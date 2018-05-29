import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.pojo.TRota;
import com.project.pojo.TUser;
import com.project.service.IRotaService;
import com.project.util.PageBean;
public class RotaTest {
	private ClassPathXmlApplicationContext app=null;
	   //在运行任何测试方法之前就要运行我
	@Before
	public void before(){
		app = new ClassPathXmlApplicationContext("spring-hibernate.xml");
	}
	
	@Test
	public void addRota() {
		for(int a=0; a<10; a++) {
			TRota rota = new TRota();
			rota.setRotaDesc("asda" + a);
			TUser user = new TUser();
			user.setUserId("2512g12346h87462a983r813451a0000");
			rota.setTUser(user);
			String rotaDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
			rota.setRotaDate(rotaDate);
			rota.setRotaEvent("");
			IRotaService rotaService = (IRotaService) app.getBean("rotaService");
			
			rotaService.addRota(rota);
		}
	}
	@Test
	public void findAllRota() {
		IRotaService rotaService = (IRotaService) app.getBean("rotaService");
		PageBean<TRota> pageBean = rotaService.findAllRota(1, 5);
		List<TRota> list = pageBean.getList();
		for (TRota tRota : list) {
			System.out.println(tRota.getRotaDesc());
		}
	}
	@Test
	public void findRotaBySome() {
		IRotaService rotaService = (IRotaService) app.getBean("rotaService");
		
		PageBean<TRota> pageBean = rotaService.findRotaBySome(1, 5,new String[] {"%aa%","","2018-05-08"});
		List<TRota> list = pageBean.getList();
		for (TRota tRota : list) {
			System.out.println(tRota.getRotaDesc());
		}
	}
}
