package business.api

import business.domain.Customer
import business.domain.Invoice
import business.domain.Item

import org.springframework.data.jpa.repository.JpaRepository;

interface CustomerService extends JpaRepository<Customer, Long>{

}

interface ItemService extends JpaRepository<Item, Long>{

}

interface InvoiceService extends JpaRepository<Invoice, Long>{
	
	Invoice findById(Long id)

}


