/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NetworkLinkManageSC.java
 *@FileTitle : HubLocation Information Management
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0 
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.clt.apps.opus.esd.prd.common.prdcommon.basic.PrdCommonManageBC;
import com.clt.apps.opus.esd.prd.common.prdcommon.basic.PrdCommonManageBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.basic.ConstraintManageBC;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.basic.ConstraintManageBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.event.EsdPrd0024Event;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.CheckCommodityVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchLinkConstraintVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchNodeConstraintVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchRouteConstraintVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.hublocationmatchingmanage.basic.HubLocationMatchingManageBC;
import com.clt.apps.opus.esd.prd.networklinkmanage.hublocationmatchingmanage.basic.HubLocationMatchingManageBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.hublocationmatchingmanage.event.EsdPrd0004Event;
import com.clt.apps.opus.esd.prd.networklinkmanage.hublocationmatchingmanage.vo.SearchHubLocationListVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.basic.InlandLinkManageBC;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.basic.InlandLinkManageBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.event.EsdPrd0007Event;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.event.EsdPrd0009Event;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.vo.PrdInlndEachLnkVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.vo.SearchInlandLinkManageListVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.basic.InlandRouteManageBC;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.basic.InlandRouteManageBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.event.EsdPrd0005Event;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.event.EsdPrd0056Event;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.GetReferenceNoVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteDetVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteMsUSVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchEmptyMasterVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchInlandRouteManageVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchEmptyInlandRouteMasterListVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchInlandRouteManageAsiaEuVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.basic.OceanLinkManageBC;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.basic.OceanLinkManageBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.event.EsdPrd0012Event;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.event.EsdPrd0013Event;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SearchOceanLinkRHQVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SearchOceanLinkVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.basic.OceanRouteConditionManageBC;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.basic.OceanRouteConditionManageBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.event.EsdPrd0010Event;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.event.EsdPrd0011Event;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.event.EsdPrd0041Event;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchCallingTmlMtxExptVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchEmbargoVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchOceanRouteConditionVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.basic.OceanRouteManageBC;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.basic.OceanRouteManageBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0014Event;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0032Event;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0035Event;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0040Event;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0060Event;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.RowSearchOceanRouteManageVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanLaneVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteAutoCreationVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteListVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteMultiCreationVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteSingleCreationVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.vslconnbuffertime.basic.VslConnBufferTimeBC;
import com.clt.apps.opus.esd.prd.networklinkmanage.vslconnbuffertime.basic.VslConnBufferTimeBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.vslconnbuffertime.event.EsdPrd0037Event;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComBakEndJbVO;
import com.clt.framework.utility.CheckUtilities;

/**
 * PRD Business Logic ServiceCommand<br>
 * handling business transaction of PRD<br>
 * @author jungsunyong
 * @see reter to ESD_PRD_004EventResponse,HubLocationMatchingManageDBDAO
 * @since J2EE 1.4
 */
public class NetworkLinkManageSC extends ServiceCommandSupport {

