/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ModelManageSC.java
*@FileTitle : Modelship by HO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.17
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.17 진마리아
* 1.0 Creation
* 2013.01.17 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.05.06 [CHM-201324211-01] 프로젝트 안정화 및 HELP DESK - SMP Season Creation 배치->backend로 변경
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2014.03.17 [CHM-20142960] SMP/Allocation control보완 요청
* 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
* 2014.11.13 박은주 [CHM-201432794] SMP 사용 편의기능 보완 요청(RHQ Add/DEL, OFC/Lane Load Guide가 0 인것들 일과 삭제, RHQ Load Guide 변경시 OFC Load Guide 배부로직 제거)
* 2015.07.23 이혜민 [CHM-201536881] SMP 보완 요청 (1.Import 팝업 Acct.add시 계약번호 Valid 및 MVC, C.OFC 가져옴. 2.Amend 팝업 계약번호 중복체크)
* 2015.09.15 이혜민 [CHM-201537538] SMP 오류 수정 건 및 Sub Trade Add 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.spc.common.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.basic.ModelManageBC;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.basic.ModelManageBCImpl;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event.EsmSpc0090Event;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event.EsmSpc0091Event;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event.EsmSpc0092Event;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event.EsmSpc0093Event;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event.EsmSpc0094Event;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event.EsmSpc0095Event;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event.EsmSpc0096Event;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event.EsmSpc0097Event;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event.EsmSpc0098Event;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration.ModelManageDBDAO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.CustCtrlGrpVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.CustManageVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.ModelPfmcVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SearchModelManageListVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SmpCustHisVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SmpHisVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SmpRptVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SpcBkgCmpbVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SpcHdHulVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.basic.SpaceAllocationManageBC;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.basic.SpaceAllocationManageBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ModelManage Business Logic ServiceCommand - ALPS-ModelManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Maria Chin
 * @see ModelManageDBDAO
 * @since J2EE 1.6
 */

