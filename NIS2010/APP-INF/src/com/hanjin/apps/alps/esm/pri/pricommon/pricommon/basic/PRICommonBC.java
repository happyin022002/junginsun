/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PRICommonBC.java
 *@FileTitle : PRICommon
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.16 박성수
 * 1.0 Creation
=========================================================
 * History
 * 2011-08-18 송호진 [CHM-2011128680-01]관련 EAI Send Log 생성부분 추가
 * 2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나
조회 가능토록 수정 - searchCheckRfaCtrtRqstOfc Method 추가
 * 2013.04.29 김보배 [CHM-201324375] Publish 기능 이전 요청
 * 2013.10.16 전윤주 [CHM-201327107] S/C Note 하 Chassis 항목 추가
 * 2015.04.22 송호진 [CHM-201535019] Customer Type = A 에 Actual Customer 란 활성화 요청
 * 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)
 * 2016.09.07 [CHM-201642825] [해수부 운임공표 및 신고제] 운임신고 관련 시스템 개발 (정식방식)
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.CheckUpdateDateVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.ComOrganizationVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PriCommonVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PrsBatchVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltChkRatePortVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCompensationChargeComboListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltPriAuthorizationVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComUpldFileVO;
import com.hanjin.syscommon.common.table.ComUserVO;
import com.hanjin.syscommon.common.table.MdmChargeVO;
import com.hanjin.syscommon.common.table.MdmSlsRepVO;
import com.hanjin.syscommon.common.table.PriAuthorizationVO;
import com.hanjin.syscommon.common.table.PriEaiSndLogVO;
import com.hanjin.syscommon.common.table.PriPrsBatVO;
import com.hanjin.syscommon.common.table.PriTariffVO;

/**
 * NIS2010-Pricommon Business Logic Command Interface<br>
 * - NIS2010-Pricommon에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Park Sungsoo
 * @see PricommonEventResponse 참조
 * @since J2EE 1.4
 */


public interface PRICommonBC {
	/**
	 * Service Scope Code list 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchServiceScopeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Currency Code list 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCurrencyCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Per Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchPerCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Sub-continent Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSubcontinentCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Service Scope Detail Name 을 조회합니다.<br>
	 * 
	 * @param String svcScpCd
	 * @return String
	 * @exception EventException
	 */
	public String searchServiceScopeCodeDetailName(String svcScpCd) throws EventException;

	/**
	 * Location Name 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchLocationName(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Country Name 을 조회합니다.<br>
	 * 
	 * @param String cntCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCountryName(String cntCd) throws EventException;

	/**
	 * Commodity Name 을 조회합니다.<br>
	 * 
	 * @param String cmdtCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCommodityName(String cmdtCd) throws EventException;

	/**
	 * Rep Commodity Name 을 조회합니다.<br>
	 * 
	 * @param String repCmdtCd
	 * @return String
	 * @exception EventException
	 */
	public String searchRepCommodityName(String repCmdtCd) throws EventException;

	/**
	 * Surcharge Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSurchargeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Commodity Group Name 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchCommodityGroupName(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Location Group Name 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchLocationGroupName(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * MDM Container Size Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchMdmCntrSzCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * S/C Proposal Service Scope Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSpScpServiceScopeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Office Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchOfficeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Office Code 에 의한 Sales Rep Code 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSalesRepByOfficeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * SalesRepByMultiOfficeList 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSalesRepByMultiOfficeList(RsltCdListVO rsltCdlistVo) throws EventException;
	
	/**
	 * MQC 에 대한 Service Scope List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSpScpMqcServiceScopeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * 조직도(RAS) 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRasOrganizationList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * 해당 CUR 별 US 환율을 가져와 현재 AMOUNT와 곱하여 리턴합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchUsExangeAmount(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * BKG_REV_UMCH_TP 테이블을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchBkgRevUmchTpList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * BKG_REV_UMCH_SUB_TP 테이블을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchBkgRevUmchSubTpList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Sales Rep Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSalesRepCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * S/C Proposal Scope Group Location Name 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchSpScopeGroupLocationName(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Sub Trade Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSubTrdCdList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Service Scope Lane Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSvcScpLaneCdList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Customer Name 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCustomerName(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Charge Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchChargeCdList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Surcharge Group Commodity Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchScgGrpCmdtCdList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Surcharge Group Location Name 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public String searchSurchargeGroupLocationName(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Region Name 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRegionName(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Scope 별 Charge Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchScopeChargeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * PRS Scope 별 Charge Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchPRSScopeChargeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Authorization 정보를 조회합니다.<br>
	 * 
	 * @param PriAuthorizationVO vo
	 * @return List<PriAuthorizationVO>
	 * @exception EventException
	 */
	public List<PriAuthorizationVO> searchAuthorization(PriAuthorizationVO vo) throws EventException;

