/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCommonBC.java
*@FileTitle : ACM_Common
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.07 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcommon.acmcommon.basic;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmcommon.acmcommon.vo.CommonVO;
import com.clt.apps.opus.esm.acm.acmcommon.acmcommon.vo.LocationSelectionVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-ACMCommon Business Logic Command Interface<br>
 * - OPUS-ACMCommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_CommonEventResponse 참조
 * @since J2EE 1.6
 */

public interface ACMCommonBC {

	/**
	 * 공통 : A/R Office 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getAROfficeFromBkgChnAgnList(CommonVO commonVO) throws EventException;

	/**
	 * 공통 : China Anegt info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getBkgChnAgnInfo(CommonVO commonVO) throws EventException;

	/**
	 * 공통 : MDM ORGANIZATION info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getMdmOrganizationInfo(CommonVO commonVO) throws EventException;

	/**
	 * 공통 : MDM VENDOR info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getMdmVendorInfo(CommonVO commonVO) throws EventException;

	/**
	 * 공통 : MDM LOCATION info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getMdmLocationInfo(CommonVO commonVO) throws EventException;

	/**
	 * 공통 : MDM VESSEL SERVICE LANE info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getMdmVslSvcLaneInfo(CommonVO commonVO) throws EventException;

	/**
	 * 공통 : MDM ORGANIZATION에서 RHQ 목록을 조회<br>
	 *
	 * @param SignOnUserAccount account
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getRhqLevelFromMdmOrganizationInfo(SignOnUserAccount account) throws EventException;

	/**
	 * 공통 : 로그인한 사용자의 ofc_cd에 따른 A/R Office 목록을 조회<br>
	 *
	 * @param SignOnUserAccount account
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getAROfficeByUserOfficeList(SignOnUserAccount account) throws EventException;

	/**
	 * 공통 : 사용자의 Office Code에 따른 AGN 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @param SignOnUserAccount account
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getAgnByAROfficeList(CommonVO commonVO, SignOnUserAccount account) throws EventException;

	/**
	 * 공통 : MDM_CHARGE info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getMdmChageInfo(CommonVO commonVO) throws EventException;

	/**
	 * 공통 : MDM_SVC_SCP info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getMdmServiceScopeInfo(CommonVO commonVO) throws EventException;

	/**
	 * 공통 : ACM_COMM_TP_CD_MAPG info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getAcmCommTpCdMapg(CommonVO commonVO) throws EventException;

	/**
	 * 공통 : ACM_OFC_INFO에서 AGN 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getAgnFromAcmOfcInfoList(CommonVO commonVO) throws EventException;

	/**
	 * 공통 : ACM_OFC_INFO에서 RHQ 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getRhqFromAcmOfcInfoList(CommonVO commonVO) throws EventException;

	/**
	 * 공통 : MDM CURRENCY info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getMdmCurrencyInfo(CommonVO commonVO) throws EventException;

	/**
	 * 공통 : 로그인한 사용자의 ofc_cd로 Sales Office 목록을 조회<br>
	 *
	 * @param SignOnUserAccount account
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getSalesOfficeFromMdmOrganizationList(SignOnUserAccount account) throws EventException;

	/**
	 * 공통 : [ESM_ACM_0029]Special Compensation Audit 의 Office Code 목록을 조회<br>
	 *
	 * @param SignOnUserAccount account
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getAROfficeAgmtCmpnInfoList(SignOnUserAccount account) throws EventException;

	/**
	 * 공통 : MDM_CUSTOMER에서 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getMdmCustomerInfo(CommonVO commonVO) throws EventException;

	/**
	 * 공통 : RHQ Level에 따른 A/R Office 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @param SignOnUserAccount account
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getAROfficeByRhqLevelList(CommonVO commonVO, SignOnUserAccount account) throws EventException;

	/**
	 * 공통 : MDM_REP_CMDT 혹은 MDM_COMMODITY에서 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO getMdmCommodityInfo(CommonVO commonVO) throws EventException;

	/**
	 * 공통 : [ESM_ACM_0023]FF Compensation Agreement Creation 저장 전 "Charge(Only for BS)"항목 체크<br>
	 * (MDM_CHARGE의 ERR_CNT 가 0인지 아닌지 조회)
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getFfChgCtntChkList(CommonVO commonVO) throws EventException;

	/**
	 * 공통 : 입력된 코드가 MDM_CNTR_TP 에 존재하는지 체크<br>
	 *
	 * @param CommonVO commonVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO getMdmCntrTpChkList(CommonVO commonVO) throws EventException;

	/**
	 * 공통 : 입력된 office code 가 상계 정산 대리점(operational)인지 체크.(리턴값 => operational : Y, else : N)<br>
	 *
	 * @param CommonVO commonVO
	 * @return String
	 * @exception EventException
	 */
	public String getOffSetFlag(CommonVO commonVO) throws EventException;

	/**
	 * [ESM_ACM_0113]
	 * Location Selection 목록을 조회(1. Conti)<br>
	 *
	 * @param LocationSelectionVO locationSelectionVO
	 * @return List<LocationSelectionVO>
	 * @exception EventException
	 */
	public List<LocationSelectionVO> searchLocSelectConti(LocationSelectionVO locationSelectionVO) throws EventException;

	/**
	 * [ESM_ACM_0113]
	 * Location Selection 목록을 조회(2. Sub Conti)<br>
	 *
	 * @param LocationSelectionVO locationSelectionVO
	 * @return List<LocationSelectionVO>
	 * @exception EventException
	 */
	public List<LocationSelectionVO> searchLocSelectSubConti(LocationSelectionVO locationSelectionVO) throws EventException;

	/**
	 * [ESM_ACM_0113]
	 * Location Selection 목록을 조회(3. Country)<br>
	 *
	 * @param LocationSelectionVO locationSelectionVO
	 * @return List<LocationSelectionVO>
	 * @exception EventException
	 */
	public List<LocationSelectionVO> searchLocSelectCountry(LocationSelectionVO locationSelectionVO) throws EventException;

	/**
	 * [ESM_ACM_0113]
	 * Location Selection 목록을 조회(4. Conti)<br>
	 *
	 * @param LocationSelectionVO locationSelectionVO
	 * @return List<LocationSelectionVO>
	 * @exception EventException
	 */
	public List<LocationSelectionVO> searchLocSelectLocation(LocationSelectionVO locationSelectionVO) throws EventException;

	/**
	 * 공통 : RHQ에 따른 Agent Code 목록을 조회<br>
	 *
	 * @param SignOnUserAccount account
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getAgnByRhqList(SignOnUserAccount account) throws EventException;

	/**
	 * 공통 : MDM_TRADE 테이블의 TRD_CD 목록을 조회<br>
	 *
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getMdmTradeList() throws EventException;

	/**
	 * 공통 : COA_LANE_RGST 테이블의 RLANE_CD 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getCoaLaneRgstList(CommonVO commonVO) throws EventException;

}