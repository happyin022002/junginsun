/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTMasterDataMgtSC.java
*@FileTitle : Holiday by Country Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.04.27 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBC;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBCImpl;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.OfficeNameVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic.SCExceptionTariffMgtBC;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic.SCExceptionTariffMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.basic.DemDetTariffMgtBC;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.basic.DemDetTariffMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1001Event;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1002Event;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1003Event;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1004Event;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1005Event;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1006Event;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1101Event;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt4014Event;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt4015Event;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.BasicTariffVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffRegionParamVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffRegionVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.DmtTariffTypeVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffSummaryListVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffSummaryParamVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinentParamVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinentVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffGroupVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffMgtVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffRateVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.ToDmtTariffTypeVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.basic.HolidayMgtBC;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.basic.HolidayMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.event.EesDmt1007Event;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.event.EesDmt1008Event;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.event.EesDmt1009Event;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.integration.HolidayMgtDBDAO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.vo.FirstHolidayVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.vo.HolidayMgtVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.vo.Sb45RulingExceptionVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.vo.SecondHolidayVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * DMTMasterDataMgt Business Logic ServiceCommand - DMTMasterDataMgt handling business transaction
 * 
 * @author SungHoon, Lee
 * @see HolidayMgtDBDAO
 * @since J2EE 1.4
 */

