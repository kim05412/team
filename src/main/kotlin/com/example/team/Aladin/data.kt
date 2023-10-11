package com.example.team.Aladin

data class AladinApiResponse(
    val item: List<Book>
)
data class Book(
    val title: String,
    val author: String,
    val pubDate: String,
    val description: String,
    val isbn: String,
    val isbn13: String,
    val itemId: Int,
    val priceSales: Int,
    val priceStandard: Int,
    val mallType: String,
    val stockStatus: String,
    val mileage: Int,
    val cover: String,
    val categoryId: Int,
    val categoryName: String,
    val publisher: String
)

//object Books : IntIdTable() {
//    val version = varchar("version", 50)
//    val logo = varchar("logo", 255)
//    val title = varchar("title", 255)
//    val author = varchar("author", 255)
//    val pubDate = varchar("pubDate", 10)  // 이 데이터 형식에 따라 수정
//    val description = varchar("description", 500)  // 이 데이터 형식에 따라 수정
//    val isbn = varchar("isbn", 13)  // 이 데이터 형식에 따라 수정
//    val isbn13 = varchar("isbn13", 13)  // 이 데이터 형식에 따라 수정
//    val itemId = integer("itemId")
//    val priceSales = integer("priceSales")
//    val priceStandard = integer("priceStandard")
//    val mallType = varchar("mallType", 50)  // 이 데이터 형식에 따라 수정
//    val stockStatus = varchar("stockStatus", 50)  // 이 데이터 형식에 따라 수정
//    val mileage = integer("mileage")
//    val cover = varchar("cover", 255)  // 이 데이터 형식에 따라 수정
//    val categoryId = integer("categoryId")
//    val categoryName = varchar("categoryName", 255)  // 이 데이터 형식에 따라 수정
//    val publisher = varchar("publisher", 255)  // 이 데이터 형식에 따라 수정
//}

