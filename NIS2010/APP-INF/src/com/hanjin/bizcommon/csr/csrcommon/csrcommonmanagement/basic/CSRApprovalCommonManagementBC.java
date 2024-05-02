/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSRApprovalCommonManagementBC.java
*@FileTitle : Approval Step & Comments
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.10
*@LastModifier : 9014787
*@LastVersion : 1.0
* 2014.07.10 9014787
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.basic;

import java.util.List;

import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo.CSRApprovalCommonManagementVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-CSRCommonManagement Business Logic Command Interface<br>
 * - ALPS-CSRCommonManagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 9014787
 * @see Ui_csr_0020EventResponse 참조
 * @since J2EE 1.6
 */
public interface CSRApprovalCommonManagementBC {
    

	/**
	 * COM_CSR_0020 조회 이벤트 처리<br>
	 * Approval Step & Comments :COM_CSR_0020 화면에 대한 조회 이벤트 처리<br>
	 * @author 9014787
	 * @param CSRApprovalCommonManagementVO vo
	 * @return List<CSRApprovalCommonManagementVO>
	 * @exception EventException
	 */
    public List<CSRApprovalCommonManagementVO> aproStepAndCmt(CSRApprovalCommonManagementVO vo) throws EventException;

    
	/**
	 * COM_CSR_0020 멀티 이벤트 처리<br>
	 * Approval Step & Comments : COM_CSR_0020  화면에 대한 멀티 이벤트 처리<br>
	 * @author 9014787
	 * @param CSRApprovalCommonManagementVO vo
	 * @exception EventException
	 */
    public void commentSave(CSRApprovalCommonManagementVO vo) throws EventException;
    
    /**
	 * COM_CSR_0016 멀티 이벤트 처리<br>
	 * CSR Approval Type Selection : COM_CSR_0016  화면에 대한 멀티 이벤트 처리<br>
	 * @author 2015513
	 * @param String csrNo
	 * @param String aproTpCd
	 * @exception EventException
	 */
    public void saveCsrAproTpCd(String csrNo, String aproTpCd) throws EventException;
}