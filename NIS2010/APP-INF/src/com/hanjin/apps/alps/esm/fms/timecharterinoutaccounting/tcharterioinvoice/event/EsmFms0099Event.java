/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0099Event.java
*@FileTitle : Owner’s Account - Window
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.25 정윤태
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_FMS_0099 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0099HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br> 
 *
 * @author Jung, Yoon-Tae
 * @see ESM_FMS_0099HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0099Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/* Contract No. */
	private String fletCtrtNo = "";
	
	/* csrCurrCd */
	private String csrCurrCd = "";
	
	/* ofcCd. */
	private String ofcCd = "";
	
	/* slpTp. */
	private String slpTp = "";
	
	public String getFletCtrtNo() {
		return fletCtrtNo;
	}

	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}
	
	public String getCsrCurrCd() {
		return csrCurrCd;
	}

	public void setCsrCurrCd(String csrCurrCd) {
		this.csrCurrCd = csrCurrCd;
	}
	
	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	public String getSlpTp() {
		return slpTp;
	}

	public void setSlpTp(String slpTp) {
		this.slpTp = slpTp;
	}	
	
}