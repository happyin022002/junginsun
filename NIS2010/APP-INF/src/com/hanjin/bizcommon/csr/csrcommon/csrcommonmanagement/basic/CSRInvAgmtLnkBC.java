/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSRInvAgmtLnkBC.java
*@FileTitle : CSR Invoice Agreement Link
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

import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo.CSRInvAgmtLnkInVO;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo.SelComApFileVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-CSRCommonManagement Business Logic Command Interface<br>
 * - ALPS-CSRCommonManagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 9014787
 * @see Ui_csr_0021EventResponse 참조
 * @since J2EE 1.6
 */

public interface CSRInvAgmtLnkBC {

	/**
	 * COM_CSR_0023 조회 이벤트 처리<br>
	 * CSR Invoice Agreement Link :COM_CSR_0023 화면에 대한 조회 이벤트 처리<br>
	 * @author 9014787
	 * @param ComCsrRequestAgmtVO comCsrRequestAgmtVO
	 * @return List<ComCsrRequestAgmtVO>
	 * @exception EventException
	 */
	public List<ComCsrRequestAgmtVO> searchInvoice(ComCsrRequestAgmtVO comCsrRequestAgmtVO) throws EventException;
	
	/**
	 * COM_CSR_0023 조회 이벤트 처리<br>
	 * CSR Invoice Agreement Link :COM_CSR_0023 Contract & Files 화면에 대한 조회 이벤트 처리<br>
	 * @author 9014787
	 * @param CSRInvAgmtLnkInVO csrInvAgmtLnkInVO
	 * @return List<SelComApFileVO>
	 * @exception EventException
	 */
	public List<SelComApFileVO> search02ComApFileUpld(CSRInvAgmtLnkInVO csrInvAgmtLnkInVO) throws EventException;

	/**
	 * COM_CSR_0023 멀티 이벤트 처리<br>
	 * CSR Invoice Agreement Link :COM_CSR_0023 Contract & Files 화면에 대한 멀티 이벤트 처리<br>
	 * @author 9014787
	 * @param Event e
	 * @exception EventException
	 */
	public void multiComApFileUpld(Event e) throws EventException;

}