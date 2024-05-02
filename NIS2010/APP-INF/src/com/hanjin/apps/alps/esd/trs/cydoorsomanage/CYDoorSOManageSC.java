/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CYDoorSOManageSC.java
*@FileTitle : CY & Door S/O Creation
*Open Issues :  
*Change history :
*@LastModifyDate : 2006-09-29
*@LastModifier : z_kim_sang_geun
*@LastVersion : 1.0
* 2006-09-29 z_kim_sang_geun
* 1.0 최초 생성
* ----------------------------------------------------------
* History
* N200902170001 2009-02-18 TRS SO 대상 삭제시 COA 비용 제거 기능 추가 
* 2011.06.27 손은주 [CHM-201111573] [TRS] S/O history function 추가 요청
* 2011.11.29 민정호 [CHM-201114644] [TRS] S/O Correction 시 Delete flag 체크로직 추가요청
* 2011.12.12 민정호 [CHM-201115019] [TRS] S/O creation 시 BKG cancel 여부 체크 로직 추가요청
* 2012.01.09 김보배 [CHM-201215479] [TRS] Dup. S/O 사전 보완기능 요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBCImpl;
import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBC;
import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBCImpl;
import com.hanjin.apps.alps.esd.trs.common.trscommon.vo.TrsSOHistoryVO;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.basic.CombinedTransportationCaseTwoSOManageBC;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.basic.CombinedTransportationCaseTwoSOManageBCImpl;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.event.EsdTrs0920Event;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.basic.SingleTransportationSOManageBC;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.basic.SingleTransportationSOManageBCImpl;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0002Event;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0930Event;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.basic.BiddingCandidateBC;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.basic.BiddingCandidateBCImpl;
//import com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
//import com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
//import com.hanjin.syscommon.common.table.CoaBkgComIfVO;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;
import com.hanjin.apps.alps.esd.trs.common.util.CommonUtil;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS에 대한 비지니스 트랜잭션을 처리한다.<br>
 *
 * @author z_kim_sang_geun
 * @see ESD_TRS_002EventResponse,SingleTransportationSOManageDBDAO 참조
 * @since J2EE 1.4
 */
