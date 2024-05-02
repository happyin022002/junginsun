/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0042Event.java
*@FileTitle : Slip Inquiry Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.06 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0042 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0042HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung, Yoon-Tae
 * @see ESM_FMS_0042HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0042Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/* CSR No */
	private String csrNo = "";

	public String getCsrNo() {
		return csrNo;
	}

	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
}