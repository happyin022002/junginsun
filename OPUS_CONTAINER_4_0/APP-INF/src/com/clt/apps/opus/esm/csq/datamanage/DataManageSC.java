/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : DataManageSC.java
*@FileTitle      : DataManage
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.03 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage;

import java.util.List;

import com.clt.apps.opus.esm.csq.common.basic.CommonBC;
import com.clt.apps.opus.esm.csq.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.basic.BasicDataBC;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.basic.BasicDataBCImpl;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.event.EsmCsq0001Event;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.event.EsmCsq0003Event;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.event.EsmCsq0008Event;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.event.EsmCsq0009Event;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.event.EsmCsq0010Event;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.event.EsmCsq0011Event;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.event.EsmCsq0002Event;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.event.EsmCsq0201Event;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.event.EsmCsq0202Event;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.event.EsmCsq0203Event;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.event.EsmCsq0207Event;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.event.EsmCsq0208Event;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.integration.BasicDataDBDAO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchAddPolPodPairForSectorVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchBasicDataCreationForSecterListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchBasicDataCreationListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchBasicDataRelationListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchLaneDirectionChangeListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchPfSkdGrpForSectorListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchPolPodPairSectorListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchTargerVvdFixListVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.basic.CostManageBC;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.basic.CostManageBCImpl;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.event.EsmCsq0012Event;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.event.EsmCsq0013Event;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.event.EsmCsq0014Event;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.event.EsmCsq0015Event;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.event.EsmCsq0005Event;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.event.EsmCsq0209Event;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.event.EsmCsq0210Event;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.event.EsmCsq0211Event;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.event.EsmCsq0212Event;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchAddedNewLaneListVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchBasicCmcbCoaPfmcListListVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchBasicCmcbCoaUcPfmcVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchBasicCmcbListVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchNewLaneOfficeCmcbListVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchNewLaneSecCmcbListVO;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.basic.OfficeMappingBC;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.basic.OfficeMappingBCImpl;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.event.EsmCsq0004Event;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.event.EsmCsq0006Event;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.event.EsmCsq0007Event;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.event.EsmCsq0204Event;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.event.EsmCsq0205Event;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.event.EsmCsq0206Event;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.vo.SearchAddSectorOfcRelSetVO;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.vo.SearchLaneOfficeRelationListVO;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.vo.SearchLaneOfficeRelationNewLaneAddListVO;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.vo.SearchSectorOfcRelationSetListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CsqQtaLaneMgmtVO;
import com.clt.syscommon.common.table.CsqQtaLaneOfcCostVO;
import com.clt.syscommon.common.table.CsqQtaOfcVO;

/**
 * ALPS-DataManage Business Logic ServiceCommand - ALPS-DataManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author CSQ USER
 * @see BasicDataDBDAO
 * @since J2EE 1.6
 */

public class DataManageSC extends ServiceCommandSupport {
	
	// Login User Information
	private SignOnUserAccount account = null;
	
