package com.tdb.numstring

import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.System.loadLibrary

class MainActivity : AppCompatActivity() {
    var numstringLang: String = "italian"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadLibrary("num_string")
    }

    fun readLangFile(name: String): String {
        var file_name: String = "langs/english.txt"
        if (name.equals("italian"))
            file_name = "langs/italian.txt"
        else if (name.equals("english"))
            file_name = "langs/english.txt"
        return application.assets.open(file_name).bufferedReader().use{it.readText()}
    }

    private external fun convert(input: String, lang: String): String

    fun convertOnClick(view: View) {
        findViewById<TextView>(R.id.output).text = convert(findViewById<EditText>(R.id.userInput).text.toString(), readLangFile(numstringLang))
    }
}
