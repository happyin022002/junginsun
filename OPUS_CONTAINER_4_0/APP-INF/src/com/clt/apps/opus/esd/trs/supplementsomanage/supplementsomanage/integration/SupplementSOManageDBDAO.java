/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : SupplementSOManageDBDAO.java
 *@FileTitle : Service Order 생성-Supplement
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-30
 *@LastModifier : juhyun
 *@LastVersion : 1.0
 * 2006-10-30 juhyun
 * 1.0 최초 생성
 * 1.1 Updated by 정상기 : 2007-02-28
 * N200903160120  2009-03-18 'Supplement S/O 조회조건 추가 '
 * 1.19 2010.11.22 이재위 [CHM-201005356-01] [TRS] RD CNTR 의 Usage Rate 변경 요청
=========================================================*/
package com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esd.trs.common.util.CommonUtil;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration.SingleTransportationSOManageDBDAOChangeChkSoStsCdRSQL;
import com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.vo.SurchargeVO;
import com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.basic.SupplementSOManageBCImpl;
import com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.event.EsdTrs0016Event;
import com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.vo.SupplementSearchVO;
import com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.vo.SupplementVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author juhyun
 * @see SupplementSOManageBCImpl 참조
 * @since J2EE 1.4
 */
public class SupplementSOManageDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 9080625155825529520L;

	/**
	 * SupplementSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public EventResponse searchSupplementSOTargetList(EsdTrs0016Event event) throws DAOException {
		SupplementSearchVO searchVO = event.getSupplementSearchVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dRs = null;
		List<HashMap<String, Object>> resultArrayList = null;

		Map<String, Object> param = new HashMap<String, Object>();

		String sonumberCheck = searchVO.getSonumber();
		String wonumberCheck = searchVO.getWonumber();
		String bkgnumberCheck = searchVO.getBkgnumber();
		String blnumberCheck = searchVO.getBlnumber();
		String eqnumberCheck = searchVO.getEqnumber();

		// 미반영건 --> 추가 검색조건 반영
		String vvdnumberCheck = searchVO.getVvdnumber();
		String refnumberCheck = searchVO.getRefnumber();
		String invnumberCheck = searchVO.getInvnumber();

		String loginUsrOfcCtyCd = searchVO.getFormUsrOfcCd() == null ? "" : searchVO.getFormUsrOfcCd().substring(0, 3);
		String fromDate = "ALL".equals(searchVO.getFromDate()) || "".equals(searchVO.getFromDate()) ? "" : JSPUtil.removeCharacter(searchVO.getFromDate(), "-");
		String toDate = "ALL".equals(searchVO.getToDate()) || "".equals(searchVO.getToDate()) ? "" : JSPUtil.removeCharacter(searchVO.getToDate(), "-");
		String hidBoundmode = "ALL".equals(searchVO.getHidBoundmode()) || "".equals(searchVO.getHidBoundmode()) ? "" : searchVO.getHidBoundmode();
		String hidCostmode = "ALL".equals(searchVO.getHidCostmode()) || "".equals(searchVO.getHidCostmode()) ? "" : searchVO.getHidCostmode();
		String hidTransmode = "ALL".equals(searchVO.getHidTransmode()) || "".equals(searchVO.getHidTransmode()) ? "" : searchVO.getHidTransmode();
		String hidProvider = "ALL".equals(searchVO.getHidProvider()) || "".equals(searchVO.getHidProvider()) ? "" : searchVO.getHidProvider();
		String hidFromNode = "ALL".equals(searchVO.getHidFromNode()) || "".equals(searchVO.getHidFromNode()) ? "" : searchVO.getHidFromNode();
		String hidViaNode = "ALL".equals(searchVO.getHidViaNode()) || "".equals(searchVO.getHidViaNode()) ? "" : searchVO.getHidViaNode();
		String hidToNode = "ALL".equals(searchVO.getHidToNode()) || "".equals(searchVO.getHidToNode()) ? "" : searchVO.getHidToNode();
		String hidDorNode = "ALL".equals(searchVO.getHidDorNode()) || "".equals(searchVO.getHidDorNode()) ? "" : searchVO.getHidDorNode();
		String hidKind = "ALL".equals(searchVO.getHidKind()) || "".equals(searchVO.getHidKind()) ? "" : searchVO.getHidKind();
		String hidEqRadio = "ALL".equals(searchVO.getHidEqRadio()) || "".equals(searchVO.getHidEqRadio()) ? "" : searchVO.getHidEqRadio();

		// 2009-03-12 CSR 추가 요청
		String hidPeriod = JSPUtil.getNull(String.valueOf(searchVO.getHidPeriod()));
		String hidTpSz = "ALL".equals(searchVO.getHidTpSz()) || "".equals(searchVO.getHidTpSz()) ? "" : searchVO.getHidTpSz();

		StringTokenizer st = null;

		try {
			List<SupplementSearchVO> arr = null;
			SupplementSearchVO tokenVO = null;
			String temp = "";
			int i = 0;

			if (vvdnumberCheck != null && !"".equals(vvdnumberCheck)) {

				st = new StringTokenizer(vvdnumberCheck, ",");
				arr = new ArrayList<SupplementSearchVO>();
				i = 0;

				while (st.hasMoreTokens()) {
					tokenVO = new SupplementSearchVO();
					temp = st.nextToken();
					if (temp.length() < 4)
						tokenVO.setVslCd(temp);
					else
						tokenVO.setVslCd("");
					if (temp.length() >= 4)
						tokenVO.setVslCd(temp.substring(0, 4));
					else
						tokenVO.setVslCd("");
					if (temp.length() >= 8)
						tokenVO.setSkdVoyNo(temp.substring(4, 8));
					else
						tokenVO.setSkdVoyNo("");
					if (temp.length() >= 9)
						tokenVO.setSkdDirCd(temp.substring(8, 9));
					else
						tokenVO.setSkdDirCd("");
					arr.add(i++, tokenVO);
				}
				param.put("vvdnumberArr", arr);
			}

			if (refnumberCheck != null && !"".equals(refnumberCheck)) {

				st = new StringTokenizer(refnumberCheck, ",");
				arr = new ArrayList<SupplementSearchVO>();
				i = 0;

				while (st.hasMoreTokens()) {
					tokenVO = new SupplementSearchVO();
					temp = st.nextToken();
					if (temp.length() < 15)
						tokenVO.setRefId(temp);
					;
					if (temp.length() >= 15)
						tokenVO.setRefId(temp.substring(0, 15));
					if (temp.length() >= 16)
						tokenVO.setRefSeq(temp.substring(15, temp.length()));
					arr.add(i++, tokenVO);
				}
				param.put("refnumberArr", arr);
			}

			if (sonumberCheck != null && !"".equals(sonumberCheck)) {

				st = new StringTokenizer(sonumberCheck, ",");
				arr = new ArrayList<SupplementSearchVO>();
				i = 0;

				while (st.hasMoreTokens()) {
					tokenVO = new SupplementSearchVO();
					temp = st.nextToken();
					if (temp.length() < 3)
						tokenVO.setTrspSoOfcCtyCd(temp);
					if (temp.length() >= 3) {
						tokenVO.setTrspSoOfcCtyCd(temp.substring(0, 3));
						tokenVO.setTrspSoSeq(temp.substring(3, temp.length()));
					}
					arr.add(i++, tokenVO);
				}
				param.put("sonumberArr", arr);
			}

			if (wonumberCheck != null && !"".equals(wonumberCheck)) {

				st = new StringTokenizer(wonumberCheck, ",");
				arr = new ArrayList<SupplementSearchVO>();
				i = 0;

				while (st.hasMoreTokens()) {
					temp = st.nextToken();
					tokenVO = new SupplementSearchVO();
					if (temp.length() < 3) {
						tokenVO.setTrspWoOfcCtyCd(temp);
						tokenVO.setTrspWoSeq(null);
					}
					if (temp.length() >= 3) {
						tokenVO.setTrspWoOfcCtyCd(temp.substring(0, 3));
						tokenVO.setTrspWoSeq(temp.substring(3, temp.length()));
					}
					arr.add(i++, tokenVO);
				}
				param.put("wonumberArr", arr);
			}

			param.put("invnumberArr", CommonUtil.seperationParameter(invnumberCheck, ","));
			param.put("bkgnumberArr", CommonUtil.seperationParameter(bkgnumberCheck, ","));
			param.put("blnumberArr", CommonUtil.seperationParameter(blnumberCheck, ","));
			param.put("eqnumberArr", CommonUtil.seperationParameter(eqnumberCheck, ","));

			param.put("from_date", fromDate);
			param.put("to_date", toDate);
			param.put("hid_boundmode", hidBoundmode);
			param.put("hid_costmode", hidCostmode);
			param.put("hid_transmode", hidTransmode);
			param.put("hid_provider", hidProvider);
			param.put("hid_from_node", hidFromNode);
			param.put("hid_via_node", hidViaNode);
			param.put("hid_to_node", hidToNode);
			param.put("hid_dor_node", hidDorNode);
			param.put("hid_kind", hidKind);
			param.put("hid_eq_radio", hidEqRadio);
			param.put("hid_period", hidPeriod);
			param.put("hid_tp_sz", hidTpSz);

			param.put("loginUsrOfcCtyCd", loginUsrOfcCtyCd);
			dRs = new SQLExecuter("DEFAULT").executeQuery(new SupplementSOManageDBDAOSearchSupplementSOTargetListRSQL(), param, param);
			resultArrayList = new ArrayList<HashMap<String, Object>>();

			/* 1:Work Order - none call, 2:Invoice - none call, 3:Adjusted - call procedure */
			int loopCnt = 0;
			HashMap<String, Object> inputMap = null;
			while (dRs.next()) {
				++loopCnt;
				inputMap = new HashMap<String, Object>();
				Map outProc = null;
				if ("RR".equals(hidKind) && loopCnt % 3 == 0) {
					Map<String, Object> velParam = new HashMap<String, Object>();
					param.clear();
					param = new HashMap<String, Object>();

					// login user office code - supplement s/o
					param.put("cre_ofc_cd", dRs.getString("cre_ofc_cd")); /* Control Office Code - TRS_TRSP_SVC_ORD.CRE_OFC_CD */
					param.put("vndr_seq", dRs.getString("vndr_seq")); /* Service Provicer - TRS_TRSP_SVC_ORD.VNDR_SEQ */
					param.put("create_date", dRs.getDate("create_date")); /* Rate Calculation 기준일자 - TRS_TRSP_SVC_ORD.CRE_DT */
					param.put("eq_knd_cd", dRs.getString("eq_knd_cd")); /* U:Container, Z:Chassis, G:Genset - TRS_TRSP_SVC_ORD.EQ_KND_CD */
					param.put("eq_tpsz_cd", dRs.getString("eq_tpsz_cd")); /* EQ TYPE SIZE - TRS_TRSP_SVC_ORD.EQ_TPSZ_CD */
					param.put("trsp_so_cmb_tp_cd", dRs.getString("trsp_so_cmb_tp_cd")); /* MATCHMAKING TYPE CODE - TRS_TRSP_SVC_ORD.TRSP_SO_CMB_TP_CD */
					param.put("cgo_tp_cd", dRs.getString("cgo_tp_cd")); /* F:Full, M:Empty - TRS_TRSP_SVC_ORD.CGO_TP_CD */
					param.put("trsp_bnd_cd", dRs.getString("trsp_bnd_cd")); /* I:IN BOUND, O:OUT BOUND - TRS_TRSP_SVC_ORD.TRSP_BND_CD */
					param.put("trsp_crr_mod_cd", dRs.getString("trsp_crr_mod_cd")); /* TD,RD,WD,TR,RT,RW,WR,TW,WT - TRS_TRSP_SVC_ORD.TRSP_CRR_MOD_CD */
					param.put("trsp_cost_dtl_mod_cd", dRs.getString("trsp_cost_dtl_mod_cd")); /* CY,DOOR,... - TRS_TRSP_SVC_ORD.TRSP_COST_DTL_MOD_CD */
					param.put("cust_nomi_trkr_flg", dRs.getString("cust_nomi_trkr_flg")); /* CNT INDICATOR - TRS_TRSP_SVC_ORD.CUST_NOMI_TRKR_FLG */
					param.put("cust_cnt_cd", dRs.getString("cust_cnt_cd")); /* 고객국가코드 - TRS_TRSP_SVC_ORD.CUST_CNT_CD */
					param.put("cust_seq", dRs.getInt("cust_seq")); /* 고객고유번호 - TRS_TRSP_SVC_ORD.CUST_SEQ */
					param.put("cmdt_cd", dRs.getString("cmdt_cd")); /* COMMODITY CODE - TRS_TRSP_SVC_ORD.CMDT_CD */
					param.put("fm_nod_cd", dRs.getString("fm_nod_cd")); /* FROM NODE - TRS_TRSP_SVC_ORD.FM_NOD_CD */
					param.put("via_nod_cd", dRs.getString("via_nod_cd")); /* VIA NODE - TRS_TRSP_SVC_ORD.VIA_NOD_CD */
					param.put("dor_nod_cd", dRs.getString("dor_nod_cd")); /* DOOR NODE - TRS_TRSP_SVC_ORD.DOR_NOD_CD */
					param.put("to_nod_cd", dRs.getString("to_nod_cd")); /* TO NODE - TRS_TRSP_SVC_ORD.TO_NOD_CD */
					param.put("bdl_knt", dRs.getInt("bdl_knt")); /* BUNDLING NUMBER OF CHASSIS/Empty Flatrack - Bundling된 Chassis/MT Flatrack수(계산해야함) */
					param.put("wgt_meas_ut_cd", dRs.getString("wgt_meas_ut_cd")); /* L-LBS, K-KG[S] - TRS_TRSP_SVC_ORD.WGT_MEAS_UT_CD */
					param.put("cntr_wgt", dRs.getDouble("cntr_wgt")); /* CARGO 중량 - TRS_TRSP_SVC_ORD.CNTR_WGT */
					param.put("spcl_cgo_cntr_tp_cd", dRs.getString("spcl_cgo_cntr_tp_cd")); /* SPECIAL CARGO TYPE CD - TRS_TRSP_SVC_ORD.SPCL_CGO_CNTR_TP_CD */

					velParam.putAll(param);

					outProc = new SQLExecuter("DEFAULT").executeSP((ISQLTemplate) new SupplementSOManageDBDAOGetTrsAllRateRSQL(), param, velParam);
					inputMap.put("agmt_ofc_cty_cd", (String) outProc.get("po_trsp_agmt_ofc_cty_cd")); // 24
					inputMap.put("agmt_seq", (String) outProc.get("po_trsp_agmt_seq")); // 25
					inputMap.put("agmt_rate_type", (String) outProc.get("po_trsp_agmt_rt_tp_cd")); // 26 'P', 'PD', 'DP', 'D'
					inputMap.put("way_type", (String) outProc.get("po_way_type")); // 27 'ONE', 'RND'
					inputMap.put("agmt_rate_type_nm", (String) outProc.get("po_trsp_agmt_rt_tp_nm")); // 28 Pair, Pair+Distance, Distance+Pair, Distance
					inputMap.put("sp_type", (String) outProc.get("po_sp_type")); // 29 'HJS', 'CNT'
					inputMap.put("cust_nomi_trkr_flg", (String) outProc.get("po_cust_nomi_trkr_flg")); // 30 'Y', 'N'
					inputMap.put("cust_cnt_cd", (String) outProc.get("po_cust_cnt_cd")); // 31
					inputMap.put("cust_seq", (String) outProc.get("po_cust_seq")); // 32
					inputMap.put("curr_cd", (String) outProc.get("po_local_curr_cd")); // 33
					inputMap.put("basic_amt", (String) outProc.get("po_basic_rt")); // 34
					inputMap.put("fuel_scg_amt", (String) outProc.get("po_fuel_scg_rt")); // 35
					inputMap.put("ow_scg_amt", (String) outProc.get("po_over_wgt_scg_rt")); // 36
					inputMap.put("etc_add_amt", "");
					inputMap.put("tot_amt", (String) outProc.get("po_local_curr_tot_amt")); // 37
					inputMap.put("tot_usd_amt", (String) outProc.get("po_usd_curr_tot_amt")); // 38
					inputMap.put("rtn_cd", (String) outProc.get("po_rtn_cd")); // 39 0:SUCCESS, OTHERS:FAILURE
					inputMap.put("rtn_msg", (String) outProc.get("po_rtn_msg")); // 40
				} else {
					inputMap.put("agmt_ofc_cty_cd", ""); // 24
					inputMap.put("agmt_seq", ""); // 25
					inputMap.put("agmt_rate_type", dRs.getString("agmt_rt_tp_cd")); // 26 'P', 'PD', 'DP', 'D'
					inputMap.put("way_type", dRs.getString("agmt_wy_tp_cd")); // 27 'ONE', 'RND'
					inputMap.put("agmt_rate_type_nm", ""); // 28 Pair, Pair+Distance, Distance+Pair, Distance
					inputMap.put("sp_type", ""); // 29 'HJS', 'CNT'
					inputMap.put("cust_nomi_trkr_flg", dRs.getString("cust_nomi_trkr_flg")); // 30 'Y', 'N'
					inputMap.put("cust_cnt_cd", dRs.getString("cust_cnt_cd")); // 31
					inputMap.put("cust_seq", dRs.getString("cust_seq")); // 32
					inputMap.put("curr_cd", dRs.getString("curr_cd")); // 33
					inputMap.put("basic_amt", dRs.getFloat("bzc_amt") + ""); // 34
					inputMap.put("nego_amt", dRs.getFloat("nego_amt") + ""); // 34
					inputMap.put("fuel_scg_amt", dRs.getFloat("fuel_scg_amt") + ""); // 35
					inputMap.put("etc_add_amt", dRs.getFloat("etc_add_amt") + "");
					inputMap.put("tot_amt", dRs.getFloat("tot_amt") + ""); // 37
					inputMap.put("tot_usd_amt", ""); // 38
					inputMap.put("rtn_cd", ""); // 39 0:SUCCESS, OTHERS:FAILURE
					inputMap.put("rtn_msg", ""); // 40
				}
				resultArrayList.add(inputMap);
			} // END OF WHILE STATEMENT

			dRs.beforeFirst();

			List<Object> totArr = new ArrayList<Object>();
			totArr.add(new DBRowSet());
			totArr.add(new ArrayList());
			totArr.set(0, dRs);
			totArr.set(1, resultArrayList);

			eventResponse.setRsVoList(totArr);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return eventResponse;
	}

	/**
	 * ESD-TRS의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public List<String> addSupplementSOList(EsdTrs0016Event event) throws DAOException {
		SupplementVO[] soModels = event.getSupplementVOs();
		SurchargeVO[] scModels = event.getSurchargeVOs();
		SupplementVO soModel = null;
		SurchargeVO scModel = null;
		SupplementSearchVO generalInfoVO = event.getSupplementSearchVO();
		DBRowSet dRs = null;
		List<String> returnArrayList = new ArrayList<String>();
		Map<String, Object> param = new HashMap<String, Object>();

		final String amountKindAdjusted = "Adjusted";

		try {
			String amountKind = null;

			String newSOSeq = "";
			String suppleSOTypeCd = "";

			/* AGREEMENT RELATED VARIABLES */
			String agmtOfcCtyCd = null;
			long agmtSeq = 0;

			String suppleSOCurrCd = null;
			float suppleSOBasicAmt = 0;
			float suppleSOFuelScgAmt = 0;
			float suppleSONegoAmt = 0;
			float suppleSOOvrWgtScgAmt = 0;
			float suppleSOEtcAddAmt = 0;
			/* AGREEMENT RELATED VARIABLES */

			String suppleSOIssueRsn = null;

			String prntTrspSoOfcCtyCd = null;
			long prntTrspSoSeq = 0;
			String loginUsrId = null;
			String loginUsrOfcCd = null;

			String surchargeKey = null;
			String convCurrency = null;
			String scgIndCd = null;

			int insCnt = 0;
			int i = 0;
			int j = 0;

			if (soModels == null || soModels.length == 0) {
				return returnArrayList;
			}
			loginUsrId = generalInfoVO.getFormCreUsrId() == null || "".equals(generalInfoVO.getFormCreUsrId()) ? "" : generalInfoVO.getFormCreUsrId();
			loginUsrOfcCd = generalInfoVO.getFormUsrOfcCd() == null ? "" : generalInfoVO.getFormUsrOfcCd();
			suppleSOTypeCd = "ALL".equals(generalInfoVO.getHidKind()) || "".equals(generalInfoVO.getHidKind()) ? "" : generalInfoVO.getHidKind();

			for (i = 0; i < soModels.length; i++) {
				soModel = soModels[i];
				/* AMOUNT KIND (WORKORDER, INVOICED, ADJUSTED) : 'Adjusted'일 경우만 creation 대상임 */
				amountKind = soModel.getAmountKind();
				if (amountKindAdjusted.equals(amountKind)) {
					/* AGREEMENT RELATED VARIABLES */
					agmtOfcCtyCd = soModel.getAgmtOfcCtyCd();
					agmtSeq = soModel.getAgmtSeq() == null || "".equals(soModel.getAgmtSeq()) ? 0 : Long.parseLong(soModel.getAgmtSeq());
					suppleSOCurrCd = soModel.getCurrCd();
					suppleSOBasicAmt = soModel.getBzcAmt() == null || "".equals(soModel.getBzcAmt()) ? 0 : Float.parseFloat(JSPUtil.removeCharacter(soModel.getBzcAmt(), ","));
					suppleSOFuelScgAmt = soModel.getFuelScgAmt() == null || "".equals(soModel.getFuelScgAmt()) ? 0 : Float.parseFloat(JSPUtil.removeCharacter(soModel.getFuelScgAmt(), ","));
					suppleSONegoAmt = soModel.getNegoAmt() == null || "".equals(soModel.getNegoAmt()) ? 0 : Float.parseFloat(JSPUtil.removeCharacter(soModel.getNegoAmt(), ","));
					suppleSOOvrWgtScgAmt = soModel.getOvrWgtScgAmt() == null || "".equals(soModel.getOvrWgtScgAmt()) ? 0 : Float.parseFloat(JSPUtil.removeCharacter(soModel.getOvrWgtScgAmt(), ","));
					suppleSOEtcAddAmt = soModel.getEtcAddAmt() == null || "".equals(soModel.getEtcAddAmt()) ? 0 : Float.parseFloat(JSPUtil.removeCharacter(soModel.getEtcAddAmt(), ","));
					/* AGREEMENT RELATED VARIABLES */

					suppleSOIssueRsn = soModel.getSplIssRsn();
					prntTrspSoOfcCtyCd = soModel.getTrspSoOfcCtyCd();
					prntTrspSoSeq = Long.parseLong(soModel.getTrspSoSeq());
					scgIndCd = soModel.getScgIndCd();

					if (soModel.getIbflag().length() > 0) {

						/*** Supplement S/O Master New Sequence Generation ***/
						dRs = new SQLExecuter("DEFAULT").executeQuery(new SupplementSOManageDBDAOCreateNewSOSeqRSQL(), param, param);
						if (dRs.next()) {
							newSOSeq = dRs.getString(1);
						}
						surchargeKey = soModel.getSurchargeKey();
						/*** MAKING CREATED SO NUMBER LIST ***/
						returnArrayList.add(prntTrspSoOfcCtyCd + newSOSeq);
						/* SVC_ORD INSERT START */

						param.put("trsp_so_seq", newSOSeq);
						param.put("trsp_spl_so_tp_cd", suppleSOTypeCd);
						param.put("trsp_agmt_ofc_cty_cd", agmtOfcCtyCd);
						param.put("trsp_agmt_seq", agmtSeq);
						param.put("curr_cd", suppleSOCurrCd);
						param.put("bzc_amt", suppleSOBasicAmt);
						param.put("fuel_scg_amt", suppleSOFuelScgAmt);
						param.put("nego_amt", suppleSONegoAmt);
						param.put("etc_add_amt", suppleSOEtcAddAmt);
						param.put("spl_iss_rsn", suppleSOIssueRsn);
						param.put("cre_ofc_cd", loginUsrOfcCd);
						param.put("cre_usr_id", loginUsrId);
						param.put("usr_ofc_cd", loginUsrOfcCd);
						param.put("upd_usr_id", loginUsrId);
						param.put("usr_ofc_cd", loginUsrOfcCd);
						param.put("prnt_trsp_so_ofc_cty_cd", prntTrspSoOfcCtyCd);
						param.put("prnt_trsp_so_seq", prntTrspSoSeq);
						param.put("scg_ind_cd", scgIndCd);

						insCnt = new SQLExecuter("DEFAULT").executeUpdate(new SupplementSOManageDBDAOInsertSOMstCSQL(), param, param);
						if (insCnt == Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to insert SQL");
						}

						/* CONVERSION AMOUNT INSERT START............................................................... */
						if (suppleSOCurrCd != null && !"".equals(suppleSOCurrCd)) {

							// USD CURRENCY CONVERSION AMOUNT
							convCurrency = "USD";

							param.clear();
							param = new HashMap<String, Object>();

							param.put("trsp_so_ofc_cty_cd", prntTrspSoOfcCtyCd);
							param.put("trsp_so_seq", newSOSeq);
							param.put("curr_cd", convCurrency);
							param.put("local_curr_cd", suppleSOCurrCd);
							param.put("target_curr_cd", convCurrency);
							param.put("bzc_amt", suppleSOBasicAmt);
							param.put("nego_amt", suppleSONegoAmt);
							param.put("fuel_scg_amt", suppleSOFuelScgAmt);
							param.put("ovr_wgt_scg_amt", suppleSOOvrWgtScgAmt);
							param.put("etc_add_amt", suppleSOEtcAddAmt);
							param.put("cre_ofc_cd", loginUsrOfcCd);
							param.put("cre_usr_id", loginUsrId);
							param.put("usr_ofc_cd", loginUsrOfcCd);
							param.put("upd_usr_id", loginUsrId);

							insCnt = new SQLExecuter("DEFAULT").executeUpdate(new SupplementSOManageDBDAOInsertConvAmtCSQL(), param, param);
							if (insCnt == Statement.EXECUTE_FAILED) {
								throw new DAOException("Fail to insert SQL");
							}

							// EUR CURRENCY CONVERSION AMOUNT
							convCurrency = "EUR";
							param.put("curr_cd", convCurrency);
							param.put("target_curr_cd", convCurrency);

							insCnt = new SQLExecuter("DEFAULT").executeUpdate(new SupplementSOManageDBDAOInsertConvAmtCSQL(), param, param);
							if (insCnt == Statement.EXECUTE_FAILED) {
								throw new DAOException("Fail to insert SQL");
							}
						}
						/* CONVERSION AMOUNT INSERT END................................................................. */

						/* SURCHARGE INSERT START................................................................. */
						if (scModels != null) {
							for (j = 0; j < scModels.length; j++) {
								scModel = scModels[j];
								String uniqueKey = scModel.getUniqueCd();
								if (uniqueKey != null && uniqueKey.equals(surchargeKey)) {

									param.clear();
									param = new HashMap<String, Object>();

									param.put("trsp_so_ofc_cty_cd", prntTrspSoOfcCtyCd);
									param.put("trsp_so_seq", newSOSeq);
									param.put("lgs_cost_cd", scModel.getLgsCostCd());
									param.put("scg_amt", JSPUtil.removeCharacter(scModel.getScgAmt(), ","));
									param.put("dry_run_rlbl_pty_tp_cd", scModel.getDryRunRlblPtyTpCd());
									param.put("fne_cuz_desc", scModel.getFneCuzDesc());
									param.put("fumg_cost_tp_cd", scModel.getFumgCostTpCd());
									param.put("mgst_tpsz_cd", scModel.getMgstTpszCd());
									param.put("insp_rf_pti_cstms_tp_cd", scModel.getInspRfPtiCstmsTpCd());
									param.put("lftg_knt", scModel.getLftgKnt());
									param.put("lftg_cuz_desc", scModel.getLftgCuzDesc());
									param.put("stop_loc_nod_cd", scModel.getStopLocNodCd());
									param.put("grs_wgt", scModel.getGrsWgt());
									param.put("incrt_dt", scModel.getIncrtDt());
									param.put("scl_stop_plc_nod_cd", scModel.getSclStopPlcNodCd());
									param.put("sto_dys", scModel.getStoDys());
									param.put("ob_bkg_no", scModel.getObBkgNo());
									param.put("wt_hrs", scModel.getWtHrs());
									param.put("otr_rmk", scModel.getOtrRmk());
									param.put("inv_scg_amt", JSPUtil.removeCharacter(scModel.getInvScgAmt(), ","));
									param.put("inv_dry_run_rlbl_pty_tp_cd", scModel.getInvDryRunRlblPtyTpCd());
									param.put("inv_fne_cuz_desc", scModel.getInvFneCuzDesc());
									param.put("inv_fumg_cost_tp_cd", scModel.getInvFumgCostTpCd());
									param.put("inv_mgst_tpsz_cd", scModel.getInvMgstTpszCd());
									param.put("inv_insp_rf_pti_cstms_tp_cd", scModel.getInvInspRfPtiCstmsTpCd());
									param.put("inv_lftg_knt", scModel.getInvLftgKnt());
									param.put("inv_lftg_cuz_desc", scModel.getInvLftgCuzDesc());
									param.put("inv_stop_loc_nod_cd", scModel.getInvStopLocNodCd());
									param.put("inv_grs_wgt", scModel.getInvGrsWgt());
									param.put("inv_incrt_dt", scModel.getInvIncrtDt());
									param.put("inv_scl_stop_plc_nod_cd", scModel.getInvSclStopPlcNodCd());
									param.put("inv_sto_dys", scModel.getInvStoDys());
									param.put("inv_ob_bkg_no", scModel.getInvObBkgNo());
									param.put("inv_wt_hrs", scModel.getInvWtHrs());
									param.put("inv_otr_rmk", scModel.getInvOtrRmk());
									param.put("n3pty_bil_flg", scModel.getN3ptyBilFlg());
									param.put("cust_cnt_cd", scModel.getCustCntCd());
									param.put("cust_seq", scModel.getCustSeq());
									param.put("n3pty_vndr_seq", scModel.getN3ptyVndrSeq());
									param.put("n3pty_ofc_cd", scModel.getN3ptyOfcCd());
									param.put("n3pty_amt", JSPUtil.removeCharacter(scModel.getN3ptyAmt(), ","));
									param.put("n3pty_desc", scModel.getN3ptyDesc());
									param.put("cre_ofc_cd", loginUsrOfcCd);
									param.put("cre_usr_id", loginUsrId);
									param.put("upd_usr_id", loginUsrId);
									param.put("INCUR_DT", scModel.getIncurDt());
									param.put("CHSS_NO", scModel.getChssNo());
									param.put("INV_INCUR_DT", scModel.getInvIncurDt());
									param.put("INV_CHSS_NO", scModel.getInvChssNo());

									insCnt = new SQLExecuter("DEFAULT").executeUpdate(new SupplementSOManageDBDAOInsertSurchargeCSQL(), param, param);
									if (insCnt == Statement.EXECUTE_FAILED) {
										throw new DAOException("Fail to insert SQL");
									}
								} // END OF INNER IF.
							} // END OF FOR LOOP.
						} // END OF OUTER IF.
						/* SURCHARGE INSERT END................................................................. */

					} // END OF IF(soModel.getIbflag().length() > 0)
				} // END OF ONLY AMOUNT KIND INDICATOR : 'Adjusted'
			} // END OF for LOOP.

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
		return returnArrayList;
	}

	/**
	 * SupplementSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param soArrayList
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSOCreatedList(List<String> soArrayList) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			List<SupplementSearchVO> arr = null;
			SupplementSearchVO tokenVO = null;
			String temp = "";
			int i = 0;
			if (soArrayList != null && !"".equals(soArrayList)) {
				arr = new ArrayList<SupplementSearchVO>();
				for (i = 0; i < soArrayList.size(); i++) {
					tokenVO = new SupplementSearchVO();
					temp = (String) soArrayList.get(i);
					if (temp.length() < 3)
						tokenVO.setTrspSoOfcCtyCd(temp);
					if (temp.length() >= 3) {
						tokenVO.setTrspSoOfcCtyCd(temp.substring(0, 3));
						tokenVO.setTrspSoSeq(temp.substring(3, temp.length()));
					}
					arr.add(i, tokenVO);
				}
				param.put("sonumberArr", arr);
			}
			dRs = new SQLExecuter().executeQuery(new SupplementSOManageDBDAOSearchSOCreatedListRSQL(), param, param);
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
	 * SupplementSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSupplementSOCorrectionList(EsdTrs0016Event event) throws DAOException {
		SupplementSearchVO searchVO = event.getSupplementSearchVO();
		DBRowSet dRs = null;

		Map<String, Object> param = new HashMap<String, Object>();

		String sonumberCheck = searchVO.getSonumber();
		String wonumberCheck = searchVO.getWonumber();
		String bkgnumberCheck = searchVO.getBkgnumber();
		String blnumberCheck = searchVO.getBlnumber();
		String eqnumberCheck = searchVO.getEqnumber();

		String vvdnumberCheck = searchVO.getVvdnumber();
		String refnumberCheck = searchVO.getRefnumber();

		String loginUsrOfcCtyCd = searchVO.getFormUsrOfcCd() == null ? "" : searchVO.getFormUsrOfcCd().substring(0, 3);

		String fromDate = "ALL".equals(searchVO.getFromDate()) || "".equals(searchVO.getFromDate()) ? "" : JSPUtil.removeCharacter(searchVO.getFromDate(), "-");
		String toDate = "ALL".equals(searchVO.getToDate()) || "".equals(searchVO.getToDate()) ? "" : JSPUtil.removeCharacter(searchVO.getToDate(), "-");
		String hidBoundmode = "ALL".equals(searchVO.getHidBoundmode()) || "".equals(searchVO.getHidBoundmode()) ? "" : searchVO.getHidBoundmode();
		String hidCostmode = "ALL".equals(searchVO.getHidCostmode()) || "".equals(searchVO.getHidCostmode()) ? "" : searchVO.getHidCostmode();
		String hidTransmode = "ALL".equals(searchVO.getHidTransmode()) || "".equals(searchVO.getHidTransmode()) ? "" : searchVO.getHidTransmode();
		String hidProvider = "ALL".equals(searchVO.getHidProvider()) || "".equals(searchVO.getHidProvider()) ? "" : searchVO.getHidProvider();
		String hidFromNode = "ALL".equals(searchVO.getHidFromNode()) || "".equals(searchVO.getHidFromNode()) ? "" : searchVO.getHidFromNode();
		String hidViaNode = "ALL".equals(searchVO.getHidViaNode()) || "".equals(searchVO.getHidViaNode()) ? "" : searchVO.getHidViaNode();
		String hidToNode = "ALL".equals(searchVO.getHidToNode()) || "".equals(searchVO.getHidToNode()) ? "" : searchVO.getHidToNode();
		String hidDorNode = "ALL".equals(searchVO.getHidDorNode()) || "".equals(searchVO.getHidDorNode()) ? "" : searchVO.getHidDorNode();
		String hidKind = "ALL".equals(searchVO.getHidKind()) || "".equals(searchVO.getHidKind()) ? "" : searchVO.getHidKind();
		String hidEqRadio = "ALL".equals(searchVO.getHidEqRadio()) || "".equals(searchVO.getHidEqRadio()) ? "" : searchVO.getHidEqRadio();
		String hidTpSz = "ALL".equals(searchVO.getHidTpSz()) || "".equals(searchVO.getHidTpSz()) ? "" : searchVO.getHidTpSz();

		StringTokenizer st = null;

		try {
			List<SupplementSearchVO> arr = null;
			SupplementSearchVO tokenVO = null;
			String temp = "";
			int i = 0;

			if (vvdnumberCheck != null && !"".equals(vvdnumberCheck)) {

				st = new StringTokenizer(vvdnumberCheck, ",");
				arr = new ArrayList<SupplementSearchVO>();
				i = 0;

				while (st.hasMoreTokens()) {
					tokenVO = new SupplementSearchVO();
					temp = st.nextToken();
					if (temp.length() < 4)
						tokenVO.setVslCd(temp);
					if (temp.length() >= 4)
						tokenVO.setVslCd(temp.substring(0, 4));
					if (temp.length() >= 8)
						tokenVO.setSkdVoyNo(temp.substring(4, 8));
					if (temp.length() >= 9)
						tokenVO.setSkdDirCd(temp.substring(8, 9));
					arr.add(i++, tokenVO);
				}
				param.put("vvdnumberArr", arr);
			}

			if (refnumberCheck != null && !"".equals(refnumberCheck)) {

				st = new StringTokenizer(refnumberCheck, ",");
				arr = new ArrayList<SupplementSearchVO>();
				i = 0;

				while (st.hasMoreTokens()) {
					tokenVO = new SupplementSearchVO();
					temp = st.nextToken();
					if (temp.length() < 15)
						tokenVO.setRefId(temp);
					if (temp.length() >= 15)
						tokenVO.setRefId(temp.substring(0, 15));
					if (temp.length() >= 16)
						tokenVO.setRefSeq(temp.substring(15, temp.length()));
					arr.add(i++, tokenVO);
				}
				param.put("refnumberArr", arr);
			}

			if (sonumberCheck != null && !"".equals(sonumberCheck)) {

				st = new StringTokenizer(sonumberCheck, ",");
				arr = new ArrayList<SupplementSearchVO>();
				i = 0;

				while (st.hasMoreTokens()) {
					tokenVO = new SupplementSearchVO();
					temp = st.nextToken();
					if (temp.length() < 3)
						tokenVO.setTrspSoOfcCtyCd(temp);
					if (temp.length() >= 3) {
						tokenVO.setTrspSoOfcCtyCd(temp.substring(0, 3));
						tokenVO.setTrspSoSeq(temp.substring(3, temp.length()));
					}
					arr.add(i++, tokenVO);
				}
				param.put("sonumberArr", arr);
			}

			if (wonumberCheck != null && !"".equals(wonumberCheck)) {

				st = new StringTokenizer(wonumberCheck, ",");
				arr = new ArrayList<SupplementSearchVO>();
				i = 0;

				while (st.hasMoreTokens()) {
					temp = st.nextToken();
					tokenVO = new SupplementSearchVO();
					if (temp.length() < 3)
						tokenVO.setTrspWoOfcCtyCd(temp);
					if (temp.length() >= 3) {
						tokenVO.setTrspWoOfcCtyCd(temp.substring(0, 3));
						tokenVO.setTrspWoSeq(temp.substring(3, temp.length()));
					}
					arr.add(i++, tokenVO);
				}
				param.put("wonumberArr", arr);
			}

			param.put("bkgnumberArr", CommonUtil.seperationParameter(bkgnumberCheck, ","));
			param.put("blnumberArr", CommonUtil.seperationParameter(blnumberCheck, ","));
			param.put("eqnumberArr", CommonUtil.seperationParameter(eqnumberCheck, ","));

			param.put("from_date", fromDate);
			param.put("to_date", toDate);
			param.put("hid_boundmode", hidBoundmode);
			param.put("hid_costmode", hidCostmode);
			param.put("hid_transmode", hidTransmode);
			param.put("hid_provider", hidProvider);
			param.put("hid_from_node", hidFromNode);
			param.put("hid_via_node", hidViaNode);
			param.put("hid_to_node", hidToNode);
			param.put("hid_dor_node", hidDorNode);
			param.put("hid_kind", hidKind);
			param.put("hid_eq_radio", hidEqRadio);
			param.put("hid_tp_sz", hidTpSz);
			param.put("loginUsrOfcCtyCd", loginUsrOfcCtyCd);
			dRs = new SQLExecuter("DEFAULT").executeQuery(new SupplementSOManageDBDAOSearchSupplementSOCorrectionListRSQL(), param, param);
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
	 * SupplementSO의 데이타 모델을 DB에서 삭제(INDICATOR = 'Y')한다.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void removeSupplementSOCreatedList(EsdTrs0016Event event) throws DAOException {
		SupplementVO[] soModels = event.getSupplementVOs();
		SupplementVO soModel = null;
		SupplementSearchVO generalInfoVO = event.getSupplementSearchVO();
		Map<String, Object> param = new HashMap<String, Object>();
		final String amountKindAdjusted = "Adjusted";
		if (soModels == null || soModels.length == 0) {
			return;
		}
		try {
			String loginUsrId = generalInfoVO.getFormCreUsrId() == null || "".equals(generalInfoVO.getFormCreUsrId()) ? "" : generalInfoVO.getFormCreUsrId();
			String loginUsrOfcCd = generalInfoVO.getFormUsrOfcCd() == null ? "" : generalInfoVO.getFormUsrOfcCd();
			SQLExecuter sqlExecuter = new SQLExecuter();
			for (int i = 0; i < soModels.length; i++) {
				soModel = soModels[i];
				if (amountKindAdjusted.equals(soModel.getAmountKind())) {
					if (soModel.getIbflag().length() > 0) {
						changeChkSoStausCode(sqlExecuter, soModel.getTrspSoOfcCtyCd(), soModel.getTrspSoSeq(), soModel.getTrspSoStsCd());
						param.put("upd_usr_id", loginUsrId);
						param.put("usr_ofc_cd", loginUsrOfcCd);
						param.put("trsp_so_ofc_cty_cd", soModel.getTrspSoOfcCtyCd());
						param.put("trsp_so_seq", soModel.getTrspSoSeq());
						int delCnt = sqlExecuter.executeUpdate(new SupplementSOManageDBDAORemoveSupplementSOCreatedListUSQL(), param, param);
						if (delCnt == Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to delete SQL");
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
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * Change Check
	 * 
	 * @param sqlExecuter
	 * @param inTrspSoOfcCtyCd
	 * @param inTrspSoSeq
	 * @param inTrspSoStsCd
	 * @throws DAOException
	 */
	private void changeChkSoStausCode(SQLExecuter sqlExecuter, String inTrspSoOfcCtyCd, String inTrspSoSeq, String inTrspSoStsCd) throws DAOException {
		DBRowSet changRowSet = null;
		Map<String, Object> checkParam = new HashMap<String, Object>();
		checkParam.put("trsp_so_ofc_cty_cd", inTrspSoOfcCtyCd);
		checkParam.put("trsp_so_seq", inTrspSoSeq);
		checkParam.put("trsp_so_sts_cd", inTrspSoStsCd);
		try {
			changRowSet = sqlExecuter.executeQuery(new SingleTransportationSOManageDBDAOChangeChkSoStsCdRSQL(), checkParam, null);
			changRowSet.next();
			if (changRowSet.getInt(1) > 0) {
				throw new DAOException(new ErrorHandler("TRS00061").getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}