package com.r2.crypto.func;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class Decrypt {

	private static final String algorithm = "AES/CBC/PKCS5Padding";
	private static String key = "Bar12345Bar12345";

	public static void main(String[] args) {
		Decrypt d = new Decrypt();

		String enc = d.encrypt(key, "HOLA");
		System.out.println(enc);
		
		String dec = d.decrypt2(key, enc);
		System.out.println(dec);
	}

	public String decrypt(String key, String encrypted) {
		String decripted = "ERROR: ";
		try {
			byte[] bytes = Hex.decodeHex(key.toCharArray());
			Key aesKey = new SecretKeySpec(bytes, "AES");

			IvParameterSpec ivspec = new IvParameterSpec(bytes);
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.DECRYPT_MODE, aesKey, ivspec);

			byte[] encryptedTemp = Hex.decodeHex(encrypted.toCharArray());

			decripted = new String(cipher.doFinal(encryptedTemp), "UTF-8");

		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage() != null) {
				decripted = decripted + e.getMessage();
			}
		}
		return decripted;
	}

	public String decrypt2(String key, String encrypted) {
		String decripted = "ERROR: ";
		try {
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));

			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

			decripted = new String(cipher.doFinal(Base64.decodeBase64(encrypted)));

		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage() != null) {
				decripted = decripted + e.getMessage();
			}
		}
		return decripted;
	}

	public String encrypt(String key, String value) {
		String encripted = "ERROR: ";
		try {
			byte[] bytes = key.getBytes("UTF-8");
			Key aesKey = new SecretKeySpec(bytes, "AES");
			IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));

			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.ENCRYPT_MODE, aesKey, iv);

			byte[] encryptedTemp = cipher.doFinal(value.getBytes());

			encripted = Base64.encodeBase64String(encryptedTemp);

		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage() != null) {
				encripted = encripted + e.getMessage();
			}
		}
		return encripted;
	}

	public byte[] getPass() {
		KeyGenerator kgen;
		byte[] key = null;
		try {
			kgen = KeyGenerator.getInstance("AES");
			kgen.init(256);
			SecretKey aesKey = kgen.generateKey();
			key = aesKey.getEncoded();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return key;
	}
}