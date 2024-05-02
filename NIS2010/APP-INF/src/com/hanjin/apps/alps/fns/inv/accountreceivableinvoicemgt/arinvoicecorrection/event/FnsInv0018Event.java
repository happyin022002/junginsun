/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0018Event.java
*@FileTitle : Invoice Split Before Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.10 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArAmtVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceSplitVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Do Soon
 * @see FNS_INV_0018HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ARInvoiceSplitVO aRInvoiceSplitVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ARInvoiceSplitVO[] aRInvoiceSplitVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArAmtVO invArAmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvArAmtVO[] invArAmtVOs;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArChgVO invArChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvArChgVO[] invArChgVOs;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArCntrVO invArCntrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvArCntrVO[] invArCntrVOs;	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArMnVO invArMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvArMnVO[] invArMnVOs;	
	
	private String ofcCd = null;
	private String splitCnt = null;
	private String ifNo = null;
	private String bkgNo = null;
	private String sailDt = null;
	private String blInvCfmDt = null;
	private String cancelIfNo = null;
	private String maxSeq = null;
	
	public FnsInv0018Event(){}
	
	public void setARInvoiceSplitVO(ARInvoiceSplitVO aRInvoiceSplitVO){
		this. aRInvoiceSplitVO = aRInvoiceSplitVO;
	}

	public void setARInvoiceSplitVOS(ARInvoiceSplitVO[] aRInvoiceSplitVOs){
		this. aRInvoiceSplitVOs = aRInvoiceSplitVOs;
	}

	public ARInvoiceSplitVO getARInvoiceSplitVO(){
		return aRInvoiceSplitVO;
	}

	public ARInvoiceSplitVO[] getARInvoiceSplitVOS(){
		return aRInvoiceSplitVOs;
	}
		
	
	/**
	 * @return the invArAmtVOs
	 */
	public InvArAmtVO[] getInvArAmtVOs() {
		return invArAmtVOs;
	}

	/**
	 * @param invArAmtVOs the invArAmtVOs to set
	 */
	public void setInvArAmtVOs(InvArAmtVO[] invArAmtVOs) {
		this.invArAmtVOs = invArAmtVOs;
	}

	/**
	 * @return the invArChgVOs
	 */
	public InvArChgVO[] getInvArChgVOs() {
		return invArChgVOs;
	}

	/**
	 * @param invArChgVOs the invArChgVOs to set
	 */
	public void setInvArChgVOs(InvArChgVO[] invArChgVOs) {
		this.invArChgVOs = invArChgVOs;
	}

	/**
	 * @return the invArCntrVOs
	 */
	public InvArCntrVO[] getInvArCntrVOs() {
		return invArCntrVOs;
	}

	/**
	 * @param invArCntrVOs the invArCntrVOs to set
	 */
	public void setInvArCntrVOs(InvArCntrVO[] invArCntrVOs) {
		this.invArCntrVOs = invArCntrVOs;
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

	/**
	 * @return the invArAmtVO
	 */
	public InvArAmtVO getInvArAmtVO() {
		return invArAmtVO;
	}

	/**
	 * @param invArAmtVO the invArAmtVO to set
	 */
	public void setInvArAmtVO(InvArAmtVO invArAmtVO) {
		this.invArAmtVO = invArAmtVO;
	}

	

	/**
	 * @return the invArChgVO
	 */
	public InvArChgVO getInvArChgVO() {
		return invArChgVO;
	}

	/**
	 * @param invArChgVO the invArChgVO to set
	 */
	public void setInvArChgVO(InvArChgVO invArChgVO) {
		this.invArChgVO = invArChgVO;
	}

	
	/**
	 * @return the invArCntrVO
	 */
	public InvArCntrVO getInvArCntrVO() {
		return invArCntrVO;
	}

	/**
	 * @param invArCntrVO the invArCntrVO to set
	 */
	public void setInvArCntrVO(InvArCntrVO invArCntrVO) {
		this.invArCntrVO = invArCntrVO;
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
	 * @return the aRInvoiceSplitVOs
	 */
	public ARInvoiceSplitVO[] getARInvoiceSplitVOs() {
		return aRInvoiceSplitVOs;
	}

	/**
	 * @param invoiceSplitVOs the aRInvoiceSplitVOs to set
	 */
	public void setARInvoiceSplitVOs(ARInvoiceSplitVO[] invoiceSplitVOs) {
		aRInvoiceSplitVOs = invoiceSplitVOs;
	}
	
	/**
	 * @return the cancelIfNo
	 */
	public String getCancelIfNo() {
		return cancelIfNo;
	}

	/**
	 * @param cancelIfNo the cancelIfNo to set
	 */
	public void setCancelIfNo(String cancelIfNo) {
		this.cancelIfNo = cancelIfNo;
	}

	/**
	 * @return the maxSeq
	 */
	public String getMaxSeq() {
		return maxSeq;
	}

	/**
	 * @param maxSeq the maxSeq to set
	 */
	public void setMaxSeq(String maxSeq) {
		this.maxSeq = maxSeq;
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
	 * @return the sailDt
	 */
	public String getSailDt() {
		return sailDt;
	}

	/**
	 * @param sailDt the sailDt to set
	 */
	public void setSailDt(String sailDt) {
		this.sailDt = sailDt;
	}

	/**
	 * @return the blInvCfmDt
	 */
	public String getBlInvCfmDt() {
		return blInvCfmDt;
	}

	/**
	 * @param blInvCfmDt the blInvCfmDt to set
	 */
	public void setBlInvCfmDt(String blInvCfmDt) {
		this.blInvCfmDt = blInvCfmDt;
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
	 * @return the splitCnt
	 */
	public String getSplitCnt() {
		return splitCnt;
	}

	/**
	 * @param splitCnt the splitCnt to set
	 */
	public void setSplitCnt(String splitCnt) {
		this.splitCnt = splitCnt;
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
	

}