package com.example.team.aladin

import com.example.team.aladin.Best.default
import jakarta.annotation.PostConstruct
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.context.annotation.Configuration
//1
object Best : IntIdTable("best") {
    //    val id = integer("id").autoIncrement()
    val createdDate  = varchar("createdDate", 20)
    val version = varchar("version", 50).default("")
    val logo = varchar("logo", 255).default("")
    val title = varchar("title", 255)
    val author = varchar("author", 255)
    val pubDate = varchar("pubDate", 10)
    val description = varchar("description", 500)
    val isbn = varchar("isbn", 13)
    val isbn13 = varchar("isbn13", 13)
    val itemId = integer("itemId")
    val priceSales = integer("priceSales")
    val priceStandard = integer("priceStandard")
    val mallType = varchar("mallType", 50)
    val stockStatus = varchar("stockStatus", 50)
    val mileage = integer("mileage")
    val cover = varchar("cover", 255)
    val categoryId = integer("categoryId")
    val categoryName = varchar("categoryName", 255)
    val publisher = varchar("publisher",255)
//    override val primaryKey = PrimaryKey(id, name = "pk_Best_id")
}
//2
object UniquePublisher: IntIdTable("publisher"){
//    val id = integer("id").autoIncrement()
    val publisher = varchar("publisher", 255)
//    override val primaryKey = PrimaryKey(id, name = "pk_publisher_id")
}
//3
object BookByPublisher : IntIdTable("book"){
    val createdDate  = varchar("createdDate", 20)
    val publisher = varchar("publisher",32)
    val version = varchar("version", 64).default("")
    val logo = varchar("logo", 255).default("")
    val title = varchar("title", 255)
    val link = varchar("link", 512)
    val author = varchar("author", 512)
    val pubDate = varchar("pubDate", 10)
    val description = varchar("description", 512)
    val isbn = varchar("isbn", 13)
    val isbn13 = varchar("isbn13", 13)
    val itemId = integer("itemId")
    val priceSales = integer("priceSales")
    val priceStandard = integer("priceStandard")
    val mallType = varchar("mallType", 50)
    val stockStatus = varchar("stockStatus", 20)
    val mileage = integer("mileage")
    val cover = varchar("cover", 512)
    val categoryId = integer("categoryId")
    val categoryName = varchar("categoryName", 255)
    val salesPoint = integer("salesPoint")
    val adult = bool("adult")
    val fixedPrice = integer("fixedPrice")
    val customerReviewRank = integer("customerReviewRank")

}



// sql-create (X)
@Configuration
// 생성자를 통해 database 객체를 주입 받음
class BestTableSetup(private val database: Database) {
    // migrate(이주하다): 코드 -> DB
    // 의존성 객체 생성 및 주입이 완료된 후에 실행할 코드를 작성
    // 스프링 환경구성이 끝난 후에 실행
    @PostConstruct
//    데이터베이스 스키마 마이그레이션은 데이터베이스 테이블과 열(Column)을 생성/업데이트
    fun migrateSchema() {
        transaction(database) {
            SchemaUtils.createMissingTablesAndColumns(Best)
        }
    }
}
@Configuration
class UniquePublisherTableSetup(private val database: Database) {
    @PostConstruct
    fun migrateSchema() {
        transaction(database) {
            SchemaUtils.createMissingTablesAndColumns(UniquePublisher)
        }
    }
}

@Configuration
class BookByPublisherTableSetup(private val database: Database) {
    @PostConstruct
    fun migrateSchema() {
        transaction(database) {
            SchemaUtils.createMissingTablesAndColumns(BookByPublisher)
        }
    }
}