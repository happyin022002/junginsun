/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EQTransportPlanNPerformSC.java
 *@FileTitle : MTY COD Simulation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.31
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.07.31 박광석
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.eqtransportplannperform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.basic.EmptyCODAdjustmentBC;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.basic.EmptyCODAdjustmentBCImpl;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr6002Event;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr7001Event;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr7002Event;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr8002Event;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr7003Event;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr6001Event;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.integration.EmptyCODAdjustmentDBDAO;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.DamageRevenueEmptyListVO;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODMasterVO;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODPortSumVO;
//import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODVVDVO;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.MTYREPOByPeriodVO;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.PODListByVVDVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-EQTransportPlanNPerform Business Logic ServiceCommand -
 * ALPS-EQTransportPlanNPerform 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Prak Kwang Seok
 * @see EmptyCODAdjustmentDBDAO
 * @since J2EE 1.6
 */

public class EQTransportPlanNPerformSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * EQTransportPlanNPerform system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("EQTransportPlanNPerformSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * EQTransportPlanNPerform system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("EQTransportPlanNPerformSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-EQTransportPlanNPerform system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesEqr6001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPODListByVVD(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMTYCODList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCODByVVD(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesEqr6002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVvdRemark(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = saveVvdRemark(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = deleteVvdRemark(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchVvdRemark(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesEqr7001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMTYREPOPlan(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVVDInformation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchYardNETBByVVDPort(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchYardCode(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchYardNETBByPort(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMTYREPOPlan(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = deleteConfirmation(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesEqr7002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRevenueMTYList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPODListByVVD2(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesEqr7003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDamageHangerMTYList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesEqr8002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMTYREPOByPeriod(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkLocation(e);
			}

		}

		return eventResponse;
	}
	
	/**
	 * EES_EQR_8002 : FOCUS OUT<br>
	 * Location check validate<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();

		String locLevel = (String) e.getAttribute("inquirylevel");
		String locCD = (String) e.getAttribute("location");
		String check = command.checkLocation(locLevel, locCD);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String, String> etcData = new HashMap<String, String>();
		etcData.put("check", check);

		eventResponse.setETCData(etcData);
		return eventResponse;
	}
	

	/**
	 * EES_EQR_8002 : [이벤트]<br>
	 * [MTYREPOByPeriod]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTYREPOByPeriod(Event e) throws EventException {
		log.debug("####### EQTransportPlanNPerformSC.searchMTYREPOByPeriod 8002 시작");
		EesEqr8002Event event = (EesEqr8002Event) e;
		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();
		List<MTYREPOByPeriodVO> list = command.searchMTYREPOByPeriod(event.getMTYREPOByPeriodOptionVO());

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);

		log.debug("####### EQTransportPlanNPerformSC.searchMTYREPOByPeriod 8002 끝");
		return eventResponse;
	}

	/**
	 * EES_EQR_7003 : [이벤트]<br>
	 * [DamageHangerMTYList]을 [조회]합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDamageHangerMTYList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr7003Event event = (EesEqr7003Event) e;
		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();

		DamageRevenueEmptyListVO damageRevenueEmptyListVO = new DamageRevenueEmptyListVO();
		damageRevenueEmptyListVO = command.searchDamageHangerMTYList(event.getDamageRevenueListOptionVO(),
				damageRevenueEmptyListVO);

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(damageRevenueEmptyListVO.getMasterContainerListVO());
		eventResponse.setRsVoList(damageRevenueEmptyListVO.getBookingContainerListVO());
		eventResponse.setRsVoList(damageRevenueEmptyListVO.getRevenueMTYListCntrTpSzVO());

		return eventResponse;
	}

	/**
	 * EES_EQR_7002 : [이벤트]<br>
	 * [RevenueMTYList]을 [조회]합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRevenueMTYList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr7002Event event = (EesEqr7002Event) e;

		String vvd = (String) event.getAttribute("vvd");
		String pod = (String) event.getAttribute("pod");

		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();

		DamageRevenueEmptyListVO damageRevenueEmptyListVO = new DamageRevenueEmptyListVO();
		damageRevenueEmptyListVO = command.searchRevenueMTYList(vvd, pod, damageRevenueEmptyListVO);

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(damageRevenueEmptyListVO.getDamageRevenueEmptyListVO01());
		eventResponse.setRsVoList(damageRevenueEmptyListVO.getDamageRevenueEmptyListVO02());
		eventResponse.setRsVoList(damageRevenueEmptyListVO.getRevenueMTYListCntrTpSzVO());

		return eventResponse;
	}

	/**
	 * EES_EQR_7001 : [이벤트]<br>
	 * [Confirmation]을 [삭제]합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteConfirmation(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr7001Event event = (EesEqr7001Event) e;
		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();
		try {
			begin();
			String vvd = (String) event.getAttribute("vvd");

			command.deleteConfirmation(vvd);
			eventResponse.setUserMessage(new ErrorHandler("MST00008").getUserMessage());
			commit();

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_EQR_7001 : [이벤트]<br>
	 * [MTYREPOPlan]을 [저장]합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMTYREPOPlan(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr7001Event event = (EesEqr7001Event) e;
		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();
		try {
			begin();
			String vvd = (String) event.getAttribute("vvd");
			String lane = (String) event.getAttribute("lane");
			String bay = (String) event.getAttribute("bay");
			String version = (String) event.getAttribute("version");
			String remark = (String) event.getAttribute("remark");
			String sh2RC = (String) event.getAttribute("sh2RC");
			String n1stEtb = (String) event.getAttribute("n1stEtb");

			String audVerSeq = command.manageMTYREPOPlan(vvd, lane, bay, version, remark, sh2RC, n1stEtb, event
					.getEmptyCODVVDPortVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
			eventResponse.setETCData("aud_ver_seq", audVerSeq);
			commit();

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_EQR_7001 : [이벤트]<br>
	 * [MTYREPOPlan]을 [조회]합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTYREPOPlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr7001Event event = (EesEqr7001Event) e;

		String vvd = (String) event.getAttribute("vvd");
		String version = (String) event.getAttribute("version");

		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();

		EmptyCODMasterVO emptyCODMasterVO = new EmptyCODMasterVO();
		emptyCODMasterVO = command.searchMTYREPOPlan(vvd, version, emptyCODMasterVO);

		String check = emptyCODMasterVO.getTxtHRD();
		Map<String, String> etcData = new HashMap<String, String>();
		etcData.put("check", check);

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData(etcData);
		eventResponse.setRsVoList(emptyCODMasterVO.getListEmptyCODVVDPortVO00());
		eventResponse.setRsVoList(emptyCODMasterVO.getListEmptyCODVVDPortVO01());
		eventResponse.setRsVoList(emptyCODMasterVO.getListEmptyCODVVDPortVO02());

		return eventResponse;
	}

	/**
	 * EES_EQR_7001 : [이벤트]<br>
	 * [VVDInformation]을 [조회]합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVDInformation(Event e) throws EventException {
		log.debug("####### EQTransportPlanNPerformSC.searchVVDInformation 7001 시작");
		// PDTO(Data Transfer Object including Parameters)

		EesEqr7001Event event = (EesEqr7001Event) e;

		String vvd = (String) event.getAttribute("vvd");

		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();
		String check = command.searchVVDInformation(vvd);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		Map<String, String> etcData = new HashMap<String, String>();
		etcData.put("check", check);

		eventResponse.setETCData(etcData);
		log.debug("####### EQTransportPlanNPerformSC.searchVVDInformation 7001 끝");
		return eventResponse;
	}

	/**
	 * EES_EQR_7001 : [이벤트]<br>
	 * [YardNETBByVVDPort]을 [조회]합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardNETBByVVDPort(Event e) throws EventException {
		log.debug("####### EQTransportPlanNPerformSC.searchYardNETBByVVDPort 7001 시작");
		// PDTO(Data Transfer Object including Parameters)
		EesEqr7001Event event = (EesEqr7001Event) e;

		String vvd = (String) event.getAttribute("vvd");
		String editPort = (String) event.getAttribute("editPort");
		String editIbFlag = (String) event.getAttribute("editIbFlag");

		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();
		List<EmptyCODPortSumVO> list = command.searchYardNETBByVVDPort(vvd, editPort, editIbFlag);

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		log.debug("####### EQTransportPlanNPerformSC.searchYardNETBByVVDPort 7001 끝");
		return eventResponse;
	}

	/**
	 * EES_CIM_7001 : Retrieve <br>
	 * searchYardNETBByPort 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardNETBByPort(Event e) throws EventException {
		log.debug("####### EQTransportPlanNPerformSC.searchYardNETBByVVDPort 7001 시작");
		// PDTO(Data Transfer Object including Parameters)
		EesEqr7001Event event = (EesEqr7001Event) e;

		String vvd = (String) event.getAttribute("vvd");
		String editPort = (String) event.getAttribute("editPort");
		String editIbFlag = (String) event.getAttribute("editIbFlag");

		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();
		List<EmptyCODPortSumVO> list = command.searchYardNETBByPort(vvd, editPort, editIbFlag);

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		log.debug("####### EQTransportPlanNPerformSC.searchYardNETBByVVDPort 7001 끝");
		return eventResponse;
	}

	/**
	 * EES_EQR_6001 : [이벤트]<br>
	 * [PODListByVVD]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPODListByVVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();

		String week = (String) e.getAttribute("week");
		String vvd = (String) e.getAttribute("vvd");
		try {
			List<PODListByVVDVO> list = command.searchPODListByVVD(week, vvd);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_CIM_1038 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPODListByVVD2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr7002Event event = (EesEqr7002Event) e;
		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();
		String vvd = (String) event.getAttribute("vvd");
		try {
			List<PODListByVVDVO> list = command.searchPODListByVVD2(vvd);
			StringBuilder sb = new StringBuilder();
			if (list.size() > 0) {
				for (int i = 0; i < list.size() - 1; i++) {
					sb.append(list.get(i).getVpsPortCd());
					sb.append("|");
				}
				sb.append(list.get(list.size() - 1).getVpsPortCd());
			}

			Map<String, String> etcData = new HashMap<String, String>();

			etcData.put("pod_list", sb.toString());

			eventResponse.setETCData(etcData);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_EQR_6001 : [이벤트]<br>
	 * [MTYCODList]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTYCODList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// EesCim1038Event event = (EesCim1038Event)e;
		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();

		String week = (String) e.getAttribute("week");
		String trade = (String) e.getAttribute("trade");
		try {
			EmptyCODMasterVO list = command.searchMTYCODList(week, trade);

			StringBuilder sb1 = new StringBuilder();

			if (list.getHead().length > 0) {
				for (int i = 0; i < list.getHead().length - 1; i++) {
					sb1.append(list.getHead()[i]);
					sb1.append(",");
				}
				sb1.append(list.getHead()[list.getHead().length - 1]);
			}

			Map<String, String> etcData = new HashMap<String, String>();
			etcData.put("sHead", sb1.toString());

			eventResponse.setETCData(etcData);
			eventResponse.setRsVoList(list.getEmptycodvvdportvo());
			eventResponse.setRsVoList(list.getEmptycodvvdportvo2());
			eventResponse.setRsVoList(list.getEmptycodvvdportvo3());
			eventResponse.setRsVoList(list.getEmptycodvvdportvo4());
			eventResponse.setRsVoList(list.getEmptycodvvdportvo5());
			eventResponse.setRsVoList(list.getEmptycodvvdportvo6());
			eventResponse.setRsVoList(list.getEmptycodvvdportvo7());
			eventResponse.setRsVoList(list.getEmptycodvvdportvo8());
			eventResponse.setRsVoList(list.getEmptycodvvdportvo9());
			eventResponse.setRsVoList(list.getEmptycodvvdportvo10());
			eventResponse.setRsVoList(list.getEmptycodvvdvo());
			eventResponse.setRsVoList(list.getEmptycodvvdport5Zoovo());

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_EQR_6001 : [이벤트]<br>
	 * [CODByVVD]을 [저장]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCODByVVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr6001Event event = (EesEqr6001Event) e;
		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();
		try {
			begin();

			EmptyCODMasterVO emp = new EmptyCODMasterVO();

			emp.setEmptycodvvdportaddvos(event.getEmptyCODVVDPortVOs());
			emp.setEmptycodvvdvos(event.getEmptyCODVVDVOs());

			command.manageCODByVVD(emp, account);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("").getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_EQR_7001 : [이벤트]<br>
	 * [YardCode]을 [조회]합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardCode(Event e) throws EventException {

		EesEqr7001Event event = (EesEqr7001Event) e;

		String yardcode = (String) event.getAttribute("yardcode");

		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();
		String check = command.searchYardCode(yardcode);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		Map<String, String> etcData = new HashMap<String, String>();
		etcData.put("check", check);

		eventResponse.setETCData(etcData);
		return eventResponse;
	}

	/**
	 * EES_EQR_6002 : [이벤트]<br>
	 * [VvdRemark]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVvdRemark(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();
		EesEqr6002Event event = (EesEqr6002Event) e;
		String remark = "";
		try {
			remark = command.searchVvdRemark(event.getEmptyCODVVDVO().getVvd());

			Map<String, String> etcData = new HashMap<String, String>();
			etcData.put("vesselremark", remark);

			eventResponse.setETCData(etcData);
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_EQR_6002 : [이벤트]<br>
	 * [VvdRemark]을 [저장]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse saveVvdRemark(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr6002Event event = (EesEqr6002Event) e;
		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();
		try {
			begin();

			command.saveVvdRemark(event.getEmptyCODVVDVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_EQR_6002 : [이벤트]<br>
	 * [VvdRemark]을 [삭제]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteVvdRemark(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr6002Event event = (EesEqr6002Event) e;
		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();
		try {
			begin();

			command.deleteVvdRemark(event.getEmptyCODVVDVO());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("").getMessage(), ex);
		}
		return eventResponse;
	}
}