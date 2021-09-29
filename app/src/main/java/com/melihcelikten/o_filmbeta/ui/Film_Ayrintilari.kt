package com.melihcelikten.o_filmbeta.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.melihcelikten.o_film_beta.Model.*
import com.melihcelikten.o_filmbeta.R


class Film_Ayrintilari : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragment_kontrol += 1
        println("fragment: ${fragment_kontrol}")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film__ayrintilari, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       // activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) { override fun handleOnBackPressed() {} })


        val filmAdi = view.findViewById<TextView>(R.id.filmin_adi)
        val filminKonusu = view.findViewById<TextView>(R.id.filmin_konusu)
        val orijinalAdi = view.findViewById<TextView>(R.id.orijinal_adi)
        val orijinalDili = view.findViewById<TextView>(R.id.orijinal_dili)
        val vizyonTarihi = view.findViewById<TextView>(R.id.vizyon_tarihi)
        val toplamOy = view.findViewById<TextView>(R.id.toplam_oy)
        val ortalamaPuan = view.findViewById<TextView>(R.id.ortalama_puan)
        val filmAyrintilariImageView  = view.findViewById<ImageView>(R.id.film_ayrintilari_Image_View)


        filmAdi.text = film_ismi_global
        filminKonusu.text = overView
        orijinalAdi.text = "Orijinal İsmi : ${orjinal_isim}"
        orijinalDili.text ="Orijinal Dili : ${orjinal_dili}"
        vizyonTarihi.text ="Vizyon Tarihi : ${vizyon_tarihi_global}"
        toplamOy.text = "Toplam İzleyici Oyu: ${toplam_izleyici_oyu}"
        ortalamaPuan.text = "Oy Ortalaması : ${oy_ortalamasi_global}"
        filmAyrintilariImageView.apply { Glide.with(this).load(global_image_url).into(this) }










    }













    override fun onDestroy() {
        super.onDestroy()

        fragment_kontrol -= 1
    }







}