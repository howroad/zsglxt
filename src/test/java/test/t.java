package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.pojo.TReport;
import com.project.pojo.TUser;
import com.project.service.IReportService;
import com.project.util.PageBean;

public class t {
	private IReportService reportService;
	@org.junit.Before
	public void befor() {
		ClassPathXmlApplicationContext 
		app = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		reportService = (IReportService) app.getBean("reportService");
	}
	@Test
	public void add() {
		TUser user = new TUser();
		
		user.setUserId("1232wedw34dsf44gg5sd563d57d7hk86");
		
		TReport tr = new TReport();
		
		tr.setTUser(user);
		
		tr.setRAddress("eeeeeeee");
		tr.setRDate(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()));
		reportService.addReport(tr);
		
	}
	@Test
	public void update() {
        TUser user = new TUser();
		user.setUserId("1232wedw34dsf44gg5sd563d57d7hk86");
		TReport tr = new TReport();
		tr.setTUser(user);
		tr.setRAddress("rrrrrrrrr");
		tr.setRDate(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()));
		tr.setRId("402880e7635ca73401635ca73bab0000");
		tr.setRCode("1");
		tr.setRDesc("lalalall");
		tr.setRName("gggggggg");
		reportService.updateTReport(tr);
	}
	@Test
	public void cx() {
		
		TReport tr = reportService.findTReportById("402880e7635ca73401635ca73bab0000");
		System.out.println(tr.getRAddress());
	}
	@Test
	public void del() {
		TReport tr=	new TReport();
		tr.setRId("402880e7635c98c101635c98c9620000");
		reportService.delTReport(tr);
	}
	@Test
	public void ff() {
		PageBean<?> b= reportService.findAllReport(1, 5);
		
		System.out.println(b.getList().size());
	}
	@Test
	public void ss() {
		
		PageBean  pb = reportService.findReportBySome(1, 5,"",1,"","","","");
				
		System.out.println(pb.getList().size());
	}
	
	
	
	
	
	
	
	
	
}
