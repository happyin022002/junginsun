package com.hanjin.sample;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import sun.misc.BASE64Decoder;

import com.tobesoft.iam.virtualagent.TBSeed;

public class AlpsPw {

	private final byte[] ZERO_16 = new byte[16];
	private int[] roundKey = new int[32];
	private byte[] chunk1 = new byte[16];
	private byte[] chunk2 = new byte[16];
	
	public static void main(String[] args) {
		String pwStr = "";
		AlpsPw pw = new AlpsPw();
		System.out.println(pw.decrypt(pwStr));
 
	}
	
	public String decrypt(String strEnc) {
		if ((strEnc == null) || (strEnc.length() == 0)) {
			return "";
		}
		byte[] inData = decodeBase64(strEnc.getBytes());
		byte[] outData = new byte[(inData.length % 16 == 0) ? inData.length : (inData.length / 16 + 1) * 16];

		for (int sp = 0; sp < inData.length; sp += 16) {
			int left = inData.length - sp;
			if (left >= 16) {
				System.arraycopy(inData, sp, this.chunk1, 0, 16);
			} else {
				zero16(this.chunk1);
				System.arraycopy(inData, sp, this.chunk1, 0, left);
			}
			TBSeed.SeedDecrypt(this.chunk1, this.roundKey, this.chunk2);
			System.arraycopy(this.chunk2, 0, outData, sp, 16);
		}

		byte[] zeroOutData = outData;
		for (int i = 0; i < outData.length; ++i) {
			if (outData[i] == 0) {
				zeroOutData = new byte[i];
				System.arraycopy(outData, 0, zeroOutData, 0, i);
				break;
			}
		}

		return new String(zeroOutData);
	}

	public byte[] decodeBase64(byte[] decodeBytes) {
		byte[] buf = (byte[]) null;
		BASE64Decoder base64Decoder = new BASE64Decoder();
		ByteArrayInputStream bin = new ByteArrayInputStream(decodeBytes);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		try {
			base64Decoder.decodeBuffer(bin, bout);
		} catch (Exception e) {
			e.printStackTrace();
		}
		buf = bout.toByteArray();
		return buf;
	}

	private void zero16(byte[] data) {
		System.arraycopy(ZERO_16, 0, data, 0, 16);
	}

	public void setUserKey(String key) {
		byte[] pbUserKey = key.getBytes();
		byte[] tmpUserKey = new byte[16];
		System.arraycopy(ZERO_16, 0, tmpUserKey, 0, 16);
		System.arraycopy(pbUserKey, 0, tmpUserKey, 0, pbUserKey.length);
		TBSeed.SeedEncRoundKey(this.roundKey, tmpUserKey);
	}

}
