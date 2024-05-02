/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EdiEns004Event.java
*@FileTitle : USATruck WO 신고 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-08
*@LastModifier : Park Jun-Yong
*@LastVersion : 1.0
* 2008-07-08 Park Jun-Yong
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.usatruckediwoack.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * PDTO(Data Transfer Object including Parameters)<br>
 * - 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Jun-Yong
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EdiEns004Event extends EventSupport {

	public EdiEns004Event(){}
	
	public String str = null;

	public String getEventName() {
		return "EdiEns004Event";
	}

	public String toString() {
		return "EdiEns004Event";
	}

	public String getString() {
		return str;
	}

	public void setString(String str) {
		this.str = str;
	}
}
