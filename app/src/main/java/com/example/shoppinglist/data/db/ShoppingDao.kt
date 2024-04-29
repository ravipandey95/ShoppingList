package com.example.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shoppinglist.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // insert or update the the existing item
    fun upsert (item : ShoppingItem)

    @Delete
    fun delete (item : ShoppingItem) // delete the item

    @Query( "SELECT * FROM shopping_items" ) // query to get all items from table
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>

}