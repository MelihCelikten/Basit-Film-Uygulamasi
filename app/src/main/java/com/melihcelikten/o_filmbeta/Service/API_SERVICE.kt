package com.melihcelikten.o_film_beta.Service

import com.google.gson.annotations.SerializedName
import com.melihcelikten.o_film_beta.Model.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query







interface API_SERVICE {





    @GET("3/movie/popular?api_key=3d986f31e4ec7abc63e77e955cb50b5f")
    suspend fun Popular_Example_Sorgu(@Query("language") language: String,
                                       @Query("page") page: Int,
    ): Popular_Example




    @GET("3/movie/upcoming?api_key=3d986f31e4ec7abc63e77e955cb50b5f")
    suspend fun Upcoming_Example_Sorgu(@Query("language") language: String,
                                          @Query("page") page: Int,
    ): Upcoming_Example



    @GET("3/movie/now_playing?api_key=3d986f31e4ec7abc63e77e955cb50b5f")
    suspend fun Now_Playing_Example_Sorgu(@Query("language") language: String,
                                        @Query("page") page: Int,
    ): Now_Playing_Example





    @GET("3/movie/top_rated?api_key=3d986f31e4ec7abc63e77e955cb50b5f")
    suspend fun Top_Rated_Example_Sorgu(@Query("language") language: String,
                                        @Query("page") page: Int,
   ): Top_Rated_Example






    companion object {

        private const val BASE_URL = "https://api.themoviedb.org/"
        fun create(): API_SERVICE {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(API_SERVICE::class.java)
        }
    }












}