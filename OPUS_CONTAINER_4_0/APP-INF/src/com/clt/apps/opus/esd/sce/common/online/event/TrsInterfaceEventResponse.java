/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TrsInterfaceEventResponse.java
*@FileTitle : TrsInterfaceEventResponse
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-18
*@LastModifier : changgyu kim
*@LastVersion : 1.0
* 2007-01-18 changgyu kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.common.online.event;

import com.clt.framework.support.layer.event.EventResponseSupport;



/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author changgyu kim
 * @see TrsInterfaceBSC 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("deprecation")
public class TrsInterfaceEventResponse extends EventResponseSupport {
	private static final long serialVersionUID = 1L;

	// Success Flag
	private String successFlag;

	/**
	 * TrsInterfaceEventResponse 객체를 생성
	 */
	public TrsInterfaceEventResponse() {
	}

	/**
	 * @return SuccessFlg
	 */
	public String getSuccessFlag() {
		return this.successFlag ;
	}

	/**
	 * 객체 표현 문자열(TrsInterfaceEventResponse)을 반환
	 * 
	 * @return String TrsInterfaceEventResponse
	 */
	public String toString() {
		return "TrsInterfaceEventResponse";
	}

	/**
	 * 이벤트 명(TrsInterfaceEventResponse)을 반환
	 * 
	 * @return String TrsInterfaceEventResponse
	 */
	public String getEventName() {
		return "TrsInterfaceEventResponse";
	}

}