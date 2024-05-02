/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NetworkLinkManageSC.java
 *@FileTitle : HubLocation 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-08-30
 *@LastModifier : jungsunyong
 *@LastVersion : 1.0 
 * 2006-08-30 jungsunyong
 * 1.0 최초 생성
 * N200902100240 2009-02-27 Terminal Matrix Exception UI 추가 개발 (ESD_PRD_041)
 * 2011.06.16 변종건 [CHM-201111584-01] [PRD] Inland Route Management상의 입력국가 추가 요청.
 * 2011.09.19 변종건 [CHM-201113069-01] Ocean Route Management상의 Auto & Multi Creation 화면 관련 변경사항
 * 2011.12.06 변종건 [CHM-201114917-01] Ocean Route Upload Excel 신규 기능 추가건
 * 2011.12.06 변종건 [CHM-201114917-01] Ocean Route Upload Excel 신규 기능 추가건
 * 2012.05.31 박만건 [CHM-201217633] 구주 Hinterland
 * 2012.06.07 이준근 [CHM-201217814-01] Constraint Management 입력 Data Validation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.common.prdcommon.basic.PrdCommonManageBC;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.basic.PrdCommonManageBCImpl;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ValidationVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.basic.ConstraintManageBC;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.basic.ConstraintManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.event.EsdPrd0024Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.event.EsdPrd0025Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.CheckCommodityVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.ConstraintVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchListCnstExptVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchRouteConstraintVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.hublocationmatchingmanage.basic.HubLocationMatchingManageBC;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.hublocationmatchingmanage.basic.HubLocationMatchingManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.hublocationmatchingmanage.event.EsdPrd0004Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.hublocationmatchingmanage.vo.SearchHubLocationListVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.basic.InlandLinkManageBC;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.basic.InlandLinkManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.event.EsdPrd0007Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.event.EsdPrd0009Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.vo.PrdInlndEachLnkVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.vo.SearchInlandLinkManageListVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandmulticreation.basic.InlandMultiCreationBCImpl;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandmulticreation.event.EsdPrd0054Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandmulticreation.vo.SearchInlandRouteVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.basic.PodManageBC;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.basic.PodManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.event.EsdPrd0085Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.vo.PrdImdgClssCdVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.vo.SearchPodListVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.basic.InlandRouteManageBC;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.basic.InlandRouteManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.event.EsdPrd0005Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.event.EsdPrd0006Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.event.EsdPrd0056Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.GetReferenceNoVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteMsUSVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteSelCreVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchEmptyMasterVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchInlandRouteManageVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchEmptyInlandRouteMasterListVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchInlandRouteManageAsiaEuVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.basic.OceanLinkManageBC;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.basic.OceanLinkManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.event.EsdPrd0012Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.event.EsdPrd0013Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo.SearchOceanLinkRHQVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo.SearchOceanLinkVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.basic.OceanRouteConditionManageBC;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.basic.OceanRouteConditionManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.event.EsdPrd0010Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.event.EsdPrd0011Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.event.EsdPrd0041Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchCallingTmlMtxExptVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchEmbargoVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchOceanRouteConditionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.basic.OceanRouteManageBC;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.basic.OceanRouteManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0014Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0016Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0032Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0033Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0035Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0040Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0060Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0086Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.RowSearchOceanRouteManageVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SaveOceanRouteVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchLaneConnectionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanLaneVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteAutoCreationVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteListVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteMultiCreationVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteSingleCreationVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteStatusVO;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComBakEndJbVO;

/**
 * alps-PRD Business Logic ServiceCommand<br>
 * - alps-PRD에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author jungsunyong
 * @see ESD_PRD_004EventResponse,HubLocationMatchingManageDBDAO 참조
 * @since J2EE 1.4
 */
public class NetworkLinkManageSC extends ServiceCommandSupport {
	// Login User Information

	private SignOnUserAccount account = null;

	/**
	 * PRD 업무 시나리오 선행작업<br>
	 * HubLocationMatchingManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	@Override
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
			if (account.getUsr_id() == null) {
				throw new RuntimeException();
			}
		} catch (Exception e) {
			log.error("NetworkLinkManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * PRD 업무 시나리오 마감작업<br>
	 * HubLocationMatchingManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	@Override
	public void doEnd() {
		// command.doEnd();
		log.debug("NetworkLinkManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * alps-PRD 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;		

		log.debug("\n[CALL] Service Command ----------------------------- "
				+ "\n EventName   : " + e.getEventName() + "\n Program No.  : "
				+ ((String) e.getAttribute("pgmNo")) + "\n Command     : "
				+ e.getFormCommand().getCommand());

		String retCrud = "";
		String usr_id = "";
		if (account != null) {
			usr_id = account.getUsr_id();
		}

		PrdCommonManageBC prdComm = new PrdCommonManageBCImpl();
		retCrud = prdComm.getPrdPgmRole(((String) e.getAttribute("pgmNo")),
				usr_id);
		log.debug("\n\n retCrud:[" + retCrud + "] null con->["
				+ (retCrud.equals("") ? "R" : retCrud) + "]");
		e.setAttribute("crud", retCrud.equals("") ? "R" : retCrud);

		DBRowSet dRs = null;
		dRs = prdComm.getRowSetPrdPgmRole(((String) e.getAttribute("pgmNo")),
				usr_id);
		log.debug("\n\n retCrud:[" + retCrud + "] null con->["
				+ (retCrud.equals("") ? "R" : retCrud) + "]");
		String ocnRole = "";
		try {
			if (dRs.next()) {
				ocnRole = dRs.getString("ADD_PCTL_PGM_ROLE_CD");
			}
		} catch (SQLException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("\n\n ocnRole:" + ocnRole);
		e.setAttribute("ocnFlg", retCrud.equals("") ? "" : ocnRole);

		/*
		 * HubLocation Matching Manage ★ kim kwi-jin 2009/07/29 수정
		 */
		if (e.getEventName().equalsIgnoreCase("EsdPRD0004Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchHubLocationMatchingManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiHubLocationMatchingManage(e);
			}

			/*
			 * Inland Route Manage ★ kim kwi-jin 2009/07/29 수정
			 */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // mst
																		// 조회
				eventResponse = this.searchInlandRouteManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // mst
																			// 저장
				eventResponse = this.multiInlandRouteManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // detail
																			// 조회
																			// ★
																			// 2009/07/31
																			// kim
																			// kwi-jin수정
				eventResponse = this.searchInlandRouteManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) { // ★2009-08-26
				eventResponse = this.rowSearchInlandRouteManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // 사용유무
																				// 확인요망
				eventResponse = this.searchPrioSeq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // Country 조회				
				eventResponse = this.searchCntOfContiUSA(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // DETAIL
																			// SAVE.
				eventResponse = this.multi01InlandRouteManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // save
																			// as
				eventResponse = this.saveAsInlandRouteManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // ★
																				// 2009/08/13
																				// kim
																				// kwijin
																				// 수정
				eventResponse = this.getReferenceNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // ★
																					// 2009/07/29
																					// kim
																					// kwi-jin수정
																					// (Product
																					// Catalog
																					// Inquiry
																					// 리스트)
				eventResponse = this.searchInlandRouteManageList01(e);
			}

			/*
			 * Inland Route Manage Empty IRG
			 */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0056Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // mst
																		// 조회
				eventResponse = this.searchEmptyInlandRouteManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // detail
																			// 조회
				eventResponse = this.searchEmptyInlandRouteManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Country 조회

				eventResponse = this.searchCntOfContiUSA(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // mst
																			// 저장
				eventResponse = this.multiEmptyInlandRouteManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // DETAIL
																			// SAVE.
				eventResponse = this.multi01EmptyInlandRouteManage(e);
			}

			// inland multi creation
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0054Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = this.searchInlandMultiList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiInlandMulti(e);
			}

