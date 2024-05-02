/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0090Event.java
*@FileTitle : Special Stowage Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.14 KimByungKyu
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0090 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0090HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_0090HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0090Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgComboVO bkgComboVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgComboVO[] bkgComboVOs = null;

	private BkgBlNoVO bkgBlNoVO = null;
	
	public BkgHrdCdgCtntListCondVO getBkgHrdCdgCtntListCondVO() {
		return bkgHrdCdgCtntListCondVO;
	}

	public void setBkgHrdCdgCtntListCondVO(
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO) {
		this.bkgHrdCdgCtntListCondVO = bkgHrdCdgCtntListCondVO;
	}

	private String ctrtNo;
	
	private String stwgCd;
	
	private BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = null;
	
	public EsmBkg0090Event(){}

	public void setBkgComboVO(BkgComboVO bkgComboVO){
		this. bkgComboVO = bkgComboVO;
	}

	public void setBkgComboVOS(BkgComboVO[] bkgComboVOs){
		this. bkgComboVOs = bkgComboVOs;
	}

	public BkgComboVO getBkgComboVO(){
		return bkgComboVO;
	}

	public BkgComboVO[] getBkgComboVOS(){
		return bkgComboVOs;
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public String getCtrtNo() {
		return ctrtNo;
	}

	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}

	public String getStwgCd() {
		return stwgCd;
	}

	public void setStwgCd(String stwgCd) {
		this.stwgCd = stwgCd;
	}
	
}