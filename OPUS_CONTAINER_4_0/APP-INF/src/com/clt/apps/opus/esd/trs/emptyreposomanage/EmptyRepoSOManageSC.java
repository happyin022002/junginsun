/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EmptyRepoSOManageSC.java
 *@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : kim_sang_geun
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.emptyreposomanage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBC;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBCImpl;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.ModifyFromTrsOffHireReturnVO;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.basic.SingleTransportationSOManageBC;
import com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.basic.SingleTransportationSOManageBCImpl;
import com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.event.EsdTrs0012Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS handling business transaction.<br>
 * 
 * @author kim_sang_geun
 * @see ESD_TRS_012EventResponse,SingleTransportationSOManageDBDAO reference
 * @since J2EE 1.4
 */
public class EmptyRepoSOManageSC extends ServiceCommandSupport {
	private SignOnUserAccount account = null;
	private String sofficeCd = "";

	/**
	 * TRS preceding process for biz scenario<br>
	 * SingleTransportationSOManage related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
			sofficeCd = account.getOfc_cd();
		} catch (Exception e) {
			log.error("EmptyRepoSOManageSC error " + e.toString(), e);
		}
	}

	/**
	 * TRS biz scenario closing<br>
	 * SingleTransportationSOManage related objects creation<br>
	 */
	public void doEnd() {
		log.debug("EmptyRepoSOManageSC End");
	}

