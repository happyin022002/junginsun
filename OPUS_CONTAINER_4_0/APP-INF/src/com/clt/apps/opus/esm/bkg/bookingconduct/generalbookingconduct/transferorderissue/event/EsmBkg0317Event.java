/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0907Event.java
*@FileTitle : TRO-Container Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.04.30 이남경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0317 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0317HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Nam Kyung
 * @see ESM_BKG_0317HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0317Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Condition 용  */
	private String bkgNo      = null;
	private String t1DocFlg   = null;
	private String cstmsClrNo = null;
	private String allInRtFlg = null;
	private String currCd     = null;
	private String trnsRevAmt = null;
	private String cxlFlg     = null;
	private String vatFlg     = null;
	private String term       = null;
	private String hlgTpCd    = null;
	private String ioBndCd    = null;
	private String cfmFlg     = null;
	private String nonTrnsRevAmt = null;
	private String addRevAmt = null;
	private String addRevChgCd = null;

	/**
	 * @return the addRevAmt
	 */
	public String getAddRevChgCd() {
		return addRevChgCd;
	}
	/**
	 * @param addRevAmt the addRevAmt to set
	 */
	public void setAddRevChgCd(String addRevChgCd) {
		this.addRevChgCd = addRevChgCd;
	}
	/**
	 * @return the addRevAmt
	 */
	public String getAddRevAmt() {
		return addRevAmt;
	}
	/**
	 * @param addRevAmt the addRevAmt to set
	 */
	public void setAddRevAmt(String addRevAmt) {
		this.addRevAmt = addRevAmt;
	}
	/**
	 * @return the nonTrnsRevAmt
	 */
	public String getNonTrnsRevAmt() {
		return nonTrnsRevAmt;
	}
	/**
	 * @param nonTrnsRevAmt the nonTrnsRevAmt to set
	 */
	public void setNonTrnsRevAmt(String nonTrnsRevAmt) {
		this.nonTrnsRevAmt = nonTrnsRevAmt;
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
	 * @return the t1DocFlg
	 */
	public String getT1DocFlg() {
		return t1DocFlg;
	}
	/**
	 * @param docFlg the t1DocFlg to set
	 */
	public void setT1DocFlg(String docFlg) {
		t1DocFlg = docFlg;
	}
	/**
	 * @return the cstmsClrNo
	 */
	public String getCstmsClrNo() {
		return cstmsClrNo;
	}
	/**
	 * @param cstmsClrNo the cstmsClrNo to set
	 */
	public void setCstmsClrNo(String cstmsClrNo) {
		this.cstmsClrNo = cstmsClrNo;
	}
	/**
	 * @return the allInRtFlg
	 */
	public String getAllInRtFlg() {
		return allInRtFlg;
	}
	/**
	 * @param allInRtFlg the allInRtFlg to set
	 */
	public void setAllInRtFlg(String allInRtFlg) {
		this.allInRtFlg = allInRtFlg;
	}
	/**
	 * @return the currCd
	 */
	public String getCurrCd() {
		return currCd;
	}
	/**
	 * @param currCd the currCd to set
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	/**
	 * @return the trnsRevAmt
	 */
	public String getTrnsRevAmt() {
		return trnsRevAmt;
	}
	/**
	 * @param trnsRevAmt the trnsRevAmt to set
	 */
	public void setTrnsRevAmt(String trnsRevAmt) {
		this.trnsRevAmt = trnsRevAmt;
	}
	/**
	 * @return the cxlFlg
	 */
	public String getCxlFlg() {
		return cxlFlg;
	}
	/**
	 * @param cxlFlg the cxlFlg to set
	 */
	public void setCxlFlg(String cxlFlg) {
		this.cxlFlg = cxlFlg;
	}
	/**
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}
	/**
	 * @param term the term to set
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	/**
	 * @return the vatFlg
	 */
	public String getVatFlg() {
		return vatFlg;
	}
	/**
	 * @param vatFlg the vatFlg to set
	 */
	public void setVatFlg(String vatFlg) {
		this.vatFlg = vatFlg;
	}
	/**
	 * @return the hlgTpCd
	 */
	public String getHlgTpCd() {
		return hlgTpCd;
	}
	/**
	 * @param hlgTpCd the hlgTpCd to set
	 */
	public void setHlgTpCd(String hlgTpCd) {
		this.hlgTpCd = hlgTpCd;
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
	 * @return the cfmFlg
	 */
	public String getCfmFlg() {
		return cfmFlg;
	}
	/**
	 * @param cfmFlg the cfmFlg to set
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}	
}