/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0040Event.java
*@FileTitle : (China) Tax Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArTaxChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.TaxInvoiceVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArTaxMnVO;


/**
 * FNS_INV_0040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0040HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0040Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArTaxMnVO invArTaxMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvArTaxMnVO[] invArTaxMnVOs = null;
	
	private InvArTaxChgVO[] invArTaxChgVOs = null;
	
	private TaxInvoiceVO taxInvoiceVO = null;
	
	private TaxInvoiceVO[] taxInvoiceVOs = null;
	
	private String taxInvNo = null;
	
	private String ofcCd = null;
	
	private String currCd = null;
	
	private String blNo = null;
	
	private String chgSeq = null;
	
	//InvArTaxMn
	private String porCd = null;
	private String custLoclLangNm = null;
	private String bankAcctNo = null;
	private String creDt = null;
	private String taxInvCxlFlg = null;
	private String taxRgstNo = null;
	private String sailArrDt = null;
	private String issUsrId = null;
	private String issDt = null;
	private String polCd = null;
	private String deptNm = null;
	private String prnKnt = null;
	private String bankNm = null;
	private String ttlLoclCurrAmt = null;
	private String actCustCntCd = null;
	private String vvdPrnFlg = null;
	private String loclNmPrnFlg = null;
	private String updUsrId = null;
	private String invXchRt = null;
	private String updDt = null;
	private String blSrcNo = null;
	private String portPrnFlg = null;
	private String actCustSeq = null;
	private String sailArrPrnFlg = null;
	private String delCd = null;
	private String taxInvCxlRmk = null;
	private String coNm = null;
	private String taxInvRmk = null;
	private String ioBndCd = null;
	private String arOfcCd = null;
	private String issCurrCd = null;
	private String custLglEngNm = null;
	private String podCd = null;
	private String vvd = null;
	private String taxInvCxlDt = null;
	private String creUsrId = null;
	private String bkgNo = null;
	private String bizRgstNo = null;
	private String taxInvSeq = null;
	private String taxInvCxlUsrId = null;
	private String issueGb = null;
	
	public FnsInv0040Event(){}
	
	public void setInvArTaxMnVO(InvArTaxMnVO invArTaxMnVO){
		this. invArTaxMnVO = invArTaxMnVO;
	}

	public void setInvArTaxMnVOS(InvArTaxMnVO[] invArTaxMnVOs){
		this. invArTaxMnVOs = invArTaxMnVOs;
	}

	public InvArTaxMnVO getInvArTaxMnVO(){
		return invArTaxMnVO;
	}

	public InvArTaxMnVO[] getInvArTaxMnVOS(){
		return invArTaxMnVOs;
	}

	public TaxInvoiceVO getTaxInvoiceVO() {
		return taxInvoiceVO;
	}

	public void setTaxInvoiceVO(TaxInvoiceVO taxInvoiceVO) {
		this.taxInvoiceVO = taxInvoiceVO;
	}

	public TaxInvoiceVO[] getTaxInvoiceVOs() {
		return taxInvoiceVOs;
	}

	public void setTaxInvoiceVOs(TaxInvoiceVO[] taxInvoiceVOs) {
		this.taxInvoiceVOs = taxInvoiceVOs;
	}

	public String getTaxInvNo() {
		return taxInvNo;
	}

	public void setTaxInvNo(String taxInvNo) {
		this.taxInvNo = taxInvNo;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getCurrCd() {
		return currCd;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getChgSeq() {
		return chgSeq;
	}

	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}

	public InvArTaxChgVO[] getInvArTaxChgVOs() {
		return invArTaxChgVOs;
	}

	public void setInvArTaxChgVOs(InvArTaxChgVO[] invArTaxChgVOs) {
		this.invArTaxChgVOs = invArTaxChgVOs;
	}

	public String getPorCd() {
		return porCd;
	}

	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}

	public String getCustLoclLangNm() {
		return custLoclLangNm;
	}

	public void setCustLoclLangNm(String custLoclLangNm) {
		this.custLoclLangNm = custLoclLangNm;
	}

	public String getBankAcctNo() {
		return bankAcctNo;
	}

	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
	}

	public String getCreDt() {
		return creDt;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public String getTaxInvCxlFlg() {
		return taxInvCxlFlg;
	}

	public void setTaxInvCxlFlg(String taxInvCxlFlg) {
		this.taxInvCxlFlg = taxInvCxlFlg;
	}

	public String getTaxRgstNo() {
		return taxRgstNo;
	}

	public void setTaxRgstNo(String taxRgstNo) {
		this.taxRgstNo = taxRgstNo;
	}

	public String getSailArrDt() {
		return sailArrDt;
	}

	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}

	public String getIssUsrId() {
		return issUsrId;
	}

	public void setIssUsrId(String issUsrId) {
		this.issUsrId = issUsrId;
	}

	public String getIssDt() {
		return issDt;
	}

	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}

	public String getPolCd() {
		return polCd;
	}

	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	public String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}

	public String getPrnKnt() {
		return prnKnt;
	}

	public void setPrnKnt(String prnKnt) {
		this.prnKnt = prnKnt;
	}

	public String getBankNm() {
		return bankNm;
	}

	public void setBankNm(String bankNm) {
		this.bankNm = bankNm;
	}

	public String getTtlLoclCurrAmt() {
		return ttlLoclCurrAmt;
	}

	public void setTtlLoclCurrAmt(String ttlLoclCurrAmt) {
		this.ttlLoclCurrAmt = ttlLoclCurrAmt;
	}

	public String getActCustCntCd() {
		return actCustCntCd;
	}

	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}

	public String getVvdPrnFlg() {
		return vvdPrnFlg;
	}

	public void setVvdPrnFlg(String vvdPrnFlg) {
		this.vvdPrnFlg = vvdPrnFlg;
	}

	public String getLoclNmPrnFlg() {
		return loclNmPrnFlg;
	}

	public void setLoclNmPrnFlg(String loclNmPrnFlg) {
		this.loclNmPrnFlg = loclNmPrnFlg;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getInvXchRt() {
		return invXchRt;
	}

	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	public String getBlSrcNo() {
		return blSrcNo;
	}

	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}

	public String getPortPrnFlg() {
		return portPrnFlg;
	}

	public void setPortPrnFlg(String portPrnFlg) {
		this.portPrnFlg = portPrnFlg;
	}

	public String getActCustSeq() {
		return actCustSeq;
	}

	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}

	public String getSailArrPrnFlg() {
		return sailArrPrnFlg;
	}

	public void setSailArrPrnFlg(String sailArrPrnFlg) {
		this.sailArrPrnFlg = sailArrPrnFlg;
	}

	public String getDelCd() {
		return delCd;
	}

	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}

	public String getTaxInvCxlRmk() {
		return taxInvCxlRmk;
	}

	public void setTaxInvCxlRmk(String taxInvCxlRmk) {
		this.taxInvCxlRmk = taxInvCxlRmk;
	}

	public String getCoNm() {
		return coNm;
	}

	public void setCoNm(String coNm) {
		this.coNm = coNm;
	}

	public String getTaxInvRmk() {
		return taxInvRmk;
	}

	public void setTaxInvRmk(String taxInvRmk) {
		this.taxInvRmk = taxInvRmk;
	}

	public String getIoBndCd() {
		return ioBndCd;
	}

	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	public String getArOfcCd() {
		return arOfcCd;
	}

	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	public String getIssCurrCd() {
		return issCurrCd;
	}

	public void setIssCurrCd(String issCurrCd) {
		this.issCurrCd = issCurrCd;
	}

	public String getCustLglEngNm() {
		return custLglEngNm;
	}

	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}

	public String getPodCd() {
		return podCd;
	}

	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public String getTaxInvCxlDt() {
		return taxInvCxlDt;
	}

	public void setTaxInvCxlDt(String taxInvCxlDt) {
		this.taxInvCxlDt = taxInvCxlDt;
	}

	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getBizRgstNo() {
		return bizRgstNo;
	}

	public void setBizRgstNo(String bizRgstNo) {
		this.bizRgstNo = bizRgstNo;
	}

	public String getTaxInvSeq() {
		return taxInvSeq;
	}

	public void setTaxInvSeq(String taxInvSeq) {
		this.taxInvSeq = taxInvSeq;
	}

	public String getTaxInvCxlUsrId() {
		return taxInvCxlUsrId;
	}

	public void setTaxInvCxlUsrId(String taxInvCxlUsrId) {
		this.taxInvCxlUsrId = taxInvCxlUsrId;
	}

	public String getIssueGb() {
		return issueGb;
	}

	public void setIssueGb(String issueGb) {
		this.issueGb = issueGb;
	}

	
	
	
}