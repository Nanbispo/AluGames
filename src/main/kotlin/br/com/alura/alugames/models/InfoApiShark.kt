package org.example.br.com.alura.alugames.models
data class InfoApiShark(val title:String, val thumb:String){
    override fun toString(): String {
        return "Info: (title: $title , thumb: $thumb)"
    }
}
