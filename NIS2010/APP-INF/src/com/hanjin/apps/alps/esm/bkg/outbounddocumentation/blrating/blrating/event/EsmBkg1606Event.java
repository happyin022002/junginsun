/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1606Event.java
*@FileTitle : Master RFA Route Id Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2009.06.26 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1606 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1606HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_1606HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1606Event extends EventSupport {

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