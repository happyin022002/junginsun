/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0704Event.java
*@FileTitle : TRO-Container Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.06.04 이남경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0704 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0704HTMLAction에서 작성<br>
 *
 * @author Lee Nam Kyung
 * @see ESM_BKG_0704HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0704Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/* param */
	private String bkgNo       = null;
	private String bkgStsCd    = null;

	private BkgBlNoVO bkgBlNoVO = null;

	/**
	 * @return void
	 */
	public EsmBkg0704Event(){}
	/**
	 * @param String bkgNo
	 * @param String bkgStsCd
	 */
	public EsmBkg0704Event(String bkgNo, String bkgStsCd){
		this.bkgNo    = bkgNo;
		this.bkgStsCd = bkgStsCd;
	}

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
	 * @return the bkgStsCd
	 */
	public String getBkgStsCd() {
		return bkgStsCd;
	}

	/**
	 * @param bkgStsCd the bkgStsCd to set
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}

}