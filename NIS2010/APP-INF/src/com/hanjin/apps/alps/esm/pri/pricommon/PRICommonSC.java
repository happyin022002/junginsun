/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PRICommonSC.java
 *@FileTitle : PRICommon
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.16 박성수
 * 1.0 Creation
=========================================================
* 2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나
조회 가능토록 수정 - searchCheckRfaCtrtRqstOfc Method 추가
* 2013.10.16 전윤주 [CHM-201327107] S/C Note 하 Chassis 항목 추가 (COMMAND41 추가)
* 2015.04.09 전윤주 [CHM-201534517] Split02-2015년 1월 소스 보안 결함 건 조치 요청
* 2015.04.22 송호진 [CHM-201535019] Customer Type = A 에 Actual Customer 란 활성화 요청
 * 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)
 * 2016.09.07 [CHM-201642825] [해수부 운임공표 및 신고제] 운임신고 관련 시스템 개발 (정식방식)
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.event.PricommonEvent;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration.PRICommonDBDAO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.CheckUpdateDateVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.ComOrganizationVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCompensationChargeComboListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComUserVO;
import com.hanjin.syscommon.common.table.MdmChargeVO;
import com.hanjin.syscommon.common.table.PriAuthorizationVO;
import com.hanjin.syscommon.common.table.PriTariffVO;

/**
 * NIS2010-PRICommon Business Logic ServiceCommand - NIS2010-PRICommon 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Park Sungsoo
 * @see PRICommonDBDAO
 * @since J2EE 1.4
 */