			/*
			 * Inland Link Manage
			 */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0009Event")) {
			EsdPrd0009Event event = (EsdPrd0009Event) e;

			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = this.searchInlandLinkManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiInlandLinkManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { // agmt
																				// no
																				// update
				eventResponse = this.multiAgmtNo(event);
			}

			/*
			 * Inland Route Manage - Route List
			 */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = this.searchInlandRouteManageCreateList(e);
			}

			/*
			 * Inland Route Manage - Link List 2009-08-13 KIM KWIJIN 수정
			 */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = this.searchInlandLinkManagePopup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiInlandLinkManagePopup(e);
			}

			/*
			 * Ocean Route Condition Manage - Carrier
			 */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = this.searchOceanRouteConditionManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiOceanRouteConditionManage(e);
			} else {
				eventResponse = this.searchOceanRouteConditionManageList(e);
			}

			/*
			 * Ocean Route Condition Manage - Embargo
			 */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = this.searchEmbargoManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiEmbargoManage(e);
			} else {
				eventResponse = this.searchEmbargoManageList(e);
			}

			/*
			 * calling terminal matrix exception
			 */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0041Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = this.searchCallingTmlMtxExptList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiCallingTmlMtxExptList(e);
			} else {
				eventResponse = this.searchCallingTmlMtxExptList(e);
			}

			/* Ocean Link Manage (HQ) */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchOceanLinkHQ(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = this.modifyOceanLinkHQ(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = this.searchOceanLinkHQJobEnd(e);
			}

			/* Ocean Link Manage (EQ) */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchOceanLinkListRHQ(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiOceanLinkRHQ(e);
			}

			/* Ocean Route Manage */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchOceanRouteList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiOceanRoute(e);
			}

			/* Ocean Route Iquery */
//		} else if (e.getEventName().equalsIgnoreCase("ESD_PRD_015Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = this.searchOceanRouteInqueryList1(e);
//			}

			/* Ocean Route Status */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchOceanRouteStatusList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = this.modifyOceanRouteStatus(e);
			}

