/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailSoManageSC.java
*@FileTitle : USA Rail Billing S/O를 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-23
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-11-23 kim_sang_geun
* 1.0 최초 생성
* -------------------------------------------------------
* history
* 2011.07.20 김영철 [CHM-201111871] [TRS] R4J 소스 품질 조치 내역 수정
* 2012.01.16 금병주 [CHM-201215713] [TRS] S/O 다중작업에 의한 COP status 오류 방지로직 추가요청 (US rail)
* 2012.04.12 김인수 [CHM-201216040] [TRS] US rail S/O 에 대한 S/O history function 연결 요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
//import com.hanjin.syscommon.common.table.CoaBkgComIfVO;
import com.hanjin.syscommon.common.table.TrsTrspRailBilOrdVO;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBCImpl;
import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBC;
import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBCImpl;
import com.hanjin.apps.alps.esd.trs.common.trscommon.vo.TrsSOHistoryVO;
import com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.event.EsdTrs0201Event;
import com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.basic.RailSoManageBC;
import com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.basic.RailSoManageBCImpl;
//import com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
//import com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.apps.alps.esd.trs.common.util.CommonUtil;
/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS에 대한 비지니스 트랜잭션을 처리한다.<br>
 *
 * @author kim_sang_geun
 * @see ESD_TRS_029EventResponse,RailSoManageDBDAO 참조
 * @since J2EE 1.4
 */
