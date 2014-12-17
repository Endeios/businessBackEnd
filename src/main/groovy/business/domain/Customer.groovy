package business.domain;

import groovy.transform.Canonical;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
@Canonical
public class Customer {
	@Id
	Long id;
	@Column
	String name;
	@Column
	String email;
}
