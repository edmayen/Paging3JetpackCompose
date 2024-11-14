package com.example.paging3jetpackcompose.ui.ricklist

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.paging3jetpackcompose.data.repository.RickRepository
import com.example.paging3jetpackcompose.domain.model.CharacterModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RickListViewModel @Inject constructor(rickRepository: RickRepository): ViewModel() {

    val characters : Flow<PagingData<CharacterModel>> = rickRepository.getAllCharacters()
}