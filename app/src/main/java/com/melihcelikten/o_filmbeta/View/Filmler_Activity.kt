package com.melihcelikten.o_filmbeta.View

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.melihcelikten.o_film_beta.Model.fragment_kontrol
import com.melihcelikten.o_filmbeta.R
import com.melihcelikten.o_filmbeta.databinding.ActivityFilmlerBinding

class Filmler_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityFilmlerBinding
    private var mAuth: FirebaseAuth? = null

    private var currentUser: FirebaseUser? = null

    lateinit var uyariMesaji : AlertDialog.Builder

    lateinit var uyariMesaji2 : AlertDialog.Builder


     lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth = FirebaseAuth.getInstance()
        currentUser = mAuth?.currentUser

        binding = ActivityFilmlerBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        toolbar = findViewById(R.id.toolbar2)
        setSupportActionBar(toolbar)

        toolbar.overflowIcon = ContextCompat.getDrawable(applicationContext,R.drawable.ic_baseline_exit_to_app_24)

        supportActionBar?.setDisplayShowTitleEnabled(false)


        uyariMesaji = AlertDialog.Builder(this)
        uyariMesaji2 = AlertDialog.Builder(this)

        uyariMesaji.setMessage("Giriş Sayfasına Dönmek İstiyor Musunuz?")
        uyariMesaji.setPositiveButton("Evet"){_,_ ->


            Toast.makeText(this,"Yönlendiriliyorsunuz...",Toast.LENGTH_SHORT).show()

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)




        }
        uyariMesaji.setNegativeButton("Hayır"){_,_ -> uyariMesaji.setCancelable(true) }





        uyariMesaji2.setMessage("${currentUser?.displayName} Hesabından Çıkış Yapmak İstiyor Musunuz?")
        uyariMesaji2.setPositiveButton("Evet"){_,_ ->

            Toast.makeText(this,"Çıkış Yaptınız!",Toast.LENGTH_SHORT).show()
            mAuth?.signOut()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)



        }
        uyariMesaji2.setNegativeButton("Hayır"){_,_ -> uyariMesaji2.setCancelable(true) }











        val navController = findNavController(R.id.nav_host_fragment_activity_filmler)

       // val appBarConfiguration = AppBarConfiguration(setOf(R.id.top_Rated, R.id.now_Playing, R.id.upcoming,R.id.popular,R.id.cikis_Yap2))

     //   setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)








    }





    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_2, menu)
        return true


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == R.id.cikis_yap_menu) { uyariMesaji2.show()

            return true
        }

        return super.onOptionsItemSelected(item)



    }




    override fun onBackPressed() {

        if (fragment_kontrol == 1){ super.onBackPressed() }

        else{ uyariMesaji.show() } }








}