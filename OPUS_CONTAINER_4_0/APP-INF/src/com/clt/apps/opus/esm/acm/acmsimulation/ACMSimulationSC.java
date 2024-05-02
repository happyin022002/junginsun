/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSimulationSC.java
*@FileTitle : ACMSimulationSC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.09 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.basic.ACMSimulationBC;
import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.basic.ACMSimulationBCImpl;
import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.event.EsmAcm0010Event;
import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.event.EsmAcm0011Event;
import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.event.EsmAcm0033Event;
import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.event.EsmAcm0106Event;
import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.event.EsmAcm0110Event;
import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.event.EsmAcm0115Event;
import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration.ACMSimulationDBDAO;
import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.vo.AGNCommMassSimVO;
import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.vo.AGNCommSimulationVO;
import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.vo.SearchAgreementVO;
import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.vo.SimAgnRateDetailVO;
import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.vo.SimAgnRateMasterVO;
import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.vo.SimulationNoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-ACMSimulation Business Logic ServiceCommand<br>
 * - OPUS-ACMSimulation에 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM, Sang-Soo
 * @see ACMSimulationDBDAO
 * @since J2EE 1.6
 */

public class ACMSimulationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ACMSimulation system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ACMSimulationSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ACMSimulation system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ACMSimulationSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-ACMSimulation system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmAcm0106Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchActualAgreement(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAGNCommSimulation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	// Simulation Result 조회
				eventResponse = searchAGNCommSimulationResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	// Simulation No. 조회
				eventResponse = getMaxSimulationNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	// Start Simulation
				eventResponse = simulateAGNCommSimulation(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSimAgnRateMaster(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getNewAgreementNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSimAgnRateMaster(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchSimAgnRateDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageSimAgnRateDetail(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0110Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSimulationNoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getSimulationOfficeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0115Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getAgreementNoInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAgmtCopy(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAGNCommMassSimList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Simulation No. 조회
				eventResponse = getMassSimulationNo(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //Start Simulation
				eventResponse = manageAGNCommMassSimList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) { //BKG Export
				eventResponse = searchAGNCommMassSimExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) { //Simulation Number
				eventResponse = searchAGNCommMassSimSimulationNumberExcel(e);
			}
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0106] Retrive<br>
	 * Agreement Search화면의 Actual, Simulation Agreement 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActualAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0106Event event = (EsmAcm0106Event)e;
		ACMSimulationBC command = new ACMSimulationBCImpl();

		try{
			List<SearchAgreementVO> list0 = command.searchActualAgreement(event.getSearchAgreementVO());
			eventResponse.setRsVoList(list0);
			List<SearchAgreementVO> list1 = command.searchSimulationAgreement(event.getSearchAgreementVO());
			eventResponse.setRsVoList(list1);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0010] Retrive<br>
	 * Agent Commission Simulation 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAGNCommSimulation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0010Event event = (EsmAcm0010Event)e;
		ACMSimulationBC command = new ACMSimulationBCImpl();

		try{
			List<AGNCommSimulationVO> list = command.searchAGNCommSimulation(event.getAGNCommSimulationVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [ESM_ACM_0010] <br>
	 * Agent Commission Simulation 결과 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAGNCommSimulationResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0010Event event = (EsmAcm0010Event)e;
		ACMSimulationBC command = new ACMSimulationBCImpl();
		
		try{
			List<AGNCommSimulationVO> list = command.searchAGNCommSimulationResult(event.getAGNCommSimulationVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

//	/**
//	 * [ESM_ACM_0010] Start Simulation<br>
//	 * New Simulation No. 조회<br>
//	 *
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse getMaxSimulationNo(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
////		EsmAcm0011Event event = (EsmAcm0011Event)e;
//		ACMSimulationBC command = new ACMSimulationBCImpl();
//
//		try{
//			String simNo = command.getMaxSimulationNo();
//			eventResponse.setETCData("sim_no", simNo);
//		} catch(EventException ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
//		} catch(Exception ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return eventResponse;
//	}
	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * New Simulation No. 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getMaxSimulationNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ACMSimulationBC command = new ACMSimulationBCImpl();

		try{
			String simNo = command.getMaxSimulationNo();
			eventResponse.setETCData("sim_no", simNo);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * Agent Commission Simulation 화면의 Start Simulation 버튼 이벤트
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse simulateAGNCommSimulation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0010Event event = (EsmAcm0010Event)e;
		ACMSimulationBC command = new ACMSimulationBCImpl();
		AGNCommSimulationVO[] agnCommSimulationVOs = null;
		String simNo = null;
		
		try{
			agnCommSimulationVOs = event.getAGNCommSimulationVOs();
			simNo = agnCommSimulationVOs[0].getSimNo();
			
			for(int i=0; i < agnCommSimulationVOs.length; i++) {
				begin();
				command.simulateAGNCommSimulation(event.getAGNCommSimulationVOs()[i].getBkgNo(), account.getUsr_id(), simNo);
				eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
				commit();
			}
			if(agnCommSimulationVOs.length > 0) {
				SimulationNoVO simulationNoVO = new SimulationNoVO();
				simulationNoVO.setSimNo(simNo);
				simulationNoVO.setSimBkgKnt(agnCommSimulationVOs.length+"");
				simulationNoVO.setSimUsrOfcCd(agnCommSimulationVOs[0].getAgnCd());
				simulationNoVO.setSimRmk(agnCommSimulationVOs[0].getSimRmk());
				simulationNoVO.setUsrId(account.getUsr_id());
				begin();
				command.addAcmSimInfo(simulationNoVO);
				commit();
			}
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
	 * [ESM_ACM_0011-01 / ESM_ACM_0011-03 / ESM_ACM_0110] Retrive<br>
	 * [Master]탭 / [Summary]탭 - Master 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSimAgnRateMaster(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0011Event event = (EsmAcm0011Event)e;
		ACMSimulationBC command = new ACMSimulationBCImpl();

		try{
			List<SimAgnRateMasterVO> list = command.searchSimAgnRateMaster(event.getSimAgnRateMasterVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0011-01] Save<br>
	 * [Master]탭 목록을 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSimAgnRateMaster(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0011Event event = (EsmAcm0011Event)e;
		ACMSimulationBC command = new ACMSimulationBCImpl();

		try{
			begin();
			command.manageSimAgnRateMaster(event.getSimAgnRateMasterVOs(), account);
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
	 * [ESM_ACM_0011-02 / ESM_ACM_0011-03]
	 * [Detail]탭 - Compensation Master / [Summary]탭 - Detail 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSimAgnRateDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0011Event event = (EsmAcm0011Event)e;
		ACMSimulationBC command = new ACMSimulationBCImpl();

		try{
			List<SimAgnRateDetailVO> list = command.searchSimAgnRateDetail(event.getSimAgnRateMasterVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0011-02] Save<br>
	 * [Detail]탭 - Compensation Master 목록을 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSimAgnRateDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0011Event event = (EsmAcm0011Event)e;
		ACMSimulationBC command = new ACMSimulationBCImpl();

		try{
			begin();
			command.manageSimAgnRateDetail(event.getSimAgnRateDetailVOs(), account);
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
	 * [ESM_ACM_0011-01] Row Add / [ESM_ACM_0110] Select<br>
	 * New Agreement No. 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getNewAgreementNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0011Event event = (EsmAcm0011Event)e;
		ACMSimulationBC command = new ACMSimulationBCImpl();

		try{
			List<SimAgnRateMasterVO> list = command.getNewAgreementNo(event.getSimAgnRateMasterVO());
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
	 * [ESM_ACM_0115] Valiation<br>
	 * 사용자가 입력한 Agreement No.의 유효성 검증<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getAgreementNoInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0115Event event = (EsmAcm0115Event)e;
		ACMSimulationBC command = new ACMSimulationBCImpl();

		try{
			// 존재하지 않는다면 BCImple에서 에러처리
			command.getAgreementNoInfo(event.getSimAgnRateMasterVO());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0115] Select<br>
	 * 선택된 Agreement No.의 Master와 Detail, TP/SZ, Route, Charge 목록을 새 Ageement No.로 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAgmtCopy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0115Event event = (EsmAcm0115Event)e;
		ACMSimulationBC command = new ACMSimulationBCImpl();

		try{
			begin();
			command.manageAgmtCopy(event.getSimAgnRateMasterVO(), account);
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
	 * [ESM_ACM_0033] Simulation Target Search<br>
	 * Target Booking 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAGNCommMassSimList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0033Event event = (EsmAcm0033Event)e;
		ACMSimulationBC command = new ACMSimulationBCImpl();

		try{
			List<AGNCommMassSimVO> list = command.searchAGNCommMassSimList(event.getAGNCommMassSimVO());
			eventResponse.setETCData("ttl_bkg", list.get(0).getTtlBkg());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0033] Start Simulation<br>
	 * 대상 Booking 을 Batch 에 입력한다<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAGNCommMassSimList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0033Event event = (EsmAcm0033Event)e;
		ACMSimulationBC command = new ACMSimulationBCImpl();

		try{
			begin();
			command.manageAGNCommMassSimList(event.getAGNCommMassSimVO(), account);
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
	 * [ESM_ACM_0033] BKG Export<br>
	 * 조회 결과를 Excel 파일 다운로드한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAGNCommMassSimExcel(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0033Event event = (EsmAcm0033Event)e;
		ACMSimulationBC command = new ACMSimulationBCImpl();

		try {
			eventResponse.setRs(command.searchAGNCommMassSimExcel(event.getAGNCommMassSimVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0110] Simulation No. Search<br>
	 * Simulation No. Search 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSimulationNoList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0110Event event = (EsmAcm0110Event)e;
		ACMSimulationBC command = new ACMSimulationBCImpl();

		try{
			List<SimulationNoVO> list = command.searchSimulationNoList(event.getSimulationNoVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * [ESM_ACM_0110]Simulation No 의 Simulation Office 조회<br>
	 * Simulation Office 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getSimulationOfficeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0110Event event = (EsmAcm0110Event)e;
		ACMSimulationBC command = new ACMSimulationBCImpl();

		try{
			List<SimulationNoVO> list = command.getSimulationOfficeList(event.getSimulationNoVO());
			eventResponse.setRsVoList(list);
			//화면의 etc 데이터에 담기
			//for (int i=0 ; i<list.size(); i++) {
				//eventResponse.setETCData(list.get(i).getColumnValues());
			//}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0033] Simulation Result - Simulation Number<br>
	 * Simulation Result - Simulation Number Excel 파일 다운로드한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAGNCommMassSimSimulationNumberExcel(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0033Event event = (EsmAcm0033Event)e;
		ACMSimulationBC command = new ACMSimulationBCImpl();

		try {
			eventResponse.setRs(command.searchAGNCommMassSimSimulationNumberExcel(event.getAGNCommMassSimVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [ESM_ACM_0033] Start Simulation<br>
	 * New Simulation No. 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getMassSimulationNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ACMSimulationBC command = new ACMSimulationBCImpl();

		try{
			String simNo = command.getMassSimulationNo();
			eventResponse.setETCData("sim_no", simNo);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
}