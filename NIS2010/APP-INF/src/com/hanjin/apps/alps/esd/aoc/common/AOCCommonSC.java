/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AOCCommonSC.java
*@FileTitle : AOCCommonSC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.aoc.common.aoccommon.basic.AocCommonBC;
import com.hanjin.apps.alps.esd.aoc.common.aoccommon.basic.AocCommonBCImpl;
import com.hanjin.apps.alps.esd.aoc.common.aoccommon.event.EsdAoc0999Event;
import com.hanjin.apps.alps.esd.aoc.common.aocpopup.basic.AocPopUpBC;
import com.hanjin.apps.alps.esd.aoc.common.aocpopup.basic.AocPopUpBCImpl;
import com.hanjin.apps.alps.esd.aoc.common.aocpopup.event.EsdAoc3901Event;
import com.hanjin.apps.alps.esd.aoc.common.aocpopup.event.EsdAoc3902Event;
import com.hanjin.apps.alps.esd.aoc.common.aocpopup.vo.FdrCostBatchErrorVO;
import com.hanjin.apps.alps.esd.aoc.common.aocpopup.vo.InlandCostBatchErrorVO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.basic.DefaultCurrBC;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.basic.DefaultCurrBCImpl;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.event.EsdAoc3034Event;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.integration.DefaultCurrDBDAO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.CntDefaultCurrVO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.CntInfoVO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.RHQComboVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-InlandCostManage Business Logic ServiceCommand - ALPS-InlandCostManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author 
 * @see DefaultCurrDBDAO
 * @since J2EE 1.6
 */

public class AOCCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * InlandCostManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("AOCCommonSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * InlandCostManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("AOCCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-InlandCostManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdAoc3034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntDefaultCurr(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //RHQ 
				eventResponse= searchRHQCombo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //Country Code
				eventResponse= searchCntInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { //Currency Code
				eventResponse= searchCurrNm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { //Currency Code 확인
				eventResponse= verifyCurrencyCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) { //Country Code 확인
				eventResponse= verifyCountryCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = multiCntDefaultCurr(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = removeCntDefaultCurr(e);				
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdAoc3901Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Retrieve : 
				eventResponse = searchInlandCostBatchError(e);
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdAoc3902Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Retrieve : 
				eventResponse = searchFdrCostBatchError(e);
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdAoc0999Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPeriod(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSubOfficeSOManageList(e);
			}
		}

		return eventResponse;
	}
	
	/**
	 * Default Currency Creation - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntDefaultCurr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3034Event event = (EsdAoc3034Event)e;
		DefaultCurrBC command = new DefaultCurrBCImpl();

		try{
			List<CntDefaultCurrVO> list = command.searchCntDefaultCurr(event.getInlandCostConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Default Currency Creation - RHQ<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DefaultCurrBC command = new DefaultCurrBCImpl();
		List<RHQComboVO> list = new ArrayList<RHQComboVO>();
		RHQComboVO combovo = new RHQComboVO();
		try{
			list = command.searchRHQCombo();
			combovo.setRhqCd("");
			combovo.setRhqNm("All");
			list.add(0,combovo);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}


	/**
	 * Default Currency Creation - Country Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3034Event event = (EsdAoc3034Event)e;
		DefaultCurrBC command = new DefaultCurrBCImpl();

		try{
			CntInfoVO vo  = command.searchCntInfo(event.getCntCd());
			eventResponse.setETCData(vo.getColumnValues());
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Default Currency Creation - Currency Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrNm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3034Event event = (EsdAoc3034Event)e;
		DefaultCurrBC command = new DefaultCurrBCImpl();

		try{
			String curr_nm  = command.searchCurrNm(event.getCurrCd());
			eventResponse.setETCData("curr_nm", curr_nm);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}	

	/**
	 * Default Currency Creation - Save<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCntDefaultCurr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3034Event event = (EsdAoc3034Event)e;
		DefaultCurrBC command = new DefaultCurrBCImpl();
		try{
			begin();
			command.multiCntDefaultCurr(event.getCntDefaultCurrVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Date"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * Default Currency Creation - Delete<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCntDefaultCurr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3034Event event = (EsdAoc3034Event)e;
		DefaultCurrBC command = new DefaultCurrBCImpl();
		try{
			begin();
			command.removeCntDefaultCurr(event.getCntDefaultCurrVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Date"}).getMessage(), ex);
        }
		return eventResponse;
	}	

	
	/**
	 * Default Currency Creation - Currency Code 확인 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyCurrencyCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3034Event event = (EsdAoc3034Event)e;
		DefaultCurrBC commCommand = new DefaultCurrBCImpl();

		try {
			String errFlg = commCommand.verifyCurrencyCode(event.getCurrCd());
			eventResponse.setETCData("err_flg", errFlg);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Default Currency Creation - Country Code 확인 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyCountryCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3034Event event = (EsdAoc3034Event)e;
		DefaultCurrBC commCommand = new DefaultCurrBCImpl();

		try {
			String knt = commCommand.verifyCountryCode(event.getRhqCd(), event.getCntCd());
			eventResponse.setETCData("knt", knt);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * ESD_AOC_3901 : 화면 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandCostBatchError(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3901Event event = (EsdAoc3901Event)e;
		AocPopUpBC command = new AocPopUpBCImpl();
		
		try{
			List<InlandCostBatchErrorVO> list = command.searchInlandCostBatchError(event.getSearchInlandCostBatchErrorVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * ESD_AOC_3902 : 화면 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFdrCostBatchError(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3902Event event = (EsdAoc3902Event)e;
		AocPopUpBC command = new AocPopUpBCImpl();
		
		try{
			List<FdrCostBatchErrorVO> list = command.searchFdrCostBatchError(event.getSearchFdrCostBatchErrorVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 월,주차 검색기간 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchPeriod(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			AocCommonBC command = new AocCommonBCImpl();
			eventResponse = command.searchPeriod(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage의 event에 대한 수정 이벤트 처리<br>
	 * Sub Office <br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSubOfficeSOManageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdAoc0999Event event = (EsdAoc0999Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			AocCommonBC command = new AocCommonBCImpl();
			String subOfcCd = command.searchSubOfficeSOManageList(event);
			eventResponse.setETCData("subOfcCd", subOfcCd);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
}