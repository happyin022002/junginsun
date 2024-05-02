/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderIssueDBDAO.java
*@FileTitle : W/O 발행화면
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.02
*@LastModifier : 최 선
*@LastVersion : 2.4
* 2006.11.21 poong_yeon
* 1.0 최초 생성
*                 1.1 N200901090011 W/O Issue 화면 보완요청
*                 1.2 CHM-200900431 Customer Code 입력가능요청(09.08.24)
* 2010.09.09 이재위 1.3[SRM-201008617] [TRS] More candidate 조회 조건 수정 / (2) S/P select default 값 정정 요청 CSR
* 2010.11.22 이재위 1.4[CHM-201005356-01] [TRS] RD CNTR 의 Usage Rate 변경 요청
* 2010.12.28 민정호 1.5[CHM-201008042] AGMT 적용시 Customer Nominated 적용
* 2011.02.10 민정호 1.6[CHM-201108602] [TRS]미주지역 Appt./Deli. time update 기능 추가
* 2011.04.28 손은주 1.7[CHM-201109770-01][TRS] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용가능성 검토요청 (US Rail surcharge 기능 연계)
* 2011.07.14 김영철 1.8[CHM-201110224] [TRS] Flat rack CNTR Bundling 기능 추가요청
* 2011.10.25 김영철 1.9[CHM-201112474] [TRS] Bundling 기능상에서 EQ TPSZ 호환성 부여요청 
* 2011.10.17 이수진 2.0[CHM-201113210] [TRS] Feeder Term 표기 칼럼 추가 요청 -  wtr_rcv_term_cd, wtr_de_term_cd 항목 추가(단, US Rail 제외)
* 2011.12.09 민정호 2.1[CLT-111121293] R4J 패치 이후 발생한 결함 건 수정(Null dereference)
* 2011.12.29 유선오 2.2[CHM-201115242] [TRS] W/O preview 화면 관련 Validation 추가, BKG data 참조로직 변경요청
* 2012.05.22 최 선   2.3[] [TRS] W/O Issue 시, 로그 추가
* 2012.08.02 최 선   2.4[] [TRS] W/O Issue 시, 로그 제거
* 2012.12.11 이재위 2.5 [CHM-201221537] W/O issue 화면에 Currency / Negotiated 금액 save 버튼 생성 개발 요건 
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.integration;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hanjin.apps.alps.esd.trs.common.util.CommonUtil;
import com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.event.EsdTrs0091Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event.EsdTrs0921Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event.EsdTrs0963Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event.EsdTrs0980Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.vo.BundlingListVO;
import com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.vo.SpotBidWoIssueListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;


import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration.*;

/**
 * ESD-workordermanage에 대한 DB 처리를 담당<br>
 * - ESD-workordermanage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author poong_yeon
 * @see WorkOrderIssueBCImpl 참조
 * @since J2EE 1.4
 */
public class SpotBidWorkOrderIssueDBDAO extends DBDAOSupport {

