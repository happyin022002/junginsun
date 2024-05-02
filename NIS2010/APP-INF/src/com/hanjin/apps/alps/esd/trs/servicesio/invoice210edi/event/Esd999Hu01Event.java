/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Esd999Hu01Event.java
*@FileTitle : Invoice 210 EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009-05-08
*@LastModifier : eunju son
*@LastVersion : 1.0
* 2009-05-08 eunju son
* 1.0 최초생성
=============================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice210edi.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *  PDTO(Data Transfer Object including Parameters)<br>
 * - HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Sang-Woo
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class Esd999Hu01Event extends EventSupport {
	
public Esd999Hu01Event(){}
	
	public String str = null;


	public String getEventName() {
		return "Esd999Hu01Event";
	}

	public String toString() {
		return "Esd999Hu01Event";
	}
	
	public String getString() {
		return str;
	}

	public void setString(String str) {
		this.str = str;
	}

}
