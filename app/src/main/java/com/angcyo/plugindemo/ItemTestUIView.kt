package com.angcyo.plugindemo

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.angcyo.library.utils.L
import com.angcyo.uiview.base.Item
import com.angcyo.uiview.base.SingleItem
import com.angcyo.uiview.base.UIItemUIView.baseInitItem
import com.angcyo.uiview.dialog.UILoading
import com.angcyo.uiview.recycler.RBaseViewHolder
import com.angcyo.uiview.utils.T_

/**
 * Created by angcyo on 2018/04/01 19:41
 */
class ItemTestUIView : BaseItemUIView() {
    override fun createItems(items: MutableList<SingleItem>) {
        items.add(object : SingleItem() {
            override fun onBindView(holder: RBaseViewHolder, posInData: Int, dataBean: Item?) {
                baseInitItem(holder, "TestItem....11...$isInPlugin") {
                    val tip = if (isInPlugin) {
                        mPluginPackage.getString(R.string.app_name2)
                    } else {
                        "no"
                    }
                    UILoading.flow(mParentILayout).setLoadingTipText("插件点击...$tip")
                }
            }
        })

        items.add(object : SingleItem() {
            override fun onBindView(holder: RBaseViewHolder, posInData: Int, dataBean: Item?) {

            }

            override fun getItemLayoutId(): Int {
                L.e("Plugin: call: getItemLayoutId -> ")
                return R.layout.item_test
            }

            override fun createItemView(parent: ViewGroup?, viewType: Int): View? {
                return if (isInPlugin) {
                    L.e("Plugin: call: createItemView -> ")
                    TextView(mActivity).apply {
                        text = "动态创建的TextView"
                        setBackgroundColor(Color.RED)
                        parent?.addView(this, ViewGroup.LayoutParams(-2, -2))

                        T_.info("创建Item in $parent")
                    }
                } else {
                    null
                }
            }
        })

        items.add(object : SingleItem() {
            override fun onBindView(holder: RBaseViewHolder, posInData: Int, dataBean: Item?) {

            }

            override fun getItemLayoutId(): Int {
                return R.layout.item_test
            }

            override fun createItemView(parent: ViewGroup?, viewType: Int): View? {
                return if (isInPlugin) {
                    mPluginPackage.inflate(mActivity, R.layout.item_test, parent)
                } else {
                    null
                }
            }
        })

        items.add(object : SingleItem() {
            override fun onBindView(holder: RBaseViewHolder, posInData: Int, dataBean: Item?) {
                baseInitItem(holder, "TestItem........") {
                    UILoading.progress(mParentILayout).setLoadingTipText("插件点击...${getString(R.string.app_name)}")
                }
            }
        })
    }

}