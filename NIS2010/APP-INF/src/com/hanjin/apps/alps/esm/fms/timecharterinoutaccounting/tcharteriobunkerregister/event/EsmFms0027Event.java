/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0027Event.java
*@FileTitle : BOD, BOR Settlement - Window
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.25 정윤태
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_FMS_0027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0027HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung, Yoon-Tae
 * @see ESM_FMS_0027HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0027Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/* Contract No. */
	private String fletCtrtNo = "";
	
	/* csrCurrCd */
	private String csrCurrCd = "";
	
	/* ofcCd. */
	private String ofcCd = "";
	
	/* aproFlg. */
	private String aproFlg = "";

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
	
	public String getAproFlg() {
		return aproFlg;
	}

	public void setAproFlg(String aproFlg) {
		this.aproFlg = aproFlg;
	}
	
}
