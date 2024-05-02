/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ComCsr0020Event.java
*@FileTitle : Approval Step & Comments
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.10
*@LastModifier : 9014787
*@LastVersion : 1.0
* 2014.07.10 9014787
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.event;

import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo.CSRApprovalCommonManagementVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * COM_CSR_0020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_CSR_0020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 9014787
 * @see COM_CSR_0020HTMLAction 참조
 * @since J2EE 1.6
 */

public class ComCsr0020Event extends EventSupport {

	private static final long serialVersionUID = -7654780329136078305L;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CSRApprovalCommonManagementVO approvalComVO = null;

	public ComCsr0020Event(){}

	/**
	 * 
	 * @param approvalComVO
	 */
	public void setApprovalCsrVO(CSRApprovalCommonManagementVO approvalComVO){
		this.approvalComVO = approvalComVO;
	}

	/**
	 * 
	 * @return approvalComVO
	 */
	public CSRApprovalCommonManagementVO getApprovalComVO(){
		return approvalComVO;
	}
}
