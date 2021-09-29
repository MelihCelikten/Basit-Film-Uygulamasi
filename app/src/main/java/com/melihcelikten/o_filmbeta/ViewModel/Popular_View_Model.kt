package com.melihcelikten.o_film_beta.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.melihcelikten.o_film_beta.Model.Popular_Paging_Source
import com.melihcelikten.o_film_beta.Model.Popular_Results
import com.melihcelikten.o_film_beta.Model.Top_Rated_Paging_Source
import com.melihcelikten.o_film_beta.Model.Top_Rated_Results
import com.melihcelikten.o_film_beta.Service.API_SERVICE
import kotlinx.coroutines.flow.Flow

class Popular_View_Model : ViewModel() {




    val popular : Flow<PagingData<Popular_Results>> = Pager(PagingConfig(pageSize = 20)) {
        Popular_Paging_Source(API_SERVICE.create())}.flow.cachedIn(viewModelScope)




}