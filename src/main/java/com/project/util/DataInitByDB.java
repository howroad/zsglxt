package com.project.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.project.pojo.TData;
import com.project.service.IDataService;

/**
 * 启动Tomcat加载数据库数据到内存
 * 
 * @author 赵子墨
 *
 */
public class DataInitByDB implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ApplicationContext context = WebApplicationContextUtils
					.getRequiredWebApplicationContext(sce.getServletContext());
			IDataService dataService = (IDataService) context.getBean("dataService");
			List<TData> DQList = dataService.findAllData("QY");
			List<TData> SJLXList = dataService.findAllData("RWDJ");
			List<TData> SJDJList = dataService.findAllData("RWLX");
			Map<String, String> QYMap = new HashMap<String, String>();
			Map<String, String> RWDJMap = new HashMap<String, String>();
			Map<String, String> RWLXMap = new HashMap<String, String>();
			for (TData dataEntity : DQList) {
				QYMap.put(dataEntity.getDataKey(), dataEntity.getDataValue());
			}
			for (TData dataEntity : SJLXList) {
				RWDJMap.put(dataEntity.getDataKey(), dataEntity.getDataValue());
			}
			for (TData dataEntity : SJDJList) {
				RWLXMap.put(dataEntity.getDataKey(), dataEntity.getDataValue());
			}
			Map<String, Object> DataMap = new HashMap<String, Object>();
			DataMap.put("QY", QYMap);
			DataMap.put("RWDJ", RWDJMap);
			DataMap.put("RWLX", RWLXMap);
			sce.getServletContext().setAttribute("DataMap", DataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
