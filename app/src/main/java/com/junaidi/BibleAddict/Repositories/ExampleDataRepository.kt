package com.junaidi.BibleAddict.Repositories

import com.junaidi.BibleAddict.ApiCallsInterface
import com.junaidi.BibleAddict.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ExampleDataRepository {
    private val api: ApiCallsInterface by lazy {
        RetrofitClient.getClient().create(ApiCallsInterface::class.java)
    }

    /**
     * Fetches a post by ID from the API.
     *
     * @param postId The ID of the post to fetch.
     * @return The response body as a string or an error message.
     */
    suspend fun fetchPostById(postId: Int): String {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getPostsByID(postId).execute()
                response.body()?.toString() ?: "No Response"
            } catch (e: Exception) {
                "Error: ${e.message}"
            }
        }
    }
}