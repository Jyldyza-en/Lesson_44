package kg.tutorialapp.lesson_44

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MyViewHolder(itemView: View): BaseViewHolder<Any>(itemView) {

    val button: Button = itemView.findViewById(R.id.button)

    override fun bind(item: Any){

        item as Item
        itemView.run {

            val ivIcon = findViewById<ImageView>(R.id.iv_icon)
            val tvName = findViewById<TextView>(R.id.tv_name)

            ivIcon.setImageResource(item.icon)
            tvName.text = item.name

        }
    }

    companion object{
        fun create(parent: ViewGroup, listener: MyAdapter.OnClickListener): MyViewHolder{
            val view =LayoutInflater.from(parent.context)
                .inflate(R.layout.item_my_view_holder, parent, false)

            val holder =  MyViewHolder(view)

            holder.itemView.setOnClickListener {
                listener.onItemClick(holder.bindingAdapterPosition)
            }

            holder.button.setOnClickListener {
                listener.onButtonClick(holder.bindingAdapterPosition)
            }

            return holder
        }
    }
}