	/**
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsdTrs0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // Create Search 1
				eventResponse = searchSingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Create Search 2
				eventResponse = search01SingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // Container File Import Search
				eventResponse = search02SingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // Correction Search
				eventResponse = search03SingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // Container mvmt info check
				eventResponse = search04SingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) { // Container verify
				eventResponse = search05SingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifySingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { // ESD_TRS_0052
				eventResponse = modify01SingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) { // ESD_TRS_0052(Empty S/O Correction) : W/O Issued
				eventResponse = modify02SingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeSingleTransportationSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSingleTransportationSOManage(e);
			} else {
				eventResponse = null;
			}
		}
		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search03SingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		EventResponse eventResponse = null;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		try {
			eventResponse = command.search03SingleTransportationSOManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;

	}

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		EventResponse eventResponse = null;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		try {
			eventResponse = command.searchSingleTransportationSOManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search01SingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		EventResponse eventResponse = null;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		try {
			eventResponse = command.search01SingleTransportationSOManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;

	}

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search02SingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		EventResponse eventResponse = null;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		try {
			eventResponse = command.search02SingleTransportationSOManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;

	}

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search04SingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		EventResponse eventResponse = null;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		try {
			eventResponse = command.search04SingleTransportationSOManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;

	}

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search05SingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		EventResponse eventResponse = null;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		try {
			eventResponse = command.search05SingleTransportationSOManage(sofficeCd, event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;

	}

	/**
	 * modify event process<br>
	 * SingleTransportationSOManage modify event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		EventResponse eventResponse = null;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		try {
			begin();
			eventResponse = command.modifySingleTransportationSOManage(sofficeCd, event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * modify event process<br>
	 * SingleTransportationSOManage modify event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modify01SingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		EventResponse eventResponse = null;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		try {
			begin();
			eventResponse = command.modify01SingleTransportationSOManage(event);
			commit();	
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * modify event process<br>
	 * Empty Repo S/O Correction : W/O Issued.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modify02SingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		EventResponse eventResponse = null;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		try {
			begin();
			eventResponse = command.modify02SingleTransportationSOManage(sofficeCd, event);
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
	 * SingleTransportationSOManage delete event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeSingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		EventResponse eventResponse = null;
		SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
		try {
			begin();
			eventResponse = command.removeSingleTransportationSOManage(sofficeCd, event);
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
	 * SingleTransportationSOManage multi event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @throws SQLException
	 * @throws DAOException
	 */
	public EventResponse multiSingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		EventResponse eventResponse = null;
		DBRowSet dRs = null;
		DBRowSet dRs2 = null;
		DBRowSet dRsChk = null;
		ModifyFromTrsOffHireReturnVO mfohVo = null;
		CntrRepoExecutionPlanEstablishBC cntrCommand = new CntrRepoExecutionPlanEstablishBCImpl();
		String to_nod_cd = null;
		String trs_seq = null;
		Collection<SingleTransportationVO> insModels = new ArrayList<SingleTransportationVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		List<String> refSeqList = null;
		try {
			begin();
			String cbstatus = event.getCbstatus();
			String ctrlOfcCd = event.getCtrlOfcCd();
			SingleTransportationVO[] stVos = event.getSingleTransportationVOs();
			HashMap<String, String> hmSeq = new HashMap<String, String>();

			SingleTransportationSOManageBC command = new SingleTransportationSOManageBCImpl();
			dRs = command.searchMultiSingleTransportationSo(e);
			if (dRs.next()) {
				dRs.getString(1);
				throw new EventException(new ErrorHandler("TRS00100").getMessage());
			}

			if (cbstatus.equals("CF")) {
				hmSeq = command.searchEmptyRepoCombineSeq(event);
			}
			for (int j = 0; j < stVos.length; j++) {
				if (stVos[j].getIbflag().length() > 0) {
					if (stVos[j].getIbflag().equals("I")) {
						if ("Y".equals(stVos[j].getLseCntrFlg())) {
							if ((stVos[j].getToNodCd()).equals(stVos[j].getOrgToYdCd())) {
								stVos[j].setLseCntrFlg("Y");

							} else {
								Map<String, Object> chk_param = new HashMap<String, Object>();
								chk_param.put("fm_nod_cd", stVos[j].getFmNodCd());
								chk_param.put("to_nod_cd", stVos[j].getToNodCd());
								dRsChk = command.searchVerifyECC(chk_param);

								if (dRsChk.getRowCount() > 0) {
									if (dRsChk.next()) {
										mfohVo = new ModifyFromTrsOffHireReturnVO();
										mfohVo.setRepoPlnId(stVos[j].getRepoPlnId());
										mfohVo.setPlnYrwk(stVos[j].getPlnYrwk());
										mfohVo.setCntrTpszCd(stVos[j].getEqTpszCd());
										mfohVo.setRefId(stVos[j].getRefId());
										mfohVo.addOldRefSeqList(stVos[j].getRefSeq());
										mfohVo.setChdToYdCd(stVos[j].getToNodCd());
										mfohVo.setChdCntrQty(("".equals(stVos[j].getEqNo()) ? "0" : "1"));
										mfohVo = cntrCommand.modifyFromTrsOffHireReturn(mfohVo, account);
										if ("00".equals(mfohVo.getReturnCode())) {
											stVos[j].setRefId(mfohVo.getNewRefId());
											refSeqList = mfohVo.getRefSeqList();
											if (refSeqList != null) {
												if (refSeqList.size() > 0)
													stVos[j].setRefSeq(refSeqList.get(0));
											}
											stVos[j].setLseCntrFlg("Y");
										} else {
											to_nod_cd = stVos[j].getOrgToYdCd();
											stVos[j].setToNodCd(to_nod_cd);
											stVos[j].setLseCntrFlg("");
										}

									}
								} else {
									stVos[j].setToNodCd(stVos[j].getOrgToYdCd());
									stVos[j].setLseCntrFlg("");
								}
								chk_param.clear();
							}

						} else {
							stVos[j].setLseCntrFlg("");
						}
						String strOfc = "";
						if (String.valueOf(stVos[j].getTrspSoOfcCtyCd()).length() > 2) {
							strOfc = String.valueOf(stVos[j].getTrspSoOfcCtyCd()).substring(0, 3);
						} else {
							strOfc = String.valueOf(stVos[j].getTrspSoOfcCtyCd());
						}
						stVos[j].setTrspSoOfcCtyCd(strOfc);
						dRs2 = command.searchEmptyRepoSeq();
						if (dRs2.next()) {
							trs_seq = dRs2.getString(1);
						}

						stVos[j].setTrspSoSeq(trs_seq);
						if (cbstatus.equals("CF")) {
							String cmbSeq = stVos[j].getTrspSoCmbSeq();
							stVos[j].setTrspSoCmbSeq(hmSeq.get(cmbSeq.substring(0, 1)));
							stVos[j].setTrspSoCmbSrtNo(cmbSeq);
						}
						insModels.add(stVos[j]);
					}
				}
			}
			param.put("cbstatus", event.getCbstatus());
			param.put("ctrl_ofc_cd", ctrlOfcCd);
			eventResponse = command.multiSingleTransportationSOManage5(insModels, param);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (SQLException se) {
			rollback();
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}

		return eventResponse;
	}
}
