/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : WebDoLinkEvent.java
 *@FileTitle : WebDoLinkEvent
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011-10-07
 *@LastModifier : Choi jonghyek
 *@LastVersion : 1.0
 * 2011-10-07 Choi jonghyek
 * 1.0 최초 생성
 * 2011.12.09 김종호 [CHM-201113793] [TRS] HJS Homepage Renewal - ALPS 외부 I/F 개발(Webservice)
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.webdo.event;

import java.util.HashMap;

import com.clt.apps.opus.esd.trs.servicesio.webdo.vo.IfSchemaVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * WebDoLinkRSC 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - WebDoLinkIWSProxy에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Choi jonghyek
 * @see 참조
 * @since J2EE 1.6
 */
public class WebDoLinkEvent extends EventSupport {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private HashMap parameterMap = null;
	String str = null;
	private IfSchemaVO ifSchemaVO = null;

	/**
	 * Constructor
	 */
	public WebDoLinkEvent() {
	}

	/**
	 * @param str_ String
	 */
	public WebDoLinkEvent(String str_) {
		str = str_;
	}

	/**
	 * @param ifSchemaVO IfSchemaVO
	 */
	public WebDoLinkEvent(IfSchemaVO ifSchemaVO) {
		this.ifSchemaVO = ifSchemaVO;
	}

	/**
	 * Evenct Name 을 반환한다.
	 * 
	 * @return "ReceiveEAIEvent"
	 */
	public String getEventName() {
		return "WebDoLinkEvent";
	}

	/**
	 * String Casting 된 Evenct Name 을 반환한다.
	 * 
	 * @return "CreateFlatFileEvent"
	 */
	public String toString() {
		return "WebDoLinkEvent";
	}

	/**
	 * getStr
	 * 
	 * @param
	 * @return String
	 */
	public String getStr() {
		return str;
	}

	/**
	 * setIfSchema setter function
	 * 
	 * @param ifSchemaVO IfSchemaVO
	 * @return
	 */
	public void setIfSchema(IfSchemaVO ifSchemaVO) {
		this.ifSchemaVO = ifSchemaVO;
	}

	/**
	 * getIfSchema getter function
	 * 
	 * @param
	 * @return IfSchemaVO
	 */
	public IfSchemaVO getIfSchema() {
		return this.ifSchemaVO;
	}

	/**
	 * @return Returns the parameterMap.
	 */
	@SuppressWarnings("rawtypes")
	public HashMap getParameterMap() {
		return parameterMap;
	}

	/**
	 * @param parameterMap
	 */
	@SuppressWarnings("rawtypes")
	public void setParameterMap(HashMap parameterMap) {
		this.parameterMap = parameterMap;
	}

}