	/**
	 * WorkOrderIssue의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return GeneralEventResponse
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public GeneralEventResponse searchWorkOrderIssueList(EsdTrs0091Event event) throws DAOException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dRs = null;
		DBRowSet rs = null;
		DBRowSet rs2 = null;
		DBRowSet rs3 = null;
		DBRowSet rs4 = null;

		//query parameter

		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
//		ArrayList arrSoNoA = new ArrayList();
//		ArrayList resultV = new ArrayList();
//		ArrayList returnList = new ArrayList();
		
//		ArrayList basisDate = new ArrayList();
		
		List<SpotBidWoIssueListVO> list = null;
//		StringTokenizer st = null;
		Map outProc = null;
		String bilCurrCd = null;
	
		String form_usr_ofc_cd		= event.getFormUsrOfcCd();
		String wo_radio 			= event.getWoRadio();
		String dt_radio 			= event.getDtRadio();
		String fmdate 				= event.getFmdate();
		String todate 				= event.getTodate();
		String combo_svc_provider 	= event.getComboSvcProvider();
		String wo_no 				= event.getWoNo();
		String trs_bnd_cd 			= event.getTrsBndCd();
		String trs_cost_md_cd 		= event.getTrsCostMdCd();
		String trs_md_cd 			= event.getTrsMdCd();
		String trs_so_tp_cd 		= event.getTrsSoTpCd();
		String fm_nod 				= event.getFmNod();
		String to_nod 				= event.getToNod();
		String dor_nod 				= event.getDorNod();
		String via_nod 				= event.getViaNod();
		String tvvd_no 				= event.getTvvdNo();
		String fvvd_no 				= event.getFvvdNo();
		String f_vvd_radio	 		= event.getFVvdRadio();
		String bkg_no 				= event.getBkgNo();
		String bl_no 				= event.getBlNo();
		String eq_radio 			= event.getEqRadio();
		String eq_no 				= event.getEqNo();
		String so_no 				= event.getSoNo();
		String mty_rfrn_no 			= event.getMtyRfrnNo();
		String cnt_flg              = event.getCntFlg();
		
		String spot_bid_no			= event.getSpotBidNo();

		param.put("form_usr_ofc_cd", form_usr_ofc_cd);
		param.put("wo_radio", wo_radio);
		param.put("dt_radio", dt_radio);
		param.put("fmdate", fmdate);
		param.put("todate", todate);
		param.put("combo_svc_provider", combo_svc_provider);
		param.put("wo_no", CommonUtil.seperationParameter(wo_no, ","));
		param.put("trs_bnd_cd", trs_bnd_cd);
		param.put("trs_cost_md_cd", trs_cost_md_cd);
		param.put("trs_md_cd", trs_md_cd);
		param.put("cust_cnt_cd", null);
		param.put("cust_seq", null);
		param.put("defalutCurr", null);		
		param.put("trs_so_tp_cd", trs_so_tp_cd);
		param.put("fm_nod", fm_nod);
		param.put("to_nod", to_nod);
		param.put("dor_nod", dor_nod);
		param.put("via_nod", via_nod);
		param.put("tvvd_no", CommonUtil.seperationParameter(tvvd_no, ","));
		param.put("fvvd_no", CommonUtil.seperationParameter(fvvd_no, ","));
		param.put("f_vvd_radio", f_vvd_radio);
		param.put("eq_radio", eq_radio);
		param.put("bkg_no", CommonUtil.seperationParameter(bkg_no, ","));
		param.put("bl_no", CommonUtil.seperationParameter(bl_no, ","));
		param.put("eq_no", CommonUtil.seperationParameter(eq_no, ","));
		param.put("so_no", CommonUtil.seperationParameter(so_no, ","));
		param.put("cnt_flg",cnt_flg);
		param.put("mty_rfrn_no", CommonUtil.seperationParameter(mty_rfrn_no, ","));
		
		param.put("spot_bid_no", CommonUtil.seperationParameter(spot_bid_no, ","));

		try {
			
			param.put("OFC_CD", form_usr_ofc_cd);
			rs2 = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchCurrCdRSQL(), param,param);
			if( rs2 != null ) {
				while( rs2.next() ) {
					bilCurrCd = JSPUtil.getNull(rs2.getString("BIL_CURR_CD"));
					}
			}
			if(bilCurrCd!=null){
				param.put("BIL_CURR_CD",bilCurrCd);
			}
			if(wo_radio.equals("Y")){
				dRs = new SQLExecuter().executeQuery(new SpotBidWorkOrderIssueDBDAOsearchWorkOrderIssuedYesListRSQL(), param,param);				
			}else{
				dRs = new SQLExecuter().executeQuery(new SpotBidWorkOrderIssueDBDAOsearchWorkOrderIssueListRSQL(), param,param);				
			}
			
			List<SpotBidWoIssueListVO> woModel = (List)RowSetUtil.rowSetToVOs(dRs, SpotBidWoIssueListVO.class);
			List<SpotBidWoIssueListVO> woModelCopy = (List)RowSetUtil.rowSetToVOs(dRs, SpotBidWoIssueListVO.class);
			String trspSoTpCd = null;
			String creDtStr      = null;
			String trspCostDtlModCd = null;
			String trspDfltVndrFlg  = null;
			String vndrSeqStr = null;
			String defalutCurrStr = null;
			String hzdMtrlFlg = "N";
			String ovwtTriAxlFlg = "N";
			int gpidExist = 0;
//			int gpidNotExist = 0;
		
			ArrayList gpIdList = new ArrayList();
			String mcntrBdlGrpSeq = null; //Grp ID
			String mcntrBdlSeq = null; // Grp Seq
			
			if(!wo_radio.equals("") && wo_radio.equals("N")){
				
				for(int m=0; woModel != null && m<woModel.size(); m++){
		
					SpotBidWoIssueListVO woModel2 = woModel.get(m);
					trspSoTpCd = woModel2.getTrspSoTpCd();
					creDtStr = woModel2.getCreDt();
					trspCostDtlModCd = woModel2.getTrspCostDtlModCd();
					trspDfltVndrFlg = woModel2.getTrspDfltVndrFlg();
					vndrSeqStr = woModel2.getVndrSeq();
					mcntrBdlGrpSeq=woModel2.getMcntrBdlGrpSeq();//2011.08.10 추가 [유선오]
	//				mcntrBdlSeq=woModel2.getMcntrBdlSeq();
					
					if(mcntrBdlGrpSeq.equals("")){
						if(!"S".equals(woModel2.getTrspSoTpCd())){
							String custCntCd="";
							String custSeq="";
							String custNomiTrkrFlg="";
							String cntFlg="N";
							String custNomiTrkrIndCd="";
							param.clear();
		
							param.put("CRE_OFC_CD",            woModel2.getCreOfcCd());            
							velParam.put("CRE_OFC_CD",         woModel2.getCreOfcCd());      
							
							param.put("CRE_DT",                creDtStr.substring(0,8));                
							velParam.put("CRE_DT",             creDtStr.substring(0,8));
							
							param.put("WY_TP_CD",              woModel2.getTrspAgmtWyTpCd());              
							velParam.put("WY_TP_CD",           woModel2.getTrspAgmtWyTpCd());
							
							param.put("EQ_KND_CD",              woModel2.getEqKndCd());              
							velParam.put("EQ_KND_CD",           woModel2.getEqKndCd());
							
							param.put("EQ_TPSZ_CD",            woModel2.getEqTpszCd());            
							velParam.put("EQ_TPSZ_CD",         woModel2.getEqTpszCd());
							
							param.put("TRSP_SO_CMB_TP_CD",     woModel2.getTrspSoCmbTpCd());     
							velParam.put("TRSP_SO_CMB_TP_CD",  woModel2.getTrspSoCmbTpCd());
							
							param.put("CGO_TP_CD",             woModel2.getCgoTpCd());             
							velParam.put("CGO_TP_CD",          woModel2.getCgoTpCd());
							
							param.put("TRSP_BND_CD",           woModel2.getTrspBndCd());           
							velParam.put("TRSP_BND_CD",        woModel2.getTrspBndCd());
							
							param.put("TRSP_CRR_MOD_CD",       woModel2.getTrspCrrModCd());       
							velParam.put("TRSP_CRR_MOD_CD",    woModel2.getTrspCrrModCd());
							
							param.put("TRSP_COST_DTL_MOD_CD",  woModel2.getTrspCostDtlModCd());  
							velParam.put("TRSP_COST_DTL_MOD_CD",woModel2.getTrspCostDtlModCd());
							
							if(!woModel2.getCustCntCd().equals("") &&  !woModel2.getCustSeq().equals("")){
								custNomiTrkrFlg = "Y";
							}
							
							param.put("CUST_NOMI_TRKR_FLG",    custNomiTrkrFlg);    
							velParam.put("CUST_NOMI_TRKR_FLG", custNomiTrkrFlg);
							
							param.put("CUST_CNT_CD",           woModel2.getCustCntCd());           
							velParam.put("CUST_CNT_CD",        woModel2.getCustCntCd());
							
							param.put("CUST_SEQ",              woModel2.getCustSeq());              
							velParam.put("CUST_SEQ",           woModel2.getCustSeq());

							param.put("RAIL_SSVC_TP_CD",        "");              
							velParam.put("RAIL_SSVC_TP_CD",     "");
							
							param.put("CMDT_CD",               woModel2.getCmdtCd());               
							velParam.put("CMDT_CD",            woModel2.getCmdtCd());
							
							param.put("FM_NOD_CD",             woModel2.getFmNodCd());             
							velParam.put("FM_NOD_CD",          woModel2.getFmNodCd());
							
							param.put("VIA_NOD_CD",            woModel2.getViaNodCd());            
							velParam.put("VIA_NOD_CD",         woModel2.getViaNodCd());
							
							param.put("DOR_NOD_CD",            woModel2.getDorNodCd());            
							velParam.put("DOR_NOD_CD",         woModel2.getDorNodCd());
							
							param.put("TO_NOD_CD",             woModel2.getToNodCd());             
							velParam.put("TO_NOD_CD",          woModel2.getToNodCd());
							
							param.put("BUNDLING_NO",           woModel2.getBundlingNo());           
							velParam.put("BUNDLING_NO",        woModel2.getBundlingNo());
							
							param.put("WGT_MEAS_UT_CD",        woModel2.getWgtMeasUtCd());        
							velParam.put("WGT_MEAS_UT_CD",     woModel2.getWgtMeasUtCd());
							
							param.put("CNTR_WGT",              woModel2.getCntrWgt());              
							velParam.put("CNTR_WGT",           woModel2.getCntrWgt());
							
							param.put("WTR_RCV_TERM",          "");          
							velParam.put("WTR_RCV_TERM",       "");
							
							param.put("WTR_DE_TERM",           event.getWtrDeTerm());           
							velParam.put("WTR_DE_TERM",        event.getWtrDeTerm());
							
							param.put("SPCL_CGO_CNTR_TP_CD",   woModel2.getSpclCgoCntrTpCd());              
							velParam.put("SPCL_CGO_CNTR_TP_CD",woModel2.getSpclCgoCntrTpCd());
							
							param.put("SC_NO",   woModel2.getScNo());
							velParam.put("SC_NO",woModel2.getScNo());
							
							param.put("RFA_NO",   woModel2.getRfaNo());
							velParam.put("RFA_NO",   woModel2.getRfaNo());
							
							rs =  new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOSearchCntInfoRSQL(), param,param);
							custNomiTrkrIndCd = "HJS";
							custNomiTrkrFlg = "N";
							while(rs.next()){
								woModel2.setVndrSeq(rs.getString("VNDR_SEQ"));
								woModel2.setVndrNm(rs.getString("VNDR_NM"));
								
								custCntCd=rs.getString("CUST_CNT_CD");
								custSeq=rs.getString("CUST_SEQ");
								custNomiTrkrFlg = "Y";
								cntFlg = "Y";
								custNomiTrkrIndCd = rs.getString("CUST_NOMI_TRKR_IND_CD");
							}
							
//							param.put("CUST_CNT_CD",           woModel2.getCustCntCd());           
//							velParam.put("CUST_CNT_CD",        woModel2.getCustCntCd());
//							
//							param.put("CUST_SEQ",              woModel2.getCustSeq());              
//							velParam.put("CUST_SEQ",           woModel2.getCustSeq());
//							
							param.put("CUST_NOMI_TRKR_FLG",    custNomiTrkrIndCd);   //CUST_NOMI_TRKR_FLG를  CUST_NOMI_TRKR_IND_CD 대체.
							velParam.put("CUST_NOMI_TRKR_FLG", custNomiTrkrIndCd);
							
							param.put("VNDR_CD",               woModel2.getVndrSeq());               
							velParam.put("VNDR_CD",            woModel2.getVndrSeq());


							outProc = new SQLExecuter("DEFAULT").executeSP((ISQLTemplate)new WorkOrderIssueDBDAOsearchWorkOrderIssueListProcRSQL(), param, velParam);
		
							String sAgmtWord = JSPUtil.getNull((String) outProc.get("po_scg3_rt")).replaceAll("\\$", "\\,");
							String sTrspAgmtCfmFlg = "";
							String sTrspAgmtRtSeq = "";
							String sTrspAgmtUpdDt = "";
							if (sAgmtWord.length() > 0) {
								String[] AgmtWords = sAgmtWord.split(",");
								sTrspAgmtCfmFlg = AgmtWords[3];
								sTrspAgmtRtSeq = AgmtWords[4];
								sTrspAgmtUpdDt = AgmtWords[5];
							}
						
							woModel2.setPoTrspAgmtOfcCtyCd(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_ofc_cty_cd")));
							woModel2.setPoTrspAgmtSeq(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_seq")));
							woModel2.setPoTrspAgmtRtTpCd(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_rt_tp_cd")));
							woModel2.setPoWayType(JSPUtil.getNull((String) outProc.get("po_way_type")));
							woModel2.setPoTrspAgmtRtTpNm(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_rt_tp_nm")));
//							woModel2.setPoSpType(JSPUtil.getNull((String) outProc.get("po_sp_type")));
							woModel2.setPoCustNomiTrkrFlg(JSPUtil.getNull((String) outProc.get("po_cust_nomi_trkr_flg")));
							woModel2.setPoCustCntCd(JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd")));
							woModel2.setPoCustSeq(JSPUtil.getNull((String) outProc.get("po_cust_seq")));
							woModel2.setPoCustCntCdSeq(JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd_seq")));
							if(cntFlg.equals("Y")){
//								woModel2.setPoCustNomiTrkrFlg("Y");
//								woModel2.setPoCustCntCd(JSPUtil.getNull(custCntCd));
//								woModel2.setPoCustSeq(JSPUtil.getNull(custSeq));
//								woModel2.setPoCustCntCdSeq(JSPUtil.getNull(custCntCd+custSeq));
								woModel2.setPoSpType("Y");								
							}else{
//								woModel2.setPoCustNomiTrkrFlg(JSPUtil.getNull((String) outProc.get("po_cust_nomi_trkr_flg")));
//								woModel2.setPoCustCntCd(JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd")));
//								woModel2.setPoCustSeq(JSPUtil.getNull((String) outProc.get("po_cust_seq")));
//								woModel2.setPoCustCntCdSeq(JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd_seq")));
//								woModel2.setPoSpType(JSPUtil.getNull((String) outProc.get("po_sp_type")));
								if(JSPUtil.getNull((String) outProc.get("po_sp_type")).equals("HJS")){
									woModel2.setPoSpType("N");						
								}else if(JSPUtil.getNull((String) outProc.get("po_sp_type")).equals("CNT")){
									woModel2.setPoSpType("Y");
								}else{
									woModel2.setPoSpType("N");
								}
							}
			//				woModel2.setPoLocalCurrCd(JSPUtil.getNull((String) outProc.get("po_local_curr_cd")));  -- curr_cd 빈칸으로 조회되어 수정함. 09/11/30
							defalutCurrStr = JSPUtil.getNull((String) outProc.get("po_local_curr_cd"));
							
							// Feeder Term이 0인 경우에는 null로 보여준다 2011.10.21 이수진
							if(JSPUtil.getNull((String) outProc.get("po_wtr_rcv_term_cd")).equals("0")){ 
								woModel2.setPoWtrRcvTermCd("");
							}else{
								woModel2.setPoWtrRcvTermCd(JSPUtil.getNull((String) outProc.get("po_wtr_rcv_term_cd")));
							}
							
							if(JSPUtil.getNull((String) outProc.get("po_wtr_de_term_cd")).equals("0")){ 
								woModel2.setPoWtrDeTermCd("");
							}else{
								woModel2.setPoWtrDeTermCd(JSPUtil.getNull((String) outProc.get("po_wtr_de_term_cd")));
							}
							
							if(defalutCurrStr == null || defalutCurrStr.equals("")){
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
							woModel2.setPoVatScgRt(JSPUtil.getNull((String) outProc.get("po_vat_scg_rt")));
							woModel2.setPoScg1Rt(JSPUtil.getNull((String) outProc.get("po_scg1_rt")));
							woModel2.setTollFeeAmt(JSPUtil.getNull((String) outProc.get("po_scg2_rt")));
							woModel2.setPoScg3Rt(JSPUtil.getNull((String) outProc.get("po_scg3_rt")));
	
							if(!"ER".equals(trspCostDtlModCd) && vndrSeqStr != null && !vndrSeqStr.equals("")){
								woModel2.setTrspDfltVndrFlg("Y");
							}
							
							//Special Cargo Available 적용
							//CHM-201432996 Special Cargo Available SP 신메뉴 개발
							rs4 =  new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOSearchSpclCgoRSQL(), param,param);
							while(rs4.next()){
								hzdMtrlFlg = rs4.getString("HZD_MTRL_FLG");
								ovwtTriAxlFlg = rs4.getString("OVWT_TRI_AXL_FLG");
							}
							woModel2.setHzdMtrlFlg(hzdMtrlFlg);
							woModel2.setOvwtTriAxlFlg(ovwtTriAxlFlg);
							woModel2.setPoCfmFlg(sTrspAgmtCfmFlg);
							woModel2.setPoAgmtRtSeq(sTrspAgmtRtSeq);
							woModel2.setPoAgmtUpdDt(sTrspAgmtUpdDt);
						
	//						gpidNotExist ++;
							woModelCopy.add(woModel2);
	//						woModelCopy.set(gpidNotExist, woModel2);
							//returnList.add(woModel);
						}
					}else{
						gpIdList.add(mcntrBdlGrpSeq);
						gpidExist ++;				
					}	
				}
				list = woModelCopy;
			} else {
				list = woModel;
			}
//    		if(list == null){
//			list = woModelCopy;
//			}else{
//			list.addAll(woModelCopy);
//		}	
			
			if (gpidExist > 0) {
				param.clear();
				param.put("gp_id", gpIdList);
				rs3 = new SQLExecuter().executeQuery(new SpotBidWorkOrderIssueDBDAOsearchWorkOrderIssueListRSQL(), param,param);	
				
				List<SpotBidWoIssueListVO> woModelBd = (List)RowSetUtil.rowSetToVOs(rs3, SpotBidWoIssueListVO.class);
				List<SpotBidWoIssueListVO> woModelBdCopy = (List)RowSetUtil.rowSetToVOs(rs3, SpotBidWoIssueListVO.class);
//				list.addAll(woModelBd);					
				
				for(int m=0; woModelBd != null && m<woModelBd.size(); m++){
		
					SpotBidWoIssueListVO woModel3 = woModelBd.get(m);
					trspSoTpCd = woModel3.getTrspSoTpCd();
					creDtStr = woModel3.getCreDt();
					trspCostDtlModCd = woModel3.getTrspCostDtlModCd();
					trspDfltVndrFlg = woModel3.getTrspDfltVndrFlg();
					vndrSeqStr = woModel3.getVndrSeq();
					mcntrBdlGrpSeq=woModel3.getMcntrBdlGrpSeq();//2011.08.10 추가 [유선오]
					mcntrBdlSeq=woModel3.getMcntrBdlSeq();
					
					if(!"S".equals(woModel3.getTrspSoTpCd())){
						param.clear();

						param.put("CRE_OFC_CD",            woModel3.getCreOfcCd());            
						velParam.put("CRE_OFC_CD",         woModel3.getCreOfcCd());      
				
						param.put("VNDR_CD",               woModel3.getVndrSeq());               
						velParam.put("VNDR_CD",            woModel3.getVndrSeq());
						
						param.put("CRE_DT",                creDtStr.substring(0,8));                
						velParam.put("CRE_DT",             creDtStr.substring(0,8));
						
						param.put("WY_TP_CD",              woModel3.getTrspAgmtWyTpCd());              
						velParam.put("WY_TP_CD",           woModel3.getTrspAgmtWyTpCd());
						
						param.put("EQ_KND_CD",              woModel3.getEqKndCd());              
						velParam.put("EQ_KND_CD",           woModel3.getEqKndCd());
						
						param.put("EQ_TPSZ_CD",            woModel3.getEqTpszCd());            
						velParam.put("EQ_TPSZ_CD",         woModel3.getEqTpszCd());
						
						param.put("TRSP_SO_CMB_TP_CD",     woModel3.getTrspSoCmbTpCd());     
						velParam.put("TRSP_SO_CMB_TP_CD",  woModel3.getTrspSoCmbTpCd());
						
						param.put("CGO_TP_CD",             woModel3.getCgoTpCd());             
						velParam.put("CGO_TP_CD",          woModel3.getCgoTpCd());
						
						param.put("TRSP_BND_CD",           woModel3.getTrspBndCd());           
						velParam.put("TRSP_BND_CD",        woModel3.getTrspBndCd());
						
						param.put("TRSP_CRR_MOD_CD",       woModel3.getTrspCrrModCd());       
						velParam.put("TRSP_CRR_MOD_CD",    woModel3.getTrspCrrModCd());
						
						param.put("TRSP_COST_DTL_MOD_CD",  woModel3.getTrspCostDtlModCd());  
						velParam.put("TRSP_COST_DTL_MOD_CD",woModel3.getTrspCostDtlModCd());
						
						param.put("CUST_NOMI_TRKR_FLG",    woModel3.getCustNomiTrkrFlg());    
						velParam.put("CUST_NOMI_TRKR_FLG", woModel3.getCustNomiTrkrFlg());
						
						param.put("CUST_CNT_CD",           woModel3.getCustCntCd());           
						velParam.put("CUST_CNT_CD",        woModel3.getCustCntCd());
						
						param.put("CUST_SEQ",              woModel3.getCustSeq());              
						velParam.put("CUST_SEQ",           woModel3.getCustSeq());
						
						param.put("RAIL_SSVC_TP_CD",        "");              
						velParam.put("RAIL_SSVC_TP_CD",     "");
						
						param.put("CMDT_CD",               woModel3.getCmdtCd());               
						velParam.put("CMDT_CD",            woModel3.getCmdtCd());
						
						param.put("FM_NOD_CD",             woModel3.getFmNodCd());             
						velParam.put("FM_NOD_CD",          woModel3.getFmNodCd());
						
						param.put("VIA_NOD_CD",            woModel3.getViaNodCd());            
						velParam.put("VIA_NOD_CD",         woModel3.getViaNodCd());
						
						param.put("DOR_NOD_CD",            woModel3.getDorNodCd());            
						velParam.put("DOR_NOD_CD",         woModel3.getDorNodCd());
						
						param.put("TO_NOD_CD",             woModel3.getToNodCd());             
						velParam.put("TO_NOD_CD",          woModel3.getToNodCd());
						
						param.put("BUNDLING_NO",           woModel3.getBundlingNo());           
						velParam.put("BUNDLING_NO",        woModel3.getBundlingNo());
						
						param.put("WGT_MEAS_UT_CD",        woModel3.getWgtMeasUtCd());        
						velParam.put("WGT_MEAS_UT_CD",     woModel3.getWgtMeasUtCd());
						
						param.put("CNTR_WGT",              woModel3.getCntrWgt());              
						velParam.put("CNTR_WGT",           woModel3.getCntrWgt());
						
						param.put("WTR_RCV_TERM",          "");          
						velParam.put("WTR_RCV_TERM",       "");
						
						param.put("WTR_DE_TERM",           event.getWtrDeTerm());           
						velParam.put("WTR_DE_TERM",        event.getWtrDeTerm());
						
						param.put("SPCL_CGO_CNTR_TP_CD",   woModel3.getSpclCgoCntrTpCd());              
						velParam.put("SPCL_CGO_CNTR_TP_CD",woModel3.getSpclCgoCntrTpCd());
										
						outProc = new SQLExecuter("DEFAULT").executeSP((ISQLTemplate)new WorkOrderIssueDBDAOsearchWorkOrderIssueListProcRSQL(), param, velParam);

						woModel3.setPoTrspAgmtOfcCtyCd(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_ofc_cty_cd")));
						woModel3.setPoTrspAgmtSeq(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_seq")));
						woModel3.setPoTrspAgmtRtTpCd(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_rt_tp_cd")));
						woModel3.setPoWayType(JSPUtil.getNull((String) outProc.get("po_way_type")));
						woModel3.setPoTrspAgmtRtTpNm(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_rt_tp_nm")));
						woModel3.setPoSpType(JSPUtil.getNull((String) outProc.get("po_sp_type")));
						woModel3.setPoCustNomiTrkrFlg(JSPUtil.getNull((String) outProc.get("po_cust_nomi_trkr_flg")));
						woModel3.setPoCustCntCd(JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd")));
						woModel3.setPoCustSeq(JSPUtil.getNull((String) outProc.get("po_cust_seq")));
						woModel3.setPoCustCntCdSeq(JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd_seq")));
		//				woModel2.setPoLocalCurrCd(JSPUtil.getNull((String) outProc.get("po_local_curr_cd")));  -- curr_cd 빈칸으로 조회되어 수정함. 09/11/30
						defalutCurrStr = JSPUtil.getNull((String) outProc.get("po_local_curr_cd"));
						if(defalutCurrStr == null || defalutCurrStr.equals("")){
							defalutCurrStr = JSPUtil.getNull((String) woModel3.getCurrCd());
						}
						woModel3.setPoLocalCurrCd(defalutCurrStr);
						if ( "1".equals(woModel3.getMcntrBdlSeq())){
							woModel3.setPoBasicRt(JSPUtil.getNull((String) outProc.get("po_basic_rt")));
							woModel3.setPoFuelScgRt(JSPUtil.getNull((String) outProc.get("po_fuel_scg_rt")));
							woModel3.setPoOverWgtScgRt(JSPUtil.getNull((String) outProc.get("po_over_wgt_scg_rt")));
							woModel3.setPoLocalCurrTotAmt(JSPUtil.getNull((String) outProc.get("po_local_curr_tot_amt")));
							woModel3.setPoUsdCurrTotAmt(JSPUtil.getNull((String) outProc.get("po_usd_curr_tot_amt")));
							woModel3.setPoRtnCd(JSPUtil.getNull((String) outProc.get("po_rtn_cd")));
							woModel3.setPoRtnMsg(JSPUtil.getNull((String) outProc.get("po_rtn_msg")));
							woModel3.setPoVatScgRt(JSPUtil.getNull((String) outProc.get("po_vat_scg_rt")));
							woModel3.setPoScg1Rt(JSPUtil.getNull((String) outProc.get("po_scg1_rt")));
							woModel3.setTollFeeAmt(JSPUtil.getNull((String) outProc.get("po_scg2_rt")));
							woModel3.setPoScg3Rt(JSPUtil.getNull((String) outProc.get("po_scg3_rt")));
						}
						if(!"ER".equals(trspCostDtlModCd) && vndrSeqStr != null && !vndrSeqStr.equals("")){
							woModel3.setTrspDfltVndrFlg("Y");
						}
					}
					woModelBdCopy.add(woModel3);
				}
	    		if(list == null){
	    			list = woModelBdCopy;
				}else{
					list.addAll(woModelBdCopy);
				}
			}
			
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
	 * 
	 * @param event
	 * @return GeneralEventResponse
	 * @throws DAOException
	 */
	public GeneralEventResponse searchWorkOrderIssueBySoNo(EsdTrs0091Event event) throws DAOException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dRs = null;
		DBRowSet rs = null;
		DBRowSet rs2 = null;
		DBRowSet rs4 = null;
		//query parameter

		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> arrSoNoA = new ArrayList();
//		ArrayList resultV = new ArrayList();
		ArrayList returnList = new ArrayList();
		
//		ArrayList basisDate = new ArrayList();
		
