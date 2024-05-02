/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : RailSoManageBCImpl.java
 *@FileTitle : USA Rail Billing S/O creation
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBC;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBCImpl;
import com.clt.apps.opus.esd.trs.common.util.CommonUtil;
import com.clt.apps.opus.esd.trs.railsomanage.railsomanage.event.EsdTrs0201Event;
import com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration.RailSoManageDBDAO;
import com.clt.apps.opus.esd.trs.railsomanage.railsomanage.vo.EqrRepoExeSoIfVO;
import com.clt.apps.opus.esd.trs.railsomanage.railsomanage.vo.SearchRailSoManageHdrVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.TrsTrspRailBilOrdVO;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS handling business logic.<br>
 * 
 * @author
 * @see ESD_TRS_201EventResponse,RailSoManageBC refer to each DAO classes
 * @since
 */
public class RailSoManageBCImpl extends BasicCommandSupport implements RailSoManageBC {
	private transient RailSoManageDBDAO dbDao = null;

	/**
	 * RailSoManageBCImpl objects creation<br>
	 * Generate RailSoManageDBDAO.<br>
	 */
	public RailSoManageBCImpl() {
		dbDao = new RailSoManageDBDAO();
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP In Bound<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return List<TrsTrspRailBilOrdVO>
	 * @exception EventException
	 */
	public List<TrsTrspRailBilOrdVO> search01RailSoManageSel(Event e) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
		List<TrsTrspRailBilOrdVO> trsTrspRailBilOrdVO = new ArrayList<TrsTrspRailBilOrdVO>();
		try {
			trsTrspRailBilOrdVO = dbDao.search01RailSoManageSel(event);
			return trsTrspRailBilOrdVO;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP In Bound<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String search01RailSoManageSeq() throws EventException {
		String lSeq = "";

		try {
			lSeq = dbDao.search01RailSoManageSeq();
			return lSeq;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP In Bound<br>
	 * 
	 * @param vo
	 * @param lSeq
	 * @param sCtrlUserId
	 * @exception EventException
	 */
	public void search01RailSoManageIns(List<TrsTrspRailBilOrdVO> vo, String lSeq, String sCtrlUserId) throws EventException {
		try {
			dbDao.search01RailSoManageIns(vo, lSeq, sCtrlUserId);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP In Bound<br>
	 * 
	 * @param lSeq
	 * @exception EventException
	 */
	public void search01RailSoManageUpd(String lSeq) throws EventException {

		try {
			dbDao.search01RailSoManageUpd(lSeq);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP In Bound<br>
	 * 
	 * @param String lSeq
	 * @param Event e
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search01RailSoManage(String lSeq, Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0201Event event = (EsdTrs0201Event) e;
		try {
			eventResponse.setRsVo(dbDao.search01RailSoManage(lSeq, event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP In Bound<br>
	 * 
	 * @param lSeq
	 * @exception EventException
	 */
	public void search01RailSoManageDel(String lSeq) throws EventException {
		try {
			dbDao.search01RailSoManageDel(lSeq);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP Out Bound<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return List<TrsTrspRailBilOrdVO>
	 * @exception EventException
	 */
	public List<TrsTrspRailBilOrdVO> search06RailSoManageSel(Event e) throws EventException {

		EsdTrs0201Event event = (EsdTrs0201Event) e;

		List<TrsTrspRailBilOrdVO> trsTrspRailBilOrdVO = new ArrayList<TrsTrspRailBilOrdVO>();

		try {
			trsTrspRailBilOrdVO = dbDao.search06RailSoManageSel(event);
			return trsTrspRailBilOrdVO;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP Out Bound<br>
	 * 
	 * @param vo
	 * @param lSeq
	 * @param sCtrlUserId
	 * @exception EventException
	 */
	public void search06RailSoManageIns(List<TrsTrspRailBilOrdVO> vo, String lSeq, String sCtrlUserId) throws EventException {

		try {
			dbDao.search06RailSoManageIns(vo, lSeq, sCtrlUserId);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP Out Bound<br>
	 * 
	 * @param lSeq
	 * @exception EventException
	 */
	public void search06RailSoManageUpd(String lSeq) throws EventException {

		try {
			dbDao.search06RailSoManageUpd(lSeq);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP Out Bound<br>
	 * 
	 * @param lSeq
	 * @param e
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search06RailSoManage(String lSeq, Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0201Event event = (EsdTrs0201Event) e;
		try {
			eventResponse.setRsVo(dbDao.search06RailSoManage(lSeq, event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP Out Bound<br>
	 * 
	 * @param lSeq
	 * @exception EventException
	 */
	public void search06RailSoManageDel(String lSeq) throws EventException {
		try {
			dbDao.search06RailSoManageDel(lSeq);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * BKG,COP CNTR List search <br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailsoBybkgcntr(Event e) throws EventException {

		EsdTrs0201Event event = (EsdTrs0201Event) e;

		DBRowSet rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet = dbDao.searchRailsoBybkgcntr(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * Empty Repo<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search08RailSoManage(Event e) throws EventException {

		EsdTrs0201Event event = (EsdTrs0201Event) e;

		DBRowSet rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet = dbDao.search08RailSoManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * Empty Repo<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EventResponse search09RailSoManage(Event e) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
		ArrayList eqr_overplan_al = null;

		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		DBRowSet rowSet = null;

		int i = 0;
		HashMap tempMap = new HashMap();

		ArrayList arr_ref_id = null;
		ArrayList arr_fm_nod_cd = null;
		ArrayList arr_to_nod_cd = null;
		ArrayList arr_eq_tpsz = null;
		ArrayList arr_more_qty = null;

		String[] aref_id = null;
		String[] afm_nod_cd = null;
		String[] ato_nod_cd = null;
		String[] aeq_tpsz_cd = null;
		String[] amore_qty = null;

		String ref_id = event.getHidRefId();
		String fm_nod_cd = event.getHidFmNodCd();
		String to_nod_cd = event.getHidToNodCd();
		String eq_tpsz_cd = event.getHidEqTpszCd();
		String more_qty = event.getHidMoreQty();
		String curr_dt = event.getHidCurrDt();

		String overPlan_refid = "";

		arr_ref_id = CommonUtil.seperationParameter(ref_id, ",");
		arr_fm_nod_cd = CommonUtil.seperationParameter(fm_nod_cd, ",");
		arr_to_nod_cd = CommonUtil.seperationParameter(to_nod_cd, ",");
		arr_eq_tpsz = CommonUtil.seperationParameter(eq_tpsz_cd, ",");
		arr_more_qty = CommonUtil.seperationParameter(more_qty, ",");

		if (arr_ref_id != null) {
			aref_id = new String[arr_ref_id.size()];
			for (int n = 0; n < arr_ref_id.size(); n++) {
				aref_id[n] = (String) arr_ref_id.get(n);
			}
		}
		if (arr_fm_nod_cd != null) {
			afm_nod_cd = new String[arr_fm_nod_cd.size()];
			for (int n = 0; n < arr_fm_nod_cd.size(); n++) {
				afm_nod_cd[n] = (String) arr_fm_nod_cd.get(n);
			}
		}
		if (arr_to_nod_cd != null) {
			ato_nod_cd = new String[arr_to_nod_cd.size()];
			for (int n = 0; n < arr_to_nod_cd.size(); n++) {
				ato_nod_cd[n] = (String) arr_to_nod_cd.get(n);
			}
		}
		if (arr_eq_tpsz != null) {
			aeq_tpsz_cd = new String[arr_eq_tpsz.size()];
			for (int n = 0; n < arr_eq_tpsz.size(); n++) {
				aeq_tpsz_cd[n] = (String) arr_eq_tpsz.get(n);
			}
		}
		if (arr_more_qty != null) {
			amore_qty = new String[arr_more_qty.size()];
			for (int n = 0; n < arr_more_qty.size(); n++) {
				amore_qty[n] = (String) arr_more_qty.get(n);
			}
		}

		try {
			if (arr_fm_nod_cd != null) {
				for (i = 0; i < arr_fm_nod_cd.size(); i++) {

					if (Integer.parseInt(amore_qty[i]) > 0) { // EQR greater than zero when the target overplan qty.

						// inlandWrsTrsSOIF overplan funcion ( year week. yyyymmdd / fmnode / tonode / 'R' / tpsz / qty
						eqr_overplan_al = ((CntrRepoExecutionPlanEstablishBCImpl) command).inlandWrsTrsSOIF(curr_dt, afm_nod_cd[i], ato_nod_cd[i], "R", aeq_tpsz_cd[i], Integer.parseInt(amore_qty[i]));

						if (eqr_overplan_al != null) {
							String[] arr = null;
							for (int z = 0; z < eqr_overplan_al.size(); z++) {
								arr = (String[]) eqr_overplan_al.get(z);
							}
							if (i == 0)
								overPlan_refid = overPlan_refid + arr[2];
							else
								overPlan_refid = overPlan_refid + "," + arr[2];

							// Add to retrieve a list of ref_id generated REF_ID .
							tempMap.put("hid_ref_id", event.getHidRefId() + "," + arr[2]);
							tempMap.put("hid_eq_tpsz_cd", event.getHidEqTpszCd() + "," + aeq_tpsz_cd[i]);
						}
					} else {
						if (i == 0)
							overPlan_refid = overPlan_refid + "nl";
						else
							overPlan_refid = overPlan_refid + "," + "nl";
					}
				}
			}

			rowSet = dbDao.search09RailSoManage(event);

			eventResponse.setRsVo(rowSet);
			eventResponse.setETCData("overplan_ref_id", overPlan_refid);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * Empty Repo<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailSoCorrectionTargetList(Event e) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRsVo(dbDao.searchRailSoCorrectionTargetList(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * Empty Verify Checked<br>
	 * 
	 * @param soffice_cd
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search11RailSoManage(String soffice_cd, Event e) throws EventException {

		EsdTrs0201Event event = (EsdTrs0201Event) e;

		DBRowSet rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet = dbDao.search11RailSoManage(soffice_cd, event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * IN BOUND Verify Checked<br>
	 * 
	 * @param soffice_cd
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search02RailSoManage(String soffice_cd, Event e) throws EventException {

		EsdTrs0201Event event = (EsdTrs0201Event) e;

		DBRowSet rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet = dbDao.search02RailSoManage(soffice_cd, event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search04RailSoManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsdTrs0201Event event = (EsdTrs0201Event) e;

		DBRowSet rowSetIrgAdjust = null;

		try {
			rowSetIrgAdjust = dbDao.search04RailSoManage(event);
			eventResponse.setRsVo(rowSetIrgAdjust);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse searchIrgCandidate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsdTrs0201Event event = (EsdTrs0201Event) e;
		DBRowSet rowSet = null;

		try {
			rowSet = dbDao.searchIrgCandidate(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * 
	 * @param soffice_cd
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search07RailSoManage(String soffice_cd, Event e) throws EventException {

		EsdTrs0201Event event = (EsdTrs0201Event) e;

		DBRowSet rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet = dbDao.search07RailSoManage(soffice_cd, event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search13RailSoManage(Event e) throws EventException {

		EsdTrs0201Event event = (EsdTrs0201Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null;

		try {
			rowSet = dbDao.search13RailSoManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search14RailSoManage(Event e) throws EventException {

		EsdTrs0201Event event = (EsdTrs0201Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		DBRowSet rowSet = null;

		try {
			rowSet = dbDao.search14RailSoManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * modify event process<br>
	 * ESD_TRS_201 event process<br>
	 * US Rail Billing - Correction
	 * 
	 * @param e ESD_TRS_201Event
	 * @param row
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyRailSoManage(Event e, int row) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setCustomData("arrTrspSoSeq", dbDao.modifyTrsTrspRailBillingVos(event, row));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * delete event process<br>
	 * ESD_TRS_201 event process<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse removeRailSoManage(Event e) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setCustomData("arrTrspSoSeq", dbDao.removeTrsTrspRailBillingVos(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * multi event process<br>
	 * ESD_TRS_201 multi event process<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @param row
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRailSoManage(Event e, int row) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setCustomData("arrTrspSoSeq", dbDao.multiTrsTrspRailBillingVos(event, row));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * multi event process<br>
	 * ESD_TRS_203 multi event process<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse multi02RailSoManage(Event e) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setCustomData("arrTrspSoSeq", dbDao.multi02TrsTrspRailBillingVos(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * multi event process<br>
	 * ESD_TRS_203 multi event process<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @param row
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse multi02RailSoManageForNoTranjection(Event e, int row) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setCustomData("arrTrspSoSeq", dbDao.multi02TrsTrspRailBillingVosForNoTranjection(event, row));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * multi event process<br>
	 * ESD_TRS_959 multi event process<br>
	 * 
	 * @param soffice_cd
	 * @param suer_ctl_id
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse multi01RailSoManage(String soffice_cd, String suer_ctl_id, Event e) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.multi01TrsTrspRailBillingVos(soffice_cd, suer_ctl_id, event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * multi event process<br>
	 * ESD_TRS_201 multi event process<br>
	 * 
	 * @param soffice_cd
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse multiProcRailSoManage(String soffice_cd) throws EventException {
		try {
			dbDao.multiProcTrsTrspRailBillingVos(soffice_cd);
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * multi event process<br>
	 * ESD_TRS_201 multi event process<br>
	 * 
	 * @param customData
	 * @param soffice_cd
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse multiProcRailSoManageForNoTranjection(Map<String, Object> customData, String soffice_cd) throws EventException {
		try {
			dbDao.multiProcTrsTrspRailBillingVosForNoTranjection(customData, soffice_cd);
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * multi event process<br>
	 * ESD_TRS_201 multi event process<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @param row
	 * @param customData
	 * @param soffice_cd
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse multiProcRailSoManageForWRS(Event e, int row, Map<String, Object> customData, String soffice_cd) throws EventException {
		EsdTrs0201Event event = (EsdTrs0201Event) e;
		try {
			dbDao.multiProcRailSoManageForWRS(event, row, customData, soffice_cd);
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * WRSTRS_SOIF 를 통해서 INLAND 데이터를 입력
	 * EQR_INLND_TRSP_PLN, EQR_INLND_TRSP_EXE_PLN, EQR_REPO_EXE_SO_IF 테이블에 데이터 입력
	 * 
	 * @param current_date	String
	 * @param fm_yd_cd		String
	 * @param to_yd_cd		String
	 * @param trsp_mod_cd	String
	 * @param cntr_tpsz_cd	String
	 * @param qty			int
	 * @param repo_pln_id 	String
	 * @param pln_yrwk		String	
	 * @param ref_id		String
	 * @return ArrayList
     * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList inlandWrsTrsSOIF(String current_date, String fm_yd_cd, String to_yd_cd, String trsp_mod_cd, String cntr_tpsz_cd, int qty, String repo_pln_id, String pln_yrwk, String ref_id) throws EventException {

        String etd_date     = "";
        String eta_date     = "";
        
        ArrayList soifList = new ArrayList();
        String[] soifArr  = null;
        
        String plnSeq = "0";
        String ref_seq = "0";
        DBRowSet rowSet = null;
        
		try {			
			// repo pln id
			etd_date        = current_date;
			eta_date        = dbDao.searchEtaDate(etd_date, fm_yd_cd, to_yd_cd, trsp_mod_cd);

			if(eta_date.equals("")) eta_date = etd_date;
			
			String office_code = "";
			String chk_us_rail = "N";
			
			SearchRailSoManageHdrVO hdrVO = new SearchRailSoManageHdrVO();
			hdrVO.setFmLocCd(fm_yd_cd.substring(0, 5));
			hdrVO.setTrspModCd(trsp_mod_cd);
			
			//미주 RAIL운송인지 체크한다
			chk_us_rail = dbDao.checkUsRail(hdrVO);
			
			// REQ_SEQ채번
			ref_seq = dbDao.searchGetRefSeq(repo_pln_id, pln_yrwk, plnSeq, ref_id);
			
			if(chk_us_rail.equals("Y")) { // USNYC, RAIL은 PHXSA로 하드코딩 - 멕시코는 제외
				office_code = "PHXSA";
		    }    
			// EQR_REPO_EXE_SO_IF 테이블의 REF_SEQ (ref_id 별로 1부터 시작) 
	       	for(int j=0; j<qty; j++) {    // qty만큼 insert 합니다.  
	       		EqrRepoExeSoIfVO eqrRepoExeSoIfVO = new EqrRepoExeSoIfVO();
		       	eqrRepoExeSoIfVO.setRepoPlnId(repo_pln_id);
		       	eqrRepoExeSoIfVO.setPlnYrwk(pln_yrwk);
		       	eqrRepoExeSoIfVO.setRefId(ref_id);
		       	eqrRepoExeSoIfVO.setPlnSeq(plnSeq);
		       	eqrRepoExeSoIfVO.setCntrTpszCd(cntr_tpsz_cd);
		       	eqrRepoExeSoIfVO.setTrspModCd(trsp_mod_cd);
		       	eqrRepoExeSoIfVO.setSoIfDivCd(trsp_mod_cd);
		       	eqrRepoExeSoIfVO.setFmYdCd(fm_yd_cd);
		       	eqrRepoExeSoIfVO.setToYdCd(to_yd_cd);
		       	eqrRepoExeSoIfVO.setFmDt(etd_date);
		       	eqrRepoExeSoIfVO.setToDt(eta_date);
		       	eqrRepoExeSoIfVO.setWoExeFlg("N");
		       	eqrRepoExeSoIfVO.setEqCtrlOfcCd(office_code);
	       		eqrRepoExeSoIfVO.setRefSeq(ref_seq);
	       		dbDao.insertInlandWrsTrsSOIF(eqrRepoExeSoIfVO,"TRS_SOIF");//INSERT INTO EQR_REPO_EXE_SO_IF 
	       	}			
			// soif pk search
			rowSet = dbDao.searchInlandWrsTrsSOIF(repo_pln_id, pln_yrwk, plnSeq , ref_id );
			
				
			int i =1;
			if (rowSet != null) {
				while (rowSet.next()) {
					soifArr = new String[4];
					for(int j=0; j<rowSet.getMetaData().getColumnCount(); j++) {
						soifArr[j] = rowSet.getString(i++);
					}
					i = 1;
					soifList.add(soifArr);
				}
			}
			
			return soifList;
		} catch (SQLException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch(Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}		
	}	
	
	/**
	 * TRS biz scenario closing<br>
	 * RailSoManage clearing related objects<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}