/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_EAS_0901Event.java
*@FileTitle : Remark Detail 조회/추가/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2008-11-22
*@LastModifier : Yaini
*@LastVersion : 1.0
* 2008-11-24 Yaini
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.terminalmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_EAS_0911Event<br>
 * @author 
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0911Event extends EventSupport {
	

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private String ofcCd = null;

	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	
}
