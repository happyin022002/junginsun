/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTYEquipmentForecastSC.java
*@FileTitle : MTY Balance Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.mtyequipmentforecast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.basic.CIMCommonBC;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.basic.CIMCommonBCImpl;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.basic.MTYEquipmentForecastBC;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.basic.MTYEquipmentForecastBCImpl;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event.EesEqr5001Event;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event.EesEqr5002Event;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event.EesEqr5003Event;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event.EesEqr5004Event;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event.EesEqr5005Event;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration.MTYEquipmentForecastDBDAO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.ForecastAccuracyListVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalRptOtrVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceCommonListVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceListVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceReferenceListVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceRepoListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * -MTYEquipmentForecast Business Logic ServiceCommand
 * 
 * @author 
 * @see MTYEquipmentForecastDBDAO
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario MTYEquipmentForecast system <br>
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("MTYEquipmentForecastSC start");
		try {

			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * biz scenario closing MTYEquipmentForecast system<br>
	 */
	public void doEnd() {
		log.debug("MTYEquipmentForecastSC end");
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
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//checking Location code
				eventResponse = checkLocation(e);
			}
		}
		return eventResponse;
	}
	/**
	 * EES_CIM_5001 : []<br>
	 * retrieving for  MTY Balance Data .<br>
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
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String,String> etcData = new HashMap<String,String>();
		if ( list.size() != 35 ) {	// IndexOutOfBoundsException 방지
			etcData.put("yyyyMm","|");
		} else {
			etcData.put("yyyyMm",JSPUtil.getNull(list.get(15).getFcastYrwk0())+"|"+JSPUtil.getNull(list.get(28).getFcastYrwk0()));
		}
		eventResponse.setETCData(etcData);
		
		eventResponse.setRsVoList(list);
		return eventResponse;		
	}

	
	/**
	 * EES_CIM_5001 : []<br>
	 * retrieving for MTY Balance reference Data <br>
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
	 * EES_CIM_5001 : []<br>
	 * saving MTY Balace data<br>
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
	 * EES_CIM_5004 : []<br>
	 * retrieving for yard date in the ecc<br>
	 * 
	 * @param e 
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
	 * EES_CIM_5001 : []<br>
	 * retrieving for yard in the ECC<br>
	 * 
	 * @param e 
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardList(Event e) throws EventException {
		String eccCd  = (String)e.getAttribute("loc_cd");
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		List<MtyBalanceCommonListVO> mtyBalanceCommonListVO = command.searchYardList( eccCd );
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
	 * EES_CIM_5004 : []<br>
	 * retrieving for the date by week<br>
	 * 
	 * @param e 
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
	 * EES_CIM_5003,EES_CIM_5004 : []<br>
	 * retrieving for EQ Demand & Supply<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyBalanceOtherList(Event e,String searchFlag) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		List<MtyBalRptOtrVO> list = null;
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
		if(list != null) {
			eventResponse.setRsVoList(list);
		}
		return eventResponse;		
	}
	
	/**
	 * EES_CIM_5003,EES_CIM_5004 : []<br>
	 * saving for EQ Demand & Supply<br>
	 * 
	 * @param Event e
	 * @param String searchFlag
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse manageMtyBalanceOther(Event e,String searchFlag) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr5004Event event1 = null;
		EesEqr5003Event event2 = null;
		if ( searchFlag.equals("5004") ) {
			event1 = (EesEqr5004Event)e;
		} else if ( searchFlag.equals("5003") ) {
			event2 = (EesEqr5003Event)e;
		}
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		try{
			begin();
			if ( searchFlag.equals("5004") ) {
				if(event1 != null) {
					command.manageMtyBalanceOther(event1.getMtyBalRptOtrVOS(),account);
				}
			} else if ( searchFlag.equals("5003") ) {
				if(event2 != null) {
					command.manageMtyBalanceOther(event2.getMtyBalRptOtrVOS(),account);
				}
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
	 * EES_CIM_5002 : []<br>
	 *  retrieving for MTY balace plan <br>
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
		return eventResponse;		
	}

	/**
	 * EES_CIM_5005 : []<br>
	 *  retrieving for In&Out Bound FCST Data by week<br>
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

		List<ForecastAccuracyListVO> list = command.searcForecastAccuracyList(event.getForecastAccuracyOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;		
	}
	
	/**
	 * checking Location <br>
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
}