		List<SpotBidWoIssueListVO> list = null;
//		StringTokenizer st = null;
		Map outProc = null;
		
		String bilCurrCd = null;
		String defalutCurrStr = null;
		
		String form_usr_ofc_cd		= event.getFormUsrOfcCd();
//		String so_no 				= event.getSoNo();
		String trspSoOfcCtyCd       = event.getTrspSoOfcCtyCd();
		String trspSoSeq		    = event.getTrspSoSeq();
//		String SO_CTY = "";
//		String SO_SEQ = "";
		String hzdMtrlFlg = "N";
		String ovwtTriAxlFlg = "N";

		String spTpCd = event.getSpTpCd();
		String vndrCd = event.getVndrCd();
	
		/*int i = 0;
		while( CommonUtil.seperationParameter(TrspSoOfcCtyCd, ",") != null && i < CommonUtil.seperationParameter(TrspSoOfcCtyCd, ",").size()){
			SO_CTY = (String) CommonUtil.seperationParameter(TrspSoOfcCtyCd, ",").get(i);
			SO_SEQ = (String) CommonUtil.seperationParameter(TrspSoSeq, ",").get(i);	
			arrSoNoA.add(i++, SO_CTY+SO_SEQ);
		}*/
		ArrayList<String> inputOfcArr = null;
		if( !trspSoOfcCtyCd.equals("") && !trspSoOfcCtyCd.equals("null") && trspSoOfcCtyCd != null) {
			
			
			inputOfcArr = CommonUtil.seperationParameter(trspSoOfcCtyCd, ",");
			
		}
		ArrayList<String> inputSeqArr = null;
		if( !trspSoSeq.equals("") && !trspSoSeq.equals("null") && trspSoSeq != null) {			
			
			inputSeqArr = CommonUtil.seperationParameter(trspSoSeq, ",");
			
		}
		if(inputSeqArr!=null){
			for(int i=0; i<inputSeqArr.size(); i++){
				if(inputOfcArr!=null){
					arrSoNoA.add(i,inputOfcArr.get(i)+inputSeqArr.get(i));
				}
			}
		}
		
