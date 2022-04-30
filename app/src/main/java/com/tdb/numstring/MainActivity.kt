package com.tdb.numstring

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.System.loadLibrary


class MainActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.convert_button).setOnClickListener {
            findViewById<TextView>(R.id.output).text = convert(findViewById<EditText>(R.id.userInput).text.toString(), readLangFile(getString(R.string.convert_lang)))
        }
        findViewById<Button>(R.id.clear_button).setOnClickListener {
            findViewById<TextView>(R.id.output).text = ""
            findViewById<EditText>(R.id.userInput).setText("")
        }
        findViewById<TextView>(R.id.output).setOnClickListener {
            copyToClipboard()
        }
        loadLibrary("num_string")
    }

    private fun readLangFile(name: String): String {
        var file_name = "langs/english.txt"
        if (name == "italian")
            file_name = "langs/italian.txt"
        else if (name == "english")
            file_name = "langs/english.txt"
        return application.assets.open(file_name).bufferedReader().use{it.readText()}
    }

    private fun copyToClipboard() {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip: ClipData = ClipData.newPlainText("output", findViewById<TextView>(R.id.output).toString())
        clipboard.setPrimaryClip(clip)
        Toast.makeText(this, R.string.text_copied, Toast.LENGTH_LONG).show()
    }

    private external fun convert(input: String, lang: String): String

}
