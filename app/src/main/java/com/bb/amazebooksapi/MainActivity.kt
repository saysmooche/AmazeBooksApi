package com.bb.amazebooksapi

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import io.reactivex.disposables.CompositeDisposable

open class MainActivity : AppCompatActivity() {
    private var viewModel: ViewModel? = null
    private val button: Button? = null
    private val textViewSee: TextView? = null
    private val getResults: List<Book>? = null
    private val compositeDisposable = CompositeDisposable()
    private var picAnimation: AnimationDrawable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.submit_button)
        val searchtxt = findViewById<EditText>(R.id.input_text)
        val wormImage = findViewById<ImageView>(R.id.imageView1)
        wormImage.setBackgroundResource(R.drawable.rocket_thrust)
        picAnimation = wormImage.background as AnimationDrawable
        wormImage.setOnClickListener { picAnimation!!.start() }
        button.setOnClickListener {
            picAnimation!!.start()
            bookInfo
        }
        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
        compositeDisposable.add(viewModel!!.getBookListRx("new").subscribe({ getResults: List<Book> -> displayBookRx(getResults) }) { throwable: Throwable? -> DebugLogger.logError(throwable) })
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    fun displayBookRx(getResults: List<Book>) {
        for (i in getResults.indices) {
            DebugLogger.logDebug("RxJava : " + getResults[i].items)
        }
    }

    val bookInfo: Unit
        get() {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("saysmooche@gmail.com."))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Welcome to Amazebooks!")
            intent.putExtra(Intent.EXTRA_TEXT, "Please review your book search query below.")
            intent.putExtra(Intent.EXTRA_TEXT, getResults.toString())
            intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getString(R.string.app_name))
            intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(applicationContext, R.drawable.bookwormbooks))
            startActivity(Intent.createChooser(intent, "Choose Mail App"))
        }

    val firebase: Unit
        get() {
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference("message")
            myRef.setValue("Welcome to AmazeBooksApi!")
            Toast.makeText(this, "You are using Firebase.", Toast.LENGTH_SHORT).show()
            myRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val value = dataSnapshot.getValue(String::class.java)
                    Log.d(TAG, "Value is: $value")
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    Log.w(TAG, "Failed to Read Value. ", databaseError.toException())
                }
            })
        }

    companion object {
        const val TAG = "TAG_N"
    }
}