package com.example.quizapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.domain.QuestionModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window: Window = this@MainActivity.window
        window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.grey)

        binding.apply {
            menu.setItemSelected(R.id.home)
            menu.setOnItemSelectedListener {
                if (it == R.id.board) {
                    startActivity(Intent(this@MainActivity, LeaderActivity::class.java))
                }
            }

            singleBtn.setOnClickListener {
                val intent = Intent(this@MainActivity, QuestionActivity::class.java)
                intent.putParcelableArrayListExtra("list", ArrayList(questionList()))
                startActivity(intent)
            }
        }
    }

    //Sample Questions
    private fun questionList(): MutableList<QuestionModel> {
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1, "Which planet is the largest planet in the solar system?",
                "Earth", "Mars", "Neptune", "Jupiter", "d", 5, "q_1", null
            )
        )
        question.add(
            QuestionModel(
                2, "Which country is the largest country in the world by land area?",
                "Russia", "Canada", "China", "United State", "a", 5, "q_2", null
            )
        )
        question.add(
            QuestionModel(
                3, "Which of the following substances is used as an anti cancer medication in the medical world?",
                "Cheese", "Lemon juice", "Cannabis", "Paspalum", "c", 5, "q_3", null
            )
        )
        question.add(
            QuestionModel(
                4, "Which moon in the earth's solar system has n atmosphere?",
                "Luna (Moon)", "Pobos (Mars's moon)", "Venus moon", "None of the above", "d", 5, "q_4", null
            )
        )
        question.add(
            QuestionModel(
                5, "Which of the following symbols represents the element with the atomic number 6?",
                "O", "H", "C", "N", "c", 5, "q_5", null
            )
        )
        question.add(
            QuestionModel(
                6, "Who is credited with inventing theater as we know it today?",
                "Shakespeare", "Arthur Miller", "Ashkouri", "Ancient Greeks", "d", 5, "q_6", null
            )
        )
        question.add(
            QuestionModel(
                7, "Which ocean is the largest ocean in the world?",
                "Pacific ocean", "Atlantic ocean", "Indian ocean", "Arctic ocean", "a", 5, "q_7", null
            )
        )
        question.add(
            QuestionModel(
                8, "Which religions are among the most practiced religions in the world?",
                "Islan, Christianity, Judaism", "Buddhism, Hinduism, Sikhism", "Zoroastrianism, Brahmanism, Yazdanism", "Taoism, Shintoism, Confucianism", "a", 5, "q_8", null
            )
        )
        question.add(
            QuestionModel(
                9, "In which continent are the most independent countries located?",
                "Asia", "Europe", "Africa", "America", "c", 5, "q_9", null
            )
        )
        question.add(
            QuestionModel(
                10, "Which ocean has the greatest average depth ?",
                "Pacific ocean", "Atlantic ocean", "Indian ocean", "Southern ocean", "d", 5, "q_10", null
            )
        )
        return question
    }
}