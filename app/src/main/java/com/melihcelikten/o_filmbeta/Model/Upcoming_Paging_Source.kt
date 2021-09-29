package com.melihcelikten.o_film_beta.Model

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.melihcelikten.o_film_beta.Service.API_SERVICE
import okio.IOException
import retrofit2.HttpException


var Upcoming_Baslangic_Sayfasi : Int = 1






class Upcoming_Paging_Source(
    private var service: API_SERVICE
    //private var nextKey : Int? = null

) : PagingSource<Int, Upcoming_Results>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Upcoming_Results> {
        val position = params.key ?: Upcoming_Baslangic_Sayfasi
        return try {
            val response = service.Upcoming_Example_Sorgu("language",position)
            val repos = response.results
            LoadResult.Page(
                data = repos,
                prevKey = if (position == Upcoming_Baslangic_Sayfasi) null else position - 1,
                nextKey = position + 1

            )
        } catch (exception: IOException) {


            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }



    }

    override  fun getRefreshKey(state: PagingState<Int, Upcoming_Results>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }














}