public class CYDoorSOManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	private String sofficeCd = "";
	private String usrid = "";

	/**
	 * TRS 업무 시나리오 선행작업<br>
	 * SingleTransportationSOManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
			sofficeCd = account.getOfc_cd();
			usrid = account.getUsr_id();
		} catch (Exception e) {
			log.error("CYDoorSOManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * SingleTransportationSOManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("CYDoorSOManageSC 종료");
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
		if (e.getEventName().equalsIgnoreCase("EsdTrs0002Event")) {			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { //ESD_TRS_0002
				eventResponse = searchSingleTransportationSOCandidatesList(e);
				/* Actual Customer Info Change cause from Door Location/Zone Modification.	*/
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) { //ESD_TRS_0002
				eventResponse = searchActualCustomerInfoSet(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) { //ESD_TRS_0002
				eventResponse = removeSOCandidate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) { //ESD_TRS_0002 : S/O Creation
				eventResponse = multiSingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) { //ESD_TRS_0051 (MODIFY => SEARCH13) S/O Correction
				eventResponse = modifySingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { //ESD_TRS_0051
				eventResponse = modify01SingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) { //ESD_TRS_0051 w/o issued 
				eventResponse = modify02SingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) { //ESD_TRS_0051
				eventResponse = removeSingleTransportationSOManage(e);
			/* W/O Not Issued S/O List Retrieve	*/
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { //ESD_TRS_0051
				eventResponse = searchSingleTransportationSOList(e);
			/* W/O Issued S/O List Retrieve		*/
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) { //ESD_TRS_0051
				eventResponse = searchSingleTransportationSOList(e);
			/* 조회조건 - Sub Office 가져오기 */
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchSubOfficeSOManageList(e);
				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchOffHireVerify(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchCostMode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchBkgVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {	// S/O Correction 시 Delete flag 체크로직 				
				eventResponse = verifySingleTransportationDeltChk(e); 
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {	// SO Creation 시 SCE_TRO_MAPG 테이블에 있는지 확인 로직 			
				eventResponse = searchSceTroMapg(e); 				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) { // ESD_TRS_0002 : Trans mode와 Route값 중복 체크
				eventResponse = searchSODupCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) { // ESD_TRS_0002 : Route 변경시  Distance 계산
				eventResponse = searchDistanceCalculation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH23)) { // ESD_TRS_0002 : Route 변경시  Distance 계산
				eventResponse = searchDoorYardName(e);	
			} else {
				eventResponse = null;
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdTrs0920Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				//CB II Matchmaking Popup- from ESD_TRS_0920
				eventResponse = searchCombinedTransportationCaseTwoSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				/*Matchmaking One Popup -service Order>Correction>CY&Door 에서 
				 *Matchmaking for Combined Case 2 버튼 클릭시 팝업 (ESD_TRS_0952)
				*/				
				eventResponse = search02CombinedTransportationCaseTwoSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = search03ServiceOfficeCodeSOManage(e);
			} else {
				eventResponse = null;
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdTrs0930Event")) { //Transfer Office Change
			if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyOfficeTransportationSOManage(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) { //Transfer Office Check
				eventResponse = modifyOfficeTransportationSOManageMT(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)) { //Transfer Office Check
				eventResponse = search10TransportationSOManage(e);
			} else {
				eventResponse = null;
			}
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSingleTransportationSOCandidatesList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0002Event event = (EsdTrs0002Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		List<SingleTransportationVO> singleTransportationVO = new ArrayList<SingleTransportationVO>();
		String lSeq = "";
		try {
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			//Temp에 입력할 S/O 대상조회
			singleTransportationVO = command.searchSingleTransportationSOCandidatesListP(event);
			//Temp에 입력할 Sequence No조회
			lSeq = command.searchSingleTransportationSOCandidatesListK();
			
			begin();
			//Temp 조회된 S/O 대상 입력
			command.searchSingleTransportationSOCandidatesListC(event,singleTransportationVO, lSeq);
			commit();
			
			begin();
			//Temp에 입력된 자료에 부가정보 추가   Update
			command.searchSingleTransportationSOCandidatesListU(event, lSeq);
			commit();

			//최종결과  조회
			eventResponse = command.searchSingleTransportationSOCandidatesList(event, lSeq);
			begin();
			//Temp에 입력된 자료 삭제
			command.searchSingleTransportationSOCandidatesListD(lSeq);
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
	 * SingleTransportationSOManage 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSingleTransportationSOList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0002Event 	event 			= (EsdTrs0002Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse 		eventResponse 	= null;	    
		try {//			
			SingleTransportationSOManageBC 	command = new SingleTransportationSOManageBCImpl();
			eventResponse 							= command.searchSingleTransportationSOList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 수정 이벤트 처리<br>
	 * SingleTransportationSOManage의 event에 대한 수정 이벤트 처리<br>
	 * CY&DOOR S/O CORRECTION
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySingleTransportationSOManage(Event e) throws EventException {
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0002Event 			event 			= (EsdTrs0002Event)e;
		EventResponse eventResponse = null;
		try {
			String bkg_no = null;
			String frm_nod  = null;
			String via_nod  = null;
			String door_nod = null;
			String to_nod   = null;
			String frm_nod2  = null;
			String via_nod2  = null;
			String door_nod2 = null;
			String to_nod2   = null;
			String crr_mod   = null;
			String crr_mod2  = null;
			String cop_no           = null;
			String cost_act_grp_seq = null;
			String eq_no            = null;
			String cost_act_grp_cd  = null;
			String trsp_bnd_cd      = null;
			
			String repo_pln_id = null;
			String pln_yrwk    = null;
			String ref_id      = null;
			String ref_seq     = null;

			String trsp_so_ofc_cty_cd = null;
			String trsp_so_seq        = null;
			String rpln_umch_flg      = null;
			String user_id = event.getSignOnUserAccount().getUsr_id();
			
			//verifySingleTransportationSOIRG(e); //IRG 존재여부 체크
			
			begin();
			
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			TrsCommonBC commCommand =  new TrsCommonBCImpl();
			eventResponse = command.modifySingleTransportationSOManage(event);

			//COP Replan을 위해 
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			ReplanManageBC replanManageBC = new ReplanManageBCImpl();//BC생성
//주석처리 CHM-201325599 Split 03-EQR T/F 관련 LEGACY 연계 방안 및 일정			
//			CntrRepoExecutionPlanEstablishBC cntrRepoExecutionPlanEstablishBC = new CntrRepoExecutionPlanEstablishBCImpl();//BC생성

			for ( int i=0; i<singleTransportationVOS.length; i++ ) {
				bkg_no   = singleTransportationVOS[i].getBkgNo();
				frm_nod  = singleTransportationVOS[i].getFmNodCd()+singleTransportationVOS[i].getFmNodYard();
				via_nod  = singleTransportationVOS[i].getViaNodCd()+singleTransportationVOS[i].getViaNodYard();
				door_nod = singleTransportationVOS[i].getDorNodCd()+singleTransportationVOS[i].getDorNodYard();
				to_nod   = singleTransportationVOS[i].getToNodCd()+singleTransportationVOS[i].getToNodYard();
				frm_nod2  = singleTransportationVOS[i].getFmNodCd2()+singleTransportationVOS[i].getFmNodYard2();
				via_nod2  = singleTransportationVOS[i].getViaNodCd2()+singleTransportationVOS[i].getViaNodYard2();
				door_nod2 = singleTransportationVOS[i].getDorNodCd2()+singleTransportationVOS[i].getDorNodYard2();
				to_nod2   = singleTransportationVOS[i].getToNodCd2()+singleTransportationVOS[i].getToNodYard2();
				crr_mod   = singleTransportationVOS[i].getTrspCrrModCd();
				crr_mod2  = singleTransportationVOS[i].getTrspCrrModCd2();

				cop_no           = singleTransportationVOS[i].getCopNo();
				cost_act_grp_seq = singleTransportationVOS[i].getCostActGrpSeq();
				eq_no            = singleTransportationVOS[i].getEqNo();
				cost_act_grp_cd  = singleTransportationVOS[i].getCostActGrpCd();
				trsp_bnd_cd      = singleTransportationVOS[i].getTrspBndCd();

				repo_pln_id = singleTransportationVOS[i].getRepoPlnId();
				pln_yrwk    = singleTransportationVOS[i].getPlnYrwk();
				ref_id      = singleTransportationVOS[i].getRefId();
				ref_seq     = singleTransportationVOS[i].getRefSeq();

				trsp_so_ofc_cty_cd = singleTransportationVOS[i].getTrspSoOfcCtyCd();
				trsp_so_seq        = singleTransportationVOS[i].getTrspSoSeq();
				rpln_umch_flg      = singleTransportationVOS[i].getRplnUmchFlg();
				
				TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();  //TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY 입력

				if (!frm_nod.equals(frm_nod2) || !via_nod.equals(via_nod2)
						|| !door_nod.equals(door_nod2) || !to_nod.equals(to_nod2)
						|| !crr_mod.equals(crr_mod2))
				{
					if (singleTransportationVOS[i].getCgoTpCd().equals("F")) {
						//COA I/F
//						CostAssignBC coaCommand = new CostAssignBCImpl();
//						CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
//						coaBkgComIfVo.setBkgNo(bkg_no);
//						coaBkgComIfVo.setCostSrcSysCd("TRS");//TRS, TES, SCE, BKG등 SUB SYSTEM CODE
//						coaBkgComIfVo.setIfRmk("S/O Modify");
//						coaBkgComIfVo.setCreUsrId(user_id);
//						coaBkgComIfVo.setUpdUsrId(user_id);
//
//						int result_cnt = coaCommand.modifyCoaCommonInterface(coaBkgComIfVo);
//						if (result_cnt < 0)
//							throw new EventException((new ErrorHandler("TRS00099",new String[]{"COA I/F Error"})).getMessage());

						//MAS I/F [CHM-201534153] 관리회계개선 프로젝트 1단계 Pre CM/OP Simulation Live 반영 요청
						CommonUtil.modifyMasCommonInterface(bkg_no,"S/O Modify",user_id);						

						//COP Replan
						SingleTransportationVO trsStsVO = new SingleTransportationVO();
						trsStsVO.setTrspSoStsCd("R");
						trsStsVO.setUpdUsrId(user_id);
						trsStsVO.setCopNo(cop_no);
						trsStsVO.setBkgNo(bkg_no);
						trsStsVO.setEqNo(eq_no);
						trsStsVO.setActGrpCd(cost_act_grp_cd);
						trsStsVO.setTrspBndCd(trsp_bnd_cd);
						trsStsVO.setCostActGrpSeq(cost_act_grp_seq);
						trsStsVO.setTrspSoOfcCtyCd(trsp_so_ofc_cty_cd);
						trsStsVO.setTrspSoSeq(trsp_so_seq);
						
						//InterRmk는 SO History를 남기기 위하여 원래의 컬럼 용도는 아니지만 ETS VO를 수정하지 않고 그대로 사용하기 위하여 이 컬럼을 사용 
						trsStsVO.setInterRmk("("+crr_mod2+") "+frm_nod2+"-"+via_nod2+"-"+door_nod2+"-"+to_nod2);
						trsStsVO.setCreOfcCd(sofficeCd);
						replanManageBC.replanCop(trsStsVO);
						
						soHisVo.setCopPlnRoutDesc("("+crr_mod2+") "+frm_nod2+"-"+via_nod2+"-"+door_nod2+"-"+to_nod2);
						soHisVo.setRoutRplnFlg("Y");
					}
				}else{
					if (singleTransportationVOS[i].getCgoTpCd().equals("F")) {
						if (!rpln_umch_flg.equals("Y")) { //UnMatch일 경우엔 상태코드를 update하지 않는다.
							//COP TRS S/O Status Update
							SingleTransportationVO trsStsVO = new SingleTransportationVO();
							trsStsVO.setTrspSoStsCd("R");
							trsStsVO.setUpdUsrId(user_id);
							trsStsVO.setCopNo(cop_no);
							trsStsVO.setCostActGrpSeq(cost_act_grp_seq);
							trsStsVO.setTrspBndCd(trsp_bnd_cd);
							trsStsVO.setTrspSoOfcCtyCd(trsp_so_ofc_cty_cd);
							trsStsVO.setTrspSoSeq(trsp_so_seq);
							replanManageBC.modifySoList(trsStsVO);
						}
					}
//주석처리 CHM-201325599 Split 03-EQR T/F 관련 LEGACY 연계 방안 및 일정							
//WHY? : CY&DOOR에서는 EMPTY CONTAINER 처리하지 않음. 2013.10.11 BY SHIN DONG IL							
//					else{
						//EQR TRS S/O Status Update
//						SingleTransportationVO trsStsVO = new SingleTransportationVO();
//						trsStsVO.setTrspSoStsCd("R");
//						trsStsVO.setUpdUsrId(user_id);
//						trsStsVO.setRepoPlnId(repo_pln_id);
//						trsStsVO.setPlnYrwk(pln_yrwk);
//						trsStsVO.setRefId(ref_id);
//						trsStsVO.setRefSeq(ref_seq);
//						command.modifyEmptyRepoIfSOSts(trsStsVO);
//					}
			    }
				//TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY 입력
				soHisVo.setTrspSoOfcCtyCd(trsp_so_ofc_cty_cd);
				soHisVo.setTrspSoSeq(trsp_so_seq);
				soHisVo.setTrspSoEvntCd("SR");

				soHisVo.setCreUsrId(user_id);
				soHisVo.setCreOfcCd(sofficeCd);
				commCommand.multiSoHistory(soHisVo);
			}
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 수정 이벤트 처리<br>
	 * SingleTransportationSOManage의 event에 대한 수정 이벤트 처리<br>
	 * CY & DOOR S/O Correction화면의 Separate 수행
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modify01SingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0002Event event = (EsdTrs0002Event)e;
		//EventResponse eventResponse = null;
		GeneralEventResponse eventResponse = new  GeneralEventResponse();
		try {
			begin();
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			command.modify01SingleTransportationSOManage(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * 수정 이벤트 처리<br>
	 * SingleTransportationSOManage의 W/O Issued에 대한 수정 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modify02SingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0002Event event = (EsdTrs0002Event)e;
		EventResponse eventResponse = null;

		try {
			begin();
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse = command.modify02SingleTransportationSOManage(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * CY&DOOR Correction S/O 삭제 이벤트 처리<br>
	 * SingleTransportationSOManage의 event에 대한 삭제 이벤트 처리<br>
	 * CY&DOOR S/O DELETE
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeSingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0002Event 			event 			= (EsdTrs0002Event)e;
		EventResponse 				eventResponse 	= null;
		try {
			
			String bkg_no = null;
			String cop_no           = null;
			String cost_act_grp_seq = null;

			String repo_pln_id = null;
			String pln_yrwk    = null;
			String ref_id      = null;
			String ref_seq     = null;
			String trsp_rqst_bkg_flg = null; //UI에서 입력하는 값
			String trsp_so_sts_cd    = null;
			
			String trsp_bnd_cd        = null;
			String trsp_so_ofc_cty_cd = null;
			String trsp_so_seq        = null;
			
			String user_id = event.getSignOnUserAccount().getUsr_id();
			
			begin();
			
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse = command.removeSingleTransportationSOManage(event);
			TrsCommonBC commCommand =  new TrsCommonBCImpl();

			//COP Replan을 위해 
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();

			for ( int i=0; i<singleTransportationVOS.length; i++ ) {
				bkg_no   = singleTransportationVOS[i].getBkgNo();
				cop_no           = singleTransportationVOS[i].getCopNo();
				cost_act_grp_seq = singleTransportationVOS[i].getCostActGrpSeq();

				repo_pln_id = singleTransportationVOS[i].getRepoPlnId();
				pln_yrwk    = singleTransportationVOS[i].getPlnYrwk();
				ref_id      = singleTransportationVOS[i].getRefId();
				ref_seq     = singleTransportationVOS[i].getRefSeq();
				trsp_rqst_bkg_flg = singleTransportationVOS[i].getTrspRqstBkgFlg();
				
				trsp_bnd_cd        = singleTransportationVOS[i].getTrspBndCd();
				trsp_so_ofc_cty_cd = singleTransportationVOS[i].getTrspSoOfcCtyCd();
				trsp_so_seq        = singleTransportationVOS[i].getTrspSoSeq();
				
				//TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY 입력
				TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();  
				soHisVo.setTrspSoOfcCtyCd(trsp_so_ofc_cty_cd);
				soHisVo.setTrspSoSeq(trsp_so_seq);
				soHisVo.setTrspSoEvntCd("SD");
				
				if (trsp_rqst_bkg_flg.equals("Y")) trsp_so_sts_cd = "D"; else trsp_so_sts_cd = "P";

				if (singleTransportationVOS[i].getCgoTpCd().equals("F")) {
					if (trsp_rqst_bkg_flg.equals("Y")) {
						//MAS I/F [CHM-201534153] 관리회계개선 프로젝트 1단계 Pre CM/OP Simulation Live 반영 요청
						CommonUtil.modifyMasCommonInterface(bkg_no,"S/O delete",user_id);
					}
				}
				//TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY 입력
				soHisVo.setCreUsrId(user_id);	
				soHisVo.setCreOfcCd(sofficeCd);
				commCommand.multiSoHistory(soHisVo);
			}
			commit();
			
			//Spot Bidding Cancel Email 전송
			begin();
			BiddingCandidateBC spotBidCommand =  new BiddingCandidateBCImpl();
			spotBidCommand.sendMailSpotBiddingCancel(singleTransportationVOS, account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * IRG 존재여부 체크<br>
	 * SingleTransportationSOManage의 event에 대한 멀티 이벤트 처리<br>
	 * CY&DOOR S/O CREATION
	 * 1. S/O를 발행하기 전에 해당구간의 IRG가 존재하는지 체크한다.
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public int verifySingleTransportationSOIRG(Event e) throws EventException {
		EsdTrs0002Event 			event 			= (EsdTrs0002Event)e;
		int result_cnt = 0;
		try {
			String frm_nod  = null;
			String via_nod  = null;
			String door_nod = null;
			String to_nod   = null;
			String frm_nod2  = null;
			String via_nod2  = null;
			String door_nod2 = null;
			String to_nod2   = null;
			String crr_mod   = null;
			String crr_mod2  = null;
			String bnd_cd    = null;

			String cgo_tp_cd        = null;

			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			SingleTransportationSOManageBC command 		= new SingleTransportationSOManageBCImpl();
			for ( int i=0; i<singleTransportationVOS.length; i++ ) {
				frm_nod   = singleTransportationVOS[i].getFmNodCd()+singleTransportationVOS[i].getFmNodYard();
				via_nod   = singleTransportationVOS[i].getViaNodCd()+singleTransportationVOS[i].getViaNodYard();
				door_nod  = singleTransportationVOS[i].getDorNodCd()+singleTransportationVOS[i].getDorNodYard();
				to_nod    = singleTransportationVOS[i].getToNodCd()+singleTransportationVOS[i].getToNodYard();
				frm_nod2  = singleTransportationVOS[i].getFmNodCd2()+singleTransportationVOS[i].getFmNodYard2();
				via_nod2  = singleTransportationVOS[i].getViaNodCd2()+singleTransportationVOS[i].getViaNodYard2();
				door_nod2 = singleTransportationVOS[i].getDorNodCd2()+singleTransportationVOS[i].getDorNodYard2();
				to_nod2   = singleTransportationVOS[i].getToNodCd2()+singleTransportationVOS[i].getToNodYard2();
				crr_mod   = singleTransportationVOS[i].getTrspCrrModCd();
				crr_mod2  = singleTransportationVOS[i].getTrspCrrModCd2();
				cgo_tp_cd = singleTransportationVOS[i].getCgoTpCd();
				bnd_cd    = singleTransportationVOS[i].getTrspBndCd();

				if (!frm_nod.equals(frm_nod2) || !via_nod.equals(via_nod2)
						|| !door_nod.equals(door_nod2) || !to_nod.equals(to_nod2)
						|| !crr_mod.equals(crr_mod2))
				{
					if (cgo_tp_cd.equals("F")) {
						//if (bnd_cd.equals("T") && singleTransportationVOS[i].getFmNodCd().equals(singleTransportationVOS[i].getToNodCd()) ) {
						if (!(bnd_cd.equals("T") || ( bnd_cd.equals("O") && !door_nod2.equals("") && !frm_nod.equals(frm_nod2)) || ( bnd_cd.equals("I") && !door_nod2.equals("") && !to_nod.equals(to_nod2)) ) ) {
							//From Node와 To Node가 동일하고 Bound Code가 'T'인 경우 (즉, T/S SHUTTLE인 경우는 IRG를 체크하지 않는다.)
							//Bound Code가 'T'인 경우 (즉, T/S SHUTTLE과 WD구간은 IRG를 체크하지 않는다.)
//						}else{
							command.verifySingleTransportationSOIRG(singleTransportationVOS[i]);
						}
					}
				}
			}

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return result_cnt;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * SingleTransportationSOManage의 event에 대한 멀티 이벤트 처리<br>
	 * CY&DOOR S/O CREATION
	 * 1. S/O Creation
	 * 2. COA I/F
	 * 3. COP Replan, COP S/O 상태코드 UPDATE
	 * 4. EQR S/O 상태코드 UPDATE 
	 * 5. SO History UPDATE
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiSingleTransportationSOManage(Event e) throws EventException {
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EsdTrs0002Event 			event 			= (EsdTrs0002Event)e;
		GeneralEventResponse eventResponse = new  GeneralEventResponse();
		
		try {
			String bkg_no   = null;
			String frm_nod  = null;
			String via_nod  = null;
			String door_nod = null;
			String to_nod   = null;
			String frm_nod2  = null;
			String via_nod2  = null;
			String door_nod2 = null;
			String to_nod2   = null;
			String crr_mod   = null;
			String crr_mod2  = null;

			String cop_no           = null;
			String cost_act_grp_seq = null;
			String eq_no            = null;
			String cost_act_grp_cd  = null;
			String trsp_bnd_cd      = null;
			
			String repo_pln_id = null;
			String pln_yrwk    = null;
			String ref_id      = null;
			String ref_seq     = null;

			String trsp_so_ofc_cty_cd = null;
			String trsp_so_seq        = null;
			String sdy_sep 	= "";
			String so_no = "";
			String spotBidFlg = "N";

			List<TrsTrspSvcOrdVO> seqVoList = new  ArrayList<TrsTrspSvcOrdVO>();
			String user_id = event.getSignOnUserAccount().getUsr_id();
			SingleTransportationSOManageBC command 		= new SingleTransportationSOManageBCImpl();
			TrsCommonBC commCommand =  new TrsCommonBCImpl();
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();

			//COP Replan과 S/O 상태코드 UPDATE를 위해 
			ReplanManageBC replanManageBC = new ReplanManageBCImpl();//BC생성
//			주석처리 CHM-201325599 Split 03-EQR T/F 관련 LEGACY 연계 방안 및 일정					
//			CntrRepoExecutionPlanEstablishBC cntrRepoExecutionPlanEstablishBC = new CntrRepoExecutionPlanEstablishBCImpl();//BC생성

			for ( int i=0; i<singleTransportationVOS.length; i++ ) {
				begin();
				command.verifySingleTransportationDupChk(event,i); //S/O 기발행 여부 체크
				so_no = command.multiSingleTransportationSOManage(event, i);
				TrsTrspSvcOrdVO seqVo = new TrsTrspSvcOrdVO();
				TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();  //TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY 입력
				seqVo.setTrspSoSeq(String.valueOf(so_no));
				
				if(singleTransportationVOS[i].getSpotBidFlg().equals("1")){
					spotBidFlg = "Y";
				}else{
					spotBidFlg = "N";
				}
				seqVo.setSpotBidFlg(spotBidFlg);
				seqVo.setSpotBidDueDt(singleTransportationVOS[i].getSpotBidDueDt());
				seqVo.setSpotBidDueDtHms(singleTransportationVOS[i].getSpotBidDueDtHms());
				seqVo.setFmNodCd(singleTransportationVOS[i].getFmNodCd()+singleTransportationVOS[i].getFmNodYard());
				seqVo.setViaNodCd(singleTransportationVOS[i].getViaNodCd()+singleTransportationVOS[i].getViaNodYard());
				seqVo.setDorNodCd(singleTransportationVOS[i].getDorNodCd()+singleTransportationVOS[i].getDorNodYard());
				seqVo.setToNodCd(singleTransportationVOS[i].getToNodCd()+singleTransportationVOS[i].getToNodYard());
				seqVo.setTrspCrrModCd(singleTransportationVOS[i].getTrspCrrModCd());
				seqVoList.add(seqVo);

				bkg_no   = singleTransportationVOS[i].getBkgNo();
				frm_nod  = singleTransportationVOS[i].getFmNodCd()+singleTransportationVOS[i].getFmNodYard();
				via_nod  = singleTransportationVOS[i].getViaNodCd()+singleTransportationVOS[i].getViaNodYard();
				door_nod = singleTransportationVOS[i].getDorNodCd()+singleTransportationVOS[i].getDorNodYard();
				to_nod   = singleTransportationVOS[i].getToNodCd()+singleTransportationVOS[i].getToNodYard();
				frm_nod2  = singleTransportationVOS[i].getFmNodCd2()+singleTransportationVOS[i].getFmNodYard2();
				via_nod2  = singleTransportationVOS[i].getViaNodCd2()+singleTransportationVOS[i].getViaNodYard2();
				door_nod2 = singleTransportationVOS[i].getDorNodCd2()+singleTransportationVOS[i].getDorNodYard2();
				to_nod2   = singleTransportationVOS[i].getToNodCd2()+singleTransportationVOS[i].getToNodYard2();
				crr_mod   = singleTransportationVOS[i].getTrspCrrModCd();
				crr_mod2  = singleTransportationVOS[i].getTrspCrrModCd2();

				cop_no           = singleTransportationVOS[i].getCopNo();
				cost_act_grp_seq = singleTransportationVOS[i].getCostActGrpSeq();
				eq_no            = singleTransportationVOS[i].getEqNo();
				trsp_bnd_cd      = singleTransportationVOS[i].getTrspBndCd();
				
				//Trans Mode를 변경할 경우  cost_act_grp_cd 도 새로 생성되어야 하기 때문에 새로 조합한다.
				//cost_act_grp_cd  = singleTransportationVOS[i].getCostActGrpCd();
				if( String.valueOf(singleTransportationVOS[i].getTrspCostDtlModCd()).equals("DR") ) { //DAO에서 DOOR에서 DR로 값이 바뀐다.
					sdy_sep 	= "D";
				} else {
					sdy_sep 	= "Y";
				}

				cost_act_grp_cd  = singleTransportationVOS[i].getTrspBndCd() + sdy_sep + singleTransportationVOS[i].getTrspCrrModCd();
				singleTransportationVOS[i].setCostActGrpCd(cost_act_grp_cd);
				
				repo_pln_id = singleTransportationVOS[i].getRepoPlnId();
				pln_yrwk    = singleTransportationVOS[i].getPlnYrwk();
				ref_id      = singleTransportationVOS[i].getRefId();
				ref_seq     = singleTransportationVOS[i].getRefSeq();

				//S/O NO는 DAO에서 세팅되었다. (SC와 DAO의 singleTransportationVOS 객체는 Call by Reference 방식으로 값이 공유되고 있다.)
				trsp_so_ofc_cty_cd = singleTransportationVOS[i].getTrspSoOfcCtyCd().substring(0, 3);
				trsp_so_seq        = singleTransportationVOS[i].getTrspSoSeq();

				if (!frm_nod.equals(frm_nod2) || !via_nod.equals(via_nod2)
						|| !door_nod.equals(door_nod2) || !to_nod.equals(to_nod2)
						|| !crr_mod.equals(crr_mod2))
				{
					if (singleTransportationVOS[i].getCgoTpCd().equals("F")) {
						//COA I/F
//						CostAssignBC coaCommand = new CostAssignBCImpl();
//						CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
//						coaBkgComIfVo.setBkgNo(bkg_no);
//						coaBkgComIfVo.setCostSrcSysCd("TRS");//TRS, TES, SCE, BKG등 SUB SYSTEM CODE
//						coaBkgComIfVo.setIfRmk("S/O Create");
//						coaBkgComIfVo.setCreUsrId(user_id);
//						coaBkgComIfVo.setUpdUsrId(user_id);
//
//						int result_cnt = coaCommand.modifyCoaCommonInterface(coaBkgComIfVo);
//						if (result_cnt < 0)
//							throw new EventException((new ErrorHandler("TRS00099",new String[]{"COA I/F Error"})).getMessage());
						//MAS I/F [CHM-201534153] 관리회계개선 프로젝트 1단계 Pre CM/OP Simulation Live 반영 요청
						CommonUtil.modifyMasCommonInterface(bkg_no,"S/O Create",user_id);
						
						//COP Replan
						SingleTransportationVO trsStsVO = new SingleTransportationVO();
						trsStsVO.setTrspSoStsCd("C");
						trsStsVO.setUpdUsrId(user_id);
						trsStsVO.setCopNo(cop_no);
						trsStsVO.setBkgNo(bkg_no);
						trsStsVO.setEqNo(eq_no);
						trsStsVO.setActGrpCd(cost_act_grp_cd);
						trsStsVO.setTrspBndCd(trsp_bnd_cd);
						trsStsVO.setCostActGrpSeq(cost_act_grp_seq);
						trsStsVO.setTrspSoOfcCtyCd(trsp_so_ofc_cty_cd);
						trsStsVO.setTrspSoSeq(trsp_so_seq);
						
						//InterRmk는 SO History를 남기기 위하여 원래의 컬럼 용도는 아니지만 ETS VO를 수정하지 않고 그대로 사용하기 위하여 이 컬럼을 사용 
						trsStsVO.setInterRmk("("+crr_mod2+") "+frm_nod2+"-"+via_nod2+"-"+door_nod2+"-"+to_nod2);
						trsStsVO.setCreOfcCd(sofficeCd);

						replanManageBC.replanCop(trsStsVO);

						soHisVo.setCopPlnRoutDesc("("+crr_mod2+") "+frm_nod2+"-"+via_nod2+"-"+door_nod2+"-"+to_nod2);
						soHisVo.setRoutRplnFlg("Y");
					}
				}else{
					if (singleTransportationVOS[i].getCgoTpCd().equals("F")) {
						//COP TRS S/O Status Update
						SingleTransportationVO trsStsVO = new SingleTransportationVO();
						trsStsVO.setTrspSoStsCd("C");
						trsStsVO.setUpdUsrId(user_id);
						trsStsVO.setCopNo(cop_no);
						trsStsVO.setCostActGrpSeq(cost_act_grp_seq);
						trsStsVO.setTrspBndCd(trsp_bnd_cd);
						trsStsVO.setTrspSoOfcCtyCd(trsp_so_ofc_cty_cd);
						trsStsVO.setTrspSoSeq(trsp_so_seq);
						replanManageBC.modifySoList(trsStsVO);
					}
//주석처리 CHM-201325599 Split 03-EQR T/F 관련 LEGACY 연계 방안 및 일정							
//WHY? : CY&DOOR에서는 EMPTY CONTAINER 처리하지 않음. 2013.10.11 BY SHIN DONG IL					
//					else{
						//EQR TRS S/O Status Update
//						SingleTransportationVO trsStsVO = new SingleTransportationVO();
//						trsStsVO.setTrspSoStsCd("C");
//						trsStsVO.setUpdUsrId(user_id);
//						trsStsVO.setRepoPlnId(repo_pln_id);
//						trsStsVO.setPlnYrwk(pln_yrwk);
//						trsStsVO.setRefId(ref_id);
//						trsStsVO.setRefSeq(ref_seq);
//						cntrRepoExecutionPlanEstablishBC.modifyFromTrsSOIFPlanSoSts(trsStsVO);
//						command.modifyEmptyRepoIfSOSts(trsStsVO);
//					}
			    }
				//TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY 입력
				soHisVo.setTrspSoOfcCtyCd(trsp_so_ofc_cty_cd);
				soHisVo.setTrspSoSeq(trsp_so_seq);
				soHisVo.setTrspSoEvntCd("SC");

				soHisVo.setCreUsrId(user_id);
				soHisVo.setCreOfcCd(sofficeCd);
				commCommand.multiSoHistory(soHisVo);

				commit();
			}
			eventResponse.setRsVoList(seqVoList);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch(Exception de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CombinedTransportationCaseTwoSOManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombinedTransportationCaseTwoSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0920Event event = (EsdTrs0920Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CombinedTransportationCaseTwoSOManageBC command = new CombinedTransportationCaseTwoSOManageBCImpl();
			eventResponse = command.searchCombinedTransportationCaseTwoSOManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CombinedTransportationCaseTwoSOManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search02CombinedTransportationCaseTwoSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0920Event event = (EsdTrs0920Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CombinedTransportationCaseTwoSOManageBC command = new CombinedTransportationCaseTwoSOManageBCImpl();
			eventResponse = command.search02CombinedTransportationCaseTwoSOManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ServiceOfficeCodeSOManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search03ServiceOfficeCodeSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0920Event event = (EsdTrs0920Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CombinedTransportationCaseTwoSOManageBC command = new CombinedTransportationCaseTwoSOManageBCImpl();
			eventResponse = command.search03ServiceOfficeCodeSOManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 수정 이벤트 처리<br>
	 * SingleTransportationSOManage의 event에 대한 수정 이벤트 처리<br>
	 * Transfer Office <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyOfficeTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0930Event event = (EsdTrs0930Event)e;
		EventResponse eventResponse = null;

		try {
			begin();
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse = command.modifyOfficeTransportationSOManage(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	private EventResponse modifyOfficeTransportationSOManageMT(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0930Event event = (EsdTrs0930Event)e;
		EventResponse eventResponse = null;

		try {
			begin();
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse = command.modifyOfficeTransportationSOManageMT(event);
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
	 * SingleTransportationSOManage의 event에 대한 수정 이벤트 처리<br>
	 * Transfer Office <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search10TransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0930Event event = (EsdTrs0930Event)e;
		EventResponse eventResponse = null;

		try {
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse = command.search10TransportationSOManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage의 event에 대한 수정 이벤트 처리<br>
	 * Sub Office <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubOfficeSOManageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0002Event event = (EsdTrs0002Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse = command.searchSubOfficeSOManageList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Actual Customer Info Change cause from Door Location/Zone Modification <br>
	 * Sub Office <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private GeneralEventResponse searchActualCustomerInfoSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		EsdTrs0002Event 	event 			= (EsdTrs0002Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse 		eventResponse 	= null;
		
		try {
			SingleTransportationSOManageBC 	command = new SingleTransportationSOManageBCImpl();
			eventResponse 							= command.searchActualCustomerInfoSet(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Actual Customer Info Change cause from Door Location/Zone Modification <br>
	 * Sub Office <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeSOCandidate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		EsdTrs0002Event 	event 			= (EsdTrs0002Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new  GeneralEventResponse();
		List<SingleTransportationVO> sub_models = new ArrayList<SingleTransportationVO>();
		try {
			SingleTransportationSOManageBC 	command = new SingleTransportationSOManageBCImpl();
			
			String bkg_no = null;
			String user_id = event.getSignOnUserAccount().getUsr_id();
			String cop_no           = null;
			String cost_act_grp_seq = null;
			String trsp_bnd_cd      = null;
			String trsp_so_ofc_cty_cd = null;
			String trsp_so_seq        = null;
			
			begin();
			sub_models = command.removeSOCandidate(event);

			ReplanManageBC replanManageBC = new ReplanManageBCImpl();//BC생성
//			CntrRepoExecutionPlanEstablishBC cntrRepoExecutionPlanEstablishBC = new CntrRepoExecutionPlanEstablishBCImpl();//BC생성

			//N200902170001 2009-02-18 TRS SO 대상 삭제시 COA 비용 제거 기능 추가 
			//COA I/F Batch
			for ( int m=0; sub_models != null && m<sub_models.size(); m++ ) {
				SingleTransportationVO model = (SingleTransportationVO) sub_models.get(m);
				bkg_no = model.getBkgNo();
				cop_no           = model.getCopNo();
				cost_act_grp_seq = model.getCostActGrpSeq();
				trsp_bnd_cd = model.getTrspBndCd();
				trsp_so_ofc_cty_cd = model.getTrspSoOfcCtyCd();
				trsp_so_seq = model.getTrspSoSeq();
				//COA I/F
				if(bkg_no != null){
//					CostAssignBC coaCommand = new CostAssignBCImpl();
//					CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
//					coaBkgComIfVo.setBkgNo(bkg_no);
//					coaBkgComIfVo.setCostSrcSysCd("TRS");//TRS, TES, SCE, BKG등 SUB SYSTEM CODE
//					coaBkgComIfVo.setIfRmk("S/O Candidate Delete");
//					coaBkgComIfVo.setCreUsrId(user_id);
//					coaBkgComIfVo.setUpdUsrId(user_id);
//					int result_cnt = coaCommand.modifyCoaCommonInterface(coaBkgComIfVo);
//					if (result_cnt < 0) //result값이 0보다 작으면 오류
//						throw new EventException((new ErrorHandler("TRS00099",new String[]{"COA I/F Error"})).getMessage());

					//MAS I/F [CHM-201534153] 관리회계개선 프로젝트 1단계 Pre CM/OP Simulation Live 반영 요청
					CommonUtil.modifyMasCommonInterface(bkg_no,"S/O Candidate Delete",user_id);
					}
				
				//COP TRS S/O Status Update
				SingleTransportationVO trsStsVO = new SingleTransportationVO();
				trsStsVO.setTrspSoStsCd("N");
				trsStsVO.setUpdUsrId(user_id);
				trsStsVO.setCopNo(cop_no);
				trsStsVO.setCostActGrpSeq(cost_act_grp_seq);
				trsStsVO.setTrspBndCd(trsp_bnd_cd);
				trsStsVO.setTrspSoOfcCtyCd(trsp_so_ofc_cty_cd);
				trsStsVO.setTrspSoSeq(trsp_so_seq);
				replanManageBC.modifySoList(trsStsVO);
			}

			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Off Hire Verify Check <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private GeneralEventResponse searchOffHireVerify(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		EsdTrs0002Event 	event 			= (EsdTrs0002Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse 		eventResponse 	= null;
		
		try {
			SingleTransportationSOManageBC 	command = new SingleTransportationSOManageBCImpl();
			eventResponse 							= command.searchOffHireVerify(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Off Hire Verify Check <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private GeneralEventResponse searchCostMode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		EsdTrs0002Event 	event 			= (EsdTrs0002Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse 		eventResponse 	= null;
		
		try {
			SingleTransportationSOManageBC 	command = new SingleTransportationSOManageBCImpl();
			eventResponse 							= command.searchCostMode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	
	/**
	 * SEARCH09 이벤트 처리<br>
	 * CodeManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchBkgVvd(Event e) throws EventException {
		EventResponse eventResponse = null;
		
		try {
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse = command.searchBkgVvd(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		return eventResponse;
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * S/O Correction 시 Delete flag 체크로직<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse verifySingleTransportationDeltChk(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event)e;
		EventResponse eventResponse = new GeneralEventResponse();
		int sw = 1;	// 구분자
		eventResponse.setETCData("delt_flg", "N");
		eventResponse.setETCData("so_sts_cd", "");
		eventResponse.setETCData("so_no", "");	
		
		try {		
			String trsp_so_ofc_cty_cd = "";
			String trsp_so_seq        = "";
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();			
			for ( int i=0; i<singleTransportationVOS.length; i++ ) {
				trsp_so_ofc_cty_cd = singleTransportationVOS[i].getTrspSoOfcCtyCd();
				trsp_so_seq        = singleTransportationVOS[i].getTrspSoSeq();				
				SingleTransportationVO trsStsVO = new SingleTransportationVO();
				
				trsStsVO.setTrspSoOfcCtyCd(trsp_so_ofc_cty_cd);
				trsStsVO.setTrspSoSeq(trsp_so_seq);			
				if(sw == 1){
					SingleTransportationSOManageBC singleTransportationSOManageBC = new SingleTransportationSOManageBCImpl();
					String rtn_val = singleTransportationSOManageBC.verifySingleTransportationDeltChk(trsStsVO);
					String[] arr_rtn_val =rtn_val.split(",");
					
					if("Y".equals(arr_rtn_val[0])){
						eventResponse.setETCData("delt_flg", arr_rtn_val[0]);
						eventResponse.setETCData("so_sts_cd", arr_rtn_val[1]);
						eventResponse.setETCData("so_no", trsp_so_ofc_cty_cd+trsp_so_seq);
						sw = 2;
					}
					// S: S/O CORRECTION 가능 F :S/O CORRECTION 불가능 
					if("F".equals(arr_rtn_val[1])){
						eventResponse.setETCData("delt_flg", arr_rtn_val[0]);
						eventResponse.setETCData("so_sts_cd", arr_rtn_val[1]);
						eventResponse.setETCData("so_no", trsp_so_ofc_cty_cd+trsp_so_seq);
						sw = 2;
					}
				}
			}	
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}		
	
	/**
	 * 조회 이벤트 처리<br>
	 * SO Creation 시 SCE_TRO_MAPG 테이블에 있는지 확인 로직<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSceTroMapg(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event)e;
		EventResponse eventResponse = new GeneralEventResponse();
		int sw = 1;	// 구분자
		eventResponse.setETCData("confirm_flg", "N");	
		
		try {		
			String bkgNo 		= "";
			String trspBndCd	= "";
			String troSeq		= "";
			String troSubSeq	= "";
			String bkgRcvdeTermCd = "";  
			String trspCostDtlModCd = "";
			String uiContiCd	= event.getUi_conti_cd();
			
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();			
			for ( int i=0; i<singleTransportationVOS.length; i++ ) {
				bkgNo 			= singleTransportationVOS[i].getBkgNo();
				trspBndCd      	= singleTransportationVOS[i].getTrspBndCd();
				troSeq      	= singleTransportationVOS[i].getTroSeq();
				troSubSeq      	= singleTransportationVOS[i].getTroSubSeq();
				bkgRcvdeTermCd	= singleTransportationVOS[i].getBkgRcvdeTermCd();
				trspCostDtlModCd = singleTransportationVOS[i].getTrspCostDtlModCd();
								
				SingleTransportationVO trsStsVO = new SingleTransportationVO();
				
				trsStsVO.setBkgNo(bkgNo);
				trsStsVO.setTrspBndCd(trspBndCd);
				trsStsVO.setTroSeq(troSeq);
				trsStsVO.setTroSubSeq(troSubSeq);
				trsStsVO.setBkgRcvdeTermCd(bkgRcvdeTermCd);
				trsStsVO.setTrspCostDtlModCd(trspCostDtlModCd);
							
				if(sw == 1){
					SingleTransportationSOManageBC singleTransportationSOManageBC = new SingleTransportationSOManageBCImpl();
					String confirm_flg = singleTransportationSOManageBC.searchSceTroMapg(trsStsVO,uiContiCd);
					if("X".equals(confirm_flg) || "R".equals(confirm_flg) || "T".equals(confirm_flg)){
						eventResponse.setETCData("confirm_flg", confirm_flg);
						eventResponse.setETCData("bkg_no", bkgNo);
						sw = 2;
					}
				}
			}	
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * 2012.01.09 김보배 [CHM-201215479] [TRS] Dup. S/O 사전 보완기능 요청
	 * Trans mode 와 Route 가 동일한 내용으로 생성된 건 중복 체크 로직<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSODupCheck(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SingleTransportationSOManageBC command = null;
		try{	
			EsdTrs0002Event event =(EsdTrs0002Event) e;
			command = new SingleTransportationSOManageBCImpl();
			String retVal = command.searchSODupCheck(event.getSingleTransportationVO());
			eventResponse.setETCData("soDupChk", retVal);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Route 변경시 Distance 조회 로직 <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDistanceCalculation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		EsdTrs0002Event event = (EsdTrs0002Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			SingleTransportationSOManageBC 	command = new SingleTransportationSOManageBCImpl();
			eventResponse = command.searchDistanceCalculation(event.getSingleTransportationVO());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * USA CY & Door Creation의 그리드 Door Yard변경시 Door Yard Name조회
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchDoorYardName(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SingleTransportationSOManageBC command = null;
		try{	
			EsdTrs0002Event event =(EsdTrs0002Event) e;
			command = new SingleTransportationSOManageBCImpl();
			String dorYdNm =event.getSearchDoorLoc()+event.getSearchDoorYard();
			String retVal = command.searchDoorYardName(dorYdNm);
			eventResponse.setETCData("dorYdNm", retVal);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
}