package org.bg181.kotlin.ui.app

import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.ComponentUtil
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.html.Span
import com.vaadin.flow.component.icon.Icon
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.component.orderedlayout.FlexLayout
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.tabs.Tab
import com.vaadin.flow.component.tabs.Tabs
import com.vaadin.flow.router.RouterLink
import org.bg181.kotlin.ui.util.UIComponentUtil

/**
 * 待办界面
 *
 * @author lxc
 * @date 2023/03/05
 */
class TodoView : FlexLayout() {

    private var leftPanel: Div? = null
    private var mainPanel: Div? = null

    init {
        super.getStyle().set("height", "100%")
        leftPanel = getLeftPanel()
        mainPanel = getMainPanle()
        super.add(leftPanel)
        super.add(mainPanel)
    }

    private fun getLeftPanel(): Div {
        val panel = Div()
        panel.getStyle().set("margin", "0")
            .set("padding", "0")
            .set("min-width", "16em")
        panel.add(getTabs())

        val div = Div()
        div.add("xxx")
        div.style.set("border-top", "1px solid var(--lumo-contrast-10pct)")
        panel.add(div)
        return panel
    }

    private fun getMainPanle(): Div {
        val panel = Div()
        panel.style.set("border-left", "1px solid var(--lumo-contrast-10pct)")
            .set("width", "100%")
            .set("min-width", "32em")
        panel.add(DefaultView())
        return panel
    }

    private fun getTabs(): Tabs {
        val tabs = Tabs()
        tabs.add(
            createTab(VaadinIcon.CLOCK, "今天"),
            createTab(VaadinIcon.MODAL_LIST, "近七天"),
            createTab(VaadinIcon.CHECK_SQUARE_O, "已完成"),
            createTab(VaadinIcon.BRIEFCASE, "收纳盒")
        )
        tabs.orientation = Tabs.Orientation.VERTICAL
        return tabs
    }

    private fun createTab(viewIcon: VaadinIcon, viewName: String): Tab {
        return Tab(UIComponentUtil.createRouterLink(viewIcon, viewName))
    }

}