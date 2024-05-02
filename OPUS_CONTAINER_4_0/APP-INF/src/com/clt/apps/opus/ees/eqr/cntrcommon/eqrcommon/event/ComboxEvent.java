/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ComboxEvent.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :  
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.event;

import com.clt.framework.support.layer.event.EventSupport;

/** 
 * Combox PDTO(Data Transfer Object including Parameters)<br>
 *
 * @author 
 * @see ComboxHTMLAction 
 * @since J2EE 1.4
 */

public class ComboxEvent extends EventSupport {

	/**
	 * event 
	 * 
	 * @return String 
	 */
	public String getEventName() {
		return "ComboxEvent";
	}

	/**
	 * event 
	 * 
	 * @return String 
	 */
	public String toString() {
		return "ComboxEvent";
	}
}