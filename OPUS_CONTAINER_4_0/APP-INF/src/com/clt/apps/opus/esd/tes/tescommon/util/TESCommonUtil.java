/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESCommonUtil
*@FileTitle : TESCommonUtil
*Open Issues :
*Change history :
*@LastModifyDate : 2016-03-31
*@LastModifier : KHS
*@LastVersion : 1.0
* 2016-03-31 KHS
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.tescommon.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.clt.apps.opus.esd.tes.common.tescommon.basic.TESCommonBCImpl;
import com.clt.bizcommon.util.BizComException;

/**
 * - TES의 공통 UTIL <br>
 * 
 * @author KHS
 * @see TESCommonBCImpl 참조
 * @since J2EE 1.4
 */
public class TESCommonUtil {

	protected static Logger log = Logger.getLogger(TESCommonUtil.class.getName());
	
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
}
