package business.domain;

import groovy.transform.Canonical;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Canonical
public class InvoiceItem {
	@Id
	Long id;
	@OneToOne(optional=false)
	Item item;
	@ManyToOne(optional=false)
	Invoice invoice;
	
}
