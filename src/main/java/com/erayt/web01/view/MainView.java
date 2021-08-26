package com.erayt.web01.view;


import com.erayt.web01.configuration.Person03Editor;
import com.erayt.web01.domain.Customer;
import com.erayt.web01.domain.Person03;
import com.erayt.web01.repository.CustomerRepository;
import com.erayt.web01.repository.Person03Repository02;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.apache.commons.lang3.StringUtils;

/**
 * @Auther: Z151
 * @Date: 2021/8/26 14:19
 */
@Route
public class MainView extends VerticalLayout  {

    private final Person03Repository02 person03Repository02;

    private final Person03Editor editor;

    final Grid<Person03> grid;

    final TextField filter;

    private final Button addNewBtn;

    public MainView(Person03Repository02 person03Repository02, Person03Editor editor) {
        this.person03Repository02 = person03Repository02;
        this.editor = editor;
        this.grid = new Grid<>(Person03.class);
        this.filter = new TextField();
        this.addNewBtn = new Button("New customer", VaadinIcon.PLUS.create());

        // build layout
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid, editor);

        grid.setHeight("300px");
        grid.setColumns("id", "firstName", "lastName");
        grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);

        filter.setPlaceholder("Filter by last name");

        // Hook logic to components

        // Replace listing with filtered content when user changes filter
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listCustomers(e.getValue()));

        // Connect selected Customer to editor or hide if none is selected
        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.editCustomer(e.getValue());
        });

        // Instantiate and edit new Customer the new button is clicked
        addNewBtn.addClickListener(e -> editor.editCustomer(new Person03("", "")));

        // Listen changes made by the editor, refresh data from backend
        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listCustomers(filter.getValue());
        });

        // Initialize listing
        listCustomers(null);
    }

    // tag::listCustomers[]
    void listCustomers(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(person03Repository02.findAll());
        }
        else {
            grid.setItems(person03Repository02.findByLastNameStartsWithIgnoreCase(filterText));
        }
    }
    // end::listCustomers[]

}
