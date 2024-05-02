
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class PW {

	private static String myKey = "OPUS_YNK_04^";
	
	public static void main(String[] args) {
		System.out.println(PW.decryptString("081A9C964564BAA18A0E0B8A63B50676"));
	}
	
	public static String decryptString(String to_decrypt) {
		String returnVal = "";
		try {
			byte[] decrypted = null;
			byte[] keyData = myKey.getBytes();
			byte[] decData = hexToBytes(to_decrypt);
			SecretKeySpec KS = new SecretKeySpec(keyData, "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(2, KS);
			decrypted = cipher.doFinal(decData);

			returnVal = new String(decrypted);
		} catch (Exception e) {
			return to_decrypt;
		}
		return returnVal;
	}
	
	private static byte[] hexToBytes(String str) {
		if (str == null)
			return null;
		if (str.length() < 2) {
			return null;
		}
		int len = str.length() / 2;
		byte[] buffer = new byte[len];
		for (int i = 0; i < len; ++i) {
			buffer[i] = (byte) Integer.parseInt(
					str.substring(i * 2, i * 2 + 2), 16);
		}
		return buffer;
	}
}
