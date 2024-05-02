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
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroCfmVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0906 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0906HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Nam Kyung
 * @see ESM_BKG_0906HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0906Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Condition 용  */
	private String    bkgNo     = null;
	private String    ioBndCd   = null;
	private BkgBlNoVO bkgBlNoVO = null;

	/** 저장용 */
	private TroCfmVO troCfmVO = null;

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
	 * @return the troCfmVO
	 */
	public TroCfmVO getTroCfmVO() {
		return troCfmVO;
	}
	/**
	 * @param troCfmVO the troCfmVO to set
	 */
	public void setTroCfmVO(TroCfmVO troCfmVO) {
		this.troCfmVO = troCfmVO;
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
}