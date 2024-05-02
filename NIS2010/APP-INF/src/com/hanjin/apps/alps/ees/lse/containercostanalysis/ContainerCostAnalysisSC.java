/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerCostAnalysisSC.java
*@FileTitle : On off Hire Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.19 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.basic.ExpensePlanBC;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.basic.ExpensePlanBCImpl;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.event.EesLse0033Event;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.event.EesLse0038Event;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo.ExpensePlanPerformanceVO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo.ExpensePlanVO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.basic.OnOffHireAuditBC;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.basic.OnOffHireAuditBCImpl;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.event.EesLse0055Event;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.event.EesLse0056Event;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.integration.OnOffHireAuditDBDAO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditDetailVO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditGroupVO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditSearchVO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.basic.PayableEstimateAuditBC;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.basic.PayableEstimateAuditBCImpl;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.event.EesLse0018Event;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.vo.EstimatedAuditVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.component.backend.support.BackEndJobResult;

/**
 * ALPS-ContainerCostAnalysis Business Logic ServiceCommand - ALPS-ContainerCostAnalysis 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Jin Jun Sung
 * @see OnOffHireAuditDBDAO
 * @since J2EE 1.6
 */

public class ContainerCostAnalysisSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ContainerCostAnalysis system 업무 시나리오 선행작업<br>
	 * EES_LSE_0055업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	@Override
	public void doStart() {
		log.debug("ContainerCostAnalysisSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ContainerCostAnalysis system 업무 시나리오 마감작업<br>
	 * EES_LSE_0055업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	@Override
	public void doEnd() {
		log.debug("ContainerCostAnalysisSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ContainerCostAnalysis system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesLse0055Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAuditResultOnOffHirelistService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAuditResultOnOffHireVersionlistService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAuditResultOnOffHireService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createOnOffHireListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0056Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = movecopyLessorOnlyListService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = createLessorOnlyListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLeaseExpensePlanListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageLeaseExpensePlanListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0038Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExpensePlanPerformanceListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPayableEstimateAuditService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = calculationPayableEstimateAuditService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = backEndCalculationPayableEstimateAuditService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = savePayableEstimateAuditService (e);
			}
		}
		return eventResponse;
	}
	/**
	 * EES_LSE_0055 : 조회 이벤트 처리<br>
	 * 임차 장비에 대한 임차-반납 조회<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAuditResultOnOffHirelistService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0055Event event = (EesLse0055Event)e;
		OnOffHireAuditBC command = new OnOffHireAuditBCImpl();

		try{
			OnOffHireAuditGroupVO resultVO = command.searchAuditResultOnOffHirelistBasic (event.getOnOffHireAuditSearchVO());
			List<List<OnOffHireAuditSearchVO>> lists = resultVO.getOnOffHireAuditSearchVOs();

			eventResponse.setRsVoList(lists.get(0));
			eventResponse.setRsVoList(lists.get(1));
			eventResponse.setRsVoList(lists.get(2));
			eventResponse.setRsVoList(lists.get(3));
			eventResponse.setRsVoList(lists.get(4));

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0056 : 조회 이벤트 처리<br>
	 * verify LSE_CTRT_NO 정합성 체크를 위한 조회<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse movecopyLessorOnlyListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0056Event event = (EesLse0056Event)e;
		OnOffHireAuditBC command = new OnOffHireAuditBCImpl();

		try{
			List<OnOffHireAuditSearchVO> list = command.verifyImportOnOffHireListBasic(event.getOnOffHireAuditSearchVO() );
			eventResponse.setRsVoList(list);
			if(list.size() > 0){
				eventResponse.setETCData("contract_no" , "T");
			}else{
				eventResponse.setETCData("contract_no" , "F");
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0055 : 저장 이벤트 처리<br>
	 * 엑셀 import 데이타 생성<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createLessorOnlyListService(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0056Event event = (EesLse0056Event)e;
		OnOffHireAuditBC command = new OnOffHireAuditBCImpl();

		try{
			begin();
			String audSeq = command.createImportOnOffHireListBasic(event.getOnOffHireAuditSearchVOS() , account);
			eventResponse.setETCData("aud_ver_seq" , audSeq);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * UI_LSE_0033 : Retrieve<br>
	 * CNTR/CHSS에 대한 년간 사업계획 목록을 조회합니다.<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchLeaseExpensePlanListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0033Event event = (EesLse0033Event)e;
			ExpensePlanBC command = new ExpensePlanBCImpl();
			List<ExpensePlanVO> list = command.searchLeaseExpensePlanListBasic(event.getPlnYr(), event.getVerSeq(), event.getCmdType());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * UI_LSE_0033 : Save<br>
	 * 년간/월간 장비임차 형태별 임차료 실적자료를 일괄 저장합니다.<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageLeaseExpensePlanListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0033Event event = (EesLse0033Event)e;
		ExpensePlanBC command = new ExpensePlanBCImpl();
		try{
			begin();
			command.manageLeaseExpensePlanListBasic(event.getExpensePlanVOs(),account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"LeaseExpensePlanList Manage"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * UI_LSE_0038 : Retrieve<br>
	 * 년간/월별 장비임차 형태별 임차료 실적목록을 조회합니다.<br>
	 *
	 * @param   Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchExpensePlanPerformanceListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0038Event event = (EesLse0038Event)e;
			ExpensePlanBC command = new ExpensePlanBCImpl();
			List<ExpensePlanPerformanceVO> list = command.searchExpensePlanPerformanceListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0055 : 조회 이벤트 처리<br>
	 * Audit 버전 리스트를 조회한다.
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAuditResultOnOffHireVersionlistService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0055Event event = (EesLse0055Event)e;
		OnOffHireAuditBC command = new OnOffHireAuditBCImpl();
		try{
			List<OnOffHireAuditSearchVO> list = command.searchAuditResultOnOffHireVersionlistBasic(event.getOnOffHireAuditSearchVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0055 : 조회 이벤트 처리<br>
	 * Lessor & HJS를 비교하여 Audit Result 리스트를 조회한다.
	 * @param   Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAuditResultOnOffHireService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0055Event event = (EesLse0055Event)e;
		OnOffHireAuditBC command = new OnOffHireAuditBCImpl();

		try{
			OnOffHireAuditGroupVO resultVO = command.searchAuditResultOnOffHireBasic(event.getOnOffHireAuditDetailVO());
			List<List<OnOffHireAuditDetailVO>> lists = resultVO.getOnOffHireAuditDetailVOs();

			eventResponse.setRsVoList(lists.get(0));
			eventResponse.setRsVoList(lists.get(1));
			eventResponse.setRsVoList(lists.get(2));
			eventResponse.setRsVoList(lists.get(3));


		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * EES_LSE_0055 : 저장<br>
	 * On/Off-Hire Audit 결과 저장<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createOnOffHireListService(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0055Event event = (EesLse0055Event)e;
		OnOffHireAuditBCImpl command = new OnOffHireAuditBCImpl();
		OnOffHireAuditDetailVO onOffHireAuditDetailVO = new OnOffHireAuditDetailVO();
		try{
			begin();
			onOffHireAuditDetailVO.setVndrSeq(event.getVndrSeq());
			onOffHireAuditDetailVO.setAudVerSeq(event.getAudVerSeq());
			onOffHireAuditDetailVO.setBilFmDt(event.getSearchStdt());
			onOffHireAuditDetailVO.setBilToDt(event.getSearchEndt());
			onOffHireAuditDetailVO.setAuditType(event.getAuditType());
			String audVerSeq = command.createOnOffHireListBasic( onOffHireAuditDetailVO , event.getOnOffHireAuditDetailVOS() , account);
			eventResponse.setETCData("aud_ver_seq" , audVerSeq);
			commit();
			//eventResponse.setUserMessage(new ErrorHandler("LSE10001").getMessage());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * UI_LSE_0018 : Retrieve<br>
	 * 임차료에 대한 추정 실적 조회 합니다.<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPayableEstimateAuditService (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0018Event event = (EesLse0018Event)e;
			PayableEstimateAuditBC command = new PayableEstimateAuditBCImpl();
			List<EstimatedAuditVO> list = command.searchPayableEstimateAuditBasic (event.getEstimatedAuditVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * UI_LSE_0018 : Calculation<br>
	 * 임차료에 대한 추정 실적 계산 합니다.<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse calculationPayableEstimateAuditService (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0018Event event = (EesLse0018Event)e;
			PayableEstimateAuditBC command = new PayableEstimateAuditBCImpl();
			List<EstimatedAuditVO> list = command.calculationPayableEstimateAuditBasic (event.getEstimatedAuditVO());

			if ( list.size() > 0 ) {
				for ( int i = 0 ; i < list.size(); i++ ) {
					(list.get(i)).setCreUsrId(account.getUsr_id());
					(list.get(i)).setUpdUsrId(account.getUsr_id());
				}

				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * UI_LSE_0018 : Save<br>
	 * 임차료에 대한 추정 실적 계산을 저장 합니다.<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse savePayableEstimateAuditService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0018Event event = (EesLse0018Event)e;
		PayableEstimateAuditBC command = new PayableEstimateAuditBCImpl();

		try{
			begin();
			command.savePayableEstimateAuditBasic(event.getEstimatedAuditVOS() , event.getYearMonth() , account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * UI_LSE_0018 : Retrieve<br>
	 * 임차료에 대한 추정 실적 조회 합니다-backend job.<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse backEndCalculationPayableEstimateAuditService (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0018Event event = (EesLse0018Event)e;
			PayableEstimateAuditBC command = new PayableEstimateAuditBCImpl();
			//List<EstimatedAuditVO> list = command.searchPayableEstimateAuditBasic (event.getEstimatedAuditVO());

			//if ( list.size() > 0 ) {
			//	eventResponse.setRsVoList(list);
			//}
			
			String status = command.backEndCalculationPayableEstimateAuditBasic(event.getEstimatedAuditVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0018 : BackEndJob<br>
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchComBackEndJobStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			PayableEstimateAuditBC command = new PayableEstimateAuditBCImpl();
			String key = (String)e.getAttribute("KEY");

			String status = command.searchComBackEndJobStatusBasic(key);
			eventResponse.setETCData("jb_sts_flg", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0018 : BackEndJob<br>
	 * BackEndJob의 실행결과로 생성된 파일을 로드합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse loadFileBackEndJobResultService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String key = (String)e.getAttribute("KEY");
		List list = null;

		try {
			if(e.getEventName().equalsIgnoreCase("EesLse0018Event")) {
				list = (List<EstimatedAuditVO>)BackEndJobResult.loadFromFile(key);
			}

			eventResponse.setRsVoList(list);
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
}