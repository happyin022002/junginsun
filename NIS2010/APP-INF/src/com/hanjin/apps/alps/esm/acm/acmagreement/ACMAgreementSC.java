/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : ACMAgreementSC.java
 * @FileTitle : ACMAgreementSC
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2016.05.19
 * @LastModifier : 김상현
 * @LastVersion : 1.1
 * 2012.03.20 김상수 1.0 Creation
 * 2016.05.19 김상현 1.1 [CHM-201641395] VIP 공제 위한 화면 개발
 */
package com.hanjin.apps.alps.esm.acm.acmagreement;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.basic.AGNCommAgreementBC;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.basic.AGNCommAgreementBCImpl;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.event.EsmAcm0001Event;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.event.EsmAcm0101Event;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.event.EsmAcm0114Event;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.event.EsmAcm0120Event;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.integration.AGNCommAgreementDBDAO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentMinimumCommissionVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentRateDetailVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentRateMasterVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.CodeDescVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.facommagreement.basic.FACommAgreementBC;
import com.hanjin.apps.alps.esm.acm.acmagreement.facommagreement.basic.FACommAgreementBCImpl;
import com.hanjin.apps.alps.esm.acm.acmagreement.facommagreement.event.EsmAcm0024Event;
import com.hanjin.apps.alps.esm.acm.acmagreement.facommagreement.vo.FACAgreementVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.ffcmpnagreement.basic.FFCmpnAgreementBC;
import com.hanjin.apps.alps.esm.acm.acmagreement.ffcmpnagreement.basic.FFCmpnAgreementBCImpl;
import com.hanjin.apps.alps.esm.acm.acmagreement.ffcmpnagreement.event.EsmAcm0023Event;
import com.hanjin.apps.alps.esm.acm.acmagreement.ffcmpnagreement.vo.FFAgreementVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.spclcmpnagreement.basic.SPCLCmpnAgreementBC;
import com.hanjin.apps.alps.esm.acm.acmagreement.spclcmpnagreement.basic.SPCLCmpnAgreementBCImpl;
import com.hanjin.apps.alps.esm.acm.acmagreement.spclcmpnagreement.event.EsmAcm0025Event;
import com.hanjin.apps.alps.esm.acm.acmagreement.spclcmpnagreement.vo.SCompAgreementVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.basic.VIPDeductAgreementBC;
import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.basic.VIPDeductAgreementBCImpl;
import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.event.EsmAcm0039Event;
import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.event.EsmAcm0040Event;
import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.vo.MdmCustomerGroupVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.vo.VIPAgreementVO;
import com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.basic.ACMCommonBCImpl;
import com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.vo.CommonVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

 
/**
 * ALPS-ACMAgreement Business Logic ServiceCommand - ALPS-ACMAgreement 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM, Sang-Soo
 * @see AGNCommAgreementDBDAO
 * @since J2EE 1.6
 */

