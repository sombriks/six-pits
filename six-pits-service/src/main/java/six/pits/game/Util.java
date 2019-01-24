package six.pits.game;

import java.security.MessageDigest;

public class Util {

	public static String md5(String str) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] digest = md.digest(str.getBytes());
		StringBuffer sb = new StringBuffer();
		for (byte b : digest)
			sb.append(String.format("%02x", b & 0xff));
		String hash = sb.toString();
		return hash;
	}
}