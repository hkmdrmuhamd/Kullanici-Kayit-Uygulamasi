package com.example.finalodevi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class spinner : Fragment(R.layout.fragment_spinner) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_spinner, container, false)
        var spnr: Spinner = view.findViewById(R.id.spinner)
        var zamanlar = arrayOf("Süre Seçiniz", "2sn", "2.5sn", "3sn", "3.5sn", "4sn")
        val layout = layoutInflater.inflate(R.layout.fragment_spinner, null)
        layout.findViewById<Spinner>(R.id.spinner)
        var edit_text1:EditText=view.findViewById(R.id.edit1)
        var edit_text2:EditText=view.findViewById(R.id.edit2)
        var uyarlayıcı = ArrayAdapter(layout.context, android.R.layout.simple_dropdown_item_1line, zamanlar)

        spnr.adapter = uyarlayıcı
        spnr.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (zamanlar[p2] == "2sn"){
                    Snackbar.make(spnr ,"${edit_text1.text}",2000)
                        .setAction("${edit_text2.text}"){
                            Toast.makeText(spnr.context,"${edit_text2.text}",Toast.LENGTH_SHORT).show()

                        }.show()
                } else if(zamanlar[p2] == "2.5sn"){
                    Snackbar.make(spnr ,"${edit_text1.text}",2500)
                        .setAction("${edit_text2.text}"){
                            Toast.makeText(spnr.context,"${edit_text2.text}",Toast.LENGTH_SHORT).show()

                        }.show()
                } else if (zamanlar[p2] == "3sn"){
                    Snackbar.make(spnr ,"${edit_text1.text}",3000)
                        .setAction("${edit_text2.text}"){
                            Toast.makeText(spnr.context,"${edit_text2.text}",Toast.LENGTH_SHORT).show()

                        }.show()
                } else if (zamanlar[p2] == "3.5sn"){
                    Snackbar.make(spnr ,"${edit_text1.text}",3500)
                        .setAction("${edit_text2.text}"){
                            Toast.makeText(spnr.context,"${edit_text2.text}",Toast.LENGTH_SHORT).show()

                        }.show()
                }else if (zamanlar[p2] == "4sn"){
                    Snackbar.make(spnr ,"${edit_text1.text}",4000)
                        .setAction("${edit_text2.text}"){
                            Toast.makeText(spnr.context,"${edit_text2.text}",Toast.LENGTH_SHORT).show()

                        }.show()
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        return view
    }
}


