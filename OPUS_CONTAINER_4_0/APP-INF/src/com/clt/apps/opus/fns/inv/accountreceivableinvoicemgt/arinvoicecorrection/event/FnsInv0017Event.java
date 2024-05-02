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
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvNewCustVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCustomerInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateVO;
import com.clt.framework.support.layer.event.EventSupport;



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
	
	private String splitFlg = null;
	
	private String actInvFlag = null;

	private String otherFlag = null;
	
	private String custLglEngNm = null;
	
	private String ioBndCd = null;
	
	private String actCustCntCd = null;

	private String actCustSeq = null;
	
	private String custNm = null;



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
		DueDateInputVO[] rtnVOs = null;
		if (this.dueDateInputVOs != null) {
			rtnVOs = new DueDateInputVO[dueDateInputVOs.length];
			System.arraycopy(dueDateInputVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param dueDateInputVOs the dueDateInputVOs to set
	 */
	public void setDueDateInputVOs(DueDateInputVO[] dueDateInputVOs){
		if(dueDateInputVOs != null){
			DueDateInputVO[] tmpVOs = new DueDateInputVO[dueDateInputVOs.length];
			System.arraycopy(dueDateInputVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dueDateInputVOs = tmpVOs;
		}
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
		DueDateVO[] rtnVOs = null;
		if (this.dueDateVOs != null) {
			rtnVOs = new DueDateVO[dueDateVOs.length];
			System.arraycopy(dueDateVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param dueDateVOs the dueDateVOs to set
	 */
	public void setDueDateVOs(DueDateVO[] dueDateVOs){
		if(dueDateVOs != null){
			DueDateVO[] tmpVOs = new DueDateVO[dueDateVOs.length];
			System.arraycopy(dueDateVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dueDateVOs = tmpVOs;
		}
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
		InvNewCustVO[] rtnVOs = null;
		if (this.invNewCustVOs != null) {
			rtnVOs = new InvNewCustVO[invNewCustVOs.length];
			System.arraycopy(invNewCustVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param invNewCustVOs the invNewCustVOs to set
	 */
	public void setInvNewCustVOs(InvNewCustVO[] invNewCustVOs){
		if(invNewCustVOs != null){
			InvNewCustVO[] tmpVOs = new InvNewCustVO[invNewCustVOs.length];
			System.arraycopy(invNewCustVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invNewCustVOs = tmpVOs;
		}
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
		InvArMnVO[] rtnVOs = null;
		if (this.invArMnVOs != null) {
			rtnVOs = new InvArMnVO[invArMnVOs.length];
			System.arraycopy(invArMnVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param invArMnVOs the invArMnVOs to set
	 */
	public void setInvArMnVOs(InvArMnVO[] invArMnVOs){
		if(invArMnVOs != null){
			InvArMnVO[] tmpVOs = new InvArMnVO[invArMnVOs.length];
			System.arraycopy(invArMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invArMnVOs = tmpVOs;
		}
	}
	
	

}