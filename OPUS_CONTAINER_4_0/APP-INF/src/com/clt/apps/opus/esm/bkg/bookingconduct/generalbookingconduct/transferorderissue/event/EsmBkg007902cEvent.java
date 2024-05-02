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
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0079_02C 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0079_02CHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Nam Kyung
 * @see ESM_BKG_0079_02CHTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg007902cEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	private BkgBlNoVO bkgBlNoVO     = null;	
	private String    boundCd       = null;
	private String    bkgNo         = null;
	private String    delFlg        = null;
	private String    currTroSeq    = null;
	private String    currTroSubSeq = null;
	private String    cntrNo        = null;
	private String    faxNo         = null;
	private String    eml           = null;
	private String    locCd         = null;
	
	/** ContainerVO 조회목록 처리 */
	private EurTroVO  eurTroVO  = null;

	
	public EsmBkg007902cEvent(){}


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
	 * @return the eurTroVO
	 */
	public EurTroVO getEurTroVO() {
		return eurTroVO;
	}

	/**
	 * @param eurTroVO the eurTroVO to set
	 */
	public void setEurTroVO(EurTroVO eurTroVO) {
		this.eurTroVO = eurTroVO;
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
	 * @return the currTroSubSeq
	 */
	public String getCurrTroSubSeq() {
		return currTroSubSeq;
	}

	/**
	 * @param currTroSubSeq the currTroSubSeq to set
	 */
	public void setCurrTroSubSeq(String currTroSubSeq) {
		this.currTroSubSeq = currTroSubSeq;
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
	 * @return the faxNo
	 */
	public String getFaxNo() {
		return faxNo;
	}


	/**
	 * @param faxNo the faxNo to set
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}


	/**
	 * @return the eml
	 */
	public String getEml() {
		return eml;
	}


	/**
	 * @param eml the eml to set
	 */
	public void setEml(String eml) {
		this.eml = eml;
	}	
	
	
	/**
	 * @return the locCd
	 */
	public String getLocCd() {
		return locCd;
	}
	
	
	/**
	 * @param eml the locCd to set
	 */
	public void setLocCd(String locCd) {
		this.locCd =locCd;
	}	
}