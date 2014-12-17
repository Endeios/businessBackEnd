package business.domain

import groovy.transform.Canonical;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Canonical
class Invoice {
	@Id
	Long id;
	@Column
	Date date;
	@ManyToOne(optional=false)
	Customer customer;
	@OneToMany
	List<InvoiceItem> items;
}
