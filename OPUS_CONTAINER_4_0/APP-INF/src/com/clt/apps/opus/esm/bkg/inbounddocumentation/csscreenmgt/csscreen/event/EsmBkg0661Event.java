/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0661Event.java
*@FileTitle : Awkward Dimension Detail(s) Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-0661 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0661HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG-0661HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0661Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Booking No.  */
	private String bkgNo = "";

	/** Container No. */
	private String cntrNo = "";
	
	/** BL No. */
	private String blNo = "";
	
	/** BL Type Code */
	private String blTpCd = "";
	
	
	public EsmBkg0661Event(){}
	
	
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