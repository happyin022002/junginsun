/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EQBalanceSC.java
*@FileTitle : Repo U/C 
*Open Issues :
*@LastModifyDate : 2009.08.28
*@LastModifier : 박수훈
*@LastVersion : 1.11
* 2006-11-16 Sangwook_Nam
* 1.0 최초 생성
* 
* Change history : 2008.02.18 전윤주 132번 화면 source 삭제
*                : CSR No.N200808260006 EQ repo contribution From - To 로 setting 하면서 17번 화면 source 삭제
* 2009.08.28 박수훈  New FrameWork 적용 [0019]
* 2009.09.07 박수훈  New FrameWork 적용 [0018]
* 2009.09.21 장영석  New FrameWork 적용 [0016]
* 2009.10.08 박수훈  New FrameWork 적용 [0161] 
* 2009.10.09 박수훈  New FrameWork 적용 [0136]
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
* 2012.03.22 김종준 [CHM-201217091-01] EMU 관련 로직 보완/변경 검토 요청의 건 -POR 별 Credit Ratio를 setup 할수 있는 화면추가 (Rule-set) 
=========================================================*/
package com.hanjin.apps.alps.esm.coa.eqbalance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.hanjin.apps.alps.esm.coa.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.coa.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.coa.common.vo.GetCodeSelectVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.basic.EQBalanceBC;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.basic.EQBalanceBCImpl;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.event.EsmCoa0016Event;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.event.EsmCoa0018Event;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.event.EsmCoa0019Event;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.event.EsmCoa0136Event;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.event.EsmCoa0161Event;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.integration.EQBalanceDBDAO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance00163ListVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance0016ListVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance0018ListVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance0019ListVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance0136ListVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance0161ListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-COA Business Logic ServiceCommand<br>
 * - ALPS-COA에 대한 비지니스 트랜잭션을 처리한다.<br>
 *
 * @author Sangwook_Nam
 * @see EQBalanceDBDAO 참조
 * @since J2EE 1.6
 */
