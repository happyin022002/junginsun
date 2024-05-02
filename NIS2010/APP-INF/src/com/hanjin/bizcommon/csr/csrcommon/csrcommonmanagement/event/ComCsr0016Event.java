/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ComCsr0016Event.java
*@FileTitle : Approval Type Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.06
*@LastModifier : SY SHIM
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * COM_CSR_0016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_CSR_0016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 2015513
 * @see COM_CSR_0016HTMLAction 참조
 * @since J2EE 1.6
 */

public class ComCsr0016Event extends EventSupport {

	private static final long serialVersionUID = -7654780329136078305L;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String csrNo = null;
	private String aproTpCd = null;
	

	public ComCsr0016Event(){}

	public String getCsrNo() {
		return csrNo;
	}

	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	public String getAproTpCd() {
		return aproTpCd;
	}

	public void setAproTpCd(String aproTpCd) {
		this.aproTpCd = aproTpCd;
	}
	
}
