/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ComCsrApprovalEvent.java
 *@FileTitle : BizCommon Com CSR approval event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.08
 *@LastModifier : Young Shin Kim
 *@LastVersion : 1.0
 * 
 * 1.0 Creation
 * -------------------------------------------------------
 */
package com.hanjin.bizcommon.csr.csrapproval.event;

/**
 * COMCSRAPPROVAL 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Young Shin Kim
 * @see 
 * @since J2EE 1.6
 */

import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestBodyVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestFileVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestHeaderVO;
import com.hanjin.framework.support.layer.event.EventSupport;

public class ComCsrApprovalEvent  extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private ComCsrRequestHeaderVO comCsrRequestHeaderVO = null;
	private ComCsrInfoVO comCsrInfoVO = null;
	/** Table Value Object Multi Data 처리 */
	private ComCsrRequestBodyVO[] comCsrRequestBodyVOs = null;
	private ComCsrRequestAgmtVO[] comCsrRequestAgmtVOs = null;
	private ComCsrRequestFileVO[] comCsrRequestFileVOs = null;
	
	/**
	 * 
	 * @param comCsrRequestHeaderVO
	 */
	public void setComCsrRequestHeaderVO(ComCsrRequestHeaderVO comCsrRequestHeaderVO){
		this.comCsrRequestHeaderVO = comCsrRequestHeaderVO;
	}
	
	/**
	 * 
	 * @return comCsrRequestHeaderVO
	 */
	public ComCsrRequestHeaderVO getComCsrRequestHeaderVO() {
		return comCsrRequestHeaderVO;
	}

	/**
	 * 
	 * @param ComCsrInfoVO
	 */
	public void setComCsrInfoVO(ComCsrInfoVO comCsrInfoVO){
		this.comCsrInfoVO = comCsrInfoVO;
	}
	
	/**
	 * 
	 * @return ComCsrInfoVO
	 */
	public ComCsrInfoVO getComCsrInfoVO() {
		return comCsrInfoVO;
	}
	
	/**
	 * 
	 * @param comCsrRequestBodyVOs
	 */
	public void setComCsrRequestBodyVOS(ComCsrRequestBodyVO[] comCsrRequestBodyVOs){
		this.comCsrRequestBodyVOs = comCsrRequestBodyVOs;
	}
	
	/**
	 * 
	 * @return ComCsrRequestBodyVO[]
	 */
	public ComCsrRequestBodyVO[] getComCsrRequestBodyVOS() {
		return comCsrRequestBodyVOs;
	}
	
	/**
	 * 
	 * @param comCsrRequestAgmtVOs
	 */
	public void setComCsrRequestAgmtVOS(ComCsrRequestAgmtVO[] comCsrRequestAgmtVOs){
		this.comCsrRequestAgmtVOs = comCsrRequestAgmtVOs;
	}
	
	/**
	 * 
	 * @return ComCsrRequestAgmtVO[]
	 */
	public ComCsrRequestAgmtVO[] getComCsrRequestAgmtVOS() {
		return comCsrRequestAgmtVOs;
	}
	
	/**
	 * 
	 * @param comCsrRequestFileVOs
	 */
	public void setComCsrRequestFileVOS(ComCsrRequestFileVO[] comCsrRequestFileVOs){
		this.comCsrRequestFileVOs = comCsrRequestFileVOs;
	}
	
	/**
	 * 
	 * @return ComCsrRequestFileVO[]
	 */
	public ComCsrRequestFileVO[] getComCsrRequestFileVOS() {
		return comCsrRequestFileVOs;
	}
}
