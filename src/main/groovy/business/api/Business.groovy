package business.api

import org.springframework.data.jpa.repository.JpaRepository;

import business.domain.Invoice
import business.domain.Item;
import business.dto.PrintableInvoice;


interface Business {
	PrintableInvoice getPrintableInvoice(Long invoiceId);
	void addItemToInvoice(Item item,Invoice invoice)
}
