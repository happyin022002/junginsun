/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms00401Event.java
*@FileTitle : RCS / Invoice No Inquiry - Window
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.08.03 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_00401 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_00401HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi, WooSeok
 * @see ESM_FMS_00401HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms00401Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String fletCtrtNo = "";
	private String fmDt = "";
	private String toDt = "";
	private String currCd = "";

	public String getFletCtrtNo() {
		return fletCtrtNo;
	}

	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}

	public String getFmDt() {
		return fmDt;
	}

	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}

	public String getToDt() {
		return toDt;
	}

	public void setToDt(String toDt) {
		this.toDt = toDt;
	}

	public String getCurrCd() {
		return currCd;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
}