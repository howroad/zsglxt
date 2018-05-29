import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.pojo.TShift;
import com.project.pojo.TUser;
import com.project.service.IShiftService;
import com.project.util.PageBean;

public class ShiftTest {
	private ClassPathXmlApplicationContext app=null;
	   //在运行任何测试方法之前就要运行我
	@Before
	public void before(){
		app = new ClassPathXmlApplicationContext("spring-hibernate.xml");
	}
	
	@Test
	public void addShift() {
		IShiftService shiftService = (IShiftService) app.getBean("shiftService");
		for(int a=0; a<10; a++) {
			
			TShift shift = new TShift();
			String SStarttime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
			shift.setSStarttime(SStarttime);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String SEndtime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
			shift.setSEndtime(SEndtime);
			
			TUser user = new TUser();
			user.setUserId("2512g12346h87462a983r813451a0001");
			shift.setTUser(user);
			
			shiftService.addShift(shift);
		}
		
	}
	
	@Test
	public void findAll() {
		IShiftService shiftService = (IShiftService) app.getBean("shiftService");
		PageBean<TShift> pageBean = shiftService.findAllShift(1, 5);
		List<TShift> list = pageBean.getList();
		for (TShift tShift : list) {
			System.out.println(tShift.getSEndtime());
		}
	}
	
	@Test
	public void find() {
		IShiftService shiftService = (IShiftService) app.getBean("shiftService");
		PageBean<TShift> pageBean = shiftService.findShiftBySome(1, 5, new String[] {"","","2018-05-05"});
		List<TShift> list = pageBean.getList();
		for (TShift tShift : list) {
			System.out.println(tShift.getSStarttime()+"++++++"+tShift.getSEndtime()+"+++=+"+tShift.getTUser().getUserName());
		}
	}
	
}