		param.put("form_usr_ofc_cd", form_usr_ofc_cd);
//		param.put("so_no", CommonUtil.seperationParameter(so_no, ","));
		param.put("so_no", arrSoNoA);
		
		
		try {
			param.put("OFC_CD", form_usr_ofc_cd);
			
			rs2 = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchCurrCdRSQL(), param,param);
			if( rs2 != null ) {
				while( rs2.next() ) {
					bilCurrCd = JSPUtil.getNull(rs2.getString("BIL_CURR_CD"));
					}
			}
			
			if(bilCurrCd!=null){
				param.put("BIL_CURR_CD",bilCurrCd);
			}
			param.put("SP_TP_CD", spTpCd);
			param.put("VNDR_CD", vndrCd);
			
			dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchWorkOrderIssueBySoNoRSQL(), param,param);
			List<SpotBidWoIssueListVO> woModel = (List)RowSetUtil.rowSetToVOs(dRs, SpotBidWoIssueListVO.class);


			
			for(int m=0; woModel != null && m<woModel.size(); m++){
				
				String custCntCd="";
				String custSeq="";
				String custNomiTrkrFlg="";
				String cntFlg="N";
				String custNomiTrkrIndCd="";
	
				param.clear();
				
				SpotBidWoIssueListVO woModel2 = woModel.get(m);
							
				param.put("CRE_OFC_CD",            woModel2.getCreOfcCd());            
				velParam.put("CRE_OFC_CD",         woModel2.getCreOfcCd());      
		

				
				param.put("CRE_DT",                woModel2.getCreDt().substring(0,8));
				velParam.put("CRE_DT",             woModel2.getCreDt().substring(0,8));
				
				param.put("WY_TP_CD",              woModel2.getTrspAgmtWyTpCd());              
				velParam.put("WY_TP_CD",           woModel2.getTrspAgmtWyTpCd());
				
				param.put("EQ_KND_CD",              woModel2.getEqKndCd());              
				velParam.put("EQ_KND_CD",           woModel2.getEqKndCd());
				
				param.put("EQ_TPSZ_CD",            woModel2.getEqTpszCd());            
				velParam.put("EQ_TPSZ_CD",         woModel2.getEqTpszCd());
				
				param.put("TRSP_SO_CMB_TP_CD",     woModel2.getTrspSoCmbTpCd());     
				velParam.put("TRSP_SO_CMB_TP_CD",  woModel2.getTrspSoCmbTpCd());
				
				param.put("CGO_TP_CD",             woModel2.getCgoTpCd());             
				velParam.put("CGO_TP_CD",          woModel2.getCgoTpCd());
				
				param.put("TRSP_BND_CD",           woModel2.getTrspBndCd());           
				velParam.put("TRSP_BND_CD",        woModel2.getTrspBndCd());
				
				param.put("TRSP_CRR_MOD_CD",       woModel2.getTrspCrrModCd());       
				velParam.put("TRSP_CRR_MOD_CD",    woModel2.getTrspCrrModCd());
				
				param.put("TRSP_COST_DTL_MOD_CD",  woModel2.getTrspCostDtlModCd());  
				velParam.put("TRSP_COST_DTL_MOD_CD",woModel2.getTrspCostDtlModCd());
				
				if(!woModel2.getCustCntCd().equals("")&& !woModel2.getCustSeq().equals("")){
					custNomiTrkrFlg = "Y";
				}
				param.put("CUST_NOMI_TRKR_FLG",    custNomiTrkrFlg);    
				velParam.put("CUST_NOMI_TRKR_FLG", custNomiTrkrFlg);
				
				param.put("CUST_CNT_CD",           woModel2.getCustCntCd());           
				velParam.put("CUST_CNT_CD",        woModel2.getCustCntCd());
				
				param.put("CUST_SEQ",              woModel2.getCustSeq());              
				velParam.put("CUST_SEQ",           woModel2.getCustSeq());
				
				
				param.put("RAIL_SSVC_TP_CD",        "");              
				velParam.put("RAIL_SSVC_TP_CD",     "");
				
				param.put("CMDT_CD",               woModel2.getCmdtCd());               
				velParam.put("CMDT_CD",            woModel2.getCmdtCd());
				
				param.put("FM_NOD_CD",             woModel2.getFmNodCd());             
				velParam.put("FM_NOD_CD",          woModel2.getFmNodCd());
				
				param.put("VIA_NOD_CD",            woModel2.getViaNodCd());            
				velParam.put("VIA_NOD_CD",         woModel2.getViaNodCd());
				
				param.put("DOR_NOD_CD",            woModel2.getDorNodCd());            
				velParam.put("DOR_NOD_CD",         woModel2.getDorNodCd());
				
				param.put("TO_NOD_CD",             woModel2.getToNodCd());             
				velParam.put("TO_NOD_CD",          woModel2.getToNodCd());
				
				param.put("BUNDLING_NO",           woModel2.getBundlingNo());           
				velParam.put("BUNDLING_NO",        woModel2.getBundlingNo());
				
				param.put("WGT_MEAS_UT_CD",        woModel2.getWgtMeasUtCd());        
				velParam.put("WGT_MEAS_UT_CD",     woModel2.getWgtMeasUtCd());

				
				param.put("CNTR_WGT",              woModel2.getCntrWgt());              
				velParam.put("CNTR_WGT",           woModel2.getCntrWgt());
				
				param.put("WTR_RCV_TERM",          "");          
				velParam.put("WTR_RCV_TERM",       "");
				
				param.put("WTR_DE_TERM",           event.getWtrDeTerm());           
				velParam.put("WTR_DE_TERM",        event.getWtrDeTerm());

				param.put("SPCL_CGO_CNTR_TP_CD",   woModel2.getSpclCgoCntrTpCd());              
				velParam.put("SPCL_CGO_CNTR_TP_CD",woModel2.getSpclCgoCntrTpCd());
				
				param.put("SC_NO",   woModel2.getScNo());
				velParam.put("SC_NO",woModel2.getScNo());
				
				param.put("RFA_NO",   woModel2.getRfaNo());
				velParam.put("RFA_NO",   woModel2.getRfaNo());
				
				rs =  new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOSearchCntInfoRSQL(), param,param);
				custNomiTrkrIndCd = "HJS";
				custNomiTrkrFlg = "N";
				while(rs.next()){
					woModel2.setVndrSeq(rs.getString("VNDR_SEQ"));
					woModel2.setVndrNm(rs.getString("VNDR_NM"));
					
					custCntCd=rs.getString("CUST_CNT_CD");
					custSeq=rs.getString("CUST_SEQ");
					custNomiTrkrFlg = "Y";
					cntFlg = "Y";
					custNomiTrkrIndCd = rs.getString("CUST_NOMI_TRKR_IND_CD");
				}
				
				param.put("CUST_NOMI_TRKR_FLG",    custNomiTrkrIndCd);   //CUST_NOMI_TRKR_FLG를  CUST_NOMI_TRKR_IND_CD 대체.
				velParam.put("CUST_NOMI_TRKR_FLG", custNomiTrkrIndCd);
				param.put("VNDR_CD",               woModel2.getVndrSeq());               
				velParam.put("VNDR_CD",            woModel2.getVndrSeq());
				
//				param.put("CUST_CNT_CD",           woModel2.getCustCntCd());           
//				velParam.put("CUST_CNT_CD",        woModel2.getCustCntCd());
				
