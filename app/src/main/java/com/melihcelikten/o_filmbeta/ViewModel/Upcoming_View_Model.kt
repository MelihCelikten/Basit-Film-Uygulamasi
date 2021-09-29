package com.melihcelikten.o_film_beta.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.melihcelikten.o_film_beta.Model.Popular_Paging_Source
import com.melihcelikten.o_film_beta.Model.Popular_Results
import com.melihcelikten.o_film_beta.Model.Upcoming_Paging_Source
import com.melihcelikten.o_film_beta.Model.Upcoming_Results
import com.melihcelikten.o_film_beta.Service.API_SERVICE
import kotlinx.coroutines.flow.Flow

class Upcoming_View_Model : ViewModel() {




    val upcoming : Flow<PagingData<Upcoming_Results>> = Pager(PagingConfig(pageSize = 20)) {
        Upcoming_Paging_Source(API_SERVICE.create())
    }.flow.cachedIn(viewModelScope)






}