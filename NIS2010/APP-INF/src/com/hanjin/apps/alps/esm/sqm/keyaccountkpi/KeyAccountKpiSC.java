/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : KeyAccountKpiSC.java
*@FileTitle      : KeyAccountKpi
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.30
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.30 이혜민
* 1.0 Creation
* 2014.01.16 PEJ [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2015.04.15 김용습 [CHM-201535206] KPI Management "Week" 조건 추가
* 2015.04.27 김용습 [CHM-201535626] (SQM) TPS 자리수 Validation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.keyaccountkpi;

import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.sqm.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.basic.KeyAccountKpiBC;
import com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.basic.KeyAccountKpiBCImpl;
import com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.event.EsmSqm0601Event;
import com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.integration.KeyAccountKpiDBDAO;
import com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.vo.SearchKpiUploadVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-KeyAccountKpi Business Logic ServiceCommand - ALPS-KeyAccountKpi 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author HYEMIN LEE
 * @see KeyAccountKpiDBDAO
 * @since J2EE 1.6
 */

public class KeyAccountKpiSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * KeyAccountKpi system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("KeyAccountKpiSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * KeyAccountKpi system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("KeyAccountKpiSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-DataManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmSqm0601Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0601(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKpiUpload(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = search1QTransferDataCnt(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchWeekCombo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageKpiUpload(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = create1QTransferData(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0504 : [INIT]
	 * 공통코드 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0601(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""},
					/* 4. Trade */
					{"mdmTrade", "", "All"},
					/* 5. Bound. */
					{"comCodeBound", "", "All"},
					/* 6. Account Group. */
					{"comCodeAccGrp", "", "All"}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0601 : [SEARCH]<br>
	 * [KPI Upload]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKpiUpload(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0601Event event = (EsmSqm0601Event)e;
		KeyAccountKpiBC command = new KeyAccountKpiBCImpl();
		
		try{
			List<SearchKpiUploadVO> list = command.searchKpiUpload(event.getConditionVO());
			String dataCnt = command.searchKpiUploadCnt(event.getConditionVO());
			
			eventResponse.setETCData("dataCnt", dataCnt);
			eventResponse.setRsVoList(list);
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
	 * ESM_SQM_0601 : [SEARCH01]<br>
	 * [KPI Upload]화면에서 Yearly 조회 후 Quarterly 1Q 데이터가 있는지 없는지 [확인]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse search1QTransferDataCnt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0601Event event = (EsmSqm0601Event)e;
		KeyAccountKpiBC command = new KeyAccountKpiBCImpl();
		
		try{
			String dataCnt = command.search1QTransferDataCnt(event.getConditionVO());
			
			eventResponse.setETCData("dataCnt", dataCnt);
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
	 * ESM_SQM_0601 : [MULTI]<br>
	 * [KPI Upload]을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageKpiUpload(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0601Event event = (EsmSqm0601Event)e;
		KeyAccountKpiBC command = new KeyAccountKpiBCImpl();

		try {
			begin();
			command.manageKpiUpload(event.getConditionVO(), event.getSqmKeyAcctCfmQtaVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0601 : [MULTI01]<br>
	 * [KPI Upload]화면에서 [1Q Data]을 [Transfer] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse create1QTransferData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0601Event event = (EsmSqm0601Event)e;
		KeyAccountKpiBC command = new KeyAccountKpiBCImpl();

		try {
			begin();
			command.create1QTransferData(event.getConditionVO(), account.getUsr_id());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0601: 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeekCombo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0601Event event = (EsmSqm0601Event)e;
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Week */
					{"week", "", "All"}
			};
			eventResponse = codeUtil.getMakeCodeSelectListForPlanning(event.getConditionVO(),account, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	
}