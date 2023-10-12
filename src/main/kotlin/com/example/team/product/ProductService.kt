package com.example.team.product

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.SubmissionPublisher

@Service
class ProductService(private val productClient: ProductClient) {
    private val mapper = jacksonObjectMapper()

    @Transactional
    @Scheduled(fixedRate = 1000 * 60 * 60 * 12)
    fun fetchGetProduct() {
        try {
            transaction {
                // 트랜잭션 내에서 작업 실행
                val currentTime = LocalDateTime.now()
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm")
                val formattedDate = currentTime.format(formatter)
                println(formattedDate)
                println("--called by schedule: ${formattedDate}--")

                // 리스트(items)의 item
                // `item`은 API 응답의 구조, 반환하는 JSON 객체의 키 이름(변경X)
                val items = productClient.getProduct().item
                println(items)

                // 기존 데이터 삭제
                Product.deleteAll()

                for (product in items) {
                    val productJson = mapper.writeValueAsString(product)
                    saveProduct(product, formattedDate)
//                    println("저장")

                    val pub = product.publisher
                    savePublisher(pub)
//                    println("출판사 저장")
//                    println(pub)
                }
            }
        } finally {
            // 트랜잭션 종료
            transaction { commit() }
        }


    }

    // 출판사만
    fun savePublisher(pub: String) {
        transaction {
            val existingPublisher = UniquePublisher.select { UniquePublisher.publisher eq pub }.firstOrNull()

            if (existingPublisher == null) {
                UniquePublisher.insert {
                    //db저장
                    it[publisher] = pub
                }
            }
        }
    }

        //전체 데이터
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
                    it[publisher] = product.publisher
                }

            }

        }

}