/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg007905Event.java
*@FileTitle : Customer Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.07.31 김병규
* 1.0 Creation
* -----------------------------------------------------------
* History
* 2010.11.23 최도순 [CHM-201007206] Actual customer column 보완 및 M&D 화면에 자동 DISPLAY 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0079_05 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0079_05HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_0079_05HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg007905Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String custCntCd = null;
	private String custSeq = null;
	
	private String oldActCustCd = null;
	private String newActCustCd = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null;
	private CustEtcVO custEtcVO = null;
	private BlDocCustVO blDocCustVO = null;	
	
	/** Table Value Object Multi Data 처리 */


	public EsmBkg007905Event(){}
	
	public BkgBlNoVO getBkgBlNoVO(){
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO){
		this.bkgBlNoVO = bkgBlNoVO;
	}
	
	public CustEtcVO getCustEtcVO(){
		return custEtcVO;
	}

	public void setCustEtcVO(CustEtcVO custEtcVO){
		this.custEtcVO = custEtcVO;
	}
	
	public BlDocCustVO getBlDocCustVO(){
		return blDocCustVO;
	}

	public void setBlDocCustVO(BlDocCustVO blDocCustVO){
		this.blDocCustVO = blDocCustVO;
	}

	public void setCustCntCd(String custCntCd){
		this. custCntCd = custCntCd;
	}

	public String getCustCntCd(){
		return custCntCd;
	}	

	public void setCustSeq(String custSeq){
		this. custSeq = custSeq;
	}

	public String getCustSeq(){
		return custSeq;
	}

	/**
	 * @return the oldActCustCd
	 */
	public String getOldActCustCd() {
		return oldActCustCd;
	}

	/**
	 * @param oldActCustCd the oldActCustCd to set
	 */
	public void setOldActCustCd(String oldActCustCd) {
		this.oldActCustCd = oldActCustCd;
	}

	/**
	 * @return the newActCustCd
	 */
	public String getNewActCustCd() {
		return newActCustCd;
	}

	/**
	 * @param newActCustCd the newActCustCd to set
	 */
	public void setNewActCustCd(String newActCustCd) {
		this.newActCustCd = newActCustCd;
	}
	
}