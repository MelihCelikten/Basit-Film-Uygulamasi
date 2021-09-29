package com.melihcelikten.o_filmbeta.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.melihcelikten.o_film_beta.Adapter.Now_Playing_Paging_Adapter
import com.melihcelikten.o_film_beta.ViewModel.Now_Playing_View_Model
import com.melihcelikten.o_filmbeta.R
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class Now_Playing : Fragment() {

    lateinit var pagingDataAdapter : Now_Playing_Paging_Adapter
    lateinit var nowPlayingViewModel : Now_Playing_View_Model
    lateinit var recyclerView : RecyclerView
    lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_now__playing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        nowPlayingViewModel = ViewModelProvider(this).get(Now_Playing_View_Model::class.java)
        recyclerView = view.findViewById(R.id.recyclerView_now_playing)
        progressBar = view.findViewById(R.id.progressBar_now_playing)
        progressBar.isVisible = false
        pagingDataAdapter = Now_Playing_Paging_Adapter()


        recyclerView.apply {

            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = pagingDataAdapter




        }

        viewLifecycleOwner.lifecycleScope.launch{ nowPlayingViewModel.now_playing.collectLatest { pagingDataAdapter.submitData(it)} }




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