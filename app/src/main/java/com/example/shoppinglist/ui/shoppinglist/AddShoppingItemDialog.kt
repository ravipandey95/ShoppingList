package com.example.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingItem

class AddShoppingItemDialog(context:Context, private var addDialogListener: AddDialogListner):AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialogue_add_shopping_item)

        findViewById<TextView>(R.id.tvAdd)?.setOnClickListener {
            val name = findViewById<EditText>(R.id.etName)?.text.toString()
            val amount = findViewById<EditText>(R.id.etAmount)?.text.toString()

            if(name.isEmpty() or amount.isEmpty()) {
                Toast.makeText( context,"Please Enter All Information", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        findViewById<TextView>(R.id.tvCancel)?.setOnClickListener {
            cancel()
        }

    }
}