	/**
	 * DataManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("DataManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}
	
	/**
	 * DataManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("DataManageSC 종료");
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
		if (e.getEventName().equalsIgnoreCase("EsmCsq0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicDataRelationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBasicDataRelation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = copyBasicDataRelation(e);
 			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0001(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmCsq0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneMasterList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0002(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageLaneMaster(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = copyLaneMaster(e);
 			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmCsq0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneDirectionChangeList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) { 
				eventResponse = searchComBoCdList0003(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) { 
				eventResponse = manageLaneDirectionChange(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) { 
				eventResponse = copyLaneDirectionChange(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCsq0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicDataCreationList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0008(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("EsmCsq0009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createCsqPerfIf(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0009(e);
			}	
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTargerVvdFixList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0010(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) { 
				eventResponse = manageTargerVvdFix(e); 
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createTargerVvdFix(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTargerVvdFixForCreation(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTargerVvdFixListCnt(e);
			}else{
				eventResponse = searchCreationUser(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmCsq0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneList(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EsmCsq0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRhqOfcMappingList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0004(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) { 
				eventResponse = manageRhqOfcMapping(e); 
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCsq0006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneOfficeRelationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageLaneOfficeRelation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createLaneOfficeRelation(e);
 			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0006(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCsq0007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneOfficeRelationNewLaneAddList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0007(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAddedNewLaneList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0012(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) { 
				eventResponse = manageAddedNewLane(e); 
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createNewLaneOfficeCmcb(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchNewLaneOfficeCmcbList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageNewLaneOfficeCmcb(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicCmcbList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBasicCmcb(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createBasicCmcb(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0013(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicCmcbNewLaneCostIfList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBasicCmcbNewLaneCostIf(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicCmcbCoaPfmcList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0015(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0005Event")) {
			if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0005(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = createRelatedData(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0201Event")) {
			if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0201(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkdGrpForSectorList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBackEndJobVO(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createPfSkdGrpForSector(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = createAddPfSkdGrpForSector(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0202Event")) {
			if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0202(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPolPodPairSectorList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPolPodPairSectorListT2(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBackEndJobVO(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPolPodPairNMainFlgList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePolPodPairForSector(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createPolPodPairForSector(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0203Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAddPolPodPairForSector(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createAddPolPodPairForSector(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0204Event")) {
			if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0204(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSectorOfcRelationSetList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBackEndJobVO(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSectorOfcRelationSetNActList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSectorOfcRelationSet(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createSectorOfcRelationSet(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = excelDownSectorOfficeRelationSet(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0205Event")) {
			if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0205(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAddSectorOfcRelSetPfGrp(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createAddSectorOfcRelSetPfGrp(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0206Event")) {
			if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0206(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAddSectorOfcRelSetPolPod(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createAddSectorOfcRelSetPolPod(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0207Event")) {
			if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0207(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicDataCreationForSecterList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0208Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) { 
				eventResponse = createBasicDataCreationForSecter(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0209Event")) {
			if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0209(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNewLaneSecCmcbList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchNewLaneSecCmcbPairCost(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createNewLaneSecCmcbPairCost(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageNewLaneSecCmcbNewLane(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageNewLaneSecCmcbPairCost(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0210Event")) {
			if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0210(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicCmcbForIasSectorList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBackEndJobVO(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBasicCmcbForIasSectorList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createBasicCmcbForIasSector(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0211Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicCmcbForIasSecNewLaneIf(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = addBasicCmcbForIasSecNewLaneIf(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0212Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0212(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicCmcbCoaUcPfmc(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicDataRelationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0001Event event = (EsmCsq0001Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			List<SearchBasicDataRelationListVO> list = command.searchBasicDataRelationList(event.getConditionVO());
			String dataCnt = command.searchBasicDataRelationListCnt(event.getConditionVO());
			
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
	 *  ESM_CSQ_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [복사]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse copyBasicDataRelation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0001Event event = (EsmCsq0001Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			begin();
			command.copyBasicDataRelation(event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 *  ESM_CSQ_0002 : [이벤트]<br>
	 * [Lane Master]을 [복사]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse copyLaneMaster(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0002Event event = (EsmCsq0002Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			begin();
			command.copyLaneMaster(event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [저장]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBasicDataRelation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0001Event event = (EsmCsq0001Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			begin();
			command.manageBasicDataRelation(event.getCsqDatRltVOS(), event.getConditionVO(), account);
			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0001 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0001(Event e) throws EventException {
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
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. Trade */
					{"mdmTrade", "", "All"},
					/* 6. Bound. */
					{"comCodeBound", "", "All"},
					/* 7. H/O Teams. */
					{"hoTeams", "", "All"},
					/* 8. RHQ. */
					{"rhq", "", "All"},
					/* 9. Out/Non Out Bound. */
					{"comCodeOutNonOutBound", "", "All"},
					
