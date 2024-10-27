package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var jokeAdapter: JokeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)

        val jokes = listOf(
            Joke("Общие", "What does Santa suffer from if he gets stuck in a chimney?", "Claustrophobia!"),
            Joke("Общие", "Why did the scarecrow win an award?", "Because he was outstanding in his field!"),
            Joke("Общие", "Why don’t skeletons fight each other?", "They don’t have the guts."),
            Joke("Общие", "What do you call fake spaghetti?", "An impasta!"),
            Joke("Общие", "Why did the bicycle fall over?", "Because it was two-tired!"),
            Joke("Общие", "What do you call cheese that isn't yours?", "Nacho cheese!"),
            Joke("Общие", "Why can't you give Elsa a balloon?", "Because she will let it go!")
        )

        jokeAdapter = JokeAdapter(jokes)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = jokeAdapter
    }
}