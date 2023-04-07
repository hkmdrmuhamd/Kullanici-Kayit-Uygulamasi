package com.example.finalodevi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.doOnTextChanged

class SecimEkrani : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secim_ekrani)
        val tasarim = layoutInflater.inflate(R.layout.dialog, null)
        var buton = findViewById<Button>(R.id.button)
        val firsFragment = frag_ilk()
        val secondFragment = spinner()
        var geriDon = Intent(this, MainActivity::class.java)
        var prog_bar = tasarim.findViewById<ProgressBar>(R.id.progressBar3)
        val gecikme_resim = findViewById<ImageView>(R.id.imageView)

        object : CountDownTimer(980920,1){
            override fun onTick(p0: Long) {
                if(p0.toInt()%1000>500){
                    gecikme_resim.setAlpha(1000)
                }else{
                    gecikme_resim.setAlpha(0)
                }
            }
            override fun onFinish() {

            }
            }.start()


        fun cikisFonksiyonu() {
            prog_bar.visibility = View.VISIBLE
            Handler().postDelayed({
                geriDon.putExtra("x",false)
                startActivity(geriDon)

            }, 3000)
        }
        buton.setOnClickListener {
            val katalog = PopupMenu(this, buton)
            katalog.menuInflater.inflate(R.menu.popupmenu, katalog.menu)
            katalog.setOnMenuItemClickListener { i ->
                when (i.itemId) {
                    R.id.rgb -> {
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.fragment, firsFragment)
                            commit()
                        }
                        true}

                    R.id.snackbar -> {
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.fragment, secondFragment)
                            commit()
                        }
                        true }
                    R.id.cikis -> {
                        val girilenAd = AlertDialog.Builder(this@SecimEkrani)
                        var editisim = tasarim.findViewById<EditText>(R.id.editTextTextPersonName)
                        var editsifre = tasarim.findViewById<EditText>(R.id.editTextt2)

                        var kontrol1 = false
                        var kontrol2 = false

                        girilenAd.setView(tasarim)



                        editisim.doOnTextChanged()
                        { charSequence: CharSequence?, i: Int, i1: Int, i2: Int ->
                            if ("muhammed hukumdar" == charSequence.toString()) {
                                kontrol1 = true
                            }
                            if (kontrol1 == true && kontrol2 == true) {
                                cikisFonksiyonu()
                            }
                        }
                        editsifre.doOnTextChanged()
                        { charSequence: CharSequence?, i: Int, i1: Int, i2: Int ->
                            if ("02210201501" == charSequence.toString()) {
                                kontrol2 = true
                            }
                            if (kontrol1 == true && kontrol2 == true) {
                                cikisFonksiyonu()
                            }
                        }
                        girilenAd.create().show()
                        true }
                    else -> false
                }
            }
            katalog.show()
        }
    }
}