					// Row Add
					/* 10. Trade */
					{"mdmTrade", "", ""},
					/* 11. Bound. */
					{"comCodeBound", "", ""},
					/* 12. RHQ. */
					{"rhq", "", ""},
					/* 13. Out/Non Out Bound. */
					{"comCodeOutNonOutBound", "", ""}
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
	 * ESM_CSQ_0003 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0003(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year. */
					{"year", "", ""},
					/* 2. Quarter. */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""},
					/* 4. Bound. */
					{"comCodeBound", "", ""}
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
	 * ESM_CSQ_0008 : [이벤트]<br>
	 * [Basic Data Creation]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicDataCreationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0008Event event = (EsmCsq0008Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			List<SearchBasicDataCreationListVO> list = command.searchBasicDataCreationList(event.getConditionVO());
			String dataCnt = command.searchBasicDataCreationListCnt(event.getConditionVO());
			
			if ( !dataCnt.isEmpty() ) {
				String data[] = dataCnt.split("[|]");
				
				eventResponse.setETCData("dataCnt", data[0]);
				eventResponse.setETCData("aplyFmYrwk", data[0].equals("0")?"":data[1]);
				eventResponse.setETCData("aplyToYrwk", data[0].equals("0")?"":data[2]);
			}
			
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
	 * ESM_CSQ_0008 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0008(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year. */
					{"year", "", ""},
					/* 2. Quarter. */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""},
					/* 4. Office View. */
					{"officeView", "", ""},
					/* 6. Bound. */
					{"comCodeBound", "", "All"},
					/* 7. Office Level. */
					{"comCodeOfficLevel", "", ""},
					/* 8. RHQ. */
					{"rhqForPlan", "", "All"}
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
	 * ESM_CSQ_0009 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0009(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""}
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
	 * ESM_CSQ_0010 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0010(Event e) throws EventException {
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
					/* 4. Bound. */
					{"comCodeBound", "", "All"}
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
	 * ESM_CSQ_0004 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0004(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
				/* 1. RHQ. */
				{"rhq", "", ""},
				/* 2. Office. */
				{"office", "", ""}
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
	 * ESM_CSQ_0006 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0006(Event e) throws EventException {
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
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. Bound. */
					{"comCodeBound", "", "All"},
					/* 6. RHQ. */
					{"rhqForPlan", "", "All"}
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
	 * ESM_CSQ_0007 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0007(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Bound. */
					{"comCodeBound", "", "All"}
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
	 * ESM_CSQ_0012 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0012(Event e) throws EventException {
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
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. Bound. */
					{"comCodeBound", "", "All"}
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
	 * ESM_CSQ_0013 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0013(Event e) throws EventException {
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
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. Bound */
					{"comCodeBound", "", "All"},
					/* 6. RHQ. */
					{"rhqForPlan", "", "All"}
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
	 * ESM_CSQ_0015 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0015(Event e) throws EventException { 
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
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. RHQ. */
					{"rhqForPlan", "", "All"},
					/* 6. Bound. */
					{"comCodeBound", "", "All"}
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
	 * ESM_CSQ_0002 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0002(Event e) throws EventException {
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
					{"mdmTrade", "", ""},
					/* 5. Bound. */
					{"comCodeBound", "", ""}
					
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
	 * ESM_CSQ_0003 : Retrieve 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLaneDirectionChangeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0003Event event = (EsmCsq0003Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			List<SearchLaneDirectionChangeListVO> list = command.searchLaneDirectionChangeList(event.getConditionVO());
			String dataCnt = command.searchLaneDirectionChangeListCnt(event.getConditionVO());
			
			eventResponse.setETCData("dataCnt", dataCnt);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0003 : Save 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageLaneDirectionChange(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0003Event event = (EsmCsq0003Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			begin();
			command.manageLaneDirectionChange(event.getCsqDirConvVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
			return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0003 : Copy 이벤트 처리<br>
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse copyLaneDirectionChange(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0003Event event = (EsmCsq0003Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			begin();
			command.copyLaneDirectionChange(event.getConditionVO(),account.getUsr_id());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0004 : Retrieve 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRhqOfcMappingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0004Event event = (EsmCsq0004Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try {
			List<CsqQtaOfcVO> list = command.searchRhqOfcMappingList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0010 : Retrieve 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTargerVvdFixList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0010Event event = (EsmCsq0010Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			List<SearchTargerVvdFixListVO> list = command.searchTargerVvdFixList(event.getConditionVO());
			String dataCnt = command.searchTargerVvdFixListCnt(event.getConditionVO());
			
			eventResponse.setETCData("dataCnt", dataCnt);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0010 : Creation 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createTargerVvdFix(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0010Event event = (EsmCsq0010Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			begin();
			command.createTargerVvdFix(event.getConditionVO(),account.getUsr_id());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0011 : Retrieve 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0011Event event = (EsmCsq0011Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			List<SearchTargerVvdFixListVO> list = command.searchLaneList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0010 : Save 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageTargerVvdFix(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0010Event event = (EsmCsq0010Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			begin();
			command.manageTargerVvdFix(event.getCsqQtaTgtVvdVOS(), event.getConditionVO() ,account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
			return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0009 : [이벤트]<br>
	 * [CSQ PERF IF]을 [생성] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCsqPerfIf(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0009Event event = (EsmCsq0009Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			eventResponse.setETCData("BatchStatus", command.createCsqPerfIf(event.getConditionVO(), account));         
		} catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0006 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneOfficeRelationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0006Event event = (EsmCsq0006Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try{
			List<SearchLaneOfficeRelationListVO> list = command.searchLaneOfficeRelationList(event.getConditionVO());
			String dataCnt = command.searchLaneOfficeRelationListCnt(event.getConditionVO());
			
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
	 * ESM_CSQ_0004 : Save 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageRhqOfcMapping(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0004Event event = (EsmCsq0004Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try{
			begin();
			command.manageRhqOfcMapping(event.getCsqQtaOfcVOS(),account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
			return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0005 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0005(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""}
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
	 * ESM_CSQ_0012 : [New Lane & Office CMCB] 을 [조회] 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddedNewLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0012Event event = (EsmCsq0012Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try {
			List<SearchAddedNewLaneListVO> list = command.searchAddedNewLaneList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0012 : MULTI 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageAddedNewLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0012Event event = (EsmCsq0012Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try{
			begin();
			command.manageAddedNewLane(event.getCsqQtaNewLaneVOS(),event.getConditionVO(),account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
			return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0012 : MULTI01 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createNewLaneOfficeCmcb(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0012Event event = (EsmCsq0012Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try {
			begin();
			String msg = command.createNewLaneOfficeCmcb(event.getCsqQtaNewLaneVOS(),event.getConditionVO(), account.getUsr_id());			
			eventResponse.setETCData("msg", msg);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0012 : SEARCHLIST 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchNewLaneOfficeCmcbList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0012Event event = (EsmCsq0012Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try {
			List<SearchNewLaneOfficeCmcbListVO> list = command.searchNewLaneOfficeCmcbList(event.getConditionVO(), event.getCsqQtaNewLaneVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0012 : MULTI02 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageNewLaneOfficeCmcb(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0012Event event = (EsmCsq0012Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try{
			begin();
			command.manageNewLaneOfficeCmcb(event.getCsqQtaNewLaneOfcCostVOS(),account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
			return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0005 : COMMAND01 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createRelatedData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0005Event event = (EsmCsq0005Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try {
			begin();
			command.createRelatedData(event.getCsqQtaLaneOfcVOS(),event.getConditionVO(), account.getUsr_id());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0002 : Retrieve 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLaneMasterList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0002Event event = (EsmCsq0002Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			List<CsqQtaLaneMgmtVO> list = command.searchLaneMasterList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0002 : MULTI 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageLaneMaster(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0002Event event = (EsmCsq0002Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			begin();
			command.manageLaneMaster(event.getCsqQtaLaneMgmtVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
			return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0006 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [저장]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageLaneOfficeRelation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0006Event event = (EsmCsq0006Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try{
			begin();
			command.manageLaneOfficeRelation(event.getCsqQtaLaneOfcVOS(), event.getConditionVO(), account);
			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0006 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createLaneOfficeRelation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0006Event event = (EsmCsq0006Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try {
			begin();
			command.createLaneOfficeRelation(event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0007 : [이벤트]<br>
	 * [RHQ-Office Mapping Data]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneOfficeRelationNewLaneAddList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0007Event event = (EsmCsq0007Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try{
			List<SearchLaneOfficeRelationNewLaneAddListVO> list = command.searchLaneOfficeRelationNewLaneAddList(event.getConditionVO());
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
	 * ESM_CSQ_0013 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicCmcbList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0013Event event = (EsmCsq0013Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try{
			List<SearchBasicCmcbListVO> list = command.searchBasicCmcbList(event.getConditionVO());
			String dataCnt = command.searchBasicCmcbListCnt(event.getConditionVO());
			
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
	 * ESM_CSQ_0013 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createBasicCmcb(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0013Event event = (EsmCsq0013Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try {
			begin();
			command.createBasicCmcb(event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0013 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [수정]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageBasicCmcb(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0013Event event = (EsmCsq0013Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try {
			begin();
			command.manageBasicCmcb(event.getCsqQtaLaneOfcCostVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0014 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicCmcbNewLaneCostIfList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0014Event event = (EsmCsq0014Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try{
			List<CsqQtaLaneOfcCostVO> list = command.searchBasicCmcbNewLaneCostIfList(event.getConditionVO());
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
	 * ESM_CSQ_0014 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageBasicCmcbNewLaneCostIf(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0014Event event = (EsmCsq0014Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try {
			begin();
			command.manageBasicCmcbNewLaneCostIf(event.getCsqQtaLaneOfcCostVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0015 : [이벤트]<br>
	 * [Basic CMCB_COA UC PFMC Retrieve)]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicCmcbCoaPfmcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0015Event event = (EsmCsq0015Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try{
			List<SearchBasicCmcbCoaPfmcListListVO> list = command.searchBasicCmcbCoaPfmcList(event.getConditionVO());
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
	 * ESM_CSQ_0010 : SEARCH02 이벤트 처리<br>
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTargerVvdFixListCnt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0010Event event = (EsmCsq0010Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			String dataCnt = command.searchTargerVvdFixListCnt(event.getConditionVO());			
			eventResponse.setETCData("dataCnt", dataCnt);
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0010 : default 이벤트 처리<br>
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCreationUser(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			String creFlg = command.searchCreationUser(account.getOfc_cd());			
			eventResponse.setETCData("creFlg", creFlg);
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_CSQ_0010 : SEARCH01 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTargerVvdFixForCreation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0010Event event = (EsmCsq0010Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			List<SearchTargerVvdFixListVO> list = command.searchTargerVvdFixForCreation(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0201 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0201(Event e) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""}
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
	 * ESM_CSQ_0202 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0202(Event e) throws EventException { 
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
					/* 4. Bound. */
					{"comCodeBound", "", "All"}
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
	 * ESM_CSQ_0204 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0204(Event e) throws EventException { 
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
					/* 4. Bound. */
					{"comCodeBound", "", ""},
					/* 5. Office View */
					{"officeView", "", ""},
					/* 6. RHQ. */
					{"rhqForPlan", "", "All"}
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
	 * ESM_CSQ_0205 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0205(Event e) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Bound. */
					{"comCodeBound", "", ""}
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
	 * ESM_CSQ_0206 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0206(Event e) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Bound. */
					{"comCodeBound", "", ""}
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
	 * ESM_CSQ_0207 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0207(Event e) throws EventException { 
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
					/* 4. Bound. */
					{"comCodeBound", "", "All"},
					/* 5. Office View */
					{"officeView", "", ""},
					/* 6. RHQ. */
					{"rhqForPlan", "", "All"}
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
	 * ESM_CSQ_0210 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0210(Event e) throws EventException { 
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
					/* 4. Bound. */
					{"comCodeBound", "", "All"}
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
	 * ESM_CSQ_0201 : Retrieve<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPfSkdGrpForSectorList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0201Event event = (EsmCsq0201Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			List<SearchPfSkdGrpForSectorListVO> list = command.searchPfSkdGrpForSectorList(event.getConditionVO());
			String dataCnt = command.searchPfSkdGrpForSectorListCnt(event.getConditionVO());
			
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
	 * ESM_CSQ_0201 : Creation<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createPfSkdGrpForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0201Event event = (EsmCsq0201Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.createPfSkdGrpForSector(event.getConditionVO(), account.getUsr_id()));
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
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
        BasicDataBC command = new BasicDataBCImpl();
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
	 * ESM_CSQ_0201 : Add-Creation<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [추가 생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createAddPfSkdGrpForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0201Event event = (EsmCsq0201Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			begin();
			command.createAddPfSkdGrpForSector(event.getConditionVO(), account.getUsr_id());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0202 : Retrieve<br>
	 * [POL POD Pair for IAS Sector List Tab1]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPolPodPairSectorList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0202Event event = (EsmCsq0202Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			List<SearchPolPodPairSectorListVO> list = command.searchPolPodPairSectorList(event.getConditionVO());
			String dataCnt = command.searchPolPodPairSectorListCnt(event.getConditionVO());
			
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
	 * ESM_CSQ_0202 : Retrieve<br>
	 * [POL POD Pair for IAS Sector List Tab2]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPolPodPairSectorListT2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0202Event event = (EsmCsq0202Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			List<SearchPolPodPairSectorListVO> list = command.searchPolPodPairSectorListT2(event.getConditionVO());
			
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
	 * ESM_CSQ_0202 : Creation 또는 Retrieve 후<br>
	 * [POL POD Pair for IAS Sector List 중 Main Flag가 하나도 없는 Lane, Bound]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPolPodPairNMainFlgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0202Event event = (EsmCsq0202Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		String list = "";
		StringBuffer listTtl = new StringBuffer();

		try{
			List<String> nMainList = command.searchPolPodPairNMainFlgList(event.getConditionVO());
			if(nMainList.size()>0){
				for(int i=0; i<nMainList.size(); i++){
					listTtl.append(", ");
					listTtl.append(nMainList.get(i));
					list = listTtl.toString();
				}
			}
			eventResponse.setETCData("nMainList", list);
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
	 * ESM_CSQ_0202 : Creation<br>
	 * [POL POD Pair for IAS Sector List]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createPolPodPairForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0202Event event = (EsmCsq0202Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.createPolPodPairForSector(event.getConditionVO(), account.getUsr_id()));
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0202 : SAVE<br>
	 * [POL POD Pair for IAS Sector List]을 [수정]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse managePolPodPairForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0202Event event = (EsmCsq0202Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			begin();
			command.managePolPodPairForSector(event.getCsqSctrPairMgmtVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0203 : Retrieve<br>
	 * [POL POD Pair for IAS Sector Add List]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAddPolPodPairForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0203Event event = (EsmCsq0203Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			List<SearchAddPolPodPairForSectorVO> list = command.searchAddPolPodPairForSector(event.getConditionVO());
			
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
	 * ESM_CSQ_0203 : CREATION<br>
	 * [POL POD Pair for IAS Sector Add List]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createAddPolPodPairForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0203Event event = (EsmCsq0203Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			begin();
			command.createAddPolPodPairForSector(event.getSearchAddPolPodPairForSectorVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0204 : Retrieve<br>
	 * [Sector Office Relation Setting]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSectorOfcRelationSetList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0204Event event = (EsmCsq0204Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try{
			List<SearchSectorOfcRelationSetListVO> list = command.searchSectorOfcRelationSetList(event.getConditionVO());
			List<SearchSectorOfcRelationSetListVO> list1 = command.searchSectorOfcRelationSetListT2(event.getConditionVO());
			String dataCnt = command.searchSectorOfcRelationSetListCnt(event.getConditionVO());
			
			eventResponse.setETCData("dataCnt", dataCnt);
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list1);
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
	 * ESM_CSQ_0204 : Creation<br>
	 * [Sector Office Relation Setting]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createSectorOfcRelationSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0204Event event = (EsmCsq0204Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.createSectorOfcRelationSet(event.getConditionVO(), account.getUsr_id()));
			commit();

		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0204 : Creation<br>
	 * [Sector Office Relation Setting_Act_flag가 하나도 없는 Lane List]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSectorOfcRelationSetNActList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0204Event event = (EsmCsq0204Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		String list = "";
		StringBuffer listTtl = new StringBuffer();

		try{
			List<String> nActList = command.searchSectorOfcRelationSetNActList(event.getConditionVO());
			if(nActList.size()>0){
				for(int i=0; i<nActList.size(); i++){
					listTtl.append(", ");
					listTtl.append(nActList.get(i));
					list = listTtl.toString();
				}
			}
			eventResponse.setETCData("nActList", list);
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
	 * ESM_CSQ_0204 : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse excelDownSectorOfficeRelationSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0204Event event = (EsmCsq0204Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try {
			List<SearchSectorOfcRelationSetListVO> list = command.searchSectorOfcRelationSetList(event.getConditionVO());
			
			if(list.size() > 0 && list != null){
				String headTitle    = "Year￠Quarter￠Office View￠Trade￠Sub Trade￠R.Lane￠Lane Bound￠RHQ￠Office￠POL￠POD￠Active￠Main";
				String column_names = "bse_yr￠bse_qtr_cd￠ofc_vw_cd￠trd_cd￠sub_trd_cd￠rlane_cd￠dir_cd￠rhq_cd￠rgn_ofc_cd￠pol_cd￠pod_cd￠csq_act_flg￠csq_mn_sctr_flg"; 
				
				String title[]   = headTitle.split("￠");
				String columns[] = column_names.split("￠");
				
				eventResponse.setCustomData("vos", list);
				eventResponse.setCustomData("title", title);
				eventResponse.setCustomData("columns", columns);
				eventResponse.setCustomData("fileName", "Sector-OfcSet.xls");
				eventResponse.setCustomData("isZip", false);
			} else {
				SearchSectorOfcRelationSetListVO vo = new SearchSectorOfcRelationSetListVO();
				
				vo.setBseYr("There is no data to search.");
				
				list.add(vo);
				
				String headTitle    = "Data";
				String column_names = "bse_yr"; 
				
				String title[]   = headTitle.split("￠");
				String columns[] = column_names.split("￠");
				
				eventResponse.setCustomData("vos", list);
				eventResponse.setCustomData("title", title);
				eventResponse.setCustomData("columns", columns);
				eventResponse.setCustomData("fileName", "Sector-OfcSet.xls");
				eventResponse.setCustomData("isZip", false);
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0204 : SAVE<br>
	 * [Sector Office Relation Setting]을 [수정]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSectorOfcRelationSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0204Event event = (EsmCsq0204Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try {
			begin();
			command.manageSectorOfcRelationSet(event.getCsqSctrLaneOfcVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0205 : Retrieve<br>
	 * [Sector Office Relation Set_Add Creation List]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAddSectorOfcRelSetPfGrp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0205Event event = (EsmCsq0205Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try{
			List<SearchAddSectorOfcRelSetVO> list = command.searchAddSectorOfcRelSetPfGrp(event.getConditionVO());
			String actCnt = command.searchAddSectorOfcRelSetPfGrpActCnt(event.getConditionVO());
			
			eventResponse.setETCData("actCnt", actCnt);
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
	 * ESM_CSQ_0205 : CREATION<br>
	 * [Sector Office Relation Set_Add Creation List]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createAddSectorOfcRelSetPfGrp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0205Event event = (EsmCsq0205Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		try {
			begin();
			command.createAddSectorOfcRelSetPfGrp(event.getSearchAddSectorOfcRelSetVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0206 : Retrieve<br>
	 * [Sector Office Relation Set_Add POL POD Pair List]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAddSectorOfcRelSetPolPod(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0206Event event = (EsmCsq0206Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try{
			List<SearchAddSectorOfcRelSetVO> list = command.searchAddSectorOfcRelSetPolPod(event.getConditionVO());
			
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
	 * ESM_CSQ_0206 : CREATION<br>
	 * [Sector Office Relation Set_Add POL POD Pair List]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createAddSectorOfcRelSetPolPod(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0206Event event = (EsmCsq0206Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try {
			begin();
			command.createAddSectorOfcRelSetPolPod(event.getSearchAddSectorOfcRelSetVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0207 : [이벤트]<br>
	 * [Basic Data Creation for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicDataCreationForSecterList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0207Event event = (EsmCsq0207Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			List<SearchBasicDataCreationForSecterListVO> list = command.searchBasicDataCreationForSecterList(event.getConditionVO());
			String dataCnt = command.searchBasicDataCreationForSecterListCnt(event.getConditionVO());
			eventResponse.setETCData("dataCnt", dataCnt);
			
//			if ( !dataCnt.isEmpty() ) {
//				String data[] = dataCnt.split("[|]");
//				
//				eventResponse.setETCData("dataCnt", data[0]);
//				eventResponse.setETCData("aplyFmYrwk", data[0].equals("0")?"":data[1]);
//				eventResponse.setETCData("aplyToYrwk", data[0].equals("0")?"":data[2]);
//			}
			
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
	 * ESM_CSQ_0208 : [이벤트]<br>
	 * [Basic Data Creation For IAS Sector]의 데이터를  [생성(IF)] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBasicDataCreationForSecter(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0208Event event = (EsmCsq0208Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			eventResponse.setETCData("BatchStatus", command.createBasicDataCreationForSecter(event.getConditionVO(), account));         
		} catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	

	/**
	 * ESM_CSQ_0209 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0209(Event e) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""}		
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
	 * ESM_CSQ_0209 : Retrieve1<br>
	 * [New Lane Sector CMCB List]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNewLaneSecCmcbList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0209Event event = (EsmCsq0209Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try{
			List<SearchNewLaneSecCmcbListVO> list = command.searchNewLaneSecCmcbList(event.getConditionVO());
			
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
	 * ESM_CSQ_0209 : Save1<br>
	 * [New Lane Sector CMCB List]을 [수정]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageNewLaneSecCmcbNewLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0209Event event = (EsmCsq0209Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try {
			begin();
			command.manageNewLaneSecCmcbNewLane(event.getSearchNewLaneSecCmcbListVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0209 : Creation<br>
	 * [New Lane Sector CMCB Pair Cost]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createNewLaneSecCmcbPairCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0209Event event = (EsmCsq0209Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try {
			begin();
			command.createNewLaneSecCmcbPairCost(event.getSearchNewLaneSecCmcbListVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0209 : Retrieve2<br>
	 * [New Lane Sector CMCB Pair Cost]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNewLaneSecCmcbPairCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0209Event event = (EsmCsq0209Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try{
			List<SearchNewLaneSecCmcbListVO> list = command.searchNewLaneSecCmcbPairCost(event.getConditionVO());
			
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
	 * ESM_CSQ_0209 : Save2<br>
	 * [New Lane Sector CMCB Pair Cost]을 [수정]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageNewLaneSecCmcbPairCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0209Event event = (EsmCsq0209Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try {
			begin();
			command.manageNewLaneSecCmcbPairCost(event.getSearchNewLaneSecCmcbListVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0210 : Retrieve<br>
	 * [Basic CMCB for IAS Sector List]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicCmcbForIasSectorList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0210Event event = (EsmCsq0210Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try{
			List<SearchNewLaneSecCmcbListVO> list = command.searchBasicCmcbForIasSectorList(event.getConditionVO());
			String dataCnt = command.searchBasicCmcbForIasSectorListCnt(event.getConditionVO());
			
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
	 * ESM_CSQ_0210 : Save<br>
	 * [Basic CMCB for IAS Sector List]을 [수정]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageBasicCmcbForIasSectorList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0210Event event = (EsmCsq0210Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try {
			begin();
			command.manageBasicCmcbForIasSectorList(event.getSearchNewLaneSecCmcbListVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0210 : Creation<br>
	 * [Basic CMCB for IAS Sector ]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createBasicCmcbForIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0210Event event = (EsmCsq0210Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.createBasicCmcbForIasSector(event.getConditionVO(), account.getUsr_id()));
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0211 : Retrieve<br>
	 * [Basic CMCB for IAS Sector_New Lane Cost IF]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicCmcbForIasSecNewLaneIf(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0211Event event = (EsmCsq0211Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try{
			List<SearchNewLaneSecCmcbListVO> list = command.searchBasicCmcbForIasSecNewLaneIf(event.getConditionVO());
			
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
	 * ESM_CSQ_0211 : New Lane Cost Apply<br>
	 * [Basic CMCB for IAS Sector_New Lane Cost IF]을 [Apply]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse addBasicCmcbForIasSecNewLaneIf(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0211Event event = (EsmCsq0211Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try {
			begin();
			command.addBasicCmcbForIasSecNewLaneIf(event.getSearchNewLaneSecCmcbListVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0212 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0212(Event e) throws EventException { 
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
					/* 4. Bound. */
					{"comCodeBound", "", ""}
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
	 * ESM_CSQ_0212 : Retrieve<br>
	 * [Basic CMCB_COA UC PFMC]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicCmcbCoaUcPfmc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0212Event event = (EsmCsq0212Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try{
			List<SearchBasicCmcbCoaUcPfmcVO> list = command.searchBasicCmcbCoaUcPfmc(event.getConditionVO());
			
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
}