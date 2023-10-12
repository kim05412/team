package com.example.team.product


//import org.jetbrains.exposed.sql.Database
//import org.jetbrains.exposed.sql.SchemaUtils
//import org.jetbrains.exposed.sql.Table
//import org.jetbrains.exposed.sql.javatime.datetime
//import org.jetbrains.exposed.sql.transactions.transaction
//import org.springframework.context.annotation.Configuration

import jakarta.annotation.PostConstruct
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.context.annotation.Configuration


object Product : Table("product") {
    val createdDate  = varchar("createdDate", 20)
    val version = varchar("version", 50).default("")
    val logo = varchar("logo", 255).default("")
    val title = varchar("title", 255)
    val author = varchar("author", 255)
    val pubDate = varchar("pubDate", 10)  // 이 데이터 형식에 따라 수정
    val description = varchar("description", 500)  // 이 데이터 형식에 따라 수정
    val isbn = varchar("isbn", 13)  // 이 데이터 형식에 따라 수정
    val isbn13 = varchar("isbn13", 13)  // 이 데이터 형식에 따라 수정
    val itemId = integer("itemId")
    val priceSales = integer("priceSales")
    val priceStandard = integer("priceStandard")
    val mallType = varchar("mallType", 50)  // 이 데이터 형식에 따라 수정
    val stockStatus = varchar("stockStatus", 50)  // 이 데이터 형식에 따라 수정
    val mileage = integer("mileage")
    val cover = varchar("cover", 255)  // 이 데이터 형식에 따라 수정
    val categoryId = integer("categoryId")
    val categoryName = varchar("categoryName", 255)  // 이 데이터 형식에 따라 수정
    val publisher = varchar("publisher", 255)  // 이 데이터 형식에 따라 수정
}
@Configuration
class ProductTableSetup(private val database: Database) {

    // migrate(이주하다): 코드 -> DB

    // 의존성 객체 생성 및 주입이 완료된 후에 실행할 코드를 작성
    // 스프링 환경구성이 끝난 후에 실행
    @PostConstruct
    fun migrateSchema() {
        transaction(database) {
            SchemaUtils.createMissingTablesAndColumns(Product)
        }
    }
}

//fun ResultRow.toBook() = Book(this[Books.id].value, this[Books.version], this[Books.logo], this[Books.title], this[Books.query])