package com.example.team.Aladin

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

data class AladinResponse(
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
@FeignClient(name="aladinClient", url="http://www.aladin.co.kr/ttb/api/ItemSearch.aspx?ttbkey=ttbrlathgus5411950001&Query=문학동네&QueryType=Publisher&MaxResults=10&start=0&SearchTarget=Book&Version=20131101&output=js")
interface  AladinClient{
    @GetMapping
    fun getAladinBook() : List<AladinResponse>
}