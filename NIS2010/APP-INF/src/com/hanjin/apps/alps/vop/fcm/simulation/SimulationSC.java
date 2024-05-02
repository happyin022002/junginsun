/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SimulationSC
*@FileTitle : SimulationSC
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
* 2014.04.16 [CHM-201429874] Standard FOC 생성 및 단계별 저장 기능 개발(0056 신규 개발)
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.simulation;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.vop.fcm.setup.setup.vo.FcmVslCntrRgstVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.basic.SimulationBC;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.basic.SimulationBCImpl;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.event.VopFcm0051Event;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.event.VopFcm0052Event;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.event.VopFcm0053Event;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.event.VopFcm0054Event;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.event.VopFcm0055Event;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.event.VopFcm0056Event;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.BnkReqSimVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.FcmBnkCsmPfDtlSimVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.FcmBnkCsmPfSimVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.SmlPfSkdVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.StandardFocVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.TrndLineSimulationVO;
import com.hanjin.apps.alps.vop.fcm.trendline.trendline.basic.TrendLineBC;
import com.hanjin.apps.alps.vop.fcm.trendline.trendline.basic.TrendLineBCImpl;
import com.hanjin.apps.alps.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.VskPfSkdVO;

/**
 * ALPS VesselReport ServiceCommand - VesselReport 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Hyuk Ryu
 * @see 
 * @since J2EE 1.6
 */

