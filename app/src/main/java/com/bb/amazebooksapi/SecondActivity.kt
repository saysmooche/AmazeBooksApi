package com.bb.amazebooksapi

import android.os.Bundle
import android.view.View
import android.widget.TextView

class SecondActivity : MainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)
        val result = findViewById<View>(R.id.textView5) as TextView
        val result5 = findViewById<View>(R.id.textView) as TextView
        val result1 = findViewById<View>(R.id.textView2) as TextView
        val result2 = findViewById<View>(R.id.textView3) as TextView
        val result3 = findViewById<View>(R.id.textView4) as TextView
        val intent = intent
        val email = intent.getSerializableExtra("EXTRA_EMAIL") as String
        val subject = intent.getSerializableExtra("EXTRA_SUBJECT") as String
        val text = intent.getSerializableExtra("EXTRA_TEXT") as String
        val text2 = intent.getSerializableExtra("EXTRA_TEXT") as String
        val other = intent.getSerializableExtra("EXTRA_SHORTCUT_NAME") as String
        result.text = email
        result1.text = subject
        result2.text = text
        result5.text = text2
        result3.text = other
    }
}