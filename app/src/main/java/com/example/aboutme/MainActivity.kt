package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding
import com.example.aboutme.data.MyName
import com.example.aboutme.databinding.ActivityMainBinding
import com.example.aboutme.ui.theme.AboutMeTheme

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val myName = MyName("Anjali Vithalkar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener { addNickName(it) }
    }

    private fun addNickName(view: View) {
        binding.apply {
            myName?.nickName = nicknameEdit.text.toString()
            invalidateAll()
            nicknameText.visibility = View.VISIBLE
            nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}