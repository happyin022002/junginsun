/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0027Event.java
*@FileTitle : Ex Rate Update by Date or VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.08.26 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0027HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author DoSoon Choi
 * @see FNS_INV_0027HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0027Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String ofcCd = "";
	private String ioBndCd = "";
	private String fmIfDt = "";
	private String toIfDt = "";
	private String runOpt = "";
	private String invCustCntCd = "";
	private String invCustSeq = "";
	private String blSrcNo = "";
	private String backEndJobKey = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ExrateInputVO exrateInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	//private ExrateInputVO[] exrateInputVOs = null;	
	
	private List<ExrateInputVO> exrateInputVOs = null;	
	
	public FnsInv0027Event(){}
    
	
	/**
	 * @param exrateInputVOs the exrateInputVOs to set
	 */
	public void setExrateInputVOs(List<ExrateInputVO> exrateInputVOs) {
		this.exrateInputVOs = exrateInputVOs;
	}

	/**
	 * @return the exrateInputVOs
	 */
	public List<ExrateInputVO> getExrateInputVOs() {
		return exrateInputVOs;
	}


	/**
	 * @return the exrateInputVO
	 */
	public ExrateInputVO getExrateInputVO() {
		return exrateInputVO;
	}

	/**
	 * @param exrateInputVO the exrateInputVO to set
	 */
	public void setExrateInputVO(ExrateInputVO exrateInputVO) {
		this.exrateInputVO = exrateInputVO;
	}

	
	
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
	 * @return the fmIfDt
	 */
	public String getFmIfDt() {
		return fmIfDt;
	}

	/**
	 * @param fmIfDt the fmIfDt to set
	 */
	public void setFmIfDt(String fmIfDt) {
		this.fmIfDt = fmIfDt;
	}

	/**
	 * @return the toIfDt
	 */
	public String getToIfDt() {
		return toIfDt;
	}

	/**
	 * @param toIfDt the toIfDt to set
	 */
	public void setToIfDt(String toIfDt) {
		this.toIfDt = toIfDt;
	}

	/**
	 * @return the runOpt
	 */
	public String getRunOpt() {
		return runOpt;
	}

	/**
	 * @param runOpt the runOpt to set
	 */
	public void setRunOpt(String runOpt) {
		this.runOpt = runOpt;
	}


	/**
	 * @return the backEndJobKey
	 */
	public String getBackEndJobKey() {
		return backEndJobKey;
	}


	/**
	 * @param backEndJobKey the backEndJobKey to set
	 */
	public void setBackEndJobKey(String backEndJobKey) {
		this.backEndJobKey = backEndJobKey;
	}
	
	


	
}