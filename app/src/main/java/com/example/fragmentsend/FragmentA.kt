package com.example.fragmentsend

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_a.*


class FragmentA : Fragment() {
    private var listener: OnFragmentAListener? = null
    private var edit_text: EditText? = null
    private var button_oK: Button? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_a, container, false)
         edit_text = root.findViewById<EditText>(R.id.editTextA)
        button_oK = root.findViewById(R.id.buttonA)
        button_oK!!.setOnClickListener {
            val input:CharSequence = edit_text!!.text
            listener?.onFragmentAInteraction(input)
        }
        return root
    }
    fun updateText(newText:CharSequence){
        edit_text!!.text = newText as Editable?
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentAListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentAListener {
        fun onFragmentAInteraction(input:CharSequence)
    }

}
