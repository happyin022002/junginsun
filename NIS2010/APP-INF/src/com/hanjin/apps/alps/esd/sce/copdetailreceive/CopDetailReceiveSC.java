/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveRSC.java
*@FileTitle : CopDetailReceived RSC
*Open Issues : 
*@Created Date : 2009-08-24
*@FirstModifier : JeongSeon An
*Change history : 
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive;

import com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBC;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceCopSkdHisVO;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
 * NIS2010-CopDetailReceive Business Logic ServiceCommand - NIS2010-CopDetailReceive 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author JeongSeon An
 * @see CopDetailReceiveDBDAO
 * @since J2EE 1.6
 */

public class CopDetailReceiveSC extends ServiceCommandSupport {

	/**
	 * CopDetailReceive system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("CopDetailReceiveRSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * CopDetailReceive system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("CopDetailReceiveRSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-CopDetailReceive system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
/*
* 1.[CTM 외부인터페이스] createCOPMVMT(SceActRcvIfVO actVo)
* 2.[VSK 외부인터페이스] sendVslSkdSceIf(SceActRcvIfVO actVo)
* 3.[322 인터페이스] create322SceIf(SceActRcvIfVO actVo)
* 4.[COP Bound Scheduling] scheduleCopDetailBound(SceCopSkdHisVO skdVo)
* 5.[COP Ocean Scheduling + old)SCE_EST_ETA_VSL_PRC] scheduleCopDetailOcean(SceVpsIfVO skdVo) <==ActualDataReceiveVsl Batch(5) 
* 6.[MVMT(CTM) & 322 Actual Mapping] copDetailReceiveMVMT <==ActualDataReceive Batch
* 7.[SPP Actual Mapping] copDetailReceiveSPP <==ActualDataReceive Batch
* 8.[VSK Actual Mapping] copDetailReceiveVSL <==ActualDataReceive Batch
* 9.[MANUAL Actual Mapping] copDetailReceiveMANUAL
* 10.[REPLAN관련  Actual Mapping] copDetailReceiveREPLAN * */		

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분; Local 테스트를 위한
		if (e.getEventName().equalsIgnoreCase("CopDetailReceiveEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // 1.[CTM 외부인터페이스]
				eventResponse = createCOPMVMT(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // 2.[VSK 외부인터페이스]
				eventResponse = sendVslSkdSceIf(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // 3.[322 인터페이스]
				eventResponse = create322SceIf(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { // 4.[COP Bound Scheduling]
				eventResponse = scheduleCopDetailBound(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) { // 5.[COP Ocean Scheduling]
				eventResponse = scheduleCopDetailOcean(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) { // 6.[MVMT(CTM) & 322 Actual Mapping]
				eventResponse = copDetailReceiveMVMT(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI07)) { // 7.[SPP Actual Mapping]
				eventResponse = copDetailReceiveSPP(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI08)) { // 8.[VSK Actual Mapping]
				//eventResponse = copDetailReceiveVSL(e);
				eventResponse = null;
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI09)) { // 9.[MANUAL Actual Mapping]
				eventResponse = copDetailReceiveMANUAL(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI10)) { // 10.[REPLAN관련  Actual Mapping]
				eventResponse = copDetailReceiveREPLAN(e);
			}
		}
		return eventResponse;	
	}

	/**
	 * CopDetailReceiveEvent : [이벤트]<br>
	 * [비즈니스대상]을 CTM 외부인터페이스 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCOPMVMT(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//CopDetailReceiveEvent event = (CopDetailReceiveEvent)e;
		CopDetailReceiveBC command = new CopDetailReceiveBCImpl();

		try{
			SceActRcvIfVO actVO = new SceActRcvIfVO();
			//테스트할 actVO SetUp START****************************
			//테스트할 actVO SetUp   END****************************
			command.createCOPMVMT(actVO);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * CopDetailReceiveEvent : [이벤트]<br>
	 * [비즈니스대상]을 VSK 외부인터페이스 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendVslSkdSceIf(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//CopDetailReceiveEvent event = (CopDetailReceiveEvent)e;
		CopDetailReceiveBC command = new CopDetailReceiveBCImpl();

		try{
			SceActRcvIfVO actVO = new SceActRcvIfVO();
			//테스트할 actVO SetUp START****************************
			//테스트할 actVO SetUp   END****************************
			command.sendVslSkdSceIf(actVO);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}	

	/**
	 * CopDetailReceiveEvent : [이벤트]<br>
	 * [비즈니스대상]을 322 인터페이스 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse create322SceIf(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//CopDetailReceiveEvent event = (CopDetailReceiveEvent)e;
		CopDetailReceiveBC command = new CopDetailReceiveBCImpl();

		try{
			SceActRcvIfVO actVO = new SceActRcvIfVO();
			//테스트할 actVO SetUp START****************************
			//테스트할 actVO SetUp   END****************************
			command.create322SceIf(actVO);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}	

	/**
	 * CopDetailReceiveEvent : [이벤트]<br>
	 * [비즈니스대상]을 COP Bound Scheduling [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse scheduleCopDetailBound(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//CopDetailReceiveEvent event = (CopDetailReceiveEvent)e;
		CopDetailReceiveBC command = new CopDetailReceiveBCImpl();

		try{
			SceCopSkdHisVO skdVO = new SceCopSkdHisVO();
			//테스트할 skdVO SetUp START****************************
			//테스트할 skdVO SetUp   END****************************
			command.scheduleCopDetailBound(skdVO);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}	

	/**
	 * CopDetailReceiveEvent : [이벤트]<br>
	 * [비즈니스대상]을 COP Ocean Scheduling [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse scheduleCopDetailOcean(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//CopDetailReceiveEvent event = (CopDetailReceiveEvent)e;
		CopDetailReceiveBC command = new CopDetailReceiveBCImpl();

		try{
			SceCopSkdHisVO skdVO = new SceCopSkdHisVO();
			//테스트할 skdVO SetUp START****************************
			//테스트할 skdVO SetUp   END****************************
			command.scheduleCopDetailBound(skdVO);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * CopDetailReceiveEvent : [이벤트]<br>
	 * [비즈니스대상]을 MVMT(CTM) & 322 Actual Mapping [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse copDetailReceiveMVMT(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//CopDetailReceiveEvent event = (CopDetailReceiveEvent)e;
		CopDetailReceiveBC command = new CopDetailReceiveBCImpl();

		try{
			SceActRcvIfVO actVO = new SceActRcvIfVO();
			//테스트할 actVO SetUp START****************************
			//테스트할 actVO SetUp   END****************************
			command.copDetailReceiveMVMT(actVO,"BATCH");
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}	
	/**
	 * CopDetailReceiveEvent : [이벤트]<br>
	 * [비즈니스대상]을 SPP Actual Mapping [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse copDetailReceiveSPP(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//CopDetailReceiveEvent event = (CopDetailReceiveEvent)e;
		CopDetailReceiveBC command = new CopDetailReceiveBCImpl();

		try{
			SceActRcvIfVO actVO = new SceActRcvIfVO();
			//테스트할 actVO SetUp START****************************
			//테스트할 actVO SetUp   END****************************
			command.copDetailReceiveSPP(actVO,"BATCH");
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

//	/**
//	 * CopDetailReceiveEvent : [이벤트]<br>
//	 * [비즈니스대상]을 VSK Actual Mapping [행위]합니다.<br>
//	 * 
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse copDetailReceiveVSL(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		CopDetailReceiveEvent event = (CopDetailReceiveEvent)e;
//		CopDetailReceiveBC command = new CopDetailReceiveBCImpl();
//
//		try{
//			SceActRcvIfVO actVO = new SceActRcvIfVO();
//			//테스트할 actVO SetUp START****************************
//			//테스트할 actVO SetUp   END****************************
//			command.copDetailReceiveVessel(actVO,"BATCH");
//
//			
//		}catch(EventException ex){
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}catch(Exception ex){
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}	
//		return eventResponse;
//	}
	/**
	 * CopDetailReceiveEvent : [이벤트]<br>
	 * [비즈니스대상]을 MANUAL Actual Mapping [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse copDetailReceiveMANUAL(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//CopDetailReceiveEvent event = (CopDetailReceiveEvent)e;
		//CopDetailReceiveBC command = new CopDetailReceiveBCImpl();

		try{
			//SceActRcvIfVO actVO = new SceActRcvIfVO();
			//테스트할 actVO SetUp START****************************
			//테스트할 actVO SetUp   END****************************
			//command.copDetailReceiveMANUAL(actVO);
			
//		}catch(EventException ex){
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * CopDetailReceiveEvent : [이벤트]<br>
	 * [비즈니스대상]을 REPLAN관련  Actual Mapping [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse copDetailReceiveREPLAN(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//CopDetailReceiveEvent event = (CopDetailReceiveEvent)e;
		CopDetailReceiveBC command = new CopDetailReceiveBCImpl();

		try{
			SceActRcvIfVO actVO = new SceActRcvIfVO();
			//테스트할 actVO SetUp START****************************
			//테스트할 actVO SetUp   END****************************
			command.copDetailReceiveREPLAN(actVO);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

}