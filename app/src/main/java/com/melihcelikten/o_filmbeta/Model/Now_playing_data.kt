package com.melihcelikten.o_film_beta.Model

import com.google.gson.annotations.SerializedName


data class Now_Playing_Example(

    @SerializedName("dates")
    var dates : Now_Playing_Dates,
    @SerializedName("page")
    var page : Int,
    @SerializedName("results")
    var results : List<Now_Playing_Results>,
    @SerializedName("total_pages")
    var totalPages : Int,
    @SerializedName("total_results")
    var totalResults : Int

)

data class Now_Playing_Dates(

    @SerializedName("maximum")
    var maximum : String,
    @SerializedName("minimum")
    var minimum : String

)

data class Now_Playing_Results(

    @SerializedName("adult") var adult : Boolean,
    @SerializedName("backdrop_path") var backdropPath : String,
    @SerializedName("genre_ids") var genreIds : List<Int>,
    @SerializedName("id") var id : Int,
    @SerializedName("original_language") var originalLanguage : String,
    @SerializedName("original_title") var originalTitle : String,
    @SerializedName("overview") var overview : String,
    @SerializedName("popularity") var popularity : Double,
    @SerializedName("poster_path") var posterPath : String,
    @SerializedName("release_date") var releaseDate : String,
    @SerializedName("title") var title : String,
    @SerializedName("video") var video : Boolean,
    @SerializedName("vote_average") var voteAverage : Double,
    @SerializedName("vote_count") var voteCount : Int

)








/*


if (size != null){

    if ((size.size - 1) == 0 ){ println("${size.get(0)}") }
    else if ((size.size - 2) == 0 ){

        println("${size.get(0)}")
        println("${size.get(1)}")


    }
    else if ((size.size - 3) == 0 ){

        println("${size.get(0)}")
        println("${size.get(1)}")
        println("${size.get(2)}")

    }
    else if ((size.size - 4) == 0 ){

        println("${size.get(0)}")
        println("${size.get(1)}")
        println("${size.get(2)}")
        println("${size.get(3)}")

    }
    else if ((size.size - 5) == 0 ){

        println("${size.get(0)}")
        println("${size.get(1)}")
        println("${size.get(2)}")
        println("${size.get(3)}")
        println("${size.get(4)}")

    }
    else if ((size.size - 6) == 0 ){

        println("${size.get(0)}")
        println("${size.get(1)}")
        println("${size.get(2)}")
        println("${size.get(3)}")
        println("${size.get(4)}")
        println("${size.get(5)}")

    }
    else if ((size.size - 7) == 0 ){

        println("${size.get(0)}")
        println("${size.get(1)}")
        println("${size.get(2)}")
        println("${size.get(3)}")
        println("${size.get(4)}")
        println("${size.get(5)}")
        println("${size.get(6)}")

    }

}
fun genre_ID_list(size: List <Int?>) :String {


    when {
        (size.size - 1) == 0 -> {

            if (size.get(0) == 28){ }
            else if (size.get(0) == 28){ }
            else if (size.get(0) == 28){ }
            else if (size.get(0) == 28){ }
            else if (size.get(0) == 28){ }
            else if (size.get(0) == 28){ }
            else if (size.get(0) == 28){ }
            else if (size.get(0) == 28){ }
            else if (size.get(0) == 28){ }
            if (size.get(0) == 28){ }
            if (size.get(0) == 28){ }





            println("${size.get(0)}")




        }




        (size.size - 2) == 0 -> {

            println("${size.get(0)}")
            println("${size.get(1)}")


        }
        (size.size - 3) == 0 -> {

            println("${size.get(0)}")
            println("${size.get(1)}")
            println("${size.get(2)}")

        }
        (size.size - 4) == 0 -> {

            println("${size.get(0)}")
            println("${size.get(1)}")
            println("${size.get(2)}")
            println("${size.get(3)}")

        }
        (size.size - 5) == 0 -> {

            println("${size.get(0)}")
            println("${size.get(1)}")
            println("${size.get(2)}")
            println("${size.get(3)}")
            println("${size.get(4)}")

        }
        (size.size - 6) == 0 -> {

            println("${size.get(0)}")
            println("${size.get(1)}")
            println("${size.get(2)}")
            println("${size.get(3)}")
            println("${size.get(4)}")
            println("${size.get(5)}")

        }
        (size.size - 7) == 0 -> {

            println("${size.get(0)}")
            println("${size.get(1)}")
            println("${size.get(2)}")
            println("${size.get(3)}")
            println("${size.get(4)}")
            println("${size.get(5)}")
            println("${size.get(6)}")

        }
    }



}



 */