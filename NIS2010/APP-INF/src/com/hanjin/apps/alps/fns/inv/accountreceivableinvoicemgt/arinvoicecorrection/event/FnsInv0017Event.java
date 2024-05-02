/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0017Event.java
*@FileTitle : Invoice Customer Correction by Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.08.11 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvNewCustVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCustomerInputVO;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Do Soon
 * @see FNS_INV_0017HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DueDateInputVO dueDateInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DueDateInputVO[] dueDateInputVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DueDateVO dueDateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DueDateVO[] dueDateVOs = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvNewCustVO invNewCustVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvNewCustVO[] invNewCustVOs = null;

	private InvArMnVO invArMnVO = null;

	private InvArMnVO[] invArMnVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ARInvoiceCustomerInputVO aRInvoiceCustomerInputVO = null;	
	
	/**
	 * @return the aRInvoiceCustomerInputVO
	 */
	public ARInvoiceCustomerInputVO getARInvoiceCustomerInputVO() {
		return aRInvoiceCustomerInputVO;
	}



	/**
	 * @param invoiceCustomerInputVO the aRInvoiceCustomerInputVO to set
	 */
	public void setARInvoiceCustomerInputVO(
			ARInvoiceCustomerInputVO invoiceCustomerInputVO) {
		aRInvoiceCustomerInputVO = invoiceCustomerInputVO;
	}

	private String ofcCd = null;
	
	private String blNo = null;
	
	private String invNo = null;
	
	private String ifNo = null;
	
	private String blInvIfDt = null;
	
	private String fromDate = null;
	
	private String toDate = null;
	
	private String splitFlg = null;
	
	private String actInvFlag = null;

	private String otherFlag = null;
	
	private String custLglEngNm = null;
	
	private String ioBndCd = null;
	
	private String actCustCntCd = null;

	private String actCustSeq = null;
	
	private String custNm = null;
	
	private String shprCustCntCd = null;
	
	private String shprCustSeq = null;

	private String fwdrCustCntCd = null;
	
	private String fwdrCustSeq = null;



	public FnsInv0017Event(){}
	
	
	
	/**
	 * @return the dueDateInputVO
	 */
	public DueDateInputVO getDueDateInputVO() {
		return dueDateInputVO;
	}

	/**
	 * @param dueDateInputVO the dueDateInputVO to set
	 */
	public void setDueDateInputVO(DueDateInputVO dueDateInputVO) {
		this.dueDateInputVO = dueDateInputVO;
	}

	/**
	 * @return the dueDateInputVOs
	 */
	public DueDateInputVO[] getDueDateInputVOs() {
		return dueDateInputVOs;
	}

	/**
	 * @param dueDateInputVOs the dueDateInputVOs to set
	 */
	public void setDueDateInputVOs(DueDateInputVO[] dueDateInputVOs) {
		this.dueDateInputVOs = dueDateInputVOs;
	}

	
	
	/**
	 * @return the dueDateVO
	 */
	public DueDateVO getDueDateVO() {
		return dueDateVO;
	}

	/**
	 * @param dueDateVO the dueDateVO to set
	 */
	public void setDueDateVO(DueDateVO dueDateVO) {
		this.dueDateVO = dueDateVO;
	}

	/**
	 * @return the dueDateVOs
	 */
	public DueDateVO[] getDueDateVOs() {
		return dueDateVOs;
	}

	/**
	 * @param dueDateVOs the dueDateVOs to set
	 */
	public void setDueDateVOs(DueDateVO[] dueDateVOs) {
		this.dueDateVOs = dueDateVOs;
	}
	
	/**
	 * @return the invNewCustVO
	 */
	public InvNewCustVO getInvNewCustVO() {
		return invNewCustVO;
	}

	/**
	 * @param invNewCustVO the invNewCustVO to set
	 */
	public void setInvNewCustVO(InvNewCustVO invNewCustVO) {
		this.invNewCustVO = invNewCustVO;
	}

	/**
	 * @return the invNewCustVOs
	 */
	public InvNewCustVO[] getInvNewCustVOs() {
		return invNewCustVOs;
	}

	/**
	 * @param invNewCustVOs the invNewCustVOs to set
	 */
	public void setInvNewCustVOs(InvNewCustVO[] invNewCustVOs) {
		this.invNewCustVOs = invNewCustVOs;
	}

	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * @return the blNo
	 */
	public String getBlNo() {
		return blNo;
	}

	/**
	 * @param blNo the blNo to set
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * @return the invNo
	 */
	public String getInvNo() {
		return invNo;
	}

	/**
	 * @param invNo the invNo to set
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	/**
	 * @return the ifNo
	 */
	public String getIfNo() {
		return ifNo;
	}

	/**
	 * @param ifNo the ifNo to set
	 */
	public void setIfNo(String ifNo) {
		this.ifNo = ifNo;
	}

	/**
	 * @return the splitFlg
	 */
	public String getSplitFlg() {
		return splitFlg;
	}

	/**
	 * @param splitFlg the splitFlg to set
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
	}

	/**
	 * @return the actInvFlag
	 */
	public String getActInvFlag() {
		return actInvFlag;
	}

	/**
	 * @param actInvFlag the actInvFlag to set
	 */
	public void setActInvFlag(String actInvFlag) {
		this.actInvFlag = actInvFlag;
	}

	/**
	 * @return the otherFlag
	 */
	public String getOtherFlag() {
		return otherFlag;
	}

	/**
	 * @param otherFlag the otherFlag to set
	 */
	public void setOtherFlag(String otherFlag) {
		this.otherFlag = otherFlag;
	}
	
	/**
	 * @return the blInvIfDt
	 */
	public String getBlInvIfDt() {
		return blInvIfDt;
	}

	/**
	 * @param blInvIfDt the blInvIfDt to set
	 */
	public void setBlInvIfDt(String blInvIfDt) {
		this.blInvIfDt = blInvIfDt;
	}	
	
	
	/**
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}


	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}


	/**
	 * @return the toDate
	 */
	public String getToDate() {
		return toDate;
	}


	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}



	/**
	 * @return the custLglEngNm
	 */
	public String getCustLglEngNm() {
		return custLglEngNm;
	}

	/**
	 * @param custLglEngNm the custLglEngNm to set
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * @return the ioBndCd
	 */
	public String getIoBndCd() {
		return ioBndCd;
	}

	/**
	 * @param ioBndCd the ioBndCd to set
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	/**
	 * @return the actCustCntCd
	 */
	public String getActCustCntCd() {
		return actCustCntCd;
	}

	/**
	 * @param actCustCntCd the actCustCntCd to set
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}

	/**
	 * @return the actCustSeq
	 */
	public String getActCustSeq() {
		return actCustSeq;
	}

	/**
	 * @param actCustSeq the actCustSeq to set
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	

	/**
	 * @return the custNm
	 */
	public String getCustNm() {
		return custNm;
	}

	/**
	 * @param custNm the custNm to set
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * @return the shprCustCntCd
	 */
	public String getShprCustCntCd() {
		return shprCustCntCd;
	}


	/**
	 * @param shprCustCntCd the shprCustCntCd to set
	 */
	public void setShprCustCntCd(String shprCustCntCd) {
		this.shprCustCntCd = shprCustCntCd;
	}


	/**
	 * @return the shprCustSeq
	 */
	public String getShprCustSeq() {
		return shprCustSeq;
	}


	/**
	 * @param shprCustSeq the shprCustSeq to set
	 */
	public void setShprCustSeq(String shprCustSeq) {
		this.shprCustSeq = shprCustSeq;
	}


	/**
	 * @return the fwdrCustCntCd
	 */
	public String getFwdrCustCntCd() {
		return fwdrCustCntCd;
	}


	/**
	 * @param fwdrCustCntCd the fwdrCustCntCd to set
	 */
	public void setFwdrCustCntCd(String fwdrCustCntCd) {
		this.fwdrCustCntCd = fwdrCustCntCd;
	}


	/**
	 * @return the fwdrCustSeq
	 */
	public String getFwdrCustSeq() {
		return fwdrCustSeq;
	}


	/**
	 * @param fwdrCustSeq the fwdrCustSeq to set
	 */
	public void setFwdrCustSeq(String fwdrCustSeq) {
		this.fwdrCustSeq = fwdrCustSeq;
	}
	
	

	
	/**
	 * @return the invArMnVO
	 */
	public InvArMnVO getInvArMnVO() {
		return invArMnVO;
	}

	/**
	 * @param invArMnVO the invArMnVO to set
	 */
	public void setInvArMnVO(InvArMnVO invArMnVO) {
		this.invArMnVO = invArMnVO;
	}

	/**
	 * @return the invArMnVOs
	 */
	public InvArMnVO[] getInvArMnVOs() {
		return invArMnVOs;
	}

	/**
	 * @param invArMnVOs the invArMnVOs to set
	 */
	public void setInvArMnVOs(InvArMnVO[] invArMnVOs) {
		this.invArMnVOs = invArMnVOs;
	}
	
	

}