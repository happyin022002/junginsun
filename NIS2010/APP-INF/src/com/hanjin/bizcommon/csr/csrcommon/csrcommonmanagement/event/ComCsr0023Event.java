/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ComCsr0023Event.java
*@FileTitle : CSR Invoice Agreement Link
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.10
*@LastModifier : 9014787
*@LastVersion : 1.0
* 2014.07.10 9014787
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.event;

import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo.CSRInvAgmtLnkInVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * COM_CSR_0023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_CSR_0023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 9014787
 * @see COM_CSR_0023HTMLAction 참조
 * @since J2EE 1.6
 */

public class ComCsr0023Event extends EventSupport {

	private static final long serialVersionUID = -7654780329136078305L;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComCsrRequestAgmtVO comCsrRequestAgmtVO = null;
	
	private CSRInvAgmtLnkInVO csrInvAgmtLnkInVO = null;

	public ComCsr0023Event(){}

	/**
	 * @return comCsrRequestAgmtVO
	 */
	public ComCsrRequestAgmtVO getComCsrRequestAgmtVO() {
		return comCsrRequestAgmtVO;
	}

	/**
	 * @param comCsrRequestAgmtVO
	 */
	public void setComCsrRequestAgmtVO(ComCsrRequestAgmtVO comCsrRequestAgmtVO) {
		this.comCsrRequestAgmtVO = comCsrRequestAgmtVO;
	}

	/**
	 * @return the csrInvAgmtLnkInVO
	 */
	public CSRInvAgmtLnkInVO getCsrInvAgmtLnkInVO() {
		return csrInvAgmtLnkInVO;
	}

	/**
	 * @param csrInvAgmtLnkInVO the csrInvAgmtLnkInVO to set
	 */
	public void setCsrInvAgmtLnkInVO(CSRInvAgmtLnkInVO csrInvAgmtLnkInVO) {
		this.csrInvAgmtLnkInVO = csrInvAgmtLnkInVO;
	}
	
	
}
