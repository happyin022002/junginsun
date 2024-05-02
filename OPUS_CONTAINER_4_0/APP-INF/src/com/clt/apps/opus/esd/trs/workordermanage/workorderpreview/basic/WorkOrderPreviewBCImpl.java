/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WorkOrderPreviewBCImpl.java
 *@FileTitle : W/O Create
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ServerExportException;

import com.clt.apps.opus.esd.tpb.common.tpbinterface.basic.TPBInterfaceBCImpl;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration.WorkOrderPreviewDBDAO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration.WorkOrderPreviewEAIDAO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration.WorkOrderPreviewEdiDBDAO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.vo.WorkOrderPreviewVO;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.TrsEdiWrkOrdHisVO;
import com.clt.syscommon.common.table.TrsTrspWrkOrdVO;

/**
 * ESD-workordermanage Business Logic Basic Command implementation<br>
 * - ESD-workordermanage process business logic.<br>
 * 
 * @author
 * @see ESD_TRS_024EventResponse,WorkOrderPreviewBC refer to DAO classes
 * @since
 */
public class WorkOrderPreviewBCImpl extends BasicCommandSupport implements WorkOrderPreviewBC {

	// Database Access Object
	private transient WorkOrderPreviewDBDAO dbDao = null;
	private transient WorkOrderPreviewEAIDAO eaiDao = null;
	private transient WorkOrderPreviewEdiDBDAO ediDao = null;

