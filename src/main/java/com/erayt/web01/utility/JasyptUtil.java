package com.erayt.web01.utility;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

public class JasyptUtil {
 
	public static void main(final String[] args) {
 
		String miyao = "Zz151";// 秘钥字符串
		String pass = "p...b(全字母)";// 待加密的明文密码
		try {
			StringEncryptor stringEncryptor = JasyptUtil.getInstance(miyao);
			String mima = stringEncryptor.encrypt(pass);
			System.out.println("[" + pass + "] is passwordEd [" + mima + "]");
 
			String jiemi = stringEncryptor.decrypt(mima);
			System.out.println("[" + mima + "] is unPasswordEd [" + jiemi + "]");
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	private static StringEncryptor stringEncryptor = null;//org.jasypt.encryption.StringEncryptor对象
 
	public static StringEncryptor getInstance(String miyao) throws Exception {
		if(miyao==null||miyao.trim().equals("")) {
			System.out.println("秘钥不能为空！");
			throw new Exception("org.jasypt.encryption.StringEncryptor秘钥不能为空！");
		}
		if (stringEncryptor == null) {
			PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
			SimpleStringPBEConfig config = new SimpleStringPBEConfig();
			config.setPassword(miyao);// 这个秘钥必须是我们自己定义
			config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
			config.setKeyObtentionIterations("1000");
			config.setPoolSize("1");
			config.setProviderName("SunJCE");
			config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
			config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
			config.setStringOutputType("base64");
			encryptor.setConfig(config);
 
			stringEncryptor = encryptor;
		}
		return stringEncryptor;
	}
 
}
