package com.sufiyan.futursity

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("top_courses")
    fun getCourse(): Call<List<CourseModel>>

    @GET("categories")
    fun getCategory(): Call<List<MainModel>>
}