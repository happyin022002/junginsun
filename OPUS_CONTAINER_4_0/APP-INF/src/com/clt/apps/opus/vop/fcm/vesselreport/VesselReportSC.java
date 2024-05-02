/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VesselReportSC.java
 *@FileTitle : VesselReport
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.09.12
 *@LastModifier : 이혜민
 *@LastVersion : 1.0
 * 2011.10.04 유혁
 * 1.0 Creation
 * History
 * 2012.09.12 이혜민 CHM-201220162-01 [FCM] DSL Report 제거
 * 2014.05.19 박다은 [CHM-201429883] [FCM] Departure Report Tap내 mail Function 신설
=========================================================*/

package com.clt.apps.opus.vop.fcm.vesselreport;

import java.util.List;

import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.basic.VesselReportBC;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.basic.VesselReportBCImpl;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.event.VopFcm0001Event;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptLogVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptLogVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.SearchMailingListVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptMssMtchVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptNotRcvVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslDepRptMssMtchVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslDepRptNotRcvVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslDepRptVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptMssMtchVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptNotRcvVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptMssMtchVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptNotRcvVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslRptInqVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

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
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createDepRpts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createNoonRpts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchMailingList(e);
			} 
		
		}	
		return eventResponse;
	}

	/**
	 * VOP_FCM_0001 : Display <br>
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
		VopFcm0001Event event = (VopFcm0001Event) e;
		VesselReportBC command = new VesselReportBCImpl();

		try {
			StringBuilder sb = new StringBuilder();
			begin();
			List<List<VslRptInqVO>> vslDepRptList = command.searchVslRptSkdInfo(event.getVslRptInqVO());
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
			List<VslDepRptMssMtchVO> vslDepRptMssMtchList = command.searchVslDepRptMssMtch(event.getVslRptInqVO());

			eventResponse.setRsVoList(vslDepRptList);
			eventResponse.setRsVoList(vslDepRptNotRcvList);
			eventResponse.setRsVoList(vslDepRptMssMtchList);

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
	private EventResponse createDepRpts(Event e) throws EventException {
		VopFcm0001Event event = (VopFcm0001Event) e;

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FcmDepRptLogVO[] fcmDepRptLogVOs = event.getFcmDepRptLogVOs();
		for(FcmDepRptLogVO fcmDepRptLogVO : fcmDepRptLogVOs){
			createDepRpt(fcmDepRptLogVO);
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * Create Departure Report received from VMS.
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private void createDepRpt(FcmDepRptLogVO fcmDepRptLogVO) {
		
		boolean result = createDepRptLogInit(fcmDepRptLogVO);
		if(result){
			result = createDepRptLog(fcmDepRptLogVO);
			manageDepRpt(fcmDepRptLogVO);
			createDepRptLogPost(fcmDepRptLogVO);
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
	 * Create departure report log. Create general data.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @return boolean
	 */
	private boolean createDepRptLog(FcmDepRptLogVO fcmDepRptLogVO) {
		VesselReportBC command = new VesselReportBCImpl();
		boolean result = false;
		try{
			begin();
			command.createDepRptLog(fcmDepRptLogVO);
			commit();
			result = true;
		}catch(Exception ex){
			rollback();
			log.error(ex.getMessage());
		}
		return result;
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
	
	/**
	 * Create departure report log. Update result of creation.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @param boolean result
	 */
	private void createDepRptLogPost(FcmDepRptLogVO fcmDepRptLogVO) {
		VesselReportBC command = new VesselReportBCImpl();
		try{
			begin();
			command.createDepRptLogPost(fcmDepRptLogVO);
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

	
	//다은
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
	
	//<<---------- NOON REPORT ----------
	
//	/**
//	 * 
//	 * VMS0004(Departure Report) EAI로 수신시 특수문자를 찾아서 replace한다.
//	 * 
//	 * @param Event 
//	 *            e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse searchSpcCharacterReplace(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		VopFcm0001Event event = (VopFcm0001Event) e;
//		VesselReportBC command = new VesselReportBCImpl();
//
//		try {
//			String depRmkRp = command.searchSpcCharacterReplace(event.getDepRmk());
//			
//			eventResponse.setETCData("dep_rmk_rp",depRmkRp);
//			
//
//		} catch (EventException eex) {
//			log.error("err " + eex.toString(), eex);
//			throw new EventException(new ErrorHandler("COM12203", new String[] { "Departure Report" }).getMessage(), eex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(ex.getMessage(), ex);
//		}
//
//		return eventResponse;
//	}
	
}
