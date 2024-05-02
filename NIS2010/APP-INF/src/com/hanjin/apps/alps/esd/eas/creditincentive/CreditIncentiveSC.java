/*============================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveSC.java
*@FileTitle : 
*@LastModifyDate : 2016.04.26.
*@LastModifier : 
*@LastVersion : 
* 2016.04.26. SHIN DONG IL
*============================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive;

import java.util.List;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.event.EsdEas0501Event;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.basic.CreditIncentiveStatusBC;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.basic.CreditIncentiveStatusBCImpl;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.TesStatusIncntVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.TrsStatusIncntVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.VslStatusIncntVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.MnrStatusCrIssVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.MnrStatusCrUsdVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.BnfStatusMlgVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.TotStatusMkrVO;

import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.event.EsdEas0502Event;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.basic.CreditIncentiveSummaryBC;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.basic.CreditIncentiveSummaryBCImpl;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.vo.CreditSmmrIssueVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.vo.CreditSmmrRhqVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.vo.CreditSmmrSrcVO;


/**
 * CreditIncentiveSC PDTO(Data Transfer Object including Parameters)<br>
 * 
 * @author SHIN DONG IL
 * @see ServiceCommandSupport 참조
 * @since J2EE 1.6
 */
public class CreditIncentiveSC extends ServiceCommandSupport{
	
	// Login User Information
	private SignOnUserAccount account = null;
	
