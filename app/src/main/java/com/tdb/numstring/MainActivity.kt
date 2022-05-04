package com.tdb.numstring

//import android.annotation.SuppressLint
//import android.content.ClipData
//import android.content.ClipboardManager
//import android.content.Context
//import android.widget.Toast
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.System.loadLibrary


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.convert_button).setOnClickListener {
            convertOnClick()
        }
        findViewById<Button>(R.id.clear_button).setOnClickListener {
            clearOnClick()
        }
//        findViewById<TextView>(R.id.output).setOnClickListener {
//            copyToClipboard()
//        }
        findViewById<TextView>(R.id.output).movementMethod = ScrollingMovementMethod()
        loadLibrary("num_string")
    }

    private fun clearOnClick() {
        findViewById<TextView>(R.id.output).text = ""
        findViewById<EditText>(R.id.userInput).setText("")
    }

    private fun convertOnClick() {
        findViewById<TextView>(R.id.output).text = convert(findViewById<EditText>(R.id.userInput).text.toString(), readLangFile(getString(R.string.convert_lang)))
    }

    private fun readLangFile(name: String): String {
        var filename = "langs/english.txt"
        if (name == "italian")
            filename = "langs/italian.txt"
        else if (name == "english")
            filename = "langs/english.txt"
        return application.assets.open(filename).bufferedReader().use{it.readText()}
    }

//    private fun copyToClipboard() {
//        val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
//        val clip: ClipData = ClipData.newPlainText("simple text", "Hello, World!")
//        clipboard.setPrimaryClip(clip)
//        Toast.makeText(this, R.string.text_copied, Toast.LENGTH_LONG).show()
//    }

    private external fun convert(input: String, lang: String): String

}
