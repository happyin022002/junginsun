/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0130Event.java
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
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArSplitIssChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArSplitIssVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0130 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0130HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Do Soon
 * @see FNS_INV_0130HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0130Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    private ARInvoiceSplitVO aRInvoiceSplitVO;
    private ARInvoiceSplitVO aRInvoiceSplitVOs[];
    private InvArAmtVO invArAmtVO;
    private InvArAmtVO invArAmtVOs[];
    private InvArChgVO invArChgVO;
    private InvArChgVO invArChgVOs[];
    private InvArCntrVO invArCntrVO;
    private InvArCntrVO invArCntrVOs[];
    private InvArMnVO invArMnVO;
    private InvArMnVO invArMnVOs[];
    private InvArSplitIssChgVO invArSplitIssChgVO;
    private InvArSplitIssChgVO invArSplitIssChgVOs[];
    private InvArSplitIssVO invArSplitIssVO;
    private InvArSplitIssVO invArSplitIssVOs[];
    private String ofcCd;
    private String splitCnt;
    private String ifNo;
    private String bkgNo;
    private String sailDt;
    private String blInvCfmDt;
    private String cancelIfNo;
    private String maxSeq;
    private String blSrcNo;
	private String saDt;
	private String dueDt;
	
	public FnsInv0130Event(){}

	/**
	 * @return the aRInvoiceSplitVO
	 */
	public ARInvoiceSplitVO getaRInvoiceSplitVO() {
		return aRInvoiceSplitVO;
	}

	/**
	 * @param aRInvoiceSplitVO the aRInvoiceSplitVO to set
	 */
	public void setaRInvoiceSplitVO(ARInvoiceSplitVO aRInvoiceSplitVO) {
		this.aRInvoiceSplitVO = aRInvoiceSplitVO;
	}

	/**
	 * @return the aRInvoiceSplitVOs
	 */
	public ARInvoiceSplitVO[] getaRInvoiceSplitVOs() {
		return aRInvoiceSplitVOs;
	}

	/**
	 * @param aRInvoiceSplitVOs the aRInvoiceSplitVOs to set
	 */
	public void setaRInvoiceSplitVOs(ARInvoiceSplitVO[] aRInvoiceSplitVOs) {
		this.aRInvoiceSplitVOs = aRInvoiceSplitVOs;
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
	 * @return the invArSplitIssChgVO
	 */
	public InvArSplitIssChgVO getInvArSplitIssChgVO() {
		return invArSplitIssChgVO;
	}

	/**
	 * @param invArSplitIssChgVO the invArSplitIssChgVO to set
	 */
	public void setInvArSplitIssChgVO(InvArSplitIssChgVO invArSplitIssChgVO) {
		this.invArSplitIssChgVO = invArSplitIssChgVO;
	}

	/**
	 * @return the invArSplitIssChgVOs
	 */
	public InvArSplitIssChgVO[] getInvArSplitIssChgVOs() {
		return invArSplitIssChgVOs;
	}

	/**
	 * @param invArSplitIssChgVOs the invArSplitIssChgVOs to set
	 */
	public void setInvArSplitIssChgVOs(InvArSplitIssChgVO[] invArSplitIssChgVOs) {
		this.invArSplitIssChgVOs = invArSplitIssChgVOs;
	}

	/**
	 * @return the invArSplitIssVO
	 */
	public InvArSplitIssVO getInvArSplitIssVO() {
		return invArSplitIssVO;
	}

	/**
	 * @param invArSplitIssVO the invArSplitIssVO to set
	 */
	public void setInvArSplitIssVO(InvArSplitIssVO invArSplitIssVO) {
		this.invArSplitIssVO = invArSplitIssVO;
	}

	/**
	 * @return the invArSplitIssVOs
	 */
	public InvArSplitIssVO[] getInvArSplitIssVOs() {
		return invArSplitIssVOs;
	}

	/**
	 * @param invArSplitIssVOs the invArSplitIssVOs to set
	 */
	public void setInvArSplitIssVOs(InvArSplitIssVO[] invArSplitIssVOs) {
		this.invArSplitIssVOs = invArSplitIssVOs;
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

	/**
	 * @return the blSrcNo
	 */
	public String getBlSrcNo() {
		return blSrcNo;
	}

	/**
	 * @param blSrcNo the blSrcNo to set
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}

	/**
	 * @return the dueDt
	 */
	public String getDueDt() {
		return dueDt;
	}

	/**
	 * @param dueDt the dueDt to set
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}

	/**
	 * @return the saDt
	 */
	public String getSaDt() {
		return saDt;
	}

	/**
	 * @param saDt the saDt to set
	 */
	public void setSaDt(String saDt) {
		this.saDt = saDt;
	}

}