	/**
	 * EAS 업무 시나리오 선행작업<br>
	 * CreditIncentive 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch(Exception e) {
			log.error("CreditIncentive 선행 작업 시 오류 " + e.toString(), e);
		}
	}
	
	/**
	 * EAS 업무 시나리오 마감작업<br>
	 * CreditIncentive 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("CreditIncentive 종료");
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CreditIncentive event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("EsdEas0501Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTesIncentiveList(e);     //Terminal Incentive Search
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
		    	 eventResponse = searchTrsIncentiveList(e);    //Transportation Incentive Search
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
		    	 eventResponse = searchVslIncentiveList(e);    //Vessel Operation Incentive Search
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
		    	 eventResponse = searchMnrCreditIssueList(e);  //Refrigerator Parts Credit Issue
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
		    	 eventResponse = searchMnrCreditUsedList(e);	//Refrigerator Parts Credit Used
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {
		    	 eventResponse = searchMileageList(e);          //Welfare Card Mileage 
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST07)) {
		    	 eventResponse = searchTotalStatusByMakerList(e);//Total Status by Maker
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
		    	 eventResponse = searchCheckRhqOfficeCode(e);//유효한 RHQ OFFICE CODE CHECK
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
		    	 eventResponse = searchCheckOfficeCode(e);	//유효한 OFFICE CODE CHECK
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
		    	 eventResponse = searchCheckPortCode(e);	//유효한 OFFICE CODE CHECK
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
		    	 eventResponse = searchCheckTesYardCode(e);	//TERMINAL의 유효한 YARD CODE CHECK
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
		    	 eventResponse = searchCheckTesCostCode(e);	//TERMINAL의 유효한 COST CODE CHECK
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
		    	 eventResponse = searchCheckTrsCostCode(e);	//T의 유효한 COST CODE CHECK
		    }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiTesIncentive(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiTrsIncentive(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = multiVslIncentive(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = multiMnrCreditIssue(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = multiMnrCreditUsed(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				eventResponse = multiMileage(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = modifyTesFileAttach(e);//TES File attach
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = modifyTrsFileAttach(e);//TRS File attach
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = modifyVslFileAttach(e);//VSL File attach
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {
				eventResponse = modifyMnrFileAttach(e);//M&R File attach
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) {	
				eventResponse = modifyMileageFileAttach(e);//Mileage File attach
				
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY06)) {
				eventResponse = modifyTesFileAttach2(e);//TES File attach
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY07)) {
				eventResponse = modifyTrsFileAttach2(e);//TRS File attach
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY08)) {
				eventResponse = modifyVslFileAttach2(e);//VSL File attach
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY09)) {
				eventResponse = modifyMnrFileAttach2(e);//M&R USD File attach 
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY10)) {	
				eventResponse = modifyMileageFileAttach2(e);//Mileage File attach
				
				
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeTesIncentive(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) {
				eventResponse = removeTrsIncentive(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE03)) {
				eventResponse = removeVslIncentive(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE04)) {
				eventResponse = removeMnrCreditIssue(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE05)) {
				eventResponse = removeMnrCreditUsed(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE06)) {
				eventResponse = removeMileage(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0502Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCreditByRhqList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
		    	 eventResponse = searchCreditBySourceList(e);
		    }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchCreditIssuetList(e);
			}
		}
		
		return eventResponse;
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status Terminal 조회한다. <br>
	 * 
	 * @param  e
	 * @return eventResponse
	 * @exception EventException
	 */
	public EventResponse searchTesIncentiveList(Event e) throws EventException {
		try {
			EsdEas0501Event event = (EsdEas0501Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		
			List<TesStatusIncntVO> list  = command.searchTesIncentiveList(event);

			eventResponse.setRsVoList(list);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TES Incentive Save 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse multiTesIncentive(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			TesStatusIncntVO[] voList  = event.getTesStatusIncntVOs();
			command.multiTesIncentive(voList,event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiTrsIncentive"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TES Incentive Delete 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse removeTesIncentive(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			TesStatusIncntVO[] voList  = event.getTesStatusIncntVOs();
			command.removeTesIncentive(voList,event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiTrsIncentive"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TES Incentive File Attach 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse modifyTesFileAttach(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.modifyTesFileAttach(event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiTrsIncentive"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TES Incentive File Attach 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse modifyTesFileAttach2(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.modifyTesFileAttach2(event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiTrsIncentive"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status Transportation 조회한다. <br>
	 * 
	 * @param  e
	 * @return eventResponse
	 * @exception EventException
	 */
	public EventResponse searchTrsIncentiveList(Event e) throws EventException {
		try {
			EsdEas0501Event event = (EsdEas0501Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		
			List<TrsStatusIncntVO> list  = command.searchTrsIncentiveList(event);

			eventResponse.setRsVoList(list);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TRS Incentive Save 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse multiTrsIncentive(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			TrsStatusIncntVO[] voList  = event.getTrsStatusIncntVOs();
			command.multiTrsIncentive(voList,event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiTesIncentive"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TRS Incentive Delete 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse removeTrsIncentive(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			TrsStatusIncntVO[] voList  = event.getTrsStatusIncntVOs();
			command.removeTrsIncentive(voList,event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiTesIncentive"}).getMessage(), ex);
		}
	}
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TRS Incentive File Attach 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse modifyTrsFileAttach(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.modifyTrsFileAttach(event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiTesIncentive"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TRS Incentive File Attach 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse modifyTrsFileAttach2(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.modifyTrsFileAttach2(event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiTesIncentive"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status VSL 운항 조회한다. <br>
	 * 
	 * @param  e
	 * @return eventResponse
	 * @exception EventException
	 */
	public EventResponse searchVslIncentiveList(Event e) throws EventException {
		try {
			EsdEas0501Event event = (EsdEas0501Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		
			List<VslStatusIncntVO> list  = command.searchVslIncentiveList(event);

			eventResponse.setRsVoList(list);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status VSL Incentive Save 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse multiVslIncentive(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			VslStatusIncntVO[] voList  = event.getVslStatusIncntVOs();
			command.multiVslIncentive(voList,event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiVslIncentive"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status VSL Incentive Save 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse removeVslIncentive(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			VslStatusIncntVO[] voList  = event.getVslStatusIncntVOs();
			command.removeVslIncentive(voList,event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiVslIncentive"}).getMessage(), ex);
		}
	}
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status VSL Incentive File Attach 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse modifyVslFileAttach(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.modifyVslFileAttach(event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiTesIncentive"}).getMessage(), ex);
		}
	}
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status VSL Incentive File Attach 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse modifyVslFileAttach2(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.modifyVslFileAttach2(event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiTesIncentive"}).getMessage(), ex);
		}
	}
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status M&R Credit Issue 조회한다. <br>
	 * 
	 * @param  e
	 * @return eventResponse
	 * @exception EventException
	 */
	public EventResponse searchMnrCreditIssueList(Event e) throws EventException {
		try {
			EsdEas0501Event event = (EsdEas0501Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		
			List<MnrStatusCrIssVO> list  = command.searchMnrCreditIssueList(event);

			eventResponse.setRsVoList(list);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status M&R Credit Issue Save 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse multiMnrCreditIssue(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			MnrStatusCrIssVO[] voList  = event.getMnrStatusCrIssVOs();
			command.multiMnrCreditIssue(voList,event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiMnrCreditUsed"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status M&R Credit Issue Delete 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse removeMnrCreditIssue(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			MnrStatusCrIssVO[] voList  = event.getMnrStatusCrIssVOs();
			command.removeMnrCreditIssue(voList,event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiMnrCreditUsed"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status M&R Credit File Attach 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse modifyMnrFileAttach(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.modifyMnrFileAttach(event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiTesIncentive"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status M&R Credit File Attach 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse modifyMnrFileAttach2(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.modifyMnrFileAttach2(event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiTesIncentive"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status M&R Credit Issue 조회한다. <br>
	 * 
	 * @param  e
	 * @return eventResponse
	 * @exception EventException
	 */
	public EventResponse searchMnrCreditUsedList(Event e) throws EventException {
		try {
			EsdEas0501Event event = (EsdEas0501Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		
			List<MnrStatusCrUsdVO> list  = command.searchMnrCreditUsedList(event);

			eventResponse.setRsVoList(list);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status M&R Credit Used Save 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse multiMnrCreditUsed(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			MnrStatusCrUsdVO[] voList  = event.getMnrStatusCrUsdVOs();
			command.multiMnrCreditUsed(voList,event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiMnrCreditUsed"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status M&R Credit Used Delete 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse removeMnrCreditUsed(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			MnrStatusCrUsdVO[] voList  = event.getMnrStatusCrUsdVOs();
			command.removeMnrCreditUsed(voList,event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiMnrCreditUsed"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Part Credit Total by Maker 조회한다. <br>
	 * 
	 * @param  e
	 * @return eventResponse
	 * @exception EventException
	 */
	public EventResponse searchTotalStatusByMakerList(Event e) throws EventException {
		try {
			EsdEas0501Event event = (EsdEas0501Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		
			List<TotStatusMkrVO> list  = command.searchTotalStatusByMakerList(event);

			eventResponse.setRsVoList(list);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status Mileage Credit 조회한다. <br>
	 * 
	 * @param  e
	 * @return eventResponse
	 * @exception EventException
	 */
	public EventResponse searchMileageList(Event e) throws EventException {
		try {
			EsdEas0501Event event = (EsdEas0501Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		
			List<BnfStatusMlgVO> list  = command.searchMileageList(event);

			eventResponse.setRsVoList(list);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * EsdEas0501Event  <br>
	 * 유효한 RHQ CODE 조회한다. <br>
	 * 
	 * @param  e
	 * @return eventResponse
	 * @exception EventException
	 */
	public EventResponse searchCheckRhqOfficeCode(Event e) throws EventException {
		try {
			EsdEas0501Event event = (EsdEas0501Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
			String rtn_val = "";
		
			rtn_val = command.searchCheckRhqOfficeCode(event);

			eventResponse.setETCData("rhq_ofc_cd",rtn_val);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * 유효한 Office CODE 조회한다. <br>
	 * 
	 * @param  e
	 * @return eventResponse
	 * @exception EventException
	 */
	public EventResponse searchCheckOfficeCode(Event e) throws EventException {
		try {
			EsdEas0501Event event = (EsdEas0501Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
			String rtn_val = "";
		
			rtn_val = command.searchCheckOfficeCode(event);

			eventResponse.setETCData("ofc_cd",rtn_val);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * 유효한 Port CODE 조회한다. <br>
	 * 
	 * @param  e
	 * @return eventResponse
	 * @exception EventException
	 */
	public EventResponse searchCheckPortCode(Event e) throws EventException {
		try {
			EsdEas0501Event event = (EsdEas0501Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
			String rtn_val = "";
		
			rtn_val = command.searchCheckPortCode(event);

			eventResponse.setETCData("port_cd",rtn_val);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * TERMINAL의 유효한 YARD CODE CHECK한다. <br>
	 * 
	 * @param  e
	 * @return eventResponse
	 * @exception EventException
	 */
	public EventResponse searchCheckTesYardCode(Event e) throws EventException {
		try {
			EsdEas0501Event event = (EsdEas0501Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
			String rtn_val = "";
		
			rtn_val = command.searchCheckTesYardCode(event);

			eventResponse.setETCData("yd_cd",rtn_val);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * TERMINAL의 유효한 COST CODE CHECK한다. <br>
	 * 
	 * @param  e
	 * @return eventResponse
	 * @exception EventException
	 */
	public EventResponse searchCheckTesCostCode(Event e) throws EventException {
		try {
			EsdEas0501Event event = (EsdEas0501Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
			String rtn_val = "";
		
			rtn_val = command.searchCheckTesCostCode(event);

			eventResponse.setETCData("lgs_cost_cd",rtn_val);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * EsdEas0501Event  <br>
	 * TRANSPORTATION의 유효한 COST CODE CHECK한다. <br>
	 * 
	 * @param  e
	 * @return eventResponse
	 * @exception EventException
	 */
	public EventResponse searchCheckTrsCostCode(Event e) throws EventException {
		try {
			EsdEas0501Event event = (EsdEas0501Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
			String rtn_val = "";
		
			rtn_val = command.searchCheckTrsCostCode(event);

			eventResponse.setETCData("lgs_cost_cd",rtn_val);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status Mileage Save 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse multiMileage(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			BnfStatusMlgVO[] voList  = event.getBnfStatusMlgVOs();
			command.multiMileage(voList,event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiMileage"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status Mileage Delete 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse removeMileage(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			BnfStatusMlgVO[] voList  = event.getBnfStatusMlgVOs();
			command.removeMileage(voList,event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiMileage"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status Mileage File Attach 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse modifyMileageFileAttach(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.modifyMileageFileAttach(event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiMileage"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status Mileage File Attach 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse modifyMileageFileAttach2(Event e) throws EventException {
		EsdEas0501Event event = (EsdEas0501Event)e;
		CreditIncentiveStatusBC command = new CreditIncentiveStatusBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.modifyMileageFileAttach2(event);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			//DMT00001 : Data was saved successfully.
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"multiMileage"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0502Event  <br>
	 * Credti & Invcentive Summary by RHQ를 조회한다. <br>
	 * @param  e
	 * @return eventResponse
	 * @exception EventException
	 */
	public EventResponse searchCreditByRhqList(Event e) throws EventException {
		try {
			EsdEas0502Event event = (EsdEas0502Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			CreditIncentiveSummaryBC command = new CreditIncentiveSummaryBCImpl();
		
			List<CreditSmmrRhqVO> list  = command.searchCreditByRhqList(event);

			eventResponse.setRsVoList(list);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * EsdEas0502Event  <br>
	 * Credti & Invcentive Summary by Source를 조회한다. <br>
	 * 
	 * @param  e
	 * @return eventResponse
	 * @exception EventException
	 */
	public EventResponse searchCreditBySourceList(Event e) throws EventException {
		try {
			EsdEas0502Event event = (EsdEas0502Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			CreditIncentiveSummaryBC command = new CreditIncentiveSummaryBCImpl();
		
			List<CreditSmmrSrcVO> list  = command.searchCreditBySourceList(event);
			
			eventResponse.setRsVoList(list);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * EsdEas0502Event  <br>
	 * Credti & Invcentive Summary M&R Mileage를 조회한다. <br>
	 * 
	 * @param  e
	 * @return eventResponse
	 * @exception EventException
	 */
	public EventResponse searchCreditIssuetList(Event e) throws EventException {
		try {
			EsdEas0502Event event = (EsdEas0502Event)e;
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			CreditIncentiveSummaryBC command = new CreditIncentiveSummaryBCImpl();
		
			List<CreditSmmrIssueVO> list  = command.searchCreditIssuetList(event);

			eventResponse.setRsVoList(list);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	

}