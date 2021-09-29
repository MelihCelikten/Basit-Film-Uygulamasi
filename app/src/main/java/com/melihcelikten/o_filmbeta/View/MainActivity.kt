package com.melihcelikten.o_filmbeta.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.melihcelikten.o_film_beta.Model.kullanici_sifre_hatirlama

import com.melihcelikten.o_filmbeta.R

class MainActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    private var currentUser: FirebaseUser? = null

    lateinit var uyariMesaji : AlertDialog.Builder
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mAuth = FirebaseAuth.getInstance()
        currentUser = mAuth?.currentUser

        uyariMesaji = AlertDialog.Builder(this)


        progressBar = findViewById(R.id.progressBar_main)
        progressBar.isVisible = false

        if (currentUser != null){ uyariMesaji.setMessage("${currentUser?.displayName} hesabından çıkış yapmak istiyor musunuz?") }




        uyariMesaji.setPositiveButton("Evet"){_,_ ->

            Toast.makeText(this,"Yönlendiriliyorsunuz, Lütfen Bekleyin...",Toast.LENGTH_SHORT).show()
            mAuth?.signOut()
            var intent = Intent(this, Firebase_Login_Activity::class.java)
            startActivity(intent)






        }
        uyariMesaji.setNegativeButton("Hayır"){_,_ -> uyariMesaji.setCancelable(true) }




        //supportActionBar?.setIcon(R.drawable.ic_baseline_exit_to_app_24)
        // toolbar.overflowIcon = ContextCompat.getDrawable(applicationContext,android.R.drawable.ic_dialog_info)


        var buton = findViewById<Button>(R.id.e_mail_button_ana_sayfa)
        var buton2 = findViewById<Button>(R.id.e_mail_button_ana_sayfa2)



        if (currentUser != null) {

            buton.text = "HOŞGELDİNİZ, ${currentUser?.displayName.toString()}"
            buton2.isVisible = true



        }

        else{
            buton.text = "E-MAİL İLE GİRİŞ YAPIN VEYA KAYDOLUN"
            buton2.isVisible = false
            println("kullanıcı giriş yapmamış.")

        }



        buton.setOnClickListener {

            progressBar.isVisible = true
            Toast.makeText(this,"Yönlendiriliyorsunuz, Lütfen Bekleyin...",Toast.LENGTH_SHORT).show()

            var intent = Intent(this, Firebase_Login_Activity::class.java)
            startActivity(intent)


        }

        buton2.setOnClickListener { uyariMesaji.show() }








    }


    override fun onBackPressed() {
        super.onBackPressed()

        finishAffinity()
    }




}