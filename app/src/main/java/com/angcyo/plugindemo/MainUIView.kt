package com.angcyo.plugindemo

import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import com.angcyo.uiview.base.UIContentView
import com.angcyo.uiview.container.ContentLayout
import com.angcyo.uiview.model.TitleBarPattern

/**
 * Created by angcyo on 2018/04/01 19:01
 */
class MainUIView : UIContentView() {

    override fun getTitleBar(): TitleBarPattern {
        return super.getTitleBar()
                .setOnTitleDoubleTapListener {
                    startIView(MainUIViewId())
                }
    }

    override fun getTitleString(): String {
        return "Hello In Plugin"
    }

    override fun inflateContentLayout(baseContentLayout: ContentLayout, inflater: LayoutInflater) {
        TextView(mActivity).apply {
            text = "动态创建的TextView"
            setBackgroundColor(Color.RED)
            baseContentLayout.addView(this, FrameLayout.LayoutParams(-2, -2).apply {
                gravity = Gravity.CENTER
            })
        }
    }

}