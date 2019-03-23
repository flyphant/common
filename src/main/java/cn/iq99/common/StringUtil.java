package cn.iq99.common;

import java.util.HashMap;

public class StringUtil {

	/**
	 * 获取解析后干净数据
	 * @param str
	 * @return
	 */
	public static String getCleanString(String str){
		
		return str.replaceAll("settingsCallback\\(\\{", "").	//去掉标题头
				replaceAll("\\s*", "").							//去掉空格
				replaceAll("\"", "").							//去掉引号
				replaceAll("'", "").							//去掉引号
				replaceAll("\\}\\);", "");						//去掉标题尾
	}
	
	/**
	 * 解析医疗设备原始返回告警报文
	 * @param str
	 * @return
	 */
	public static HashMap<String, String> getYasenMap(String str){
		String res=getCleanString(str);
		String contents[]=res.split(",");
		HashMap<String, String> resMap=new HashMap<String, String>();
		for(String content:contents){
			resMap.put(content.split(":")[0], content.split(":")[1]);
		}
		return resMap;
	}
	
}
