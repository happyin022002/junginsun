/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCommonSC.java
*@FileTitle : ACMCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.07 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcommon;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.basic.ACMCommonBC;
import com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.basic.ACMCommonBCImpl;
import com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.event.AcmCommonEvent;
import com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.event.EsmAcm0113Event;
import com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.integration.ACMCommonDBDAO;
import com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.vo.CommonVO;
import com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.vo.LocationSelectionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ACMCommon Business Logic ServiceCommand - ALPS-ACMCommon 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM, Sang-Soo
 * @see ACMCommonDBDAO
 * @since J2EE 1.6
 */

public class ACMCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ACMCommon system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ACMCommonSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ACMCommon system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ACMCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ACMCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("AcmCommonEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getAROfficeFromBkgChnAgnList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getBkgChnAgnInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = getMdmOrganizationInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = getMdmVendorInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = getMdmLocationInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = getMdmVslSvcLaneInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = getRhqFromAcmOfcInfoList(e);    // RHQ Level과 Combo목록조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = getAROfficeByUserOfficeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = getAgnByAROfficeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = getMdmChageInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = getMdmServiceScopeInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = getAcmCommTpCdMapg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = getAgnFromAcmOfcInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = getMdmCurrencyInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = getSalesOfficeFromMdmOrganizationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {    // [ESM_ACM_0029],[ESM_ACM_0031] Special Compensation Audit 의 Office Code 조회
				eventResponse = getAROfficeAgmtCmpnInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = getMdmCustomerInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = getAROfficeByRhqLevelList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = getMdmCommodityInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {	// [ESM_ACM_0023],[ESM_ACM_0025] 저장 전 "Charge(Only for BS)"항목 체크
				eventResponse = getFfChgCtntChkList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
				eventResponse = getMdmCntrTpChkList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
				eventResponse = getOffSetFlag(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH23)) {
				eventResponse = getAgnByRhqList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH24)) {
				eventResponse = getMdmTradeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH25)) {
				eventResponse = getCoaLaneRgstList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0113Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLocSelectConti(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLocSelectSubConti(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchLocSelectCountry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchLocSelectLocation(e);
			}
		}
		return eventResponse;
	}

	/**
	 * 공통 : A/R Office 목록을 조회<br>
	 * IBMultiCombo / HTML Select 생성용<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getAROfficeFromBkgChnAgnList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getAROfficeFromBkgChnAgnList(event.getCommonVO());
			eventResponse.setRsVoList(commonVOlist);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : China Agent info 단건을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getBkgChnAgnInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getBkgChnAgnInfo(event.getCommonVO());
			// 존재한다면 정상리턴, 0건이면 에러
			if ("EXIST".equals(event.getCommonVO().getValue9())) {
				eventResponse.setETCData("chn_agn_cd", commonVOlist.get(0).getValue0());
				eventResponse.setETCData("agn_nm", commonVOlist.get(0).getValue1());
				eventResponse.setETCData("vndr_cnt_cd", commonVOlist.get(0).getValue2());
				eventResponse.setETCData("vndr_seq", commonVOlist.get(0).getValue3());
				eventResponse.setETCData("finc_ofc_cd", commonVOlist.get(0).getValue4());
			}
			// "NOTEXIST"일때 존재하지 않는다면 BCImple에서 정상리턴, 0건이상이면 에러
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : MDM ORGANIZATION info 단건을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getMdmOrganizationInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getMdmOrganizationInfo(event.getCommonVO());
			eventResponse.setETCData("ofc_cd", commonVOlist.get(0).getValue0());
			eventResponse.setETCData("ofc_eng_nm", commonVOlist.get(0).getValue1());
			eventResponse.setETCData("ofc_knd_cd", commonVOlist.get(0).getValue2());
			eventResponse.setETCData("vndr_cnt_cd", commonVOlist.get(0).getValue3());
			eventResponse.setETCData("vndr_seq", commonVOlist.get(0).getValue4());
			eventResponse.setETCData("loc_cd", commonVOlist.get(0).getValue5());
			eventResponse.setETCData("ar_ofc_cd", commonVOlist.get(0).getValue6());
			eventResponse.setETCData("ar_hd_qtr_ofc_cd", commonVOlist.get(0).getValue7());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : MDM VENDOR info 단건을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getMdmVendorInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getMdmVendorInfo(event.getCommonVO());
			eventResponse.setETCData("vndr_cnt_cd", commonVOlist.get(0).getValue0());
			eventResponse.setETCData("vndr_seq", commonVOlist.get(0).getValue1());
			eventResponse.setETCData("vndr_lgl_eng_nm", commonVOlist.get(0).getValue2());
			eventResponse.setETCData("prnt_cnt_cd", commonVOlist.get(0).getValue3());
			eventResponse.setETCData("prnt_vndr_seq", commonVOlist.get(0).getValue4());
			eventResponse.setETCData("ofc_cd", commonVOlist.get(0).getValue5());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : MDM LOCATION info 단건을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getMdmLocationInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getMdmLocationInfo(event.getCommonVO());
			eventResponse.setETCData("loc_cd", commonVOlist.get(0).getValue0());
			eventResponse.setETCData("scc_cd", commonVOlist.get(0).getValue1());
			eventResponse.setETCData("loc_nm", commonVOlist.get(0).getValue2());
			eventResponse.setETCData("cnt_cd", commonVOlist.get(0).getValue3());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : MDM VESSEL SERVICE LANE info 단건을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getMdmVslSvcLaneInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getMdmVslSvcLaneInfo(event.getCommonVO());
			eventResponse.setETCData("vsl_slan_cd", commonVOlist.get(0).getValue0());
			eventResponse.setETCData("vsl_slan_nm", commonVOlist.get(0).getValue1());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : 로그인한 사용자의 ofc_cd에 따른 A/R Office 목록을 조회<br>
	 * IBMultiCombo / HTML Select 생성용<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getAROfficeByUserOfficeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getAROfficeByUserOfficeList(account);
			eventResponse.setRsVoList(commonVOlist);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : 지정된 A/R Office에 따른 AGN 목록을 조회<br>
	 * IBMultiCombo / HTML Select 생성용<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getAgnByAROfficeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getAgnByAROfficeList(event.getCommonVO(), account);
			eventResponse.setRsVoList(commonVOlist);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : MDM_CHARGE info 단건을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getMdmChageInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getMdmChageInfo(event.getCommonVO());
			eventResponse.setETCData("chg_cd", commonVOlist.get(0).getValue0());
			eventResponse.setETCData("chg_nm", commonVOlist.get(0).getValue1());
			eventResponse.setETCData("rep_chg_cd", commonVOlist.get(0).getValue2());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : MDM_SVC_SCP info 단건을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getMdmServiceScopeInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getMdmServiceScopeInfo(event.getCommonVO());
			eventResponse.setRsVoList(commonVOlist);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : ACM_COMM_TP_CD_MAPG info 단건을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getAcmCommTpCdMapg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getAcmCommTpCdMapg(event.getCommonVO());
			eventResponse.setRsVoList(commonVOlist);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : ACM_OFC_INFO에서 AGN 목록/단건을 조회<br>
	 * IBMultiCombo / HTML Select 생성용, Validation용<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getAgnFromAcmOfcInfoList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getAgnFromAcmOfcInfoList(event.getCommonVO());
			if ("".equals(event.getCommonVO().getValue0())) {
				eventResponse.setRsVoList(commonVOlist);
			} else {
				eventResponse.setETCData("agn_cd", commonVOlist.get(0).getValue0());
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : ACM_OFC_INFO에서 RHQ 목록을 조회<br>
	 * IBMultiCombo / HTML Select 생성용<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getRhqFromAcmOfcInfoList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist1 = command.getRhqLevelFromMdmOrganizationInfo(account);
			eventResponse.setETCData("rhq_cd", commonVOlist1.get(0).getValue0());
			eventResponse.setETCData("ofc_knd_cd", commonVOlist1.get(0).getValue1());

			List<CommonVO> commonVOlist2 = command.getRhqFromAcmOfcInfoList(event.getCommonVO());
			eventResponse.setRsVoList(commonVOlist2);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : MDM CURRENCY info 단건을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getMdmCurrencyInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getMdmCurrencyInfo(event.getCommonVO());
			eventResponse.setETCData("curr_cd", commonVOlist.get(0).getValue0());
			eventResponse.setETCData("curr_nm", commonVOlist.get(0).getValue1());
			eventResponse.setETCData("cnt_cd", commonVOlist.get(0).getValue2());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : 로그인한 사용자의 ofc_cd로 Sales Office 목록을 조회<br>
	 * IBMultiCombo / HTML Select 생성용<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getSalesOfficeFromMdmOrganizationList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getSalesOfficeFromMdmOrganizationList(account);
			eventResponse.setRsVoList(commonVOlist);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : [ESM_ACM_0029]Special Compensation Audit 의 Office Code 목록을 조회<br>
	 * IBMultiCombo / HTML Select 생성용<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getAROfficeAgmtCmpnInfoList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getAROfficeAgmtCmpnInfoList(account);
			eventResponse.setRsVoList(commonVOlist);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : MDM_CUSTOMER에서 단건을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getMdmCustomerInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getMdmCustomerInfo(event.getCommonVO());
			eventResponse.setETCData("cust_seq", commonVOlist.get(0).getValue0());
			eventResponse.setETCData("cust_cnt_cd", commonVOlist.get(0).getValue1());
			eventResponse.setETCData("cust_lgl_eng_nm", commonVOlist.get(0).getValue2());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : RHQ Level에 따른 A/R Office 목록을 조회<br>
	 * IBMultiCombo / HTML Select 생성용<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getAROfficeByRhqLevelList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getAROfficeByRhqLevelList(event.getCommonVO(), account);
			eventResponse.setRsVoList(commonVOlist);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : MDM_REP_CMDT 혹은 MDM_COMMODITY에서 단건을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getMdmCommodityInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		String cmdtCd = "";
		String cmdtNm = "";

		try{
			CommonVO rsltVo = command.getMdmCommodityInfo(event.getCommonVO());
			if(rsltVo != null) {
				cmdtCd = rsltVo.getValue0();
				cmdtNm = rsltVo.getValue1();
			}
			eventResponse.setETCData("cmdt_cd", cmdtCd);
			eventResponse.setETCData("cmdt_nm", cmdtNm);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : [ESM_ACM_0023]FF Compensation Agreement Creation 저장 전 "Charge(Only for BS)"항목 체크<br>
	 * (MDM_CHARGE의 ERR_CNT 가 0인지 아닌지 조회)
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getFfChgCtntChkList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getFfChgCtntChkList(event.getCommonVO());
			eventResponse.setETCData("err_cnt", commonVOlist.get(0).getValue0());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : 입력된 코드가 MDM_CNTR_TP 에 존재하는지 체크<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getMdmCntrTpChkList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			CommonVO commonVO = command.getMdmCntrTpChkList(event.getCommonVO());
			eventResponse.setETCData("cnt", commonVO.getValue1());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : 입력된 office code 가 상계 정산 대리점(operational)인지 체크.(리턴값 => operational : Y, else : N)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getOffSetFlag(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			String rtnValue = command.getOffSetFlag(event.getCommonVO());
			eventResponse.setETCData("so_flag", rtnValue);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0113] Location Selection 목록을 조회<br>
	 * 1. Conti<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocSelectConti(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0113Event event = (EsmAcm0113Event)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<LocationSelectionVO> list = command.searchLocSelectConti(event.getLocationSelectionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0113] Location Selection 목록을 조회<br>
	 * 2. Sub Conti<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocSelectSubConti(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0113Event event = (EsmAcm0113Event)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<LocationSelectionVO> list = command.searchLocSelectSubConti(event.getLocationSelectionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0113] Location Selection 목록을 조회<br>
	 * 3. Country<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocSelectCountry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0113Event event = (EsmAcm0113Event)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<LocationSelectionVO> list = command.searchLocSelectCountry(event.getLocationSelectionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0113] Location Selection 목록을 조회<br>
	 * 4. Location<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocSelectLocation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0113Event event = (EsmAcm0113Event)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<LocationSelectionVO> list = command.searchLocSelectLocation(event.getLocationSelectionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : RHQ에 따른 Agent Code 목록을 조회<br>
	 * IBMultiCombo / HTML Select 생성용<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getAgnByRhqList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getAgnByRhqList(account);
			eventResponse.setRsVoList(commonVOlist);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : MDM_TRADE 테이블의 TRD_CD 목록을 조회<br>
	 * IBMultiCombo / HTML Select 생성용<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getMdmTradeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getMdmTradeList();
			eventResponse.setRsVoList(commonVOlist);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : COA_LANE_RGST 테이블의 RLANE_CD 목록을 조회<br>
	 * IBMultiCombo / HTML Select 생성용<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getCoaLaneRgstList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AcmCommonEvent event = (AcmCommonEvent)e;
		ACMCommonBC command = new ACMCommonBCImpl();

		try{
			List<CommonVO> commonVOlist = command.getCoaLaneRgstList(event.getCommonVO());
			eventResponse.setRsVoList(commonVOlist);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

}