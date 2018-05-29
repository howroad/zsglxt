package com.project.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传工具类
 * 
 * @author 赵子墨
 *
 */
public class FileUploadUtil {
	/**
	 * 上传路径
	 */
	private static final String MKDIR_PATH = "http://192.168.1.67:8080/img";

	/**
	 * 上传文件
	 * 
	 * @param files
	 *            文件集合
	 * @return 文件名集合
	 */
	public static String[] fileUpload(MultipartFile[] files) {
		List<String> nameList = new ArrayList<String>();
		try {
			for (int i = 0; i < files.length; i++) {
				String fileName = getFileName(files[i]);
				files[i].transferTo(new File(MKDIR_PATH, fileName));
				nameList.add(fileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nameList.toArray(new String[nameList.size()]);
	}

	/**
	 * 生成文件名
	 * 
	 * @param file
	 *            文件
	 * @return 文件名
	 */
	public static String getFileName(MultipartFile file) {
		String originalFilename = file.getOriginalFilename();
		String fileName = System.currentTimeMillis() + "xx."
				+ originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
		return fileName;
	}
}
