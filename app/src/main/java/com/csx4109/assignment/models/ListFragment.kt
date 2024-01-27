package com.csx4109.assignment.models

import GameAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.R


class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView = view.findViewById(R.id.rvList)
        setupRecyclerView()
        return view
    }

    private fun setupRecyclerView() {
        // Assuming userGames is a list of Game objects
        val userGames: List<Game> = LocalVariables.games
        val adapter = GameAdapter(userGames)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }




}

