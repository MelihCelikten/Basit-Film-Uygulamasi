package com.melihcelikten.o_film_beta.Model



var fragment_kontrol : Int = 0
var kullanici_sifre_hatirlama : Boolean? = null

var film_ismi_global : String? = null
var overView : String? = null
var global_image_url: String? = null
var orjinal_isim: String? = null
var vizyon_tarihi_global: String? = null
var toplam_izleyici_oyu: String? = null
var oy_ortalamasi_global : String? = null
var orjinal_dili : String? = null

fun genre_ID_kontrol(genreID: Int) : String? {

    when (genreID) {
        28 -> { return "Aksiyon" }
        12 -> { return "Macera" }
        16 -> { return "Animasyon" }
        35 -> { return "Komedi" }
        80 -> { return "Suç" }
        99 -> { return "Belgesel" }
        18 -> { return "Dram" }
        10751 -> { return "Aile" }
        14 -> { return "Fantastik" }
        36 -> { return "Tarih" }
        27 -> { return "Korku" }
        10402 -> { return "Müzik" }
        9648 -> { return "Gizem" }
        10749 -> { return "Romantik" }
        878 -> { return "Bilim Kurgu" }
        10770 -> { return "TV Filmi" }
        53 -> { return "Gelirim" }
        10752 -> { return "Savaş" }
        37 -> { return "Vahşi Batı" }
        else -> { return null }
    }



}