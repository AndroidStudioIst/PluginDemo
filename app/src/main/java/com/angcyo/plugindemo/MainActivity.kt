package com.angcyo.plugindemo

import android.content.Intent
import com.angcyo.uiview.base.UILayoutActivity

class MainActivity : UILayoutActivity() {
    override fun onLoadView(intent: Intent?) {
        startIView(MainUIView())
    }
}
