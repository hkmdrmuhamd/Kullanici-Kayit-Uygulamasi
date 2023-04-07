package com.example.finalodevi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.SeekBar
import android.widget.Toast

class acilis : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acilis)

        var seBar = findViewById<SeekBar>(R.id.seekgecis)
        seBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if(p1==1000){
                    var mesaj=layoutInflater.inflate(R.layout.toast,null)
                    var toast_t= Toast(applicationContext)
                    toast_t.view=mesaj
                    toast_t.duration= Toast.LENGTH_SHORT
                    toast_t.show()
                    object: CountDownTimer(2000,1000){
                        override fun onTick(p0: Long) {

                        }
                        override fun onFinish() {
                            var girisEkraninaGec= Intent(applicationContext,MainActivity::class.java)
                            startActivity(girisEkraninaGec)
                            finish()
                        }

                    }.start()
                }
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {

            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
                object : CountDownTimer(1000, 1) {
                    override fun onTick(p0: Long) {
                        seBar.progress = seBar.progress - 50
                    }
                    override fun onFinish() {

                    }
                }.start()
            }
        })
    }
}