package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textGoal: TextView
    private lateinit var btnSetGoal: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textGoal = findViewById(R.id.textGoal)
        btnSetGoal = findViewById(R.id.btnSetGoal)

        btnSetGoal.setOnClickListener {
            showGoalInputDialog()
        }
    }

    private fun showGoalInputDialog() {
        val editText = EditText(this)
        editText.hint = "금액을 입력하세요 (예: 300000)"

        AlertDialog.Builder(this)
            .setTitle("한달 목표 소비량 설정")
            .setView(editText)
            .setPositiveButton("저장") { dialog, _ ->
                val input = editText.text.toString()
                if (input.isNotEmpty()) {
                    val formatted = "%,d".format(input.toInt())
                    textGoal.text = "한달 목표 소비량: ${formatted}원"
                }
                dialog.dismiss()
            }
            .setNegativeButton("취소") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}
