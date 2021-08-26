package com.erayt.web01.configuration;
import com.erayt.web01.domain.Person03;
import com.erayt.web01.repository.Person03Repository02;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import com.erayt.web01.domain.Customer;
import com.erayt.web01.repository.CustomerRepository;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class Person03Editor extends VerticalLayout implements KeyNotifier {

	private final Person03Repository02 person03Repository02;

	/**
	 * The currently edited customer
	 */
	private Person03 person03;

	/* Fields to edit properties in Customer entity */
	TextField firstName = new TextField("First name");
	TextField lastName = new TextField("Last name");

	/* Action buttons */
	// TODO why more code?
	Button save = new Button("Save", VaadinIcon.CHECK.create());
	Button cancel = new Button("Cancel");
	Button delete = new Button("Delete", VaadinIcon.TRASH.create());
	HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

	Binder<Person03> binder = new Binder<>(Person03.class);
	private ChangeHandler changeHandler;

	@Autowired
	public Person03Editor(Person03Repository02 person03Repository02) {
		this.person03Repository02 = person03Repository02;

		add(firstName, lastName, actions);

		// bind using naming convention
		binder.bindInstanceFields(this);

		// Configure and style components
		setSpacing(true);

		save.getElement().getThemeList().add("primary");
		delete.getElement().getThemeList().add("error");

		addKeyPressListener(Key.ENTER, e -> save());

		// wire action buttons to save, delete and reset
		save.addClickListener(e -> save());
		delete.addClickListener(e -> delete());
		cancel.addClickListener(e -> editCustomer(person03));
		setVisible(false);
	}

	void delete() {
        person03Repository02.delete(person03);
		changeHandler.onChange();
	}

	void save() {
        person03Repository02.save(person03);
		changeHandler.onChange();
	}

	public interface ChangeHandler {
		void onChange();
	}

	public final void editCustomer(Person03 c) {
		if (c == null) {
			setVisible(false);
			return;
		}
		final boolean persisted = c.getId()==0L;
		if (persisted) {
			// Find fresh entity for editing
            person03 = person03Repository02.findById(c.getId()).get();
		}
		else {
            person03 = c;
		}
		cancel.setVisible(persisted);

		// Bind customer properties to similarly named fields
		// Could also use annotation or "manual binding" or programmatically
		// moving values from fields to entities before saving
		binder.setBean(person03);

		setVisible(true);

		// Focus first name initially
		firstName.focus();
	}

	public void setChangeHandler(ChangeHandler h) {
		// ChangeHandler is notified when either save or delete
		// is clicked
		changeHandler = h;
	}

}