/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0942Event.java
*@FileTitle : Attorney Create Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.05.12 안진응
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0942 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0942HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author An Jin Eung
 * @see ESM_BKG_0942HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0942Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = 6505397460113280378L;

    private String cntrNo  = "";
    private String poNo    = "";
	/**
	 * @return the cntrNo
	 */
	public String getCntrNo() {
		return cntrNo;
	}
	/**
	 * @param cntrNo the cntrNo to set
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	/**
	 * @return the poNo
	 */
	public String getPoNo() {
		return poNo;
	}
	/**
	 * @param poNo the poNo to set
	 */
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}


}