/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0075Event.java
*@FileTitle :  (Korea)Security Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.25 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SecurityInputVO;


/**
 * FNS_INV_0075 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0075HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Do Soon
 * @see FNS_INV_0075HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0075Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SecurityInputVO securityInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SecurityInputVO[] securityInputVOs = null;
	
	private String custCntCd = "";
	
	private String custSeq = "";

	public FnsInv0075Event(){}

	

	/**
	 * @return the securityInputVO
	 */
	public SecurityInputVO getSecurityInputVO() {
		return securityInputVO;
	}



	/**
	 * @param securityInputVO the securityInputVO to set
	 */
	public void setSecurityInputVO(SecurityInputVO securityInputVO) {
		this.securityInputVO = securityInputVO;
	}



	/**
	 * @return the securityInputVOs
	 */
	public SecurityInputVO[] getSecurityInputVOs() {
		return securityInputVOs;
	}



	/**
	 * @param securityInputVOs the securityInputVOs to set
	 */
	public void setSecurityInputVOs(SecurityInputVO[] securityInputVOs) {
		this.securityInputVOs = securityInputVOs;
	}



	/**
	 * @return the custCntCd
	 */
	public String getCustCntCd() {
		return custCntCd;
	}

	/**
	 * @param custCntCd the custCntCd to set
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	/**
	 * @return the custSeq
	 */
	public String getCustSeq() {
		return custSeq;
	}

	/**
	 * @param custSeq the custSeq to set
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	
	

}