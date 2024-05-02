/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ComboxEvent.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-11
*@LastModifier : 김원섭
*@LastVersion : 1.0
* 2006-10-11 김원섭
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esm.spc.common.common.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * Combox 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ComboxHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김원섭
 * @see ComboxHTMLAction 참조
 * @since J2EE 1.4
 */

public class ComboxEvent extends EventSupport {

	/**
	 * event 명을 반환한다.
	 * 
	 * @return String 
	 */
	public String getEventName() {
		return "ComboxEvent";
	}

	/**
	 * event 명을 반환한다.
	 * 
	 * @return String 
	 */
	public String toString() {
		return "ComboxEvent";
	}
}