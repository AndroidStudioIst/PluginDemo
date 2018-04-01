package com.angcyo.plugindemo

import android.view.LayoutInflater
import com.angcyo.uiview.base.UIContentView
import com.angcyo.uiview.container.ContentLayout

/**
 * Created by angcyo on 2018/04/01 19:01
 */
class MainUIViewId : UIContentView() {

    override fun getTitleString(): String {
        return "UseId:$isInPlugin"
    }

    override fun inflateContentLayout(baseContentLayout: ContentLayout, inflater: LayoutInflater) {
        if (isInPlugin) {
            mPluginPackage.inflate(mActivity, R.layout.activity_main, baseContentLayout)
        } else {
            inflate(R.layout.activity_main)
        }
    }

}