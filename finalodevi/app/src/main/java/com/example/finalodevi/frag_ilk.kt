package com.example.finalodevi

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView


class frag_ilk : Fragment(R.layout.fragment_frag_ilk) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_frag_ilk,container,false)
        val rSeekBar : SeekBar = view.findViewById(R.id.sk1)
        val gSeekBar : SeekBar = view.findViewById(R.id.sk2)
        val bSeekBar : SeekBar = view.findViewById(R.id.sk3)
        val text : TextView = view.findViewById(R.id.Mesaj)
        var r_hexdes = Integer.toHexString(0)
        var g_hexdes = Integer.toHexString(188)
        var b_hexdes = Integer.toHexString(212)

        if(r_hexdes.toString()=="0"){
            r_hexdes="00"
        }
        if(g_hexdes.toString()=="0"){
            g_hexdes="00"
        }
        if(b_hexdes.toString()=="0"){
            b_hexdes="00"
        }

        text.text = "#"+ r_hexdes.toString() + g_hexdes.toString() +b_hexdes.toString()


        fun renkUpdatte() {

            val red = rSeekBar.progress
            val green = gSeekBar.progress
            val blue = bSeekBar.progress
            val renk = Color.argb(255, red, green, blue)

            r_hexdes = Integer.toHexString(red)
            g_hexdes = Integer.toHexString(green)
            b_hexdes = Integer.toHexString(blue)

            if(r_hexdes.toString()=="0"){
                r_hexdes="00"
            }
            if(g_hexdes.toString()=="0"){
                g_hexdes="00"
            }
            if(b_hexdes.toString()=="0"){
                b_hexdes="00"
            }

            text.text = "#"+ r_hexdes.toString() + g_hexdes.toString() +b_hexdes.toString()

            view.setBackgroundColor(renk)
        }
        rSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                renkUpdatte()

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        gSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                renkUpdatte()

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        bSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                renkUpdatte()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
        return view
    }

}
