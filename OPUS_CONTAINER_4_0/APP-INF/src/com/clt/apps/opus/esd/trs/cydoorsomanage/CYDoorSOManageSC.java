/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CYDoorSOManageSC.java
 *@FileTitle : CY & Door S/O Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esd.trs.cydoorsomanage;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBC;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBCImpl;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBCImpl;
import com.clt.apps.opus.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.basic.CombinedTransportationCaseTwoSOManageBC;
import com.clt.apps.opus.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.basic.CombinedTransportationCaseTwoSOManageBCImpl;
import com.clt.apps.opus.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.event.EsdTrs0920Event;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.basic.SingleTransportationSOManageBC;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.basic.SingleTransportationSOManageBCImpl;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0002Event;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0930Event;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.basic.WorkOrderManagementBC;
import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.basic.WorkOrderManagementBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.CoaBkgComIfVO;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * business transaction handling about cargoreleaseordermgt Business Logic ServiceCommand - cargoreleaseordermgt.<br>
 * 
 * @author
 * @see ESD_TRS_002EventResponse,SingleTransportationSOManageDBDAO
 * @since J2EE 1.4
 */
public class CYDoorSOManageSC extends ServiceCommandSupport {
	/**
	 * Action of business scenario that each event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsdTrs0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComboList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // ESD_TRS_0002
				eventResponse = searchSingleTransportationSOCandidatesList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) { // ESD_TRS_0002
				eventResponse = searchActualCustomerInfoSet(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) { // ESD_TRS_0002
				eventResponse = removeSOCandidate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) { // ESD_TRS_0002 : S/O Creation
				eventResponse = multiSingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) { // ESD_TRS_0051 (MODIFY => SEARCH13) S/O Correction
				eventResponse = modifySingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { // ESD_TRS_0051
				eventResponse = modify01SingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) { // ESD_TRS_0051 w/o issued
				eventResponse = modify02SingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) { // ESD_TRS_0051
				eventResponse = removeSingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // ESD_TRS_0051
				eventResponse = searchSingleTransportationSOList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) { // ESD_TRS_0051
				eventResponse = searchSingleTransportationSOList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchSubOfficeSOManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchOffHireVerify(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchCostMode(e);
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0930Event")) { // Transfer Office Change
			if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyOfficeTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { // Transfer Office Check
				eventResponse = modifyOfficeTransportationSOManageMT(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) { // Transfer Office Check
				eventResponse = search10TransportationSOManage(e);
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0920Event")) { // S/O Office Popup ( ESD_TRS_0964 )
			if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = search03ServiceOfficeCodeSOManage(e);
			} else {
				eventResponse = null;
			}
		}
		return eventResponse;
	}

	/**
	 * retrieve event handling<br>
	 * Display List of SingleTransportationSOManage event processing for a particular event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSingleTransportationSOCandidatesList(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		EventResponse eventResponse = new GeneralEventResponse();
		String lSeq = "";
		List<SingleTransportationVO> singleTransportationVO = new ArrayList<SingleTransportationVO>();
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		try {
			singleTransportationVO = command.searchSingleTransportationSOCandidatesListP(event);
			if (singleTransportationVO != null && !singleTransportationVO.isEmpty()) {
				lSeq = command.searchSingleTransportationSOCandidatesListK();

				begin();
				command.searchSingleTransportationSOCandidatesListC(event, singleTransportationVO, lSeq);
				commit();

				begin();
				command.searchSingleTransportationSOCandidatesListU(event, lSeq);
				commit();

				eventResponse = command.searchSingleTransportationSOCandidatesList(event, lSeq);

				begin();
				command.searchSingleTransportationSOCandidatesListD(lSeq);
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
	 * retrieve event handling<br>
	 * SingleTransportationSOManage screen views for event handling<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSingleTransportationSOList(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		EventResponse eventResponse = null;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		try {
			eventResponse = command.searchSingleTransportationSOList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Modified event handling<br>
	 * SingleTransportationSOManage modified event handling for the event<br>
	 * 
	 * CY&DOOR S/O CORRECTION
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		GeneralEventResponse eventResponse = null;
		ReplanManageBC replanManageBC = new ReplanManageBCImpl();
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		WorkOrderManagementBC workOrderManagementBC = new WorkOrderManagementBCImpl();
		List<TrsTrspSvcOrdVO> seqVoList = new ArrayList<TrsTrspSvcOrdVO>();
		try {
			String bkg_no = null;
			String frm_nod = null;
			String via_nod = null;
			String door_nod = null;
			String to_nod = null;
			String frm_nod2 = null;
			String via_nod2 = null;
			String door_nod2 = null;
			String to_nod2 = null;
			String crr_mod = null;
			String crr_mod2 = null;
			String cop_no = null;
			String cost_act_grp_seq = null;
			String eq_no = null;
			String cost_act_grp_cd = null;
			String trsp_bnd_cd = null;

			String repo_pln_id = null;
			String pln_yrwk = null;
			String ref_id = null;
			String ref_seq = null;

			String trsp_so_ofc_cty_cd = null;
			String trsp_so_seq = null;
			String rpln_umch_flg = null;
			String user_id = event.getSignOnUserAccount().getUsr_id();
			int rowCnt = 0; // S/O 단위로 처리하기 위한 Row count
			
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			CntrRepoExecutionPlanEstablishBC cntrRepoExecutionPlanEstablishBC = new CntrRepoExecutionPlanEstablishBCImpl();
			for (SingleTransportationVO vo : singleTransportationVOS) {
				begin();
				eventResponse = command.modifySingleTransportationSOManage(event, rowCnt++); // S/O 1건에 대해 Update 처리
				if (!vo.getEqNo().equals(vo.getBeforeEqNo())) {
					workOrderManagementBC.modifyWorkOrderExecuteDateByTrs(vo.getTrspSoOfcCtyCd(), vo.getTrspSoSeq(), vo.getTrspWoOfcCtyCd(), vo.getTrspWoSeq(), vo.getEqNo(), vo.getBkgNo(), user_id);
				}
				bkg_no = vo.getBkgNo();
				frm_nod = vo.getFmNodCd() + vo.getFmNodYard();
				via_nod = vo.getViaNodCd() + vo.getViaNodYard();
				door_nod = vo.getDorNodCd() + vo.getDorNodYard();
				to_nod = vo.getToNodCd() + vo.getToNodYard();
				frm_nod2 = vo.getFmNodCd2() + vo.getFmNodYard2();
				via_nod2 = vo.getViaNodCd2() + vo.getViaNodYard2();
				door_nod2 = vo.getDorNodCd2() + vo.getDorNodYard2();
				to_nod2 = vo.getToNodCd2() + vo.getToNodYard2();
				crr_mod = vo.getTrspCrrModCd();
				crr_mod2 = vo.getTrspCrrModCd2();

				cop_no = vo.getCopNo();
				cost_act_grp_seq = vo.getCostActGrpSeq();
				eq_no = vo.getEqNo();
				cost_act_grp_cd = vo.getCostActGrpCd();
				trsp_bnd_cd = vo.getTrspBndCd();
				if ("".equals(trsp_bnd_cd)) { // Bound Blank에 대한 처리
					trsp_bnd_cd = "T";
				}

				repo_pln_id = vo.getRepoPlnId();
				pln_yrwk = vo.getPlnYrwk();
				ref_id = vo.getRefId();
				ref_seq = vo.getRefSeq();

				trsp_so_ofc_cty_cd = vo.getTrspSoOfcCtyCd();
				trsp_so_seq = vo.getTrspSoSeq();
				rpln_umch_flg = vo.getRplnUmchFlg();

				if (!frm_nod.equals(frm_nod2) || !via_nod.equals(via_nod2) || !door_nod.equals(door_nod2) || !to_nod.equals(to_nod2) || !crr_mod.equals(crr_mod2)) {
					if (vo.getCgoTpCd().equals("F")) {
						// COA I/F
						CostAssignBC coaCommand = new CostAssignBCImpl();
						CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
						coaBkgComIfVo.setBkgNo(bkg_no);
						coaBkgComIfVo.setCostSrcSysCd("TRS");// TRS, TES, SCE, BKG등 SUB SYSTEM CODE
						coaBkgComIfVo.setIfRmk("S/O Modify");
						coaBkgComIfVo.setCreUsrId(user_id);
						coaBkgComIfVo.setUpdUsrId(user_id);

						int result_cnt = coaCommand.modifyCoaCommonInterface(coaBkgComIfVo);
						if (result_cnt < 0)
							throw new EventException((new ErrorHandler("TRS00099", new String[] { "COA I/F Error" })).getMessage());

						// COP Replan
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
						replanManageBC.replanCop(trsStsVO);
					}
				} else {
					if (vo.getCgoTpCd().equals("F")) {
						if (!rpln_umch_flg.equals("Y")) { // UnMatch a case does not update the status code.
							// COP TRS S/O Status Update
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
					} else {
						// EQR TRS S/O Status Update
						SingleTransportationVO trsStsVO = new SingleTransportationVO();
						trsStsVO.setTrspSoStsCd("R");
						trsStsVO.setUpdUsrId(user_id);
						trsStsVO.setRepoPlnId(repo_pln_id);
						trsStsVO.setPlnYrwk(pln_yrwk);
						trsStsVO.setRefId(ref_id);
						trsStsVO.setRefSeq(ref_seq);
						cntrRepoExecutionPlanEstablishBC.modifyFromTrsSOIFPlanSoSts(trsStsVO);
					}
				}
				TrsTrspSvcOrdVO seqVo = new TrsTrspSvcOrdVO();
				seqVo.setTrspSoSeq(trsp_so_seq);
				seqVoList.add(seqVo);
				commit();
			}
			eventResponse.setRsVoList(seqVoList);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Modified event handling<br>
	 * SingleTransportationSOManage modified event handling for the event<br>
	 * CY & DOOR S / O Correction Separate screens performed
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modify01SingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
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
	 * Modified event handling<br>
	 * SingleTransportationSOManage of the W / O Issued on modifying the event-handling<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modify02SingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		String usrId = null;
		EventResponse eventResponse = null;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		WorkOrderManagementBC workOrderManagementBC = new WorkOrderManagementBCImpl();
		try {
			begin();
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			eventResponse = command.modify02SingleTransportationSOManage(event);
			usrId = e.getSignOnUserAccount().getUsr_id();
			for (SingleTransportationVO vo : singleTransportationVOS) {
				if (!vo.getEqNo().equals(vo.getBeforeEqNo())) {
					workOrderManagementBC.modifyWorkOrderExecuteDateByTrs(vo.getTrspSoOfcCtyCd(), vo.getTrspSoSeq(), vo.getTrspWoOfcCtyCd(), vo.getTrspWoSeq(), vo.getEqNo(), vo.getBkgNo(), usrId);
				}
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
	 * CY & DOOR Correction S / O delete event handling<br>
	 * SingleTransportationSOManage delete event handling for the event<br>
	 * CY&DOOR S/O DELETE
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeSingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		EventResponse eventResponse = null;
		try {
			begin();
			String user_id = event.getSignOnUserAccount().getUsr_id();
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse = command.removeSingleTransportationSOManage(event);

			// For COP Replan
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			for (int i = 0; i < singleTransportationVOS.length; i++) {
				if (singleTransportationVOS[i].getCgoTpCd().equals("F")) {
					if ("Y".equals(singleTransportationVOS[i].getTrspRqstBkgFlg())) {
						CostAssignBC coaCommand = new CostAssignBCImpl();
						CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
						coaBkgComIfVo.setBkgNo(singleTransportationVOS[i].getBkgNo());
						coaBkgComIfVo.setCostSrcSysCd("TRS");// TRS, TES, SCE, BKG등 SUB SYSTEM CODE
						coaBkgComIfVo.setIfRmk("S/O delete");
						coaBkgComIfVo.setCreUsrId(user_id);
						coaBkgComIfVo.setUpdUsrId(user_id);
						int result_cnt = coaCommand.modifyCoaCommonInterface(coaBkgComIfVo);
						if (result_cnt < 0)
							throw new EventException((new ErrorHandler("TRS00099", new String[] { "COA I/F Error" })).getMessage());
					}
				}
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
	 * Check the presence of IRG<br>
	 * SingleTransportationSOManage multi-event processing for the event<br>
	 * CY&DOOR S/O CREATION A. S / O before issuing the appropriate section to see if there's IRG.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public int verifySingleTransportationSOIRG(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		int result_cnt = 0;
		try {
			String frm_nod = null;
			String via_nod = null;
			String door_nod = null;
			String to_nod = null;
			String frm_nod2 = null;
			String via_nod2 = null;
			String door_nod2 = null;
			String to_nod2 = null;
			String crr_mod = null;
			String crr_mod2 = null;
			String bnd_cd = null;

			String cgo_tp_cd = null;

			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			for (int i = 0; i < singleTransportationVOS.length; i++) {
				frm_nod = singleTransportationVOS[i].getFmNodCd() + singleTransportationVOS[i].getFmNodYard();
				via_nod = singleTransportationVOS[i].getViaNodCd() + singleTransportationVOS[i].getViaNodYard();
				door_nod = singleTransportationVOS[i].getDorNodCd() + singleTransportationVOS[i].getDorNodYard();
				to_nod = singleTransportationVOS[i].getToNodCd() + singleTransportationVOS[i].getToNodYard();
				frm_nod2 = singleTransportationVOS[i].getFmNodCd2() + singleTransportationVOS[i].getFmNodYard2();
				via_nod2 = singleTransportationVOS[i].getViaNodCd2() + singleTransportationVOS[i].getViaNodYard2();
				door_nod2 = singleTransportationVOS[i].getDorNodCd2() + singleTransportationVOS[i].getDorNodYard2();
				to_nod2 = singleTransportationVOS[i].getToNodCd2() + singleTransportationVOS[i].getToNodYard2();
				crr_mod = singleTransportationVOS[i].getTrspCrrModCd();
				crr_mod2 = singleTransportationVOS[i].getTrspCrrModCd2();
				cgo_tp_cd = singleTransportationVOS[i].getCgoTpCd();
				bnd_cd = singleTransportationVOS[i].getTrspBndCd();

				if (!frm_nod.equals(frm_nod2) || !via_nod.equals(via_nod2) || !door_nod.equals(door_nod2) || !to_nod.equals(to_nod2) || !crr_mod.equals(crr_mod2)) {
					if (cgo_tp_cd.equals("F")) {
						if (!(bnd_cd.equals("T") || (bnd_cd.equals("O") && !door_nod2.equals("") && !frm_nod.equals(frm_nod2)) || (bnd_cd.equals("I") && !door_nod2.equals("") && !to_nod
								.equals(to_nod2)))) {
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
	 * Multi-event processing<br>
	 * SingleTransportationSOManage multi-event processing for the event<br>
	 * CY&DOOR S/O CREATION 1. S/O Creation 2. COA I/F 3. COP Replan, COP S / O status code UPDATE 4. EQR S / O status code UPDATE
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiSingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			String bkg_no = null;
			String frm_nod = null;
			String via_nod = null;
			String door_nod = null;
			String to_nod = null;
			String frm_nod2 = null;
			String via_nod2 = null;
			String door_nod2 = null;
			String to_nod2 = null;
			String crr_mod = null;
			String crr_mod2 = null;

			String cop_no = null;
			String cost_act_grp_seq = null;
			String eq_no = null;
			String cost_act_grp_cd = null;
			String trsp_bnd_cd = null;

			String repo_pln_id = null;
			String pln_yrwk = null;
			String ref_id = null;
			String ref_seq = null;

			String trsp_so_ofc_cty_cd = null;
			String trsp_so_seq = null;
			String sdy_sep = "";
			String so_no = "";

			List<TrsTrspSvcOrdVO> seqVoList = new ArrayList<TrsTrspSvcOrdVO>();
			String user_id = event.getSignOnUserAccount().getUsr_id();
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();

			// COP Replan and S / O status code for the UPDATE
			ReplanManageBC replanManageBC = new ReplanManageBCImpl();
			CntrRepoExecutionPlanEstablishBC cntrRepoExecutionPlanEstablishBC = new CntrRepoExecutionPlanEstablishBCImpl();

			for (int i = 0; i < singleTransportationVOS.length; i++) {
				begin();
				command.verifySingleTransportationDupChk(event, i); // S / O gibalhaeng check whether
				so_no = command.multiSingleTransportationSOManage(event, i);
				TrsTrspSvcOrdVO seqVo = new TrsTrspSvcOrdVO();
				seqVo.setTrspSoSeq(String.valueOf(so_no));
				seqVoList.add(seqVo);

				bkg_no = singleTransportationVOS[i].getBkgNo();
				frm_nod = singleTransportationVOS[i].getFmNodCd() + singleTransportationVOS[i].getFmNodYard();
				via_nod = singleTransportationVOS[i].getViaNodCd() + singleTransportationVOS[i].getViaNodYard();
				door_nod = singleTransportationVOS[i].getDorNodCd() + singleTransportationVOS[i].getDorNodYard();
				to_nod = singleTransportationVOS[i].getToNodCd() + singleTransportationVOS[i].getToNodYard();
				frm_nod2 = singleTransportationVOS[i].getFmNodCd2() + singleTransportationVOS[i].getFmNodYard2();
				via_nod2 = singleTransportationVOS[i].getViaNodCd2() + singleTransportationVOS[i].getViaNodYard2();
				door_nod2 = singleTransportationVOS[i].getDorNodCd2() + singleTransportationVOS[i].getDorNodYard2();
				to_nod2 = singleTransportationVOS[i].getToNodCd2() + singleTransportationVOS[i].getToNodYard2();
				crr_mod = singleTransportationVOS[i].getTrspCrrModCd();
				crr_mod2 = singleTransportationVOS[i].getTrspCrrModCd2();

				cop_no = singleTransportationVOS[i].getCopNo();
				cost_act_grp_seq = singleTransportationVOS[i].getCostActGrpSeq();
				eq_no = singleTransportationVOS[i].getEqNo();
				trsp_bnd_cd = CheckUtilities.isNullOrNullStringReplacement(singleTransportationVOS[i].getTrspBndCd(), "T");

				// If you change the Trans Mode cost_act_grp_cd new combination because there will be newly created.
				// cost_act_grp_cd = singleTransportationVOS[i].getCostActGrpCd();
				if (String.valueOf(singleTransportationVOS[i].getTrspCostDtlModCd()).equals("DR")) { // Changes in the DR-value in DAO DOOR.
					sdy_sep = "D";
				} else {
					sdy_sep = "Y";
				}

				cost_act_grp_cd = CheckUtilities.isNullOrNullStringReplacement(singleTransportationVOS[i].getTrspBndCd(), "T") + sdy_sep + singleTransportationVOS[i].getTrspCrrModCd();
				singleTransportationVOS[i].setCostActGrpCd(cost_act_grp_cd);

				repo_pln_id = singleTransportationVOS[i].getRepoPlnId();
				pln_yrwk = singleTransportationVOS[i].getPlnYrwk();
				ref_id = singleTransportationVOS[i].getRefId();
				ref_seq = singleTransportationVOS[i].getRefSeq();

				// S / O NO was set at the DAO. (SC and Call by Reference of the DAO object singleTransportationVOS value is shared in a way.)
				trsp_so_ofc_cty_cd = singleTransportationVOS[i].getTrspSoOfcCtyCd().substring(0, 3);
				trsp_so_seq = singleTransportationVOS[i].getTrspSoSeq();

				if (!frm_nod.equals(frm_nod2) || !via_nod.equals(via_nod2) || !door_nod.equals(door_nod2) || !to_nod.equals(to_nod2) || !crr_mod.equals(crr_mod2)) {
					if (singleTransportationVOS[i].getCgoTpCd().equals("F")) {
						// S / O History Record issued
						command.multiSoIssueBeforeHis(singleTransportationVOS[i], "Replan");

						// COA I/F
						CostAssignBC coaCommand = new CostAssignBCImpl();
						CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
						coaBkgComIfVo.setBkgNo(bkg_no);
						coaBkgComIfVo.setCostSrcSysCd("TRS");// TRS, TES, SCE, BKG등 SUB SYSTEM CODE
						coaBkgComIfVo.setIfRmk("S/O Create");
						coaBkgComIfVo.setCreUsrId(user_id);
						coaBkgComIfVo.setUpdUsrId(user_id);

						int result_cnt = coaCommand.modifyCoaCommonInterface(coaBkgComIfVo);
						if (result_cnt < 0)
							throw new EventException((new ErrorHandler("TRS00099", new String[] { "COA I/F Error" })).getMessage());

						// COP Replan
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

						replanManageBC.replanCop(trsStsVO);

						// S / O issuance SCE History Record table
						command.multiSoIssueAfterHis(singleTransportationVOS[i], "Replan");
					}
				} else {
					if (singleTransportationVOS[i].getCgoTpCd().equals("F")) {
						// S / O History Record issued
						command.multiSoIssueBeforeHis(singleTransportationVOS[i], "Sts");

						// COP TRS S/O Status Update
						SingleTransportationVO trsStsVO = new SingleTransportationVO();
						trsStsVO.setTrspSoStsCd("C");
						trsStsVO.setUpdUsrId(user_id);
						trsStsVO.setCopNo(cop_no);
						trsStsVO.setCostActGrpSeq(cost_act_grp_seq);
						trsStsVO.setTrspBndCd(trsp_bnd_cd);
						trsStsVO.setTrspSoOfcCtyCd(trsp_so_ofc_cty_cd);
						trsStsVO.setTrspSoSeq(trsp_so_seq);
						replanManageBC.modifySoList(trsStsVO);

						// S / O issuance SCE History Record table
						command.multiSoIssueAfterHis(singleTransportationVOS[i], "Sts");
					} else {
						// EQR TRS S/O Status Update
						SingleTransportationVO trsStsVO = new SingleTransportationVO();
						trsStsVO.setTrspSoStsCd("C");
						trsStsVO.setUpdUsrId(user_id);
						trsStsVO.setRepoPlnId(repo_pln_id);
						trsStsVO.setPlnYrwk(pln_yrwk);
						trsStsVO.setRefId(ref_id);
						trsStsVO.setRefSeq(ref_seq);
						cntrRepoExecutionPlanEstablishBC.modifyFromTrsSOIFPlanSoSts(trsStsVO);
					}
				}
				commit();
			}
			eventResponse.setRsVoList(seqVoList);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		}
		return eventResponse;
	}

	/**
	 * Modified event handling<br>
	 * SingleTransportationSOManage modified event handling for the event<br>
	 * Transfer Office <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyOfficeTransportationSOManage(Event e) throws EventException {
		EsdTrs0930Event event = (EsdTrs0930Event) e;
		EventResponse eventResponse = null;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		try {
			begin();
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
		EsdTrs0930Event event = (EsdTrs0930Event) e;
		EventResponse eventResponse = null;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		try {
			begin();
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
	 * retrieve event handling<br>
	 * SingleTransportationSOManage modified event handling for the event<br>
	 * Transfer Office <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search10TransportationSOManage(Event e) throws EventException {
		EsdTrs0930Event event = (EsdTrs0930Event) e;
		EventResponse eventResponse = null;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		try {
			eventResponse = command.search10TransportationSOManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event handling<br>
	 * SingleTransportationSOManage modified event handling for the event<br>
	 * Sub Office <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubOfficeSOManageList(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		EventResponse eventResponse = null;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		try {
			eventResponse = command.searchSubOfficeSOManageList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event handling<br>
	 * Actual Customer Info Change cause from Door Location/Zone Modification <br>
	 * Sub Office <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private GeneralEventResponse searchActualCustomerInfoSet(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		GeneralEventResponse eventResponse = null;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		try {
			eventResponse = command.searchActualCustomerInfoSet(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event handling<br>
	 * Actual Customer Info Change cause from Door Location/Zone Modification <br>
	 * Sub Office <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeSOCandidate(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<SingleTransportationVO> sub_models = new ArrayList<SingleTransportationVO>();
		try {
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();

			String bkg_no = null;
			String user_id = event.getSignOnUserAccount().getUsr_id();
			String cop_no = null;
			String cost_act_grp_seq = null;
			String trsp_bnd_cd = null;
			String trsp_so_ofc_cty_cd = null;
			String trsp_so_seq = null;

			begin();
			sub_models = command.removeSOCandidate(event);

			ReplanManageBC replanManageBC = new ReplanManageBCImpl();
			for (int m = 0; sub_models != null && m < sub_models.size(); m++) {
				SingleTransportationVO model = (SingleTransportationVO) sub_models.get(m);
				bkg_no = model.getBkgNo();
				cop_no = model.getCopNo();
				cost_act_grp_seq = model.getCostActGrpSeq();
				trsp_bnd_cd = model.getTrspBndCd();
				trsp_so_ofc_cty_cd = model.getTrspSoOfcCtyCd();
				trsp_so_seq = model.getTrspSoSeq();
				// COA I/F
				if (bkg_no != null) {
					CostAssignBC coaCommand = new CostAssignBCImpl();
					CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
					coaBkgComIfVo.setBkgNo(bkg_no);
					coaBkgComIfVo.setCostSrcSysCd("TRS");// TRS, TES, SCE, BKG - SUB SYSTEM CODE
					coaBkgComIfVo.setIfRmk("S/O Candidate Delete");
					coaBkgComIfVo.setCreUsrId(user_id);
					coaBkgComIfVo.setUpdUsrId(user_id);
					int result_cnt = coaCommand.modifyCoaCommonInterface(coaBkgComIfVo);
					if (result_cnt < 0) // If the value is less than 0 errors result
						throw new EventException((new ErrorHandler("TRS00099", new String[] { "COA I/F Error" })).getMessage());
				}

				// COP TRS S/O Status Update
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
	 * retrieve event handling<br>
	 * Off Hire Verify Check <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private GeneralEventResponse searchOffHireVerify(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		GeneralEventResponse eventResponse = null;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		try {
			eventResponse = command.searchOffHireVerify(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event handling<br>
	 * Off Hire Verify Check <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private GeneralEventResponse searchCostMode(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		GeneralEventResponse eventResponse = null;
		try {
			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			eventResponse = command.searchCostMode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event handling<br>
	 * SingleTransportationSOManage modified event handling for the event<br>
	 * Sub Office <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search03ServiceOfficeCodeSOManage(Event e) throws EventException {
		EsdTrs0920Event event = (EsdTrs0920Event) e;
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
	 * Combo Search
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComboList(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse = command.searchMdmCntrTpSz(event);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
}
