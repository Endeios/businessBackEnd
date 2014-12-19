package businessBackEnd;

import static org.junit.Assert.*;

import java.util.Date;

import groovy.transform.AnnotationCollector;

import javax.sql.DataSource;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import business.BusinessConfig;
import business.api.Business;
import business.api.CustomerService;
import business.api.InvoiceService;
import business.api.ItemService;
import business.domain.Customer;
import business.domain.Invoice;
import business.domain.Item;
import business.dto.PrintableInvoice;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:context.xml"})
//@ContextConfiguration(classes=BusinessConfig.class)
public class BusinessTest {
	
	@Autowired
	private DataSource ds;
	@Autowired
	private Business business;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private InvoiceService invoiceService;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		assertNotNull("Datasource should be in place", ds);
		assertNotNull("Datasource should be in place", business);
	}
	
	@Test
	public void testBusiness() {
		Customer c = new Customer();
		c.setEmail("endeios@gmail.com");
		c.setName("endeios");
		customerService.save(c);
		Item i1 = new Item();
		i1.setName("Dom perignon del '54");
		i1.setPrice(1000.1F);
		Item i2 = new Item();
		i2.setName("Dom perignon del '54");
		i2.setPrice(1000.1F);
		itemService.save(i1);
		itemService.save(i2);
		
		Invoice inv = new Invoice();
		inv.setCustomer(c);
		inv.setDate(new Date());
		invoiceService.save(inv);
		
		business.addItemToInvoice(i1, inv);
		business.addItemToInvoice(i2, inv);
		PrintableInvoice pi = business.getPrintableInvoice(inv.getId());
		System.err.println(pi);
	}

}
