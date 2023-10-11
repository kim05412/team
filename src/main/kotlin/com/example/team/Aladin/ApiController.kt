//package com.example.team.Aladin
//
//
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//import com.google.gson.Gson
//import okhttp3.OkHttpClient
//import okhttp3.Request
//import org.jetbrains.exposed.sql.*
//import org.jetbrains.exposed.sql.transactions.transaction
//
//// JSON 문자열을 AladinApiResponse 객체로 파싱하는 함수
//fun parseResponse(responseBody: String): AladinApiResponse {
//    return Gson().fromJson(responseBody, AladinApiResponse::class.java)
//}
//
////val url = "http://www.aladin.co.kr/ttb/api/ItemSearch.aspx?ttbkey=ttbrlathgus5411950001&QueryType=Publisher&Query=문학동네&MaxResults=10&start=0&SearchTarget=Book&output=js&Version=20131101"
//
//suspend fun fetchDataFromServer(url: String):AladinApiResponse? {
//    return withContext(Dispatchers.IO) {
//        val client = OkHttpClient()
//        val request = Request.Builder().url(url).build()
//        val response = client.newCall(request).execute()
//        if (response.isSuccessful) {
//            val aladinApiResponse = response.body?.string()
//            if (aladinApiResponse != null) {
//                val parsedData = parseResponse(aladinApiResponse)
//                transaction {
//                    try {
//                        SchemaUtils.create(Books)
//
//                        // Insert each book into the database
//                        for (bookData in parsedData.item) {
//                            Books.insert {
//                                it[title] = bookData.title
//                                it[author] = bookData.author
//                                it[pubDate] = bookData.pubDate
//                                it[description] = bookData.description
//                                it[isbn] = bookData.isbn
//                                it[isbn13] = bookData.isbn13
//                                it[itemId] = bookData.itemId
//                                it[priceSales] = bookData.priceSales
//                                it[priceStandard] = bookData.priceStandard
//                                it[mallType] = bookData.mallType
//                                it[stockStatus] = bookData.stockStatus
//                                it[mileage] = bookData.mileage
//                                it[cover] = bookData.cover
//                                it[categoryId] = bookData.categoryId
//                                it[categoryName] = bookData.categoryName
//                                it[publisher] = bookData.publisher
//                            }
//                        }
//                        commit()
//                    } catch (e: Exception) {
//                        rollback()
//                        println("Error while inserting data into the database: ${e.message}")
//                    }
//                }
//            } else {
//                println("Failed to parse the response body.")
//                null
//            }
//        } else {
//            println("Failed to fetch data from the server.")
//            null
//        }
//    }
//}