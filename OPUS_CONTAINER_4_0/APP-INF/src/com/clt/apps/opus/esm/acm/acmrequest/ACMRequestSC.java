/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMRequestSC.java
*@FileTitle : ACMRequestSC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.26
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.26 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.basic.AGNCommRequestBC;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.basic.AGNCommRequestBCImpl;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.event.EsmAcm0006Event;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.event.EsmAcm0105Event;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration.AGNCommRequestDBDAO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.AGNCommRequestVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.CalcDtlBkgRevenueVO;
import com.clt.apps.opus.esm.acm.acmrequest.batmanagement.basic.BATManagementBC;
import com.clt.apps.opus.esm.acm.acmrequest.batmanagement.basic.BATManagementBCImpl;
import com.clt.apps.opus.esm.acm.acmrequest.batmanagement.event.EsmAcm0032Event;
import com.clt.apps.opus.esm.acm.acmrequest.batmanagement.vo.BATManagementVO;
import com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.basic.OTRCommRequestBC;
import com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.basic.OTRCommRequestBCImpl;
import com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.event.EsmAcm0014Event;
import com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.vo.OTRCommRequestVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-ACMRequest Business Logic ServiceCommand<br>
 * - OPUS-ACMRequest에 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM, Sang-Soo
 * @see AGNCommRequestDBDAO
 * @since J2EE 1.6
 */

