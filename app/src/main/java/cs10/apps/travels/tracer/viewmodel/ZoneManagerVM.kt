package cs10.apps.travels.tracer.viewmodel

import android.app.Application
import androidx.lifecycle.*
import cs10.apps.travels.tracer.db.MiDB
import cs10.apps.travels.tracer.model.Zone
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ZoneManagerVM(application: Application) : AndroidViewModel(application) {

    // mis live data
    private var myZones = MutableLiveData<MutableList<Zone>>()
    private lateinit var editingZone: Zone


    fun load(miDB: MiDB, rootVM: RootVM){
        rootVM.enableLoading()

        viewModelScope.launch(Dispatchers.IO){

            // load zones
            val zones = miDB.zonesDao().getAll()

            // process zones
            zones.forEach { z ->
                val stats = miDB.zonesDao().countTravelsIn(z.x0, z.x1, z.y0, z.y1)
                z.zoneStats = stats
            }

            // post zones
            zones.sort()
            myZones.postValue(zones)

            rootVM.disableLoading()
        }
    }

    fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<MutableList<Zone>>) {
        myZones.observe(lifecycleOwner, observer)
    }

    fun selectEditing(item: Zone) {
        editingZone = item
    }
}