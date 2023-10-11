package com.example.team.Aladin
//


//import org.simpleframework.xml.Element
//import org.simpleframework.xml.ElementList
//import org.simpleframework.xml.Root
//
//@Root(name = "object", strict = false)
//data class YourXMLResponseType(
//    @field:Element(name = "title")
//    var title: String = "",
//
//    @field:ElementList(inline = true, required = false)
//    var items: List<YourXMLItem> = mutableListOf()
//)
//
//data class YourXMLItem(
//    @field:Element(name = "title")
//    var title: String = "",
//
//    @field:Element(name = "author")
//    var author: String = "",
//
//    @field:Element(name = "pubDate")
//    var pubDate: String = "",
//
//    @field:Element(name = "description")
//    var description: String = "",
//
//    @field:Element(name = "isbn")
//    var isbn: String = "",
//
//    @field:Element(name = "isbn13")
//    var isbn13: String = "",
//
//    @field:Element(name = "priceSales")
//    var priceSales: Double = 0.0,
//
//    @field:Element(name = "priceStandard")
//    var priceStandard: Double = 0.0,
//
//    @field:Element(name = "mallType")
//    var mallType: String = "",
//
//    @field:Element(name = "stockStatus")
//    var stockStatus: String = "",
//
//    @field:Element(name = "mileage")
//    var mileage: Int = 0,
//
//    @field:Element(name = "cover")
//    var cover: String = "",
//
//    @field:Element(name = "categoryId")
//    var categoryId: Int = 0,
//
//    @field:Element(name = "categoryName")
//    var categoryName: String = "",
//
//    @field:Element(name = "publisher")
//    var publisher: String = "",
//
//    @field:Element(name = "salesPoint")
//    var salesPoint: Int = 0,
//
//    @field:Element(name = "customerReviewRank")
//    var customerReviewRank: Int = 0,
//
//    @field:Element(name = "adult")
//    var adult: Boolean = false,
//
//    @field:Element(name = "fixedPrice")
//    var fixedPrice: Boolean = false
//)