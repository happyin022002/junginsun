/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : CodSimulateBCImpl.java
*@FileTitle      : COD Simulation 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

	package com.clt.apps.opus.ees.eqr.simulationmanage;

	import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.eqr.common.Constants;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBC;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBCImpl;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonConditionVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonVO;
import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.basic.CodSimulateBC;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.basic.CodSimulateBCImpl;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.event.EesEqr0012Event;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.event.EesEqr0098Event;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.event.EesEqr0099Event;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.event.EesEqr0140Event;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0012ConditionVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

	/**
	* -EQR Business Logic ServiceCommand<br>
	* - -EQR에 대한 비지니스 트랜잭션을 처리한다.<br>
	*
	* @author ChangHoChae
	* @see EES_EQR_010EventResponse,OnewaySimulateDBDAO 참조
	* @since J2EE 1.4
	*/
	public class SimulationManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * EQR 업무 시나리오 선행작업<br>
	 * OnewaySimulate업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
		} catch(Exception e) {
			log.error("SimulationManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * EQR 업무 시나리오 마감작업<br>
	 * OnewaySimulate업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("SimulationManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * -EQR 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;



		if (e.getEventName().equalsIgnoreCase("EesEqr0012Event")) {
			//if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				//eventResponse = searchMaxRepoPlanId(e);							//distribute 완료된 최대 repo plan id 검색
			//} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepoPlanPreInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchRepoPlanInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyRepoPlanInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyComfirmRepoPlanInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = createManualRepoPlanId(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = modifyRepoPlnIdNm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = deleteRepoPlnId(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLaneExistInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
			// 조회 여부를 체크
				log.debug("=========>" );
				eventResponse = searchKeyRepoPlanInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
			// 조회 여부를 체크
				log.debug("=========>" );
				//eventResponse = searchMainRepoPlanInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)){
				eventResponse = searchCntrRepoInOutPlanVvdInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST07)){
				eventResponse = searchCODVskLaneData(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
				eventResponse = searchRepoPlanIdViewInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = createManualNewRepoPlanId(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST08)){
				eventResponse = searchCODVskLaneLocData(e);
			}
			
		}

			// Bay Plan
			if (e.getEventName().equalsIgnoreCase("EesEqr0140Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		// Retrieve 버튼 클릭시
					eventResponse = searchBayPlan(e);//
				}
			}
		return eventResponse;
	}



	/**
	 * distribute 완료된 최대 repo plan id 검색	<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*private EventResponse searchMaxRepoPlanId(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0012Event event = (EesEqr0012Event)e;
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0012ConditionVO conditionVO = event.getEesEqr0012ConditionVO();

		try{
			String[] result = commonImpl.searchMaxRepoPlanId().getResultStrArray();

			conditionVO.setYyyyww(result[0]);
			conditionVO.setSeq(result[1]);

			event.setEesEqr0012ConditionVO(conditionVO);
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}*/

	/**
	 * [EES_EQR_0012] 신규생성되는 Repo ID에 대한 정보를 조회<br>
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepoPlanPreInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0012Event event = (EesEqr0012Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		try {
			CodSimulateBC command = new CodSimulateBCImpl();
			CommonRsVO commonRsVO = command.searchRepoPlanPreInfo(event.getEesEqr0012ConditionVO() , account);
			eventResponse.setRsVo(commonRsVO.getDbRowset());
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 0012 화면의 메인 쿼리 조회 이벤트 처리<br>
	 * SimulationManage 화면에 대한 조회 이벤트 처리<br>
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unused")
	private EventResponse searchRepoPlanInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0012Event event = (EesEqr0012Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		try {
			begin();
			CodSimulateBC command = new CodSimulateBCImpl();
			CommonRsVO commonRsVO = command.searchRepoPlanInfo(event.getEesEqr0012ConditionVO() , account);
			String[] keyinfo = command.searchKeyRepoPlanInfo(event.getEesEqr0012ConditionVO()).getResultStrArray();
			eventResponse.setETCData("userId" , keyinfo[0]);
			eventResponse.setETCData("userTime", keyinfo[1]);
			eventResponse.setETCData("repo_id_used" ,keyinfo[2]);
			eventResponse.setRsVo(commonRsVO.getDbRowset());
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 0012 화면에서 조회 이벤트 처리<br>
	 * SimulationManage 화면에 대한 조회 이벤트 처리<br>
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKeyRepoPlanInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0012Event event = (EesEqr0012Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체

		try {
			CodSimulateBC command = new CodSimulateBCImpl();
			String[] keyinfo = command.searchKeyRepoPlanInfo(event.getEesEqr0012ConditionVO()).getResultStrArray();
			eventResponse.setETCData("userId" , keyinfo[0]);
			eventResponse.setETCData("userTime", keyinfo[1]);
			eventResponse.setETCData("repo_id_used" ,keyinfo[2]);
			log.debug("etc data" + keyinfo[1].toString());

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return (eventResponse);
	}

	/**
	 * 0012 화면에서 VVD 정보 조회 이벤트 처리<br>
	 * SimulationManage 화면에 대한 조회 이벤트 처리<br>
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoInOutPlanVvdInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0012Event event = (EesEqr0012Event)e;
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
		EesEqr0012ConditionVO conditionVO = event.getEesEqr0012ConditionVO();
		EesCommonVO retVO = null; // EventResponse 의 결과 Value 를 담고 있는 결과 VO
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EesCommonConditionVO eescommonVO = new EesCommonConditionVO();

		try {

			CodSimulateBC command = new CodSimulateBCImpl();
			CommonBC command0 = new CommonBCImpl();
			begin();
			eescommonVO.setWeekperiodSearchword(conditionVO.getPlnyrwk());
			CommonRsVO commonRsVO = command.searchCntrRepoInOutPlanVvdInfo(event.getEesEqr0012ConditionVO(), account);
			retVO  = command0.searchWeekDatePeriod(eescommonVO);
			conditionVO.setStartdate(retVO.getWeekPeriodFromdate());
			conditionVO.setEnddate(retVO.getWeekPeriodTodate());
			returnVOList.add(conditionVO);
			returnVOList.add(commonRsVO);
			eventResponse.setETCData("rowSearchCol" , conditionVO.getCol());
			eventResponse.setRsVoList(returnVOList);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 0012 화면에서 Lane 데이터 조회 이벤트 처리<br>
	 * SimulationManage 화면에 대한 조회 이벤트 처리<br>
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCODVskLaneData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0012Event event = (EesEqr0012Event)e;
		EesEqr0012ConditionVO conditionVO = event.getEesEqr0012ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try {

			CodSimulateBC command = new CodSimulateBCImpl();
			CommonRsVO commonRsVO = command.searchCODVskLaneData(event.getEesEqr0012ConditionVO());
			returnVOList.add(conditionVO);
			returnVOList.add(commonRsVO);
			
			eventResponse.setRsVoList(returnVOList);
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_EQR_0012Event Change POD save <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	public EventResponse modifyRepoPlanInfo(Event e) throws EventException {
		EesEqr0012Event event = (EesEqr0012Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CodSimulateBC command = new CodSimulateBCImpl();
			// CommonBCImpl MaxUpdate , MaxUserid 사용안함  확인 필요
			begin();
			command.modifyRepoPlanInfo(event.getEesEqr0012ConditionVO(), event.getEesEqr0012MultiVOs(), account);
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_EQR_0012Event Change POD comfire <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	public EventResponse modifyRepoPlnIdNm(Event e) throws EventException {
		EesEqr0012Event event = (EesEqr0012Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CodSimulateBC command = new CodSimulateBCImpl();
			begin();
			command.modifyRepoPlnIdNm( event.getEesEqr0012ConditionVO(),  account);
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_EQR_0012Event Change POD comfire <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	public EventResponse createManualRepoPlanId(Event e) throws EventException {
		EesEqr0012Event event = (EesEqr0012Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CodSimulateBC command = new CodSimulateBCImpl();

		try {
			begin();
			String dupYN = command.createManualRepoPlanId( event.getEesEqr0012ConditionVO(), account);
			commit();
			eventResponse.setETCData("dupYN", dupYN);

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_EQR_0012Event Confirm 하기전 Repo Plan Id 삭제 <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	public EventResponse deleteRepoPlnId(Event e) throws EventException {
		EesEqr0012Event event = (EesEqr0012Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CodSimulateBC command = new CodSimulateBCImpl();

		try {
			begin();
			String delYN = command.deleteRepoPlanId( event.getEesEqr0012ConditionVO(), account);
			commit();
			eventResponse.setETCData("delYN", delYN);

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_EQR_0012Event Change Repo_Rmk Name <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	public EventResponse modifyComfirmRepoPlanInfo(Event e) throws EventException {
		EesEqr0012Event event = (EesEqr0012Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CodSimulateBC command = new CodSimulateBCImpl();
			// CommonBCImpl MaxUpdate , MaxUserid 사용안함  확인 필요
			begin();
			command.modifyComfirmRepoPlanInfo( event.getEesEqr0012ConditionVO(),  account);
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 0012 COD lane 존재 여부 조회 이벤트 처리<br>
	 * SimulationManage 화면에 대한 조회 이벤트 처리<br>
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneExistInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0012Event event = (EesEqr0012Event)e;
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
		EesEqr0012ConditionVO conditionVO = event.getEesEqr0012ConditionVO();
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체


		try {
			CodSimulateBC command = new CodSimulateBCImpl();
			begin();
			CommonRsVO commonRsVO = command.searchLaneExistInfo(event.getEesEqr0012ConditionVO());
			returnVOList.add(conditionVO);
			returnVOList.add(commonRsVO);
			eventResponse.setRsVoList(returnVOList);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 0140 화면의 조회 이벤트 처리<br>
	 * SimulationManage 화면에 대한 조회 이벤트 처리<br>
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBayPlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0140Event event = (EesEqr0140Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체


		try {
			CodSimulateBC command = new CodSimulateBCImpl();
			begin();
			CommonRsVO commonRsVO = command.searchBayPlan(event.getEesEqr0140ConditionVO());
			eventResponse.setRsVo(commonRsVO.getDbRowset());

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Plan ID 등록여부조회<br>
	 * Plan ID 등록여부조회<br>
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unused")
	private EventResponse searchRepoPlanIdViewInfo(Event e) throws EventException {
		EesEqr0012Event event = (EesEqr0012Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CodSimulateBC command = new CodSimulateBCImpl();

		try {
			begin();
			String dataYN = command.searchRepoPlanIdViewInfo( event.getEesEqr0012ConditionVO(), account);
			commit();
			eventResponse.setETCData("dataYN", dataYN);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	
	/**
	 * EES_EQR_0012Event Change POD comfire <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	public EventResponse createManualNewRepoPlanId(Event e) throws EventException {
		EesEqr0012Event event = (EesEqr0012Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CodSimulateBC command = new CodSimulateBCImpl();

		try {
			begin();
			String dupYN = command.createManualNewRepoPlanId( event.getEesEqr0012ConditionVO(), account); 
			commit();
			eventResponse.setETCData("dupYN", dupYN);

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * VVD로 LOC 추출 <br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchCODVskLaneLocData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0012Event event = (EesEqr0012Event)e;
		EesEqr0012ConditionVO conditionVO = event.getEesEqr0012ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try {
			CodSimulateBC command = new CodSimulateBCImpl();
			CommonRsVO commonRsVO = command.searchCODVskLaneLocData(event.getEesEqr0012ConditionVO());
			eventResponse.setETCData("all_loc_cd" , commonRsVO.getResultString());
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

}