import com.code.android_layout.R

data class AlignBodyItems(val drawable: Int, val text: Int)

val alignBodyItems = listOf(
    AlignBodyItems(R.drawable.abi_inversion, R.string.abi_inversion),
    AlignBodyItems(R.drawable.stretching, R.string.stretching),
    AlignBodyItems(R.drawable.hiit, R.string.HIIT),
    AlignBodyItems(R.drawable.tabata, R.string.Tabata),
    AlignBodyItems(R.drawable.yog, R.string.yog),
    AlignBodyItems(R.drawable.inversion, R.string.abi_inversion)
)