package cn.iq99.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

	public static String toJson(Object object) {
		Gson gson=new GsonBuilder()
			.serializeNulls()			//展示为空字段
			.setDateFormat(DateUtil.DATETIME_LONG).create();	//格式化时间
			
		return gson.toJson(object).replaceAll("null", "\"\"");	//替换null值
	}
}
