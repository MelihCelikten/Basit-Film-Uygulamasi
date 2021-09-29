package com.melihcelikten.o_filmbeta.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.melihcelikten.o_filmbeta.R
import java.text.SimpleDateFormat
import java.util.*


class Profil : Fragment() {


    private var mAuth: FirebaseAuth? = null

    private var currentUser: FirebaseUser? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profil, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAuth = FirebaseAuth.getInstance()
        currentUser = mAuth?.currentUser

        @SuppressLint("SimpleDateFormat")
        fun hesapYaratilmaTarihi (time: Long = currentUser?.metadata?.creationTimestamp!!): String {
            val date = Date(time)
            val format = SimpleDateFormat("dd/M/yyyy hh:mm:ss")



            return format.format(date)
        }

        @SuppressLint("SimpleDateFormat")
        fun sonEtkinlik (time: Long = currentUser?.metadata?.lastSignInTimestamp!!): String {
            val date = Date(time)
            val format = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            return format.format(date)
        }


        val kullaniciAdi = view.findViewById<TextView>(R.id.profil_kullanici_adi)
        val eMail = view.findViewById<TextView>(R.id.profil_e_mail_adresi)
        val eMailOnay = view.findViewById<TextView>(R.id.profil_e_mail_onay)
        val telefon= view.findViewById<TextView>(R.id.profil_telefon_numarası)
        val hesapKayit = view.findViewById<TextView>(R.id.profil_hesap_tarihi)
        val hesapEtkinlik = view.findViewById<TextView>(R.id.profil_son_hesap_etkinligi)


        if (currentUser?.isEmailVerified == false){ eMailOnay.text = "E-Mail Adresi Onaylanmamıştır." }
        else{ eMailOnay.text = "${currentUser?.isEmailVerified}" }

        if (currentUser?.phoneNumber?.trim()?.length == 0){ telefon.text = "Hesaba Kayıtlı Bir Telefon Numarası Yoktur." }
        else{ telefon.text = "${currentUser?.phoneNumber}" }


        kullaniciAdi.text = "${currentUser?.displayName}"
        eMail.text = "${currentUser?.email}"

        hesapKayit.text = hesapYaratilmaTarihi()
        hesapEtkinlik.text = sonEtkinlik()







    }


}