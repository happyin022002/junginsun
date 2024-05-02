/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTYEquipmentForecastSC.java
*@FileTitle : MTY Balance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.23 김종준
* 1.0 Creation
* 2013.02.21 신용찬 [CHM-201323022]    OP/MG FCST HISTORY 화면생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.basic.CIMCommonBC;
import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.basic.CIMCommonBCImpl;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.basic.CommonBC;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.basic.CommonBCImpl;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.basic.MTYEquipmentForecastBC;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.basic.MTYEquipmentForecastBCImpl;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event.EesEqr5001Event;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event.EesEqr5002Event;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event.EesEqr5003Event;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event.EesEqr5004Event;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event.EesEqr5005Event;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event.EesEqr5006Event;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event.EesEqr5008Event;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event.EesEqr5009Event;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration.MTYEquipmentForecastDBDAO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.ForecastAccuracyListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalRptOtrVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceCommonListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceReferenceListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceRepoListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.basic.MTYWeeklySimulationBC;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.basic.MTYWeeklySimulationBCImpl;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.event.EesEqr5010Event;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.event.EesEqr5011Event;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.vo.MtyWeeklySimulationVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.basic.AvailableOffHireBC;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.basic.AvailableOffHireBCImpl;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-MTYEquipmentForecast Business Logic ServiceCommand - ALPS-MTYEquipmentForecast 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author kim jong jun
 * @see MTYEquipmentForecastDBDAO
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * MTYEquipmentForecast system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("MTYEquipmentForecastSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * MTYEquipmentForecast system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("MTYEquipmentForecastSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-MTYEquipmentForecast system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesEqr5001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyBalanceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMtyBalanceReferenceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//Location 코드 체크
				eventResponse = checkLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMtyBalance(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr5004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyBalanceOtherList(e,"5004");
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchYardDateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMtyBalanceOther(e,"5004");
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr5003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyBalanceOtherList(e,"5003");
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMtyBalanceOther(e,"5003");
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr5002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyBalanceRepoList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr5005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searcForecastAccuracyList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//Location 코드 체크
				eventResponse = checkLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr5006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyBalanceRepoOut(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMtyBalanceRepoOut(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMtyBalanceRepoOutVvdYardList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkMtyBalanceRepoOutYard(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr5008Event")) {  // LOG 조회					
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyBalanceListLog(e);
			} 				
		} else if (e.getEventName().equalsIgnoreCase("EesEqr5009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyRepoInDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMtyRepoInDetailVvdPortList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	
					eventResponse = searchLocationDatePeriod(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMtyRepoInDetailList(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EesEqr5010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyWeeklySimulation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMtyWeeklySimulationOrigin(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageMtyWeeklySimulation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkSubLocCd(e);
			} else {
				eventResponse = searchCurrentWeek(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr5011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyWeeklySimulationReport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkSubLocCd(e);
			} else {
				eventResponse = searchCurrentWeek(e);
			}

		}
			
		return eventResponse;
	}

	/**
	 * EES_CIM_5001 : [이벤트]<br>
	 * 지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyBalanceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr5001Event event = (EesEqr5001Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		event.getMtyBalanceOptionVO().setFcastYrwk(event.getMtyBalanceOptionVO().getFcastYrwk().replace("-", ""));
		List<MtyBalanceListVO> list = command.searchMtyBalanceList(event.getMtyBalanceOptionVO());
		String saveFlag = command.checkMtyBalanceLCCSave(event.getMtyBalanceOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String,String> etcData = new HashMap<String,String>();
		
//		if ( list.size() != 35 ) {	// IndexOutOfBoundsException 방지
		if ( list.size() != 46 ) {	// IndexOutOfBoundsException 방지, 46 : 조회값 row			
			etcData.put("yyyyMm","|");
		} else {		
			// 5001 화면좌측의 주차정보 +1,+2,+3
			etcData.put("yyyyMm",JSPUtil.getNull(list.get(15).getFcastYrwk0())+"|"+JSPUtil.getNull(list.get(26).getFcastYrwk0())+"|"+JSPUtil.getNull(list.get(37).getFcastYrwk0()));
		}
		eventResponse.setETCData(etcData);
		
		eventResponse.setRsVoList(list);
		eventResponse.setETCData("save_flag", saveFlag);
		return eventResponse;		
	}

	/**
	 * EES_CIM_5001 : [이벤트]<br>
	 * OP Forecast, MG Forecast 의 Log를 조회..<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyBalanceListLog(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr5008Event event = (EesEqr5008Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		
		// Repo Plan ID 주차정보
		log.debug(">>>>>> 5008 loc_cd       	: " +event.getMtyBalanceOptionVO().getLocCd());
		log.debug(">>>>>> 5008 inp_yrwk     	: " +event.getMtyBalanceOptionVO().getInpYrwk());
		log.debug(">>>>>> 5008 fcast_yrwk   	: " +event.getMtyBalanceOptionVO().getFcastYrwk());
		log.debug(">>>>>> 5008 repo_pln_yrwk   	: " +event.getMtyBalanceOptionVO().getRepoPlnYrwk());
		log.debug(">>>>>> 5008 loc_grp_cd   	: " +event.getMtyBalanceOptionVO().getLocGrpCd());
		log.debug(">>>>>> 5008 tp_cd   			: " +event.getMtyBalanceOptionVO().getTpCd());
		
		
		event.getMtyBalanceOptionVO().setFcastYrwk(event.getMtyBalanceOptionVO().getFcastYrwk().replace("-", ""));	
		
		List<MtyBalanceListVO> list = command.searchMtyBalanceListLog(event.getMtyBalanceOptionVO());

		eventResponse.setRsVoList(list);

		return eventResponse;		
	}
	
	
	/**
	 * EES_CIM_5001 : [이벤트]<br>
	 * 지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyBalanceReferenceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr5001Event event = (EesEqr5001Event)e;
		event.getMtyBalanceOptionVO().setFcastYrwk(event.getMtyBalanceOptionVO().getFcastYrwk().replace("-", ""));
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		List<MtyBalanceReferenceListVO> list = command.searchMtyBalanceReferenceList(event.getMtyBalanceOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		
		return eventResponse;		
	}
	/**
	 * EES_CIM_5001 : [이벤트]<br>
	 * 지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력한 내용을 생성,수정<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMtyBalance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr5001Event event = (EesEqr5001Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		try{
			begin();
			command.manageMtyBalance(event.getMtyBalanceListVOS(),account);
//			eventResponse.setUserMessage(new ErrorHandler("CIM00003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	
	/**
	 * EES_CIM_5004 : [이벤트]<br>
	 * ECC내 소속 야드,ECC내 소속 야드 를 조회한다<br>
	 * 
	 * @param e 이벤트
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardDateList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		Map<String,String> etcData = new HashMap<String,String>();
		
		GeneralEventResponse yardEtcData = (GeneralEventResponse)searchYardList(e);
		etcData.put("yd_cd",yardEtcData.getETCData("yd_cd").toString());
		etcData.put("yd_nm",yardEtcData.getETCData("yd_nm").toString());

		GeneralEventResponse dateEtcData = (GeneralEventResponse)searchDateListByWeek(e);
		etcData.put("date_list_by_week",dateEtcData.getETCData("date_list_by_week").toString());

		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}	
	

	
	/**
	 * EES_CIM_5001 : [이벤트]<br>
	 * ECC내 소속 야드<br>
	 * 
	 * @param e 이벤트
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardList(Event e) throws EventException {
		String locCd  = (String)e.getAttribute("loc_cd");
		String locGrpCd  = (String)e.getAttribute("loc_grp_cd");
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		List<MtyBalanceCommonListVO> mtyBalanceCommonListVO = command.searchYardList( locGrpCd, locCd );
		StringBuilder ydCdSb = new StringBuilder();
		StringBuilder ydNmSb = new StringBuilder();
		if(mtyBalanceCommonListVO.size() > 0) {
			for(int i = 0 ; i < mtyBalanceCommonListVO.size()-1 ; i++){
				ydCdSb.append(mtyBalanceCommonListVO.get(i).getYdCd());
				ydCdSb.append("|");
				ydNmSb.append(mtyBalanceCommonListVO.get(i).getYdNm());
				ydNmSb.append("|");
			}
			ydCdSb.append(mtyBalanceCommonListVO.get(mtyBalanceCommonListVO.size()-1).getYdCd());
			ydNmSb.append(mtyBalanceCommonListVO.get(mtyBalanceCommonListVO.size()-1).getYdNm());
		}

		Map<String,String> etcData = new HashMap<String,String>();
		
		etcData.put("yd_cd",ydCdSb.toString());
		etcData.put("yd_nm",ydNmSb.toString());
		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}	
	
	/**
	 * EES_CIM_5004 : [이벤트]<br>
	 * 특정 주차내의 일자 목록을 조회한다.<br>
	 * 
	 * @param e 이벤트
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDateListByWeek(Event e) throws EventException {
		String yearWeek = ((String)e.getAttribute("fcast_yrwk")).replace("-", "");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		List<MtyBalanceCommonListVO> mtyBalanceCommonListVO = command.searchDateListByWeek( yearWeek  );
		StringBuilder ydCdSb = new StringBuilder();
		if(mtyBalanceCommonListVO.size() > 0) {
			for(int i = 0 ; i < mtyBalanceCommonListVO.size()-1 ; i++){
				ydCdSb.append(mtyBalanceCommonListVO.get(i).getDateListByWeek());
				ydCdSb.append("|");
			}
			ydCdSb.append(mtyBalanceCommonListVO.get(mtyBalanceCommonListVO.size()-1).getDateListByWeek());
		}

		Map<String,String> etcData = new HashMap<String,String>();
		
		etcData.put("date_list_by_week",ydCdSb.toString());
		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}		

	/**
	 * EES_CIM_5003,EES_CIM_5004 : [이벤트]<br>
	 * 해당 Yard 의 장비인수 및 임차계획 수량,장비수급에 영향을 미치는 EQ Demand & Supply의 기타항목들을 Manual로 입력한 내용을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyBalanceOtherList(Event e,String searchFlag) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		List<MtyBalRptOtrVO> list = new ArrayList<MtyBalRptOtrVO>();
		if ( searchFlag.equals("5004") ) {
			EesEqr5004Event event = (EesEqr5004Event)e;
			event.getMtyBalanceOptionVO().setFcastYrwk(event.getMtyBalanceOptionVO().getFcastYrwk().replace("-", ""));
			list = command.searchMtyBalanceOtherList(event.getMtyBalanceOptionVO());
		} else if ( searchFlag.equals("5003") ) {
			EesEqr5003Event event = (EesEqr5003Event)e;
			event.getMtyBalanceOptionVO().setFcastYrwk(event.getMtyBalanceOptionVO().getFcastYrwk().replace("-", ""));
			list = command.searchMtyBalanceOtherList(event.getMtyBalanceOptionVO());
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;		
	}
	
	/**
	 * EES_CIM_5003,EES_CIM_5004 : [이벤트]<br>
	 * 해당 Yard 의 장비인수 및 임차계획 수량,장비수급에 영향을 미치는 EQ Demand & Supply의 기타항목들을 Manual로 입력한 내용을 조회한다.<br>
	 * 
	 * @param Event e
	 * @param String searchFlag
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse manageMtyBalanceOther(Event e,String searchFlag) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// 2015.02.25 CHM-201534210 EQR 소스 보안
		EesEqr5004Event event1 = new EesEqr5004Event();
		EesEqr5003Event event2 = new EesEqr5003Event();
		if ( searchFlag.equals("5004") ) {
			event1 = (EesEqr5004Event)e;
		} else if ( searchFlag.equals("5003") ) {
			event2 = (EesEqr5003Event)e;
		}
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		try{
			begin();
			if ( searchFlag.equals("5004") ) {
				command.manageMtyBalanceOther(event1.getMtyBalRptOtrVOS(),account);
			} else if ( searchFlag.equals("5003") ) {
				command.manageMtyBalanceOther(event2.getMtyBalRptOtrVOS(),account);
			}
			//eventResponse.setUserMessage(new ErrorHandler("CIM00003").getUserMessage());
			commit();
		}catch(EventException ex){
			eventResponse.setUserMessage(new ErrorHandler("CIM00004").getUserMessage());
			rollback();
			throw ex;
		}
		return eventResponse;
	}	

	/**
	 * EES_CIM_5002 : [이벤트]<br>
	 *  EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyBalanceRepoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr5002Event event = (EesEqr5002Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		event.getMtyBalanceOptionVO().setFcastYrwk(event.getMtyBalanceOptionVO().getFcastYrwk().replace("-", ""));

		List<MtyBalanceRepoListVO> list = command.searchMtyBalanceRepoList(event.getMtyBalanceOptionVO());
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		event.setMtyBalanceRepoListVO(list.get(0));
		
		if(list.get(0).getCurrFlag().equals("T")){
			MtyBalanceOptionVO mtyBalanceOptionVO = event.getMtyBalanceOptionVO();
			mtyBalanceOptionVO.setWkStDt(list.get(0).getWkStDt());
			mtyBalanceOptionVO.setWkEndDt(list.get(0).getWkEndDt());
			List<MtyBalanceRepoListVO> list2 = command.searchMtyBalanceDischargedList(event.getMtyBalanceOptionVO());
			eventResponse.setRsVoList(list2);
		}
		return eventResponse;		
	}

	/**
	 * EES_CIM_5005 : [이벤트]<br>
	 *  MTY Balance Report의 In&Out Bound FCST Data의 정확도를 WEEK별로 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searcForecastAccuracyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr5005Event event = (EesEqr5005Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		event.getForecastAccuracyOptionVO().setFmWeek(event.getForecastAccuracyOptionVO().getFmWeek().replace("-", ""));
		event.getForecastAccuracyOptionVO().setToWeek(event.getForecastAccuracyOptionVO().getToWeek().replace("-", ""));

		String status = command.searchForecastAccuracyList(event.getForecastAccuracyOptionVO(), account);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("BackEndJobKey", status);
		return eventResponse;		
	}
	
	/**
	 * 화면별 Location 이벤트 체크로직<br>
	 * Location check validate<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CIMCommonBC command = new CIMCommonBCImpl();

		String locLevel = (String)e.getAttribute("inquirylevel");
		String locCD = (String)e.getAttribute("location");
		String check = command.checkLocation(locLevel,locCD);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String,String> etcData = new HashMap<String,String>();
		etcData.put("check",check);
		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}
	
	/**
	 * EES_CIM_5005 : BackEndJob<br>
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchComBackEndJobStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			String key = (String)e.getAttribute("KEY");

			String status = command.searchComBackEndJobStatusBasic(key);
			eventResponse.setETCData("jb_sts_flg", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CIM_5005 : BackEndJob<br>
	 * BackEndJob의 실행결과로 생성된 파일을 로드합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse loadFileBackEndJobResultService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String key = (String)e.getAttribute("KEY");
		// 2015.02.25 CHM-201534210 EQR 소스 보안
		List list = new ArrayList();

		try {
			if(e.getEventName().equalsIgnoreCase("EesEqr5005Event")) {
				list = (List<ForecastAccuracyListVO>)BackEndJobResult.loadFromFile(key);
			}

			eventResponse.setRsVoList(list);
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * EES_CIM_5006 : [이벤트]<br>
	 * EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyBalanceRepoOut(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		List<MtyBalanceRepoListVO> list = null;
		EesEqr5006Event event = (EesEqr5006Event)e;
		event.getMtyBalanceRepoListVO().setInpYrwk(event.getMtyBalanceRepoListVO().getInpYrwk().replace("-", ""));
		event.getMtyBalanceRepoListVO().setFcastYrwk(event.getMtyBalanceRepoListVO().getFcastYrwk().replace("-", ""));
		list = command.searchMtyBalanceRepoOut(event.getMtyBalanceRepoListVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;		
	}
	
	/**
	 * EES_CIM_5006 : [이벤트]<br>
	 * VVD를 이용하여 slan cd, from/to yard, etd, eta를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyBalanceRepoOutVvdYardList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		String slanCd = "";
		List<MtyBalanceRepoListVO> fmYdList = null;
		List<MtyBalanceRepoListVO> toYdList = null;
		EesEqr5006Event event = (EesEqr5006Event)e;
		slanCd = command.searchMtyBalanceRepoOutSlanCd(event.getMtyBalanceRepoListVO());
		fmYdList = command.searchMtyBalanceRepoOutFrYdList(event.getMtyBalanceRepoListVO());
		toYdList = command.searchMtyBalanceRepoOutToYdList(event.getMtyBalanceRepoListVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(fmYdList);
		eventResponse.setRsVoList(toYdList);
		eventResponse.setETCData("slan_cd", slanCd);
		return eventResponse;		
	}
	
	/**
	 * EES_CIM_5006 : [이벤트]<br>
	 * T/D VVD가 아닌 경우 입력된 yard cd가 해당 ecc/lcc/scc에 속하는지 체크
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkMtyBalanceRepoOutYard(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		String ydCd = "";
		EesEqr5006Event event = (EesEqr5006Event)e;
		ydCd = command.checkMtyBalanceRepoOutYard(event.getMtyBalanceRepoListVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("yd_cd", ydCd);
		return eventResponse;		
	}
	
	/**
	 * EES_CIM_5005 : [이벤트]<br>
	 * EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 수정한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMtyBalanceRepoOut(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr5006Event event = (EesEqr5006Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		try{
			begin();
			command.manageMtyBalanceRepoOut(event.getMtyBalanceRepoListVOS(),account);
//			eventResponse.setUserMessage(new ErrorHandler("CIM00003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CIM_5010 : [이벤트]<br>
	 * 현재 주차를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrentWeek(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CommonBC common = new CommonBCImpl();
		MTYWeeklySimulationBC command = new MTYWeeklySimulationBCImpl();
		CommonVO commonVO = null;
		String fcastYrwk = "";
		String levelCd = "";
		commonVO = common.getCurrentWeek();
		fcastYrwk = commonVO.getResultString().substring(0, 4) + "-" + commonVO.getResultString().substring(4);
		levelCd = command.checkMtyBalanceRepoOutYard(account.getOfc_cd());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("fcast_yrwk", fcastYrwk);
		eventResponse.setETCData("level_cd", levelCd);
		return eventResponse;		
	}
	
	/**
	 * EES_CIM_5010 : [이벤트]<br>
	 * 지점별로 향후 -1~+4 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyWeeklySimulation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr5010Event event = (EesEqr5010Event)e;
		MTYWeeklySimulationBC command = new MTYWeeklySimulationBCImpl();
		List<MtyWeeklySimulationVO> list = command.searchMtyWeeklySimulation(event.getMtyWeeklySimulationOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		
		return eventResponse;		
	}
	
	/**
	 * EES_CIM_5010 : [이벤트]<br>
	 * 해당 셀의 원래 값을 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyWeeklySimulationOrigin(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MTYWeeklySimulationBC command = new MTYWeeklySimulationBCImpl();
		String cntrQty = "";
		EesEqr5010Event event = (EesEqr5010Event)e;
		cntrQty = command.searchMtyWeeklySimulationOrigin(event.getMtyWeeklySimulationOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("cntr_qty", cntrQty);
		return eventResponse;		
	}
	
	/**
	 * EES_CIM_5010 : [이벤트]<br>
	 * 지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력한 내용을 생성,수정<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMtyWeeklySimulation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr5010Event event = (EesEqr5010Event)e;
		MTYWeeklySimulationBC command = new MTYWeeklySimulationBCImpl();
		try{
			begin();
			command.manageMtyWeeklySimulation(event.getMtyWeeklySimulationOptionVOS(),account);
//			eventResponse.setUserMessage(new ErrorHandler("CIM00003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CIM_5011 : [이벤트]<br>
	 * 지점별로 이전 수 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyWeeklySimulationReport(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr5011Event event = (EesEqr5011Event)e;
		MTYWeeklySimulationBC command = new MTYWeeklySimulationBCImpl();
		String rptTtl = command.searchMtyWeeklySimulationReportTitle(event.getMtyWeeklySimulationOptionVO());
		CommonRsVO commonRsVO = command.searchMtyWeeklySimulationReport(event.getMtyWeeklySimulationOptionVO(), rptTtl);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRs(commonRsVO.getDbRowset());
		eventResponse.setETCData("rpt_ttl", rptTtl);
		return eventResponse;		
	}
	
	/**
	 * EES_CIM_5010, 5011: [이벤트]<br>
	 * 입력 받은 rcc/lcc/ecc가 해당 rcc에 속하는지 체크
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSubLocCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MTYWeeklySimulationBC command = new MTYWeeklySimulationBCImpl();
		String check = "";
		if (e.getEventName().equalsIgnoreCase("EesEqr5010Event")) {
			EesEqr5010Event event = (EesEqr5010Event)e;
			check = command.checkSubLocCd(event.getMtyWeeklySimulationOptionVO());
		}else if(e.getEventName().equalsIgnoreCase("EesEqr5011Event")) {
			EesEqr5011Event event = (EesEqr5011Event)e;
			check = command.checkSubLocCd(event.getMtyWeeklySimulationOptionVO());
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("check", check);
		return eventResponse;		
	}
	
	
	/**
	 * EES_EQR_5009 : [이벤트]<br>
	 * 5009화면에서 입력된 수기정보+REPO IN 데이터를 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRepoInDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr5009Event event = (EesEqr5009Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		event.getMtyBalanceOptionVO().setFcastYrwk(event.getMtyBalanceOptionVO().getFcastYrwk().replace("-", ""));
		
		List<MtyBalanceRepoListVO> list = command.searchMtyRepoInDetailList(event.getMtyBalanceOptionVO());
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		event.setMtyBalanceRepoListVO(list.get(0));
		
		if(list.get(0).getCurrFlag().equals("T")){
			MtyBalanceOptionVO mtyBalanceOptionVO = event.getMtyBalanceOptionVO();
			mtyBalanceOptionVO.setWkStDt(list.get(0).getWkStDt());
			mtyBalanceOptionVO.setWkEndDt(list.get(0).getWkEndDt());
			
			log.debug(">>>>>>>>>>>>>>> getCurrFlag 1");
			List<MtyBalanceRepoListVO> list2 = command.searchMtyBalanceDischargedList(event.getMtyBalanceOptionVO());
			
			log.debug(">>>>>>>>>>>>>>> getCurrFlag 2");
			eventResponse.setRsVoList(list2);
		}
		return eventResponse;		
	}	
	
	/**
	 * EES_EQR_5009 : [이벤트]<br>
	 * VVD를 이용하여 slan cd, PORT, ETB를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRepoInDetailVvdPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String slanCd = "";
		
		EesEqr5009Event event = (EesEqr5009Event)e;
		slanCd   = command.searchMtyBalanceRepoOutSlanCd(event.getMtyBalanceRepoListVO());
		
		eventResponse.setETCData("slan_cd", slanCd);
		
		return eventResponse;		
	}	
	
	/**
	 * EES_EQR_5009 : [이벤트]<br>
	 * LCC/ECC/SCC 내 소속 LOCATION,ETB DATE<br>
	 * 
	 * @param e 이벤트
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationDatePeriod(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		Map<String,String> etcData = new HashMap<String,String>();
		
		GeneralEventResponse yardEtcData = (GeneralEventResponse)searchLocationList(e);
		etcData.put("to_yd_cd",yardEtcData.getETCData("to_yd_cd").toString());
		etcData.put("to_yd_nm",yardEtcData.getETCData("to_yd_nm").toString());

		GeneralEventResponse dateEtcData = (GeneralEventResponse)searchLocationDateList(e);
		etcData.put("to_etb_dt", dateEtcData.getETCData("to_etb_dt").toString());

		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}		
	
	/**
	 * EES_EQR_5009 : [이벤트]<br>
	 * LCC/ECC/SCC 에 속한 LOCATION<br>
	 * 
	 * @param e 이벤트
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationList(Event e) throws EventException {
		String locCd    = (String)e.getAttribute("loc_cd");
		String locGrpCd = (String)e.getAttribute("loc_grp_cd");
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		
		List<MtyBalanceCommonListVO> mtyBalanceCommonListVO = command.searchLocationList( locGrpCd, locCd );
		StringBuilder ydCdSb = new StringBuilder();
		StringBuilder ydNmSb = new StringBuilder();
		if(mtyBalanceCommonListVO.size() > 0) {
			for(int i = 0 ; i < mtyBalanceCommonListVO.size()-1 ; i++){
				ydCdSb.append(mtyBalanceCommonListVO.get(i).getYdCd());
				ydCdSb.append("|");
				ydNmSb.append(mtyBalanceCommonListVO.get(i).getYdNm());
				ydNmSb.append("|");
			}
			ydCdSb.append(mtyBalanceCommonListVO.get(mtyBalanceCommonListVO.size()-1).getYdCd());
			ydNmSb.append(mtyBalanceCommonListVO.get(mtyBalanceCommonListVO.size()-1).getYdNm());
		}

		Map<String,String> etcData = new HashMap<String,String>();
		
		etcData.put("to_yd_cd",ydCdSb.toString());
		etcData.put("to_yd_nm",ydNmSb.toString());
		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}		
	
	/**
	 * EES_EQR_5009 : [이벤트]<br>
	 * 특정 주차내의 일자 목록을 조회한다.<br>
	 * 
	 * @param e 이벤트
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationDateList(Event e) throws EventException {
		log.debug("--------------searchLocationDateList START ");
		String wk_st_dt = ((String)e.getAttribute("wk_st_dt")).replace("/", "");
		log.debug("--------------searchLocationDateList SC wk_st_dt : " +wk_st_dt);
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		List<MtyBalanceCommonListVO> mtyBalanceCommonListVO = command.searchLocationDateList( wk_st_dt  );
		StringBuilder ydCdSb = new StringBuilder();
		
		if(mtyBalanceCommonListVO.size() > 0) {
			for(int i = 0 ; i < mtyBalanceCommonListVO.size()-1 ; i++){
				ydCdSb.append(mtyBalanceCommonListVO.get(i).getDateListByWeek());
				ydCdSb.append("|");
			}
			ydCdSb.append(mtyBalanceCommonListVO.get(mtyBalanceCommonListVO.size()-1).getDateListByWeek());
		}

		Map<String,String> etcData = new HashMap<String,String>();
		
		etcData.put("to_etb_dt", ydCdSb.toString());
		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}			
	
	/**
	 * EES_EQR_5009 : [이벤트]<br>
	 * REPO IN 데이터를 수기로 관리하는 기능 처리.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMtyRepoInDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr5009Event event = (EesEqr5009Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		
		log.debug(">>>>>>>>>>>>>>>> event.getMtyBalanceRepoListVOS().length : "+event.getMtyBalanceRepoListVOS().length);
		try{
			begin();
			command.manageMtyRepoInDetailList(event.getMtyBalanceRepoListVOS(),account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
}