package org.bg181.kotlin.ui

import com.vaadin.flow.component.applayout.AppLayout
import com.vaadin.flow.component.applayout.DrawerToggle
import com.vaadin.flow.component.html.H1
import com.vaadin.flow.component.tabs.Tab
import com.vaadin.flow.component.tabs.Tabs
import com.vaadin.flow.router.Route

/**
 * 首页
 *
 * @author lxc
 * @date 2023/03/04
 */
@Route("/index")
class IndexView : AppLayout() {

    init {
        val toggle = DrawerToggle()
        val title = H1("我的应用")
        title.style.set("font-size", "var(--lumo-font-size-l)")["margin"] = "0"
        val tabs: Tabs = getTabs()
        addToDrawer(tabs)
        addToNavbar(toggle, title)
    }

    private fun getTabs(): Tabs {
        return Tabs(Tab("待办"), Tab("日历"))
    }

}