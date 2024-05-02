/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NetworkLinkManageUsaSC.java
 *@FileTitle : NetworkLinkManageUsa Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage;

import java.util.List;

import com.clt.apps.opus.esd.prd.common.prdcommon.basic.PrdCommonManageBC;
import com.clt.apps.opus.esd.prd.common.prdcommon.basic.PrdCommonManageBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.basic.InlandRouteManageBC;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.basic.InlandRouteManageBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.basic.InlandRouteManageUsaBC;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.basic.InlandRouteManageUsaBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.event.EsdPrd0057Event;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.event.EsdPrd0058Event;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteMsUSVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteUSDetVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.lnlandRouteUSVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * PRD Business Logic ServiceCommand<br>
 * handling business transaction of PRD<br>
 * @author jungsunyong
 * @see ESD_PRD_004EventResponse,HubLocationMatchingManageDBDAO
 * @since J2EE 1.4
 */
public class NetworkLinkManageUsaSC extends ServiceCommandSupport {
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
		log.debug("NetworkLinkManageUsaSC End");
	}

	/**
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		/*
		 * Inland Route Manage
		 */
		if (e.getEventName().equalsIgnoreCase("EsdPrd0057Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // mst
				eventResponse = searchInlandRouteMasterUSA(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // detail
				eventResponse = searchInlandRouteDetailUSA(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Country
				eventResponse = searchCntOfContiUSA(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // DETAIL SAVE.
				eventResponse = saveInlandRouteDetailUSA(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // saving mst
				eventResponse = saveInlandRouteMasterUSA(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // DETAIL SAVE AS
				eventResponse = saveAsInlandRouteDetailUSA(e);
			}
		}
		/*
		 * Priority POPUP
		 */
		if (e.getEventName().equalsIgnoreCase("EsdPRD0058Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // mst
				eventResponse = searchInlandRouteMasterPopUSA(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = saveInlandRoutePriorityUSA(e);
			}
		}

		return eventResponse;
	}

	/**
	 * NetworkLinkManageUsaSC's saveAsInlandRouteDetailUSA
	 * @param e
	 * @return
	 * @throws EventException EventResponse
	 */
	private EventResponse saveAsInlandRouteDetailUSA(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0057Event event = (EsdPrd0057Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();
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
				event.getInlandRouteMsUSVO().setNodTpCd2(event.getInlandRouteMsUSVO().getNodTpCd1());
				try {
					begin();
					String newRoutSeq = command.saveAsInlandRouteManage(event.getInlandRouteUSDetVOs(), event.getInlandRouteMsUSVO(), account);
					event.getInlandRouteMsUSVO().setIRoutSeq(newRoutSeq);
					eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());

					commit();
				} catch (EventException ee) {
					log.error(ee.getMessage(), ee);
					rollback();
					eventResponse.setETCData("strErrMsg", ee.getMessage());
				}
			}
		} catch (EventException ex) {
			log.error(ex.getMessage(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * NetworkLinkManageUsaSC's saveInlandRoutePriorityUSA
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse saveInlandRoutePriorityUSA(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsdPrd0058Event event = (EsdPrd0058Event) e;
		InlandRouteManageUsaBC command = new InlandRouteManageUsaBCImpl();
		try {
			begin();
			command.saveInlandRoutePriorityUSA(event.getInlandRouteUSVOs(), account);
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
	 * NetworkLinkManageUsaSC's saveInlandRouteMasterUSA
	 * @param e
	 * @return
	 * @throws EventException EventResponse
	 */
	private EventResponse saveInlandRouteMasterUSA(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0057Event event = (EsdPrd0057Event) e;
		InlandRouteManageUsaBC command = new InlandRouteManageUsaBCImpl();
		try {
			begin();
			command.saveInlandRouteMasterUSA(event.getInlandRouteUSVOs(), event.getInlandRouteUSVO(), account);
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
	 * NetworkLinkManageUsaSC's saveInlandRouteDetailUSA
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse saveInlandRouteDetailUSA(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0057Event event = (EsdPrd0057Event) e;
		InlandRouteManageBC command = new InlandRouteManageBCImpl();
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
						while (dbRowSet.next()) {
							String deltFlg = dbRowSet.getString("DELT_FLG");
							if ("N".equals(deltFlg)) {
								eventResponse.setETCData("strErrMsg", "Exist Inland route.");
								return eventResponse;
							}
						}
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
	 * NetworkLinkManageUsaSC's searchInlandRouteDetailUSA
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchInlandRouteDetailUSA(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0057Event event = (EsdPrd0057Event) e;
		InlandRouteManageUsaBC command = new InlandRouteManageUsaBCImpl();

		try {
			SearchConditionVO searchConditionVO = event.getSearchConditionVO();
			List<InlandRouteUSDetVO> list = command.searchInlandRouteDetailUSA(searchConditionVO);

			for (int i = 0; i < list.size(); i++) {
				list.get(i).setVndrName(list.get(i).getVndrAbbrNm());
				list.get(i).setTztmHrs(list.get(i).getFmtTztmHrs());
				list.get(i).setRefeNo(list.get(i).getAgmtRefNo());
				list.get(i).setCombinedMd(list.get(i).getInlndRoutCmbFlg().equals("Y") ? list.get(i).getInlndRoutCmbFlg() : "");
				list.get(i).setClonTrspModCd(list.get(i).getTrspModCd());
				list.get(i).setSelRow(searchConditionVO.getISelrow());

				list.get(i).setClonVndrSeq(list.get(i).getVndrSeq());
				list.get(i).setClonAgmtNo(list.get(i).getAgmtNo());
				list.get(i).setClonCombinedMd(list.get(i).getInlndRoutCmbFlg().equals("Y") ? list.get(i).getInlndRoutCmbFlg() : "");
				list.get(i).setClonRailCrrTpCd(list.get(i).getRailCrrTpCd());
				list.get(i).setClonInlndRoutJuncNm(list.get(i).getInlndRoutJuncNm());

				if (i == 0) {
					eventResponse.setETCData("i_inv", list.get(i).getInlndRoutInvBilPattCd());
					eventResponse.setETCData("i_rout_pln_cd", list.get(i).getRoutPlnCd());
					eventResponse.setETCData("i_route_rmk", list.get(i).getInlndRoutRmk());
					eventResponse.setETCData("i_wrs_fl_cd", list.get(i).getWrsFullCmdtCd());
					eventResponse.setETCData("wrs_f_chk", list.get(i).getWrsFullCmdt());
					eventResponse.setETCData("i_wrs_mt_cd", list.get(i).getWrsMtyCmdtCd());
					eventResponse.setETCData("disable_bkg_flg", list.get(i).getCc());
					eventResponse.setETCData("i_bkg_flg", list.get(i).getInlndRoutBkgFlg().equals("Y") ? list.get(i).getInlndRoutBkgFlg() : "");
					eventResponse.setETCData("i_mcntr_rout_flg", list.get(i).getMcntrRoutFlg().equals("Y") ? list.get(i).getMcntrRoutFlg() : "");

				}

			}

			if (searchConditionVO.getIHubSearchGb().equals("Y")) {
				if (searchConditionVO.getIFrontGb().equals("F")) {
					InlandRouteUSDetVO itmFirst = new InlandRouteUSDetVO();
					itmFirst.setIbflag("I");
					itmFirst.setLnkOrgLoc(JSPUtil.getNull(searchConditionVO.getIUndefineNod().substring(0, 5)));
					itmFirst.setLnkOrgType(JSPUtil.getNull(searchConditionVO.getIUndefineNod().substring(5)));

					itmFirst.setLnkDestLoc(JSPUtil.getNull(searchConditionVO.getIRoutOrgNodCd().substring(0, 5)));
					itmFirst.setLnkDestType(JSPUtil.getNull(searchConditionVO.getIRoutOrgNodCd().substring(5)));

					itmFirst.setRoutDtlSeq(JSPUtil.getNull(searchConditionVO.getISelrow()));

					list.add(0, itmFirst);
				}
			}

			if (searchConditionVO.getIHubSearchGb().equals("Y")) {
				if (searchConditionVO.getIFrontGb().equals("B")) {
					InlandRouteUSDetVO itmLast = new InlandRouteUSDetVO();
					itmLast.setIbflag("I");
					itmLast.setLnkOrgLoc(JSPUtil.getNull(searchConditionVO.getIUndefineNod().substring(0, 5)));
					itmLast.setLnkOrgType(JSPUtil.getNull(searchConditionVO.getIUndefineNod().substring(5)));

					itmLast.setLnkDestLoc(JSPUtil.getNull(searchConditionVO.getIRoutOrgNodCd().substring(0, 5)));
					itmLast.setLnkDestType(JSPUtil.getNull(searchConditionVO.getIRoutOrgNodCd().substring(5)));

					itmLast.setRoutDtlSeq(JSPUtil.getNull(searchConditionVO.getISelrow()));

					list.add(list.size(), itmLast);
				}
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
	 * NetworkLinkManageUsaSC's searchInlandRouteMasterUSA
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchInlandRouteMasterUSA(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0057Event event = (EsdPrd0057Event) e;
		InlandRouteManageUsaBC command = new InlandRouteManageUsaBCImpl();
		try {
			List<lnlandRouteUSVO> list = command.searchInlandRouteMasterUSA(event.getInlandRouteUSVO());
			eventResponse.setRsVoList(list);
			StringBuilder comboArg = new StringBuilder();
			int maxPrioSeq = 0;
			if (list.size() > 0) {
				lnlandRouteUSVO itm = (lnlandRouteUSVO) list.get(0);
				maxPrioSeq = Integer.parseInt(itm.getMaxPrioSeq());
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
	 * NetworkLinkManageUsaSC's searchInlandRouteMasterPopUSA
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchInlandRouteMasterPopUSA(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0058Event event = (EsdPrd0058Event) e;
		InlandRouteManageUsaBC command = new InlandRouteManageUsaBCImpl();

		try {
			List<lnlandRouteUSVO> list = command.searchInlandRouteMasterUSA(event.getInlandRouteUSVO());
			eventResponse.setRsVoList(list);

			// setting ETC-DATA
			StringBuilder comboArg = new StringBuilder();
			int maxPrioSeq = 0;

			if (list.size() > 0) {
				lnlandRouteUSVO itm = (lnlandRouteUSVO) list.get(0);
				maxPrioSeq = Integer.parseInt(itm.getMaxPrioSeq());
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
	 * NetworkLinkManageUsaSC's searchCntOfContiUSA
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchCntOfContiUSA(Event e) throws EventException {
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
}
