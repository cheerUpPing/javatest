package symencoding;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

import javax.crypto.Cipher;

public class RSAUtil {/*


	public static byte[] encrypt(PublicKey pk, byte[] date) throws Exception {
		try {
			Cipher cipher = Cipher.getInstance("RSA", new org.bouncycastle.jce.provider.BouncyCastleProvider());
			cipher.init(Cipher.ENCRYPT_MODE, pk);
			int blockSize = cipher.getBlockSize();
			int outputSize = cipher.getOutputSize(date.length);
			int leavedSize = date.length % blockSize;
			int blocksSize = leavedSize != 0 ? date.length / blockSize + 1 : date.length / blockSize;
			byte[] raw = new byte[outputSize * blocksSize];
			int i = 0;
			while (date.length - i * blockSize > 0) {
				if (date.length - i * blockSize > blockSize)
					cipher.doFinal(date, i * blockSize, blockSize, raw, i * outputSize);
				else
					cipher.doFinal(date, i * blockSize, date.length - i * blockSize, raw, i * outputSize);
				i++;
			}
			return raw;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}


	public static byte[] decrypt(PrivateKey pk, byte[] raw) throws Exception {
		try {
			Cipher cipher = Cipher.getInstance("RSA", new org.bouncycastle.jce.provider.BouncyCastleProvider());
			cipher.init(cipher.DECRYPT_MODE, pk);
			int blockSize = cipher.getBlockSize();
			ByteArrayOutputStream bout = new ByteArrayOutputStream(64);
			int j = 0;

			while (raw.length - j * blockSize > 0) {
				bout.write(cipher.doFinal(raw, j * blockSize, blockSize));
				j++;
			}
			return bout.toByteArray();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}


	public static KeyPair getKeyPair(String rsaKeyStore) throws Exception {
		FileInputStream fis = new FileInputStream(rsaKeyStore);
		ObjectInputStream oos = new ObjectInputStream(fis);
		KeyPair kp = (KeyPair) oos.readObject();
		oos.close();
		fis.close();
		return kp;
	}

	public static void saveKeyPair(KeyPair kp, String path) throws Exception {
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		// ������Կ
		oos.writeObject(kp);
		oos.close();
		fos.close();
	}


	public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {

		SecureRandom sr = new SecureRandom();
		KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA",
				new org.bouncycastle.jce.provider.BouncyCastleProvider());
		// ע����Կ��С���Ϊ1024,������ܻ����������.
		kg.initialize(1024, sr);
		KeyPair genKeyPair = kg.genKeyPair();
		return genKeyPair;

	}

	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}


	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	public static void main(String[] args) throws Exception {

		KeyPair generateKeyPair = getKeyPair("E:\\code\\key.CRT");
		//KeyPair generateKeyPair = generateKeyPair();

		PublicKey publicKey = generateKeyPair.getPublic();
		System.out.println(publicKey);

		PrivateKey privateKey = generateKeyPair.getPrivate();
		System.out.println(privateKey);

		String test = "saaaa";

		byte[] en_test = encrypt(publicKey, test.getBytes());
		System.out.println("���ܺ��ַ�:" + parseByte2HexStr(en_test));

		byte[] de_test = decrypt(privateKey, en_test);
		System.out.println("���ܺ��ַ�:" + new String(de_test));
	}*/

}