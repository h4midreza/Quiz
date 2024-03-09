package com.example.quizapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.quizapp.R
import com.example.quizapp.adapter.LeaderAdapter
import com.example.quizapp.databinding.ActivityLeaderBinding
import com.example.quizapp.domain.UserModel

class LeaderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLeaderBinding
    private val leaderAdapter by lazy { LeaderAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window: Window = this@LeaderActivity.window
        window.statusBarColor = ContextCompat.getColor(this@LeaderActivity, R.color.grey)

        binding.apply {
            scoreTop1Txt.text = loadData()[0].score.toString()
            scoreTop2Txt.text = loadData()[1].score.toString()
            scoreTop3Txt.text = loadData()[2].score.toString()
            titleTop1Txt.text = loadData()[0].name
            titleTop2Txt.text = loadData()[2].name
            titleTop3Txt.text = loadData()[3].name

            val drawableResourceId1: Int = binding.root.resources.getIdentifier(
                loadData()[0].pic, "drawable", binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourceId1)
                .into(pic1)

            val drawableResourceId2: Int = binding.root.resources.getIdentifier(
                loadData()[1].pic, "drawable", binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourceId2)
                .into(pic2)

            val drawableResourceId3: Int = binding.root.resources.getIdentifier(
                loadData()[2].pic, "drawable", binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourceId3)
                .into(pic3)

            menu.setItemSelected(R.id.board)
            menu.setOnItemSelectedListener {
                if (it == R.id.home){
                    startActivity(Intent(this@LeaderActivity, MainActivity::class.java))
                }
            }

            var list: MutableList<UserModel> = loadData()
            list.removeAt(0)
            list.removeAt(1)
            list.removeAt(2)

            leaderAdapter.differ.submitList(list)

            leaderView.apply {
                layoutManager = LinearLayoutManager(this@LeaderActivity)
                adapter = leaderAdapter
            }
        }
    }

    //sample list
    private fun loadData(): MutableList<UserModel> {
        val users: MutableList<UserModel> = mutableListOf()
        users.add(UserModel(1, "Sophia", "person1", 4850))
        users.add(UserModel(2, "Danial", "person2", 4560))
        users.add(UserModel(3, "James", "person3", 4340))
        users.add(UserModel(4, "John Smith", "person4", 4050))
        users.add(UserModel(5, "Emily Johnson", "person5", 3890))
        users.add(UserModel(6, "David Brown", "person6", 3850))
        users.add(UserModel(7, "Sara Wilson", "person7", 3650))
        users.add(UserModel(8, "Michael Davis", "person8", 3350))
        users.add(UserModel(9, "David wood", "person9", 3050))
        users.add(UserModel(10, "Tom Winger", "person5", 2970))
        return users
    }
}