/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg007902cEvent.java
*@FileTitle : TRO(Transportation Request Order) for Inland Haulage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.04.30 이남경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0079_02A 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0079_02AHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Nam Kyung
 * @see ESM_BKG_0079_02AHTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg007902bEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Condition 용  */
	private BkgBlNoVO bkgBlNoVO     = null;
	private String    boundCd       = null;
	private String    rtnTroFlg     = null;
	private String    troSeq        = null;
	private String    modCd         = null;
	private String    bkgNo         = null;
	private String    cntrNo        = null;
	private String    delFlg        = null;
	private String    currRtnTroFlg = null;
	private String    currTroSeq    = null;	
	private String    flatFile      = null;
	private String    ownrTrkFlg      = null;
	/**
	 * @return the ownrTrkFlg
	 */
	public String getOwnrTrkFlg() {
		return ownrTrkFlg;
	}

	/**
	 * @param ownrTrkFlg the ownrTrkFlg to set
	 */
	public void setOwnrTrkFlg(String ownrTrkFlg) {
		this.ownrTrkFlg = ownrTrkFlg;
	}

	/** ContainerVO 조회목록 처리 */
	private TroVO troVO = null;


	public EsmBkg007902bEvent(){}

	/**
	 * @return the bkgBlNoVO
	 */
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}


	/**
	 * @param bkgBlNoVO the bkgBlNoVO to set
	 */
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}



	/**
	 * @return the boundCd
	 */
	public String getBoundCd() {
		return boundCd;
	}

	/**
	 * @param boundCd the boundCd to set
	 */
	public void setBoundCd(String boundCd) {
		this.boundCd = boundCd;
	}

	/**
	 * @return the troVO
	 */
	public TroVO getTroVO() {
		return troVO;
	}

	/**
	 * @param troVO the troVO to set
	 */
	public void setTroVO(TroVO troVO) {
		this.troVO = troVO;
	}

	/**
	 * @return the rtnTroFlg
	 */
	public String getRtnTroFlg() {
		return rtnTroFlg;
	}

	/**
	 * @param rtnTroFlg the rtnTroFlg to set
	 */
	public void setRtnTroFlg(String rtnTroFlg) {
		this.rtnTroFlg = rtnTroFlg;
	}

	/**
	 * @return the troSeq
	 */
	public String getTroSeq() {
		return troSeq;
	}

	/**
	 * @param troSeq the troSeq to set
	 */
	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}

	/**
	 * @return the modCd
	 */
	public String getModCd() {
		return modCd;
	}

	/**
	 * @param modCd the modCd to set
	 */
	public void setModCd(String modCd) {
		this.modCd = modCd;
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
	 * @return the cntrNo
	 */
	public String getCntrNo() {
		return cntrNo;
	}

	/**
	 * @param cntrNo the cntrNo to set
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * @return the delFlg
	 */
	public String getDelFlg() {
		return delFlg;
	}

	/**
	 * @param delFlg the delFlg to set
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	/**
	 * @return the currTroSeq
	 */
	public String getCurrTroSeq() {
		return currTroSeq;
	}

	/**
	 * @param currTroSeq the currTroSeq to set
	 */
	public void setCurrTroSeq(String currTroSeq) {
		this.currTroSeq = currTroSeq;
	}

	/**
	 * @return the currRtnTroFlg
	 */
	public String getCurrRtnTroFlg() {
		return currRtnTroFlg;
	}

	/**
	 * @param currRtnTroFlg the currRtnTroFlg to set
	 */
	public void setCurrRtnTroFlg(String currRtnTroFlg) {
		this.currRtnTroFlg = currRtnTroFlg;
	}

	/**
	 * @return the flatFile
	 */
	public String getFlatFile() {
		return flatFile;
	}

	/**
	 * @param flatFile the flatFile to set
	 */
	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}	
}