public class RailSoManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	private String sofficeCd = "";
	private String userId = ""; 

	/**
	 * TRS 업무 시나리오 선행작업<br>
	 * RailSoManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
			sofficeCd = account.getOfc_cd();
			userId = account.getUsr_id();
		} catch (Exception e) {
			log.error("RailSoManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * RailSoManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("RailSoManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ESD-TRS 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분		
		if (e.getEventName().equalsIgnoreCase("EsdTrs0201Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {       //ESD_TRS_0928 조회
				eventResponse = search04RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) { //Request Service Provider Inquiry 956
				eventResponse = search13RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) { //ESD_TRS_0928 조회 AND ESD_TRS_0953 조회
				eventResponse = searchIrgCandidate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { //ESD_TRS_204 Correction 조회
				eventResponse = searchRailSoCorrectionTargetList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) { //ESD_TRS_204 Delete
				eventResponse = removeRailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) { //ESD_TRS_204 Plan Delete(Delete Button)
				eventResponse = removeEmptyRepoPlanForRail(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) { //ESD_TRS_204 Correction
				eventResponse = modifyRailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) { //ESD_TRS_203(Empty Repo) 조회
				eventResponse = search08RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) { //ESD_TRS_203(Empty Repo) 하위 sheet 조회
				eventResponse = search09RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //Cancel REQ Reject 959
				eventResponse = multi01RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) { //ESD_TRS_203 Verify 체크 조회
				eventResponse = search11RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { //ESD_TRS_203 Empty S/O Creation
				eventResponse = multi02RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //ESD_TRS_201 In Bound Verify
				eventResponse = search02RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //SO Creation 저장
				eventResponse = multiRailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { //SO Candidate 저장
				eventResponse = multiRailSoCandidate(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) { //ESD_TRS_202 Out Bound Verify
				eventResponse = search07RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) { //ESD_TRS_202(COP) 조회 Out Bound
				eventResponse = searchRailsoBybkgcntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //ESD_TRS_201(COP) 조회 In Bound
				eventResponse = search01RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) { //ESD_TRS_202(COP) 조회 Out Bound
				eventResponse = search06RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) { //ESD_TRS_203 EQ Verify 체크 조회
				eventResponse = search14RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)){ //ESD_TRS_204 SO delete Verify 체크 조회
				eventResponse = verifyRailSoManageDeltChk(e);
			} else {
				eventResponse = null;
			}
		}
		
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * COP In Bound<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search01RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체		
		EventResponse eventResponse = null;
		
		List<TrsTrspRailBilOrdVO> trsTrspRailBilOrdVO = new ArrayList<TrsTrspRailBilOrdVO>();
		
		String lSeq = "";

		try {
			RailSoManageBC command = new RailSoManageBCImpl();
			
			trsTrspRailBilOrdVO = command.search01RailSoManageSel(event);
			
			lSeq = command.search01RailSoManageSeq();
			
			begin();
			command.search01RailSoManageIns(trsTrspRailBilOrdVO, lSeq, event.getUserid());
			commit();
			
			begin();
			command.search01RailSoManageUpd(lSeq);
			commit();
			
			eventResponse = command.search01RailSoManage(lSeq);
			
			begin();
			command.search01RailSoManageDel(lSeq);
			commit();			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} 
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * COP Out Bound<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search06RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		List<TrsTrspRailBilOrdVO> trsTrspRailBilOrdVO = new ArrayList<TrsTrspRailBilOrdVO>();
		
		String lSeq = "";

		try {
			RailSoManageBC command = new RailSoManageBCImpl();
			
			trsTrspRailBilOrdVO = command.search06RailSoManageSel(event);
			
			lSeq = command.search01RailSoManageSeq();
			
			begin();
			command.search06RailSoManageIns(trsTrspRailBilOrdVO, lSeq, event.getUserid());
			commit();
			
			begin();
			command.search06RailSoManageUpd(lSeq);
			commit();
			
			eventResponse = command.search06RailSoManage(lSeq);
			
			begin();
			command.search06RailSoManageDel(lSeq);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} 
		return eventResponse;
	}

		
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * COP Out Bound<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRailsoBybkgcntr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			RailSoManageBC command = new RailSoManageBCImpl();
			eventResponse = command.searchRailsoBybkgcntr(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} 
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * Empty Repo<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search08RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			RailSoManageBC command = new RailSoManageBCImpl();
			eventResponse = command.search08RailSoManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * Empty Repo<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search09RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			RailSoManageBC command = new RailSoManageBCImpl();
			eventResponse = command.search09RailSoManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * Correction<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRailSoCorrectionTargetList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			RailSoManageBC command = new RailSoManageBCImpl();
			eventResponse = command.searchRailSoCorrectionTargetList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * Empty Verify Check<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search11RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			RailSoManageBC command = new RailSoManageBCImpl();
			eventResponse = command.search11RailSoManage(sofficeCd, event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * Request Service Provider Inquiry Popup<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search13RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			RailSoManageBC command = new RailSoManageBCImpl();
			eventResponse = command.search13RailSoManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * Request Empty Container Check<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search14RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			RailSoManageBC command = new RailSoManageBCImpl();
			eventResponse = command.search14RailSoManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage의 event에 대한 IN BOUND 특정 리스트 조회 이벤트 처리<br>
	 * Verify<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search02RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			RailSoManageBC command = new RailSoManageBCImpl();
			eventResponse = command.search02RailSoManage(sofficeCd, event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search04RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			RailSoManageBC command = new RailSoManageBCImpl();
			eventResponse = command.search04RailSoManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * Possible Candidates For IRG Adjust<br>
	 * @param e Event 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrgCandidate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			RailSoManageBC command = new RailSoManageBCImpl();
			eventResponse = command.searchIrgCandidate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * Verify<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search07RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			RailSoManageBC command = new RailSoManageBCImpl();
			eventResponse = command.search07RailSoManage(sofficeCd, event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 수정 이벤트 처리<br>
	 * RailSoManageForNoTranjection의 event에 대한 수정 이벤트 처리<br>
	 * US Rail Billing - Correction
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyRailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		EventResponse eventResponse = null;
		RailSoManageBC command = new RailSoManageBCImpl();
		
		try {
		
			String frmNod = null;
			String toNod = null;
			String orgFrmNod = null;
			String orgToNod = null;
			String localUserId = event.getSignOnUserAccount().getUsr_id();
			String trsp_so_ofc_cty_cd = null;
			String trsp_so_seq        = null;
			
			//COP Replan을 위해 
			ReplanManageBC replanManageBC = new ReplanManageBCImpl();//BC생성
			TrsTrspRailBilOrdVO[] svcModels = event.getTrsTrspRailBilOrdVos();			
			TrsCommonBC commCommand =  new TrsCommonBCImpl();
			
			// COA 중복 호출 구분자 
			for(int i=0; i<svcModels.length-1; i++){
				for(int j=i+1; j<svcModels.length; j++){
					if( svcModels[j].getBkgNo().equals(svcModels[i].getBkgNo()) ){
						svcModels[j].setN3ptyBilFlg("Y");
					}
				}
			}
			
			for(int k=0; event.getTrsTrspRailBilOrdVos()!= null &&  k<event.getTrsTrspRailBilOrdVos().length; k++){
				begin();
				eventResponse = command.modifyRailSoManage(event, k);
				command.multiProcRailSoManageForWRS(event, k, eventResponse.getCustomData(), event.getSctrlOfcCd()); // Procedure Call

				frmNod = svcModels[k].getFmNodCd() + svcModels[k].getFmNodYard();
				toNod = svcModels[k].getToNodCd() + svcModels[k].getToNodYard();
				orgFrmNod  = svcModels[k].getOrgFmNodCd() + svcModels[k].getOrgFmNodYard();
				orgToNod = svcModels[k].getOrgToNodCd()+svcModels[k].getOrgToNodYard();
				trsp_so_ofc_cty_cd = svcModels[k].getTrspSoOfcCtyCd();
				trsp_so_seq = svcModels[k].getTrspSoSeq();
				
				TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();
				
				if (!frmNod.equals(orgFrmNod) || !toNod.equals(orgToNod))
				{
					if (svcModels[k].getCgoTpCd().equals("F")) {
						if( !svcModels[k].getN3ptyBilFlg().equals("Y") ){
							//COA I/F
//							CostAssignBC coaCommand = new CostAssignBCImpl();
//							CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
//							coaBkgComIfVo.setBkgNo(svcModels[k].getBkgNo());
//							coaBkgComIfVo.setCostSrcSysCd("TRS");//TRS, TES, SCE, BKG등 SUB SYSTEM CODE
//							coaBkgComIfVo.setIfRmk("US RAIL S/O Mofify");
//							coaBkgComIfVo.setCreUsrId(localUserId);
//							coaBkgComIfVo.setUpdUsrId(localUserId);
//
//							int result_cnt = coaCommand.modifyCoaCommonInterface(coaBkgComIfVo);
//							if (result_cnt < 0)
//								throw new EventException((new ErrorHandler("SAQ00099",new String[]{"COA I/F Error"})).getMessage());
							
							//MAS I/F [CHM-201534153] 관리회계개선 프로젝트 1단계 Pre CM/OP Simulation Live 반영 요청
							CommonUtil.modifyMasCommonInterface(svcModels[k].getBkgNo(),"US RAIL S/O Mofify",localUserId);	
						}
						
						svcModels[k].setTrspSoStsCd("R");
						
						//COP Replan
						replanManageBC.replanCop(svcModels[k]);
						
						//SO Creation 전에  IRG Adjust 한 경우 이전 경로정보를 history에 저장. 

						//soHisVo.setCopPlnRoutDesc("("+crr_mod2+") "+frm_nod2+"-"+via_nod2+"-"+door_nod2+"-"+to_nod2);
//						String irgValue = event.getHid_parameter();
//						soHisVo.setCopPlnRoutDesc(irgValue);
						soHisVo.setCopPlnRoutDesc(svcModels[k].getOrgFmNodCd() + svcModels[k].getOrgFmNodYard() + " - " + svcModels[k].getOrgToNodCd() + svcModels[k].getOrgToNodYard());
						soHisVo.setRoutRplnFlg("Y"); //route 변경시 Y
						
						
					}
				}else{
					if (svcModels[k].getCgoTpCd().equals("F")) {
						svcModels[k].setTrspSoStsCd("R");
						//COP TRS S/O Status Update
						replanManageBC.modifySoList(svcModels[k]);
					}

			    }
				
				//history 생성
				soHisVo.setTrspSoOfcCtyCd(trsp_so_ofc_cty_cd);
				soHisVo.setTrspSoSeq(trsp_so_seq);
				soHisVo.setTrspSoEvntCd("SR");
				soHisVo.setSrcCd("USRAIL");
				soHisVo.setCreUsrId(userId);
				soHisVo.setCreOfcCd(sofficeCd);
				commCommand.multiSoHistory(soHisVo);
				
				commit();	
			}			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 삭제 이벤트 처리<br>
	 * RailSoManage의 event에 대한 삭제 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeRailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		EventResponse eventResponse = null;
		
		String user_id = event.getSignOnUserAccount().getUsr_id();
		
		try {			
			begin();
			RailSoManageBC command = new RailSoManageBCImpl();
			eventResponse = command.removeRailSoManage(event);
			
			//COP Replan을 위해 
			TrsTrspRailBilOrdVO[] model = event.getTrsTrspRailBilOrdVos();
			ReplanManageBC replanManageBC = new ReplanManageBCImpl();//BC생성
			TrsCommonBC commCommand =  new TrsCommonBCImpl();

			for ( int i=0; i<model.length; i++ ) {
				if (model[i].getCgoTpCd().equals("F")) {
					if( model[i].getTrspRqstBkgFlg().equals("Y") ) {
						model[i].setTrspSoStsCd("D");						
					}else{
						model[i].setTrspSoStsCd("P");						
					}
					
					//COP TRS S/O Status Update
					replanManageBC.modifySoList(model[i]);
					
					TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();  
					soHisVo.setTrspSoOfcCtyCd(model[i].getTrspSoOfcCtyCd());
					soHisVo.setTrspSoSeq(model[i].getTrspSoSeq());
					soHisVo.setTrspSoEvntCd("SD");
					soHisVo.setCreUsrId(user_id);	
					soHisVo.setSrcCd("USRAIL");
					soHisVo.setCreOfcCd(sofficeCd);
					commCommand.multiSoHistory(soHisVo);
				}
			}
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse; //this.searchRailSoManage(e);
	}
	
	/**
	 * ESD_TRS_0203: Row Delete
	 * CHM-201327803 Empty Repo & EQ On/Off Hire 개선 사항2
	 * Check된 복수개의 Row Delete
	 * 2013.11.27 by SHIN DONG IL
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeEmptyRepoPlanForRail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		EventResponse eventResponse = null;
		
		try {			
			begin();

			RailSoManageBC command = new RailSoManageBCImpl();
			eventResponse = command.removeEmptyRepoPlanForRail(event);
			
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse; //this.searchRailSoManage(e);
	}
		
	/**
	 * 멀티 이벤트 처리<br>
	 * RailSoManageForNoTranjection의 event에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		RailSoManageBC command = new RailSoManageBCImpl();
		
		try {
			String frmNod = null;
			String toNod = null;
			String orgFrmNod = null;
			String orgToNod = null;
			String localUserId = event.getSignOnUserAccount().getUsr_id();
			String trsp_so_ofc_cty_cd = null;
			String trsp_so_seq        = null;
			
			//COP Replan을 위해 
			ReplanManageBC replanManageBC = new ReplanManageBCImpl();//BC생성
			TrsTrspRailBilOrdVO[] svcModels = event.getTrsTrspRailBilOrdVos();
			TrsCommonBC commCommand =  new TrsCommonBCImpl();
			
			// COA 중복 호출 구분자 
			for(int i=0; i<svcModels.length-1; i++){
				for(int j=i+1; j<svcModels.length; j++){
					if( svcModels[j].getBkgNo().equals(svcModels[i].getBkgNo()) ){
						svcModels[j].setN3ptyBilFlg("Y");
					}
				}
			}
			
			for(int k=0;svcModels!= null &&  k<svcModels.length; k++){
				begin();				
				eventResponse = command.multiRailSoManage(event, k);
				command.multiProcRailSoManageForNoTranjection(eventResponse.getCustomData(), event.getSctrlOfcCd()); // Procedure Call
				
				frmNod = svcModels[k].getFmNodCd() + svcModels[k].getFmNodYard();
				toNod = svcModels[k].getToNodCd() + svcModels[k].getToNodYard();
				orgFrmNod  = svcModels[k].getOrgFmNodCd() + svcModels[k].getOrgFmNodYard();
				orgToNod = svcModels[k].getOrgToNodCd()+svcModels[k].getOrgToNodYard();
				trsp_so_ofc_cty_cd = svcModels[k].getTrspSoOfcCtyCd();
				trsp_so_seq = svcModels[k].getTrspSoSeq();
				
				TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();

				if (!frmNod.equals(orgFrmNod) || !toNod.equals(orgToNod))
				{
					
					if (svcModels[k].getCgoTpCd().equals("F")) {
						
						if( !svcModels[k].getN3ptyBilFlg().equals("Y") ){
							//COA I/F
//							CostAssignBC coaCommand = new CostAssignBCImpl();
//							CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
//							coaBkgComIfVo.setBkgNo(svcModels[k].getBkgNo());
//							coaBkgComIfVo.setCostSrcSysCd("TRS");//TRS, TES, SCE, BKG등 SUB SYSTEM CODE
//							coaBkgComIfVo.setIfRmk("US RAIL S/O Creation");
//							coaBkgComIfVo.setCreUsrId(localUserId);
//							coaBkgComIfVo.setUpdUsrId(localUserId);
//
//							int result_cnt = coaCommand.modifyCoaCommonInterface(coaBkgComIfVo);
//							if (result_cnt < 0)
//								throw new EventException((new ErrorHandler("SAQ00099",new String[]{"COA I/F Error"})).getMessage());	
							//MAS I/F [CHM-201534153] 관리회계개선 프로젝트 1단계 Pre CM/OP Simulation Live 반영 요청
							CommonUtil.modifyMasCommonInterface(svcModels[k].getBkgNo(),"US RAIL S/O Creation",localUserId);	
							
						}
						
						svcModels[k].setTrspSoStsCd("C");
						
						//COP Replan
						replanManageBC.replanCop(svcModels[k]);
						
						//SO Creation 전에  IRG Adjust 한 경우 이전 경로정보를 history에 저장. 

						//soHisVo.setCopPlnRoutDesc("("+crr_mod2+") "+frm_nod2+"-"+via_nod2+"-"+door_nod2+"-"+to_nod2);
//						String irgValue = event.getHid_parameter();
						soHisVo.setCopPlnRoutDesc(svcModels[k].getOrgFmNodCd() + svcModels[k].getOrgFmNodYard() + " - " + svcModels[k].getOrgToNodCd() + svcModels[k].getOrgToNodYard());
						soHisVo.setRoutRplnFlg("Y"); //route 변경시 Y
					}
				}else{
					if (svcModels[k].getCgoTpCd().equals("F")) {
						svcModels[k].setTrspSoStsCd("C");
						
						//COP TRS S/O Status Update
						replanManageBC.modifySoList(svcModels[k]);
					}
			    }
				
				soHisVo.setTrspSoOfcCtyCd(trsp_so_ofc_cty_cd);
				soHisVo.setTrspSoSeq(trsp_so_seq);
				soHisVo.setTrspSoEvntCd("SC");
				soHisVo.setSrcCd("USRAIL");
				soHisVo.setCreUsrId(userId);
				soHisVo.setCreOfcCd(sofficeCd);
				commCommand.multiSoHistory(soHisVo);
				
				commit();				
			}			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Save event에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */

	public EventResponse multiRailSoCandidate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		String rtn_ref_id ="";
		
		
		try {
			begin();
			
			RailSoManageBC command = new RailSoManageBCImpl();
			rtn_ref_id = command.multiRailSoCandidate(event,account);	
			
			commit();
			
			rtn_ref_id = rtn_ref_id.substring(0, rtn_ref_id.length()-1);
			eventResponse.setETCData("ref_id",rtn_ref_id);
			
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 		
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * RailSoManage의 event에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multi02RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			begin();
			RailSoManageBC command = new RailSoManageBCImpl();
			eventResponse = command.multi02RailSoManage(event);
			command.multiProcRailSoManage(event.getSctrlOfcCd());
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			if(de.toString().indexOf("Transaction timed out") > -1){
				eventResponse = multi02RailSoManageForNoTranjection(e);
			}else{
				throw new EventException(de.getMessage());
			}
		}
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * RailSoManageForNoTranjection의 event에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multi02RailSoManageForNoTranjection(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		RailSoManageBC command = new RailSoManageBCImpl();
		try {
			TrsTrspRailBilOrdVO[] svcModels = event.getTrsTrspRailBilOrdVos();
			
			for(int k=0; svcModels!= null &&  k<svcModels.length; k++){
				begin();				
				eventResponse = command.multi02RailSoManageForNoTranjection(event, k);
				command.multiProcRailSoManageForNoTranjection(eventResponse.getCustomData(), event.getSctrlOfcCd()); // Procedure Call
				commit();
			}		
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * RailSoManage의 Cancel REQ Reject 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multi01RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			begin();
			RailSoManageBC command = new RailSoManageBCImpl();
			eventResponse = command.multi01RailSoManage(sofficeCd, userId, event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * S/O correction 시 S/O가 delete 됬는지 여부 체크
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse verifyRailSoManageDeltChk(Event e) throws EventException {
		// TODO Auto-generated method stub
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();

		try {
			RailSoManageBC command = new RailSoManageBCImpl();
			String so_no = command.verifyRailSoManageDeltChk(sofficeCd, event);
			eventResponse.setETCData("so_no",so_no);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}