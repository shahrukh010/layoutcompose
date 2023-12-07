package com.code.android_layout.components

import AlignBodyItems
import FavoriteCollection
import alignBodyItems
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.code.android_layout.R
import com.code.android_layout.ui.theme.AndroidlayoutTheme
import favoriteCollection


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(value = "", onValueChange = {}, leadingIcon = {
        Icon(imageVector = Icons.Default.Search, contentDescription = null)
    }, colors = TextFieldDefaults.outlinedTextFieldColors(

        unfocusedBorderColor = MaterialTheme.colorScheme.surface,
        focusedBorderColor = MaterialTheme.colorScheme.surface
    ), placeholder = {
        Text(stringResource(R.string.placeholder_search))
    }, modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 56.dp)
    )
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int, @StringRes text: Int, modifier: Modifier = Modifier
) {

    Column(
        modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            stringResource(text),
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                .padding(start = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )

    }
}


@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int, @StringRes text: Int, modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
//        shadowElevation = 4.dp, // Adjust the elevation as needed
        color = Color.hsl(0.00F, 0.00F, 0.93F),
        modifier = Modifier
            .width(255.dp)
            .heightIn(100.dp),

        ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp),
        ) {

            Image(
                painter = painterResource(drawable), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp),
            )

            Text(
                stringResource(text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

    }
}

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier, alignYourBodyData: List<AlignBodyItems>
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)

    ) {

        items(alignYourBodyData.size) { index ->
            AlignYourBodyElement(
                drawable = alignYourBodyData[index].drawable, text = alignYourBodyData[index].text
            )
        }
    }
}

@Composable
fun FavoriteCollectionGrid(
    modifier: Modifier = Modifier, favoriteCollection: List<FavoriteCollection>

) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.height(168.dp)
    ) {

        items(favoriteCollection) { item ->
            FavoriteCollectionCard(item.drawable, item.text);
        }
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int, modifier: Modifier = Modifier, content: @Composable () -> Unit
) {

    Column(modifier) {
        Text(
            stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content();
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Column(
        modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.title) {
            AlignYourBodyRow(alignYourBodyData = alignBodyItems)
        }
        HomeSection(title = R.string.favorite) {
            FavoriteCollectionGrid(favoriteCollection = favoriteCollection)
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
private fun BottomNavigation(modifier: Modifier = Modifier) {

    NavigationBar(
        contentColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = Modifier
    ) {

        NavigationBarItem(
            icon = {

                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                )
            },
            label = {
                Text(
                    text = stringResource(
                        R.string.bottom_navigation_home
                    )
                )
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(modifier = Modifier.size(150.dp),
            icon = {
                Icon(
                    imageVector = Icons.Default.Person, contentDescription = null,
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.bottom_navigation_profile),
                )
            },
            selected = true, onClick = {}
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {

    AndroidlayoutTheme {
        Scaffold(
            bottomBar = { BottomNavigation() }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenContentPreview() {

    AndroidlayoutTheme {
//        HomeScreen()
//        BottomNavigation()
        App();
    }
}

@Preview(showBackground = true)
@Composable
fun HomeSectionPreview() {
    AndroidlayoutTheme {
        HomeSection(R.string.favorite) {

//            AlignYourBodyRow(alignYourBodyData = alignBodyItems)
//            FavoriteCollectionGrid(favoriteCollection = favoriteCollection)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {

    AndroidlayoutTheme {
//        FavoriteCollectionCard(drawable = R.drawable.leves1, text = R.string.LEVES)
//        AlignYourBodyRow(alignYourBodyData = alignBodyItems)

//        FavoriteCollectionGrid(favoriteCollection = favoriteCollection)
    }
}
