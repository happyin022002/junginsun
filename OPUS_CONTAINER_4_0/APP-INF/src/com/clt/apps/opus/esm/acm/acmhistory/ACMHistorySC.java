/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMHistorySC.java
*@FileTitle : ACMHistorySC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.15 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmhistory;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.basic.AGNCommAgmtHistoryBC;
import com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.basic.AGNCommAgmtHistoryBCImpl;
import com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.event.EsmAcm0017Event;
import com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.vo.AgncommagmtDetailHistoryVO;
import com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.vo.AgncommagmtMasterHistoryVO;
import com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.vo.AgncommagmthistoryVO;
import com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.basic.AGNCommCalcHistoryBC;
import com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.basic.AGNCommCalcHistoryBCImpl;
import com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.event.EsmAcm0016Event;
import com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.event.EsmAcm0116Event;
import com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.vo.AGNCommCalcHistoryVO;
import com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.vo.CalcDtlHistoryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-ACMAgreement Business Logic ServiceCommand - OPUS-ACMAgreement 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM, Young Oh
 * @see AGNCommAgmtHistoryDBDAO
 * @since J2EE 1.6
 */

public class ACMHistorySC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ACMAgreement system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ACMHistorySC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ACMHistory system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ACMHistorySC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-ACMHistory system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmAcm0017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgncommagmthistory(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAgncommagmtMasterDetail(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAGNCommCalcHistory(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0116Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCalcDtlHistory(e);
			}
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0017] Retrive<br>
	 * Agent Commission Agreement History (master) - Agreement List 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgncommagmthistory(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0017Event event = (EsmAcm0017Event)e;
		AGNCommAgmtHistoryBC command = new AGNCommAgmtHistoryBCImpl();

		try{
			List<AgncommagmthistoryVO> list = command.searchAgncommagmthistory(event.getAgncommagmthistoryVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0017] Retrive<br>
	 * Agent Commission Agreement History (master) - Master History 목록, Detail(Compensation) History 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgncommagmtMasterDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0017Event event = (EsmAcm0017Event)e;
		AGNCommAgmtHistoryBC command = new AGNCommAgmtHistoryBCImpl();

		try{
			List<AgncommagmtMasterHistoryVO> list1 = command.searchAgncommagmtMasterHistory(event.getAgncommagmtMasterHistoryVO());
			List<AgncommagmtDetailHistoryVO> list2 = command.searchAgncommagmtDetailHistory(event.getAgncommagmtDetailHistoryVO());
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
	 * [ESM_ACM_0016] Retrive<br>
	 * Agent Commission Calculation History 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAGNCommCalcHistory(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0016Event event = (EsmAcm0016Event)e;
		AGNCommCalcHistoryBC command = new AGNCommCalcHistoryBCImpl();

		try{
			List<AGNCommCalcHistoryVO> list = command.searchAGNCommCalcHistory(event.getAGNCommCalcHistoryVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0116] Retrieve<br>
	 * Calculation Detail의 Booking Revenue 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCalcDtlHistory(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0116Event event = (EsmAcm0116Event)e;
		AGNCommCalcHistoryBC command = new AGNCommCalcHistoryBCImpl();

		try{
			List<CalcDtlHistoryVO> list1 = command.searchCalcDtlBkgRevenue(event.getCalcDtlHistoryVO());
			eventResponse.setRsVoList(list1);
			List<CalcDtlHistoryVO> list2 = command.searchCalcDtlBkgQty(event.getCalcDtlHistoryVO());
			eventResponse.setRsVoList(list2);
			List<CalcDtlHistoryVO> list3 = command.searchCalcDtlBkgRoute(event.getCalcDtlHistoryVO());
			eventResponse.setRsVoList(list3);
			List<CalcDtlHistoryVO> list4 = command.searchCalcDtlChgDeduction(event.getCalcDtlHistoryVO());
			eventResponse.setRsVoList(list4);
			List<CalcDtlHistoryVO> list5 = command.searchCalcDtlTrsCstDeduction(event.getCalcDtlHistoryVO());
			eventResponse.setRsVoList(list5);
			List<CalcDtlHistoryVO> list6 = command.searchCalcDtlGeneralComm(event.getCalcDtlHistoryVO());
			eventResponse.setRsVoList(list6);
			List<CalcDtlHistoryVO> list7 = command.searchCalcDtlCntrHandlingFee(event.getCalcDtlHistoryVO());
			eventResponse.setRsVoList(list7);
			List<CalcDtlHistoryVO> list8 = command.searchCalcDtlTSCommission(event.getCalcDtlHistoryVO());
			eventResponse.setRsVoList(list8);
			List<CalcDtlHistoryVO> list9 = command.searchCalcDtlCommissionDtl(event.getCalcDtlHistoryVO());
			eventResponse.setRsVoList(list9);

		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

}