public class DMTMasterDataMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DMTMasterDataMgt system preceding process for biz scenario<br>
	 * EES_DMT_1007 related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * DMTMasterDataMgt system biz scenario closing<br>
	 * EES_DMT_1007 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("DMTMasterDataMgtSC 종료");
	}

	/**
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EesDmt1001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicTariff(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBasicTariffFreeTime(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBasicTariffRate(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = confirmBasicTariff(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = confirmCancelBasicTariff(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeBasicTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchBasicTariffXSL(e);
            }
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt1002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCombinationSet(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTariffCombination(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTariffFreeTime(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchTariffRate(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchUpdateCombinationSet(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createBasicTariff(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyBasicTariff(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = modifyBasicTariffExpire(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt1003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicTariffSummuryList(e);
			}		
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt1004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicTariffDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchBasicTariffDetailList02(e);
            }
		}		
		else if (e.getEventName().equalsIgnoreCase("EesDmt1005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCommodityTariffList(e);
			}		
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyCommodityTariff(e);
			}
		}		
		else if (e.getEventName().equalsIgnoreCase("EesDmt1006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCommodityTariffRegionList(e);
			}		
		}		
		else if (e.getEventName().equalsIgnoreCase("EesDmt1007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageHoliday(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHolidayList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchWeekendTypeByCountry(e);
			}			
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt1008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHolidayCountList(e);
			}		
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchHolidayList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchWeekendTypeByCountry(e);
			}			
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt1101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = copyBasicTariff(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt4014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				
				eventResponse = searchBasicTariff(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBasicTariffFreeTime(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBasicTariffRate(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = confirmBasicTariff(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = confirmCancelBasicTariff(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeBasicTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchBasicTariffXSL(e);
            }
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt4015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicTariffDetailList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchBasicTariffDetailList02(e);
            }		
//		} else if (e.getEventName().equalsIgnoreCase("EesDmt1009Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchSb45RulingExceptionList(e);
//			} if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//				eventResponse = searchSb45RulingExceptionDupCheck(e);
//			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
//				eventResponse = modifySb45RulingException(e);
//			}
		}

		return eventResponse;
	}
	/**
	 * EES_DMT_1007 : Retrieve<br>
	 * Retrieving public holiday Info of registered Country. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHolidayList(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		HolidayMgtBC 			command 		= new HolidayMgtBCImpl();
		HolidayMgtVO 			holidayMgtVO 	= null;
		
		int 					holFstDate 		= 7;	//토요일(기본값)
		int 					holSndDate 		= 1;	//일요일(기본값)
		String 					wkndTpCd 		= "";
		
		if (e instanceof EesDmt1007Event) {
			EesDmt1007Event event = (EesDmt1007Event)e;
			holidayMgtVO = event.getHolidayMgtVO();
		} else if (e instanceof EesDmt1008Event) {
			EesDmt1008Event event = (EesDmt1008Event)e;
			holidayMgtVO = event.getHolidayMgtVO();
		}
		
		try{
		
			List<HolidayMgtVO> list = null;
			if(holidayMgtVO != null) {
				list = command.searchHolidayList(holidayMgtVO);
				
				//[2015.05.28]소스품질 Modify
				if (list != null && list.size() > 0) {
					wkndTpCd = list.get(0).getWkndTpCd();
				} else {
					wkndTpCd = holidayMgtVO.getWkndTpCd();
				}
			}
	
			/*if (list != null && list.size() > 0) {
				wkndTpCd = list.get(0).getWkndTpCd();
			} else {
				wkndTpCd = holidayMgtVO.getWkndTpCd();
			}*/
			
			if ("TF".equals(wkndTpCd)) {
				holFstDate = 5;	//목요일
				holSndDate = 6;	//금요일
			} else if ("FS".equals(wkndTpCd)) {
				holFstDate = 6;	//금요일
				holSndDate = 7;	//토요일			
			}			
		
			String[] 				monthOfYears 		= { "JAN", "FEB", "MAR", "APR",	"MAY", "JUN", "JUL", "AUG",	"SEP", "OCT", "NOV", "DEC" }; 
			
			int 					holYr 				= 0;
			if(holidayMgtVO != null) {
				holYr = Integer.parseInt(holidayMgtVO.getHolYr());
			}
			
			List<String> 			firstHoliday 		= new ArrayList<String>();
			List<String> 			secondHoliday 		= new ArrayList<String>();
			
			List<FirstHolidayVO> 	lstFirstHolidayVO 	= new ArrayList<FirstHolidayVO>();
			List<SecondHolidayVO> 	lstSecondHolidayVO 	= new ArrayList<SecondHolidayVO>();
	
			FirstHolidayVO 			firstHolidayVO 		= null;
			SecondHolidayVO 		secondHolidayVO 	= null;		
			
			Calendar 				fromCal 			= Calendar.getInstance();
			Calendar 				toCal				= Calendar.getInstance();
			
			String 					dayOfMonth 			= null;
			
			fromCal.clear();
			fromCal.set(holYr, 0, 1);
			toCal.clear();
			toCal.set(holYr, 11, 31);
			
			while (!fromCal.after(toCal)) {
				
				dayOfMonth = fromCal.get(Calendar.DAY_OF_MONTH) < 10 
								? "0" + fromCal.get(Calendar.DAY_OF_MONTH) 
								: fromCal.get(Calendar.DAY_OF_MONTH) + "";
								
				if (fromCal.get(Calendar.DAY_OF_WEEK) == holFstDate) {
					firstHoliday.add(dayOfMonth + monthOfYears[fromCal.get(Calendar.MONTH)]);
					fromCal.add(Calendar.DATE, 7);				
				}
				else {
					fromCal.add(Calendar.DATE, 1);
				}
			}
			
			for (int i = 0 ; i < firstHoliday.size() ; i++) {
				firstHolidayVO = new FirstHolidayVO();
				firstHolidayVO.setFirstholiday(firstHoliday.get(i));
				lstFirstHolidayVO.add(firstHolidayVO);
			}
			eventResponse.setRsVoList(lstFirstHolidayVO);
			
			fromCal.clear();
			fromCal.set(holYr, 0, 1);
			toCal.clear();
			toCal.set(holYr, 11, 31);
			
			while (!fromCal.after(toCal)) {
				
				dayOfMonth = fromCal.get(Calendar.DAY_OF_MONTH) < 10 
								? "0" + fromCal.get(Calendar.DAY_OF_MONTH) 
								: fromCal.get(Calendar.DAY_OF_MONTH) + "";
								
				if (fromCal.get(Calendar.DAY_OF_WEEK) == holSndDate) {
					secondHoliday.add(dayOfMonth + monthOfYears[fromCal.get(Calendar.MONTH)]);
					fromCal.add(Calendar.DATE, 7);				
				}
				else {
					fromCal.add(Calendar.DATE, 1);
				}
			}
	
			for (int i = 0 ; i < secondHoliday.size() ; i++) {
				secondHolidayVO = new SecondHolidayVO();
				secondHolidayVO.setSecondholiday(secondHoliday.get(i));
				lstSecondHolidayVO.add(secondHolidayVO);
			}
			eventResponse.setRsVoList(lstSecondHolidayVO);		
			if(list != null ){
				eventResponse.setRsVoList(list);
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_1007 : Retrieve<br>
	 * Retrieving public holiday type by Country. <br>
	 *  
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeekendTypeByCountry(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		HolidayMgtBC 			command 		= new HolidayMgtBCImpl();
		HolidayMgtVO 			holidayMgtVO 	= null;
		String 					wkndTpCd 		= null;
		
		if (e instanceof EesDmt1007Event) {
			holidayMgtVO 	= ((EesDmt1007Event)e).getHolidayMgtVO();
		} else if (e instanceof EesDmt1008Event) {
			holidayMgtVO 	= ((EesDmt1008Event)e).getHolidayMgtVO();
		}
		try{
			if(holidayMgtVO != null) {
				wkndTpCd = command.searchWeekendTypeByCountry(holidayMgtVO);
			}
			if(wkndTpCd != null) eventResponse.setETCData("wknd_tp_cd", wkndTpCd);
		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;		
	}
	
	/**
	 * EES_DMT_1008 : Retrieve<br>
	 * Retrieving public holiday Info of registered country. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHolidayCountList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt1008Event event = (EesDmt1008Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			HolidayMgtVO paramVO = event.getHolidayMgtVO();
			HolidayMgtBC command = new HolidayMgtBCImpl();
			
			String ofcCd = paramVO.getSvrId();
			paramVO.setSvrId(ofcCd);
			List<HolidayMgtVO> list = command.searchHolidayCountList(event.getHolidayMgtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_1007 : Save<br>
	 * Creating, Updating, Deleting public holiday Info of country. <br> 
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageHoliday(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt1007Event event = (EesDmt1007Event)e;
		HolidayMgtBC command = new HolidayMgtBCImpl();
		try{
			begin();
			command.manageHoliday(event.getHolidayMgtVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [EES_DMT_1003] : [search] <br>
	 * Retrieving BasicTariffSummuryList<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchBasicTariffSummuryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt1003Event event = (EesDmt1003Event)e;
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		CommonFinderBC commmandCom = new CommonFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		SearchBasicTariffSummaryParamVO paramVO = event.getSearchBasicTariffSummaryParamVO();
		OfficeNameVO officeNameVO = new OfficeNameVO();
		officeNameVO.setOfcCd(paramVO.getSvrId());
		
		try{
			paramVO.setSvrId(commmandCom.searchRHQByOffice(officeNameVO));
			List<SearchBasicTariffSummaryListVO> list = command.searchBasicTariffSummuryList(paramVO);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
		
	}
	
	/**
	 * [EES_DMT_1004] : [search] <br>
	 * [EES_DMT_4015] : [search] <br>
	 * Retrieving Continent <br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchBasicTariffDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SearchContinentParamVO searchContinetParamVO = null;
		try{
			if(e instanceof EesDmt1004Event) {
				searchContinetParamVO = ((EesDmt1004Event)e).getSearchContinentParamVO();
				searchContinetParamVO.setUiCode("1004");
			}else if(e instanceof EesDmt4015Event) {
				searchContinetParamVO = ((EesDmt4015Event)e).getSearchContinentParamVO();
				searchContinetParamVO.setUiCode("4015");
			}
			if(searchContinetParamVO != null) {
				List<SearchContinentVO> list = command.searchBasicTariffDetailList(searchContinetParamVO);
				eventResponse.setRsVoList(list);
			}
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(), ex);
		}	
		
		return eventResponse;
		
	}
	
    /**
     * [EES_DMT_1004] : [search] <br>
     * [EES_DMT_4015] : [search] <br>
     * Retrieving Continent<br>
     * @param Event e
     * @return EventResponse response 
     * @throws EventException
     */
    private EventResponse searchBasicTariffDetailList02 ( Event e ) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SearchContinentParamVO searchContinetParamVO = null;
        try{
            if(e instanceof EesDmt1004Event) {
                searchContinetParamVO = ((EesDmt1004Event)e).getSearchContinentParamVO();
                searchContinetParamVO.setUiCode("1004");
            }else if(e instanceof EesDmt4015Event) {
                searchContinetParamVO = ((EesDmt4015Event)e).getSearchContinentParamVO();
                searchContinetParamVO.setUiCode("4015");
            }
            if(searchContinetParamVO != null) {
            	List<SearchContinentVO> list = command.searchBasicTariffDetailList02(searchContinetParamVO);
            	eventResponse.setRsVoList(list);
            }
            
        }catch(EventException ex){
			log.error(ex.getMessage(),ex);
            throw ex;
        }catch(Exception ex){
			log.error(ex.getMessage(),ex);
            throw new EventException(ex.getMessage(), ex);
        }   
        
        return eventResponse;
        
    }
    
	/**
	 * [EES_DMT_1001] : [search] <br>
	 * [EES_DMT_4014] : [search] <br>
	 * Retrieving BasicTariff<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchBasicTariff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<BasicTariffVO> list = null;
		DmtTariffTypeVO dmtTariffTypeVO = null;
		
		try {
			
			if(e instanceof EesDmt1001Event) {
				dmtTariffTypeVO = ((EesDmt1001Event)e).getDmtTariffTypeVO();
				dmtTariffTypeVO.setUiCode("1001");
			}else if(e instanceof EesDmt4014Event) {
				dmtTariffTypeVO = ((EesDmt4014Event)e).getDmtTariffTypeVO();
				dmtTariffTypeVO.setUiCode("4014");
			}
			
			if(dmtTariffTypeVO != null) {
				list = command.searchBasicTariff(dmtTariffTypeVO);
			}
			if(list != null) eventResponse.setRsVoList(list);
			
			if(dmtTariffTypeVO != null) {
				list = command.searchWeekEnd(dmtTariffTypeVO);
			}
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("WKND1",list.get(0).getWknd1());
				eventResponse.setETCData("WKND2",list.get(0).getWknd2());
			}else{
				eventResponse.setETCData("WKND1","SAT");
				eventResponse.setETCData("WKND2","SUN");
			}
			
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
    /**
     * [EES_DMT_1001] : [search] <br>
     * [EES_DMT_4014] : [search] <br>
     * Retrieving BasicTariff <br>
     * @param Event e
     * @return EventResponse response 
     * @throws EventException
     */
    private EventResponse searchBasicTariffXSL(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        List<BasicTariffVO> list = null;
        DmtTariffTypeVO dmtTariffTypeVO = null;
        
        try {
            
            if(e instanceof EesDmt1001Event) {
                dmtTariffTypeVO = ((EesDmt1001Event)e).getDmtTariffTypeVO();
                dmtTariffTypeVO.setUiCode("1001");
            }else if(e instanceof EesDmt4014Event) {
                dmtTariffTypeVO = ((EesDmt4014Event)e).getDmtTariffTypeVO();
                dmtTariffTypeVO.setUiCode("4014");
            }
            
            if(dmtTariffTypeVO != null) {
            	List<SearchContinentVO> list = command.searchBasicTariffXSL(dmtTariffTypeVO);
            	eventResponse.setRsVoList(list);
            }
            
//            list = command.searchBasicTariff(dmtTariffTypeVO);
//            eventResponse.setRsVoList(list);
//            list = command.searchWeekEnd(dmtTariffTypeVO);
//            
//            if (list != null && list.size() > 0) {
//                eventResponse.setETCData("WKND1",list.get(0).getWknd1());
//                eventResponse.setETCData("WKND2",list.get(0).getWknd2());
//            }else{
//                eventResponse.setETCData("WKND1","SAT");
//                eventResponse.setETCData("WKND2","SUN");
//            }
            
        }catch(EventException ex){
			log.error(ex.getMessage(),ex);
            throw ex;
        }catch(Exception ex){
			log.error(ex.getMessage(),ex);
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
	
	/**
	 * [EES_DMT_1001] : [search] <br>
	 * [EES_DMT_4014] : [search] <br>
	 * Retrieving BasicTariffFreeTime<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchBasicTariffFreeTime(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtTariffTypeVO dmtTariffTypeVO = null;
		
		try {
			if(e instanceof EesDmt1001Event) {
				dmtTariffTypeVO = ((EesDmt1001Event)e).getDmtTariffTypeVO();
			}else if(e instanceof EesDmt4014Event) {
				dmtTariffTypeVO = ((EesDmt4014Event)e).getDmtTariffTypeVO();
			}
			if(dmtTariffTypeVO != null) {
				List<TariffFreeTimeVO> list = command.searchBasicTariffFreeTime(dmtTariffTypeVO);
				eventResponse.setRsVoList(list);
			}
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * [EES_DMT_1001] : [search] <br>
	 * [EES_DMT_4014] : [search] <br>
	 * Retrieving BasicTariffRate<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchBasicTariffRate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DmtTariffTypeVO dmtTariffTypeVO = null;
		
		try {
			if(e instanceof EesDmt1001Event) {
				dmtTariffTypeVO = ((EesDmt1001Event)e).getDmtTariffTypeVO();
			}else if(e instanceof EesDmt4014Event) {
				dmtTariffTypeVO = ((EesDmt4014Event)e).getDmtTariffTypeVO();
			}
			if(dmtTariffTypeVO != null) {
				List<TariffRateVO> list = command.searchBasicTariffRate(dmtTariffTypeVO);
				eventResponse.setRsVoList(list);
			}
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;

	}
	
	/**
	 * [EES_DMT_1001] : [confirm] <br>
	 * [EES_DMT_4014] : [confirm] <br>
	 * Retrieving BasicTariff <br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse confirmBasicTariff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BasicTariffVO[] basicTariffVOs = null;
		
		BasicTariffVO basicTariffVO = new BasicTariffVO();
		String trf_grp_seq = "";
		int max_seq = 0;
		
		try {
			if(e instanceof EesDmt1001Event) {
				basicTariffVOs = ((EesDmt1001Event)e).getBasicTarriffVOs();
			}else if(e instanceof EesDmt4014Event) {
				basicTariffVOs = ((EesDmt4014Event)e).getBasicTarriffVOs();
			}
			
			if(basicTariffVOs != null) {
				begin();
				for( int i=0; i< basicTariffVOs.length ; i++) {
					basicTariffVO = basicTariffVOs[i];
					
					basicTariffVO.setOfcCd(account.getOfc_cd());
					basicTariffVO.setUsrId(account.getUsr_id());
					basicTariffVO.setCrntCfmFlg("Y");
					
					if(i == 0 ) {
						
						//DMT_TRF_GRP CONFIRM
						command.confirmBasicTariff(basicTariffVO);
						//DMT_TRF_RGN CONFIRM
						command.confirmRgnBasicTariff(basicTariffVO);
						
						//DMT_TRF_RGN_CFM_HIS INSERT
						command.addTrfRgnCfmHis(basicTariffVO);
						max_seq = command.searchTrfRgnCfmSeq(basicTariffVO);
						basicTariffVO.setRgnCfmSeq(String.valueOf(max_seq));
						
						//DMT_TRF_GRP_CFM_HIS INSERT
						command.addTrfGrpCfmHis(basicTariffVO);
						
						trf_grp_seq = basicTariffVO.getTrfGrpSeq();
						continue;
					}
					
					if(!basicTariffVO.getTrfGrpSeq().equals(trf_grp_seq)) {
						basicTariffVO.setRgnCfmSeq(String.valueOf(max_seq));
	
						//DMT_TRF_GRP CONFIRM
						command.confirmBasicTariff(basicTariffVO);
						//DMT_TRF_GRP_CFM_HIS INSERT
						command.addTrfGrpCfmHis(basicTariffVO);
						
						trf_grp_seq = basicTariffVO.getTrfGrpSeq();
					}
				}
				commit();
			}
		} catch(EventException ex) {
			log.error(ex.getMessage(),ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            rollback(); 
 			throw new EventException(ex.getMessage(),ex);
 		}
		return eventResponse;
	}
	
	/**
	 * [EES_DMT_1001] : [confirmCancel] <br>
	 * [EES_DMT_4014] : [confirmCancel] <br>
	 * Retrieving BasicTariff<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException	 
	 */
	private EventResponse confirmCancelBasicTariff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BasicTariffVO[] basicTariffVOs = null;
		BasicTariffVO basicTariffVO = new BasicTariffVO();
		String trf_grp_seq = "";
		int max_seq = 0;
		
		try {
			if(e instanceof EesDmt1001Event) {
				basicTariffVOs = ((EesDmt1001Event)e).getBasicTarriffVOs();
			}else if(e instanceof EesDmt4014Event) {
				basicTariffVOs = ((EesDmt4014Event)e).getBasicTarriffVOs();
			}
			
			if(basicTariffVOs != null) {
				begin();
				for( int i=0; i< basicTariffVOs.length ; i++) {
					basicTariffVO = basicTariffVOs[i];
					basicTariffVO.setOfcCd(account.getOfc_cd());
					basicTariffVO.setUsrId(account.getUsr_id());
					basicTariffVO.setCrntCfmFlg("N");
					
					if(i == 0 ) {
						//DMT_TRF_GRP CONFIRM
						command.confirmCancelBasicTariff(basicTariffVO);
						//DMT_TRF_RGN CONFIRM
						command.confirmCancelRgnBasicTariff(basicTariffVO);
						
						//DMT_TRF_RGN_CFM_HIS INSERT
						command.addTrfRgnCfmHis(basicTariffVO);
						max_seq = command.searchTrfRgnCfmSeq(basicTariffVO);
						
						basicTariffVO.setRgnCfmSeq(String.valueOf(max_seq));
						
						//DMT_TRF_GRP_CFM_HIS INSERT
						command.addTrfGrpCfmHis(basicTariffVO);
						
	
						trf_grp_seq = basicTariffVO.getTrfGrpSeq();
						continue;
					}
					
					if(!basicTariffVO.getTrfGrpSeq().equals(trf_grp_seq)) {
						basicTariffVO.setRgnCfmSeq(String.valueOf(max_seq));
						//DMT_TRF_GRP CONFIRM
						command.confirmCancelBasicTariff(basicTariffVO);
						
						//DMT_TRF_GRP_CFM_HIS INSERT
						command.addTrfGrpCfmHis(basicTariffVO);
						
						trf_grp_seq = basicTariffVO.getTrfGrpSeq();
					}
				}
				commit();
			}
		} catch(EventException ex) {
			log.error(ex.getMessage(),ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            rollback(); 
 			throw new EventException(ex.getMessage(),ex);
 		}
		return eventResponse;		
	}
	
	/**
	 * [EES_DMT_1001] : [search] <br>
	 * [EES_DMT_4014] : [search] <br>
	 * Retrieving BasicTariff<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse removeBasicTariff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BasicTariffVO[] basicTariffVOs = null;
		
		try {
			if(e instanceof EesDmt1001Event) {
				basicTariffVOs = ((EesDmt1001Event)e).getBasicTarriffVOs();
			}else if(e instanceof EesDmt4014Event) {
				basicTariffVOs = ((EesDmt4014Event)e).getBasicTarriffVOs();
			}
			
			if(basicTariffVOs != null) {
				begin();
				command.removeBasicTariff(basicTariffVOs);
				commit();
			}
			//eventResponse.setUserMessage("Pls make sure to create new tariff!!");
			eventResponse.setUserMessage(new ErrorHandler("DMT06026").getUserMessage());
		} catch(EventException ex) {
			log.error(ex.getMessage(),ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            rollback(); 
 			throw new EventException(ex.getMessage(),ex);
 		}
		return eventResponse;			
	}
	
	/**
	 * [EES_DMT_1002] : [search] <br>
	 * Retrieving CombinationSet<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchCombinationSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt1002Event event = (EesDmt1002Event)e;
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<BasicTariffVO> list = command.searchCombinationSet(event.getDmtTariffTypeVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
		
	}
	
	/**
	 * [EES_DMT_1002] : [search] <br>
	 * Retrieving Update CombinationSet<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchUpdateCombinationSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt1002Event event = (EesDmt1002Event)e;
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<BasicTariffVO> list = command.searchUpdateCombinationSet(event.getDmtTariffTypeVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
		
	}	
	
	/**
	 * [EES_DMT_1002] : [search] <br>
	 * Retrieving TariffCombination<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchTariffCombination(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt1002Event event = (EesDmt1002Event)e;
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BasicTariffVO basicTariffVO = event.getBasicTarriffVO();
		try {
			String button_mode = basicTariffVO.getButtonMode();
			
			if(!button_mode.equals("C")) {
				List<BasicTariffVO> list = command.searchTariffCombination(basicTariffVO);
				eventResponse.setRsVoList(list);
			}
			
			List<TariffGroupVO> list2 = command.searchDmtTrfGrp(basicTariffVO);
			if (list2 != null && list2.size() > 0) {
				eventResponse.setETCData("cmnc_hr",				list2.get(0).getCmncHr());
				eventResponse.setETCData("curr_cd",				list2.get(0).getCurrCd());
				eventResponse.setETCData("dmdt_bzc_trf_grp_nm",	list2.get(0).getDmdtBzcTrfGrpNm());
				eventResponse.setETCData("dmdt_chg_cmnc_tp_cd",	list2.get(0).getDmdtChgCmncTpCd());
				eventResponse.setETCData("dmdt_trf_grp_tp_cd",	list2.get(0).getDmdtTrfGrpTpCd());
				eventResponse.setETCData("eff_dt",				list2.get(0).getEffDt());
				eventResponse.setETCData("exp_dt",				list2.get(0).getExpDt());
				eventResponse.setETCData("xcld_hol_flg",		list2.get(0).getXcldHolFlg());
				eventResponse.setETCData("xcld_sat_flg",		list2.get(0).getXcldSatFlg());
				eventResponse.setETCData("xcld_sun_flg",		list2.get(0).getXcldSunFlg());
				
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * [EES_DMT_1002] : [search] <br>
	 * Retrieving TariffFreeTime<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchTariffFreeTime(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt1002Event event = (EesDmt1002Event)e;
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<TariffFreeTimeVO> list = command.searchBasicTariffFreeTime(event.getDmtTariffTypeVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
		
	}
	
	/**
	 * [EES_DMT_1002] : [search] <br>
	 * Retrieving TariffRate<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchTariffRate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt1002Event event = (EesDmt1002Event)e;
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<TariffRateVO> list = command.searchBasicTariffRate(event.getDmtTariffTypeVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
		
	}

	/**
	 * [EES_DMT_1002] : [create] <br>
	 * Retrieving BasicTariff<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse createBasicTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt1002Event event = (EesDmt1002Event)e;
		TariffMgtVO tariffMgtVO = new TariffMgtVO();
		
		tariffMgtVO.setTariffGroupVO(event.getTariffGroupVO());
		tariffMgtVO.setDmtTariffTypeVO(event.getDmtTariffTypeVO());

		tariffMgtVO.setTariffCombinationVOs(event.getTariffCombinationVOs());
		tariffMgtVO.setTariffFreeTimeVOs(event.getTariffFreeTimeVOs());
		tariffMgtVO.setTariffRateVOs(event.getTariffRateVOs());
		
		DemDetTariffMgtBC command 		= new DemDetTariffMgtBCImpl();
		SCExceptionTariffMgtBC commandSC= new SCExceptionTariffMgtBCImpl();
		
		String sResult = "";
		try {
			DmtTariffTypeVO dmtTariffTypeVO = tariffMgtVO.getDmtTariffTypeVO();
			
			String bound 	= dmtTariffTypeVO.getDmdtTrfCd().substring(2, 3);
			String calcTpCd = dmtTariffTypeVO.getDmdtTrfCd().substring(0, 1);
			
			CalculationTypeParmVO calcVO = new CalculationTypeParmVO();
			calcVO.setDmdtCalcTpCd(calcTpCd);
			calcVO.setIoBndCd(bound);
			calcVO.setCntCd(dmtTariffTypeVO.getCvrgCntCd());
			calcVO.setRgnCd(dmtTariffTypeVO.getCvrgRgnCd());
			calcVO.setSteCd(dmtTariffTypeVO.getCvrgSteCd());
			calcVO.setLocCd(dmtTariffTypeVO.getCvrgLocCd());
			calcVO.setEffDt(tariffMgtVO.getTariffGroupVO().getEffDt());
			calcVO.setExpDt(tariffMgtVO.getTariffGroupVO().getExpDt());
			
			if(dmtTariffTypeVO.getUiCode().equals("1001")) {
				//1. checkCalcType
				boolean checkCalc = commandSC.checkCalcType(calcVO);
				
				if(!checkCalc) {
					eventResponse.setUserMessage(new ErrorHandler("DMT06011").getUserMessage());
				}else{
					begin();
					sResult = command.createBasicTariff(tariffMgtVO, account);
					if(sResult.equals("OK")) {
						commit();
						eventResponse.setETCData("SUCCESS_YN", "Y");	
						//eventResponse.setUserMessage("Tariff Group Created! Please Confirm to apply");
						eventResponse.setUserMessage(new ErrorHandler("DMT06008").getUserMessage());
					}else {
						rollback();
						eventResponse.setETCData("SUCCESS_YN", "N");	
						eventResponse.setUserMessage(sResult);
					}
				}
			}else{
				begin();
				sResult = command.createBasicTariff(tariffMgtVO, account);
				if(sResult.equals("OK")) {
					commit();
					eventResponse.setETCData("SUCCESS_YN", "Y");	
					//eventResponse.setUserMessage("Tariff Group Created! Please Confirm to apply");
					eventResponse.setUserMessage(new ErrorHandler("DMT06008").getUserMessage());
				}else {
					rollback();
					eventResponse.setETCData("SUCCESS_YN", "N");	
					eventResponse.setUserMessage(sResult);
				}
			}
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			//eventResponse.setUserMessage(new ErrorHandler(ex.getMessage()).getUserMessage());
			eventResponse.setETCData("SUCCESS_YN", "N");		
			eventResponse.setUserMessage(ex.getMessage());
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			eventResponse.setETCData("SUCCESS_YN", "N");		
			eventResponse.setUserMessage(ex.getMessage());
            rollback(); 
 			throw new EventException(ex.getMessage(),ex);
 		}
		return eventResponse;	
	}
	
	/**
	 * [EES_DMT_1002] : [modify] <br>
	 * Modifying BasicTariff<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse modifyBasicTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt1002Event event = (EesDmt1002Event)e;
		TariffMgtVO tariffMgtVO = new TariffMgtVO();

		tariffMgtVO.setTariffGroupVO(event.getTariffGroupVO());
		tariffMgtVO.setDmtTariffTypeVO(event.getDmtTariffTypeVO());		
		tariffMgtVO.setTariffCombinationVOs(event.getTariffCombinationVOs());
		tariffMgtVO.setTariffFreeTimeVOs(event.getTariffFreeTimeVOs());
		tariffMgtVO.setTariffRateVOs(event.getTariffRateVOs());
		
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		String sResult = "";
		try {
			begin();
			sResult = command.modifyBasicTariff(tariffMgtVO, account);
			if(sResult.equals("OK")) {
				commit();
				eventResponse.setETCData("SUCCESS_YN", "Y");	
				eventResponse.setUserMessage(new ErrorHandler("DMT06028").getUserMessage());
			}else{
				rollback();
				log.error("error==>"+sResult);
				eventResponse.setETCData("SUCCESS_YN", "N");	
				eventResponse.setUserMessage(sResult);
			}
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			rollback();
			throw ex;
		}catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            rollback(); 
 			throw new EventException(ex.getMessage(),ex);
 		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_1002 : expire<br>
	 * Expiring BasicTariff.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse modifyBasicTariffExpire(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt1002Event event = (EesDmt1002Event)e;
		TariffMgtVO tariffMgtVO = new TariffMgtVO();

		tariffMgtVO.setTariffGroupVO(event.getTariffGroupVO());
		tariffMgtVO.setDmtTariffTypeVO(event.getDmtTariffTypeVO());		
		tariffMgtVO.setTariffCombinationVOs(event.getTariffCombinationVOs());
		tariffMgtVO.setTariffFreeTimeVOs(event.getTariffFreeTimeVOs());
		tariffMgtVO.setTariffRateVOs(event.getTariffRateVOs());
		
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		try {
			begin();
			command.modifyBasicTariffExpire(tariffMgtVO, account);
			commit();
			eventResponse.setETCData("SUCCESS_YN", "Y");	
			eventResponse.setUserMessage(new ErrorHandler("DMT06029").getUserMessage());
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			rollback();
			throw ex;
		}catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            rollback(); 
 			throw new EventException(ex.getMessage(),ex);
 		}
		return eventResponse;	
	}
	
	/**
	 * EesDmt1101Event : copy<br>
	 * Copying BasicTariff.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse copyBasicTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt1101Event event = (EesDmt1101Event)e;
		DmtTariffTypeVO dmtTariffTypeVO = new DmtTariffTypeVO();
		dmtTariffTypeVO = event.getDmtTariffTypeVO();
		ToDmtTariffTypeVO toDmtTariffTypeVO = new ToDmtTariffTypeVO();
		toDmtTariffTypeVO = event.getToDmtTariffTypeVO();
		String sResult = "";
		
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		try {
			begin();
			sResult = command.copyBasicTariff(dmtTariffTypeVO, toDmtTariffTypeVO, account);
			
			if(sResult.equals("OK") ) {
				commit();
				eventResponse.setUserMessage(new ErrorHandler("DMT06030").getUserMessage());
			}else{
				log.error("error==>"+sResult);
				rollback();
				eventResponse.setUserMessage(sResult);
			}
			
		} catch(EventException ex) {
			log.error(ex.getMessage(),ex);
			rollback();
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		}catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            rollback(); 
			eventResponse.setUserMessage(ex.getMessage());
 			throw new EventException(ex.getMessage(),ex);
 		}
		return eventResponse;
		
	}
	
	/**
	 * [EES_DMT_1005] : [search] <br>
	 * Retrieving CommdityTariffList<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
	private EventResponse searchCommodityTariffList(Event e) throws EventException {
		EesDmt1005Event event = (EesDmt1005Event)e;
		DmtTariffTypeVO dmtTariffTypeVO = new DmtTariffTypeVO();
		DemDetTariffMgtBC command 		= new DemDetTariffMgtBCImpl();
		SCExceptionTariffMgtBC commandSC= new SCExceptionTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		boolean isError = false;
		String sErrorMsg = "";
		try{
			dmtTariffTypeVO = event.getDmtTariffTypeVO();
			//1.checkCalcType
			String dmdtTrfCd = dmtTariffTypeVO.getSelDmdtTrfCd();
			dmtTariffTypeVO.setDmdtTrfCd(dmdtTrfCd);
			
			String bound 	= dmtTariffTypeVO.getDmdtTrfCd().substring(2, 3);
			String calcTpCd = dmtTariffTypeVO.getDmdtTrfCd().substring(0, 1);
			
			CalculationTypeParmVO calcVO = new CalculationTypeParmVO();
			calcVO.setDmdtCalcTpCd(calcTpCd);
			calcVO.setIoBndCd(bound);
			calcVO.setCntCd(dmtTariffTypeVO.getCvrgCntCd());
			calcVO.setRgnCd(dmtTariffTypeVO.getCvrgRgnCd());
			calcVO.setSteCd(dmtTariffTypeVO.getCvrgSteCd());
			calcVO.setLocCd(dmtTariffTypeVO.getCvrgLocCd());
			
			boolean checkCalc = commandSC.checkCalcType(calcVO);
			
			if(!checkCalc) {
				eventResponse.setUserMessage(new ErrorHandler("DMT06011").getUserMessage());
			}else{
				//2.searchCommodity
				List<CommodityTariffVO> list = command.searchCommodityTariffList(dmtTariffTypeVO);
				
				if(list != null ) {
					for(int i = 0; i< list.size() ; i++) {
						CommodityTariffVO commdityTariffVO = (CommodityTariffVO)list.get(i);
						
						if(commdityTariffVO.getReturnCd().equals("DMT06031")) {
							isError = true;
							sErrorMsg = new ErrorHandler("DMT06031").getUserMessage();
							log.debug("[ERR_CD]DMT06031||"+sErrorMsg);
							break;
						}
					}
				}
				
				if(isError) {
					log.error("error==>"+sErrorMsg);
					eventResponse.setUserMessage(sErrorMsg);
				}else{
					eventResponse.setRsVoList(list);
				}				
			}
		} catch(EventException ex ) {
			log.error(ex.getMessage(),ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		}catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
 			throw new EventException(ex.getMessage(),ex);
 		}
		
		return eventResponse;
		
	}
	
	/**
	 * [EES_DMT_1005] : [modify] <br>
	 * Creating CommodityTariff.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse modifyCommodityTariff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt1005Event event = (EesDmt1005Event)e;
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		
		try{
			begin();
			command.modifyCommodityTariff(event.getCommodityTariffVOs(), event.getDmtTariffTypeVO(), account);
			commit();
		}catch(EventException ex) {
			log.error(ex.getMessage(),ex);
			rollback();
			throw ex;
			
		}catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
 			throw new EventException(ex.getMessage(),ex);
 		}
		return eventResponse;
	}
	
	/**
	 * [EES_DMT_1006] : [search] <br>
	 * Retrieving CommodityTariffRegionList.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCommodityTariffRegionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DemDetTariffMgtBC command = new DemDetTariffMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommodityTariffRegionParamVO commodityTariffRegionParamVO = null;
		try{
			commodityTariffRegionParamVO = ((EesDmt1006Event)e).getCommodityTariffRegionParamVO();
			List<CommodityTariffRegionVO> list = command.searchCommodityTariffRegionList(commodityTariffRegionParamVO);
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(), ex);
		}	
		
		return eventResponse;
		
	}
	
	/**
	 * [EES_DMT_1009] : [search] <br>
	 * Retrieving SB45 Ruling Exceptions <br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
//	private EventResponse searchSb45RulingExceptionList(Event e) throws EventException {
//		HolidayMgtBC command = new HolidayMgtBCImpl();
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		Sb45RulingExceptionVO sb45RulingExceptionVO =  ((EesDmt1009Event)e).getSb45RulingExceptionVO();
//		try{
//			List<Sb45RulingExceptionVO> list = command.searchSb45RulingExceptionList(sb45RulingExceptionVO);
//			eventResponse.setRsVoList(list);
//		}catch(EventException ex){
//			log.error(ex.getMessage(),ex);
//			throw ex;
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new EventException(ex.getMessage(), ex);
//		}	
//		
//		return eventResponse;		
//	}
	
	/**
	 * [EES_DMT_1009] : [modify] <br>
	 * Creating/Updating SB45 Ruling Exceptions<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
//	private EventResponse modifySb45RulingException(Event e) throws EventException {
//		Sb45RulingExceptionVO vo = null;
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EesDmt1009Event event = (EesDmt1009Event)e;
//		HolidayMgtBC command = new HolidayMgtBCImpl();
//		
//		try {
//			begin();
//			vo = command.modifySb45RulingException(event.getSb45RulingExceptionVOS(), account);
//			// dup exists
//			if (vo != null) {
//				eventResponse.setETCData("DUPLICATED", "Y");
//				eventResponse.setETCData("SEQ", vo.getSeq());
//				
//				rollback();
//			} else { // dup does not exist
//				commit();
//			}
//		} catch(EventException ex) {
//			log.error(ex.getMessage(),ex);
//			rollback();
//			throw ex;
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			rollback();
// 			throw new EventException(ex.getMessage(),ex);
// 		}
//		return eventResponse;
//	}
	
	/**
	 * [EES_DMT_1009] : [search] <br>
	 * Retrieving SB45 Ruling Exceptions Dup Check <br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
	 */
//	private EventResponse searchSb45RulingExceptionDupCheck(Event e) throws EventException {
//		HolidayMgtBC command = new HolidayMgtBCImpl();
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		Sb45RulingExceptionVO sb45RulingExceptionVO =  ((EesDmt1009Event)e).getSb45RulingExceptionVO();
//		try{
//			Sb45RulingExceptionVO vo = command.searchSb45RulingExceptionDupCheck(sb45RulingExceptionVO);
//
//			if (vo != null) {
//				eventResponse.setETCData("RESULT", "Y");
//			} else {
//				eventResponse.setETCData("RESULT", "N");
//			}
//		}catch(EventException ex){
//			log.error(ex.getMessage(),ex);
//			throw ex;
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new EventException(ex.getMessage(), ex);
//		}	
//		
//		return eventResponse;		
//	}
}