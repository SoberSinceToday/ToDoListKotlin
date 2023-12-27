package com.example.notebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list: ListView = findViewById(R.id.listViewDeals)
        val pasteField: EditText = findViewById(R.id.text_input)
        val button: Button = findViewById(R.id.input_button)

        val deals: MutableList<String> = mutableListOf()
        val arrAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, deals)

        list.adapter = arrAdapter
        list.setOnItemClickListener{adapterView, view, i, l ->
            val textToDel = list.getItemAtPosition(i).toString()
            arrAdapter.remove(textToDel)

            Toast.makeText(this, "Item $textToDel has been deleted", Toast.LENGTH_SHORT).show()
        }

        button.setOnClickListener {
            val userText = pasteField.text.toString().trim()
            if (userText != "")
                arrAdapter.insert(userText, 0)
                pasteField.setText("")
        }
    }
}