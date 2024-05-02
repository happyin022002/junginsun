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
package com.hanjin.apps.alps.esm.fms.fmscommonutil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.bizcommon.util.BizComException;
import com.hanjin.bizcommon.util.BizComUtil;
import com.hanjin.framework.component.util.DateTime;


/**
 * 업무공통에서 사용하는 공통 코드 등을 구현<br>
 * @author Young Du Lee
 * @see 
 * @since J2EE 1.4
 */
public final class BizComFmsUtil {
	
	/**
	 * Constructor<br>
	 */
	public BizComFmsUtil() {
	}


	/**
	 * Method separating several parameters 
	 * ex) TI|TO to ArrayList
	 * @param param
	 * @param sep
	 * @return
	 * @throws BizComException
	 */
	public static List<String> getSeperationParameter(String param, String sep) throws BizComException {
		List<String> list = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !param.equals("") ) {
			list = new ArrayList<String>();
			st = new StringTokenizer(param, sep);
			while( st.hasMoreTokens() ) {
				list.add(j++, st.nextToken());
			}
		}
		return list;
	}	
}
