package com.example.scaler_task.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.scaler_task.pojo.Resource
import com.example.scaler_task.pojo.VideosList
import com.example.scaler_task.repository.MainRepository
import kotlinx.coroutines.Dispatchers


const val pageSize = 5

class MainViewModel
@ViewModelInject
constructor(private val mainRepository: MainRepository) : ViewModel() {
    var videoList: VideosList = VideosList(null)

    fun getVideoList() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(
                Resource.success(
                    data = mainRepository.getVideoList(pageSize)
                )
            )

        } catch (exception: Exception) {
            emit(Resource.error(exception.message ?: "Error Occurred!", data = null))
        }
    }
}