	/**
	 * Tariff Code로 PRI_AUTHORIZATION 테이블을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO vo
	 * @return List<PriAuthorizationVO>
	 * @exception EventException
	 */
	public List<PriAuthorizationVO> searchAuthByTariff(RsltCdListVO vo) throws EventException;

	/**
	 * Currency 정보를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchAllCurrencyCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Service Scope Property Mapping Rule List를 조회 합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSvcScpPptMapgList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Per Type 코드,명칭을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchAllPerCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Note Conversion Rule 코드,명칭 CONVERSION TYPE별로 조회 합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchNoteConvRuleMapgList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Request Office Name 정보를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRequestOfficeName(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Customer 별 sale rep를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCustBySaleRepList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Sales Rep Code 로 Office Code 와 Sales Rep Name 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCustByReqOffice(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Approval Office를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchApprovalOfficeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * 기존의 office코드와 함께 Approval Office를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchApprovalOfficeAllList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Location, Group Location, Country, Region Name을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTotalLocationName(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * PRS Exchange Rate List 를 조회합니다.<br>
	 * 해당 Exchange Rate 년월을 리턴합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchPrsExchangeRateYrMon(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * PRS Exchange Rate List 를 조회합니다.<br>
	 * 해당 Exchange Rate 년월을 리턴합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchPrsTPExchangeRateYrMon(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * PRS RQ Exchange Rate Year Mon를 조회합니다.<br>
	 * 해당 Exchange Rate 년월을 리턴<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchPrsRqExchangeRateYrMon(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * PRS SQ Exchange Rate List 를 조회합니다.<br>
	 * 해당 Exchange Rate 년월을 리턴<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchPrsSqExchangeRateYrMon(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * PRS RP Exchange Rate List를 조회합니다.<br>
	 * 해당 Exchange Rate 년월을 리턴<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchPrsRpExchangeRateYrMon(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * VESSEL SERVICE LANE의 코드명을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchVesselServiceLaneName(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * VSK VESSEL SCHEDULE 코드를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchVskVesselScheduleCode(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Actual Customer 리스트를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchActualCustomerList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * IMDG Class 리스트를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchImdgClassCode(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Location Code를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchServiceScopeLocationCode(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * cmpb group commodity Name<br>
	 * 코드에 해당하는 이름을 가져온다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchCmpbGroupCommodityName(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * cmpb group location Name<br>
	 * 코드에 해당하는 이름을 가져온다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchCmpbGroupLocationName(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * RFA Proposal Service Scope Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRpScpServiceScopeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * SYS_GUID()값을 조회한다.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchSysGuid() throws EventException;

	/**
	 * 공통 코드,명칭 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchComCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * DMT S/C EXCEPTION GROUP에서 PROP_NO가 존재하는지 조회합니다.<br>
	 * 
	 * @param rsltcdlistvo RsltCdListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchDmtScExptGrpCount(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * CHSS S/C EXCEPTION LIST에서 PROP_NO가 존재하는지 조회합니다.<br>
	 * 
	 * @param rsltcdlistvo RsltCdListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchChssScExptListCount(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * 공통 코드,명칭을 한번에 조회합니다.<br>
	 * 
	 * @param RsltCdListVO paramCdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchComCodeDescList(RsltCdListVO paramCdlistvo) throws EventException;

	/**
	 * Rep Charge Code List를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRepChargeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * SC Prefix List를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchScPrefixList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * RHQ List를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRHQList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Batch Job 실행후 jobid를 program no(etc1)와 parameter(etc2)로 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public RsltCdListVO searchBatchScheduleJobIdAndStatus(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Term Tyle List를 조회합니다.<br>
	 * S/C Term Type 을 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTermTypeList(RsltCdListVO rsltCdlistVo) throws EventException;

	/**
	 * Term Tyle List를 조회합니다.<br>
	 * RFA Term Type 을 조회한다.<br>
	 * 
	 * @param rsltCdlistVo RsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRfaTermTypeList(RsltCdListVO rsltCdlistVo) throws EventException;

	/**
	 * Term Tyle List를 조회합니다.<br>
	 * SCOPE 별 CHARGE 코드리스트를 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTradeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * Surcharge Trade Code를 조회 이벤트 처리<br>
	 * Trade 별 CHARGE 코드리스트를 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSurchargeTradeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * RLane을 조회를 조회합니다.<br>
	 * SCOPE 별 CHARGE 코드리스트를 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRLaneCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * 조직도를 조회합니다.<br>
	 * 
	 * @param ComOrganizationVO comOrganizationVO
	 * @return List<ComOrganizationVO>
	 * @exception EventException
	 */
	public List<ComOrganizationVO> searchOrganizationList(ComOrganizationVO comOrganizationVO) throws EventException;

