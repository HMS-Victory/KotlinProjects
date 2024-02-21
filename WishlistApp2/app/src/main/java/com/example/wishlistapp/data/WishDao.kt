package com.example.wishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

//allows you to make queries to the database
@Dao
abstract class WishDao {
    //automatically adds item that is passed in to the db
    @Insert(onConflict=OnConflictStrategy.IGNORE)
    abstract suspend fun addAWish(wishEntity: Wish)

    // Loads all wishes from the wish table
    @Query("SELECT * FROM 'wish-table'")
    abstract fun getAllWishes(): Flow<List<Wish>>
    //automatically updates the db with passed in value
    @Update
    abstract suspend fun updateaWish(wishEntity: Wish)
    //automatically deletes item that is passed in
    @Delete
    abstract suspend fun deleteAWish(wishEntity: Wish)

    @Query("SELECT * FROM 'wish-table' WHERE id=:id")
    abstract fun getAWishById(id:Long):Flow<Wish>
}