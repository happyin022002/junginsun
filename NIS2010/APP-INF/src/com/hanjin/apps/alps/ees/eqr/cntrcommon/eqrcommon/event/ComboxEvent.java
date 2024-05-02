/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ComboxEvent.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-27
*@LastModifier :  SHIN DONG IL
*@LastVersion : 1.0
* 2013-05-27  SHIN DONG IL
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.event;

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