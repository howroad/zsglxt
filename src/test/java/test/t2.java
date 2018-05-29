package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.pojo.TReport;
import com.project.pojo.TResubmit;
import com.project.pojo.TUser;
import com.project.service.IResubmitService;
import com.project.util.PageBean;

public class t2 {
	
	private IResubmitService rs;
	@Before
	public void befor() {
		ClassPathXmlApplicationContext 
		app = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		rs = (IResubmitService) app.getBean("resubmitService");
	}
	
	
	@Test
	public void add() {
		TUser u = new TUser();
		u.setUserId("1232wedw34dsf44gg5sd563d57d7hk86");
		
		TReport r = new TReport();
		
		r.setRId("402880e7635ca9d201635ca9d86b0000");
		
		TResubmit sb = new TResubmit();
		sb.setTReport(r);
		sb.setTUser(u);
		sb.setRsDesc("66666666");
		
		rs.addResubmit(sb);
		
	}
	@Test
	public void cx() {
		
		List<?> list = rs.findAllResubmitByReportId("402880e7635ca9d201635ca9d86b0000");
		
		System.out.println(list.size());
		
	}
	
	@Test
	public void dd() {
		
		PageBean<?> pb=rs.getAllResubitByUserId("1232wedw34dsf44gg5sd563d57d7hk86",1, 5);
		
		System.out.println(pb.getList().size());
		
	}
	
	
}
