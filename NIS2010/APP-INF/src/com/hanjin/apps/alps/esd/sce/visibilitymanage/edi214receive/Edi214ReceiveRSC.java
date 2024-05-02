/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Edi214ReceiveRSC
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2008-08-01
*@LastModifier :
*@LastVersion : 1.0
* 2006-08-02 
* 1.0 최초 생성
* 2011.12.01 전준영 [CLT-111121289]Split R4J 소스품질 결함 조치 - Null Dereferencing(객체에 NULL이 배정된 이후 객체에 대한 참조를 하지 말아야 한다
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive;

import com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive.basic.Edi214ReceiveBC;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive.basic.Edi214ReceiveBCImpl;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive.event.EsdSce0085Event;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive.vo.SearchActualDateInfoVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
 * ENIS-SCE EDI_214_MSG Logic ServiceCommand<br>
 * - ENIS-SCE에 EDI_214_MSG에 대한 비지니스 트랜잭션을 처리한다.<br>
 * @param 
 * @author yjlee
 * @see EsdSce0085Event, EsdSce0085EventResponse
 * @since J2EE 1.4
 */
public class Edi214ReceiveRSC extends ServiceCommandSupport {


	/**
	 * SCE 업무 시나리오 선행작업<br>
	 * ExceptionManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("Edi214ReceiveRSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * SCE 업무 시나리오 마감작업<br>
	 * ExceptionManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("Edi214ReceiveRSC 종료");
	}
	
	

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ENIS-SCE 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		EventResponse eventResponse = null;
		log.debug("\n 여기는 edi214SC perform");
		if (e.getEventName().equalsIgnoreCase("EsdSce0085Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = createEDI214data(e);
			}
		}
		
		return null;
	}
	
	/**
	 * 214 Message 를 분리하여 Update 한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse createEDI214data(Event e) throws EventException {
//		EventResponse eventResponse = null;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		Edi214ReceiveBC command = null;
		String str = "";
		
		try {
			command = new Edi214ReceiveBCImpl();
			str = ((EsdSce0085Event)e).getString(); 
			/*str = " $$$MSGSTART:CFMM                TEST                214       000061998         \n" +
			" {HDR                                                                            \n" +
			" WONO:MEM3499173                                                                 \n" +
			" SONO:MEM13221760                                                                \n" +
			" BLNO:HKGA25809607                                                               \n" +
			" BKGNO:HKGZ3270362                                                               \n" +
			" }HDR                                                                            \n" +
			" {CNTR                                                                           \n" +
			" EQNO:TRLU597170                                                                 \n" +
			" STATUS:                                                                         \n" +
			" STATUS_REASON:                                                                  \n" +
			" APP_STATUS:AB                                                                   \n" +
			" APP_STATUS_REASON:NA                                                            \n" +
			" STATUS_DATE:20070611                                                            \n" +
			" STATUS_TIME:0400                                                                \n" +
			" STATUS_TIMECODE:LT                                                              \n" +
			" E_CITY:MEMPHIS                                                                  \n" +
			" E_STATE:TN                                                                      \n" +
			" E_COUNTRY:US                                                                    \n" +
			" STOP_SEQ:1                                                                      \n" +
			" }CNTR                                                                           \n" +
			" {LOC                                                                            \n" +
			" LOC_TYPE:CN                                                                     \n" +
			" LOC_NAME:PROTECTIVE INDUSTRIAL PRODUCTS                                         \n" +
			" LOC_ADDR:3531 LAMAR AVENUE SUITE 111                                            \n" +
			" LOC_ADDR2:                                                                      \n" +
			" LOC_CITY:MEMPHIS                                                                \n" +
			" LOC_STATE:TN                                                                    \n" +
			" LOC_ZIP:38118                                                                   \n" +
			" LOC_COUNTRY:                                                                    \n" +
			" }LOC                                                                            \n";
			*/
			log.info("\n\n\n Full String : \n\n\n"+str);
			
			//Edi214MsgVO msgVo = new Edi214MsgVO();
			SearchActualDateInfoVO msgVo = new SearchActualDateInfoVO();
			/*  넘어온 전문을 HDR/CNTR/LOC로 분해한다.  */
			msgVo = command.getEDI214DataFormat(str);
			
			log.debug("msgVO.getBkgNo == " + msgVo.getBkgNo());
			
			//begin();
			/*  분해된 HDR/CNTR_LIST/LOC로 임시 TABLE에 넣는다.  */
			command.createEDI214TmpData(msgVo);
			//commit();
			
			
			//begin();
			/* 임시로 입력된 data의 유효성 검사 */
			command.confirmEDI214(msgVo);
			//commit();
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;

		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
