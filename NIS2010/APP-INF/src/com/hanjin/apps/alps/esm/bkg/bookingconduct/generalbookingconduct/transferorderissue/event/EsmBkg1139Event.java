/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1139Event.java
*@FileTitle : TRO Notice Application
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.28
*@LastModifier : 금병주
*@LastVersion : 1.0
* 2011.11.28 금병주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1139 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1139HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Keum Byoung Joo
 * @see ESM_BKG_1139HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1139Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Condition 용  */
	private String    bkgNo     = null;
	private BkgBlNoVO bkgBlNoVO = null;
    private String    ioBndCd	= null;

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
}