/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1093HTMLAction.java
*@FileTitle : Inbound C/S USA_Instruction Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsCustSvcInstrsVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-1093 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-1093HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG-1093HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1093Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Booking No.  */
	private String bkgNo = "";

	/**
     * D/O Release Reference
     */
    private UsCustSvcInstrsVO usCustSvcInstrs = null;	
	
	public EsmBkg1093Event(){}
	
	
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getBkgNo() {
		return bkgNo;
	}


	public UsCustSvcInstrsVO getUsCustSvcInstrs() {
		return usCustSvcInstrs;
	}


	public void setUsCustSvcInstrs(UsCustSvcInstrsVO usCustSvcInstrs) {
		this.usCustSvcInstrs = usCustSvcInstrs;
	}


	

}