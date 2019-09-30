package com.arlanov.testcoroutines.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.arlanov.testcoroutines.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.Main) {
            show("load")
            val data = withContext(Dispatchers.IO){
                Thread.sleep(4000)
                "succes"
            }
            text.text = data

            show("load2")
            val data2 = withContext(Dispatchers.IO){
                Thread.sleep(3000)
                "succes2"
            }
            text.text = data2
        }
        show("wait")
    }

    private fun show(s: String){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show()

    }
}
