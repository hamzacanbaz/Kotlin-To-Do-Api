package com.example.kotlincoroutinesexample.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincoroutinesexample.R
import com.example.kotlincoroutinesexample.adapter.RecyclerViewAdapter
import com.example.kotlincoroutinesexample.model.TodoModel
import com.example.kotlincoroutinesexample.service.TodoApi
import kotlinx.android.synthetic.main.fragment_to_do_list.*
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class ToDoList : Fragment(), RecyclerViewAdapter.Listener {

    private val BASE_URL = "https://api.mocki.io/v1/"
    private var job : Job? = null
    private var todoModels : ArrayList<TodoModel>? = null
    private var recyclerViewAdapter : RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()



    }
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Error: ${throwable.localizedMessage}")
    }

    private fun loadData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TodoApi::class.java)

        job = CoroutineScope(Dispatchers.IO + exceptionHandler ).launch {
            val response = retrofit.getData()
//            println(response)

            withContext(Dispatchers.Main){
//                println(response.body()?.get(1))


                if (response.isSuccessful){
                    response.body()?.let { it ->
                        todoModels = ArrayList(it)
                        todoModels?.let {
                            //  recycler view
//                            println("basarili geldi")
                            recyclerViewAdapter = RecyclerViewAdapter(it,this@ToDoList)
                            recyclerView.adapter = recyclerViewAdapter

                        }
                    }
                }
            }
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        println("geldi")

        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager



    }

    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()
    }

    override fun onItemClick(todoModel: TodoModel) {
//        println("clicked")
        val direction = ToDoListDirections.actionToDoListToDetailFragment(todoModel.title,todoModel.description)
        findNavController().navigate(direction)
    }


}