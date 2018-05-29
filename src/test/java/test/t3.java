package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.service.IDataService;


public class t3 {

	
	private IDataService rs;
	@Before
	public void befor() {
		ClassPathXmlApplicationContext 
		app = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		rs =  (IDataService) app.getBean("dataService");
	}
	
	@Test
	public void a() {
		
		int a=rs.findAllData(null).size();
		System.out.println(a);
	}
}
