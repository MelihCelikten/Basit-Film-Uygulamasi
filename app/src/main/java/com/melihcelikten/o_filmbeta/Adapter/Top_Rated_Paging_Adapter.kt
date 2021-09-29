package com.melihcelikten.o_filmbeta.Adapter

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

class Top_Rated_Paging_Adapter :  PagingDataAdapter<Top_Rated_Results, Top_Rated_Paging_Adapter.ViewHolder>(
    COMPARATOR
){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        var top_rated_button = view.findViewById<Button>(R.id.button_top_rated)
        var top_rated_title = view.findViewById<TextView>(R.id.top_rated_title)
        var top_rated_ortalama_puan = view.findViewById<TextView>(R.id.top_rated_ortalama_puan)
        var top_rated_Image_View = view.findViewById<ImageView>(R.id.top_rated_Image_View)
        var top_rated_linear = view.findViewById<LinearLayout>(R.id.top_rated_linear_3)

        var text1 = view.findViewById<TextView>(R.id.birinciKonuBasligi)
        var text2 = view.findViewById<TextView>(R.id.ikinciKonuBasligi)
        var text3 = view.findViewById<TextView>(R.id.ucuncuKonuBasligi)
        var text4 = view.findViewById<TextView>(R.id.dorduncuKonuBasligi)
        var text5 = view.findViewById<TextView>(R.id.besinciKonuBasligi)




    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.top_rated_title.text = getItem(position)?.title
        holder.top_rated_ortalama_puan.text = "Ortalama Puan : ${getItem(position)?.voteAverage.toString()}"



        getItem(position).apply {


            if (getItem(position)?.genreIds?.size == 1){

                holder.text1.text = getItem(position)?.genreIds?.get(0)?.let { genre_ID_kontrol(it) }
                holder.top_rated_linear.removeView(holder.text5)
                holder.top_rated_linear.removeView(holder.text4)
                holder.top_rated_linear.removeView(holder.text3)
                holder.top_rated_linear.removeView(holder.text2)




            }
            else if (getItem(position)?.genreIds?.size == 2){

                holder.text1.text = getItem(position)?.genreIds?.get(0)?.let { genre_ID_kontrol(it) }
                holder.text2.text = getItem(position)?.genreIds?.get(1)?.let { genre_ID_kontrol(it) }

                holder.top_rated_linear.removeView(holder.text5)
                holder.top_rated_linear.removeView(holder.text4)
                holder.top_rated_linear.removeView(holder.text3)





            }
            else if (getItem(position)?.genreIds?.size == 3){

                holder.text1.text = getItem(position)?.genreIds?.get(0)?.let { genre_ID_kontrol(it) }
                holder.text2.text = getItem(position)?.genreIds?.get(1)?.let { genre_ID_kontrol(it) }
                holder.text3.text = getItem(position)?.genreIds?.get(2)?.let { genre_ID_kontrol(it) }

                holder.top_rated_linear.removeView(holder.text5)
                holder.top_rated_linear.removeView(holder.text4)



            }
            else if (getItem(position)?.genreIds?.size == 4){

                holder.text1.text = getItem(position)?.genreIds?.get(0)?.let { genre_ID_kontrol(it) }
                holder.text2.text = getItem(position)?.genreIds?.get(1)?.let { genre_ID_kontrol(it) }
                holder.text3.text = getItem(position)?.genreIds?.get(2)?.let { genre_ID_kontrol(it) }
                holder.text4.text = getItem(position)?.genreIds?.get(3)?.let { genre_ID_kontrol(it) }
                holder.top_rated_linear.removeView(holder.text5)



            }
            else if (getItem(position)?.genreIds?.size == 5){


                holder.text1.text = getItem(position)?.genreIds?.get(0)?.let { genre_ID_kontrol(it) }
                holder.text2.text = getItem(position)?.genreIds?.get(1)?.let { genre_ID_kontrol(it) }
                holder.text3.text = getItem(position)?.genreIds?.get(2)?.let { genre_ID_kontrol(it) }
                holder.text4.text = getItem(position)?.genreIds?.get(3)?.let { genre_ID_kontrol(it) }
                holder.text5.text = getItem(position)?.genreIds?.get(4)?.let { genre_ID_kontrol(it) }
            }




        }

        holder.top_rated_Image_View.apply {

            val image_url : String = "https://image.tmdb.org/t/p/w500${getItem(position)?.posterPath}"

            Glide.with(this).load(image_url).into(this)

            println("poster path: ${image_url}")

        }

        holder.top_rated_button.setOnClickListener {


            film_ismi_global = getItem(position)?.title
            overView = getItem(position)?.overview
            orjinal_isim = getItem(position)?.originalTitle
            vizyon_tarihi_global =getItem(position)?.releaseDate
            toplam_izleyici_oyu = getItem(position)?.voteCount.toString()
            oy_ortalamasi_global = getItem(position)?.voteAverage.toString()
            orjinal_dili = getItem(position)?.originalLanguage.toString()
            global_image_url = "https://image.tmdb.org/t/p/w500${getItem(position)?.backdropPath}"



            holder.itemView.findNavController().navigate(R.id.action_top_Rated_to_film_Ayrintilari)


        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.top_rated_pager_adapter, parent, false))



    }


    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Top_Rated_Results>() {
            override fun areItemsTheSame(oldItem: Top_Rated_Results, newItem: Top_Rated_Results): Boolean =
                oldItem.adult == newItem.adult

            override fun areContentsTheSame(oldItem: Top_Rated_Results, newItem: Top_Rated_Results): Boolean =
                oldItem == newItem
        }
    }

}