/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName       : DailyForecastSC.java
 *@FileTitle      : DailyForecast
 *Open Issues     :
 *Change history  :
 *@LastModifyDate :  
 *@LastModifier   : 
 *@LastVersion    : 

=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast;

import java.util.List;

import com.clt.apps.opus.esm.spc.common.common.basic.CommonBC;
import com.clt.apps.opus.esm.spc.common.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.basic.BasicDataBC;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.basic.BasicDataBCImpl;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.event.EsmSpc0100Event;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.integration.BasicDataDBDAO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByVvdListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByWeekListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.basic.DailyForecastManageBC;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.basic.DailyForecastManageBCImpl;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0102Event;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0103Event;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0104Event;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc9010Event;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageMainVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastManageListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDlyFctSplListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SpcOfcLvlVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.DlyFctInpListVO;

/**
 * DailyForecast Business Logic ServiceCommand - handling business transaction for DailyForecast
 * 
 * @author
 * @see BasicDataDBDAO  
 * @since J2EE 1.6
 */

public class DailyForecastSC extends ServiceCommandSupport { 
	// Login User Information
	private SignOnUserAccount account = null;
 
	/**
	 * preceding process for biz scenario<br>
	 * related objects creation <br>
	 */
	public void doStart() {
		log.debug("DailyForecastSC start");
		try {

			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * biz scenario closing <br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("DailyForecastSC End");
	}

	/**
	 * 
	 * @param e
	 *            Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {		
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsmSpc0100Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchDailyForcastManageByVvdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchDailyForcastManageByWeekList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiDailyForcastVvdManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiDailyForcastManage(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
//				eventResponse = multiOfficeLevelManage(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkLanePortValid(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkOfficeValid(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkVvdValid(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0103Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchDailyForecastSrepAccountManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiDailyForecastSrepAccountManage(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchDailyForecastManage2List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiDailyForecastManage2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = multiDailyForcastForHistory(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchDailyForecastHistoryOfcList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchDailyForecastHistorySrepAcctList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc3001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfcLvlList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiOfficeLevelManage(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc9010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = multiDailyForecastManage3(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDailyForecastManage3List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchDailyForecastTemplateList(e);
			}
		}
		
		return eventResponse;
	}

	/**
	 * EsmSpc0104Event retrieve event process<br>
	 * forecast history list retrieve<br>
	 * 
	 * @author
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyForecastHistoryOfcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0104Event event = (EsmSpc0104Event) e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();

		try {
			List<DailyforecastmanageMainVO> rsVoList = command.searchDailyForecastHistoryOfcList(event.getDailyforecastmanageConditionVO());
			if (rsVoList.size() > 0) {
				rsVoList.get(0).setEventCommand("SEARCHLIST01");
			}
			eventResponse.setRsVoList(rsVoList);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EsmSpc0104Event retrieve event process<br>
	 * forecast history info retrieve<br>
	 * 
	 * @author
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyForecastHistorySrepAcctList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0104Event event = (EsmSpc0104Event) e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();

		try {
			List<DailyforecastmanageMainVO> rsVoList = command.searchDailyForecastHistorySrepAcctList(event.getDailyforecastmanageConditionVO());
			if (rsVoList.size() > 0) {
				rsVoList.get(0).setEventCommand("SEARCHLIST02");
			}
			eventResponse.setRsVoList(rsVoList);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EsmSpc0103Event save event process<br>
	 * forecast srep account save<br>
	 * 
	 * @author
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiDailyForecastSrepAccountManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0103Event event = (EsmSpc0103Event) e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();
		try {
			begin();
			command.multiDailyForecastSrepAccountManage(event.getSpcSlsRepCustMapgVOS(), account);
			eventResponse.setETCData("status", "OK");
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * EsmSpc0103Event retrieve event process<br>
	 * forecast srep account retrieve<br>
	 * 
	 * @author
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyForecastSrepAccountManageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0103Event event = (EsmSpc0103Event) e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();

		try {
			List<DailyforecastmanageMainVO> rsVoList = command.searchDailyForecastSrepAccountManageList(event.getDailyforecastmanageConditionVO());
			if (rsVoList.size() > 0) {
				rsVoList.get(0).setEventCommand("SEARCHLIST");
			}
			eventResponse.setRsVoList(rsVoList);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EsmSpc0100Event retrieve event process<br>
	 * forecast manabe by vvd retrieve<br>
	 * 
	 * @author
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyForcastManageByVvdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0100Event event = (EsmSpc0100Event) e;
		BasicDataBC command = new BasicDataBCImpl();

		try {
			List<SearchDailyForcastManageByVvdListVO> list = command.searchDailyForcastManageByVvdList(event.getSearchDailyForcastManageByVvdListConditionVO());
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
	 * EsmSpc0100Event retrieve event process<br>
	 * forecast manage by week retrieve<br>
	 * 
	 * @author
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyForcastManageByWeekList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0100Event event = (EsmSpc0100Event) e;
		BasicDataBC command = new BasicDataBCImpl();

		try {
			List<SearchDailyForcastManageByWeekListVO> list = command.searchDailyForcastManageByWeekList(event.getSpcFcastOfcPolMapgConditionVO());
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
	 * EsmSpc0100Event save event process<br>
	 * daily forecast vvd manage save<br>
	 * 
	 * @author
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiDailyForcastVvdManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0100Event event = (EsmSpc0100Event) e;
		BasicDataBC command = new BasicDataBCImpl();
		try {
			begin();
			command.multiDailyForcastVvdManage(event.getSpcIrrFcastOfcPolMapgVOS(), account);
			eventResponse.setETCData("status", "OK");
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * EsmSpc0100Event save event process<br>
	 * daily forecast manage save<br>
	 * 
	 * @author
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiDailyForcastManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0100Event event = (EsmSpc0100Event) e;
		BasicDataBC command = new BasicDataBCImpl();
		try {
			begin();
			command.multiDailyForcastManage(event.getSpcFcastOfcPolMapgVOS(), account);
			eventResponse.setETCData("status", "OK");
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * EsmSpc0102Event retrieve event process<br>
	 * daily forecast manage retrieve<br>
	 * 
	 * @author
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyForecastManage2List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0102Event event = (EsmSpc0102Event) e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();

		try {
			List<SearchDailyForecastManageListVO> list = command.searchDailyForecastManage2List(event.getConditionVO());
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
	 * EsmSpc0102Event save event process<br>
	 * daily forecast manage save<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiDailyForecastManage2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0102Event event = (EsmSpc0102Event) e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();

		try {
			begin();
			command.multiDailyForecastManage2(event.getSpcDlyFcastCustVOS(), account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * EsmSpc9010Event save event process<br>
	 * daily forecast manage save<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiDailyForecastManage3(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc9010Event event = (EsmSpc9010Event) e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();

		try {
			List<DlyFctInpListVO> rtnList = command.checkFileImportList(event.getDlyFctInpListVOS());
			
			int nCnt = 0;
			
			for (int i = 0; i < rtnList.size(); i++) {
				if (rtnList.get(i).getRemark().length() > 0){
					nCnt++;					
				}				
			}
			
			if(nCnt > 0){
				eventResponse.setRsVoList(rtnList);		
				eventResponse.setETCData("status", "NO");
				eventResponse.setUserMessage("Please Check Remark !");				
			} else {			
				begin();
				command.multiDailyForecastManage3(event.getDlyFctInpListVOS(), account);
				eventResponse.setRsVoList(rtnList);	
				eventResponse.setETCData("status", "OK");
				eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
				commit();
			}
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_SPC_9010 : search Daily Forecast 
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchDailyForecastManage3List(Event e) throws EventException {		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc9010Event event = (EsmSpc9010Event) e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();		

		try {
			List<SearchDlyFctSplListVO> list = command.searchDailyForecastManage3List(event.getConditionVO());
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
	 * ESM_SPC_9010 : search Daily Forecast Template
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchDailyForecastTemplateList(Event e) throws EventException {		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc9010Event event = (EsmSpc9010Event) e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();		

		try {
			List<SearchDlyFctSplListVO> list = command.searchDailyForecastTemplateList(event.getConditionVO());
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
	 * EsmSpc0102Event save event process<br>
	 * daily forecast history save<br>
	 * 
	 * @author
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiDailyForcastForHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0102Event event = (EsmSpc0102Event) e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();

		try {
			begin();
			command.multiDailyForcastForHistory(event.getConditionVO(), account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * SPC Office Level
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOfcLvlList(Event e) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			DailyForecastManageBC command = new DailyForecastManageBCImpl();
			List<SpcOfcLvlVO> list = command.searchOfcLvlList();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiOfficeLevelManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DailyForecastManageBC command = new DailyForecastManageBCImpl();
		try {
			begin();
			command.multiOfficeLevelManage();
			eventResponse.setETCData("status", "OK");
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
//	private EventResponse searchSpaceAllocationOfficeCond(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		CommonBC command = new CommonBCImpl();
//		
//		try{
//			List<SearchOfficeCondVO> list = command.searchOfficeCond(e, account);
//			if(list.size() > 0){
//				SearchOfficeCondVO searchOfficeCondVO = list.get(0);
//				eventResponse.setETCData(searchOfficeCondVO.getColumnValues());
//			}
//		}catch(EventException ex){
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}catch(Exception ex){
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}
//		return eventResponse;
//	}  //소스 품질 수정 요청건
	
	/**
	 * ESM_SPC_0100 : sheet Port Change
	 * Checking port with Lane, Bound
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkLanePortValid(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0100Event event = (EsmSpc0100Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			String flg = command.checkLanePortValid(event.getSpcFcastOfcPolMapgVO());
			eventResponse.setETCData("valid_flg", flg);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0100 : sheet Office Change
	 * Region Office 체크
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkOfficeValid(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0100Event event = (EsmSpc0100Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			String flg = command.checkOfficeValid(event.getSpcFcastOfcPolMapgVO());
			eventResponse.setETCData("valid_flg", flg);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0100 : sheet vvd Change
	 * vvd 체크
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkVvdValid(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0100Event event = (EsmSpc0100Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			String flg = command.checkVvdValid(event.getSpcIrrFcastOfcPolMapgVO());
			eventResponse.setETCData("valid_flg", flg);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
}