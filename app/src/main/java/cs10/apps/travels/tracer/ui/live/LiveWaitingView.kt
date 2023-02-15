package cs10.apps.travels.tracer.ui.live

import android.content.Context
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.preference.PreferenceManager
import cs10.apps.common.android.Emoji
import cs10.apps.travels.tracer.R
import cs10.apps.travels.tracer.databinding.ContentLiveWaitingBinding
import cs10.apps.travels.tracer.message.WhatsAppApi
import cs10.apps.travels.tracer.model.Parada

class LiveWaitingView(private val binding: ContentLiveWaitingBinding) {
    private var expanded = false
    private var enabled = false

    private val whatsAppApi = WhatsAppApi()

    // TODO: replace with user preferences
    private val prefs = PreferenceManager.getDefaultSharedPreferences(getContext())
    private val testPhoneNumber = "+5492216146436"

    init {
        disableAnimation()
        setupShareButton()
    }

    private fun setupShareButton() {
        binding.shareWaitingBtn.setOnClickListener {
            if (whatsAppApi.isAppInstalled(getContext())){
                val message = Emoji.getBusEmoji() + " - " + binding.currentStopTv.text.toString()
                val person1 = prefs.getString("dest_no1", testPhoneNumber)
                whatsAppApi.sendMessageToPerson(getContext(), message, person1!!)
            } else {
                Toast.makeText(getContext(), "App is not installed!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getContext() : Context {
        return binding.root.context
    }

    private fun animateButton(){
        if (expanded) animateReduceButton()
        else animateExpandButton()
    }

    private fun animateExpandButton(){
        binding.circularCard.animate()
            .scaleX(1.15f)
            .scaleY(1.15f)
            .setDuration(1000)
            .withEndAction {
                expanded = true
                if (enabled) animateReduceButton()
            }.start()
    }

    private fun animateReduceButton(){
        binding.circularCard.animate()
            .scaleX(0.8f)
            .scaleY(0.8f)
            .setDuration(1000)
            .withEndAction {
                expanded = false
                if (enabled) animateExpandButton()
            }.start()
    }

    fun hide(){
        binding.root.isVisible = false
    }

    fun show(){
        binding.root.isVisible = true
    }

    fun setVisibility(b: Boolean) {
        if (b) show()
        else hide()
    }

    fun setStopHere(stopHere: Parada?){
        when (stopHere) {
            null -> {
                binding.currentStopTv.text = null
                binding.shareWaitingBtn.isVisible = false
                disableAnimation()
            } else -> {
                binding.currentStopTv.text = "Esperando en ${stopHere.nombre}"
                binding.shareWaitingBtn.isVisible = true
                enableAnimation()
            }
        }
    }

    private fun disableAnimation(){
        enabled = false
        binding.circularCard.setCardBackgroundColor(ContextCompat.getColor(
            binding.root.context, android.R.color.darker_gray))
    }

    private fun enableAnimation(){
        if (!enabled){
            enabled = true
            binding.circularCard.setCardBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.bus))
            animateButton()
        }
    }

    fun isVisible() : Boolean {
        return binding.root.isVisible
    }
}