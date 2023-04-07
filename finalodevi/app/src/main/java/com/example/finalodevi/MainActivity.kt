package com.example.finalodevi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var Secim = getSharedPreferences("", MODE_PRIVATE)
        var pEdit = Secim.edit()
        var namemetin = findViewById<TextView>(R.id.girisAd)
        var sifreMetin = findViewById<TextView>(R.id.girisSoyad)
        var switch = findViewById<Switch>(R.id.sw1)
        var progres1 =findViewById<ProgressBar>(R.id.progressBar2)
        var user ="muhammed hukumdar"
        var password ="02210201501"
        var dogru2 = false
        var dogru1 = false
        var gecisYap = Intent(this, SecimEkrani::class.java)

        val user1=Intent(this@MainActivity,SecimEkrani::class.java)
        user1.putExtra("mesaj1",user)
        val password1=Intent(this@MainActivity,SecimEkrani::class.java)
        password1.putExtra("mesaj2",password)
        var exit_swich =intent.getBooleanExtra("x",true)


        fun sonraiSayfa()
        { Handler().postDelayed({
            pEdit.putString(user,namemetin.text.toString())
            pEdit.putString(password,sifreMetin.text.toString())
            pEdit.putString("swich_dogrulama",switch.isChecked.toString())
            pEdit.apply()
            progres1.isVisible = true
            startActivity(gecisYap)
            },3000)
        }

        if (exit_swich==false)
        {
            pEdit.putString("swich_dogrulama","false").apply()
            switch.isChecked=false
        }

        if(Secim.getString("swich_dogrulama","false")=="true")
        {
            namemetin.text = Secim.getString(user,"").toString()
            sifreMetin.text = Secim.getString(password,"").toString()
            switch.isChecked=true
            dogru1 = true
            dogru2 = true

            sonraiSayfa()

            Toast.makeText(applicationContext," Kaydedilmiş \n İsim: $user  \n Şifre: $password \n Unutma: True ",Toast.LENGTH_SHORT).show()

        }
        else {

            namemetin.doOnTextChanged() { charSequence: CharSequence?, i: Int, i1: Int, i2: Int ->
                if (user == charSequence.toString()) {
                    dogru2 = true
                }

                if (dogru2 == true && dogru1 == true) {
                    sonraiSayfa()
                }
            }

            sifreMetin.doOnTextChanged() { charSequence: CharSequence?, i: Int, i1: Int, i2: Int ->
                if (password == charSequence.toString()) {
                    dogru1 = true
                }

                if (dogru2 == true && dogru1 == true) {
                    sonraiSayfa()
                }
            }
            Toast.makeText(
                applicationContext,
                " Kaydedilmiş \n İsim: Değer Yok  \n Şifre: Değer \n Unutma: False ",
                Toast.LENGTH_SHORT
            ).show()

        }       }
}