package com.example.recycklerwithclicks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_show.view.*

class showAdapter:RecyclerView.Adapter<showAdapter.showVh>() {
    private var data = arrayListOf<Dataclass>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): showVh {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_show,parent,false)
        return showVh(view)
    }

    override fun getItemCount()=data.size

    override fun onBindViewHolder(holder: showVh, position: Int) {
        holder.bind(data[position])
    }

    fun update (data:ArrayList<Dataclass>){
       this.data=data
        notifyDataSetChanged()
    }

    fun remove(poz:Int){
        if (poz > -1 && data.size > poz){
            data.removeAt(poz)
            notifyDataSetChanged()
        }
    }

    fun add(item: Dataclass){
          data.add(item)
          notifyItemInserted(1)

      }

    class showVh(view:View):RecyclerView.ViewHolder(view){
        fun bind(item:Dataclass){
            itemView.text1.text=item.tv
            itemView.text2.text=item.tv1
            itemView.image.setBackgroundResource(item.imagesh)
        }
    }
}