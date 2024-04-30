package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.other.ShoppingItemAdapter
import com.example.shoppinglist.ui.shoppinglist.AddDialogListner
import com.example.shoppinglist.ui.shoppinglist.AddShoppingItemDialog
import com.example.shoppinglist.ui.shoppinglist.ShoppingViewModel
import com.example.shoppinglist.ui.shoppinglist.ShoppingViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: ShoppingViewModelFactory by instance()

    lateinit var viewModel: ShoppingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main )

        viewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(), viewModel)
        findViewById<RecyclerView>(R.id.rvShoppingItems).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.rvShoppingItems).adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        } )


        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            AddShoppingItemDialog(this,
                object : AddDialogListner {
                    override fun onAddButtonClicked(item: ShoppingItem) {
                        viewModel.upsert(item)
                    }
                }).show()
        }
    }
}