public class ModelManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ModelManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ModelManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ModelManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ModelManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ModelManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmSpc0090Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Retrieve
				eventResponse = searchModelList(e); //적용
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { 
				eventResponse = checkOfcRhq(e); //적용
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkLaneTrd(e);//적용
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSeasonInfo(e);//적용
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
//				eventResponse = checkBatchEnd(e);
				eventResponse = searchBackEndJobVO(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) { // RHQ 유효성체크
				eventResponse = checkRhq(e);//적용
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) { // Sub Trade 유효성체크
				eventResponse = checkSubTrdCd(e);//적용
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // Save
				eventResponse = manageSpaceManagementPlan(e);//적용
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Confirm
				eventResponse = confirmVersion(e);//적용
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {// Creation
				eventResponse = createNewSeason(e);//적용
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // Reuse
				eventResponse = manageReviveOfcLane(e);//적용
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { // Regeneration
				eventResponse = manageSeasonRegeneration(e);//적용
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) { // Sub Trade Add
				eventResponse = searchNewAccountInfo(e);//적용
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {// Copy
                eventResponse = copyNewSeason(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSmpRole(e);
			} else {
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsmSpc0091Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSMPHistory(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSMPCustHistory(e);
			}else {
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0095Event")) { // Import
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchModelshipAcctList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageModelshipAcctList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchAcctValidEtcData(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0096Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWeeklyAvgPfmc(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0097Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgCmpb(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0098Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHdHul(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageHdHul(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0093Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSmpRptByOfc(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSmpRptByLane(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0094Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustCtrlGrp(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCustCtrlGrp(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0092Event")) { // Amend
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchModelshipAcctAmendList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkAmendScRfa(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkScRfaDup(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkSmpAmendList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageModelshipAcctAmend(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0091 : RETRIEVE<br>
	 * SMP History을 조회합니다.<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSMPHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0091Event event = (EsmSpc0091Event)e;
		ModelManageBC command = new ModelManageBCImpl();

		try{
			List<SmpHisVO> list = command.searchSMPHistory(event.getConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0091 : RETRIEVE<br>
	 * SMP Customer History을 조회합니다.<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSMPCustHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0091Event event = (EsmSpc0091Event)e;
		ModelManageBC command = new ModelManageBCImpl();
		
		try{
			List<SmpCustHisVO> list = command.searchSMPCustHistory(event.getConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * 노선별 Head Hual Bound 정보를 저장한다. <br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse manageHdHul(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0098Event event = (EsmSpc0098Event)e;
		ModelManageBC command = new ModelManageBCImpl();
		try {
			begin();
			command.manageHdHul(event.getSpcHdHulVOs(), account);
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_SPC_0098 : RETRIEVE<br>
	 * HeadHaul 정보를 조회합니다.<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchHdHul(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0098Event event = (EsmSpc0098Event)e;
		ModelManageBC command = new ModelManageBCImpl();
		
		try{
			List<SpcHdHulVO> list = command.searchHdHul(event.getConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

 
	
	   /**
     * ESM_SPC_0090 : RETRIEVE<br>
     * 해당 Season,Version의 Performance(최초) 또는 SMP 정보를 조회합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchModelList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmSpc0090Event event = (EsmSpc0090Event)e;
        ModelManageBC command = new ModelManageBCImpl();

        try{
            List<SearchModelManageListVO> list = command.searchModelList(event.getConditionVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }catch(Exception ex){
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }   
        return eventResponse;
    }
	
	/**
	 * 0091 open. 조회의 condition을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocationOfficeCond(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC command = new CommonBCImpl();
		
		try{
			List<SearchOfficeCondVO> list = command.searchOfficeCond(e, account);
			
			if(list.size() > 0){
				SearchOfficeCondVO searchOfficeCondVO = list.get(0);
				eventResponse.setETCData(searchOfficeCondVO.getColumnValues());
			}
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0095 : OPEN/RETRIEVE<br>
	 * Season/Version에 등록되어 있는 Modelship Account를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchModelshipAcctList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0095Event event = (EsmSpc0095Event)e;
		ModelManageBC command = new ModelManageBCImpl();
		
		try{
			List<CustManageVO> list = command.searchModelshipAcctList(event.getCustManageVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0096 : OPEN/RETRIEVE<br>
	 * 선택된 Customer, SC 에 대한 Sub Trade별, 노선별 PFMC를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeeklyAvgPfmc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0096Event event = (EsmSpc0096Event)e;
		ModelManageBC command = new ModelManageBCImpl();
		
		try{
			List<ModelPfmcVO> list = command.searchWeeklyAvgPfmc(event.getModelPfmcVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0095 : SAVE<br>
	 * Season/Version 미컨펌시 Account 정보를 수정 / 컨펌시 version up 하며 Account 정보를 등록합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageModelshipAcctList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0095Event event = (EsmSpc0095Event)e;
		ModelManageBC command = new ModelManageBCImpl();
		try {
			begin();
			List<String> errList = command.manageModelshipAcctList(event.getCustManageVOs(), account);

			StringBuffer errData = new StringBuffer();
			//errList.get(0) 은 new version
			if(errList.size()>1){
				for(int i=1; i<errList.size(); i++){
					errData.append(errList.get(i));
					if(i<errList.size()-1){
						errData.append("|");
					}
				}
			}
			eventResponse.setETCData("err_data", errData.toString());
			eventResponse.setETCData("new_ver", errList.get(0));
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	 
	
	   /**
     * ESM_SPC_0090 : L.OFC Change<br>
     * 입력한 OFC가 지정된 RHQ에 해당하는지 확인합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkOfcRhq(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmSpc0090Event event = (EsmSpc0090Event)e;
        CommonBC comCommand = new CommonBCImpl();
         
        try{
            SearchModelManageListVO vo = event.getSearchModelManageListVO();
            boolean rtn = comCommand.checkOfcRhq(vo.getSlsRhqCd(), vo.getSlsRgnOfcCd());
 
            eventResponse.setETCData("ofc_chk", rtn==true?"Y":"N");
         }catch(EventException ex){
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }catch(Exception ex){
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }   
        return eventResponse;
    }
	
 
	
	
	   /**
     * ESM_SPC_0090 : Sub Trade Change<br>
     * 입력한 Sub Trade가 유효한지 확인합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkSubTrdCd(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmSpc0090Event event = (EsmSpc0090Event)e;
        CommonBC comCommand = new CommonBCImpl();
        
        try{
            SearchModelManageListVO vo = event.getSearchModelManageListVO();
            boolean rtn = comCommand.checkSubTrdCd(vo.getTrdCd(), vo.getSubTrdCd());
            eventResponse.setETCData("sub_trd_chk", rtn==true?"Y":"N");
        }catch(EventException ex){
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }catch(Exception ex){
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }   
        return eventResponse;
    }
 
	   
    /**
     * ESM_SPC_0090 : RHQ Change<br>
     * 입력한 RHQ가 유효한지 확인합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkRhq(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmSpc0090Event event = (EsmSpc0090Event)e;
        CommonBC comCommand = new CommonBCImpl();
        
        try{
            SearchModelManageListVO vo = event.getSearchModelManageListVO();
            boolean rtn = comCommand.checkRhq(vo.getSlsRhqCd());
            eventResponse.setETCData("rhq_chk", rtn==true?"Y":"N");
        }catch(EventException ex){
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }catch(Exception ex){
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }   
        return eventResponse;
    }
	 
	

    /**
     * ESM_SPC_0090 : RLANE Change<br>
     * 입력한 RLANE이 지정된 Trade, Sub Trade에 해당하는지 확인합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkLaneTrd(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmSpc0090Event event = (EsmSpc0090Event)e;
        CommonBC comCommand = new CommonBCImpl();
//      ModelManageBC command = new ModelManageBCImpl();
        
        try{
            SearchModelManageListVO vo = event.getSearchModelManageListVO();
            boolean rtn = comCommand.checkLaneTrd(vo.getTrdCd(), vo.getSubTrdCd(), vo.getRlaneCd());
   
            eventResponse.setETCData("lane_chk", rtn==true?"Y":"N");
        }catch(EventException ex){
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }catch(Exception ex){
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }   
        return eventResponse;
    }
    
 
	   /**
     * ESM_SPC_0090 : SAVE<br>
     * Space Management Plan 을 수립합니다.(H/O & RHQ)<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageSpaceManagementPlan(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmSpc0090Event event = (EsmSpc0090Event)e;
        ModelManageBC command = new ModelManageBCImpl();
        try {
            begin();
            command.manageSpaceManagementPlan(event.getSearchModelManageListVOs(), account);
            commit();
        } catch(EventException ex){
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }
        return eventResponse;
    }
    

 
	
	

    /**
     * ESM_SPC_0090 : Season Change<br>
     * 해당 season 의 실적 기준 - from, to, duration 조회합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSeasonInfo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmSpc0090Event event = (EsmSpc0090Event)e;
        ModelManageBC command = new ModelManageBCImpl();
        
        try{
            String[] arr = command.searchSeasonInfo(event.getConditionVO());
            eventResponse.setETCData("from", arr[0]==null?"":arr[0]);
            eventResponse.setETCData("to", arr[1]==null?"":arr[1]);
            eventResponse.setETCData("duration", arr[2]==null?"":arr[2]);
            eventResponse.setETCData("cfm_ver_period", arr[3]==null?"":arr[3]);
        }catch(EventException ex){
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }catch(Exception ex){
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }   
        return eventResponse;
    }
 
	

    /**
     * ESM_SPC_0090 : Creation<br>
     * 새로운 Space Management Plan 의 Season을 생성합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse createNewSeason(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmSpc0090Event event = (EsmSpc0090Event)e;
        ModelManageBC command = new ModelManageBCImpl();
        try {
            begin();
//          log.debug("========================createNewSeason SC Start================================");
            String key = command.createNewSeason(event.getSpcMdlVerMstVO(), event.getCustCtrlGrpVOs(), account);
            eventResponse.setETCData("BackEndJobKey", key);
            commit();
        } catch(EventException ex){
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }
        return eventResponse;
    }
    

    /**
     * ESM_SPC_0090 : Creation<br>
     * 새로운 Space Management Plan 의 Season을 생성합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse copyNewSeason(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmSpc0090Event event = (EsmSpc0090Event)e;
        ModelManageBC command = new ModelManageBCImpl();
        try {
            begin();
//          log.debug("========================createNewSeason SC Start================================");
            String key = command.copyNewSeason(event.getSpcMdlVerMstVO(),  account);
            eventResponse.setETCData("BackEndJobKey", key);
            commit();
        } catch(EventException ex){
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }
        return eventResponse;
    }
 
	
	   /**
     * ESM_SPC_0090 : Creation<br>
     * Space Management Plan 의 version을 Confirm합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse confirmVersion(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmSpc0090Event event = (EsmSpc0090Event)e;
        ModelManageBC command = new ModelManageBCImpl();
        SpaceAllocationManageBC allocCommand = new SpaceAllocationManageBCImpl();
        try {
            begin();
            command.confirmVersion(event.getSpcMdlVerMstVO(),event.getSpcMdlExptWkVOList(), account);
            String verSeq = event.getSpcMdlVerMstVO().getVerSeq();
            if(verSeq != null && "1".equals(verSeq)){
                //Season 내 첫번째 version의 컨펌시 적용 이후 주차에 기등록되어있는 Allocation 을 조정한다.(SPC_MDL_CUST_CTRL_GRP 관련)
                allocCommand.multiCustCtrlAlloc(event.getSpcMdlVerMstVO());
            }
            commit();
        } catch(EventException ex){
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }
        return eventResponse;
    }
    
    
	/**
     * BackEndJob : interval <br>
     * BackEndJob의 상태값을 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBackEndJobVO(Event e) throws EventException {
        String key = (String)e.getAttribute("KEY");
        String[] rtnArr = null;
        String status = null;
        String errMsg = null;
        ModelManageBC command = new ModelManageBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	rtnArr = command.searchBackEndJobVO(key);
        	status = rtnArr[0];
        	errMsg = rtnArr[1];
            eventResponse.setETCData("jb_sts_flg", status);
            eventResponse.setETCData("jb_usr_err_msg", errMsg);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * ESM_SPC_0097 : OPEN/RETRIEVE<br>
	 * 선택된 Customer, SC 에 대한 Sub Trade별, 노선별 BKG pol,pod CMPB를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgCmpb(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0097Event event = (EsmSpc0097Event)e;
		ModelManageBC command = new ModelManageBCImpl();
		
		try{
			List<SpcBkgCmpbVO> list = command.searchBkgCmpb(event.getSpcBkgCmpbVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0093 By Lane tab : RETRIEVE<br>
	 * 조건에 맞는 SMP Loading 정보 Lane 관점에서 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSmpRptByLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0093Event event = (EsmSpc0093Event)e;
		ModelManageBC command = new ModelManageBCImpl();
		
		try{
			List<SmpRptVO> list = command.searchSmpRptByLane(event.getConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0093 By Office tab : RETRIEVE<br>
	 * 조건에 맞는 SMP Loading 정보 Office 관점에서 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSmpRptByOfc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0093Event event = (EsmSpc0093Event)e;
		ModelManageBC command = new ModelManageBCImpl();
		
		try{
			List<SmpRptVO> list = command.searchSmpRptByOfc(event.getConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
 
	

    /**
     * ESM_SPC_0090 : REVIVE<br>
     * 삭제 처리된 office 또는 lane을 재사용하기 위해 살립니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageReviveOfcLane(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmSpc0090Event event = (EsmSpc0090Event)e;
        ModelManageBC command = new ModelManageBCImpl();
        
        try{
            begin();
            command.manageReviveOfcLane(event.getSearchModelManageListVO(), account);
            commit();
        }catch(EventException ex){
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }   
        return eventResponse;
    }
	
	/**
	 * ESM_SPC_0090 : open<br>
	 * login user의 role 여부를 조회합니다.<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSmpRole(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsmSpc0090Event event = (EsmSpc0090Event)e;
		CommonBC command = new CommonBCImpl();
		
		try{
			String spc01 = null;
			String spc08 = null;
			String spc09 = null;
			
			String[] ofcInfo = command.searchSmpRole(account.getUsr_id());
			if(ofcInfo != null){
				spc01 = ofcInfo[0];
				spc08 = ofcInfo[1];
				spc09 = ofcInfo[2];
			}
			eventResponse.setETCData("spc01", spc01);
			eventResponse.setETCData("spc08", spc08);
			eventResponse.setETCData("spc09", spc09);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0094 : RETRIEVE<br>
	 * Trade, 조회주차에 해당하는 Season의 Yield Group 정보를 조회합니다.<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchCustCtrlGrp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0094Event event = (EsmSpc0094Event)e;
		ModelManageBC command = new ModelManageBCImpl();

		try{
			List<CustCtrlGrpVO> list = command.searchCustCtrlGrp(event.getConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0094 : SAVE<br>
	 * Trade, 조회주차에 해당하는 Season의 Yield Group 저장을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCustCtrlGrp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0094Event event = (EsmSpc0094Event)e;
		ModelManageBC command = new ModelManageBCImpl();
		try {
			begin();
			command.manageCustCtrlGrp(event.getCustCtrlGrpVOs(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0092 : OPEN/RETRIEVE<br>
	 * Season/Version에 등록되어 있는 Modelship Account 중 유효하지 않은 S/C, RFA 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchModelshipAcctAmendList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0092Event event = (EsmSpc0092Event)e;
		ModelManageBC command = new ModelManageBCImpl();
		
		try{
			List<CustManageVO> list = command.searchModelshipAcctAmendList(event.getCustManageVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0092 : S/C, RFA Change<br>
	 * 입력한 S/C, RFA 가 유효 한지 확인합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkAmendScRfa(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0092Event event = (EsmSpc0092Event)e;
		ModelManageBC command = new ModelManageBCImpl();
		
		try{
			boolean rtn = command.checkAmendScRfa(event.getCustManageVO());

			eventResponse.setETCData("chk", rtn==true?"Y":"N");
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0092 : SAVE<br> 
	 * S/C, RFA 정보를 Update 한다. <br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageModelshipAcctAmend(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0092Event event = (EsmSpc0092Event)e;
		ModelManageBC command = new ModelManageBCImpl();
		
		try {
			begin();
			command.manageModelshipAcctAmend(event.getCustManageVOs(), account);
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0090 : SEARCH05<br>
	 * Amend 해야할 S/C, RFA 존재 여부 확인합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSmpAmendList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0092Event event = (EsmSpc0092Event)e;
		ModelManageBC command = new ModelManageBCImpl();
		
		try{
			boolean rtn = command.checkSmpAmendList(event.getCustManageVO());

			eventResponse.setETCData("chk", rtn==true?"Y":"N");
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0092 : SEARCH02<br>
	 * Amend 팝업에서 입력한 SC, RFA#의 중복을 체크합니다. (SPC_MDL_CUST_CTRL 테이블내)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkScRfaDup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0092Event event = (EsmSpc0092Event)e;
		ModelManageBC command = new ModelManageBCImpl();
		
		try{
			boolean rtn = command.checkScRfaDup(event.getCustManageVO());

			eventResponse.setETCData("chk", rtn==true?"Y":"N");
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
 

    /**
     * ESM_SPC_0090 : Regeneration<br>
     * Space Management Plan 의 PERF 를 재생성합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageSeasonRegeneration(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmSpc0090Event event = (EsmSpc0090Event)e;
        ModelManageBC command = new ModelManageBCImpl();
        
        try {
            begin();
            String key = command.manageSeasonRegeneration(event.getSpcMdlVerMstVO(), account);
            eventResponse.setETCData("BackEndJobKey", key);
            commit();
        } catch(EventException ex){
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }
        return eventResponse;
    }
 
	
	   /**
     * ESM_SPC_0090 : MULTI05<br>
     * 실적이 아예 없는 화주를 조회 후 Sub Trade Add 했을 경우 해당 Account 기본 정보를 조회합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNewAccountInfo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmSpc0090Event event = (EsmSpc0090Event)e;
        ModelManageBC command = new ModelManageBCImpl();

        try{
            List<SearchModelManageListVO> list = command.searchNewAccountInfo(event.getConditionVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }catch(Exception ex){
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }   
        return eventResponse;
    }
	
	/**
	 * ESM_SPC_0095 : SEARCHLIST01<br>
	 * Acct. Add 후 Account, SC, RFA 입력 시 해당 계약의 유효성 체크 및  MVC, C.OFC 조회해온다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAcctValidEtcData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0095Event event = (EsmSpc0095Event)e;
		ModelManageBC command = new ModelManageBCImpl();
		
		try{
			String acctData = command.searchAcctValidEtcData(event.getCustManageVO());
			eventResponse.setETCData("acctData", acctData);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
}