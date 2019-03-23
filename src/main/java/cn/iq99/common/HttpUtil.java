package cn.iq99.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpUtil {

	/**
	 * 获取http内容
	 * @param httpUrl
	 * @return
	 * @throws Exception
	 */
	public static String getHttpInterface(String httpUrl) throws Exception{
		
		log.info("<<<开始解析url:{}",httpUrl);
		BufferedReader in=null;
		StringBuffer result=null;
		try {
			URL url=new URL(httpUrl);
			
			//打开和url之间的连接
			HttpURLConnection connection=(HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Charset", "utf-8");
            connection.connect();
 
            result = new StringBuffer();
            //读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            return result.toString();

		} catch (Exception e) {
            throw new Exception("获取连接失败"+e);
        }finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
            	throw new Exception("关闭连接失败"+e);
            }
        }
	}
	
	/**
	 * 获取http内容
	 * @param httpUrl
	 * @param retryCount 重试次数 
	 * @return
	 * @throws Exception
	 */
	public static String getHttpInterface(String httpUrl,int retryCount) throws Exception{
		
		log.info("<<<开始解析url:{}",httpUrl);
		String res="";
		int i=0;
		while(i<retryCount){
			i++;
			try {
				res=getHttpInterface(httpUrl);
				break;
			} catch (Exception e) {		
				
				try {
					Thread.sleep(1000*5L);//sleep5秒
				} catch (InterruptedException e1) {
					log.error("重试http连接等待异常:",e1);
					throw new Exception("连接异常:"+httpUrl);
				}  
				log.info("获取连接异常:{},重试连接次数:{}",e,i);
				throw new Exception("连接异常:"+httpUrl);
			}
		}

		return res;
	}
	
}
