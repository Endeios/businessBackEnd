package business.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import business.api.Business;
import business.api.InvoiceService;
import business.domain.Invoice;
import business.domain.Item;
import business.dto.PrintableInvoice;

public class BusinessImpl implements Business {
	
	
	@Autowired
	private InvoiceService invoiceService;

	@Override
	public PrintableInvoice getPrintableInvoice(Long invoiceId) {
		PrintableInvoice pi = new PrintableInvoice();
		Invoice retInvoice = invoiceService.findById(invoiceId)
		println retInvoice
		pi.setInvoice(retInvoice);
		return pi;
	}

	@Override
	public void addItemToInvoice(Item item, Invoice invoice) {
		Invoice inv = invoiceService.findById(invoice.id);
		inv.getItems().add(item);
		invoiceService.save(inv)
	}

}
