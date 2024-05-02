/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv009401Event.java
*@FileTitle : Invoice Customer Change(Single)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvNewCustVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0094_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0094_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0094_01HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv009401Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DueDateVO dueDateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DueDateVO[] dueDateVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceCustomerChangeVO invoiceCustomerChangeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvoiceCustomerChangeVO[] invoiceCustomerChangeVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DueDateInputVO dueDateInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DueDateInputVO[] dueDateInputVOs = null;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvNewCustVO invNewCustVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvNewCustVO[] invNewCustVOs = null;
	
	private InvArMnVO invArMnVO = null;

	private InvArMnVO[] invArMnVOs = null;
	
	
	private String ofcCd = null;
	
	private String invNo = null;
	
	private String ifNo = null;
	
	private String splitFlg = null;
	
	private String actCustCntCd = null;
	
	private String actCustSeq = null;
	
	private String invCustCntCd = null;
	
	private String invCustSeq = null;
	
	private String arIfNo = null;
	
	private String revTpCd = null;
	
	private String revSrcCd = null;
	
	private String bkgNo = null;
	
	private String invCurrCd = null;

	public FnsInv009401Event(){}
	
	
	/**
	 * @return the invCustCntCd
	 */
	public String getInvCustCntCd() {
		return invCustCntCd;
	}


	/**
	 * @param invCustCntCd the invCustCntCd to set
	 */
	public void setInvCustCntCd(String invCustCntCd) {
		this.invCustCntCd = invCustCntCd;
	}


	/**
	 * @return the invCustSeq
	 */
	public String getInvCustSeq() {
		return invCustSeq;
	}


	/**
	 * @param invCustSeq the invCustSeq to set
	 */
	public void setInvCustSeq(String invCustSeq) {
		this.invCustSeq = invCustSeq;
	}


	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}


	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}


	/**
	 * @return the arIfNo
	 */
	public String getArIfNo() {
		return arIfNo;
	}


	/**
	 * @param arIfNo the arIfNo to set
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}


	/**
	 * @return the revTpCd
	 */
	public String getRevTpCd() {
		return revTpCd;
	}


	/**
	 * @param revTpCd the revTpCd to set
	 */
	public void setRevTpCd(String revTpCd) {
		this.revTpCd = revTpCd;
	}


	/**
	 * @return the revSrcCd
	 */
	public String getRevSrcCd() {
		return revSrcCd;
	}


	/**
	 * @param revSrcCd the revSrcCd to set
	 */
	public void setRevSrcCd(String revSrcCd) {
		this.revSrcCd = revSrcCd;
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


	public String getInvCurrCd() {
		return invCurrCd;
	}


	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}


	/**
	 * @return the invoiceCustomerChangeVOs
	 */
	public InvoiceCustomerChangeVO[] getInvoiceCustomerChangeVOs() {
		InvoiceCustomerChangeVO[] rtnVOs = null;
		if (this.invoiceCustomerChangeVOs != null) {
			rtnVOs = new InvoiceCustomerChangeVO[invoiceCustomerChangeVOs.length];
			System.arraycopy(invoiceCustomerChangeVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	/**
	 * @param invoiceCustomerChangeVOs the invoiceCustomerChangeVOs to set
	 */
	public void setInvoiceCustomerChangeVOs(InvoiceCustomerChangeVO[] invoiceCustomerChangeVOs){
		if(invoiceCustomerChangeVOs != null){
			InvoiceCustomerChangeVO[] tmpVOs = new InvoiceCustomerChangeVO[invoiceCustomerChangeVOs.length];
			System.arraycopy(invoiceCustomerChangeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invoiceCustomerChangeVOs = tmpVOs;
		}
	}


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


	public void setInvoiceCustomerChangeVO(InvoiceCustomerChangeVO invoiceCustomerChangeVO){
		this. invoiceCustomerChangeVO = invoiceCustomerChangeVO;
	}

	public void setInvoiceCustomerChangeVOS(InvoiceCustomerChangeVO[] invoiceCustomerChangeVOs){
		if(invoiceCustomerChangeVOs != null){
			InvoiceCustomerChangeVO[] tmpVOs = new InvoiceCustomerChangeVO[invoiceCustomerChangeVOs.length];
			System.arraycopy(invoiceCustomerChangeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invoiceCustomerChangeVOs = tmpVOs;
		}
	}


	public InvoiceCustomerChangeVO getInvoiceCustomerChangeVO(){
		return invoiceCustomerChangeVO;
	}

	public InvoiceCustomerChangeVO[] getInvoiceCustomerChangeVOS(){
		InvoiceCustomerChangeVO[] rtnVOs = null;
		if (this.invoiceCustomerChangeVOs != null) {
			rtnVOs = new InvoiceCustomerChangeVO[invoiceCustomerChangeVOs.length];
			System.arraycopy(invoiceCustomerChangeVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
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
	
	

}