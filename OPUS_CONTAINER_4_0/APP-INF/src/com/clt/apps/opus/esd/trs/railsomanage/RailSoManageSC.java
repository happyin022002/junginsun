/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : RailSoManageSC.java
 *@FileTitle : USA Rail Billing S/O Create
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBCImpl;
import com.clt.apps.opus.esd.trs.railsomanage.railsomanage.basic.RailSoManageBC;
import com.clt.apps.opus.esd.trs.railsomanage.railsomanage.basic.RailSoManageBCImpl;
import com.clt.apps.opus.esd.trs.railsomanage.railsomanage.event.EsdTrs0201Event;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaBkgComIfVO;
import com.clt.syscommon.common.table.TrsTrspRailBilOrdVO;

/**
 * TRS Business Logic ServiceCommand<br>
 * TRS handling business transaction.<br>
 * 
 * @author
 * @see ESD_TRS_029EventResponse,RailSoManageDBDAO
 * @since
 */
public class RailSoManageSC extends ServiceCommandSupport {
	private SignOnUserAccount account = null;
	private String sofficeCd = "";
	private String userId = "";

	/**
	 * Generating the implicit object when AgreementFileImport task is called.<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
			sofficeCd = account.getOfc_cd();
			userId = account.getUsr_id();
		} catch (Exception e) {
			log.error("RailSoManageSC Error when preceding process " + e.toString(), e);
		}
	}

	/**
	 * TRS Biz scenario closing<br>
	 * RailSoManage clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("RailSoManageSC End");
	}

	/**
	 * Performing the task scenario corresponding each event.<br>
	 * Branch processing of every event occurring at ESD-TRS task<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsdTrs0201Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // ESD_TRS_0928 retrieve
				eventResponse = search04RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) { // Request Service Provider Inquiry 956
				eventResponse = search13RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) { // ESD_TRS_0928 retrieve AND ESD_TRS_0953 retrieve
				eventResponse = searchIrgCandidate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // ESD_TRS_204 Correction retrieve
				eventResponse = searchRailSoCorrectionTargetList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) { // ESD_TRS_204 Delete
				eventResponse = removeRailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) { // ESD_TRS_204 Correction
				eventResponse = modifyRailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) { // ESD_TRS_203(Empty Repo) retrieve
				eventResponse = search08RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) { // ESD_TRS_203(Empty Repo) 하위 sheet retrieve
				eventResponse = search09RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Cancel REQ Reject 959
				eventResponse = multi01RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) { // ESD_TRS_203 Verify check retrieve
				eventResponse = search11RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // ESD_TRS_203 Empty S/O Creation
				eventResponse = multi02RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // ESD_TRS_201 In Bound Verify
				eventResponse = search02RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // SO Creation save
				eventResponse = multiRailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) { // ESD_TRS_202 Out Bound Verify
				eventResponse = search07RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) { // ESD_TRS_202(COP) retrieve Out Bound
				eventResponse = searchRailsoBybkgcntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // ESD_TRS_201(COP) retrieve In Bound
				eventResponse = search01RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) { // ESD_TRS_202(COP) retrieve Out Bound
				eventResponse = search06RailSoManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) { // ESD_TRS_203 EQ Verify check retrieve
				eventResponse = search14RailSoManage(e);
			} else {
				eventResponse = null;
			}
		}

		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP In Bound<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search01RailSoManage(Event e) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
		EventResponse eventResponse = new GeneralEventResponse();
		List<TrsTrspRailBilOrdVO> trsTrspRailBilOrdVO = new ArrayList<TrsTrspRailBilOrdVO>();
		try {
			RailSoManageBC command = new RailSoManageBCImpl();
			trsTrspRailBilOrdVO = command.search01RailSoManageSel(event);
			if (trsTrspRailBilOrdVO != null && !trsTrspRailBilOrdVO.isEmpty()) {
				String lSeq = command.search01RailSoManageSeq();

				begin();
				command.search01RailSoManageIns(trsTrspRailBilOrdVO, lSeq, event.getUserid());
				commit();

				begin();
				command.search01RailSoManageUpd(lSeq);
				commit();

				eventResponse = command.search01RailSoManage(lSeq, event);
				begin();
				command.search01RailSoManageDel(lSeq);
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
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP Out Bound<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search06RailSoManage(Event e) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
		EventResponse eventResponse = new GeneralEventResponse();
		List<TrsTrspRailBilOrdVO> trsTrspRailBilOrdVO = new ArrayList<TrsTrspRailBilOrdVO>();
		String lSeq = "";
		try {
			RailSoManageBC command = new RailSoManageBCImpl();
			trsTrspRailBilOrdVO = command.search06RailSoManageSel(event);
			if (trsTrspRailBilOrdVO != null && !trsTrspRailBilOrdVO.isEmpty()) {
				lSeq = command.search01RailSoManageSeq();
				begin();
				command.search06RailSoManageIns(trsTrspRailBilOrdVO, lSeq, event.getUserid());
				commit();

				begin();
				command.search06RailSoManageUpd(lSeq);
				commit();

				eventResponse = command.search06RailSoManage(lSeq, event);
				begin();
				command.search06RailSoManageDel(lSeq);
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
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP Out Bound<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRailsoBybkgcntr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event) e;
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
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * Empty Repo<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search08RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event) e;
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
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * Empty Repo<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search09RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event) e;
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
	 * retrieve event process<br>
	 * a query for a specific list of RailSoManage <br>
	 * Correction<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRailSoCorrectionTargetList(Event e) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
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
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * Empty Verify Check<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search11RailSoManage(Event e) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
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
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * Request Service Provider Inquiry Popup<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search13RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event) e;
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
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * Request Empty Container Check<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search14RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event) e;
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
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * Verify<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search02RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event) e;
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
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search04RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event) e;
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
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * Possible Candidates For IRG Adjust<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrgCandidate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event) e;
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
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * Verify<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search07RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event) e;
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
	 * modify event process<br>
	 * RailSoManageForNoTranjection modify event process<br>
	 * US Rail Billing - Correction
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyRailSoManage(Event e) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
		EventResponse eventResponse = null;
		RailSoManageBC command = new RailSoManageBCImpl();

		try {
			String frmNod = null;
			String toNod = null;
			String interNod1 = null;
			String interNod2 = null;
			String orgFrmNod = null;
			String orgToNod = null;
			String orgInterNod1 = null;
			String orgInterNod2 = null;
			// COP Replan
			ReplanManageBC replanManageBC = new ReplanManageBCImpl();
			TrsTrspRailBilOrdVO[] svcModels = event.getTrsTrspRailBilOrdVos();

			// COA dup ckeck
			for (int i = 0; i < svcModels.length - 1; i++) {
				for (int j = i + 1; j < svcModels.length; j++) {
					if (svcModels[j].getBkgNo().equals(svcModels[i].getBkgNo())) {
						svcModels[j].setN3ptyBilFlg("Y");
					}
				}
			}
			begin();
			for (int k = 0; event.getTrsTrspRailBilOrdVos() != null && k < event.getTrsTrspRailBilOrdVos().length; k++) {
				eventResponse = command.modifyRailSoManage(event, k);
				command.multiProcRailSoManageForWRS(event, k, eventResponse.getCustomData(), event.getSctrlOfcCd());
				frmNod = svcModels[k].getFmNodCd() + svcModels[k].getFmNodYard();
				toNod = svcModels[k].getToNodCd() + svcModels[k].getToNodYard();
				interNod1 = svcModels[k].getInterchange1Loc() + svcModels[k].getInterchange1Nod();
				interNod2 = svcModels[k].getInterchange2Loc() + svcModels[k].getInterchange2Nod();
				orgFrmNod = svcModels[k].getOrgFmNodCd() + svcModels[k].getOrgFmNodYard();
				orgToNod = svcModels[k].getOrgToNodCd() + svcModels[k].getOrgToNodYard();
				orgInterNod1 = svcModels[k].getOrgInterchange1Loc() + svcModels[k].getOrgInterchange1Nod();
				orgInterNod2 = svcModels[k].getOrgInterchange2Loc() + svcModels[k].getOrgInterchange2Nod();

				if (!frmNod.equals(orgFrmNod) || !interNod1.equals(orgInterNod1) || !interNod2.equals(orgInterNod2) || !toNod.equals(orgToNod)) {
					if (svcModels[k].getCgoTpCd().equals("F")) {
						if (!svcModels[k].getN3ptyBilFlg().equals("Y")) {
							// COA I/F
							CostAssignBC coaCommand = new CostAssignBCImpl();
							CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
							coaBkgComIfVo.setBkgNo(svcModels[k].getBkgNo());
							coaBkgComIfVo.setCostSrcSysCd("TRS");// TRS, TES, SCE, BKG SUB SYSTEM CODE
							coaBkgComIfVo.setIfRmk("US RAIL S/O Mofify");
							coaBkgComIfVo.setCreUsrId(userId);
							coaBkgComIfVo.setUpdUsrId(userId);

							int result_cnt = coaCommand.modifyCoaCommonInterface(coaBkgComIfVo);
							if (result_cnt < 0)
								throw new EventException((new ErrorHandler("SAQ00099", new String[] { "COA I/F Error" })).getMessage());
						}

						svcModels[k].setTrspSoStsCd("R");

						// COP Replan
						if ("Y".equals(svcModels[k].getUplnSoFlg())) {
							svcModels[k].setUplnSoFlg("USRAIL_UNPLAN");
						} else {
							svcModels[k].setUplnSoFlg("");
						}
						replanManageBC.replanCop(svcModels[k]);
					}
				} else {
					if (svcModels[k].getCgoTpCd().equals("F") && !("Y".equals(svcModels[k].getUplnSoFlg()))) {
						svcModels[k].setTrspSoStsCd("R");

						// COP TRS S/O Status Update
						replanManageBC.modifySoList(svcModels[k]);
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
	 * delete event process<br>
	 * RailSoManage delete event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeRailSoManage(Event e) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
		EventResponse eventResponse = null;
		RailSoManageBC command = new RailSoManageBCImpl();
		ReplanManageBC replanManageBC = new ReplanManageBCImpl();
		try {
			begin();
			eventResponse = command.removeRailSoManage(event);
			TrsTrspRailBilOrdVO[] model = event.getTrsTrspRailBilOrdVos();
			for (int i = 0; i < model.length; i++) {
				if (model[i].getCgoTpCd().equals("F") && !("Y".equals(model[i].getUplnSoFlg()))) {
					if (model[i].getTrspRqstBkgFlg().equals("Y")) {
						model[i].setTrspSoStsCd("D");
					} else {
						model[i].setTrspSoStsCd("P");
					}
					model[i].setRvisIndFlg("Y");
					replanManageBC.modifySoList(model[i]);
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
	 * multi event process<br>
	 * RailSoManageForNoTranjection multi event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRailSoManage(Event e) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
		EventResponse eventResponse = null;
		RailSoManageBC command = new RailSoManageBCImpl();

		try {
			String frmNod = null;
			String interNod1 = null;
			String interNod2 = null;
			String toNod = null;
			String orgFrmNod = null;
			String orgToNod = null;
			String orgInterNod1 = null;
			String orgInterNod2 = null;
			// COP Replan
			ReplanManageBC replanManageBC = new ReplanManageBCImpl();// BC create
			TrsTrspRailBilOrdVO[] svcModels = event.getTrsTrspRailBilOrdVos();

			for (int i = 0; i < svcModels.length - 1; i++) {
				for (int j = i + 1; j < svcModels.length; j++) {
					if (svcModels[j].getBkgNo().equals(svcModels[i].getBkgNo())) {
						svcModels[j].setN3ptyBilFlg("Y");
					}
				}
			}

			for (int k = 0; svcModels != null && k < svcModels.length; k++) {
				begin();
				eventResponse = command.multiRailSoManage(event, k);
				command.multiProcRailSoManageForNoTranjection(eventResponse.getCustomData(), event.getSctrlOfcCd()); // Procedure Call

				frmNod = svcModels[k].getFmNodCd() + svcModels[k].getFmNodYard();
				interNod1 = svcModels[k].getInterchange1Loc() + svcModels[k].getInterchange1Nod();
				interNod2 = svcModels[k].getInterchange2Loc() + svcModels[k].getInterchange2Nod();
				toNod = svcModels[k].getToNodCd() + svcModels[k].getToNodYard();
				orgFrmNod = svcModels[k].getOrgFmNodCd() + svcModels[k].getOrgFmNodYard();
				orgToNod = svcModels[k].getOrgToNodCd() + svcModels[k].getOrgToNodYard();
				orgInterNod1 = svcModels[k].getOrgInterchange1Loc() + svcModels[k].getOrgInterchange1Nod();
				orgInterNod2 = svcModels[k].getOrgInterchange2Loc() + svcModels[k].getOrgInterchange2Nod();
				if (!frmNod.equals(orgFrmNod) || !interNod1.equals(orgInterNod1) || !interNod2.equals(orgInterNod2) || !toNod.equals(orgToNod)) {
					if (svcModels[k].getCgoTpCd().equals("F") || svcModels[k].getCgoTpCd().equals("R")) {
						if (!svcModels[k].getN3ptyBilFlg().equals("Y")) {
							CostAssignBC coaCommand = new CostAssignBCImpl();
							CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
							coaBkgComIfVo.setBkgNo(svcModels[k].getBkgNo());
							coaBkgComIfVo.setCostSrcSysCd("TRS");
							coaBkgComIfVo.setIfRmk("US RAIL S/O Creation");
							coaBkgComIfVo.setCreUsrId(userId);
							coaBkgComIfVo.setUpdUsrId(userId);
							int result_cnt = coaCommand.modifyCoaCommonInterface(coaBkgComIfVo);
							if (result_cnt < 0) {
								throw new EventException((new ErrorHandler("SAQ00099", new String[] { "COA I/F Error" })).getMessage());
							}
						}
						svcModels[k].setTrspSoStsCd("C");

						// COP Replan
						if ("Y".equals(svcModels[k].getUplnSoFlg())) {
							svcModels[k].setUplnSoFlg("USRAIL_UNPLAN");
						} else {
							svcModels[k].setUplnSoFlg("");
						}
						replanManageBC.replanCop(svcModels[k]);
					}
				} else {
					if (("F".equals(svcModels[k].getCgoTpCd()) || "R".equals(svcModels[k].getCgoTpCd())) && !("Y".equals(svcModels[k].getUplnSoFlg()))) {
						svcModels[k].setTrspSoStsCd("C");
						replanManageBC.modifySoList(svcModels[k]);
					}
				}
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
	 * multi event process<br>
	 * RailSoManage multi event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multi02RailSoManage(Event e) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
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
			if (de.toString().indexOf("Transaction timed out") > -1) {
				eventResponse = multi02RailSoManageForNoTranjection(e);
			} else {
				throw new EventException(de.getMessage());
			}
		}
		return eventResponse;
	}

	/**
	 * multi event process<br>
	 * RailSoManageForNoTranjection multi event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multi02RailSoManageForNoTranjection(Event e) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
		EventResponse eventResponse = null;
		RailSoManageBC command = new RailSoManageBCImpl();
		try {
			TrsTrspRailBilOrdVO[] svcModels = event.getTrsTrspRailBilOrdVos();

			for (int k = 0; svcModels != null && k < svcModels.length; k++) {
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
	 * multi event process<br>
	 * RailSoManage Cancel REQ Reject event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multi01RailSoManage(Event e) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
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
}