public class SimulationSC extends ServiceCommandSupport {

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
		EventResponse eventResponse = new GeneralEventResponse();
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopFcm0051Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBunkerRequestSimulation(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBunkerRequestSimulation(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopFcm0052Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkd(e);
			}if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVslRgstInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiFcmBnkCsm(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("VopFcm0053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTrndLineNo(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopFcm0054Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTrndLineForFOC(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkVslCdOfTrndLine(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCapaLaneOfTrndLine(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopFcm0055Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTrndLineDataList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTrndLineItmList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = simulateTrndLine(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopFcm0056Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStandardFoc(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageStandardFoc(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0051 : Retrieve
	 * 지정된 VVD에 대해 Bunker Request Simulation을 한다. 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBunkerRequestSimulation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopFcm0051Event event = (VopFcm0051Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BnkReqSimVO bnkReqSimVO = event.getBnkReqSimVO();

		try {
			SimulationBC command = new SimulationBCImpl();
			
			// Search target VVD and SKD information.
			List<BnkReqSimVO> bnkReqSimVOs = command.searchVvd(bnkReqSimVO);
			if(bnkReqSimVOs!=null && bnkReqSimVOs.size()>0){
				eventResponse.setETCData("lane_cd", bnkReqSimVOs.get(0).getSlanCd());
			}
			
			// Search trend line to simulate bunker request.
			FcmTrndLineVO fcmTrndLineVO = command.searchTrendLineForBnkReqSim(bnkReqSimVO);
			
			eventResponse.setRsVoList(bnkReqSimVOs);
			eventResponse.setRsVo(fcmTrndLineVO);
		} catch (EventException ex){
			throw ex;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0051 : Save
	 * Save the simulation data, and get the simulation number.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBunkerRequestSimulation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopFcm0051Event event = (VopFcm0051Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		BnkReqSimVO[] bnkReqSimVOs = event.getBnkReqSimVOs();
		String simNo = "";

		try {
			SimulationBC command = new SimulationBCImpl();
			
			// Search target VVD and SKD information.
			simNo = command.manageBunkerRequestSimulation(bnkReqSimVOs);
			
		} catch (EventException ex){
			throw ex;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		eventResponse.setETCData("simNo",simNo);
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Codepublish의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiFcmBnkCsm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopFcm0052Event event = (VopFcm0052Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		 FcmBnkCsmPfSimVO  fcmBnkCsmPfSimVO = event.getFcmBnkCsmPfSimVO();
		 String simNo ="";

		try {
			SimulationBC command = new SimulationBCImpl();
	
		    begin();
			if(fcmBnkCsmPfSimVO.getBnkCsmSimNo().equals("")){
				 simNo = command.addSimNo();

				if(simNo.equals("")){
					simNo = (new SimpleDateFormat("yyyyMM")).format(new Date())+"001";
				}else{
					simNo =Integer.parseInt(simNo)+1+"";
				}
				
				fcmBnkCsmPfSimVO.setBnkCsmSimNo(simNo);
				command.addFcmBnkCsmPfSim(fcmBnkCsmPfSimVO,account);
			}else{
				simNo=fcmBnkCsmPfSimVO.getBnkCsmSimNo();
			}
			command.multiFcmBnkCsm(fcmBnkCsmPfSimVO,account);
			commit();
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		eventResponse.setETCData("simNo",simNo);
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0001  : Display <br>
	 * Vessel Report에 대한 주어진 구간의 스케줄 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPfSkd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0052Event event = (VopFcm0052Event)e;
		SimulationBC command = new SimulationBCImpl();
		
		try {
				StringBuilder sb = new StringBuilder();
				StringBuffer sb2 = new StringBuffer();
				SmlPfSkdVO pfSkdVO = event.getSmlPfSkdVO();
				VskPfSkdVO vskPfSkdVO = new VskPfSkdVO();
				List<VskPfSkdDtlVO> vskPfSkdDtlVOs = new ArrayList<VskPfSkdDtlVO>();
				pfSkdVO.setVslSvcTpCd("");
				pfSkdVO.setSlanStndFlg("");
				List<SmlPfSkdVO> list = command.searchPfSkd(pfSkdVO);
				if(list != null && list.size()>0){
					vskPfSkdVO.setVslSlanCd(list.get(0).getVslSlanCd());
					
					vskPfSkdVO.setPfSvcTpCd(list.get(0).getPfSvcTpCd());
					vskPfSkdVO.setSlanStndFlg(list.get(0).getSlanStndFlg());
					vskPfSkdVO.setSvcDurDys(list.get(0).getSvcDurDys());
					vskPfSkdVO.setStndSvcSpd(list.get(0).getStndSvcSpd());
					vskPfSkdVO.setBrthItvalDys(list.get(0).getBrthItvalDys());
					
					vskPfSkdVO.setMmlUsdFlg(list.get(0).getMmlUsdFlg());
					vskPfSkdVO.setSimDt(list.get(0).getSimDt());
//					vskPfSkdVO.setBnkCsmSimNo(list.get(0).getBnkCsmSimNo());
					vskPfSkdVO.setN1stVslClssCd(list.get(0).getN1stVslClssCd());
					vskPfSkdVO.setN1stVslClssKnt(list.get(0).getN1stVslClssKnt());
					
					vskPfSkdVO.setN2ndVslClssCd(list.get(0).getN2ndVslClssCd());
					vskPfSkdVO.setN2ndVslClssKnt(list.get(0).getN2ndVslClssKnt());
					vskPfSkdVO.setN3rdVslClssCd(list.get(0).getN3rdVslClssCd());
					vskPfSkdVO.setN3rdVslClssKnt(list.get(0).getN3rdVslClssKnt());
					vskPfSkdVO.setClptKnt(list.get(0).getClptKnt());
					
					vskPfSkdVO.setTtlDist(list.get(0).getTtlDist());
					vskPfSkdVO.setMaxSpd(list.get(0).getMaxSpd());
					vskPfSkdVO.setAvgSpd(list.get(0).getAvgSpd());
					vskPfSkdVO.setDeltFlg(list.get(0).getDeltFlg());
					vskPfSkdVO.setPfSkdRmk(list.get(0).getPfSkdRmk());
					
					vskPfSkdVO.setCreDt(list.get(0).getCreDt());
					vskPfSkdVO.setUpdDt(list.get(0).getUpdDt());

					for(int i=0; i<list.size(); i++){
						
						VskPfSkdDtlVO vskPfSkdDtlVO = new VskPfSkdDtlVO();					
						vskPfSkdDtlVO.setRowSeq(list.get(i).getRowSeq());
						
						vskPfSkdDtlVO.setVslSlanCd(list.get(i).getVslSlanCd());
						
						vskPfSkdDtlVO.setPfSvcTpCd(list.get(i).getPfSvcTpCd());
						vskPfSkdDtlVO.setPortCd(list.get(i).getPortCd());
						vskPfSkdDtlVO.setSkdDirCd(list.get(i).getSkdDirCd());
						vskPfSkdDtlVO.setClptSeq(list.get(i).getClptSeq());
						vskPfSkdDtlVO.setPortRotnSeq(list.get(i).getPortRotnSeq());
						
						vskPfSkdDtlVO.setYdCd(list.get(i).getTempYdCd());
						vskPfSkdDtlVO.setCallYdIndSeq(list.get(i).getCallYdIndSeq());
						vskPfSkdDtlVO.setTurnPortFlg(list.get(i).getTurnPortFlg());
						vskPfSkdDtlVO.setTurnPortIndCd(list.get(i).getTurnPortIndCd());
						vskPfSkdDtlVO.setEtbDyCd(list.get(i).getEtbDyCd());
						
						vskPfSkdDtlVO.setEtbDyNo(list.get(i).getEtbDyNo());
						vskPfSkdDtlVO.setEtbTmHrmnt(list.get(i).getEtbTmHrmnt());
						vskPfSkdDtlVO.setEtdDyCd(list.get(i).getEtdDyCd());
						vskPfSkdDtlVO.setEtdDyNo(list.get(i).getEtdDyNo());
						vskPfSkdDtlVO.setEtdTmHrmnt(list.get(i).getEtdTmHrmnt());
						
						                       vskPfSkdDtlVO.setLnkDist("");
						                       vskPfSkdDtlVO.setLnkSpd("");
						                       vskPfSkdDtlVO.setTztmHrs("");
						                       vskPfSkdDtlVO.setSeaBufHrs("");
						                       vskPfSkdDtlVO.setSeaBufSpd("");
//						                       vskPfSkdDtlVO.setMnvrOutHrs("");
						                       
						vskPfSkdDtlVO.setAvgSeaBufSpd(list.get(i).getAvgSeaBufSpd());
						
//						vskPfSkdDtlVO.setMnvrInHrs(list.get(i).getMnvrInHrs());
		               vskPfSkdDtlVO.setMnvrOutHrs(list.get(i).getMnvrOutHrs());
						vskPfSkdDtlVO.setIbIpcgoQty(list.get(i).getIbIpcgoQty());
						vskPfSkdDtlVO.setIbOcnCgoQty(list.get(i).getIbOcnCgoQty());
						vskPfSkdDtlVO.setObIpcgoQty(list.get(i).getObIpcgoQty());
						
						vskPfSkdDtlVO.setObOcnCgoQty(list.get(i).getObOcnCgoQty());
						vskPfSkdDtlVO.setTmlProdQty(list.get(i).getTmlProdQty());
						vskPfSkdDtlVO.setCrnKnt(list.get(i).getCrnKnt());
						vskPfSkdDtlVO.setActWrkHrs(list.get(i).getActWrkHrs());
						vskPfSkdDtlVO.setPortBufHrs(list.get(i).getPortBufHrs());
						
						vskPfSkdDtlVO.setZd(list.get(i).getZd());
						//2009 09 30 임창빈 수석 수정요청 : 
						//Maximum Speed,P/F Speed,Speed (Incl. buffer),Total Buffer Ratio,Sea buffer Ratio,Port buffer Ratio,P/F Speed Ratio,Buffer Speed Ratio
						//기존의 쿼리에서 계산되어서 가져오는 방법에서  화면에 마지막 로우의 숨긴 데이타를 빼고 계산한다
						/*
						vskPfSkdDtlVO.setTotMaxSpd(list.get(i).getTotMaxSpd());
						vskPfSkdDtlVO.setTotAvgSpd(list.get(i).getTotAvgSpd());
						vskPfSkdDtlVO.setBufSpd(list.get(i).getSeaBufSpd());
						
						vskPfSkdDtlVO.setTotBufRat(list.get(i).getTotBufRat());
						vskPfSkdDtlVO.setSeaBufRat(list.get(i).getSeaBufRat());
						vskPfSkdDtlVO.setPortBufRat(list.get(i).getPortBufRat());
						vskPfSkdDtlVO.setPfSpdRat(list.get(i).getPfSpdRat());
						vskPfSkdDtlVO.setBufSpdRat(list.get(i).getBufSpdRat());
	*/					
						vskPfSkdDtlVO.setMinMaxSpd(list.get(i).getMinMaxSpd());
						
						vskPfSkdDtlVO.setCheckWkTm(list.get(i).getCheckWkTm());
						vskPfSkdDtlVO.setCraneWkTm(list.get(i).getCraneWkTm());
						
						vskPfSkdDtlVOs.add(vskPfSkdDtlVO);
						VskPfSkdDtlVO vskPfSkdDtlVO2 = new VskPfSkdDtlVO();	
						   vskPfSkdDtlVO2.setVslSlanCd("");
							
							vskPfSkdDtlVO2.setPfSvcTpCd("");
							vskPfSkdDtlVO2.setPortCd("");
							vskPfSkdDtlVO2.setSkdDirCd("");
							vskPfSkdDtlVO2.setClptSeq("");
							vskPfSkdDtlVO2.setPortRotnSeq("");
							
							vskPfSkdDtlVO2.setYdCd("");
							vskPfSkdDtlVO2.setCallYdIndSeq("");
							vskPfSkdDtlVO2.setTurnPortFlg("");
							vskPfSkdDtlVO2.setTurnPortIndCd("");
							vskPfSkdDtlVO2.setEtbDyCd("");
							
							vskPfSkdDtlVO2.setEtbDyNo("");
							vskPfSkdDtlVO2.setEtbTmHrmnt("");
							vskPfSkdDtlVO2.setEtdDyCd("");
							vskPfSkdDtlVO2.setEtdDyNo("");
							vskPfSkdDtlVO2.setEtdTmHrmnt("");
							
							   vskPfSkdDtlVO2.setLnkDist(list.get(i).getLnkDist());
		                       vskPfSkdDtlVO2.setLnkSpd(list.get(i).getLnkSpd());
		                       vskPfSkdDtlVO2.setTztmHrs(list.get(i).getTztmHrs());
		                       vskPfSkdDtlVO2.setSeaBufHrs(list.get(i).getSeaBufHrs());
		                       vskPfSkdDtlVO2.setSeaBufSpd(list.get(i).getSeaBufSpd());
//		                       vskPfSkdDtlVO2.setMnvrOutHrs(list.get(i).getMnvrOutHrs());
							                       
							vskPfSkdDtlVO2.setAvgSeaBufSpd("");
							
//							vskPfSkdDtlVO2.setMnvrInHrs("");
							vskPfSkdDtlVO2.setMnvrInHrs(list.get(i).getMnvrInHrs());
							             //  vskPfSkdDtlVO2.setMnvrOutHrs(list.get(i).getMnvrOutHrs());
							vskPfSkdDtlVO2.setIbIpcgoQty("");
							vskPfSkdDtlVO2.setIbOcnCgoQty("");
							vskPfSkdDtlVO2.setObIpcgoQty("");
							
							vskPfSkdDtlVO2.setObOcnCgoQty("");
							vskPfSkdDtlVO2.setTmlProdQty("");
							vskPfSkdDtlVO2.setCrnKnt("");
							vskPfSkdDtlVO2.setActWrkHrs("");
							vskPfSkdDtlVO2.setPortBufHrs("");
							
							vskPfSkdDtlVO2.setZd("");
					
							vskPfSkdDtlVO2.setMinMaxSpd("");
							
							vskPfSkdDtlVO2.setCheckWkTm("");
							vskPfSkdDtlVO2.setCraneWkTm("");
							
							vskPfSkdDtlVOs.add(vskPfSkdDtlVO2);					
						
					}
					
					//2009 09 30 임창빈 수석 수정요청 : 
					//Maximum Speed,P/F Speed,Speed (Incl. buffer),Total Buffer Ratio,Sea buffer Ratio,Port buffer Ratio,P/F Speed Ratio,Buffer Speed Ratio
					//기존의 쿼리에서 계산되어서 가져오는 방법에서  화면에 마지막 로우의 숨긴 데이타를 빼고 계산한다
					//마지막 로우는 계산에서 제한다
					double cnt = list.size()-1;
					//SEA SPEED TOTLAL
					double totLinkSpd = 0;
					//SEA BUFFER SPEED TOTAL
					double totBufSpd = 0;
					//SEA BUFFER TOTAL
					double totSeaBufHrs = 0;
					//SEA TIME TOTAL
					double totSeaTime = 0;
					//MANU IN HRS TOTAL
					double totMnvrInHrs = 0;
					//MANU OUT HRS TOTAL
					double totMnvrOutHrs = 0;
					//WORKING HOUR TOTAL
					double totActWrkHrs = 0;
					//PORT BUFFER HRS TOTLA
					double totPortBufHrs = 0;
					//VSL CALSS MAX SPD
					double dMinMaxSpd = 0;
					//MAX SPEED
					float totMaxSpd = 0;
					//P/F SPEED
					float totAvgSpd = 0;
					// P/F SPEED INCLUDE SEA BUFFER
					double avgSpdIncludeSeaBuf = 0;
					
					BigDecimal bufSpd = null;
					BigDecimal totBufRat = null;
					BigDecimal seaBufRat = null;
					BigDecimal portBufRat = null;
					BigDecimal pfSpdRat = null;
					BigDecimal bufSpdRat = null;

					float max = 0;
					for(int k=0; k<list.size()-1; k++){
						
						if(Float.compare(Float.parseFloat(list.get(k).getLnkSpd()), max)>0){
							max = Float.parseFloat(list.get(k).getLnkSpd());
						}
						
						if(k==0){
							dMinMaxSpd = Double.parseDouble(list.get(0).getMinMaxSpd());
							avgSpdIncludeSeaBuf = Double.parseDouble(list.get(0).getAvgSpd());
						}
						
						if(list.get(k).getLnkSpd() != null && !"".equals(list.get(k).getLnkSpd())){
							totLinkSpd 	+= Float.parseFloat(list.get(k).getLnkSpd());
						}
						if(list.get(k).getSeaBufSpd() != null && !"".equals(list.get(k).getSeaBufSpd())){
							totBufSpd += Float.parseFloat(list.get(k).getSeaBufSpd());
						}
						if(list.get(k).getSeaBufHrs() != null && !"".equals(list.get(k).getSeaBufHrs())){
							totSeaBufHrs += Float.parseFloat(list.get(k).getSeaBufHrs());
						}
						if(list.get(k).getTztmHrs() != null && !"".equals(list.get(k).getTztmHrs())){
							totSeaTime += Float.parseFloat(list.get(k).getTztmHrs());
						}
						if(list.get(k+1).getMnvrInHrs() != null && !"".equals(list.get(k+1).getMnvrInHrs())){
							totMnvrInHrs += Float.parseFloat(list.get(k+1).getMnvrInHrs());
						}
						if(list.get(k).getMnvrOutHrs() != null && !"".equals(list.get(k).getMnvrOutHrs())){
							totMnvrOutHrs += Float.parseFloat(list.get(k).getMnvrOutHrs());
						}
						if(list.get(k).getActWrkHrs() != null && !"".equals(list.get(k).getActWrkHrs())){
							totActWrkHrs += Float.parseFloat(list.get(k).getActWrkHrs());
						}
						if(list.get(k).getPortBufHrs() != null && !"".equals(list.get(k).getPortBufHrs())){
							totPortBufHrs += Float.parseFloat(list.get(k).getPortBufHrs());
						}
						
					}
					//Manu In은  마지막 로우는 보여준다
//					totMnvrInHrs = totMnvrInHrs + Float.parseFloat(list.get(list.size()-1).getMnvrInHrs());
					//Max Speed
					totMaxSpd = max;
					//Avg Speed
					totAvgSpd = Math.round(totLinkSpd/cnt); // <-- P/F Speed
					
					//Vsl Class Min_Max_Speed
//					dMinMaxSpd = totBufSpd/cnt;//Math.round(totBufSpd/cnt);
					
					//Sea Buffer Speed
					double tempBufSpd = Double.parseDouble(list.get(0).getSeaBufSpd());
					BigDecimal bigBufSpd = new BigDecimal(tempBufSpd);
					bufSpd = bigBufSpd.setScale(1,BigDecimal.ROUND_HALF_UP);
					
					double tempTotBufRat = (totBufSpd+totSeaBufHrs)/(totSeaTime+totSeaBufHrs+totMnvrInHrs+totMnvrOutHrs+totActWrkHrs)*100;
					if(Double.toString(tempTotBufRat).equals("NaN") || Double.toString(tempTotBufRat).equals("Infinity")){
						tempTotBufRat = 0;
			        }
					BigDecimal bigTotBufRat = new BigDecimal(tempTotBufRat);
					totBufRat = bigTotBufRat.setScale(2,BigDecimal.ROUND_HALF_UP);
			
			        double tempSeaBufRat = totSeaBufHrs/(totSeaTime+totSeaBufHrs+totMnvrInHrs+totMnvrOutHrs)*100;
			        if(Double.toString(tempSeaBufRat).equals("NaN") || Double.toString(tempSeaBufRat).equals("Infinity")){
			        	tempSeaBufRat = 0;
			        }
			        BigDecimal bigSeaBufRat = new BigDecimal(tempSeaBufRat);
			        seaBufRat = bigSeaBufRat.setScale(2,BigDecimal.ROUND_HALF_UP);
			        
			        double tempPortBufRat = totPortBufHrs/(totActWrkHrs+totPortBufHrs)*100;
			        if(Double.toString(tempPortBufRat).equals("NaN") || Double.toString(tempPortBufRat).equals("Infinity")){
			        	tempPortBufRat = 0;
			        }
			        BigDecimal bigPortBufRat = new BigDecimal(tempPortBufRat);
			        portBufRat = bigPortBufRat.setScale(2,BigDecimal.ROUND_HALF_UP);
			
			        double tempPfSpdRat = 0;
			        if(dMinMaxSpd!=0){
			        	// P/F Speed Ratio = P/F Speed / MIN_MAX_SPEED
			        	tempPfSpdRat = totAvgSpd / dMinMaxSpd;
			        }
			        
			        BigDecimal bigPfSpdRat = new BigDecimal(tempPfSpdRat);        
			        pfSpdRat = bigPfSpdRat.setScale(2,BigDecimal.ROUND_HALF_UP);
			        
			        double tempBufSpdRat = 0;
			        if(dMinMaxSpd!=0){
			        	tempBufSpdRat = avgSpdIncludeSeaBuf/dMinMaxSpd*100;	
			        }
			        
			        BigDecimal bigBufSpdRat = new BigDecimal(tempBufSpdRat);
			        bufSpdRat = bigBufSpdRat.setScale(2,BigDecimal.ROUND_HALF_UP);
			
					
			        list.get(0).setTotMaxSpd(Float.toString(totMaxSpd));
			        list.get(0).setTotAvgSpd(Float.toString(totAvgSpd));
			        list.get(0).setSeaBufSpd(bufSpd.toString());
			        list.get(0).setTotBufRat(totBufRat.toString());
			        list.get(0).setSeaBufRat(seaBufRat.toString());
			        list.get(0).setPortBufRat(portBufRat.toString());
			        list.get(0).setPfSpdRat(pfSpdRat.toString());
			        list.get(0).setBufSpdRat(bufSpdRat.toString());	

					sb.append(list.get(0).getTempYdCd());
					for(int i=1; i<list.size(); i++){
						sb.append("|");
						sb.append(list.get(i).getTempYdCd());
					}
					
					sb2.append(list.get(0).getTotMaxSpd());
					sb2.append("|");
					sb2.append(list.get(0).getTotAvgSpd());
					sb2.append("|");
					sb2.append(list.get(0).getSeaBufSpd());
					sb2.append("|");
					sb2.append(list.get(0).getTotBufRat());
					sb2.append("|");
					sb2.append(list.get(0).getSeaBufRat());
					sb2.append("|");
					sb2.append(list.get(0).getPortBufRat());
					sb2.append("|");
					sb2.append(list.get(0).getPfSpdRat());
					sb2.append("|");
					sb2.append(list.get(0).getBufSpdRat());
					sb2.append("|");
					sb2.append(list.get(0).getMinMaxSpd());
					sb2.append("|");
					sb2.append(list.get(0).getVslSvcTpCd());
					sb2.append("|");
					sb2.append(list.get(0).getCheckVslSkd());
					sb2.append("|");
					sb2.append(list.get(0).getCreUsrId());
					sb2.append("|");
					sb2.append(list.get(0).getUpdUsrId());
					
					eventResponse.setRsVo(vskPfSkdVO);
					eventResponse.setRsVoList(vskPfSkdDtlVOs);
					if(vskPfSkdVO.getN1stVslClssCd() != ""){
						List<FcmBnkCsmPfDtlSimVO> list2  = null;
						list2  = command.searchFcmBnkCsmPfDtlSimSmlPfSkd(pfSkdVO,vskPfSkdVO.getN1stVslClssCd());
						if(list2.size() != 0){
							eventResponse.setRsVoList(dataset(list2));
						}
					}
					if(vskPfSkdVO.getN2ndVslClssCd() != ""){
						List<FcmBnkCsmPfDtlSimVO> list2  = null;
						list2  = command.searchFcmBnkCsmPfDtlSimSmlPfSkd(pfSkdVO,vskPfSkdVO.getN2ndVslClssCd());
						if(list2.size() != 0){
							eventResponse.setRsVoList(dataset(list2));
						}
					}
					if(vskPfSkdVO.getN3rdVslClssCd() != ""){
						List<FcmBnkCsmPfDtlSimVO> list2  = null;
						list2  = command.searchFcmBnkCsmPfDtlSimSmlPfSkd(pfSkdVO,vskPfSkdVO.getN3rdVslClssCd());
						if(list2.size() != 0){
							eventResponse.setRsVoList(dataset(list2));
						}
					}

					eventResponse.setETCData("ydCd", sb.toString());
					eventResponse.setETCData("etcdt", sb2.toString());
				}else{
					eventResponse.setUserMessage(new ErrorHandler("VSK10018",new String[]{"P/F SKD Creation"}).getUserMessage());
				}
										
			
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Departure Report" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0052 : Trend Line Sheet OnChange
	 * Simulation에 필요한 Vessel Registration 정보를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslRgstInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SimulationBC command = new SimulationBCImpl();
		VopFcm0052Event event = (VopFcm0052Event)e;
		FcmTrndLineVO fcmTrndLineVO = event.getFcmTrndLineVO();
		try{
			FcmVslCntrRgstVO fcmVslCntrRgstVO = command.searchVslRgstInfo(fcmTrndLineVO);
//			eventResponse.setRsVo(fcmVslCntrRgstVO);
		
			eventResponse.setETCData("op_min_spd", fcmVslCntrRgstVO.getOpMinSpd());
			eventResponse.setETCData("op_max_spd", fcmVslCntrRgstVO.getOpMaxSpd());
			eventResponse.setETCData("op_gnr_spd", fcmVslCntrRgstVO.getOpGnrSpd());
			eventResponse.setETCData("mnvr_csm_wgt", fcmVslCntrRgstVO.getMnvrCsmWgt());
			eventResponse.setETCData("gnr_csm_wgt", fcmVslCntrRgstVO.getGnrCsmWgt());
			
		}catch(EventException ex){
			throw ex;
		} catch (Exception ex) {
	    	log.error("err " + ex.toString(), ex);
	    	throw new EventException(ex.getMessage(), ex);
		}
	    
		return eventResponse;
	}	
	
	
	/**
	 * 데이타 재정렬<br>
	 * fcmBnkCsmPfDtlSim 데이타 row를 두개의 row로 재정렬<br>
	 * 
	 * @param List<FcmBnkCsmPfDtlSimVO> list
	 * @return List<FcmBnkCsmPfDtlSimVO>
	 */
	private List<FcmBnkCsmPfDtlSimVO> dataset(List<FcmBnkCsmPfDtlSimVO> list2) {

		List<FcmBnkCsmPfDtlSimVO> fcmBnkCsmPfDtlSimVOs = new ArrayList<FcmBnkCsmPfDtlSimVO>();
			if(list2 != null){
				for(int i=0;i<list2.size();i++){
					FcmBnkCsmPfDtlSimVO fcmBnkCsmPfDtlSimVO = new FcmBnkCsmPfDtlSimVO();
					fcmBnkCsmPfDtlSimVO.setIbflag(list2.get(i).getIbflag());
					fcmBnkCsmPfDtlSimVO.setRowSeq(list2.get(i).getRowSeq());
					fcmBnkCsmPfDtlSimVO.setClptSeq(list2.get(i).getClptSeq());
					fcmBnkCsmPfDtlSimVO.setVslClssCd(list2.get(i).getVslClssCd()); 
					fcmBnkCsmPfDtlSimVO.setSkdDirCd(list2.get(i).getSkdDirCd()); 
					fcmBnkCsmPfDtlSimVO.setPortCd(list2.get(i).getPortCd()); 
					fcmBnkCsmPfDtlSimVO.setYdCd(list2.get(i).getYdCd()); 
					fcmBnkCsmPfDtlSimVO.setSimMaxSpd(""); 
					fcmBnkCsmPfDtlSimVO.setSimMinSpd(""); 
					fcmBnkCsmPfDtlSimVO.setSimRunAuxSpd(""); 
					fcmBnkCsmPfDtlSimVO.setSimSeaSpd(""); 
					fcmBnkCsmPfDtlSimVO.setSimSeaFoilCsmWgt(""); 
					fcmBnkCsmPfDtlSimVO.setSimMnvrFoilCsmWgt(""); 
					fcmBnkCsmPfDtlSimVO.setSimPortFoilCsmWgt(list2.get(i).getSimPortFoilCsmWgt()); 
					fcmBnkCsmPfDtlSimVO.setSimGnrPortFoilCsmWgt(list2.get(i).getSimGnrSeaFoilCsmWgt()); 							
					fcmBnkCsmPfDtlSimVO.setSimTtlFoilCsmWgt(""); 
					fcmBnkCsmPfDtlSimVO.setSimBufSeaSpd(""); 
					fcmBnkCsmPfDtlSimVO.setSimBufSeaFoilCsmWgt(""); 
					fcmBnkCsmPfDtlSimVO.setSimBufGnrFoilCsmWgt(""); 
					fcmBnkCsmPfDtlSimVO.setSimBufTtlFoilCsmWgt(""); 
					fcmBnkCsmPfDtlSimVOs.add(fcmBnkCsmPfDtlSimVO);		
					
					FcmBnkCsmPfDtlSimVO fcmBnkCsmPfDtlSimVO2 = new FcmBnkCsmPfDtlSimVO();
					fcmBnkCsmPfDtlSimVO.setIbflag(list2.get(i).getIbflag());
					fcmBnkCsmPfDtlSimVO2.setSimGnrPortFoilCsmWgt(list2.get(i).getSimGnrPortFoilCsmWgt()); 
					fcmBnkCsmPfDtlSimVO2.setClptSeq(list2.get(i).getClptSeq());
					fcmBnkCsmPfDtlSimVO2.setVslClssCd(list2.get(i).getVslClssCd()); 
					fcmBnkCsmPfDtlSimVO2.setSkdDirCd(""); 
					fcmBnkCsmPfDtlSimVO2.setPortCd(""); 
					fcmBnkCsmPfDtlSimVO2.setYdCd(""); 							
					fcmBnkCsmPfDtlSimVO2.setSimMaxSpd(list2.get(i).getSimMaxSpd()); 
					fcmBnkCsmPfDtlSimVO2.setSimMinSpd(list2.get(i).getSimMinSpd()); 
					fcmBnkCsmPfDtlSimVO2.setSimRunAuxSpd(list2.get(i).getSimRunAuxSpd()); 
					fcmBnkCsmPfDtlSimVO2.setSimSeaSpd(list2.get(i).getSimSeaSpd()); 
					fcmBnkCsmPfDtlSimVO2.setSimSeaFoilCsmWgt(list2.get(i).getSimSeaFoilCsmWgt()); 
					fcmBnkCsmPfDtlSimVO2.setSimMnvrFoilCsmWgt(list2.get(i).getSimMnvrFoilCsmWgt()); 
					fcmBnkCsmPfDtlSimVO2.setSimPortFoilCsmWgt(""); 
					fcmBnkCsmPfDtlSimVO2.setSimGnrPortFoilCsmWgt(list2.get(i).getSimGnrPortFoilCsmWgt()); 						
					fcmBnkCsmPfDtlSimVO2.setSimTtlFoilCsmWgt(list2.get(i).getSimTtlFoilCsmWgt()); 
					fcmBnkCsmPfDtlSimVO2.setSimBufSeaSpd(list2.get(i).getSimBufSeaSpd()); 
					fcmBnkCsmPfDtlSimVO2.setSimBufSeaFoilCsmWgt(list2.get(i).getSimBufSeaFoilCsmWgt()); 
					fcmBnkCsmPfDtlSimVO2.setSimBufGnrFoilCsmWgt(list2.get(i).getSimBufGnrFoilCsmWgt()); 
					fcmBnkCsmPfDtlSimVO2.setSimBufTtlFoilCsmWgt(list2.get(i).getSimBufTtlFoilCsmWgt()); 
					fcmBnkCsmPfDtlSimVOs.add(fcmBnkCsmPfDtlSimVO2);
					
				}
			}
         return fcmBnkCsmPfDtlSimVOs;
	}
	
	/**
	 * VOP_FCM_0053 : Design Capacity Change
	 * 해당 조건에 맞는 Trend Line No를 조회한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchTrndLineNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TrendLineBC command = new TrendLineBCImpl();
		VopFcm0053Event event = (VopFcm0053Event)e;
		try{
			List<FcmTrndLineVO> fcmTrndLineVOs = command.searchFcmTrndLinePopupList(event.getFcmTrndLineVO());
			eventResponse.setRsVoList(fcmTrndLineVOs);
		}catch(EventException ex){
			throw ex;
		} catch (Exception ex) {
	    	log.error("err " + ex.toString(), ex);
	    	throw new EventException(ex.getMessage(), ex);
		}
	    
		return eventResponse;
	}
	
//	/**
//	 * VOP_FCM_0053 : Window Open
//	 * MDM Vessel(Container) Design Capacity 목록을 조회한다.
//	 * 
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse searchCntrDznCapaList(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		FCMCommonBC command = new FCMCommonBCImpl();
//		try{
//			String cntrDznCapaList = command.searchCntrDznCapaList();
//			eventResponse.setETCData("cntr_dzn_capa", cntrDznCapaList);
//		}catch(EventException ex){
//			throw ex;
//		} catch (Exception ex) {
//	    	log.error("err " + ex.toString(), ex);
//	    	throw new EventException(ex.getMessage(), ex);
//		}
//	    
//		return eventResponse;
//	}
	
	/**
	 * VOP_FCM_0054 : vessel code 입력시
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVslCdOfTrndLine(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SimulationBC command = new SimulationBCImpl();
		VopFcm0054Event event = (VopFcm0054Event)e;
		try{
			FcmTrndLineVO fcmTrndLineVO = event.getFcmTrndLineVO();
			String isVslOk = command.checkVslCdOfTrndLine(fcmTrndLineVO.getVslCd());
			if("Y".equals(isVslOk)){
				String[] arrDirCd = command.searchTrndLineDirCd(fcmTrndLineVO);
				
				StringBuilder sb = new StringBuilder();
				if(arrDirCd != null && arrDirCd.length > 0){
					sb.append(arrDirCd[0]);
					for (int i = 1; i < arrDirCd.length; i++) {
						sb.append("|");
						sb.append(arrDirCd[i]);
					}
				}else{
					sb.append("");
				}
				eventResponse.setETCData("skd_dir_cd", sb.toString());
			}
			eventResponse.setETCData("is_vsl_ok", isVslOk);
		}catch(EventException ex){
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0054 : Sub Item 선택시
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrndLineForFOC(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SimulationBC command = new SimulationBCImpl();
		VopFcm0054Event event = (VopFcm0054Event)e;
		try{
			List<FcmTrndLineVO> list = command.searchTrndLineForFOC(event.getFcmTrndLineVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0054 : Sub Item 선택시
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCapaLaneOfTrndLine(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SimulationBC command = new SimulationBCImpl();
		VopFcm0054Event event = (VopFcm0054Event)e;
		try{
			List<String[]> list = command.searchCapaLaneOfTrndLine(event.getFcmTrndLineVO());

			String[] arrCapa	 = list.get(0);
			String[] arrSubClass = list.get(1);
			String[] arrLane	 = list.get(2);
			
			StringBuilder sb = new StringBuilder();
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			
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
			
			eventResponse.setETCData("vsl_clss_cd", sb.toString());
			eventResponse.setETCData("vsl_clss_sub_cd", sb1.toString());
			eventResponse.setETCData("vsl_slan_cd", sb2.toString());
		}catch(EventException ex){
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0055 : Item 선택시
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrndLineItmList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SimulationBC command = new SimulationBCImpl();
		VopFcm0055Event event = (VopFcm0055Event)e;
		try{
			TrndLineSimulationVO vo = event.getTrndLineSimulationVO();
			vo.setTarget(event.getTarget());
			String[] rslt = command.searchTrndLineItmList(vo);
			
			StringBuilder sb = new StringBuilder();
			
			if(rslt != null && rslt.length > 0){
				sb.append(rslt[0]);
				for (int i = 1; i < rslt.length; i++) {
					sb.append("|");
					sb.append(rslt[i]);
				}
			}else{
				sb.append("");
			}
			
			eventResponse.setETCData("rslt", sb.toString());
		}catch(EventException ex){
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_FCM_0055  : Retrieve <br>
	 * Trend Line 생성을 위한 정보와 해당 정보를 이용한 Trend Line 을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrndLineDataList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0055Event event = (VopFcm0055Event)e;
		TrendLineBC command = new TrendLineBCImpl();
		
		try {
			FcmTrndLineVO fcmTrndLineVO = event.getFcmTrndLineVO();
			fcmTrndLineVO.setVslClssCd(fcmTrndLineVO.getCntrDznCapa());
			// TREND LINE back data 조회
			List<FcmNoonRptVO> fcmNoonRptVOs = command.searchFcmTrndLineBasic(fcmTrndLineVO);
			// back data를 이용한 Trend Line 계수 계산
			List<FcmTrndLineVO> fcmTrndLineVOs = command.calcTrndLine(fcmNoonRptVOs, "0055");

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
	 * VOP_FCM_0055  : Simulation <br>
	 * Back Data의 delt_flg를 변경한 후, 변경된 Back Data를 이용해 Trnd Line 정보를 구한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse simulateTrndLine(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0055Event event = (VopFcm0055Event)e;
		TrendLineBC command = new TrendLineBCImpl();
		
		try {
			FcmNoonRptVO[] rawDataVOs = event.getFcmNoonRptVOs();
			//rawData를 이용하여 average slip, calc spd, applied slip을 구하여 다시 rawData에 setting.
			rawDataVOs = command.calcRawDataSimulation(rawDataVOs);
			
			List<FcmNoonRptVO> fcmNoonRptVOs = new ArrayList<FcmNoonRptVO>();
			for(int i=0; i<rawDataVOs.length;i++){
				fcmNoonRptVOs.add(rawDataVOs[i]);
			}
			
			List<FcmTrndLineVO> fcmTrndLineVOs = command.calcTrndLine(fcmNoonRptVOs, "0055");
			
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
	 * VOP_FCM_0056 : Retrieve
	 * Standard FOC 화면을 조회한다. 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchStandardFoc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopFcm0056Event event = (VopFcm0056Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StandardFocVO standardFocVO = event.getStandardFocVO();
		BnkReqSimVO bnkReqSimVO = event.getBnkReqSimVO();

		try {
			SimulationBC command = new SimulationBCImpl();
			
			List<StandardFocVO> standardFocVOs = command.searchStandardFoc(standardFocVO);
			
			if(standardFocVOs!=null && standardFocVOs.size()>0){
				eventResponse.setETCData("lane_cd", standardFocVOs.get(0).getVslSlanCd());
			}
			
			// Search trend line to simulate bunker request.
			FcmTrndLineVO fcmTrndLineVO = command.searchTrendLineForBnkReqSim(bnkReqSimVO);
			
			eventResponse.setRsVoList(standardFocVOs);
			eventResponse.setRsVo(fcmTrndLineVO);
		} catch (EventException ex){
			throw ex;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0056 : Save
	 * Standard FOC 정보를 저장한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageStandardFoc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopFcm0056Event event = (VopFcm0056Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			SimulationBC command = new SimulationBCImpl();
	
		    begin();
			command.manageStandardFoc(event.getFcmVslPortStndFuelOilVOs(),account);
			commit();
			
		} catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

		return eventResponse;
	}
	
}