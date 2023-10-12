package com.example.team.product

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.data.annotation.CreatedDate
import org.springframework.web.bind.annotation.GetMapping

data class ProductListResponse(
    val item: List<ProductResponse>
)
data class formattedDate(
    val createdDate: String
)
data class ProductResponse(
    val version: String?,
    val logo: String?,
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
// 베스트 셀러 http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbrlathgus5411950001&QueryType=Bestseller&MaxResults=100&start=1&SearchTarget=Book&output=xml&Version=20131101
@FeignClient(name = "aladdin", url = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbrlathgus5411950001&QueryType=Bestseller&MaxResults=10&start=1&SearchTarget=Book&output=js&Version=20131101")
interface ProductClient {

    @GetMapping
    fun getProduct(): ProductListResponse

}
//@FeignClient(name = "aladin-service") // 서비스의 이름을 지정
//interface ProductClient {
//    @GetMapping("/ttb/api/ItemList.aspx") // 실제 서비스의 엔드포인트 지정
//    fun getProduct(@RequestParam("ttbkey") ttbkey: String,
//                   @RequestParam("QueryType") queryType: String,
//                   @RequestParam("MaxResults") maxResults: Int,
//                   @RequestParam("start") start: Int,
//                   @RequestParam("SearchTarget") searchTarget: String,
//                   @RequestParam("output") output: String,
//                   @RequestParam("Version") version: String): List<ProductResponse>
//
//}