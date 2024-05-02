/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonSC.java
*@FileTitle : EQR공통모듈
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.13 채창호
* 1.0 Creation
*Change history  -------------------------------------------------------------------
* No.   Ver.     Modifier             modifier date    explanation
* 1      1.0       ChangHoChae    2006-09-13      최초 생성
* 2      1.35     ChangHoChae     2008-06-26      CSR No : N200806030017 -
* 3      1.36     chae chang ho    2008-11-20      CSR No : N200811110008 - User 가 Vessel SKD 업데이트 할 수 있도록 시스템 보완.
* 4      1.37     HaengJi, Lee       2009-02-10      신규프로젝트 No  - [ S2Q-09P-004 ], Bay Plan I/F 화면추가에 따른 메소드 추가 - searchBayPlan
* 5      1.38     HaengJi, Lee       2009-04-22      CSR No : N200904200110 - VVD Add 추가기능으로 인해 SEARCH10에 해당하는 로직 , searchLane 메소드 추가
* 6      2.0     EunHo Chung       2009-08-04      new FrameWork 변경작업
* 7	   2.1      Lee Byoung Hun  2010-05-11		CSR No : CHM-201003779 - checkEqrAccess 메소드 추가
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common;

import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.event.EesEqr0105Event;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.basic.CommonBC;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.basic.CommonBCImpl;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.event.EesCommonEvent;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration.CommonDBDAO;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.EesCommonVO;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

import java.util.ArrayList;
import java.util.List;


/**
 * ALPS-Common Business Logic ServiceCommand - ALPS-Common 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Chae Change Ho
 * @see CommonDBDAO
 * @since J2EE 1.6
 */