	/**
	 * charge 리스트를 조회합니다.<br>
	 * 
	 * @param MdmChargeVO mdmChargeVO
	 * @return List<MdmChargeVO>
	 * @exception EventException
	 */
	public List<MdmChargeVO> searchChargeList(MdmChargeVO mdmChargeVO) throws EventException;

	/**
	 * 로그인 사용자의 SELECT 권한 정보와 REQUEST OFFICE를 조회합니다.[PRS용]<br>
	 * 
	 * @param RsltPriAuthorizationVO priAuthorizationVO
	 * @param SignOnUserAccount account
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public RsltCdListVO searchAuthorizationOffice(RsltPriAuthorizationVO priAuthorizationVO, SignOnUserAccount account) throws EventException;

	/**
	 * Sales Rep Code 로 User 정보를 조회합니다.<br>
	 * 
	 * @param MdmSlsRepVO mdmSlsRepVO
	 * @return List<ComUserVO>
	 * @exception EventException
	 */
	public List<ComUserVO> searchSalesRepInfo(MdmSlsRepVO mdmSlsRepVO) throws EventException;

	/**
	 * PRS BATCH table에 parameter와 program id, batch id를 저장합니다.<br>
	 * 
	 * @param PriPrsBatVO priPrsBatVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addPrsBatch(PriPrsBatVO priPrsBatVO, SignOnUserAccount account) throws EventException;

	/**
	 * PRS BATCH table에서 parameter와 program id를 이용해 batch id를 조회합니다.<br>
	 * 
	 * @param PriPrsBatVO priPrsBatVO
	 * @return PrsBatchVO
	 * @exception EventException
	 */
	public PrsBatchVO searchPrsBatch(PriPrsBatVO priPrsBatVO) throws EventException;

	/**
	 * Tariff Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTariffCodeList(RsltCdListVO rsltCdlistVo) throws EventException;

	/**
	 * Service Scope Code 로 Tariff Code 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTariffCodeByServiceScopeCode(RsltCdListVO rsltCdlistVo) throws EventException;

	/**
	 * RFA Actual Customer 리스트 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRFAActualCustomerList(RsltCdListVO rsltCdlistVo) throws EventException;

	/**
	 * Tariff Code 가 존재하는 Service Scope Code List 전체를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTariffServiceScopeCodeList(RsltCdListVO rsltCdlistVo) throws EventException;

	/**
	 * BackEndJob의 상태를 조회합니다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String key) throws EventException;

	/**
	 * Upload 되어있는 Excel Template File Key 를 조회합니다.<br>
	 * 
	 * @param ComUpldFileVO comUpldFileVO
	 * @return String
	 * @exception EventException
	 */
	public String searchExcelTemplateFileKey(ComUpldFileVO comUpldFileVO) throws EventException;

	/**
	 * Compensation Charge Combo list 리스트를 조회한다.<br>
	 * DHF, CMS, NMS, ODF 조회.<br>
	 * 
	 * @param RsltCompensationChargeComboListVO pVo
	 * @return List<RsltCompensationChargeComboListVO>
	 * @exception EventException
	 */
	public List<RsltCompensationChargeComboListVO> searchCompensationChargeComboList(RsltCompensationChargeComboListVO pVo) throws EventException;

	/**
	 * Sales Rep 에 대한 Customer List 정보를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSalesRepListByCustOnly(RsltCdListVO rsltCdlistVo) throws EventException;

	/**
	 * PRS BATCH table에 prs_bat_id 값을 update한다. <br>
	 * 
	 * @param PriPrsBatVO priPrsBatVO
	 * @exception EventException
	 */
	public void modifyPrsBatchMaxRotation(PriPrsBatVO priPrsBatVO) throws EventException;

	/**
	 * PRS BATCH table에 log 값을 update한다. <br>
	 * 
	 * @param PriPrsBatVO priPrsBatVO
	 * @exception EventException
	 */
	public void modifyPrsBatchLog(PriPrsBatVO priPrsBatVO) throws EventException;

	/**
	 * PRS BATCH table에서 parameter와 program id를 이용해 batch id를 조회합니다.<br>
	 * 
	 * @param PriPrsBatVO priPrsBatVO
	 * @return PrsBatchVO
	 * @exception EventException
	 */
	public PrsBatchVO searchPrsBatchMaxRotation(PriPrsBatVO priPrsBatVO) throws EventException;

	/**
	 * Region Code, Contry Code가 MDM_SVC_SCP_LMT 에 Origin, Dest에 맞춰서 존재 하는지 확인한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCheckServiceScopeOriginDestRegionList(RsltCdListVO rsltCdlistVo) throws EventException;

	/**
	 * 화면 조회이후 upd_dt가 변경되었는지 확인한다.<br>
	 * 
	 * @param CheckUpdateDateVO checkUpdateDate
	 * @return CheckUpdateDateVO
	 * @exception DAOException
	 */
	public CheckUpdateDateVO searchCheckUpdateDate(CheckUpdateDateVO checkUpdateDate) throws EventException;

