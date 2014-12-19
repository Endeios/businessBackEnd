package business.dto
import groovy.transform.Canonical;
import business.domain.Invoice;

@Canonical
class PrintableInvoice {
	Invoice invoice;
}
