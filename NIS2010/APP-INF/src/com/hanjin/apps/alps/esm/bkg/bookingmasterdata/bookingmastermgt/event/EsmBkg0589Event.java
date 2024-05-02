/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0589Event.java
*@FileTitle : User Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.08
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2011.11.08 정선용
* 1.0 Creation
* 2011.11.29 정선용 [CHM-201113753-01] Split 01-Korea CLL 전송 후 변동사항 발생 시 SMS 자동 발송 기능 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0589 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0589HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0589HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0589Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String slanCd = null;
	private String dirCd = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgUserSmsInputVO bkgUserSmsInputVO = null;
	private BkgUserSmsListVO bkgUserSmsListVO= null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgUserSmsInputVO[] bkgUserSmsInputVOs = null;
	private BkgUserSmsListVO[] bkgUserSmsListVOs = null;

	public EsmBkg0589Event(){}
	

	
	public String getSlanCd() {
		return slanCd;
	}



	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}



	public String getDirCd() {
		return dirCd;
	}



	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}



	public BkgUserSmsInputVO getBkgUserSmsInputVO() {
		return bkgUserSmsInputVO;
	}



	public void setBkgUserSmsInputVO(BkgUserSmsInputVO bkgUserSmsInputVO) {
		this.bkgUserSmsInputVO = bkgUserSmsInputVO;
	}



	public BkgUserSmsInputVO[] getBkgUserSmsInputVOs() {
		return bkgUserSmsInputVOs;
	}



	public void setBkgUserSmsInputVOs(BkgUserSmsInputVO[] bkgUserSmsInputVOs) {
		this.bkgUserSmsInputVOs = bkgUserSmsInputVOs;
	}



	public BkgUserSmsListVO getBkgUserSmsListVO() {
		return bkgUserSmsListVO;
	}



	public void setBkgUserSmsListVO(BkgUserSmsListVO bkgUserSmsListVO) {
		this.bkgUserSmsListVO = bkgUserSmsListVO;
	}



	public BkgUserSmsListVO[] getBkgUserSmsListVOs() {
		return bkgUserSmsListVOs;
	}



	public void setBkgUserSmsListVOs(BkgUserSmsListVO[] bkgUserSmsListVOs) {
		this.bkgUserSmsListVOs = bkgUserSmsListVOs;
	}


}