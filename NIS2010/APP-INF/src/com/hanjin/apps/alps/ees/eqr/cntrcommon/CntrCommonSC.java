/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrCommonSC.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-27
*@LastModifier : SHIN DONG IL
*@LastVersion : 2013-05-27
* 2006-10-11 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrcommon;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.basic.CommonBC;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.basic.CommonBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.event.EesCommonEvent;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.EesCommonVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-Common Business Logic ServiceCommand
 * - alps-Common에 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author 김원섭
 * @see ComboxEventResponse,CommonDBDAO
 * @since J2EE 1.4
 */

public class CntrCommonSC extends ServiceCommandSupport {

	SignOnUserAccount account = null; 

	/**
	 * Common 업무 시나리오 선행작업<br>
	 * Common업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("CntrCommonSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * Common 업무 시나리오 마감작업<br>
	 * Common업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CntrCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * alps-Common 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		
		if(e.getFormCommand().isCommand(FormCommand.SEARCH12)) { // LOC YARD INITIAL VESSEL SEARCH
			eventResponse = searchLocYardInitialInfo(e);
						
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // LOC YARD EXIST
			eventResponse = searchLocYardExist(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST20)) { // LOC YARD(vessel) MULTI COMBO BOX
			log.debug("SC 20 ======");
			eventResponse = searchLocYardVesselInfo(e);
			
		}
		
		if (e.getEventName().equalsIgnoreCase("EesEqrCodEvent")) {
			if (   e.getFormCommand().isCommand(FormCommand.SEARCHLIST01 )
				|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchCommonCodeList(e);
			}
		}
		return eventResponse; 
	}



	/**
	 * 조회 이벤트 처리<br>
	 * Common의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonCodeList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CommonBC command = new CommonBCImpl();
			eventResponse = command.searchCommonCodeList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * LOC YARD initial 조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/ 
	private EventResponse searchLocYardInitialInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try { 
			CommonBC command = new CommonBCImpl();
			retVO = command.searchLocYardInitialInfo(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			// 사용자 ViewAdapter 에 ConditionVo 와 ResultVo 를 담기 위한 List 객체구현
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * LOC YARD EXIST  이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLocYardExist(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			
			log.debug("------------------- CNTRCOMMONSC");
			
			retVO = command.searchLocYardExist(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			// 사용자 ViewAdapter 에 ConditionVo 와 ResultVo 를 담기 위한 List 객체구현
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * LOC YARD - vessel 조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLocYardVesselInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			
			log.debug("SC 20 searchLocYardVesselInfo======");
			
			retVO = command.searchLocYardVesselInfo(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			// 사용자 ViewAdapter 에 ConditionVo 와 ResultVo 를 담기 위한 List 객체구현
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			//eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		


}