package com.example.fragmentsend

import android.content.Context
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


class FragmentB : Fragment() {
    private var listener: OnFragmentBListener? = null
    private var edit_text: EditText? = null
    private var button_oK: Button? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_b, container, false)
         edit_text = root.findViewById(R.id.editTextB)
        button_oK = root.findViewById(R.id.buttonB)
        button_oK!!.setOnClickListener {
            val input:CharSequence = edit_text!!.text
            listener?.onFragmentBInteraction(input)
        }
        return root
    }
    fun updateText(newText:CharSequence){
        edit_text!!.text = newText as Editable?
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentBListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentBListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentBListener {
        fun onFragmentBInteraction(input:CharSequence)
    }

}
