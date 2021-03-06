package com.behaviorule.arturdumchev.behaviorule

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.top_view.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(tToolbar)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        fab.setOnClickListener { view ->
            val isVisible = tvPainIsTheArse.visibility == View.VISIBLE
            val drawableRes = when {
                isVisible -> R.drawable.ic_keyboard_arrow_down_black_24dp
                else -> R.drawable.ic_close_black_24dp
            }
            fab.setImageDrawable(ContextCompat.getDrawable(this, drawableRes))

            val visibility = if (isVisible) View.GONE else View.VISIBLE
            tvPainIsTheArse.visibility = visibility

            Snackbar.make(view, "Angry text visibility changed", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }
}
