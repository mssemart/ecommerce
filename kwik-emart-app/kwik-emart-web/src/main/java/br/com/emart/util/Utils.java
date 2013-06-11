package br.com.emart.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
	public static String encripta(String senha)
	{
		try {     
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
			
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
			  hexString.append(String.format("%02X", 0xFF & b));
			}
			return hexString.toString();
       } catch (NoSuchAlgorithmException ns) {     
            return null;  
       } catch (UnsupportedEncodingException e) {
    	   return null;  
	}  
	}
}
