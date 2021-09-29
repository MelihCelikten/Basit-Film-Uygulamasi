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

class Popular_Paging_Adapter : PagingDataAdapter<Popular_Results, Popular_Paging_Adapter.ViewHolder>(
    COMPARATOR
){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        var pager_button = view.findViewById<Button>(R.id.button_popular)
        var title_text = view.findViewById<TextView>(R.id.popular_title)
        var vote_count_text = view.findViewById<TextView>(R.id.popular_oy_ortalamasi)
        var pagerAdapterImageView= view.findViewById<ImageView>(R.id.popular_Image_View)
        var linear3 = view.findViewById<LinearLayout>(R.id.popular_linear_2)

        var text1 = view.findViewById<TextView>(R.id.birinciKonuBasligi_popular)
        var text2 = view.findViewById<TextView>(R.id.ikinciKonuBasligi_popular)
        var text3 = view.findViewById<TextView>(R.id.ucuncuKonuBasligi_popular)
        var text4 = view.findViewById<TextView>(R.id.dorduncuKonuBasligi_popular)
        var text5 = view.findViewById<TextView>(R.id.besinciKonuBasligi_popular)



    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.title_text.text = getItem(position)?.title
        holder.vote_count_text.text = "Ortalama Puan : ${getItem(position)?.voteAverage.toString()}"



        getItem(position).apply {


            if (getItem(position)?.genreIds?.size == 1){

                holder.text1.text = getItem(position)?.genreIds?.get(0)?.let { genre_ID_kontrol(it) }
                holder.linear3.removeView(holder.text5)
                holder.linear3.removeView(holder.text4)
                holder.linear3.removeView(holder.text3)
                holder.linear3.removeView(holder.text2)




            }
            else if (getItem(position)?.genreIds?.size == 2){

                holder.text1.text = getItem(position)?.genreIds?.get(0)?.let { genre_ID_kontrol(it) }
                holder.text2.text = getItem(position)?.genreIds?.get(1)?.let { genre_ID_kontrol(it) }

                holder.linear3.removeView(holder.text5)
                holder.linear3.removeView(holder.text4)
                holder.linear3.removeView(holder.text3)





            }
            else if (getItem(position)?.genreIds?.size == 3){

                holder.text1.text = getItem(position)?.genreIds?.get(0)?.let { genre_ID_kontrol(it) }
                holder.text2.text = getItem(position)?.genreIds?.get(1)?.let { genre_ID_kontrol(it) }
                holder.text3.text = getItem(position)?.genreIds?.get(2)?.let { genre_ID_kontrol(it) }

                holder.linear3.removeView(holder.text5)
                holder.linear3.removeView(holder.text4)



            }
            else if (getItem(position)?.genreIds?.size == 4){

                holder.text1.text = getItem(position)?.genreIds?.get(0)?.let { genre_ID_kontrol(it) }
                holder.text2.text = getItem(position)?.genreIds?.get(1)?.let { genre_ID_kontrol(it) }
                holder.text3.text = getItem(position)?.genreIds?.get(2)?.let { genre_ID_kontrol(it) }
                holder.text4.text = getItem(position)?.genreIds?.get(3)?.let { genre_ID_kontrol(it) }
                holder.linear3.removeView(holder.text5)



            }
            else if (getItem(position)?.genreIds?.size == 5){


                holder.text1.text = getItem(position)?.genreIds?.get(0)?.let { genre_ID_kontrol(it) }
                holder.text2.text = getItem(position)?.genreIds?.get(1)?.let { genre_ID_kontrol(it) }
                holder.text3.text = getItem(position)?.genreIds?.get(2)?.let { genre_ID_kontrol(it) }
                holder.text4.text = getItem(position)?.genreIds?.get(3)?.let { genre_ID_kontrol(it) }
                holder.text5.text = getItem(position)?.genreIds?.get(4)?.let { genre_ID_kontrol(it) }
            }




        }

        holder.pagerAdapterImageView.apply {

            var image_url : String = "https://image.tmdb.org/t/p/w500${getItem(position)?.posterPath}"

            Glide.with(this).load(image_url).into(this)

            println("poster path: ${image_url}")

        }


        holder.pager_button.setOnClickListener {


            film_ismi_global = getItem(position)?.title
            overView = getItem(position)?.overview
            orjinal_isim = getItem(position)?.originalTitle
            vizyon_tarihi_global =getItem(position)?.releaseDate
            toplam_izleyici_oyu = getItem(position)?.voteCount.toString()
            oy_ortalamasi_global = getItem(position)?.voteAverage.toString()
            orjinal_dili = getItem(position)?.originalLanguage.toString()
            global_image_url = "https://image.tmdb.org/t/p/w500${getItem(position)?.backdropPath}"


            holder.itemView.findNavController().navigate(R.id.action_popular_to_film_Ayrintilari)




        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.popular_paging_adapter, parent, false))



    }

    companion object {

        private val COMPARATOR = object : DiffUtil.ItemCallback<Popular_Results>() {
            override fun areItemsTheSame(oldItem: Popular_Results, newItem: Popular_Results): Boolean =
                oldItem.adult == newItem.adult

            override fun areContentsTheSame(oldItem: Popular_Results, newItem: Popular_Results): Boolean =
                oldItem == newItem
        }


    }

    }