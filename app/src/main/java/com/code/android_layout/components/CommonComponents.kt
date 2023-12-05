package com.code.android_layout.components

import AlignBodyItems
import alignBodyItems
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toDrawable
import com.code.android_layout.R
import com.code.android_layout.ui.theme.AndroidlayoutTheme


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
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
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
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .width(255.dp)
            .heightIn(100.dp),

        ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(255.dp)
                .padding(start = 10.dp),
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
    modifier: Modifier = Modifier,
    alignYourBodyData: List<AlignBodyItems>
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)

    ) {

        items(alignYourBodyData.size) { index ->
            AlignYourBodyElement(
                drawable = alignYourBodyData[index].drawable,
                text = alignYourBodyData[index].text
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {

    AndroidlayoutTheme {
        AlignYourBodyRow(alignYourBodyData = alignBodyItems)
    }
}
