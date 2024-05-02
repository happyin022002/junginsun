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

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0921 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0921HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Nam Kyung
 * @see ESM_BKG_0921HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0920Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Condition 용  */
	private String    bkgNo     = null;
	private BkgBlNoVO bkgBlNoVO = null;
	private String    boundCd   = null;
	private String    troSeq    = null;
	private String    uiId      = null;

	/** 저장용 */
	private BkgBlNoVO[] arrBkgBlNoVO = null;
	
	
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
	 * @return the arrBkgBlNoVO
	 */
	public BkgBlNoVO[] getArrBkgBlNoVO() {
		BkgBlNoVO[] tmpVOs = null;
		if (this. arrBkgBlNoVO != null) {
			tmpVOs = Arrays.copyOf(arrBkgBlNoVO, arrBkgBlNoVO .length);
		}
		return tmpVOs;
	}
	/**
	 * @param arrBkgBlNoVO the arrBkgBlNoVO to set
	 */
	public void setArrBkgBlNoVO(BkgBlNoVO[] arrBkgBlNoVO) {
		if (arrBkgBlNoVO != null) {
			BkgBlNoVO[] tmpVOs = Arrays.copyOf(arrBkgBlNoVO, arrBkgBlNoVO .length);
			this. arrBkgBlNoVO = tmpVOs;
		}
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
	 * @return the uiId
	 */
	public String getUiId() {
		return uiId;
	}
	/**
	 * @param uiId the uiId to set
	 */
	public void setUiId(String uiId) {
		this.uiId = uiId;
	}
}