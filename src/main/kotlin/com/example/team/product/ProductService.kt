package com.example.team.product

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class ProductService(private val productClient: ProductClient) {
    private val mapper = jacksonObjectMapper()
    @Scheduled(fixedRate = 1000 * 60 * 60 *12 )
    fun fetchGetProduct() {
        val currentTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm")
        val formattedDate = currentTime.format(formatter)
        println(formattedDate)
        println("--called by schedule: ${formattedDate}--")

        // 리스트(items)의 item
        // `item`은 API 응답의 구조, 반환하는 JSON 객체의 키 이름(변경X)
        val items = productClient.getProduct().item
        println(items)
        for(product in items) {
            val productJson = mapper.writeValueAsString(product)
            saveProduct(product, formattedDate)
            println("저장")
            println(productJson)

        }

    }

    //table:data
    fun saveProduct(product: ProductResponse, formattedDate: String) {
        transaction {
            Product.insert {
                it[createdDate] = formattedDate
//                it[version] = product.version
//                it[logo] = product.logo
                it[title] = product.title
                it[author] = product.author
                it[pubDate] = product.pubDate
                it[description] = product.description
                it[isbn] = product.isbn
                it[isbn13] = product.isbn13
                it[itemId] = product.itemId
                it[priceSales] = product.priceSales
                it[priceStandard] = product.priceStandard
                it[mallType] = product.mallType
                it[stockStatus] = product.stockStatus
                it[mileage] = product.mileage
                it[cover] = product.cover
                it[categoryId] = product.categoryId
                it[categoryName] = product.categoryName
                it[publisher]=product.publisher
            }

        }

    }


}