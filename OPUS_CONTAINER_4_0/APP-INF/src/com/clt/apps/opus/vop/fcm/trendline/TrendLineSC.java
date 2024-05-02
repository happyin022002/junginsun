/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselReportSC.java
*@FileTitle : VesselReport
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.10.04 유혁
* 1.0 Creation
* 
* History
* 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
* 2015.04.30 이병훈 [CHM-201534057] Split09-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/

package com.clt.apps.opus.vop.fcm.trendline;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.fcm.fcmcommon.fcmcommon.basic.FCMCommonBC;
import com.clt.apps.opus.vop.fcm.fcmcommon.fcmcommon.basic.FCMCommonBCImpl;
import com.clt.apps.opus.vop.fcm.fcmcommonutil.fcmgeneralutil.FCMGeneralUtil;
import com.clt.apps.opus.vop.fcm.trendline.trendline.basic.TrendLineBC;
import com.clt.apps.opus.vop.fcm.trendline.trendline.basic.TrendLineBCImpl;
import com.clt.apps.opus.vop.fcm.trendline.trendline.event.VopFcm0012Event;
import com.clt.apps.opus.vop.fcm.trendline.trendline.event.VopFcm0013Event;
import com.clt.apps.opus.vop.fcm.trendline.trendline.event.VopFcm0014Event;
import com.clt.apps.opus.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptVO;
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

public class TrendLineSC extends ServiceCommandSupport {

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
	
