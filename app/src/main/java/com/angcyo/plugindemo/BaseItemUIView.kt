package com.angcyo.plugindemo

import com.angcyo.uiview.base.SingleItem
import com.angcyo.uiview.base.UIItemUIView

/**
 * Created by angcyo on 2018/04/01 19:41
 */

abstract class BaseItemUIView : UIItemUIView<SingleItem>() {
    override fun getTitleString(): String {
        return "InBaseItem...$isInPlugin"
    }
}