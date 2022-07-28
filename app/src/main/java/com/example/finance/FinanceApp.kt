package com.example.finance

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp // this annotation triggers the hilt set up for the entire app
class FinanceApp : Application()