	@Override
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if(e.getEventName().equalsIgnoreCase("VopFcm0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFcmTrndLineList(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("VopFcm0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFcmTrndLineBasic(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLaneVslCapa(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //simulation
				eventResponse = simulateTrndLine(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchFcmTrndLineBasicForInq(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTrndLine(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageTrndLineUpd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = deleteTrndLine(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("VopFcm0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFcmTrndLinePopupList(e);
			}else{
				eventResponse = searchVslClassCapaList(e);	
			}
		}
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0013  : Retrieve <br>
	 * Trend Line 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFcmTrndLineList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0013Event event = (VopFcm0013Event)e;
		TrendLineBC command = new TrendLineBCImpl();
		
		try {
			// TREND LINE 정보 조회
			List<FcmTrndLineVO> fcmTrndLineVOs = command.searchFcmTrndLineList(event.getFcmTrndLineVO());
			eventResponse.setRsVoList(fcmTrndLineVOs);
			if(fcmTrndLineVOs!=null && fcmTrndLineVOs.size()>0){
				eventResponse.setETCData("trnd_line_rmk", fcmTrndLineVOs.get(0).getTrndLineRmk());
				
				// 산포도 조회를 위한 MATCH NOON RPT 정보 조회
				for(FcmTrndLineVO fcmTrndLineVO : fcmTrndLineVOs){
					List<FcmNoonRptVO> fcmNoonRptVOs = command.searchFcmTrndLineRptMtchList(fcmTrndLineVO);
					makePoint(eventResponse, fcmTrndLineVO, fcmNoonRptVOs);
				}
			}
		} catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * Trend Line 정보 조회를 위한 X:Y Point 정보를 생성한다.
	 * 
	 * @param EventResponse eventResponse
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @param List<FcmNoonRptVO> fcmNoonRptVOs
	 * @exception EventException
	 */
	private void makePoint(EventResponse eventResponse,
			FcmTrndLineVO fcmTrndLineVO,
			List<FcmNoonRptVO> fcmNoonRptVOs) throws EventException {
		
		try{
			StringBuilder sb = new StringBuilder();
			String chartTpCd = "";
			if("01".equals(fcmTrndLineVO.getTrndLineChtTpCd())){
				chartTpCd = "CHART01";
				for(FcmNoonRptVO fcmNoonRptVO : fcmNoonRptVOs){
					sb.append(",").append(FCMGeneralUtil.getCheckNullToString(fcmNoonRptVO.getCalcSpd())).
					   append(":").append(FCMGeneralUtil.getCheckNullToString(fcmNoonRptVO.getMnFoilCsmQty()));
				}
			}else if("02".equals(fcmTrndLineVO.getTrndLineChtTpCd())){
				chartTpCd = "CHART02";
				for(FcmNoonRptVO fcmNoonRptVO : fcmNoonRptVOs){
					sb.append(",").append(FCMGeneralUtil.getCheckNullToString(fcmNoonRptVO.getSailAvgSpd())).
					   append(":").append(FCMGeneralUtil.getCheckNullToString(fcmNoonRptVO.getMnFoilCsmQty()));
				}
				
			}else if("03".equals(fcmTrndLineVO.getTrndLineChtTpCd())){
				chartTpCd = "CHART03";
				for(FcmNoonRptVO fcmNoonRptVO : fcmNoonRptVOs){
					sb.append(",").append(FCMGeneralUtil.getCheckNullToString(fcmNoonRptVO.getCalcSpd())).
					   append(":").append(FCMGeneralUtil.getCheckNullToString(fcmNoonRptVO.getSailAvgRpmPwr()));
				}
				
			}else if("04".equals(fcmTrndLineVO.getTrndLineChtTpCd())){
				chartTpCd = "CHART04";
				for(FcmNoonRptVO fcmNoonRptVO : fcmNoonRptVOs){
					sb.append(",").append(FCMGeneralUtil.getCheckNullToString(fcmNoonRptVO.getSailAvgRpmPwr())).
					   append(":").append(FCMGeneralUtil.getCheckNullToString(fcmNoonRptVO.getMnFoilCsmQty()));
				}
				
			}else if("05".equals(fcmTrndLineVO.getTrndLineChtTpCd())){
				chartTpCd = "CHART05";
				for(FcmNoonRptVO fcmNoonRptVO : fcmNoonRptVOs){
					sb.append(",").append(FCMGeneralUtil.getCheckNullToString(fcmNoonRptVO.getLoad())).
					   append(":").append(FCMGeneralUtil.getCheckNullToString(fcmNoonRptVO.getMnFoilCsmQty()));
				}
				
			}else if("06".equals(fcmTrndLineVO.getTrndLineChtTpCd())){
				chartTpCd = "CHART06";
				for(FcmNoonRptVO fcmNoonRptVO : fcmNoonRptVOs){
					sb.append(",").append(FCMGeneralUtil.getCheckNullToString(fcmNoonRptVO.getSailAvgSpd())).
					   append(":").append(FCMGeneralUtil.getCheckNullToString(fcmNoonRptVO.getLoad()));
				}
				
			}
			
			eventResponse.setETCData(chartTpCd, sb.toString());
			
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
	}
	
	/**
	 * VOP_FCM_0012  : Retrieve <br>
	 * Trend Line 생성을 위한 정보와 해당 정보를 이용한 Trend Line 을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFcmTrndLineBasic(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0012Event event = (VopFcm0012Event)e;
		TrendLineBC command = new TrendLineBCImpl();
		
		try {
			// TREND LINE back data 조회
			List<FcmNoonRptVO> fcmNoonRptVOs = command.searchFcmTrndLineBasic(event.getFcmTrndLineVO());
			// back data를 이용한 Trend Line 계수 계산
			List<FcmTrndLineVO> fcmTrndLineVOs = command.calcTrndLine(fcmNoonRptVOs, "0012");

			eventResponse.setRsVoList(fcmTrndLineVOs);
			eventResponse.setRsVoList(fcmNoonRptVOs);
		} catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0012  : Cretion에서의 기생성된 Trnd Line Retrieve <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFcmTrndLineBasicForInq(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0012Event event = (VopFcm0012Event)e;
		TrendLineBC command = new TrendLineBCImpl();
		
		try {
			// TREND LINE 조회
			List<FcmTrndLineVO> fcmTrndLineVOs = command.searchFcmTrndLineForInq(event.getFcmTrndLineVO());

			// raw data 조회
			List<FcmNoonRptVO> fcmNoonRptVOs = new ArrayList<FcmNoonRptVO>();
			if(fcmTrndLineVOs.size()>0){
				fcmNoonRptVOs = command.searchFcmTrndLineRawDataForInq(fcmTrndLineVOs.get(0));
				eventResponse.setETCData("trnd_line_rmk", fcmTrndLineVOs.get(0).getTrndLineRmk());
			}

			eventResponse.setRsVoList(fcmTrndLineVOs);
			eventResponse.setRsVoList(fcmNoonRptVOs);
		} catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0012  : Simulation <br>
	 * Back Data의 delt_flg를 변경한 후, 변경된 Back Data를 이용해 Trnd Line 정보를 구한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse simulateTrndLine(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0012Event event = (VopFcm0012Event)e;
		TrendLineBC command = new TrendLineBCImpl();
		
		try {
			FcmNoonRptVO[] rawDataVOs = event.getFcmNoonRptVOs();
			//rawData를 이용하여 average slip, calc spd, applied slip을 구하여 다시 rawData에 setting.
			rawDataVOs = command.calcRawDataSimulation(rawDataVOs);
			
			List<FcmNoonRptVO> fcmNoonRptVOs = new ArrayList<FcmNoonRptVO>();
			for(int i=0; i<rawDataVOs.length;i++){
				fcmNoonRptVOs.add(rawDataVOs[i]);
			}
			
			List<FcmTrndLineVO> fcmTrndLineVOs = command.calcTrndLine(fcmNoonRptVOs, "0012");
			
			eventResponse.setRsVoList(fcmTrndLineVOs);
			eventResponse.setRsVoList(fcmNoonRptVOs);
		} catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0012  : Period 입력 후 <br>
	 * 해당 기간의 Noon Rpt가 존재하는 Lane, Vessel, Design Cap.를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneVslCapa(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0012Event event = (VopFcm0012Event)e;
		TrendLineBC command = new TrendLineBCImpl();
		
		try {
			List<String[]> list = command.searchLaneVslCapa(event.getFcmTrndLineVO());
			String[] arrCapa	 = list.get(0);
			String[] arrSubClass = list.get(1);
			String[] arrLane	 = list.get(2);
			String[] arrVsl		 = list.get(3);
			String[] arrDirCd	 = list.get(4);

			StringBuilder sb = new StringBuilder();
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			StringBuilder sb3 = new StringBuilder();
			StringBuilder sb4 = new StringBuilder();
			
			if(arrCapa != null && arrCapa.length > 0){
				sb.append(arrCapa[0]);
				for (int i = 1; i < arrCapa.length; i++) {
					sb.append("|");
					sb.append(arrCapa[i]);
				}
			}else{
				sb.append("");
			}
			if(arrSubClass != null && arrSubClass.length > 0){
				sb1.append(arrSubClass[0]);
				for (int i = 1; i < arrSubClass.length; i++) {
					sb1.append("|");
					sb1.append(arrSubClass[i]);
				}
			}else{
				sb1.append("");
			}
			if(arrLane != null && arrLane.length > 0){
				sb2.append(arrLane[0]);
				for (int i = 1; i < arrLane.length; i++) {
					sb2.append("|");
					sb2.append(arrLane[i]);
				}
			}else{
				sb2.append("");
			}
			if(arrVsl != null && arrVsl.length > 0){
				sb3.append(arrVsl[0]);
				for (int i = 1; i < arrVsl.length; i++) {
					sb3.append("|");
					sb3.append(arrVsl[i]);
				}
			}else{
				sb3.append("");
			}
			if(arrDirCd != null && arrDirCd.length > 0){
				sb4.append(arrDirCd[0]);
				for (int i = 1; i < arrDirCd.length; i++) {
					sb4.append("|");
					sb4.append(arrDirCd[i]);
				}
			}else{
				sb4.append("");
			}
			
			eventResponse.setETCData("vsl_clss_cd", sb.toString());
			eventResponse.setETCData("vsl_clss_sub_cd", sb1.toString());
			eventResponse.setETCData("vsl_slan_cd", sb2.toString());
			eventResponse.setETCData("vsl_cd", sb3.toString());
			eventResponse.setETCData("skd_dir_cd", sb4.toString());
			
		} catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Trnd Line을 생성합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTrndLine(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0012Event event = (VopFcm0012Event)e;
		TrendLineBC command = new TrendLineBCImpl();
		
		try{
			begin();
			String[] trndLineNo = command.manageTrndLine(event.getFcmTrndLineVO(), event.getFcmNoonRptVOs(), event.getFcmTrndLineVOs(), account);
//			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			eventResponse.setETCData("trnd_line_no", trndLineNo[0]);
			eventResponse.setETCData("trnd_line_tp_sub_cd", trndLineNo[1]);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 기존재하는 Trnd Line의 정보를 수정합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTrndLineUpd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0012Event event = (VopFcm0012Event)e;
		TrendLineBC command = new TrendLineBCImpl();
		
		try{
			begin();
			command.manageTrndLineUpd(event.getFcmTrndLineVO(), event.getFcmNoonRptVOs(), event.getFcmTrndLineVOs(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Trnd Line을 삭제합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteTrndLine(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0012Event event = (VopFcm0012Event)e;
		TrendLineBC command = new TrendLineBCImpl();
		
		try{
			begin();
			command.removeTrndLine(event.getFcmTrndLineVO());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_FCM_0014  : Retrieve <br>
	 * Trend Line 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFcmTrndLinePopupList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0014Event event = (VopFcm0014Event)e;
		TrendLineBC command = new TrendLineBCImpl();
		
		try {
			// TREND LINE 정보 조회
			List<FcmTrndLineVO> fcmTrndLineVOs = command.searchFcmTrndLinePopupList(event.getFcmTrndLineVO());
			eventResponse.setRsVoList(fcmTrndLineVOs);
		} catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0014 : Window Open<br>
	 * MDM Vessel Class Capacity List를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVslClassCapaList(Event e) throws EventException {
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			FCMCommonBC command = new FCMCommonBCImpl();
	
			String list = command.searchVslClassCapaList();
			eventResponse.setETCData("cntr_dzn_capa", list);
			
		} catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}

		return eventResponse;
	}
}
