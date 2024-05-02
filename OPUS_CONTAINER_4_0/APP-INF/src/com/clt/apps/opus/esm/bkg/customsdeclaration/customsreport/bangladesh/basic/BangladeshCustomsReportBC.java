/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BangadeshCustomsReportBC.java
*@FileTitle : BangadeshCustomsReportBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.BangladeshCustCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.BkgCstmsBdFrtFwrdLicDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.LicenseInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.LicenseInfoListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-BangadeshCustomsReport Business Logic Command Interface<br>
 * - OPUS-BangadeshCustomsReport에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author charves
 * @see UI_BKG-0215EventResponse,CustomsReportBC 각 DAO클래스 참조
 * @since J2EE 1.6
 */
public interface BangladeshCustomsReportBC {

	/**
	 * Bangladesh Customs License정보를 조회 한다.
	 * @param LicenseInfoCondVO licenseInfoCondVO
	 * @return List<LicenseInfoListVO>
	 * @throws EventException
	 */
	public List<LicenseInfoListVO> searchLicenseInfo(LicenseInfoCondVO licenseInfoCondVO) throws EventException;

	/**
	 * Customs Code가 추가되었을때 해당 Customs Name을 조회한다.
	 *
	 * @param BangladeshCustCondVO custCondVO
	 * @return String
	 * @throws EventException
	 */
	public String searchCustomerNm(BangladeshCustCondVO custCondVO) throws EventException;


	/**
	 * Bangladesh License정보를 입력/수정/삭제한다.
	 *
	 * @param BkgCstmsBdFrtFwrdLicDetailVO[] bkgCstmsBdFrtFwrdLicDetailVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageLicenseInfo(BkgCstmsBdFrtFwrdLicDetailVO[] bkgCstmsBdFrtFwrdLicDetailVO, SignOnUserAccount account) throws EventException;


}