public class ACMAgreementSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ACMAgreement system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ACMAgreementSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ACMAgreement system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ACMAgreementSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ACMAgreement system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmAcm0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgentRateMaster(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getNewAgreementNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAgentRateMaster(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchAgentRateDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageAgentRateDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSurchargeCnt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchAgentRateMinComm(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getAgreementNoInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAgmtCopy(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFFAgreement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFFAgreement(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFACAgreement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFACAgreement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = requestFACAgreement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = approveFACAgreement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = rejectFACAgreement(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSCompAgreement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSCompAgreement(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0114Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgentRateDetail(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0039Event")) { // VIP Agreement Creation.
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {        // Retrieve
				eventResponse = searchVIPAgreementList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {  // Insert/Update/Delete
				eventResponse = multiVipAgreement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSubTradeList(e);
			} else {
				eventResponse = initVIPAgreement();
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchGroupCustomerList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0120Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChargeCode(e);
			}
		}

		return eventResponse;
	}

	/**
	 * [ESM_ACM_0001-01 / ESM_ACM_0001-03 / ESM_ACM_0101] Retrive<br>
	 * [Master]탭 / [Summary]탭 - Master 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgentRateMaster(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0001Event event = (EsmAcm0001Event)e;
		AGNCommAgreementBC command = new AGNCommAgreementBCImpl();

		try{
			List<AgentRateMasterVO> list = command.searchAgentRateMaster(event.getAgentRateMasterVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0001-01] Save<br>
	 * [Master]탭 목록을 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAgentRateMaster(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0001Event event = (EsmAcm0001Event)e;
		AGNCommAgreementBC command = new AGNCommAgreementBCImpl();

		try{
			begin();
			command.manageAgentRateMaster(event.getAgentRateMasterVOs(), account);
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
	 * [ESM_ACM_0001-02 / ESM_ACM_0001-03]
	 * [Detail]탭 - Compensation Master / [Summary]탭 - Detail 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgentRateDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AgentRateMasterVO AgentRateMasterVO = null;
		if (e.getEventName().equalsIgnoreCase("EsmAcm0001Event")) {
			EsmAcm0001Event event = (EsmAcm0001Event)e;
			AgentRateMasterVO = event.getAgentRateMasterVO();
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0114Event")) {
			EsmAcm0114Event event = (EsmAcm0114Event)e;
			AgentRateMasterVO = event.getAgentRateMasterVO();
		}
		AGNCommAgreementBC command = new AGNCommAgreementBCImpl();

		try{
			if(AgentRateMasterVO != null){
				List<AgentRateDetailVO> list = command.searchAgentRateDetail(AgentRateMasterVO);
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Master의 한 Row 에 해당하는 Minimum Commission 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgentRateMinComm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AgentMinimumCommissionVO AgentMinimumCommissionVO = null;
			EsmAcm0001Event event = (EsmAcm0001Event)e;
			AgentMinimumCommissionVO = event.getAgentMinimumCommissionVO();
		AGNCommAgreementBC command = new AGNCommAgreementBCImpl();

		try{
			if(AgentMinimumCommissionVO != null){
				List<AgentMinimumCommissionVO> list = command.searchAgentRateMinComm(AgentMinimumCommissionVO);
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
		

	/**
	 * [ESM_ACM_0001-02] Save<br>
	 * [Detail]탭 - Compensation Master 목록을 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAgentRateDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0001Event event = (EsmAcm0001Event)e;
		AGNCommAgreementBC command = new AGNCommAgreementBCImpl();

		try{
			begin();
			command.manageAgentRateDetail(event.getAgentRateDetailVOs(),event.getAgentMinimumCommissionVOs() , account);
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
	 * [ESM_ACM_0001-01] Row Add / [ESM_ACM_0101] Select<br>
	 * New Agreement No. 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getNewAgreementNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0001Event event = (EsmAcm0001Event)e;
		AGNCommAgreementBC command = new AGNCommAgreementBCImpl();

		try{
			List<AgentRateMasterVO> list = command.getNewAgreementNo(event.getAgentRateMasterVO());
			eventResponse.setETCData("new_agmt_no", list.get(0).getNewAgmtNo());
			eventResponse.setETCData("usr_id", account.getUsr_id());    // 로그인한 사용자 ID
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0101] Valiation<br>
	 * 사용자가 입력한 Agreement No.의 유효성 검증<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getAgreementNoInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0101Event event = (EsmAcm0101Event)e;
		AGNCommAgreementBC command = new AGNCommAgreementBCImpl();

		try{
			// 존재하지 않는다면 BCImple에서 에러처리
			command.getAgreementNoInfo(event.getAgentRateMasterVO());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0101] Select<br>
	 * 선택된 Agreement No.의 Master와 Detail, TP/SZ, Route, Charge 목록을 새 Ageement No.로 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAgmtCopy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0101Event event = (EsmAcm0101Event)e;
		AGNCommAgreementBC command = new AGNCommAgreementBCImpl();

		try{
			begin();
			command.manageAgmtCopy(event.getAgentRateMasterVO(), account);
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
	 * [ESM_ACM_0023] Retrive<br>
	 * FF Compensation Agreement Creation 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFFAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0023Event event = (EsmAcm0023Event)e;
		FFCmpnAgreementBC command = new FFCmpnAgreementBCImpl();

		try{
			List<FFAgreementVO> list = command.searchFFAgreement(event.getFfagreementVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0024] Retrieve<br>
	 * FAC Agreement Creation 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFACAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0024Event event = (EsmAcm0024Event)e;
		FACommAgreementBC command = new FACommAgreementBCImpl();

		try{
			List<FACAgreementVO> list = command.searchFACAgreement(event.getFacAgreementVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0024] Save<br>
	 * FAC Agreement Creation 목록을 조회<br>
	 *
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse manageFACAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0024Event event = (EsmAcm0024Event)e;
		FACommAgreementBC command = new FACommAgreementBCImpl();

		try {
			begin();
			command.manageFACAgreement(event.getFacAgreementVOs(), account);
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
	 * [ESM_ACM_0025] Retrive<br>
	 * Compensation Agreement Rate Creation 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCompAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0025Event event = (EsmAcm0025Event)e;
		SPCLCmpnAgreementBC command = new SPCLCmpnAgreementBCImpl();

		try{
			List<SCompAgreementVO> list = command.searchSCompAgreement(event.getScompAgreementVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0024] Request<br>
	 * Request 버튼 클릭 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse requestFACAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0024Event event = (EsmAcm0024Event)e;
		FACommAgreementBC command = new FACommAgreementBCImpl();
		try {
			begin();
			command.requestFACAgreement(event.getFacAgreementVOs(), account);
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
	 * [ESM_ACM_0024] Approve<br>
	 * Approve 버튼 클릭 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse approveFACAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0024Event event = (EsmAcm0024Event)e;
		FACommAgreementBC command = new FACommAgreementBCImpl();
		try {

			begin();
			command.approveFACAgreement(event.getFacAgreementVOs(), account);
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
	 * [ESM_ACM_0024] Reject<br>
	 * Reject 버튼 클릭 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse rejectFACAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0024Event event = (EsmAcm0024Event)e;
		FACommAgreementBC command = new FACommAgreementBCImpl();

		try {
			begin();
			command.rejectFACAgreement(event.getFacAgreementVOs(), account);
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
	 * [ESM_ACM_0023] Retrive<br>
	 * FF Compensation Agreement Creation 목록을 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFFAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0023Event event = (EsmAcm0023Event)e;
		FFCmpnAgreementBC command = new FFCmpnAgreementBCImpl();

		try{
			begin();
			command.manageFFAgreement(event.getFfagreementVOs(), account);
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
	 * [ESM_ACM_0025] Retrive<br>
	 * Compensation Agreement Rate Creation 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSCompAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0025Event event = (EsmAcm0025Event)e;
		SPCLCmpnAgreementBC command = new SPCLCmpnAgreementBCImpl();

		try{
			begin();
			command.manageSCompAgreement(event.getScompAgreementVOs(), account);
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
	 * VIP agreement list 조회.
	 * @param event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVIPAgreementList(Event event) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0039Event esmAcm0039Event = (EsmAcm0039Event)event;
		VIPDeductAgreementBC vipDeductAgreementBC = new VIPDeductAgreementBCImpl();

		try {
			List<VIPAgreementVO> list = vipDeductAgreementBC.searchVIPAgreementList(esmAcm0039Event.getVipAgreementVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * VIP Agreement 추가/수정/삭제 처리.
	 * @param event
	 * @throws EventException
	 */
	private EventResponse multiVipAgreement(Event event) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0039Event esmAcm0039Event = (EsmAcm0039Event)event;
		VIPDeductAgreementBC vipDeductAgreementBC = new VIPDeductAgreementBCImpl();

		try {
			begin();
			vipDeductAgreementBC.multiVipAgreement(esmAcm0039Event.getVipAgreementVO(), esmAcm0039Event.getVipAgreementVOs());
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
	 * Grid combo 구성을 위한 데이터
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse initVIPAgreement() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<CommonVO> list = (new ACMCommonBCImpl()).getMdmTradeList();
			StringBuffer trdCdSB = new StringBuffer();
			for (int i=0; i<list.size(); i++) {
				trdCdSB.append(((CommonVO)list.get(i)).getValue0());
				trdCdSB.append("|");
			}
			eventResponse.setETCData("trdCdStr", trdCdSB.substring(0, trdCdSB.length() - 1));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * Sub trade code 조회.
	 * @param event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSubTradeList(Event event) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0039Event esmAcm0039Event = (EsmAcm0039Event)event;
		VIPDeductAgreementBC vipDeductAgreementBC = new VIPDeductAgreementBCImpl();

		try {
			String subTradeStr = vipDeductAgreementBC.searchSubTradeList(esmAcm0039Event.getVipAgreementVO().getTrdCd());
			eventResponse.setETCData("subTrdCdStr", subTradeStr);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * Group Customer Code 조회.
	 * @param event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchGroupCustomerList(Event event) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0040Event esmAcm0040Event = (EsmAcm0040Event)event;
		VIPDeductAgreementBC vipDeductAgreementBC = new VIPDeductAgreementBCImpl();

		try {
			List<MdmCustomerGroupVO> list = vipDeductAgreementBC.searchGroupCustomerList(esmAcm0040Event.getMdmCustomerGroupVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * Charge Code 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0120Event event = (EsmAcm0120Event)e;
		AGNCommAgreementBC command = new AGNCommAgreementBCImpl();

		try{
			List<CodeDescVO> list = command.searchChargeCode(event.getCodeDescVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Surcharge count 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeCnt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0001Event event = (EsmAcm0001Event)e;
		AGNCommAgreementBC command = new AGNCommAgreementBCImpl();

		try{
			String surChgFlg = command.searchSurchargeCnt(event.getChgCd());
			eventResponse.setETCData("surchg_flg", surChgFlg);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
}