public class EQRCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Common system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 * 
	 */
	public void doStart() {
		log.debug("CommonSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Common system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-Common system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
			eventResponse = scnridReMarkSearch(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
			eventResponse = checkEccCode(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
			eventResponse = repoidReMarkSearch(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
			eventResponse = checkLocCode(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) { // LOC YARD MULTI COMBO BOX
			eventResponse = searchLocYardInfo(e);

		}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {     //  LOC YARD COMPANY MULTI COMBO BOX
			eventResponse = searchLocYardCompanyInfo(e);

		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) { // VENDOR MULTI COMBO BOX
			eventResponse = searchVendorInfo(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST07)) { 
			eventResponse = checkLocCodeWithMaster(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST08)) { // VVD MULTI COMBO BOX
			eventResponse = searchVvdInfo(e);		
					
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST09)) { // LOC YARD-ECC MULTI COMBO BOX
			eventResponse = searchLocYardEccInfo(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) { //Get SCNR_ID 
			eventResponse = searchWeekScnrId(e);					
								
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)) {
			eventResponse = searchCountryInfo(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST14)) {
			eventResponse = searchCheckPeriod(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST15)) {
			eventResponse = searchCheckPeriodOpt(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST16)){
			eventResponse = searchBetweenWeek(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST17)){
			eventResponse = searchWeekDatePeriod(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST18)){
			eventResponse = searchEtaDate(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST19)) { // LOC YARD MULTI COMBO BOX(임대사 포함)
			eventResponse = searchLseCoYardInfo(e);
						
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST20)) { // LOC YARD(vessel) MULTI COMBO BOX
			eventResponse = searchLocYardVesselInfo(e);
		
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) { // SEARCH VENDOR INFO BY SEQ
			eventResponse = searchVendorInfoBySeq(e);
		
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // LOC YARD INITIAL SEARCH
			eventResponse = searchLocYardInitialInfo(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // LOC YARD EXIST
			eventResponse = searchLocYardExist(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // COMPANY LOC YARD EXIST
			eventResponse = searchLocYardCompanyExist(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) { // VVD CODE EXIST
			eventResponse = searchVvdExist(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)) { // VVD INLAND INFO
			eventResponse = searchVvdInlandInfo(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCH07)) {  // SEARCH  duplicate_check POD
			eventResponse = searchDuplicatCheckPod(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCH08)) {  // SEARCH  checkPeriod -8 
			eventResponse = searchBeforeCheckPeriod(e);
			
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCH09)) {  // vessel skd 체크 -8 
			eventResponse = searchVesselScheduleCheck(e);
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)) {  // BayPort List
			eventResponse = searchBayPort(e);
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)) {  // BayPort List
			eventResponse = searchLane(e);
		}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchEQRAdjust(e);
		}else if(e.getFormCommand().isCommand(FormCommand.SEARCH11)) {  // EQR All-Weeks' Plan Access Grant Check
			eventResponse = checkEqrAccess(e);
		}
		
		return eventResponse;
	}
	
	/**
	 * Common : [이벤트]<br>
	 * ECC_CD 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse (EesCommonVO)getCustomData("RetVO")
	 * @exception EventException
	 */
	private EventResponse checkEccCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		CommonBC command = new CommonBCImpl();
		String ecc_cd = event.getEesCommonConditionVO().getEcccd();
		try{
			retVO = command.checkEccCode(ecc_cd);
			//eventResponse.setCustomData("RetVO", retVO);
			// 사용자 ViewAdapter 에 ConditionVo 와 ResultVo 를 담기 위한 List 객체구현
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
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
	private EventResponse scnridReMarkSearch(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			retVO =  command.scnridReMarkSearch(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
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
	private EventResponse repoidReMarkSearch(Event e) throws EventException {

		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 

		try {
			CommonBC command = new CommonBCImpl();
			retVO =  command.repoidReMarkSearch(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
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
	private EventResponse checkLocCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 

		try {
			CommonBC command = new CommonBCImpl();
			retVO =  command.checkLocCode(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
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
	private EventResponse checkLocCodeWithMaster(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 

		try {
			CommonBC command = new CommonBCImpl();
			retVO =  command.checkLocCodeWithMaster(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
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
	 * LOC YARD Company EXIST  이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLocYardCompanyExist(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchLocYardCompanyExist(event.getEesCommonConditionVO());
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
	 * LOC YARD 조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLocYardInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchLocYardInfo(event.getEesCommonConditionVO());
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
	 * 임대사 YARD 조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLseCoYardInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchLseCoYardInfo(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			List<CommonVO> voList = new ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			voList.add(commonVO);
			eventResponse.setRsVoList(voList);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * LOC YARD - ECC 조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLocYardEccInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchLocYardEccInfo(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * VENDOR 조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchVendorInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchVendorInfo(event.getEesCommonConditionVO());
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
	 * VENDOR Company 조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLocYardCompanyInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchLocYardCompanyInfo(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * VENDOR 조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchVendorInfoBySeq(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchVendorInfoBySeq(event.getEesCommonConditionVO());
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
	 * VVD 조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchVvdInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchVvdInfo(event.getEesCommonConditionVO());
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
	 * VVD Inland Info 조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchVvdInlandInfo(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchVvdInlandInfo(event.getEesCommonConditionVO());
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
	 * VVD Code 조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchVvdExist(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchVvdExist(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Week에 대한 Scnr_id 조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchWeekScnrId(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchWeekScnrId(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * Country 조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchCountryInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchCountryInfo(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * 입력된 from week에 대한 최대 to week 조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchCheckPeriod(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			
			retVO = command.searchCheckPeriod(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * 입력된 from week에 대한 최대 to week 조회 이벤트 처리(FM, TO, AT)<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchCheckPeriodOpt(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			
			retVO = command.searchCheckPeriodOpt(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * 조회 이벤트 처리<br>
	 * Common의 event에 대한 특정 리스트 조회 이벤트 처리(주간일주일 날짜를 구한다)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBetweenWeek(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 

		try {
			CommonBC command = new CommonBCImpl();
			retVO =  command.searchBetweenWeek(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			// 사용자 ViewAdapter 에 ConditionVo 와 ResultVo 를 담기 위한 List 객체구현
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Week Date Period(fromdate, todate) 조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchWeekDatePeriod(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchWeekDatePeriod(event.getEesCommonConditionVO());
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
	 * Eta Date  조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchEtaDate(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchEtaDate(event.getEesCommonConditionVO());
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
	 * duplicate_check POD 조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchDuplicatCheckPod(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchDuplicatCheckPod(event.getEesCommonConditionVO());
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
	 * 입력된 from week에 대한 최대 to week 조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchBeforeCheckPeriod(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			
			retVO = command.searchBeforeCheckPeriod(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * VESSEL 스케즐을 VSK_VSL_PORT_SKD에서 체크를 해서 값을 가져온다. <br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchVesselScheduleCheck(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			
			retVO = command.searchVesselScheduleCheck(event.getEesCommonConditionVO());
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
	 * BayPort 조회 이벤트 처리<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchBayPort(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchBayPort(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * CSR No : N200904200110 <br>
	 * Scenario vessel schedule에 신규 VVD추가시 해당 Lane 조회  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLane(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO 
		try {
			CommonBC command = new CommonBCImpl();
			
			retVO = command.searchLane(event.getEesCommonConditionVO());
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
	 * 조회 이벤트 처리<br>
	 * EQRAdjust의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQRAdjust(Event e) throws EventException {
		
		EesEqr0105Event event = (EesEqr0105Event)e;  	// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();  			// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		String eccString = "";
		try {
			CommonBCImpl commonImpl = new CommonBCImpl();
			eccString = commonImpl.convertECCInfoString(event.getStatus(), event.getLocation()).getResultString();
			eventResponse.setCustomData("eccString", eccString);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * EQR VL-VD 전주차 접근권한 유저 여부 확인
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkEqrAccess(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC command = new CommonBCImpl();
		
		String ofcCd = "";

		try{
			CommonVO commonVO = command.getUserInfo(account.getUsr_id());
			
			DBRowSet rowSet = commonVO.getDbRowset();
			if (rowSet != null) {
				while (rowSet.next()) {
					ofcCd = JSPUtil.getNull(rowSet.getString("OFC_CD"));
				}
			}
			
			eventResponse.setETCData("ofcCd", ofcCd);
			
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
