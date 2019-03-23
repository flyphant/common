package cn.iq99.common;

import java.util.Random;

import lombok.extern.slf4j.Slf4j;

/**
 * 密码生成工具
 * @author jaysonding
 *
 */
@Slf4j
public class PasswordActivateUtil {

	public static void main(String[] args) {
		getStongPassword(32);

	}

	/**
	 * 随机生成N位的强密码
	 * @param n
	 * @return
	 */
	public static String getStongPassword(int n) {
		
		String password="";
		String[] plainText= {"a","b","c","d","e","f","g","h","h","i","j","k","l",
				"m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H",
				"I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4",
				"5","6","7","8","9","0","!","@","#","$","%"};

		Random random=new Random();
		for(int i=0;i<n;i++) {
			password+=plainText[random.nextInt(68)];
		}
		log.debug("生成密码:{}",password);
		return password;
	}
}
