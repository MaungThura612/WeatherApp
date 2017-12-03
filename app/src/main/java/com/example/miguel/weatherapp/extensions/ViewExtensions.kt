package com.example.miguel.weatherapp.extensions

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.TextView
import java.text.DateFormat
import java.util.*

/**
 * Created by miguel on 11/11/17.
 */
val View.ctx : Context
 get() = context


fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
 val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
 return df.format(this)

}
var TextView.textColor: Int
    get() = currentTextColor
    set(v) = setTextColor(v)

public fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)

fun View.slideExit() {
    if (translationY == 0f) animate().translationY(-height.toFloat())
}

fun View.slideEnter() {
    if (translationY < 0f) animate().translationY(0f)
}