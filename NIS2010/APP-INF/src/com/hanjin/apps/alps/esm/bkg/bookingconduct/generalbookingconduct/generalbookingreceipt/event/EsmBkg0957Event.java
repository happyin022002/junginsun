/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0957Event.java
*@FileTitle : Code Creation Request Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.28 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
/**
 * ESM_BKG_0957 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0092HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Byung Kyu
 * @see ESM_BKG_0957HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0957Event extends EventSupport  {
	private static final long serialVersionUID = 1L;
	
	private String bkgNo = null;
	private String custTpCd = null;
	
	public EsmBkg0957Event(){}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getCustTpCd() {
		return custTpCd;
	}

	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}	
}
