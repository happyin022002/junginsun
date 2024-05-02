/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt7008Event.java
*@FileTitle : Approval Authority Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.09 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.ApprovalRequestUserVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_7008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_7008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Sung Hwan
 * @see EES_DMT_7008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt7008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ApprovalRequestUserVO approvalRequestUserVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ApprovalRequestUserVO[] approvalRequestUserVOs = null;

	public EesDmt7008Event(){}
	
	public void setApprovalRequestUserVO(ApprovalRequestUserVO approvalRequestUserVO){
		this. approvalRequestUserVO = approvalRequestUserVO;
	}

	public void setApprovalRequestUserVOS(ApprovalRequestUserVO[] approvalRequestUserVOs){
		this. approvalRequestUserVOs = approvalRequestUserVOs;
	}

	public ApprovalRequestUserVO getApprovalRequestUserVO(){
		return approvalRequestUserVO;
	}

	public ApprovalRequestUserVO[] getApprovalRequestUserVOS(){
		return approvalRequestUserVOs;
	}

}