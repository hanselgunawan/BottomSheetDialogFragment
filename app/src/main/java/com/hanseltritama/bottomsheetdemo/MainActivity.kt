package com.hanseltritama.bottomsheetdemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ActionBottomDialogFragment.ItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showBottomSheet(view: View) {
        val addPhotoBottomDialogFragment = ActionBottomDialogFragment.newInstance()
        addPhotoBottomDialogFragment.show(supportFragmentManager, ActionBottomDialogFragment.TAG)
    }

    @SuppressLint("SetTextI18n")
    override fun onItemClick(item: String) {
        tvSelectedItem.text = "Selected action item is $item"
    }
}
