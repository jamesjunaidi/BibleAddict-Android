package com.junaidi.BibleAddict

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.junaidi.BibleAddict.Models.PostExampleObject
import com.junaidi.BibleAddict.Models.Profile
import com.junaidi.BibleAddict.maincomposables.Heading
import com.junaidi.BibleAddict.maincomposables.WeeklyCheckboxes
import com.junaidi.BibleAddict.ui.theme.BibleAddictTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : ComponentActivity() {
    private val retroClient = RetrofitClient.getClient()
    private val postApi = retroClient.create(ApiCallsInterface::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BibleAddictTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LazyColumn {
                        item {
                            Heading(Profile(5, 5, "James"))
                        }

                        item {
                            WeeklyCheckboxes()
                        }

                        item {
                            Text("Notification Selector")
                        }

                        item {
                            MyButton(
                                onButtonClick = {
                                    println("Button was clicked")
                                    callApi()
                                }
                            )
                        }
                    }

                    // Greeting("Android")
                }
            }
        }
    }

    fun callApi() : PostExampleObject? {
        Log.d("Tag", "Api Button Clicked")

        var ret : PostExampleObject? = null

        GlobalScope.launch {
            try {
                // val retroFitCall = retroApi.getPosts()
                val retroFitCall = postApi.getPostsByID(2)
                val response = retroFitCall.execute()
                Log.d("Tag", "This is the result: " + response.body())
                ret = response.body()
            } catch (e: java.lang.Exception) {
                Log.e("Tag", "Error: ", e)
            }
        }


        return ret
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun MyButton(onButtonClick: () -> Unit) {
    Button(
        onClick = { onButtonClick() }
    ) {
        Text(text = "Click Me")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BibleAddictTheme {
        Greeting("Android")
    }
}


