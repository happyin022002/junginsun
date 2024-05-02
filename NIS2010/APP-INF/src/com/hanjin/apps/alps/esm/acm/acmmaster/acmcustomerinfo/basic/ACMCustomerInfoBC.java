/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCustomerInfoBC.java
*@FileTitle : ACMCustomerInfoBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.03 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.vo.CustVendorMatchForSCompVO;
import com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.vo.FACExSettingVO;
import com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.vo.FFCmpnExSettingVO;
import com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.vo.FFVendorMatchVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ACMMaster Business Logic Command Interface<br>
 * - ALPS-ACMMaster에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0019EventResponse 참조
 * @since J2EE 1.6
 */

public interface ACMCustomerInfoBC {

	/**
	 * [ESM_ACM_0019]
	 * FF-Vendor Match for FF Compensation 목록을 조회<br>
	 *
	 * @param FFVendorMatchVO ffVendorMatchVO
	 * @return List<FFVendorMatchVO>
	 * @exception EventException
	 */
	public List<FFVendorMatchVO> searchFFVendorMatch(FFVendorMatchVO ffVendorMatchVO) throws EventException;

	/**
	 * [ESM_ACM_0019]
	 * ACM_FF_VNDR_MTCH 테이블에서 FF_CNT_CD와 FF_SEQ의 중복 체크<br>
	 *
	 * @param FFVendorMatchVO ffVendorMatchVO
	 * @exception EventException
	 */
	public void getCustomerFromFFVenderMatch(FFVendorMatchVO ffVendorMatchVO) throws EventException;

	/**
	 * [ESM_ACM_0019]
	 * FF-Vendor Match for FF Compensation 목록을 저장<br>
	 *
	 * @param FFVendorMatchVO[] ffVendorMatchVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFFVendorMatch(FFVendorMatchVO[] ffVendorMatchVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0020]
	 * FF Compensation Exclusion Setting 목록을 조회<br>
	 *
	 * @param FFCmpnExSettingVO ffCmpnExSettingVO
	 * @return List<FFCmpnExSettingVO>
	 * @exception EventException
	 */
	public List<FFCmpnExSettingVO> searchFFCmpnExSetting(FFCmpnExSettingVO ffCmpnExSettingVO) throws EventException;

	/**
	 * [ESM_ACM_0020]
	 * ACM_FF_EXCLU_SET 테이블에서 FF_CNT_CD와 FF_SEQ의 중복 체크<br>
	 *
	 * @param FFCmpnExSettingVO ffCmpnExSettingVO
	 * @exception EventException
	 */
	public void getCustomerFromFFExclusion(FFCmpnExSettingVO ffCmpnExSettingVO) throws EventException;

	/**
	 * [ESM_ACM_0020]
	 * FF Compensation Exclusion Setting 목록을 저장<br>
	 *
	 * @param FFCmpnExSettingVO[] ffCmpnExSettingVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFFCmpnExSetting(FFCmpnExSettingVO[] ffCmpnExSettingVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0021]
	 * FAC Exclusion Setting 목록을 조회<br>
	 *
	 * @param FACExSettingVO facExSettingVO
	 * @return List<FACExSettingVO>
	 * @exception EventException
	 */
	public List<FACExSettingVO> searchFACExSetting(FACExSettingVO facExSettingVO) throws EventException;

	/**
	 * [ESM_ACM_0021]
	 * FAC Exclusion Setting 목록을 저장<br>
	 *
	 * @param FACExSettingVO[] facExSettingVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFACExSetting(FACExSettingVO[] facExSettingVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0022]
	 * Customer-Vendor Match for Special Compensation 목록을 조회<br>
	 *
	 * @param CustVendorMatchForSCompVO custVendorMatchForSCompVO
	 * @return List<CustVendorMatchForSCompVO>
	 * @exception EventException
	 */
	public List<CustVendorMatchForSCompVO> searchCustVendorMatchForSComp(CustVendorMatchForSCompVO custVendorMatchForSCompVO) throws EventException;

	/**
	 * [ESM_ACM_0022]
	 * Customer-Vendor Match for Special Compensation 목록을 저장<br>
	 *
	 * @param CustVendorMatchForSCompVO[] custVendorMatchForSCompVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustVendorMatchForSComp(CustVendorMatchForSCompVO[] custVendorMatchForSCompVOs, SignOnUserAccount account) throws EventException;

}
