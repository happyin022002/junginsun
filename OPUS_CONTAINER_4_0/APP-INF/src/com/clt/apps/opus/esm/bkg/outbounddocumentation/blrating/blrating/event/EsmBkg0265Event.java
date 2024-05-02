/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0265Event.java
*@FileTitle : Freight & Charge_Freight & Charge Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.26 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0265 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0265HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_0265HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0265Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String bkgNo = "";
	private String diffRmk = "";
	private String interRmk ="";

	/**
	 * @return the diff_rmk
	 */
	public String getDiff_rmk() {
		return diffRmk;
	}
	/**
	 * @param diff_rmk the diff_rmk to set
	 */
	public void setInter_rmk(String inter_rmk) {
		this.interRmk = inter_rmk;
	}
	
	/**
	 * @return the inter_rmk
	 */
	public String getInter_rmk() {
		return interRmk;
	}
	/**
	 * @param diff_rmk the diff_rmk to set
	 */
	public void setDiff_rmk(String diff_rmk) {
		this.diffRmk = diff_rmk;
	}
	
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