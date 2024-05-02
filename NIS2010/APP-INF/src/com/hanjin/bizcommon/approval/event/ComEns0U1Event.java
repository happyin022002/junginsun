/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_0U1Event.java
*@FileTitle : VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-31 Hyung Choon_Roh
* 1.0 최초 생성
* 2015.07.20 심성윤 [CHM-201536387] [Develop]ALPS Auth 사후 결재 기능 탭 로직 추가(0U1,0U2,0V1) 
=========================================================*/
package com.hanjin.bizcommon.approval.event;

import java.util.Arrays;

import com.hanjin.bizcommon.approval.vo.ApprovalCsrVO;
import com.hanjin.bizcommon.approval.vo.ApprovalStaffVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationAproVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * COM_ENS_0T1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_ENS_0U1HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hyung Choon_Roh
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ComEns0U1Event extends EventSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4239335916203863181L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ApprovalStaffVO approvalStaffVO = null;
	private AuthorizationAproVO authorizationAproVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ApprovalCsrVO[] approvalCsrVOs = null;
	private AuthorizationAproVO[] authorizationAproVOs = null;
	
	
	public ComEns0U1Event(){}
	
	public void setApprovalStaffVO(ApprovalStaffVO approvalStaffVO){
		this.approvalStaffVO = approvalStaffVO;
	}

	public void setApprovalCsrVOS(ApprovalCsrVO[] approvalCsrVOs){
		if(approvalCsrVOs != null){
			ApprovalCsrVO[] tmpVOs = Arrays.copyOf(approvalCsrVOs, approvalCsrVOs.length);
			this.approvalCsrVOs = tmpVOs;
		}
	}

	public ApprovalStaffVO getApprovalStaffVO(){
		return approvalStaffVO;
	}

	public ApprovalCsrVO[] getApprovalCsrVOS(){
		ApprovalCsrVO[] rtnVOs = null;
		if (this.approvalCsrVOs != null) {
			rtnVOs = Arrays.copyOf(approvalCsrVOs, approvalCsrVOs.length);
		}
		return rtnVOs;
	}
	
	/**
	 * 
	 * @param authorizationAproVOs
	 */
	public void setAuthorizationAproVOS(AuthorizationAproVO[] authorizationAproVOs){		
		if(authorizationAproVOs != null){
			AuthorizationAproVO[] tmpVOs = Arrays.copyOf(authorizationAproVOs, authorizationAproVOs.length);
			this.authorizationAproVOs = tmpVOs;
		}
	}
	
	
	/**
	 * 
	 * @return AuthorizationInquiryVO[] rtnVOs
	 */
	public AuthorizationAproVO[] getAuthorizationAproVOS(){		
		AuthorizationAproVO[] rtnVOs = null;
		if (this.authorizationAproVOs != null) {
			rtnVOs = Arrays.copyOf(authorizationAproVOs, authorizationAproVOs.length);
		}
		return rtnVOs;
	}
	
	/**
	 * 
	 *  @param authorizationInquiryVO
	 */
	public void setAuthorizationAproVO(AuthorizationAproVO authorizationAproVO){
		this.authorizationAproVO = authorizationAproVO;
	}
	
	/**
	 * 
	 * @return authorizationInquiryVO
	 */
	public AuthorizationAproVO getAuthorizationAproVO(){
		return authorizationAproVO;
	}
}
