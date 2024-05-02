/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0041Event.java
*@FileTitle : Slip Inquiry Master
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.03 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSlipApprovalVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung, Yoon-Tae
 * @see ESM_FMS_0041HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0041Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private CondSearchSlipApprovalVO condSearchSlipApprovalVO = null;
	
	/** Slip Type */
	private String slipType = null;

	/** Flet Contract Type Code */
	private String fletCtrtTpCd = null;

	/** CSR No */
	private String csrNo = null;
	
	public void setCondSearchSlipApprovalVO(CondSearchSlipApprovalVO condSearchSlipApprovalVO){
		this.condSearchSlipApprovalVO = condSearchSlipApprovalVO;
	}

	public void setSlipType(String slipType){
		this.slipType = slipType;
	}

	public void setFletCtrtTpCd(String fletCtrtTpCd){
		this.fletCtrtTpCd = fletCtrtTpCd;
	}

	public void setCsrNo(String csrNo){
		this.csrNo = csrNo;
	}
	
	public CondSearchSlipApprovalVO getCondSearchSlipApprovalVO(){
		return condSearchSlipApprovalVO;
	}
	
	public String getSlipType(){
		return slipType;
	}

	public String getFletCtrtTpCd(){
		return fletCtrtTpCd;
	}

	public String getCsrNo(){
		return csrNo;
	}
}