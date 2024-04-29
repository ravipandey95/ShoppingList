package com.example.shoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items") // Entity is nothing but a Table in the DataBase
data class ShoppingItem (
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_amount")
    var amount: Int
) {
    @PrimaryKey(autoGenerate = true) // Room will generate the id we don't have to set them up manually
    var Id: Int? = null
}