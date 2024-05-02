/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSupplyDemandForecastSC.java
*@FileTitle : EQ Operation Trend (Inventory Trend)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.05.04 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.basic.CIMCommonBC;
import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.basic.CIMCommonBCImpl;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.basic.CNTRInventoryReportBC;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.basic.CNTRInventoryReportBCImpl;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0001Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0002Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0008Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0017Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0018Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0028Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0029Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0030Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0031Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0073Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration.CNTRInventoryReportDBDAO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCntrListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCodeCommonVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtSmryVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.StockByCntrListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.StockSmryVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.TrendListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.basic.EQAvailabilityFinderBC;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.basic.EQAvailabilityFinderBCImpl;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0034Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0039Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0046Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0047Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0048Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0049Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0050Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0051Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0052Event;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailDetailListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailRepoListVO;
import com.hanjin.apps.alps.ees.lse.lsecommon.leaseterm.basic.LeaseTermBC;
import com.hanjin.apps.alps.ees.lse.lsecommon.leaseterm.basic.LeaseTermBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MstLseTermVO;

/**
 * ALPS-ContainerSupplyDemandForecast Business Logic ServiceCommand - ALPS-ContainerSupplyDemandForecast 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author kim jong jun
 * @see CNTRInventoryReportDBDAO
 * @since J2EE 1.4
 */

public class ContainerSupplyDemandForecastSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ContainerSupplyDemandForecast system 업무 시나리오 선행작업<br>
	 * EES_CIM_0001업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
		}
	}

	/**
	 * ContainerSupplyDemandForecast system 업무 시나리오 마감작업<br>
	 * EES_CIM_0001 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ContainerSupplyDemandForecastSC End");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ContainerSupplyDemandForecast system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = new GeneralEventResponse();
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesCim0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Inventory
				eventResponse = searchTrendListByInvt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//Period,HEAD,TP/SZ
				eventResponse = searchCommon01List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//Long Staying
				eventResponse = searchTrendListByLongStaying(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	//Period
				eventResponse = searchDefaultMonthWeek(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {	//HEAD
				eventResponse = searchMonthWeekList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {	//TP/SZ
				eventResponse = searchCntrTypeSizeList();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {	//Location 코드 체크
				eventResponse = checkLocation(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EesCim0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Inventory
				eventResponse = searchTotalInvtList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//Period,HEAD,TP/SZ
				eventResponse = searchCommon02List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {	//HEAD
				eventResponse = searchMonthWeekList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {	//TP/SZ
				eventResponse = searchCntrTypeSizeList();
			}
		} else if(e.getEventName().equalsIgnoreCase("EesCim0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Inventory
				InvtSmryVO[]  invtSmryVOs = searchLandInvtListByLoc(e);
				eventResponse.setRsVoArray(invtSmryVOs);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//HEAD,TP/SZ
				eventResponse = searchCommon02List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02) || e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	//By MVMT,Lease Term 조회
				eventResponse = searchLandInvtListByTerm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {	//Location 코드 체크
				eventResponse = checkLocation(e);
			} 
		} else if(e.getEventName().equalsIgnoreCase("EesCim0017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Sea Inventory (by VVD)
				eventResponse = searchSeaInvtListInvt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//HEAD,TP/SZ
				eventResponse = searchCommon02List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//POL-POD Pair 조회
				eventResponse = searchSeaInvtListByPolPod(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	//CNTR LIST 조회
				eventResponse = searchSeaInvtListByCntr(e);
			} 
		} else if(e.getEventName().equalsIgnoreCase("EesCim0018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Container List by Location
				eventResponse = searchCntrListByLoc(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//HEAD,TP/SZ
				eventResponse = searchCommon02List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//Location 코드 체크
				eventResponse = checkLocation(e);
			} 
		} else if(e.getEventName().equalsIgnoreCase("EesCim0034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//EQ Availability
				eventResponse = searchAvailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//HEAD,TP/SZ
				eventResponse = searchCommon02List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//Location 코드 체크
				eventResponse = checkLocation(e);
			}  
		} else if(e.getEventName().equalsIgnoreCase("EesCim0039Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//EQ Availability
				AvailRepoListVO[]  availRepoListVOs = searchAvailRepoList(e);
				eventResponse.setRsVoArray(availRepoListVOs);
			} 
		} else if(e.getEventName().equalsIgnoreCase("EesCim0046Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//BR Detail
				AvailDetailListVO[]  availDetailListVOs = searchAvailBRList(e);
				eventResponse.setRsVoArray(availDetailListVOs);
			} 
		} else if(e.getEventName().equalsIgnoreCase("EesCim0047Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Past BR
				AvailDetailListVO[]  availDetailListVOs = searchAvailPickUpList(e);
				eventResponse.setRsVoArray(availDetailListVOs);
			}
		} else if(e.getEventName().equalsIgnoreCase("EesCim0048Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//OFF Detail
				AvailDetailListVO[]  availDetailListVOs = searchAvailOFFList(e);
				eventResponse.setRsVoArray(availDetailListVOs);
			} 
		} else if(e.getEventName().equalsIgnoreCase("EesCim0049Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//IG Detail
				AvailDetailListVO[]  availDetailListVOs = searchAvailIGList(e);
				eventResponse.setRsVoArray(availDetailListVOs);
			} 
		} else if(e.getEventName().equalsIgnoreCase("EesCim0050Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//RTN Detail
				AvailDetailListVO[]  availDetailListVOs = searchAvailRTNList(e);
				eventResponse.setRsVoArray(availDetailListVOs);
			} 

		} else if(e.getEventName().equalsIgnoreCase("EesCim0051Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//OFF Detail
				AvailDetailListVO[]  availDetailListVOs = searchAvailONList(e);
				eventResponse.setRsVoArray(availDetailListVOs);
			} 
		} else if(e.getEventName().equalsIgnoreCase("EesCim0052Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Past BR
				AvailDetailListVO[]  availDetailListVOs = searchAvailPastBRList(e);
				eventResponse.setRsVoArray(availDetailListVOs);
			} 
		} else if(e.getEventName().equalsIgnoreCase("EesCim0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//구주지역내 장비수급 계획을 감안하여, 금일 기준의 Available 장비 대수를 조회한다.
				eventResponse = searchStockList(e,"0028");
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//TP/SZ
				eventResponse = searchCntrTypeSizeList();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//Location 코드 체크
				eventResponse = checkLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageStock(e,"0028");
			} 
		} else if(e.getEventName().equalsIgnoreCase("EesCim0029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				// 구주지역내 SCC 또는 Yard별 MT 재고를 컨테이너별로 조회한다.(팝업)
				eventResponse = searchStockCntrList(e); 
			}   
		} else if(e.getEventName().equalsIgnoreCase("EesCim0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				// 구주지역내 MTY 컨테이너의 Release/ Redelivery Order 승인리스트를 확인하여, 해당야드에 반입/ 반출되는 컨테이너 정보를 조회한다.(팝업)
				eventResponse = searchStockDueDateList(e);
			}  
		} else if(e.getEventName().equalsIgnoreCase("EesCim0031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				// 구주지역내 MTY 컨테이너의 Release/ Redelivery Order 승인리스트를 확인하여, 해당야드에 반입/ 반출되는 컨테이너 정보를 조회한다.(팝업)
				eventResponse = searchStockList(e,"0031");
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageStock(e,"0031");
			} 
		}  else if(e.getEventName().equalsIgnoreCase("EesCim0073Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Inventory
				eventResponse = searchInvtOptmStkList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//Period,HEAD,TP/SZ
				eventResponse = searchCommon02List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	
				eventResponse = searchYearWk(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {	//TP/SZ
				eventResponse = searchCntrTypeSizeList();
			}
		}
		return eventResponse; 
	}
	/**
	 * EES_CIM_0008 : Retrieve <br>
	 * Land의 CNTR 재고를 Location별로 구분하여 조회<br>
	 * 
	 * @param e 이벤트
	 * @return InvtSmryVO[]
	 * @exception EventException
	 */
	private InvtSmryVO[] searchLandInvtListByLoc(Event e) throws EventException {
		InvtSmryVO[]  invtSmryVOs= null;
		try {
			CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
			EesCim0008Event event = (EesCim0008Event)e;
			invtSmryVOs= command.searchLandInvtListByLoc(event.getInvtOptionVO());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(),de);
		}
		return invtSmryVOs;
	}
	 
	private EventResponse searchCommon01List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCim0001Event event = (EesCim0001Event)e;
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		event.getInvtOptionVO().setOfcCd(account.getOfc_cd());
		
		if ( event.getInvtOptionVO().getOpTrndTpCd().substring(1, 2).equals("M")) {
			event.getInvtOptionVO().setFmDur("3");
			event.getInvtOptionVO().setToDur("1");
		} else if ( event.getInvtOptionVO().getOpTrndTpCd().substring(1, 2).equals("W")) {
			event.getInvtOptionVO().setFmDur("12");
			event.getInvtOptionVO().setToDur("1");
		}
		
		InvtOptionVO invtOptionVO = command.searchDefaultMonthWeek(event.getInvtOptionVO() );
		Map<String,String> etcData = new HashMap<String,String>();
		if(invtOptionVO.getFmPrd() != null ) {
			etcData.put("fm_prd",invtOptionVO.getFmPrd());
			etcData.put("to_prd",invtOptionVO.getToPrd());
		}		
		
		GeneralEventResponse periodEtcData = (GeneralEventResponse)searchDefaultMonthWeek(e);	//period
		etcData.put("period",periodEtcData.getETCData("fm_prd").toString()+"|"+periodEtcData.getETCData("to_prd").toString());

		GeneralEventResponse tpszEtcData = (GeneralEventResponse)searchCntrTypeSizeList();		//TP/SZ
		etcData.put("cntr_tpsz_cd",tpszEtcData.getETCData("cntr_tpsz_cd").toString());
		
		if ( event.getInvtOptionVO().getFromBseDt().equals("") ) {
			event.getInvtOptionVO().setFromBseDt(periodEtcData.getETCData("fm_prd").toString());
		}
		if ( event.getInvtOptionVO().getToBseDt().equals("") ) {
			event.getInvtOptionVO().setToBseDt(periodEtcData.getETCData("to_prd").toString());
		}
		GeneralEventResponse headEtcData = (GeneralEventResponse)searchMonthWeekList(e);		//HEAD
		etcData.put("bse_dt",headEtcData.getETCData("bse_dt").toString());

		eventResponse.setETCData(etcData);
		return eventResponse;
	}		
	
	/**
	 * 각화면 공통 lease_term,TP/SZ 조회<br>
	 * 각화면 공통 lease_term,TP/SZ  정보 조회<br>
	 * 
	 * @param e 이벤트
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommon02List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		List<InvtCodeCommonVO> invtCodeCommonVO = command.searchCntrTypeSizeList( );
		StringBuilder sb = new StringBuilder();
		if(invtCodeCommonVO.size() > 0) {
			for(int i = 0 ; i < invtCodeCommonVO.size()-1 ; i++){
				sb.append(invtCodeCommonVO.get(i).getCntrTpszCd());
				sb.append("|");
			}
			sb.append(invtCodeCommonVO.get(invtCodeCommonVO.size()-1).getCntrTpszCd());
		} 

		Map<String,String> etcData = new HashMap<String,String>();
		 
		etcData.put("cntr_tpsz_cd",sb.toString());		
		
		//Lease Term Combo Object Item
		LeaseTermBC leaseCommand = new LeaseTermBCImpl();
		List<MstLseTermVO> leaseTermList = leaseCommand.searchLeaseTermComboItemBasic();
		StringBuffer sLeaseTermNm = new StringBuffer();
		StringBuffer sLeaseTermCd = new StringBuffer();

		for ( int i = 0 ; i < leaseTermList.size() ; i++ ) {
			if ( sLeaseTermNm.toString().equals("") ) {
				sLeaseTermNm.append(leaseTermList.get(i).getLstmCd());
				sLeaseTermCd.append(leaseTermList.get(i).getLstmCd());
			} else {
				sLeaseTermNm.append("|").append(leaseTermList.get(i).getLstmCd());
				sLeaseTermCd.append("|").append(leaseTermList.get(i).getLstmCd());
			}
		}

		etcData.put("lease_term_nm", sLeaseTermNm.toString());
		etcData.put("lease_term_cd", sLeaseTermCd.toString());

		eventResponse.setETCData(etcData);
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0001 : Retrieve <br>
	 * 지역기준의 CNTR 재고관리 운영지표인 Inventory Trend 조회  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrendListByInvt(Event e) throws EventException {
		EesCim0001Event event = (EesCim0001Event)e;
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		List<TrendListVO> list = command.searchTrendListByInvt(event.getInvtOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	/**
	 * 화면공통Period 조회 이벤트 처리<br>
	 * 현재일을 기준으로 주차와,년월을 구해 주어진 기간의 주차와,년월을 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDefaultMonthWeek(Event e) throws EventException {
		EesCim0001Event event = (EesCim0001Event)e;
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		event.getInvtOptionVO().setOfcCd(account.getOfc_cd());
		
		if ( event.getInvtOptionVO().getOpTrndTpCd().substring(1, 2).equals("M")) {
			event.getInvtOptionVO().setFmDur("3");
			event.getInvtOptionVO().setToDur("1");
		} else if ( event.getInvtOptionVO().getOpTrndTpCd().substring(1, 2).equals("W")) {
			event.getInvtOptionVO().setFmDur("12");
			event.getInvtOptionVO().setToDur("1");
		}
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvtOptionVO invtOptionVO = command.searchDefaultMonthWeek(event.getInvtOptionVO() );
		if(invtOptionVO.getFmPrd() != null ) {
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("fm_prd",invtOptionVO.getFmPrd());
			etcData.put("to_prd",invtOptionVO.getToPrd());
			eventResponse.setETCData(etcData);
		}
		return eventResponse;		
	}	

	/**
	 * EES_CIM_0001 : 달,주헤더 Retrieve <br>
	 * 주어진 기간의 주차와,년월 목록을 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthWeekList(Event e) throws EventException {
		EesCim0001Event event = (EesCim0001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		
		event.getInvtOptionVO().setOfcCd(account.getOfc_cd());

		List<TrendListVO> trendListVOS = command.searchMonthWeekList(event.getInvtOptionVO() );
		String totBaseDt = "";
		if(trendListVOS.size() > 0) {
			for ( int i=0; i<trendListVOS.size(); i++) {
				if ( i == trendListVOS.size()-1) {
					totBaseDt = totBaseDt+trendListVOS.get(i).getBseDt().substring(0, 4)+"-"+trendListVOS.get(i).getBseDt().substring(4, 6);
				} else {
					totBaseDt = totBaseDt+trendListVOS.get(i).getBseDt().substring(0, 4)+"-"+trendListVOS.get(i).getBseDt().substring(4, 6)+"|";
				}
			}
		}
		Map<String,String> etcData = new HashMap<String,String>();
		
		etcData.put("bse_dt",totBaseDt);
		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}
	/**
	 * 컨테이너 TYPE/SIZE 목록을 조회 Retrieve<br>
	 * 컨테이너 TYPE/SIZE 목록을 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrTypeSizeList() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		List<InvtCodeCommonVO> invtCodeCommonVO = command.searchCntrTypeSizeList( );
		StringBuilder sb = new StringBuilder();
		if(invtCodeCommonVO.size() > 0) {
			for(int i = 0 ; i < invtCodeCommonVO.size()-1 ; i++){
				sb.append(invtCodeCommonVO.get(i).getCntrTpszCd());
				sb.append("|");
			}
			sb.append(invtCodeCommonVO.get(invtCodeCommonVO.size()-1).getCntrTpszCd());
		}

		Map<String,String> etcData = new HashMap<String,String>();
		
		etcData.put("cntr_tpsz_cd",sb.toString());
		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}

	/**
	 * EES_CIM_0001 : Long Staying Retrieve<br>
	 * 지역별,EQ TY/SZ 별 Long Staying Ratio를 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrendListByLongStaying(Event e) throws EventException {
		EesCim0001Event event = (EesCim0001Event)e;
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		List<TrendListVO> list = command.searchTrendListByLongStaying(event.getInvtOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * EES_CIM_0002 : Retrieve<br>
	 * Land 및 Sea 구간의 Full & MTY CNTR 재고를 Lease Term으로 구분하여 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTotalInvtList(Event e) throws EventException {
		EesCim0002Event event = (EesCim0002Event)e;
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		List<InvtSmryVO> list = command.searchTotalInvtList(event.getInvtOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0073 : Retrieve<br>
	 * Land Inventory with Optimum Stock 화면에서 Location 별로 구분하여 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvtOptmStkList(Event e) throws EventException {
		EesCim0073Event event = (EesCim0073Event)e;
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		List<InvtSmryVO> list = command.searchInvtOptmStkList(event.getInvtOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * batch week, this week 조회<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYearWk(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		List<InvtOptionVO> invtOptionVO = command.searchYearWk();

		String thsWk = "";
		String preBatWk = "";
		String nxtBatWk = "";
		String batWk = "";
		String batFlg = "N";
		
		if(invtOptionVO.size() > 0) {
			for(int i = 0 ; i < invtOptionVO.size() ; i++){
				String wkFlg = "";
				String yrwk = "";
				
				wkFlg = invtOptionVO.get(i).getWkFlg();
				yrwk = invtOptionVO.get(i).getYrwk();
				
				if("T".equals(wkFlg)){
					thsWk = yrwk; 
				}else if("B".equals(wkFlg)){
					batWk = yrwk;
				}else if("PB".equals(wkFlg)){
					preBatWk = yrwk;
				}else{
					nxtBatWk = yrwk; 
				}
			}
		}
		
		if(thsWk.equals(batWk)){
			 batFlg = "Y";
		}
		
		if(thsWk.equals(nxtBatWk)){
			 batFlg = "Y";
		}

		Map<String,String> etcData = new HashMap<String,String>();
		 
		etcData.put("bat_flg",  batFlg);		
		etcData.put("ths_wk", thsWk);
		etcData.put("pre_bat_wk", preBatWk);

		eventResponse.setETCData(etcData);
		return eventResponse;
	}	

	/**
	 * EES_CIM_0008 : Retrieve<br>
	 * Land의 CNTR 재고를 Lease Term,Movement Status 별로 구분하여 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLandInvtListByTerm(Event e) throws EventException {
		EesCim0008Event event = (EesCim0008Event)e;
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		List<InvtSmryVO> list = command.searchLandInvtListByTerm(event.getInvtOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * EES_CIM_0017 : Retrieve<br>
	 * 조회시점 기준, 해상에 VVD별로 소재하고 있는 컨테이너의 Lease Term 별,Style(FL/MTY) 수량 조회<br> 
	 * 
	 * @param e 이벤트
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSeaInvtListInvt(Event e) throws EventException {
		EesCim0017Event event = (EesCim0017Event)e;
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		List<InvtSmryVO> list = command.searchSeaInvtListInvt(event.getInvtOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0017 : Retrieve<br>
	 * 조회시점 기준, 해상에 VVD별로 소재하고 있는 컨테이너의 POL/POD 별 수량 조회<br> 
	 * 
	 * @param e 이벤트
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSeaInvtListByPolPod(Event e) throws EventException {
		EesCim0017Event event = (EesCim0017Event)e;
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		List<InvtSmryVO> list = command.searchSeaInvtListByPolPod(event.getInvtOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * EES_CIM_0017 : Retrieve<br>
	 * 조회시점 기준, 해상에 VVD별로 소재하고 있는 컨테이너 번호,관련 Booking 및 장비관리 정보 조회<br> 
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSeaInvtListByCntr(Event e) throws EventException {
		EesCim0017Event event = (EesCim0017Event)e;
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		List<InvtCntrListVO> list = command.searchSeaInvtListByCntr(event.getInvtOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0018 : Retrieve<br>
	 * 조회시점 기준, 지역별로 소재하고 있는 컨테이너 넘버 및 관련 Booking 및 장비관리 정보를 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrListByLoc(Event e) throws EventException {
		EesCim0018Event event = (EesCim0018Event)e;
		
		event.getInvtOptionVO().setOfcCd(account.getOfc_cd());

		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		List<InvtCntrListVO> list = command.searchCntrListByLoc(event.getInvtOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * EES_CIM_0034 : Retrieve<br>
	 * 조회일로부터 2Week 기간의 가용 MTY 수량을 Yard, Daily별로 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAvailList(Event e) throws EventException {
		EesCim0034Event event = (EesCim0034Event)e;
		EQAvailabilityFinderBC command = new EQAvailabilityFinderBCImpl();
		List<AvailListVO> list = command.searchAvailList(event.getAvailOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	/**
	 * EES_CIM_0039 : Retrieve<br>
	 * EQR의 MTY BKG정보 및 Inland 구간의 MTY 이송계획을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return availRepoListVOs AvailRepoListVO[] 
	 * @exception EventException
	 */
	private AvailRepoListVO[] searchAvailRepoList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		AvailRepoListVO[]  availRepoListVOs= null;
		EQAvailabilityFinderBC command = new EQAvailabilityFinderBCImpl();
		EesCim0039Event event = (EesCim0039Event)e;
		availRepoListVOs= command.searchAvailRepoList(event.getAvailOptionVO());
		return availRepoListVOs;		
		
	}	
	
	/**
	 * EES_CIM_0052 : Retrieve<br>
	 * 예정 MTY Pick-up 일자가 지난 BR(Booking 정보)를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return availDetailListVOs AvailDetailListVO[] 
	 * @exception EventException
	 */
	private AvailDetailListVO[] searchAvailPastBRList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		AvailDetailListVO[]  availDetailListVOs= null;
		EQAvailabilityFinderBC command = new EQAvailabilityFinderBCImpl();
		EesCim0052Event event = (EesCim0052Event)e;
		availDetailListVOs= command.searchAvailPastBRList(event.getAvailOptionVO());
		return availDetailListVOs;		
		
	}
	 
	/**
	 * EES_CIM_0046 : Retrieve<br>
	 * BR(Booking Reserved)의 Detail한 BKG 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return availDetailListVOs AvailDetailListVO[] 
	 * @exception EventException
	 */
	private AvailDetailListVO[] searchAvailBRList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		AvailDetailListVO[]  availDetailListVOs= null;
		EQAvailabilityFinderBC command = new EQAvailabilityFinderBCImpl();
		EesCim0046Event event = (EesCim0046Event)e;
		availDetailListVOs= command.searchAvailBRList(event.getAvailOptionVO());
		return availDetailListVOs;		
		
	}
	 
	/**
	 * EES_CIM_0047 : Retrieve<br>
	 * 금일 Pick-up된(PUP, Picked Up) 컨테이너 수량을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return availDetailListVOs AvailDetailListVO[] 
	 * @exception EventException
	 */
	private AvailDetailListVO[] searchAvailPickUpList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		AvailDetailListVO[]  availDetailListVOs= null;
		EQAvailabilityFinderBC command = new EQAvailabilityFinderBCImpl();
		EesCim0047Event event = (EesCim0047Event)e;
		availDetailListVOs= command.searchAvailPickUpList(event.getAvailOptionVO());
		return availDetailListVOs;		
		
	}

	/**
	 * EES_CIM_0049 : Retrieve<br>
	 * IG(I/B MTY Generation) 예측수량을 Detail하게 조회.<br>
	 * 
	 * @param e Event
	 * @return availDetailListVOs AvailDetailListVO[] 
	 * @exception EventException
	 */
	private AvailDetailListVO[] searchAvailIGList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		AvailDetailListVO[]  availDetailListVOs= null;
		EQAvailabilityFinderBC command = new EQAvailabilityFinderBCImpl();
		EesCim0049Event event = (EesCim0049Event)e;
		availDetailListVOs= command.searchAvailIGList(event.getAvailOptionVO());
		return availDetailListVOs;		
		
	}
	
	/**
	 * EES_CIM_0050 : Retrieve<br>
	 * 금일 MTY Returned 컨테이너 수량을 확인하는 화면.<br>
	 * 
	 * @param e Event
	 * @return availDetailListVOs AvailDetailListVO[] 
	 * @exception EventException
	 */
	private AvailDetailListVO[] searchAvailRTNList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		AvailDetailListVO[]  availDetailListVOs= null;
		EQAvailabilityFinderBC command = new EQAvailabilityFinderBCImpl();
		EesCim0050Event event = (EesCim0050Event)e;
		availDetailListVOs= command.searchAvailRTNList(event.getAvailOptionVO());
		return availDetailListVOs;		
		
	}

	/**
	 * EES_CIM_0048 : Retrieve<br>
	 * Off-hire 계획 및 실적(조회당일)의 Detail 정보를 확인.<br>
	 * 
	 * @param e Event
	 * @return availDetailListVOs AvailDetailListVO[] 
	 * @exception EventException
	 */
	private AvailDetailListVO[] searchAvailOFFList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		AvailDetailListVO[]  availDetailListVOs= null;
		EQAvailabilityFinderBC command = new EQAvailabilityFinderBCImpl();
		EesCim0048Event event = (EesCim0048Event)e;
		availDetailListVOs= command.searchAvailOFFList(event.getAvailOptionVO());
		return availDetailListVOs;		
		
	}
	
	/**
	 * EES_CIM_0051 : Retrieve<br>
	 * Off-hire 계획 및 실적(조회당일)의 Detail 정보를 확인.<br>
	 * 
	 * @param e Event
	 * @return availDetailListVOs AvailDetailListVO[] 
	 * @exception EventException
	 */
	private AvailDetailListVO[] searchAvailONList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		AvailDetailListVO[]  availDetailListVOs= null;
		EQAvailabilityFinderBC command = new EQAvailabilityFinderBCImpl();
		EesCim0051Event event = (EesCim0051Event)e;
		availDetailListVOs= command.searchAvailONList(event.getAvailOptionVO());
		return availDetailListVOs;		
		
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
	 * EES_CIM_0028 : Retrieve <br>
	 * 구주지역내 장비수급 계획을 감안하여, 금일 기준의 Available 장비 대수를 조회한다.  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStockList(Event e,String searchFlag) throws EventException {
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		List<StockSmryVO> list = null;
		if ( searchFlag.equals("0028") ) {
			EesCim0028Event event1 = (EesCim0028Event)e;
			event1.getInvtOptionVO().setFmStkJbDt(event1.getInvtOptionVO().getFmStkJbDt().replace("-", ""));
			event1.getInvtOptionVO().setToStkJbDt(event1.getInvtOptionVO().getToStkJbDt().replace("-", ""));
			list = command.searchStockList(event1.getInvtOptionVO());
		} else if ( searchFlag.equals("0031") ) {
			EesCim0031Event event2 = (EesCim0031Event)e;
			event2.getInvtOptionVO().setFmStkJbDt(event2.getInvtOptionVO().getFmStkJbDt().replace("-", ""));
			event2.getInvtOptionVO().setToStkJbDt(event2.getInvtOptionVO().getToStkJbDt().replace("-", ""));
			list = command.searchStockList(event2.getInvtOptionVO());
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0028 : [이벤트]<br>
	 * 구주지역의 특정 LCC/ECC Level 내의 가용 MTY 재고를 Yard별로 생성,수정<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageStock(Event e,String searchFlag) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		EesCim0028Event event1 = new EesCim0028Event();
		EesCim0031Event event2 = new EesCim0031Event();
		if ( searchFlag.equals("0028") ) {
			event1 = (EesCim0028Event)e;
		} else if ( searchFlag.equals("0031") ) {
			event2 = (EesCim0031Event)e;
		}
		
		try{
			begin();
			if ( searchFlag.equals("0028") ) {
				command.manageStock(event1.getStockSmryVOS(),account);
				eventResponse.setUserMessage(new ErrorHandler("CIM00003").getUserMessage());
			} else if ( searchFlag.equals("0031") ) {
				command.manageStock(event2.getStockSmryVOS(),account);
			}
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0029 : Retrieve <br>
	 * 구주지역내 SCC 또는 Yard별 MT 재고를 컨테이너별로 조회한다.(팝업)
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStockCntrList(Event e) throws EventException {
		EesCim0029Event event = (EesCim0029Event)e;
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		event.getInvtOptionVO().setFmStkJbDt(event.getInvtOptionVO().getFmStkJbDt().replace("-", ""));
		event.getInvtOptionVO().setToStkJbDt(event.getInvtOptionVO().getToStkJbDt().replace("-", ""));
		List<StockByCntrListVO> list = command.searchStockCntrList(event.getInvtOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}	

	/**
	 * EES_CIM_0030 : Retrieve <br>
	 * 구주지역내 MTY 컨테이너의 Release/ Redelivery Order 승인리스트를 확인하여, 해당야드에 반입/ 반출되는 컨테이너 정보를 조회한다.(팝업)
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStockDueDateList(Event e) throws EventException {
		EesCim0030Event event = (EesCim0030Event)e;
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		event.getInvtOptionVO().setFmStkJbDt(event.getInvtOptionVO().getFmStkJbDt().replace("-", ""));
		event.getInvtOptionVO().setToStkJbDt(event.getInvtOptionVO().getToStkJbDt().replace("-", ""));
		List<StockByCntrListVO> list = command.searchStockDueDateList(event.getInvtOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
}