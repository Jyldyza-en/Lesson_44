package kg.tutorialapp.lesson_44

object Data {

    private val items = listOf<Item>(
        Item(1, "Java", R.drawable.ic_baseline_anchor_24),
        Item(2, "Kotlin", R.drawable.ic_baseline_cloud_circle_24),
        Item(3, "Dart", R.drawable.ic_baseline_share_24)
    )

    val itemDetails = listOf<ItemDetails>(
        ItemDetails(1,"Java", R.drawable.ic_baseline_anchor_24, "Sun Microsystems", "Строго типизированный объектно-ориентированный язык программирования общего назначения"),
        ItemDetails(2,"Kotlin", R.drawable.ic_baseline_cloud_circle_24, "JetBrains", "статически типизированный, объектно-ориентированный язык программирования"),
        ItemDetails(3,"Dart", R.drawable.ic_baseline_anchor_24, "Google", "Язык программирования, позиционируется в качестве замены/альтернативы JavaScript. ")
    )

    fun getLongListOfItems(): MutableList<Any>{
        val list = mutableListOf<Any>()
        for (i in 0..100){
            list.addAll(items)
            if (i % 3 == 0)
                list.add("https://dart.dev/tutorials")
        }
        return  list
    }
}