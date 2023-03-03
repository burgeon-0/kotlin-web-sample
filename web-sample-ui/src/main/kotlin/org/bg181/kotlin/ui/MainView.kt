package org.bg181.kotlin.ui

import com.vaadin.flow.component.Key
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.checkbox.Checkbox
import com.vaadin.flow.component.html.H1
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.router.Route

/**
 * 主界面
 * 
 * @author lxc
 * @date 2023/03/03
 */
@Route("")
class MainView : VerticalLayout() {

    init {
        val todosList = VerticalLayout()
        val taskField = TextField()
        val addButton = Button("Add")
        addButton.addClickListener {
            val checkbox = Checkbox(taskField.getValue())
            todosList.add(checkbox)
        }
        addButton.addClickShortcut(Key.ENTER)
        add(
            H1("Vaadin Todo"), todosList, HorizontalLayout(
                taskField,
                addButton
            )
        )
    }

}