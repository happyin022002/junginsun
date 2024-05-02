/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_0H1Event.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-13
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-13 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.continent.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * COM_ENS_0H1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_ENS_0H1HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hyung Choon_Roh
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ComEns0H1Event extends EventSupport {

	/**
	 * Constructor<br>
	 */
	public ComEns0H1Event(){}
	
	/**
     * Event 명을 반환<br>
     * @return String
     */
	public String getEventName() {
		return "ComEns0H1Event";
	}

	/**
     * Class 명을 반환<br>
     * @return String
     */
	public String toString() {
		return "ComEns0H1Event";
	}
}
