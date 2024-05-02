/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WorkOrderIssueDBDAO.java
 *@FileTitle : W/O 발행화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011-02-10
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2006-11-21 poong_yeon
 * 1.0 최초 생성
 * 1.112 N200901090011 W/O Issue 화면 보완요청
 * 1.114 CHM-200900431 Customer Code 입력가능요청(09.08.24)
 * 1.54 2010.09.09 이재위 [SRM-201008617] [TRS] More candidate 조회 조건 수정 / (2) S/P select default 값 정정 요청 CSR
 * 1.55 2010.11.22 이재위 [CHM-201005356-01] [TRS] RD CNTR 의 Usage Rate 변경 요청
 * 1.6  2010.12.28 민정호 [CHM-201008042] AGMT 적용시 Customer Nominated 적용
 * 1.7  2011.02.10 민정호 [CHM-201108602] [TRS]미주지역 Appt./Deli. time update 기능 추가
 * 2011.04.28 손은주 [CHM-201109770-01][TRS] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용가능성 검토요청 (US Rail surcharge 기능 연계)
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.clt.apps.opus.esd.trs.common.util.CommonUtil;
import com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.integration.SurchargeInputInquiryDBDAOsearchSurchargeInputInquiryListByAgreementRSQL;
import com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.integration.SurchargeInputInquiryDBDAOsearchSurchargeInputInquirySumByAgreementRSQL;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event.EsdTrs0023Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event.EsdTrs0921Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event.EsdTrs0977Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.SearchTrsSvcOrdBkgChmHisVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.TrsChgMgmtBkgVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.WoIssueListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * ESD-workordermanage에 대한 DB 처리를 담당<br>
 * - ESD-workordermanage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * @author poong_yeon
 * @see WorkOrderIssueBCImpl 참조
 * @since J2EE 1.4
 */
