/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_0U2Event.java
*@FileTitle : Approval Inquery
*Open Issues :
*Change history :
*@LastModifyDate : 2014-01-02
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2014-01-02 SHIN DONG IL
* 1.0 최초 생성
* 2015.07.20 심성윤 [CHM-201536387] [Develop]ALPS Auth 사후 결재 기능 탭 로직 추가(0U1,0U2,0V1) 
=========================================================*/
package com.hanjin.bizcommon.approval.event;

import java.util.Arrays;

import com.hanjin.bizcommon.approval.vo.ApprovalInqueryCondtionVO;
import com.hanjin.bizcommon.approval.vo.ApprovalInqueryVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationInquiryVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * COM_ENS_0T1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_ENS_0U2HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hyung Choon_Roh
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ComEns0U2Event extends EventSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4239335916203863181L;
	


	/** Table Value Object 조회 조건 및 단건 처리  */
	private ApprovalInqueryCondtionVO approvalInqueryCondtionVO = null;
	private AuthorizationInquiryVO authorizationInquiryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ApprovalInqueryVO[] approvalInqueryVOs = null;	
	private AuthorizationInquiryVO[] authorizationInquiryVOs = null;
	

	public ComEns0U2Event(){}
	
	public ApprovalInqueryVO[] getApprovalInqueryVOs() {		
		ApprovalInqueryVO[] rtnVOs = null;
		if (this.approvalInqueryVOs != null) {
			rtnVOs = Arrays.copyOf(approvalInqueryVOs, approvalInqueryVOs.length);
		}
		return rtnVOs;
	}

	public void setApprovalInqueryVOs(ApprovalInqueryVO[] approvalInqueryVOs) {
		if(approvalInqueryVOs != null){
			ApprovalInqueryVO[] tmpVOs = Arrays.copyOf(approvalInqueryVOs, approvalInqueryVOs.length);
			this.approvalInqueryVOs = tmpVOs;
		}
	}

	public ApprovalInqueryCondtionVO getApprovalInqueryCondtionVO() {
		return approvalInqueryCondtionVO;
	}

	public void setApprovalInqueryCondtionVO(ApprovalInqueryCondtionVO approvalInqueryCondtionVO) {
		this.approvalInqueryCondtionVO = approvalInqueryCondtionVO;
	}
	
	/**
	 * 
	 * @param authorizationInquiryVOs
	 */
	public void setAuthorizationInquiryVOS(AuthorizationInquiryVO[] authorizationInquiryVOs){		
		if(authorizationInquiryVOs != null){
			AuthorizationInquiryVO[] tmpVOs = Arrays.copyOf(authorizationInquiryVOs, authorizationInquiryVOs.length);
			this.authorizationInquiryVOs = tmpVOs;
		}
	}
	
	
	/**
	 * 
	 * @return AuthorizationInquiryVO[] rtnVOs
	 */
	public AuthorizationInquiryVO[] getAuthorizationInquiryVOS(){		
		AuthorizationInquiryVO[] rtnVOs = null;
		if (this.authorizationInquiryVOs != null) {
			rtnVOs = Arrays.copyOf(authorizationInquiryVOs, authorizationInquiryVOs.length);
		}
		return rtnVOs;
	}
	
	/**
	 * 
	 *  @param authorizationInquiryVO
	 */
	public void setAuthorizationInquiryVO(AuthorizationInquiryVO authorizationInquiryVO){
		this.authorizationInquiryVO = authorizationInquiryVO;
	}
	
	/**
	 * 
	 * @return authorizationInquiryVO
	 */
	public AuthorizationInquiryVO getAuthorizationInquiryVO(){
		return authorizationInquiryVO;
	}
}
