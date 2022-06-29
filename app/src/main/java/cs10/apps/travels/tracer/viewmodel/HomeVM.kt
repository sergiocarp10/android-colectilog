package cs10.apps.travels.tracer.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cs10.apps.travels.tracer.model.Parada

class HomeVM : ViewModel() {

    val maxDistance = MutableLiveData<Double>()
    val favoriteStops = MutableLiveData<List<Parada>>()

    fun getStop(pos: Int) : Parada {
        if (favoriteStops.value == null) return Parada()
        return favoriteStops.value!![pos]
    }
}