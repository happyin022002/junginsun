/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_034Event.java
*@FileTitle : FAC AP Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-30
*@LastModifier : Jung-Hyung, Kim
*@LastVersion : 1.0
* 2007-01-30 Jung-Hyung, Kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.facaudit.event;

import com.clt.apps.opus.esm.agt.common.event.AGTEvent;
import com.clt.framework.core.controller.html.HTMLAction;

/**
 * ESM_AGT_034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Junghyung_kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0034Event extends AGTEvent {

	/**
	 * ESM_AGT_O10Event 생성자
	 */
	public EsmAgt0034Event(){}

	/**
	 * Event 명을 반환한다.
	 * @return String 
	 */
	public String getEventName() {
		return "ESM_AGT_034Event";
	}

	/**
	 * Event 명을 반환한다.
	 * @return String 
	 */
	public String toString() {
		return "ESM_AGT_034Event";
	}

}
