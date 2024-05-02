/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : SingleTransportationSOManageDBDAO.java
 *@FileTitle : CY & Door S/O Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.04.25
 *@LastModifier : 민정호
 *@LastVersion : 1.3
 * 2006.09.29 김상근
 * 1.0 최초 생성
 *----------------------------------------------------------
 * History
 * 2009.02.26 조풍연 1.1 [N200903060130] MEXICO RAIL S/O 대상에 조회도록 변경
 * 2010.10.08 최 선   1.2 [CHM-201006411] S/O DOOR NODE 팝업창의 RETURN VALUE 오류 수정
 * 2011.04.25 민정호 1.3 [CHM-201110290] [TRS] 중복 Door S/O 발행을 방지하기 위한 로직 추가 요청
 * 2011.07.13 민정호 1.70 [CHM-201112130] [TRS] Door S/O 중복 발행을 방지하기 위한 로직 일부 수정요청
=========================================================*/
package com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esd.trs.common.trscommon.integration.TrsCommonDBDAOsearchMdmCntrTpSzRSQL;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.basic.SingleTransportationSOManageBCImpl;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0002Event;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0930Event;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SoProcVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 김상근
 * @see SingleTransportationSOManageBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class SingleTransportationSOManageDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = -8425647060257402361L;

	/**
	 * Office code의 conti_cd check.<br>
	 * 각 대륙별(미주, 구주, 아주) 별로 여러지역의 Office를 동시에 조회하거나 미주화면에서 아주의 Control Office 자료를 조회 할 경우 오류를 발생 시킨다.
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchContiCodeCheck(EsdTrs0002Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			String ui_conti_cd = event.getUi_conti_cd();
			String so_office = event.getPrnt_ofc_cd();
			List<String> arr_so_office = new ArrayList();
			arr_so_office = this.seperationParameter(so_office, ",");
			String conti_cd = "";
			String err_msg = "";
			param.put("arr_so_office", arr_so_office);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			SingleTransportationSOManageDBDAOSearchContiCodeCheckRSQL template = new SingleTransportationSOManageDBDAOSearchContiCodeCheckRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);

			if (dbRowset.next()) {
				conti_cd = dbRowset.getString("conti_cd");
				if ((!conti_cd.equals(ui_conti_cd)) || (dbRowset.getRowCount() > 1)) {
					if (ui_conti_cd.equals("M")) {
						err_msg = "Please input America office code";
					} else if (ui_conti_cd.equals("E")) {
						err_msg = "Please input Europe office code";
					} else if (ui_conti_cd.equals("A")) {
						err_msg = "Please input Asia office code";
					}
				}
				if (err_msg.length() > 1)
					throw new DAOException((new ErrorHandler("TRS00099", new String[] { err_msg })).getMessage());
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * SingleTransportationSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Creation Search View(Insert)
	 * 
	 * @return
	 * @throws DAOException
	 */
	public String searchSingleTransportationSOCandidatesListK() throws DAOException {
		DBRowSet dbRowset = null;
		String lSeq = "";
		try {
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListGetSeqRSQL(), null, null);
			dbRowset.next();
			lSeq = dbRowset.getString("seq");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return lSeq;
	}

	/**
	 * S/O Candidate 조회대상을 temp 테이블에 입력하는 이벤트 처리 Creation Search View(Insert)
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public List<SingleTransportationVO> searchSingleTransportationSOCandidatesListP(EsdTrs0002Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		List<SingleTransportationVO> rtnList = new ArrayList<SingleTransportationVO>();
		try {
			String sUnplannedShuttleFlag = event.getSUnplannedShuttleFlag();
			// Control Office Split setting
			String so_office = event.getCtrl_so_office();
			List<String> arr_so_office = new ArrayList();
			arr_so_office = this.seperationParameter(so_office, ",");
			param.put("arr_so_office", arr_so_office);

			// Booking no Split setting
			String bkgno = event.getBkgno();
			List<String> arr_bkgno = new ArrayList();
			arr_bkgno = this.seperationParameter(bkgno, ",");
			param.put("arr_bkgno", arr_bkgno);

			// B/L no Split setting
			String billno = event.getBillno();
			List<String> arr_billno = new ArrayList();
			arr_billno = this.seperationParameter(billno, ",");
			param.put("arr_billno", arr_billno);

			// Container no Split setting
			String cntrno = event.getCntrno();
			List<String> arr_cntrno = new ArrayList();
			arr_cntrno = this.seperationParameter(cntrno, ",");
			param.put("arr_cntrno", arr_cntrno);

			// trunk VVD Splint setting
			String trunkvvd = event.getTrunkvvd();
			List<String> arr_trunkvvd = new ArrayList();
			arr_trunkvvd = this.seperationParameter(trunkvvd, ",");
			param.put("arr_trunkvvd", arr_trunkvvd);

			// feeder VVD Splint setting (Door S/O만 존재)
			String txt_feeder_vvd = event.getTxt_feeder_vvd();
			List<String> arr_feeder_vvd = new ArrayList();
			arr_feeder_vvd = this.seperationParameter(txt_feeder_vvd, ",");
			param.put("arr_feeder_vvd", arr_feeder_vvd);

			// Post code Splint setting (Door S/O만 존재 - TRO 자료 존재시)
			String zip_code = event.getZip_code();
			List<String> arr_zip_code = new ArrayList();
			arr_zip_code = this.seperationParameter(zip_code, ",");
			param.put("arr_zip_code", arr_zip_code);

			// multi from node setting 2015.04.13
			String fmnode = event.getSearchFmNode();
			List<String> arr_fmnode = new ArrayList();
			arr_fmnode = this.seperationParameter(fmnode, ",");
			param.put("arr_fmnode", arr_fmnode);

			// multi to node setting 2015.04.13
			String tonode = event.getSearchToNode();
			List<String> arr_tonode = new ArrayList();
			arr_tonode = this.seperationParameter(tonode, ",");
			param.put("arr_tonode", arr_tonode);

			// ECC Split setting
			String eccCd = event.getEccCd();
			List<String> arr_ecc_cd = new ArrayList();
			arr_ecc_cd = this.seperationParameter(eccCd, ",");
			param.put("arr_ecc_cd", arr_ecc_cd);
			
			// EQ TP/SZ Split setting
			String eqTpSzCd = event.getEqTpSzCd();
			List<String> eq_tpsz_cd = new ArrayList();
			eq_tpsz_cd = this.seperationParameter(eqTpSzCd, ",");
			param.put("eq_tpsz_cd", eq_tpsz_cd);
			
			param.put("dateCondition", event.getRad_dateSep().toString());
			param.put("frm_plandate", event.getFrm_plandate().toString());
			param.put("to_plandate", event.getTo_plandate().toString());
			param.put("contract_no", event.getContract_no().toString());
			param.put("contract_tp_cd", event.getContract_tp_cd().toString());
			param.put("bound", event.getBound().toString());
			param.put("transmode", event.getTransmode().toString());
			param.put("costmode", event.getCostmode().toString());
			param.put("frmnode", event.getSearchFmLoc().toString());
			param.put("frmnodeyard", event.getSearchFmYard().toString());
			param.put("vianode", event.getSearchViaLoc().toString());
			param.put("vianodeyard", event.getSearchViaYard());
			param.put("tonode", event.getSearchToLoc());
			param.put("tonodeyard", event.getSearchToYard());
			param.put("dorloc", event.getSearchDoorLoc());
			param.put("dorlocyard", event.getSearchDoorYard());
			param.put("sUnplannedShuttleFlag", event.getSUnplannedShuttleFlag());
			param.put("TroUnConfirmDoor", event.getSTroUnConfirmDoor());
			param.put("feeder_vvd_tp", event.getFeeder_vvd());

			param.put("cydoor_div", event.getCydoor_div()); // UI에서 선택한 CY/DOOR구분 (CY : CY, DOOR : DR)
			param.put("ui_conti_cd", event.getUi_conti_cd()); // UI에서 셋팅한 대륙구분코드 (구주 : E, 미주 : M, 아주 : A)
			// 2015.04.13
			param.put("portio", event.getPortIo());
			param.put("portcd", event.getPortCd());
			param.put("stop_off_flg", event.getStopOffFlg());
			param.put("ctrl_ofc_cd", ((SignOnUserAccount) event.getSiteSignOnUserAccount()).getOfc_cd());

			// S/O Candidate 를 temp 테이블에 저장한다.

			if (sUnplannedShuttleFlag.equals("US")) {
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUnplanCreateRSQL(), param, param);
			} else {
				if ("E".equals(event.getUi_conti_cd().toString())) { // 구주
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListCreateRSQL(), param, param);
				} else {
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUsAsiaCreateRSQL(), param, param);
				}
			}
			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SingleTransportationVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * S/O Candidate 조회대상을 temp 테이블에 입력하는 이벤트 처리 Creation Search View(Insert)
	 * 
	 * @param event
	 * @param vo
	 * @param lSeq
	 * @throws DAOException
	 */
	public void searchSingleTransportationSOCandidatesListC(EsdTrs0002Event event, List<SingleTransportationVO> vo, String lSeq) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			String sUnplannedShuttleFlag = event.getSUnplannedShuttleFlag();
			param.put("trsp_tmp_seq", lSeq);
			if (vo != null && vo.size() > 0) {
				if (sUnplannedShuttleFlag.equals("US")) {
					new SQLExecuter("DEFAULT").executeBatch(new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUnplanCreateCSQL(), vo, param, param);
				} else {
					new SQLExecuter("DEFAULT").executeBatch(new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListCreateCSQL(), vo, param, param);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Temp 테이블에 저정된 S/O Candidate 조회대상에 UPDATE하는 이벤트 처리<br>
	 * Creation Search View(Insert)
	 * 
	 * @param event
	 * @param lSeq
	 * @throws DAOException
	 */
	public void searchSingleTransportationSOCandidatesListU(EsdTrs0002Event event, String lSeq) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("cydoor_div", event.getCydoor_div().toString());
			param.put("ui_conti_cd", event.getUi_conti_cd().toString());
			param.put("trsp_tmp_seq", lSeq);
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUptUSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Creation Search View(Insert)
	 * 
	 * @param event
	 * @param lSeq
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSingleTransportationSOCandidatesList(EsdTrs0002Event event, String lSeq) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			String cydoor_div = event.getCydoor_div();
			String ui_conti_cd = event.getUi_conti_cd();
			param.put("cydoor_div", event.getCydoor_div().toString()); // UI에서 선택한 CY/DOOR구분 (CY : CY, DOOR : DR)
			param.put("ui_conti_cd", event.getUi_conti_cd().toString()); // UI에서 셋팅한 대륙구분코드 (구주 : E, 미주 : M, 아주 : A)
			param.put("trsp_tmp_seq", lSeq);
			param.put("TroUnConfirmDoor", event.getSTroUnConfirmDoor().toString());
			param.put("dor_svc_tp_cd", event.getDorSvcTpCd()); // 조회 조건 추가 Door Service Type Code
			param.put("tri_axl_req_flg", event.getTriAxlReqFlg()); // 조회 조건 추가 Tri-axle Request Flag
			param.put("cnmv_sts_cd", event.getCnmvStsCd()); // 조회 조건 추가 Latest Movement Status
			if (cydoor_div.equals("DR")) {
				if (ui_conti_cd.equals("E")) { // 구주
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListEurDrRSQL(), param, param);
				} else if (ui_conti_cd.equals("M")) { // 미주
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUsaDrRSQL(), param, param);
				} else if (ui_conti_cd.equals("A")) { // 아주
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListAsiaDrRSQL(), param, param);
				}
			} else {
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListRSQL(), param, param);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * S/O Candidate 조회대상을 temp 테이블에 입력하는 이벤트 처리 Creation Search View(Insert)
	 * 
	 * @param lSeq
	 * @throws DAOException
	 */
	public void searchSingleTransportationSOCandidatesListD(String lSeq) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("trsp_tmp_seq", lSeq);
			// temp 테이블에 저장된 S/O Candidate를 삭제한다.
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListTmpDSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Creation Search View(Insert)
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSingleTransportationSOList(EsdTrs0002Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("dateCondition", event.getRad_dateSep().toString());
			param.put("frm_plandate", event.getFrm_plandate().toString());
			param.put("to_plandate", event.getTo_plandate().toString());
			param.put("bound", event.getBound().toString());
			param.put("transmode", event.getTransmode().toString());
			param.put("costmode", event.getCostmode().toString());
			param.put("frmnode", event.getSearchFmLoc().toString() + event.getSearchFmYard().toString());
			param.put("vianode", event.getSearchViaLoc().toString() + event.getSearchViaYard().toString());
			param.put("tonode", event.getSearchToLoc().toString() + event.getSearchToYard().toString());
			param.put("dorloc", event.getSearchDoorLoc().toString() + event.getSearchDoorYard().toString());
			param.put("rad_wo_issued", event.getRad_wo_issued().toString());
			param.put("svc_provider", event.getCombo_svc_provider().toString());
			param.put("form_usr_ofc_cd", event.getForm_usr_ofc_cd().toString());

			String bkgno = event.getBkgno();
			List<String> arr_bkgno = new ArrayList();
			arr_bkgno = this.seperationParameter(bkgno, ",");
			param.put("arr_bkgno", arr_bkgno);

			String billno = event.getBillno();
			List<String> arr_billno = new ArrayList();
			arr_billno = this.seperationParameter(billno, ",");
			param.put("arr_billno", arr_billno);

			String cntrno = event.getCntrno();
			List<String> arr_cntrno = new ArrayList();
			arr_cntrno = this.seperationParameter(cntrno, ",");
			param.put("arr_cntrno", arr_cntrno);

			String trunkvvd = event.getTrunkvvd();
			List<String> arr_trunkvvd = new ArrayList();
			arr_trunkvvd = this.seperationParameter(trunkvvd, ",");
			param.put("arr_trunkvvd", arr_trunkvvd);

			String so_no = event.getSo_no();
			List<String> arr_so_no = new ArrayList();
			arr_so_no = this.seperationParameter(so_no, ",");
			param.put("arr_so_no", arr_so_no);

			String wo_no = event.getWo_no();
			List<String> arr_wo_no = new ArrayList();
			arr_wo_no = this.seperationParameter(wo_no, ",");
			param.put("arr_wo_no", arr_wo_no);

			String zip_code = event.getZip_code();
			List<String> arr_zip_code = new ArrayList();
			arr_zip_code = this.seperationParameter(zip_code, ",");
			param.put("arr_zip_code", arr_zip_code);

			// multi from node setting 2015.04.13
			String fmnode = event.getSearchFmNode();
			List<String> arr_fmnode = new ArrayList();
			arr_fmnode = this.seperationParameter(fmnode, ",");
			param.put("arr_fmnode", arr_fmnode);

			// multi to node setting 2015.04.13
			String tonode = event.getSearchToNode();
			List<String> arr_tonode = new ArrayList();
			arr_tonode = this.seperationParameter(tonode, ",");
			param.put("arr_tonode", arr_tonode);

			param.put("portio", event.getPortIo().toString());
			param.put("portcd", event.getPortCd().toString());
			param.put("cnmv_sts_cd", event.getCnmvStsCd()); // 조회 조건 추가 Latest Movement Status

			String cntrSltNo = event.getCntrSltNo();
			List<String> arr_cntrSltNo = new ArrayList();
			arr_cntrSltNo = this.seperationParameter(cntrSltNo, ",");
			param.put("arr_cntr_slt_no", arr_cntrSltNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(new SingleTransportationSOManageDBDAOSearchSingleTransportationSOListRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * SingleTransportationSOManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * @param event
	 * @param rowCnt
	 * @throws DAOException
	 */
	public void modifySINGLE_TRANSPORTATION_VO(EsdTrs0002Event event, int rowCnt) throws DAOException {
		try {
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			List<SingleTransportationVO> mSTVoList = new ArrayList<SingleTransportationVO>();
			Map<String, Object> param = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			DBRowSet dbRowset1 = null;
			int insCnt[] = null;
			String cmbSeq = "";
			String cbstatus = event.getCbstatus();
			String cost_act_grp_cd = null;
			param.put("cbstatus", cbstatus);
			param.put("form_usr_ofc_cd", event.getForm_usr_ofc_cd());
			param.put("form_cre_usr_id", event.getForm_cre_usr_id());
			
			Map<String, Object> checkParam = new HashMap<String, Object>();
			if (singleTransportationVOS[rowCnt] == null) {
				return;
			}
			checkParam.clear();
			checkParam.put("trsp_so_ofc_cty_cd", singleTransportationVOS[rowCnt].getTrspSoOfcCtyCd());
			checkParam.put("trsp_so_seq", singleTransportationVOS[rowCnt].getTrspSoSeq());
			checkParam.put("trsp_so_sts_cd", singleTransportationVOS[rowCnt].getTrspSoStsCd());
			dbRowset1 = sqlExe.executeQuery(new SingleTransportationSOManageDBDAOChangeChkSoStsCdRSQL(), checkParam, checkParam);
			if(dbRowset1 != null && dbRowset1.next() && dbRowset1.getInt(1) > 0) {
				throw new DAOException(new ErrorHandler("TRS00061").getMessage());
			}
			mSTVoList.add(singleTransportationVOS[rowCnt]);
			param.put("SoOfcCtyCd", singleTransportationVOS[rowCnt].getTrspSoOfcCtyCd());
			param.put("SoSeq", singleTransportationVOS[rowCnt].getTrspSoSeq());
			dbRowset1 = sqlExe.executeQuery(new SingleTransportationSOManageDBDAOCyDoorSeqRSQL(), param, param);
			if (!dbRowset1.next()) {
				throw new DAOException(new ErrorHandler("TRS00015").getMessage() + singleTransportationVOS[rowCnt].getTrspSoOfcCtyCd() + singleTransportationVOS[rowCnt].getTrspSoSeq());
			}

			/* Combined Column Setting */
			if (cbstatus.equals("CS")) {
				singleTransportationVOS[rowCnt].setTrspSoCmbTpCd(singleTransportationVOS[rowCnt].getTrspSoCmbTpCd());
			} else {
				singleTransportationVOS[rowCnt].setTrspSoCmbTpCd(cbstatus);
			}
			if (cbstatus.equals("CF") || cbstatus.equals("CS")) { // COMBINED에 대한 처리구문.
				String cmbSrtNo = String.valueOf(singleTransportationVOS[rowCnt].getTrspSoCmbSeq());
				singleTransportationVOS[rowCnt].setTrspSoCmbSrtNo(cmbSrtNo);
				if (cmbSrtNo.substring(2).equals("1") && cmbSrtNo.length() > 2) {
					dbRowset1 = sqlExe.executeQuery(new SingleTransportationSOManageDBDAOCyDoorCombineSeqRSQL(), param, param); // Combind_SEQ
					if (dbRowset1.next()) {
						cmbSeq = dbRowset1.getString("CMB_SEQ");
					}
				}
				singleTransportationVOS[rowCnt].setTrspSoCmbSeq(cmbSeq);
				if (cbstatus.equals("CF")) {
					singleTransportationVOS[rowCnt].setCmbSoRltStsFlg("F");
				} else if (cbstatus.equals("CS")) {
					singleTransportationVOS[rowCnt].setCmbSoRltStsFlg("S");
				}
			} else {
				singleTransportationVOS[rowCnt].setTrspSoCmbSrtNo("");
				singleTransportationVOS[rowCnt].setTrspSoCmbSeq("");
				singleTransportationVOS[rowCnt].setCmbSoRltStsFlg("");
			}

			cost_act_grp_cd = singleTransportationVOS[rowCnt].getCostActGrpCd().substring(0, 2) + singleTransportationVOS[rowCnt].getTrspCrrModCd();
			singleTransportationVOS[rowCnt].setCostActGrpCd(cost_act_grp_cd);

			if (String.valueOf(singleTransportationVOS[rowCnt].getTrspCostDtlModCd()).equals("DOOR")) {
				singleTransportationVOS[rowCnt].setTrspCostDtlModCd("DR");
			} else {
				if (singleTransportationVOS[rowCnt].getFmNodCd().equals(singleTransportationVOS[rowCnt].getToNodCd())) {
					if (singleTransportationVOS[rowCnt].getTrspBndCd().equals("T")) {
						singleTransportationVOS[rowCnt].setTrspCostDtlModCd("TS");
					} else {
						singleTransportationVOS[rowCnt].setTrspCostDtlModCd("LS");
					}
				} else {
					singleTransportationVOS[rowCnt].setTrspCostDtlModCd("CY");
				}
				singleTransportationVOS[rowCnt].setDorDeAddr("");
			}

			if (String.valueOf(singleTransportationVOS[rowCnt].getDorSvcTpCd()).equals("ALL")) {
				singleTransportationVOS[rowCnt].setDorSvcTpCd("");
			}
			insCnt = sqlExe.executeBatch((ISQLTemplate) new SingleTransportationSOManageDBDAOModifySingleTransportationVoTrsUSQL(), mSTVoList, param, param);
			for (int i = 0; i < insCnt.length; i++) {
				if (insCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + i + " SQL");
			}
			return;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * Separate를 실행 Combined 해제
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public ArrayList modify01SINGLE_TRANSPORTATION_VO(EsdTrs0002Event event) throws DAOException {
		try {
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			ArrayList arrSeq = new ArrayList();
			Map<String, Object> param = new HashMap<String, Object>();
			List<SingleTransportationVO> mSTVoList = new ArrayList<SingleTransportationVO>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			DBRowSet dbRowset1 = null;
			int cmbCnt = 0;
			String cre_ofc_cd = "";
			String trsp_so_cmb_seq = "";
			String pre_trsp_so_cmb_seq = "";

			String form_usr_ofc_cd = event.getForm_usr_ofc_cd();
			String form_cre_usr_id = event.getForm_cre_usr_id();
			param.put("form_usr_ofc_cd", form_usr_ofc_cd);
			param.put("form_cre_usr_id", form_cre_usr_id);

			int vos_length = singleTransportationVOS.length;
			SingleTransportationSOManageDBDAOModify01SingleTransportationVoChkRSQL template1 = new SingleTransportationSOManageDBDAOModify01SingleTransportationVoChkRSQL();
			for (int i = 0; i < singleTransportationVOS.length; i++) {
				mSTVoList.add(singleTransportationVOS[i]);
				arrSeq.add(i, String.valueOf(singleTransportationVOS[i].getTrspSoSeq())); // TRSP_SO_SEQ : 객체를 넘긴다.
				cre_ofc_cd = singleTransportationVOS[i].getCreOfcCd();
				trsp_so_cmb_seq = singleTransportationVOS[i].getTrspSoCmbSeq();
				param.put("cre_ofc_cd", cre_ofc_cd);
				param.put("trsp_so_cmb_seq", trsp_so_cmb_seq);
				dbRowset1 = sqlExe.executeQuery(template1, param, param);
				dbRowset1.next();
				if (i > 0 && !pre_trsp_so_cmb_seq.equals(trsp_so_cmb_seq)) {
					throw new DAOException((new ErrorHandler("TRS00099", new String[] { "CB Seq same S/O can be separated only." })).getMessage());
				}

				pre_trsp_so_cmb_seq = trsp_so_cmb_seq;
				cmbCnt = dbRowset1.getInt("CNT");
			}
			if (cmbCnt > 0 && vos_length != cmbCnt) {
				throw new DAOException((new ErrorHandler("TRS00099", new String[] { "Combined S/O after all the views can be separated." })).getMessage());
			}
			if (mSTVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SingleTransportationSOManageDBDAOModify01SingleTransportationVoUSQL(), mSTVoList, param, param);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to SO Update No" + i + " SQL");
				}
			}

			return arrSeq;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage의 수정된 데이타 모델을 DB에 반영한다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public ArrayList modify02SINGLE_TRANSPORTATION_VO(EsdTrs0002Event event) throws DAOException {
		try {
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			ArrayList arrSeq = new ArrayList();
			Map<String, Object> param = new HashMap<String, Object>();
			List<SingleTransportationVO> mSTVoList = new ArrayList<SingleTransportationVO>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			String form_usr_ofc_cd = event.getForm_usr_ofc_cd(); // Session office
			String form_cre_usr_id = event.getForm_cre_usr_id(); // Session user
			param.put("form_usr_ofc_cd", form_usr_ofc_cd);
			param.put("form_cre_usr_id", form_cre_usr_id);

			for (int i = 0; i < singleTransportationVOS.length; i++) {
				mSTVoList.add(singleTransportationVOS[i]);
				arrSeq.add(i, String.valueOf(singleTransportationVOS[i].getTrspSoSeq())); // TRSP_SO_SEQ : 객체를 넘긴다.
			}

			if (mSTVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SingleTransportationSOManageDBDAOModify02SingleTransportationVoUSQL(), mSTVoList, param, param);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to SO Update No" + i + " SQL");
				}
			}

			return arrSeq;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * CY&DOOR Correction S/O 삭제 이벤트 처리<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public ArrayList removeSINGLE_TRANSPORTATION_VO(EsdTrs0002Event event) throws DAOException {
		DBRowSet dbRowset1 = null;
		SQLExecuter sqlExe = new SQLExecuter("");
		ArrayList arrSeq = new ArrayList();
		Map<String, Object> param = new HashMap<String, Object>();
		List<SingleTransportationVO> mSTVoList = new ArrayList<SingleTransportationVO>();
		List<SingleTransportationVO> mSceList = new ArrayList<SingleTransportationVO>();
		List<SingleTransportationVO> mEqrList = new ArrayList<SingleTransportationVO>();
		try {
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			int insCnt[] = null;
			param.put("form_usr_ofc_cd", event.getForm_usr_ofc_cd());
			param.put("form_cre_usr_id", event.getForm_cre_usr_id());

			for (int i = 0; i < singleTransportationVOS.length; i++) {
				Map<String, Object> checkParam = new HashMap<String, Object>();
				checkParam.put("trsp_so_ofc_cty_cd", singleTransportationVOS[i].getTrspSoOfcCtyCd());
				checkParam.put("trsp_so_seq", singleTransportationVOS[i].getTrspSoSeq());
				checkParam.put("trsp_so_sts_cd", singleTransportationVOS[i].getTrspSoStsCd());
				dbRowset1 = sqlExe.executeQuery(new SingleTransportationSOManageDBDAOChangeChkSoStsCdRSQL(), checkParam, checkParam);
				dbRowset1.next();
				if (dbRowset1.getInt(1) > 0) {
					throw new DAOException(new ErrorHandler("TRS00061").getMessage());
				}

				// TRS Inter Remart 삭제
				checkParam.put("upd_usr_id", event.getForm_cre_usr_id());
				sqlExe.executeUpdate(new SingleTransportationSOManageDBDAORemoveTrsInterRmkUSQL(), checkParam, checkParam);

				mSTVoList.add(singleTransportationVOS[i]);
				arrSeq.add(i, String.valueOf(singleTransportationVOS[i].getTrspSoSeq()));
				// COP,EQR상태코드를 UPDATE할 대상을 VO에 담는다.
				if (singleTransportationVOS[i].getCgoTpCd().equals("F")) {
//					if (!singleTransportationVOS[i].getRplnUmchFlg().equals("Y")) {
						mSceList.add(singleTransportationVOS[i]);
//					}
				} else {
					mEqrList.add(singleTransportationVOS[i]);
				}
			}

			if (mSTVoList.size() > 0) {
				/**
				 * UPDATE - TRS_TRSP_SVC_ORD
				 */
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SingleTransportationSOManageDBDAORemoveSingleTransportationVoTrsStsUSQL(), mSTVoList, param, param);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to TRS SO Status Update No" + i + " SQL");
				}
				/**
				 * Delete - TRS_TRSP_SVC_ORD_BKG_CNG
				 */
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SingleTransportationSOManageDBDAORemoveBookingChageBySoDeleteDSQL(), mSTVoList, param, param);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to TRS SO Status Update No" + i + " SQL");
				}
				/**
				 * Delete - TRS_TRSP_SVC_ORD_CNG
				 */
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SingleTransportationSOManageDBDAORemoveSoChangeBySoDeleteDSQL(), mSTVoList, param, param);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to TRS SO Status Update No" + i + " SQL");
				}

				/**
				 * INSERT - TRS_TRSP_EDI_RAIL_GLO_TMP
				 */
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SingleTransportationSOManageDBDAORemoveSingleTransportationVoEdiTmpCSQL(), mSTVoList, param, param);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to SO# Temp Insert No" + i + " SQL");
				}
			}

			if (mSceList.size() > 0) {
				sqlExe.executeBatch((ISQLTemplate) new SingleTransportationSOManageDBDAORemoveSingleTransportationVoBeforeHisCSQL(), mSTVoList, param, param); // S/O삭제 Before history
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SingleTransportationSOManageDBDAORemoveSingleTransportationVoSceUSQL(), mSTVoList, param, param);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to SCE SO Status Update No" + i + " SQL");
				}
				sqlExe.executeBatch((ISQLTemplate) new SingleTransportationSOManageDBDAORemoveSingleTransportationVoAfterHisCSQL(), mSTVoList, param, param); // S/O삭제 After history
			}

			if (mEqrList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SingleTransportationSOManageDBDAORemoveSingleTransportationVoEqrUSQL(), mSTVoList, param, param);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to EQR SO Status Update No" + i + " SQL");
				}
			}

			return arrSeq;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * S/O Candidate 조회대상을 temp 테이블에 입력하는 이벤트 처리 Creation Search View(Insert)
	 * 
	 * @param srcMap
	 * @throws DAOException
	 */
	public void verifySingleTransportationSOIRG(Map<String, String> srcMap) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		String cop_no = srcMap.get("cop_no");
		String bnd_cd = srcMap.get("trsp_bnd_cd");
		String cost_act_grp_seq = srcMap.get("cost_act_grp_seq");
		String trsp_crr_mod_cd = srcMap.get("trsp_crr_mod_cd");
		String frm_nod = srcMap.get("fm_nod_cd") + srcMap.get("fm_nod_yard");
		String via_nod = srcMap.get("via_nod_cd") + srcMap.get("via_nod_yard");
		String door_nod = srcMap.get("dor_nod_cd") + srcMap.get("dor_nod_yard");
		String to_nod = srcMap.get("to_nod_cd") + srcMap.get("to_nod_yard");
		String bkg_no = srcMap.get("bkg_no");
		String err_msg = "";
		param.put("v_cop_no", cop_no);
		param.put("v_bnd_cd", bnd_cd);
		param.put("v_cost_act_grp_seq", cost_act_grp_seq);
		param.put("v_trsp_crr_mod_cd", trsp_crr_mod_cd);
		param.put("v_fm_nod_cd", frm_nod);
		param.put("v_via_nod_cd", via_nod);
		param.put("v_dor_nod_cd", door_nod);
		param.put("v_to_nod_cd", to_nod);

		err_msg = "The route does not exist in IRG list.\nContact RHQ relevant to your office for creation of the IRG!!\n";
		err_msg = err_msg + "(BKG NO : " + bkg_no + ", COP NO : " + cop_no + ")";

		try {
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			SingleTransportationSOManageDBDAOVerifySingleTransportationSOIRGRSQL template = new SingleTransportationSOManageDBDAOVerifySingleTransportationSOIRGRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);
			if (dbRowset.next()) {
				if (dbRowset.getRowCount() > 0) {
					err_msg = "";
				}
			}

			if (err_msg.length() > 0)
				throw new DAOException((new ErrorHandler("TRS00099", new String[] { err_msg })).getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param event
	 * @param sRow
	 * @throws DAOException
	 */
	public void verifySingleTransportationDupChk(EsdTrs0002Event event, int sRow) throws DAOException {
		try {
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			// List<SingleTransportationVO> mSTVoList = new ArrayList<SingleTransportationVO>();
			Map<String, Object> param = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			DBRowSet dbRowset3 = null;
			String sUnplannedShuttleFlag = event.getSUnplannedShuttleFlag();
			String cop_no = "";
			String cost_act_grp_seq = "";
			String fm_nod_cd = "";
			String to_nod_cd = "";
			String trsp_cost_dtl_mode_cd = "";
			String trsp_bnd_cd = "";
			String tro_seq = "";

			cop_no = singleTransportationVOS[sRow].getCopNo();
			cost_act_grp_seq = singleTransportationVOS[sRow].getCostActGrpSeq();
			fm_nod_cd = singleTransportationVOS[sRow].getFmNodCd() + singleTransportationVOS[sRow].getFmNodYard();
			to_nod_cd = singleTransportationVOS[sRow].getToNodCd() + singleTransportationVOS[sRow].getToNodYard();
			trsp_cost_dtl_mode_cd = singleTransportationVOS[sRow].getTrspCostDtlModCd();
			trsp_bnd_cd = singleTransportationVOS[sRow].getTrspBndCd();
			tro_seq = singleTransportationVOS[sRow].getTroSeq();

			param.put("cop_no", cop_no);
			param.put("cost_act_grp_seq", cost_act_grp_seq);
			param.put("fm_nod_cd", fm_nod_cd);
			param.put("to_nod_cd", to_nod_cd);
			param.put("trsp_cost_dtl_mode_cd", trsp_cost_dtl_mode_cd);
			param.put("trsp_bnd_cd", trsp_bnd_cd);
			param.put("ui_conti_cd", event.getUi_conti_cd().toString()); // UI에서 셋팅한 대륙구분코드 (구주 : E, 미주 : M, 아주 : A)
			param.put("tro_seq", tro_seq);

			if (sUnplannedShuttleFlag.equals("US")) { // UnPlaned 대상일 경우
				String err_msg = "Unplanned S/O of the route for this CNTR is already issued!! \nGo to 'S/O Correction' for modification or delete.";
				SingleTransportationSOManageDBDAOMultiSingleTrsSoUnplanedRSQL template = new SingleTransportationSOManageDBDAOMultiSingleTrsSoUnplanedRSQL();
				dbRowset3 = sqlExe.executeQuery(template, param, param);
				StringBuffer sb_dup_chk = new StringBuffer();
				sb_dup_chk.append("(   ");
				while (dbRowset3.next()) {
					sb_dup_chk.append(dbRowset3.getString("CHK_UNIT"));
				}
				sb_dup_chk.append(")");
				if (sb_dup_chk.length() > 10) {
					throw new DAOException((new ErrorHandler("TRS00099", new String[] { err_msg })).getMessage() + "\n" + sb_dup_chk);
				}
			} else { // Planed 대상일 경우
				SingleTransportationSOManageDBDAOMultiSingleTrsSoRSQL template = new SingleTransportationSOManageDBDAOMultiSingleTrsSoRSQL();
				dbRowset3 = sqlExe.executeQuery(template, param, param);
				StringBuffer sb_dup_chk = new StringBuffer();
				sb_dup_chk.append("(   ");
				while (dbRowset3.next()) {
					sb_dup_chk.append(dbRowset3.getString("CHK_UNIT"));
				}
				sb_dup_chk.append(")");
				if (sb_dup_chk.length() > 10) {
					throw new DAOException(new ErrorHandler("TRS00100").getMessage() + sb_dup_chk.toString());
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param event
	 * @param sRow
	 * @return
	 * @throws DAOException
	 */
	public String multiSINGLE_TRANSPORTATION_VO(EsdTrs0002Event event, int sRow) throws DAOException {
		try {
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			List<SingleTransportationVO> mSTVoList = new ArrayList<SingleTransportationVO>();
			Map<String, Object> param = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			DBRowSet dbRowset1 = null;
			DBRowSet dbRowset4 = null;

			String cbstatus = event.getCbstatus();
			String form_usr_ofc_cd = event.getForm_usr_ofc_cd(); // Session office
			String form_cre_usr_id = event.getForm_cre_usr_id(); // Session user
			String cmbSeq = "";
			String sdy_sep = "";
			String cost_act_grp_cd = null;
			String sUnplannedShuttleFlag = event.getSUnplannedShuttleFlag();
			String trspSeq = null;
			String sCostActGrpSeq = "";

			dbRowset1 = sqlExe.executeQuery(new SingleTransportationSOManageDBDAOCyDoorSeqRSQL(), param, param);
			if (dbRowset1.next()) {
				trspSeq = dbRowset1.getString("TRSP_SEQ");
			}

			if (sUnplannedShuttleFlag.equals("US")) { // UnPlaned 대상일 경우
				// COST_ACT_GRP_SEQ이 600일 경우 COST_ACT_GRP_SEQ를 새로 생성해야 한다.
				// 새로 생성하는 기준은 SEQ 600바로 다음번호의 SO의 발행내역이 있는지 조회하여
				// (600 + 바로 다음번 SEQ) / 2 로 새로운 번호를 구한다음 반올림한다.
				sCostActGrpSeq = singleTransportationVOS[sRow].getCostActGrpSeq();
				if (Integer.parseInt(sCostActGrpSeq) == 600) {
					String sNewCostActSeq = "";
					param.put("cop_no", singleTransportationVOS[sRow].getCopNo());
					dbRowset4 = sqlExe.executeQuery(new SingleTransportationSOManageDBDAOMultiSingleTrsSoUnplanedNewSeqRSQL(), param, param);
					if (dbRowset4.next())
						sNewCostActSeq = dbRowset4.getString("NEW_COST_ACT_GRP_SEQ");
					singleTransportationVOS[sRow].setCostActGrpSeq(sNewCostActSeq);
				}
				singleTransportationVOS[sRow].setUplnSoFlg("Y");
			}

			// '':SINGLE, CF:COMBINED ONE, FF/FM:COMBINED TWO
			if (cbstatus.equals("CS")) {
				singleTransportationVOS[sRow].setTrspSoCmbTpCd(singleTransportationVOS[sRow].getTrspSoCmbTpCd());
			} else {
				singleTransportationVOS[sRow].setTrspSoCmbTpCd(cbstatus);
			}
			// JSP 화면에서는 trsp_so_cmb_seq를 trsp_so_cmb_srt_no로 사용하고 있다.
			if (cbstatus.equals("CF") || cbstatus.equals("CS")) { // COMBINED에 대한 처리구문.
				String cmbSrtNo = String.valueOf(singleTransportationVOS[sRow].getTrspSoCmbSeq());
				singleTransportationVOS[sRow].setTrspSoCmbSrtNo(cmbSrtNo);
				if (cmbSrtNo.substring(2).equals("1") && cmbSrtNo.length() > 2) {
					dbRowset1 = sqlExe.executeQuery(new SingleTransportationSOManageDBDAOCyDoorCombineSeqRSQL(), param, param); // Combind_SEQ
					if (dbRowset1.next()) {
						cmbSeq = dbRowset1.getString("CMB_SEQ");
					}
				} else {
					cmbSeq = singleTransportationVOS[sRow - 1].getTrspSoCmbSeq();
				}
				singleTransportationVOS[sRow].setTrspSoCmbSeq(cmbSeq);
				if (cbstatus.equals("CF")) {
					singleTransportationVOS[sRow].setCmbSoRltStsFlg("F");
				} else if (cbstatus.equals("CS")) {
					singleTransportationVOS[sRow].setCmbSoRltStsFlg("S");
				}
			} else {
				singleTransportationVOS[sRow].setTrspSoCmbSrtNo("");
				singleTransportationVOS[sRow].setTrspSoCmbSeq("");
				singleTransportationVOS[sRow].setCmbSoRltStsFlg("");
			}

			// Trans Mode를 변경할 경우 cost_act_grp_cd 도 새로 생성되어야 하기 때문에 새로 조합한다.
			// cost_act_grp_cd = singleTransportationVOS[i].getCostActGrpCd();
			if (String.valueOf(singleTransportationVOS[sRow].getTrspCostDtlModCd()).equals("DOOR")) {
				sdy_sep = "D";
			} else {
				sdy_sep = "Y";
			}
			cost_act_grp_cd = CheckUtilities.isNullOrNullStringReplacement(singleTransportationVOS[sRow].getTrspBndCd(), "T") + sdy_sep + singleTransportationVOS[sRow].getTrspCrrModCd();
			singleTransportationVOS[sRow].setCostActGrpCd(cost_act_grp_cd);

			if (String.valueOf(singleTransportationVOS[sRow].getTrspCostDtlModCd()).equals("DOOR")) {
				singleTransportationVOS[sRow].setTrspCostDtlModCd("DR");
				// dor_de_addr은 변경없이 입력
			} else {
				if (singleTransportationVOS[sRow].getFmNodCd().equals(singleTransportationVOS[sRow].getToNodCd())) {
					if (singleTransportationVOS[sRow].getTrspBndCd().equals("T")) {
						singleTransportationVOS[sRow].setTrspCostDtlModCd("TS");
					} else {
						singleTransportationVOS[sRow].setTrspCostDtlModCd("LS");
					}
				} else {
					singleTransportationVOS[sRow].setTrspCostDtlModCd("CY");
				}
				singleTransportationVOS[sRow].setDorDeAddr("");
			}

			if (String.valueOf(singleTransportationVOS[sRow].getDorSvcTpCd()).equals("ALL")) {
				singleTransportationVOS[sRow].setDorSvcTpCd("");
			} else {
				// All이 아닐 경우 변경없이 입력
			}

			String sFeederVVD = "";
			if (singleTransportationVOS[sRow].getTrspBndCd().equals("I")) {
				sFeederVVD = singleTransportationVOS[sRow].getIbVvdCd();
			} else {
				sFeederVVD = singleTransportationVOS[sRow].getObVvdCd();
			}
			if (sFeederVVD.length() > 8) {
				singleTransportationVOS[sRow].setFdrVslCd(sFeederVVD.substring(0, 4));
				singleTransportationVOS[sRow].setFdrSkdVoyNo(sFeederVVD.substring(4, 8));
				singleTransportationVOS[sRow].setFdrSkdDirCd(sFeederVVD.substring(8));
			}

			singleTransportationVOS[sRow].setTrspSoSeq(trspSeq);
			singleTransportationVOS[sRow].setCreOfcCd(form_usr_ofc_cd);
			singleTransportationVOS[sRow].setCreUsrId(form_cre_usr_id);
			singleTransportationVOS[sRow].setUpdUsrId(form_cre_usr_id);
			singleTransportationVOS[sRow].setCbstatus(cbstatus);

			mSTVoList.add(singleTransportationVOS[sRow]);

			insCnt = sqlExe.executeBatch((ISQLTemplate) new SingleTransportationSOManageDBDAOMultiSingleTrsCSQL(), mSTVoList, param, null);
			for (int i = 0; i < insCnt.length; i++) {
				if (insCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}
			param.clear();
			param.put("cre_ofc_cd", singleTransportationVOS[sRow].getCreOfcCd().substring(0, 3));
			param.put("trsp_so_seq", singleTransportationVOS[sRow].getTrspSoSeq());
			sqlExe.executeSP(new SingleTransportationSOManageDBDAOMultiSingleTrsSoChgMgmtCSQL(), param, param);
			return trspSeq;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * Seperate를 실행 Combined 해제
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void modifyOfficeSINGLE_TRANSPORTATION_VO(EsdTrs0930Event event) throws DAOException {
		try {
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			List<SingleTransportationVO> mSTVoList = new ArrayList<SingleTransportationVO>();
			Map<String, Object> param = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			String login_usr_id = event.getSignOnUserAccount().getUsr_id();
			String cre_ofc_cd = event.getSignOnUserAccount().getOfc_cd();
			param.put("new_trns_rqst_ofc_cd", event.getNew_trns_rqst_ofc_cd());
			param.put("new_trns_rqst_rsn", event.getNew_trns_rqst_rsn());

			for (int i = 0; i < singleTransportationVOS.length; i++) {
				singleTransportationVOS[i].setUpdUsrId(login_usr_id);
				singleTransportationVOS[i].setCreOfcCd(cre_ofc_cd);
				mSTVoList.add(singleTransportationVOS[i]);
			}

			insCnt = sqlExe.executeBatch((ISQLTemplate) new SingleTransportationSOManageDBDAOModifyOfficeSingleTransportationVoSceUSQL(), mSTVoList, param, param);
			for (int i = 0; i < insCnt.length; i++) {
				if (insCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + i + " SQL");
			}

			insCnt = sqlExe.executeBatch((ISQLTemplate) new SingleTransportationSOManageDBDAOModifyOfficeSingleTransportationVoPrdUSQL(), mSTVoList, param, param);
			for (int i = 0; i < insCnt.length; i++) {
				if (insCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + i + " SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * Seperate를 실행 Combined 해제
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void modifyOfficeMT_TRANSPORTATION_VO(EsdTrs0930Event event) throws DAOException {
		try {

			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			List<SingleTransportationVO> mSTVoList = new ArrayList<SingleTransportationVO>();
			Map<String, Object> param = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			String login_usr_id = event.getSignOnUserAccount().getUsr_id();
			String cre_ofc_cd = event.getSignOnUserAccount().getOfc_cd();
			param.put("new_trns_rqst_ofc_cd", event.getNew_trns_rqst_ofc_cd());
			param.put("new_trns_rqst_rsn", event.getNew_trns_rqst_rsn());
			for (int i = 0; i < singleTransportationVOS.length; i++) {
				singleTransportationVOS[i].setUpdUsrId(login_usr_id);
				singleTransportationVOS[i].setCreOfcCd(cre_ofc_cd);
				mSTVoList.add(singleTransportationVOS[i]);
			}

			insCnt = sqlExe.executeBatch((ISQLTemplate) new SingleTransportationSOManageDBDAOModifyOfficeMTTransportationVoUSQL(), mSTVoList, param, param);
			for (int i = 0; i < insCnt.length; i++) {
				if (insCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + i + " SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage의 조회 된 데이타 모델을 DB에 반영한다.<br>
	 * Seperate를 실행 Combined 해제
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search10TransportationSOManage(EsdTrs0930Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("new_trns_rqst_ofc_cd", event.getNew_trns_rqst_ofc_cd());
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(new SingleTransportationSOManageDBDAOSearch10TransportationSOManageRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * SingleTransportationSOManage의 조회 된 데이타 모델을 DB에 반영한다.<br>
	 * Office의 Sub Office 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSubOfficeSOManageList(EsdTrs0002Event event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			// String ui_conti_cd = event.getUi_conti_cd();
			String so_office = event.getCtrl_so_office();
			List<String> arr_so_office = new ArrayList();
			arr_so_office = this.seperationParameter(so_office, ",");
			// String conti_cd = "";
			// String err_msg = "";
			param.put("arr_so_office", arr_so_office);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			SingleTransportationSOManageDBDAOSearchSubOfficeSOManageListRSQL template = new SingleTransportationSOManageDBDAOSearchSubOfficeSOManageListRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Actual Customer Info Change cause from Door Location/Zone Modification <br>
	 * Seperate를 실행 Combined 해제
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public GeneralEventResponse searchActualCustomerInfoSet(EsdTrs0002Event event) throws DAOException {
		// String ui_conti_cd = event.getUi_conti_cd();

		String sFmLocContiCd = event.getSFmLocContiCd();
		String sBoundCd = event.getSBoundCd();
		String sCneeCustCntCd = event.getSCneeCustCntCd();
		String sCneeCustSeq = event.getSCneeCustSeq();
		String sShprCustCntCd = event.getSShprCustCntCd();
		String sShprCustSeq = event.getSShprCustSeq();
		String sDoorNodCd = event.getSDoorNodCd();

		Map<String, Object> param = new HashMap<String, Object>();
		// DBRowSet dRs = null;
		Map outProc = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SoProcVO custVo = new SoProcVO();

		try {

			if ((!"".equals(sFmLocContiCd) && sFmLocContiCd != null) && (!"".equals(sBoundCd) && sBoundCd != null) && (("I".equals(sBoundCd) && !"".equals(sCneeCustCntCd) && sCneeCustCntCd != null) || ("O".equals(sBoundCd) && !"".equals(sShprCustCntCd) && sShprCustCntCd != null))
					&& (!"".equals(sDoorNodCd) && sDoorNodCd != null)) {
				sCneeCustSeq = "".equals(sCneeCustSeq) || sCneeCustSeq == null ? "0" : sCneeCustSeq;
				sShprCustSeq = "".equals(sShprCustSeq) || sShprCustSeq == null ? "0" : sShprCustSeq;
				param.put("pi_conti_cd", sFmLocContiCd);
				param.put("pi_bound_cd", sBoundCd);
				param.put("pi_cnee_cnt_cd", sCneeCustCntCd);
				param.put("pi_cnee_seq", sCneeCustSeq);
				param.put("pi_shpr_cnt_cd", sShprCustCntCd);
				param.put("pi_shpr_seq", sShprCustSeq);
				param.put("pi_door_nod_cd", sDoorNodCd);

				outProc = new SQLExecuter("DEFAULT").executeSP((ISQLTemplate) new SingleTransportationSOManageDBDAOActualCustomerInfoProcRSQL(), param, param);
				custVo.setRtnValue((String) outProc.get("po_rtn_value"));
				custVo.setActCustCntCd((String) outProc.get("po_act_cust_cnt_cd"));
				custVo.setActCustSeq((String) outProc.get("po_act_cust_seq"));
				custVo.setActCustAddrSeq((String) outProc.get("po_act_cust_addr_seq"));
				custVo.setActCustFctryPstCd((String) outProc.get("po_act_cust_fctry_pst_cd"));
				custVo.setActCustFctryNm((String) outProc.get("po_act_cust_fctry_nm"));
				custVo.setActCustFctryAddr((String) outProc.get("po_act_cust_fctry_addr"));
				custVo.setActCustFctryPhnNo((String) outProc.get("po_act_cust_fctry_phn_no"));
				custVo.setActCustFctryFaxNo((String) outProc.get("po_act_cust_fctry_fax_no"));
				custVo.setActCustFctryPicNo((String) outProc.get("po_act_cust_fctry_pic_no"));
				custVo.setActCustEml((String) outProc.get("po_act_cust_eml"));
				custVo.setActCustRmk((String) outProc.get("po_act_cust_rmk"));
				eventResponse.setRsVo(custVo);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return eventResponse;
	}

	/**
	 * SO Candidate 삭제 이벤트 처리<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public List<SingleTransportationVO> removeSOCandidate(EsdTrs0002Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		List<SingleTransportationVO> sub_models = new ArrayList<SingleTransportationVO>();
		try {
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt[] = null;

			String form_cre_usr_id = event.getForm_cre_usr_id();
			for (int k = 0; k < singleTransportationVOS.length; k++) {
				SingleTransportationVO model = (SingleTransportationVO) singleTransportationVOS[k];
				sub_models.add(model);
				if (!model.getEqNo().equals("")) {
					param.put("eq_no", model.getEqNo());
					param.put("pol_cd", model.getPolCd());
					param.put("trunkvvd", model.getTrunkvvd());
					param.put("ctrl_ofc_cd", model.getCtrlOfcCd());
					param.put("fm_nod_cd", model.getFmNodCd());
					param.put("fm_nod_yard", model.getFmNodYard());
					dbRowset = sqlExe.executeQuery(new SingleTransportationSOManageDBDAORemoveSOCandidateRSQL(), param, param);
					for (; dbRowset.next();) {
						SingleTransportationVO sub_model = new SingleTransportationVO();
						sub_model.setCopNo(dbRowset.getObject("COP_NO").toString());
						sub_model.setCostActGrpSeq(dbRowset.getObject("COST_ACT_GRP_SEQ").toString());
						sub_model.setBkgNo(dbRowset.getObject("BKG_NO").toString());
						sub_model.setUpdUsrId(form_cre_usr_id);
						sub_models.add(sub_model);
					}
				}
			}
			insCnt = sqlExe.executeBatch((ISQLTemplate) new SingleTransportationSOManageDBDAORemoveSOCandidateUSQL(), sub_models, null);
			for (int i = 0; i < insCnt.length; i++) {
				if (insCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update No" + i + " SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sub_models;
	}

	/**
	 * SingleTransportationSOManage의 조회 된 데이타 모델을 DB에 반영한다.<br>
	 * CNTR 직반납을 위해 OffHireVerify check
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchOffHireVerify(EsdTrs0002Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList arr_cntrno = event.getSel_cntr_noList();
		try {
			param.put("arr_cntrno", arr_cntrno);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			SingleTransportationSOManageDBDAOSearchOffHireVerifyRSQL template = new SingleTransportationSOManageDBDAOSearchOffHireVerifyRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * SingleTransportationSOManage의 조회 된 데이타 모델을 DB에 반영한다.<br>
	 * CY / Door 변경에 따른 Cost Mode 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchCostMode(EsdTrs0002Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("cydoordiv", event.getCydoor_div());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			SingleTransportationSOManageDBDAOSearchCostModeRSQL template = new SingleTransportationSOManageDBDAOSearchCostModeRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * S/O 발행 변경사항을 History 테이블에 관리 TRS_TRSP_SVC_ORD_TMP 테이블에 데이터를 INSERT한다.
	 * 
	 * @param model
	 * @param replanSts
	 * @throws DAOException
	 * @throws Exception
	 */
	public void multiSoIssueBeforeHis(SingleTransportationVO model, String replanSts) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt = 0;
		try {
			Map<String, String> paramVo = model.getColumnValues();
			param.putAll(paramVo);
			param.put("replanSts", replanSts);

			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new SingleTransportationSOManageDBDAOMultiSoIssueBeforeHisCSQL(), param, param);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * S/O 발행 변경사항을 History 테이블에 관리 TRS_TRSP_SVC_ORD_TMP 테이블에 데이터를 INSERT한다.
	 * 
	 * @param model
	 * @param replanSts
	 * @throws DAOException
	 * @throws Exception
	 */
	public void multiSoIssueAfterHis(SingleTransportationVO model, String replanSts) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt = 0;
		try {
			Map<String, String> paramVo = model.getColumnValues();
			param.putAll(paramVo);
			param.put("replanSts", replanSts);

			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new SingleTransportationSOManageDBDAOMultiSoIssueAfterHisCSQL(), param, param);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * MDM Container Type/Size Combo List
	 * 
	 * @param event
	 * @return List<MdmCntrTpSzVO>
	 * @throws DAOException
	 */
	public List<MdmCntrTpSzVO> searchMdmCntrTpSz(EsdTrs0002Event event) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCntrTpSzVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("eq_radio", "U");
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			TrsCommonDBDAOsearchMdmCntrTpSzRSQL template = new TrsCommonDBDAOsearchMdmCntrTpSzRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);

			list = new ArrayList<MdmCntrTpSzVO>();
			while (dbRowset.next()) {
				MdmCntrTpSzVO vo = new MdmCntrTpSzVO();
				vo.setCntrTpszCd(dbRowset.getString("cntr_tpsz_cd"));
				list.add(vo);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 여러개의 parameter를 나누어주는 메소드 Detail Inquity Popup<br>
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return
	 */
	public ArrayList seperationParameter(String sparameter, String sSeperate) {
		ArrayList arrlist = null;
		StringTokenizer st = null;
		int j = 0;
		if (!sparameter.equals("")) {
			arrlist = new ArrayList();
			st = new StringTokenizer(sparameter, sSeperate);
			while (st.hasMoreTokens()) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}

	/**
	 * 여러개의 parameter를 나누어주는 메소드 Detail Inquity Popup<br>
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return
	 */
	public String seperationParameterq(String sparameter, String sSeperate) {
		String slist = null;
		StringTokenizer st = null;
		int j = 0;
		if (!sparameter.equals("")) {
			st = new StringTokenizer(sparameter, sSeperate);
			while (st.hasMoreTokens()) {
				if (j != 0) {
					slist = slist + ",'" + st.nextToken() + "'";
				} else {
					slist = slist + "'" + st.nextToken() + "'";
				}
			}
		}
		return slist;
	}

	/**
	 * @param obj
	 * @return
	 */
	public static Object getNull(Object obj) {
		if (obj == null) {
			return "";
		}
		return obj;
	}
}
