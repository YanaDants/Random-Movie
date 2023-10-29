package com.example.randommovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var films: Array<String>
    val r = Random()
    var seensfilm = emptyArray<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        films = resources.getStringArray(R.array.movies)
        for(i in films.indices){
            seensfilm += 0
        }
    }

    fun onNextClick(view: android.view.View) {
        val tvTitle = findViewById<TextView>(R.id.title)

        for (i in films.indices){
            if (i == films.size-1){
                Toast.makeText(applicationContext, "It is all. Please, reset", Toast.LENGTH_SHORT).show()
            }
            val randint = r.nextInt(films.size)
            if (seensfilm[randint] == 0){
                tvTitle.text= films[randint]
                seensfilm[randint] = 1
                break
            }
        }

    }

    fun onClearClick(view: android.view.View) {
        for(i in films.indices){
            seensfilm[i] = 0
        }
    }
}
