/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : ACMSetupSC.java
 * @FileTitle : Charge Deduction User Setting
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2012.03.14
 * @LastModifier : 김상수
 * @LastVersion : 1.0
 * 2012.03.14 김상수 1.0 Creation.
 * 2016.08.05 김상현 [CHM-201642499] ALPS > ACM VIP Agreement Creation 상 SC/RFA No. 추가 요청 
 */
package com.hanjin.apps.alps.esm.acm.acmsetup;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.basic.ACMSetupBC;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.basic.ACMSetupBCImpl;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.event.EsmAcm0002Event;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.event.EsmAcm0003Event;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.event.EsmAcm0004Event;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.event.EsmAcm0038Event;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.event.EsmAcm0026Event;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.event.EsmAcm0104Event;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.integration.ACMSetupDBDAO;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo.ChargeDdtSetVO;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo.CntrTpSzGrpVO;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo.CntrTpSelectVO;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo.FeederageInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo.RevenueStrcSetVO;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo.FinanceOfficeInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ACMSetup Business Logic ServiceCommand - ALPS-ACMSetup 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM, Sang-Soo
 * @see ACMSetupDBDAO
 * @since J2EE 1.6
 */

public class ACMSetupSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ACMSetup system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ACMSetupSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ACMSetup system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ACMSetupSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ACMSetup system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmAcm0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChargeDdtSet(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getChargeDdtNmInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageChargeDdtSet(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntrTpSzGrp(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getCntrTpSzGrpNmInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCntrTpSzGrp(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFinanceOfficeInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFinanceOfficeInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0038Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFeederageInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFeederageInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0026Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRevenueStrcSet(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRevenueStrcSet(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntrTpSelect(e);
			}
		}

		return eventResponse;
	}

	/**
	 * [ESM_ACM_0003] Retrive<br>
	 * User Set List, Rep.Charge, Charge Code 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeDdtSet(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ACMSetupBC command = new ACMSetupBCImpl();

		try{
			List<ChargeDdtSetVO> list0 = command.searchChargeDdtSet();
			List<ChargeDdtSetVO> list1 = command.searchRepCharge();
			List<ChargeDdtSetVO> list2 = command.searchChargeCode();
			eventResponse.setRsVoList(list0);
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0003] Validation<br>
	 * Charge Deduction Group Name 단건을 조회 (Validation)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getChargeDdtNmInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0003Event event = (EsmAcm0003Event)e;
		ACMSetupBC command = new ACMSetupBCImpl();

		try{
			// 존재하지 않는다면 BCImple에서 에러처리
			command.getChargeDdtNmInfo(event.getChargeDdtSetVO());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0003] Save<br>
	 * User Set List 목록을 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageChargeDdtSet(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0003Event event = (EsmAcm0003Event)e;
		ACMSetupBC command = new ACMSetupBCImpl();

		try{
			ChargeDdtSetVO[] chargeDdtSetVOs = event.getChargeDdtSetVOs();
			ChargeDdtSetVO[] chargeDdtSetRepChgVOs = event.getChargeDdtSetRepChgVOs();
			ChargeDdtSetVO[] chargeDdtSetChargeVOs = event.getChargeDdtSetChargeVOs();

			begin();
			command.manageChargeDdtSet(chargeDdtSetVOs, chargeDdtSetRepChgVOs, chargeDdtSetChargeVOs, account);
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
	 * [ESM_ACM_0002] Retrive<br>
	 * User Set List , Container TP/SZ Code 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrTpSzGrp(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ACMSetupBC command = new ACMSetupBCImpl();

		try{
			List<CntrTpSzGrpVO> list0 = command.searchCntrTpSzGrp();
			List<CntrTpSzGrpVO> list1 = command.searchCntrTpSzList();
			eventResponse.setRsVoList(list0);
			eventResponse.setRsVoList(list1);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0002] Validation<br>
	 * Container TP/SZ Group Name 단건을 조회 (Validation)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getCntrTpSzGrpNmInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0002Event event = (EsmAcm0002Event)e;
		ACMSetupBC command = new ACMSetupBCImpl();

		try{
			// 존재하지 않는다면 BCImple에서 에러처리
			command.getCntrTpSzGrpNmInfo(event.getCntrTpSzGrpVO());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0002] Save<br>
	 * Container TP/SZ Code 목록을 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCntrTpSzGrp(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0002Event event = (EsmAcm0002Event)e;
		ACMSetupBC command = new ACMSetupBCImpl();

		try{
			begin();
			command.manageCntrTpSzGrp(event.getCntrTpSzGrpVOs(), event.getCntrTpSzGrpCodeSlctVOs(), account);
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
	 * [ESM_ACM_0004] Retrive<br>
	 * Finance Office Info 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFinanceOfficeInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0004Event event = (EsmAcm0004Event)e;
		ACMSetupBC command = new ACMSetupBCImpl();

		try{
			List<FinanceOfficeInfoVO> list = command.searchFinanceOfficeInfo(event.getFinanceOfficeInfoVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0004] Save<br>
	 * Finance Office Info 목록을 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFinanceOfficeInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0004Event event = (EsmAcm0004Event)e;
		ACMSetupBC command = new ACMSetupBCImpl();

		try{
			begin();
			command.manageFinanceOfficeInfo(event.getFinanceOfficeInfoVOs(), account);
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
	 * [ESM_ACM_0026] Retrive<br>
	 * Revenue 인식 Charge Code 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRevenueStrcSet(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0026Event event = (EsmAcm0026Event)e;
		ACMSetupBC command = new ACMSetupBCImpl();

		try{
			List<RevenueStrcSetVO> list = command.searchRevenueStrcSet(event.getRevenueStrcSetVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0026] Save<br>
	 * Revenue 인식 Charge Code 목록을 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRevenueStrcSet(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0026Event event = (EsmAcm0026Event)e;
		ACMSetupBC command = new ACMSetupBCImpl();

		try{
			begin();
			command.manageRevenueStrcSet(event.getRevenueStrcSetVOs(), account);
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
	//
	
	/**
	 * [ESM_ACM_0038] Retrieve<br>
	 *  목록을 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
		private EventResponse searchFeederageInfo(Event e) throws EventException {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmAcm0038Event event = (EsmAcm0038Event)e;
			ACMSetupBC command = new ACMSetupBCImpl();

			try{
				List<FeederageInfoVO> list = command.searchFeederageInfo(event.getFeederageInfoVO());
				eventResponse.setRsVoList(list);
			} catch(EventException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage(), ex);
			} catch(Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage(), ex);
			}
			return eventResponse;
		}
	
	/**
	 * [ESM_ACM_0038] Save<br>
	 *  목록을 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFeederageInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0038Event event = (EsmAcm0038Event)e;
		ACMSetupBC command = new ACMSetupBCImpl();

		try{
			begin();
			command.manageFeederageInfo(event.getFeederageInfoVOs(), account);
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
	 * [ESM_ACM_0104] Retrieve<br>
	 * Container Type Selection 목록을 조회<br>
	 * 
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrTpSelect(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0104Event event = (EsmAcm0104Event)e;
		ACMSetupBC command = new ACMSetupBCImpl();

		try{
			List<CntrTpSelectVO> list = command.searchCntrTpSelect(event.getCntrTpSelectVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
}