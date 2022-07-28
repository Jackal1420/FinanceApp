package com.example.finance

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * This is the top level class of our finance app, it allows us to use Dagger/Hilt dependency injection.
 */
@HiltAndroidApp // this annotation triggers the hilt set up for the entire app
class FinanceApp : Application()