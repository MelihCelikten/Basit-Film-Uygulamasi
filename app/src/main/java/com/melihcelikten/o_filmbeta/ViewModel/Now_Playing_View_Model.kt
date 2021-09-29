package com.melihcelikten.o_film_beta.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.melihcelikten.o_film_beta.Model.Now_Playing_Paging_Source
import com.melihcelikten.o_film_beta.Model.Now_Playing_Results
import com.melihcelikten.o_film_beta.Model.Top_Rated_Paging_Source
import com.melihcelikten.o_film_beta.Model.Top_Rated_Results
import com.melihcelikten.o_film_beta.Service.API_SERVICE
import kotlinx.coroutines.flow.Flow

class Now_Playing_View_Model : ViewModel() {

    val now_playing : Flow<PagingData<Now_Playing_Results>> = Pager(PagingConfig(pageSize = 20)) {
        Now_Playing_Paging_Source(API_SERVICE.create()) }.flow.cachedIn(viewModelScope)


}