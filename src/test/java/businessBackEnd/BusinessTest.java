package businessBackEnd;

import static org.junit.Assert.*;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BusinessConfig.class)
public class BusinessTest {
	
	@Autowired
	DataSource ds;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		assertNotNull("Datasource should be in place", ds);
	}

}
