package com.hanseltritama.bottomsheetdemo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet.*
import java.lang.RuntimeException

class ActionBottomDialogFragment : BottomSheetDialogFragment(), View.OnClickListener {

    companion object {
        val TAG = "ActionBottomDialog"
        fun newInstance() : ActionBottomDialogFragment {
            return ActionBottomDialogFragment()
        }
    }

    private var mListener: ItemClickListener? = null

    interface ItemClickListener {
        fun onItemClick(item: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        share_textview.setOnClickListener(this)
        upload_textview.setOnClickListener(this)
        copy_textview.setOnClickListener(this)
        print_textview.setOnClickListener(this)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ItemClickListener) {
            mListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement ItemClickListener.")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    override fun onClick(view: View?) {
        val tvSelected: TextView = view as TextView
        mListener?.onItemClick(tvSelected.text.toString())
    }
}