/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0033Event.java
*@FileTitle : Invoice Split After Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.22 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArAmtVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceSplitVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;

/**
 * FNS_INV_0033 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0033HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Do Soon
 * @see FNS_INV_0033HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0033Event extends EventSupport {

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
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArIfNoVO invArIfNoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvArIfNoVO[] invArIfNoVOs;	
	
	private String ofcCd = null;
	private String splitCnt = null;
	private String ifNo = null;
	private String bkgNo = null;
	private String sailDt = null;
	private String blInvCfmDt = null;
	private String cancelIfNo = null;
	private String maxSeq = null;
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

	private String invNo = null;

	public FnsInv0033Event(){}
	
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
	 * @return the invArIfNoVO
	 */
	public InvArIfNoVO getInvArIfNoVO() {
		return invArIfNoVO;
	}

	/**
	 * @param invArIfNoVO the invArIfNoVO to set
	 */
	public void setInvArIfNoVO(InvArIfNoVO invArIfNoVO) {
		this.invArIfNoVO = invArIfNoVO;
	}

	/**
	 * @return the invArIfNoVOs
	 */
	public InvArIfNoVO[] getInvArIfNoVOs() {
		return invArIfNoVOs;
	}

	/**
	 * @param invArIfNoVOs the invArIfNoVOs to set
	 */
	public void setInvArIfNoVOs(InvArIfNoVO[] invArIfNoVOs) {
		this.invArIfNoVOs = invArIfNoVOs;
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
	
}