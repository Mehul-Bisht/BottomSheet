package com.example.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottomsheet.*

   lateinit var bottomSheetBehavior : BottomSheetBehavior<View>

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomSheetBehavior = BottomSheetBehavior.from(bottomsheet)
        //state hidden
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        shareimg.setOnClickListener{
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        bottomsheet.setOnClickListener {
            //show the dialog
            if(bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            //hide the dialog
            else if(bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }


        kepplayout.setOnClickListener(this)
        emaillayout.setOnClickListener(this)
        hangoutslayout.setOnClickListener(this)
        googlepluslayout.setOnClickListener(this)
        messengerlayout.setOnClickListener(this)
        slideslayout.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
            var returner = ""
             when(v?.id){
             R.id.kepplayout -> returner = "Keep notes"
             R.id.emaillayout -> returner = "E-mail"
             R.id.hangoutslayout -> returner = "Hangouts"
             R.id.googlepluslayout -> returner = "Google Plus"
             R.id.messengerlayout -> returner = "Messenger"
             R.id.slideslayout -> returner = "Slides"
             else -> returner = "nothing"
            }
            if(returner == "nothing"){
                chameleon.text = "Click a button in share dialog to activate it !"
            }
            else
            { chameleon.text = " You just clicked the $returner button ! "
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED}
        }
    }
}
