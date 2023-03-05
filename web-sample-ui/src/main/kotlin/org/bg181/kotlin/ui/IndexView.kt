package org.bg181.kotlin.ui

import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.ComponentUtil
import com.vaadin.flow.component.applayout.AppLayout
import com.vaadin.flow.component.applayout.DrawerToggle
import com.vaadin.flow.component.html.H1
import com.vaadin.flow.component.html.Span
import com.vaadin.flow.component.icon.Icon
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.component.tabs.Tab
import com.vaadin.flow.component.tabs.Tabs
import com.vaadin.flow.router.Route
import com.vaadin.flow.router.RouterLink
import org.bg181.kotlin.ui.app.DefaultView
import org.bg181.kotlin.ui.app.TodoView
import org.bg181.kotlin.ui.util.UIComponentUtil

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
        title.style.set("font-size", "var(--lumo-font-size-l)")
            .set("margin", "0")

        val tabs = getTabs()
        super.addToDrawer(tabs)
        super.addToNavbar(toggle, title)

        super.setContent(TodoView())
    }

    private fun getTabs(): Tabs {
        val tabs = Tabs()
        tabs.add(
            createTab(VaadinIcon.PIN_POST, "待办", TodoView()),
            createTab(VaadinIcon.CALENDAR_O, "日历", DefaultView())
        )
        tabs.orientation = Tabs.Orientation.VERTICAL
        return tabs
    }

    private fun createTab(viewIcon: VaadinIcon, viewName: String, component: Component): Tab {
        val tab = Tab(UIComponentUtil.createRouterLink(viewIcon, viewName))
        ComponentUtil.addListener<ClickEvent<*>>(
            tab, ClickEvent::class.java, {
                super.setContent(component)
            }
        )
        return tab
    }

}