package com.rsschool.android2021

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    private var listener: ButtonClickFirst? = null

    private var generateButton: Button? = null
    private var previousResult: TextView? = null
    private var editMin: EditText? = null
    private var editMax: EditText? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as ButtonClickFirst
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        previousResult = view.findViewById(R.id.previous_result)
        generateButton = view.findViewById(R.id.generate)

        val result = arguments?.getInt(PREVIOUS_RESULT_KEY)
        previousResult?.text = "Previous result: ${result.toString()}"

        editMin = view.findViewById(R.id.min_value)
        val min = editMin.text.toString()
        // TODO: val max = ...

        generateButton?.setOnClickListener {
            listener?.onButtonClickFirst(min, max)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(previousResult: Int): FirstFragment {
            val fragment = FirstFragment()
            val args = Bundle()
            args.putInt(PREVIOUS_RESULT_KEY, previousResult)
            fragment.arguments = args
            return fragment
        }

        private const val PREVIOUS_RESULT_KEY = "PREVIOUS_RESULT"

        interface ButtonClickFirst{
            fun onButtonClickFirst(min: Int, max: Int)
        }
    }
}