public class WorkOrderIssueDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = -3273871077454241154L;

	/**
	 * WorkOrderIssue의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param EsdTrs0023Event event
	 * @return GeneralEventResponse eventResponse
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public GeneralEventResponse searchWorkOrderIssueList(EsdTrs0023Event event) throws DAOException {
		String strEqTpSz = "D2,D4,D5,D7,R2,R4,R5,F2,F4,F5,O2,O4,A2,A4,S2,S4";
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dRs = null;
		DBRowSet rs2 = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		List<WoIssueListVO> list = new ArrayList<WoIssueListVO>();
		Map outProc = null;
		String bilCurrCd = null;

		String form_usr_ofc_cd = event.getFormUsrOfcCd();
		String wo_radio = event.getWoRadio();
		String dt_radio = event.getDtRadio();
		String fmdate = event.getFmdate();
		String todate = event.getTodate();
		String combo_svc_provider = event.getComboSvcProvider();
		String wo_no = event.getWoNo();
		String trs_bnd_cd = event.getTrsBndCd();
		String trs_cost_md_cd = event.getTrsCostMdCd();
		String trs_md_cd = event.getTrsMdCd();
		String trs_so_tp_cd = event.getTrsSoTpCd();
		String fm_nod = event.getFmNod();
		String to_nod = event.getToNod();
		String dor_nod = event.getDorNod();
		String via_nod = event.getViaNod();
		String tvvd_no = event.getTvvdNo();
		String fvvd_no = event.getFvvdNo();
		String f_vvd_radio = event.getFVvdRadio();
		String bkg_no = event.getBkgNo();
		String bl_no = event.getBlNo();
		String eq_radio = event.getEqRadio();
		String eq_no = event.getEqNo();
		String so_no = event.getSoNo();
		String keepSoNos = event.getKeepSoNos();
		String mty_rfrn_no = event.getMtyRfrnNo();

		String wo_iss_sts_cd = event.getWoIssStsCd();
		String dor_arr_dt = event.getDorArrDt();
		String dor_arr_tm = event.getDorArrTm();
		String dor_pst_cd = event.getDorPstCd();
		String fm_lcc_cd = event.getFmLccCd();
		String to_lcc_cd = event.getToLccCd();
		String ecc_cd = event.getEccCd();
		String input_office = event.getInputOffice();
		String cop_no = event.getCopNo();
		String ruoh = event.getRuoh();
		String cgo_tp_cd = event.getCgoTpCd();
		String eq_tpsz_cd = event.getEqTpszCd();
		String cntr_slt_no = event.getCntrSltNo();

		param.put("wo_iss_sts_cd", wo_iss_sts_cd);
		param.put("dor_arr_dt", dor_arr_dt);
		param.put("dor_arr_tm", dor_arr_tm);
		param.put("dor_pst_cd", CommonUtil.seperationParameter(dor_pst_cd, ","));

		param.put("fm_lcc_cd", CommonUtil.seperationParameter(fm_lcc_cd, ","));
		param.put("to_lcc_cd", CommonUtil.seperationParameter(to_lcc_cd, ","));
		param.put("ecc_cd", CommonUtil.seperationParameter(ecc_cd, ","));

		param.put("input_office", CommonUtil.seperationParameter(input_office, ","));
		param.put("cop_no", CommonUtil.seperationParameter(cop_no, ","));
		param.put("ruoh", ruoh);
		param.put("cgo_tp_cd", CommonUtil.seperationParameter(cgo_tp_cd, ","));
		param.put("eq_tpsz_cd", CommonUtil.seperationParameter(eq_tpsz_cd, ","));
		param.put("spcl_cgo_cntr_tp_cd", CommonUtil.seperationParameter(event.getSpclCgCntrTpCd(), ","));
		param.put("form_usr_ofc_cd", form_usr_ofc_cd);
		param.put("wo_radio", wo_radio);
		param.put("dt_radio", dt_radio);
		param.put("fmdate", JSPUtil.removeCharacter(fmdate, "-"));
		param.put("todate", JSPUtil.removeCharacter(todate, "-"));
		param.put("combo_svc_provider", combo_svc_provider);
		param.put("wo_no", CommonUtil.seperationParameter(wo_no, ","));
		param.put("trs_bnd_cd", trs_bnd_cd);
		param.put("trs_cost_md_cd", trs_cost_md_cd);
		param.put("trs_md_cd", trs_md_cd);
		param.put("cust_cnt_cd", "");
		param.put("cust_seq", "");
		param.put("defalutCurr", "");
		param.put("trs_so_tp_cd", trs_so_tp_cd);
		param.put("fm_nod", fm_nod);
		param.put("to_nod", to_nod);
		param.put("dor_nod", dor_nod);
		param.put("via_nod", via_nod);
		param.put("trs_chg_tp_cd", event.getTrsChgTpCd());
		param.put("user_id", event.getUserId());

		param.put("tvvd_no", CommonUtil.seperationParameter(tvvd_no, ","));
		param.put("fvvd_no", CommonUtil.seperationParameter(fvvd_no, ","));
		param.put("f_vvd_radio", f_vvd_radio);
		param.put("eq_radio", eq_radio);
		param.put("bkg_no", CommonUtil.seperationParameter(bkg_no, ","));
		param.put("bl_no", CommonUtil.seperationParameter(bl_no, ","));
		param.put("eq_no", CommonUtil.seperationParameter(eq_no, ","));
		param.put("so_no", CommonUtil.seperationParameter(so_no, ","));
		param.put("cop_flg", event.getCopFlg());
		param.put("mty_rfrn_no", CommonUtil.seperationParameter(mty_rfrn_no, ","));
		param.put("trs_sub_sts_cd", CommonUtil.seperationParameter(event.getTrsSubStsCd(), ","));
		param.put("cntr_slt_no", CommonUtil.seperationParameter(cntr_slt_no, ","));
		param.put("cnmv_sts_cd", event.getCnmvStsCd());
		param.put("crnt_yd_cd", event.getCrntYdCd());

		param.put("src_keep_flg", event.getSrcKeepFlg());
		param.put("keep_so_no", CommonUtil.seperationParameter(keepSoNos, ","));

		ArrayList<String> initSoNoArrs = new ArrayList<String>();
		if (event.getInitTrspSoOfcCtyCd() != null && event.getInitTrspSoSeq() != null) {
			ArrayList<String> initTrspSoOfcCtyCdArrs = CommonUtil.seperationParameter(event.getInitTrspSoOfcCtyCd(), ",");
			ArrayList<String> initTrspSoSeqArrs = CommonUtil.seperationParameter(event.getInitTrspSoSeq(), ",");
			for (int i = 0; i < initTrspSoOfcCtyCdArrs.size(); i++) {
				initSoNoArrs.add(i, initTrspSoOfcCtyCdArrs.get(i) + initTrspSoSeqArrs.get(i));
			}
		}
		param.put("init_sono_arrs", initSoNoArrs);
		try {
			param.put("OFC_CD", form_usr_ofc_cd);
			rs2 = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchCurrCdRSQL(), param, param);
			if (rs2 != null) {
				while (rs2.next()) {
					bilCurrCd = JSPUtil.getNull(rs2.getString("BIL_CURR_CD"));
				}
			}
			param.put("BIL_CURR_CD", bilCurrCd != null ? bilCurrCd : "");
			List<WoIssueListVO> woModel = null;
			if (wo_radio.equals("Y")) {
				dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchWorkOrderIssuedYesListRSQL(), param, param);
				woModel = (List) RowSetUtil.rowSetToVOs(dRs, WoIssueListVO.class);
			} else if (wo_radio.equals("N")) {
				dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchWorkOrderIssueListRSQL(), param, param);
				woModel = (List) RowSetUtil.rowSetToVOs(dRs, WoIssueListVO.class);
			} else {
				param.put("wo_radio", "Y");
				dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchWorkOrderIssuedYesListRSQL(), param, param);
				woModel = (List) RowSetUtil.rowSetToVOs(dRs, WoIssueListVO.class);

				param.put("wo_radio", "N");
				dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchWorkOrderIssueListRSQL(), param, param);
				woModel.addAll((List) RowSetUtil.rowSetToVOs(dRs, WoIssueListVO.class));
			}

			Collections.sort(woModel, new Comparator<WoIssueListVO>() {
				public int compare(WoIssueListVO arg0, WoIssueListVO arg1) {
					return arg1.getCngIndFlg().compareTo(arg0.getCngIndFlg());
				}
			});

			String creDtStr = null;
			String trspCostDtlModCd = null;
			String vndrSeqStr = null;
			String defalutCurrStr = null;

			String trspSoTpCd = null;
			String trspDfltVndrFlg = null;
			Map<String, String> cntEqTpSzHm = new HashMap<String, String>();
			double ttlWgtKgs = 0.0d;
			double ttlWgtLbs = 0.0d;
			int ttlTeu = 0;
			int ttlFeu = 0;
			if (woModel != null) {
				for (int m = 0; m < woModel.size(); m++) {
					WoIssueListVO woModel2 = woModel.get(m);
					// EQ Type Size
					if (strEqTpSz.indexOf(woModel2.getEqTpszCd()) > -1) {
						if (cntEqTpSzHm.containsKey(woModel2.getEqTpszCd().toLowerCase())) {
							cntEqTpSzHm.put(woModel2.getEqTpszCd().toLowerCase(), String.valueOf(Integer.parseInt(cntEqTpSzHm.get(woModel2.getEqTpszCd().toLowerCase())) + 1));
						} else {
							cntEqTpSzHm.put(woModel2.getEqTpszCd().toLowerCase(), "1");
						}
						// Total Weight KGS
						ttlWgtKgs += Double.parseDouble(CheckUtilities.checkNullAndReturnString(woModel2.getKgsGrossWgt(), "0"));
						// Total Weight LBS
						ttlWgtLbs += Double.parseDouble(CheckUtilities.checkNullAndReturnString(woModel2.getLbsGrossWgt(), "0"));

						if (woModel2.getEqTpszCd().endsWith("2")) {
							ttlTeu++;
						} else {
							ttlFeu++;
						}
					}

					if ("Y".equals(woModel2.getWoIssued()) || "X".equals(woModel2.getWoIssStsCd())) {
						continue;
					}
					trspSoTpCd = woModel2.getTrspSoTpCd();
					creDtStr = woModel2.getCreDt();
					trspCostDtlModCd = woModel2.getTrspCostDtlModCd();
					trspDfltVndrFlg = woModel2.getTrspDfltVndrFlg();
					vndrSeqStr = woModel2.getVndrSeq();
					if (!"S".equals(woModel2.getTrspSoTpCd())) {
						param.clear();
						param.put("CRE_OFC_CD", woModel2.getCreOfcCd());
						param.put("VNDR_CD", woModel2.getVndrSeq());
						param.put("CRE_DT", creDtStr.substring(0, 8));
						param.put("WY_TP_CD", woModel2.getTrspAgmtWyTpCd());
						param.put("EQ_KND_CD", woModel2.getEqKndCd());
						param.put("EQ_TPSZ_CD", woModel2.getEqTpszCd());
						param.put("TRSP_SO_CMB_TP_CD", woModel2.getTrspSoCmbTpCd());
						// 2016.02.26 when Revenue Empty Container is Y, apply Empty Rate even though Cargo Type is Full
						if (woModel2.getRvnMptCntr().equalsIgnoreCase("Y")) {
							param.put("CGO_TP_CD", "M");
						} else {
							param.put("CGO_TP_CD", woModel2.getCgoTpCd());
						}
						param.put("TRSP_BND_CD", woModel2.getTrspBndCd());
						param.put("TRSP_CRR_MOD_CD", woModel2.getTrspCrrModCd());
						param.put("TRSP_COST_DTL_MOD_CD", woModel2.getTrspCostDtlModCd());
						param.put("CUST_NOMI_TRKR_FLG", woModel2.getCustNomiTrkrFlg());
						param.put("CUST_CNT_CD", woModel2.getCustCntCd());
						param.put("CUST_SEQ", woModel2.getCustSeq());
						param.put("RAIL_SSVC_TP_CD", "");
						param.put("CMDT_CD", woModel2.getCmdtCd());
						param.put("FM_NOD_CD", woModel2.getFmNodCd());
						param.put("VIA_NOD_CD", woModel2.getViaNodCd());
						param.put("DOR_NOD_CD", woModel2.getDorNodCd());
						param.put("TO_NOD_CD", woModel2.getToNodCd());
						param.put("BUNDLING_NO", woModel2.getBundlingNo());
						// param.put("WGT_MEAS_UT_CD", woModel2.getWgtMeasUtCd());
						param.put("WGT_MEAS_UT_CD", "KG");
						// param.put("CNTR_WGT", woModel2.getCntrWgt());
						param.put("CNTR_WGT", CheckUtilities.isInBlank(woModel2.getKgsNetWgt()) ? "0" : woModel2.getKgsNetWgt().trim());
						param.put("WTR_RCV_TERM", "");
						param.put("WTR_DE_TERM", event.getWtrDeTerm());
						param.put("SPCL_CGO_CNTR_TP_CD", woModel2.getSpclCgoCntrTpCd());

						outProc = new SQLExecuter("DEFAULT").executeSP((ISQLTemplate) new WorkOrderIssueDBDAOsearchWorkOrderIssueListProcRSQL(), param, param);

						woModel2.setPoTrspAgmtOfcCtyCd(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_ofc_cty_cd")));
						woModel2.setPoTrspAgmtSeq(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_seq")));
						woModel2.setPoTrspAgmtRtTpCd(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_rt_tp_cd")));
						woModel2.setPoWayType(JSPUtil.getNull((String) outProc.get("po_way_type")));
						woModel2.setPoTrspAgmtRtTpNm(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_rt_tp_nm")));
						woModel2.setPoCustNomiTrkrFlg(JSPUtil.getNull((String) outProc.get("po_cust_nomi_trkr_flg")));
						woModel2.setPoCustCntCd(JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd")));
						woModel2.setPoCustSeq(JSPUtil.getNull((String) outProc.get("po_cust_seq")));
						woModel2.setPoCustCntCdSeq(JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd_seq")));
						defalutCurrStr = JSPUtil.getNull((String) outProc.get("po_local_curr_cd"));
						if (defalutCurrStr == null || defalutCurrStr.equals("")) {
							defalutCurrStr = JSPUtil.getNull((String) woModel2.getCurrCd());
						}
						woModel2.setPoLocalCurrCd(defalutCurrStr);
						woModel2.setPoBasicRt(JSPUtil.getNull((String) outProc.get("po_basic_rt")));
						woModel2.setPoFuelScgRt(JSPUtil.getNull((String) outProc.get("po_fuel_scg_rt")));
						woModel2.setPoOverWgtScgRt(JSPUtil.getNull((String) outProc.get("po_over_wgt_scg_rt")));
						woModel2.setPoLocalCurrTotAmt(JSPUtil.getNull((String) outProc.get("po_local_curr_tot_amt")));
						woModel2.setPoUsdCurrTotAmt(JSPUtil.getNull((String) outProc.get("po_usd_curr_tot_amt")));
						woModel2.setPoRtnCd(JSPUtil.getNull((String) outProc.get("po_rtn_cd")));
						woModel2.setPoRtnMsg(JSPUtil.getNull((String) outProc.get("po_rtn_msg")));
						if (!"ER".equals(trspCostDtlModCd) && vndrSeqStr != null && !vndrSeqStr.equals("") && CheckUtilities.isInBlank(woModel2.getDefaultSpFlg())) {
							woModel2.setTrspDfltVndrFlg("Y");
						} else {
							woModel2.setTrspDfltVndrFlg(CheckUtilities.isNullOrNullStringReplacement(woModel2.getDefaultSpFlg(), "N"));
						}
						mapVO = woModel2.getColumnValues();
						param.putAll(mapVO);
						if (!"".equals(woModel2.getPoTrspAgmtSeq()) && woModel2.getPoTrspAgmtSeq() != null) {
							dRs = new SQLExecuter().executeQuery(new SurchargeInputInquiryDBDAOsearchSurchargeInputInquirySumByAgreementRSQL(), param, param);
							if (dRs.next()) {
								woModel2.setEtcAddAmt(JSPUtil.getNull(dRs.getString("etc_add_amt"), "0.00"));
							} else {
								woModel2.setEtcAddAmt("0.00");
							}
						} else {
							woModel2.setEtcAddAmt("0.00");
						}
					} else {
						woModel2.setPoBasicRt(CheckUtilities.isNullReplacement(woModel2.getPoBasicRt(), "0.00"));
						woModel2.setPoFuelScgRt(CheckUtilities.isNullReplacement(woModel2.getPoFuelScgRt(), "0.00"));
						woModel2.setPoOverWgtScgRt(CheckUtilities.isNullReplacement(woModel2.getPoOverWgtScgRt(), "0.00"));
						woModel2.setPoLocalCurrTotAmt(CheckUtilities.isNullReplacement(woModel2.getPoLocalCurrTotAmt(), "0.00"));
						woModel2.setPoUsdCurrTotAmt(CheckUtilities.isNullReplacement(woModel2.getPoUsdCurrTotAmt(), "0.00"));
						woModel2.setEtcAddAmt(CheckUtilities.isNullReplacement(woModel2.getEtcAddAmt(), "0.00"));
					}
					double d = Double.parseDouble(CheckUtilities.isNullOrNullStringReplacement(woModel2.getPoBasicRt(), "0"))
							+ Double.parseDouble(CheckUtilities.isNullOrNullStringReplacement(woModel2.getNegoAmt(), "0"))
							+ Double.parseDouble(CheckUtilities.isNullOrNullStringReplacement(woModel2.getPoFuelScgRt(), "0"))
							+ Double.parseDouble(CheckUtilities.isNullOrNullStringReplacement(woModel2.getEtcAddAmt(), "0"));
					if (!CheckUtilities.isInBlank(woModel2.getPoLocalCurrCd()) && !"USD".equals(woModel2.getPoLocalCurrCd()) && d > 0) {
						param.put("LOCAL_TOT_AMT", d);
						param.put("CURR_CD", woModel2.getPoLocalCurrCd());
						param.put("FORM_USR_OFC_CD", event.getFormUsrOfcCd());
						dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchLocalCurr2UsdCurrRSQL(), param, param);
						if (dRs.next()) {
							d = dRs.getDouble(1);
						}
					}
					woModel2.setPoUsdCurrTotAmt(String.valueOf(d));
					woModel.set(m, woModel2);
				}
			}
			list.addAll(woModel);
			eventResponse.setRsVoList(list);
			DecimalFormat nf = new DecimalFormat("#,##0.000");
			eventResponse.setETCData("ttlwgtkgs", nf.format((Math.round(ttlWgtKgs * 1000d) / 1000d)));
			eventResponse.setETCData("ttlwgtlbs", nf.format((Math.round(ttlWgtLbs * 1000d) / 1000d)));
			eventResponse.setETCData("ttlteu", String.valueOf(ttlTeu));
			eventResponse.setETCData("ttlfeu", String.valueOf(ttlFeu));
			eventResponse.setETCData("ttlbox", String.valueOf(ttlTeu + ttlFeu));
			eventResponse.setETCData(cntEqTpSzHm);
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
	 * 가져온다.<br>
	 * @param event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AbstractValueObject> searchTrsSvcOrdBkgChmHis(EsdTrs0977Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList tempArrL = new ArrayList();
		List<AbstractValueObject> rlit = new ArrayList<AbstractValueObject>();
		try {
			WoIssueListVO[] woIssueListVOs = event.getWoIssueListVOs();

			if (woIssueListVOs != null) {
				for (int i = 0; i < woIssueListVOs.length; i++) {
					StringBuilder tempValue = new StringBuilder();
					tempValue.append("(");
					tempValue.append("'").append(woIssueListVOs[i].getTrspSoOfcCtyCd()).append("',");
					tempValue.append("'").append(woIssueListVOs[i].getTrspSoSeq()).append("',");
					tempValue.append("'").append(woIssueListVOs[i].getBkgNo()).append("')");
					if (i != woIssueListVOs.length - 1) {
						tempValue.append(",");
					}
					tempArrL.add(tempValue.toString());
				}
			}
			if (tempArrL.size() > 0) {
				velParam.put("trsp_so_bkg", tempArrL);
			}
			rlit = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOSearchTrsSvcOrdBkgChmHisRSQL(), param, velParam, SearchTrsSvcOrdBkgChmHisVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return rlit;
	}

	/**
	 * 가져온다.<br>
	 * @param event
	 * @throws DAOException
	 */
	public void updateTrsSvcOrdBkgChmHis(EsdTrs0977Event event) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			SearchTrsSvcOrdBkgChmHisVO[] searchTrsSvcOrdBkgChmHisVOs = event.getSearchTrsSvcOrdBkgChmHisVOs();
			String usrId = event.getSignOnUserAccount().getUsr_id();
			SearchTrsSvcOrdBkgChmHisVO preVo = null;
			for (int i = 0; i < searchTrsSvcOrdBkgChmHisVOs.length; i++) {
				SearchTrsSvcOrdBkgChmHisVO vo = searchTrsSvcOrdBkgChmHisVOs[i];
				if (vo != null) {
					if ("U".equals(vo.getIbflag())) {
						if (i > 0 && preVo != null) {
							if (preVo.getTrspSoOfcCtyCd().equals(vo.getTrspSoOfcCtyCd()) && preVo.getTrspSoSeq().equals(vo.getTrspSoSeq())) {
								continue;
							}
						}
						if (!CheckUtilities.isInBlank(vo.getCngCateCd()) && !CheckUtilities.isInBlank(vo.getCngCateSubCd())) {
							param.put("bkg_no", vo.getBkgNo());
							param.put("trsp_so_ofc_cty_cd", vo.getTrspSoOfcCtyCd());
							param.put("trsp_so_seq", vo.getTrspSoSeq());
							param.put("trsp_so_sub_seq", vo.getTrspSoSubSeq());
							param.put("trsp_cng_sub_seq", vo.getTrspCngSubSeq());
							param.put("cng_cate_cd", vo.getCngCateCd());
							param.put("cng_cate_sub_cd", vo.getCngCateSubCd());
							param.put("upd_usr_id", usrId);
							new SQLExecuter().executeSP(new WorkOrderIssueDBDAOUpdateTrsChgSoSyncPrcUSQL(), param, null);
						}
					}
				}
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
	}

	/**
	 * WorkOrderIssue의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param event
	 * @return GeneralEventResponse
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GeneralEventResponse searchWorkOrderIssueBySoNo(EsdTrs0023Event event) throws DAOException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dRs = null;
		DBRowSet rs2 = null;
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList<String> arrSoNoA = new ArrayList();
		List<WoIssueListVO> list = new ArrayList<WoIssueListVO>();
		Map outProc = null;
		String bilCurrCd = null;
		String defalutCurrStr = null;

		String form_usr_ofc_cd = event.getFormUsrOfcCd();
		String trspSoOfcCtyCd = event.getTrspSoOfcCtyCd();
		String trspSoSeq = event.getTrspSoSeq();
		String spTpCd = event.getSpTpCd();
		String vndrCd = event.getVndrCd();

		ArrayList<String> inputOfcArr = null;
		if (!trspSoOfcCtyCd.equals("") && !trspSoOfcCtyCd.equals("null") && trspSoOfcCtyCd != null) {
			inputOfcArr = CommonUtil.seperationParameter(trspSoOfcCtyCd, ",");
		}
		ArrayList<String> inputSeqArr = null;
		if (!trspSoSeq.equals("") && !trspSoSeq.equals("null") && trspSoSeq != null) {
			inputSeqArr = CommonUtil.seperationParameter(trspSoSeq, ",");
		}

		if (trspSoOfcCtyCd != null && trspSoSeq != null) {
			for (int i = 0; i < inputSeqArr.size(); i++) {
				arrSoNoA.add(i, inputOfcArr.get(i) + inputSeqArr.get(i));
			}
		}

		param.put("form_usr_ofc_cd", form_usr_ofc_cd);
		param.put("so_no", arrSoNoA);
		try {
			param.put("OFC_CD", form_usr_ofc_cd);
			rs2 = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchCurrCdRSQL(), param, param);
			if (rs2 != null) {
				while (rs2.next()) {
					bilCurrCd = JSPUtil.getNull(rs2.getString("BIL_CURR_CD"));
				}
			}
			param.put("BIL_CURR_CD", bilCurrCd);
			param.put("SP_TP_CD", spTpCd);
			param.put("VNDR_CD", vndrCd);

			// 2015.04.23 CHAN WOO PARK
			String trspCostDtlModCd = null;
			String vndrSeqStr = null;

			// S/O No. 로 S/O 검색
			dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchWorkOrderIssueBySoNoRSQL(), param, param);
			List<WoIssueListVO> woModel = (List) RowSetUtil.rowSetToVOs(dRs, WoIssueListVO.class);
			WoIssueListVO woModel2 = null;
			for (int m = 0; woModel != null && m < woModel.size(); m++) {
				param.clear();
				woModel2 = woModel.get(m);
				if (woModel2 == null) {
					continue;
				}
				trspCostDtlModCd = woModel2.getTrspCostDtlModCd();
				vndrSeqStr = woModel2.getVndrSeq();
				param.put("CRE_OFC_CD", woModel2.getCreOfcCd());
				param.put("VNDR_CD", woModel2.getVndrSeq());
				param.put("CRE_DT", woModel2.getCreDt().substring(0, 8));
				param.put("WY_TP_CD", woModel2.getTrspAgmtWyTpCd());
				param.put("EQ_KND_CD", woModel2.getEqKndCd());
				param.put("EQ_TPSZ_CD", woModel2.getEqTpszCd());
				param.put("TRSP_SO_CMB_TP_CD", woModel2.getTrspSoCmbTpCd());
				param.put("CGO_TP_CD", woModel2.getCgoTpCd());
				param.put("TRSP_BND_CD", woModel2.getTrspBndCd());
				param.put("TRSP_CRR_MOD_CD", woModel2.getTrspCrrModCd());
				param.put("TRSP_COST_DTL_MOD_CD", woModel2.getTrspCostDtlModCd());
				param.put("CUST_NOMI_TRKR_FLG", woModel2.getCustNomiTrkrFlg());
				param.put("CUST_CNT_CD", woModel2.getCustCntCd());
				param.put("CUST_SEQ", woModel2.getCustSeq());
				param.put("RAIL_SSVC_TP_CD", "");
				param.put("CMDT_CD", woModel2.getCmdtCd());
				param.put("FM_NOD_CD", woModel2.getFmNodCd());
				param.put("VIA_NOD_CD", woModel2.getViaNodCd());
				param.put("DOR_NOD_CD", woModel2.getDorNodCd());
				param.put("TO_NOD_CD", woModel2.getToNodCd());
				param.put("BUNDLING_NO", woModel2.getBundlingNo());
				param.put("WGT_MEAS_UT_CD", woModel2.getWgtMeasUtCd());
				param.put("CNTR_WGT", woModel2.getCntrWgt());
				param.put("WTR_RCV_TERM", "");
				param.put("WTR_DE_TERM", event.getWtrDeTerm());
				param.put("SPCL_CGO_CNTR_TP_CD", woModel2.getSpclCgoCntrTpCd());
				outProc = new SQLExecuter("DEFAULT").executeSP((ISQLTemplate) new WorkOrderIssueDBDAOsearchWorkOrderIssueListProcRSQL(), param, param);
				woModel2.setPoTrspAgmtOfcCtyCd(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_ofc_cty_cd")));
				woModel2.setPoTrspAgmtSeq(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_seq")));
				woModel2.setPoTrspAgmtRtTpCd(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_rt_tp_cd")));
				woModel2.setPoWayType(JSPUtil.getNull((String) outProc.get("po_way_type")));
				woModel2.setPoTrspAgmtRtTpNm(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_rt_tp_nm")));
				// 2015.04.24 CHAN WOO PARK
				woModel2.setPoCustNomiTrkrFlg(JSPUtil.getNull((String) outProc.get("po_cust_nomi_trkr_flg")));
				woModel2.setPoCustCntCd(JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd")));
				woModel2.setPoCustSeq(JSPUtil.getNull((String) outProc.get("po_cust_seq")));
				woModel2.setPoCustCntCdSeq(JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd_seq")));
				defalutCurrStr = JSPUtil.getNull((String) outProc.get("po_local_curr_cd"));
				if (defalutCurrStr == null || "".equals(defalutCurrStr)) {
					defalutCurrStr = JSPUtil.getNull((String) woModel2.getCurrCd());
				}
				woModel2.setPoLocalCurrCd(defalutCurrStr);
				woModel2.setPoBasicRt(JSPUtil.getNull((String) outProc.get("po_basic_rt")));
				woModel2.setPoFuelScgRt(JSPUtil.getNull((String) outProc.get("po_fuel_scg_rt")));
				woModel2.setPoOverWgtScgRt(JSPUtil.getNull((String) outProc.get("po_over_wgt_scg_rt")));
				woModel2.setPoUsdCurrTotAmt(JSPUtil.getNull((String) outProc.get("po_usd_curr_tot_amt")));
				woModel2.setPoRtnCd(JSPUtil.getNull((String) outProc.get("po_rtn_cd")));
				woModel2.setPoRtnMsg(JSPUtil.getNull((String) outProc.get("po_rtn_msg")));

				// 2015.04.23 CHAN WOO PARK
				// Vendor가 존재할 경우 TRSP_DFLT_VNDR_FLG = 'Y'로 표시
				if (!"ER".equals(trspCostDtlModCd) && vndrSeqStr != null && !vndrSeqStr.equals("") && CheckUtilities.isInBlank(woModel2.getDefaultSpFlg())) {
					woModel2.setTrspDfltVndrFlg("Y");
				} else {
					woModel2.setTrspDfltVndrFlg(CheckUtilities.isNullOrNullStringReplacement(woModel2.getDefaultSpFlg(), "N"));
				}
				double d = Double.parseDouble(CheckUtilities.isNullOrNullStringReplacement(woModel2.getPoBasicRt(), "0"))
						+ Double.parseDouble(CheckUtilities.isNullOrNullStringReplacement(woModel2.getNegoAmt(), "0"))
						+ Double.parseDouble(CheckUtilities.isNullOrNullStringReplacement(woModel2.getPoFuelScgRt(), "0"))
						+ Double.parseDouble(CheckUtilities.isNullOrNullStringReplacement(woModel2.getEtcAddAmt(), "0"));
				if (!CheckUtilities.isInBlank(woModel2.getPoLocalCurrCd()) && !"USD".equals(woModel2.getPoLocalCurrCd()) && d > 0) {
					param.put("LOCAL_TOT_AMT", d);
					param.put("CURR_CD", woModel2.getPoLocalCurrCd());
					param.put("FORM_USR_OFC_CD", event.getFormUsrOfcCd());
					dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchLocalCurr2UsdCurrRSQL(), param, param);
					if (dRs.next()) {
						d = dRs.getDouble(1);
					}
				}
				woModel2.setPoUsdCurrTotAmt(String.valueOf(d));
				woModel.set(m, woModel2);
			}
			list.addAll(woModel);
			eventResponse.setRsVoList(list);

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
	 * WorkOrderIssue의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GeneralEventResponse searchSpSelectList(EsdTrs0023Event event) throws DAOException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList<String> arrSoNoA = new ArrayList<String>();
		List<WoIssueListVO> list = new ArrayList<WoIssueListVO>();

		// 2014.12.11 Added by Hyungwook Choi
		Map<String, String> mapVO = new HashMap<String, String>();

		Map outProc = null;
		String cnt = "";
		WoIssueListVO[] models = event.getWoIssueListVOs();
		String spTpCd = event.getSpTpCd();
		String vndrCd = event.getVndrCd();
		String creDtStr = null;

		int k = models.length;
		HashMap<String, String> hWeight = new HashMap<String, String>();
		for (int i = 0; k > i; i++) {
			arrSoNoA.add(i, models[i].getTrspSoOfcCtyCd() + models[i].getTrspSoSeq());
			hWeight.put(models[i].getTrspSoOfcCtyCd() + models[i].getTrspSoSeq(), CheckUtilities.isInBlank(models[i].getKgsNetWgt()) ? "0" : models[i].getKgsNetWgt().trim());
		}
		param.put("SO_NO", arrSoNoA);
		param.put("SP_TP_CD", spTpCd);
		param.put("VNDR_CD", vndrCd);
		param.put("cnt", cnt);

		try {
			dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchSpSelectListRSQL(), param, param);
			List<WoIssueListVO> woModel = (List) RowSetUtil.rowSetToVOs(dRs, WoIssueListVO.class);
			for (int m = 0; woModel != null && m < woModel.size(); m++) {
				WoIssueListVO woModel2 = woModel.get(m);
				param.put("CRE_OFC_CD", woModel2.getCreOfcCd());

				param.put("VNDR_CD", vndrCd);

				if (event.getBasisDt() == null || "".equals(event.getBasisDt())) {
					creDtStr = woModel2.getCreDt();
				} else {
					creDtStr = JSPUtil.replace(event.getBasisDt(), "-", "");
				}
				param.put("CRE_DT", creDtStr.substring(0, 8));
				param.put("WY_TP_CD", event.getWyTpCd());
				param.put("EQ_KND_CD", woModel2.getEqKndCd());
				param.put("EQ_TPSZ_CD", woModel2.getEqTpszCd());
				param.put("TRSP_SO_CMB_TP_CD", woModel2.getTrspSoCmbTpCd());
				if (woModel2.getRvnMptCntr().equals("Y")) {
					param.put("CGO_TP_CD", "M");
				} else {
					param.put("CGO_TP_CD", woModel2.getCgoTpCd());
				}
				param.put("TRSP_BND_CD", woModel2.getTrspBndCd());
				param.put("TRSP_CRR_MOD_CD", woModel2.getTrspCrrModCd());
				param.put("TRSP_COST_DTL_MOD_CD", woModel2.getTrspCostDtlModCd());
				if (event.getCustCntCd() == null) {
					param.put("CUST_NOMI_TRKR_FLG", "N");
					param.put("CUST_CNT_CD", "");
					param.put("CUST_SEQ", "");
				} else {
					param.put("CUST_NOMI_TRKR_FLG", "Y");
					param.put("CUST_CNT_CD", event.getCustCntCd());
					param.put("CUST_SEQ", event.getCustSeq());
				}

				param.put("CMDT_CD", woModel2.getCmdtCd());
				param.put("FM_NOD_CD", woModel2.getFmNodCd());
				param.put("VIA_NOD_CD", woModel2.getViaNodCd());
				param.put("DOR_NOD_CD", woModel2.getDorNodCd());
				param.put("TO_NOD_CD", woModel2.getToNodCd());
				param.put("BUNDLING_NO", woModel2.getBundlingNo());
				// param.put("WGT_MEAS_UT_CD", woModel2.getWgtMeasUtCd());
				// param.put("CNTR_WGT", woModel2.getCntrWgt());
				param.put("WGT_MEAS_UT_CD", "KG");
				if (hWeight.containsKey(woModel2.getTrspSoOfcCtyCd() + woModel2.getTrspSoSeq())) {
					param.put("CNTR_WGT", hWeight.get(woModel2.getTrspSoOfcCtyCd() + woModel2.getTrspSoSeq()));
				} else {
					param.put("CNTR_WGT", "0");
				}

				param.put("WTR_RCV_TERM", event.getWtrRcvTerm());
				param.put("WTR_DE_TERM", event.getWtrDeTerm());
				param.put("SPCL_CGO_CNTR_TP_CD", woModel2.getSpclCgoCntrTpCd());
				param.put("trsp_so_ofc_cty_cd", woModel2.getTrspSoOfcCtyCd());
				param.put("trsp_so_seq", woModel2.getTrspSoSeq());
				outProc = new SQLExecuter("DEFAULT").executeSP((ISQLTemplate) new WorkOrderIssueDBDAOsearchSpSelectListProcRSQL(), param, param);

				woModel2.setPoTrspAgmtOfcCtyCd(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_ofc_cty_cd")));
				woModel2.setPoTrspAgmtSeq(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_seq")));
				woModel2.setPoTrspAgmtRtTpCd(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_rt_tp_cd")));
				woModel2.setPoWayType(JSPUtil.getNull((String) outProc.get("po_way_type")));
				woModel2.setPoTrspAgmtRtTpNm(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_rt_tp_nm")));
				woModel2.setPoSpType(JSPUtil.getNull((String) outProc.get("po_sp_type")));
				woModel2.setPoCustNomiTrkrFlg(JSPUtil.getNull((String) outProc.get("po_cust_nomi_trkr_flg")));
				woModel2.setPoCustCntCd(JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd")));
				woModel2.setPoCustSeq(JSPUtil.getNull((String) outProc.get("po_cust_seq")));
				woModel2.setPoCustCntCdSeq(JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd_seq")));
				woModel2.setPoLocalCurrCd(JSPUtil.getNull((String) outProc.get("po_local_curr_cd")));
				woModel2.setPoBasicRt(JSPUtil.getNull((String) outProc.get("po_basic_rt")));
				woModel2.setPoFuelScgRt(JSPUtil.getNull((String) outProc.get("po_fuel_scg_rt")));
				woModel2.setPoOverWgtScgRt(JSPUtil.getNull((String) outProc.get("po_over_wgt_scg_rt")));
				woModel2.setPoLocalCurrTotAmt(JSPUtil.getNull((String) outProc.get("po_local_curr_tot_amt")));
				woModel2.setPoUsdCurrTotAmt(JSPUtil.getNull((String) outProc.get("po_usd_curr_tot_amt")));
				woModel2.setPoRtnCd(JSPUtil.getNull((String) outProc.get("po_rtn_cd")));
				woModel2.setPoRtnMsg(JSPUtil.getNull((String) outProc.get("po_rtn_msg")));

				// 2014.12.11 Added by Hyungwook Choi
				mapVO = woModel2.getColumnValues();
				param.putAll(mapVO);
				if (!"".equals(woModel2.getPoTrspAgmtSeq()) && woModel2.getPoTrspAgmtSeq() != null) {
					dRs = new SQLExecuter().executeQuery(new SurchargeInputInquiryDBDAOsearchSurchargeInputInquirySumByAgreementRSQL(), param, param);
					if (dRs.next()) {
						woModel2.setEtcAddAmt(JSPUtil.getNull(dRs.getString("etc_add_amt")));
					}
				}

				double d = Double.parseDouble(CheckUtilities.isNullOrNullStringReplacement(woModel2.getPoBasicRt(), "0"))
						+ Double.parseDouble(CheckUtilities.isNullOrNullStringReplacement(woModel2.getNegoAmt(), "0"))
						+ Double.parseDouble(CheckUtilities.isNullOrNullStringReplacement(woModel2.getPoFuelScgRt(), "0"))
						+ Double.parseDouble(CheckUtilities.isNullOrNullStringReplacement(woModel2.getEtcAddAmt(), "0"));
				if (!CheckUtilities.isInBlank(woModel2.getPoLocalCurrCd()) && !"USD".equals(woModel2.getPoLocalCurrCd()) && d > 0) {
					param.put("LOCAL_TOT_AMT", d);
					param.put("CURR_CD", woModel2.getPoLocalCurrCd());
					param.put("FORM_USR_OFC_CD", event.getFormUsrOfcCd());
					dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchLocalCurr2UsdCurrRSQL(), param, param);
					if (dRs.next()) {
						d = dRs.getDouble(1);
					}
				}
				woModel2.setPoUsdCurrTotAmt(String.valueOf(d));
				woModel.set(m, woModel2);
			}
			list.addAll(woModel);
			eventResponse.setRsVoList(list);
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
	 * Office의 Bill Currency Cd를 조회한다.<br>
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchMdmOrganization(EsdTrs0921Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String formUsrOfcCd = event.getFormUsrOfcCd();

		try {
			param.put("ofc_cd", formUsrOfcCd);
			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderIssueDBDAOSearchMdmOrganizationRSQL(), param, param);

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
	 * WorkOrderIssue의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchMoreCandidates(EsdTrs0921Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String basis_dt = (String) event.getBasisDt() == null ? "" : JSPUtil.removeCharacter((String) event.getBasisDt(), "-").substring(0, 8);
		param.put("trsp_so_ofc_cty_cd", event.getTrspSoOfcCtyCd());
		param.put("trsp_so_seq", event.getTrspSoSeq());
		param.put("ctrl_ofc_cd", event.getCtrlOfcCd());
		param.put("vndr_seq", event.getVndrSeq());
		param.put("basis_dt", basis_dt);
		param.put("eq_knd_cd", event.getEqKndCd());
		param.put("eq_tp_sz_cd", event.getEqTpSzCd());
		param.put("cmb_tp_cd", event.getCmbTpCd());
		param.put("cgo_tp_cd", event.getCgoTpCd());
		param.put("bound_cd", event.getBoundCd());
		param.put("crr_mod_cd", event.getCrrModCd());
		param.put("cost_mod_cd", event.getCostmodCd());
		param.put("cust_cnt_cd", event.getCustCntCd());
		param.put("cust_seq", event.getCustSeq());
		param.put("cmdt_cd", event.getCmdtCd());
		param.put("from_nod_cd", event.getFromNodCd());
		param.put("via_nod_cd", event.getViaNodCd());
		param.put("door_nod_cd", event.getDoorNodCd());
		param.put("to_nod_cd", event.getToNodCd());
		param.put("bundle_cnt", event.getBundleCnt());
		param.put("wgt_uom", event.getBundleCnt());
		param.put("wgt_qty", event.getWgtQty());
		param.put("wo_issued", event.getWoIssued());
		param.put("fm_vndr_prmry_seq", event.getFmVndrPrmrySeq());
		param.put("spcl_cgo_cntr_tp_cd", event.getSpclCgoCntrTpCd());
		param.put("trsp_agmt_ofc_cty_cd", event.getTrspAgmtOfcCtyCd());
		param.put("trsp_agmt_seq", event.getTrspAgmtSeq());

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderIssueDBDAOsearchMoreCandidatesRSQL(), param, param);
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
	 * @param event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLocalCurr2UsdCurr(EsdTrs0023Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			String localTotAmt = event.getLocalTotAmt();
			String currCd = event.getLocalCurrCd();
			String formUsrOfcCd = event.getFormUsrOfcCd();

			param.put("LOCAL_TOT_AMT", localTotAmt);
			param.put("CURR_CD", currCd);
			param.put("FORM_USR_OFC_CD", formUsrOfcCd);

			dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchLocalCurr2UsdCurrRSQL(), param, param);
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
	 * FRUSTRATE에 대한 처리를 한다.<br>
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList setFrustrate(EsdTrs0023Event event) throws DAOException {
		WoIssueListVO[] model = event.getWoIssueListVOs();
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList returnArray = new ArrayList();
		String form_cre_usr_id = event.getFormCreUsrId();
		try {
			if (model != null && model.length > 0) {
				for (int i = 0; i < model.length; i++) {
					param.put("form_cre_usr_id", form_cre_usr_id);
					param.put("trsp_so_ofc_cty_cd", model[i].getTrspSoOfcCtyCd());
					param.put("trsp_so_seq", model[i].getTrspSoSeq());

					new SQLExecuter().executeUpdate(new WorkOrderIssueDBDAOsetFrustrateSoUSQL(), param, param);
					new SQLExecuter().executeUpdate(new WorkOrderIssueDBDAOsetFrustrateSceUSQL(), param, param);
				}
			}
			return returnArray;
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
	}

	/**
	 * EDI FLAT FILE LAYOUT 목록을 가져온다.<br>
	 * @param woVO
	 * @return
	 * @throws DAOException
	 */
	public ArrayList<DBRowSet> searchSurchargeList(List<WoIssueListVO> woVO) throws DAOException {
		DBRowSet dRs = null;
		ArrayList<DBRowSet> returnArr = new ArrayList<DBRowSet>();
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList<String> arrSoNo = new ArrayList<String>();
		// 2014.12.11 Added by Hyungwook Choi
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			int m = woVO.size();
			String trspSoOfcCtyCd = null;
			String trspSoSeq = null;
			for (int i = 0; woVO != null && i < m; i++) {
				trspSoOfcCtyCd = woVO.get(i).getTrspSoOfcCtyCd();
				trspSoSeq = woVO.get(i).getTrspSoSeq();
				arrSoNo.add(i, trspSoOfcCtyCd + trspSoSeq);
			}
			param.put("SoNo", arrSoNo);
			dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchSurchargeListRSQL(), param, param);
			returnArr.add(dRs);

			// 2014.12.11 Added by Hyungwook Choi
			for (int j = 0; woVO != null && j < m; j++) {
				if ("Y".equals(woVO.get(j).getWoIssued()) || "DF".equals(woVO.get(j).getTrsSubStsCd())) {
					continue;
				}
				mapVO = woVO.get(j).getColumnValues();
				if (!"".equals(woVO.get(j).getPoTrspAgmtSeq()) && woVO.get(j).getPoTrspAgmtSeq() != null) {
					dRs = new SQLExecuter().executeQuery(new SurchargeInputInquiryDBDAOsearchSurchargeInputInquiryListByAgreementRSQL(), mapVO, mapVO);
				}
				returnArr.add(dRs);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return returnArr;
	}

	/**
	 * EDI FLAT FILE LAYOUT 목록을 가져온다.<br>
	 * @param scgRs
	 * @return ArrayList
	 * @throws DAOException
	 */
	public ArrayList<DBRowSet> searchSurchargeList(DBRowSet scgRs) throws DAOException {
		DBRowSet dRs = null;
		ArrayList<DBRowSet> returnArr = new ArrayList<DBRowSet>();
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList<String> arrSoNo = new ArrayList<String>();

		try {
			int i = 0;
			if (scgRs.getRowCount() > 0) {
				while (scgRs.next()) {
					String trspSoOfcCtyCd = scgRs.getString("TRSP_SO_OFC_CTY_CD");
					String trspSoSeq = scgRs.getString("TRSP_SO_SEQ");
					arrSoNo.add(i++, trspSoOfcCtyCd + trspSoSeq);
				}
				param.put("SoNo", arrSoNo);
				dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderIssueDBDAOsearchSurchargeListRSQL(), param, param);
				returnArr.add(dRs);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return returnArr;
	}

	/**
	 * 3RD PARTY BASIC INTERFACE BILLING CASE 목록을 가져온다.<br>
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchBillingCaseCode() throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchBillingCaseCodeRSQL(), param, param);
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
	 * 3RD PARTY BASIC INTERFACE 목록을 가져온다.<br>
	 * @param event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchTpbBasicAmt(EsdTrs0023Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {

			String trspSoOfcCtyCd = event.getTrspSoOfcCtyCd();
			String trspSoSeq = event.getTrspSoSeq();

			param.put("TRSP_SO_OFC_CTY_CD", trspSoOfcCtyCd);
			param.put("TRSP_SO_SEQ", trspSoSeq);

			dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchTpbBasicAmtRSQL(), param, param);
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
	 * Work Order Issued S/O NO 목록을 가져온다.<br>
	 * @param event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchWoIssuedSoList(EsdTrs0023Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {

			String wo_prv_grp_seq = event.getWoPrvGrpSeq();
			String wo_iss_no = event.getWoIssNo();

			param.put("wo_prv_grp_seq", wo_prv_grp_seq);
			param.put("wo_iss_no", wo_iss_no);

			dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchWoIssuedSoListRSQL(), param, param);
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
	 * TrspSubStsCd 수정한다.<br>
	 * @param voList
	 * @throws DAOException
	 */

	public void modifyTrspSubStsCd(List<TrsTrspSvcOrdVO> voList) throws DAOException {
		try {
			int insCnt[] = null;
			if (voList.size() > 0) {
				insCnt = new SQLExecuter().executeBatch((ISQLTemplate) new WorkOrderIssueDBDAOModifyTrspSubStsCdUSQL(), voList, null, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
				// Draft W/O인 경우 TRS_TRSP_WRK_ORD.WO_ISS_STS_CD = 'I'로 업데이트
				new SQLExecuter("").executeBatch((ISQLTemplate) new WorkOrderIssueDBDAOModifyWoIssStsCdUSQL(), voList, null, null);
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
	}

	/**
	 * INSERT TRS_SUB_STS_HIS
	 * @param voList
	 * @throws DAOException
	 */
	public void insertTrsSubStsHis(List<TrsTrspSvcOrdVO> voList) throws DAOException {
		try {
			if (voList.size() > 0) {
				new SQLExecuter().executeBatch((ISQLTemplate) new WorkOrderIssueDBDAOInsertTrsSubStsHisCSQL(), voList, null, null);
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
	}

	/**
	 * Work Order 상태값을 가져온다.<br>
	 * @param trspWoOfcCtyCd
	 * @param trspWoSeq
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public int searchWOStsCDCheck(String trspWoOfcCtyCd, String trspWoSeq) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		int cnt = 0;
		try {
			param.put("trsp_wo_ofc_cty_cd", trspWoOfcCtyCd);
			param.put("trsp_wo_seq", trspWoSeq);
			dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOSearchWOStsCDCheckRSQL(), param, param);
			if (dRs != null) {
				while (dRs.next()) {
					cnt = dRs.getInt("CNT");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return cnt;
	}

	/**
	 * @param trsChgMgmtBkgVO
	 * @throws DAOException
	 */
	public void insertTrsChgMgmtBkgPrc(TrsChgMgmtBkgVO trsChgMgmtBkgVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(trsChgMgmtBkgVO.getColumnValues());
			new SQLExecuter().executeSP(new WorkOrderIssueDBDAOInsertTrsChgMgmtBkgPrcCSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * updateCYContainerNo
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int updateCYContainerNo(WoIssueListVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(vo.getColumnValues());
			return new SQLExecuter().executeUpdate(new WorkOrderIssueDBDAOUpdateCYContainerNoUSQL(), param, param);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * S/O의 Booking No 가 변경되었을 경우 <br>
	 * Shipment C/M의 데이터를 변경 해줌.
	 * @param newBkgNos
	 * @throws DAOException
	 */
	public void updateShipmentCm(String[] newBkgNos) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			SQLExecuter executer = new SQLExecuter();
			if (newBkgNos != null) {
				Set<String> s = new HashSet<String>();
				for (int i = 0; i < newBkgNos.length; i++) {
					if (newBkgNos[i] == null || CheckUtilities.isInBlank(newBkgNos[i])) {
						continue;
					}
					if (!s.contains(newBkgNos[i])) {
						param.put("new_bkg_no", newBkgNos[i]);
						executer.executeSP(new WorkOrderIssueDBDAOUpdateShipmentCmUSQL(), param, param);
						s.add(newBkgNos[i]);
					}
				}
			} else {
				param.put("new_bkg_no", "");
				executer.executeSP(new WorkOrderIssueDBDAOUpdateShipmentCmUSQL(), param, param);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}
}
