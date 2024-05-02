/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EQTransportPlanNPerformSC.java
 *@FileTitle : MTY COD Simulation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.eqtransportplannperform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.basic.EmptyCODAdjustmentBC;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.basic.EmptyCODAdjustmentBCImpl;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr6001Event;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr6002Event;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr7001Event;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr7002Event;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr7003Event;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr8002Event;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.integration.EmptyCODAdjustmentDBDAO;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.DamageRevenueEmptyListVO;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODMasterVO;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODPortSumVO;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.MTYREPOByPeriodVO;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.PODListByVVDVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
//import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODVVDVO;

/**
 * -EQTransportPlanNPerform Business Transaction ServiceCommand -
 * 
 * @author 
 * @see EmptyCODAdjustmentDBDAO
 * @since J2EE 1.6
 */

public class EQTransportPlanNPerformSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario EQTransportPlanNPerform system<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("EQTransportPlanNPerformSC start");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * biz scenario closing EQTransportPlanNPerform system<br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("EQTransportPlanNPerformSC end");
	}

	/**
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

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
	 * EES_EQR_8002 : []<br>
	 * retrieving for MTYREPOByPeriod<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTYREPOByPeriod(Event e) throws EventException {
		log.debug("####### EQTransportPlanNPerformSC.searchMTYREPOByPeriod 8002 start");
		EesEqr8002Event event = (EesEqr8002Event) e;
		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();
		List<MTYREPOByPeriodVO> list = command.searchMTYREPOByPeriod(event.getMTYREPOByPeriodOptionVO());

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);

		log.debug("####### EQTransportPlanNPerformSC.searchMTYREPOByPeriod 8002 end");
		return eventResponse;
	}

	/**
	 * EES_EQR_7003 : []<br>
	 * retrieving for DamageHangerMTYList<br>
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
	 * EES_EQR_7002 : []<br>
	 * retrieving for RevenueMTYList<br>
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
	 * EES_EQR_7001 : []<br>
	 * removing Confirmation<br>
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
	 * EES_EQR_7001 : []<br>
	 * saving MTYREPOPlan<br>
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
	 * EES_EQR_7001 : []<br>
	 * retrieving for MTYREPOPlan<br>
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
	 * EES_EQR_7001 : []<br>
	 * retrieving for VVDInformation<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVDInformation(Event e) throws EventException {
		log.debug("####### EQTransportPlanNPerformSC.searchVVDInformation 7001 start");
		// PDTO(Data Transfer Object including Parameters)

		EesEqr7001Event event = (EesEqr7001Event) e;

		String vvd = (String) event.getAttribute("vvd");

		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();
		String check = command.searchVVDInformation(vvd);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		Map<String, String> etcData = new HashMap<String, String>();
		etcData.put("check", check);

		eventResponse.setETCData(etcData);
		log.debug("####### EQTransportPlanNPerformSC.searchVVDInformation 7001 end");
		return eventResponse;
	}

	/**
	 * EES_EQR_7001 : []<br>
	 * retrieving for YardNETBByVVDPort<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardNETBByVVDPort(Event e) throws EventException {
		log.debug("####### EQTransportPlanNPerformSC.searchYardNETBByVVDPort 7001 start");
		// PDTO(Data Transfer Object including Parameters)
		EesEqr7001Event event = (EesEqr7001Event) e;

		String vvd = (String) event.getAttribute("vvd");
		String editPort = (String) event.getAttribute("editPort");
		String editIbFlag = (String) event.getAttribute("editIbFlag");

		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();
		List<EmptyCODPortSumVO> list = command.searchYardNETBByVVDPort(vvd, editPort, editIbFlag);

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		log.debug("####### EQTransportPlanNPerformSC.searchYardNETBByVVDPort 7001 end");
		return eventResponse;
	}

	/**
	 * EES_CIM_7001 : Retrieve <br>
	 * retrieving for searchYardNETBByPort<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardNETBByPort(Event e) throws EventException {
		log.debug("####### EQTransportPlanNPerformSC.searchYardNETBByVVDPort 7001 start");
		// PDTO(Data Transfer Object including Parameters)
		EesEqr7001Event event = (EesEqr7001Event) e;

		String vvd = (String) event.getAttribute("vvd");
		String editPort = (String) event.getAttribute("editPort");
		String editIbFlag = (String) event.getAttribute("editIbFlag");

		EmptyCODAdjustmentBC command = new EmptyCODAdjustmentBCImpl();
		List<EmptyCODPortSumVO> list = command.searchYardNETBByPort(vvd, editPort, editIbFlag);

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		log.debug("####### EQTransportPlanNPerformSC.searchYardNETBByVVDPort 7001 end");
		return eventResponse;
	}

	/**
	 * EES_EQR_6001 : []<br>
	 * retrieving for PODListByVVD<br>
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
	 * EES_CIM_1038 : []<br>
	 * retrieving for POD list by VVD<br>
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
	 * EES_EQR_6001 : []<br>
	 * retrieving for MTYCODList<br>
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
	 * EES_EQR_6001 : []<br>
	 * retrieving for CODByVVD<br>
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
	 * EES_EQR_7001 : []<br>
	 * retrieving for YardCode<br>
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
	 * EES_EQR_6002 : []<br>
	 * retrieving for VvdRemark<br>
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
	 * EES_EQR_6002 : []<br>
	 * retrieving for VvdRemark<br>
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
	 * EES_EQR_6002 : []<br>
	 * removing VvdRemark<br>
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