public class ACMRequestSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ACMRequest system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ACMRequestSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ACMRequest system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ACMRequestSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-ACMRequest system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmAcm0006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAGNCommRequest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {	  	// Request
				eventResponse = requestAGNCommRequest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {   	// Call ACM_TEST_3
				eventResponse = executeAcmTest3Prc(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {   	// Ex. Rate Input
				eventResponse = executeRateInput(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	// Calculate
				eventResponse = createAgnComm(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				// Retrieve
				eventResponse = searchOTRCommRequest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {	// office 및 vendor 정보를 조회
				eventResponse = searchOfficeVendorInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {	// Cur 변경시 , xchRt를 조회
				eventResponse = searchCurrXchRt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {	// Add Row 시  PatmentAmt, UsdAmt를 조회
				eventResponse = searchPatmentUsdAmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {	// Cur 변경시 xchRt를 조회(XCH_RT_DIV_LVL 값 4인경우 사용)
				eventResponse = searchPatmentFxCurrUsdAmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {	// Cur 변경시 xchRt를 조회(XCH_RT_DIV_LVL 값 4인경우 사용)
				eventResponse = searchFxCurrRt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		// Save(변경, 삭제)
				eventResponse = manageOTRCommRequest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {		// request
				eventResponse = requestOTRCommRequest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0105Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCalcDtlBkgRevenue(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBatchManagement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = deleteBatchManagement(e);
			}
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0006] Retrive<br>
	 * Agent Commission Request 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAGNCommRequest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0006Event event = (EsmAcm0006Event)e;
		AGNCommRequestBC command = new AGNCommRequestBCImpl();

		try{
			List<AGNCommRequestVO> list = command.searchAGNCommRequest(event.getAGNCommRequestVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0006] Request<br>
	 * Agent Commission Request 화면의 요청 관련 정보 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse requestAGNCommRequest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0006Event event = (EsmAcm0006Event)e;
		AGNCommRequestBC command = new AGNCommRequestBCImpl();

		try{
			begin();
			command.requestAGNCommRequest(event.getAGNCommRequestVOs(), account);
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
	 * [ESM_ACM_0006] EXEC PRC<br>
	 * calling procedure<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse executeAcmTest3Prc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0006Event event = (EsmAcm0006Event)e;
		AGNCommRequestBC command = new AGNCommRequestBCImpl();
		AGNCommRequestVO[] agnCommRequestVOs = null;

		try{
			agnCommRequestVOs = event.getAGNCommRequestVOs();
			log.debug("===== [ACM_TEST_3] Total : "+agnCommRequestVOs.length + " =====");
			for(int i=0; i<agnCommRequestVOs.length; i++) {
				begin();
				log.debug("===== [ACM_TEST_3] execute : "+ (i+1) +" th =====");
				agnCommRequestVOs[i].setUsrId(account.getUsr_id());
				command.executeAcmTest3Prc(agnCommRequestVOs[i]);
				eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
				commit();
			}
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
	 * [ESM_ACM_0006] Ex. Rate Input<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse executeRateInput(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0006Event event = (EsmAcm0006Event)e;
		AGNCommRequestBC command = new AGNCommRequestBCImpl();

		try{
			begin();
			command.executeRateInput(event.getAGNCommRequestVOs(), account);
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
	 * [ESM_ACM_0006] Calculate<br>
	 * Agent Commission Request 화면의 Calculate 버튼 이벤트
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createAgnComm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0006Event event = (EsmAcm0006Event)e;
		AGNCommRequestBC command = new AGNCommRequestBCImpl();

		try{
			for(int i=0; i < event.getAGNCommRequestVOs().length; i++) {
				begin();
				command.createAgnComm(event.getAGNCommRequestVOs()[i].getBkgNo(), account.getUsr_id());
				eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
				commit();
			}
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
	 * [ESM_ACM_0014] Retrive<br>
	 * Other Commission Request 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOTRCommRequest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0014Event event = (EsmAcm0014Event)e;
		OTRCommRequestBC command = new OTRCommRequestBCImpl();

		try{
			List<OTRCommRequestVO> list = command.searchOTRCommRequest(event.getOTRCommRequestVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0014] Retrive<br>
	 * Other Commission Request 화면의 office 및 vendor 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeVendorInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0014Event event = (EsmAcm0014Event)e;
		OTRCommRequestBC command = new OTRCommRequestBCImpl();

		try{
			List<OTRCommRequestVO> list = command.searchOfficeVendorInfo(event.getOTRCommRequestVO());
			//화면의 etc 데이터에 담기
			for (int i=0 ; i<list.size(); i++) {
				eventResponse.setETCData(list.get(i).getColumnValues());
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0014] Retrive<br>
	 * Other Commission Request 화면의 Add Row 시  xchRt를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrXchRt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0014Event event = (EsmAcm0014Event)e;
		OTRCommRequestBC command = new OTRCommRequestBCImpl();

		try{
			List<OTRCommRequestVO> list = command.searchCurrXchRt(event.getOTRCommRequestVO());
			//화면의 etc 데이터에 담기
			for (int i=0 ; i<list.size(); i++) {
				eventResponse.setETCData(list.get(i).getColumnValues());
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0014] Retrive<br>
	 * Other Commission Request 화면의 Cur 변경시 , PatmentAmt, UsdAmt를 재설정 한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPatmentUsdAmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0014Event event = (EsmAcm0014Event)e;
		OTRCommRequestBC command = new OTRCommRequestBCImpl();

		try{
			List<OTRCommRequestVO> list = command.searchPatmentUsdAmt(event.getOTRCommRequestVO());
			//화면의 etc 데이터에 담기
			for (int i=0 ; i<list.size(); i++) {
				eventResponse.setETCData(list.get(i).getColumnValues());
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0014] Save<br>
	 * Other Commission Creation & Request 목록을 추가, 수정, 삭제한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOTRCommRequest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0014Event event = (EsmAcm0014Event)e;
		OTRCommRequestBC command = new OTRCommRequestBCImpl();

		try{
			//추가
			for(int i=0; i < event.getOTRCommRequestVOs().length; i++) {
				begin();
				command.otherCommissionRequestManageOTRCommRequest(event.getOTRCommRequestVOs()[i], account);
				eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
				commit();
			}
			//수정, 삭제
			begin();
			command.manageOTRCommRequest(event.getOTRCommRequestVOs(), account);
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



//	/**
//	 * [ESM_ACM_0014] Save<br>
//	 * Other Commission Creation & Request 목록을 추가 한다.<br>
//	 *
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse otherCommissionRequestManageOTRCommRequest(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsmAcm0014Event event = (EsmAcm0014Event)e;
//		OTRCommRequestBC command = new OTRCommRequestBCImpl();
//
//		try{
//
//			for(int i=0; i < event.getOTRCommRequestVOs().length; i++) {
//				if ( event.getOTRCommRequestVOs()[i].getIbflag().equals("I")){
//					begin();
//					command.otherCommissionRequestManageOTRCommRequest(event.getOTRCommRequestVOs(), account);
//					eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
//					commit();
//				}
//			}
//
//		} catch(EventException ex) {
//			rollback();
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		} catch(Exception ex) {
//			rollback();
//			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return eventResponse;
//	}

	/**
	 * [ESM_ACM_0014] Save<br>
	 * Other Commission Request 목록을 Request 한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse requestOTRCommRequest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0014Event event = (EsmAcm0014Event)e;
		OTRCommRequestBC command = new OTRCommRequestBCImpl();

		try{
			begin();
			command.requestOTRCommRequest(event.getOTRCommRequestVOs(), account);
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
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Booking Revenue 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCalcDtlBkgRevenue(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0105Event event = (EsmAcm0105Event)e;
		AGNCommRequestBC command = new AGNCommRequestBCImpl();

		try{
			List<CalcDtlBkgRevenueVO> list1 = command.searchCalcDtlBkgRevenue(event.getCalcDtlBkgRevenueVO());
			eventResponse.setRsVoList(list1);
			List<CalcDtlBkgRevenueVO> list2 = command.searchCalcDtlBkgQty(event.getCalcDtlBkgRevenueVO());
			eventResponse.setRsVoList(list2);
			List<CalcDtlBkgRevenueVO> list3 = command.searchCalcDtlBkgRoute(event.getCalcDtlBkgRevenueVO());
			eventResponse.setRsVoList(list3);
			List<CalcDtlBkgRevenueVO> list4 = command.searchCalcDtlChgDeduction(event.getCalcDtlBkgRevenueVO());
			eventResponse.setRsVoList(list4);
			List<CalcDtlBkgRevenueVO> list5 = command.searchCalcDtlTrsCstDeduction(event.getCalcDtlBkgRevenueVO());
			eventResponse.setRsVoList(list5);
			List<CalcDtlBkgRevenueVO> list6 = command.searchCalcDtlGeneralComm(event.getCalcDtlBkgRevenueVO());
			eventResponse.setRsVoList(list6);
			List<CalcDtlBkgRevenueVO> list7 = command.searchCalcDtlCntrHandlingFee(event.getCalcDtlBkgRevenueVO());
			eventResponse.setRsVoList(list7);
			List<CalcDtlBkgRevenueVO> list8 = command.searchCalcDtlTSCommission(event.getCalcDtlBkgRevenueVO());
			eventResponse.setRsVoList(list8);
			List<CalcDtlBkgRevenueVO> list9 = command.searchCalcDtlCommissionDtl(event.getCalcDtlBkgRevenueVO());
			eventResponse.setRsVoList(list9);

		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0032] Retrieve<br>
	 * Batch Management 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBatchManagement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0032Event event = (EsmAcm0032Event)e;
		BATManagementBC command = new BATManagementBCImpl();

		try{
			List<BATManagementVO> list1 = command.searchBatchManagement(event.getBATManagementVO());
			List<BATManagementVO> list2 = command.searchSimBatchManagement(event.getBATManagementVO());
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
	 * [ESM_ACM_0032] Cancel Batch(Mass Calculation Batch)<br>
	 * 현재 진행되고 있지 않은 mass calculation cancel<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteBatchManagement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0032Event event = (EsmAcm0032Event)e;
		BATManagementBC command = new BATManagementBCImpl();

		try{
			begin();
			command.deleteBatchManagement(event.getBATManagementVOs(), account);
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
	 * [ESM_ACM_0014] Retrive<br>
	 * Other Commission Request 화면의 Cur 변경시 xchRt를 조회(XCH_RT_DIV_LVL 값 4인경우 사용)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFxCurrRt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0014Event event = (EsmAcm0014Event)e;
		OTRCommRequestBC command = new OTRCommRequestBCImpl();

		try{
			List<OTRCommRequestVO> list = command.searchFxCurrRt(event.getOTRCommRequestVO());
			//화면의 etc 데이터에 담기
			for (int i=0 ; i<list.size(); i++) {
				eventResponse.setETCData(list.get(i).getColumnValues());
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * [ESM_ACM_0014] Retrive<br>
	 * Other Commission Request 화면의 Cur 변경시 xchRt를 조회(XCH_RT_DIV_LVL 값 4인경우 사용)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPatmentFxCurrUsdAmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0014Event event = (EsmAcm0014Event)e;
		OTRCommRequestBC command = new OTRCommRequestBCImpl();

		try{
			List<OTRCommRequestVO> list = command.searchPatmentFxCurrUsdAmt(event.getOTRCommRequestVO());
			//화면의 etc 데이터에 담기
			for (int i=0 ; i<list.size(); i++) {
				eventResponse.setETCData(list.get(i).getColumnValues());
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
}