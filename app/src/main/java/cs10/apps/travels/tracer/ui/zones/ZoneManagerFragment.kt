package cs10.apps.travels.tracer.ui.zones

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cs10.apps.common.android.ui.CS_Fragment
import cs10.apps.travels.tracer.adapter.ZoneManagerAdapter
import cs10.apps.travels.tracer.databinding.FragmentManageZonesBinding
import cs10.apps.travels.tracer.model.Zone
import cs10.apps.travels.tracer.viewmodel.RootVM
import cs10.apps.travels.tracer.viewmodel.ZoneManagerVM

class ZoneManagerFragment : CS_Fragment() {
    private lateinit var binding: FragmentManageZonesBinding
    private lateinit var rootVM: RootVM
    private lateinit var zoneManagerVM: ZoneManagerVM
    private var autoOpened = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentManageZonesBinding.inflate(inflater, container, false)

        // instanciar view models
        rootVM = ViewModelProvider(requireActivity())[RootVM::class.java]
        zoneManagerVM = ViewModelProvider(requireActivity())[ZoneManagerVM::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ZoneManagerAdapter(listOf()) { zone -> onZoneClick(zone) }
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())

        zoneManagerVM.observe(viewLifecycleOwner) { list ->
            adapter.list = list
            adapter.notifyDataSetChanged()

            if (list.isEmpty() && !autoOpened){
                val intent = Intent(requireActivity(), ZoneCreator::class.java)
                Handler(Looper.getMainLooper()).postDelayed({startActivity(intent)}, 200)
                autoOpened = true
            }
        }

        rootVM.loading.observe(viewLifecycleOwner) {
            binding.root.isVisible = !it
        }
    }

    override fun onResume() {
        super.onResume()

        // reload
        zoneManagerVM.load(rootVM.database, rootVM)
    }

    private fun onZoneClick(item: Zone){
        zoneManagerVM.selectEditing(item)

        /*
        val intent = Intent(requireActivity(), LineDetail::class.java)
        intent.putExtra("number", customBusLine.number)
        startActivity(intent)

         */
    }

}