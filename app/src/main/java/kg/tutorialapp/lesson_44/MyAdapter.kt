package kg.tutorialapp.lesson_44

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.tutorialapp.lesson_44.MyAdapter.Type.ADVERTISEMENT
import kg.tutorialapp.lesson_44.MyAdapter.Type.ITEM

class MyAdapter(private val listener: OnClickListener): RecyclerView.Adapter<BaseViewHolder<Any>>() {

    private val items = arrayListOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Any> {

        Log.i(TAG, "onCreateViewHolder()")

        return when(viewType){
            ITEM -> MyViewHolder.create(parent, listener)
            else -> AddViewHolder.create(parent, listener)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Any>, position: Int) {

        Log.i(TAG, "onBindViewHolder()")
        holder.bind(item = items[position])
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun getItemViewType(position: Int): Int {
        return  when(items[position]){
            is String -> ADVERTISEMENT
            is Item -> ITEM
            else -> -1
        }
    }

    fun setNewItems(newItems: List<Any>){
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    object Type{
        const val ITEM = 0
        const val ADVERTISEMENT = 1
    }

    companion object{
        const val TAG = "Adapter"
    }

    interface OnClickListener{

        fun onItemClick(position: Int)
        fun onAdClick(position: Int)
        fun onButtonClick(position: Int)
    }
}