/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : CodSimulateBCImpl.java
*@FileTitle      : COD Simulation 조회/수정 
*Open Issues     :
*Change history  :
*@LastModifyDate : 2006-11-20
*@LastModifier   : ChangHoChae
*@LastVersion    : 1.17
*@Create         : Ver 1.0    2006-11-20 ChangHoChae
*@Modify         : Ver 1.17   2009-02-05 HaengJi, Lee
*                  신규프로젝트 No  - [ S2Q-09P-004 ]
*                  Bay Plan I/F 화면추가에 따른 메소드 추가 - searchBayPlan
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.simulationmanage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.basic.CommonBC;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.basic.CommonBCImpl;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.EesCommonConditionVO;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.EesCommonVO;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.basic.CntrRepoPlanOptiExecuteBC;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.basic.CntrRepoPlanOptiExecuteBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo.EesEqr0049ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.basic.VesselScheduleChangeSimulateBC;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.basic.VesselScheduleChangeSimulateBCImpl;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.basic.CodSimulateBC;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.event.EesEqr0011Event;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.event.EesEqr0097Event;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.vo.EesEqr0011ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.vo.SearchVesselPlanCompareVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.basic.CodSimulateBCImpl;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.event.EesEqr0012Event;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.event.EesEqr0098Event;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.event.EesEqr0099Event;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.event.EesEqr0140Event;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0012ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.basic.OnewaySimulateBC;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.basic.OnewaySimulateBCImpl;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.event.EesEqr0010Event;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.vo.EesEqr0010ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.basic.CntrRepoPlanSensitivityAnalysisBC;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.basic.CntrRepoPlanSensitivityAnalysisBCImpl;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.event.EesEqr0065Event;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.vo.EesEqr0065ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.event.EesEqr0088Event;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ENIS-EQR Business Logic ServiceCommand<br>
 * - ENIS-EQR에 대한 비지니스 트랜잭션을 처리한다.<br>
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
		} catch (Exception e) {
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
	 * ENIS-EQR 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		

		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesEqr0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchTotalOneWayOffer(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				//eventResponse = modifyOneWayOffer(e);
				eventResponse = modifyOneWayOfferJmsCall(e);
			}
			
			// 두번째 탭 조회 설정 
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchOneWayPlanCompare(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EesEqr0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {			// Save , Re-Run    버튼 클릭시
				eventResponse = createNewVesselPlan(e);
			} 	
			//if (e.getFormCommand().isCommand(FormCommand.ADD)) {			// Re-Run   버튼 클릭시
			//	eventResponse = reRunVesselPlan(e);
			//} 
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = reRunCallJMS(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EesEqr0097Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		// Retrieve 버튼 클릭시
				eventResponse = searchVesselPlanCompare(e);
			} 	
		}
		
		if (e.getEventName().equalsIgnoreCase("EesEqr0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchMaxRepoPlanId(e);							//distribute 완료된 최대 repo plan id 검색	
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchRepoPlanInfo(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyRepoPlanInfo(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyComfirmRepoPlanInfo(e);
			}
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLaneExistInfo(e);
			}
			// 조회 여부를 체크 
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				log.debug("=========>" );
				eventResponse = searchKeyRepoPlanInfo(e);
			}
//			 조회 여부를 체크 
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				log.debug("=========>" );
				//eventResponse = searchMainRepoPlanInfo(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)){
				eventResponse = searchCntrRepoInOutPlanVvdInfo(e);
			}
		}
			
			if (e.getEventName().equalsIgnoreCase("EesEqr0098Event")) {
				// 012  두번째 탭 조회 설정 
				if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
					eventResponse = searchPOLChangePlanCompare(e);
				}
			}
			
			if (e.getEventName().equalsIgnoreCase("EesEqr0099Event")) {
				// 012 세번째 탭 조회 설정 
				if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
					eventResponse = searchPODChangePlanCompare(e);
				 }
			}
		
			// Bay Plan
			if (e.getEventName().equalsIgnoreCase("EesEqr0140Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		// Retrieve 버튼 클릭시
					eventResponse = searchBayPlan(e);//
				}
			}
			
			
			// 민감도 조회/수정    
			if (e.getEventName().equalsIgnoreCase("EesEqr0065Event")) {	
				if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		// Retrieve 버튼 클릭시
					eventResponse = searchPlanSensitivity(e);//
				} 
				
				if(e.getFormCommand().isCommand(FormCommand.MULTI)) {			// Share 버튼 클릭시 
					eventResponse = modifyPlanSensitivity(e);
				}
			}
			
			// 민감도 분석/조회 
			if (e.getEventName().equalsIgnoreCase("EesEqr0088Event")) {	
				if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		// Retrieve 버튼 클릭시
					eventResponse = searchPlanSensitivityCompare(e);//
				} 
				
				if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {	// Sheet1 Row 클릭시
					eventResponse = searchUnitCostSensitivityCompare(e);//
				}
				if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {	// Sheet1 Row 클릭시
					eventResponse = searchRepoPlanType(e);//
				}
			}
		return eventResponse;
	}			

	
	
    /**
     * 0011화면의 조회 이벤트 처리<br>
     * SimulationManage 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchVesselPlanCompare(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	EesEqr0097Event event = (EesEqr0097Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
        	VesselScheduleChangeSimulateBC command = new VesselScheduleChangeSimulateBCImpl();
        	List<SearchVesselPlanCompareVO> list = command.searchVesselPlanCompare(event.getEesEqr0011ConditionVO());
        	eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }	
    
    
    /**
     * 0011 화면의 저장 이벤트 처리<br>
     * SimulationManage 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse createNewVesselPlan(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EesEqr0011Event event = (EesEqr0011Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        //EventResponse eventResponse = null;
        
        try {
        	VesselScheduleChangeSimulateBC command = new VesselScheduleChangeSimulateBCImpl();
        	begin();
            command.createNewVesselPlan(event.getConditionVO(),event.getEqrScnrVslSkdVOS(),account);
            commit();
            eventResponse.setETCData("newScnrId" ,event.getConditionVO().getNewscnrid());
            eventResponse.setETCData("run_id_no" ,event.getConditionVO().getRunIdNo());
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }   
    
    

    /**
     * 0011화면 JMS 호출 이벤트 처리<br>
     * VesselScheduleChangeSimulate의 event에 대한 멀티 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse reRunCallJMS(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EesEqr0011Event event = (EesEqr0011Event)e;
        try {
        	EesEqr0011ConditionVO condiVO = event.getConditionVO();
            begin();
            VesselScheduleChangeSimulateBC command = new VesselScheduleChangeSimulateBCImpl();
            CommonBCImpl commonImpl = new CommonBCImpl();
            String sim_pln_id = Constants.REPO_WORD + condiVO.getYyyyww2() + Constants.REPO_WEEK + condiVO.getSeq2();
            String repoPlanId = commonImpl.createNewRepoPlanId(sim_pln_id).getResultString(); // 새로운 repo_plan_id을 생성한다.
            command.reRunCallJMS(condiVO,repoPlanId,account);
            commit();
            eventResponse.setETCData("newScnrId" ,event.getConditionVO().getNewscnrid());
            eventResponse.setETCData("run_id_no" ,event.getConditionVO().getRunIdNo());
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
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
	private EventResponse searchMaxRepoPlanId(Event e) throws EventException {
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
     * 0012 화면의 메인 쿼리 조회 이벤트 처리<br>
     * SimulationManage 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchRepoPlanInfo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EesEqr0012Event event = (EesEqr0012Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	
        
        try {
        	CodSimulateBC command = new CodSimulateBCImpl();
        	begin();
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
            throw new EventException(de.getMessage());
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
            throw new EventException(de.getMessage());
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
        	CommonRsVO commonRsVO = command.searchCntrRepoInOutPlanVvdInfo(event.getEesEqr0012ConditionVO());
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
            throw new EventException(de.getMessage());
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
			command.modifyRepoPlanInfo( event.getEqrVslLdisPlnCodTmpVOs() ,event.getEqrVslPlnCodQtyVOs() ,event.getEesEqr0012ConditionVO(), event.getEesEqr0012MultiVOs(), account);      
			commit();
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
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
			throw new EventException(de.getMessage());
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
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }  
	
	  /**
     * 0098화면의 조회 이벤트 처리<br>
     * SimulationManage 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchPOLChangePlanCompare(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EesEqr0098Event event = (EesEqr0098Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	
        
        try {
        	CodSimulateBC command = new CodSimulateBCImpl();
        	begin();
        	CommonRsVO commonRsVO = command.searchPOLChangePlanCompare(event.getEesEqr0012ConditionVO());
        	eventResponse.setRsVo(commonRsVO.getDbRowset());
        
            commit();
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }   
    
	  /**
     * 0099 화면의 조회 이벤트 처리<br>
     * SimulationManage 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchPODChangePlanCompare(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EesEqr0099Event event = (EesEqr0099Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	
        
        try {
        	CodSimulateBC command = new CodSimulateBCImpl();
        	begin();
        	CommonRsVO commonRsVO = command.searchPODChangePlanCompare(event.getEesEqr0012ConditionVO());
        	eventResponse.setRsVo(commonRsVO.getDbRowset());
        
            commit();
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
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
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    } 
    
//    /**
//     * 멀티 이벤트 처리<br>
//     * EES_EQR_011 화면에 대한 멀티 이벤트 처리<br>
//     * jms에서 제어권을 받아와서 엔진을 실행을 시켜주는 메소드
//     * @param str String
//     * @exception EventException
//     */
// 
//    public void receiveEqr0011Rerun(String str) throws EventException{
//    	
//        // PDTO(Data Transfer Object including Parameters)
//    	EesEqr0049ConditionVO condiVO049 = new EesEqr0049ConditionVO();
//        HashMap<String,String> hm = Utils.createMap(str);
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        
//        String newScnrId  =(String)hm.get("newScrnid");
//        String repoPlanId = "";
//        String sim_pln_id = (String)hm.get("sim_pln_id");
//        String repo_pln_dtrb_flg     = "N";
//        String repo_pln_auto_gen_flg = "N";
//        String[] old_repo_id_type = null;
//        String[] st_end_between_yearwk = null;
//        String userId = (String)hm.get("user_id");   // user id information
//        String st_year               = "";
//        String st_month              = "";
//        String st_weekly             = "";
//        String end_year              = "";
//        String end_month             = "";
//        String end_weekly            = "";
//        String weekStdt              = "";
//        
//        CntrRepoPlanOptiExecuteBC cntrRepoPlanOptiExecuteImpl = new CntrRepoPlanOptiExecuteBCImpl();
//        CommonBCImpl commonImpl = new CommonBCImpl();
//        VesselScheduleChangeSimulateBC command  = new VesselScheduleChangeSimulateBCImpl();
//        
//        try {
//        	cntrRepoPlanOptiExecuteImpl.selectEnginCheck();									    // 현재 RUNNING 하는 엔진의 있는 지 체크
//			repoPlanId            = commonImpl.createNewRepoPlan_id(sim_pln_id).getResultString();  				// 새로운 repo_plan_id을 생성한다.
//			old_repo_id_type      = commonImpl.searchOldRepoPlantype(sim_pln_id).getResultStrArray();   			// 과거 repo_pln_id 의 속성을 가져온다.
//			st_end_between_yearwk = commonImpl.weewklyConvertMonth((String)hm.get("yyyyww") , 16).getResultStrArray();   	// 해당 주 16주에 대한 시작 , 끝나는 주차 년 월 주차를 가져 온다.
//			
//			
//			// 기존 주차를 기준으로 해서 시작 년 월 주차, 종료 년 월, 주차를 가져온다. 
//			st_year               = st_end_between_yearwk[0];   // 시작 년도 
//			st_weekly             = st_end_between_yearwk[1];   // 시작 주차  
//			st_month              = st_end_between_yearwk[2];   // 시작 년월 
//			
//			end_year              = st_end_between_yearwk[3];   // 종료 년도 
//			end_weekly            = st_end_between_yearwk[4];   // 종료 주차 
//			end_month             = st_end_between_yearwk[5];   // 종료 년월			
//
//			weekStdt        = commonImpl.searchWeekToDate(st_year +st_weekly).getResultString(); 
//			// EES_EQR_049Event setting
//			condiVO049.setRepo_pln_dtrb_flg(repo_pln_dtrb_flg);
//			condiVO049.setRepo_auto_gen_flg(repo_pln_auto_gen_flg);
//			condiVO049.setScnrid(newScnrId);
//			condiVO049.setOld_scnr_id(((String)hm.get("scnrId")));
//			condiVO049.setRepo_plan_id(repoPlanId);
//			condiVO049.setSim_pln_id(sim_pln_id);
//			condiVO049.setInclu_onh_flg(old_repo_id_type[0]);
//			condiVO049.setInclu_offh_flg(old_repo_id_type[1]);
//	        condiVO049.setCntrTpszCd(old_repo_id_type[2]);
//	        condiVO049.setRepo_pln_rmk("V");
//	        condiVO049.setUser_id(userId);
//	        condiVO049.setStyear(st_year);
//	        condiVO049.setStmonth(st_month);
//	        condiVO049.setStweekly(st_weekly);
//	        condiVO049.setEndyear(end_year);
//	        condiVO049.setStmonth(end_month);
//	        condiVO049.setEndweekly(end_weekly);
//	        condiVO049.setDuration(old_repo_id_type[3]);
//			        	
//	        command.reRunVesselPlan(condiVO049 , userId);
//           // cntrRepoPlanOptiExecuteImpl.createRepoPlanRunOptimizer(condiVO049 , weekStdt , userId);
//	        cntrRepoPlanOptiExecuteImpl.enginRunOptimizer(condiVO049 , weekStdt);
//            log.debug("\n reRunVesselPlanJMS ::event049.getRun_id_no(): " + condiVO049.getRun_id_no());
//             eventResponse.setETCData("run_id_no" ,condiVO049.getRun_id_no());
//
//        } catch (EventException de) {
//        	rollback();
//            log.error("err " + de.toString(), de);
//            throw new EventException(de.getMessage());
//        }
//    }
    
    /**
     * oneway offer 조회 이벤트 처리<br>
     * SimulationManage 화면에 대한 조회 이벤트 처리<br>
     * @param  e Event
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchTotalOneWayOffer(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EesEqr0010Event event = (EesEqr0010Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	OnewaySimulateBC command = new OnewaySimulateBCImpl();
    	CommonRsVO rsVO = new CommonRsVO();
    	List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();
    	
    	String[]  tpszInfo = null;
		String[]  gapInfo  = null;
		String[]  maxInfo  = null;
		try {
			// offer의 총합을 구합
			tpszInfo = command.searchTotalOneWayOfferExist(event.getEesEqr0010ConditionVO()).getResultStrArray();
			String tpszCd     = event.getEesEqr0010ConditionVO().getCntrtpsztype();
			String[]  arrTpszCd  = tpszCd.split(",");
			for (int k=0 ; k < arrTpszCd.length  ; k++){
				eventResponse.setETCData(arrTpszCd[k] ,tpszInfo[k]);
			}
			// 각 TPSZ 별 차이를 받아서 넘겨준다.
			gapInfo = command.searchTotalOneWayOfferGap(event.getEesEqr0010ConditionVO()).getResultStrArray();
			// 각 TPSZ별 최대값을 받아서 넘겨준다. 
			maxInfo = command.searchTotalOneWayOfferMax(event.getEesEqr0010ConditionVO()).getResultStrArray();
			event.getEesEqr0010ConditionVO().setVolInfo(tpszInfo);
			event.getEesEqr0010ConditionVO().setMaxInfo(maxInfo);
			event.getEesEqr0010ConditionVO().setGapInfo(gapInfo);
			rsVO=command.searchTotalOneWayOffer(event.getEesEqr0010ConditionVO());
			rsVO.setConditionVO(event.getEesEqr0010ConditionVO());
			rsVoList.add(rsVO);
			eventResponse.setRsVoList(rsVoList);
			
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * 멀티 이벤트 처리<br>
     * EES_EQR_0010 화면에 대한 멀티 이벤트 처리<br>
     * 0010화면에서 값을 저장을 하고 jms로 호출하는 메소드
     * @param e Event
     * @return EventResponse EES_EQR_002EventResponse
     * @exception EventException
     */
 
    public EventResponse modifyOneWayOfferJmsCall(Event e) throws EventException{
    	
    	
    	EesEqr0010Event event=(EesEqr0010Event)e;
    	EesEqr0049ConditionVO condiVO049 = new EesEqr0049ConditionVO();
    	EesEqr0010ConditionVO condiVO010 = event.getEesEqr0010ConditionVO();
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrRepoPlanOptiExecuteBCImpl cntrRepoPlanOptiExecuteBC = new CntrRepoPlanOptiExecuteBCImpl();
		CommonBCImpl commonBC = new CommonBCImpl();
		OnewaySimulateBC command = new OnewaySimulateBCImpl();
		

            String new_repo_id           = "";
        // 과거 repo_plan_id의 속성을 정의 한다. 
            String sim_pln_id            = Constants.REPO_WORD+event.getEesEqr0010ConditionVO().getYyyyww()+Constants.REPO_WEEK+event.getEesEqr0010ConditionVO().getSeq();
            String old_scnario_id        = event.getEesEqr0010ConditionVO().getScnrId();
	       // String new_scnd_id         = "";
	        // 과거 repo_plan_id의 속성을 정의 한다. 
	        String incl_onh_flg          =""; 
	        String incl_offh_flg         = "";
	        String repo_pln_dtrb_flg     = "N";
	        String repo_pln_auto_gen_flg = "N";
	        String incl_cntr_tpsz_ctntg  = "";
	        String duration              = "";
	        String delt_flg              = "N";
	        String st_year               = "";
	        String st_month              = "";
	        String st_weekly             = "";
	        String end_year              = "";
	        String end_month             = "";
	        String end_weekly            = "";
	        String[] old_repo_id_type    = null;
	        String[] st_end_between_yearwk = null;
	        String   run_id_no           = "";
	        String   weekStdt            = "";
	        
        
    	try {
			String usr_id        = event.getSignOnUserAccount().getUsr_id();
			new_repo_id           = commonBC.createNewRepoPlanId(sim_pln_id).getResultString();  // 새로운 repo_plan_id을 생성한다.
			String seq            = new_repo_id.substring(11,14);
			//	new_scnd_id           = commonBC.createNewScnario_id(old_scnario_id);  // 새로운 scnario id을 생성한다. 
			old_repo_id_type      = commonBC.searchOldRepoPlantype(sim_pln_id).getResultStrArray(); // 과거 repo_pln_id 의 속성을 가져온다.
			st_end_between_yearwk = commonBC.weewklyConvertMonth(event.getEesEqr0010ConditionVO().getYyyyww() , 16).getResultStrArray(); // 해당 주 16주에 대한 시작 , 끝나는 주차 년 월 주차를 가져 온다. 
				
				// old_repo_plan_id type 성격을 가져온다. 
				incl_onh_flg          = old_repo_id_type[0];
				incl_offh_flg         = old_repo_id_type[1];
				incl_cntr_tpsz_ctntg  = old_repo_id_type[2];
				duration              = old_repo_id_type[3];
				
				// 기존 주차를 기준으로 해서 시작 년 월 주차, 종료 년 월, 주차를 가져온다. 
				st_year               = st_end_between_yearwk[0];   // 시작 년도 
				st_weekly             = st_end_between_yearwk[1];   // 시작 주차  
				st_month              = st_end_between_yearwk[2];   // 시작 년월 
				
				end_year              = st_end_between_yearwk[3];   // 종료 년도 
				end_weekly            = st_end_between_yearwk[4];   // 종료 주차 
				end_month             = st_end_between_yearwk[5];   // 종료 년월
				
				weekStdt        = commonBC.searchWeekToDate(st_year +st_weekly).getResultString(); 
				//ees_eqr49 event에 데이터를 setting 
				condiVO049.setScnrid(old_scnario_id);
				condiVO049.setRepo_plan_id(new_repo_id);
				condiVO049.setInclu_onh_flg(incl_onh_flg);
				condiVO049.setInclu_offh_flg(incl_offh_flg);
				condiVO049.setRepo_pln_dtrb_flg(repo_pln_dtrb_flg);
				condiVO049.setRepo_auto_gen_flg(repo_pln_auto_gen_flg);
				condiVO049.setSim_pln_id(sim_pln_id);
				condiVO049.setDelt_flg(delt_flg);
				condiVO049.setUser_id(usr_id);
				condiVO049.setCntrTpszCd(incl_cntr_tpsz_ctntg);
				condiVO049.setRepo_pln_rmk("O");
				condiVO049.setStyear(st_year);
				condiVO049.setStmonth(st_month);
				condiVO049.setStweekly(st_weekly);
				condiVO049.setEndyear(end_year);
				condiVO049.setEndmonth(end_month);
				condiVO049.setEndweekly(end_weekly);
				condiVO049.setDuration(duration);
				condiVO049.setSold_flg("");
				run_id_no = new_repo_id.substring(4,10)+seq;
				condiVO010.setRunIdNo(run_id_no);
				condiVO010.setNewRepoPlan(new_repo_id);
				condiVO010.setUserId(usr_id);
				event.setEesEqr0010ConditionVO(condiVO010);
				eventResponse.setETCData("run_id_no" ,run_id_no);
				eventResponse.setCustomData("run_id_no",run_id_no);
				cntrRepoPlanOptiExecuteBC.selectEnginCheck(); // 엔진이 돌고 있는지 체크 
				cntrRepoPlanOptiExecuteBC.createRepoPlanRunOptimizer(condiVO049 ,weekStdt ,usr_id); // eqr_eq_repo_pln와 엔진관련 테이블에 저장을 한다.
				command.modifyOneWayOffer(event.getEesEqr0010ConditionVO() , event.getEesEqr0010MutiVOs() , new_repo_id); // offer 수량을 입력을 한다.
				command.send0010ReRunSteve(event.getEesEqr0010ConditionVO());
		    return eventResponse;
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
 
    }
    

	
	   /**
     * 0011화면 조회 이벤트 처리<br>
     * SimulationManage 화면에 대한 조회 이벤트 처리<br>
     * @param  e Event
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchOneWayPlanCompare(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EesEqr0010Event event = (EesEqr0010Event)e;
    	CommonRsVO rsVO = new CommonRsVO();
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        //EventResponse eventResponse = null;
        
        try {
        	OnewaySimulateBC command = new OnewaySimulateBCImpl();
        	begin();
            rsVO = command.searchOneWayPlanCompare(event.getEesEqr0010ConditionVO());
            commit();
            eventResponse.setRs(rsVO.getDbRowset());
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }   
   
    /**
	 * 조회 이벤트 처리<br>
	 * CntrRepoPlanSensitivityAnalysis의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPlanSensitivity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0065Event event = (EesEqr0065Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		CommonRsVO rsVO = new CommonRsVO();
		
		try {
			CntrRepoPlanSensitivityAnalysisBC command = new CntrRepoPlanSensitivityAnalysisBCImpl();
			rsVO = command.searchPlanSensitivity(event.getEesEqr0065ConditionVO());
			eventResponse.setRs(rsVO.getDbRowset()); 
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 0065화면 수정 이벤트 처리<br>
	 * CntrRepoPlanSensitivityAnalysis의 event에 대한 수정 이벤트 처리<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyPlanSensitivity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr0065Event event = (EesEqr0065Event)e;
		//EesEqr0049ConditionVO condiVO049 = new EesEqr0049ConditionVO();
	  	EesEqr0065ConditionVO condiVO065 = event.getEesEqr0065ConditionVO();
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrRepoPlanOptiExecuteBCImpl cntrRepoPlanOptiExecuteBC = new CntrRepoPlanOptiExecuteBCImpl();
		CntrRepoPlanSensitivityAnalysisBC command = new CntrRepoPlanSensitivityAnalysisBCImpl();
		CommonBCImpl commonBC = new CommonBCImpl();

			    String old_scnario_id        = condiVO065.getScnrid();
		        String new_repo_id           = "";
		        String sim_pln_id            = Constants.REPO_WORD+condiVO065.getYyyyww()+Constants.REPO_WEEK+condiVO065.getSeq();
		        String   run_id_no           = "";
		        
			try {
			    	String usr_id        = event.getSignOnUserAccount().getUsr_id();
					new_repo_id           = commonBC.createNewRepoPlanId(sim_pln_id).getResultString();  // 새로운 repo_plan_id을 생성한다.
				    String seq            = new_repo_id.substring(11,14);
				    condiVO065.setUserId(usr_id);
				    cntrRepoPlanOptiExecuteBC.selectEnginCheck(); // 엔진이 돌고 있는지 체크
					command.modifyPlanSensitivity(event.getEesEqr0065MultiVOs(),event.getEesEqr0065ConditionVO() ,old_scnario_id);       // 변경된 시나리오를 가지고 해당 데이터의 내용을 변경을 한다. 
					//cntrRepoPlanOptiExecuteBC.createRepoPlanRunOptimizeralone(ees_eqr49_event);  // 새로운 환경 설정값을 설정한다.
					run_id_no = new_repo_id.substring(4,10)+seq;
					condiVO065.setRunId(run_id_no);
					command.send0065ReRunSteve(condiVO065);
					//run_id_no = new_repo_id.substring(4,10)+seq;
					//condiVO065.setRunId(run_id_no);
					log.info("run_id_no imple=========>" +condiVO065.getRunId());
					eventResponse.setCustomData("run_id_no",run_id_no);
					eventResponse.setETCData("run_id_no", run_id_no);
		    }catch (Exception de) {
	            log.error("err "+de.toString(),de);
	            throw new EventException(de.getMessage());
	        }
		return eventResponse;//Return Method 호출하는 부분
	}
	

	
	 /**
     * 0088화면(민감도 조회 이벤트 처리)<br>
     * SimulationManage 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchPlanSensitivityCompare(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EesEqr0088Event event = (EesEqr0088Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();
        
        try {
        	CntrRepoPlanSensitivityAnalysisBC command = new CntrRepoPlanSensitivityAnalysisBCImpl();
        	begin();
        	CommonRsVO commonRsVO = command.searchPlanSensitivityCompare(event.getEesEqr0088ConditionVO());
        	rsVoList.add(commonRsVO);
        	eventResponse.setRsVoList(rsVoList);
            commit();
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }   
    
    /**
     * 0088화면(민감도 조회 이벤트 처리)<br>
     * SimulationManage 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchUnitCostSensitivityCompare(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EesEqr0088Event event = (EesEqr0088Event)e;    	
        
        try {
        	CntrRepoPlanSensitivityAnalysisBC command = new CntrRepoPlanSensitivityAnalysisBCImpl();
        	begin();
        	CommonRsVO commonRsVO = command.searchUnitCostSensitivityCompare(event.getEesEqr0088ConditionVO());
        	eventResponse.setRs(commonRsVO.getDbRowset());
            commit();
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * 0088화면(민감도 조회 이벤트 처리)<br>
     * SimulationManage 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchRepoPlanType(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EesEqr0088Event event = (EesEqr0088Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	
    	String[] typeInfo = new String[3];
        
        try {
        	CntrRepoPlanSensitivityAnalysisBC command = new CntrRepoPlanSensitivityAnalysisBCImpl();
        	begin();
        	typeInfo = command.searchRepoPlanType(event.getEesEqr0088ConditionVO()).getResultStrArray();
        	eventResponse.setETCData("sensText" , typeInfo[0]);
        	eventResponse.setETCData("objText", typeInfo[1]);
        	eventResponse.setETCData("repo_rmk2" ,typeInfo[2]);
            commit();
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }   
}