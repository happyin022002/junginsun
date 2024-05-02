/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WorkOrderPreviewDBDAO.java
 *@FileTitle : WorkOrderPreviewDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.clt.apps.opus.esd.trs.common.internalremarkpopup.integration.InternalRemarkPopupDBDAOUpdateInternalRemarkVObySoWoUSQL;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.basic.WorkOrderPreviewBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.vo.WorkOrderPreviewVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.TrsTrspWrkOrdPrvTmpVO;
import com.clt.syscommon.common.table.TrsTrspWrkOrdVO;

/**
 * ESD-workordermanage에 대한 DB 처리를 담당<br>
 * - ESD-workordermanage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author poong_yeon
 * @see WorkOrderPreviewBCImpl 참조
 * @since J2EE 1.4
 */
public class WorkOrderPreviewDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 6132500820062573285L;

	/**
	 * WorkOrderPreview의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void searchWorkOrderPreviewGroup(EsdTrs0024Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		SQLExecuter sqlExecuter = new SQLExecuter("DEFAULT");
		DBRowSet selectRs = null;
		DBRowSet seqRs = null;
		DBRowSet groupRs = null;

		List<TrsTrspWrkOrdPrvTmpVO> sonumberArr = new ArrayList<TrsTrspWrkOrdPrvTmpVO>();
		WorkOrderPreviewVO workOrderPreviewVO = event.getWorkOrderPreviewVO();
		TrsTrspWrkOrdPrvTmpVO[] models = event.getTrsTrspWrkOrdPrvTmpVOs();
		TrsTrspWrkOrdPrvTmpVO model = null;
		int i = 0;
		try {
			/***** SEQ NO 가져오기 시작 *****/
			String groupSeq = "";
			if (CheckUtilities.isInBlank(workOrderPreviewVO.getScgGrpSeq())) {
				seqRs = sqlExecuter.executeQuery(new WorkOrderPreviewDBDAOSearchWorkOrderPreviewTmpSeqRSQL(), param, param);
				seqRs.next();
				groupSeq = seqRs.getString("group_seq");
				event.setGroupSeq(groupSeq);
			} else {
				groupSeq = workOrderPreviewVO.getScgGrpSeq();
				event.setGroupSeq(groupSeq);
			}
			/***** SEQ NO 가져오기 끝 *****/

			/***** 초기 INSERT 시작 ******/
			for (i = 0; i < models.length; i++) {
				model = models[i];
				param.put("wo_prv_grp_seq", groupSeq);
				param.put("wo_iss_sts_cd", "DF".equals(workOrderPreviewVO.getDraftFlg()) ? "X" : "I");
				param.put("vndr_seq", model.getVndrSeq());
				param.put("wo_cxl_flg", model.getWoCxlFlg());
				param.put("dtn_use_flg", model.getDtnUseFlg());
				param.put("wo_bl_no_iss_flg", model.getWoBlNoIssFlg());
				param.put("curr_cd", model.getCurrCd());
				param.put("bzc_amt", model.getBzcAmt());
				param.put("nego_amt", model.getNegoAmt());
				param.put("etc_add_amt", model.getEtcAddAmt());
				param.put("fuel_scg_amt", model.getFuelScgAmt());
				param.put("ovr_wgt_scg_amt", model.getOvrWgtScgAmt());
				param.put("n3pty_bil_flg", model.getN3ptyBilFlg());
				param.put("usd_ttl_amt", model.getUsdTtlAmt());
				param.put("cust_cnt_cd", model.getCustCntCd());
				param.put("cust_seq", model.getCustSeq());
				param.put("cust_nomi_trkr_flg", model.getCustNomiTrkrFlg());
				param.put("trsp_agmt_rt_tp_cd", model.getTrspAgmtRtTpCd());
				param.put("trsp_agmt_wy_tp_cd", model.getTrspAgmtWyTpCd());
				param.put("trsp_frst_flg", model.getTrspFrstFlg());
				param.put("trsp_rjct_rsn_cd", model.getTrspRjctRsnCd());
				param.put("trsp_dflt_vndr_flg", model.getTrspDfltVndrFlg());

				param.put("n1st_nod_pln_dt", model.getN1stNodPlnDt());
				param.put("lst_nod_pln_dt", model.getLstNodPlnDt());
				param.put("dor_nod_pln_dt", model.getDorNodPlnDt());
				param.put("inter_rmk", fromHtml(model.getInterRmk()));
				param.put("spcl_instr_rmk", fromHtml(model.getSpclInstrRmk()));
				param.put("fctry_nm", fromHtml(model.getFctryNm()));
				param.put("dor_pst_cd", fromHtml(model.getDorPstCd()));
				param.put("cntc_pson_phn_no", fromHtml(model.getCntcPsonPhnNo()));
				param.put("cntc_pson_fax_no", fromHtml(model.getCntcPsonFaxNo()));
				param.put("cntc_pson_nm", fromHtml(model.getCntcPsonNm()));

				param.put("n3pty_cust_cnt_cd", fromHtmlInt(model.getN3ptyCustCntCd()));
				param.put("n3pty_cust_seq", fromHtmlInt(model.getN3ptyCustSeq()));
				param.put("n3pty_desc", fromHtmlInt(model.getN3ptyDesc()));
				param.put("n3pty_vndr_seq", fromHtmlInt(model.getN3ptyVndrSeq()));
				param.put("n3pty_ofc_cd", fromHtmlInt(model.getN3ptyOfcCd()));
				param.put("n3pty_bil_bzc_amt", fromHtmlInt(model.getN3ptyBilBzcAmt()));
				param.put("n3pty_bil_tp_cd", fromHtmlInt(model.getN3ptyBilTpCd()));
				param.put("n3pty_curr_cd", fromHtmlInt(model.getN3ptyCurrCd()));

				param.put("trsp_so_ofc_cty_cd", model.getTrspSoOfcCtyCd());
				param.put("trsp_so_seq", model.getTrspSoSeq());
				param.put("trsp_agmt_ofc_cty_cd", fromHtmlInt(model.getTrspAgmtOfcCtyCd()));
				param.put("trsp_agmt_seq", fromHtmlInt(model.getTrspAgmtSeq()));

				param.put("wgt_meas_ut_cd", fromHtmlInt(model.getWgtMeasUtCd()));
				param.put("cntr_kgs_wgt", model.getCntrKgsWgt());
				param.put("cntr_lbs_wgt", model.getCntrLbsWgt());
				param.put("cntr_pkup_no", model.getCntrPkupNo());
				param.put("scg_ind_cd", model.getScgIndCd());

				selectRs = sqlExecuter.executeQuery(new WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssuedGroupRSQL(), param, param);
				if (selectRs.next()) {
					param.clear();
					param.put("trsp_so_ofc_cty_cd", selectRs.getString("trsp_so_ofc_cty_cd"));
					param.put("trsp_so_seq", selectRs.getString("trsp_so_seq"));
					param.put("wo_prv_grp_seq", selectRs.getString("wo_prv_grp_seq"));
					param.put("wo_iss_no", selectRs.getString("wo_iss_no"));
					param.put("wo_iss_sts_cd", selectRs.getString("wo_iss_sts_cd"));
					param.put("vndr_seq", selectRs.getString("vndr_seq"));
					param.put("wo_cxl_flg", selectRs.getString("wo_cxl_flg"));
					param.put("dtn_use_flg", selectRs.getString("dtn_use_flg"));
					param.put("wo_bl_no_iss_flg", selectRs.getString("wo_bl_no_iss_flg"));
					param.put("curr_cd", selectRs.getString("curr_cd"));
					param.put("bzc_amt", selectRs.getString("bzc_amt"));
					param.put("nego_amt", selectRs.getString("nego_amt"));
					param.put("etc_add_amt", selectRs.getString("etc_add_amt"));
					param.put("fuel_scg_amt", selectRs.getString("fuel_scg_amt"));
					param.put("ovr_wgt_scg_amt", selectRs.getString("ovr_wgt_scg_amt"));
					param.put("n3pty_bil_flg", selectRs.getString("n3pty_bil_flg"));
					param.put("usd_ttl_amt", selectRs.getString("usd_ttl_amt"));
					param.put("cust_cnt_cd", selectRs.getString("cust_cnt_cd"));
					param.put("cust_seq", selectRs.getString("cust_seq"));
					param.put("cust_nomi_trkr_flg", selectRs.getString("cust_nomi_trkr_flg"));
					param.put("trsp_agmt_rt_tp_cd", selectRs.getString("trsp_agmt_rt_tp_cd"));
					param.put("trsp_agmt_wy_tp_cd", selectRs.getString("trsp_agmt_wy_tp_cd"));
					param.put("trsp_frst_flg", selectRs.getString("trsp_frst_flg"));
					param.put("trsp_rjct_rsn_cd", selectRs.getString("trsp_rjct_rsn_cd"));
					param.put("trsp_dflt_vndr_flg", selectRs.getString("trsp_dflt_vndr_flg"));
					param.put("n1st_nod_pln_dt", selectRs.getString("n1st_nod_pln_dt"));
					param.put("lst_nod_pln_dt", selectRs.getString("lst_nod_pln_dt"));
					param.put("dor_nod_pln_dt", selectRs.getString("dor_nod_pln_dt"));
					param.put("inter_rmk", selectRs.getString("inter_rmk"));
					param.put("spcl_instr_rmk", selectRs.getString("spcl_instr_rmk"));
					param.put("fctry_nm", selectRs.getString("fctry_nm"));
					param.put("dor_pst_cd", selectRs.getString("dor_pst_cd"));
					param.put("cntc_pson_phn_no", selectRs.getString("cntc_pson_phn_no"));
					param.put("cntc_pson_fax_no", selectRs.getString("cntc_pson_fax_no"));
					param.put("cntc_pson_nm", selectRs.getString("cntc_pson_nm"));
					param.put("n3pty_cust_cnt_cd", selectRs.getString("n3pty_cust_cnt_cd"));
					param.put("n3pty_cust_seq", selectRs.getString("n3pty_cust_seq"));
					param.put("n3pty_desc", selectRs.getString("n3pty_desc"));
					param.put("n3pty_vndr_seq", selectRs.getString("n3pty_vndr_seq"));
					param.put("n3pty_ofc_cd", selectRs.getString("n3pty_ofc_cd"));
					param.put("n3pty_bil_bzc_amt", selectRs.getString("n3pty_bil_bzc_amt"));
					param.put("n3pty_bil_tp_cd", selectRs.getString("n3pty_bil_tp_cd"));
					param.put("n3pty_curr_cd", selectRs.getString("n3pty_curr_cd"));
					param.put("cre_usr_id", event.getFormCreUsrId());
					param.put("upd_usr_id", event.getFormCreUsrId());
					param.put("trsp_agmt_ofc_cty_cd", selectRs.getString("trsp_agmt_ofc_cty_cd"));
					param.put("trsp_agmt_seq", selectRs.getString("trsp_agmt_seq"));
					param.put("wgt_meas_ut_cd", selectRs.getString("wgt_meas_ut_cd"));
					param.put("cntr_kgs_wgt", selectRs.getString("cntr_kgs_wgt"));
					param.put("cntr_lbs_wgt", selectRs.getString("cntr_lbs_wgt"));
					param.put("cntr_pkup_no", selectRs.getString("cntr_pkup_no"));
					param.put("scg_ind_cd", selectRs.getString("scg_ind_cd"));
					int insCnt = sqlExecuter.executeUpdate(new WorkOrderPreviewDBDAOInsertWorkOrderPreviewTempCSQL(), param, param);
					if (insCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert SQL");
					}
				}
			}
			/***** 초기 INSERT 끝 ******/

			/***** Group 만들기 select문 시작 ******/
			TrsTrspWrkOrdPrvTmpVO arr = null;
			for (i = 0; i < models.length; i++) {
				arr = new TrsTrspWrkOrdPrvTmpVO();
				arr.setTrspSoOfcCtyCd(models[i].getTrspSoOfcCtyCd());
				arr.setTrspSoSeq(models[i].getTrspSoSeq());
				sonumberArr.add(arr);
			}

			param.clear();
			param.put("wo_prv_grp_seq", groupSeq);
			param.put("sonumberArr", sonumberArr);
			groupRs = sqlExecuter.executeQuery(new WorkOrderPreviewDBDAOSearchWorkOrderPreviewGroupWOListRSQL(), param, param);
			while (groupRs.next()) {
				param.clear();
				param.put("trsp_so_sts_cd", groupRs.getString("trsp_so_sts_cd"));
				param.put("wo_iss_no", groupRs.getString("wo_iss_no"));
				param.put("trsp_wo_ofc_cty_cd", groupRs.getString("trsp_wo_ofc_cty_cd"));
				param.put("trsp_wo_seq", groupRs.getString("trsp_wo_seq"));
				param.put("wo_fmt_tp_cd", groupRs.getString("wo_fmt_tp_cd"));
				param.put("trsp_so_cmb_tp_cd", groupRs.getString("trsp_so_cmb_tp_cd"));
				param.put("trsp_cost_dtl_mod_cd", groupRs.getString("trsp_cost_dtl_mod_cd"));
				param.put("cgo_tp_cd", groupRs.getString("cgo_tp_cd"));
				param.put("trsp_crr_mod_cd", groupRs.getString("trsp_crr_mod_cd"));
				param.put("fm_nod_cd", groupRs.getString("fm_nod_cd"));
				param.put("via_nod_cd", groupRs.getString("via_nod_cd"));
				param.put("dor_nod_cd", groupRs.getString("dor_nod_cd"));
				param.put("to_nod_cd", groupRs.getString("to_nod_cd"));
				param.put("fdr_vsl_cd", groupRs.getString("fdr_vsl_cd"));
				param.put("fdr_skd_voy_no", groupRs.getString("fdr_skd_voy_no"));
				param.put("fdr_skd_dir_cd", groupRs.getString("fdr_skd_dir_cd"));
				param.put("usr_ofc_cd", event.getFormUsrOfcCd());
				param.put("cre_usr_id", event.getFormCreUsrId());
				param.put("trsp_so_ofc_cty_cd", groupRs.getString("trsp_so_ofc_cty_cd"));
				param.put("trsp_so_seq", groupRs.getString("trsp_so_seq"));
				param.put("wo_prv_grp_seq", groupSeq);
				int updCnt = sqlExecuter.executeUpdate(new WorkOrderPreviewDBDAOUpdateWorkOrderPreviewTempUSQL(), param, param);
				if (updCnt == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to update SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * WorkOrderPreview의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void searchWorkOrderPreviewIssuedGroup(EsdTrs0024Event event) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();

		// DB ResultSet
		DBRowSet selectRs = null;
		DBRowSet seqRs = null;
		DBRowSet groupRs = null;
		SQLExecuter sqlExecuter = new SQLExecuter("DEFAULT");
		WorkOrderPreviewVO workOrderPreviewVO = event.getWorkOrderPreviewVO();
		List<TrsTrspWrkOrdPrvTmpVO> sonumberArr = new ArrayList<TrsTrspWrkOrdPrvTmpVO>();
		TrsTrspWrkOrdPrvTmpVO[] trsTrspWrkOrdPrvTmpVOs = event.getTrsTrspWrkOrdPrvTmpVOs();
		TrsTrspWrkOrdPrvTmpVO model = null;
		int i = 0;
		try {
			/***** SEQ NO 가져오기 시작 *****/
			String groupSeq = "";
			if (CheckUtilities.isInBlank(workOrderPreviewVO.getScgGrpSeq())) {
				seqRs = sqlExecuter.executeQuery(new WorkOrderPreviewDBDAOSearchWorkOrderPreviewTmpSeqRSQL(), param, param);
				seqRs.next();
				groupSeq = seqRs.getString("group_seq");
				event.setGroupSeq(groupSeq);
			} else {
				groupSeq = workOrderPreviewVO.getScgGrpSeq();
				event.setGroupSeq(groupSeq);
			}
			/***** SEQ NO 가져오기 끝 *****/

			/***** 초기 INSERT 시작 ******/
			String n1stNodPlnDt = null;
			String lstNodPlnDt = null;
			String dorNodPlnDt = null;

			for (i = 0; i < trsTrspWrkOrdPrvTmpVOs.length; i++) {
				if (trsTrspWrkOrdPrvTmpVOs[i].getN1stNodPlnDt() == null || trsTrspWrkOrdPrvTmpVOs[i].getN1stNodPlnDt().equals("")) {
					n1stNodPlnDt = null;
				} else {
					n1stNodPlnDt = trsTrspWrkOrdPrvTmpVOs[i].getN1stNodPlnDt();
				}

				if (trsTrspWrkOrdPrvTmpVOs[i].getLstNodPlnDt() == null || trsTrspWrkOrdPrvTmpVOs[i].getLstNodPlnDt().equals("")) {
					lstNodPlnDt = null;
				} else {
					lstNodPlnDt = trsTrspWrkOrdPrvTmpVOs[i].getLstNodPlnDt();
				}

				if (trsTrspWrkOrdPrvTmpVOs[i].getDorNodPlnDt() == null || trsTrspWrkOrdPrvTmpVOs[i].getDorNodPlnDt().equals("")) {
					dorNodPlnDt = null;
				} else {
					dorNodPlnDt = trsTrspWrkOrdPrvTmpVOs[i].getDorNodPlnDt();
				}
				param.put("wo_prv_grp_seq", groupSeq);
				param.put("wo_iss_sts_cd", "DF".equals(workOrderPreviewVO.getDraftFlg()) ? "X" : "I");
				param.put("vndr_seq", trsTrspWrkOrdPrvTmpVOs[i].getVndrSeq());
				param.put("wo_cxl_flg", trsTrspWrkOrdPrvTmpVOs[i].getWoCxlFlg());
				param.put("dtn_use_flg", trsTrspWrkOrdPrvTmpVOs[i].getDtnUseFlg());
				param.put("wo_bl_no_iss_flg", trsTrspWrkOrdPrvTmpVOs[i].getWoBlNoIssFlg());
				param.put("curr_cd", trsTrspWrkOrdPrvTmpVOs[i].getCurrCd());
				param.put("bzc_amt", trsTrspWrkOrdPrvTmpVOs[i].getBzcAmt());
				param.put("nego_amt", trsTrspWrkOrdPrvTmpVOs[i].getNegoAmt());
				param.put("etc_add_amt", trsTrspWrkOrdPrvTmpVOs[i].getEtcAddAmt());
				param.put("fuel_scg_amt", trsTrspWrkOrdPrvTmpVOs[i].getFuelScgAmt());
				param.put("ovr_wgt_scg_amt", trsTrspWrkOrdPrvTmpVOs[i].getOvrWgtScgAmt());
				param.put("n3pty_bil_flg", trsTrspWrkOrdPrvTmpVOs[i].getN3ptyBilFlg());
				param.put("usd_ttl_amt", trsTrspWrkOrdPrvTmpVOs[i].getUsdTtlAmt());
				param.put("cust_cnt_cd", trsTrspWrkOrdPrvTmpVOs[i].getCustCntCd());
				param.put("cust_seq", trsTrspWrkOrdPrvTmpVOs[i].getCustSeq());
				param.put("cust_nomi_trkr_flg", trsTrspWrkOrdPrvTmpVOs[i].getCustNomiTrkrFlg());
				param.put("trsp_agmt_rt_tp_cd", trsTrspWrkOrdPrvTmpVOs[i].getTrspAgmtRtTpCd());
				param.put("trsp_agmt_wy_tp_cd", trsTrspWrkOrdPrvTmpVOs[i].getTrspAgmtWyTpCd());
				param.put("trsp_frst_flg", trsTrspWrkOrdPrvTmpVOs[i].getTrspFrstFlg());
				param.put("trsp_rjct_rsn_cd", trsTrspWrkOrdPrvTmpVOs[i].getTrspRjctRsnCd());
				param.put("trsp_dflt_vndr_seq", trsTrspWrkOrdPrvTmpVOs[i].getTrspDfltVndrFlg());
				param.put("n1st_nod_pln_dt", n1stNodPlnDt);
				param.put("lst_nod_pln_dt", lstNodPlnDt);
				param.put("dor_nod_pln_dt", dorNodPlnDt);
				param.put("inter_rmk", fromHtml(trsTrspWrkOrdPrvTmpVOs[i].getInterRmk()));
				param.put("spcl_instr_rmk", fromHtml(trsTrspWrkOrdPrvTmpVOs[i].getSpclInstrRmk()));
				param.put("fctry_nm", fromHtml(trsTrspWrkOrdPrvTmpVOs[i].getFctryNm()));
				param.put("dor_pst_cd", fromHtml(trsTrspWrkOrdPrvTmpVOs[i].getDorPstCd()));
				param.put("cntc_pson_phn_no", fromHtml(trsTrspWrkOrdPrvTmpVOs[i].getCntcPsonPhnNo()));
				param.put("cntc_pson_fax_no", fromHtml(trsTrspWrkOrdPrvTmpVOs[i].getCntcPsonFaxNo()));
				param.put("cntc_pson_nm", fromHtml(trsTrspWrkOrdPrvTmpVOs[i].getCntcPsonNm()));

				param.put("n3pty_cust_cnt_cd", fromHtmlInt(trsTrspWrkOrdPrvTmpVOs[i].getN3ptyCustCntCd()));
				param.put("n3pty_cust_seq", fromHtmlInt(trsTrspWrkOrdPrvTmpVOs[i].getN3ptyCustSeq()));
				param.put("n3pty_desc", fromHtmlInt(trsTrspWrkOrdPrvTmpVOs[i].getN3ptyDesc()));
				param.put("n3pty_vndr_seq", fromHtmlInt(trsTrspWrkOrdPrvTmpVOs[i].getN3ptyVndrSeq()));
				param.put("n3pty_ofc_cd", fromHtmlInt(trsTrspWrkOrdPrvTmpVOs[i].getN3ptyOfcCd()));
				param.put("n3pty_bil_bzc_amt", fromHtmlInt(trsTrspWrkOrdPrvTmpVOs[i].getN3ptyBilBzcAmt()));
				param.put("n3pty_bil_tp_cd", fromHtmlInt(trsTrspWrkOrdPrvTmpVOs[i].getN3ptyBilTpCd()));
				param.put("n3pty_curr_cd", fromHtmlInt(trsTrspWrkOrdPrvTmpVOs[i].getN3ptyCurrCd()));

				param.put("trsp_so_ofc_cty_cd", trsTrspWrkOrdPrvTmpVOs[i].getTrspSoOfcCtyCd());
				param.put("trsp_so_seq", trsTrspWrkOrdPrvTmpVOs[i].getTrspSoSeq());
				param.put("trsp_agmt_ofc_cty_cd", fromHtmlInt(trsTrspWrkOrdPrvTmpVOs[i].getTrspAgmtOfcCtyCd()));
				param.put("trsp_agmt_seq", fromHtmlInt(trsTrspWrkOrdPrvTmpVOs[i].getTrspAgmtSeq()));

				param.put("wgt_meas_ut_cd", trsTrspWrkOrdPrvTmpVOs[i].getWgtMeasUtCd());
				param.put("cntr_kgs_wgt", trsTrspWrkOrdPrvTmpVOs[i].getCntrKgsWgt());
				param.put("cntr_lbs_wgt", trsTrspWrkOrdPrvTmpVOs[i].getCntrLbsWgt());
				param.put("cntr_pkup_no", trsTrspWrkOrdPrvTmpVOs[i].getCntrPkupNo());
				param.put("scg_ind_cd", trsTrspWrkOrdPrvTmpVOs[i].getScgIndCd());
				selectRs = sqlExecuter.executeQuery(new WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssuedGroupRSQL(), param, param);
				while (selectRs.next()) {
					param.clear();
					param.put("trsp_so_ofc_cty_cd", selectRs.getString("trsp_so_ofc_cty_cd"));
					param.put("trsp_so_seq", selectRs.getString("trsp_so_seq"));
					param.put("wo_prv_grp_seq", selectRs.getString("wo_prv_grp_seq"));
					param.put("wo_iss_sts_cd", selectRs.getString("wo_iss_sts_cd"));
					param.put("wo_iss_no", selectRs.getString("wo_iss_no"));
					param.put("vndr_seq", selectRs.getString("vndr_seq"));
					param.put("wo_cxl_flg", selectRs.getString("wo_cxl_flg"));
					param.put("dtn_use_flg", selectRs.getString("dtn_use_flg"));
					param.put("wo_bl_no_iss_flg", selectRs.getString("wo_bl_no_iss_flg"));
					param.put("curr_cd", selectRs.getString("curr_cd"));
					param.put("bzc_amt", selectRs.getString("bzc_amt"));
					param.put("nego_amt", selectRs.getString("nego_amt"));
					param.put("etc_add_amt", selectRs.getString("etc_add_amt"));
					param.put("fuel_scg_amt", selectRs.getString("fuel_scg_amt"));
					param.put("ovr_wgt_scg_amt", selectRs.getString("ovr_wgt_scg_amt"));
					param.put("n3pty_bil_flg", selectRs.getString("n3pty_bil_flg"));
					param.put("usd_ttl_amt", selectRs.getString("usd_ttl_amt"));
					param.put("cust_cnt_cd", selectRs.getString("cust_cnt_cd"));
					param.put("cust_seq", selectRs.getString("cust_seq"));
					param.put("cust_nomi_trkr_flg", selectRs.getString("cust_nomi_trkr_flg"));
					param.put("trsp_agmt_rt_tp_cd", selectRs.getString("trsp_agmt_rt_tp_cd"));
					param.put("trsp_agmt_wy_tp_cd", selectRs.getString("trsp_agmt_wy_tp_cd"));
					param.put("trsp_frst_flg", selectRs.getString("trsp_frst_flg"));
					param.put("trsp_rjct_rsn_cd", selectRs.getString("trsp_rjct_rsn_cd"));
					param.put("trsp_dflt_vndr_flg", selectRs.getString("trsp_dflt_vndr_flg"));
					param.put("n1st_nod_pln_dt", selectRs.getString("n1st_nod_pln_dt"));
					param.put("lst_nod_pln_dt", selectRs.getString("lst_nod_pln_dt"));
					param.put("dor_nod_pln_dt", selectRs.getString("dor_nod_pln_dt"));
					param.put("inter_rmk", selectRs.getString("inter_rmk"));
					param.put("spcl_instr_rmk", selectRs.getString("spcl_instr_rmk"));
					param.put("fctry_nm", selectRs.getString("fctry_nm"));
					param.put("dor_pst_cd", selectRs.getString("dor_pst_cd"));
					param.put("cntc_pson_phn_no", selectRs.getString("cntc_pson_phn_no"));
					param.put("cntc_pson_fax_no", selectRs.getString("cntc_pson_fax_no"));
					param.put("cntc_pson_nm", selectRs.getString("cntc_pson_nm"));
					param.put("n3pty_cust_cnt_cd", selectRs.getString("n3pty_cust_cnt_cd"));
					param.put("n3pty_cust_seq", selectRs.getString("n3pty_cust_seq"));
					param.put("n3pty_desc", selectRs.getString("n3pty_desc"));
					param.put("n3pty_vndr_seq", selectRs.getString("n3pty_vndr_seq"));
					param.put("n3pty_ofc_cd", selectRs.getString("n3pty_ofc_cd"));
					param.put("n3pty_bil_bzc_amt", selectRs.getString("n3pty_bil_bzc_amt"));
					param.put("n3pty_bil_tp_cd", selectRs.getString("n3pty_bil_tp_cd"));
					param.put("n3pty_curr_cd", selectRs.getString("n3pty_curr_cd"));
					param.put("cre_usr_id", event.getFormCreUsrId());
					param.put("upd_usr_id", event.getFormCreUsrId());
					param.put("trsp_agmt_ofc_cty_cd", selectRs.getString("trsp_agmt_ofc_cty_cd"));
					param.put("trsp_agmt_seq", selectRs.getString("trsp_agmt_seq"));
					param.put("wgt_meas_ut_cd", selectRs.getString("wgt_meas_ut_cd"));
					param.put("cntr_kgs_wgt", selectRs.getString("cntr_kgs_wgt"));
					param.put("cntr_lbs_wgt", selectRs.getString("cntr_lbs_wgt"));
					param.put("cntr_pkup_no", selectRs.getString("cntr_pkup_no"));
					param.put("scg_ind_cd", selectRs.getString("scg_ind_cd"));
					int insCnt = sqlExecuter.executeUpdate(new WorkOrderPreviewDBDAOInsertWorkOrderPreviewTempCSQL(), param, param);
					if (insCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update SQL");
					}
				}
			}

			/***** 초기 INSERT 끝 ******/

			/***** Group 만들기 select문 시작 ******/
			TrsTrspWrkOrdPrvTmpVO arr = null;
			for (i = 0; i < trsTrspWrkOrdPrvTmpVOs.length; i++) {
				arr = new TrsTrspWrkOrdPrvTmpVO();
				model = trsTrspWrkOrdPrvTmpVOs[i];
				arr.setTrspSoOfcCtyCd(model.getTrspSoOfcCtyCd());
				arr.setTrspSoSeq(model.getTrspSoSeq());
				sonumberArr.add(arr);
			}

			param.put("sonumberArr", sonumberArr);
			groupRs = sqlExecuter.executeQuery(new WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssuedGroupWOListRSQL(), param, param);

			while (groupRs.next()) {
				param.clear();
				param.put("trsp_so_sts_cd", groupRs.getString("trsp_so_sts_cd"));
				param.put("wo_iss_no", groupRs.getString("wo_iss_no"));
				param.put("trsp_wo_ofc_cty_cd", groupRs.getString("trsp_wo_ofc_cty_cd"));
				param.put("trsp_wo_seq", groupRs.getString("trsp_wo_seq"));
				param.put("wo_fmt_tp_cd", groupRs.getString("wo_fmt_tp_cd"));
				param.put("trsp_so_cmb_tp_cd", groupRs.getString("trsp_so_cmb_tp_cd"));
				param.put("trsp_cost_dtl_mod_cd", groupRs.getString("trsp_cost_dtl_mod_cd"));
				param.put("cgo_tp_cd", groupRs.getString("cgo_tp_cd"));
				param.put("trsp_crr_mod_cd", groupRs.getString("trsp_crr_mod_cd"));
				param.put("fm_nod_cd", groupRs.getString("fm_nod_cd"));
				param.put("via_nod_cd", groupRs.getString("via_nod_cd"));
				param.put("dor_nod_cd", groupRs.getString("dor_nod_cd"));
				param.put("to_nod_cd", groupRs.getString("to_nod_cd"));
				param.put("fdr_vsl_cd", groupRs.getString("fdr_vsl_cd"));
				param.put("fdr_skd_voy_no", groupRs.getString("fdr_skd_voy_no"));
				param.put("fdr_skd_dir_cd", groupRs.getString("fdr_skd_dir_cd"));
				param.put("usr_ofc_cd", event.getFormUsrOfcCd());
				param.put("cre_usr_id", event.getFormCreUsrId());
				param.put("cre_usr_ofc_cd", event.getFormUsrOfcCd());
				param.put("trsp_so_ofc_cty_cd", groupRs.getString("trsp_so_ofc_cty_cd"));
				param.put("trsp_so_seq", groupRs.getString("trsp_so_seq"));
				param.put("wo_prv_grp_seq", groupSeq);

				int updCnt = sqlExecuter.executeUpdate(new WorkOrderPreviewDBDAOUpdateWorkOrderPreviewTempUSQL(), param, param);
				if (updCnt == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to update SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * WorkOrderPreview의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchWorkOrderPreviewIssueStatus(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet issSelRs = null;
		String groupSeq = event.getGroupSeq();
		try {
			WorkOrderPreviewVO vo = event.getWorkOrderPreviewVO();
			param.clear();
			param.put("group_seq", groupSeq);
			issSelRs = new SQLExecuter("").executeQuery(new WorkOrderPreviewDBDAOSearchWorkOrderGroupSeqRSQL(), param, param);
			while (issSelRs.next()) {
				param.clear();
				param.put("wo_prv_grp_seq", groupSeq);
				param.put("wo_iss_no", issSelRs.getString("wo_iss_no"));
				if (!"DF".equals(vo.getDraftFlg())) {
					int updCnt = new SQLExecuter("").executeUpdate(new WorkOrderPreviewDBDAOUpdateWorkOrderPreviewIssueStatusUSQL(), param, param);
					if (updCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update SQL");
					}
				} else {
					int updCnt = new SQLExecuter("").executeUpdate(new WorkOrderPreviewDBDAOUpdateWorkOrderPreviewDraftStatusUSQL(), param, param);
					if (updCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update SQL");
					}
				}
			}
			param.clear();
			param.put("wo_prv_grp_seq", groupSeq);
			dRs = new SQLExecuter("").executeQuery(new WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssueStatusRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * WorkOrderPreview의 데이타 모델을 DB에 저장한다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet addWorkOrderPreview(EsdTrs0024Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet seqRs = null;
		DBRowSet flgSelectRs = null;
		DBRowSet emtSelectRs = null;
		DBRowSet scSelectRs = null;

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		String seqNo = null;
		String kntNo = null;
		int insCnt = 0;
		int updCnt = 0;
		int delCnt = 0;

		try {
			String woPrnUseFlg = wrkOrdPrvVO.getWoPrnUseFlg();
			String woEmlUseFlg = wrkOrdPrvVO.getWoEmlUseFlg();
			String woFaxUseFlg = wrkOrdPrvVO.getWoFaxUseFlg();
			String woEdiUseFlg = wrkOrdPrvVO.getWoEdiUseFlg();

			String cmdtDpUseFlg = wrkOrdPrvVO.getCmdtDpUseFlg();
			String preDisUseFlg = wrkOrdPrvVO.getPreDisUseFlg();
			String interUseFlg = wrkOrdPrvVO.getInterUseFlg();

			woPrnUseFlg = (woPrnUseFlg == null || "".equals(woPrnUseFlg)) ? "N" : "Y";
			woEmlUseFlg = (woEmlUseFlg == null || "".equals(woEmlUseFlg)) ? "N" : "Y";
			woFaxUseFlg = (woFaxUseFlg == null || "".equals(woFaxUseFlg)) ? "N" : "Y";
			cmdtDpUseFlg = (cmdtDpUseFlg == null || "".equals(cmdtDpUseFlg)) ? "N" : "Y";
			preDisUseFlg = (preDisUseFlg == null || "".equals(preDisUseFlg)) ? "N" : "Y";
			woEdiUseFlg = (woEdiUseFlg == null || "".equals(woEdiUseFlg)) ? "N" : "Y";
			interUseFlg = (interUseFlg == null || "".equals(interUseFlg)) ? "N" : "Y";

			/***** 중복 verify 시작 *****/
			String woIssStsCd = "DF".equals(wrkOrdPrvVO.getDraftFlg()) ? "X" : "I";
			param.clear();
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			/***** SEQ NO 가져오기 시작 *****/
			seqRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOAddWorkOrderPreviewGetSeqRSQL(), param, param);
			seqRs.next();
			seqNo = seqRs.getString("seq");
			/***** SEQ NO 가져오기 끝 *****/

			// TRS_TRSP_WRK_ORD INSERT
			param.clear();
			param.put("trsp_wo_ofc_cty_cd", event.getFormUsrOfcCd().substring(0, 3));
			param.put("trsp_wo_seq", seqNo);
			param.put("wo_iss_sts_cd", woIssStsCd);
			param.put("wo_fmt_tp_cd", wrkOrdPrvVO.getWoFmtTpCd());
			param.put("wo_vndr_seq", wrkOrdPrvVO.getWoVndrSeq());
			param.put("wo_prn_use_flg", woPrnUseFlg);
			param.put("wo_fax_use_flg", woFaxUseFlg);
			param.put("wo_eml_use_flg", woEmlUseFlg);
			param.put("wo_edi_use_flg", woEdiUseFlg);
			param.put("wo_n1st_fax_no", wrkOrdPrvVO.getWoN1stFaxNo());
			param.put("wo_n2nd_fax_no", wrkOrdPrvVO.getWoN2ndFaxNo());
			param.put("wo_n3rd_fax_no", wrkOrdPrvVO.getWoN3rdFaxNo());
			param.put("wo_n1st_eml", wrkOrdPrvVO.getWoN1stEml());
			param.put("wo_n2nd_eml", wrkOrdPrvVO.getWoN2ndEml());
			param.put("wo_n3rd_eml", wrkOrdPrvVO.getWoN3rdEml());
			param.put("wo_rmk", wrkOrdPrvVO.getWoRmk());
			param.put("rt_dp_use_flg", wrkOrdPrvVO.getRtDpUseFlg());
			param.put("cmdt_dp_use_flg", cmdtDpUseFlg);
			param.put("pre_dis_use_flg", preDisUseFlg);
			param.put("inter_use_flg", interUseFlg);
			param.put("cre_ofc_cd", event.getFormUsrOfcCd());
			param.put("cre_usr_id", event.getFormCreUsrId());
			param.put("upd_usr_id", event.getFormCreUsrId());
			param.put("usr_ofc_cd", event.getFormUsrOfcCd());

			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewWrkOrdCSQL(), param, param);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
			if (!"DF".equals(wrkOrdPrvVO.getDraftFlg())) {
				kntNo = "1";
				param.put("wo_iss_knt", kntNo);
				insCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewWrkOrdHisCSQL(), param, param);
				if (insCnt == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
				}
			}
			/***** TRS_TRSP_WRK_ORD,TRS_TRSP_WRK_ORD_HIS 처리 끝 *****/
			param.clear();
			param.put("trsp_wo_ofc_cty_cd", event.getFormUsrOfcCd().substring(0, 3));
			param.put("trsp_wo_seq", seqNo);
			param.put("vndr_seq", wrkOrdPrvVO.getWoVndrSeq());
			param.put("upd_usr_id", event.getFormCreUsrId());
			param.put("usr_ofc_cd", event.getFormUsrOfcCd());
			param.put("conti_cd", wrkOrdPrvVO.getContiCd());
			param.put("wo_edi_use_flg", woEdiUseFlg);
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());
			param.put("trs_sub_sts_cd", wrkOrdPrvVO.getDraftFlg());
			param.put("wo_iss_sts_cd", woIssStsCd);
			new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOInsertTrsSubStsHisCSQL(), param, param);
			updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewSvcOrdUSQL(), param, param);
			if (updCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}

			// TRS_TRSP_WRK_ORD_PRV_TMP UPDATE
			param.clear();
			param.put("trsp_wo_ofc_cty_cd", event.getFormUsrOfcCd().substring(0, 3));
			param.put("trsp_wo_seq", seqNo);
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewWrkOrdPrvTmpUSQL(), param, param);
			if (updCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}

			/***** TEMP TABLE에서 TRS_TRSP_SVC_ORD TABLE로 UPDATE할 데이타 가져오기 시작 *****/
			param.clear();
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());
			flgSelectRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOAddWorkOrderPreviewWrkOrdPrvTmpRSQL(), param, param);
			while (flgSelectRs.next()) {
				if (!"DF".equals(wrkOrdPrvVO.getDraftFlg())) {
					// CY-DOOR 건에 한해 SCE_PLN_SO_LIST UPDATE 진행
					if (flgSelectRs.getString("trsp_so_tp_cd") != null && "Y".equals(flgSelectRs.getString("trsp_so_tp_cd"))) {

						// SCE UPDATE전 테이블 History 기록
						param.clear();
						param.put("cop_no", flgSelectRs.getString("cop_no"));
						param.put("eq_no", flgSelectRs.getString("eq_no"));
						param.put("cost_act_grp_seq", flgSelectRs.getString("cost_act_grp_seq"));
						param.put("cost_act_grp_cd", flgSelectRs.getString("cost_act_grp_cd"));
						param.put("trsp_crr_mod_cd", flgSelectRs.getString("trsp_crr_mod_cd"));
						param.put("trsp_bnd_cd", flgSelectRs.getString("trsp_bnd_cd"));
						param.put("cre_ofc_cd", flgSelectRs.getString("cre_ofc_cd"));
						param.put("trsp_so_seq", flgSelectRs.getString("trsp_so_seq"));
						if (flgSelectRs.getString("trsp_rjct_rsn_cd") != null && "B".equals(flgSelectRs.getString("trsp_rjct_rsn_cd")) && flgSelectRs.getString("wo_cxl_flg") != null && flgSelectRs.getString("wo_cxl_flg").equals("Y")) {
							param.put("trsp_so_sts_cd", "D");
						} else {
							param.put("trsp_so_sts_cd", "I");
						}
						param.put("fm_nod_cd", flgSelectRs.getString("fm_nod_cd"));
						param.put("via_nod_cd", flgSelectRs.getString("via_nod_cd"));
						param.put("dor_nod_cd", flgSelectRs.getString("dor_nod_cd"));
						param.put("to_nod_cd", flgSelectRs.getString("to_nod_cd"));
						param.put("bkg_no", flgSelectRs.getString("bkg_no"));
						param.put("upln_so_flg", flgSelectRs.getString("upln_so_flg"));
						param.put("cre_usr_id", event.getFormCreUsrId());
						param.put("upd_usr_id", event.getFormCreUsrId());

						insCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewSvcOrdBeforeHisCSQL(), param, param);
						if (insCnt == Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to insert SQL");
						}

						// SCE_PLN_SO_LIST UPDATE
						param.put("trsp_so_ofc_cty_cd", flgSelectRs.getString("trsp_so_ofc_cty_cd"));
						param.put("trsp_so_seq", flgSelectRs.getString("trsp_so_seq"));

						updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewScePlnSoListUSQL(), param, param);
						if (updCnt == Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to update SQL");
						}

						// SCE UPDATE후 테이블 History 기록
						param.clear();
						param.put("eq_no", flgSelectRs.getString("eq_no"));
						param.put("cre_ofc_cd", flgSelectRs.getString("cre_ofc_cd"));
						param.put("trsp_so_seq", flgSelectRs.getString("trsp_so_seq"));
						param.put("bkg_no", flgSelectRs.getString("bkg_no"));
						param.put("cre_usr_id", event.getFormCreUsrId());
						param.put("upd_usr_id", event.getFormCreUsrId());
						param.put("cop_no", flgSelectRs.getString("cop_no"));
						param.put("cost_act_grp_seq", flgSelectRs.getString("cost_act_grp_seq"));

						insCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewSvcOrdAfterHisCSQL(), param, param);
						if (insCnt == Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to insert SQL");
						}
					}
				}
				param.clear();
				param.put("wo_bl_no_iss_flg", flgSelectRs.getString("wo_bl_no_iss_flg"));
				param.put("dtn_use_flg", flgSelectRs.getString("dtn_use_flg"));
				param.put("curr_cd", flgSelectRs.getString("curr_cd"));
				param.put("bzc_amt", flgSelectRs.getString("bzc_amt"));
				param.put("nego_amt", flgSelectRs.getString("nego_amt"));
				param.put("etc_add_amt", flgSelectRs.getString("etc_add_amt"));
				param.put("fuel_scg_amt", flgSelectRs.getString("fuel_scg_amt"));
				param.put("ovr_wgt_scg_amt", flgSelectRs.getString("ovr_wgt_scg_amt"));
				param.put("n3pty_bil_flg", flgSelectRs.getString("n3pty_bil_flg"));
				param.put("cust_cnt_cd", flgSelectRs.getString("cust_cnt_cd"));
				param.put("cust_seq", flgSelectRs.getString("cust_seq"));
				param.put("cust_nomi_trkr_flg", flgSelectRs.getString("cust_nomi_trkr_flg"));
				param.put("trsp_agmt_rt_tp_cd", flgSelectRs.getString("trsp_agmt_rt_tp_cd"));
				param.put("trsp_agmt_wy_tp_cd", flgSelectRs.getString("trsp_agmt_wy_tp_cd"));
				param.put("trsp_frst_flg", flgSelectRs.getString("trsp_frst_flg"));
				param.put("trsp_rjct_rsn_cd", flgSelectRs.getString("trsp_rjct_rsn_cd"));
				param.put("trsp_dflt_vndr_flg", flgSelectRs.getString("trsp_dflt_vndr_flg"));
				param.put("n1st_nod_pln_dt", flgSelectRs.getString("n1st_nod_pln_dt"));
				param.put("lst_nod_pln_dt", flgSelectRs.getString("lst_nod_pln_dt"));
				param.put("dor_nod_pln_dt", flgSelectRs.getString("dor_nod_pln_dt"));
				param.put("inter_rmk", flgSelectRs.getString("inter_rmk"));
				param.put("spcl_instr_rmk", flgSelectRs.getString("spcl_instr_rmk"));
				param.put("fctry_nm", flgSelectRs.getString("fctry_nm"));
				param.put("dor_pst_cd", flgSelectRs.getString("dor_pst_cd"));
				param.put("cntc_pson_phn_no", flgSelectRs.getString("cntc_pson_phn_no"));
				param.put("cntc_pson_fax_no", flgSelectRs.getString("cntc_pson_fax_no"));
				param.put("cntc_pson_nm", flgSelectRs.getString("cntc_pson_nm"));
				param.put("trsp_so_ofc_cty_cd", flgSelectRs.getString("trsp_so_ofc_cty_cd"));
				param.put("trsp_so_seq", flgSelectRs.getString("trsp_so_seq"));
				param.put("n3pty_bil_bzc_amt", flgSelectRs.getString("n3pty_bil_bzc_amt"));
				param.put("n3pty_vndr_seq", flgSelectRs.getString("n3pty_vndr_seq"));
				param.put("n3pty_ofc_cd", flgSelectRs.getString("n3pty_ofc_cd"));
				param.put("n3pty_desc", flgSelectRs.getString("n3pty_desc"));
				param.put("n3pty_cust_seq", flgSelectRs.getString("n3pty_cust_seq"));
				param.put("n3pty_cust_cnt_cd", flgSelectRs.getString("n3pty_cust_cnt_cd"));
				param.put("n3pty_bil_tp_cd", flgSelectRs.getString("n3pty_bil_tp_cd"));
				param.put("n3pty_curr_cd", flgSelectRs.getString("n3pty_curr_cd"));
				param.put("wgt_meas_ut_cd", flgSelectRs.getString("wgt_meas_ut_cd"));
				param.put("cntr_kgs_wgt", flgSelectRs.getString("cntr_kgs_wgt"));
				param.put("cntr_lbs_wgt", flgSelectRs.getString("cntr_lbs_wgt"));
				param.put("cgo_tp_cd", flgSelectRs.getString("cgo_tp_cd"));
				param.put("cntr_pkup_no", flgSelectRs.getString("cntr_pkup_no"));
				param.put("scg_ind_cd", flgSelectRs.getString("scg_ind_cd"));

				updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewSvcOrdFromTmpUSQL(), param, param);
				if (updCnt == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to update SQL");
				}

				/***** SURCHARGE TEMP TABLE에서 SURCHARGE TABLE로 INSERT 시작 *****/
				// SURCHARGE SELECT
				param.clear();
				param.put("wo_prv_grp_seq", wrkOrdPrvVO.getScgGrpSeq());
				param.put("trsp_so_ofc_cty_cd", flgSelectRs.getString("trsp_so_ofc_cty_cd"));
				param.put("trsp_so_seq", flgSelectRs.getString("trsp_so_seq"));

				scSelectRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOAddWorkOrderPreviewScgDtlTmpRSQL(), param, param);
				if (scSelectRs.next()) {
					// SURCHARGE DELETE
					param.clear();
					param.put("trsp_so_ofc_cty_cd", flgSelectRs.getString("trsp_so_ofc_cty_cd"));
					param.put("trsp_so_seq", flgSelectRs.getString("trsp_so_seq"));

					delCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewScgDtlDSQL(), param, param);
					if (delCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to delete SQL");
					}

					// SURCHARGE INSERT
					param.clear();
					param.put("scg_grp_seq", wrkOrdPrvVO.getScgGrpSeq());
					param.put("trsp_so_ofc_cty_cd", flgSelectRs.getString("trsp_so_ofc_cty_cd"));
					param.put("trsp_so_seq", flgSelectRs.getString("trsp_so_seq"));
					param.put("usr_ofc_cd", event.getFormUsrOfcCd());

					insCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewScgDtlCSQL(), param, param);
					if (insCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert SQL");
					}
					/***** SURCHARGE TEMP TABLE에서 SURCHARGE TABLE로 INSERT 끝 *****/
				}
			}
			/***** TEMP TABLE에서 TRS_TRSP_SVC_ORD TABLE로 UPDATE할 데이타 가져오기 끝 *****/

			/***** EMPTY REPO인 경우 EQR_REPO_EXE_SO_IF로 UPDATE 시작 *****/

			if (!"DF".equals(wrkOrdPrvVO.getDraftFlg())) {
				param.clear();
				param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
				param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());
				emtSelectRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOAddWorkOrderPreviewEmptyContainerRSQL(), param, param);
				while (emtSelectRs.next()) {
					param.put("tot_amt", emtSelectRs.getString("tot_amt"));
					param.put("repo_pln_id", emtSelectRs.getString("repo_pln_id"));
					param.put("pln_yrwk", emtSelectRs.getString("pln_yrwk"));
					param.put("ref_id", emtSelectRs.getString("ref_id"));
					param.put("ref_seq", emtSelectRs.getString("ref_seq"));

					updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewEqrRepoExeSoIfUSQL(), param, param);
					if (updCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update SQL");
					}
				}
				/***** EMPTY REPO인 경우 EQR_REPO_EXE_SO_IF로 UPDATE 끝 *****/
			}
			flgSelectRs.beforeFirst();
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

		return flgSelectRs;
	}

	/**
	 * WorkOrderPreview의 데이타 모델을 DB에 저장한다.<br>
	 * 
	 * 1.211 N200906110140 [TRS] PB 214개발 및 W/O Cancel시 기 입력된 Appt, Deliv Time 삭제 요청
	 * 
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet addWorkOrderPreviewIssued(EsdTrs0024Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet checkInvRs = null;
		DBRowSet checkWrkOrdRs = null;
		DBRowSet kntRs = null;
		DBRowSet flgSelectRs = null;
		DBRowSet copSelectRs = null;
		DBRowSet emtSelectRs = null;
		DBRowSet scSelectRs = null;

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		String kntNo = "";
		int insCnt = 0;
		int updCnt = 0;
		int delCnt = 0;

		try {

			String woPrnUseFlg = wrkOrdPrvVO.getWoPrnUseFlg();
			String woEmlUseFlg = wrkOrdPrvVO.getWoEmlUseFlg();
			String woFaxUseFlg = wrkOrdPrvVO.getWoFaxUseFlg();
			String woEdiUseFlg = wrkOrdPrvVO.getWoEdiUseFlg();

			String cmdtDpUseFlg = wrkOrdPrvVO.getCmdtDpUseFlg();
			String preDisUseFlg = wrkOrdPrvVO.getPreDisUseFlg();
			String interUseFlg = wrkOrdPrvVO.getInterUseFlg();

			woPrnUseFlg = (woPrnUseFlg == null || "".equals(woPrnUseFlg)) ? "N" : "Y";
			woEmlUseFlg = (woEmlUseFlg == null || "".equals(woEmlUseFlg)) ? "N" : "Y";
			woFaxUseFlg = (woFaxUseFlg == null || "".equals(woFaxUseFlg)) ? "N" : "Y";
			cmdtDpUseFlg = (cmdtDpUseFlg == null || "".equals(cmdtDpUseFlg)) ? "N" : "Y";
			preDisUseFlg = (preDisUseFlg == null || "".equals(preDisUseFlg)) ? "N" : "Y";
			woEdiUseFlg = (woEdiUseFlg == null || "".equals(woEdiUseFlg)) ? "N" : "Y";
			interUseFlg = (interUseFlg == null || "".equals(interUseFlg)) ? "N" : "Y";

			/***** W/O ISSUE에서 PREVIEW CONFIRM 사이에 INVOICE AUDIT 여부 체크 시작 *****/
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			checkInvRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedChkInvAuditRSQL(), param, param);

			if (checkInvRs.next()) {
				throw new DAOException(new ErrorHandler("TRS50104").getMessage());
			}
			/***** W/O ISSUE에서 PREVIEW CONFIRM 사이에 INVOICE AUDIT 여부 체크 끝 *****/

			/***** TRS_TRSP_WRK_ORD,TRS_TRSP_WRK_ORD_HIS 처리 시작 *****/
			// TRS_TRSP_WRK_ORD 에 존재하는 데이터인지 확인
			param.clear();
			param.put("trsp_wo_ofc_cty_cd", wrkOrdPrvVO.getTrspWoOfcCtyCd());
			param.put("trsp_wo_seq", wrkOrdPrvVO.getTrspWoSeq());
			checkWrkOrdRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedChkWrkOrdRSQL(), param, param);

			param.clear();
			param.put("trsp_wo_ofc_cty_cd", wrkOrdPrvVO.getTrspWoOfcCtyCd());
			param.put("trsp_wo_seq", wrkOrdPrvVO.getTrspWoSeq());
			param.put("wo_iss_sts_cd", wrkOrdPrvVO.getWoIssStsCd());
			param.put("wo_fmt_tp_cd", wrkOrdPrvVO.getWoFmtTpCd());
			param.put("wo_vndr_seq", wrkOrdPrvVO.getWoVndrSeq());
			param.put("wo_cntc_pson_nm", wrkOrdPrvVO.getWoCntcPsonNm());
			param.put("wo_prn_use_flg", woPrnUseFlg);
			param.put("wo_fax_use_flg", woFaxUseFlg);
			param.put("wo_eml_use_flg", woEmlUseFlg);
			param.put("wo_edi_use_flg", woEdiUseFlg);
			param.put("wo_n1st_fax_no", wrkOrdPrvVO.getWoN1stFaxNo());
			param.put("wo_n2nd_fax_no", wrkOrdPrvVO.getWoN2ndFaxNo());
			param.put("wo_n3rd_fax_no", wrkOrdPrvVO.getWoN3rdFaxNo());
			param.put("wo_n1st_eml", wrkOrdPrvVO.getWoN1stEml());
			param.put("wo_n2nd_eml", wrkOrdPrvVO.getWoN2ndEml());
			param.put("wo_n3rd_eml", wrkOrdPrvVO.getWoN3rdEml());
			param.put("wo_rmk", wrkOrdPrvVO.getWoRmk());
			param.put("rt_dp_use_flg", wrkOrdPrvVO.getRtDpUseFlg());
			param.put("cmdt_dp_use_flg", cmdtDpUseFlg);
			param.put("pre_dis_use_flg", preDisUseFlg);
			param.put("inter_use_flg", interUseFlg);
			param.put("cre_ofc_cd", event.getFormUsrOfcCd());
			param.put("cre_usr_id", event.getFormCreUsrId());
			param.put("upd_usr_id", event.getFormCreUsrId());
			param.put("usr_ofc_cd", event.getFormUsrOfcCd());

			if (checkWrkOrdRs.next()) {
				// TRS_TRSP_WRK_ORD UPDATE
				updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedWrkOrdUSQL(), param, param);
				if (updCnt == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to update SQL");
				}
			} else {
				// TRS_TRSP_WRK_ORD INSERT
				insCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedWrkOrdCSQL(), param, param);
				if (insCnt == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
				}
			}
			if (!"DF".equals(wrkOrdPrvVO.getDraftFlg())) {
				// wo_iss_knt 구하기 (param : trsp_wo_ofc_cty_cd, trsp_wo_seq)
				kntRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedGetWoIssKntRSQL(), param, param);
				while (kntRs.next()) {
					kntNo = kntRs.getString("knt");
				}
				// INSERT(param : trs_trsp_wrk_ord 에 입력된 데이터에 이어서 사용)
				param.put("wo_iss_knt", kntNo);
				insCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewWrkOrdHisCSQL(), param, param);
				if (insCnt == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
				}
			}
			/***** TRS_TRSP_WRK_ORD,TRS_TRSP_WRK_ORD_HIS 처리 끝 *****/

			// TRS_TRSP_SVC_ORD UPDATE
			param.clear();
			param.put("trsp_wo_ofc_cty_cd", wrkOrdPrvVO.getTrspWoOfcCtyCd());
			param.put("trsp_wo_seq", wrkOrdPrvVO.getTrspWoSeq());
			param.put("vndr_seq", wrkOrdPrvVO.getWoVndrSeq());
			param.put("upd_usr_id", event.getFormCreUsrId());
			param.put("usr_ofc_cd", event.getFormUsrOfcCd());
			param.put("conti_cd", wrkOrdPrvVO.getContiCd());
			param.put("wo_edi_use_flg", woEdiUseFlg);
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());
			param.put("trs_sub_sts_cd", wrkOrdPrvVO.getDraftFlg());
			param.put("wo_iss_sts_cd", wrkOrdPrvVO.getWoIssStsCd());

			new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOInsertTrsSubStsHisCSQL(), param, param);
			updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSvcOrdUSQL(), param, param);
			if (updCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}

			// TRS_TRSP_WRK_ORD_PRV_TMP UPDATE
			param.clear();
			param.put("trsp_wo_ofc_cty_cd", wrkOrdPrvVO.getTrspWoOfcCtyCd());
			param.put("trsp_wo_seq", wrkOrdPrvVO.getTrspWoSeq());
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedWrkOrdPrvTmpUSQL(), param, param);
			if (updCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
			/***** cancel된 wo에 대한 처리 시작 *****/
			param.clear();
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSvcOrdCnclUSQL(), param, param);
			if (updCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}

			param.clear();
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			delCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedScgDtlCnclDSQL(), param, param);
			if (delCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
			}

			param.clear();
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			delCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedScgDtlZeroDSQL(), param, param);
			if (delCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
			}
			/***** cancel된 wo에 대한 처리 끝 *****/

			/***** cancel된 wo에 해당하는 Internal Remark 삭제 처리 시작 *****/
			// 2015.05.19 CHAN WOO PARK
			param.clear();
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());
			param.put("wo_no", wrkOrdPrvVO.getTrspWoOfcCtyCd() + wrkOrdPrvVO.getTrspWoSeq());
			param.put("usr_ofc_cd", event.getFormUsrOfcCd());

			delCnt = new SQLExecuter("DEFAULT").executeUpdate(new InternalRemarkPopupDBDAOUpdateInternalRemarkVObySoWoUSQL(), param, param);
			if (delCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
			/***** cancel된 wo에 해당하는 Internal Remark 삭제 처리 종료 *****/

			/***** TEMP TABLE에서 TRS_TRSP_SVC_ORD TABLE로 UPDATE할 데이타 가져오기 시작(cancel data 제외) *****/
			param.clear();
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			flgSelectRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedWrkOrdPrvTmpRSQL(), param, param);
			while (flgSelectRs.next()) {
				param.clear();
				param.put("wo_bl_no_iss_flg", flgSelectRs.getString("wo_bl_no_iss_flg"));
				param.put("dtn_use_flg", flgSelectRs.getString("dtn_use_flg"));
				param.put("curr_cd", flgSelectRs.getString("curr_cd"));
				param.put("bzc_amt", flgSelectRs.getString("bzc_amt"));
				param.put("nego_amt", flgSelectRs.getString("nego_amt"));
				param.put("etc_add_amt", flgSelectRs.getString("etc_add_amt"));
				param.put("fuel_scg_amt", flgSelectRs.getString("fuel_scg_amt"));
				param.put("ovr_wgt_scg_amt", flgSelectRs.getString("ovr_wgt_scg_amt"));
				param.put("n3pty_bil_flg", flgSelectRs.getString("n3pty_bil_flg"));
				param.put("cust_nomi_trkr_flg", flgSelectRs.getString("cust_nomi_trkr_flg"));
				param.put("trsp_agmt_rt_tp_cd", flgSelectRs.getString("trsp_agmt_rt_tp_cd"));
				param.put("trsp_agmt_wy_tp_cd", flgSelectRs.getString("trsp_agmt_wy_tp_cd"));
				param.put("trsp_frst_flg", flgSelectRs.getString("trsp_frst_flg"));
				param.put("trsp_rjct_rsn_cd", flgSelectRs.getString("trsp_rjct_rsn_cd"));
				param.put("trsp_dflt_vndr_flg", flgSelectRs.getString("trsp_dflt_vndr_flg"));
				param.put("n1st_nod_pln_dt", flgSelectRs.getString("n1st_nod_pln_dt"));
				param.put("lst_nod_pln_dt", flgSelectRs.getString("lst_nod_pln_dt"));
				param.put("dor_nod_pln_dt", flgSelectRs.getString("dor_nod_pln_dt"));
				param.put("inter_rmk", flgSelectRs.getString("inter_rmk"));
				param.put("spcl_instr_rmk", flgSelectRs.getString("spcl_instr_rmk"));
				param.put("fctry_nm", flgSelectRs.getString("fctry_nm"));
				param.put("dor_pst_cd", flgSelectRs.getString("dor_pst_cd"));
				param.put("cntc_pson_phn_no", flgSelectRs.getString("cntc_pson_phn_no"));
				param.put("cntc_pson_fax_no", flgSelectRs.getString("cntc_pson_fax_no"));
				param.put("cntc_pson_nm", flgSelectRs.getString("cntc_pson_nm"));
				param.put("trsp_so_ofc_cty_cd", flgSelectRs.getString("trsp_so_ofc_cty_cd"));
				param.put("trsp_so_seq", flgSelectRs.getString("trsp_so_seq"));
				param.put("n3pty_bil_bzc_amt", flgSelectRs.getString("n3pty_bil_bzc_amt"));
				param.put("n3pty_vndr_seq", flgSelectRs.getString("n3pty_vndr_seq"));
				param.put("n3pty_ofc_cd", flgSelectRs.getString("n3pty_ofc_cd"));
				param.put("n3pty_desc", flgSelectRs.getString("n3pty_desc"));
				param.put("n3pty_cust_seq", flgSelectRs.getString("n3pty_cust_seq"));
				param.put("n3pty_cust_cnt_cd", flgSelectRs.getString("n3pty_cust_cnt_cd"));
				param.put("n3pty_bil_tp_cd", flgSelectRs.getString("n3pty_bil_tp_cd"));
				param.put("n3pty_curr_cd", flgSelectRs.getString("n3pty_curr_cd"));

				param.put("wgt_meas_ut_cd", flgSelectRs.getString("wgt_meas_ut_cd"));
				param.put("cntr_kgs_wgt", flgSelectRs.getString("cntr_kgs_wgt"));
				param.put("cntr_lbs_wgt", flgSelectRs.getString("cntr_lbs_wgt"));
				param.put("cgo_tp_cd", flgSelectRs.getString("cgo_tp_cd"));
				param.put("cntr_pkup_no", flgSelectRs.getString("cntr_pkup_no"));
				param.put("scg_ind_cd", flgSelectRs.getString("scg_ind_cd"));

				updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSvcOrdFromTmpUSQL(), param, param);
				if (updCnt == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to update SQL");
				}

				/***** SURCHARGE TEMP TABLE에서 SURCHARGE TABLE로 INSERT 시작 *****/
				// SURCHARGE SELECT
				param.clear();
				param.put("wo_prv_grp_seq", wrkOrdPrvVO.getScgGrpSeq());
				param.put("trsp_so_ofc_cty_cd", flgSelectRs.getString("trsp_so_ofc_cty_cd"));
				param.put("trsp_so_seq", flgSelectRs.getString("trsp_so_seq"));

				scSelectRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedScgDtlTmpRSQL(), param, param);

				if (scSelectRs.next()) {

					// SURCHARGE DELETE
					param.clear();
					param.put("trsp_so_ofc_cty_cd", flgSelectRs.getString("trsp_so_ofc_cty_cd"));
					param.put("trsp_so_seq", flgSelectRs.getString("trsp_so_seq"));

					delCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedScgDtlDSQL(), param, param);
					if (delCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to delete SQL");
					}

					// SURCHARGE INSERT
					param.clear();
					param.put("wo_prv_grp_seq", wrkOrdPrvVO.getScgGrpSeq());
					param.put("trsp_so_ofc_cty_cd", flgSelectRs.getString("trsp_so_ofc_cty_cd"));
					param.put("trsp_so_seq", flgSelectRs.getString("trsp_so_seq"));
					param.put("usr_ofc_cd", event.getFormUsrOfcCd());

					insCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedScgDtlCSQL(), param, param);
					if (insCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert SQL");
					}
					/***** SURCHARGE TEMP TABLE에서 SURCHARGE TABLE로 INSERT 끝 *****/
				}
			}
			/***** TEMP TABLE에서 TRS_TRSP_SVC_ORD TABLE로 UPDATE할 데이타 가져오기 끝(cancel data 제외) *****/

			/***** cop update 시작 *****/
			if (!"DF".equals(wrkOrdPrvVO.getDraftFlg())) {
				param.clear();
				param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
				param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());
				copSelectRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedWrkOrdPrvTmpCopRSQL(), param, param);
				while (copSelectRs.next()) {
					// SCE_PLN_SO_LIST UPDATE
					param.clear();

					if ("Y".equals(copSelectRs.getString("trsp_frst_flg"))) {
						param.put("trsp_so_sts_cd", "F");
					} else if ("B".equals(copSelectRs.getString("trsp_rjct_rsn_cd")) && "Y".equals(copSelectRs.getString("wo_cxl_flg"))) {
						param.put("trsp_so_sts_cd", "D");
					} else if (!"B".equals(copSelectRs.getString("trsp_rjct_rsn_cd")) && "Y".equals(copSelectRs.getString("wo_cxl_flg"))) {
						param.put("trsp_so_sts_cd", "C");
					} else {
						param.put("trsp_so_sts_cd", "I");
					}

					param.put("trsp_so_ofc_cty_cd", copSelectRs.getString("trsp_so_ofc_cty_cd"));
					param.put("trsp_so_seq", copSelectRs.getString("trsp_so_seq"));
					param.put("wo_cxl_flg", copSelectRs.getString("wo_cxl_flg"));

					updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedScePlnSoListUSQL(), param, param);
					if (updCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update SQL");
					}
				}

				/***** cop update 시작 *****/

				/***** EMPTY REPO인 경우 EQR_REPO_EXE_SO_IF로 UPDATE 시작 *****/
				param.clear();
				param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
				param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());
				param.put("wo_cxl_flg", wrkOrdPrvVO.getWoCxlFlg());

				emtSelectRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedEmptyContainerRSQL(), param, param);

				while (emtSelectRs.next()) {
					param.clear();
					param.put("cre_ofc_cd", event.getFormUsrOfcCd());
					param.put("cre_usr_id", event.getFormCreUsrId());
					param.put("repo_cost_amt", emtSelectRs.getString("tot_amt"));
					param.put("repo_pln_id", emtSelectRs.getString("repo_pln_id"));
					param.put("pln_yrwk", emtSelectRs.getString("pln_yrwk"));
					param.put("ref_id", emtSelectRs.getString("ref_id"));
					param.put("ref_seq", emtSelectRs.getString("ref_seq"));
					param.put("wo_cxl_flg", wrkOrdPrvVO.getWoCxlFlg());

					updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedEqrRepoExeSoIfUSQL(), param, param);
					if (updCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update SQL");
					}
				}
				/***** EMPTY REPO인 경우 EQR_REPO_EXE_SO_IF로 UPDATE 끝 *****/

				param.clear();
				param.put("cre_ofc_cd", event.getFormUsrOfcCd());
				param.put("cre_usr_id", event.getFormCreUsrId());
				param.put("upd_usr_id", event.getFormCreUsrId());
				param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
				param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

				insCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedRjctHisCSQL(), param, param);
				if (insCnt == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
				}
				copSelectRs.beforeFirst();
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

		return copSelectRs;
	};

	/**
	 * WorkOrderPreview의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException 1.198 N200902240180 [TRS] TPB 대상 건 I/F 가능 시점 추가 요청 (09.03.17)
	 */
	public TPBInterfaceVO[] searchTrs3PtyIF(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		TPBInterfaceVO[] models1 = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();
			TPBInterfaceVO model1 = null;

			int updCnt = 0;
			int insCnt = 0;

			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOSearchTrs3PtyIFSvcOrdUSQL(), param, param);
			if (updCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}

			param.clear();
			param.put("trsp_if_ofc_cd", event.getFormUsrOfcCd());
			param.put("cre_usr_id", event.getFormCreUsrId());
			param.put("upd_usr_id", event.getFormCreUsrId());
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());
			param.put("usr_ofc_cd", event.getFormUsrOfcCd());

			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOSearchTrs3PtyIFCSQL(), param, param);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}

			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOSearchTrs3PtyIFBzCSQL(), param, param);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}

			param.clear();
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchTrs3PtyIFRSQL(), param, param);

			if (dRs != null) {
				models1 = new TPBInterfaceVO[dRs.getRowCount()];
				int i = 0;
				while (dRs.next()) {
					// model1 = new TrsN3rdPtyIfVO();
					model1 = new TPBInterfaceVO();
					model1.setTrspIfOfcCd(dRs.getString("trsp_if_ofc_cd"));
					model1.setTrspIfSeq(dRs.getString("trsp_if_seq"));
					models1[i++] = model1;
				}
			}

			param.clear();
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOSearchTrs3PtyIFUSQL(), param, param);
			if (updCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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

		return models1;
	}

	/**
	 * WorkOrderPreview의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public TPBInterfaceVO[] searchTrs3PtyIFCxl(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		TPBInterfaceVO[] models1 = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();
			TPBInterfaceVO model1 = null;

			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchTrs3PtyIFCxlRSQL(), param, param);

			if (dRs != null) {

				int i = 0;
				models1 = new TPBInterfaceVO[dRs.getRowCount()];

				while (dRs.next()) {
					model1 = new TPBInterfaceVO();
					model1.setTrspIfOfcCd(dRs.getString("trsp_if_ofc_cd"));
					model1.setTrspIfSeq(dRs.getString("trsp_if_seq"));
					models1[i++] = model1;
				}
			}

			int updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOSearchTrs3PtyIFCxlUSQL(), param, param);
			if (updCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return models1;
	}

	/**
	 * WorkOrderPreview의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public TPBInterfaceVO[] searchTrs3PtyIFList(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		TPBInterfaceVO[] models = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchTrs3PtyIFListRSQL(), param, param);

			TPBInterfaceVO model = null;

			if (dRs != null) {

				int i = 0;
				models = new TPBInterfaceVO[dRs.getRowCount()];

				while (dRs.next()) {
					model = new TPBInterfaceVO();
					model.setTrspIfOfcCd(dRs.getString("trsp_so_ofc_cty_cd"));
					model.setTrspIfSeq(dRs.getString("trsp_so_seq"));
					models[i++] = model;
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return models;
	}

	/**
	 * WorkOrderPreview의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSoByPrvTmp(EsdTrs0024Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());
			return new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchSoByPrvTmpRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * WorkOrderPreview의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet checkSoChanged(EsdTrs0024Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());
			return new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOAddWorkOrderPreviewChkDupleRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * WorkOrderPreview의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSoByPrvTmpSnd(EsdTrs0024Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());
			return new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchSoByPrvTmpSndRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * WorkOrderPreview의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEdiSendingList(EsdTrs0024Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());
			return new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchEdiSendingListRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * WorkOrderPreview EDI 가능 조건 조회한다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchWorkOrderPreviewEdiCondChk(EsdTrs0024Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();
			param.put("vndr_seq", wrkOrdPrvVO.getWoVndrSeq());
			param.put("trsp_cost_dtl_mod_cd", wrkOrdPrvVO.getTrspCostDtlModCd());
			param.put("fm_nod_cd", wrkOrdPrvVO.getWoIssNo());
			param.put("to_nod_cd", wrkOrdPrvVO.getWoIssNo());
			param.put("conti_cd", wrkOrdPrvVO.getContiCd());
			return new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchWorkOrderPreviewEdiCondChkRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * WorkOrderPreview EDI 가능 조건 조회한다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEdiResendCondChk(EsdTrs0024Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();
			param.put("vndr_seq", wrkOrdPrvVO.getWoVndrSeq());
			return new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchEdiResendCondChkRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * WorkOrderPreview의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSODeleteCheck(EsdTrs0024Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());
			return new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchDeleteSoCheckRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * WorkOrderPreview의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchBkgCancelList(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOsearchBkgCancelListRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * WorkOrderPreview의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEdiSendingListBySO(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

			param.put("edi_trsp_so_ofc_cty_cd", wrkOrdPrvVO.getEdiTrspSoOfcCtyCd());
			param.put("edi_trsp_so_seq", wrkOrdPrvVO.getEdiTrspSoSeq());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchEdiSendingListBySORSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;

	}

	/**
	 * WorkOrderPreview의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEdiSendingListByWO(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

			param.put("trsp_wo_ofc_cty_cd", wrkOrdPrvVO.getEdiTrspWoOfcCtyCd());
			param.put("trsp_wo_seq", wrkOrdPrvVO.getEdiTrspWoSeq());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchEdiSendingListByWORSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;

	}

	/**
	 * WorkOrderPreview의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEdiResendList(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String trspWoOfcCtyCd = "";
		String trspWoSeq = "";

		try {
			TrsTrspWrkOrdPrvTmpVO wrkOrdPrvVO = event.getTrsTrspWrkOrdPrvTmpVO();

			trspWoOfcCtyCd = wrkOrdPrvVO.getTrspWoOfcCtyCd();

			if (trspWoOfcCtyCd != null && trspWoOfcCtyCd.length() > 3) {
				trspWoSeq = trspWoOfcCtyCd.substring(3);
				trspWoOfcCtyCd = trspWoOfcCtyCd.substring(0, 3);
			}
			param.put("TRSP_WO_OFC_CTY_CD", trspWoOfcCtyCd);
			param.put("TRSP_WO_SEQ", trspWoSeq);

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOsearchEdiResenListRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;

	}

	/**
	 * EDI FLAT FILE LAYOUT 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEdiLayoutList(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

			param.put("edi_vndr_seq", wrkOrdPrvVO.getEdiFltCd());
			param.put("flt_file_no", wrkOrdPrvVO.getFltFileNo());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchEdiLayoutListRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * EDI FLAT FILE LAYOUT 목록을 가져온다.<br>
	 * 
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUsaEdiLayoutList() throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchUsaEdiLayoutListRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * EDI FLAT FILE LAYOUT 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEdiInquiryList(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String trspWoOfcCtyCd = null;
		String trspWoSeq = null;

		TrsTrspWrkOrdVO wrkOrdPrvVO = event.getTrsTrspWrkOrdVO();
		trspWoOfcCtyCd = wrkOrdPrvVO.getTrspWoOfcCtyCd();

		if (trspWoOfcCtyCd != null && trspWoOfcCtyCd.length() > 3) {
			trspWoSeq = trspWoOfcCtyCd.substring(3);
			trspWoOfcCtyCd = trspWoOfcCtyCd.substring(0, 3);
		}

		try {

			param.put("trsp_wo_ofc_cty_cd", trspWoOfcCtyCd);
			param.put("trsp_wo_seq", trspWoSeq);

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchEdiInquiryListRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * FAX, EMAIL NO를 저장한다.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void addFaxAndEmailNo(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		String woFaxUseFlg = null;
		String woEmlUseFlg = null;
		int updCnt = 0;
		int updCnt2 = 0;

		try {
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOAddFaxAndEmailNoRSQL(), param, param);

			woFaxUseFlg = wrkOrdPrvVO.getWoFaxUseFlg();
			woEmlUseFlg = wrkOrdPrvVO.getWoEmlUseFlg();

			if (dRs.next()) {

				if (woFaxUseFlg != null && woFaxUseFlg.equals("FAX")) {

					param.put("fax_no_01", wrkOrdPrvVO.getFaxNo01());
					param.put("fax_no_02", wrkOrdPrvVO.getFaxNo02());
					param.put("fax_no_03", wrkOrdPrvVO.getFaxNo03());
					param.put("trsp_wo_ofc_cty_cd", dRs.getString("trsp_wo_ofc_cty_cd"));
					param.put("trsp_wo_seq", dRs.getString("trsp_wo_seq"));

					updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddFaxAndEmailNoFaxUSQL(), param, param);
					updCnt2 = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddFaxAndEmailNoFaxHisUSQL(), param, param);
					if (updCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to delete SQL");
					}
					if (updCnt2 == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to delete SQL");
					}
				}

				if (woEmlUseFlg != null && woEmlUseFlg.equals("EML")) {

					param.put("eml_no_01", wrkOrdPrvVO.getEmlNo01());
					param.put("eml_no_02", wrkOrdPrvVO.getEmlNo02());
					param.put("eml_no_03", wrkOrdPrvVO.getEmlNo03());
					param.put("trsp_wo_ofc_cty_cd", dRs.getString("trsp_wo_ofc_cty_cd"));
					param.put("trsp_wo_seq", dRs.getString("trsp_wo_seq"));

					updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddFaxAndEmailNoEmlUSQL(), param, param);
					updCnt2 = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddFaxAndEmailNoEmlHisUSQL(), param, param);
					if (updCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to delete SQL");
					}
					if (updCnt2 == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to delete SQL");
					}
				}
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
	 * WO NO 를 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchWoNo(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		try {

			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchWoNoRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * WO NO 를 가져온다.<br>
	 * 
	 * @param event
	 * @return SingleTransportationVO[]
	 * @throws DAOException
	 */
	public SingleTransportationVO[] searchDeleteSoList(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();
		SingleTransportationVO[] models = null;
		SingleTransportationVO model = null;

		try {
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchDeleteSoListRSQL(), param, param);

			if (dRs == null || dRs.getRowCount() < 1)
				return null;

			models = new SingleTransportationVO[dRs.getRowCount()];

			// for(int i=0; i<dRs.getRowCount(); i++){
			int i = 0;
			if (dRs != null && dRs.getRowCount() > 0) {
				while (dRs.next()) {
					model = new SingleTransportationVO();
					model.setIbflag("U");
					model.setCgoTpCd(JSPUtil.getNull(dRs.getString("cgo_tp_cd")));
					model.setTrspSoOfcCtyCd(JSPUtil.getNull(dRs.getString("trsp_so_ofc_cty_cd")));
					model.setTrspSoSeq(JSPUtil.getNull(dRs.getString("trsp_so_seq")));
					model.setTrspRqstBkgFlg(JSPUtil.getNull(dRs.getString("trsp_rqst_bkg_flg")));
					model.setUpdUsrId(JSPUtil.getNull(dRs.getString("upd_usr_id")));
					model.setCopNo(JSPUtil.getNull(dRs.getString("cop_no")));
					model.setCostActGrpSeq(JSPUtil.getNull(dRs.getString("cost_act_grp_seq")));
					model.setRepoPlnId(JSPUtil.getNull(dRs.getString("repo_pln_id")));
					model.setPlnYrwk(JSPUtil.getNull(dRs.getString("pln_yrwk")));
					model.setRefId(JSPUtil.getNull(dRs.getString("ref_id")));
					model.setRefSeq(JSPUtil.getNull(dRs.getString("ref_seq")));
					model.setRplnUmchFlg(JSPUtil.getNull(dRs.getString("rpln_umch_flg")));
					models[i] = model;
					i++;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return models;
	}

	/**
	 * RD Main Query 조회결과를 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchRdContentsMain(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		try {

			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchRdContentsMainRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * RD Main 하단 SUB 조회결과를 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchRdContentsMainSub(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		try {

			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchRdContentsMainSubRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * RD Main 하단 SUB 조회결과를 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchRdContentsCntrList(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		try {

			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchRdContentsCntrListRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * RD Main 하단 SUB 조회결과를 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchRdContentsSpecialCargoSummaryAwkward(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		try {

			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchRdContentsSpecialCargoSummaryAwkwardRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * RD Main 하단 SUB 조회결과를 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchRdContentsSpecialCargoSummaryReefer(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		try {

			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchRdContentsSpecialCargoSummaryReeferRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * RD Main 하단 SUB 조회결과를 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchRdContentsSpecialCargoSummaryDG(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		try {

			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchRdContentsSpecialCargoSummaryDGRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * EDI FLAT FILE LAYOUT 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEdiUsaTroMaster(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		try {

			param.put("trsp_so_ofc_cty_cd", wrkOrdPrvVO.getEdiTrspSoOfcCtyCd());
			param.put("trsp_so_seq", wrkOrdPrvVO.getEdiTrspSoSeq());
			param.put("wo_iss_sts_cd", wrkOrdPrvVO.getWoIssStsCd());
			param.put("conti_cd", wrkOrdPrvVO.getContiCd());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchEdiUsaTroMasterRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * EDI FLAT FILE LAYOUT 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEdiUsaTroPic(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		try {

			param.put("trsp_so_ofc_cty_cd", wrkOrdPrvVO.getEdiTrspSoOfcCtyCd());
			param.put("trsp_so_seq", wrkOrdPrvVO.getEdiTrspSoSeq());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchEdiUsaTroPicRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * EDI FLAT FILE LAYOUT 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEdiUsaTroCntr(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		try {

			param.put("trsp_so_ofc_cty_cd", wrkOrdPrvVO.getEdiTrspSoOfcCtyCd());
			param.put("trsp_so_seq", wrkOrdPrvVO.getEdiTrspSoSeq());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchEdiUsaTroCntrRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * EDI FLAT FILE LAYOUT 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEdiUsa01Cmdt(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		try {

			param.put("trsp_so_ofc_cty_cd", wrkOrdPrvVO.getEdiTrspSoOfcCtyCd());
			param.put("trsp_so_seq", wrkOrdPrvVO.getEdiTrspSoSeq());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchEdiUsa01CmdtRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * EDI FLAT FILE LAYOUT 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEdiUsaDangerCgo(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		try {

			param.put("trsp_so_ofc_cty_cd", wrkOrdPrvVO.getEdiTrspSoOfcCtyCd());
			param.put("trsp_so_seq", wrkOrdPrvVO.getEdiTrspSoSeq());
			param.put("trsp_bnd_cd", wrkOrdPrvVO.getTrspBndCd());
			param.put("trsp_cst_dtl_mod_cd", wrkOrdPrvVO.getTrspCostDtlModCd());
			param.put("conti_cd", wrkOrdPrvVO.getEdiLoc());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchEdiUsaDangerCgoRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * EDI FLAT FILE LAYOUT 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEdiUsaReeferCgo(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		try {

			param.put("trsp_so_ofc_cty_cd", wrkOrdPrvVO.getEdiTrspSoOfcCtyCd());
			param.put("trsp_so_seq", wrkOrdPrvVO.getEdiTrspSoSeq());
			param.put("cntr_no", wrkOrdPrvVO.getEdiEqNo());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchEdiUsaReeferCgoRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * EDI FLAT FILE LAYOUT 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEdiUsaAwkwardCgo(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		try {

			param.put("trsp_so_ofc_cty_cd", wrkOrdPrvVO.getEdiTrspSoOfcCtyCd());
			param.put("trsp_so_seq", wrkOrdPrvVO.getEdiTrspSoSeq());
			param.put("cntr_no", wrkOrdPrvVO.getEdiEqNo());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchEdiUsaAwkwardCgoRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * EDI FLAT FILE LAYOUT 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEdiUsaTrdAddr(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		try {

			param.put("trsp_so_ofc_cty_cd", wrkOrdPrvVO.getEdiTrspSoOfcCtyCd());
			param.put("trsp_so_seq", wrkOrdPrvVO.getEdiTrspSoSeq());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchEdiUsaTrdAddrRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * EDI FLAT FILE LAYOUT 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEdiUsaCust(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();

		try {

			param.put("trsp_so_ofc_cty_cd", wrkOrdPrvVO.getEdiTrspSoOfcCtyCd());
			param.put("trsp_so_seq", wrkOrdPrvVO.getEdiTrspSoSeq());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchEdiUsaCustRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * CONTI_CD 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchContiCd(EsdTrs0024Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			TrsTrspWrkOrdPrvTmpVO model = event.getTrsTrspWrkOrdPrvTmpVOs()[0];
			param.put("trsp_so_ofc_cty_cd", model.getTrspSoOfcCtyCd());
			param.put("trsp_so_seq", model.getTrspSoSeq());
			return new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchContiCdRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * HTML 에서 표현될 특수 문자(&amp;, \n, &nbsp;, &lt;, &gt;, &quot;) 처리
	 * 
	 * @param source
	 * @return String
	 */
	public String fromHtml(String source) {
		if (source == null) {
			return null;
		} else {
			source = replace(source, "@quot;", "\"");
			source = replace(source, "@ffd;", "\n");
			source = replace(source, "@cgrtn;", "\r");
			source = replace(source, "@acute;", "\'");
			source = replace(source, "@#44;", ",");
			source = replace(source, "@lt;", "<");
			source = replace(source, "@gt;", ">");
			source = replace(source, "@amp;", "&");
			source = replace(source, "@null;", " ");
			return source;
		}
	}

	/**
	 * @param source
	 * @return
	 */
	public String fromHtmlInt(String source) {
		if (source == null) {
			return null;
		} else {
			source = replace(source, "@null;", "");
			return source;
		}
	}

	/**
	 * @param source
	 * @param fromStr
	 * @param toStr
	 * @return
	 */
	public String replace(String source, String fromStr, String toStr) {
		if (source == null)
			return null;
		int start = 0;
		int end = 0;
		StringBuffer result = new StringBuffer();
		while ((end = source.indexOf(fromStr, start)) >= 0) {
			result.append(source.substring(start, end));
			result.append(toStr);
			start = end + fromStr.length();
		}
		result.append(source.substring(start));
		return result.toString();
	}

	/**
	 * vndr_seq 가 변경된 건들의 bkg_no 목록을 조회한다. <br>
	 * 
	 * @param event
	 * @return List<String>
	 * @throws DAOException
	 */
	public List<String> getBkgNoIfVndrChanged(EsdTrs0024Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		List<String> bkgNoList = new ArrayList<String>();
		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();
		try {
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());
			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOGetBkgNoIfVndrChangedRSQL(), param, param);
			while (dRs.next()) {
				String orgVndrSeq = null == dRs.getString("vndr_seq") ? "" : dRs.getString("vndr_seq");
				String currVndrSeq = wrkOrdPrvVO.getWoVndrSeq();
				if (null != currVndrSeq && !"".equals(currVndrSeq) && !currVndrSeq.equals(orgVndrSeq)) {
					bkgNoList.add(dRs.getString("bkg_no"));
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return bkgNoList;
	}

	/**
	 * WO NO 를 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public String searchWorkOrderNo(EsdTrs0024Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();
		try {
			String workOrderNo = "";
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());
			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchWorkOrderNoRSQL(), param, param);
			if (dRs.next()) {
				workOrderNo = dRs.getString("WO_NM");
			}
			return workOrderNo;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * 
	 * @param param
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchTrsTrspWrkOrdPreTmpByVendorCM(HashMap<String, Object> param) throws DAOException {
		try {
			return new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOSearchTrsTrspWrkOrdPreTmpByVendorCMRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * 
	 * @param param
	 * @return
	 * @throws DAOException
	 */
	public int updateTrsTrspWrkOrdPreTmpByVendorCM(HashMap<String, Object> param) throws DAOException {
		try {
			return new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOUpdateTrsTrspWrkOrdPreTmpByVendorCMUSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * WorkOrderPreview의 데이타 모델을 DB에 저장한다.<br>
	 * 
	 * 1.211 N200906110140 [TRS] PB 214개발 및 W/O Cancel시 기 입력된 Appt, Deliv Time 삭제 요청
	 * 
	 * @param WorkOrderPreviewVO wrkOrdPrvVO
	 * @param String iSoNO
	 * @return DBRowSet copSelectRs
	 * @throws DAOException
	 */
	public DBRowSet workOrderCancelByVendorCm(WorkOrderPreviewVO wrkOrdPrvVO, String iSoNO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet checkInvRs = null;
		DBRowSet copSelectRs = null;
		DBRowSet emtSelectRs = null;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		int updCnt = 0;
		int delCnt = 0;
		try {
			/***** W/O ISSUE에서 PREVIEW CONFIRM 사이에 INVOICE AUDIT 여부 체크 시작 *****/
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());
			param.put("so_no", iSoNO);
			param.put("usr_ofc_cd", wrkOrdPrvVO.getSoCreOfcCd());

			checkInvRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedChkInvAuditRSQL(), param, param);
			if (checkInvRs.next()) {
				throw new DAOException(new ErrorHandler("TRS50104").getMessage());
			}
			updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSvcOrdCnclUSQL(), param, param);
			if (updCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
			delCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedScgDtlCnclDSQL(), param, param);
			if (delCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
			}

			delCnt = new SQLExecuter("DEFAULT").executeUpdate(new InternalRemarkPopupDBDAOUpdateInternalRemarkVObySoWoUSQL(), param, param);
			if (delCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
			}

			/***** cop update 시작 *****/
			copSelectRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedWrkOrdPrvTmpCopRSQL(), param, param);
			while (copSelectRs.next()) {
				param.clear();
				if (copSelectRs.getString("trsp_frst_flg") != null && copSelectRs.getString("trsp_frst_flg").equals("Y")) {
					param.put("trsp_so_sts_cd", "F");
				} else if (copSelectRs.getString("trsp_rjct_rsn_cd") != null && copSelectRs.getString("trsp_rjct_rsn_cd").equals("B") && copSelectRs.getString("wo_cxl_flg") != null && copSelectRs.getString("wo_cxl_flg").equals("Y")) {
					param.put("trsp_so_sts_cd", "F");
				} else if (copSelectRs.getString("wo_cxl_flg").equals("Y")) {
					param.put("trsp_so_sts_cd", "C");
				} else {
					param.put("trsp_so_sts_cd", "I");
				}
				param.put("trsp_so_ofc_cty_cd", copSelectRs.getString("trsp_so_ofc_cty_cd"));
				param.put("trsp_so_seq", copSelectRs.getString("trsp_so_seq"));

				updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedScePlnSoListUSQL(), param, param);
				if (updCnt == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to update SQL");
				}
			}

			/***** cop update 시작 *****/

			/***** EMPTY REPO인 경우 EQR_REPO_EXE_SO_IF로 UPDATE 시작 *****/
			param.clear();
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());
			param.put("wo_cxl_flg", wrkOrdPrvVO.getWoCxlFlg());
			emtSelectRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedEmptyContainerRSQL(), param, param);
			while (emtSelectRs.next()) {
				param.clear();
				param.put("repo_cost_amt", emtSelectRs.getString("tot_amt"));
				param.put("repo_pln_id", emtSelectRs.getString("repo_pln_id"));
				param.put("pln_yrwk", emtSelectRs.getString("pln_yrwk"));
				param.put("ref_id", emtSelectRs.getString("ref_id"));
				param.put("ref_seq", emtSelectRs.getString("ref_seq"));
				param.put("wo_cxl_flg", wrkOrdPrvVO.getWoCxlFlg());

				// updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedEqrRepoExeSoIfUSQL(), param, param);
				// if (updCnt == Statement.EXECUTE_FAILED) {
				// throw new DAOException("Fail to update SQL");
				// }
			}
			/***** EMPTY REPO인 경우 EQR_REPO_EXE_SO_IF로 UPDATE 끝 *****/

			param.clear();
			// param.put("cre_ofc_cd", event.getFormUsrOfcCd());
			// param.put("cre_usr_id", event.getFormCreUsrId());
			// param.put("upd_usr_id", event.getFormCreUsrId());
			// param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			// param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());

			// insCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedRjctHisCSQL(), param, param);
			// if (insCnt == Statement.EXECUTE_FAILED) {
			// throw new DAOException("Fail to insert SQL");
			// }
			// copSelectRs.beforeFirst();

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

		return copSelectRs;
	}

	/**
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchWorkOrderInquiryPreview(EsdTrs0024Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		SQLExecuter sqlExecuter = new SQLExecuter("DEFAULT");
		DBRowSet seqRs = null;
		try {
			if (!CheckUtilities.isInBlank(event.getpWoNo())) {
				param.put("trsp_wo_ofc_cty_cd", event.getpWoNo().substring(0, 3));
				param.put("trsp_wo_seq", event.getpWoNo().substring(3));
				if (CheckUtilities.isInBlank(event.getPwoPrvGrpSeq())) {
					seqRs = sqlExecuter.executeQuery(new WorkOrderPreviewDBDAOSearchWorkOrderPreviewTmpSeqRSQL(), param, param);
					seqRs.next();
					param.put("wo_prv_grp_seq", seqRs.getString("group_seq"));
					// INSERT TRS_TRSP_WRK_ORD_PRV_TMP
					sqlExecuter.executeUpdate(new WorkOrderPreviewDBDAOAddTrsTrspWrkOrdPrvTmpForInquiryCSQL(), param, param);
					// INSERT TRS_TRSP_SCG_DTL_TMP
					sqlExecuter.executeUpdate(new WorkOrderPreviewDBDAOAddTrsTrspScgDtlTmpForInquiryCSQL(), param, param);
				} else {
					param.put("wo_prv_grp_seq", event.getPwoPrvGrpSeq());
				}
				//
				seqRs = sqlExecuter.executeQuery(new WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssueStatusRSQL(), param, param);
			}
			return seqRs;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * 
	 * @param HashMap<String, Object> param
	 * @throws DAOException
	 */
	public void manageTrsTrspWrkOrdByVendorCM(HashMap<String, Object> param) throws DAOException {
		try {
			new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOManageTrsTrspWrkOrdByVendorCMUSQL(), param, param);
			new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderPreviewDBDAOManageTrsTrspWrkOrdHisByVendorCMCSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}
}