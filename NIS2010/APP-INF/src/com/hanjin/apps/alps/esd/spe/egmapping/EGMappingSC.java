/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EGMappingSC.java
*@FileTitle : EG vs Evaluator Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmapping;

import java.util.List;
import com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.basic.EGandEvaluatorBC;
import com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.basic.EGandEvaluatorBCImpl;
import com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.event.EsdSpe1006Event;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.vo.SpeEGEVMappingVO;
import com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.basic.EvaluationGroupMappingBC;
import com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.basic.EvaluationGroupMappingBCImpl;
import com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.event.EsdSpe1008Event;
import com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.vo.EGAndBEMappingVO;


/**
 * ALPS-EGMapping Business Logic ServiceCommand - ALPS-EGMapping 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author HI
 * @see EGandEvaluatorDBDAO
 * @since J2EE 1.6
 */

public class EGMappingSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * EGMapping system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("EGMappingSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * EGMapping system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("EGMappingSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-SpeMst system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdSpe1006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Basic Evaluator 를 조회한다.
				eventResponse = searchEGEVBasic(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // Performance Evaluator 를 조회한다.
				eventResponse = searchEGEVPerformance(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // EG vs Evalulator Mapping 화면을 저장한다.
				eventResponse = multiEGEVMapping(e);
			}
		}if (e.getEventName().equalsIgnoreCase("EsdSpe1008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) { // Basic Evaluation 데이터를 조회한다.
				eventResponse = searchBECode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) { // Basic Evaluation 데이터가 저장가능 한지 확인한다.
				eventResponse = searchEGBEMappingChk(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Evaluation Group Mapping & Basic Evaluation 화면을 조회한다.
				eventResponse = searchEGBEMapping(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {   // Evaluation Group Mapping & Basic Evaluation 화면을 저장/수정/삭제 한다.
				eventResponse = multiEGBEMapping(e);
			}
		}
		
		
		return eventResponse;
	}	


	/**
	 * Basic Evaluator 를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEGEVBasic(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1006Event event = (EsdSpe1006Event)e;
		EGandEvaluatorBC command = new EGandEvaluatorBCImpl();
		
		try{
			List<SpeEGEVMappingVO> list = command.searchEGEVBasic(event.getSpeEGEVMappingVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEGCre"}).getMessage(), ex);
		}	
		return eventResponse;
	}		
	
	/**
	 * EG 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEGEVPerformance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1006Event event = (EsdSpe1006Event)e;
		EGandEvaluatorBC command = new EGandEvaluatorBCImpl();
		
		try{
			List<SpeEGEVMappingVO> list = command.searchEGEVPerformance(event.getSpeEGEVMappingVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEGCre"}).getMessage(), ex);
		}	
		return eventResponse;
	}		
	
	
	/**
	 * EG vs Evalulator Mapping 화면을 저장한다..<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiEGEVMapping(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1006Event event = (EsdSpe1006Event)e;
		EGandEvaluatorBC command = new EGandEvaluatorBCImpl();
		
		try{
			begin();
			command.multiEGEVMapping(event.getSpeEGEVMappingVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEGCre"}).getMessage(), ex);
		}	
		return eventResponse;
	}
	
	
	/**
	 * Basic Evaluation 데이터가 저장가능 한지 확인한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEGBEMappingChk(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1008Event event = (EsdSpe1008Event)e;
		EvaluationGroupMappingBC command = new EvaluationGroupMappingBCImpl();
		
		try{
			List<EGAndBEMappingVO> list = command.searchEGBEMappingChk(event.getEgAndBEMappingVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEGCre"}).getMessage(), ex);
		}	
		return eventResponse;
	}		
	
	
	/**
	 * Evaluation Group Mapping & Basic Evaluation 화면을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEGBEMapping(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1008Event event = (EsdSpe1008Event)e;
		EvaluationGroupMappingBC command = new EvaluationGroupMappingBCImpl();
		
		try{
			List<EGAndBEMappingVO> list = command.searchEGBEMapping(event.getEgAndBEMappingVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEGCre"}).getMessage(), ex);
		}	
		return eventResponse;
	}		
	
	/**
	 * Basic Evaluation 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBECode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1008Event event = (EsdSpe1008Event)e;
		EvaluationGroupMappingBC command = new EvaluationGroupMappingBCImpl();
		
		try{
			List<EGAndBEMappingVO> list = command.searchBECode(event.getEgAndBEMappingVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEGCre"}).getMessage(), ex);
		}	
		return eventResponse;
	}		


	/**
	 * Evaluation Group Mapping & Basic Evaluation 화면을 저장/수정/삭제 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiEGBEMapping(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1008Event event = (EsdSpe1008Event)e;
		EvaluationGroupMappingBC command = new EvaluationGroupMappingBCImpl();
		
		try{
			begin();
			command.multiEGBEMapping(event.getEgAndBEMappingVOs(),account);  
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEGCre"}).getMessage(), ex);
		}	
		return eventResponse;
	}
	
	
}


