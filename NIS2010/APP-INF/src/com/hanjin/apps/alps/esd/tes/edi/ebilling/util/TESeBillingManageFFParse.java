/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESeBillingManageBCAbst.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2012-01-04
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.util;

//import java.util.HashMap;

import com.hanjin.framework.core.layer.event.EventException;
//import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ENIS-ESD Business Logic Basic Command implementation<br>
 * - ENIS-ESD에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see TESeBillingManageBC 참조
 * @since J2EE 1.4
 */
public interface TESeBillingManageFFParse {
	
	/**
	 * PARSER 유형
	 */
	public static final String PARSER_UTIL_STR_01 = "STR.01";
	public static final String PARSER_UTIL_XML_01 = "XML.01";
	public static final String PARSER_UTIL_PDF_01 = "PDF.01";
	public static final String PARSER_UTIL_XLS_01 = "XLS.01";
	public static final String PARSER_UTIL_PRV_01 = "PRV.01";
	
	/**
	 * F/F을 parse method로 해당 tag만 대상으로 DATA 분리해 내기
	 * 
	 * @param str_ff
	 * @param tag_nm
	 * @return Object
	 * @throws EventException
	 */
	public Object getTagUnitData(String str_ff, String tag_nm) throws EventException;
	
	
}