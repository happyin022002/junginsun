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


import org.apache.log4j.Logger;

import com.hanjin.framework.core.layer.event.EventException;

/**
 * ENIS-ESD Business Logic Basic Command implementation<br>
 * - ENIS-ESD에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see TESeBillingManageBC 참조
 * @since J2EE 1.4
 */
public class TESeBillingManageParseUtil {

	/**
	 * log
	 */
	protected static Logger log = Logger.getLogger(TESeBillingManageParseUtil.class.getName());

	/**
	 * F/F parser 유형
	 */
	private TESeBillingManageFFParse ffParser = null;
	
	/**
	 * TESeBillingManageBC default 생성자 - default Parser는 일반 F/F분해
	 * 
	 */
	public TESeBillingManageParseUtil(){
		ffParser = new TESeBillingManageFFParseSTRImpl();
	}
	
	/**
	 * TESeBillingManageBC 생성자
	 * -> PARSER UTIL CD에 따라 분기를 해야 한다.
	 * 
	 * @param tp_cd
	 */
	public TESeBillingManageParseUtil(String tp_cd){
		if (tp_cd!=null){
			if (tp_cd.trim().equals(TESeBillingManageFFParse.PARSER_UTIL_STR_01)){
				this.ffParser = new TESeBillingManageFFParseSTRImpl();		
//			} else if (tp_cd.trim().equals(TESeBillingManageFFParse.PARSER_UTIL_XML_01)){
//				this.ffParser = new TESeBillingManageFFParseXMLImpl();
//			} else if (tp_cd.trim().equals(TESeBillingManageFFParse.PARSER_UTIL_PDF_01)){
//				this.ffParser = new TESeBillingManageFFParsePDFImpl();				
			}
		}
	}

	/**
	 * parser 변경
	 * @param newffParser
	 * @throws EventException
	 */
	public void changeFFParser(TESeBillingManageFFParse newffParser) throws EventException {
		if (newffParser!=null){
			this.ffParser = newffParser;	
		}
	}

	/**
	 * parser 변경
	 * @param tp_cd
	 * @throws EventException
	 */
	public void changeFFParser(String tp_cd) throws EventException {
		if (tp_cd!=null){
			if (tp_cd.trim().equals(TESeBillingManageFFParse.PARSER_UTIL_STR_01)){
				this.ffParser = new TESeBillingManageFFParseSTRImpl();		
//			} else if (tp_cd.trim().equals(TESeBillingManageFFParse.PARSER_UTIL_XML_01)){
//				this.ffParser = new TESeBillingManageFFParseXMLImpl();
//			} else if (tp_cd.trim().equals(TESeBillingManageFFParse.PARSER_UTIL_PDF_01)){
//				this.ffParser = new TESeBillingManageFFParsePDFImpl();
			}
		}
	}
	
	/**
	 * F/F을 parse method로 해당 tag만 대상으로 DATA 분리해 내기
	 * 
	 * @param obj
	 * @param str_ff
	 * @param tag_nm
	 * @throws EventException
	 */
	public Object getTagUnitData(String str_ff, String tag_nm) throws EventException {
		log.error("\n\n BBBB - TESeBillingManageUtil.getTagUnitData - ########################################### ");
		try {
			return ffParser.getTagUnitData(str_ff, tag_nm);	
		} catch(Exception e){
			log.debug(e.getMessage());
			throw new EventException(e.getMessage());
		}
	}

}