//				param.put("CUST_SEQ",              woModel2.getCustSeq());              
//				velParam.put("CUST_SEQ",           woModel2.getCustSeq());
				
//				param.put("CUST_NOMI_TRKR_FLG",    woModel2.getCustNomiTrkrFlg());    
//				velParam.put("CUST_NOMI_TRKR_FLG", woModel2.getCustNomiTrkrFlg());
				
				outProc = new SQLExecuter("DEFAULT").executeSP((ISQLTemplate)new WorkOrderIssueDBDAOsearchWorkOrderIssueListProcRSQL(), param, param);
				
				String sAgmtWord = JSPUtil.getNull((String) outProc.get("po_scg3_rt")).replaceAll("\\$", "\\,");
				String sTrspAgmtCfmFlg = "";
				String sTrspAgmtRtSeq = "";
				String sTrspAgmtUpdDt = "";
				if (sAgmtWord.length() > 0) {
					String[] AgmtWords = sAgmtWord.split(",");
					sTrspAgmtCfmFlg = AgmtWords[3];
					sTrspAgmtRtSeq = AgmtWords[4];
					sTrspAgmtUpdDt = AgmtWords[5];
				}
		 							
				woModel2.setPoTrspAgmtOfcCtyCd(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_ofc_cty_cd")));
				woModel2.setPoTrspAgmtSeq(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_seq")));
				woModel2.setPoTrspAgmtRtTpCd(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_rt_tp_cd")));
				woModel2.setPoWayType(JSPUtil.getNull((String) outProc.get("po_way_type")));
				woModel2.setPoTrspAgmtRtTpNm(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_rt_tp_nm")));
//				woModel2.setPoSpType(JSPUtil.getNull((String) outProc.get("po_sp_type")));
				woModel2.setPoCustNomiTrkrFlg(JSPUtil.getNull((String) outProc.get("po_cust_nomi_trkr_flg")));
				woModel2.setPoCustCntCd(JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd")));
				woModel2.setPoCustSeq(JSPUtil.getNull((String) outProc.get("po_cust_seq")));
				woModel2.setPoCustCntCdSeq(JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd_seq")));
				if(cntFlg.equals("Y")){
//					woModel2.setPoCustNomiTrkrFlg("Y");
//					woModel2.setPoCustCntCd(JSPUtil.getNull(custCntCd));
//					woModel2.setPoCustSeq(JSPUtil.getNull(custSeq));
//					woModel2.setPoCustCntCdSeq(JSPUtil.getNull(custCntCd+custSeq));
					woModel2.setPoSpType("Y");								
				}else{
//					woModel2.setPoCustNomiTrkrFlg(JSPUtil.getNull((String) outProc.get("po_cust_nomi_trkr_flg")));
//					woModel2.setPoCustCntCd(JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd")));
//					woModel2.setPoCustSeq(JSPUtil.getNull((String) outProc.get("po_cust_seq")));
//					woModel2.setPoCustCntCdSeq(JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd_seq")));
					if(JSPUtil.getNull((String) outProc.get("po_sp_type")).equals("HJS")){
						woModel2.setPoSpType("N");						
					}else if(JSPUtil.getNull((String) outProc.get("po_sp_type")).equals("CNT")){
						woModel2.setPoSpType("Y");
					}else{
						woModel2.setPoSpType("N");
					}

				}
//				woModel2.setPoLocalCurrCd(JSPUtil.getNull((String) outProc.get("po_local_curr_cd")));  -- curr_cd 빈칸으로 조회되어 수정함. 09/11/30
				defalutCurrStr = JSPUtil.getNull((String) outProc.get("po_local_curr_cd"));
				if(defalutCurrStr == null || "".equals(defalutCurrStr)){
					defalutCurrStr = JSPUtil.getNull((String) woModel2.getCurrCd());
				}
				woModel2.setPoLocalCurrCd(defalutCurrStr);
				woModel2.setPoBasicRt(JSPUtil.getNull((String) outProc.get("po_basic_rt")));
				woModel2.setPoFuelScgRt(JSPUtil.getNull((String) outProc.get("po_fuel_scg_rt")));
				woModel2.setPoVatScgRt(JSPUtil.getNull((String) outProc.get("po_vat_scg_rt")));
				woModel2.setPoScg1Rt(JSPUtil.getNull((String) outProc.get("po_scg1_rt")));
				woModel2.setTollFeeAmt(JSPUtil.getNull((String) outProc.get("po_scg2_rt")));
				woModel2.setPoScg3Rt(JSPUtil.getNull((String) outProc.get("po_scg3_rt")));
				woModel2.setPoOverWgtScgRt(JSPUtil.getNull((String) outProc.get("po_over_wgt_scg_rt")));
				woModel2.setPoLocalCurrTotAmt(JSPUtil.getNull((String) outProc.get("po_local_curr_tot_amt")));
				woModel2.setPoUsdCurrTotAmt(JSPUtil.getNull((String) outProc.get("po_usd_curr_tot_amt")));
				woModel2.setPoRtnCd(JSPUtil.getNull((String) outProc.get("po_rtn_cd")));
				woModel2.setPoRtnMsg(JSPUtil.getNull((String) outProc.get("po_rtn_msg")));
				
				// Feeder Term이 0인 경우에는 null로 보여준다 2011.10.27 이수진
				if(JSPUtil.getNull((String) outProc.get("po_wtr_rcv_term_cd")).equals("0")){ 
					woModel2.setPoWtrRcvTermCd("");
				}else{
					woModel2.setPoWtrRcvTermCd(JSPUtil.getNull((String) outProc.get("po_wtr_rcv_term_cd")));
				}
				
				if(JSPUtil.getNull((String) outProc.get("po_wtr_de_term_cd")).equals("0")){ 
					woModel2.setPoWtrDeTermCd("");
				}else{
					woModel2.setPoWtrDeTermCd(JSPUtil.getNull((String) outProc.get("po_wtr_de_term_cd")));
				}
				
				//Special Cargo Available 적용
				//CHM-201432996 Special Cargo Available SP 신메뉴 개발
				rs4 =  new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOSearchSpclCgoRSQL(), param,param);
				while(rs4.next()){
					hzdMtrlFlg = rs4.getString("HZD_MTRL_FLG");
					ovwtTriAxlFlg = rs4.getString("OVWT_TRI_AXL_FLG");
				}
				woModel2.setHzdMtrlFlg(hzdMtrlFlg);
				woModel2.setOvwtTriAxlFlg(ovwtTriAxlFlg);
				
				woModel2.setPoCfmFlg(sTrspAgmtCfmFlg);
				woModel2.setPoAgmtRtSeq(sTrspAgmtRtSeq);
				woModel2.setPoAgmtUpdDt(sTrspAgmtUpdDt);
				
				woModel.set(m, woModel2);
				returnList.add(woModel);
			}

			if(list == null){
				list = woModel;
			}else{
				list.addAll(woModel);
			}	
			
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
	 * 
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public GeneralEventResponse searchSpSelectList(EsdTrs0091Event event) throws DAOException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dRs = null;
		//query parameter
//		EsdTrs0091EventResponse resultResponse = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList arrSoNoA = new ArrayList();
//		ArrayList resultV = new ArrayList();
		ArrayList returnList = new ArrayList();
		List<SpotBidWoIssueListVO> list = null;
		
//		StringTokenizer st = null;
		Map outProc = null;
		String cnt = "";
//		String arrSoNo = event.getSoNo();
		SpotBidWoIssueListVO[] models = event.getSpotBidWoIssueListVOs();
		String spTpCd = event.getSpTpCd();
		String vndrCd = event.getVndrCd();
//		String WTR_RCV_TERM = "";
//		String WY_TP_CD = event.getWyTpCd();
//		String CUST_CNT_CD = event.getCustCntCd();
//		String CUST_SEQ = event.getCustSeq();
		String creDtStr      = null;
		
		int k = models.length;
		for(int i=0; k>i ; i++){
		arrSoNoA.add(i,models[i].getTrspSoOfcCtyCd()+models[i].getTrspSoSeq());
		}
		param.put("SO_NO", arrSoNoA);
		param.put("SP_TP_CD", spTpCd);
		param.put("VNDR_CD", vndrCd);
		param.put("cnt", cnt);
//		log.error("arrSoNoA: "+arrSoNoA);
//		log.error("spTpCd: "+spTpCd);
//		log.error("vndrCd: "+vndrCd);
//		log.error("cnt: "+cnt);
		
		try {
			dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchSpSelectListRSQL(), param,param);
			
			List<SpotBidWoIssueListVO> woModel = (List)RowSetUtil.rowSetToVOs(dRs, SpotBidWoIssueListVO.class);
			
			for(int m=0; woModel != null && m<woModel.size(); m++){
				
				SpotBidWoIssueListVO woModel2 = woModel.get(m);
				
//				String bbb = woModel2.getCreDt();
//				CreDt = Date.valueOf(bbb.substring(0,4)+"-"+bbb.substring(4,6)+"-"+bbb.substring(6,8));

				
				param.put("CRE_OFC_CD",            woModel2.getCreOfcCd());            
				velParam.put("CRE_OFC_CD",         woModel2.getCreOfcCd());      
				
				param.put("VNDR_CD",               vndrCd);               
				velParam.put("VNDR_CD",               vndrCd);
				
				if("".equals(event.getBasisDt()) || event.getBasisDt() == null){
					creDtStr = woModel2.getCreDt();
				}else{
					creDtStr = JSPUtil.replace(event.getBasisDt(), "-", "");
				}
				param.put("CRE_DT",                creDtStr.substring(0,8));                
				velParam.put("CRE_DT",             creDtStr.substring(0,8));

				param.put("WY_TP_CD",              event.getWyTpCd());              
				velParam.put("WY_TP_CD",           event.getWyTpCd());
				
				param.put("EQ_KND_CD",              woModel2.getEqKndCd());              
				velParam.put("EQ_KND_CD",           woModel2.getEqKndCd());
				
				param.put("EQ_TPSZ_CD",            woModel2.getEqTpszCd());            
				velParam.put("EQ_TPSZ_CD",         woModel2.getEqTpszCd());
				
				param.put("TRSP_SO_CMB_TP_CD",     woModel2.getTrspSoCmbTpCd());     
				velParam.put("TRSP_SO_CMB_TP_CD",  woModel2.getTrspSoCmbTpCd());
				
				param.put("CGO_TP_CD",             woModel2.getCgoTpCd());             
				velParam.put("CGO_TP_CD",          woModel2.getCgoTpCd());
				
				param.put("TRSP_BND_CD",           woModel2.getTrspBndCd());           
				velParam.put("TRSP_BND_CD",        woModel2.getTrspBndCd());
				
				param.put("TRSP_CRR_MOD_CD",       woModel2.getTrspCrrModCd());       
				velParam.put("TRSP_CRR_MOD_CD",    woModel2.getTrspCrrModCd());
				
				param.put("TRSP_COST_DTL_MOD_CD",  woModel2.getTrspCostDtlModCd());  
				velParam.put("TRSP_COST_DTL_MOD_CD",woModel2.getTrspCostDtlModCd());
				
				if(event.getCustCntCd() == null){					
					param.put("CUST_NOMI_TRKR_FLG",    "N");    
					velParam.put("CUST_NOMI_TRKR_FLG", "N");
					
					param.put("CUST_CNT_CD",           "");           
					velParam.put("CUST_CNT_CD",        "");		
					
					param.put("CUST_SEQ",              "");              
					velParam.put("CUST_SEQ",           "");	
					
				}else{
					param.put("CUST_NOMI_TRKR_FLG",   "Y");    
					velParam.put("CUST_NOMI_TRKR_FLG", "Y");
					
					param.put("CUST_CNT_CD",           event.getCustCntCd());           
					velParam.put("CUST_CNT_CD",        event.getCustCntCd());
					
					param.put("CUST_SEQ",              event.getCustSeq());              
					velParam.put("CUST_SEQ",           event.getCustSeq());	
					
				}
				
				
				param.put("CMDT_CD",               woModel2.getCmdtCd());               
				velParam.put("CMDT_CD",            woModel2.getCmdtCd());
				
				param.put("FM_NOD_CD",             woModel2.getFmNodCd());             
				velParam.put("FM_NOD_CD",          woModel2.getFmNodCd());
				
				param.put("VIA_NOD_CD",            woModel2.getViaNodCd());            
				velParam.put("VIA_NOD_CD",         woModel2.getViaNodCd());
				
				param.put("DOR_NOD_CD",            woModel2.getDorNodCd());            
				velParam.put("DOR_NOD_CD",         woModel2.getDorNodCd());
				
				param.put("TO_NOD_CD",             woModel2.getToNodCd());             
				velParam.put("TO_NOD_CD",          woModel2.getToNodCd());
				
				param.put("BUNDLING_NO",           woModel2.getBundlingNo());           
				velParam.put("BUNDLING_NO",        woModel2.getBundlingNo());
				
				param.put("WGT_MEAS_UT_CD",        woModel2.getWgtMeasUtCd());        
				velParam.put("WGT_MEAS_UT_CD",     woModel2.getWgtMeasUtCd());

				param.put("CNTR_WGT",              woModel2.getCntrWgt());              
				velParam.put("CNTR_WGT",           woModel2.getCntrWgt());
				
				param.put("WTR_RCV_TERM",          event.getWtrRcvTerm());          
				velParam.put("WTR_RCV_TERM",       event.getWtrRcvTerm());
				
				param.put("WTR_DE_TERM",           event.getWtrDeTerm());           
				velParam.put("WTR_DE_TERM",        event.getWtrDeTerm());
				
				param.put("SPCL_CGO_CNTR_TP_CD",   woModel2.getSpclCgoCntrTpCd());           
				velParam.put("SPCL_CGO_CNTR_TP_CD",woModel2.getSpclCgoCntrTpCd());

//				log.error("woModel2.getCreOfcCd(): "+woModel2.getCreOfcCd());
//				log.error("vndrCd: "+vndrCd);
//				log.error("event.getBasisDt(): "+event.getBasisDt());
//				log.error("creDtStr.substring(0,8): "+creDtStr.substring(0,8));
//				log.error("event.getWyTpCd(): "+event.getWyTpCd());
//				log.error("woModel2.getEqKndCd(): "+woModel2.getEqKndCd());
//				log.error("woModel2.getEqTpszCd(): "+woModel2.getEqTpszCd());
//				log.error("woModel2.getTrspSoCmbTpCd(): "+woModel2.getTrspSoCmbTpCd());
//				log.error("woModel2.getCgoTpCd(): "+woModel2.getCgoTpCd());
//				log.error("woModel2.getTrspBndCd(): "+woModel2.getTrspBndCd());
//				log.error("woModel2.getTrspCrrModCd(): "+woModel2.getTrspCrrModCd());
//				log.error("woModel2.getTrspCostDtlModCd(): "+woModel2.getTrspCostDtlModCd());
//				log.error("event.getCustCntCd(): "+event.getCustCntCd());
//				log.error("woModel2.getCmdtCd(): "+woModel2.getCmdtCd());
//				log.error("event.getCustSeq(): "+event.getCustSeq());
//				log.error("woModel2.getFmNodCd(): "+woModel2.getFmNodCd());
//				log.error("woModel2.getViaNodCd(): "+woModel2.getViaNodCd());
//				log.error("woModel2.getDorNodCd(): "+woModel2.getDorNodCd());
//				log.error("woModel2.getToNodCd(): "+woModel2.getToNodCd());
//				log.error("woModel2.getBundlingNo(): "+woModel2.getBundlingNo());
//				log.error("woModel2.getWgtMeasUtCd(): "+woModel2.getWgtMeasUtCd());
//				log.error("woModel2.getCntrWgt(): "+woModel2.getCntrWgt());
//				log.error("event.getWtrRcvTerm(): "+event.getWtrRcvTerm());
//				log.error("event.getWtrDeTerm(): "+event.getWtrDeTerm());
//				log.error("woModel2.getSpclCgoCntrTpCd(): "+woModel2.getSpclCgoCntrTpCd());
				
				log.error("param: "+param);
				log.error("velParam: "+velParam);
				
				outProc = new SQLExecuter("DEFAULT").executeSP((ISQLTemplate)new WorkOrderIssueDBDAOsearchSpSelectListProcRSQL(), param, velParam);
				
				woModel2.setTrspSoOfcCtyCd(woModel2.getTrspSoOfcCtyCd());
				woModel2.setTrspSoSeq(woModel2.getTrspSoSeq());
				
				String sAgmtWord = JSPUtil.getNull((String) outProc.get("po_scg3_rt")).replaceAll("\\$", "\\,");
				String sTrspAgmtCfmFlg = "";
				String sTrspAgmtRtSeq = "";
				String sTrspAgmtUpdDt = "";
				if (sAgmtWord.length() > 0) {
					String[] AgmtWords = sAgmtWord.split(",");
					sTrspAgmtCfmFlg = AgmtWords[3];
					sTrspAgmtRtSeq = AgmtWords[4];
					sTrspAgmtUpdDt = AgmtWords[5];
				}

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
				woModel2.setPoVatScgRt(JSPUtil.getNull((String) outProc.get("po_vat_scg_rt")));
				woModel2.setPoScg1Rt(JSPUtil.getNull((String) outProc.get("po_scg1_rt")));
				woModel2.setTollFeeAmt(JSPUtil.getNull((String) outProc.get("po_scg2_rt")));
				woModel2.setPoScg3Rt(JSPUtil.getNull((String) outProc.get("po_scg3_rt")));
				woModel2.setPoOverWgtScgRt(JSPUtil.getNull((String) outProc.get("po_over_wgt_scg_rt")));
				woModel2.setPoLocalCurrTotAmt(JSPUtil.getNull((String) outProc.get("po_local_curr_tot_amt")));
				woModel2.setPoUsdCurrTotAmt(JSPUtil.getNull((String) outProc.get("po_usd_curr_tot_amt")));
				woModel2.setPoRtnCd(JSPUtil.getNull((String) outProc.get("po_rtn_cd")));
				woModel2.setPoRtnMsg(JSPUtil.getNull((String) outProc.get("po_rtn_msg")));
//				woModel2.setPoWtrRcvTermCd(JSPUtil.getNull((String) outProc.get("po_wtr_rcv_term_cd")));  //2011.10.17 이수진 추가
				if(JSPUtil.getNull((String) outProc.get("po_wtr_rcv_term_cd")).equals("0")){ 
					woModel2.setPoWtrRcvTermCd("");
				}else{
					woModel2.setPoWtrRcvTermCd(JSPUtil.getNull((String) outProc.get("po_wtr_rcv_term_cd")));
				}
//				woModel2.setPoWtrDeTermCd(JSPUtil.getNull((String) outProc.get("po_wtr_de_term_cd")));
				if(JSPUtil.getNull((String) outProc.get("po_wtr_de_term_cd")).equals("0")){ 
					woModel2.setPoWtrDeTermCd("");
				}else{
					woModel2.setPoWtrDeTermCd(JSPUtil.getNull((String) outProc.get("po_wtr_de_term_cd")));
				}
				woModel2.setPoCfmFlg(sTrspAgmtCfmFlg);
				woModel2.setPoAgmtRtSeq(sTrspAgmtRtSeq);
				woModel2.setPoAgmtUpdDt(sTrspAgmtUpdDt);

				woModel.set(m, woModel2);
				returnList.add(woModel);
			}

			if(list == null){
				list = woModel;
			}else{
				list.addAll(woModel);
			}	
			
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
	 * 
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
			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderIssueDBDAOSearchMdmOrganizationRSQL(), param,param);

			
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
	 * 
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchMoreCandidates(EsdTrs0921Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String basis_dt    = (String)event.getBasisDt() == null ? "" : JSPUtil.removeCharacter((String)event.getBasisDt(),"-").substring(0,8);
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

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderIssueDBDAOsearchMoreCandidatesRSQL(), param,param);
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
	 * 
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCntMoreCandidates(EsdTrs0980Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("sc_no",event.getSc_no());
			param.put("rfa_no",event.getRfa_no());
			param.put("trsp_bnd_cd",event.getTrsp_bnd_cd());
			param.put("fm_nod_cd",event.getFm_nod_cd());
			param.put("fm_nod_yard",event.getFm_nod_yard());
			param.put("to_nod_cd",event.getTo_nod_cd());
			param.put("to_nod_yard",event.getTo_nod_yard());
			param.put("dor_nod_cd",event.getDor_nod_cd());
			param.put("dor_nod_yard",event.getDor_nod_yard());
			param.put("ctrl_ofc_cd",event.getCtrl_ofc_cd());
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderIssueDBDAOSearchCntMoreCandidatesRSQL(), param,param);
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
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLocalCurr2UsdCurr(EsdTrs0091Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			String localTotAmt = event.getLocalTotAmt();
			String currCd = event.getLocalCurrCd();
			String formUsrOfcCd = event.getFormUsrOfcCd();
			
			param.put("LOCAL_TOT_AMT", localTotAmt);
			param.put("CURR_CD", currCd);
			param.put("FORM_USR_OFC_CD", formUsrOfcCd);			
			
			dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchLocalCurr2UsdCurrRSQL(), param,param);
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
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public ArrayList setFrustrate(EsdTrs0091Event event) throws DAOException {

		SpotBidWoIssueListVO[] model = event.getSpotBidWoIssueListVOs();
		//query parameter

		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList returnArray = new ArrayList();
//		ArrayList<String> arrSoNoA = new ArrayList();


		String form_usr_ofc_cd		= event.getFormUsrOfcCd();
		String form_cre_usr_id		= event.getFormCreUsrId();

		try {
			
			if( model != null && model.length > 0 ){
				for( int i=0; i<model.length; i++ ){
					param.put("form_usr_ofc_cd", form_usr_ofc_cd);
					param.put("form_cre_usr_id", form_cre_usr_id);
					param.put("trsp_so_ofc_cty_cd", model[i].getTrspSoOfcCtyCd());
					param.put("trsp_so_seq", model[i].getTrspSoSeq());
			
					new SQLExecuter().executeUpdate(new WorkOrderIssueDBDAOsetFrustrateSoUSQL(), param,param);
					new SQLExecuter().executeUpdate(new WorkOrderIssueDBDAOsetFrustrateSceUSQL(), param,param);
				
					/** 이하 TRO I/F 삭제됨 
					/** Frustrate 상태를 TRO롤 I/F 할때 사용할 OBJECT SETTING 시작 **/
//					TrsTrspSvcOrdVO soModel = new TrsTrspSvcOrdVO();
//					soModel.setTrspSoOfcCtyCd(model[i].getTrspSoOfcCtyCd());
//					soModel.setTrspSoSeq(model[i].getTrspSoSeq());
//					returnArray.add(soModel);
					/** Frustrate 상태를 TRO롤 I/F 할때 사용할 OBJECT SETTING 끝 **/
					
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
	 * Appointment/Delivery Time 저장 처리를 한다.<br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public ArrayList setAppDeli(EsdTrs0091Event event) throws DAOException {

		TrsTrspSvcOrdVO[] model = event.getTrsTrspSvcOrdVOs();

		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList returnArray = new ArrayList();
		
		String form_usr_ofc_cd		= event.getFormUsrOfcCd();
		String form_cre_usr_id		= event.getFormCreUsrId();

		try {
			
			if( model != null && model.length > 0 ){								
				for( int i=0; i<model.length; i++ ){
					param.put("form_usr_ofc_cd", form_usr_ofc_cd);
					param.put("form_cre_usr_id", form_cre_usr_id);
					
					param.put("apnt_dt", model[i].getApntDt());
					param.put("de_dt", model[i].getDeDt());					
					param.put("eq_no", model[i].getEqNo());
					param.put("eq_tpsz_cd", model[i].getEqTpszCd());
					param.put("n3pty_bil_flg", model[i].getN3ptyBilFlg());
					param.put("trsp_bnd_cd", model[i].getTrspBndCd());
					param.put("curr_cd", model[i].getCurrCd());					
					param.put("fm_nod_cd",model[i].getFmNodCd());
					param.put("to_nod_cd",model[i].getToNodCd());
									
					new SQLExecuter().executeUpdate(new WorkOrderIssueDBDAOsetAppDeliUSQL(), param,param);					
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
	 * Curr Code / Nego Amount 저장 처리를 한다.<br>
	 * 
	 * @param EsdTrs0091Event event
	 * @return ArrayList
	 * @throws DAOException
	 */
	public ArrayList modifyCurrNego(EsdTrs0091Event event) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet seqRs = null;
		ArrayList returnArray = new ArrayList();
		
		TrsTrspSvcOrdVO[] model = event.getTrsTrspSvcOrdVOs();
		String usrOfcCd		= event.getFormUsrOfcCd();
		String creUsrId		= event.getFormCreUsrId();
		String groupSeq = "";
		
		try {
			
			if( model != null && model.length > 0 ){								
				for( int i=0; i<model.length; i++ ){
					if(!(model[i].getCurrCd().equalsIgnoreCase(model[i].getOrgCurrCd()) && model[i].getNegoAmt().equalsIgnoreCase(model[i].getOrgNegoAmt()))){
						
						param.put("form_usr_ofc_cd", usrOfcCd);
						param.put("form_cre_usr_id", creUsrId);
						
						param.put("curr_cd", model[i].getCurrCd());		
						param.put("nego_amt", model[i].getNegoAmt());					
						param.put("trsp_so_ofc_cty_cd",model[i].getTrspSoOfcCtyCd());
						param.put("trsp_so_seq",model[i].getTrspSoSeq());
						
						/***** CurrNego Update 시작*****/
						int updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderIssueDBDAOmodifyCurrNegoUSQL(), param,param);
						if(updCnt == Statement.EXECUTE_FAILED){
							throw new DAOException("Fail to update SQL");
						}
						/***** CurrNego Update 끝*****/	
						
						if("".equalsIgnoreCase(groupSeq)){
							/***** SEQ NO 가져오기 시작*****/
							// 데이터 전송을 위해 DB ResultSet을 구현한 객체
							seqRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderIssueDBDAOsearchWorkOrderPreviewTmpSeqRSQL(), param, param);
							seqRs.next();
							groupSeq = seqRs.getString("group_seq");
							/***** SEQ NO 가져오기 끝*****/	
						}
						param.put("wo_prv_grp_seq", groupSeq);
						
						/***** WorkOrderPreviewTemp Insert 시작*****/
						int insCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderIssueDBDAOaddWorkOrderPreviewTempCSQL(), param, param);
						if(insCnt == Statement.EXECUTE_FAILED){
							throw new DAOException("Fail to insert SQL");
						}
						/***** WorkOrderPreviewTemp Insert 끝*****/	
						
						param.clear();
					}
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
	 * 
	 * @param woVO
	 * @return
	 * @throws DAOException
	 */
	public ArrayList searchSurchargeList(List<SpotBidWoIssueListVO> woVO) throws DAOException {
		DBRowSet dRs = null;
//		ResultSet rs = null;
		ArrayList returnArr = new ArrayList();
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList arrSoNo = new ArrayList();

		try {
			int m = woVO.size();
			for(int i=0; woVO != null && i < m ; i++){
				String trspSoOfcCtyCd = woVO.get(i).getTrspSoOfcCtyCd();
				String trspSoSeq = woVO.get(i).getTrspSoSeq();	
				arrSoNo.add(i, trspSoOfcCtyCd+trspSoSeq);
			}
			param.put("SoNo", arrSoNo);
			dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchSurchargeListRSQL(), param,param);
			
			returnArr.add(dRs);
			
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
	 * 
	 * @param scgRs
	 * @return ArrayList
	 * @throws DAOException
	 */	
	public ArrayList searchSurchargeList(DBRowSet scgRs) throws DAOException {
		DBRowSet dRs = null;
//		ResultSet rs = null;
		ArrayList returnArr = new ArrayList<DBRowSet>();
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList arrSoNo = new ArrayList();

		try {
			int i=0;
			if( scgRs.getRowCount()>0 ){
				while(scgRs.next()){
					String trspSoOfcCtyCd = scgRs.getString("TRSP_SO_OFC_CTY_CD");
					String trspSoSeq = scgRs.getString("TRSP_SO_SEQ");	
					arrSoNo.add(i++, trspSoOfcCtyCd + trspSoSeq);
				}
				param.put("SoNo", arrSoNo);
				dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderIssueDBDAOsearchSurchargeListRSQL(), param,param);
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
	 * String Util.<br>
	 * 
	 * @return String 결과 값
	 * @throws DAOException
	 */
//	private String getRPAD(String src, int len, String padStr){
//		String tgt = null;
//		String tempStr = "";
//		if(src == null) src = "";
//		if(padStr == null || src.length() >= len) tgt = src;
//		else {
//			padStr = padStr.substring(0,1);
//			int padCnt = len - src.length();
//			for(int i=0; i<padCnt; i++) tempStr =tempStr + padStr;
//			tgt = src+tempStr;
//		}
//	
//		return tgt;
//	}
	
	/**
	 * 3RD PARTY BASIC INTERFACE BILLING CASE 목록을 가져온다.<br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchBillingCaseCode() throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();


		try {
			dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchBillingCaseCodeRSQL(), param,param);
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
	 * 
	 * @param event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchTpbBasicAmt(EsdTrs0091Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			
			String trspSoOfcCtyCd = event.getTrspSoOfcCtyCd();
			String trspSoSeq = event.getTrspSoSeq();
			
			param.put("TRSP_SO_OFC_CTY_CD", trspSoOfcCtyCd);
			param.put("TRSP_SO_SEQ", trspSoSeq);
			
			dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchTpbBasicAmtRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	   }
	

/*
 * 1.112 N200901090011 W/O Issue 화면 보완요청
 */
/**
 * Work Order Issued S/O NO 목록을 가져온다.<br>
 * 
 * @param event
 * @return DBRowSet DB 처리 결과
 * @throws DAOException
 */
	public DBRowSet searchWoIssuedSoList(EsdTrs0091Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			
			String wo_prv_grp_seq = event.getWoPrvGrpSeq();
			String wo_iss_no = event.getWoIssNo();
			
			param.put("wo_prv_grp_seq", wo_prv_grp_seq);
			param.put("wo_iss_no", wo_iss_no);
			
			dRs = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchWoIssuedSoListRSQL(), param,param);
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
	 * Bundling List 의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return List<BundlingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BundlingListVO> searchBundlingList(EsdTrs0963Event event) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BundlingListVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList<String> arrSoNo = new ArrayList<String>();
		
		TrsTrspSvcOrdVO [] trsTrspSvcOrdVOs = event.getTrsTrspSvcOrdVOs();
		
		String so = "";
		
		try {
			
			for(int f=0; trsTrspSvcOrdVOs != null && f < trsTrspSvcOrdVOs.length; f++){
				so = trsTrspSvcOrdVOs[f].getTrspSoOfcCtyCd()+trsTrspSvcOrdVOs[f].getTrspSoSeq();
				arrSoNo.add(f, so);
			}
			param.put("so_no_a",arrSoNo);
			
//			dbRowset = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOSearchBundlingListRSQL(), param,param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WorkOrderIssueDBDAOSearchBundlingListRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BundlingListVO .class);
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
		return list;
	}
	/**
	 * bkg_xter_rqst_mst에 bkg_upld_sts_cd를 newSts로 update한다.<br>
	 * newSts가 'D'일 경우 rqst_delt_flg를 'y'로 update한다.<br>
	 *
	 * @param String userId
	 * @param List<BundlingListVO> bundlingListVO
	 * @param String gpYn
	 * @exception DAOException
	 */
	public void setBundling(String userId, List<BundlingListVO> bundlingListVO, String gpYn) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("gp_yn", gpYn);
			velParam.put("gp_yn", gpYn);
			param.put("usr_id", userId);
			velParam.put("usr_id", userId);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(bundlingListVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new WorkOrderIssueDBDAOsetBundlingUSQL(), bundlingListVO, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**   
	 * WorkOrderPreview 시행 전에 issue 상태체크 조회
	 * @param event
	 * @return dbRowset
	 * @throws DAOException
	 */
	public DBRowSet searchWorkOrderPreviewStatusCheck(EsdTrs0091Event event) throws DAOException{
	  
	    DBRowSet dbRowset=null;   
	    String r_sonumber = JSPUtil.getNull(event.getTrspSoNo());
		Map<String, Object> param = new HashMap<String, Object>(); 
		List<String> trspSoNo = new ArrayList();
		try {  			
		if(!r_sonumber.equals("")){
		
			String arrSoNo[] =(r_sonumber.split(","));
			for(int i=0;i<arrSoNo.length;i++){  
				trspSoNo.add(arrSoNo[i]);							
			} 
			param.put("r_sonumber",trspSoNo);	
				
        	dbRowset = new SQLExecuter("").executeQuery(new WorkOrderIssueDBDAOsearchWorkOrderPreviewStatusCheckRSQL(), param, param); 
    	 }
		}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 			
		return dbRowset;

	}
	
	/**
	 * WorkOrderIssue의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public GeneralEventResponse searchReRateApplyList(EsdTrs0091Event event) throws DAOException {		

		Map outProc 	= null;
		List rtnArr 	= new ArrayList();
		
		Map<String, Object> param 			= new HashMap<String, Object>();
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();		
		SpotBidWoIssueListVO[] model 			= event.getSpotBidWoIssueListVOs();
													
		try {
			
			param.clear();
			
			for(int m=0; model != null && m<model.length; m++){
				
				param.put("CRE_OFC_CD",            model[m].getCreOfcCd());      
				param.put("VNDR_CD",               model[m].getVndrSeq());               
				param.put("CRE_DT",                model[m].getCreDt().substring(0,8));                
				param.put("WY_TP_CD",              model[m].getTrspAgmtWyTpCd());              
				param.put("EQ_KND_CD",              model[m].getEqKndCd());              
				param.put("EQ_TPSZ_CD",            model[m].getEqTpszCd());            
				param.put("TRSP_SO_CMB_TP_CD",     model[m].getTrspSoCmbTpCd());     
				param.put("CGO_TP_CD",             model[m].getCgoTpCd());             
				param.put("TRSP_BND_CD",           model[m].getTrspBndCd());           
				param.put("TRSP_CRR_MOD_CD",       model[m].getTrspCrrModCd());       
				param.put("TRSP_COST_DTL_MOD_CD",  model[m].getTrspCostDtlModCd());  
				param.put("CUST_NOMI_TRKR_FLG",    model[m].getCustNomiTrkrFlg());    
				param.put("CUST_CNT_CD",           model[m].getCustCntCd());           
				param.put("CUST_SEQ",              model[m].getCustSeq());              
				param.put("RAIL_SSVC_TP_CD",        "");              
				param.put("CMDT_CD",               model[m].getCmdtCd());               
				param.put("FM_NOD_CD",             model[m].getFmNodCd());             
				param.put("VIA_NOD_CD",            model[m].getViaNodCd());            
				param.put("DOR_NOD_CD",            model[m].getDorNodCd());            
				param.put("TO_NOD_CD",             model[m].getToNodCd());             
				param.put("BUNDLING_NO",           model[m].getBundlingNo());           
				param.put("WGT_MEAS_UT_CD",        model[m].getWgtMeasUtCd());        
				param.put("CNTR_WGT",              model[m].getCntrWgt());              
				param.put("SPCL_CGO_CNTR_TP_CD",   model[m].getSpclCgoCntrTpCd());              
				param.put("WTR_RCV_TERM",          "");          
				param.put("WTR_DE_TERM",           null);           
				
				outProc = new SQLExecuter("DEFAULT").executeSP((ISQLTemplate)new WorkOrderIssueDBDAOsearchWorkOrderIssueListProcRSQL(), param, param);
				param.clear();
				String sAgmtWord = JSPUtil.getNull((String) outProc.get("po_scg3_rt")).replaceAll("\\$", "\\,");
				String sTrspAgmtCfmFlg = "";
				String sTrspAgmtRtSeq = "";
				String sTrspAgmtUpdDt = "";
				if (sAgmtWord.length() > 0) {
					String[] AgmtWords = sAgmtWord.split(",");
					sTrspAgmtCfmFlg = AgmtWords[3];
					sTrspAgmtRtSeq = AgmtWords[4];
					sTrspAgmtUpdDt = AgmtWords[5];
				}
					
				String po_cust_cnt_cd 	= JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd"));
				String po_cust_seq 		= JSPUtil.getNull((String) outProc.get("po_cust_seq"));
		
				SpotBidWoIssueListVO rateApplyVO = new SpotBidWoIssueListVO();
				
				log.debug("=======>"+model[m].getTrspSoOfcCtyCdSeq());
				rateApplyVO.setTrspSoOfcCtyCdSeq(	model[m].getTrspSoOfcCtyCdSeq());
				
				
				rateApplyVO.setPoTrspAgmtOfcCtyCd	(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_ofc_cty_cd")));
				rateApplyVO.setPoTrspAgmtSeq		(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_seq")));
				rateApplyVO.setPoTrspAgmtRtTpCd		(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_rt_tp_cd")));
				rateApplyVO.setPoWayType			(JSPUtil.getNull((String) outProc.get("po_way_type")));
				rateApplyVO.setPoTrspAgmtRtTpNm		(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_rt_tp_nm")));
				rateApplyVO.setPoSpType				(JSPUtil.getNull((String) outProc.get("po_sp_type")));
				rateApplyVO.setPoCustNomiTrkrFlg	(JSPUtil.getNull((String) outProc.get("po_cust_nomi_trkr_flg")));
				rateApplyVO.setPoCustCntCd			(po_cust_cnt_cd);
				rateApplyVO.setPoCustSeq			(po_cust_seq);
				rateApplyVO.setPoCustCntCdSeq		(po_cust_cnt_cd+po_cust_seq);
				rateApplyVO.setPoLocalCurrCd		(JSPUtil.getNull((String) outProc.get("po_local_curr_cd")));
				rateApplyVO.setPoBasicRt			(JSPUtil.getNull((String) outProc.get("po_basic_rt")));
				rateApplyVO.setPoFuelScgRt			(JSPUtil.getNull((String) outProc.get("po_fuel_scg_rt")));
				rateApplyVO.setPoOverWgtScgRt		(JSPUtil.getNull((String) outProc.get("po_over_wgt_scg_rt")));
				rateApplyVO.setPoVatScgRt			(JSPUtil.getNull((String) outProc.get("po_vat_scg_rt")));
				rateApplyVO.setPoScg1Rt				(JSPUtil.getNull((String) outProc.get("po_scg1_rt")));
				rateApplyVO.setTollFeeAmt			(JSPUtil.getNull((String) outProc.get("po_scg2_rt")));
				rateApplyVO.setPoScg3Rt				(JSPUtil.getNull((String) outProc.get("po_scg3_rt")));
				rateApplyVO.setPoLocalCurrTotAmt	(JSPUtil.getNull((String) outProc.get("po_local_curr_tot_amt")));
				rateApplyVO.setPoUsdCurrTotAmt		(JSPUtil.getNull((String) outProc.get("po_usd_curr_tot_amt")));
				rateApplyVO.setPoRtnCd				(JSPUtil.getNull((String) outProc.get("po_rtn_cd")));
				rateApplyVO.setPoRtnMsg				(JSPUtil.getNull((String) outProc.get("po_rtn_msg")));
				rateApplyVO.setPoWtrRcvTermCd       (JSPUtil.getNull((String) outProc.get("po_wtr_rcv_term_cd"))); //2011.10.19 이수진 추가
				rateApplyVO.setPoWtrDeTermCd        (JSPUtil.getNull((String) outProc.get("po_wtr_de_term_cd")));
				rateApplyVO.setPoCfmFlg(sTrspAgmtCfmFlg);
				rateApplyVO.setPoAgmtRtSeq(sTrspAgmtRtSeq);
				rateApplyVO.setPoAgmtUpdDt(sTrspAgmtUpdDt);   
				rtnArr.add(rateApplyVO);
			}
			eventResponse.setRsVoList(rtnArr);

			return eventResponse;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}

	/**   
	 * WorkOrderPreview 시행 전에 issue 상태체크 조회
	 * @param event
	 * @return dbRowset
	 * @throws DAOException
	 */
	public DBRowSet searchMoreBidder(EsdTrs0091Event event) throws DAOException{

	    DBRowSet dbRowset=null;   
		Map<String, Object> param = new HashMap<String, Object>();

		String spotBidNo = event.getSpotBidNo();

		try {
			param.put("spot_bid_no", spotBidNo);
        	dbRowset = new SQLExecuter("").executeQuery(new SpotBidWorkOrderIssueDBDAOsearchWorkOrderBidVndrListRSQL(), param, param);
		}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dbRowset;
	}
}	
