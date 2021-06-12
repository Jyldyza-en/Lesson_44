package kg.tutorialapp.lesson_44

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class AddViewHolder(itemView: View) :
    BaseViewHolder<Any>(itemView) {

    private var tvUrl: TextView = itemView.findViewById(R.id.tv_url)


    override fun bind(item: Any){

        item as String

        tvUrl.text = item

    }

    companion object{

        fun create(parent: ViewGroup, listener: MyAdapter.OnClickListener): BaseViewHolder<Any> {

            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_add_view_holder, parent, false)

            return AddViewHolder(view).apply {
                itemView.setOnClickListener {
                    listener.onAdClick(bindingAdapterPosition)
                }
            }

        }
    }
}
