package com.example.kotlincoroutinesexample.service

//import com.example.kotlincoroutinesexample.model.CryptoModel
import com.example.kotlincoroutinesexample.model.TodoModel
//import com.example.kotlincoroutinesexample.model.TodoModel
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface TodoApi {
//
    @GET("13f44462")
    suspend fun getData() : Response<List<TodoModel>>
//@GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
//suspend fun getData(): Response<List<CryptoModel>>

}