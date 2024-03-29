package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.csx4109.assignment.databinding.ActivityAssignment2Binding
import com.csx4109.assignment.models.GridFragment
import com.csx4109.assignment.models.ListFragment

/**
 * Page Name: Game List
 *
 * -- Description --
 * Create an app that can show a list of games from `LocalVariable.games`
 * There should be 2 fragments for each navigation buttom
 * - RecyclerView - LinearLayout
 * - RecyclerView - GridLayout
 *
 * NavigationButtom menu should have 2 items
 * - menuItem with id `item_list` which should show the first fragment
 * - menuItem with id `item_grid` which should show the second fragment
 *
 * For the first fragment, you should use LinearLayout to show the list of games
 * - The recyclerView should have id of `rvList`
 * Each item should show the following information with the following id
 * - imageView named `ivGame` that load image from internet using coil library
 * - textView named `tvGameName` that show the name of the game
 * - textView named `tvGenre` that show the genre of the game
 * - textView named `tvGameScore` that show the score rating of the game
 * - textView named `tvGameDescription` that show the description of the game
 *
 * For the second fragment, you should use GridLayout to show the list of games with 2 item per row
 * - The recyclerView should have id of `rvGrid`
 * Each item should show the following information with the following id
 * - imageView named `ivGame` that load image from internet using coil library
 * - textView named `tvGameScore` that show the score rating of the game
 *
 * Cases
 * - When open an application, the first fragment should be shown as LinearLayout
 * - When click the second navigation button, the second fragment should be shown as GridLayout
 * - Each item in both view should be displayed correctly in order
 *
 * ***You can check video example in MS team***
 */
class Assignment2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityAssignment2Binding

    private val listFragment = ListFragment()
    private val gridFragment = GridFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssignment2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_list -> {
                    loadListFragment()
                    true
                }
                R.id.item_grid -> {
                    loadGridFragment()
                    true
                }
                else -> false
            }
        }

        // Load ListFragment initially
        loadListFragment()
    }

    private fun loadListFragment() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, listFragment, ListFragment::class.java.simpleName)
        transaction.commit()
    }

    private fun loadGridFragment() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, gridFragment, GridFragment::class.java.simpleName)
        transaction.commit()
    }
}