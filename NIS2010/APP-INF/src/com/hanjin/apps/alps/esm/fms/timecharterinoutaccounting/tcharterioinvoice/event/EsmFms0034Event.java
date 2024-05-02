/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0034Event.java
*@FileTitle : Hire Revenue Retrieve / Window
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.06.26 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon Seyeong
 * @see ESM_FMS_0034HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0034Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Contract No. */
	private String fletCtrtNo = "";
	
	/** Currency Code */
	private String currCd = "";
	
	public String getFletCtrtNo() {
		return fletCtrtNo;
	}

	public void setFletCtrtNo(String currCd) {
		this.fletCtrtNo = currCd;
	}
	
	public String getCurrCd() {
		return currCd;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
}