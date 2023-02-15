package cs10.apps.travels.tracer.message

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import cs10.apps.common.android.web.UrlHelper
import cs10.apps.common.android.web.UrlParam

class WhatsAppApi {
    private val packageName = "com.whatsapp"
    private val baseUrl = "https://api.whatsapp.com"
    private val actionSend = "send"

    fun isAppInstalled(context: Context) : Boolean {
        try {
            context.packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
        } catch (e: PackageManager.NameNotFoundException){
            return false
        }

        return true
    }

    fun sendMessageToPerson(context: Context, message: String, phoneNumber: String){
        val content = UrlHelper.buildUrl(baseUrl, actionSend, setOf(
            UrlParam("phone", phoneNumber),
            UrlParam("text", message)
        ))

        openAppIntent(context, content)
    }

    fun sendMessageToGroup(context: Context, message: String, groupId: String){
        throw RuntimeException("Not supported yet")
    }

    private fun openAppIntent(context: Context, url: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }

}