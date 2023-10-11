package com.example.team.NaverOpenApi//package com.example.team.database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
//import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import okhttp3.OkHttpClient
import okhttp3.Request
import com.google.gson.JsonParser
import org.jetbrains.exposed.dao.id.IntIdTable


// MySQL 데이터베이스 연결 설정
//private val database = Database.connect(
//    url = "jdbc:mysql://localhost:3306/books?rewriteBatchedStatements=true",
//    driver = "com.mysql.cj.jdbc.Driver",
//    user = "root",
//    password = "password1234!"
//)

// 데이터 모델 정의
object DataEntity : IntIdTable() {
    val data = text("data")
}
// DTO
data class Data(val id: Int, val data: String)

fun main() {
    runBlocking {
        val dataUrl = "http://www.aladin.co.kr/ttb/api/ItemList.aspx" // 데이터를 가져올 서버의 URL로 변경
        val jsonData = fetchDataFromServer(dataUrl)
        if (jsonData != null) {
            val data = parseJsonData(jsonData)
            saveDataToDatabase(data)
        }
    }
}

// 서버에서 데이터 가져오는 함수
suspend fun fetchDataFromServer(url: String): String? {
    val client = OkHttpClient()
    val request = Request.Builder().url(url).build()
    val response = client.newCall(request).execute()
    return if (response.isSuccessful) {
        response.body?.string()
    } else {
        println("Failed to fetch data from the server.")
        null
    }
}

// JSON 데이터 파싱 함수
// DTO
fun parseJsonData(jsonData: String): Data {
    val jsonObject = JsonParser.parseString(jsonData).asJsonObject
    val id = jsonObject["id"].asInt
    val data = jsonObject["data"].asString
    return Data(id, data)
}
// 데이터를 MySQL에 저장하는 함수
fun saveDataToDatabase(data: Data) {
    transaction {
        SchemaUtils.create(DataEntity)
        DataEntity.insert {
            it[DataEntity.data] = data.data
        }
    }
}
