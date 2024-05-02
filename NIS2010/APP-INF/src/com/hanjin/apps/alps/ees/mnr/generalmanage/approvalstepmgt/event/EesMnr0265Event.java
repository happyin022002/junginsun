/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0265Event.java
*@FileTitle : Write Off Approval Inquiry
*Open Issues :
*Change history : 
*@LastModifyDate : 2013.09.05	
*@LastModifier : HAN Jonghee 	
*@LastVersion : 1.0
* 2013.09.05 HAN Jonghee  
* 1.0 Creation
* 2014-02-26 Jonghee HAN Live malfunction fixed
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.event;


import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.ApprovalStepGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0265 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0265HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author HAN Jonghee
 * @see ees_mnr_0265HTMLAction 참조
 * 
 * @since J2EE 1.6   
 */    
      
public class EesMnr0265Event extends EventSupport { 

	private static final long serialVersionUID = 1L; 
	 
	public EesMnr0265Event(){}   

	/** Total Loss 조회 조건 및 단건 처리  */
	private ApprovalStepGRPVO approvalStepGRPVO = null;

	public ApprovalStepGRPVO getApprovalStepGRPVO() {
		return approvalStepGRPVO;
	}

	public void setApprovalStepGRPVO(ApprovalStepGRPVO approvalStepGRPVO) {
		this.approvalStepGRPVO = approvalStepGRPVO;
	}
}