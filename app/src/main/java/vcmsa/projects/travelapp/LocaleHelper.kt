package vcmsa.projects.travelapp

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import java.util.*

object LocaleHelper {

    fun applyLocale(context: Context): Context {
        val prefs: SharedPreferences =
            context.getSharedPreferences("user_settings", Context.MODE_PRIVATE)
        val lang = prefs.getString("language", "en") ?: "en"

        val locale = Locale(lang)
        Locale.setDefault(locale)

        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)

        return context.createConfigurationContext(config)
    }
}
