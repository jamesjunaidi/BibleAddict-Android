package com.junaidi.BibleAddict

import com.junaidi.BibleAddict.Models.PostExampleObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiCallsInterface {
    @GET("posts")
    fun getPosts(): Call<List<PostExampleObject>>

    @GET("posts/{id}")
    fun getPostsByID(@Path("id") postId: Int): Call<PostExampleObject>

    @POST("posts")
    fun postObject(@Body postobject: PostExampleObject): Call<PostExampleObject>
}