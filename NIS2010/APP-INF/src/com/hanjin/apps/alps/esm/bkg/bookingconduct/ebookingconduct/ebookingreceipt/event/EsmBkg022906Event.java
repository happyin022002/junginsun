/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg022906Event.java
*@FileTitle : e-Booking & SI Process Detail(TRO/O)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.22 전용진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0229_06 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0229_06HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0229_06HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg022906Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Condition 용  */	
	private BkgBlNoVO bkgBlNoVO     = null;
	private String    boundCd       = null;
	private String    rtnTroFlg     = null;
	private String    bkgNo         = null;
	private String    delFlg        = null;	
	private String    currTroSeq    = null;	
	private String    isEurFlg      = null;  //eBooking의 경우, Eur 여부 
	
	/** ContainerVO 조회목록 처리 */
	private TroVO    troVO    = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private XterRqstNoVO xterRqstNoVO = null;
	

	public EsmBkg022906Event(){}

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
	 * @return the xterRqstNoVO
	 */
	public XterRqstNoVO getXterRqstNoVO() {
		return xterRqstNoVO;
	}

	/**
	 * @param xterRqstNoVO the xterRqstNoVO to set
	 */
	public void setXterRqstNoVO(XterRqstNoVO xterRqstNoVO) {
		this.xterRqstNoVO = xterRqstNoVO;
	}

	/**
	 * @return the isEurFlg
	 */
	public String getIsEurFlg() {
		return isEurFlg;
	}

	/**
	 * @param isEurFlg the isEurFlg to set
	 */
	public void setIsEurFlg(String isEurFlg) {
		this.isEurFlg = isEurFlg;
	}
}