/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AdmSys0025Event.java
*@FileTitle : Job Code Approver Assign
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.10
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.07.10 최덕우
* 1.0 Creation 
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.ApproverVO;


/**
 * ADM_SYS_0025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ADM_SYS_0025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi, DukWoo
 * @see ADM_SYS_0025HTMLAction 참조
 * @since J2EE 1.6
 */

public class AdmSys0025Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Input Value Object 조회 조건 및 단건 처리  */
	private ApproverVO approverVO = null;

	/** Table Value Object Multi Data 처리  */
	private ApproverVO[] approverVOs = null;
	
	public AdmSys0025Event() {}

	
	/**
	 * @return the approverVO
	 */
	public ApproverVO getApproverVO() {
		return approverVO;
	}

	/**
	 * @param approverVO the approverVO to set
	 */
	public void setApproverVO(ApproverVO approverVO) {
		this.approverVO = approverVO;
	}

	/**
	 * @return the approverVOs
	 */
	public ApproverVO[] getApproverVOs() {
		ApproverVO[] rtnVOs = null;
		if(this.approverVOs != null){
			rtnVOs = Arrays.copyOf(this.approverVOs, this.approverVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param approverVOs the approverVOs to set
	 */
	public void setApproverVOs(ApproverVO[] approverVOs) {
		if(approverVOs != null){
			ApproverVO[] tempVOs = Arrays.copyOf(approverVOs, approverVOs.length);
			this.approverVOs = tempVOs;
		}
	}	
	
}