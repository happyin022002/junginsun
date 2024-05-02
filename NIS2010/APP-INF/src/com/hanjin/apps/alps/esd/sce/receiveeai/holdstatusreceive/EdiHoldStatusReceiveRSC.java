/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EdiHoldStatusReceiveRSC
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013-06-25
*@LastModifier :
*@LastVersion : 1.0
* 2013-06-25
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.receiveeai.holdstatusreceive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.receiveeai.holdstatusreceive.basic.EdiHoldStatusReceiveBC;
import com.hanjin.apps.alps.esd.sce.receiveeai.holdstatusreceive.basic.EdiHoldStatusReceiveBCImpl;
import com.hanjin.apps.alps.esd.sce.receiveeai.holdstatusreceive.event.EsdSce0152Event;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
/**
 * ALPS-SCE EDI_HOLD_STATUS_MSG Logic ServiceCommand<br>
 * - ALPS-SCE에 EDI_HOLD_STATUS_MSG 대한 비지니스 트랜잭션을 처리한다.<br>
 * @param 
 * @author Sang-Jun Kwon 
 * @see 
 * @since J2EE 1.4
 */
public class EdiHoldStatusReceiveRSC extends ServiceCommandSupport {

	/**
	 * EdiHoldStatusReceiveRSC 업무 시나리오 선행작업<br>
	 * EdiHoldStatusReceiveRSC 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("EdiHoldStatusReceiveRSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * EdiHoldStatusReceiveRSC 업무 시나리오 마감작업<br>
	 * EdiHoldStatusReceiveRSC 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("EdiHoldStatusReceiveRSC 종료");
	}
	
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ENIS-SCEM 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("EsdSce0152Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = createHoldStatusData(e);
			}
		}
		
		return null;
	}
	
	
	/**
	 * Hold Staus DATA를 생성한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createHoldStatusData(Event e) throws EventException {

		EventResponse eventResponse = new GeneralEventResponse();
		EdiHoldStatusReceiveBC command = null;
		String str = "";
		
		try {
			command = new EdiHoldStatusReceiveBCImpl();
			str = ((EsdSce0152Event)e).getString();
			
			/*  넘어온 전문을 HEADER/RELEASE로 분해한다.  */
			 log.info("\n\n\n Hold Staus Full String : \n\n\n"+str);
			 HashMap<String, String> holdStatusHeader  = null;
			 HashMap<String, String>[] holdStatusRelease = null;
			
			//1.parsing 
			//begin();
			 holdStatusHeader = command.getHoldStatusHeaderdData(str);
			 holdStatusRelease = command.getHoldStatusReleaseData(str);
			//commit();
			
			//2.db저장
			log.info(")int releaseCnt = "+ holdStatusRelease.length);
			for(int i=0; i< holdStatusRelease.length;i++){
				command.updateHoldStatus(holdStatusHeader, holdStatusRelease[i]);
			}
			
//			Iterator itr =totParamArrLst.iterator();
//			while(itr.hasNext()){
//				param =(HashMap)itr.next();
////				createEDI322dataLoopUnit(param, command); 
//			}
			//commit();
			
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse; 
	}

}