	/**
	 * 입력한 Tariff Code에 해당하는 Tariff Name 조회
	 * 
	 * @param PriTariffVO priTariffVO
	 * @return List<PriTariffVO>
	 * @exception EventException
	 */
	public List<PriTariffVO> searchTariffCodeName(PriTariffVO priTariffVO) throws EventException;

	/**
	 * SYSDATE의 정보를 YYYYMMDD포멧으로 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchSystemDate(RsltCdListVO rsltCdlistVo) throws EventException;

	/**
	 * Pricing EAI Send Log 정보를 저장합니다.<br>
	 * 
	 * @param PriEaiSndLogVO priEaiSndLogVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addEaiSendLog(PriEaiSndLogVO priEaiSndLogVO, SignOnUserAccount account) throws EventException;

	/**
	 * 해당 RFA No,Proposal No가 BA Office에서 생성된것인지 확인<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckRfaCtrtRqstOfc(RsltCdListVO rsltCdlistVo) throws EventException;

	/**
	 * 2012.05.22 추가 <br>
	 * 구주 Hinterland 프로젝트에 따른 변경 사항 <br>
	 * 구주 Hinterland 프로젝트 오픈 이전에 발생한 AEW, AEE에 대해서는 Ament 불가<br>
	 * 
	 * @param rsltCdlistVo
	 * @return int
	 * @throws EventException
	 */
	public int searchCheckForBeforeAmend(RsltCdListVO rsltCdlistVo) throws EventException;

	/**
	 * RFA Proposal Creation-Rate[Load Excel] <br>
	 * SERVICE SCOPE 가 AEE, AEW인경우 PORT 코드 체크를 위한 메소드 <BR>
	 * 
	 * @return List<RsltChkRatePortVO>
	 * @throws EventException
	 */
	public List<RsltChkRatePortVO> searchCheckRatePort() throws EventException;

	/**
	 * 환율 변환 ==> USD ==> Local Currency
	 * 
	 * @param PriCommonVO priCommonVO
	 * @return String
	 * @throws EventException
	 */
	public String searchFromUsdToEtcCurrency(PriCommonVO priCommonVO) throws EventException;

	/**
	 * RHQ 별 Service Scope 리스트 정보를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchServiceScopeByRhqOfc(RsltCdListVO rsltCdlistVo) throws EventException;

	/**
	 * RHQ 별 Service Scope 리스트 정보를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTariffIhcExceptionCyLocation(RsltCdListVO rsltCdlistVo) throws EventException;

	/**
	 * Service Scope 별 Bound 정보를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchBoundByServiceScope(RsltCdListVO rsltCdlistVo) throws EventException;

	/**
	 * US Country 정보를 조회합니다.<br>
	 * ( FOR Add-on management T/F Project )
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchUSInlandCountryCode(RsltCdListVO rsltCdlistVo) throws EventException;

	/**
	 * Copy 이전의 Duration 날짜 조회.
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchDurationDateForRateCopy(RsltCdListVO rsltCdlistVo) throws EventException;

	/**
	 * To Date 조회
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchToDate() throws EventException;
	
	/**
	 * Tariff Mapping 을 위한 Country 정보를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchAocTariffCountryList(RsltCdListVO rsltCdlistVo) throws EventException;

	/**
	 * Percent Base CHG Creation 화면에서 사용할 ChargeList 를 조회합니다.<br>
	 * mdm_charge 코드,명칭을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchChargeListForPctBse (RsltCdListVO rsltCdlistVo) throws EventException ;

	/**
	 * 2015.04.13 추가 <br>
	 * Shipper's Association S/C 에서 Actual Customer 를 입력할 때 
	 * Affiliate 로 등재 되어있는 지를 체크한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return int
	 * @throws EventException
	 */
	public int searchCheckValidAfil(RsltCdListVO rsltCdlistVo) throws EventException ;
	
	/**
	 * 2016.04.15 추가 <br>
	 * Master RFA의 Route Note Conversion 코드를 조회한다.
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchMstNoteConvChgCdList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * Office Code 에 의한 Sales Rep Code with Role를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSalesRepRoleByOfficeList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * S/C File Cancel 권한 조회<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @param SignOnUserAccount account
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public RsltCdListVO checkFileCancelAuth(RsltCdListVO rsltcdlistvo, SignOnUserAccount account) throws EventException;

	/**
	 * 2016.05.02 추가 <br>
	 * Master RFA의 권한을 조회한다.
	 * 
	 * @param String usr_id
	 * @return RsltCdListVO rsltCdlistVo
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchMstRfaAuthList(String usr_id) throws EventException;
	
}