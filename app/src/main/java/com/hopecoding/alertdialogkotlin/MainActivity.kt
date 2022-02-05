package com.hopecoding.alertdialogkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var savedText: String? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()
    }

    fun save(view: View) {
        val alert = AlertDialog.Builder(this)
        savedText = editText.text.toString()
        if (savedText.equals("")) {
            Toast.makeText(this, "You forgot to enter text", Toast.LENGTH_LONG).show()
        } else {
            alert.setTitle("Save")
            alert.setMessage("Are you sure you want to save your text?")
            alert.setNegativeButton("Yes") { _, _ ->
                Toast.makeText(applicationContext, "Your text has been saved.", Toast.LENGTH_LONG)
                    .show()
                textView.text = savedText
                editText.setText("")
            }
            alert.setPositiveButton("No") { _,_ ->
                Toast.makeText(applicationContext,
                    "Your text has not been saved.",
                    Toast.LENGTH_LONG).show()
            }

            alert.show()

        }

    }


}