public class EQBalanceSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * account getter
	 * @return SignOnUserAccount
	 */
	public SignOnUserAccount getAccount() {return this.account;}

	/**
	 * COA 업무 시나리오 선행작업<br>
	 * MultiDimensionRPT업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
		} catch (Exception e) {
            log.error("MultiDimensionRPTSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * COA 업무 시나리오 마감작업<br>
	 * EQBalance업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("EQBalanceSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ENIS-COA 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		log.debug("\n[CALL] Service Command ----------------------------- " +
				  "\n EventName   : " + e.getEventName() +
				  "\n Command     : " + e.getFormCommand().getCommand());
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmCoa0016Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEQBalance00162List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchEQBalance00163List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkEccYn(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = multiEQBalance00163(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST01) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST02) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)
				) {
				eventResponse = searchComBoCdList0016(e);	
			}
		}	

		if (e.getEventName().equalsIgnoreCase("EsmCoa0018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQBalance0018List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiEQBalance0018(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsmCoa0019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQBalance0019List (e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0019(e);	
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsmCoa0136Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQBalance0136List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiEQBalance0136(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsmCoa0161Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQBalance0161List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiEQBalance0161(e);
			}
		}

		return eventResponse;
	}

	/**
	 * ESM_COA_0016 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQBalance00162List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0016Event event = (EsmCoa0016Event)e;
		EQBalanceBC command = new EQBalanceBCImpl();

		try{
			List<SearchConditionVO> list = command.searchEQBalance00162List(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	

	/**
	 * ESM_COA_0016 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQBalance00163List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0016Event event = (EsmCoa0016Event)e;
		EQBalanceBC command = new EQBalanceBCImpl();

		try{
			List<SearchEQBalance00163ListVO> list = command.searchEQBalance00163List(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0016 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiEQBalance00163(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0016Event event = (EsmCoa0016Event)e;
		EQBalanceBC command = new EQBalanceBCImpl();
		try{
			begin();
			String excel_load_yn = (String)e.getAttribute("excel_load_yn");
			command.multiEQBalance00163(event.getCoaCntrRepoShtgInfoVOS(),event.getSearchConditionVO(),account, excel_load_yn);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Set Credit Ratio 팝업 화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0018 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQBalance0018List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0018Event event = (EsmCoa0018Event)e;
		EQBalanceBC command = new EQBalanceBCImpl();

		try{
			List<SearchEQBalance0018ListVO> list = command.searchEQBalance0018List(event.getSearchEQBalance0018ListVO()
					                                                              ,event.getSearchConditionVO());
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
	 * 멀티 이벤트 처리<br>
	 * Set Credit Ratio 팝업 화면에 대한 멀티 이벤트 처리<br>
	 * ESM_COA_0018 수정
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiEQBalance0018(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0018Event event = (EsmCoa0018Event)e;
		EQBalanceBC command = new EQBalanceBCImpl();
		try{
			begin();
			command.multiEQBalance0018(event.getCoaCntrRepoCrVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * EQBalance화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0019 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQBalance0019List (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0019Event event = (EsmCoa0019Event)e;
		EQBalanceBC command = new EQBalanceBCImpl();

		try{
			List<SearchEQBalance0019ListVO> list = command.searchEQBalance0019List (event.getSearchEQBalance0019ListVO()
				                                                                	,event.getSearchConditionVO());
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
	 * 조회 이벤트 처리<br> 
	 * From ECC Setting 팝업 화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0136 화면 조회<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQBalance0136List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0136Event event = (EsmCoa0136Event)e;
		EQBalanceBC command = new EQBalanceBCImpl();

		try{
			List<SearchEQBalance0136ListVO> list = command.searchEQBalance0136List(event.getSearchEQBalance0136ListVO()
					                                                              ,event.getSearchConditionVO());
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
	 * 조회 이벤트 처리<br>
	 * From ECC Setting 팝업 화면에 대한 수정 이벤트 처리<br>
	 * ESM_COA_0136 화면 수정<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiEQBalance0136(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0136Event event = (EsmCoa0136Event)e;
		EQBalanceBC command = new EQBalanceBCImpl();
		try{
			begin();
			command.multiEQBalance0136(event.getCoaCntrRepoRoutEccVOS()
					                  ,event.getSearchConditionVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * To ECC Setting 팝업 화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0161 화면 조회<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQBalance0161List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0161Event event = (EsmCoa0161Event)e;
		EQBalanceBC command = new EQBalanceBCImpl();

		try{
			List<SearchEQBalance0161ListVO> list = command.searchEQBalance0161List(event.getSearchEQBalance0161ListVO()
					                                                              ,event.getSearchConditionVO());
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
	 * 조회 이벤트 처리<br>
	 * DEL ECC Setting 팝업 화면에 대한 수정 이벤트 처리<br>
	 * ESM_COA_0161 화면 수정<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiEQBalance0161(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0161Event event = (EsmCoa0161Event)e;
		EQBalanceBC command = new EQBalanceBCImpl();
		try{
			begin();
			command.multiEQBalance0161(event.getCoaCntrRepoRoutEccVOS()
					                  ,event.getSearchConditionVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0016 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchComBoCdList0016(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
	   	EsmCoa0016Event event = (EsmCoa0016Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String[][] array = {
					{"EQRepoTpSz","",""},
					{"RCC","","All"},
					{"LCC","","All"},
					{"cntrOrgDestCd","",""}
		       	};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				String[][] array = { {"LCC",event.getSearchConditionVO().getFRccCd(),"All"} };
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				if (!"".equals(event.getSearchConditionVO().getFRccCd()) && !"".equals(event.getSearchConditionVO().getFLccCd())) {
					String[][] array = { {"ecc",event.getSearchConditionVO().getFRccCd()+"|"+event.getSearchConditionVO().getFLccCd(),"All"} };
					eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
				} else {
					String[][] array = { {"ecc","0|0","All"} };
					eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
		    	}
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				String[][] array = {
					{"LOC2ECC",event.getSearchConditionVO().getFLoc(),""}
		       	};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
				List<GetCodeSelectVO> list = eventResponse.getRsVoList();
				String eccString = "";
				if (null!=list && 0<list.size()) {
					for (GetCodeSelectVO vo : list) {
						eccString = vo.getCode();
						break;
					}
				}
				eventResponse.setETCData("eccString",eccString);
			} 
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0016 : COA_CNTR_REPO_SHTG_INFO 테이블의 키중복 check  합니다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse checkEccYn(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EQBalanceBC command = new EQBalanceBCImpl();
		String eccCd = (String) e.getAttribute("eccCd");
		String checkEccYn = command.checkEccYn(eccCd);
		Map<String, String> etcData = new HashMap<String, String>();
		etcData.put("checkEccYn", checkEccYn);
		eventResponse.setETCData(etcData);
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0019 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0019(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String[][] array = {
					{"EQRepoTpSz","","All"},
					{"ecc","","All"},
					{"LCC","","All"},
					{"RCC","","All"}
		       	};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

}