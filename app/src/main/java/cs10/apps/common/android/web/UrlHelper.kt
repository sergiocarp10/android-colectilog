package cs10.apps.common.android.web

class UrlHelper {

    companion object {

        fun buildUrl(baseUrl: String, action: String, params: Set<UrlParam>) : String {
            val stringBuilder = StringBuilder(baseUrl)
            stringBuilder.append('/').append(action).append('?')

            for ((index, p) in params.withIndex()){
                stringBuilder.append(p.name).append('=').append(p.value)
                if (index + 1 < params.size) stringBuilder.append('&')
            }

            return stringBuilder.toString()
        }
    }
}