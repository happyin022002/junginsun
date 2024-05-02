/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSupplyDemandForecastSC.java
*@FileTitle : EQ Operation Trend (Inventory Trend)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.basic.CIMCommonBC;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.basic.CIMCommonBCImpl;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.basic.CNTRInventoryReportBC;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.basic.CNTRInventoryReportBCImpl;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0001Event;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0002Event;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0008Event;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0017Event;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0018Event;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0028Event;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0029Event;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0030Event;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0031Event;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration.CNTRInventoryReportDBDAO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCntrListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCodeCommonVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtSmryVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.StockByCntrListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.StockSmryVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.TrendListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.basic.EQAvailabilityFinderBC;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.basic.EQAvailabilityFinderBCImpl;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0034Event;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0039Event;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0046Event;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0047Event;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0048Event;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0049Event;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0050Event;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0051Event;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0052Event;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailDetailListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailRepoListVO;
import com.clt.apps.opus.ees.lse.lsecommon.leaseterm.basic.LeaseTermBC;
import com.clt.apps.opus.ees.lse.lsecommon.leaseterm.basic.LeaseTermBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MstLseTermVO;


/**
 * ContainerSupplyDemandForecast Business Logic ServiceCommand 
 * handling business transaction for ContainerSupplyDemandForecast
 * 
 * @author
 * @see CNTRInventoryReportDBDAO
 * @since J2EE 1.4
 */

public class ContainerSupplyDemandForecastSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding business scenario process for ContainerSupplyDemandForecast system 
	 * creating Object when calling EES_CIM_0001 business scenario
	 */
	public void doStart() {
		try {
			// checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
		}
	}

	/**
	 * closing ContainerSupplyDemandForecast system business scenario
	 */
	public void doEnd() {
		log.debug("ContainerSupplyDemandForecastSC End");
	}

	/**
	 * processing business scenario for event
	 * handling event for ContainerSupplyDemandForecast system 
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = new GeneralEventResponse();
		// in case SC handle multiple events 
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
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {	//checking Location code
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
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {	//checking Location code
				eventResponse = checkLocation(e);
			} 
		} else if(e.getEventName().equalsIgnoreCase("EesCim0017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Sea Inventory (by VVD)
				eventResponse = searchSeaInvtListInvt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//HEAD,TP/SZ
				eventResponse = searchCommon02List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//retrieving POL-POD Pair
				eventResponse = searchSeaInvtListByPolPod(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	//retrieving CNTR LIST
				eventResponse = searchSeaInvtListByCntr(e);
			} 
		} else if(e.getEventName().equalsIgnoreCase("EesCim0018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Container List by Location
				eventResponse = searchCntrListByLoc(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//HEAD,TP/SZ
				eventResponse = searchCommon02List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//checking Location code
				eventResponse = checkLocation(e);
			} 
		} else if(e.getEventName().equalsIgnoreCase("EesCim0034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//EQ Availability
				eventResponse = searchAvailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//HEAD,TP/SZ
				eventResponse = searchCommon02List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//checking Location code
				eventResponse = checkLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	//EQ TP LIST
				eventResponse = searchAvailTpSzList(e);
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
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//retrieving Today's available EQ quantity with Europe region EQ management plan
				eventResponse = searchStockList(e,"0028");
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//TP/SZ
				eventResponse = searchCntrTypeSizeList();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//checking Location code
				eventResponse = checkLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageStock(e,"0028");
			} 
		} else if(e.getEventName().equalsIgnoreCase("EesCim0029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//retrieving MT inventory by SCC, Yard and container type/size in Europe region
				eventResponse = searchStockCntrList(e); 
			}   
		} else if(e.getEventName().equalsIgnoreCase("EesCim0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//retrieving In/Out container information in yard by checking MTY container Release/Redelivery Order approval list in Europe region (pop up)
				eventResponse = searchStockDueDateList(e);
			}  
		} else if(e.getEventName().equalsIgnoreCase("EesCim0031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//retrieving In/Out container information in yard by checking MTY container Release/Redelivery Order approval list in Europe region (pop up)
				eventResponse = searchStockList(e,"0031");
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageStock(e,"0031");
			} 
		} 
		return eventResponse; 
	}
	/**
	 * EES_CIM_0008 : Retrieve <br>
	 * retrieving Land container inventory by Location
	 * 
	 * @param e event
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
	 * retrieving lease term, Tp/SZ 
	 * 
	 * @param e event
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
	 * retrieving Inventory Trend as regional container inventory management
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
	 * handling retrieve event for Period
	 * retrieving week, year, month for Today
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
	 * EES_CIM_0001 : retrieving month, week
	 * retrieving week, year, month list for inputed period
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
	 * retrieving container TYPE/SIZE list
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
	 * EES_CIM_0001 : Long Staying Retrieve
	 * retrieving Long Staying Ratio by region,EQ TY/SZ 
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
	 * retrieving Full & MTY CNTR inventory for Land & Sea route by Lease Term
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
	 * EES_CIM_0008 : Retrieve
	 * retrieving Land CNTR inventory by Lease Term, Movement Status
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
	 * retrieving container quantity in VVD by Lease Term & Style(FL/MTY)
	 * 
	 * @param e Event
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
	 * retrieving container quantity in VVD by POL/POD
	 * 
	 * @param e Event
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
	 * retrieving container no, related booking and EQ management information by VVD
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSeaInvtListByCntr(Event e) throws EventException {
		EesCim0017Event event = (EesCim0017Event)e;
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		int rtvTotal = command.searchSeaInvtTotalByCntr(event.getInvtOptionVO());
		eventResponse.setETCData("rtv_total", String.valueOf(rtvTotal));
		
		List<InvtCntrListVO> list = command.searchSeaInvtListByCntr(event.getInvtOptionVO());
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0018 : Retrieve<br>
	 * retrieving container no, related booking and EQ management information by region
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrListByLoc(Event e) throws EventException {
		EesCim0018Event event = (EesCim0018Event)e;
		
		event.getInvtOptionVO().setOfcCd(account.getOfc_cd());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		
		int rtvTotal = command.searchCntrTotalCntByLoc(event.getInvtOptionVO());
		eventResponse.setETCData("rtv_total", String.valueOf(rtvTotal));
		
		List<InvtCntrListVO> list = command.searchCntrListByLoc(event.getInvtOptionVO());
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * EES_CIM_0034 : Retrieve<br>
	 * retrieving available MTY quantity for next 2 week form search date by yard daily
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
	 * EES_CIM_0034 : Retrieve<br>
	 * retrieving available MTY quantity for next 2 week form search date by yard daily
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAvailTpSzList(Event e) throws EventException {
		EesCim0034Event event = (EesCim0034Event)e;
		EQAvailabilityFinderBC command = new EQAvailabilityFinderBCImpl();
		List<AvailListVO> list = command.searchAvailTpSzList(event.getAvailOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0039 : Retrieve<br>
	 * retrieving MTY transfer plan for Inland route and EQR MTY booking information
	 * 
	 * @param e Event
	 * @return availRepoListVOs AvailRepoListVO[] 
	 * @exception EventException
	 */
	private AvailRepoListVO[] searchAvailRepoList(Event e) throws EventException {
		
		AvailRepoListVO[]  availRepoListVOs= null;
		EQAvailabilityFinderBC command = new EQAvailabilityFinderBCImpl();
		EesCim0039Event event = (EesCim0039Event)e;
		availRepoListVOs= command.searchAvailRepoList(event.getAvailOptionVO());
		return availRepoListVOs;		
		
	}	
	
	/**
	 * EES_CIM_0052 : Retrieve<br>
	 * retrieving late BR(Booking information) for expected MTY Pick-up date
	 * 
	 * @param e Event
	 * @return availDetailListVOs AvailDetailListVO[] 
	 * @exception EventException
	 */
	private AvailDetailListVO[] searchAvailPastBRList(Event e) throws EventException {
		
		AvailDetailListVO[]  availDetailListVOs= null;
		EQAvailabilityFinderBC command = new EQAvailabilityFinderBCImpl();
		EesCim0052Event event = (EesCim0052Event)e;
		availDetailListVOs= command.searchAvailPastBRList(event.getAvailOptionVO());
		return availDetailListVOs;		
		
	}
	 
	/**
	 * EES_CIM_0046 : Retrieve<br>
	 * retrieving booking details for BR(Booking Reserved)
	 * 
	 * @param e Event
	 * @return availDetailListVOs AvailDetailListVO[] 
	 * @exception EventException
	 */
	private AvailDetailListVO[] searchAvailBRList(Event e) throws EventException {
		
		AvailDetailListVO[]  availDetailListVOs= null;
		EQAvailabilityFinderBC command = new EQAvailabilityFinderBCImpl();
		EesCim0046Event event = (EesCim0046Event)e;
		availDetailListVOs= command.searchAvailBRList(event.getAvailOptionVO());
		return availDetailListVOs;		
		
	}
	 
	/**
	 * EES_CIM_0047 : Retrieve<br>
	 * retrieving Today's container Pick-up quantity 
	 * 
	 * @param e Event
	 * @return availDetailListVOs AvailDetailListVO[] 
	 * @exception EventException
	 */
	private AvailDetailListVO[] searchAvailPickUpList(Event e) throws EventException {
		
		AvailDetailListVO[]  availDetailListVOs= null;
		EQAvailabilityFinderBC command = new EQAvailabilityFinderBCImpl();
		EesCim0047Event event = (EesCim0047Event)e;
		availDetailListVOs= command.searchAvailPickUpList(event.getAvailOptionVO());
		return availDetailListVOs;		
		
	}

	/**
	 * EES_CIM_0049 : Retrieve<br>
	 * retrieving expected IG(I/B MTY Generation) details
	 * 
	 * @param e Event
	 * @return availDetailListVOs AvailDetailListVO[] 
	 * @exception EventException
	 */
	private AvailDetailListVO[] searchAvailIGList(Event e) throws EventException {
		
		AvailDetailListVO[]  availDetailListVOs= null;
		EQAvailabilityFinderBC command = new EQAvailabilityFinderBCImpl();
		EesCim0049Event event = (EesCim0049Event)e;
		availDetailListVOs= command.searchAvailIGList(event.getAvailOptionVO());
		return availDetailListVOs;		
		
	}
	
	/**
	 * EES_CIM_0050 : Retrieve<br>
	 * retrieving MTY Returned container quantity
	 * 
	 * @param e Event
	 * @return availDetailListVOs AvailDetailListVO[] 
	 * @exception EventException
	 */
	private AvailDetailListVO[] searchAvailRTNList(Event e) throws EventException {
		
		AvailDetailListVO[]  availDetailListVOs= null;
		EQAvailabilityFinderBC command = new EQAvailabilityFinderBCImpl();
		EesCim0050Event event = (EesCim0050Event)e;
		availDetailListVOs= command.searchAvailRTNList(event.getAvailOptionVO());
		return availDetailListVOs;		
		
	}

	/**
	 * EES_CIM_0048 : Retrieve<br>
	 * retrieving Off-hire plan and performance details for search date
	 * 
	 * @param e Event
	 * @return availDetailListVOs AvailDetailListVO[] 
	 * @exception EventException
	 */
	private AvailDetailListVO[] searchAvailOFFList(Event e) throws EventException {
		
		AvailDetailListVO[]  availDetailListVOs= null;
		EQAvailabilityFinderBC command = new EQAvailabilityFinderBCImpl();
		EesCim0048Event event = (EesCim0048Event)e;
		availDetailListVOs= command.searchAvailOFFList(event.getAvailOptionVO());
		return availDetailListVOs;		
		
	}
	
	/**
	 * EES_CIM_0051 : Retrieve<br>
	 * retrieving Off-hire plan and performance details for search date
	 * 
	 * @param e Event
	 * @return availDetailListVOs AvailDetailListVO[] 
	 * @exception EventException
	 */
	private AvailDetailListVO[] searchAvailONList(Event e) throws EventException {
		
		AvailDetailListVO[]  availDetailListVOs= null;
		EQAvailabilityFinderBC command = new EQAvailabilityFinderBCImpl();
		EesCim0051Event event = (EesCim0051Event)e;
		availDetailListVOs= command.searchAvailONList(event.getAvailOptionVO());
		return availDetailListVOs;		
		
	}
	
	/**
	 * checking Location event
	 * Location check validate
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
	 * EES_CIM_0028 : Retrieve 
	 * retrieving Today's available EQ quantity with EQ management plan in Europe
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
		if(list != null) {
			eventResponse.setRsVoList(list);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0028 
	 * creating and modifying available MTY inventory for special LCC/ECC in Europe
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
	 * retrieving MT inventory by container type, SCC, yard in Europe
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
	 * retrieving In/Out container information in yard by checking MTY container Release/Redelivery Order approval list in Europe region (pop up)
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