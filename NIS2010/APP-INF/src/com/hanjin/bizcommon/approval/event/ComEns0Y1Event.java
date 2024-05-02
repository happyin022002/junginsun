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
=========================================================*/
package com.hanjin.bizcommon.approval.event;

import com.hanjin.bizcommon.approval.vo.UnApprovalCsrVO;
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
public class ComEns0Y1Event extends EventSupport {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5244766153206907948L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private UnApprovalCsrVO unApprovalCsrVO = null;
	
	/** Table Value Object 조회 조건 및 다건 처리  */
	private UnApprovalCsrVO[] unApprovalCsrVOS = null;	
	
	public ComEns0Y1Event(){}


	/**
	 * @return the unApprovalCsrVO
	 */
	public UnApprovalCsrVO getUnApprovalCsrVO() {
		return unApprovalCsrVO;
	}


	/**
	 * @param unApprovalCsrVO the unApprovalCsrVO to set
	 */
	public void setUnApprovalCsrVO(UnApprovalCsrVO unApprovalCsrVO) {
		this.unApprovalCsrVO = unApprovalCsrVO;
	}


	/**
	 * @return the unApprovalCsrVOS
	 */
	public UnApprovalCsrVO[] getUnApprovalCsrVOS() {
		return unApprovalCsrVOS;
	}


	/**
	 * @param unApprovalCsrVOS the unApprovalCsrVOS to set
	 */
	public void setUnApprovalCsrVOS(UnApprovalCsrVO[] unApprovalCsrVOS) {
		this.unApprovalCsrVOS = unApprovalCsrVOS;
	}

}
