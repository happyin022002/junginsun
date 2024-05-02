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
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0079_02A 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0079_02AHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Nam Kyung
 * @see ESM_BKG_0079_02AHTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg007902aEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Condition 용  */
	private BkgBlNoVO bkgBlNoVO     = null;	
	private String    boundCd       = null;
	private String    rtnTroFlg     = null;
	private String    bkgNo         = null;
	private String    delFlg        = null;	
	private String    currTroSeq    = null;
	
	/** ContainerVO 조회목록 처리 */
	private TroVO troVO = null;
	private TroDtlVO troDtlVO = null;


	public EsmBkg007902aEvent(){}


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


	public TroDtlVO getTroDtlVO() {
		return troDtlVO;
	}


	public void setTroDtlVO(TroDtlVO troDtlVO) {
		this.troDtlVO = troDtlVO;
	}
	
	
}