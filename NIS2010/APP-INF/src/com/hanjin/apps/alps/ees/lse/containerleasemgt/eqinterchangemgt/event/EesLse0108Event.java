/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0108Event.java
*@FileTitle : EQ Interchange Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.01
*@LastModifier : 길정권
*@LastVersion : 1.0
* 2015.06.01 길정권
* 1.0 Creation
* 2015-07-09 [CHM-201536018] EQ INTERCHANGE WORK module 신규 개발 제안
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeReqVO;


/**
 * EES_LSE_0108 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0108HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0108HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0108Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqInterchangeReqVO eqInterchangeReqVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqInterchangeReqVO[] eqInterchangeReqVOs = null;

	public EesLse0108Event(){}
	
	public void setEqInterchangeApprovalVO(EqInterchangeReqVO eqInterchangeReqVO){
		this. eqInterchangeReqVO = eqInterchangeReqVO;
	}

	public void setEqInterchangeApprovalVOS(EqInterchangeReqVO[] eqInterchangeReqVOs){
		this. eqInterchangeReqVOs = eqInterchangeReqVOs;
	}

	public EqInterchangeReqVO getEqInterchangeApprovalVO(){
		return eqInterchangeReqVO;
	}

	public EqInterchangeReqVO[] getEqInterchangeApprovalVOS(){
		return eqInterchangeReqVOs;
	}

}