/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EdiEns001Event.java
*@FileTitle : USARail WO 신고 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.usarailwoack.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * PDTO(Data Transfer Object including Parameters)<br>
 * - 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Sang-Woo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EdiEns001Event extends EventSupport {

	public EdiEns001Event(){}
	
	public String str = null;

	public String getEventName() {
		return "EdiEns001Event";
	}

	public String toString() {
		return "EdiEns001Event";
	}

	public String getString() {
		return str;
	}

	public void setString(String str) {
		this.str = str;
	}
}
