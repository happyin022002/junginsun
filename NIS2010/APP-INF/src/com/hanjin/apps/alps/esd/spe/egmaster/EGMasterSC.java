/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EGMasterSC.java
*@FileTitle : Evaluation Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster;

import java.util.List;
import com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.basic.EvaluationGroupBC;
import com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.basic.EvaluationGroupBCImpl;
import com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.event.EsdSpe1001Event;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.vo.SpeEGCreVO;
import com.hanjin.apps.alps.esd.spe.egmaster.kpicodecreation.basic.KPICodeCreationBC;
import com.hanjin.apps.alps.esd.spe.egmaster.kpicodecreation.basic.KPICodeCreationBCImpl;
import com.hanjin.apps.alps.esd.spe.egmaster.kpicodecreation.event.EsdSpe1005Event;
import com.hanjin.apps.alps.esd.spe.egmaster.kpicodecreation.vo.KPICodeCreVO;
import com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.basic.SPServiceCategoryBC;
import com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.basic.SPServiceCategoryBCImpl;
import com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.event.EsdSpe1003Event;
import com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.vo.SpeSvcCateVO;


/**
 * ALPS-EGMaster Business Logic ServiceCommand - ALPS-EGMaster 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author HI
 * @see EvaluationGroupDBDAO
 * @since J2EE 1.6
 */

public class EGMasterSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * EGMaster system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("EGMasterSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * EGMaster system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("EGMasterSC 종료");
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
		if (e.getEventName().equalsIgnoreCase("EsdSpe1001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // 저장한다
				eventResponse = multiEGCre(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // EG 데이터를 조회한다
				eventResponse = searchEGData(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // 저장전 저장할수 있는 데이터 인지 확인한다.
				eventResponse = searchEGDataChk(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EsdSpe1003Event")){
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // 저장한다
				eventResponse = multiSpSvcCateCfm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //업체의 서비스 카테고리 정보를 조회한다.
				eventResponse = searchSpSvcCateCfm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) { //저장전 저장할수 있는 데이터 인지 확인한다
				eventResponse = searchSpSvcCateCfmChk(e);
			}
			
			
		}else if(e.getEventName().equalsIgnoreCase("EsdSpe1005Event")){
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // 저장한다
				eventResponse = multiKPICodeCre(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //업체의 서비스 카테고리 정보를 조회한다.
				eventResponse = searchKPICodeCre(e);
			}
		}
		return eventResponse;
	}

	/**
	 * EG 데이터를 입력/수정/삭제 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiEGCre(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1001Event event = (EsdSpe1001Event)e;
		EvaluationGroupBC command = new EvaluationGroupBCImpl();
		
		try{
			begin();
			command.multiEGCre(event.getSpeEGCreVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"addEGCre"}).getMessage(), ex);
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
	private EventResponse searchEGData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1001Event event = (EsdSpe1001Event)e;
		EvaluationGroupBC command = new EvaluationGroupBCImpl();
		
		try{
			List<SpeEGCreVO> list = command.searchEGData(event.getSpeEGCreVO());
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
	private EventResponse searchEGDataChk(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1001Event event = (EsdSpe1001Event)e;
		EvaluationGroupBC command = new EvaluationGroupBCImpl();
		
		try{
			List<SpeEGCreVO> list = command.searchEGDataChk(event.getSpeEGCreVO());
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
	 *  S/P Service Category Confirm 을 입력/수정/삭제 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpSvcCateCfm(Event e) throws EventException { 
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1003Event event = (EsdSpe1003Event)e;
		SPServiceCategoryBC command = new SPServiceCategoryBCImpl();
		
		try{
			begin();
			command.multiSpSvcCateCfm(event.getSpeSvcCateVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"addEGCre"}).getMessage(), ex);
		}	
		return eventResponse;
	}
	
	
	/**
	 * 업체의 서비스 카테고리 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpSvcCateCfm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		EsdSpe1003Event event = (EsdSpe1003Event)e;
		SPServiceCategoryBC command = new SPServiceCategoryBCImpl();
		
		try{
			eventResponse = command.searchSpSvcCateCfm(event);
			
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEGCre"}).getMessage(), ex);
		}	
		return eventResponse;
	}	
	
	/**
	 * 저장전 저장할수 있는 데이터 인지 확인한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpSvcCateCfmChk(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1003Event event = (EsdSpe1003Event)e;
		SPServiceCategoryBC command = new SPServiceCategoryBCImpl();
		
		try{
			List<SpeSvcCateVO> list = command.searchSpSvcCateCfmChk(event.getSpeSvcCateVO());
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
	 * KPI Code Creation 데이터를 입력/수정/삭제 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiKPICodeCre(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1005Event event = (EsdSpe1005Event)e;
		KPICodeCreationBC command = new KPICodeCreationBCImpl();
		
		try{
			begin();
			command.multiKPICodeCre(event.getkPICodeCreVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"addEGCre"}).getMessage(), ex);
		}	
		return eventResponse;
	}
	
	
	/**
	 * KPI Code Creation 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKPICodeCre(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1005Event event = (EsdSpe1005Event)e;
		KPICodeCreationBC command = new KPICodeCreationBCImpl();
		
		try{
			List<KPICodeCreVO> list = command.searchKPICodeCre(event.getkPICodeCreVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEGCre"}).getMessage(), ex);
		}	
		return eventResponse;
	}		
	
}