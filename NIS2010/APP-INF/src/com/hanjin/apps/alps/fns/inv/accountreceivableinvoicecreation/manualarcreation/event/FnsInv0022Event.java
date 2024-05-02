/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0022Event.java
*@FileTitle : Other Revenue Invoice Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.04.27 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARInvoiceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.RevenueAcctVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueEachTargetVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0022HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0022Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	//기본 조회 조건
	private String blSrcNo = null;
	private String arIfNo = null;
	private String bkgNo = null;
	private String office = null;	
	private String pageType = null;
	private String loginOfcCd = null;
	
	//경리환율 조회 조건
	private String glEffDt = null;
	private String currCd = null;
	private String localCurrCd = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RevenueAcctVO revenueAcctVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RevenueAcctVO[] revenueAcctVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ARInvoiceCreationVO aRInvoiceCreationVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BKGInvoiceVO bKGInvoiceVO = null;
	
	private InvIssMainVO invIssMainVO =  null;
	private IssueEachTargetVO[] issEachTgtVOs =  null;
	
	public FnsInv0022Event(){}
	
	public void setRevenueAcctVO(RevenueAcctVO revenueAcctVO){
		this. revenueAcctVO = revenueAcctVO;
	}

	public void setRevenueAcctVOS(RevenueAcctVO[] revenueAcctVOs){
		if(revenueAcctVOs != null){
			RevenueAcctVO[] tmpVOs = new RevenueAcctVO[revenueAcctVOs.length];
			System.arraycopy(revenueAcctVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.revenueAcctVOs = tmpVOs;
		}
	}

	public RevenueAcctVO getRevenueAcctVO(){
		return revenueAcctVO;
	}

	public RevenueAcctVO[] getRevenueAcctVOS(){
		RevenueAcctVO[] rtnVOs = null;
		if (this.revenueAcctVOs != null) {
			rtnVOs = new RevenueAcctVO[revenueAcctVOs.length];
			System.arraycopy(revenueAcctVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public String getBlSrcNo() {
		return blSrcNo;
	}

	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}

	public String getArIfNo() {
		return arIfNo;
	}

	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public String getLoginOfcCd() {
		return loginOfcCd;
	}

	public void setLoginOfcCd(String loginOfcCd) {
		this.loginOfcCd = loginOfcCd;
	}
	
	public String getGlEffDt() {
		return glEffDt;
	}

	public void setGlEffDt(String glEffDt) {
		this.glEffDt = glEffDt;
	}

	public String getCurrCd() {
		return currCd;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	public String getLocalCurrCd() {
		return localCurrCd;
	}

	public void setLocalCurrCd(String localCurrCd) {
		this.localCurrCd = localCurrCd;
	}

	public ARInvoiceCreationVO getARInvoiceCreationVO() {
		return aRInvoiceCreationVO;
	}

	public void setARInvoiceCreationVO(ARInvoiceCreationVO invoiceCreationVO) {
		aRInvoiceCreationVO = invoiceCreationVO;
	}

	public BKGInvoiceVO getBKGInvoiceVO() {
		return bKGInvoiceVO;
	}

	public void setBKGInvoiceVO(BKGInvoiceVO invoiceVO) {
		bKGInvoiceVO = invoiceVO;
	}

	public InvIssMainVO getInvIssMainVO() {
		return invIssMainVO;
	}

	public void setInvIssMainVO(InvIssMainVO invIssMainVO) {
		this.invIssMainVO = invIssMainVO;
	}

	public IssueEachTargetVO[] getIssEachTgtVOs() {
		IssueEachTargetVO[] rtnVOs = null;
		if (this.issEachTgtVOs != null) {
			rtnVOs = new IssueEachTargetVO[issEachTgtVOs.length];
			System.arraycopy(issEachTgtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setIssEachTgtVOs(IssueEachTargetVO[] issEachTgtVOs){
		if(issEachTgtVOs != null){
			IssueEachTargetVO[] tmpVOs = new IssueEachTargetVO[issEachTgtVOs.length];
			System.arraycopy(issEachTgtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.issEachTgtVOs = tmpVOs;
		}
	}

}