	/**
	 * WorkOrderPreviewBCImpl object create<br>
	 * WorkOrderPreviewDBDAO create.<br>
	 */
	public WorkOrderPreviewBCImpl() {
		dbDao = new WorkOrderPreviewDBDAO();
		eaiDao = new WorkOrderPreviewEAIDAO();
		ediDao = new WorkOrderPreviewEdiDBDAO();
	}

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e
	 * @return SingleTransportationVO[]
	 * @exception EventException
	 */
	public SingleTransportationVO[] searchDeleteSoList(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;

		try {
			return dbDao.searchDeleteSoList(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchWoNo(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		DBRowSet rowSet = null;

		try {
			rowSet = dbDao.searchWoNo(event);
			return rowSet;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEdiInquiryList(Event e) throws EventException {

		EsdTrs0024Event event = (EsdTrs0024Event) e;
		DBRowSet rowSet = null;

		try {
			rowSet = dbDao.searchEdiInquiryList(event);

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);

			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e
	 * @param account
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap<String, Object> addWorkOrderPreview(Event e, SignOnUserAccount account) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		TPBInterfaceVO[] models = null;
		TPBInterfaceVO[] models1 = null;
		HashMap<String, Object> rsltHashMap = new HashMap<String, Object>();
		try {
			dbDao.addWorkOrderPreview(event);
			rsltHashMap = addWorkOrderPreviewCommon(event);
			/* TRS-TPB IF */
			models1 = dbDao.searchTrs3PtyIFList(event);
			if (models1 != null && models1.length > 0) {
				TPBInterfaceBCImpl tbpIF = new TPBInterfaceBCImpl();
				models = dbDao.searchTrs3PtyIF(event);
				tbpIF.createTRSTPB(models, account);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return rsltHashMap;
	}

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e
	 * @param account
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap<String, Object> addWorkOrderPreviewIssued(Event e, SignOnUserAccount account) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		DBRowSet rowSet = null;

		TPBInterfaceVO[] models = null;
		TPBInterfaceVO[] models1 = null;
		TPBInterfaceVO[] models2 = null;
		HashMap<String, Object> flatFileHashMap = new HashMap<String, Object>();
		try {
			TrsTrspWrkOrdVO wrkOrdVO = event.getTrsTrspWrkOrdVO();
			WorkOrderPreviewVO wrkPrvVO = event.getWorkOrderPreviewVO();
			String issStsCd = wrkOrdVO.getWoIssStsCd();
			if (CheckUtilities.isInBlank(wrkPrvVO.getContiCd())) {
				if (event.getTrsTrspWrkOrdPrvTmpVOs() != null && event.getTrsTrspWrkOrdPrvTmpVOs().length > 0) {
					rowSet = dbDao.searchContiCd(event);
					if (rowSet.next()) {
						wrkPrvVO.setContiCd(rowSet.getString("conti_cd"));
					}
					event.setWorkOrderPreviewVO(wrkPrvVO);
				}
			}
			if ("N".equals(issStsCd)) {
				flatFileHashMap = addWorkOrderPreviewCommon(event);
				rowSet = dbDao.addWorkOrderPreviewIssued(event);
			} else if ("C".equals(issStsCd)) {
				flatFileHashMap = addWorkOrderPreviewCommon(event);
				rowSet = dbDao.addWorkOrderPreviewIssued(event);
			} else {
				rowSet = dbDao.addWorkOrderPreviewIssued(event);
				flatFileHashMap = addWorkOrderPreviewCommon(event);
			}
			/* TRS-TPB IF */
			models1 = dbDao.searchTrs3PtyIFList(event);
			if ((null != models1) && (models1.length > 0)) {
				TPBInterfaceBCImpl tbpIF = new TPBInterfaceBCImpl();
				models2 = dbDao.searchTrs3PtyIFCxl(event);
				tbpIF.createTRSTPB(models2, account);

				models = dbDao.searchTrs3PtyIF(event);
				tbpIF.createTRSTPB(models, account);
			}
		} catch (SQLException ee) {
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return flatFileHashMap;
	}

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e
	 * @exception EventException
	 */
	public void resendEDIAsia(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		String[] ffList = null;
		DBRowSet rowSet = null;
		String vndrSeq = null;
		String woEdiUseFlg = null;
		String ediRcvrNmUseFlg = null;
		String soCreOfcCd = null;
		String trspBndCd = null;
		String contiCd = null;
		try {

			rowSet = dbDao.searchEdiResendList(event);
			WorkOrderPreviewVO woVO = event.getWorkOrderPreviewVO();
			while (rowSet.next()) {
				vndrSeq = rowSet.getString("vndr_seq");
				woEdiUseFlg = rowSet.getString("wo_edi_use_flg");
				ediRcvrNmUseFlg = rowSet.getString("edi_rcvr_nm_use_flg");
				soCreOfcCd = rowSet.getString("so_cre_ofc_cd");
				trspBndCd = rowSet.getString("trsp_bnd_cd");
				contiCd = rowSet.getString("CONTI_CD");

				if (vndrSeq != null && vndrSeq.equals("102297")) {
					woVO.setEdiLoc("ASIA");
				} else if (vndrSeq != null
						&& ((vndrSeq.equals("105121") || vndrSeq.equals("105147") || vndrSeq.equals("135366") || vndrSeq.equals("155153") || vndrSeq.equals("175368")) ||

						(soCreOfcCd.equals("VLCBB") && (vndrSeq.equals("120759") || vndrSeq.equals("120852") || vndrSeq.equals("121403") || vndrSeq.equals("125140") || vndrSeq.equals("166660") || vndrSeq.equals("168242") || vndrSeq.equals("172121") || vndrSeq.equals("143046")
								|| vndrSeq.equals("166697") || vndrSeq.equals("120849") || vndrSeq.equals("181404"))))) {
					woVO.setEdiLoc("EUR");
				} else if ("M".equals(rowSet.getString("CONTI_CD")) && woEdiUseFlg.equals("Y") && ediRcvrNmUseFlg.equals("Y")) {
					woVO.setEdiLoc("USA");
				}

				if ("M".equals(contiCd) && woEdiUseFlg.equals("Y")) {
					woVO.setEdiLoc("USA");
				} else if ("A".equals(contiCd) && woEdiUseFlg.equals("Y")) {
					woVO.setEdiLoc("ASIA");
				} else if ("E".equals(contiCd) && woEdiUseFlg.equals("Y")) {
					woVO.setEdiLoc("EUR");
				}

				woVO.setEdiTrspSoOfcCtyCd(rowSet.getString("trsp_so_ofc_cty_cd"));
				woVO.setEdiTrspSoSeq(rowSet.getString("trsp_so_seq"));
				woVO.setEdiTrspWoOfcCtyCd(rowSet.getString("trsp_wo_ofc_cty_cd"));
				woVO.setEdiTrspWoSeq(rowSet.getString("trsp_wo_seq"));
				woVO.setEdiWoIssStsCd(rowSet.getString("wo_iss_sts_cd"));
				woVO.setEdiVndrSeq(vndrSeq);
				woVO.setTrspCrrModCd(rowSet.getString("trsp_crr_mod_cd"));
				woVO.setTrspCostDtlModCd(rowSet.getString("trsp_cost_dtl_mod_cd"));
				woVO.setEdiEqNo(rowSet.getString("eq_no"));
				woVO.setEdiRcvrNm(rowSet.getString("edi_rcvr_nm"));
				woVO.setWoEdiUseFlg(rowSet.getString("wo_edi_use_flg"));
				woVO.setSoCreOfcCd(rowSet.getString("so_cre_ofc_cd"));
				woVO.setTrspBndCd(trspBndCd);
				event.setWorkOrderPreviewVO(woVO);
			}
			ffList = sendFlatFile(event);
			sendFlatMessage(ffList[1]);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e
	 * @exception EventException
	 */
	public void resendEDIEur(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		String[] ffList = null;
		DBRowSet rowSet = null;
		String vndrSeq = null;
		String trspBndCd = null;
		try {
			rowSet = dbDao.searchEdiResendList(event);
			WorkOrderPreviewVO woVO = event.getWorkOrderPreviewVO();
			while (rowSet.next()) {
				vndrSeq = rowSet.getString("vndr_seq");
				trspBndCd = rowSet.getString("trsp_bnd_cd");
				woVO.setEdiTrspSoOfcCtyCd(rowSet.getString("trsp_so_ofc_cty_cd"));
				woVO.setEdiTrspSoSeq(rowSet.getString("trsp_so_seq"));
				woVO.setEdiTrspWoOfcCtyCd(rowSet.getString("trsp_wo_ofc_cty_cd"));
				woVO.setEdiTrspWoSeq(rowSet.getString("trsp_wo_seq"));
				woVO.setEdiWoIssStsCd(rowSet.getString("wo_iss_sts_cd"));
				woVO.setEdiVndrSeq(vndrSeq);
				woVO.setTrspCrrModCd(rowSet.getString("trsp_crr_mod_cd"));
				woVO.setTrspCostDtlModCd(rowSet.getString("trsp_cost_dtl_mod_cd"));
				woVO.setEdiEqNo(rowSet.getString("eq_no"));
				woVO.setEdiRcvrNm(rowSet.getString("edi_rcvr_nm"));
				woVO.setWoEdiUseFlg(rowSet.getString("wo_edi_use_flg"));
				woVO.setSoCreOfcCd(rowSet.getString("so_cre_ofc_cd"));
				woVO.setTrspBndCd(trspBndCd);
				event.setWorkOrderPreviewVO(woVO);
			}
			ffList = sendFlatFile(event);
			sendFlatMessage(ffList[1]);

		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderPreviewIssueStatus(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchWorkOrderPreviewIssueStatus(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderPreviewIssuedGroup(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.searchWorkOrderPreviewIssuedGroup(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderPreviewGroup(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.searchWorkOrderPreviewGroup(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * EDI condition retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderPreviewEdiCondChk(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchWorkOrderPreviewEdiCondChk(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * EDI condition retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEdiResendCondChk(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchEdiResendCondChk(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public DBRowSet searchEdiSendingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0024Event event = (EsdTrs0024Event) e;

		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchEdiSendingList(event);
			return rowSet;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSODeleteCheck(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchSODeleteCheck(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public DBRowSet searchBkgCancelList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0024Event event = (EsdTrs0024Event) e;

		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchBkgCancelList(event);
			return rowSet;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e
	 * @exception EventException
	 */
	public void addFaxAndEmailNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0024Event event = (EsdTrs0024Event) e;

		try {
			dbDao.addFaxAndEmailNo(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * addWorkOrderPreviewCommon
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HashMap<String, Object> addWorkOrderPreviewCommon(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		DBRowSet rowSet = null;
		String contiCd = null;
		String vndrSeq = null;
		String iWoPrvGrpSeq = null;
		String iWoIssNo = null;

		int i = 0;
		int cntrSeq = 1;
		int totalWoCnt = 0;

		HashMap<String, Object> rsltFlatFileHashmap = new HashMap<String, Object>();
		ArrayList relRedFF = new ArrayList();
		ArrayList joEdiFF = new ArrayList();
		try {
			WorkOrderPreviewVO woVO = event.getWorkOrderPreviewVO();
			rowSet = dbDao.searchSoByPrvTmp(event);
			totalWoCnt = rowSet.getRowCount();
			while (rowSet.next()) {
				vndrSeq = rowSet.getString("vndr_seq");
				contiCd = rowSet.getString("conti_cd");
				if ("M".equals(contiCd)) {
					woVO.setEdiLoc("USA");
				} else if ("A".equals(contiCd)) {
					woVO.setEdiLoc("ASIA");
				} else if ("E".equals(contiCd)) {
					woVO.setEdiLoc("EUR");
				}
				woVO.setEdiTrspSoOfcCtyCd(rowSet.getString("trsp_so_ofc_cty_cd"));
				woVO.setEdiTrspSoSeq(rowSet.getString("trsp_so_seq"));
				woVO.setEdiTrspWoOfcCtyCd(rowSet.getString("trsp_wo_ofc_cty_cd"));
				woVO.setEdiTrspWoSeq(rowSet.getString("trsp_wo_seq"));

				woVO.setEdiWoIssStsCd(rowSet.getString("wo_iss_sts_cd"));
				woVO.setEdiVndrSeq(vndrSeq);
				woVO.setTrspCrrModCd(rowSet.getString("trsp_crr_mod_cd"));
				woVO.setTrspCostDtlModCd(rowSet.getString("trsp_cost_dtl_mod_cd"));
				woVO.setEdiEqNo(rowSet.getString("eq_no"));
				woVO.setEdiRcvrNm(rowSet.getString("edi_rcvr_nm"));
				woVO.setContiCd(rowSet.getString("conti_cd"));
				woVO.setSoCreOfcCd(rowSet.getString("so_cre_ofc_cd"));
				woVO.setTrspBndCd(rowSet.getString("trsp_bnd_cd"));
				woVO.setWoPrvGrpSeq(rowSet.getString("wo_prv_grp_seq"));
				woVO.setWoIssNo(rowSet.getString("wo_iss_no"));
				if ("Y".equals(rowSet.getString("wo_cxl_flg"))) {
					woVO.setEdiWoIssStsCd("N");
				}
				if (("E".equals(contiCd) || "M".equals(contiCd)) && !"X".equals(rowSet.getString("WO_ISS_STS_CD"))) { // Draft W/O 인 경우는 RELRED 발송 X
					if ("DF".equals(rowSet.getString("TRS_SUB_STS_CD"))) { // Draft Cancel 인 경우는 RELRED 발송 X
						continue;
					}
					// 2015.07.30 CHAN WOO PARK
					// CHILE EPPREL/EPPRES CASE 추가
					if (i == 0) {
						iWoPrvGrpSeq = woVO.getWoPrvGrpSeq();
						iWoIssNo = woVO.getWoIssNo();
						relRedFF.add(woVO);
					} else {
						if (!(iWoPrvGrpSeq.equals(woVO.getWoPrvGrpSeq()) && iWoIssNo.equals(woVO.getWoIssNo()))) {
							iWoPrvGrpSeq = woVO.getWoPrvGrpSeq();
							iWoIssNo = woVO.getWoIssNo();
							relRedFF.add(woVO);
						}
					}
					i++;
				}
				event.setWorkOrderPreviewVO(woVO);
				if ("M".equals(contiCd)) {
					joEdiFF.add(makeFlatFileEdiUsOutBound(woVO)); // JO-EDI - Only US
				} else if ("E".equals(contiCd)) {
					joEdiFF.add(makeFlatFileEdiEuOutBound(woVO, cntrSeq, totalWoCnt)); // JO-EDI - EUR,
				}
				cntrSeq++;
			}
			rsltFlatFileHashmap.put("JOEDI", joEdiFF);
			rsltFlatFileHashmap.put("RELRED", relRedFF);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return rsltFlatFileHashmap;
	}

	/**
	 * Flat file transfer<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public String[] sendFlatFile(Event e) throws EventException {

		EsdTrs0024Event event = (EsdTrs0024Event) e;
		WorkOrderPreviewVO woVO = event.getWorkOrderPreviewVO();

		String fileNo = "1";
		String woEdiUseFlg = null;
		woEdiUseFlg = woVO.getWoEdiUseFlg();
		if (woEdiUseFlg == null || !woEdiUseFlg.equals("EDI"))
			return null;

		String[] returnArray = new String[3];
		try {
			woVO.setFltFileNo(fileNo);
			woVO.setEdiFltCd("102297");
			event.setWorkOrderPreviewVO(woVO);
			returnArray = makeFlatFileEdiEuOutBound(woVO, 1, 1);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return returnArray;
	}

	/**
	 * Flat File transfer. <br>
	 * 
	 * @param flatFile
	 * @return String
	 * @exception EventException
	 */
	public String sendFlatMessage(String flatFile) throws EventException {
		return eaiDao.sendFlatMessage(flatFile);
	}

	/**
	 * workordermanage biz scenario closing<br>
	 * WorkOrderPreview clearing related objects<br>
	 */
	public void doEnd() {
		dbDao = null;
	}

	/**
	 * If the vendor sequence is changed S / O is to look up on bkg_no<br>
	 * When wo preview confirm there has been a change in vendor sequence is checked and, if changed, will return bkg_no. <br>
	 * 
	 * @return response bkg_no
	 * @exception EventException
	 */
	public List<String> getBkgNoIfVndrChanged(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		try {
			return dbDao.getBkgNoIfVndrChanged(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * WorkOrder Send FAX
	 * 
	 * @param Event e
	 * @param String userId
	 * @param String workOrderNo
	 * @exception EventException
	 */
	public void sendEaiFax(Event e, String userId, String workOrderNo) throws EventException {
		try {
			eaiDao.sendEaiFax(e, userId, workOrderNo);
		} catch (ServerExportException se) {
			log.error(se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * WorkOrder Send Mail
	 * 
	 * @param Event e
	 * @param wonoRowSet
	 * @return List
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public List emailSend(Event e, DBRowSet wonoRowSet) throws EventException {
		List arrWoMail = new ArrayList();
		try {
			arrWoMail = eaiDao.emailSend(e, wonoRowSet);
		} catch (ServerExportException se) {
			throw new EventException(se.getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage());
		}
		return arrWoMail;
	}

	/**
	 * makeFlatFileEdiUsOutBound
	 * 
	 * @param woVO
	 * @return String[]
	 * @throws EventException
	 */
	public String[] makeFlatFileEdiUsOutBound(WorkOrderPreviewVO woVO) throws EventException {
		String woEdiUseFlg = woVO.getWoEdiUseFlg();
		String woIssStsCd = woVO.getEdiWoIssStsCd();
		if (woEdiUseFlg == null || !woEdiUseFlg.equals("EDI")) {
			return null;
		}
		String[] returnArray = new String[3];
		try {
			DBRowSet mRowSet = ediDao.searchFlatFileUsvMaster(woVO);
			if (mRowSet.getRowCount() <= 0)
				throw new EventException("Data Not Found");
			else {
				while (mRowSet.next()) {
					if ("I".equals(woIssStsCd)) {
						returnArray = ffJoEdiUSOutbound(woVO, mRowSet, "CRT");
					} else if ("R".equals(woIssStsCd) || "C".equals(woIssStsCd)) {
						returnArray = ffJoEdiUSOutbound(woVO, mRowSet, "UPDT");
					} else if ("N".equals(woIssStsCd)) {
						returnArray = ffJoEdiSndAckOutBound(woVO, mRowSet, "N");
					} else if ("J".equals(woIssStsCd)) {
						returnArray = ffJoEdiSndAckOutBound(woVO, mRowSet, "J");
					} else if ("A".equals(woIssStsCd)) {
						returnArray = ffJoEdiSndAckOutBound(woVO, mRowSet, "A");
					}
					addJoEdiHistory(mRowSet, woVO);
				}
			}
			return returnArray;
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}

	}

	/**
	 * NYK-Hawk_FFile(USV_N)-JOEDICRT_IAS_OUTBOUND <BR>
	 * NYK-Hawk_FFile(USV_N)-JOEDIUPDT_IAS_OUTBOUND
	 * 
	 * @param e
	 * @param type
	 * @return
	 * @throws EventException
	 */
	private String[] ffJoEdiUSOutbound(WorkOrderPreviewVO woVO, DBRowSet mRowSet, String type) throws EventException {
		StringBuilder sb = new StringBuilder();
		DBRowSet eqRowSet = null;
		DBRowSet sealRowSet = null;
		DBRowSet chargeRowSet = null;
		DBRowSet hzRowSet = null;
		DBRowSet stopRowSet = null;
		DBRowSet appRowSet = null;
		DBRowSet apptEqRowSet = null;

		String msgType;
		String headerBrace;

		String[] returnArray = new String[3];
		returnArray[0] = "USA";
		try {
			if ("UPDT".equals(type)) {
				msgType = "JOEDIUPDT";
				headerBrace = "UPDT";
			} else {
				msgType = "JOEDICRT";
				headerBrace = "CRT";
			}
			sb.append("$$$MSGSTART:" + StringUtils.rightPad("OSCAR", 20, "") + StringUtils.rightPad("IA", 20, "") + StringUtils.rightPad(msgType, 10, "") + ReferenceNumberGeneratorBroker.getKey("TRS", "TRS_EDI_EUR_HD_SEQ")).append("\n");
			sb.append("{").append(headerBrace).append("\n");
			sb.append("JO_ITEM_MSG_TYPE:").append(checkBlankToReplace(mRowSet, "JO_ITEM_MSG_TYPE", null)).append("\n");
			sb.append("SND_CD:").append(checkBlankToReplace(mRowSet, "SND_CD", null)).append("\n");
			sb.append("RCV_CD:").append(checkBlankToReplace(mRowSet, "RCV_CD", null)).append("\n");
			sb.append("JO_ITEM_REF:").append(checkBlankToReplace(mRowSet, "JO_ITEM_REF", null)).append("\n");
			sb.append("CARRIER_CD:").append(checkBlankToReplace(mRowSet, "CARRIER_CD", null)).append("\n");
			sb.append("MOVE_TYPE:").append(checkBlankToReplace(mRowSet, "MOVE_TYPE", null)).append("\n");
			sb.append("TRIP_TYPE:").append(checkBlankToReplace(mRowSet, "TRIP_TYPE", null)).append("\n");
			sb.append("CATEGORY:").append(checkBlankToReplace(mRowSet, "CATEGORY", null)).append("\n");
			sb.append("CREATEBY:").append(checkBlankToReplace(mRowSet, "CREATEBY", null)).append("\n");
			sb.append("WO_DT:").append(checkBlankToReplace(mRowSet, "WO_DT", null)).append("\n");
			sb.append("BKG_NO:").append(checkBlankToReplace(mRowSet, "BKG_NO", null)).append("\n");
			sb.append("BL_NO:").append(checkBlankToReplace(mRowSet, "BL_NO", null)).append("\n");
			sb.append("RAIL_BILL_NO:").append(checkBlankToReplace(mRowSet, "RAIL_BILL_NO", null)).append("\n");
			sb.append("VND_NO:").append(checkBlankToReplace(mRowSet, "VND_NO", null)).append("\n");
			sb.append("SND_REF:").append(checkBlankToReplace(mRowSet, "SND_REF", null)).append("\n");
			sb.append("RESPOND_DT:").append(checkBlankToReplace(mRowSet, "RESPOND_DT", null)).append("\n");
			sb.append("LAST_FREE_DT:").append(checkBlankToReplace(mRowSet, "LAST_FREE_DT", null)).append("\n");
			sb.append("CUTOFF_DT:").append(checkBlankToReplace(mRowSet, "CUTOFF_DT", null)).append("\n");
			sb.append("VESSEL:").append(checkBlankToReplace(mRowSet, "VESSEL", null)).append("\n");
			sb.append("VOYAGE:").append(checkBlankToReplace(mRowSet, "VOYAGE", null)).append("\n");
			sb.append("POL_NAME:").append(checkBlankToReplace(mRowSet, "POL_NAME", null)).append("\n");
			sb.append("POD_NAME:").append(checkBlankToReplace(mRowSet, "POD_NAME", null)).append("\n");
			sb.append("ARR_ETA:").append(checkBlankToReplace(mRowSet, "ARR_ETA", null)).append("\n");
			sb.append("SHPR:").append(checkBlankToReplace(mRowSet, "SHPR", null)).append("\n");
			sb.append("BRKR:").append(checkBlankToReplace(mRowSet, "BRKR", null)).append("\n");
			sb.append("BILLTO:").append(checkBlankToReplace(mRowSet, "BILLTO", null)).append("\n");
			sb.append("CARRIER_CD:").append(checkBlankToReplace(mRowSet, "CARRIER_CD", null)).append("\n");
			sb.append("COMMENT:").append(checkBlankToReplace(mRowSet, "WO_RMK", null)).append("\n");
			sb.append("{EQUIPMENT_LIST").append("\n");
			eqRowSet = ediDao.searchFlatFileUsvEquipment(mRowSet);
			while (eqRowSet.next()) {
				sb.append("{EQUIPMENT").append("\n");
				sb.append("CNTR_NO:").append(checkBlankToReplace(eqRowSet, "CNTR_NO", null)).append("\n");
				sb.append("CNTR_TPSZ:").append(checkBlankToReplace(eqRowSet, "CNTR_TPSZ", null)).append("\n");
				sb.append("PKG_QTY:").append(checkBlankToReplace(eqRowSet, "PKG_QTY", null)).append("\n");
				sb.append("N_EGT:").append(checkBlankToReplace(eqRowSet, "N_EGT", null)).append("\n");
				sb.append("T_WGT:").append(checkBlankToReplace(eqRowSet, "T_WGT", null)).append("\n");
				sb.append("G_WGT:").append(checkBlankToReplace(eqRowSet, "G_WGT", null)).append("\n");
				sb.append("WGTUNIT:").append(checkBlankToReplace(eqRowSet, "WGTUNIT", null)).append("\n");
				sb.append("VOL:").append(checkBlankToReplace(eqRowSet, "VOL", null)).append("\n");
				sb.append("VOLUNIT:").append(checkBlankToReplace(eqRowSet, "VOLUNIT", null)).append("\n");
				sb.append("FREIGHT_DESC:").append(checkBlankToReplace(eqRowSet, "FREIGHT_DESC", null)).append("\n");
				sealRowSet = ediDao.searchFlatFileUsvSeal(eqRowSet);
				while (sealRowSet.next()) {
					sb.append("{SEAL").append("\n");
					sb.append("SEAL_NO:").append(checkBlankToReplace(sealRowSet, "CNTR_SEAL_NO", null)).append("\n");
					sb.append("}SEAL").append("\n");
				}
				sb.append("MTREL_NO:").append(checkBlankToReplace(eqRowSet, "MTREL_NO", null)).append("\n");
				sb.append("HAZMAT:").append(checkBlankToReplace(eqRowSet, "HAZMAT", null)).append("\n");
				sb.append("OVWGT:").append(checkBlankToReplace(eqRowSet, "OVWGT", null)).append("\n");
				sb.append("SHIP_NO:").append(checkBlankToReplace(eqRowSet, "SHIP_NO", null)).append("\n");
				sb.append("HEIGHT:").append(checkBlankToReplace(eqRowSet, "HEIGHT", null)).append("\n");
				sb.append("WIDTH:").append(checkBlankToReplace(eqRowSet, "WIDTH", null)).append("\n");
				sb.append("DEPTH:").append(checkBlankToReplace(eqRowSet, "DEPTH", null)).append("\n");
				sb.append("COMMENT:").append(checkBlankToReplace(eqRowSet, "EQ_COMMENT", null)).append("\n");

				chargeRowSet = ediDao.searchFlatFileUsvCharge(mRowSet, eqRowSet);
				while (chargeRowSet.next()) {
					sb.append("{CHARGE").append("\n");
					sb.append("STOP_NO:").append(checkBlankToReplace(chargeRowSet, "STOP_NO", null)).append("\n");
					sb.append("SVC_CD:").append(checkBlankToReplace(chargeRowSet, "SVC_CD", null)).append("\n");
					sb.append("AMOUNT:").append(checkBlankToReplace(chargeRowSet, "AMOUNT", null)).append("\n");
					sb.append("CURRENCY:").append(checkBlankToReplace(chargeRowSet, "CURRENCY", null)).append("\n");
					sb.append("FSC_PERCENT:").append(checkBlankToReplace(chargeRowSet, "FSC_PERCENT", null)).append("\n");
					sb.append("BILLABLE:").append(checkBlankToReplace(chargeRowSet, "BILLABLE", null)).append("\n");
					sb.append("CHARGE_REF:").append(checkBlankToReplace(chargeRowSet, "CHARGE_REF", null)).append("\n");
					sb.append("BILLTO:").append(checkBlankToReplace(chargeRowSet, "BILLTO", null)).append("\n");
					sb.append("COMMENT:").append(checkBlankToReplace(chargeRowSet, "CHG_COMMENT", null)).append("\n");
					sb.append("}CHARGE").append("\n");
				}
				hzRowSet = ediDao.searchFlatFileUsvHazardodus(mRowSet, eqRowSet);
				while (hzRowSet.next()) {
					sb.append("{HAZARDODUS").append("\n");
					sb.append("CMDD:").append(checkBlankToReplace(hzRowSet, "CMDD", null)).append("\n");
					sb.append("SHP_QUAL:").append(checkBlankToReplace(hzRowSet, "SHP_QUAL", null)).append("\n");
					sb.append("CLASS:").append(checkBlankToReplace(hzRowSet, "CLASS", null)).append("\n");
					sb.append("CLASS_QUAL:").append(checkBlankToReplace(hzRowSet, "CLASS_QUAL", null)).append("\n");
					sb.append("UN_NO:").append(checkBlankToReplace(hzRowSet, "UN_NO", null)).append("\n");
					sb.append("WGT:").append(checkBlankToReplace(hzRowSet, "WGT", null)).append("\n");
					sb.append("WGTUNIT:").append(checkBlankToReplace(hzRowSet, "WGTUNIT", null)).append("\n");
					sb.append("D_PKG_GRP:").append(checkBlankToReplace(hzRowSet, "D_PKG_GRP", null)).append("\n");
					sb.append("IMO_LIMIT:").append(checkBlankToReplace(hzRowSet, "IMO_LIMIT", null)).append("\n");
					sb.append("NOS:").append(checkBlankToReplace(hzRowSet, "NOS", null)).append("\n");
					sb.append("TECH_NAME:").append(checkBlankToReplace(hzRowSet, "TECH_NAME", null)).append("\n");
					sb.append("D_PKG_UNIT:").append(checkBlankToReplace(hzRowSet, "D_PKG_UNIT", null)).append("\n");
					sb.append("D_PKG_QTY:").append(checkBlankToReplace(hzRowSet, "D_PKG_QTY", null)).append("\n");
					sb.append("D_PKG:").append(checkBlankToReplace(hzRowSet, "D_PKG", null)).append("\n");
					sb.append("CONTACT_NM:").append(checkBlankToReplace(hzRowSet, "CONTACT_NM", null)).append("\n");
					sb.append("CONTACT_TEL:").append(checkBlankToReplace(hzRowSet, "CONTACT_TEL", null)).append("\n");
					sb.append("CONTACT_REF:").append(checkBlankToReplace(hzRowSet, "CONTACT_REF", null)).append("\n");
					sb.append("REPORT_IND:").append(checkBlankToReplace(hzRowSet, "REPORT_IND", null)).append("\n");
					sb.append("FLASH_UNIT:").append(checkBlankToReplace(hzRowSet, "FLASH_UNIT", null)).append("\n");
					sb.append("FLASH:").append(checkBlankToReplace(hzRowSet, "FLASH", null)).append("\n");
					sb.append("MAR_POLL:").append(checkBlankToReplace(hzRowSet, "MAR_POLL", null)).append("\n");
					sb.append("COMMENT:").append(checkBlankToReplace(hzRowSet, "HS_COMMENT", null)).append("\n");
					sb.append("}HAZARDODUS").append("\n");
				}
				sb.append("}EQUIPMENT").append("\n");
			}
			sb.append("}EQUIPMENT_LIST").append("\n");
			sb.append("{STOP_LIST").append("\n");
			stopRowSet = ediDao.searchFlatFileUsvStop(mRowSet);
			while (stopRowSet.next()) {
				sb.append("{STOP").append("\n");
				sb.append("STOP_TP:").append(checkBlankToReplace(stopRowSet, "STOP_TP", null)).append("\n");
				sb.append("STOP_NM:").append(checkBlankToReplace(stopRowSet, "STOP_NM", null)).append("\n");
				sb.append("STOP_NO:").append(checkBlankToReplace(stopRowSet, "STOP_NO", null)).append("\n");
				sb.append("{LOCATION").append("\n");
				sb.append("STOP_LOC:").append(checkBlankToReplace(stopRowSet, "STOP_LOC", null)).append("\n");
				sb.append("STOP_REF:").append(checkBlankToReplace(stopRowSet, "STOP_REF", null)).append("\n");
				sb.append("STOP_ADD1:").append(checkBlankToReplace(stopRowSet, "STOP_ADD1", null)).append("\n");
				sb.append("STOP_ADD2:").append(checkBlankToReplace(stopRowSet, "STOP_ADD2", null)).append("\n");
				sb.append("STOP_CITY:").append(checkBlankToReplace(stopRowSet, "STOP_CITY", null)).append("\n");
				sb.append("STOP_STATE:").append(checkBlankToReplace(stopRowSet, "STOP_STATE", null)).append("\n");
				sb.append("STOP_CNT:").append(checkBlankToReplace(stopRowSet, "STOP_CNT", null)).append("\n");
				sb.append("STOP_POSTAL:").append(checkBlankToReplace(stopRowSet, "STOP_POSTAL", null)).append("\n");
				sb.append("STOP_TZ:").append(checkBlankToReplace(stopRowSet, "STOP_TZ", null)).append("\n");
				sb.append("STOP_CONTACT_NM:").append(checkBlankToReplace(stopRowSet, "STOP_CONTACT_NM", null)).append("\n");
				sb.append("STOP_CONTACT_TE:").append(checkBlankToReplace(stopRowSet, "STOP_CONTACT_TE", null)).append("\n");
				sb.append("COMMENT:").append(checkBlankToReplace(stopRowSet, "STOP_COMMENT", null)).append("\n");
				sb.append("}LOCATION").append("\n");
				sb.append("{APPT_LIST").append("\n");
				appRowSet = ediDao.searchFlatFileUsvAppt(stopRowSet);
				while (appRowSet.next()) {
					sb.append("{APPT").append("\n");
					apptEqRowSet = ediDao.searchFlatFileUsvApptEq(appRowSet);
					while (apptEqRowSet.next()) {
						sb.append("{APPT_EQ").append("\n");
						sb.append("CNTR_NO:").append(checkBlankToReplace(apptEqRowSet, "CNTR_NO", null)).append("\n");
						sb.append("CNTR_TPSZ:").append(checkBlankToReplace(apptEqRowSet, "CNTR_TPSZ", null)).append("\n");
						sb.append("}APPT_EQ").append("\n");
					}
					sb.append("GATE_IN_START:").append(checkBlankToReplace(appRowSet, "GATE_IN_START", null)).append("\n");
					sb.append("GATE_IN_END:").append(checkBlankToReplace(appRowSet, "GATE_IN_END", null)).append("\n");
					sb.append("GATE_IN_FORM:").append(checkBlankToReplace(appRowSet, "GATE_IN_FORM", null)).append("\n");
					sb.append("GATE_OUT_START:").append(checkBlankToReplace(appRowSet, "GATE_OUT_START", null)).append("\n");
					sb.append("GATE_OUT_EDN:").append(checkBlankToReplace(appRowSet, "GATE_OUT_EDN", null)).append("\n");
					sb.append("GATE_OUT_FORM:").append(checkBlankToReplace(appRowSet, "GATE_OUT_FORM", null)).append("\n");
					sb.append("}APPT").append("\n");
				}
				sb.append("}APPT_LIST").append("\n");
				sb.append("}STOP").append("\n");
			}
			sb.append("}STOP_LIST").append("\n");
			sb.append("}").append(headerBrace);
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		returnArray[1] = sb.toString();
		returnArray[2] = woVO.getEdiVndrSeq();
		return returnArray;
	}

	/**
	 * 
	 * @param woVO
	 * @param mRowSet
	 * @param type
	 * @return
	 * @throws EventException
	 */
	private String[] ffJoEdiSndAckOutBound(WorkOrderPreviewVO woVO, DBRowSet mRowSet, String type) throws EventException {
		try {
			String headerBrace = "";
			String msgType = "";
			if ("N".equals(type)) {
				headerBrace = "CAN";
				msgType = "JOEDICAN";
			} else if ("A".equals(type)) {
				headerBrace = "ACC";
				msgType = "JOEDIACC";
			} else if ("J".equals(type)) {
				headerBrace = "REJT";
				msgType = "JOEDIREJ";
			}
			String[] returnArray = new String[3];
			returnArray[0] = "USA";
			StringBuilder sb = new StringBuilder();
			sb.append("$$$MSGSTART:" + StringUtils.rightPad("OSCAR", 20, "") + StringUtils.rightPad("IA", 20, "") + StringUtils.rightPad(msgType, 10, "") + ReferenceNumberGeneratorBroker.getKey("TRS", "TRS_EDI_EUR_HD_SEQ")).append("\n");
			sb.append("{").append(headerBrace).append("\n");
			sb.append("JO_ITEM_MSG_TYPE:").append(checkBlankToReplace(mRowSet, "JO_ITEM_MSG_TYPE", null)).append("\n");
			sb.append("SND_CD:").append(checkBlankToReplace(mRowSet, "SND_CD", null)).append("\n");
			sb.append("RCV_CD:").append(checkBlankToReplace(mRowSet, "RCV_CD", null)).append("\n");
			sb.append("JO_ITEM_REF:").append(checkBlankToReplace(mRowSet, "JO_ITEM_REF", null)).append("\n");
			sb.append("}").append(headerBrace);
			returnArray[1] = sb.toString();
			returnArray[2] = woVO.getEdiVndrSeq();

			log.info("ffJoEdiSndAckOutBound ::: " + sb.toString());
			return returnArray;
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * 
	 * @param woVO
	 * @param cntrSeq
	 * @param totalWoCnt
	 * @return
	 * @throws Exception
	 */
	private String[] makeFlatFileEdiEuOutBound(WorkOrderPreviewVO woVO, int cntrSeq, int totalWoCnt) throws Exception {
		String woEdiUseFlg = woVO.getWoEdiUseFlg();

		if (woEdiUseFlg == null || !woEdiUseFlg.equals("EDI")) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		DBRowSet masterRowSet = null;
		DBRowSet railScacCodeRowSet = null;
		DBRowSet portVoyageDetailRowSet = null;
		DBRowSet partyRowSet = null;
		DBRowSet chargeRowSet = null;
		DBRowSet surchargeRowSet = null;
		DBRowSet equipmentRowSet = null;
		DBRowSet equipmentMeasurementRowSet = null;
		DBRowSet hazardodusRowSet = null;
		DBRowSet measure2RowSet = null;
		DBRowSet sealRowSet = null;
		DBRowSet eq2RowSet = null;
		DBRowSet mrnRowSet = null;
		DBRowSet measure3RowSet = null;
		DBRowSet awkardRowSet = null;
		DBRowSet awkardMeasureRowSet = null;
		DBRowSet reeferRowSet = null;
		DBRowSet stopRowSet = null;
		DBRowSet orginRowSet = null;
		DBRowSet destRowSet = null;
		DBRowSet appointRowSet = null;
		String[] returnArray = new String[3];
		returnArray[0] = "EUR_ASIA";
		try {
			masterRowSet = ediDao.searchFlatFileEsvMaster(woVO);
			sb.append("$$$MSGSTART:" + StringUtils.rightPad("OSCAR", 20, "") + StringUtils.rightPad(receiverIdForJoEdiEu(woVO.getEdiVndrSeq()), 20, "") + StringUtils.rightPad("JOEDI", 10, "") + ReferenceNumberGeneratorBroker.getKey("TRS", "TRS_EDI_EUR_HD_SEQ")).append("\n");
			while (masterRowSet.next()) {
				sb.append("{EU").append("\n");
				sb.append("JO_ITEM_MSG_TYPE:").append(checkBlankToReplace(masterRowSet, "JO_ITEM_MSG_TYPE", null)).append("\n");
				sb.append("SND_CD:").append(checkBlankToReplace(masterRowSet, "SND_CD", null)).append("\n");
				sb.append("RCV_CD:").append(checkBlankToReplace(masterRowSet, "RCV_CD", null)).append("\n");
				sb.append("JO_ITEM_REF:").append(checkBlankToReplace(masterRowSet, "JO_ITEM_REF", null)).append("\n");
				sb.append("CARRIER_CD:").append(checkBlankToReplace(masterRowSet, "CARRIER_CD", null)).append("\n");
				sb.append("MOVE_TYPE:").append(checkBlankToReplace(masterRowSet, "MOVE_TYPE", null)).append("\n");
				sb.append("TRIP_TYPE:").append(checkBlankToReplace(masterRowSet, "TRIP_TYPE", null)).append("\n");
				sb.append("CATEGORY:").append(checkBlankToReplace(masterRowSet, "CATEGORY", null)).append("\n");
				sb.append("CREATEBY:").append(checkBlankToReplace(masterRowSet, "CREATEBY", null)).append("\n");
				sb.append("AMEND_NO:").append(checkBlankToReplace(masterRowSet, "AMEND_NO", null)).append("\n");
				sb.append("VERSION_NO:").append(checkBlankToReplace(masterRowSet, "VERSION_NO", null)).append("\n");
				sb.append("JO_ISSUE_DT:").append(checkBlankToReplace(masterRowSet, "JO_ISSUE_DT", null)).append("\n");
				sb.append("RESPOND_DT:").append(checkBlankToReplace(masterRowSet, "RESPOND_DT", null)).append("\n");
				sb.append("TRANS_MD:").append(checkBlankToReplace(masterRowSet, "TRANS_MD", null)).append("\n");
				sb.append("COMMENT:").append(checkBlankToReplace(masterRowSet, "M_COMMENT", null)).append("\n");
				sb.append("REASON_CD:").append(checkBlankToReplace(masterRowSet, "REASON_CD", null)).append("\n");
				railScacCodeRowSet = ediDao.searchFlatFileEsvRail(masterRowSet);
				while (railScacCodeRowSet.next()) {
					sb.append("{RAIL_SCAC_CODE").append("\n");
					sb.append("SEQ_NO:").append(checkBlankToReplace(railScacCodeRowSet, "SEQ_NO", null)).append("\n");
					sb.append("RAIL_SCAC_CD:").append(checkBlankToReplace(railScacCodeRowSet, "RAIL_SCAC_CD", null)).append("\n");
					sb.append("}RAIL_SCAC_CODE").append("\n");
				}
				sb.append("CNTR_SEQ:").append(cntrSeq).append("\n");
				sb.append("TOTAL_CNTR:").append(totalWoCnt).append("\n");
				portVoyageDetailRowSet = ediDao.searchFlatFileEsvPort(masterRowSet);
				while (portVoyageDetailRowSet.next()) {
					sb.append("{PORT_VOYAGE_DETAIL").append("\n");
					sb.append("EX_VOY_REF:").append(checkBlankToReplace(portVoyageDetailRowSet, "EX_VOY_REF", null)).append("\n");
					sb.append("SVC_LOOP:").append(checkBlankToReplace(portVoyageDetailRowSet, "SVC_LOOP", null)).append("\n");
					sb.append("VESSEL:").append(checkBlankToReplace(portVoyageDetailRowSet, "VESSEL", null)).append("\n");
					sb.append("VOYAGE:").append(checkBlankToReplace(portVoyageDetailRowSet, "VOYAGE", null)).append("\n");
					sb.append("DIRECTION:").append(checkBlankToReplace(portVoyageDetailRowSet, "DIRECTION", null)).append("\n");
					sb.append("CALLSIGN:").append(checkBlankToReplace(portVoyageDetailRowSet, "CALLSIGN", null)).append("\n");
					sb.append("POL_NAME:").append(checkBlankToReplace(portVoyageDetailRowSet, "POL_NAME", null)).append("\n");
					sb.append("POL_UNLC:").append(checkBlankToReplace(portVoyageDetailRowSet, "POL_UNLC", null)).append("\n");
					sb.append("POD_NAME:").append(checkBlankToReplace(portVoyageDetailRowSet, "POD_NAME", null)).append("\n");
					sb.append("POD_UNLC:").append(checkBlankToReplace(portVoyageDetailRowSet, "POD_UNLC", null)).append("\n");
					sb.append("ARR_ETA:").append(checkBlankToReplace(portVoyageDetailRowSet, "ARR_ETA", null)).append("\n");
					sb.append("LAST_FREE_DT:").append(checkBlankToReplace(portVoyageDetailRowSet, "LAST_FREE_DT", null)).append("\n");
					sb.append("CUTOFF_DT:").append(checkBlankToReplace(portVoyageDetailRowSet, "CUTOFF_DT", null)).append("\n");
					sb.append("}PORT_VOYAGE_DETAIL").append("\n");
				}

				partyRowSet = ediDao.searchFlatFileEsvParty(masterRowSet);
				while (partyRowSet.next()) {
					sb.append("{PARTY").append("\n");
					sb.append("PARTY_TYPE:").append(checkBlankToReplace(partyRowSet, "PARTY_TYPE", null)).append("\n");
					sb.append("PARTY_NAME:").append(checkBlankToReplace(partyRowSet, "PARTY_NAME", null)).append("\n");
					sb.append("PARTY_ADD1:").append(checkBlankToReplace(partyRowSet, "PARTY_ADD1", null)).append("\n");
					sb.append("PARTY_ADD2:").append(checkBlankToReplace(partyRowSet, "PARTY_ADD2", null)).append("\n");
					sb.append("PARTY_CITY:").append(checkBlankToReplace(partyRowSet, "PARTY_CITY", null)).append("\n");
					sb.append("PARTY_POSTAL:").append(checkBlankToReplace(partyRowSet, "PARTY_POSTAL", null)).append("\n");
					sb.append("PARTY_STATE:").append(checkBlankToReplace(partyRowSet, "PARTY_STATE", null)).append("\n");
					sb.append("PARTY_CNT:").append(checkBlankToReplace(partyRowSet, "PARTY_CNT", null)).append("\n");
					sb.append("}PARTY").append("\n");
				}

				chargeRowSet = ediDao.searchFlatFileEsvCharge(masterRowSet);
				while (chargeRowSet.next()) {
					sb.append("{CHARGE").append("\n");
					sb.append("FREIGHT:").append(checkBlankToReplace(chargeRowSet, "FREIGHT", null)).append("\n");
					sb.append("CURRENCY:").append(checkBlankToReplace(chargeRowSet, "CURRENCY", null)).append("\n");
					sb.append("FSC_PERCENT:").append(checkBlankToReplace(chargeRowSet, "FSC_PERCENT", null)).append("\n");
					sb.append("BILLABLE:").append(checkBlankToReplace(chargeRowSet, "BILLABLE", null)).append("\n");
					sb.append("CHARGE_REF:").append(checkBlankToReplace(chargeRowSet, "CHARGE_REF", null)).append("\n");
					sb.append("COMMENT:").append(checkBlankToReplace(chargeRowSet, "CHARGE_COMMENT", null)).append("\n");
					sb.append("TOTAL_CHARGE:").append(checkBlankToReplace(chargeRowSet, "TOTAL_CHARGE", null)).append("\n");
					sb.append("}CHARGE").append("\n");
				}

				sb.append("{SURCHARGE_LIST").append("\n");
				surchargeRowSet = ediDao.searchFlatFileEsvSurcharge(masterRowSet);
				while (surchargeRowSet.next()) {
					sb.append("{SURCHARGE").append("\n");
					sb.append("SURCHARGE_TYPE:").append(checkBlankToReplace(surchargeRowSet, "SURCHARGE_TYPE", null)).append("\n");
					sb.append("AMOUNT:").append(checkBlankToReplace(surchargeRowSet, "AMOUNT", null)).append("\n");
					sb.append("CURRENCY:").append(checkBlankToReplace(surchargeRowSet, "CURRENCY", null)).append("\n");
					sb.append("BILLABLE:").append(checkBlankToReplace(surchargeRowSet, "BILLABLE", null)).append("\n");
					sb.append("SURCHARGE_REF:").append(checkBlankToReplace(surchargeRowSet, "SURCHARGE_REF", null)).append("\n");
					sb.append("COMMENT:").append(checkBlankToReplace(surchargeRowSet, "SURCHARGE_COMMENT", null)).append("\n");
					sb.append("DESCRIPTION:").append(checkBlankToReplace(surchargeRowSet, "DESCRIPTION", null)).append("\n");
					sb.append("}SURCHARGE").append("\n");
				}
				sb.append("}SURCHARGE_LIST").append("\n");
				sb.append("WAYBILL_NO:").append(checkBlankToReplace(masterRowSet, "WAYBILL_NO", null)).append("\n");
				equipmentRowSet = ediDao.searchFlatFileEsvEquipment(masterRowSet);
				while (equipmentRowSet.next()) {
					sb.append("{EQUIPMENT").append("\n");
					sb.append("CNTR_NO:").append(checkBlankToReplace(equipmentRowSet, "CNTR_NO", null)).append("\n");
					sb.append("CNTR_TPSZ:").append(checkBlankToReplace(equipmentRowSet, "CNTR_TPSZ", null)).append("\n");
					sb.append("COMMENT:").append(checkBlankToReplace(equipmentRowSet, "EQ_COMMENT", null)).append("\n");
					sb.append("{CAEGO_DETAIL").append("\n");
					sb.append("{PACKAGE").append("\n");
					sb.append("PKG_QTY:").append(checkBlankToReplace(equipmentRowSet, "PKG_QTY", null)).append("\n");
					sb.append("PKG_CD:").append(checkBlankToReplace(equipmentRowSet, "PKG_CD", null)).append("\n");
					sb.append("PKG_TYPE:").append(checkBlankToReplace(equipmentRowSet, "PKG_TYPE", null)).append("\n");
					sb.append("}PACKAGE").append("\n");
					equipmentMeasurementRowSet = ediDao.searchFlatFileEsvEquipmentCaegoDetailMeasure(equipmentRowSet);
					while (equipmentMeasurementRowSet.next()) {
						sb.append("{MEASUREMENT").append("\n");
						sb.append("MEAS_TYPE:").append(checkBlankToReplace(equipmentMeasurementRowSet, "MEAS_TYPE", null)).append("\n");
						sb.append("MEAS_QTY:").append(checkBlankToReplace(equipmentMeasurementRowSet, "MEAS_QTY", null)).append("\n");
						sb.append("MEAS_UNIT:").append(checkBlankToReplace(equipmentMeasurementRowSet, "MEAS_UNIT", null)).append("\n");
						sb.append("}MEASUREMENT").append("\n");
					}
					sb.append("CMDD:").append(checkBlankToReplace(equipmentRowSet, "CMDD", null)).append("\n");
					sb.append("CNTR_TYPE:").append(checkBlankToReplace(equipmentRowSet, "CNTR_TYPE", null)).append("\n");
					sb.append("HS_CD:").append(checkBlankToReplace(equipmentRowSet, "HS_CD", null)).append("\n");
					hazardodusRowSet = ediDao.searchFlatFileEsvHazard(equipmentRowSet);
					while (hazardodusRowSet.next()) {
						sb.append("{HAZARDODUS").append("\n");
						measure2RowSet = ediDao.searchFlatFileEsvHazardodusMeasurement(hazardodusRowSet);
						while (measure2RowSet.next()) {
							sb.append("{MEASUREMENT").append("\n");
							sb.append("MEAS_TYPE:").append(checkBlankToReplace(measure2RowSet, "MEAS_TYPE", null)).append("\n");
							sb.append("MEAS_QTY:").append(checkBlankToReplace(measure2RowSet, "MEAS_QTY", null)).append("\n");
							sb.append("MEAS_UNIT:").append(checkBlankToReplace(measure2RowSet, "MEAS_UNIT", null)).append("\n");
							sb.append("}MEASUREMENT").append("\n");
						}
						sb.append("PRO_SH_NAME:").append(checkBlankToReplace(hazardodusRowSet, "PRO_SH_NAME", null)).append("\n");
						sb.append("TECH_NAME:").append(checkBlankToReplace(hazardodusRowSet, "TECH_NAME", null)).append("\n");
						sb.append("D_PKG:").append(checkBlankToReplace(hazardodusRowSet, "D_PKG", null)).append("\n");
						sb.append("D_PKG_CD:").append(checkBlankToReplace(hazardodusRowSet, "D_PKG_CD", null)).append("\n");
						sb.append("D_PKG_QTY:").append(checkBlankToReplace(hazardodusRowSet, "D_PKG_QTY", null)).append("\n");
						sb.append("UN_NO:").append(checkBlankToReplace(hazardodusRowSet, "UN_NO", null)).append("\n");
						sb.append("EMS_NO:").append(checkBlankToReplace(hazardodusRowSet, "EMS_NO", null)).append("\n");
						sb.append("D_PKG_GRP:").append(checkBlankToReplace(hazardodusRowSet, "D_PKG_GRP", null)).append("\n");
						sb.append("CLASS:").append(checkBlankToReplace(hazardodusRowSet, "CLASS", null)).append("\n");
						sb.append("FLASH:").append(checkBlankToReplace(hazardodusRowSet, "FLASH", null)).append("\n");
						sb.append("FLASH_UNIT:").append(checkBlankToReplace(hazardodusRowSet, "FLASH_UNIT", null)).append("\n");
						sb.append("IMO_LIMIT:").append(checkBlankToReplace(hazardodusRowSet, "IMO_LIMIT", null)).append("\n");
						sb.append("IMO_LIMIT_QTY:").append(checkBlankToReplace(hazardodusRowSet, "IMO_LIMIT_QTY", null)).append("\n");
						sb.append("REPORT_QTY:").append(checkBlankToReplace(hazardodusRowSet, "REPORT_QTY", null)).append("\n");
						sb.append("MAR_POLL:").append(checkBlankToReplace(hazardodusRowSet, "MAR_POLL", null)).append("\n");
						sb.append("REMARK:").append(checkBlankToReplace(hazardodusRowSet, "REMARK", null)).append("\n");
						sb.append("RESTRICT_CD:").append(checkBlankToReplace(hazardodusRowSet, "RESTRICT_CD", null)).append("\n");
						sb.append("{EMERGENCY_CONTACT").append("\n");
						sb.append("CONTACT_TYPE:").append(checkBlankToReplace(hazardodusRowSet, "CONTACT_TYPE", null)).append("\n");
						sb.append("CONTACT_NO:").append(checkBlankToReplace(hazardodusRowSet, "CONTACT_NO", null)).append("\n");
						sb.append("CONTACT_INFO:").append(checkBlankToReplace(hazardodusRowSet, "CONTACT_INFO", null)).append("\n");
						sb.append("}EMERGENCY_CONTACT").append("\n");
						sb.append("}HAZARDODUS").append("\n");
					}
					sb.append("}CAEGO_DETAIL").append("\n");

					sealRowSet = ediDao.searchFlatFileEsvSeal(equipmentRowSet);
					while (sealRowSet.next()) {
						sb.append("{SEAL_NUMBER").append("\n");
						sb.append("SEAL_NO:").append(checkBlankToReplace(sealRowSet, "SEAL_NO", null)).append("\n");
						sb.append("SEAL_TPYE:").append(checkBlankToReplace(sealRowSet, "SEAL_TPYE", null)).append("\n");
						sb.append("}SEAL_NUMBER").append("\n");
					}
					eq2RowSet = ediDao.searchFlatFileEsvEquipmentReference(equipmentRowSet);
					while (eq2RowSet.next()) {
						sb.append("{EQUIPMENT_REFERENCE").append("\n");
						sb.append("VENDOR_REF:").append(checkBlankToReplace(eq2RowSet, "VENDOR_REF", null)).append("\n");
						sb.append("RAIL_BILL_NO:").append(checkBlankToReplace(eq2RowSet, "RAIL_BILL_NO", null)).append("\n");
						sb.append("SND_REF:").append(checkBlankToReplace(eq2RowSet, "SND_REF", null)).append("\n");
						sb.append("MTREL_NO:").append(checkBlankToReplace(eq2RowSet, "MTREL_NO", null)).append("\n");
						sb.append("ATB_NO:").append(checkBlankToReplace(eq2RowSet, "ATB_NO", null)).append("\n");
						mrnRowSet = ediDao.searchFlatFileEsvMrn(eq2RowSet);
						while (mrnRowSet.next()) {
							sb.append("{MRN_NUMBER_LIST").append("\n");
							sb.append("MRN_NO:").append(checkBlankToReplace(mrnRowSet, "MRN_NO", null)).append("\n");
							sb.append("}MRN_NUMBER_LIST").append("\n");
						}
						sb.append("PKG_REF:").append(checkBlankToReplace(eq2RowSet, "PKG_REF", null)).append("\n");
						sb.append("MTPLAN_NO:").append(checkBlankToReplace(eq2RowSet, "MTPLAN_NO", null)).append("\n");
						sb.append("{BL_NUMBER_LIST").append("\n");
						sb.append("BL_NO:").append(checkBlankToReplace(eq2RowSet, "BL_NO", null)).append("\n");
						sb.append("}BL_NUMBER_LIST").append("\n");
						sb.append("{BN_NUMBER_LIST").append("\n");
						sb.append("BKG_NO:").append(checkBlankToReplace(eq2RowSet, "BKG_NO", null)).append("\n");
						sb.append("}BN_NUMBER_LIST").append("\n");
						sb.append("}EQUIPMENT_REFERENCE").append("\n");
					}
					measure3RowSet = ediDao.searchFlatFileEsvMeasure(equipmentRowSet);
					while (measure3RowSet.next()) {
						sb.append("{MEASUREMENT").append("\n");
						sb.append("MEAS_TYPE:").append(checkBlankToReplace(measure3RowSet, "MEAS_TYPE", null)).append("\n");
						sb.append("MEAS_QTY:").append(checkBlankToReplace(measure3RowSet, "MEAS_QTY", null)).append("\n");
						sb.append("MEAS_UNIT:").append(checkBlankToReplace(measure3RowSet, "MEAS_UNIT", null)).append("\n");
						sb.append("}MEASUREMENT").append("\n");
					}
					awkardRowSet = ediDao.searchFlatFileEsvAwkard(equipmentRowSet);
					while (awkardRowSet.next()) {
						sb.append("{AWKARD").append("\n");
						sb.append("AK_REMARK:").append(checkBlankToReplace(awkardRowSet, "AK_REMARK", null)).append("\n");
						awkardMeasureRowSet = ediDao.searchFlatFileEsvAwkardMeasure(awkardRowSet);
						while (awkardMeasureRowSet.next()) {
							sb.append("{AWKARD_MEASUREMENT").append("\n");
							sb.append("AK_TYPE:").append(checkBlankToReplace(awkardMeasureRowSet, "AK_TYPE", null)).append("\n");
							sb.append("AK_UNIT:").append(checkBlankToReplace(awkardMeasureRowSet, "AK_UNIT", null)).append("\n");
							sb.append("AK_QTY:").append(checkBlankToReplace(awkardMeasureRowSet, "AK_QTY", null)).append("\n");
							sb.append("}AWKARD_MEASUREMENT").append("\n");
						}
						sb.append("}AWKARD").append("\n");
					}

					reeferRowSet = ediDao.searchFlatFileEsvReefer(equipmentRowSet);
					while (reeferRowSet.next()) {
						sb.append("{REEFER").append("\n");
						sb.append("TEMP:").append(checkBlankToReplace(reeferRowSet, "TEMP", null)).append("\n");
						sb.append("TEMP_UNIT:").append(checkBlankToReplace(reeferRowSet, "TEMP_UNIT", null)).append("\n");
						sb.append("VENT:").append(checkBlankToReplace(reeferRowSet, "VENT", null)).append("\n");
						sb.append("VENT_NO:").append(checkBlankToReplace(reeferRowSet, "VENT_NO", null)).append("\n");
						sb.append("VENT_UNIT:").append(checkBlankToReplace(reeferRowSet, "VENT_UNIT", null)).append("\n");
						sb.append("HUMIDITY:").append(checkBlankToReplace(reeferRowSet, "HUMIDITY", null)).append("\n");
						sb.append("DRAIN_HOLE:").append(checkBlankToReplace(reeferRowSet, "DRAIN_HOLE", null)).append("\n");
						sb.append("GENSET:").append(checkBlankToReplace(reeferRowSet, "GENSET", null)).append("\n");
						sb.append("REMARK:").append(checkBlankToReplace(reeferRowSet, "REMARK", null)).append("\n");
						sb.append("}REEFER").append("\n");
					}
					sb.append("FUMIGATE:").append(checkBlankToReplace(equipmentRowSet, "FUMIGATE", null)).append("\n");
					sb.append("TRIAXLE:").append(checkBlankToReplace(equipmentRowSet, "TRIAXLE", null)).append("\n");
					sb.append("}EQUIPMENT").append("\n");
				}

				stopRowSet = ediDao.searchFlatFileEsvStop(masterRowSet);
				String totalAppt = null;
				if (stopRowSet.next()) {
					totalAppt = checkBlankToReplace(stopRowSet, "TOTAL_APPT", "");
				}
				sb.append("{STOP_LIST").append("\n");
				orginRowSet = ediDao.searchFlatFileEsvOrigin(masterRowSet);
				while (orginRowSet.next()) {
					sb.append("{ORIGIN").append("\n");
					sb.append("ORG_LOC:").append(checkBlankToReplace(orginRowSet, "ORG_LOC", null)).append("\n");
					sb.append("{LOCATION").append("\n");
					sb.append("ORG_REF:").append(checkBlankToReplace(orginRowSet, "ORG_REF", null)).append("\n");
					sb.append("ORG_NM:").append(checkBlankToReplace(orginRowSet, "ORG_NM", null)).append("\n");
					sb.append("ORG_ADD1:").append(checkBlankToReplace(orginRowSet, "ORG_ADD1", null)).append("\n");
					sb.append("ORG_ADD2:").append(checkBlankToReplace(orginRowSet, "ORG_ADD2", null)).append("\n");
					sb.append("ORG_ADD3:").append(checkBlankToReplace(orginRowSet, "ORG_ADD3", null)).append("\n");
					sb.append("ORG_ADD4:").append(checkBlankToReplace(orginRowSet, "ORG_ADD4", null)).append("\n");
					sb.append("ORG_CITY:").append(checkBlankToReplace(orginRowSet, "ORG_CITY", null)).append("\n");
					sb.append("ORG_STATE:").append(checkBlankToReplace(orginRowSet, "ORG_STATE", null)).append("\n");
					sb.append("ORG_CNT:").append(checkBlankToReplace(orginRowSet, "ORG_CNT", null)).append("\n");
					sb.append("ORG_POSTAL:").append(checkBlankToReplace(orginRowSet, "ORG_POSTAL", null)).append("\n");
					sb.append("ORG_TZ:").append(checkBlankToReplace(orginRowSet, "ORG_TZ", null)).append("\n");
					sb.append("ORG_CONTACT_NM:").append(checkBlankToReplace(orginRowSet, "ORG_CONTACT_NM", null)).append("\n");
					sb.append("ORG_CONTACT_TE:").append(checkBlankToReplace(orginRowSet, "ORG_CONTACT_TE", null)).append("\n");
					sb.append("COMMENT:").append(checkBlankToReplace(orginRowSet, "ORG_COMMENT", null)).append("\n");
					sb.append("}LOCATION").append("\n");
					sb.append("ORG_PLN_DT:").append(checkBlankToReplace(orginRowSet, "ORG_PLN_DT", null)).append("\n");
					sb.append("ORG_ACTL_DT:").append(checkBlankToReplace(orginRowSet, "ORG_ACTL_DT", null)).append("\n");
					sb.append("ORG_TYPE:").append(checkBlankToReplace(orginRowSet, "ORG_TYPE", null)).append("\n");
					sb.append("}ORIGIN").append("\n");
				}

				destRowSet = ediDao.searchFlatFileEsvDestination(masterRowSet);
				while (destRowSet.next()) {
					sb.append("{DESTINATION").append("\n");
					sb.append("DEST_LOC:").append(checkBlankToReplace(destRowSet, "DEST_LOC", null)).append("\n");
					sb.append("{LOCATION").append("\n");
					sb.append("DEST_REF:").append(checkBlankToReplace(destRowSet, "DEST_REF", null)).append("\n");
					sb.append("DEST_NM:").append(checkBlankToReplace(destRowSet, "DEST_NM", null)).append("\n");
					sb.append("DEST_ADD1:").append(checkBlankToReplace(destRowSet, "DEST_ADD1", null)).append("\n");
					sb.append("DEST_ADD2:").append(checkBlankToReplace(destRowSet, "DEST_ADD2", null)).append("\n");
					sb.append("DEST_ADD3:").append(checkBlankToReplace(destRowSet, "DEST_ADD3", null)).append("\n");
					sb.append("DEST_ADD4:").append(checkBlankToReplace(destRowSet, "DEST_ADD4", null)).append("\n");
					sb.append("DEST_CITY:").append(checkBlankToReplace(destRowSet, "DEST_CITY", null)).append("\n");
					sb.append("DEST_STATE:").append(checkBlankToReplace(destRowSet, "DEST_STATE", null)).append("\n");
					sb.append("DEST_CNT:").append(checkBlankToReplace(destRowSet, "DEST_CNT", null)).append("\n");
					sb.append("DEST_POSTAL:").append(checkBlankToReplace(destRowSet, "DEST_POSTAL", null)).append("\n");
					sb.append("DEST_TZ:").append(checkBlankToReplace(destRowSet, "DEST_TZ", null)).append("\n");
					sb.append("DEST_CONTACT_NM:").append(checkBlankToReplace(destRowSet, "DEST_CONTACT_NM", null)).append("\n");
					sb.append("DEST_CONTACT_TE:").append(checkBlankToReplace(destRowSet, "DEST_CONTACT_TE", null)).append("\n");
					sb.append("COMMENT:").append(checkBlankToReplace(destRowSet, "DEST_COMMENT", null)).append("\n");
					sb.append("}LOCATION").append("\n");
					sb.append("DEST_PLN_DT:").append(checkBlankToReplace(destRowSet, "DEST_PLN_DT", null)).append("\n");
					sb.append("DEST_ACTL_DT:").append(checkBlankToReplace(destRowSet, "DEST_ACTL_DT", null)).append("\n");
					sb.append("DEST_TYPE:").append(checkBlankToReplace(destRowSet, "DEST_TYPE", null)).append("\n");
					sb.append("}DESTINATION").append("\n");
				}
				appointRowSet = ediDao.searchFlatFileEsvAppoint(masterRowSet);
				while (appointRowSet.next()) {
					sb.append("{APPOINTMENT").append("\n");
					sb.append("{LOCATION").append("\n");
					sb.append("APPT_REF:").append(checkBlankToReplace(appointRowSet, "APPT_REF", null)).append("\n");
					sb.append("APPT_NM:").append(checkBlankToReplace(appointRowSet, "APPT_NM", null)).append("\n");
					sb.append("APPT_ADD1:").append(checkBlankToReplace(appointRowSet, "APPT_ADD1", null)).append("\n");
					sb.append("APPT_ADD2:").append(checkBlankToReplace(appointRowSet, "APPT_ADD2", null)).append("\n");
					sb.append("APPT_ADD3:").append(checkBlankToReplace(appointRowSet, "APPT_ADD3", null)).append("\n");
					sb.append("APPT_ADD4:").append(checkBlankToReplace(appointRowSet, "APPT_ADD4", null)).append("\n");
					sb.append("APPT_CITY:").append(checkBlankToReplace(appointRowSet, "APPT_CITY", null)).append("\n");
					sb.append("APPT_SATE:").append(checkBlankToReplace(appointRowSet, "APPT_SATE", null)).append("\n");
					sb.append("APPT_CNT:").append(checkBlankToReplace(appointRowSet, "APPT_CNT", null)).append("\n");
					sb.append("APPT_POSTAL:").append(checkBlankToReplace(appointRowSet, "APPT_POSTAL", null)).append("\n");
					sb.append("APPT_TZ:").append(checkBlankToReplace(appointRowSet, "APPT_TZ", null)).append("\n");
					sb.append("APPT_CONTACT_NM:").append(checkBlankToReplace(appointRowSet, "APPT_CONTACT_NM", null)).append("\n");
					sb.append("APPT_CONTACT_TE:").append(checkBlankToReplace(appointRowSet, "APPT_CONTACT_TE", null)).append("\n");
					sb.append("COMMENT:").append(checkBlankToReplace(appointRowSet, "APPT_COMMENT", null)).append("\n");
					sb.append("LOAD_REF:").append(checkBlankToReplace(appointRowSet, "LOAD_REF", null)).append("\n");
					sb.append("SPCL_INSTR:").append(checkBlankToReplace(appointRowSet, "SPCL_INSTR", null)).append("\n");
					sb.append("}LOCATION").append("\n");
					sb.append("APPT_PLN_DT:").append(checkBlankToReplace(appointRowSet, "APPT_PLN_DT", null)).append("\n");
					sb.append("APPT_ACTL_INDT:").append(checkBlankToReplace(appointRowSet, "APPT_ACTL_INDT", null)).append("\n");
					sb.append("APPT_ACTL_OUTDT:").append(checkBlankToReplace(appointRowSet, "APPT_ACTL_OUTDT", null)).append("\n");
					sb.append("APPT_TYPE:").append(checkBlankToReplace(appointRowSet, "APPT_TYPE", null)).append("\n");
					sb.append("}APPOINTMENT").append("\n");
				}
				sb.append("TOTAL_APPT:").append(totalAppt).append("\n");
				sb.append("}STOP_LIST").append("\n");
				addJoEdiHistory(masterRowSet, woVO);
			}
			sb.append("}EU").append("\n");
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		returnArray[1] = sb.toString();
		returnArray[2] = woVO.getEdiVndrSeq();
		return returnArray;
	}

	/**
	 * 
	 * @param rowSet
	 * @param woVO
	 * @throws DAOException
	 */
	private void addJoEdiHistory(DBRowSet rowSet, WorkOrderPreviewVO woVO) throws EventException {
		TrsEdiWrkOrdHisVO hisVo = new TrsEdiWrkOrdHisVO();
		try {
			String woIssStsCd = rowSet.getString("wo_iss_sts_cd");
			hisVo.setTrspSoOfcCtyCd(rowSet.getString("trsp_so_ofc_cty_cd"));
			hisVo.setTrspSoSeq(rowSet.getString("trsp_so_seq"));
			hisVo.setTrspWoOfcCtyCd(woVO.getEdiTrspWoOfcCtyCd());
			hisVo.setTrspWoSeq(woVO.getEdiTrspWoSeq());
			hisVo.setVndrSeq(rowSet.getString("vndr_seq"));
			hisVo.setMsgBndCd("O");
			if ("R".equals(woIssStsCd) || "C".equals(woIssStsCd)) {
				woIssStsCd = "U";
			} else if ("I".equals(woIssStsCd)) {
				woIssStsCd = "C";
			} else if ("N".equals(woIssStsCd)) {
				woIssStsCd = "X";
			}
			hisVo.setMsgTpCd(woIssStsCd);
			hisVo.setCreUsrId("SYSTEM");
			hisVo.setUpdUsrId("SYSTEM");
			ediDao.addJoEdiHistory(hisVo);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * 
	 * @param ediVndrSeq
	 * @return
	 */
	private String receiverIdForJoEdiEu(String ediVndrSeq) throws DAOException {
		return ediDao.searchJoEdiEuReceiver(ediVndrSeq);
	}

	/**
	 * 
	 * @param ds
	 * @param column
	 * @param defaultValue
	 * @return
	 * @throws Exception
	 */
	private String checkBlankToReplace(DBRowSet ds, String column, String defaultValue) throws Exception {
		String dbValue = "";
		try {
			dbValue = ds.getString(column.toLowerCase());
			if (!CheckUtilities.isInBlank(dbValue)) {
				dbValue = dbValue.replaceAll("\r", "").replaceAll("\n", "").trim();
			} else {
				if (!CheckUtilities.isInBlank(defaultValue)) {
					dbValue = defaultValue.trim();
				}
			}
		} catch (Exception e) {
			log.error("column : " + column);
		}
		return dbValue;
	}

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e
	 * @return DBRowSet
	 * @exception EventException
	 */
	public String searchWorkOrderNo(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		try {
			return dbDao.searchWorkOrderNo(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * workOrderCancelByVendorCM
	 * 
	 * @param param
	 * @param account
	 * @return int
	 * @exception EventException
	 */
	public int workOrderCancelByVendorCM(HashMap<String, Object> param, SignOnUserAccount account) throws EventException {
		try {
			DBRowSet ds = dbDao.searchTrsTrspWrkOrdPreTmpByVendorCM(param);
			String iSoNo = "";
			if (ds.next()) {
				param.put("wo_prv_grp_seq", ds.getString("wo_prv_grp_seq"));
				dbDao.updateTrsTrspWrkOrdPreTmpByVendorCM(param);
				WorkOrderPreviewVO wrkOrdPrvVO = new WorkOrderPreviewVO();
				wrkOrdPrvVO.setWoPrvGrpSeq(ds.getString("wo_prv_grp_seq"));
				wrkOrdPrvVO.setWoIssNo(ds.getString("wo_iss_no"));
				wrkOrdPrvVO.setTrspWoOfcCtyCd(ds.getString("trsp_wo_ofc_cty_cd"));
				wrkOrdPrvVO.setTrspWoSeq(ds.getString("trsp_wo_seq"));
				wrkOrdPrvVO.setSoCreOfcCd(account.getOfc_cd());
				iSoNo = ds.getString("trsp_so_ofc_cty_cd") + ds.getString("trsp_so_seq");
				dbDao.workOrderCancelByVendorCm(wrkOrdPrvVO, iSoNo);
			}
			return 0;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (SQLException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * 
	 * @param param
	 * @throws EventException
	 */
	public void manageTrsTrspWrkOrdByVendorCM(HashMap<String, Object> param) throws EventException {
		try {
			dbDao.manageTrsTrspWrkOrdByVendorCM(param);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchWorkOrderInquiryPreview(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		try {
			eventResponse.setRsVo(dbDao.searchWorkOrderInquiryPreview(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * checkSoChanged
	 * 
	 * @param e
	 * @param issuedFlag
	 * @return
	 * @throws EventException
	 */
	public boolean checkSoChanged(Event e, boolean issuedFlag) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		boolean isCheckStsCd = false;
		DBRowSet changRowSet = null;
		try {
			changRowSet = dbDao.checkSoChanged(event);
			if (changRowSet.next()) {
				if (issuedFlag) {
					if (changRowSet.getInt("delete_cnt") > 0 || changRowSet.getInt("cr_cnt") > 0) {
						isCheckStsCd = true;
					}
				} else {
					if (changRowSet.getInt("delete_cnt") > 0 || changRowSet.getInt("issue_cnt") > 0) {
						isCheckStsCd = true;
					}
				}
			}
			return isCheckStsCd;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
}