package com.example.team.Aladin

import org.springframework.stereotype.Service

import org.jetbrains.exposed.sql.*




@Service
class AladinService(private val productClient: AladinClient) {
    fun fetchGetAladinBook() {
       val result = productClient.getAladinBook()
        println(result)


    }

//    fun fetchBooksFromAladin(): Mono<AladinApiResponse> {
//        val aladinApiUrl = "http://www.aladin.co.kr/ttb/api/ItemSearch.aspx?ttbkey=ttbrlathgus5411950001&QueryType=Publisher&Query=문학동네&MaxResults=10&start=0&SearchTarget=Book&output=js&Version=20131101"
//
//        return webClient.get()
//            .uri(aladinApiUrl)
//            .retrieve()
//            .bodyToMono(AladinApiResponse::class.java)
//    }
}