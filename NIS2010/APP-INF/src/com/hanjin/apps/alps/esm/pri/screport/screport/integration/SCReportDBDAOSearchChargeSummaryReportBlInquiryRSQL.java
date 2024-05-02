/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCReportDBDAOSearchChargeSummaryReportBlInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2015.06.25 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAOSearchChargeSummaryReportBlInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Charge Summary Report - BL Inquiry 조회한다.
	  * 2013.06.17 송호진 [CHM-201324516] Detail View 와 B/L Inquiry 사이의 Route 비교 일치 ( COA -> BKG )
	  * 2013.06.24 송호진 [CHM-201324516] MDM_CHARGE 에 새로 추가된 MDT_RAT_FLG 적용
	  * 2013.07.04 전윤주 [CHM-201325625] Customer Classification 조건을 CC, RC, LC로 수정
	  * 2014.06.02 최성환 [CHM-201430519]Charge Summary Report 로직 보완 요청
	  * 2015.06.30 최성환 [CHM-201536493] Split03-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public SCReportDBDAOSearchChargeSummaryReportBlInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sls_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_clss",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rvis_cntr_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("per_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAOSearchChargeSummaryReportBlInquiryRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("#if(${f_excel} == 'Y')" ).append("\n"); 
		query.append("SELECT 'MONTH' COST_YRMON" ).append("\n"); 
		query.append("      ,'WEEK' COST_WK" ).append("\n"); 
		query.append("      ,'TRADE' TRD_CD" ).append("\n"); 
		query.append("      ,'SUB-TRADE' SUB_TRD_CD" ).append("\n"); 
		query.append("      ,'SCOPE' SVC_SCP_CD" ).append("\n"); 
		query.append("      ,'RHQ' REGION" ).append("\n"); 
		query.append("      ,'C.OFC' CTRT_OFC_CD" ).append("\n"); 
		query.append("      ,'DIR(BOUND)' DIR_CD" ).append("\n"); 
		query.append("      ,'LANE' RLANE_CD" ).append("\n"); 
		query.append("      ,'TRUNK VVD' VVD_CD" ).append("\n"); 
		query.append("      ,'BOOKING NO.' BKG_NO" ).append("\n"); 
		query.append("      ,'CONTRACT NO.' CTRT_NO" ).append("\n"); 
		query.append("      ,'CUSTOMER CODE' CUST_CD" ).append("\n"); 
		query.append("      ,'CUSTOMER DESCRIPTION' CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,'TEU' TEU" ).append("\n"); 
		query.append("      ,'FEU' FEU" ).append("\n"); 
		query.append("      ,'POR' BKG_POR_CD" ).append("\n"); 
		query.append("      ,'POL COUNTRY' POL_CNT_CD" ).append("\n"); 
		query.append("      ,'POL' BKG_POL_CD" ).append("\n"); 
		query.append("      ,'POD' POD_CNT_CD" ).append("\n"); 
		query.append("      ,'POD COUNTRY' BKG_POD_CD" ).append("\n"); 
		query.append("      ,'DEL' BKG_DEL_CD" ).append("\n"); 
		query.append("      ,'R/D TERM' RD_TERM_CD" ).append("\n"); 
		query.append("      ,'SURCHARGE TYPE' REP_CHG_CD" ).append("\n"); 
		query.append("      ,'PAYMENT' FRT_TERM_CD" ).append("\n"); 
		query.append("      ,'SURCHARGE CODE' CHG_CD" ).append("\n"); 
		query.append("      ,'MANDATORY RATING' MDTR_CD" ).append("\n"); 
		query.append("      ,'PER' PER_CD" ).append("\n"); 
		query.append("      ,'CARGO TYPE' CGO_CATE_CD" ).append("\n"); 
		query.append("      ,'CUR.' CURR_CD" ).append("\n"); 
		query.append("      ,'TARIFF TOTAL' TRF_USD_CHG_AMT" ).append("\n"); 
		query.append("      ,'RATING TOTAL'  RAT_CHG_AMT" ).append("\n"); 
		query.append("      ,'COLLECTION RATIO(%)' CLT_RATIO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT COST_YRMON" ).append("\n"); 
		query.append("      ,COST_WK" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,SVC_SCP_CD" ).append("\n"); 
		query.append("      ,REGION" ).append("\n"); 
		query.append("      ,CTRT_OFC_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,VVD_CD" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,CTRT_NO" ).append("\n"); 
		query.append("      ,CUST_CD" ).append("\n"); 
		query.append("      ,CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(TEU) TEU" ).append("\n"); 
		query.append("      ,TO_CHAR(FEU) FEU" ).append("\n"); 
		query.append("      ,BKG_POR_CD" ).append("\n"); 
		query.append("      ,POL_CNT_CD" ).append("\n"); 
		query.append("      ,BKG_POL_CD" ).append("\n"); 
		query.append("      ,POD_CNT_CD" ).append("\n"); 
		query.append("      ,BKG_POD_CD" ).append("\n"); 
		query.append("      ,BKG_DEL_CD" ).append("\n"); 
		query.append("      ,RD_TERM_CD" ).append("\n"); 
		query.append("      ,REP_CHG_CD" ).append("\n"); 
		query.append("      ,FRT_TERM_CD" ).append("\n"); 
		query.append("      ,CHG_CD" ).append("\n"); 
		query.append("      ,MDTR_CD" ).append("\n"); 
		query.append("      ,PER_CD" ).append("\n"); 
		query.append("      ,CGO_CATE_CD" ).append("\n"); 
		query.append("      ,CURR_CD" ).append("\n"); 
		query.append("      ,TRF_USD_CHG_AMT" ).append("\n"); 
		query.append("      ,RAT_CHG_AMT" ).append("\n"); 
		query.append("      ,TRIM(TO_CHAR(TO_NUMBER(REPLACE(RAT_CHG_AMT,',',''))/REPLACE(trf_usd_chg_amt,',','') * 100,'99,999,999,999,990.9')) CLT_RATIO" ).append("\n"); 
		query.append("FROM      " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT COST_YRMON" ).append("\n"); 
		query.append("      ,COST_WK" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,SVC_SCP_CD" ).append("\n"); 
		query.append("      ,REGION" ).append("\n"); 
		query.append("      ,CTRT_OFC_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,VVD_CD" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,CTRT_NO" ).append("\n"); 
		query.append("      ,CUST_CD" ).append("\n"); 
		query.append("      ,CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("#if(${f_excel} == 'Y')" ).append("\n"); 
		query.append("      ,TO_CHAR(TEU) TEU" ).append("\n"); 
		query.append("      ,TO_CHAR(FEU) FEU" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,TEU" ).append("\n"); 
		query.append("      ,FEU" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,BKG_POR_CD" ).append("\n"); 
		query.append("      ,POL_CNT_CD" ).append("\n"); 
		query.append("      ,BKG_POL_CD" ).append("\n"); 
		query.append("      ,POD_CNT_CD" ).append("\n"); 
		query.append("      ,BKG_POD_CD" ).append("\n"); 
		query.append("      ,BKG_DEL_CD" ).append("\n"); 
		query.append("      ,RD_TERM_CD" ).append("\n"); 
		query.append("      ,REP_CHG_CD" ).append("\n"); 
		query.append("      ,FRT_TERM_CD" ).append("\n"); 
		query.append("      ,CHG_CD " ).append("\n"); 
		query.append("      ,DECODE ( MDT_RAT_FLG, 'Y','YES','N','NO' ) AS MDTR_CD" ).append("\n"); 
		query.append("       --User 의 요청에 따라 CNTR_SZ_CD 가 2,4,7 에 해당하지 않은 RAT_UT_CD 는 그대로 표시" ).append("\n"); 
		query.append("      ,DISP_PER_CD AS PER_CD" ).append("\n"); 
		query.append("--    ,DECODE(PER_CD, 'OT', 'Other', PER_CD) PER_CD" ).append("\n"); 
		query.append("      ,CGO_CATE_CD" ).append("\n"); 
		query.append("      ,CURR_CD" ).append("\n"); 
		query.append("#if(${f_excel} == 'Y')" ).append("\n"); 
		query.append("      ,TRIM(TO_CHAR(NVL(SUM(TRF_USD_CHG_AMT),0),'99,999,999,999,990.99')) TRF_USD_CHG_AMT" ).append("\n"); 
		query.append("      ,TRIM(TO_CHAR(NVL((SELECT SUM(CHG_AMT)" ).append("\n"); 
		query.append("         FROM BKG_CHG_RT C2" ).append("\n"); 
		query.append("        WHERE C2.BKG_NO = C1.BKG_NO            " ).append("\n"); 
		query.append("          AND C2.CHG_CD = C1.CHG_CD" ).append("\n"); 
		query.append("                       --TRF RAT UT CODE를 PER 기준으로 환산하여 JOIN 함" ).append("\n"); 
		query.append("          AND (DECODE((SELECT DECODE(RAT_UT_CD, 'BX', 'BX', 'BL', 'BL', CNTR_SZ_CD)" ).append("\n"); 
		query.append("                       FROM PRI_RAT_UT" ).append("\n"); 
		query.append("                     WHERE RAT_UT_CD(+) = C2.RAT_UT_CD) " ).append("\n"); 
		query.append("                           ,'2', '20'" ).append("\n"); 
		query.append("                           ,'4', '40'" ).append("\n"); 
		query.append("                           ,'7', '45'" ).append("\n"); 
		query.append("                           ,'BX','BX'" ).append("\n"); 
		query.append("                           ,'BL','BL' " ).append("\n"); 
		query.append("                           ,'OT') = C1.PER_CD" ).append("\n"); 
		query.append("				 OR C1.PER_CD  IN ( 'BX', 'BL' )" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         AND C2.CGO_CATE_CD = C1.CGO_CATE_CD" ).append("\n"); 
		query.append("         AND C2.FRT_INCL_XCLD_DIV_CD <> 'I'" ).append("\n"); 
		query.append("      ),0),'99,999,999,999,990.99')) RAT_CHG_AMT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,SUM(TRF_USD_CHG_AMT) TRF_USD_CHG_AMT" ).append("\n"); 
		query.append("      ,(SELECT SUM(CHG_AMT)" ).append("\n"); 
		query.append("         FROM BKG_CHG_RT C2" ).append("\n"); 
		query.append("        WHERE C2.BKG_NO = C1.BKG_NO            " ).append("\n"); 
		query.append("          AND C2.CHG_CD = C1.CHG_CD" ).append("\n"); 
		query.append("		  --TRF RAT UT CODE를 PER 기준으로 환산하여 JOIN 함" ).append("\n"); 
		query.append("          AND (DECODE((SELECT DECODE(RAT_UT_CD, 'BX', 'BX', 'BL', 'BL', CNTR_SZ_CD)" ).append("\n"); 
		query.append("                       FROM PRI_RAT_UT" ).append("\n"); 
		query.append("                      WHERE RAT_UT_CD(+) = C2.RAT_UT_CD) " ).append("\n"); 
		query.append("                           ,'2', '20'" ).append("\n"); 
		query.append("                           ,'4', '40'" ).append("\n"); 
		query.append("                           ,'7', '45'" ).append("\n"); 
		query.append("                           ,'BX','BX'" ).append("\n"); 
		query.append("                           ,'BL','BL' " ).append("\n"); 
		query.append("                           ,'OT') = C1.PER_CD" ).append("\n"); 
		query.append("				 OR C1.PER_CD  IN ( 'BX', 'BL' )" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         AND C2.CGO_CATE_CD = C1.CGO_CATE_CD" ).append("\n"); 
		query.append("         AND C2.FRT_INCL_XCLD_DIV_CD <> 'I'" ).append("\n"); 
		query.append("      ) RAT_CHG_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT B1.COST_YRMON" ).append("\n"); 
		query.append("              ,B1.COST_WK" ).append("\n"); 
		query.append("              ,B1.TRD_CD" ).append("\n"); 
		query.append("              ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("              ,B1.SVC_SCP_CD" ).append("\n"); 
		query.append("              ,B1.REGION" ).append("\n"); 
		query.append("              ,B1.CTRT_OFC_CD" ).append("\n"); 
		query.append("              ,B1.DIR_CD" ).append("\n"); 
		query.append("              ,B1.RLANE_CD" ).append("\n"); 
		query.append("              ,B1.VVD_CD" ).append("\n"); 
		query.append("              ,B1.BKG_NO" ).append("\n"); 
		query.append("              ,B1.CTRT_NO" ).append("\n"); 
		query.append("              ,B1.CUST_CD" ).append("\n"); 
		query.append("              ,B1.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("              ,B1.TEU" ).append("\n"); 
		query.append("              ,B1.FEU" ).append("\n"); 
		query.append("              ,B1.BKG_POR_CD" ).append("\n"); 
		query.append("              ,B1.POL_CNT_CD" ).append("\n"); 
		query.append("              ,B1.BKG_POL_CD" ).append("\n"); 
		query.append("              ,B1.POD_CNT_CD" ).append("\n"); 
		query.append("              ,B1.BKG_POD_CD" ).append("\n"); 
		query.append("              ,B1.BKG_DEL_CD" ).append("\n"); 
		query.append("              ,B1.RD_TERM_CD" ).append("\n"); 
		query.append("              ,B3.REP_CHG_CD" ).append("\n"); 
		query.append("              ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02318' AND INTG_CD_VAL_CTNT(+) = B2.FRT_TERM_CD) FRT_TERM_CD " ).append("\n"); 
		query.append("              ,B2.CHG_CD" ).append("\n"); 
		query.append("              ,B3.MDT_RAT_FLG " ).append("\n"); 
		query.append("              --User 의 요청에 따라 CNTR_SZ_CD 가 2,4,7 에 해당하지 않은 RAT_UT_CD 는 그대로 표시" ).append("\n"); 
		query.append("              ,( SELECT  DECODE ( CNTR_SZ_CD, '2', '20', '4', '40', '7', '45', RAT_UT_CD ) " ).append("\n"); 
		query.append("                 FROM    PRI_RAT_UT" ).append("\n"); 
		query.append("                 WHERE   RAT_UT_CD(+) = B2.RAT_UT_CD ) DISP_PER_CD" ).append("\n"); 
		query.append("              ,DECODE((SELECT DECODE(RAT_UT_CD, 'BX', 'BX', 'BL', 'BL', CNTR_SZ_CD)" ).append("\n"); 
		query.append("                              FROM PRI_RAT_UT" ).append("\n"); 
		query.append("                                WHERE RAT_UT_CD(+) = B2.RAT_UT_CD) " ).append("\n"); 
		query.append("                             ,'2', '20'" ).append("\n"); 
		query.append("                             ,'4', '40'" ).append("\n"); 
		query.append("                             ,'7', '45'" ).append("\n"); 
		query.append("                             ,'BX','BX'" ).append("\n"); 
		query.append("                             ,'BL','BL'" ).append("\n"); 
		query.append("                             ,'OT') PER_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,B2.CGO_CATE_CD" ).append("\n"); 
		query.append("              ,B2.CURR_CD" ).append("\n"); 
		query.append("              ,B2.CHG_AMT TRF_USD_CHG_AMT" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("#if (${gubun} == '2' )" ).append("\n"); 
		query.append("                       /*+ ORDERED USE_NL(A4) INDEX(A4 XPKMDM_CUSTOMER) INDEX(A1 XAK3MAS_BKG_EXPN_DTL) */ " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gubun} == '1' )" ).append("\n"); 
		query.append("                       /*+ ORDERED USE_NL(A4) INDEX(A4 XPKMDM_CUSTOMER) */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                       A1.COST_YRMON" ).append("\n"); 
		query.append("                      ,A1.COST_WK" ).append("\n"); 
		query.append("                      ,A1.TRD_CD" ).append("\n"); 
		query.append("                      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                      ,A2.SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,A3.OFC_N3RD_LVL_CD REGION" ).append("\n"); 
		query.append("                      ,A2.CTRT_OFC_CD" ).append("\n"); 
		query.append("                      ,A1.DIR_CD" ).append("\n"); 
		query.append("                      ,A1.RLANE_CD" ).append("\n"); 
		query.append("                      ,A1.VSL_CD||A1.SKD_VOY_NO||A1.DIR_CD VVD_CD" ).append("\n"); 
		query.append("                      ,A2.BKG_NO" ).append("\n"); 
		query.append("                      ,COALESCE(A2.SC_NO, A2.RFA_NO,A2.TAA_NO) CTRT_NO" ).append("\n"); 
		query.append("                      ,A2.CTRT_CUST_CNT_CD|| LPAD(A2.CTRT_CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("                      ,A4.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                      ,SUM(DECODE(SUBSTR(A1.CNTR_TPSZ_CD,-1,1),'2',NVL(A1.BKG_QTY,0),NVL(A1.BKG_QTY,0)*2))  TEU" ).append("\n"); 
		query.append("                      ,SUM(DECODE(SUBSTR(A1.CNTR_TPSZ_CD,-1,1),'2',NVL(A1.BKG_QTY,0)*0.5,NVL(A1.BKG_QTY,0)))  FEU" ).append("\n"); 
		query.append("                      ,A1.BKG_POR_CD" ).append("\n"); 
		query.append("                      ,SUBSTR(A1.BKG_POL_CD, 1,2) POL_CNT_CD" ).append("\n"); 
		query.append("                      ,A1.BKG_POL_CD" ).append("\n"); 
		query.append("                      ,SUBSTR(A1.BKG_POD_CD, 1,2) POD_CNT_CD" ).append("\n"); 
		query.append("                      ,A1.BKG_POD_CD" ).append("\n"); 
		query.append("                      ,A1.BKG_DEL_CD" ).append("\n"); 
		query.append("                      ,A1.BKG_RCV_TERM_CD||'/'||A1.BKG_DE_TERM_CD RD_TERM_CD" ).append("\n"); 
		query.append("                      ,CASE WHEN A4.NEW_KEY_ACCT_FLG =  'Y' THEN 'CC'" ).append("\n"); 
		query.append("                          --  WHEN A4.GLO_ACCT_FLG = 'Y' THEN 'GA'" ).append("\n"); 
		query.append("                            WHEN A4.RGN_ACCT_FLG =  'Y' THEN 'RC'" ).append("\n"); 
		query.append("                       ELSE 'LC'" ).append("\n"); 
		query.append("                       END CUST_CLSS" ).append("\n"); 
		query.append("                      ,A4.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("                FROM " ).append("\n"); 
		query.append("#if (${gubun} == '2' )" ).append("\n"); 
		query.append("                     --MONTH를 선택한 경우" ).append("\n"); 
		query.append("                     MAS_BKG_EXPN_DTL A1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gubun} == '1' || ${gubun} == '3')" ).append("\n"); 
		query.append("                     -- WeeK를 선택한 경우, Applicatoin Date를 선택한 경우" ).append("\n"); 
		query.append("                     MAS_BKG_EXPN_DTL_WK A1 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                     ,BKG_BOOKING A2               " ).append("\n"); 
		query.append("                     ,MDM_CUSTOMER A4" ).append("\n"); 
		query.append("                     ,MAS_OFC_LVL A3" ).append("\n"); 
		query.append("                WHERE A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("                  AND A2.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                  AND A2.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("                  AND A2.CTRT_OFC_CD = A3.OFC_CD" ).append("\n"); 
		query.append("                  AND A2.CTRT_CUST_CNT_CD = A4.CUST_CNT_CD" ).append("\n"); 
		query.append("                  AND A2.CTRT_CUST_SEQ = A4.CUST_SEQ" ).append("\n"); 
		query.append("                  AND A3.OFC_LVL < '9'" ).append("\n"); 
		query.append("                  				  " ).append("\n"); 
		query.append("#if (${gubun} == '1' )" ).append("\n"); 
		query.append("	#if(${f_sls_mon} == '' )" ).append("\n"); 
		query.append("                  -- YEAR, WEEK만 들어올 때" ).append("\n"); 
		query.append("                  AND  SUBSTR(SLS_YRMON,1,4)||COST_WK BETWEEN @[f_year]||@[f_fm_wk] AND @[f_year]||@[f_to_wk] " ).append("\n"); 
		query.append("    #end				  " ).append("\n"); 
		query.append("    #if(${f_sls_mon} != '' )" ).append("\n"); 
		query.append("                  --Year Week 중에 Month가 들어올 때" ).append("\n"); 
		query.append("                  AND  SUBSTR(SLS_YRMON,5,2) = @[f_sls_mon] " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                  AND A1.SLS_YRMON BETWEEN A3.OFC_APLY_FM_YRMON AND A3.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("#end				 " ).append("\n"); 
		query.append("#if (${gubun} == '2' )" ).append("\n"); 
		query.append("                   --Year,Month 조건" ).append("\n"); 
		query.append("                  AND A1.COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon] " ).append("\n"); 
		query.append("                  AND A1.COST_YRMON BETWEEN A3.OFC_APLY_FM_YRMON AND A3.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("#end				  " ).append("\n"); 
		query.append("#if (${gubun} == '3' )" ).append("\n"); 
		query.append("                  --Applicatoin Date를 선택한 경우" ).append("\n"); 
		query.append("                  AND EXISTS (SELECT BKG_NO" ).append("\n"); 
		query.append("                               FROM BKG_RATE" ).append("\n"); 
		query.append("                              WHERE RT_APLY_DT >= TO_DATE(@[start_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                AND RT_APLY_DT <= TO_DATE(@[end_dt], 'YYYY-MM-DD') + 0.99999 /* 0.99999 는 23시 59분 59초를 의미 */" ).append("\n"); 
		query.append("                                AND BKG_NO = A2.BKG_NO) " ).append("\n"); 
		query.append("                  AND A1.SLS_YRMON BETWEEN A3.OFC_APLY_FM_YRMON AND A3.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rvis_cntr_cust_tp_cd} != '' )" ).append("\n"); 
		query.append("                  --Main sheet에 있는 customer Type 필수" ).append("\n"); 
		query.append("                  AND A4.RVIS_CNTR_CUST_TP_CD = @[rvis_cntr_cust_tp_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_cust_cnt_cd} != '' )" ).append("\n"); 
		query.append("                  --Main sheet에 있는 customer code 선택" ).append("\n"); 
		query.append("                  AND A2.CTRT_CUST_CNT_CD = @[ctrt_cust_cnt_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_cust_seq} != '' )" ).append("\n"); 
		query.append("                  --Main sheet에 있는 customer code 선택" ).append("\n"); 
		query.append("                  AND A2.CTRT_CUST_SEQ = @[ctrt_cust_seq] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_grp_id} != '' )" ).append("\n"); 
		query.append("                  --Main sheet에 있는 group customer code 선택" ).append("\n"); 
		query.append("                  AND A4.CUST_GRP_ID = @[cust_grp_id] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '' )" ).append("\n"); 
		query.append("                  AND A2.SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq_cd} != '' )" ).append("\n"); 
		query.append("                  AND A3.OFC_N3RD_LVL_CD = @[rhq_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_ofc_cd} != '' )" ).append("\n"); 
		query.append("                  AND A2.CTRT_OFC_CD = @[ctrt_ofc_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("                  AND A2.POR_CD LIKE @[por_cd]||'%' --POR 조건" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("                  AND A2.POL_CD LIKE @[pol_cd]||'%' -- POL 조건" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("                  AND A2.POD_CD LIKE @[pod_cd]||'%' -- POD 조건" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("                  AND A2.DEL_CD LIKE @[del_cd]||'%' --DEL 조건 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                  AND A2.BKG_OFC_CD = @[bkg_ofc_cd] --BKG_OFC_CD 조건 " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("              GROUP BY A1.COST_YRMON" ).append("\n"); 
		query.append("                      ,A1.COST_WK" ).append("\n"); 
		query.append("                      ,A1.TRD_CD" ).append("\n"); 
		query.append("                      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                      ,A2.SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,A3.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                      ,A2.CTRT_OFC_CD" ).append("\n"); 
		query.append("                      ,A1.DIR_CD" ).append("\n"); 
		query.append("                      ,A1.RLANE_CD" ).append("\n"); 
		query.append("                      ,A1.VSL_CD||A1.SKD_VOY_NO||A1.DIR_CD" ).append("\n"); 
		query.append("                      ,A2.BKG_NO" ).append("\n"); 
		query.append("                      ,COALESCE(A2.SC_NO, A2.RFA_NO,A2.TAA_NO)" ).append("\n"); 
		query.append("                      ,A2.CTRT_CUST_CNT_CD|| LPAD(A2.CTRT_CUST_SEQ, 6, '0')" ).append("\n"); 
		query.append("                      ,A4.CUST_LGL_ENG_NM    " ).append("\n"); 
		query.append("                      ,A1.BKG_POR_CD" ).append("\n"); 
		query.append("                      ,SUBSTR(A1.BKG_POL_CD, 1,2)" ).append("\n"); 
		query.append("                      ,A1.BKG_POL_CD" ).append("\n"); 
		query.append("                      ,SUBSTR(A1.BKG_POD_CD, 1,2)" ).append("\n"); 
		query.append("                      ,A1.BKG_POD_CD" ).append("\n"); 
		query.append("                      ,A1.BKG_DEL_CD" ).append("\n"); 
		query.append("                      ,A1.BKG_RCV_TERM_CD||'/'||A1.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("                      ,CASE WHEN A4.NEW_KEY_ACCT_FLG =  'Y' THEN 'CC'" ).append("\n"); 
		query.append("                            --WHEN A4.GLO_ACCT_FLG = 'Y' THEN 'GA'" ).append("\n"); 
		query.append("                            WHEN A4.RGN_ACCT_FLG =  'Y' THEN 'RC'" ).append("\n"); 
		query.append("                       ELSE 'LC'" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                      ,A4.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("              ) B1" ).append("\n"); 
		query.append("        ,BKG_TRF_SCG_RT B2" ).append("\n"); 
		query.append("        ,MDM_CHARGE B3" ).append("\n"); 
		query.append("        WHERE B1.BKG_NO = B2.BKG_NO" ).append("\n"); 
		query.append("          AND B2.CHG_CD = B3.CHG_CD" ).append("\n"); 
		query.append("          AND B3.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("#if (${rep_chg_cd} != '' )" ).append("\n"); 
		query.append("          --Main sheet에 있는 REP_CHG_CD 필수" ).append("\n"); 
		query.append("          AND B3.REP_CHG_CD = @[rep_chg_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chg_cd} != '' )" ).append("\n"); 
		query.append("          --Main sheet에 있는 CHG_CD 필수" ).append("\n"); 
		query.append("          AND B3.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_clss} != '' )" ).append("\n"); 
		query.append("          --Main sheet에 있는 CUST_CLSS 필수" ).append("\n"); 
		query.append("          AND B1.CUST_CLSS = @[cust_clss]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cgo_cate_cd} != '')" ).append("\n"); 
		query.append("          AND B2.CGO_CATE_CD = @[cgo_cate_cd] -- 체크 박스에 체크하는대로 조회 조건 들어옴" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") C1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${per_cd} != '' )" ).append("\n"); 
		query.append("-- Main sheet에 있는 PER 선택" ).append("\n"); 
		query.append("AND PER_CD = @[per_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY COST_YRMON" ).append("\n"); 
		query.append("      ,COST_WK" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,SVC_SCP_CD" ).append("\n"); 
		query.append("      ,REGION" ).append("\n"); 
		query.append("      ,CTRT_OFC_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,VVD_CD" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,CTRT_NO" ).append("\n"); 
		query.append("      ,CUST_CD" ).append("\n"); 
		query.append("      ,CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,TEU" ).append("\n"); 
		query.append("      ,FEU" ).append("\n"); 
		query.append("      ,BKG_POR_CD" ).append("\n"); 
		query.append("      ,POL_CNT_CD" ).append("\n"); 
		query.append("      ,BKG_POL_CD" ).append("\n"); 
		query.append("      ,POD_CNT_CD" ).append("\n"); 
		query.append("      ,BKG_POD_CD" ).append("\n"); 
		query.append("      ,BKG_DEL_CD" ).append("\n"); 
		query.append("      ,RD_TERM_CD" ).append("\n"); 
		query.append("      ,REP_CHG_CD" ).append("\n"); 
		query.append("      ,FRT_TERM_CD" ).append("\n"); 
		query.append("      ,CHG_CD" ).append("\n"); 
		query.append("      ,MDT_RAT_FLG" ).append("\n"); 
		query.append("      ,DISP_PER_CD" ).append("\n"); 
		query.append("      ,PER_CD " ).append("\n"); 
		query.append("      ,CGO_CATE_CD" ).append("\n"); 
		query.append("      ,CURR_CD" ).append("\n"); 
		query.append("#if(${f_excel} == 'Y')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}