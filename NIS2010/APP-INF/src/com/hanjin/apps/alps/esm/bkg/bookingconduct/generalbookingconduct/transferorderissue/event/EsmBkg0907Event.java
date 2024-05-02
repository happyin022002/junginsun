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
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgEurCntrListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0907 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0907HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Nam Kyung
 * @see ESM_BKG_0907HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0907Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Condition 용  */
	private BkgBlNoVO bkgBlNoVO = null;
	private String    ioBndCd   = null;


	/** 조회목록 출력용 CustomVO */
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgEurCntrListVO bkgEurCntrListVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgEurCntrListVO[] bkgEurCntrListVOs = null;

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

	public BkgEurCntrListVO getBkgEurCntrListVO() {
		return bkgEurCntrListVO;
	}

	public void setBkgEurCntrListVO(BkgEurCntrListVO bkgEurCntrListVO) {
		this.bkgEurCntrListVO = bkgEurCntrListVO;
	}

	public BkgEurCntrListVO[] getBkgEurCntrListVOs() {
		return bkgEurCntrListVOs;
	}

	public void setBkgEurCntrListVOs(BkgEurCntrListVO[] bkgEurCntrListVOs) {
		this.bkgEurCntrListVOs = bkgEurCntrListVOs;
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