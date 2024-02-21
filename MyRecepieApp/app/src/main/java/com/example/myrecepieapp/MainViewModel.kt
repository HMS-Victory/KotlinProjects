package com.example.myrecepieapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _categorieState=mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> =_categorieState

    init{
        fetchCategories()
    }


    private fun fetchCategories(){
        viewModelScope.launch{
            try{
                val response=recepieService.getCategories()
                _categorieState.value=_categorieState.value.copy(
                    list=response.categories,
                    loading=false,
                    error=null
                )
            }catch(error: Exception){
                _categorieState.value=_categorieState.value.copy(
                    loading=false,
                    error="Error fetching Categories ${error.message}"
                )
            }
        }
    }


    data class RecipeState(
        val loading: Boolean=true,
        val list: List<Category> =emptyList(),
        val error: String? =null
    )

}