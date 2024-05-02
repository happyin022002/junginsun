/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0616Event.java
*@FileTitle : Booking EDI Transmit to Terminal
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.25 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0616 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0616HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0616HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0618Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String edirefCd;
	private String edirefId;
	private String vvd;
	
	public EsmBkg0618Event(){}

	public String getEdirefCd() {
		return edirefCd;
	}

	public void setEdirefCd(String edirefCd) {
		this.edirefCd = edirefCd;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public String getEdirefId() {
		return edirefId;
	}

	public void setEdirefId(String edirefId) {
		this.edirefId = edirefId;
	}
	
}