/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SarUtil.java
 *@FileTitle : SarUtil
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;

import com.clt.framework.component.rowset.DBRowSet;

/**
 * Sar Common Util
 * 
 * @author cyo
 * @see
 * @since
 */
public class SarUtil {

	/**
	 * dbRowSet을 특정 컬럼의 String[] 로 변환
	 * 
	 * @param DBRowSet dbRowSet
	 * @param String column
	 * @return String[]
	 * @throws SQLException
	 */
	public static String[] getArrayString(DBRowSet dbRowSet, String column) throws SQLException {

		if (dbRowSet == null) {
			return null;
		}

		int cnt = dbRowSet.getRowCount();
		if (cnt == 0) {
			return new String[0];
		}

		String[] arr = new String[cnt];
		int i = 0;

		while (dbRowSet.next()) {
			arr[i++] = dbRowSet.getString(column);
		}

		return arr;

	}

	/**
	 * dbRowSet을 특정 컬럼의 String[] 로 변환
	 * 
	 * @param DBRowSet dbRowSet
	 * @param int idx
	 * @return String[]
	 * @throws SQLException
	 */
	public static String[] getArrayString(DBRowSet dbRowSet, int idx) throws SQLException {

		if (dbRowSet == null) {
			return null;
		}

		int cnt = dbRowSet.getRowCount();
		if (cnt == 0) {
			return new String[0];
		}

		String[] arr = new String[cnt];
		int i = 0;

		while (dbRowSet.next()) {
			arr[i++] = dbRowSet.getString(idx);
		}

		return arr;

	}

	/**
	 * 배열을 특정문자를 추가하여 하나의 문자열로 반환
	 * 
	 * @param String[] arr
	 * @param String spChar
	 * @return String
	 */
	public static String addSpChar(String[] arr, String spChar) {

		if (arr == null) {
			return null;
		}

		if (arr.length == 0) {
			return "";
		}

		StringBuffer sb = new StringBuffer();

		if (spChar == null || spChar.trim().equals("")) {
			spChar = "|";
		}

		for (int i = 0; i < arr.length; i++) {
			sb.append(spChar).append(arr[i]);
		}

		return sb.substring(1);
	}

	/**
	 * 배열을 특정문자를 추가하여 하나의 문자열로 반환
	 * 
	 * @param String[] arr
	 * @return String
	 */
	public static String addSpChar(String[] arr) {
		return addSpChar(arr, "|");
	}

	/**
	 * 인수가 넘버타입의 조건절인경우의 SQL의 IN절 문자 생성 [100,200,300] ==> "100,200,300"
	 * 
	 * @author 진윤오
	 * @param String[] numStr
	 * @return String
	 */
	public static String getInSqlNum(String[] numStr) {

		StringBuffer sb = new StringBuffer();

		if (numStr == null) {
			return null;
		}

		for (int i = 0; i < numStr.length; i++) {
			String in = numStr[i];
			// 넘버
			sb.append(in.trim()).append(",");
		}

		return sb.substring(0, sb.lastIndexOf(","));

	}

	/**
	 * 인수가 문자타입의 조건절인경우의 SQL의 IN절 문자 생성 [100,200,300] ==> "'100','200','300'"
	 * 
	 * @author 진윤오
	 * @param String[] str
	 * @return String
	 */
	public static String getInSqlChar(String[] str) {

		StringBuffer sb = new StringBuffer();

		if (str == null || str.length == 0) {
			return null;
		}

		int cnt = 0;

		for (int i = 0; i < str.length; i++) {
			String in = str[i];
			if (in != null && !in.trim().equals("")) {
				sb.append("'");
				// 문자
				sb.append(in.trim()).append("',");
				cnt++;
			}
		}

		if (cnt > 0) {
			return sb.substring(0, sb.lastIndexOf(","));
		}

		return "";

	}

	/**
	 * 로컬을 USD금액으로 환산
	 * 
	 * @author cyo
	 * @param BigDecimal lclAmt
	 * @param BigDecimal utVal
	 * @param BigDecimal usdLoclXchRt
	 * @return BigDecimal
	 */
	public static BigDecimal getLclToUsdAmt(BigDecimal lclAmt, BigDecimal utVal, BigDecimal usdLoclXchRt) {

		if (utVal == null || utVal.intValue() == 0) {
			return new BigDecimal(0);
		}

		if (usdLoclXchRt == null || usdLoclXchRt.floatValue() <= 0) {
			return new BigDecimal(0);
		}

		BigDecimal usdAmt = lclAmt.multiply(utVal);

		if (lclAmt.intValue() < 0) {
			usdAmt = usdAmt.divide(usdLoclXchRt, BigDecimal.ROUND_FLOOR);
		} else {
			usdAmt = usdAmt.divide(usdLoclXchRt, BigDecimal.ROUND_CEILING);
		}

		return usdAmt;
	}

