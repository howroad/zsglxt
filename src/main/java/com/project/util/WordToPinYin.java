package com.project.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sourceforge.pinyin4j.PinyinHelper;

public class WordToPinYin {

	public static String toPinyin(String str) {
		String convert = "";
		for (int j = 0, len = str.length(); j < len; j++) {
			char word = str.charAt(j);
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
			if (pinyinArray != null) {
				convert += pinyinArray[0].charAt(0);
			} else {
				convert += word;
			}
		}
		return convert.toUpperCase();
	}
	
	public static String dateToString() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	
}
