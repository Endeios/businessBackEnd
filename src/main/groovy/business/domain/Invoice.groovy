package business.domain

import groovy.transform.Canonical;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Canonical
class Invoice {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	@Column
	Date date;
	@ManyToOne(optional=false,fetch=FetchType.EAGER)
	Customer customer;
	@OneToMany(fetch=FetchType.EAGER)
	List<Item> items;
}
