import com.code.android_layout.R

data class AlignBodyItems(val drawable: Int, val text: Int)

val alignBodyItems = listOf(
    AlignBodyItems(R.drawable.inversion, R.string.abi_inversion),
    AlignBodyItems(R.drawable.stretching, R.string.stretching),
    AlignBodyItems(R.drawable.hiit, R.string.HIIT),
    AlignBodyItems(R.drawable.yog, R.string.yog),
)


data class FavoriteCollection(var drawable: Int, val text: Int)

val favoriteCollection = listOf(
    FavoriteCollection(R.drawable.museum, R.string.Museum),
    FavoriteCollection(R.drawable.hiit, R.string.HIIT),
    FavoriteCollection(R.drawable.stretching, R.string.stretching),
    FavoriteCollection(R.drawable.tabata, R.string.Tabata),
)