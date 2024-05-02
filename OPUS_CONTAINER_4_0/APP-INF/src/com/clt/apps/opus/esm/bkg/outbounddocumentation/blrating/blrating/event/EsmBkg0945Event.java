/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0945Event.java
*@FileTitle : Exchange Rate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.18 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0945 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0945HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see ESM_BKG_0945HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0945Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String bkgNo = null;

	/**
	 * @return the bkg_no
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * @param bkg_no the bkg_no to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
}