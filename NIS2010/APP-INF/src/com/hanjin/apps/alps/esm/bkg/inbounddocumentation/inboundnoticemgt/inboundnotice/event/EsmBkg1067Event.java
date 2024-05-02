/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1067Event.java
*@FileTitle : Pick up upload history
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.03
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.11.03 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1067 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1067HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mi Ok
 * @see ESM_BKG_1067HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1067Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String bkgNo = "";
	
	private String cntrNo = "";
	
	private String ofcCd = "";

	public EsmBkg1067Event(){}

	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * @param cntrNo the cntrNo to set
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * @return the cntrNo
	 */
	public String getCntrNo() {
		return cntrNo;
	}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}
	


}