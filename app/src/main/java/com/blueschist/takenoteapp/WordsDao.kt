package com.blueschist.takenoteapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordsDao {
    @Query("SELECT * from word_table ORDER BY words ASC")
    fun getAlphabetizedWords(): LiveData<List<Words>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(words: Words)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}