/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiLse0048Event.java
*@FileTitle : Long Term Lease CNTR Delivery Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.lsecommon.event;

import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.vo.SearchInvoiceNoVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * UI_LSE_0048 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_LSE_0048HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Nho Jung Yong
 * @see EES_LSE_0048HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesLseComEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EesLseComEvent(){}

	/* Location Code */
	private String locCd;
	/* Location Type : ex.) LCC, RCC, SCC... */
	private String locTp;
	/* Vendor Sequence */
	private String vndrSeq;
	/* Currency Code */
	private String currCd;
	/* VVD Code */
	private String vvdCd;
	/* Container No. */
	private String cntrNo;
	/* Office Code */
	private String ofcCd;
	/* Office Code */
	private String ydCd;
	/* Office Code */
	private String sLanCd;
	/* Office Code */
	private String intgCdId;
	/* Group Code*/
	private String eqLocTpCd;
	/* Sheet Index*/
	private String sheetIdx;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String mdlCd = null;
	/* Column Info */
	private String refPk = null;
	/* Column Info */
	private String schDate = null;
	/* Column Info */
	private String chkDateYN = null;
	/* Column Info */
	private String agmtSeq = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgreementVO agreementVO = null;

	/** Table Value Object Multi Data 처리 */
	private AgreementVO[] agreementVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInvoiceNoVO searchInvoiceNoVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchInvoiceNoVO[] searchInvoiceNoVOs = null;

	
	public void setAgreementVO(AgreementVO agreementVO){
		this. agreementVO = agreementVO;
	}

	public void setAgreementVOS(AgreementVO[] agreementVOs){
		if (agreementVOs != null) {
			AgreementVO[] tmpVOs = new AgreementVO[agreementVOs.length];
			System.arraycopy(agreementVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.agreementVOs = tmpVOs;
		}
	}

	public AgreementVO getAgreementVO(){
		return agreementVO;
	}

	public AgreementVO[] getAgreementVOS(){
		AgreementVO[] tmpVOs = null;
		if (this.agreementVOs != null) {
			tmpVOs = new AgreementVO[agreementVOs.length];
			System.arraycopy(agreementVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	
	public void setSearchInvoiceNoVO(SearchInvoiceNoVO searchInvoiceNoVO){
		this. searchInvoiceNoVO = searchInvoiceNoVO;
	}

	public void setSearchInvoiceNoVOS(SearchInvoiceNoVO[] searchInvoiceNoVOs){
		if (searchInvoiceNoVOs != null) {
			SearchInvoiceNoVO[] tmpVOs = new SearchInvoiceNoVO[searchInvoiceNoVOs.length];
			System.arraycopy(searchInvoiceNoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchInvoiceNoVOs = tmpVOs;
		}
	}

	public SearchInvoiceNoVO getSearchInvoiceNoVO(){
		return searchInvoiceNoVO;
	}

	public SearchInvoiceNoVO[] getSearchInvoiceNoVOS(){
		SearchInvoiceNoVO[] tmpVOs = null;
		if (this.searchInvoiceNoVOs != null) {
			tmpVOs = new SearchInvoiceNoVO[searchInvoiceNoVOs.length];
			System.arraycopy(searchInvoiceNoVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	public String getLocCd() {
		return locCd;
	}

	public void setLocTp(String locTp) {
		this.locTp = locTp;
	}

	public String getLocTp() {
		return locTp;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public String getVndrSeq() {
		return vndrSeq;
	}

	/**
	 * @param currCd the currCd to set
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	/**
	 * @return the currCd
	 */
	public String getCurrCd() {
		return currCd;
	}

	/**
	 * @param vvdCd the vvdCd to set
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	/**
	 * @return the vvdCd
	 */
	public String getVvdCd() {
		return vvdCd;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public String getCntrNo() {
		return cntrNo;
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
	 * @return the ydCd
	 */
	public String getYdCd() {
		return ydCd;
	}

	/**
	 * @param ydCd the ydCd to set
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}

	/**
	 * @return the sLanCd
	 */
	public String getSLanCd() {
		return sLanCd;
	}

	/**
	 * @param sLanCd the sLanCd to set
	 */
	public void setSLanCd(String sLanCd) {
		this.sLanCd = sLanCd;
	}
	
	/**
	 * @return the intgCdId
	 */
	public String getIntgCdId() {
		return intgCdId;
	}

	/**
	 * @param intgCdId the intgCdId to set
	 */
	public void setIntgCdId(String intgCdId) {
		this.intgCdId = intgCdId;
	}
	
	/**
	 * @return the eqLocTpCd
	 */
	public String getEqLocTpCd() {
		return eqLocTpCd;
	}
	
	
	/**
	 * @param sheetIdx the sheetIdx to set
	 */
	public void setSheetIdx(String sheetIdx) {
		this.sheetIdx = sheetIdx;
	}
	
	/**
	 * @return the sheetIdx
	 */
	public String getSheetIdx() {
		return sheetIdx;
	}

	/**
	 * @param eqLocTpCd the sLanCd to set
	 */
	public void setEqLocTpCd(String eqLocTpCd) {
		this.eqLocTpCd = eqLocTpCd;
	}
	
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public String getInvNo() {
		return invNo;
	}
	
	public void setMdlCd(String mdlCd) {
		this.mdlCd = mdlCd;
	}

	public String getMdlCd() {
		return mdlCd;
	}
	
	public void setRefPk(String refPk) {
		this.refPk = refPk;
	}

	public String getRefPk() {
		return refPk;
	}
	
	public void setSchDate(String schDate) {
		this.schDate = schDate;
	}

	public String getSchDate() {
		return schDate;
	}
	
	public void setChkDateYN(String chkDateYN) {
		this.chkDateYN = chkDateYN;
	}

	public String getChkDateYN() {
		return chkDateYN;
	}
	
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	public String getAgmtSeq() {
		return agmtSeq;
	}
}