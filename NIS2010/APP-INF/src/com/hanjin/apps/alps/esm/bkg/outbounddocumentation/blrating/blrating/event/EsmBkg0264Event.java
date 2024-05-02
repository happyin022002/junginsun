/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0264Event.java
*@FileTitle : Freight & Charge_BKG Q'TY Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.26 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0264 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0264HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_0264HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0264Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String bkgNo = null;

	/**
	 * @return the bkg_no
	 */
	public String getBkg_no() {
		return bkgNo;
	}

	/**
	 * @param bkg_no the bkg_no to set
	 */
	public void setBkg_no(String bkg_no) {
		this.bkgNo = bkg_no;
	}

}