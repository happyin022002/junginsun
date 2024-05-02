/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0079Event.java
*@FileTitle : BKG Creation Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.14 KimByungKyu
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgBookingVO;


/**
 * ESM_BKG_0079 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0079HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_0079HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0079Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private BkgBlNoVO bkgBlNoVO  = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBookingVO bkgBookingVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgBookingVO[] bkgBookingVOs = null;
	
	private String bccExistFlg = null;

	
	public EsmBkg0079Event(){}

	public void setBkgBookingVO(BkgBookingVO bkgBookingVO){
		this. bkgBookingVO = bkgBookingVO;
	}

	public void setBkgBookingVOS(BkgBookingVO[] bkgBookingVOs){
		this. bkgBookingVOs = bkgBookingVOs;
	}

	public BkgBookingVO getBkgBookingVO(){
		return bkgBookingVO;
	}

	public BkgBookingVO[] getBkgBookingVOS(){
		return bkgBookingVOs;
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

	public String getBccExistFlg() {
		return bccExistFlg;
	}

	public void setBccExistFlg(String bccExistFlg) {
		this.bccExistFlg = bccExistFlg;
	}
	
	
}