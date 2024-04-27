package com.example.shoppinglist.ui.shoppinglist

import com.example.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListner {
    fun onAddButtonClicked(item : ShoppingItem)
}