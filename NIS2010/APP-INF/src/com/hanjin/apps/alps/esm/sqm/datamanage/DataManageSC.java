/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : DataManageSC.java
*@FileTitle      : DataManage
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.03 SQM USER
* 1.0 Creation
* 2014.01.16 PEJ   [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
* 2014.09.23 이혜민 [CHM-201431753] Sector-Office Relation Setting 화면 내 Raw Data Export 버튼 생성건 
* 2014.09.30 이혜민 [] Sector-Office Relation Setting for IAS Sector Creation시 전분기 act_flg를 넣어주는 부분에서 time out이 나므로 backendjob 실행 후 update하는 것으로 수정
* 2015.05.12 김용습 [CHM-201535562] [SQM] Sector-Office Relation Setting for IAS Sector - 타임아웃 방지를 위해 데이터를 반으로 나누어 생성되게 함 
* 2015.12.02 김용습 [CHM-201539212] 연간/분기동안 확정 Data에 한번 들어간 Sector Pair는 active 해제할 수 없도록 로직 수정
* 2015.12.07 김용습 [CHM-201539014] Baisc Data Relation Setting IAS Trade 추가 로직 수정
* 2016.01.13 [CHM-201539389] Lane Office Inactive 불가하도록 비활성화 로직 변경
* 2016.05.11 Sector Office Relation Setting for IAS Sector 화면 및 P/F Skd Group 화면 로직 수정 요청
-P/F Skd Group Management for IAS Sector : Target VVD Fix 에서 대상항차 Fix 할 때부터 P/F Group 도 Planning에서 Freezing 될 때까지는 Add Creation 불가하도록 로직 수정 (Target VVD Fix ~ Planning의 Freezing동안)
* 2016.07.04 최성민 [CHM-201642330] SQM 화면 버튼 추가 요청
* 2016.08.11 Basic CMCB (CM Cost Per Box) 화면 Add Creation 버튼 추가
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage;

import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.sqm.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.sqm.common.vo.CommonVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.basic.BasicDataBC;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.basic.BasicDataBCImpl;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event.EsmSqm0001Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event.EsmSqm0002Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event.EsmSqm0003Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event.EsmSqm0004Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event.EsmSqm0005Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event.EsmSqm0006Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event.EsmSqm0038Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event.EsmSqm0201Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event.EsmSqm0202Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event.EsmSqm0203Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event.EsmSqm0207Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event.EsmSqm0208Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration.BasicDataDBDAO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchAddPolPodPairForSectorVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchBasicDataCreationForSecterListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchBasicDataCreationListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchBasicDataRelationListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchLaneDirectionChangeListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchPfSkdGrpForSectorListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchPolPodPairSectorListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchTargerVvdFixListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.basic.CostManageBC;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.basic.CostManageBCImpl;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.event.EsmSqm0010Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.event.EsmSqm0011Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.event.EsmSqm0012Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.event.EsmSqm0013Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.event.EsmSqm0039Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.event.EsmSqm0111Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.event.EsmSqm0209Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.event.EsmSqm0210Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.event.EsmSqm0211Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.event.EsmSqm0212Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchAddedNewLaneListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchBasicCmcbListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchBasicCmcbMasPfmcListListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchBasicCmcbMasUcPfmcVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchNewLaneOfficeCmcbListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchNewLaneSecCmcbListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.basic.OfficeMappingBC;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.basic.OfficeMappingBCImpl;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.event.EsmSqm0007Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.event.EsmSqm0008Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.event.EsmSqm0009Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.event.EsmSqm0204Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.event.EsmSqm0205Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.event.EsmSqm0206Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.vo.SearchAddSectorOfcRelSetVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.vo.SearchLaneOfficeRelationListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.vo.SearchLaneOfficeRelationNewLaneAddListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.vo.SearchSectorOfcRelationSetListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmQtaLaneMgmtVO;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcCostVO;
import com.hanjin.syscommon.common.table.SqmQtaOfcVO;

/**
 * ALPS-DataManage Business Logic ServiceCommand - ALPS-DataManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author SQM USER
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
		if (e.getEventName().equalsIgnoreCase("EsmSqm0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicDataRelationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBasicDataRelation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = copyBasicDataRelation(e);
 			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0001(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmSqm0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneDirectionChangeList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) { 
				eventResponse = searchComBoCdList0002(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) { 
				eventResponse = manageLaneDirectionChange(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) { 
				eventResponse = copyLaneDirectionChange(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSqm0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicDataCreationList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0003(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("EsmSqm0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createSqmPerfIf(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0004(e);
			}	
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTargerVvdFixList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0005(e);
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
		}  else if (e.getEventName().equalsIgnoreCase("EsmSqm0006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneList(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EsmSqm0007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRhqOfcMappingList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0007(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) { 
				eventResponse = manageRhqOfcMapping(e); 
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSqm0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneOfficeRelationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageLaneOfficeRelation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createLaneOfficeRelation(e);
 			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0008(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchConfirmedDataOfLaneOffice(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchLoadingViewCheckList(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EsmSqm0009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneOfficeRelationNewLaneAddList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0009(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAddedNewLaneList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0010(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) { 
				eventResponse = manageAddedNewLane(e); 
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createNewLaneOfficeCmcb(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchNewLaneOfficeCmcbList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageNewLaneOfficeCmcb(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicCmcbList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBasicCmcb(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createBasicCmcb(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0011(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0111Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0111(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasiCmcbBatchStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createAddBasicCmcb(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicCmcbNewLaneCostIfList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBasicCmcbNewLaneCostIf(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicCmcbMasPfmcList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0013(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0038Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneMasterList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0038(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageLaneMaster(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0039Event")) {
			if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0039(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = createRelatedData(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0201Event")) {
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
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = searchValidationAddPfSkdGrpForSector(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0202Event")) {
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
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0203Event")) {
			if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0203(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAddPolPodPairForSector(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createAddPolPodPairForSector(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0204Event")) {
			if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0204(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSectorOfcRelationSetList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBackEndJobVO(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSectorOfcRelationSetNActList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchConfirmedDataOfPair(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSectorOfcRelationSet(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createSectorOfcRelationSet(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = excelDownSectorOfficeRelationSet(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0205Event")) {
			if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0205(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAddSectorOfcRelSetPfGrp(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createAddSectorOfcRelSetPfGrp(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0206Event")) {
			if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0206(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAddSectorOfcRelSetPolPod(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createAddSectorOfcRelSetPolPod(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0207Event")) {
			if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0207(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicDataCreationForSecterList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0208Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) { 
				eventResponse = createBasicDataCreationForSecter(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0209Event")) {
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
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0210Event")) {
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
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0211Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicCmcbForIasSecNewLaneIf(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = addBasicCmcbForIasSecNewLaneIf(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0212Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0212(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicCmcbMasUcPfmc(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicDataRelationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0001Event event = (EsmSqm0001Event)e;
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
	 *  ESM_SQM_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [복사]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse copyBasicDataRelation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0001Event event = (EsmSqm0001Event)e;
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
	 * ESM_SQM_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [저장]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBasicDataRelation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0001Event event = (EsmSqm0001Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			begin();
			command.manageBasicDataRelation(event.getSqmDatRltVOS(), event.getConditionVO(), account);
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
	 * ESM_SQM_0001 : 공통코드 조회 이벤트 처리<br>
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
//					{"trade", "", ""},
					{"mdmTrade", "", "All"},
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
	 * ESM_SQM_0002 : 공통코드 조회 이벤트 처리<br>
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
					/* 1. Year. */
					{"year", "", ""},
					/* 2. Quarter. */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""},
					/* 4. Trade. */
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
	 * ESM_SQM_0003 : [이벤트]<br>
	 * [Basic Data Creation]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicDataCreationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0003Event event = (EsmSqm0003Event)e;
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
	 * ESM_SQM_0003 : 공통코드 조회 이벤트 처리<br>
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
					/* 4. Office View. */
					{"officeView", "", ""},
					/* 6. Bound. */
					{"comCodeBound", "", "All"},
					/* 7. Office Level. */
					{"comCodeOfficLevel", "", ""},
					/* 8. RHQ. */
					{"rhq", "", "All"}
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
	 * ESM_SQM_0004 : 공통코드 조회 이벤트 처리<br>
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
	 * ESM_SQM_0005 : 공통코드 조회 이벤트 처리<br>
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
					{"nextQta", "", ""},
					/* 4. Trade */
					{"mdmTrade", "", "All"},
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
	 * ESM_SQM_0007 : 공통코드 조회 이벤트 처리<br>
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
	 * ESM_SQM_0008 : 공통코드 조회 이벤트 처리<br>
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
					/* 6. Sub Trade. */
					{"subTrade", "", "All"},
					/* 7. Bound. */
					{"comCodeBound", "", "All"},
					/* 8. RHQ. */
					{"rhq", "", "All"}
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
	 * ESM_SQM_0009 : 공통코드 조회 이벤트 처리<br>
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
					/* 1. Trade */
					{"mdmTrade", "", "All"},
					/* 2. Sub Trade. */
					{"subTrade", "", "All"},
					/* 3. Bound. */
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
	 * ESM_SQM_0010 : 공통코드 조회 이벤트 처리<br>
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
	 * ESM_SQM_0011 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0011(Event e) throws EventException {
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
					{"rhq", "", "All"}
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
	 * ESM_SQM_0111 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0111(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		EsmSqm0111Event event = (EsmSqm0111Event)e;
		
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
					{"rhq", "", "All"},
					/* 7. Trade. */
					{"trade", event.getConditionVO().getFBseYr()+event.getConditionVO().getFBseQtrCd(), "All"},
					/* 8. Rlane. */
					{"rLane", event.getConditionVO().getFTrdCd(), "All"},
					/* 9. Office. */
					{"office", event.getConditionVO().getFRhqCd(), "All"}
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
	 * ESM_SQM_0013 : 공통코드 조회 이벤트 처리<br>
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
					/* 5. RHQ. */
					{"rhq", "", "All"},
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
	 * ESM_SQM_0038 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0038(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Trade */
					{"mdmTrade", "", ""},
					/* 2. Bound. */
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
	 * ESM_SQM_0002 : Retrieve 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLaneDirectionChangeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0002Event event = (EsmSqm0002Event)e;
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
	 * ESM_SQM_0002 : Save 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageLaneDirectionChange(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0002Event event = (EsmSqm0002Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			begin();
			command.manageLaneDirectionChange(event.getSqmDirConvVOS(), event.getConditionVO(), account);
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
	 * ESM_SQM_0002 : Copy 이벤트 처리<br>
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse copyLaneDirectionChange(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0002Event event = (EsmSqm0002Event)e;
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
	 * ESM_SQM_0007 : Retrieve 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRhqOfcMappingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0007Event event = (EsmSqm0007Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try {
			List<SqmQtaOfcVO> list = command.searchRhqOfcMappingList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0005 : Retrieve 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTargerVvdFixList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0005Event event = (EsmSqm0005Event)e;
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
	 * ESM_SQM_0005 : Creation 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createTargerVvdFix(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0005Event event = (EsmSqm0005Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			begin();
			command.createTargerVvdFix(event.getConditionVO(),event.getVbpIfFlg(),account.getUsr_id());
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
	 * ESM_SQM_0006 : Retrieve 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0006Event event = (EsmSqm0006Event)e;
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
	 * ESM_SQM_0005 : Save 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageTargerVvdFix(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0005Event event = (EsmSqm0005Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			begin();
			command.manageTargerVvdFix(event.getSqmQtaTgtVvdVOS(), event.getConditionVO() ,account);
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
	 * ESM_SQM_0004 : [이벤트]<br>
	 * [SQM PERF IF]을 [생성] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createSqmPerfIf(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0004Event event = (EsmSqm0004Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			eventResponse.setETCData("BatchStatus", command.createSqmPerfIf(event.getConditionVO(), account));         
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
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLoadingViewCheckList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0008Event event = (EsmSqm0008Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try{
			List<SearchLaneOfficeRelationListVO> list = command.searchLoadingViewCheckList(event.getConditionVO());
			
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
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneOfficeRelationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0008Event event = (EsmSqm0008Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try{
			List<SearchLaneOfficeRelationListVO> list = command.searchLaneOfficeRelationList(event.getConditionVO());
			String dataCnt = command.searchLaneOfficeRelationListCnt(event.getConditionVO());
			String freezingYn = command.searchQtaReleaseVersion(event.getConditionVO());

			eventResponse.setETCData("CFM_FLG", freezingYn);
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
	 * ESM_SQM_0007 : Save 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageRhqOfcMapping(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0007Event event = (EsmSqm0007Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try{
			begin();
			command.manageRhqOfcMapping(event.getSqmQtaOfcVOS(),account);
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
	 * ESM_SQM_0039 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0039(Event e) throws EventException {
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
	 * ESM_SQM_0010 : [New Lane & Office CMCB] 을 [조회] 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddedNewLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0010Event event = (EsmSqm0010Event)e;
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
	 * ESM_SQM_0010 : MULTI 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageAddedNewLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0010Event event = (EsmSqm0010Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try{
			begin();
			command.manageAddedNewLane(event.getSqmQtaNewLaneVOS(),event.getConditionVO(),account);
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
	 * ESM_SQM_0010 : MULTI01 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createNewLaneOfficeCmcb(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0010Event event = (EsmSqm0010Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try {
			begin();
			String msg = command.createNewLaneOfficeCmcb(event.getSqmQtaNewLaneVOS(),event.getConditionVO(), account.getUsr_id());			
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
	 * ESM_SQM_0010 : SEARCHLIST 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchNewLaneOfficeCmcbList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0010Event event = (EsmSqm0010Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try {
			List<SearchNewLaneOfficeCmcbListVO> list = command.searchNewLaneOfficeCmcbList(event.getConditionVO(), event.getSqmQtaNewLaneVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0010 : MULTI02 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageNewLaneOfficeCmcb(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0010Event event = (EsmSqm0010Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try{
			begin();
			command.manageNewLaneOfficeCmcb(event.getSqmQtaNewLaneOfcCostVOS(),account);
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
	 * ESM_SQM_0039 : COMMAND01 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createRelatedData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0039Event event = (EsmSqm0039Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try {
			begin();
			command.createRelatedData(event.getSqmQtaLaneOfcVOS(),event.getConditionVO(), account.getUsr_id());
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
	 * ESM_SQM_0038 : Retrieve 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLaneMasterList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0038Event event = (EsmSqm0038Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			List<SqmQtaLaneMgmtVO> list = command.searchLaneMasterList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0038 : MULTI 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageLaneMaster(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0038Event event = (EsmSqm0038Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			begin();
			command.manageLaneMaster(event.getSqmQtaLaneMgmtVOS(), account);
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
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [저장]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageLaneOfficeRelation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0008Event event = (EsmSqm0008Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try{
			begin();
			command.manageLaneOfficeRelation(event.getSqmQtaLaneOfcVOS(), event.getConditionVO(), account);
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
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createLaneOfficeRelation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0008Event event = (EsmSqm0008Event)e;
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
	 * ESM_SQM_0009 : [이벤트]<br>
	 * [RHQ-Office Mapping Data]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneOfficeRelationNewLaneAddList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0009Event event = (EsmSqm0009Event)e;
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
	 * ESM_SQM_0011 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicCmcbList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0011Event event = (EsmSqm0011Event)e;
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
	 * ESM_SQM_0011 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createBasicCmcb(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0011Event event = (EsmSqm0011Event)e;
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
	 * ESM_SQM_0011 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [수정]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageBasicCmcb(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0011Event event = (EsmSqm0011Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try {
			begin();
			command.manageBasicCmcb(event.getSqmQtaLaneOfcCostVOS(), event.getConditionVO(), account);
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
	 * ESM_SQM_0111 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createAddBasicCmcb(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0111Event event = (EsmSqm0111Event)e;
		CostManageBC command = new CostManageBCImpl();
		CommonBC commonBC = new CommonBCImpl();
		
		try {
			String batStatus = "";
			//1. 배치가 돌고 있는지 Check 한다
			CommonVO commonVO = event.getCommonVO();
			commonVO.setFBatId("ESM_SQM_B007");
			batStatus = commonBC.searchBatchStatus(commonVO);
				
			//2. 만약 Running 상태이면 해당 상태를 알리고 더 이상 진행하지 않는다. 
			if("R".equals(batStatus)){
				eventResponse.setETCData("BatchStatus", batStatus);
				return eventResponse;
			}

			/*
			ScheduleUtil su = new ScheduleUtil();
			if(su.isRunning(conditionVO.getFBatId())) {
				eventResponse.setETCData("BatchStatus", "R");
				return eventResponse;
			}
			*/
			

			//3. Batch Status 저장
			begin();
			commonVO.setFBatStsCd("R"); //RUNNING
			commonBC.addBatchStatus(commonVO, account);		
			commit();
			
			// 4. batch를 실행한다.
			CommonVO vo = command.createAddBasicCmcb(event.getConditionVO(), account);
			eventResponse.setETCData("BatchStatus", vo.getFBatStsCd()); 

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
	 * ESM_SQM_0111 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [조회]합니다.<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasiCmcbBatchStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		EsmSqm0111Event event = (EsmSqm0111Event)e;
		
		try {
			String batchStatus = "";
			//1. 배치가 돌고 있는지 Check 한다
			CommonVO commonVO = event.getCommonVO();
			commonVO.setFBatId("ESM_SQM_B007");
			batchStatus = commonBC.searchBatchStatus(commonVO);
			eventResponse.setETCData("BatchStatus", batchStatus); 
			
			/*
			ScheduleUtil su = new ScheduleUtil();
			if(su.isRunning(event.getConditionVO().getFBatId())) {
				eventResponse.setETCData("BatchStatus", "R");
			} else {
				eventResponse.setETCData("BatchStatus", "F");
			}
			*/
			
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_SQM_0012 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicCmcbNewLaneCostIfList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0012Event event = (EsmSqm0012Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try{
			List<SqmQtaLaneOfcCostVO> list = command.searchBasicCmcbNewLaneCostIfList(event.getConditionVO());
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
	 * ESM_SQM_0012 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageBasicCmcbNewLaneCostIf(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0012Event event = (EsmSqm0012Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try {
			begin();
			command.manageBasicCmcbNewLaneCostIf(event.getSqmQtaLaneOfcCostVOS(), event.getConditionVO(), account);
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
	 * ESM_SQM_0013 : [이벤트]<br>
	 * [Basic CMCB_MAS UC PFMC Retrieve)]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicCmcbMasPfmcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0013Event event = (EsmSqm0013Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try{
			List<SearchBasicCmcbMasPfmcListListVO> list = command.searchBasicCmcbMasPfmcList(event.getConditionVO());
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
	 * ESM_SQM_0005 : SEARCH02 이벤트 처리<br>
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTargerVvdFixListCnt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0005Event event = (EsmSqm0005Event)e;
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
	 * ESM_SQM_0005 : default 이벤트 처리<br>
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
	 * ESM_SQM_0005 : SEARCH01 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTargerVvdFixForCreation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0005Event event = (EsmSqm0005Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			List<SearchTargerVvdFixListVO> list = command.searchTargerVvdFixForCreation(event.getConditionVO(),event.getVbpIfFlg());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0201 : 공통코드 조회 이벤트 처리<br>
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
					{"nextQta", "", ""},
					/* 4. sub Trade. */
					{"subTradeSector", "", "All"},
					/* 5. IAS Region */
					{"iasRegion", "", "All"}
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
	 * ESM_SQM_0202 : 공통코드 조회 이벤트 처리<br>
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
					/* 4. sub Trade. */
					{"subTradeSector", "", "All"},
					/* 5. IAS Region */
					{"iasRegion", "", "All"},
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
	 * ESM_SQM_0203 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0203(Event e) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. sub Trade. */
					{"subTradeSector", "", ""},
					/* 2. IAS Region */
					{"iasRegion", "", "All"}
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
	 * ESM_SQM_0204 : 공통코드 조회 이벤트 처리<br>
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
					/* 4. sub Trade. */
					{"subTradeSector", "", ""},
					/* 5. IAS Region */
					{"iasRegion", "", "All"},
					/* 6. Bound. */
					{"comCodeBound", "", ""},
					/* 7. Office View */
					{"officeView", "", ""},
					/* 8. RHQ. */
					{"rhq", "", "All"}
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
	 * ESM_SQM_0205 : 공통코드 조회 이벤트 처리<br>
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
					/* 1. sub Trade. */
					{"subTradeSector", "", ""},
					/* 2. IAS Region */
					{"iasRegion", "", "All"},
					/* 3. Bound. */
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
	 * ESM_SQM_0206 : 공통코드 조회 이벤트 처리<br>
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
					/* 1. sub Trade. */
					{"subTradeSector", "", ""},
					/* 2. IAS Region */
					{"iasRegion", "", "All"},
					/* 3. Bound. */
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
	 * ESM_SQM_0207 : 공통코드 조회 이벤트 처리<br>
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
					/* 4. sub Trade. */
					{"subTradeSector", "", "All"},
					/* 5. IAS Region */
					{"iasRegion", "", "All"},
					/* 6. Bound. */
					{"comCodeBound", "", "All"},
					/* 7. Office View */
					{"officeView", "", ""},
					/* 8. RHQ. */
					{"rhq", "", "All"}
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
	 * ESM_SQM_0210 : 공통코드 조회 이벤트 처리<br>
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
					/* 4. sub Trade. */
					{"subTradeSector", "", ""},
					/* 5. IAS Region */
					{"iasRegion", "", "All"},
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
	 * ESM_SQM_0201 : Retrieve<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPfSkdGrpForSectorList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0201Event event = (EsmSqm0201Event)e;
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
	 * ESM_SQM_0201 : Add Creation<br>
	 * Add Creation시 유효성 검사<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchValidationAddPfSkdGrpForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0201Event event = (EsmSqm0201Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
//			List<SearchPfSkdGrpForSectorListVO> list = command.searchPfSkdGrpForSectorList(event.getConditionVO());
			String dataCnt = command.searchValidationAddPfSkdGrpForSector(event.getConditionVO());
			
			eventResponse.setETCData("dataCnt", dataCnt);
//			eventResponse.setRsVoList(list);
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
	 * ESM_SQM_0201 : Creation<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createPfSkdGrpForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0201Event event = (EsmSqm0201Event)e;
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
	 * ESM_SQM_0201 : Add-Creation<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [추가 생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createAddPfSkdGrpForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0201Event event = (EsmSqm0201Event)e;
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
	 * ESM_SQM_0202 : Retrieve<br>
	 * [POL POD Pair for IAS Sector List Tab1]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPolPodPairSectorList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0202Event event = (EsmSqm0202Event)e;
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
	 * ESM_SQM_0202 : Retrieve<br>
	 * [POL POD Pair for IAS Sector List Tab2]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPolPodPairSectorListT2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0202Event event = (EsmSqm0202Event)e;
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
	 * ESM_SQM_0202 : Creation 또는 Retrieve 후<br>
	 * [POL POD Pair for IAS Sector List 중 Main Flag가 하나도 없는 Lane, Bound]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPolPodPairNMainFlgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0202Event event = (EsmSqm0202Event)e;
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
	 * ESM_SQM_0202 : Creation<br>
	 * [POL POD Pair for IAS Sector List]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createPolPodPairForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0202Event event = (EsmSqm0202Event)e;
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
	 * ESM_SQM_0202 : SAVE<br>
	 * [POL POD Pair for IAS Sector List]을 [수정]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse managePolPodPairForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0202Event event = (EsmSqm0202Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try {
			begin();
			command.managePolPodPairForSector(event.getSqmSctrPairMgmtVOS(), event.getConditionVO(), account);
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
	 * ESM_SQM_0203 : Retrieve<br>
	 * [POL POD Pair for IAS Sector Add List]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAddPolPodPairForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0203Event event = (EsmSqm0203Event)e;
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
	 * ESM_SQM_0203 : CREATION<br>
	 * [POL POD Pair for IAS Sector Add List]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createAddPolPodPairForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0203Event event = (EsmSqm0203Event)e;
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
	 * ESM_SQM_0204 : Retrieve<br>
	 * [Sector Office Relation Setting]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSectorOfcRelationSetList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0204Event event = (EsmSqm0204Event)e;
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
	 * ESM_SQM_0204<br>
	 * Active cell을 uncheck하려고 할 때 타는 로직(이미 해당 pair로 확정 데이터가 생성된 것이 있으면 uncheck될 수 없도록 함)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
		private EventResponse searchConfirmedDataOfPair(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmSqm0204Event event = (EsmSqm0204Event)e;
			OfficeMappingBC command = new OfficeMappingBCImpl();
			
			try{
				String dataCnt = command.searchConfirmedDataOfPair(event.getSqmSctrLaneOfcVO(), event.getConditionVO());
				
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
	 * ESM_SQM_0008<br>
	 * Active cell을 uncheck하려고 할 때 타는 로직(이미 해당 pair로 확정 데이터가 생성된 것이 있으면 uncheck될 수 없도록 함)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
		private EventResponse searchConfirmedDataOfLaneOffice(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmSqm0008Event event = (EsmSqm0008Event)e;
			OfficeMappingBC command = new OfficeMappingBCImpl();
			
			try{
				String dataCnt = command.searchConfirmedDataOfLaneOffice(event.getSqmQtaLaneOfcVO(), event.getConditionVO());
				
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
	 * ESM_SQM_0204 : Creation<br>
	 * [Sector Office Relation Setting]을 [생성]합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createSectorOfcRelationSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0204Event event = (EsmSqm0204Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		try {
			eventResponse.setETCData("BatchStatus", command.createSectorOfcRelationSet(event.getConditionVO(), account)); 
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
	 * ESM_SQM_0204 : Creation<br>
	 * [Sector Office Relation Setting_Act_flag가 하나도 없는 Lane List]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSectorOfcRelationSetNActList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0204Event event = (EsmSqm0204Event)e;
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
	 * ESM_SQM_0204 : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse excelDownSectorOfficeRelationSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0204Event event = (EsmSqm0204Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try {
			List<SearchSectorOfcRelationSetListVO> list = command.searchSectorOfcRelationSetList(event.getConditionVO());
			
			if(list.size() > 0 && list != null){
				String headTitle    = "Year￠Quarter￠Office View￠Trade￠Sub Trade￠IAS Region￠R.Lane￠Lane Bound￠RHQ￠Office￠POL￠POD￠Active￠Main";
				String column_names = "bse_yr￠bse_qtr_cd￠ofc_vw_cd￠trd_cd￠sub_trd_cd￠ias_rgn_cd￠rlane_cd￠dir_cd￠rhq_cd￠rgn_ofc_cd￠pol_cd￠pod_cd￠sqm_act_flg￠sqm_mn_sctr_flg"; 
				
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
	 * ESM_SQM_0204 : SAVE<br>
	 * [Sector Office Relation Setting]을 [수정]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSectorOfcRelationSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0204Event event = (EsmSqm0204Event)e;
		OfficeMappingBC command = new OfficeMappingBCImpl();
		
		try {
			begin();
			command.manageSectorOfcRelationSet(event.getSqmSctrLaneOfcVOS(), event.getConditionVO(), account);
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
	 * ESM_SQM_0205 : Retrieve<br>
	 * [Sector Office Relation Set_Add Creation List]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAddSectorOfcRelSetPfGrp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0205Event event = (EsmSqm0205Event)e;
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
	 * ESM_SQM_0205 : CREATION<br>
	 * [Sector Office Relation Set_Add Creation List]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createAddSectorOfcRelSetPfGrp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0205Event event = (EsmSqm0205Event)e;
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
	 * ESM_SQM_0206 : Retrieve<br>
	 * [Sector Office Relation Set_Add POL POD Pair List]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAddSectorOfcRelSetPolPod(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0206Event event = (EsmSqm0206Event)e;
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
	 * ESM_SQM_0206 : CREATION<br>
	 * [Sector Office Relation Set_Add POL POD Pair List]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createAddSectorOfcRelSetPolPod(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0206Event event = (EsmSqm0206Event)e;
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
	 * ESM_SQM_0207 : [이벤트]<br>
	 * [Basic Data Creation for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicDataCreationForSecterList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0207Event event = (EsmSqm0207Event)e;
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
	 * ESM_SQM_0208 : [이벤트]<br>
	 * [Basic Data Creation For IAS Sector]의 데이터를  [생성(IF)] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBasicDataCreationForSecter(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0208Event event = (EsmSqm0208Event)e;
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
	 * ESM_SQM_0209 : 공통코드 조회 이벤트 처리<br>
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
	 * ESM_SQM_0209 : Retrieve1<br>
	 * [New Lane Sector CMCB List]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNewLaneSecCmcbList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0209Event event = (EsmSqm0209Event)e;
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
	 * ESM_SQM_0209 : Save1<br>
	 * [New Lane Sector CMCB List]을 [수정]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageNewLaneSecCmcbNewLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0209Event event = (EsmSqm0209Event)e;
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
	 * ESM_SQM_0209 : Creation<br>
	 * [New Lane Sector CMCB Pair Cost]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createNewLaneSecCmcbPairCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0209Event event = (EsmSqm0209Event)e;
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
	 * ESM_SQM_0209 : Retrieve2<br>
	 * [New Lane Sector CMCB Pair Cost]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNewLaneSecCmcbPairCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0209Event event = (EsmSqm0209Event)e;
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
	 * ESM_SQM_0209 : Save2<br>
	 * [New Lane Sector CMCB Pair Cost]을 [수정]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageNewLaneSecCmcbPairCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0209Event event = (EsmSqm0209Event)e;
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
	 * ESM_SQM_0210 : Retrieve<br>
	 * [Basic CMCB for IAS Sector List]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicCmcbForIasSectorList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0210Event event = (EsmSqm0210Event)e;
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
	 * ESM_SQM_0210 : Save<br>
	 * [Basic CMCB for IAS Sector List]을 [수정]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageBasicCmcbForIasSectorList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0210Event event = (EsmSqm0210Event)e;
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
	 * ESM_SQM_0210 : Creation<br>
	 * [Basic CMCB for IAS Sector ]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createBasicCmcbForIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0210Event event = (EsmSqm0210Event)e;
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
	 * ESM_SQM_0211 : Retrieve<br>
	 * [Basic CMCB for IAS Sector_New Lane Cost IF]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicCmcbForIasSecNewLaneIf(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0211Event event = (EsmSqm0211Event)e;
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
	 * ESM_SQM_0211 : New Lane Cost Apply<br>
	 * [Basic CMCB for IAS Sector_New Lane Cost IF]을 [Apply]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse addBasicCmcbForIasSecNewLaneIf(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0211Event event = (EsmSqm0211Event)e;
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
	 * ESM_SQM_0212 : 공통코드 조회 이벤트 처리<br>
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
					/* 4. sub Trade. */
					{"subTradeSector", "", ""},
					/* 5. IAS Region */
					{"iasRegion", "", "All"},
					/* 6. Bound. */
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
	 * ESM_SQM_0212 : Retrieve<br>
	 * [Basic CMCB_MAS UC PFMC]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicCmcbMasUcPfmc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0212Event event = (EsmSqm0212Event)e;
		CostManageBC command = new CostManageBCImpl();
		
		try{
			List<SearchBasicCmcbMasUcPfmcVO> list = command.searchBasicCmcbMasUcPfmc(event.getConditionVO());
			
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