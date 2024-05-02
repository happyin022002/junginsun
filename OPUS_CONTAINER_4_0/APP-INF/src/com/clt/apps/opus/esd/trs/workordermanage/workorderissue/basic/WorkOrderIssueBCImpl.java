/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WorkOrderIssueBCImpl.java
 *@FileTitle : W/O Issue
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event.EsdTrs0023Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event.EsdTrs0921Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event.EsdTrs0977Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration.WorkOrderIssueDBDAO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.SearchTrsSvcOrdBkgChmHisVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.TrsChgMgmtBkgVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.WoIssueListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * ESD-workordermanage Business Logic Basic Command implementation<br>
 * @author
 * @param <WoIssueListVO>
 * @see ESD_TRS_023EventResponse,WorkOrderIssueBC
 * @since J2EE 1.4
 */
public class WorkOrderIssueBCImpl extends BasicCommandSupport implements WorkOrderIssueBC {

	private transient WorkOrderIssueDBDAO dbDao = null;

	/**
	 * WorkOrderIssueBCImpl <br>
	 * WorkOrderIssueDBDAO<br>
	 */
	public WorkOrderIssueBCImpl() {
		dbDao = new WorkOrderIssueDBDAO();
	}

	/**
	 * FRUSTRATE<br>
	 * WorkOrderIssue - Inquiry event process<br>
	 * @return response ESD_TRS_023EventResponse
	 * @exception EventException
	 */
	public EventResponse setFrustrate(Event e) throws EventException {
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRsVo(dbDao.setFrustrate(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * FRUSTRATE<br>
	 * WorkOrderIssue - Transp. Status Update<br>
	 * @param e
	 * @exception EventException
	 */
	public void modifyTrspSubStsCd(Event e) throws EventException {
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs = null;
		try {
			trsTrspSvcOrdVOs = event.getTrsTrspSvcOrdVOs();
			ArrayList<String> s = new ArrayList<String>();
			for (int i = 0; trsTrspSvcOrdVOs != null && i < trsTrspSvcOrdVOs.length; i++) {
				TrsTrspSvcOrdVO vo = trsTrspSvcOrdVOs[i];
				String key = vo.getTrspWoOfcCtyCd() + "|" + vo.getTrspWoSeq();
				int dcnt = 0;
				for (int j = 0; j < s.size(); j++) {
					String g = s.get(j);
					if (key.equals(g)) {
						dcnt++;
						break;
					}
				}
				if (dcnt == 0) {
					s.add(key);
				}
			}
			List<TrsTrspSvcOrdVO> trspSvcOrdVOs = new ArrayList<TrsTrspSvcOrdVO>();
			for (int i = 0; i < s.size(); i++) {
				String[] r = s.get(i).split("[|]");
				if (r.length == 2) {
					TrsTrspSvcOrdVO v = new TrsTrspSvcOrdVO();
					v.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					v.setTrsSubStsCd(event.getTrsSubStsCdN());
					v.setTrspWoOfcCtyCd(r[0]);
					v.setTrspWoSeq(r[1]);
					trspSvcOrdVOs.add(v);
				}
			}
			dbDao.insertTrsSubStsHis(trspSvcOrdVOs);
			dbDao.modifyTrspSubStsCd(trspSvcOrdVOs);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * WorkOrderIssue - Inquiry event process<br>
	 * @param e
	 * @return response ESD_TRS_023EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderIssueList(Event e) throws EventException {
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		try {
			return dbDao.searchWorkOrderIssueList(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * WorkOrderIssue - searchTrsSvcOrdBkgChmHis<br>
	 * @param e
	 * @return response ESD_TRS_023EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTrsSvcOrdBkgChmHis(Event e) throws EventException {
		EsdTrs0977Event event = (EsdTrs0977Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<SearchTrsSvcOrdBkgChmHisVO> newRsltList = new ArrayList<SearchTrsSvcOrdBkgChmHisVO>();
			List<AbstractValueObject> rlist = dbDao.searchTrsSvcOrdBkgChmHis(event);
			for (int i = 0; i < rlist.size(); i++) {
				SearchTrsSvcOrdBkgChmHisVO vo = (SearchTrsSvcOrdBkgChmHisVO) rlist.get(i);
				String[] column = vo.getNewColnm1().split(Pattern.quote(","));
				String[] newVal = vo.getNewVal1().split(Pattern.quote("@#@"));
				String[] preVal = vo.getPreVal().split(Pattern.quote("@#@"));
				for (int j = 0; j < column.length; j++) {
					SearchTrsSvcOrdBkgChmHisVO newVo = (SearchTrsSvcOrdBkgChmHisVO) vo.clone();
					newVo.setNewColnm(column[j]);
					if (newVal.length > j) {
						newVo.setNowReadVal(newVal[j]);
					}
					if (preVal.length > j) {
						newVo.setPreviousVal(preVal[j]);
					}

					if (newVo.getNowReadVal().equals(newVo.getPreviousVal())) {
						continue;
					}

					if (newVo.getNowReadVal() != null) {
						newVo.setNowReadVal(newVo.getNowReadVal().replaceAll(Pattern.quote("|"), ""));
					}
					if (newVo.getPreviousVal() != null) {
						newVo.setPreviousVal(newVo.getPreviousVal().replaceAll(Pattern.quote("|"), ""));
					}
					newVo.setCngCateSubCdDesc(getCngCateSubCdDesc(vo.getCatCateSub(), column[j]));
					newRsltList.add(newVo);
				}
			}

			eventResponse.setRsVoList(newRsltList);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * @param cngCateCd
	 * @param catCateSub
	 * @return
	 */
	private String getCngCateSubCdDesc(String catCateSub, String newColumn) {
		String rVal = "";
		if ("VVSV".equals(catCateSub)) {
			rVal = "Pre VVD";
		} else if ("VVTV".equals(catCateSub)) {
			rVal = "T-VVD";
		} else if ("CNCN".equals(catCateSub)) {
			rVal = "Nature";
		} else if ("SCAW".equals(catCateSub)) {
			rVal = "Dims";
		} else if ("SCRF".equals(catCateSub)) {
			if ("CDO_TEMP|FDO_TEMP".equals(newColumn)) {
				rVal = "Temp";
			} else if ("VENT_RTO".equals(newColumn)) {
				rVal = "Vent";
			}
		} else if ("CRUS".equals(catCateSub)) {
			if ("FRT_CLT_FLG".equals(newColumn)) {
				rVal = "Freight";
			} else if ("OBL_RDEM_FLG".equals(newColumn)) {
				rVal = "BL";
			} else if ("CSTMS_CLR_CD".equals(newColumn)) {
				rVal = "Customs";
			}
		} else if ("SCDG".equals(catCateSub)) {
			if ("IMDG_UN_NO|IMDG_UN_NO_SEQ".equalsIgnoreCase(newColumn)) {
				rVal = "UN#";
			} else if ("IMDG_CLSS_CD".equals(newColumn)) {
				rVal = "CL.";
			} else if ("GRS_WGT".equals(newColumn)) {
				rVal = "Gross Wt";
			} else if ("NET_WGT".equals(newColumn)) {
				rVal = "Net Wt";
			} else if ("PRP_SHP_NM".equals(newColumn)) {
				rVal = "PSN";
			} else if ("HZD_DESC".equals(newColumn)) {
				rVal = "Cont";
			} else if ("FLSH_PNT_CDO_TEMP".equals(newColumn)) {
				rVal = "F/P";
			} else if ("IMDG_PCK_GRP_CD".equals(newColumn)) {
				rVal = "Pkg Grp.";
			} else if ("PSA_NO".equals(newColumn)) {
				rVal = "PSA Grp.";
			} else if ("MRN_POLUT_FLG".equals(newColumn)) {
				rVal = "MP";
			} else if ("EMER_CNTC_PHN_NO_CTNT".equals(newColumn)) {
				rVal = "Emer. Cont.";
			} else if ("EMER_CNTC_PSON_NM".equals(newColumn)) {
				rVal = "Cont. Person";
			}
		} else if ("ATEU".equals(catCateSub)) {
			if ("LOD_REF_NO".equalsIgnoreCase(newColumn)) {
				rVal = "Load Ref";
			} else if ("DOR_ZIP_ID".equals(newColumn)) {
				rVal = "Zip";
			} else if ("ARR_DT".equals(newColumn)) {
				rVal = "Door ETA";
			} else if ("CNTC_PSON_NM".equals(newColumn)) {
				rVal = "Contact";
			} else if ("CNTC_PHN_NO".equals(newColumn)) {
				rVal = "Tel.";
			} else if ("CNTC_EML".equals(newColumn)) {
				rVal = "Email.";
			} else if ("DOR_ADDR".equals(newColumn)) {
				rVal = "Company&Address";
			} else if ("SPCL_INSTR_RMK".equals(newColumn)) {
				rVal = "Spec. Inst";
			}
		} else if ("ATAU".equals(catCateSub)) {
			if ("DOR_PST_NO".equals(newColumn)) {
				rVal = "Zip";
			} else if ("DOR_ARR_DT".equals(newColumn)) {
				rVal = "Door ETA";
			} else if ("ACT_SHPR_ADDR".equals(newColumn)) {
				rVal = "Company&Address";
			} else if ("DIFF_RMK".equals(newColumn)) {
				rVal = "Spec. Inst";
			} else if ("ZN_CD".equals(newColumn)) {
				rVal = "Location";
			}
		} else if ("CTPO".equals(catCateSub)) {
			rVal = "Port Cut Off";
		} else if ("CTIN".equals(catCateSub)) {
			rVal = "Inland Cut Off";
		}
		return rVal;
	}

	/**
	 * Inquiry event process<br>
	 * WorkOrderIssue - searchTrsSvcOrdBkgChmHis<br>
	 * @param e
	 * @exception EventException
	 */
	public void updateTrsSvcOrdBkgChmHis(Event e) throws EventException {
		EsdTrs0977Event event = (EsdTrs0977Event) e;
		try {
			dbDao.updateTrsSvcOrdBkgChmHis(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * WorkOrderIssue - Inquiry event process<br>
	 * @param e ESD_TRS_023Event
	 * @return EventResponse ESD_TRS_023EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderIssueBySoNo(Event e) throws EventException {
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		try {
			return dbDao.searchWorkOrderIssueBySoNo(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * WorkOrderIssue - Inquiry event process<br>
	 * @param e ESD_TRS_023Event
	 * @return EventResponse ESD_TRS_023EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSpSelectList(Event e) throws EventException {
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		try {
			return dbDao.searchSpSelectList(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * WorkOrderIssue - Inquiry event process<br>
	 * @param e ESD_TRS_023Event
	 * @return EventResponse ESD_TRS_023EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLocalCurr2UsdCurr(Event e) throws EventException {
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		DBRowSet rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet = dbDao.searchLocalCurr2UsdCurr(event);
			if (rowSet.next()) {
				eventResponse.setETCData("amt_usd", rowSet.getString("WO_TOT_AMT_USD"));
			}
			eventResponse.setRsVo(rowSet);
			return eventResponse;

		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * WorkOrderIssue - Inquiry event process<br>
	 * @param e
	 * @return response ESD_TRS_023EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMoreCandidates(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0921Event event = (EsdTrs0921Event) e;
		try {
			eventResponse.setRsVo(dbDao.searchMoreCandidates(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * S/P Select - Inquiry event process<br>
	 * @param e
	 * @return response EsdTrs0921EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMdmOrganization(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null;
		EsdTrs0921Event event = (EsdTrs0921Event) e;
		FormCommand formcommand = e.getFormCommand();
		try {
			rowSet = dbDao.searchMdmOrganization(event);
			while (rowSet.next()) {
				if (formcommand.isCommand(FormCommand.SEARCH01)) {
					eventResponse.setETCData("bil_curr_cd", rowSet.getString("BIL_CURR_CD"));
					eventResponse.setETCData("conti_cd", rowSet.getString("CONTI_CD"));

				}
			}
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * WorkOrderIssue - Inquiry event process<br>
	 * @param woVO
	 * @return
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList searchSurchargeList(List<WoIssueListVO> woVO) throws EventException {
		try {
			return dbDao.searchSurchargeList(woVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * WorkOrderIssue - Inquiry event process<br>
	 * @param scgRs
	 * @return
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList searchSurchargeList(DBRowSet scgRs) throws EventException {

		try {
			return dbDao.searchSurchargeList(scgRs);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * 3RD PARTY BASIC INTERFACE BILLING CASE<br>
	 * @return response ESD_TRS_023EventResponse
	 * @exception EventException
	 */
	public EventResponse searchBillingCaseCode() throws EventException {
		DBRowSet rowSet = null; // DB ResultSet for sending data
		StringBuilder bil_cs_cd = new StringBuilder();
		StringBuilder bil_cs_nm = new StringBuilder();

		try {
			rowSet = dbDao.searchBillingCaseCode();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			while (rowSet.next()) {
				bil_cs_cd.append("|").append(rowSet.getString("N3PTY_BIL_TP_CD"));
				bil_cs_nm.append("|").append(rowSet.getString("N3PTY_BIL_TP_NM"));
			}
			eventResponse.setETCData("bil_cs_cd", bil_cs_cd.toString());
			eventResponse.setETCData("bil_cs_nm", bil_cs_nm.toString());

			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * 3RD PARTY BASIC INTERFACE <br>
	 * @param e
	 * @return response ESD_TRS_023EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTpbBasicAmt(Event e) throws EventException {
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(dbDao.searchTpbBasicAmt(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * 3RD PARTY BASIC INTERFACE <br>
	 * @param e
	 * @return response ESD_TRS_023EventResponse
	 * @exception EventException
	 */

	public EventResponse searchWoIssuedSoList(Event e) throws EventException {
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(dbDao.searchWoIssuedSoList(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * searchWOStsCDCheck<br>
	 * <br>
	 * @param e
	 * @return response ESD_TRS_023EventResponse
	 * @exception EventException
	 */

	public EventResponse searchWOStsCDCheck(Event e) throws EventException {
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		int cnt = 0;
		int totCnt = 0;
		try {
			TrsTrspSvcOrdVO[] TrsTrspSvcOrdVOs = event.getTrsTrspSvcOrdVOs();
			ArrayList<String> s = new ArrayList<String>();
			for (int i = 0; TrsTrspSvcOrdVOs != null && i < TrsTrspSvcOrdVOs.length; i++) {
				TrsTrspSvcOrdVO vo = TrsTrspSvcOrdVOs[i];
				String key = vo.getTrspWoOfcCtyCd() + "|" + vo.getTrspWoSeq();
				int dcnt = 0;
				for (int j = 0; j < s.size(); j++) {
					String g = s.get(j);
					if (key.equals(g)) {
						dcnt++;
						break;
					}
				}
				if (dcnt == 0) {
					s.add(key);
				}
			}
			for (int i = 0; i < s.size(); i++) {
				String[] r = s.get(i).split("[|]");
				if (r.length == 2) {
					cnt = dbDao.searchWOStsCDCheck(r[0], r[1]);
					totCnt += cnt;
				}
			}
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("stsCnt", String.valueOf(totCnt));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * insertTrsChgMgmtBkgPrc
	 * @param trsChgMgmtBkgVO
	 * @exception EventException
	 */
	public void insertTrsChgMgmtBkgPrc(TrsChgMgmtBkgVO trsChgMgmtBkgVO) throws EventException {
		try {
			dbDao.insertTrsChgMgmtBkgPrc(trsChgMgmtBkgVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * updateCYContainerNo
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public List<WoIssueListVO> updateCYContainerNo(Event e) throws EventException {
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		List<WoIssueListVO> updateVos = new ArrayList<WoIssueListVO>();
		try {
			String loingUsrId = event.getSignOnUserAccount().getUsr_id();
			WoIssueListVO[] woIssueListVOs = event.getWoIssueListVOs();
			for (WoIssueListVO vo : woIssueListVOs) {
				vo.setUpdUsrId(loingUsrId);
				if (dbDao.updateCYContainerNo(vo) > 0) {
					updateVos.add(vo);
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return updateVos;
	}

	/**
	 * S/O의 Booking No 가 변경되었을 경우 <br>
	 * Shipment C/M의 데이터를 변경 해줌.
	 */
	public void updateShipmentCm() {
		try {
			updateShipmentCm(null);
		} catch (EventException ee) {
			log.error("err " + ee.toString(), ee);
		}
	}

	/**
	 * S/O의 Booking No 가 변경되었을 경우 <br>
	 * Shipment C/M의 데이터를 변경 해줌.
	 * @param newBkgNos
	 * @throws EventException
	 */
	public void updateShipmentCm(String[] newBkgNos) throws EventException {
		try {
			dbDao.updateShipmentCm(newBkgNos);
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * End process of workordermanage task scenario<br>
	 * Releasing the related implicit object when WorkOrderIssue task is end.<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}