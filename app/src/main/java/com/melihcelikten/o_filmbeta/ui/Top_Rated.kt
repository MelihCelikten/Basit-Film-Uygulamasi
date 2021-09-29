package com.melihcelikten.o_filmbeta.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.melihcelikten.o_filmbeta.Adapter.Top_Rated_Paging_Adapter
import com.melihcelikten.o_film_beta.ViewModel.Top_Rated_View_Model
import com.melihcelikten.o_filmbeta.R
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class Top_Rated : Fragment() {

    lateinit var pagingDataAdapter : Top_Rated_Paging_Adapter
    lateinit var top_rated_ViewModel : Top_Rated_View_Model
    lateinit var recyclerView : RecyclerView
    lateinit var progressBar: ProgressBar


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top__rated, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        top_rated_ViewModel = ViewModelProvider(this).get(Top_Rated_View_Model::class.java)
        recyclerView = view.findViewById(R.id.recyclerView_top_rated)
        progressBar = view.findViewById(R.id.progressBar_top_rated)
        progressBar.isVisible = false
        pagingDataAdapter = Top_Rated_Paging_Adapter()

        recyclerView.apply {

            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = pagingDataAdapter




        }

        viewLifecycleOwner.lifecycleScope.launch{ top_rated_ViewModel.top_rated.collectLatest { pagingDataAdapter.submitData(it)} }



        pagingDataAdapter.addLoadStateListener { loadState ->

            if (loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading)

                progressBar.isVisible = true
            // Show ProgressBar
            else {
                progressBar.isVisible = false

                // If we have an error, show a toast
                val errorState = when {
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.prepend is LoadState.Error ->  loadState.prepend as LoadState.Error
                    loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                    else -> null
                }
                errorState?.let {
                    Toast.makeText(view.context, it.error.localizedMessage, Toast.LENGTH_LONG).show()
                }

            }
        }




    }
}