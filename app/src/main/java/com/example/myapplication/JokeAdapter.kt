package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class JokeAdapter(private val jokeList: List<Joke>) : RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    class JokeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val questionTextView: TextView = view.findViewById(R.id.joke_question)
        val answerTextView: TextView = view.findViewById(R.id.joke_answer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.joke_item, parent, false)
        return JokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke = jokeList[position]
        holder.questionTextView.text = joke.question
        holder.answerTextView.text = joke.answer
    }

    override fun getItemCount(): Int {
        return jokeList.size
    }
}