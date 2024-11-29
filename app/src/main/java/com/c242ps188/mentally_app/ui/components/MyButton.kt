package com.c242ps188.mentally_app.ui.components

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.C242PS188.mentally_app.R

class MyButton: AppCompatEditText {

    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
        if (text.toString().length < 8) {
            setError(context.getString(R.string.error_password), null)
        } else {
            error = null
        }
    }

//    <com.c242ps188.mentally_app.ui.components.MyButton
//    android:layout_width="match_parent"
//    android:layout_marginStart="16dp"
//    android:layout_marginEnd="16dp"
//    android:layout_height="60dp"
//    android:background="@drawable/bg_rounded_edit_text"
//    app:layout_constraintStart_toStartOf="parent"
//    android:hint="@string/enter_your_email"
//    android:paddingStart="24dp"
//    android:inputType="textPassword"
//    app:layout_constraintEnd_toEndOf="parent"
//    app:layout_constraintTop_toBottomOf="@id/rv_article"
//    tools:ignore="RtlSymmetry" />

}