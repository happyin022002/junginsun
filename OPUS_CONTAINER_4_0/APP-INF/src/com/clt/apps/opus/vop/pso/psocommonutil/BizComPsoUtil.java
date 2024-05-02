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
package com.clt.apps.opus.vop.pso.psocommonutil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import com.clt.bizcommon.util.BizComException;


/**
 * 업무공통에서 사용하는 공통 코드 등을 구현<br>
 * @author Hyung Choon_Roh
 * @see 
 * @since J2EE 1.4
 */
public final class BizComPsoUtil {
	
	/**
	 * Constructor<br>
	 */
	public BizComPsoUtil() {
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
		if( !param.equals("") ) {
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
	 * @return
	 * @throws BizComException
	 */
	public static List<String> getSeperationParameterList(String param, String sep, String prefix) throws Exception {
		List<String> list = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !param.equals("") ) {
			list = new ArrayList<String>();
			st = new StringTokenizer(param, sep);
			while( st.hasMoreTokens() ) {
				String tmpStr = st.nextToken(); 
				if(!"ALL".equals(tmpStr.trim()) && !"".equals(tmpStr.trim())){
					list.add(j++, prefix+tmpStr);
				}
			}
		}
		return list;
	}
	
	/**
	 * Exists parameters 
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
	 * 
	 * @param arrayArgs
	 * @param String[] arrayArgs
	 * @return HashMap<String, String>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static HashMap<String, String> getStringArrayToHashMap(String[] arrayArgs) {
		HashMap returnHashTable = new HashMap();
		for (String args : arrayArgs) {
			returnHashTable.put(args, args);
		}
		return returnHashTable;
	}
}
