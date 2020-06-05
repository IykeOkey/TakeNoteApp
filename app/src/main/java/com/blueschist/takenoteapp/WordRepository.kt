package com.blueschist.takenoteapp

import androidx.lifecycle.LiveData

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO

class WordRepository(private val wordsDao: WordsDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<Words>> = wordsDao.getAlphabetizedWords()

    suspend fun insert(words: Words) {
        wordsDao.insert(words)
    }
}