//			/* Node Constraint */
//		} else if (e.getEventName().equalsIgnoreCase("ESD_PRD_022Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = this.searchNodeConstraintList(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
//				eventResponse = this.multiNodeConstraint(e);
////			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
////				log.debug("\n@@@@@@@ ESD_PRD_022Event SEARCH01");
////				eventResponse = this.searchCategoryCd(e);
////			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
////				log.debug("\n@@@@@@@ ESD_PRD_022Event SEARCH02");
////				eventResponse = this.searchConstraintItemCd(e);
////			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
////				log.debug("\n@@@@@@@ ESD_PRD_022Event SEARCH03");
////				eventResponse = this.searchConstraintItemNm(e);
//			}
//
//			/* Link Constraint */
//		} else if (e.getEventName().equalsIgnoreCase("ESD_PRD_023Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = this.searchLinkConstraintList(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
//				eventResponse = this.multiLinkConstraint(e);
//			}

			// Constraint Management
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = this.searchNodeConstraintList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = this.searchLinkConstraintList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = this.searchRouteConstraintList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = this.multiNodeConstraint(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = this.multiLinkConstraint(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = this.multiRouteConstraint(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = this.checkCommodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = this.checkRouteConstraint(e);
				
				if(eventResponse.getRsVoList() != null && eventResponse.getRsVoList().size() > 0) {
					eventResponse.setETCData("checkField", ((SearchRouteConstraintVO)eventResponse.getRsVoList().get(0)).getChkField());
					eventResponse.setETCData("rowNum", ((SearchRouteConstraintVO)eventResponse.getRsVoList().get(0)).getRowNum());
				}
				else {
					eventResponse.setETCData("checkField", "");
					eventResponse.setETCData("rowNum", "");
				}
			}

			// ★ Pod Management
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0085Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchPodList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = this.searchLocationState(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = this.searchValidation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiPod(e);
			}

			/* Ocean Route Manage - Manual Creation */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0035Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = this.searchOceanLane(e);
			}

			/* Ocean Route Manage - Manual Creation PopUp */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchOceanLane(e);
			}

			/* Ocean Route Manage - Auto Creation */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchOceanRouteAutoCreationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = this.rowSearchOceanRouteManage(e);
			}

			/* Ocean Route Manage - MULTI Creation */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0060Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchOceanRouteMultiCreationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiCreateOceanRoute(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {   //2011.07.11 이수진 추가
				eventResponse = this.searchSameOceanRoute(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = this.searchOceanRouteSingleCreation(e);
			}
			
			/* Ocean Route Manage - Upload Excel Verification Result */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0086Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchOceanRouteValidationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = this.searchOceanRouteValidation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiOceanRouteValidationList(e);
			}

			/* Lane Connection Manage - Auto Creation */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchLaneConnection(e);
			}
		} 
		else if (e.getEventName().equalsIgnoreCase("EsdPrd0087Event")) {
			log.debug("\nEsdPrd0087Event---------");
			if ( e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchUNClass(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsdPrd0025Event")) {
			log.debug("\nEsdPrd0025Event---------");
			if ( e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchListExptCust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiExptCust(e);
			}
		}
		
		
		return eventResponse;
	}

	/**
	 * IMDG Class 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUNClass(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//ScgComInternalEvent event = (ScgComInternalEvent)e;
		PodManageBC command = new PodManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			log.debug("\nEsdPrd0087Event---------3");
			List<PrdImdgClssCdVO> list = command.searchUNClass();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Class"}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * NetworkLinkManageSC's multiCallingTmlMtxExptList ★2009-09-17 kim kwijin수정
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 *             EventResponse
	 */
	private EventResponse multiCallingTmlMtxExptList(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0041Event event = (EsdPrd0041Event) e;
		OceanRouteConditionManageBC command = new OceanRouteConditionManageBCImpl();
		try {
			begin();
			command.multiCallingTmlMtxExptList(event
					.getSearchCallingTmlMtxExptVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRD00063")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/** Multi Creation시 Insert 한 Row에 대하여 중복 여부 Validation Check 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOceanRouteMultiCreationList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0060Event event = (EsdPrd0060Event) e;
		OceanRouteManageBC command = new OceanRouteManageBCImpl();

		try {
			List<SearchOceanRouteMultiCreationVO> list = command
					.searchOceanRouteMultiCreationList(event
							.getSearchOceanRouteMultiCreationVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * NetworkLinkManageSC's multiAgmtNo Agmt no 를 저장한다. 또한 해당 Agmt No를 가진 IRG도
	 * 함께 업데이트 한다. (from,to node, mode , s/p 가 같은 경우)
	 * 
	 * @param e
	 * @param models
	 * @return
	 * @throws EventException
	 *             EventResponse
	 */
	private EventResponse multiAgmtNo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0009Event event = (EsdPrd0009Event) e;
		InlandLinkManageBC command = new InlandLinkManageBCImpl();
		try {
			begin();

			List<PrdInlndEachLnkVO> list = command.multiAgmtNo(event
					.getPrdInlndEachLnkVOs(), account);
			eventResponse.setRsVoList(list);

			eventResponse.setETCData("validAgmtNoRoute", list.get(
					list.size() - 1).getValidAgmtNoRoute());
			eventResponse.setETCData("validUpdateRoute", list.get(
					list.size() - 1).getValidUpdateRoute());
			eventResponse.setUserMessage(new ErrorHandler("PRD00063")
					.getUserMessage());

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * NetworkLinkManageSC's searchEmptyInlandRouteManageList
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEmptyInlandRouteManageList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0056Event event = (EsdPrd0056Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();

		try {
			List<SearchEmptyInlandRouteMasterListVO> list = command
					.searchEmptyInlandRouteManageList(event
							.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * NetworkLinkManageSC's getReferenceNo
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 *             EventResponse
	 */
	private EventResponse getReferenceNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0005Event event = (EsdPrd0005Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();

		try {
			List<GetReferenceNoVO> list = command.getReferenceNo(event
					.getGetReferenceNoVO());
			eventResponse.setRsVoList(list);

			eventResponse.setETCData("rowCount", list.size() + "");
			if (list.size() > 0) {
				eventResponse.setETCData("trs_vndr_seq", list.get(
						list.size() - 1).getVndrSeq());
			} else {
				eventResponse.setETCData("trs_vndr_seq", "");
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * NetworkLinkManageSC's searchOceanLane
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 *             EventResponse
	 */
	private EventResponse searchOceanLane(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			List<SearchOceanLaneVO> list = null;
			OceanRouteManageBC command = new OceanRouteManageBCImpl();
			if (e.getEventName().equals("EsdPrd0035Event")) {
				EsdPrd0035Event event = (EsdPrd0035Event) e;
				list = command.searchOceanLane(event.getSearchOceanLaneVO(),
						event.getEventName());
			} else {
				EsdPrd0040Event event = (EsdPrd0040Event) e;
				list = command.searchOceanLane(event.getSearchOceanLaneVO(),
						event.getEventName());
			}

			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * NetworkLinkManageSC's searchConstraintItemNm
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 *             EventResponse
	 */
//	private EventResponse searchConstraintItemNm(Event e) throws EventException {
//		EventResponse eventResponse = null;
//
//		try {
//			ConstraintManageBC command = new ConstraintManageBCImpl();
//		} catch (Exception de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}

	/**
	 * NetworkLinkManageSC's searchConstraintItemCd
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 *             EventResponse
	 */
//	private EventResponse searchConstraintItemCd(Event e) throws EventException {
//		EventResponse eventResponse = null;
//
//		try {
//			ConstraintManageBC command = new ConstraintManageBCImpl();
//		} catch (Exception de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}

	/**
	 * NetworkLinkManageSC's searchCategoryCd
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 *             EventResponse
	 */
//	private EventResponse searchCategoryCd(Event e) throws EventException {
//		EventResponse eventResponse = null;
//
//		try {
//			ConstraintManageBC command = new ConstraintManageBCImpl();
//		} catch (Exception de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}

	/**
	 * 조회 이벤트 처리<br>
	 * InlandRouteManage의 route prio seq 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPrioSeq(Event e) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0005Event event = (EsdPrd0005Event) e;

		try {
			InlandRouteManageBC command = new InlandRouteManageBCImpl();
			String str = command.searchPrioSeq(event.getInlandRouteMsUSVO());
			// TODO 이 로직이 맞는가?
			eventResponse.setETCData(str, str);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * HubLocationMatchingManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 *                <b> 2009/07/27 kim kwijin 수정</b>
	 * 
	 */
	private EventResponse searchHubLocationMatchingManage(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0004Event event = (EsdPrd0004Event) e;

		try {
			HubLocationMatchingManageBC command = new HubLocationMatchingManageBCImpl();
			List<SearchHubLocationListVO> list = command
					.searchHubLocationMatchingManage(event
							.getSearchHubLocationListVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * HubLocationMatchingManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 *                2009/07/29 kim kwi-jin 수정
	 */
	private EventResponse multiHubLocationMatchingManage(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0004Event event = (EsdPrd0004Event) e;
		HubLocationMatchingManageBC command = new HubLocationMatchingManageBCImpl();
		try {
			begin();
			command.multiHubLocationMatchingManage(event
					.getSearchHubLocationListVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRD00063")
					.getUserMessage());
			List<SearchHubLocationListVO> list = command
					.searchHubLocationMatchingManage(event
							.getSearchHubLocationListVO());
			eventResponse.setRsVoList(list);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * InlandRouteManage 화면에 대한 master조회 이벤트 처리<br>
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRouteManageList(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0005Event event = (EsdPrd0005Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();

		try {
			SearchConditionVO schConditionVo = event.getSearchConditionVO();
			List<SearchInlandRouteManageAsiaEuVO> list = command
					.searchInlandRouteManageList(schConditionVo);
			eventResponse.setRsVoList(list);

			String comboArg = "";
			int maxPrioSeq = 0;

			if (list.size() > 0) {
				maxPrioSeq = Integer.parseInt(list.get(0).getMaxPrioSeq());
			}
			if (maxPrioSeq < list.size()) {

				for (int i = 0; i <= list.size(); i++) {
					comboArg = comboArg + i + "|";
				}
			} else {
				for (int i = 0; i <= maxPrioSeq; i++) {
					comboArg = comboArg + i + "|";
				}
			}
			
			String contiCd = "A";
			if(!"B".equals(schConditionVo.getRInbound())) { // Terminal Shuttle일 경우는 무조건 Optimum을 사용못하므로, Eruope로 안본다.
				
				// Continent값을 처리
				PrdCommonManageBC prdCommonManageBC = new PrdCommonManageBCImpl(); 
				ValidationVO validationVO = new ValidationVO();
				String originContiCd = "";
				String destContiCd = "";
				if (schConditionVo.getIOrgCd() != null && !"".equals(schConditionVo.getIOrgCd())) {
					validationVO.setCheckData(schConditionVo.getIOrgCd());
					List<ValidationVO> contValRsltVo = prdCommonManageBC.searchContinentCode(validationVO);
					if (contValRsltVo.size() > 0) {
						originContiCd = contValRsltVo.get(0).getChk();
					}
				}
				
				if (schConditionVo.getIDestCd() != null && !"".equals(schConditionVo.getIDestCd())) {
					validationVO.setCheckData(schConditionVo.getIDestCd());
					List<ValidationVO> contValRsltVo = prdCommonManageBC.searchContinentCode(validationVO);
					if (contValRsltVo.size() > 0) {
						destContiCd = contValRsltVo.get(0).getChk();
					}
				}
				
				if(("E".equals(originContiCd) && "E".equals(destContiCd)) 
						||("".equals(originContiCd) && "E".equals(destContiCd))
						||("E".equals(originContiCd) && "".equals(destContiCd))
						) {
					contiCd = "E";
				}
			}
			
			log.debug("★maxPrioSeq:::" + maxPrioSeq);
			log.debug("★prio_seq_combo:::" + comboArg);
			log.debug("★conti_cd:::" + contiCd);
			eventResponse.setETCData("prio_seq_combo", comboArg);
			eventResponse.setETCData("maxPrioSeq", maxPrioSeq + "");
			eventResponse.setETCData("sch_conti_cd", contiCd + "");

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * 조회 이벤트 처리<br>
	 * InlandRouteManage 화면에 대한 master조회 이벤트 처리<br>
	 * ★ 2009/07/29 kim kwi-jin 수정
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRouteManageList01(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0005Event event = (EsdPrd0005Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();

		try {
			List<InlandRouteVO> list = command
					.searchInlandRouteManageList01(event.getInlandRouteVO());
			eventResponse.setRsVoList(list);

			String comboArg = "";
			int maxPrioSeq = 0;
			for (int i = 0; i < list.size(); i++) {
				InlandRouteVO itm = (InlandRouteVO) list.get(i);
//				comboArg += itm.getPrioSeq() + "|";
				comboArg = comboArg + itm.getPrioSeq() + "|";
				maxPrioSeq = Integer.parseInt(itm.getPrioSeq());

			}
			// max < row count 일때 차이만큼 prioSeq 를 만들어준다.
			if (maxPrioSeq < list.size()) {
				int gap = list.size() - maxPrioSeq;
				for (int i = 1; i <= gap; i++) {
					comboArg = comboArg + (maxPrioSeq + 1) + "|";
				}
			}

			eventResponse.setETCData("prio_seq_combo", comboArg);
			eventResponse.setETCData("maxPrioSeq", maxPrioSeq + "");

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * 조회 이벤트 처리<br>
	 * InlandRouteManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * ★ 2009/07/31 kim kwi-jin수정
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRouteManage(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0005Event event = (EsdPrd0005Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();

		try {

			List<InlandRouteDetVO> list = command.searchInlandRouteManage(event
					.getInlandRouteDetVO());
			InlandRouteDetVO itm = new InlandRouteDetVO();
			if (list.size() > 0) {
				itm = (InlandRouteDetVO) list.get(0);
				eventResponse.setETCData("i_inv", JSPUtil.getNull(itm
						.getInlndRoutInvBilPattCd()));
				eventResponse.setETCData("i_rout_pln_cd", JSPUtil.getNull(itm
						.getRoutPlnCd()));
				eventResponse.setETCData("i_route_rmk", JSPUtil.getNull(itm
						.getInlndRoutRmk()));
				eventResponse.setETCData("i_wrs_fl_cd", JSPUtil.getNull(itm
						.getWrsFullCmdtCd()));
				eventResponse.setETCData("i_wrs_mt_cd", JSPUtil.getNull(itm
						.getWrsMtyCmdtCd()));
				eventResponse.setETCData("disable_bkg_flg", JSPUtil.getNull(itm
						.getCc()));
				eventResponse.setETCData("i_bkg_flg", JSPUtil.getNull(
						itm.getInlndRoutBkgFlg()).equals("Y") ? JSPUtil
						.getNull(itm.getInlndRoutBkgFlg()) : "");
				eventResponse.setETCData("i_mcntr_rout_flg", JSPUtil.getNull(
						itm.getMcntrRoutFlg()).equals("Y") ? JSPUtil
						.getNull(itm.getMcntrRoutFlg()) : "");

				eventResponse.setETCData("i_optm_flg", JSPUtil.getNull(
						itm.getInlndRoutOptmFlg()).equals("Y") ? JSPUtil
						.getNull(itm.getInlndRoutOptmFlg()) : "");
				eventResponse.setETCData("i_altn_optm_flg", JSPUtil.getNull(
						itm.getAltnOptmFlg()).equals("Y") ? JSPUtil
								.getNull(itm.getAltnOptmFlg()) : "");

			}

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EmptyInlandRoute DETAIL 조회 ★2009-08-24 KIM KWIJIN수정
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchEmptyInlandRouteManage(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0056Event event = (EsdPrd0056Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();

		try {
			List<InlandRouteDetVO> list = command
					.searchEmptyInlandRouteManage(event.getInlandRouteDetVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * InlandRouteManage의 event에 대한 특정ROW 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 *                2009-08-13 KIMKWIJIN 수정
	 */
	private EventResponse rowSearchInlandRouteManage(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0005Event event = (EsdPrd0005Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();

		try {
			List<RowSearchInlandRouteManageVO> list = command
					.rowSearchInlandRouteManage(event
							.getRowSearchInlandRouteManageVO());
			log.debug("★★★::::"
					+ event.getRowSearchInlandRouteManageVO().getRow());
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("rowCount", list.size() + "");

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * InlandRouteManage의 event에 대한 master 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiInlandRouteManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0005Event event = (EsdPrd0005Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();
		try {
			begin();
			command.multiInlandRouteManage(event
					.getSearchInlandRouteManageAsiaEuVOs(), event
					.getSearchConditionVO().getIDelFlg(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRD00063")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * multiEmptyInlandRoute ★2009-08-24 KIM KWIJIN수정
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiEmptyInlandRouteManage(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0056Event event = (EsdPrd0056Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();
		try {
			begin();
			command.multiEmptyInlandRouteManage(event
					.getEmptySaveInlandRouteMstVOs(), account, event
					.getSearchConditionVO().getIDelFlg());

			eventResponse.setUserMessage(new ErrorHandler("PRD00063")
					.getUserMessage());

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * InlandRouteManage의 event에 대한 detail 멀티 이벤트 처리<br>
	 * PRD_005 화면에서 detail 저장시
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multi01InlandRouteManage(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0005Event event = (EsdPrd0005Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();
		String errMsg = "";
		try {
			int retCnt = command.getInLandRouteExistCount(event
					.getInlandRouteMsUSVO(), event.getInlandRouteUSDetVOs());
			event.getInlandRouteMsUSVO().setNodTpCd2(
					event.getInlandRouteMsUSVO().getNodTpCd1());

			if (retCnt > 0) {
				int remRet = command.getInLandRouteRemarkCompare(event
						.getInlandRouteMsUSVO());
				if (remRet > 0) {
					begin();
					command.updateRemark(event.getInlandRouteMsUSVO());
					commit();
				} else {
					// eventResponse.setUserMessage("Exist Inland route.");
					errMsg = "Exist Inland route.";
					eventResponse.setETCData("strErrMsg", errMsg);
					return eventResponse;
				}

			} else {
				begin();
//				String newRoutSeq = command.multi01InlandRouteManage(event.getInlandRouteUSDetVOs(), event.getInlandRouteMsUSVO(), account);
				command.multi01InlandRouteManage(event.getInlandRouteUSDetVOs(), event.getInlandRouteMsUSVO(), account);
				eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
				commit();
			}

			eventResponse.setRsVoList(command.rowSearchMaster(event
					.getInlandRouteMsUSVO()));

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multi01EmptyInlandRouteManage(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0056Event event = (EsdPrd0056Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();
//		String multi = "";
		try {
			int retCnt = command.getEmptyInLandRouteExistCount(event
					.getEmptySaveInlandRouteDetVOs(), event
					.getEmptySaveInlandRouteDetVO());
			if (retCnt > 0) {

				InlandRouteMsUSVO inlandRouteMsUSVO = new InlandRouteMsUSVO();
				inlandRouteMsUSVO.setIRoutOrgNodCd(event.getEmptySaveInlandRouteDetVO().getIRoutOrgNodCd());
				inlandRouteMsUSVO.setIRoutDestNodCd(event.getEmptySaveInlandRouteDetVO().getIRoutDestNodCd());
				inlandRouteMsUSVO.setIRoutSeq(event.getEmptySaveInlandRouteDetVO().getIRoutSeq());
				inlandRouteMsUSVO.setIRouteRmk(event.getEmptySaveInlandRouteDetVO().getIRouteRmk());

				// 리마크 부분이 변경 됐으면 리마크 업데이트
				int remRet = command
						.getInLandRouteRemarkCompare(inlandRouteMsUSVO);

				if (remRet > 0) {
					begin();
					command.updateEmptyRemark(event
							.getEmptySaveInlandRouteDetVO());
					commit();
				} else {

					eventResponse
							.setETCData("strErrMsg", "Exist Inland route.");
					return eventResponse;
				}

			} else {
				begin();
				command.multi01EmptyInlandRouteManage(event
						.getEmptySaveInlandRouteDetVOs(), event
						.getEmptySaveInlandRouteDetVO(), account);
				commit();
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		// call by reference 가 되면 multi를 세팅하지 않아도 된다.
		return this.rowSearchEmptyMaster(e);
	}

	/**
	 * NetworkLinkManageSC's saveAsInlandRouteManage
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 *             EventResponse
	 */
	private EventResponse saveAsInlandRouteManage(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0005Event event = (EsdPrd0005Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();
		String errMsg = "";
		try {
			int retCnt = command.getInLandRouteExistCount(event
					.getInlandRouteMsUSVO(), event.getInlandRouteUSDetVOs());
			if (retCnt > 0) {
				// 리마크 부분이 변경 됐으면 리마크 업데이트

				int remRet = command.getInLandRouteRemarkCompare(event
						.getInlandRouteMsUSVO());
				if (remRet > 0) {
					begin();
					command.updateRemark(event.getInlandRouteMsUSVO());
					commit();
				} else {

					errMsg = "Exist Inland route.";
					eventResponse.setETCData("strErrMsg", errMsg);
					return eventResponse;
				}
			} else {
				event.getInlandRouteMsUSVO().setNodTpCd2(
						event.getInlandRouteMsUSVO().getNodTpCd1());
				begin();
				String newRoutSeq = command.saveAsInlandRouteManage(event
						.getInlandRouteUSDetVOs(),
						event.getInlandRouteMsUSVO(), account);
				event.getInlandRouteMsUSVO().setIRoutSeq(newRoutSeq);
				eventResponse.setUserMessage(new ErrorHandler("PRD00063")
						.getUserMessage());

				commit();

			}
			eventResponse.setRsVoList(command.rowSearchMaster(event
					.getInlandRouteMsUSVO()));
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * InlandRouteManage의 디테이정보를 저장후 해당 마스터 정보를 업데이트 하기위해 조회 <br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
//	private EventResponse rowSearchMaster(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		// ESD_PRD_005Event event = (ESD_PRD_005Event)e;
//		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
//		log.debug("\n\nRowSearchMaster--------------");
//		EventResponse eventResponse = null;
//		try {
//			InlandRouteManageBC command = new InlandRouteManageBCImpl();
//			// eventResponse = command.rowSearchMaster(e);
//			throw new EventException();
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		// return null;
//	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse rowSearchEmptyMaster(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0056Event event = (EsdPrd0056Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();

		try {
			List<RowSearchEmptyMasterVO> list = command
					.rowSearchEmptyMaster(event.getEmptySaveInlandRouteDetVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * InlandLinkManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandLinkManageList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0009Event event = (EsdPrd0009Event) e;
		InlandLinkManageBC command = new InlandLinkManageBCImpl();

		try {
			List<PrdInlndEachLnkVO> list = command
					.searchInlandLinkManageList(event.getPrdInlndEachLnkVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * InlandLinkManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandLinkManagePopup(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0007Event event = (EsdPrd0007Event) e;
		InlandLinkManageBC command = new InlandLinkManageBCImpl();

		try {
			List<SearchInlandLinkManageListVO> list = command
					.searchInlandLinkManagePopup(event
							.getSearchInlandLinkManageListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * 멀티 이벤트 처리<br>
	 * InlandLinkManage의 event에 대한 멀티 이벤트 처리<br>
	 * 009번 화면에서 는 안쓰고 007 번(팝업) 화면에서 사용
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiInlandLinkManagePopup(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0007Event event = (EsdPrd0007Event) e;
		InlandLinkManageBC command = new InlandLinkManageBCImpl();
		try {
			begin();

			Map etcData = command.multiInlandLinkManage(event
					.getSearchInlandLinkManageListVOs(), account);
			eventResponse.setETCData(etcData);
			List list = command.searchInlandLinkManagePopup(event
					.getSearchInlandLinkManageListVO());
			eventResponse.setRsVoList(list);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * NetworkLinkManageSC's multiInlandLinkManage
	 * 
	 * @param event
	 * @param models
	 * @param sa
	 * @return
	 * @throws EventException
	 *             EventResponse
	 */
	private EventResponse multiInlandLinkManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0009Event event = (EsdPrd0009Event) e;
		InlandLinkManageBC command = new InlandLinkManageBCImpl();
		try {
			begin();

			Map etcData = command.multiInlandLinkManage(event
					.getSearchInlandLinkManageListVOs(), account);
			eventResponse.setETCData(etcData);
			List<PrdInlndEachLnkVO> list = command
					.searchInlandLinkManageList(event.getPrdInlndEachLnkVO());
			eventResponse.setRsVoList(list);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;

	}

	/**
	 * 조회 이벤트 처리<br>
	 * InlandRouteManage 화면에 대한 조회 이벤트 처리<br>
	 * ★2009-09-01 kim kwijin수정
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRouteManageCreateList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0006Event event = (EsdPrd0006Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();

		try {
			List<InlandRouteSelCreVO> list = command
					.searchInlandRouteManageCreateList(event
							.getInlandRouteSelCreVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * 조회 이벤트 처리<br>
	 * OceanRouteConditionManage carrier 화면에 대한 조회 이벤트 처리<br>
	 * ★2009-09-16 kim kwijin수정
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOceanRouteConditionManageList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0011Event event = (EsdPrd0011Event) e;
		OceanRouteConditionManageBC command = new OceanRouteConditionManageBCImpl();

		try {
			List<SearchOceanRouteConditionVO> list = command
					.searchOceanRouteConditionManageList(event
							.getSearchOceanRouteConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * NetworkLinkManageSC's searchCallingTmlMtxExptList ★2009-09-17 kim
	 * kwijin수정
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 *             EventResponse
	 */
	private EventResponse searchCallingTmlMtxExptList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0041Event event = (EsdPrd0041Event) e;
		OceanRouteConditionManageBC command = new OceanRouteConditionManageBCImpl();

		try {
			List<SearchCallingTmlMtxExptVO> list = command
					.searchCallingTmlMtxExptList(event
							.getSearchCallingTmlMtxExptVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * OceanRouteConditionManage carrier 의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiOceanRouteConditionManage(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0011Event event = (EsdPrd0011Event) e;
		OceanRouteConditionManageBC command = new OceanRouteConditionManageBCImpl();
		try {
			begin();
			command.multiOceanRouteConditionManage(event
					.getSearchOceanRouteConditionVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRD00063")
					.getUserMessage());
			commit();

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * 조회 이벤트 처리<br>
	 * OceanRouteConditionManage Embargo 화면에 대한 조회 이벤트 처리<br>
	 * ★2009-09-18 kim kwijin수정
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEmbargoManageList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0010Event event = (EsdPrd0010Event) e;
		OceanRouteConditionManageBC command = new OceanRouteConditionManageBCImpl();

		try {
			List<SearchEmbargoVO> list = command.searchEmbargoManageList(event
					.getSearchEmbargoVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * 멀티 이벤트 처리<br>
	 * OceanRouteConditionManage Embargo 의 event에 대한 멀티 이벤트 처리<br>
	 * ★2009-09-18 kim kwijin수정
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiEmbargoManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0010Event event = (EsdPrd0010Event) e;
		OceanRouteConditionManageBC command = new OceanRouteConditionManageBCImpl();
		try {
			begin();
			command.multiEmbargoManage(event.getSearchEmbargoVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRD00063")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * OceanLinkManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOceanLinkHQ(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0012Event event = (EsdPrd0012Event) e;
		OceanLinkManageBC command = new OceanLinkManageBCImpl();

		try {
			List<SearchOceanLinkVO> list = command.searchOceanLinkList(event
					.getSearchOceanLinkVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 수정 이벤트 처리<br>
	 * OceanLinkManage의 event에 대한 수정 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyOceanLinkHQ(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0012Event event = (EsdPrd0012Event) e;
		OceanLinkManageBC command = new OceanLinkManageBCImpl();
		try {
			begin();
			SaveOceanLinkVO[] vos = event.getSaveOceanLinkVOs();
			String key = command.modifyOceanLink(vos, account);
			eventResponse.setETCData("back_end_job_key", key);
			commit();
						
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 수정 이벤트 처리<br>
	 * OceanLinkManage의 event에 대한 수정 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOceanLinkHQJobEnd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0012Event event = (EsdPrd0012Event) e;
		OceanLinkManageBC command = new OceanLinkManageBCImpl();
		try {
            String backEndJobKey = event.getSearchOceanLinkVO().getBackEndJobKey();
			// Backend job이 완료되었는지 검사한다.
            BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(backEndJobKey);

            DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
            List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
           
            ComBakEndJbVO jobVo = new ComBakEndJbVO();
            
            if (dbRowSetlist.size() == 0) {
                // Background job framework가 정상적으로 동작하지 않을 경우 발생하는 오류를 회피하기 위함           
                jobVo.setJbStsFlg("0");
            } else {
                jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);
            }

            eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
            if (jobVo.getJbStsFlg().equals("3")) {
                // Backend job이 완료되었으면 조회를 수행한다.
    			List<SearchOceanLinkVO> list = command.searchOceanLinkList(event
    					.getSearchOceanLinkVO());
    			eventResponse.setRsVoList(list);
            	eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
            }
			
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * RHQ Ocean Link Management ★2009-09-16 kim kwijin수정
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOceanLinkListRHQ(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0013Event event = (EsdPrd0013Event) e;
		OceanLinkManageBC command = new OceanLinkManageBCImpl();

		try {
			List<SearchOceanLinkRHQVO> list = command
					.searchOceanLinkListRHQ(event.getSearchOceanLinkRHQVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiOceanLinkRHQ(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0013Event event = (EsdPrd0013Event) e;
		OceanLinkManageBC command = new OceanLinkManageBCImpl();
		try {
			begin();
			command.multiOceanLinkRHQ(event.getSaveOceanLinkRHQVOs(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return this.searchOceanLinkListRHQ(e);
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOceanRouteList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0014Event event = (EsdPrd0014Event) e;
		OceanRouteManageBC command = new OceanRouteManageBCImpl();

		try {
			List<SearchOceanRouteListVO> list = command
//			.searchOceanRouteList(event.getSearchConditionVO());
					.searchOceanRouteList(event.getSearchConditionVO(),event.getIPage());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiOceanRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0014Event event = (EsdPrd0014Event) e;
		OceanRouteManageBC command = new OceanRouteManageBCImpl();
		try {
			begin();
			command.multiOceanRoute(event.getSaveOceanRouteVOs(), account);
			List<SearchOceanRouteListVO> list = command
//			.searchOceanRouteList(event.getSearchConditionVO());
					.searchOceanRouteList(event.getSearchConditionVO(), event.getIPage());
			eventResponse.setUserMessage(new ErrorHandler("PRD00063")
					.getUserMessage());
			eventResponse.setRsVoList(list);
			commit();

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiCreateOceanRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0060Event event = (EsdPrd0060Event) e;
		OceanRouteManageBC command = new OceanRouteManageBCImpl();
		try {
			begin();
			// command.save(event.getApPayInvVOS(),account);
			command.multiOceanRoute(event.getSaveOceanRouteVOs(), account);
			// List<SearchOceanRouteListVO> list =
			// command.searchOceanRouteList(event.getSearchConditionVO());
			eventResponse.setUserMessage(new ErrorHandler("PRD00063")
					.getUserMessage());
			// eventResponse.setRsVoList(list);
			commit();

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
//	private EventResponse searchOceanRouteInqueryList1(Event e)
//			throws EventException {
//		EventResponse eventResponse = null;
//
//		try {
//			OceanRouteManageBC command = new OceanRouteManageBCImpl();
//			throw new EventException();
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		// return eventResponse;
//	}

	/**
	 * searchOceanRouteStatusList ★2009-09-18 kim kwijin수정
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOceanRouteStatusList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0016Event event = (EsdPrd0016Event) e;
		OceanRouteManageBC command = new OceanRouteManageBCImpl();

		try {
			List<SearchOceanRouteStatusVO> list = command
					.searchOceanRouteStatusList(event
							.getSearchOceanRouteStatusVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * modifyOceanRouteStatus ★2009-09-18 kim kwijin수정
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse modifyOceanRouteStatus(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0016Event event = (EsdPrd0016Event) e;
		OceanRouteManageBC command = new OceanRouteManageBCImpl();
		try {
			begin();
			command.modifyOceanRouteStatus(event.getSaveOceanRouteStatusVOs(),
					event.getSearchOceanRouteStatusVO(), account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return this.searchOceanRouteStatusList(e);

	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchNodeConstraintList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0024Event event = (EsdPrd0024Event) e;
		ConstraintManageBC command = new ConstraintManageBCImpl();

		try {
			List<ConstraintVO> list = command.searchNodeConstraintList(event
					.getConstraintVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiNodeConstraint(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0024Event event = (EsdPrd0024Event) e;
		ConstraintManageBC command = new ConstraintManageBCImpl();
		try {
			begin();
			command.multiNodeConstraint(event.getSearchNodeConstraintVOs(),
					account);
			//List<SearchNodeConstraintVO> list = command.searchNodeConstraintList(event.getConstraintVO());
			//command.searchNodeConstraintList(event.getConstraintVO());
			eventResponse.setUserMessage(new ErrorHandler("PRD00063")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchLinkConstraintList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0024Event event = (EsdPrd0024Event) e;
		ConstraintManageBC command = new ConstraintManageBCImpl();

		try {
			List<ConstraintVO> list = command.searchLinkConstraintList(event
					.getConstraintVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiLinkConstraint(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0024Event event = (EsdPrd0024Event) e;
		ConstraintManageBC command = new ConstraintManageBCImpl();
		try {
			begin();
			command.multiLinkConstraint(event.getSearchLinkConstraintVOs(),account);
//			List<SearchLinkConstraintVO> list = command.searchLinkConstraintList(event.getConstraintVO());
			command.searchLinkConstraintList(event.getConstraintVO());
			eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchRouteConstraintList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0024Event event = (EsdPrd0024Event) e;
		ConstraintManageBC command = new ConstraintManageBCImpl();

		try {

			List<ConstraintVO> list = command.searchRouteConstraintList(event
					.getConstraintVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiRouteConstraint(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0024Event event = (EsdPrd0024Event) e;
		ConstraintManageBC command = new ConstraintManageBCImpl();
		try {
			begin();
			command.multiRouteConstraint(event.getSearchRouteConstraintVOs(),
					account);
			// List<SearchRouteConstraintVO> list =
			// command.searchRouteConstraintList(event.getConstraintVO());
			eventResponse.setUserMessage(new ErrorHandler("PRD00063")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESD_PRD_0024 : checkRouteConstraint <br>
	 * 저장 할 대상의 validation를 체크 합니다. <br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkRouteConstraint(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0024Event event = (EsdPrd0024Event) e;
		ConstraintManageBC command = new ConstraintManageBCImpl();

		try {

			List<SearchRouteConstraintVO> list = command.checkRouteConstraint(event.getSearchRouteConstraintVOs());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
		
	}
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOceanRouteAutoCreationList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0032Event event = (EsdPrd0032Event) e;
		OceanRouteManageBC command = new OceanRouteManageBCImpl();

		try {
			List<SearchOceanRouteAutoCreationVO> list = command
					.searchOceanRouteAutoCreationList(event
							.getSearchOceanRouteAutoCreationVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * 조회 이벤트 처리<br>
	 * InlandRouteManage의 event에 대한 특정ROW 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse rowSearchOceanRouteManage(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0032Event event = (EsdPrd0032Event) e;
		OceanRouteManageBC command = new OceanRouteManageBCImpl();

		try {
			List<RowSearchOceanRouteManageVO> list = command.rowSearchOceanRouteManage(event.getRowSearchOceanRouteManageVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}
	
    /**  2011.07.11 이수진
     * 조회 이벤트 처리<br>
     * ESD_PRD_0016 화면에 대한 멀티 이벤트 처리<br>
     * @param SaveOceanRouteVO saveOceanRouteVO
     * @throws EventException
     */
	private EventResponse searchSameOceanRoute(Event e)		throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0060Event event = (EsdPrd0060Event) e;
		OceanRouteManageBC command = new OceanRouteManageBCImpl();
		log.debug("\n event"+event.toString());
		try {
			String dupFlag = command.searchSameOceanRoute(event.getSaveOceanRouteVO());
			eventResponse.setETCData("dup_flag", dupFlag);
			// --validation 추가 (단건만 처리함)
			SaveOceanRouteVO[] saveVos = {event.getSaveOceanRouteVO()};
			List<SaveOceanRouteVO> list = command.searchOceanRouteValidationList(saveVos);
			
			eventResponse.setETCData("ERR_CD", "N");
			eventResponse.setUserMessage("");
			String exptFlag = (String) event.getAttribute("expt_flag");
			if( list != null && !exptFlag.equals("Y")){
				
				SaveOceanRouteVO saveVo = list.get(0);
				String[] arrCd ={"E01","E02","E03","E04","E05","E06","E07","E08","E09","E10","E11","E12","E13","E14","E98","E99"};
				String[] arrDesc ={"Port Code Error","Lane Code Error","Lane P/F SKD Error","Link Error","POD Overlap Error","Canal Code Error","Optimization Error(1)","Optimization Error(2)","Optimization Error(3)","Return Shipment Error","Temporary Flag Error","Ocean Flag Error","Transit Time Error","Trans-shipment Error","Duplication Error","The others Error"};
				for (int j = 0; j < arrCd.length; j++) {
					
					if(saveVo.getSErrDesc().equals(arrCd[j]))  {
						eventResponse.setETCData("ERR_CD", arrCd[j]);
						eventResponse.setUserMessage(new ErrorHandler("PRD99998", new String[]{arrDesc[j] }).getUserMessage());	
//						throw new EventException(new ErrorHandler("PRD99998", new String[]{arrDesc[j] }).getMessage());
						
					}
				}
			}
			
			//--------------
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	
	}
	
   	
	
	

	/**
	 * 조회 이벤트 처리<br>
	 * LaneConnection의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneConnection(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0033Event event = (EsdPrd0033Event) e;
		OceanRouteManageBC command = new OceanRouteManageBCImpl();

		try {
			event.getSearchLaneConnectionVO().setICostYrmon("200701");
			List<SearchLaneConnectionVO> list = command
					.searchLaneConnection(event.getSearchLaneConnectionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkCommodity(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0024Event event = (EsdPrd0024Event) e;
		ConstraintManageBC command = new ConstraintManageBCImpl();

		try {
			List<CheckCommodityVO> list = command.checkCommodity(event
					.getCheckCommodityVO());
			if(list.size() > 0){
				eventResponse.setETCData("cmdt_cd", list.get(0).getCmdtCd());
				eventResponse.setETCData("cmdt_nm", list.get(0).getCmdtNm());
			} else {
				eventResponse.setETCData("cmdt_cd", "");
				eventResponse.setETCData("cmdt_nm", "");
			}
//			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * search pod lsit ★2009-10-16 kim kwijin생성
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchPodList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0085Event event = (EsdPrd0085Event) e;
		PodManageBC command = new PodManageBCImpl();

		try {
			log.debug("★ㅇ라ㅓ알아ㅓ러ㅏㅇ");
			List<SearchPodListVO> list = command.searchPodList(event
					.getSearchPodListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * multi pod ★2009-10-16 kim kwijin생성
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiPod(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0085Event event = (EsdPrd0085Event) e;
		PodManageBC command = new PodManageBCImpl();
		try {
			begin();
			command.multiPod(event.getSearchPodListVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRD00063")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * searchLocationState ★2009-10-16 kim kwijin생성
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchLocationState(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0085Event event = (EsdPrd0085Event) e;
		PodManageBC command = new PodManageBCImpl();

		try {
			List<SearchPodListVO> list = command.searchLoactionState(event
					.getSearchPodListVO());
			String locationState = "";
			if (list != null && list.size() > 0) {
				SearchPodListVO vo = (SearchPodListVO) list.get(0);
				locationState = JSPUtil.getNull(vo.getLocationState());
				// eventResponse.setETCData("","");
			}
			eventResponse.setETCData("location_state", locationState);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchValidation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0085Event event = (EsdPrd0085Event) e;
		PodManageBC command = new PodManageBCImpl();
		try {
			String counter = JSPUtil.getNull(command.searchValidation(event
					.getSearchPodListVO()));
			eventResponse.setETCData("counter", counter);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchInlandMultiList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0054Event event = (EsdPrd0054Event) e;
		try {
			List list = new InlandMultiCreationBCImpl()
					.searchInlandMultiList(event.getSearchInlandRouteVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiInlandMulti(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0054Event event = (EsdPrd0054Event) e;
		SearchInlandRouteVO[] vos = event.getSearchInlandRouteVOs();
		StringBuilder sb = new StringBuilder();
		String msg = "";
		
		for (int i = 0, s = vos.length; i < s; i++) {
			begin();
			SearchInlandRouteVO vo = vos[i];
			sb.append("^"); // row 구분자 ^ , col 구분자는 |
			vo.setCreUsrId(account.getUsr_id());
			try {
				msg = new InlandMultiCreationBCImpl().multiInlandMulti(vo);

				sb.append(vo.getSeqNo());
				sb.append("|Success|");
				sb.append(msg);
			} catch (DAOException e1) {
				log.error("\n 파라미터 = \n" + vo.getColumnValues());
				log.error("\n 메시지 = \n" + e1.getMessage(), e1);
				sb.append(vo.getSeqNo());
				sb.append("|Fail|");
				sb.append(e1.getMessage().substring(
						e1.getMessage().lastIndexOf(">") + 1));
				rollback();
				throw new EventException(new ErrorHandler(e1).getMessage());
			}
			commit();
		}

		try {
			eventResponse.setETCData("result", sb.toString());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * NetworkLinkManageSC's searchCntOfContiUSA
	 * @param e
	 * @return
	 * @throws EventException  
	 */
	private EventResponse searchCntOfContiUSA(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PrdCommonManageBC command = new PrdCommonManageBCImpl();
		
		String[] cntCdArray = null;
		String cntCd = "";
		
		try{
			cntCdArray = command.searchCntOfConti("M");
			
			if(cntCdArray != null){
				for( int idx=0;idx<cntCdArray.length;idx++){
					cntCd = cntCd + cntCdArray[idx].toString() + "|";
				}
			}
			eventResponse.setETCData("cnt_cd", cntCd);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
     * Ocean Route Creation - Multi Creation의 Validation Check<br>
     * ESD_PRD_0060 화면에 대한 Validation 이벤트 처리<br>
     * @param e Event
     * @return EventResponse
     * @throws EventException
     */
	private EventResponse searchOceanRouteSingleCreation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0060Event event = (EsdPrd0060Event) e;
		OceanRouteManageBC command = new OceanRouteManageBCImpl();
		
		try {
			List<SearchOceanRouteSingleCreationVO> list = command.searchOceanRouteSingleCreation(event.getSearchOceanRouteSingleCreationVO());
			
			eventResponse.setETCData("prio", list.get(0).getPrio());
			eventResponse.setETCData("pol1", list.get(0).getPol1());
			eventResponse.setETCData("pol2", list.get(0).getPol2());
			eventResponse.setETCData("pol3", list.get(0).getPol3());
			eventResponse.setETCData("pol4", list.get(0).getPol4());
			eventResponse.setETCData("pod1", list.get(0).getPod1());
			eventResponse.setETCData("pod2", list.get(0).getPod2());
			eventResponse.setETCData("pod3", list.get(0).getPod3());
			eventResponse.setETCData("pod4", list.get(0).getPod4());
			eventResponse.setETCData("dir1", list.get(0).getDir1());
			eventResponse.setETCData("dir2", list.get(0).getDir2());
			eventResponse.setETCData("dir3", list.get(0).getDir3());
			eventResponse.setETCData("dir4", list.get(0).getDir4());
			eventResponse.setETCData("fdr_flg1", list.get(0).getFdrFlg1());
			eventResponse.setETCData("fdr_flg2", list.get(0).getFdrFlg2());
			eventResponse.setETCData("fdr_flg3", list.get(0).getFdrFlg3());
			eventResponse.setETCData("fdr_flg4", list.get(0).getFdrFlg4());
			eventResponse.setETCData("svc_tp1", list.get(0).getSvcTp1());
			eventResponse.setETCData("svc_tp2", list.get(0).getSvcTp2());
			eventResponse.setETCData("svc_tp3", list.get(0).getSvcTp3());
			eventResponse.setETCData("svc_tp4", list.get(0).getSvcTp4());
			eventResponse.setETCData("fmt_tot_tt", list.get(0).getFmtTotTt());
			eventResponse.setETCData("fmt_tot_st", list.get(0).getFmtTotSt());
			eventResponse.setETCData("fmt_tt", list.get(0).getFmtTt());
			eventResponse.setETCData("link_valid_flg", list.get(0).getLinkValidFlg());
			eventResponse.setETCData("fdr_usd", list.get(0).getFdrUsd());
			eventResponse.setETCData("link_cnt", list.get(0).getLinkCount());
			eventResponse.setETCData("upd_ind_cd", list.get(0).getUpdIndCd());
			
			eventResponse.setETCData("tt1", list.get(0).getTt1());
			eventResponse.setETCData("tt2", list.get(0).getTt2());
			eventResponse.setETCData("tt3", list.get(0).getTt3());
			eventResponse.setETCData("tt4", list.get(0).getTt4());
			eventResponse.setETCData("st1", list.get(0).getSt1());
			eventResponse.setETCData("st2", list.get(0).getSt2());
			eventResponse.setETCData("st3", list.get(0).getSt3());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * NetworkLinkManageSC's searchOceanRouteValidationList
	 * @param e
	 * @return
	 * @throws EventException  
	 */
	private EventResponse searchOceanRouteValidationList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0086Event event = (EsdPrd0086Event) e;
		OceanRouteManageBC command = new OceanRouteManageBCImpl();
		try {
			log.debug(event.getSaveOceanRouteVOs());
			List<SaveOceanRouteVO> list = command.searchOceanRouteValidationList(event.getSaveOceanRouteVOs());
			
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESD_PRD_0086 화면의 저장
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiOceanRouteValidationList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0086Event event = (EsdPrd0086Event) e;
		OceanRouteManageBC command = new OceanRouteManageBCImpl();
		
		try {
			begin();
			command.multiOceanRoute(event.getSaveOceanRouteVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
			commit();

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * NetworkLinkManageSC's searchOceanRouteValidation
	 * @param e
	 * @return
	 * @throws EventException  
	 */
	private EventResponse searchOceanRouteValidation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0086Event event = (EsdPrd0086Event) e;
		OceanRouteManageBC command = new OceanRouteManageBCImpl();
		
		try {
			List<SaveOceanRouteVO> list = command.searchOceanRouteValidationList(event.getSaveOceanRouteVOs());
			String arrStr = "";
			for( int idx=0; idx<list.size();idx++){
				if( idx == list.size()-1 ){
					arrStr = arrStr + list.get(idx).getSSeq() 			+"|"+ list.get(idx).getSChk() 			+"|"+ list.get(idx).getSErrTp() 		+"|"+ list.get(idx).getSErrDesc()
								+"|"+ list.get(idx).getSTs1Type() 		+"|"+ list.get(idx).getSTs2Type() 		+"|"+ list.get(idx).getSTs3Type() 		+"|"+ list.get(idx).getSTs4Type()
								+"|"+ list.get(idx).getFmtTotTt() 		+"|"+ list.get(idx).getSPrior() 		+"|"+ list.get(idx).getFullRout()
								+"|"+ list.get(idx).getSPol1() 			+"|"+ list.get(idx).getSPol2() 			+"|"+ list.get(idx).getSPol3() 			+"|"+ list.get(idx).getSPol4()
								+"|"+ list.get(idx).getSPod1() 			+"|"+ list.get(idx).getSPod2() 			+"|"+ list.get(idx).getSPod3() 			+"|"+ list.get(idx).getSPod4()
								+"|"+ list.get(idx).getSDir1() 			+"|"+ list.get(idx).getSDir2() 			+"|"+ list.get(idx).getSDir3() 			+"|"+ list.get(idx).getSDir4()
								+"|"+ list.get(idx).getSFdrFlg1() 		+"|"+ list.get(idx).getSFdrFlg2() 		+"|"+ list.get(idx).getSFdrFlg3() 		+"|"+ list.get(idx).getSFdrFlg4()
								+"|"+ list.get(idx).getSN1stTztmHrs() 	+"|"+ list.get(idx).getSN2ndTztmHrs() 	+"|"+ list.get(idx).getSN3rdTztmHrs() 	+"|"+ list.get(idx).getSN4thTztmHrs()
								+"|"+ list.get(idx).getSN1stStayTmHrs() +"|"+ list.get(idx).getSN2ndStayTmHrs() +"|"+ list.get(idx).getSN3rdStayTmHrs() +"|"+ list.get(idx).getSLnkCnt();
				} else{
					arrStr = arrStr + list.get(idx).getSSeq() 			+"|"+ list.get(idx).getSChk() 			+"|"+ list.get(idx).getSErrTp() 		+"|"+ list.get(idx).getSErrDesc()
								+"|"+ list.get(idx).getSTs1Type() 		+"|"+ list.get(idx).getSTs2Type() 		+"|"+ list.get(idx).getSTs3Type() 		+"|"+ list.get(idx).getSTs4Type()
								+"|"+ list.get(idx).getFmtTotTt() 		+"|"+ list.get(idx).getSPrior() 		+"|"+ list.get(idx).getFullRout()
								+"|"+ list.get(idx).getSPol1() 			+"|"+ list.get(idx).getSPol2() 			+"|"+ list.get(idx).getSPol3() 			+"|"+ list.get(idx).getSPol4()
								+"|"+ list.get(idx).getSPod1() 			+"|"+ list.get(idx).getSPod2() 			+"|"+ list.get(idx).getSPod3() 			+"|"+ list.get(idx).getSPod4()
								+"|"+ list.get(idx).getSDir1() 			+"|"+ list.get(idx).getSDir2() 			+"|"+ list.get(idx).getSDir3() 			+"|"+ list.get(idx).getSDir4()
								+"|"+ list.get(idx).getSFdrFlg1() 		+"|"+ list.get(idx).getSFdrFlg2() 		+"|"+ list.get(idx).getSFdrFlg3() 		+"|"+ list.get(idx).getSFdrFlg4()
								+"|"+ list.get(idx).getSN1stTztmHrs() 	+"|"+ list.get(idx).getSN2ndTztmHrs() 	+"|"+ list.get(idx).getSN3rdTztmHrs() 	+"|"+ list.get(idx).getSN4thTztmHrs()
								+"|"+ list.get(idx).getSN1stStayTmHrs() +"|"+ list.get(idx).getSN2ndStayTmHrs() +"|"+ list.get(idx).getSN3rdStayTmHrs() +"|"+ list.get(idx).getSLnkCnt() +",";
				}
			}
			eventResponse.setETCData("arrStr", arrStr);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	private EventResponse multiExptCust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0025Event event = (EsdPrd0025Event) e;
		ConstraintManageBC command = new ConstraintManageBCImpl();
		
		try {
			begin();
			command.multiExptCust(event.getSearchListCnstExptVOs(), event.getSearchListCnstExptVO().getNodCd(),
					event.getSearchListCnstExptVO().getNodCnstItmCd(), event.getSearchListCnstExptVO().getNodCnstSeq(),
					account);
			eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	private EventResponse searchListExptCust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0025Event event = (EsdPrd0025Event) e;
		ConstraintManageBC command = new ConstraintManageBCImpl();
		try {
			List<SearchListCnstExptVO> list = command.searchListExptCust(event.getSearchListCnstExptVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
}
