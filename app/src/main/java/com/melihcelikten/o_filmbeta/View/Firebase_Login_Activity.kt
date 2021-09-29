package com.melihcelikten.o_filmbeta.View

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.melihcelikten.o_film_beta.Model.kullanici_sifre_hatirlama
import com.melihcelikten.o_filmbeta.R

class Firebase_Login_Activity : AppCompatActivity() {



    private var mAuth: FirebaseAuth? = null
    private var currentUser: FirebaseUser? = null


    var kullanici_kayit : String? = null
    var kullanici_sifre : String? = null

    lateinit var checkBox: CheckBox




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_login)


        checkBox = findViewById(R.id.checkBox)
        checkBox.setOnCheckedChangeListener { buton, sonuc -> kullanici_sifre_hatirlama = sonuc == true }

        mAuth = FirebaseAuth.getInstance()
        currentUser = mAuth?.currentUser



        /*

        if (currentUser != null) {

            val intent = Intent(this,Filmler_Activity::class.java)
            startActivity(intent)




        }
        if (currentUser == null) { println("kullanıcı giriş yapmamış.") }


         */



        val progress_bar_email = findViewById<ProgressBar>(R.id.progressBar_firebase)
        progress_bar_email.isVisible = false

        val e_mail_kullanici_text = findViewById<EditText>(R.id.editTextTextPersonName)
        val e_mail_kullanici_sifre = findViewById<EditText>(R.id.editTextTextPassword)

        val e_mail_giris_button = findViewById<Button>(R.id.giris_yap_firebase)
        val e_mail_kayit_button = findViewById<Button>(R.id.kayit_ol_firebase)


        e_mail_kayit_button.setOnClickListener {


            progress_bar_email.isVisible = true

            try {

                kullanici_kayit = e_mail_kullanici_text.text.trim().toString()
                kullanici_sifre = e_mail_kullanici_sifre.text.trim().toString()


                mAuth?.createUserWithEmailAndPassword(kullanici_kayit!!,kullanici_sifre!!)?.addOnCompleteListener { firebase->


                    if (firebase.isSuccessful){


                        progress_bar_email.isVisible = false

                        val profileUpdates = UserProfileChangeRequest.Builder().apply { displayName = e_mail_kullanici_text.text.toString().trim() }.build()
                        mAuth?.currentUser?.updateProfile(profileUpdates)?.addOnCompleteListener {
                                task-> if (task.isSuccessful){ Toast.makeText(this,"O FİLM BETA'YA HOŞGELDİNİZ! ${mAuth?.currentUser?.displayName.toString()}", Toast.LENGTH_LONG).show() } }

                        val intent = Intent(this,Filmler_Activity::class.java)
                        startActivity(intent)








                    }

                    else{

                        progress_bar_email.isVisible = false
                        Toast.makeText(this,"HATA KODU: ${ firebase.exception?.localizedMessage}", Toast.LENGTH_LONG).show() }


                }




            }catch (e:Exception){

                Toast.makeText(this,"Kullanıcı Adınızı ve Şifrenizi Giriniz!", Toast.LENGTH_SHORT).show()

            }









        }
        e_mail_giris_button.setOnClickListener {


            kullanici_kayit = e_mail_kullanici_text.text.trim().toString()
            kullanici_sifre = e_mail_kullanici_sifre.text.trim().toString()




            try {

                progress_bar_email.isVisible = true


                mAuth?.signInWithEmailAndPassword(kullanici_kayit!!,kullanici_sifre!!)?.addOnCompleteListener { firebase->


                    if (firebase.isSuccessful){

                        progress_bar_email.isVisible = false


                        var intent = Intent(this,Filmler_Activity::class.java)
                        startActivity(intent)
                        Toast.makeText(this, "TEKRAR HOŞGELDİN! ${mAuth!!.currentUser?.email.toString().trim()}", Toast.LENGTH_LONG).show()}



                }?.addOnFailureListener { firebase ->

                    progress_bar_email.isVisible = false
                    Toast.makeText(this,firebase.localizedMessage, Toast.LENGTH_LONG).show()

                }

            }catch (e: Exception){

                progress_bar_email.isVisible = false

                Toast.makeText(this,"Kullanıcı Adınızı ve Şifrenizi Giriniz!", Toast.LENGTH_SHORT).show()


            }








        }
















    }







    override fun onBackPressed() {
        super.onBackPressed()

        finish()
    }











    }



