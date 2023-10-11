package com.example.team.Aladin

import org.jetbrains.exposed.sql.*
import org.springframework.stereotype.Service

@Service
class BookService(private val aladinService: AladinService) {

    fun fetchBooksAndSaveToDatabase() {
        val aladinApiResponse = aladinService.fetchBooksFromAladin().block() // Blocking for simplicity

        // Check if aladinApiResponse is not null and process the data
        if (aladinApiResponse != null) {
            for (book in aladinApiResponse.bookList) {
                saveBookToDatabase(book)
            }
        }
    }
}