package business

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import business.api.Business;
import business.api.CustomerService;
import business.api.InvoiceService;
import business.api.ItemService;

@Singleton
class BusinessApp{
	static Business business;
	static CustomerService customerService;
	static ItemService itemService;
	static InvoiceService invoiceService;
	private ApplicationContext context;
	{
		context = new ClassPathXmlApplicationContext("context.xml")
		println "Context is ${context}"
		business = context.getBean(Business.class)
		itemService = context.getBean(ItemService.class)
		invoiceService = context.getBean(InvoiceService.class)
		customerService = context.getBean(CustomerService.class)
	}
	
	
}
