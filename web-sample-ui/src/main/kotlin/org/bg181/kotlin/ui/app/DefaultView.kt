package org.bg181.kotlin.ui.app

import com.vaadin.flow.component.html.H1
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.VerticalLayout

/**
 * 默认界面
 *
 * @author lxc
 * @date 2023/03/03
 */
class DefaultView : VerticalLayout() {

    init {
        super.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER)
        super.add(H1("暂未实现，敬请期待"))
    }

}