public class PRICommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * PRICommon system 업무 시나리오 선행작업<br>
	 * PRICommon업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * PRICommon system 업무 시나리오 마감작업<br>
	 * PRICommon 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("PRICommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-PRICommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("PricommonEvent")) {
			// Service Scope Code List(전체) (Ras)
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchServiceScopeCodeList(e);
			}
			// Sub-continent Code
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSubcontinentCodeList(e);
			}
			// Per type search
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPerCodeList(e);
			}
			// Service Scope Detail Name
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchServiceScopeCodeDetailName(e);
			}
			// Location Name
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchLocationName(e);
			}
			// Currency search
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchCurrencyCodeList(e);
			}
			// Country Name
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchCountryName(e);
			}
			// Commodity Name
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchCommodityName(e);
			}
			// Surcharge
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchSurchargeCodeList(e);
			}
			// Commodity Group Name
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCommodityGroupName(e);
			}
			// Location Group Name
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchLocationGroupName(e);
			}
			// mdm_cntr_sz code list
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchMdmCntrSzCodeList(e);
			}
			// PRI_SP_SCP_MN Service scope list
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchSpScpServiceScopeCodeList(e);
			}
			// Office Code List ( 전체 )
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchOfficeCodeList(e);
			}
			// Office 에 따른 Sales Rep
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchSalesRepByOfficeList(e);
			}
			// Sales Rep List ( 전체 )
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchSalesRepCodeList(e);
			}
			//
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = searchSpScopeGroupLocationName(e);
			}
			// Sub Trade List
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = searchSubTrdCdList(e);
			}
			// 공통코드 코드+명칭 테이블
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = searchComCodeDescList(e);
			}
			// 공통코드테이블 (Ras)
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = searchComCodeList(e);
			}
			// PRI_SP_SCP_MQC Service scope list
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchSpScpMqcServiceScopeCodeList(e);
			}
			// 조직도를 조회한다.(Ras)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchRasOrganizationList(e);
			}
			// 해당 CUR 별 US 환율을 가져와 현재 AMOUNT와 곱하여 리턴
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = searchUsExangeAmount(e);
			}
			// BKG_REV_UMCH_TP 테이블 조회
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = searchBkgRevUmchTpList(e);
			}
			// BKG_REV_UMCH_SUB_TP 테이블 조회
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = searchBkgRevUmchSubTpList(e);
			}
			// Svc Scp Lane List
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)) {
				eventResponse = searchSvcScpLaneCdList(e);
			}
			// Customer Name
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND07)) {
				eventResponse = searchCustomerName(e);
			}
			// Region Name
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND08)) {
				eventResponse = searchRegionName(e);
			}
			// Charge list
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
				eventResponse = searchChargeCdList(e);
			}
			// surcharge group commodity cd list
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND10)) {
				eventResponse = searchScgGrpCmdtCdList(e);
			}
			// surcharge group location nm
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND11)) {
				eventResponse = searchSurchargeGroupLocationName(e);
			}
			// Scope Charge Code List
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND12)) {
				eventResponse = searchScopeChargeCodeList(e);
			}
			// 공통코드 한번에 가져오기
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND13)) {
				eventResponse = searchAllCommon(e);
			}
			// PRI 코드 한번에 가져오기
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND14)) {
				eventResponse = searchPriCode(e);
			}
			// PRI_AUTHORIZATION 가져오기
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND15)) {
				eventResponse = searchAuthorization(e);
			}
			// MDM_CURRENCY 전체 가져오기
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND16)) {
				eventResponse = searchAllCurrencyCodeList(e);
			}
			// Service Scope에 대한 Property 가져오기(PRI_SVC_SCP_PPT_MAPG)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND17)) {
				eventResponse = searchSvcScpPptMapgList(e);
			}
			// Per type search
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND18)) {
				eventResponse = searchAllPerCodeList(e);
			}// NOTE CONVERSION RULE CODE ( CONVERSION TYPE별)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND19)) {
				eventResponse = searchNoteConvRuleMapgList(e);
			}

			// sales rep customer별
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND20)) {
				eventResponse = searchCustBySaleRepList(e);
			}
			// sales rep customer별 NAME
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND21)) {
				eventResponse = searchCustByReqOffice(e);
			}
			// request office
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND22)) {
				eventResponse = searchRequestOfficeName(e);
			}
			// APPROVAL office
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND23)) {
				eventResponse = searchApprovalOfficeList(e);
			}
			// Location|Group Location|Country|Region|State Code Name
			// Group Location 일경우에는 etc1에 group_cmd 데이터를 받아야함.
			// RFA Group Location 일경우에는 ORI/DEST 구분이 필요한 경우 ~
			// etc2에 org_dest_tp_cd값을 추가해야함.
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND24)) {
				eventResponse = searchTotalLocationName(e);
			}
			// prs_xch_rt_yrmon|prs_xch_rt_yrmon
			// pri_sp_scp_mn 테이블에서 환율계산 년월을 조회함
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND25)) {
				eventResponse = searchPrsExchangeRateYrMon(e);
			}

			// VESSEL SERVICE LANE 코드명 가져오기(MDM_VSL_SVC_LANE)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND26)) {
				eventResponse = searchVesselServiceLaneName(e);
			}
			// VSK VESSEL SCHEDULE 코드 가져오기(VSK_VSL_SKD)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND27)) {
				eventResponse = searchVskVesselScheduleCode(e);
			}
			// Actual Customer 리스트가져오기
			// 필수항목: PROP_CD, AMDT_SEQ, SVC_SCP_CD
			// 예) KR000021|HANKOOK TIRE CO., LTD
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND28)) {
				eventResponse = searchActualCustomerList(e);
			}
			// Rep Commodity Name
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND29)) {
				eventResponse = searchRepCommodityName(e);
			}
			// IMO Class (SCG_IMDG_CLSS_CD)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND30)) {
				eventResponse = searchImdgClassCode(e);
			}
			// Location Code (MDM_SVC_SCP_LMT와MDM_LOCATION 에서 SCOPE별로 LOCATION이
			// 존재하는 데이터만 조회)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND31)) {
				eventResponse = searchServiceScopeLocationCode(e);
			}
			// CMPB Group Commodity Name
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND32)) {
				eventResponse = searchCmpbGroupCommodityName(e);
			}
			// CMPB Group Location Name
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND33)) {
				eventResponse = searchCmpbGroupLocationName(e);
			}
			// prs_xch_rt_yrmon|prs_xch_rt_yrmon
			// pri_rq_mn 테이블에서 환율계산 년월을 조회함
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND34)) {
				eventResponse = searchPrsRqExchangeRateYrMon(e);
			}
			// prs_xch_rt_yrmon|prs_xch_rt_yrmon
			// pri_rp_scp_mn 테이블에서 환율계산 년월을 조회함
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND35)) {
				eventResponse = searchPrsRpExchangeRateYrMon(e);
			}
			// prs_xch_rt_yrmon|prs_xch_rt_yrmon
			// pri_sq_mn 테이블에서 환율계산 년월을 조회함
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND36)) {
				eventResponse = searchPrsSqExchangeRateYrMon(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND37)) {
				eventResponse = searchRpScpServiceScopeCodeList(e);
			}
			// SYS_GUID() - globally unique identifier
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND38)) {
				eventResponse = searchSysGuid();
			}
			// DMT_SC_EXPT_GRP - PROP_NO존재유무:PROP_NO의 COUNT정보조회
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND39)) {
				eventResponse = searchDmtScExptGrpCount(e);
			}
			// rep charge 콤보 (Ras)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND40)) {
				eventResponse = searchRepChargeCodeList(e);
			}			
			// CGM_SC_EXPT_LIST - PROP_NO존재유무:PROP_NO의 COUNT정보조회
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND41)) {
				eventResponse = searchChssScExptListCount(e);
			}
			// Customer 별 담당 Sales Rep (Office Code 제외)
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSalesRepListByCustOnly(e);
			}

			// S/C No prefix 콤보
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchScPrefixList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchBatchScheduleJobIdAndStatus(e);
			}
			// S/C TermType List 콤보
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchTermTypeList(e);
			}
			// S/C RHQ 콤보
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchRHQList(e);
			}

			// PRS Scope Charge Code List
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchPRSScopeChargeCodeList(e);
			}

			// Trade Code List
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {
				eventResponse = searchTradeCodeList(e);
			}

			// RLane List
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST07)) {
				eventResponse = searchRLaneCodeList(e);
			}

			// Organization List
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {
				eventResponse = searchOrganizationList(e);
			}

			// Charge list : CHG_CD, CHG_NM, REP_CHG_CD
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST09)) {
				eventResponse = searchChargeList(e);
			}
			// 권한별 SCP Scope LIST SEARCH.[PRS용]
			// else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
			// eventResponse = searchAuthServiceScopeCodeList(e);
			// }
			// Sales Rep 정보를 조회합니다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)) {
				eventResponse = searchSalesRepInfo(e);
			}
			// Tariff Code List 를 조회합니다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)) {
				eventResponse = searchTariffCodeList(e);
			}

			// prs_xch_rt_yrmon|prs_xch_rt_yrmon
			// pri_sp_scp_mn 테이블에서 환율계산 년월을 조회함
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)) {
				eventResponse = searchPrsTPExchangeRateYrMon(e);
			}
			// Tariff Code List 를 조회합니다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)) {
				eventResponse = searchTariffCodeByServiceScopeCode(e);
			}
			// RFA Actual Customer 리스트가져오기
			// 필수항목: PROP_CD, AMDT_SEQ, SVC_SCP_CD
			// 예) KR000021|HANKOOK TIRE CO., LTD
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST15)) {
				eventResponse = searchRFAActualCustomerList(e);
			}
			//
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST16)) {
				eventResponse = searchAuthByTariff(e);
			}
			// Tariff Code 가 존재하는 Service Scope List 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST17)) {
				eventResponse = searchTariffServiceScopeCodeList(e);
			}
			// BackEndJob의 상태를 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST18)) {
				eventResponse = getBackEndJobStatus(e);
			}
			// Excel Template File Key 를 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST19)) {
				eventResponse = searchExcelTemplateFile(e);
			}
			// Compensation Charge Combo list : DHF, CMS, NMS, ODF 만...
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST20)) {
				eventResponse = searchCompensationChargeComboList(e);
			}
			// Update Date 가 변경된 것이 있는지 check 한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST08)) {
				eventResponse = searchCheckUpdateDate(e);
			}
			// 입력한 Tariff Code에 해당하는 Tariff Name 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST14)) {
				eventResponse = searchTariffCodeName(e);
			}

			// SYSDATE 정보 조회:YYYYMMDD
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				eventResponse = searchSystemDate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
				eventResponse = searchCheckRfaCtrtRqstOfc(e);
			}

			// 2012.05.22 추가
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
				eventResponse = searchCheckForBeforeAmend(e);
			}

			// 2012.05.29 추가
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH23)) {
				eventResponse = searchCheckRatePort(e);
			}
			// 2012.08.03 추 - 환율 변환 (USD ==> Local)
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH24)) {
				eventResponse = searchFromUsdToEtcCurrency(e);
			}
			// RHQ 별 Service Scope 리스트 정보를 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH25)) {
				eventResponse = searchServiceScopeByRhqOfc(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH26)) {
				eventResponse = searchTariffIhcExceptionCyLocation(e);
			}
			// Service Scope 별 Bound 정보를 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH27)) {
				eventResponse = searchBoundByServiceScope(e);
			}
			// US Country 정보를 조회 ( FOR Add-on management T/F Project )
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH28)) {
				eventResponse = searchUSInlandCountryCode(e);
			}
			// Copy 이전의 Duration 날짜 조회.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH29)) {
				eventResponse = searchDurationDateForRateCopy(e);
			}
			// To Date 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH30)) {
				eventResponse = searchToDate(e);
			}
			// Shipper's Association 의 경우 입력되는 Actual Customer 에 대해 Affiliate 체크추가 2015.04.13 송호진
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH31)) {
				eventResponse = searchCheckValidAfil(e);
			}
			//RFA 효율화를 위한 요청 (1차) (CHM-201640671)
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH32)) {
				eventResponse = searchSalesRepRoleByOfficeList(e);
			}
			// SC File Cancel 권한 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH33)) {
				eventResponse = checkFileCancelAuth(e);
			}
			//[해수부 운임공표 및 신고제] 운임신고 관련 시스템 개발 (정식방식) (CHM-201642825)
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH34)) {
				eventResponse = searchSalesRepByMultiOfficeList(e);
			}
		}
		return eventResponse;
	}

	/**
	 * Service Scope Code List 전체를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceScopeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltCdListVO> list = command.searchServiceScopeCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Currency Code List를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrencyCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchCurrencyCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Per Type Code List 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPerCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchPerCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통코드 List 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchComCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Combo Item 에 적용할 코드리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCodeDescList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchComCodeDescList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Sub-continent Code List 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubcontinentCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchSubcontinentCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Service Scope Detail Name 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceScopeCodeDetailName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			RsltCdListVO vo = event.getRsltCdListVO();
			String svcScpCd = (vo != null) ? vo.getCd() : "";
			String svcScpNm = command.searchServiceScopeCodeDetailName(svcScpCd);
			eventResponse.setRsVo(svcScpNm);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Location Name 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchLocationName(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Country Name 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCountryName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			RsltCdListVO vo = event.getRsltCdListVO();
			String cntCd = (vo != null) ? vo.getCd() : "";
			String cntNm = command.searchCountryName(cntCd);
			//[CWE-476] Null Dereferencing
			if(vo != null) {
				vo.setNm(cntNm);
			}
			
			eventResponse.setRsVo(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Commodity Name 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommodityName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			RsltCdListVO vo = event.getRsltCdListVO();
			String cmdtCd = (vo != null) ? vo.getCd() : "";
			String cmdtNm = command.searchCommodityName(cmdtCd);
			//[CWE-476] Null Dereferencing
			if(vo != null) {
				vo.setNm(cmdtNm);
			}
			eventResponse.setRsVo(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Rep Commodity Name 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepCommodityName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			RsltCdListVO vo = event.getRsltCdListVO();
			String repCmdtCd = (vo != null) ? vo.getCd() : "";
			String repCmdtNm = command.searchRepCommodityName(repCmdtCd);
			//[CWE-476] Null Dereferencing
			if(vo != null) {
				vo.setNm(repCmdtNm);
			}
			eventResponse.setRsVo(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Surcharge 코드정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchSurchargeCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * CommodityGroup Name 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommodityGroupName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			RsltCdListVO vo = event.getRsltCdListVO();
			String cmdtNm = command.searchCommodityGroupName(vo);
			vo.setNm(cmdtNm);
			eventResponse.setRsVo(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * LocationGroup Name 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationGroupName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			RsltCdListVO vo = event.getRsltCdListVO();
			String cmdtNm = command.searchLocationGroupName(vo);
			vo.setNm(cmdtNm);
			eventResponse.setRsVo(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * mdm_cntr_sz 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmCntrSzCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchMdmCntrSzCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Service Scope Code List 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpScpServiceScopeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchSpScpServiceScopeCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Office Code List 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchOfficeCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Office 에 따른 Sales Rep 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSalesRepByOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchSalesRepByOfficeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 복수 Office의 Sales Rep 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSalesRepByMultiOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchSalesRepByMultiOfficeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * MQC 에 해당하는 Service Scope Code List 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpScpMqcServiceScopeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchSpScpMqcServiceScopeCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Ras 대상 조직도를 조회한다.(Ras)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRasOrganizationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchRasOrganizationList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 해당 CUR 별 US 환율을 가져와 현재 AMOUNT와 곱하여 리턴<br>
	 * 
	 * @param Event e
	 * @return String
	 * @exception EventException
	 */
	private EventResponse searchUsExangeAmount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			RsltCdListVO vo = event.getRsltCdListVO();
			String cmdtNm = command.searchUsExangeAmount(vo);
			vo.setNm(cmdtNm);
			eventResponse.setRsVo(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * unmatch type code List 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgRevUmchTpList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchBkgRevUmchTpList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * unmatch sub type code List 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgRevUmchSubTpList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchBkgRevUmchSubTpList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Sales Rep Code List 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSalesRepCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchSalesRepCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Location Group Name 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpScopeGroupLocationName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			String sGrpLocName = command.searchSpScopeGroupLocationName(event.getRsltCdListVO());
			RsltCdListVO vo = new RsltCdListVO();
			vo.setNm(sGrpLocName);
			eventResponse.setRsVo(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Surcharge Group Commodity Code List 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeGroupLocationName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			String sGrpLocNm = command.searchSurchargeGroupLocationName(event.getRsltCdListVO());
			RsltCdListVO vo = new RsltCdListVO();
			vo.setNm(sGrpLocNm);
			eventResponse.setRsVo(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Sub Trade Code List 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubTrdCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchSubTrdCdList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Service Scope Lane Code List 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSvcScpLaneCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchSvcScpLaneCdList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Customer Name 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchCustomerName(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Region Name 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRegionName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchRegionName(event.getRsltCdListVO());
			RsltCdListVO vo = new RsltCdListVO();
			String rgnNm = "";
			if (list.size() > 0) {
				rgnNm = list.get(0).getNm();
			}
			vo.setNm(rgnNm);
			eventResponse.setRsVo(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Charge Code List 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchChargeCdList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Surcharge Group Commodity Code List 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScgGrpCmdtCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchScgGrpCmdtCdList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * SCOPE 별 CHARGE 코드리스트 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScopeChargeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchScopeChargeCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * PRS에서 사용하는 SCOPE 별 CHARGE 코드리스트정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPRSScopeChargeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchPRSScopeChargeCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통코드(코드,명칭)정보를 조회합니다.<br>
	 * 필요한 공통코드를 한번에 가져온다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchAllCommon(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		try {
			CodeUtil cdUtil = CodeUtil.getInstance();
			String[] cd = event.getRsltCdListVO().getCd().split(":");

			for (int j = 0; j < cd.length; j = j + 2) {

				ArrayList<CodeInfo> codeSelect = (ArrayList<CodeInfo>) cdUtil.getCodeSelect(cd[j], 0);
				ArrayList<CodeInfo> cdList = codeSelect;
				List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
				for (int i = 0; i < cdList.size(); i++) {
					RsltCdListVO rsltcdlistvo = new RsltCdListVO();
					rsltcdlistvo.setCd(cdList.get(i).getCode());
					if (cd[j + 1].equals("Y")) {
						rsltcdlistvo.setNm(cdList.get(i).getCode() + "\t" + cdList.get(i).getName());
					} else {
						rsltcdlistvo.setNm(cdList.get(i).getName());
					}
					list.add(rsltcdlistvo);
				}
				eventResponse.setRsVoList(list);
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * PRI 코드 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPriCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

			String[] cd = event.getRsltCdListVO().getCd().split(":");
			for (int i = 0; i < cd.length; i++) {
				if (cd[i].equals("CUR")) {
					list = command.searchCurrencyCodeList(event.getRsltCdListVO());
				} else if (cd[i].equals("PER")) {
					list = command.searchPerCodeList(event.getRsltCdListVO());
				} else if (cd[i].equals("OFF_CODE")) {// Office Code List ( 전체 )
					list = command.searchOfficeCodeList(event.getRsltCdListVO());
				} else if (cd[i].equals("SALE_REP")) {// Sales Rep List ( 전체 )
					list = command.searchSalesRepCodeList(event.getRsltCdListVO());
				} else if (cd[i].equals("SCOPE")) {// Service Scope Code List(전체)
					list = command.searchServiceScopeCodeList(event.getRsltCdListVO());
				} else if (cd[i].equals("APP_CODE")) {// Approval Office Code List ( IN 조건으로 8건만 가져온다. )
					list = command.searchApprovalOfficeList(event.getRsltCdListVO());
				} else if (cd[i].equals("PRE_FIX")) {// S/C NO PRE FIX
					list = command.searchScPrefixList(event.getRsltCdListVO());
				}
				// searchScPrefixList
				// searchApprovalOfficeList
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * PRI_AUTHORIZATION 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthorization(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<PriAuthorizationVO> list = command.searchAuthorization(event.getPriAuthorizationVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * PRI_AUTHORIZATION 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthByTariff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<PriAuthorizationVO> list = command.searchAuthByTariff(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Currency Code List 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAllCurrencyCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchAllCurrencyCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Proporty List 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSvcScpPptMapgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchSvcScpPptMapgList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Per List 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAllPerCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchAllPerCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Note Conversion Mapping Rule 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoteConvRuleMapgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchNoteConvRuleMapgList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Request Office Name 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRequestOfficeName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchRequestOfficeName(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Sales Rep 에 대한 Customer List 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustBySaleRepList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchCustBySaleRepList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Sales Rep Code 로 Office Code 와 Sales Rep Name 을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustByReqOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchCustByReqOffice(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Approval Office List 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchApprovalOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchApprovalOfficeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Location, Group Location, Country, Region Name 정보를 조회합니다.<br>
	 * Code 의 자리수로 구분해서 Name 을 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTotalLocationName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchTotalLocationName(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 해당 Exchange Rate 년월 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return String
	 * @exception EventException
	 */
	private EventResponse searchPrsExchangeRateYrMon(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			RsltCdListVO vo = event.getRsltCdListVO();
			String cmdtNm = command.searchPrsExchangeRateYrMon(vo);
			vo.setNm(cmdtNm);
			eventResponse.setRsVo(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 해당 Exchange Rate 년월 정보를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return String
	 * @exception EventException
	 */
	private EventResponse searchPrsTPExchangeRateYrMon(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			RsltCdListVO vo = event.getRsltCdListVO();
			String cmdtNm = command.searchPrsTPExchangeRateYrMon(vo);
			vo.setNm(cmdtNm);
			eventResponse.setRsVo(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 해당 Exchange Rate 년월 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return String
	 * @exception EventException
	 */
	private EventResponse searchPrsSqExchangeRateYrMon(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			RsltCdListVO vo = event.getRsltCdListVO();
			String cmdtNm = command.searchPrsSqExchangeRateYrMon(vo);
			vo.setNm(cmdtNm);
			eventResponse.setRsVo(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 해당 Exchange Rate 년월 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return String
	 * @exception EventException
	 */
	private EventResponse searchPrsRqExchangeRateYrMon(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			RsltCdListVO vo = event.getRsltCdListVO();
			String cmdtNm = command.searchPrsRqExchangeRateYrMon(vo);
			vo.setNm(cmdtNm);
			eventResponse.setRsVo(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 해당 Exchange Rate 년월 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return String
	 * @exception EventException
	 */
	private EventResponse searchPrsRpExchangeRateYrMon(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			RsltCdListVO vo = event.getRsltCdListVO();
			String cmdtNm = command.searchPrsRpExchangeRateYrMon(vo);
			vo.setNm(cmdtNm);
			eventResponse.setRsVo(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VESSEL SERVICE LANE의 코드명 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselServiceLaneName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchVesselServiceLaneName(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VSK VESSEL SCHEDULE 코드 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVskVesselScheduleCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchVskVesselScheduleCode(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Actual Customer 리스트 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActualCustomerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchActualCustomerList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * IMDG Class 리스트 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchImdgClassCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchImdgClassCode(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Location Code 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceScopeLocationCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchServiceScopeLocationCode(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * CMPB Group Commodity Name 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCmpbGroupCommodityName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			String cmpbCmdtNm = command.searchCmpbGroupCommodityName(event.getRsltCdListVO());
			RsltCdListVO vo = new RsltCdListVO();
			vo.setNm(cmpbCmdtNm);
			eventResponse.setRsVo(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * CMPB Group Location Name 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCmpbGroupLocationName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			String cmpbCmdtNm = command.searchCmpbGroupLocationName(event.getRsltCdListVO());
			RsltCdListVO vo = new RsltCdListVO();
			vo.setNm(cmpbCmdtNm);
			eventResponse.setRsVo(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * RFA 에 대한 Service Scope Code List 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRpScpServiceScopeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchRpScpServiceScopeCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Mapping ID 조회 이벤트 처리<br>
	 * SYS_GUID()값을 조회합니다.<br>
	 * 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSysGuid() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		try {
			String guid = command.searchSysGuid();
			eventResponse.setETCData("SYS_GUID", guid);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * DMT S/C EXCEPTION GROUP에서 PROP_NO가 존재하는지 조회합니다.<br>
	 * 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDmtScExptGrpCount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			String count = command.searchDmtScExptGrpCount(event.getRsltCdListVO());
			eventResponse.setETCData("PROP_NO_COUNT", count);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * CHSS S/C EXCEPTION LIST에서 PROP_NO가 존재하는지 조회합니다.<br>
	 * 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChssScExptListCount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			String count = command.searchChssScExptListCount(event.getRsltCdListVO());
			eventResponse.setETCData("PROP_NO_COUNT", count);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Rep Charge 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepChargeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchRepChargeCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * S/C No prefix List 콤보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScPrefixList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchScPrefixList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * S/C No prefix List 콤보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchRHQList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Batch Job 실행후 jobid와 상태를 program no(etc1)와 parameter(etc2)로 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBatchScheduleJobIdAndStatus(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			RsltCdListVO vo = command.searchBatchScheduleJobIdAndStatus(event.getRsltCdListVO());
			eventResponse.setRsVo(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * S/C Term Type List 콤보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTermTypeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchTermTypeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Trade Code를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTradeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchTradeCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Revenue Lane 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRLaneCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchRLaneCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조직도를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOrganizationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<ComOrganizationVO> list = command.searchOrganizationList(event.getComOrganizationVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Charge 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<MdmChargeVO> list = command.searchChargeList(event.getMdmChargeVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Sales Rep Code 로 User 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSalesRepInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<ComUserVO> list = command.searchSalesRepInfo(event.getMdmSlsRepVO());

			Map<String, String> etcData = new HashMap<String, String>();
			if (list != null && list.size() > 0) {
				etcData = list.get(0).getColumnValues();
			}
			eventResponse.setETCData(etcData);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Tariff Code List 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchTariffCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Service Scope Code 로 Tariff Code 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchTariffCodeByServiceScopeCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchTariffCodeByServiceScopeCode(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * RFA Actual Customer 리스트 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRFAActualCustomerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchRFAActualCustomerList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Tariff Code 가 존재하는 Service Scope Code List 전체를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffServiceScopeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchTariffServiceScopeCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * BackEndJob의 상태를 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		PricommonEvent event = (PricommonEvent) e;

		String status = command.getBackEndJobStatus(event.getKey());
		eventResponse.setETCData("JB_STS_FLG", status);
		return eventResponse;
	}

	/**
	 * Upload 되어있는 Excel Template File Key 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExcelTemplateFile(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			String fileKey = command.searchExcelTemplateFileKey(event.getComUpldFileVO());
			eventResponse.setCustomData("fileKey", fileKey);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Compensation Charge Combo list 리스트를 조회한다.<br>
	 * DHF, CMS, NMS, ODF 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCompensationChargeComboList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCompensationChargeComboListVO> list = command.searchCompensationChargeComboList(event.getRsltCompensationChargeComboListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Customer 별 Sales Rep List 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSalesRepListByCustOnly(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchSalesRepListByCustOnly(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 화면에서 Update Date를 조회후 저장하기전에 update date가 변경된 적이 있는지 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckUpdateDate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {

			// /////////////////////////////
			// Update Date를 이용해 화면 조회 후 데이터의 변경이 있었다면 상태를 변화 시키지 않는다.
			// Begin
			// ////////////////////////////
			String pageName = event.getCheckUpdateDateVO().getPageName();
			CheckUpdateDateVO checkUpdateDate = command.searchCheckUpdateDate(event.getCheckUpdateDateVO());
			// 화면 조회후 데이터 변경이 있었으므로 에러처리한다.
			if (checkUpdateDate != null) {
				throw new EventException(new ErrorHandler("PRI01135", new String[] { pageName }).getMessage());
			}
			// /////////////////////////////
			// Update Date를 이용해 화면 조회 후 데이터의 변경이 있었다면 상태를 변화 시키지 않는다.
			// End
			// ////////////////////////////
			eventResponse.setRsVo(checkUpdateDate);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 입력한 Tariff Code에 해당하는 Tariff Name 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 * @exception EventException
	 */
	private EventResponse searchTariffCodeName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();

		try {
			List<PriTariffVO> list = command.searchTariffCodeName(event.getPriTariffVO());
			eventResponse.setETCData("trf_nm", list.get(0).getTrfNm());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * OFFICE코드에 해당하는 SYSDATE의 정보를 YYYYMMDD포멧으로 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 * @exception EventException
	 */
	private EventResponse searchSystemDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PricommonEvent event = (PricommonEvent)e;
		PRICommonBC command = new PRICommonBCImpl();

		try {
			RsltCdListVO rsltCdListVO = new RsltCdListVO();
			rsltCdListVO.setCreOfcCd(account.getOfc_cd());

			String sysDate = command.searchSystemDate(rsltCdListVO);
			eventResponse.setETCData("SYSDATE", sysDate);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 해당 RFA No,Proposal No가 BA Office에서 생성된것인지 확인
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 * @exception EventException
	 */
	private EventResponse searchCheckRfaCtrtRqstOfc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();

		try {
			String baInd = command.searchCheckRfaCtrtRqstOfc(event.getRsltCdListVO());
			eventResponse.setETCData("baInd", baInd);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003 : 구주 Hinterland 프로젝트에 따른 변경 사항 <br>
	 * 구주 Hinterland 프로젝트 오픈 이전에 발생한 AEW, AEE에 대해서는 Ament 불가<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 * @exception EventException
	 */
	private EventResponse searchCheckForBeforeAmend(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();

		try {
			int rsltVal = command.searchCheckForBeforeAmend(event.getRsltCdListVO());
			eventResponse.setETCData("cnt", String.valueOf(rsltVal));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * RFA Proposal Creation-Rate[Load Excel] <br>
	 * SERVICE SCOPE 가 AEE, AEW인경우 PORT 코드 체크를 위한 메소드 <BR>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCheckRatePort(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		try {
			eventResponse.setRsVoList(command.searchCheckRatePort());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * RFA Proposal Creation-Rate[Load Excel] <br>
	 * SERVICE SCOPE 가 AEE, AEW인경우 PORT 코드 체크를 위한 메소드 <BR>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchFromUsdToEtcCurrency(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			String rate = command.searchFromUsdToEtcCurrency(event.getPriCommonVO());
			eventResponse.setETCData("RATE", rate);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * RHQ 별 Service Scope 리스트 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceScopeByRhqOfc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchServiceScopeByRhqOfc(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * RHQ 별 Service Scope 리스트 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffIhcExceptionCyLocation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchTariffIhcExceptionCyLocation(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Service Scope 별 Bound 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBoundByServiceScope(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchBoundByServiceScope(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * US Country 정보를 조회합니다. ( FOR Add-on management T/F Project ) <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSInlandCountryCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchUSInlandCountryCode(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Copy 이전의 Duration 날짜 조회. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDurationDateForRateCopy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchDurationDateForRateCopy(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * To Date 조회. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchToDate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		try {
			eventResponse.setETCData("SYS_TODATE", command.searchToDate());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0070 :  <br>
	 * Shipper's Association S/C 에서 Actual Customer 를 입력할 때 <br> 
	 * Affiliate 로 등재 되어있는 지를 체크한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 * @exception EventException
	 */
	private EventResponse searchCheckValidAfil(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();

		try {
			int rsltVal = command.searchCheckValidAfil(event.getRsltCdListVO());
			eventResponse.setETCData("cnt", String.valueOf(rsltVal));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Office 에 따른 Sales Rep with Role 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSalesRepRoleByOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchSalesRepRoleByOfficeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * S/C File Cancel 권한을 조회 한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkFileCancelAuth(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			RsltCdListVO rsltVO = command.checkFileCancelAuth(event.getRsltCdListVO() , account);
			String fileCancelAuth = "";
			fileCancelAuth = rsltVO.getEtc1();
			eventResponse.setETCData("fileCancelAuth" , fileCancelAuth);
			log.error(">>>>>>>>>>>>>>>>: " + fileCancelAuth);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

}