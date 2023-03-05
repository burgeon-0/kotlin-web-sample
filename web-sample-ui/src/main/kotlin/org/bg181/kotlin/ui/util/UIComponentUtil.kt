package org.bg181.kotlin.ui.util

import com.vaadin.flow.component.html.Span
import com.vaadin.flow.component.icon.Icon
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.router.RouterLink

/**
 * UI 组件工具类
 *
 * @author lxc
 * @date 2023/03/05
 */
class UIComponentUtil {

    companion object {

        /**
         * 创建 RouterLink
         *
         * @param viewIcon
         * @param viewName
         * @return
         */
        fun createRouterLink(viewIcon: VaadinIcon, viewName: String): RouterLink {
            val icon: Icon = viewIcon.create()
            icon.getStyle().set("box-sizing", "border-box")
                .set("margin-inline-end", "var(--lumo-space-m)")
                .set("margin-inline-start", "var(--lumo-space-xs)")
                .set("padding", "var(--lumo-space-xs)")
            val link = RouterLink()
            link.add(icon, Span(viewName))
            link.tabIndex = -1
            return link
        }

    }

}