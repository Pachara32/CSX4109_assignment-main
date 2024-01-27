package com.csx4109.assignment.models

import GameAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.R

class GridFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_grid, container, false)
        recyclerView = view.findViewById(R.id.rvGrid)
        setupRecyclerView()
        return view
    }

    private fun setupRecyclerView() {
        // Assuming userGames is a list of Game objects
        val userGames: List<Game> = LocalVariables.games
        val adapter = GameAdapter(userGames)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(context, 2)
    }
}
