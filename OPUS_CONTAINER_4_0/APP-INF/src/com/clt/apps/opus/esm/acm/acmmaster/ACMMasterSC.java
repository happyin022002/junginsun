/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMMasterSC.java
*@FileTitle : ACMMasterSC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.06
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.06 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmmaster;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.basic.ACMChinaOfficeInfoBC;
import com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.basic.ACMChinaOfficeInfoBCImpl;
import com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.event.EsmAcm0005Event;
import com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.event.EsmAcm0007Event;
import com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.integration.ACMChinaOfficeInfoDBDAO;
import com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.vo.ChinaInfoForLaneVO;
import com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.vo.ChinaOfficeInfoVO;
import com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.basic.ACMCustomerInfoBC;
import com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.basic.ACMCustomerInfoBCImpl;
import com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.event.EsmAcm0019Event;
import com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.event.EsmAcm0020Event;
import com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.event.EsmAcm0021Event;
import com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.event.EsmAcm0022Event;
import com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.vo.CustVendorMatchForSCompVO;
import com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.vo.FACExSettingVO;
import com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.vo.FFCmpnExSettingVO;
import com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.vo.FFVendorMatchVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgChinaAgentVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-ACMMaster Business Logic ServiceCommand - OPUS-ACMMaster 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM, Sang-Soo
 * @see ACMChinaOfficeInfoDBDAO
 * @since J2EE 1.6
 */

public class ACMMasterSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ACMMaster system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ACMMasterSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ACMMaster system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ACMMasterSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-ACMMaster system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmAcm0007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOBChinaOfficeInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageOBChinaOfficeInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIBChinaInfoForLane(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageIBChinaInfoForLane(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFFVendorMatch(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getCustomerFromFFVenderMatch(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFFVendorMatch(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFFCmpnExSetting(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getCustomerFromFFExclusion(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFFCmpnExSetting(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFACExSetting(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFACExSetting(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustVendorMatchForSComp(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCustVendorMatchForSComp(e);
			}
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0007] Retrive<br>
	 * O/B China Office Info 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOBChinaOfficeInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0007Event event = (EsmAcm0007Event)e;
		ACMChinaOfficeInfoBC command = new ACMChinaOfficeInfoBCImpl();

		try{
			List<ChinaOfficeInfoVO> list = command.searchOBChinaOfficeInfo(event.getChinaOfficeInfoVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0007] Save<br>
	 * O/B China Office Info 목록을 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOBChinaOfficeInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0007Event event = (EsmAcm0007Event)e;
		ACMChinaOfficeInfoBC command = new ACMChinaOfficeInfoBCImpl();

		try{
			String chk = command.checkDupVendorCode(event.getChinaOfficeInfoVOs());
			if("".equals(chk)){
				begin();
				BkgChinaAgentVO[] bkgChinaAgentVOs = command.manageOBChinaOfficeInfo(event.getChinaOfficeInfoVOs(), account);
				// BKG모듈 호출
				com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBC bkgCommand =
					new com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBCImpl();
				bkgCommand.manageChinaAgentCode(bkgChinaAgentVOs, account);
				commit();
			}
			eventResponse.setETCData("dup_vendor", chk);
			
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0005] Retrive<br>
	 * I/B China Agent info 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIBChinaInfoForLane(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0005Event event = (EsmAcm0005Event)e;
		ACMChinaOfficeInfoBC command = new ACMChinaOfficeInfoBCImpl();

		try{
			List<ChinaInfoForLaneVO> list = command.searchIBChinaInfoForLane(event.getChinaInfoForLaneVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0005] Save<br>
	 * I/B China Agent info 목록을 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageIBChinaInfoForLane(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0005Event event = (EsmAcm0005Event)e;
		ACMChinaOfficeInfoBC command = new ACMChinaOfficeInfoBCImpl();

		try{
			begin();
			command.manageIBChinaInfoForLane(event.getChinaInfoForLaneVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0019] Retrive<br>
	 * FF-Vendor Match for FF Compensation 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFFVendorMatch(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0019Event event = (EsmAcm0019Event)e;
		ACMCustomerInfoBC command = new ACMCustomerInfoBCImpl();

		try{
			List<FFVendorMatchVO> list = command.searchFFVendorMatch(event.getFFVendorMatchVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0019]
	 * ACM_FF_VNDR_MTCH 테이블에서 FF_CNT_CD와 FF_SEQ의 중복 체크<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getCustomerFromFFVenderMatch(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0019Event event = (EsmAcm0019Event)e;
		ACMCustomerInfoBC command = new ACMCustomerInfoBCImpl();

		try{
			command.getCustomerFromFFVenderMatch(event.getFFVendorMatchVO());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0019] Save<br>
	 * FF-Vendor Match for FF Compensation 목록을 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFFVendorMatch(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0019Event event = (EsmAcm0019Event)e;
		ACMCustomerInfoBC command = new ACMCustomerInfoBCImpl();

		try{
			begin();
			command.manageFFVendorMatch(event.getFFVendorMatchVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0020] Retrive<br>
	 * FF Compensation Exclusion Setting 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFFCmpnExSetting(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0020Event event = (EsmAcm0020Event)e;
		ACMCustomerInfoBC command = new ACMCustomerInfoBCImpl();

		try{
			List<FFCmpnExSettingVO> list = command.searchFFCmpnExSetting(event.getFFCmpnExSettingVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0020]
	 * ACM_FF_EXCLU_SET 테이블에서 FF_CNT_CD와 FF_SEQ의 중복 체크<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getCustomerFromFFExclusion(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0020Event event = (EsmAcm0020Event)e;
		ACMCustomerInfoBC command = new ACMCustomerInfoBCImpl();

		try{
			command.getCustomerFromFFExclusion(event.getFFCmpnExSettingVO());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0020] Save<br>
	 * FF Compensation Exclusion Setting 목록을 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFFCmpnExSetting(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0020Event event = (EsmAcm0020Event)e;
		ACMCustomerInfoBC command = new ACMCustomerInfoBCImpl();

		try{
			begin();
			command.manageFFCmpnExSetting(event.getFFCmpnExSettingVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0021] Retrive<br>
	 * FAC Exclusion Setting 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFACExSetting(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0021Event event = (EsmAcm0021Event)e;
		ACMCustomerInfoBC command = new ACMCustomerInfoBCImpl();

		try{
			List<FACExSettingVO> list = command.searchFACExSetting(event.getFACExSettingVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0021] Save<br>
	 * FAC Exclusion Setting 목록을 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFACExSetting(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0021Event event = (EsmAcm0021Event)e;
		ACMCustomerInfoBC command = new ACMCustomerInfoBCImpl();

		try{
			begin();
			command.manageFACExSetting(event.getFACExSettingVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0022] Retrive<br>
	 * Customer-Vendor Match for Special Compensation 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustVendorMatchForSComp(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0022Event event = (EsmAcm0022Event)e;
		ACMCustomerInfoBC command = new ACMCustomerInfoBCImpl();

		try{
			List<CustVendorMatchForSCompVO> list = command.searchCustVendorMatchForSComp(event.getCustVendorMatchForSCompVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0022] Save<br>
	 * Customer-Vendor Match for Special Compensation 목록을 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCustVendorMatchForSComp(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0022Event event = (EsmAcm0022Event)e;
		ACMCustomerInfoBC command = new ACMCustomerInfoBCImpl();

		try{
			begin();
			command.manageCustVendorMatchForSComp(event.getCustVendorMatchForSCompVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

}