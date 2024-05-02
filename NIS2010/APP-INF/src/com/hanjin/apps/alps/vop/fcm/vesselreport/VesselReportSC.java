/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VesselReportSC.java
 *@FileTitle : VesselReport
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.04.07
 *@LastModifier : 이병훈
 *@LastVersion : 1.0
 * 1.0 Creation
 * 
 * [CHM-201640787] 연료 소모 분석관련  Departure Report 신규 화면 개발 - 2016.04.07 이병훈
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.vesselreport;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.basic.VesselReportBC;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.basic.VesselReportBCImpl;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.event.VopFcm0001Event;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.event.VopFcm0002Event;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.event.VopFcm0003Event;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.event.VopFcm0004Event;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.event.VopFcm0005Event;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptErrClsVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptLogVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptLogVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.SearchMailingListVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.SearchVslPortSkdVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptMssMtchVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptNotRcvVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslDepRptErrVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslDepRptNotRcvVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslDepRptOverlapVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslDepRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslFcmDepRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptMssMtchVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptNotRcvVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptMssMtchVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptNotRcvVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRptInqVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS VesselReport ServiceCommand - VesselReport 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Hyuk Ryu
 * @see
 * @since J2EE 1.6
 */

public class VesselReportSC extends ServiceCommandSupport {

	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * VesselReportSC system 업무 시나리오 선행작업<br>
	 */
	public void doStart() {
		log.debug("VesselReportSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * VesselReportSC system 업무 시나리오 마감작업<br>
	 */
	public void doEnd() {
		log.debug("VesselReportSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS VesselReport system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopFcm0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslRptSkdInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVslDepRptList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchNoonReportList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchAbLogReportList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchRobMthEndReportList(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
//				eventResponse = searchSpcCharacterReplace(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = createDepRptLogs(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = createDepRpts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createNoonRpts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchMailingList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeVslDepRptErrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) {
				eventResponse = removeVslDepRptOverlapList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopFcm0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslRptSkdInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchVslFcmDepRptList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = updateVslFcmDepRptList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopFcm0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslRptSkdInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchVslPortSkdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiFcmDepRptErrPkCleasing(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("VopFcm0004Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01) || e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchFcmDepRptErrCls(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = multiFcmDepRptErrCls(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("VopFcm0005Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01) || e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchFcmDepRptErrCls(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = multiFcmDepRptErrCls(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removFcmDepRptOverlap(e);
			}
		}
		return eventResponse;
	}

	/**
	 * VOP_FCM_0001 & VOP_FCM_0002<br>
	 * Vessel Report에 대한 주어진 구간의 스케줄 정보를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslRptSkdInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VslRptInqVO vslRptInqVO = new VslRptInqVO();
		
		if (e instanceof VopFcm0001Event) {
			VopFcm0001Event event = (VopFcm0001Event) e;
			vslRptInqVO = event.getVslRptInqVO();
		} else if (e instanceof VopFcm0002Event) {
			VopFcm0002Event event = (VopFcm0002Event) e;
			vslRptInqVO = event.getVslRptInqVO();
		} else if (e instanceof VopFcm0003Event) {
			VopFcm0003Event event = (VopFcm0003Event) e;
			vslRptInqVO = event.getVslRptInqVO();
		}
		
		VesselReportBC command = new VesselReportBCImpl();

		try {
			StringBuilder sb = new StringBuilder();
			begin();
			List<List<VslRptInqVO>> vslDepRptList = command.searchVslRptSkdInfo(vslRptInqVO);
			commit();

			if (vslDepRptList.size() > 0) {
				List<VslRptInqVO> vslSlanCds = vslDepRptList.get(0);
				sb = new StringBuilder();
				for (int i = 0; i < vslSlanCds.size(); i++) {
					sb.append(vslSlanCds.get(i).getVslSlanCd());
					if (i < vslSlanCds.size() - 1) {
						sb.append(",");
					}
				}
			}

			eventResponse.setETCData("vsl_slan_cd", sb.toString());

			if (vslDepRptList.size() > 1) {
				List<VslRptInqVO> vslCds = vslDepRptList.get(1);
				sb = new StringBuilder();
				for (int i = 0; i < vslCds.size(); i++) {
					sb.append(vslCds.get(i).getVslCd());
					if (i < vslCds.size() - 1) {
						sb.append(",");
					}
				}
			}

			eventResponse.setETCData("vsl_cd", sb.toString());

			if (vslDepRptList.size() > 2) {
				List<VslRptInqVO> vpsPortCds = vslDepRptList.get(2);
				sb = new StringBuilder();
				for (int i = 0; i < vpsPortCds.size(); i++) {
					sb.append(vpsPortCds.get(i).getVpsPortCd());
					if (i < vpsPortCds.size() - 1) {
						sb.append(",");
					}
				}
			}

			eventResponse.setETCData("vps_port_cd", sb.toString());

		} catch (EventException eex) {
			log.error("err " + eex.toString(), eex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Vessel Report" }).getMessage(), eex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * VOP_FCM_0001 : Display <br>
	 * Departure Report 정보를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslDepRptList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0001Event event = (VopFcm0001Event) e;
		VesselReportBC command = new VesselReportBCImpl();

		try {
			List<VslDepRptVO> vslDepRptList = command.searchVslDepRpt(event.getVslRptInqVO());
			List<VslDepRptNotRcvVO> vslDepRptNotRcvList = command.searchVslDepRptNotRcv(event.getVslRptInqVO());
			List<VslDepRptErrVO> vslDepRptErrList = command.searchVslDepRptErr(event.getVslRptInqVO());
			List<VslDepRptOverlapVO> vslDepRptOverlapList = command.searchVslDepRptOverlap(event.getVslRptInqVO());


			eventResponse.setRsVoList(vslDepRptList);
			eventResponse.setRsVoList(vslDepRptNotRcvList);
			eventResponse.setRsVoList(vslDepRptErrList);
			eventResponse.setRsVoList(vslDepRptOverlapList);
			


		} catch (EventException eex) {
			log.error("err " + eex.toString(), eex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Departure Report" }).getMessage(), eex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0001 : Delete
	 * Departure Report 정보를 삭제합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeVslDepRptErrList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0001Event event = (VopFcm0001Event)e;
		VesselReportBC command = new VesselReportBCImpl();
		try{
			begin();
			command.removeVslDepRptErrList(event.getVslDepRptErrVOs());

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Departure Report" }).getMessage(), ex);
		}		
		return eventResponse;
	}

	
	/**
	 * VOP_FCM_0001 : Delete
	 * Departure Report 정보를 삭제합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeVslDepRptOverlapList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0001Event event = (VopFcm0001Event)e;
		VesselReportBC command = new VesselReportBCImpl();
		try{
			begin();
			command.removeVslDepRptOverlapList(event.getVslDepRptOverlapVOs());
			eventResponse.setUserMessage(new ErrorHandler("FCM00007").getUserMessage());

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Departure Report" }).getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * VOP_FCM_0001 : Display <br>
	 * Noon Report 정보를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoonReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0001Event event = (VopFcm0001Event) e;
		VesselReportBC command = new VesselReportBCImpl();

		try {

			List<VslNoonRptMssMtchVO> noonRptMssMtchtList = command.searchVslNoonRptMssMtch(event.getVslRptInqVO());
			List<VslNoonRptNotRcvVO> noonRptNotRcvList = command.searchVslNoonRptNotRcv(event.getVslRptInqVO());
			List<VslNoonRptVO> noonRpt = command.searchVslNoonRpt(event.getVslRptInqVO());

			eventResponse.setRsVoList(noonRptMssMtchtList);
			eventResponse.setRsVoList(noonRptNotRcvList);
			eventResponse.setRsVoList(noonRpt);

		} catch (EventException eex) {
			log.error("err " + eex.toString(), eex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Noon Report" }).getMessage(), eex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * VOP_FCM_0001 : Display <br>
	 * ABLog Report 정보를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAbLogReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0001Event event = (VopFcm0001Event) e;
		VesselReportBC command = new VesselReportBCImpl();

		try {

			List<VslABLogRptVO> abLogRptList = command.searchVslABLogRpt(event.getVslRptInqVO());
			List<VslABLogRptNotRcvVO> aBLogRptNotList = command.searchVslABLogRptNotRcv(event.getVslRptInqVO());
			List<VslABLogRptMssMtchVO> aBLogRptMssMtchList = command.searchVslABLogRptMssMtch(event.getVslRptInqVO());

			eventResponse.setRsVoList(abLogRptList);
			eventResponse.setRsVoList(aBLogRptNotList);
			eventResponse.setRsVoList(aBLogRptMssMtchList);

		} catch (EventException eex) {
			log.error("err " + eex.toString(), eex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "ABLog Report" }).getMessage(), eex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * VOP_FCM_0001 : Display <br>
	 * ROB Month END Report 정보를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRobMthEndReportList(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0001Event event = (VopFcm0001Event) e;
		VesselReportBC command = new VesselReportBCImpl();

		try {

			List<VslRobMthEndRptVO> robMthEndRptList = command.searchVslRobMthEndRpt(event.getVslRptInqVO());
			List<VslRobMthEndRptNotRcvVO> robMthEndRptNotList = command.searchVslRobMthEndRptNotRcv(event.getVslRptInqVO());
			List<VslRobMthEndRptMssMtchVO> robMthEndRptMssMtchList = command.searchVslRobMthEndRptMssMtch(event.getVslRptInqVO());

			eventResponse.setRsVoList(robMthEndRptList);
			eventResponse.setRsVoList(robMthEndRptNotList);
			eventResponse.setRsVoList(robMthEndRptMssMtchList);

		} catch (EventException eex) {
			log.error("err " + eex.toString(), eex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "ROB Month END Report" }).getMessage(), eex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	//---------- DEPARTURE REPORT ---------->>
	
	/**
	 * 
	 * Create Departure Reports received from VMS.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createDepRptLogs(Event e) throws EventException {
		VopFcm0001Event event = (VopFcm0001Event) e;

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FcmDepRptLogVO[] fcmDepRptLogVOs = event.getFcmDepRptLogVOs();
		for(FcmDepRptLogVO fcmDepRptLogVO : fcmDepRptLogVOs){
			createDepRptLog(fcmDepRptLogVO);
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * Create Departure Report received from VMS.
	 * 
	 * @param Event e
	 */
	private void createDepRptLog(FcmDepRptLogVO fcmDepRptLogVO) {
		
		boolean result = createDepRptLogInit(fcmDepRptLogVO);
		if(result){
			modifyDepRptLog(fcmDepRptLogVO);
			modifyDepRptLogPost(fcmDepRptLogVO);
		}
	}
	
	/**
	 * Create departure report log. Create Initial data.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @return boolean
	 */
	private boolean createDepRptLogInit(FcmDepRptLogVO fcmDepRptLogVO) {
		VesselReportBC command = new VesselReportBCImpl();
		boolean result = false;
		try{
			begin();
			command.createDepRptLogInit(fcmDepRptLogVO);
			commit();
			result = true;
		}catch(Exception ex){
			rollback();
			log.error(ex.getMessage());
		}
		return result;
	}
	
	/**
	 * Update departure report log. Create general data.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @return boolean
	 */
	private boolean modifyDepRptLog(FcmDepRptLogVO fcmDepRptLogVO) {
		VesselReportBC command = new VesselReportBCImpl();
		boolean result = false;
		try{
			begin();
			command.modifyDepRptLog(fcmDepRptLogVO);
			commit();
			result = true;
		}catch(Exception ex){
			rollback();
			log.error(ex.getMessage());
		}
		return result;
	}
	
	/**
	 * Update departure report log. Update result of creation.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 */
	private void modifyDepRptLogPost(FcmDepRptLogVO fcmDepRptLogVO) {
		VesselReportBC command = new VesselReportBCImpl();
		try{
			begin();
			command.modifyDepRptLogPost(fcmDepRptLogVO);
			commit();
		}catch(Exception ex){
			rollback();
			log.error(ex.getMessage());
		}
	}
	
	/**
	 * 
	 * Create or update departure report.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createDepRpts(Event e) throws EventException {
		VopFcm0001Event event = (VopFcm0001Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FcmDepRptLogVO[] fcmDepRptLogVOs = event.getFcmDepRptLogVOs();
		
		for (FcmDepRptLogVO fcmDepRptLogVO : fcmDepRptLogVOs) {
			
			// 정상적으로 I/F 된 건에 대해서 Departure Report Validation Check 및 Departure Report 테이블 적재 진행
			if ("Y".equals(fcmDepRptLogVO.getIfFlg())) {
				manageDepRpt(fcmDepRptLogVO);
				
				// EAI_IF_RMK 내용이 존재하는 경우 FCM_DEP_RPT_LOG 테이블 Update
				if (!"".equals(fcmDepRptLogVO.getEaiIfRmk())) {
					modifyDepRptLogPost(fcmDepRptLogVO);
				}
			}
		}
		return eventResponse;
	}
	
	/**
	 * Create or update departure report.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 */
	private void manageDepRpt(FcmDepRptLogVO fcmDepRptLogVO) {
		VesselReportBC command = new VesselReportBCImpl();
		try{
			begin();
			command.manageDepRpt(fcmDepRptLogVO);
			commit();
		}catch(Exception ex){
			rollback();
			log.error(ex.getMessage());
		}
	}
	
	//<<---------- DEPARTURE REPORT ----------

	//---------- NOON REPORT ---------->>
	/**
	 * 
	 * Create noon report received from VMS.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createNoonRpts(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0001Event event = (VopFcm0001Event) e;
		FcmNoonRptLogVO[] fcmNoonRptLogVOs = event.getFcmNoonRptLogVOs();
		for(FcmNoonRptLogVO fcmNoonRptLogVO : fcmNoonRptLogVOs){
			createNoonRpt(fcmNoonRptLogVO);
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * Create noon report received from VMS.
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private void createNoonRpt(FcmNoonRptLogVO fcmNoonRptLogVO) {
		
		boolean result = createNoonRptLogInit(fcmNoonRptLogVO);
		if(result){
			result = createNoonRptLog(fcmNoonRptLogVO);
			manageNoonRpt(fcmNoonRptLogVO);
			createNoonRptLogPost(fcmNoonRptLogVO);
		}
	}
	
	/**
	 * Create noon report log. Create Initial data.<br>
	 * 
	 * @param FcmNoonRptLogVO fcmNoonRptLogVO
	 * @return boolean
	 */
	private boolean createNoonRptLogInit(FcmNoonRptLogVO fcmNoonRptLogVO) {
		VesselReportBC command = new VesselReportBCImpl();
		boolean result = false;
		try{
			begin();
			command.createNoonRptLogInit(fcmNoonRptLogVO);
			commit();
			result = true;
		}catch(Exception ex){
			rollback();
			log.error(ex.getMessage());
		}
		return result;
	}
	
	/**
	 * Create noon report log. Create general data.<br>
	 * 
	 * @param FcmNoonRptLogVO fcmNoonRptLogVO
	 * @return boolean
	 */
	private boolean createNoonRptLog(FcmNoonRptLogVO fcmNoonRptLogVO) {
		VesselReportBC command = new VesselReportBCImpl();
		boolean result = false;
		try{
			begin();
			command.createNoonRptLog(fcmNoonRptLogVO);
			commit();
			result = true;
		}catch(Exception ex){
			rollback();
			log.error(ex.getMessage());
		}
		return result;
	}
	
	/**
	 * Create or update noon report.<br>
	 * 
	 * @param FcmNoonRptLogVO fcmNoonRptLogVO
	 */
	private void manageNoonRpt(FcmNoonRptLogVO fcmNoonRptLogVO) {
		VesselReportBC command = new VesselReportBCImpl();
		try{
			begin();
			command.manageNoonRpt(fcmNoonRptLogVO);
			commit();
		}catch(Exception ex){
			rollback();
			log.error(ex.getMessage());
		}
	} 
	
	/**
	 * Create noon report log. Update result of creation.<br>
	 * 
	 * @param FcmNoonRptLogVO fcmNoonRptLogVO
	 * @param boolean result
	 */
	private void createNoonRptLogPost(FcmNoonRptLogVO fcmNoonRptLogVO) {
		VesselReportBC command = new VesselReportBCImpl();
		try{
			begin();
			command.createNoonRptLogPost(fcmNoonRptLogVO);
			commit();
		}catch(Exception ex){
			rollback();
			log.error(ex.getMessage());
		}
			
	}
	
	/**
	 * Mail Preview 를 조회 합니다. <br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchMailingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0001Event event = (VopFcm0001Event)e;
		VesselReportBC command = new VesselReportBCImpl();

		try{
			List<SearchMailingListVO> vos = command.searchMailingList(event.getSearchMailingListVO());
			
			String fromPsn     = "";
			String toPsn       = "";
//			String ccPsn       = "";
			String subject     = "";
//			String bodyConts   = "";
			
			if(vos != null && vos.size() > 0) {
				fromPsn     = vos.get(0).getFromPsn();
				toPsn       = vos.get(0).getToPsn();
//				ccPsn       = vos.get(0).getCcPsn();
				subject     = vos.get(0).getSubject();
			}
			
			eventResponse.setETCData("from_psn", 	fromPsn);
			eventResponse.setETCData("to_psn", 		toPsn);
//			eventResponse.setETCData("cc_psn", 		ccPsn);
			eventResponse.setETCData("subject", 	subject);  
			eventResponse.setETCData("usr_id",      account.getUsr_id());
			

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Mail Preview"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * Departure Report Inquiry 조회
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVslFcmDepRptList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0002Event event = (VopFcm0002Event) e;
		VesselReportBC command = new VesselReportBCImpl();

		try {
			List<VslFcmDepRptVO> vslFcmDepRptVOList = command.searchVslFcmDepRptList(event.getVslRptInqVO());

			eventResponse.setRsVoList(vslFcmDepRptVOList);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", "Departure Report").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * Departure Report Inquiry 업데이트
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse updateVslFcmDepRptList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0002Event event = (VopFcm0002Event)e;
		VesselReportBC command = new VesselReportBCImpl();
		
		try{
			begin();
			command.updateVslFcmDepRptList(event.getVslFcmDepRptVOs(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", "Departure Report").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**-----------------------------------------------------------0003 start-------------------------------------------**/
	
	/**
	 * Departure Report PK Error Cleansing sheet2(SKD) 조회
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVslPortSkdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0003Event event = (VopFcm0003Event) e;
		VesselReportBC command = new VesselReportBCImpl();

		try {
			List<SearchVslPortSkdVO> vslPortSkdVOList = command.searchVslPortSkdList(event.getSearchVslPortSkdVO());
			eventResponse.setRsVoList(vslPortSkdVOList);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", "Departure Report PK Error Cleansing").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	
	/**
	 * Departure Report PK Error Cleansing 업데이트
	 * HISTORY 추가, Error 삭제, VMS IF
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse multiFcmDepRptErrPkCleasing(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0003Event event = (VopFcm0003Event)e;
		VesselReportBC command = new VesselReportBCImpl();
		
		try{
			begin();
			//pk err check : FCM_DEP_RPT_ERR 테이블 삭제 FCM_DEP_RPT_CLS_HIS 추가 
			command.multiFcmDepRptErrPkCleasing(event.getFcmDepRptErrVO(), event.getFcmDepRptClsHisVO(),account);
			//Item err check
			command.validationCheckDepRptItems(event.getFcmDepRptErrVO());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", "Departure Report PK Error Cleansing").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Departure Report Item Error Correction 조회
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchFcmDepRptErrCls(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		VesselReportBC    command		= new VesselReportBCImpl();
		FcmDepRptErrClsVO depRptClsVO	= new FcmDepRptErrClsVO();
		FcmDepRptErrClsVO existingVO	= new FcmDepRptErrClsVO();
		FcmDepRptVO 	  depRptVO		= new FcmDepRptVO();
		String			  sEventName	= "";
		
		List<FcmDepRptErrClsVO> fcmDepRptOvlpVOList			= new ArrayList<FcmDepRptErrClsVO>();
		List<FcmDepRptErrClsVO> fcmDepRptOvlpHiddenVOList	= new ArrayList<FcmDepRptErrClsVO>();
		List<FcmDepRptErrClsVO> fcmDepRptErrClsVOList		= new ArrayList<FcmDepRptErrClsVO>();
		List<FcmDepRptErrClsVO> fcmDepRptClsHisVOList		= new ArrayList<FcmDepRptErrClsVO>();
		List<FcmDepRptErrClsVO> fcmDepRptSamSectDatVOList	= new ArrayList<FcmDepRptErrClsVO>();
		List<FcmDepRptVO> 		fcmDepRptVOHiddenList		= new ArrayList<FcmDepRptVO>();
		
		try {
			sEventName = e.getEventName();
			
			if("VopFcm0004Event".equalsIgnoreCase(sEventName)){
				
				VopFcm0004Event event = (VopFcm0004Event) e;
				
				if(event.getFormCommand().isCommand(FormCommand.SEARCH)){

					if("VOP_FCM_0001".equals(event.getFcmDepRptErrClsVO().getCallUiId())){
						fcmDepRptErrClsVOList	= command.searchFcmDepRptErrCls("SRCH", sEventName, event.getFcmDepRptErrClsVO());						
					}else if("VOP_FCM_0002".equals(event.getFcmDepRptErrClsVO().getCallUiId())){
						depRptVO				= command.searchFcmDepRptCls(event.getFcmDepRptErrClsVO());
						fcmDepRptErrClsVOList	= command.searchFcmDepRptErrCls("SRCH", depRptVO);
					}

					if(fcmDepRptErrClsVOList != null){
						depRptClsVO = fcmDepRptErrClsVOList.get(0);
					}
					
					fcmDepRptClsHisVOList		= command.searchFcmDepRptClsHis(event.getFcmDepRptErrClsVO());
					fcmDepRptSamSectDatVOList	= command.searchFcmDepRptSamSectDat(depRptClsVO);
					
					eventResponse.setRsVoList(fcmDepRptErrClsVOList);
					eventResponse.setRsVoList(fcmDepRptClsHisVOList);
					eventResponse.setRsVoList(fcmDepRptSamSectDatVOList);
					
					if("VOP_FCM_0002".equals(event.getFcmDepRptErrClsVO().getCallUiId())){
						fcmDepRptVOHiddenList.add(0,depRptVO);
						eventResponse.setRsVoList(fcmDepRptVOHiddenList);
					}
					
				}else if(event.getFormCommand().isCommand(FormCommand.SEARCH01)){
					if("VOP_FCM_0001".equals(event.getFcmDepRptErrClsVO().getCallUiId())){
						fcmDepRptErrClsVOList = command.searchFcmDepRptErrCls("SIM", sEventName, event.getFcmDepRptErrClsVO());
					}else if("VOP_FCM_0002".equals(event.getFcmDepRptErrClsVO().getCallUiId())){
						depRptVO = command.depRptClsVOTOdepRptVO(event.getFcmDepRptVO(), event.getFcmDepRptErrClsVO());
						fcmDepRptErrClsVOList = command.searchFcmDepRptErrCls("SIM", depRptVO);
					}
					
					eventResponse.setRsVoList(fcmDepRptErrClsVOList);
				}else if(event.getFormCommand().isCommand(FormCommand.SEARCH02)){
					fcmDepRptClsHisVOList = command.searchFcmDepRptClsHis(event.getFcmDepRptErrClsVO());
					eventResponse.setRsVoList(fcmDepRptClsHisVOList);
				}
			}else if("VopFcm0005Event".equalsIgnoreCase(sEventName)){
				
				VopFcm0005Event event = (VopFcm0005Event) e;
				
				if(event.getFormCommand().isCommand(FormCommand.SEARCH)){

					fcmDepRptErrClsVOList	= command.searchFcmDepRptErrCls("SRCH", sEventName, event.getFcmDepRptErrClsVO());						

					if(fcmDepRptErrClsVOList != null){
						depRptClsVO = fcmDepRptErrClsVOList.get(0);
					}
					
					fcmDepRptClsHisVOList		= command.searchFcmDepRptClsHis(event.getFcmDepRptErrClsVO());
					fcmDepRptSamSectDatVOList	= command.searchFcmDepRptSamSectDat(depRptClsVO);
					
					fcmDepRptOvlpVOList.add(0, fcmDepRptErrClsVOList.get(0));
					
					if(fcmDepRptClsHisVOList.size() > 0){
						existingVO = command.overLapDataCompare(fcmDepRptErrClsVOList.get(0), fcmDepRptClsHisVOList.get(0));
						fcmDepRptOvlpHiddenVOList.add(0, existingVO);
						fcmDepRptOvlpVOList.add(1, existingVO);
					}else{
						fcmDepRptOvlpVOList.add(1, new FcmDepRptErrClsVO());
					}
					
					fcmDepRptOvlpVOList.add(2, fcmDepRptErrClsVOList.get(1));
					fcmDepRptOvlpVOList.add(3, fcmDepRptErrClsVOList.get(2));
					fcmDepRptOvlpVOList.add(4, fcmDepRptErrClsVOList.get(3));
					fcmDepRptOvlpVOList.add(5, fcmDepRptErrClsVOList.get(4));
					
					eventResponse.setRsVoList(fcmDepRptOvlpVOList);
					eventResponse.setRsVoList(fcmDepRptClsHisVOList);
					eventResponse.setRsVoList(fcmDepRptSamSectDatVOList);
					eventResponse.setRsVoList(fcmDepRptOvlpHiddenVOList);
					
				}else if(event.getFormCommand().isCommand(FormCommand.SEARCH01)){
					
					fcmDepRptErrClsVOList	= command.searchFcmDepRptErrCls("SIM", sEventName, event.getFcmDepRptErrClsVO());
					
					fcmDepRptOvlpVOList.add(0, fcmDepRptErrClsVOList.get(0));
					fcmDepRptOvlpVOList.add(1, new FcmDepRptErrClsVO());
					fcmDepRptOvlpVOList.add(2, fcmDepRptErrClsVOList.get(1));
					fcmDepRptOvlpVOList.add(3, fcmDepRptErrClsVOList.get(2));
					fcmDepRptOvlpVOList.add(4, fcmDepRptErrClsVOList.get(3));
					fcmDepRptOvlpVOList.add(5, fcmDepRptErrClsVOList.get(4));
					
					eventResponse.setRsVoList(fcmDepRptOvlpVOList);
				}else if(event.getFormCommand().isCommand(FormCommand.SEARCH02)){
					fcmDepRptClsHisVOList = command.searchFcmDepRptClsHis(event.getFcmDepRptErrClsVO());
					eventResponse.setRsVoList(fcmDepRptClsHisVOList);
				}
			}

			
		} catch (EventException eex) {
			log.error("err " + eex.toString(), eex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Departure Report" }).getMessage(), eex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * Departure Report Error Cleansing 업데이트
	 * 본테이블 추가, HISTORY 추가, Error 삭제
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse multiFcmDepRptErrCls(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		VesselReportBC  command		= new VesselReportBCImpl();
		FcmDepRptVO     depRptVO	= new FcmDepRptVO();
		try{
			begin();
			
			if(e.getEventName().equalsIgnoreCase("VopFcm0004Event")){

				VopFcm0004Event event = (VopFcm0004Event)e;
				
				if("VOP_FCM_0001".equals(event.getFcmDepRptErrClsVO().getCallUiId())){
					//FcmDepRptLogVO SET, FCM_DEP_RPT MERGE, FCM_DEP_RPT_CLS_HIS INSERT, FCM_DEP_RPT_ERR DELETE
					command.multiFcmDepRptErrCls(event.getFcmDepRptErrClsVO(), account);
				}else if("VOP_FCM_0002".equals(event.getFcmDepRptErrClsVO().getCallUiId())){
					//FcmDepRptVO SET, FCM_DEP_RPT UPDATE, FCM_DEP_RPT_CLS_HIS INSERT
					depRptVO = command.depRptClsVOTOdepRptVO(event.getFcmDepRptVO(), event.getFcmDepRptErrClsVO());
					command.multiFcmDepRptErrCls(depRptVO, event.getFcmDepRptErrClsVO(), account);
				}
			}else if(e.getEventName().equalsIgnoreCase("VopFcm0005Event")){
				
				VopFcm0005Event event = (VopFcm0005Event)e;
				
				//FcmDepRptLogVO SET, FCM_DEP_RPT MERGE, FCM_DEP_RPT_CLS_HIS INSERT, FCM_DEP_RPT_ERR DELETE
				command.multiFcmDepRptErrCls(event.getFcmDepRptErrClsVO(), account);
			}
			
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", "Departure Report Error Cleansing").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Departure Report Error 삭제
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removFcmDepRptOverlap(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		VesselReportBC  command		= new VesselReportBCImpl();

		try{
			begin();
			
			if(e.getEventName().equalsIgnoreCase("VopFcm0005Event")){
				
				VopFcm0005Event event = (VopFcm0005Event)e;
				
				//FCM_DEP_RPT DELETE
				command.removeFcmDepRptErr(event.getFcmDepRptErrClsVO());
			}
			
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", "Departure Report Error Cleansing").getMessage(), ex);
		}
		
		return eventResponse;
	}
}
