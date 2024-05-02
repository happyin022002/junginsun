/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComCsr0011Event.java
*@FileTitle : Invoice List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.20 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event;

import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CSRSOhdrVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CSRSOlistVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ApPayInvVO;


/**
 * COM_CSR_0011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  COM_CSR_0011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HAM DAE SUNG
 * @see COM_CSR_0011HTMLAction 참조
 * @since J2EE 1.6
 */

public class ComCsr0011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ApPayInvVO apPayInvVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ApPayInvVO[] apPayInvVOs = null;
	
	private CSRSOlistVO cSRSOlistVO = null;
	
	private CSRSOlistVO[] cSRSOlistVOs = null;
	
	private CSRSOhdrVO cSRSOhdrVO = null;

	public ComCsr0011Event(){}
	
	public void setApPayInvVO(ApPayInvVO apPayInvVO){
		this. apPayInvVO = apPayInvVO;
	}

	public void setApPayInvVOS(ApPayInvVO[] apPayInvVOs){
		this. apPayInvVOs = apPayInvVOs;
	}

	public ApPayInvVO getApPayInvVO(){
		return apPayInvVO;
	}

	public ApPayInvVO[] getApPayInvVOS(){
		return apPayInvVOs;
	}

	/**
	 * @return the cSRSOlistVO
	 */
	public CSRSOlistVO getCSRSOlistVO() {
		return cSRSOlistVO;
	}

	/**
	 * @param olistVO the cSRSOlistVO to set
	 */
	public void setCSRSOlistVO(CSRSOlistVO olistVO) {
		cSRSOlistVO = olistVO;
	}

	/**
	 * @return the cSRSOlistVOs
	 */
	public CSRSOlistVO[] getCSRSOlistVOs() {
		return cSRSOlistVOs;
	}

	/**
	 * @param olistVOs the cSRSOlistVOs to set
	 */
	public void setCSRSOlistVOs(CSRSOlistVO[] olistVOs) {
		cSRSOlistVOs = olistVOs;
	}

	/**
	 * @return the cSRSOhdrVO
	 */
	public CSRSOhdrVO getCSRSOhdrVO() {
		return cSRSOhdrVO;
	}

	/**
	 * @param ohdrVO the cSRSOhdrVO to set
	 */
	public void setCSRSOhdrVO(CSRSOhdrVO ohdrVO) {
		cSRSOhdrVO = ohdrVO;
	}

	
}