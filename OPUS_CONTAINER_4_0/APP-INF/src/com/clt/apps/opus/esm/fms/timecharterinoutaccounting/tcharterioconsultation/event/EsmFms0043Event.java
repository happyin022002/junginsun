/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0043Event.java
*@FileTitle : Slip Correction - Master
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.07 정윤태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSlipApprovalVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0043 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0043HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung, Yoon-Tae
 * @see ESM_FMS_0043HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0043Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/* CSR No */
	private String csrNo = "";
	
	/* CSR Desc */
	private String csrDesc = "";

	private CondSearchSlipApprovalVO condSearchSlipApprovalVO = null;
	
	public void setCondSearchSlipApprovalVO(CondSearchSlipApprovalVO condSearchSlipApprovalVO){
		this.condSearchSlipApprovalVO = condSearchSlipApprovalVO;
	}

	public CondSearchSlipApprovalVO getCondSearchSlipApprovalVO(){
		return condSearchSlipApprovalVO;
	}
	
	public String getCsrNo() {
		return csrNo;
	}

	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	public String getCsrDesc() {
		return csrDesc;
	}

	public void setCsrDesc(String csrDesc) {
		this.csrDesc = csrDesc;
	}
}