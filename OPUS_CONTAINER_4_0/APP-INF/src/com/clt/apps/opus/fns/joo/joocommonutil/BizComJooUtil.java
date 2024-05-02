/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BizComException.java
*@FileTitle : 공통
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-31 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommonutil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.clt.bizcommon.util.BizComException;
import com.clt.bizcommon.util.BizComUtil;
import com.clt.framework.component.util.DateTime;


/**
 * 업무공통에서 사용하는 공통 코드 등을 구현<br>
 * @author Hyung Choon_Roh
 * @see 
 * @since J2EE 1.6
 */
public final class BizComJooUtil {
	
	
	/**
	 * Constructor<br>
	 */
	public BizComJooUtil() {
	}

	
	/**
	 * SLP ISS DT 생성 Function.
	 * @param date
	 * @return
	 */
	public static String getFormatSlpIssueDate(String date) throws BizComException {
		Calendar cal = Calendar.getInstance();
		String pattern = "yyMM";
		String strYyMm = "";
		date = date.replaceAll("-", "");
		
		if(date.length() >= 8){
			int iyyyy = Integer.parseInt(date.substring(0,4));
			int imm = Integer.parseInt(date.substring(4,6));
			int idd = Integer.parseInt(date.substring(6,8));
		  
			cal.set(iyyyy, (imm-1), idd);
		  
			strYyMm = DateTime.getFormatDate(cal.getTime(), pattern);
		  
		}else{
			strYyMm = DateTime.getFormatDate(cal.getTime(), pattern);
		}
		return strYyMm;
	}
	
	/**
	 * yyyymmdd > yymm 으로 리턴.
	 * @param date
	 * @return
	 */
	public static String getFormatSlpIssueDateYmdToYyMm(String date){
		Calendar cal = Calendar.getInstance();
		String pattern = "yyMM";
		String strYyMm = "";
		date = date.replaceAll("-", "");
		
		if(date.length() == 8){
			strYyMm = date.substring(2, 6);
		}else{
			strYyMm = DateTime.getFormatDate(cal.getTime(), pattern);
		}
		return strYyMm;
	}
	
	/**
	 * csrno > yymm 으로 리턴.
	 * 06SSINWA14110002 > 1411
	 * @param date
	 * @return
	 */
	public static String getFormatSlpIssueDateCsrNoToYyMm(String csrNo){
		String strYyMm = "";
		
		int iStart = csrNo.length()-8;
		int iEnd = iStart + 4;
		
		strYyMm = csrNo.substring(iStart, iEnd);
		return strYyMm;
	}
	
	/**
	 * Method separating several parameters 
	 * ex) TI|TO to ArrayList
	 * @param param
	 * @param sep
	 * @return
	 * @throws BizComException
	 */
	public static List<String> getSeperationParameterList(String param, String sep) throws Exception {
		List<String> list = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !StringUtils.isEmpty(param) && !param.equals("") ) {
			list = new ArrayList<String>();
			st = new StringTokenizer(param, sep);
			while( st.hasMoreTokens() ) {
				String tmpStr = st.nextToken(); 
				if(!"ALL".equals(tmpStr.trim()) && !"".equals(tmpStr.trim())){
					list.add(j++, tmpStr);
				}
			}
		}
		return list;
	}
	
	/**
	 * Method separating several parameters 
	 * ex) TI|TO to ArrayList
	 * @param param
	 * @param sep
	 * @param String except
	 * @return
	 * @throws BizComException
	 */
	public static List<String> getSeperationParameterList(String param, String sep, String except) throws Exception {
		List<String> list = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !StringUtils.isEmpty(param) && !param.equals("") ) {
			list = new ArrayList<String>();
			st = new StringTokenizer(param, sep);
			while( st.hasMoreTokens() ) {
				String tmpStr = st.nextToken(); 
				if(!"ALL".equals(tmpStr.trim()) && !"".equals(tmpStr.trim()) && !except.equals(tmpStr.trim()) ){
					list.add(j++, tmpStr);
				}
			}
		}
		return list;
	}
	
	/**
	 * Method separating several parameters 
	 * ex) TI|TO to ArrayList
	 * @param param
	 * @param sep
	 * @param String[] except
	 * @return
	 * @throws BizComException
	 */
	public static List<String> getSeperationParameterList(String param, String sep, String[] except) throws Exception {
		List<String> list = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !StringUtils.isEmpty(param) && !param.equals("") ) {
			list = new ArrayList<String>();
			st = new StringTokenizer(param, sep);
			while( st.hasMoreTokens() ) {
				String tmpStr = st.nextToken(); 
				if(!"ALL".equals(tmpStr.trim()) && !"".equals(tmpStr.trim()) && !except.equals(tmpStr.trim()) ){
					if(except != null && except.length > 0){
						boolean isExist = false;
						for(int i=0; i < except.length; i++){
							if(except[i].equals(tmpStr.trim())){
								isExist = true;
								break;
							}
						}
						if(!isExist) list.add(j++, tmpStr);
					}else{
						list.add(j++, tmpStr);
					}
				}
			}
		}
		return list;
	}	
	
	
	/**
	 * isExistsParameter
	 * @param param String
	 * @param str String
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean isExistsParameter(String param, String str) throws Exception{
		str = str.toUpperCase();
		return (param.toUpperCase().indexOf(str) > -1) ? true : false;
	}	
	
	/**
	 * CodeInfo List를 parsing하여 Select tag를 생성하기 위한 String을 생성한다.<br>
	 * ex) val1|val2|val3|$$|text1|text2|text3 <br>
	 *  CODE_DELIMITTER로 split하면 value string과 text string이 생성되고, 각각 string을 <br>
	 *  |로 split하면 string array로 반환받을 수 있다.
	 * 
	 * @param codeList Collection<CodeInfo>
	 * @return String
	 * @throws 
	 */
	public static String getCodeSelectString(List<JooCodeInfoVO> codeList){
		
	    StringBuilder itemComboText1 = new StringBuilder();
	    StringBuilder itemComboValue1 = new StringBuilder();
		int iCnt = 0;
	    for(JooCodeInfoVO vo : codeList){
	    	if(iCnt != 0){
	    		itemComboText1.append("|");
	            itemComboValue1.append("|");
	    	}
	    	
	    	itemComboValue1.append(vo.getCode());
	        itemComboText1.append(vo.getName());
	        iCnt++;
	    }
	    return itemComboValue1  +BizComUtil.CODE_DELIMITTER + itemComboText1;
	}
}
