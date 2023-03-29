package com.vunh.demobottomnav.utils

const val DEVICE_TYPE = 1 /* ANDROID */

const val PACKAGE_NAME = "com.nttdata.wms.ls2"
const val PREFERENCE_NAME = "ls2_preference"
const val KEY_FIRST_BOOT = "first_boot"
const val KEY_DONT_SHOW_UPDATE_VERSION = "dont_show_update_version"
const val KEY_OAUTH_TOKEN = "oauth_token"
const val KEY_CURRENT_LANGUAGE = "current_language"

annotation class INTENT_KEY {
    companion object {
        var EXTRA_EMAIL = "put_email"
    }
}

annotation class TIME_DELAY {
    companion object {
        var TIME_SPLASH = 20
    }
}

annotation class HTTP_CODE {
    companion object {
        val SUCCESS = "200"
        val CREATE_SUCCESS = "201"
        val AUTHENTICATION_ERROR = "401"
        val NOT_FOUND_ERROR = "404"
        val FORBIDDEN_ERROR = "403"
        val SERVER_ERROR = "500"
    }
}

annotation class LANGUAGE {
    companion object {
        val JAPANESE = "ja"
        val VIETNAMESE = "vi"
        val ENGLISH = "en"
    }
}

annotation class SETTINGS {
    companion object {
        val SETTINGS_APP = "setting_app"
        val SETTINGS_LANGUAGE = "setting_language"
        val SETTINGS_MANUAL_INPUT = "setting_manual_input"
        val SETTINGS_ENABLE_OFFLINE = "setting_enable_offline"
        val SETTINGS_GET_LAST_VERSION = "setting_get_last_version"
        val SETTINGS_SYNC_DATA_LOCAL = "setting_sync_data_local"
    }
}

annotation class DATE_TYPE {
    companion object {
        var DATE = "dd/MM/yyyy"
        var DATETIME = "dd/MM/yyyy hh:mm:ss"
    }
}
