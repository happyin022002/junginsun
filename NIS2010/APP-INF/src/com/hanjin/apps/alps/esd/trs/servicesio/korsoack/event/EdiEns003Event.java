/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EdiEns003Event.java
*@FileTitle : Kor 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.korsoack.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * COM_ENS_0H1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_ENS_0H1HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Sang-Woo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EdiEns003Event extends EventSupport {

	public EdiEns003Event(){}
	
	public String str = null;

	public String getEventName() {
		return "EdiEns003Event";
	}

	public String toString() {
		return "EdiEns003Event";
	}

	public String getString() {
		return str;
	}

	public void setString(String str) {
		this.str = str;
	}
}