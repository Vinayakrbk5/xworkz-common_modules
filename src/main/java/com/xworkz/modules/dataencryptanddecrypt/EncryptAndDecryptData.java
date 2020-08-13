package main.java.com.xworkz.modules.dataencryptanddecrypt;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

@Component
public class EncryptAndDecryptData {

	public static final String ALGO = "AES";

	private byte[] keyValue = "lv39eptlvuhaqqsr".getBytes();

	public EncryptAndDecryptData() {
	}

	public String encryptData(String encData) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(encData.getBytes());
		String encryptedValue = new BASE64Encoder().encode(encVal);
		return encryptedValue;
	}
	
	public String decrypti(String enData) throws Exception {
		Key key = generateKey();
		Cipher c=Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decodeValue=new BASE64Decoder().decodeBuffer(enData);
		byte[] decVal=c.doFinal(decodeValue);
		String decValue=new String(decVal);
		
		return decValue;
		
	}

	private Key generateKey() {
		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}
}