	/**
	 * 로컬을 KRW금액으로 환산
	 * 
	 * @author cyo
	 * @param BigDecimal lclAmt
	 * @param BigDecimal utVal
	 * @param BigDecimal usdKrwXchRt
	 * @param BigDecimal usdLoclXchRt
	 * @return BigDecimal
	 */
	public static BigDecimal getLclToKrwAmt(BigDecimal lclAmt, BigDecimal utVal, BigDecimal usdKrwXchRt, BigDecimal usdLoclXchRt) {
		if (utVal == null || utVal.intValue() == 0) {
			return new BigDecimal(0);
		}

		if (usdKrwXchRt == null || usdKrwXchRt.floatValue() <= 0) {
			return new BigDecimal(0);
		}

		if (usdLoclXchRt == null || usdLoclXchRt.floatValue() <= 0) {
			return new BigDecimal(0);
		}

		BigDecimal krwAmt = lclAmt.multiply(utVal);
		BigDecimal krwRatio = usdKrwXchRt.divide(new BigDecimal(1000)).divide(usdLoclXchRt, BigDecimal.ROUND_CEILING);
		krwAmt = krwAmt.multiply(krwRatio);
		return krwAmt;
	}

	/**
	 * 숫자 월 영문 표시
	 * 
	 * @param String month
	 * @return String
	 */
	public static String getEngMonthName(String month) {
		int mon = Integer.valueOf(month);
		switch (mon) {
		case 1:
			return "JAN";
		case 2:
			return "FEB";
		case 3:
			return "MAR";
		case 4:
			return "APR";
		case 5:
			return "MAY";
		case 6:
			return "JUN";
		case 7:
			return "JUL";
		case 8:
			return "AUG";
		case 9:
			return "SEP";
		case 10:
			return "OCT";
		case 11:
			return "NOV";
		case 12:
			return "DEC";
		default:
			return "";
		}

	}

	/**
	 * 
	 * Date diff
	 * 
	 * @author jinyoonoh 2014. 4. 22.
	 * @param String fromDt
	 * @param String toDt
	 * @return long
	 */
	public static long getDiffDays(String fromDt, String toDt) {

		if (StringUtils.isEmpty(fromDt) || StringUtils.isEmpty(toDt)) {
			return 0;
		}

		fromDt = fromDt.replaceAll("\\-", "");
		toDt = toDt.replaceAll("\\-", "");

		if (fromDt.length() != 8 || toDt.length() != 8) {
			return 0;
		}

		Calendar calFrom = Calendar.getInstance();
		int year = Integer.parseInt(fromDt.substring(0, 4));
		int month = Integer.parseInt(fromDt.substring(4, 6)) - 1;
		int days = Integer.parseInt(fromDt.substring(6, 8)) - 1;
		calFrom.set(year, month, days);

		Calendar calTo = Calendar.getInstance();
		year = Integer.parseInt(toDt.substring(0, 4));
		month = Integer.parseInt(toDt.substring(4, 6)) - 1;
		days = Integer.parseInt(toDt.substring(6, 8)) - 1;
		calTo.set(year, month, days);
		long diff = calTo.getTime().getTime() - calFrom.getTime().getTime();

		return Math.abs(TimeUnit.MILLISECONDS.toDays(diff));

	}

	/**
	 * Date add
	 * 
	 * @param String dt
	 * @param int day
	 * @return String
	 * @throws ParseException
	 */
	public static String addDays(String dt, int day) throws ParseException {

		if (StringUtils.isEmpty(dt) || dt.length() < 8) {
			return dt;
		}

		dt = dt.replaceAll("\\-", "");
		dt = dt.substring(0, 8);

		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");

		Calendar cal = Calendar.getInstance();
		cal.setTime(fmt.parse(dt));

		cal.add(Calendar.DAY_OF_MONTH, day);

		return fmt.format(cal.getTime());

	}

	/**
	 * Copy VO field
	 * 
	 * @param Object srcVO
	 * @param Object destVO
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void copyBeanProperties(Object srcVO, Object destVO) throws SecurityException, NoSuchMethodException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {

		if (srcVO == null || destVO == null) {
			throw new NullPointerException("srcVO or destVO is null");
		}

		Map<String, String> srcColMap = null;
		Map<String, String> srcValMap = null;

		Map<String, String> destColMap = null;

		Class srcCls = srcVO.getClass();
		Class destCls = destVO.getClass();
		// source VO
		{
			Method method = srcCls.getMethod("getFieldNames", null);
			srcColMap = (Map<String, String>) method.invoke(srcVO, null);
			method = srcCls.getMethod("getColumnValues", null);
			srcValMap = (Map<String, String>) method.invoke(srcVO, null);
		}
		// destnation VO
		{
			Method method = destCls.getMethod("getFieldNames", null);
			destColMap = (Map<String, String>) method.invoke(destVO, null);
		}
		// copy field value
		for (String key : destColMap.keySet()) {
			if (srcColMap.containsKey(key)) {
				String field = srcColMap.get(key);
				Field fld = destCls.getDeclaredField(field);
				fld.setAccessible(true);
				fld.set(destVO, srcValMap.get(key));
			}
		}

	}

}
