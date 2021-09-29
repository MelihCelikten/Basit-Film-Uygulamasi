package com.melihcelikten.o_film_beta.Model

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.melihcelikten.o_film_beta.Service.API_SERVICE
import okio.IOException
import retrofit2.HttpException




var Popular_Baslangic_Sayfasi : Int = 1


class Popular_Paging_Source(
    private var service: API_SERVICE

) : PagingSource<Int, Popular_Results>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Popular_Results> {
        val position = params.key ?: Popular_Baslangic_Sayfasi
        return try {
            val response = service.Popular_Example_Sorgu("language",position)
            val repos = response.results
            LoadResult.Page(
                data = repos,
                prevKey = if (position == Popular_Baslangic_Sayfasi) null else position - 1,
                nextKey = position + 1

            )
        } catch (exception: IOException) {


            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }



    }

    override  fun getRefreshKey(state: PagingState<Int, Popular_Results>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }














}