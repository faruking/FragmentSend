package com.example.fragmentsend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() ,FragmentA.OnFragmentAListener,FragmentB.OnFragmentBListener {
var fragmentA:FragmentA?= null
    var fragmentB:FragmentB?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         fragmentA = FragmentA()
        fragmentB = FragmentB()

        supportFragmentManager.beginTransaction().replace(R.id.frameLayoutA, fragmentA!!)
            .replace(R.id.frameLayoutB, fragmentB!!)

            .commit()
    }
    override fun onFragmentAInteraction(input: CharSequence) {
        fragmentB!!.updateText(input)
    }

    override fun onFragmentBInteraction(input: CharSequence) {
        fragmentA!!.updateText(input)

    }

}
