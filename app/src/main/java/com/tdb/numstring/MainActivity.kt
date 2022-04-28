package com.tdb.numstring

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import java.lang.System.loadLibrary

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadLibrary("num_string")
        findViewById<EditText>(R.id.userInput).setText(greeting("Worqweld"))
    }

    external fun greeting(pattern: String): String

    fun showPopup(view: View) {
        var popup = PopupMenu(this, view)
        var inflater = popup.menuInflater
        inflater.inflate(androidx.core.R.menu.example_menu, popup.menu)
        popup.show()
    }
}
