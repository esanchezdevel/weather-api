package esanchez.devel.weather.cryptography;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Cryptography {

	public static String encode(String text) {
		return BCrypt.hashpw(text, BCrypt.gensalt(12));
	}

	public static boolean checkPassword(String text, String encrypt) {
		return BCrypt.checkpw(text, encrypt);
	}
}
