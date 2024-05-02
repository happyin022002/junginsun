/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0659Event.java
*@FileTitle : DG Cargo Detail Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.05.07 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-0659 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0659HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mi Ok
 * @see ESM_BKG-0659HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0659Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Booking No.  */
	private String bkgNo = "";
	
	/** Container No. */
	private String cntrNo = "";
	
	/** BL No. */
	private String blNo = "";
	
	/** BL Type Code */
	private String blTpCd = "";

	
	public EsmBkg0659Event(){}
	
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	

	public String getBkgNo() {
		return bkgNo;
	}

	public String getCntrNo() {
		return cntrNo;
	}
	
	public String getBlNo() {
		return blNo;
	}

	public String getBlTpCd() {
		return blTpCd;
	}	
}