	private SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario - PRD<br>
	 * related objects creation<br>
	 */
	@Override
	public void doStart() {
		try {
			account = getSignOnUserAccount();
			if (account.getUsr_id() == null) {
				throw new RuntimeException();
			}
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
	}

	/**
	 * biz scenario closing - PRD<br>
	 * clearing related objects<br>
	 */
	@Override
	public void doEnd() {
		log.debug("NetworkLinkManageSC End");
	}

	/**
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsdPRD0004Event")) {
			/*
			 * HubLocation Matching Manage
			 */
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchHubLocationMatchingManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiHubLocationMatchingManage(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0005Event")) {
			/*
			 * Inland Route Manage
			 */
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // retrieving mst
				eventResponse = this.searchInlandRouteManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // saving mst
				eventResponse = this.multiInlandRouteManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // retrieving detail
				eventResponse = this.searchInlandRouteManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = this.rowSearchInlandRouteManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = this.searchPrioSeq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // retrieving Country
				eventResponse = this.searchCntOfContiUSA(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = this.multi01InlandRouteManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = this.saveAsInlandRouteManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = this.getReferenceNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Inland Route Inquiry ( ESD_PRD_0055 ) -Retrieving
				eventResponse = this.searchInlandRouteManageList01(e);
			}
			/*
			 * Inland Route Manage Empty IRG
			 */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0056Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // retrieving mst
				eventResponse = this.searchEmptyInlandRouteManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // retrieving detail
				eventResponse = this.searchEmptyInlandRouteManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // retrieving Country
				eventResponse = this.searchCntOfContiUSA(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // retrieving mst
				eventResponse = this.multiEmptyInlandRouteManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = this.multi01EmptyInlandRouteManage(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0009Event")) {
			/*
			 * Inland Link Manage
			 */
			EsdPrd0009Event event = (EsdPrd0009Event) e;
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = this.searchInlandLinkManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiInlandLinkManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { // agmt
				eventResponse = this.multiAgmtNo(event);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0007Event")) {
			/*
			 * Inland Route Manage - Link List
			 */
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = this.searchInlandLinkManagePopup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiInlandLinkManagePopup(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0011Event")) {
			/*
			 * Ocean Route Condition Manage - Carrier
			 */
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
			/* Node Constraint */
		} else if (e.getEventName().equalsIgnoreCase("ESD_PRD_022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchNodeConstraintList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiNodeConstraint(e);
			}

			/* Link Constraint */
		} else if (e.getEventName().equalsIgnoreCase("ESD_PRD_023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchLinkConstraintList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiLinkConstraint(e);
			}

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
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = this.searchHubConstraintList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = this.multiHubConstraint(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12) || e.getFormCommand().isCommand(FormCommand.SEARCH13) || e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = this.searchContainerTypeSize(e);
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
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = this.searchSameOceanRoute(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = this.searchOceanRouteSingleCreation(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchVslConnBufferTimeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiVslConnBufferTime(e);
			}
		}
		return eventResponse;
	}

	/**
	 * NetworkLinkManageSC's multiCallingTmlMtxExptList
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse multiCallingTmlMtxExptList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0041Event event = (EsdPrd0041Event) e;
		OceanRouteConditionManageBC command = new OceanRouteConditionManageBCImpl();
		try {
			begin();
			command.multiCallingTmlMtxExptList(event.getSearchCallingTmlMtxExptVOs(), account);
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
	 * checking duplication of inserted rows - Multi Creation
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOceanRouteMultiCreationList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0060Event event = (EsdPrd0060Event) e;
		OceanRouteManageBC command = new OceanRouteManageBCImpl();

		try {
			List<SearchOceanRouteMultiCreationVO> list = command.searchOceanRouteMultiCreationList(event.getSearchOceanRouteMultiCreationVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * saving NetworkLinkManageSC's multiAgmtNo Agmt No. and IRG which has the Agmt No.
	 * @param e
	 * @param models
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse multiAgmtNo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0009Event event = (EsdPrd0009Event) e;
		InlandLinkManageBC command = new InlandLinkManageBCImpl();
		try {
			begin();

			List<PrdInlndEachLnkVO> list = command.multiAgmtNo(event.getPrdInlndEachLnkVOs(), account);
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("validAgmtNoRoute", list.get(list.size() - 1).getValidAgmtNoRoute());
			eventResponse.setETCData("validUpdateRoute", list.get(list.size() - 1).getValidUpdateRoute());
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
	 * NetworkLinkManageSC's searchEmptyInlandRouteManageList
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEmptyInlandRouteManageList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0056Event event = (EsdPrd0056Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();
		try {
			List<SearchEmptyInlandRouteMasterListVO> list = command.searchEmptyInlandRouteManageList(event.getSearchConditionVO());
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
	 * @param e
	 * @return
	 * @throws EventException EventResponse
	 */
	private EventResponse getReferenceNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0005Event event = (EsdPrd0005Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();

		try {
			List<GetReferenceNoVO> list = command.getReferenceNo(event.getGetReferenceNoVO());
			eventResponse.setRsVoList(list);

			eventResponse.setETCData("rowCount", list.size() + "");
			if (list.size() > 0) {
				eventResponse.setETCData("trs_vndr_seq", list.get(list.size() - 1).getVndrSeq());
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
	 * @param e
	 * @return
	 * @throws EventException EventResponse
	 */
	private EventResponse searchOceanLane(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			List<SearchOceanLaneVO> list = null;
			OceanRouteManageBC command = new OceanRouteManageBCImpl();
			if (e.getEventName().equals("EsdPrd0035Event")) {
				EsdPrd0035Event event = (EsdPrd0035Event) e;
				list = command.searchOceanLane(event.getSearchOceanLaneVO(), event.getEventName());
			} else {
				EsdPrd0040Event event = (EsdPrd0040Event) e;
				list = command.searchOceanLane(event.getSearchOceanLaneVO(), event.getEventName());
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
	 * handling retrieve event<br>
	 * handling InlandRouteManage의 route prio seq<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPrioSeq(Event e) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0005Event event = (EsdPrd0005Event) e;

		try {
			InlandRouteManageBC command = new InlandRouteManageBCImpl();
			String str = command.searchPrioSeq(event.getInlandRouteMsUSVO());
			eventResponse.setETCData(str, str);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * handling retrieve event<br>
	 * retrieving list of HubLocationMatchingManage<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHubLocationMatchingManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0004Event event = (EsdPrd0004Event) e;

		try {
			HubLocationMatchingManageBC command = new HubLocationMatchingManageBCImpl();
			List<SearchHubLocationListVO> list = command.searchHubLocationMatchingManage(event.getSearchHubLocationListVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * handling multi event<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiHubLocationMatchingManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0004Event event = (EsdPrd0004Event) e;
		HubLocationMatchingManageBC command = new HubLocationMatchingManageBCImpl();
		try {
			begin();
			command.multiHubLocationMatchingManage(event.getSearchHubLocationListVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
			List<SearchHubLocationListVO> list = command.searchHubLocationMatchingManage(event.getSearchHubLocationListVO());
			if (CollectionUtils.isEmpty(list)) {
				SearchHubLocationListVO[] ss = event.getSearchHubLocationListVOs();
				List<SearchHubLocationListVO> l = new ArrayList<SearchHubLocationListVO>();
				for (int i = 0; i < ss.length; i++) {
					l.add(ss[i]);
				}
				eventResponse.setRsVoList(l);
			} else {
				eventResponse.setRsVoList(list);
			}
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
	 * handling retrieve event<br>
	 * InlandRouteManage screen<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRouteManageList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0005Event event = (EsdPrd0005Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();

		try {
			List<SearchInlandRouteManageAsiaEuVO> list = command.searchInlandRouteManageList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);

			StringBuilder comboArg = new StringBuilder();
			int maxPrioSeq = 0;

			if (list.size() > 0) {
				maxPrioSeq = Integer.parseInt(list.get(0).getMaxPrioSeq());
			}
			if (maxPrioSeq < list.size()) {
				for (int i = 0; i <= list.size(); i++) {
					comboArg.append(i).append("|");
				}
			} else {
				for (int i = 0; i <= maxPrioSeq; i++) {
					comboArg.append(i).append("|");
				}
			}
			eventResponse.setETCData("prio_seq_combo", comboArg.toString());
			eventResponse.setETCData("maxPrioSeq", maxPrioSeq + "");
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * handling retrieve event<br>
	 * retrieving master - InlandRouteManage screen<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRouteManageList01(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0005Event event = (EsdPrd0005Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();
		try {
			List<InlandRouteVO> list = command.searchInlandRouteManageList01(event.getInlandRouteVO());
			eventResponse.setRsVoList(list);
			StringBuilder comboArg = new StringBuilder();
			int maxPrioSeq = 0;
			for (int i = 0; i < list.size(); i++) {
				InlandRouteVO itm = (InlandRouteVO) list.get(i);
				comboArg.append(itm.getPrioSeq()).append("|");
				maxPrioSeq = Integer.parseInt(itm.getPrioSeq());
			}
			if (maxPrioSeq < list.size()) {
				int gap = list.size() - maxPrioSeq;
				for (int i = 1; i <= gap; i++) {
					comboArg.append(maxPrioSeq + 1).append("|");
				}
			}
			eventResponse.setETCData("prio_seq_combo", comboArg.toString());
			eventResponse.setETCData("maxPrioSeq", maxPrioSeq + "");
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * handling retrieve event<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRouteManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0005Event event = (EsdPrd0005Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();
		try {
			List<InlandRouteDetVO> list = command.searchInlandRouteManage(event.getInlandRouteDetVO());
			if (list.size() > 0) {
				InlandRouteDetVO itm = (InlandRouteDetVO) list.get(0);
				eventResponse.setETCData("i_inv", JSPUtil.getNull(itm.getInlndRoutInvBilPattCd()));
				eventResponse.setETCData("i_rout_pln_cd", JSPUtil.getNull(itm.getRoutPlnCd()));
				eventResponse.setETCData("i_route_rmk", JSPUtil.getNull(itm.getInlndRoutRmk()));
				eventResponse.setETCData("i_wrs_fl_cd", JSPUtil.getNull(itm.getWrsFullCmdtCd()));
				eventResponse.setETCData("i_wrs_mt_cd", JSPUtil.getNull(itm.getWrsMtyCmdtCd()));
				eventResponse.setETCData("disable_bkg_flg", JSPUtil.getNull(itm.getCc()));
				eventResponse.setETCData("i_bkg_flg", JSPUtil.getNull(itm.getInlndRoutBkgFlg()).equals("Y") ? JSPUtil.getNull(itm.getInlndRoutBkgFlg()) : "");
				eventResponse.setETCData("i_mcntr_rout_flg", JSPUtil.getNull(itm.getMcntrRoutFlg()).equals("Y") ? JSPUtil.getNull(itm.getMcntrRoutFlg()) : "");
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
	 * retrieving EmptyInlandRoute DETAIL
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchEmptyInlandRouteManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0056Event event = (EsdPrd0056Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();

		try {
			List<InlandRouteDetVO> list = command.searchEmptyInlandRouteManage(event.getInlandRouteDetVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * handling retrieve event<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse rowSearchInlandRouteManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0005Event event = (EsdPrd0005Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();

		try {
			List<RowSearchInlandRouteManageVO> list = command.rowSearchInlandRouteManage(event.getRowSearchInlandRouteManageVO());
			log.debug("★★★::::" + event.getRowSearchInlandRouteManageVO().getRow());
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
	 * handling multi event<br>
	 * InlandRouteManage<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiInlandRouteManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0005Event event = (EsdPrd0005Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();
		try {
			begin();
			command.multiInlandRouteManage(event.getSearchInlandRouteManageAsiaEuVOs(), event.getSearchConditionVO().getIDelFlg(), account);
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
	 * multiEmptyInlandRoute
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiEmptyInlandRouteManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0056Event event = (EsdPrd0056Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();
		try {
			begin();
			command.multiEmptyInlandRouteManage(event.getEmptySaveInlandRouteMstVOs(), account, event.getSearchConditionVO().getIDelFlg());
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
	 * handling multi event<br>
	 * InlandRouteManage<br>
	 * saving detail of PRD_005
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multi01InlandRouteManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0005Event event = (EsdPrd0005Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();
		String errMsg = "";
		try {
			DBRowSet dbRowSet = command.getInLandRouteExistCount(event.getInlandRouteMsUSVO(), event.getInlandRouteUSDetVOs());
			DBRowSet s = (DBRowSet) dbRowSet.clone();
			event.getInlandRouteMsUSVO().setNodTpCd2(event.getInlandRouteMsUSVO().getNodTpCd1());
			int j = 0;
			if (dbRowSet.getRowCount() > 0) {
				while (dbRowSet.next()) {
					String delt_flg = dbRowSet.getString("delt_flg");
					if ("N".equals(delt_flg)) {
						j++;
						break;
					}
				}
				if (j > 0) {
					int remRet = command.getInLandRouteRemarkCompare(event.getInlandRouteMsUSVO());
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
					while (s.next()) {
						String delt_flg = s.getString("delt_flg");
						if ("Y".equals(delt_flg)) {
							InlandRouteMsUSVO vo = new InlandRouteMsUSVO();
							vo.setIRoutOrgNodCd(s.getString("ROUT_ORG_NOD_CD"));
							vo.setIRoutDestNodCd(s.getString("ROUT_DEST_NOD_CD"));
							vo.setIRoutSeq(s.getString("ROUT_SEQ"));
							vo.setUpdUsrId(account.getUsr_id());
							begin();
							command.updatePrdInlndRoutMst(vo);
							commit();
						}
					}
				}
			} else {
				begin();
				// String newRoutSeq = command.multi01InlandRouteManage(event.getInlandRouteUSDetVOs(), event.getInlandRouteMsUSVO(), account);
				command.multi01InlandRouteManage(event.getInlandRouteUSDetVOs(), event.getInlandRouteMsUSVO(), account);
				eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
				commit();
			}

			eventResponse.setRsVoList(command.rowSearchMaster(event.getInlandRouteMsUSVO()));

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
	private EventResponse multi01EmptyInlandRouteManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0056Event event = (EsdPrd0056Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();
		try {
			DBRowSet dbRowSet = command.getEmptyInLandRouteExistCount(event.getEmptySaveInlandRouteDetVOs(), event.getEmptySaveInlandRouteDetVO());
			DBRowSet s = (DBRowSet) dbRowSet.clone();
			int j = 0;
			if (dbRowSet.getRowCount() > 0) {
				while (dbRowSet.next()) {
					if ("N".equals(dbRowSet.getString("delt_flg"))) {
						j++;
						break;
					}
				}
				if (j > 0) {
					InlandRouteMsUSVO inlandRouteMsUSVO = new InlandRouteMsUSVO();
					inlandRouteMsUSVO.setIRoutOrgNodCd(event.getEmptySaveInlandRouteDetVO().getIRoutOrgNodCd());
					inlandRouteMsUSVO.setIRoutDestNodCd(event.getEmptySaveInlandRouteDetVO().getIRoutDestNodCd());
					inlandRouteMsUSVO.setIRoutSeq(event.getEmptySaveInlandRouteDetVO().getIRoutSeq());
					inlandRouteMsUSVO.setIRouteRmk(event.getEmptySaveInlandRouteDetVO().getIRouteRmk());
					int remRet = command.getInLandRouteRemarkCompare(inlandRouteMsUSVO);
					if (remRet > 0) {
						begin();
						command.updateEmptyRemark(event.getEmptySaveInlandRouteDetVO());
						commit();
					} else {
						eventResponse.setETCData("strErrMsg", "Exist Inland route.");
						return eventResponse;
					}
				} else {
					while (s.next()) {
						String delt_flg = s.getString("delt_flg");
						if ("Y".equals(delt_flg)) {
							InlandRouteMsUSVO vo = new InlandRouteMsUSVO();
							vo.setIRoutOrgNodCd(s.getString("ROUT_ORG_NOD_CD"));
							vo.setIRoutDestNodCd(s.getString("ROUT_DEST_NOD_CD"));
							vo.setIRoutSeq(s.getString("ROUT_SEQ"));
							vo.setUpdUsrId(account.getUsr_id());
							begin();
							command.updatePrdInlndRoutMst(vo);
							commit();
						}
					}
				}
			} else {
				begin();
				command.multi01EmptyInlandRouteManage(event.getEmptySaveInlandRouteDetVOs(), event.getEmptySaveInlandRouteDetVO(), account);
				commit();
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return this.rowSearchEmptyMaster(e);
	}

	/**
	 * NetworkLinkManageSC's saveAsInlandRouteManage
	 * @param e
	 * @return
	 * @throws EventException EventResponse
	 */
	private EventResponse saveAsInlandRouteManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0005Event event = (EsdPrd0005Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();
		String errMsg = "";
		try {
			DBRowSet dbRowSet = command.getInLandRouteExistCount(event.getInlandRouteMsUSVO(), event.getInlandRouteUSDetVOs());
			DBRowSet s = (DBRowSet) dbRowSet.clone();
			int j = 0;
			if (dbRowSet.getRowCount() > 0) {
				while (dbRowSet.next()) {
					String delt_flg = dbRowSet.getString("delt_flg");
					if ("N".equals(delt_flg)) {
						j++;
						break;
					}
				}
				if (j > 0) {
					int remRet = command.getInLandRouteRemarkCompare(event.getInlandRouteMsUSVO());
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
					while (s.next()) {
						String delt_flg = s.getString("delt_flg");
						if ("Y".equals(delt_flg)) {
							InlandRouteMsUSVO vo = new InlandRouteMsUSVO();
							vo.setIRoutOrgNodCd(s.getString("ROUT_ORG_NOD_CD"));
							vo.setIRoutDestNodCd(s.getString("ROUT_DEST_NOD_CD"));
							vo.setIRoutSeq(s.getString("ROUT_SEQ"));
							vo.setUpdUsrId(account.getUsr_id());
							begin();
							command.updatePrdInlndRoutMst(vo);
							commit();
						}
					}
				}
			} else {
				event.getInlandRouteMsUSVO().setNodTpCd2(event.getInlandRouteMsUSVO().getNodTpCd1());
				begin();
				String newRoutSeq = command.saveAsInlandRouteManage(event.getInlandRouteUSDetVOs(), event.getInlandRouteMsUSVO(), account);
				event.getInlandRouteMsUSVO().setIRoutSeq(newRoutSeq);
				eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());

				commit();

			}
			eventResponse.setRsVoList(command.rowSearchMaster(event.getInlandRouteMsUSVO()));
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
	private EventResponse rowSearchEmptyMaster(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0056Event event = (EsdPrd0056Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();

		try {
			List<RowSearchEmptyMasterVO> list = command.rowSearchEmptyMaster(event.getEmptySaveInlandRouteDetVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * handling retrieve event<br>
	 * InlandLinkManage<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandLinkManageList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0009Event event = (EsdPrd0009Event) e;
		InlandLinkManageBC command = new InlandLinkManageBCImpl();

		try {
			List<PrdInlndEachLnkVO> list = command.searchInlandLinkManageList(event.getPrdInlndEachLnkVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * handling retrieve event<br>
	 * InlandLinkManage<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandLinkManagePopup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0007Event event = (EsdPrd0007Event) e;
		InlandLinkManageBC command = new InlandLinkManageBCImpl();

		try {
			List<SearchInlandLinkManageListVO> list = command.searchInlandLinkManagePopup(event.getSearchInlandLinkManageListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * handling multi event<br>
	 * InlandLinkManage<br>
	 * using at 007 screen(pop up)
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */

	private EventResponse multiInlandLinkManagePopup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0007Event event = (EsdPrd0007Event) e;
		InlandLinkManageBC command = new InlandLinkManageBCImpl();
		try {
			begin();

			Map<String, String> etcData = command.multiInlandLinkManage(event.getSearchInlandLinkManageListVOs(), account);
			eventResponse.setETCData(etcData);
			List<SearchInlandLinkManageListVO> list = command.searchInlandLinkManagePopup(event.getSearchInlandLinkManageListVO());
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
	 * @param event
	 * @param models
	 * @param sa
	 * @return
	 * @throws EventException EventResponse
	 */
	private EventResponse multiInlandLinkManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0009Event event = (EsdPrd0009Event) e;
		InlandLinkManageBC command = new InlandLinkManageBCImpl();
		try {
			begin();
			Map<String, String> etcData = command.multiInlandLinkManage(event.getSearchInlandLinkManageListVOs(), account);
			eventResponse.setETCData(etcData);
			if (!CheckUtilities.isInBlank(String.valueOf(etcData.get("pseudoCd"))) || !CheckUtilities.isInBlank(String.valueOf(etcData.get("blankCd")))
					|| !CheckUtilities.isInBlank(String.valueOf(etcData.get("invalidVendorCd")))) {
				SearchInlandLinkManageListVO[] ss = event.getSearchInlandLinkManageListVOs();
				List<SearchInlandLinkManageListVO> l = new ArrayList<SearchInlandLinkManageListVO>();
				for (int i = 0; i < ss.length; i++) {
					l.add(ss[i]);
				}
				eventResponse.setRsVoList(l);
			} else {
				List<PrdInlndEachLnkVO> list = command.searchInlandLinkManageList(event.getPrdInlndEachLnkVO());
				eventResponse.setRsVoList(list);
			}
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
	 * handling retrieve event<br>
	 * OceanRouteConditionManage carrier<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOceanRouteConditionManageList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0011Event event = (EsdPrd0011Event) e;
		OceanRouteConditionManageBC command = new OceanRouteConditionManageBCImpl();

		try {
			List<SearchOceanRouteConditionVO> list = command.searchOceanRouteConditionManageList(event.getSearchOceanRouteConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * NetworkLinkManageSC's searchCallingTmlMtxExptList
	 * @param e
	 * @return
	 * @throws EventException EventResponse
	 */
	private EventResponse searchCallingTmlMtxExptList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0041Event event = (EsdPrd0041Event) e;
		OceanRouteConditionManageBC command = new OceanRouteConditionManageBCImpl();

		try {
			List<SearchCallingTmlMtxExptVO> list = command.searchCallingTmlMtxExptList(event.getSearchCallingTmlMtxExptVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * handling multi event<br>
	 * OceanRouteConditionManage carrier<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiOceanRouteConditionManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0011Event event = (EsdPrd0011Event) e;
		OceanRouteConditionManageBC command = new OceanRouteConditionManageBCImpl();
		try {
			begin();
			command.multiOceanRouteConditionManage(event.getSearchOceanRouteConditionVOs(), account);
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
	 * handling retrieve event<br>
	 * OceanRouteConditionManage Embargo<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEmbargoManageList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0010Event event = (EsdPrd0010Event) e;
		OceanRouteConditionManageBC command = new OceanRouteConditionManageBCImpl();

		try {
			List<SearchEmbargoVO> list = command.searchEmbargoManageList(event.getSearchEmbargoVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * handling multi event<br>
	 * OceanRouteConditionManage Embargo<br>
	 * @param e Event
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
	 * handling retrieve event<br>
	 * OceanLinkManage<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOceanLinkHQ(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0012Event event = (EsdPrd0012Event) e;
		OceanLinkManageBC command = new OceanLinkManageBCImpl();

		try {
			List<SearchOceanLinkVO> list = command.searchOceanLinkList(event.getSearchOceanLinkVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * handling modify event<br>
	 * OceanLinkManage<br>
	 * @param e Event
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
	 * handling modify event<br>
	 * OceanLinkManage<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchOceanLinkHQJobEnd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0012Event event = (EsdPrd0012Event) e;
		OceanLinkManageBC command = new OceanLinkManageBCImpl();
		try {
			String backEndJobKey = event.getSearchOceanLinkVO().getBackEndJobKey();
			// checking whether Back end job is finished or not.
			BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(backEndJobKey);

			DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
			List<ComBakEndJbVO> dbRowSetlist = (List) RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);

			ComBakEndJbVO jobVo = new ComBakEndJbVO();

			if (dbRowSetlist.size() == 0) {
				// to avoid error of Background job framework
				jobVo.setJbStsFlg("0");
			} else {
				jobVo = (ComBakEndJbVO) dbRowSetlist.get(0);
			}

			eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
			if (jobVo.getJbStsFlg().equals("3")) {
				// retrieving when Back end job is finished
				List<SearchOceanLinkVO> list = command.searchOceanLinkList(event.getSearchOceanLinkVO());
				eventResponse.setRsVoList(list);
				eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
			}

		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * RHQ Ocean Link Management
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOceanLinkListRHQ(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0013Event event = (EsdPrd0013Event) e;
		OceanLinkManageBC command = new OceanLinkManageBCImpl();

		try {
			List<SearchOceanLinkRHQVO> list = command.searchOceanLinkListRHQ(event.getSearchOceanLinkRHQVO());
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
		// GeneralEventResponse eventResponse = new GeneralEventResponse();
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
			List<SearchOceanRouteListVO> list = command.searchOceanRouteList(event.getSearchConditionVO());
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
			List<SearchOceanRouteListVO> list = command.searchOceanRouteList(event.getSearchConditionVO());
			eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
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
			eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
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
	private EventResponse searchNodeConstraintList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0024Event event = (EsdPrd0024Event) e;
		ConstraintManageBC command = new ConstraintManageBCImpl();

		try {
			List<SearchNodeConstraintVO> list = command.searchNodeConstraintList(event.getConstraintVO());
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
			command.multiNodeConstraint(event.getSearchNodeConstraintVOs(), account);
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
	private EventResponse searchLinkConstraintList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0024Event event = (EsdPrd0024Event) e;
		ConstraintManageBC command = new ConstraintManageBCImpl();

		try {
			List<SearchLinkConstraintVO> list = command.searchLinkConstraintList(event.getConstraintVO());
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
			command.multiLinkConstraint(event.getSearchLinkConstraintVOs(), account);
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
	private EventResponse searchRouteConstraintList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0024Event event = (EsdPrd0024Event) e;
		ConstraintManageBC command = new ConstraintManageBCImpl();
		try {
			List<SearchRouteConstraintVO> list = command.searchRouteConstraintList(event.getConstraintVO());
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
			command.multiRouteConstraint(event.getSearchRouteConstraintVOs(), account);
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
	private EventResponse searchHubConstraintList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0024Event event = (EsdPrd0024Event) e;
		ConstraintManageBC command = new ConstraintManageBCImpl();
		try {
			eventResponse.setRsVoList(command.searchHubConstraintList(event.getConstraintVO()));
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
	private EventResponse multiHubConstraint(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0024Event event = (EsdPrd0024Event) e;
		ConstraintManageBC command = new ConstraintManageBCImpl();
		try {
			begin();
			command.multiHubConstraint(event.getSearchHubConstraintListVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOceanRouteAutoCreationList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0032Event event = (EsdPrd0032Event) e;
		OceanRouteManageBC command = new OceanRouteManageBCImpl();

		try {
			List<SearchOceanRouteAutoCreationVO> list = command.searchOceanRouteAutoCreationList(event.getSearchOceanRouteAutoCreationVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * handling retrieve event<br>
	 * InlandRouteManage<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse rowSearchOceanRouteManage(Event e) throws EventException {
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

	/**
	 * handling retrieve event<br>
	 * ESD_PRD_0016<br>
	 * @param SaveOceanRouteVO saveOceanRouteVO
	 * @throws EventException
	 */
	private EventResponse searchSameOceanRoute(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0060Event event = (EsdPrd0060Event) e;
		OceanRouteManageBC command = new OceanRouteManageBCImpl();

		try {
			String dupFlag = command.searchSameOceanRoute(event.getSaveOceanRouteVO());
			eventResponse.setETCData("dup_flag", dupFlag);
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
			List<CheckCommodityVO> list = command.checkCommodity(event.getCheckCommodityVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
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
		StringBuilder cntCd = new StringBuilder();
		try {
			cntCdArray = command.searchCntOfConti("M");
			if (cntCdArray != null) {
				for (int idx = 0; idx < cntCdArray.length; idx++) {
					cntCd.append(cntCdArray[idx].toString()).append("|");
				}
			}
			eventResponse.setETCData("cnt_cd", cntCd.toString());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * Ocean Route Creation - Validation Check of Multi Creation<br>
	 * ESD_PRD_0060<br>
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
	private EventResponse searchVslConnBufferTimeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0037Event event = (EsdPrd0037Event) e;
		VslConnBufferTimeBC command = new VslConnBufferTimeBCImpl();
		try {
			eventResponse.setRsVoList(command.searchVslConnBufferTimeList(event.getVslConnBufferTimeListVO()));
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
	private EventResponse multiVslConnBufferTime(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0037Event event = (EsdPrd0037Event) e;
		VslConnBufferTimeBC command = new VslConnBufferTimeBCImpl();
		try {
			command.multiVslConnBufferTime(event.getVslConnBufferTimeListVOs(), account);
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
	private EventResponse searchContainerTypeSize(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0024Event event = (EsdPrd0024Event) e;
		ConstraintManageBC command = new ConstraintManageBCImpl();
		try {
			eventResponse.setRs(command.searchContainerTypeSize(event.getConstraintVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
}
