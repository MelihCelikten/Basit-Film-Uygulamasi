package com.melihcelikten.o_film_beta.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.melihcelikten.o_film_beta.Model.*
import com.melihcelikten.o_filmbeta.R

class Now_Playing_Paging_Adapter:  PagingDataAdapter<Now_Playing_Results, Now_Playing_Paging_Adapter.ViewHolder>(COMPARATOR){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var now_playing_button = view.findViewById<Button>(R.id.button_now_playing)
        var now_playing_title = view.findViewById<TextView>(R.id.title_now_playing)
        var ortalama_puan_now_playing = view.findViewById<TextView>(R.id.oy_ortalamasi_now_playing)
        var imageView_now_playing = view.findViewById<ImageView>(R.id.now_playing_Image_View)
        var linear_now_playing = view.findViewById<LinearLayout>(R.id.now_playing_linear_2)

        var text1 = view.findViewById<TextView>(R.id.birinciKonuBasligi_now_playing)
        var text2 = view.findViewById<TextView>(R.id.ikinciKonuBasligi_now_playing)
        var text3 = view.findViewById<TextView>(R.id.ucuncuKonuBasligi_now_playing)
        var text4 = view.findViewById<TextView>(R.id.dorduncuKonuBasligi_now_playing)
        var text5 = view.findViewById<TextView>(R.id.besinciKonuBasligi_now_playing)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.now_playing_title.text = getItem(position)?.title
        holder.ortalama_puan_now_playing.text = "Ortalama Puan : ${getItem(position)?.voteAverage.toString()}"





        getItem(position).apply {


            if (getItem(position)?.genreIds?.size == 1){

                holder.text1.text = getItem(position)?.genreIds?.get(0)?.let { genre_ID_kontrol(it) }
                holder.linear_now_playing.removeView(holder.text5)
                holder.linear_now_playing.removeView(holder.text4)
                holder.linear_now_playing.removeView(holder.text3)
                holder.linear_now_playing.removeView(holder.text2)




            }
            else if (getItem(position)?.genreIds?.size == 2){

                holder.text1.text = getItem(position)?.genreIds?.get(0)?.let { genre_ID_kontrol(it) }
                holder.text2.text = getItem(position)?.genreIds?.get(1)?.let { genre_ID_kontrol(it) }

                holder.linear_now_playing.removeView(holder.text5)
                holder.linear_now_playing.removeView(holder.text4)
                holder.linear_now_playing.removeView(holder.text3)





            }
            else if (getItem(position)?.genreIds?.size == 3){

                holder.text1.text = getItem(position)?.genreIds?.get(0)?.let { genre_ID_kontrol(it) }
                holder.text2.text = getItem(position)?.genreIds?.get(1)?.let { genre_ID_kontrol(it) }
                holder.text3.text = getItem(position)?.genreIds?.get(2)?.let { genre_ID_kontrol(it) }

                holder.linear_now_playing.removeView(holder.text5)
                holder.linear_now_playing.removeView(holder.text4)



            }
            else if (getItem(position)?.genreIds?.size == 4){

                holder.text1.text = getItem(position)?.genreIds?.get(0)?.let { genre_ID_kontrol(it) }
                holder.text2.text = getItem(position)?.genreIds?.get(1)?.let { genre_ID_kontrol(it) }
                holder.text3.text = getItem(position)?.genreIds?.get(2)?.let { genre_ID_kontrol(it) }
                holder.text4.text = getItem(position)?.genreIds?.get(3)?.let { genre_ID_kontrol(it) }
                holder.linear_now_playing.removeView(holder.text5)



            }
            else if (getItem(position)?.genreIds?.size == 5){


                holder.text1.text = getItem(position)?.genreIds?.get(0)?.let { genre_ID_kontrol(it) }
                holder.text2.text = getItem(position)?.genreIds?.get(1)?.let { genre_ID_kontrol(it) }
                holder.text3.text = getItem(position)?.genreIds?.get(2)?.let { genre_ID_kontrol(it) }
                holder.text4.text = getItem(position)?.genreIds?.get(3)?.let { genre_ID_kontrol(it) }
                holder.text5.text = getItem(position)?.genreIds?.get(4)?.let { genre_ID_kontrol(it) }
            }




        }




        holder.imageView_now_playing.apply {

            val image_url : String = "https://image.tmdb.org/t/p/w500${getItem(position)?.posterPath}"
            Glide.with(this).load(image_url).into(this)


        }





        holder.now_playing_button.setOnClickListener {


            film_ismi_global = getItem(position)?.title
            overView = getItem(position)?.overview
            orjinal_isim = getItem(position)?.originalTitle
            vizyon_tarihi_global =getItem(position)?.releaseDate
            toplam_izleyici_oyu = getItem(position)?.voteCount.toString()
            oy_ortalamasi_global = getItem(position)?.voteAverage.toString()
            orjinal_dili = getItem(position)?.originalLanguage.toString()
            global_image_url = "https://image.tmdb.org/t/p/w500${getItem(position)?.backdropPath}"



           holder.itemView.findNavController().navigate(R.id.action_now_Playing_to_film_Ayrintilari)









        }







    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Now_Playing_Paging_Adapter.ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.now_playing_adapter, parent, false))



    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Now_Playing_Results>() {
            override fun areItemsTheSame(oldItem: Now_Playing_Results, newItem: Now_Playing_Results): Boolean =
                oldItem.adult == newItem.adult

            override fun areContentsTheSame(oldItem: Now_Playing_Results, newItem: Now_Playing_Results): Boolean =
                oldItem == newItem
        }
    }

}