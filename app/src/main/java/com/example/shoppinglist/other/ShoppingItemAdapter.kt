package com.example.shoppinglist.other


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter(
    var items : List<ShoppingItem>,
    private val viewmodel : ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currShoppingItem = items[position]

        holder.itemView.findViewById<TextView>(R.id.tvName).text = currShoppingItem.name
        holder.itemView.findViewById<TextView>(R.id.tvAmount).text = "${currShoppingItem.amount}"

        holder.itemView.findViewById<ImageView>(R.id.ivDelete).setOnClickListener {
            viewmodel.delete(currShoppingItem)
        }

        holder.itemView.findViewById<ImageView>(R.id.ivPlus).setOnClickListener {
            currShoppingItem.amount++
            viewmodel.upsert(currShoppingItem)
        }

        holder.itemView.findViewById<ImageView>(R.id.ivMinus).setOnClickListener {
            if (currShoppingItem.amount > 0){
                currShoppingItem.amount--
                viewmodel.upsert(currShoppingItem)
            }
        }
    }
}