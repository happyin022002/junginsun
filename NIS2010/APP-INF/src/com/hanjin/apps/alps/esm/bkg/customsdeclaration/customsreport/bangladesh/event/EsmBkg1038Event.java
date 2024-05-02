/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0334Event.java
*@FileTitle : EsmBkg0334Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 1.
*@LastModifier : 전창현
*@LastVersion : 1.0
* 2009. 9. 1. 전창현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.bangladesh.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.BangladeshCustCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.BkgCstmsBdFrtFwrdLicCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.BkgCstmsBdFrtFwrdLicDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.LicenseInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.event.ESM_BKG_0152HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_00152 에 대한 PDTO(Data Transfer Object including Parameters)
 * - ESM_BKG_00152HTMLAction에서 작성
 * - ServiceCommand Layer로 전달하는 PDTO로 사용
 * 
 * @author 전창현
 * @see ESM_BKG_0152HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg1038Event extends EventSupport {

	private static final long serialVersionUID = 7562149991636194708L;

	// 화면에서 넘어오는 파라메터를 저장하는 객체
	//private BkgCstmsChnDeModVO bkgCstmsChnDeModVO = null;
	// 데이터 추가/삭제용 리스트 객체
	
	// 중국 DEL 지역별 운송 Mode를 조회한다.
	private LicenseInfoCondVO licenseInfoCondVO = null;
	private BangladeshCustCondVO custCondVO = null;

	
	public LicenseInfoCondVO getLicenseInfoCondVO() {
		return licenseInfoCondVO;
	}

	public void setLicenseInfoCondVO(
			LicenseInfoCondVO licenseInfoCondVO) {
		this.licenseInfoCondVO = licenseInfoCondVO;
	}
	/**
	 * @return the containerCondVO
	 */
	public BangladeshCustCondVO getCustCondVO() {
		return custCondVO;
	}
	/**
	 * @param containerCondVO the containerCondVO to set
	 */
	public void setCustCondVO(BangladeshCustCondVO custCondVO) {
		this.custCondVO = custCondVO;
	}
	
	
	///////////////////////////////////////////////////////////////////////
	private BkgCstmsBdFrtFwrdLicCondVO bkgCstmsBdFrtFwrdLicCondVO = null;


	public BkgCstmsBdFrtFwrdLicCondVO getBkgCstmsBdFrtFwrdLicCondVO() {
		return bkgCstmsBdFrtFwrdLicCondVO;
	}

	public void setBkgCstmsBdFrtFwrdLicCondVO(
			BkgCstmsBdFrtFwrdLicCondVO bkgCstmsBdFrtFwrdLicCondVO) {
		this.bkgCstmsBdFrtFwrdLicCondVO = bkgCstmsBdFrtFwrdLicCondVO;
	}

	//중국 DEL 지역별 운송 Mode를 입력/수정/삭제한다.
	public BkgCstmsBdFrtFwrdLicDetailVO[] getBkgCstmsBdFrtFwrdLicDetailVOs = null;

	public BkgCstmsBdFrtFwrdLicDetailVO[] getBkgCstmsBdFrtFwrdLicDetailVOs() {
		return getBkgCstmsBdFrtFwrdLicDetailVOs;
	}

	public void setBkgCstmsBdFrtFwrdLicDetailVOs(
			BkgCstmsBdFrtFwrdLicDetailVO[] getBkgCstmsBdFrtFwrdLicDetailVOs) {
		this.getBkgCstmsBdFrtFwrdLicDetailVOs = getBkgCstmsBdFrtFwrdLicDetailVOs;
	}
	
	
	


}
