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
* 2012.06.25 전성진 [CHM-201217633] 구주 Hinterland Operation 개선 Project - T1&Revenue Guideline 적용
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.GlineRevInVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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
	private String bkgNo      		= null;
	private String t1DocFlg   		= null;
	private String cstmsClrNo 		= null;
	private String allInRtFlg 		= null;
	private String currCd     		= null;
	private String trnsRevAmt 		= null;
	private String cxlFlg     		= null;
	private String vatFlg     		= null;
	private String term       		= null;
	private String hlgTpCd    		= null;
	private String ioBndCd    		= null;
	private String cfmFlg     		= null;
	private String nonTrnsRevAmt 	= null;
	private String addRevAmt 		= null;
	private String addRevChgCd 		= null;
	private String addRevAmt2 		= null;
	private String addRevChgCd2 	= null;
	private String addRevAmt3 		= null;
	private String addRevChgCd3 	= null;
	private String cntrTpszCd 		= null;
	private String bsePortLocCd 	= null;
	private String pntLocCd 		= null;
	private String trspModeCd 		= null;
	private String rfFlag 			= null;
	private String dgFlag 			= null;
	private String awkFlag 			= null;
	private String cfmDt 			= null;
	private String addRevRmk		= null;
	private String optmStsCd 		= null;
	private String cntrNo			= null;
	private String arbCurrCd		= null;
	private String arbRevAmt		= null;
	private String multiRev			= null;
	private String cgoWgt			= null;
	private GlineRevInVO glineRevInVO = null;

	

	
	/**
	 * @return optmStsCd
	 */
	public String getOptmStsCd() {
		return optmStsCd;
	}
	/**
	 * @param optmStsCd
	 */
	public void setOptmStsCd(String optmStsCd) {
		this.optmStsCd = optmStsCd;
	}
	/**
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return cntrNo;
	}
	/**
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
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
	 * @return the addRevChgCd2
	 */
	public String getAddRevChgCd2() {
		return addRevChgCd2;
	}
	/**
	 * @param addRevChgCd2 the addRevChgCd2 to set
	 */
	public void setAddRevChgCd2(String addRevChgCd2) {
		this.addRevChgCd2 = addRevChgCd2;
	}
	
	/**
	 * @return the addRevChgCd3
	 */
	public String getAddRevChgCd3() {
		return addRevChgCd3;
	}
	/**
	 * @param addRevChgCd3 the addRevChgCd3 to set
	 */
	public void setAddRevChgCd3(String addRevChgCd3) {
		this.addRevChgCd3 = addRevChgCd3;
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
	 * @return the addRevAmt2
	 */
	public String getAddRevAmt2() {
		return addRevAmt2;
	}
	/**
	 * @param addRevAmt2 the addRevAmt2 to set
	 */
	public void setAddRevAmt2(String addRevAmt2) {
		this.addRevAmt2 = addRevAmt2;
	}
	
	/**
	 * @return the addRevAmt3
	 */
	public String getAddRevAmt3() {
		return addRevAmt3;
	}
	/**
	 * @param addRevAmt3 the addRevAmt3 to set
	 */
	public void setAddRevAmt3(String addRevAmt3) {
		this.addRevAmt3 = addRevAmt3;
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
	
	/**
	 * @return the glineRevInVO
	 */
	public GlineRevInVO getGlineRevInVO() {
		return glineRevInVO;
	}

	/**
	 * @param glineRevInVO the glineRevInVO to set
	 */
	public void setGlineRevInVO(GlineRevInVO glineRevInVO) {
		this.glineRevInVO = glineRevInVO;
	}
	/**
	 * @return the cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return cntrTpszCd;
	}
	/**
	 * @param cntrTpszCd the cntrTpszCd to set
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	/**
	 * @return the bsePortLocCd
	 */
	public String getBsePortLocCd() {
		return bsePortLocCd;
	}
	/**
	 * @param bsePortLocCd the bsePortLocCd to set
	 */
	public void setBsePortLocCd(String bsePortLocCd) {
		this.bsePortLocCd = bsePortLocCd;
	}
	/**
	 * @return the pntLocCd
	 */
	public String getPntLocCd() {
		return pntLocCd;
	}
	/**
	 * @param pntLocCd the pntLocCd to set
	 */
	public void setPntLocCd(String pntLocCd) {
		this.pntLocCd = pntLocCd;
	}
	/**
	 * @return the trspModeCd
	 */
	public String getTrspModeCd() {
		return trspModeCd;
	}
	/**
	 * @param trspModeCd the trspModeCd to set
	 */
	public void setTrspModeCd(String trspModeCd) {
		this.trspModeCd = trspModeCd;
	}
	/**
	 * @return the rfFlag
	 */
	public String getRfFlag() {
		return rfFlag;
	}
	/**
	 * @param rfFlag the rfFlag to set
	 */
	public void setRfFlag(String rfFlag) {
		this.rfFlag = rfFlag;
	}
	/**
	 * @return the dgFlag
	 */
	public String getDgFlag() {
		return dgFlag;
	}
	/**
	 * @param dgFlag the dgFlag to set
	 */
	public void setDgFlag(String dgFlag) {
		this.dgFlag = dgFlag;
	}
	/**
	 * @return the awkFlag
	 */
	public String getAwkFlag() {
		return awkFlag;
	}
	/**
	 * @param awkFlag the awkFlag to set
	 */
	public void setAwkFlag(String awkFlag) {
		this.awkFlag = awkFlag;
	}
	/**
	 * @return the cfmDt
	 */
	public String getCfmDt() {
		return cfmDt;
	}
	/**
	 * @param cfmDt the cfmDt to set
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
	}
	/**
	 * @return the addRevRmk
	 */
	public String getAddRevRmk() {
		return addRevRmk;
	}
	/**
	 * @param addRevRmk the addRevRmk to set
	 */
	public void setAddRevRmk(String addRevRmk) {
		this.addRevRmk = addRevRmk;
	}
	public String getArbCurrCd() {
		return arbCurrCd;
	}
	public void setArbCurrCd(String arbCurrCd) {
		this.arbCurrCd = arbCurrCd;
	}
	public String getArbRevAmt() {
		return arbRevAmt;
	}
	public void setArbRevAmt(String arbRevAmt) {
		this.arbRevAmt = arbRevAmt;
	}
	public String getMultiRev() {
		return multiRev;
	}
	public void setMultiRev(String multiRev) {
		this.multiRev = multiRev;
	}
	
	
	/**
	 * @return cgoWgt
	 */
	public String getCgoWgt() {
		return cgoWgt;
	}
	/**
	 * @param optmStsCd
	 */
	public void setCgoWgt(String cgoWgt) {
		this.cgoWgt = cgoWgt;
	}
}