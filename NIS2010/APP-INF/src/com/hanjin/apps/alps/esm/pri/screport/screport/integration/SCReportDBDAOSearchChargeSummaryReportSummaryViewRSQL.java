/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCReportDBDAOSearchChargeSummaryReportSummaryViewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAOSearchChargeSummaryReportSummaryViewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Charge Summary Report - Summary View Tab을 조회한다.
	  * 2013.06.24 송호진 [CHM-201324516] MDM_CHARGE 에 새로 추가된 MDT_RAT_FLG 적용
	  * 2013.07.04 전윤주 [CHM-201325625] Customer Classification 조건을 CC, RC, LC로 수정
	  * 2014.06.02 최성환 [CHM-201430519]Charge Summary Report 로직 보완 요청
	  * 2015.06.30 최성환 [CHM-201536493] Split03-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public SCReportDBDAOSearchChargeSummaryReportSummaryViewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mdtr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rep_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAOSearchChargeSummaryReportSummaryViewRSQL").append("\n"); 
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
		query.append("SELECT C1.REP_CHG_CD" ).append("\n"); 
		query.append("      ,DECODE ( C1.MDTR_CD, 'Y','YES','N','NO' ) AS MDTR_CD" ).append("\n"); 
		query.append("      ,C1.CHG_CD" ).append("\n"); 
		query.append("      ,C1.CUST_CLSS" ).append("\n"); 
		query.append("      ,C1.CUST_TP_CD" ).append("\n"); 
		query.append("      ,C1.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("#if (${cust_grp_id} != '' )" ).append("\n"); 
		query.append("      ,C1.CUST_GRP_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cd} != '' )" ).append("\n"); 
		query.append("      ,C1.CUST_CD" ).append("\n"); 
		query.append("      ,C1.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,C1.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("      ,C1.SVC_SCP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq_cd} != '')" ).append("\n"); 
		query.append("      ,C1.RHQ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_ofc_cd} != '' )" ).append("\n"); 
		query.append("      ,C1.CTRT_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${per_cd} != '' )" ).append("\n"); 
		query.append("      ,DECODE(C1.PER_CD, 'OT', 'Other', C1.PER_CD) PER_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,SUM(C1.RAT_USD_CHG_AMT) RAT_USD_CHG_AMT" ).append("\n"); 
		query.append("      ,SUM(C1.TRF_USD_CHG_AMT) TRF_USD_CHG_AMT" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(C1.TRF_USD_CHG_AMT), 0, 0" ).append("\n"); 
		query.append("             ,SUM(C1.RAT_USD_CHG_AMT)/SUM(C1.TRF_USD_CHG_AMT)*100)" ).append("\n"); 
		query.append("            ,2) CLT_RATIO" ).append("\n"); 
		query.append("	  ,COUNT(C1.BKG_NO) BKG_COUNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT B1.REP_CHG_CD" ).append("\n"); 
		query.append("              ,B1.MDTR_CD" ).append("\n"); 
		query.append("              ,B1.CHG_CD" ).append("\n"); 
		query.append("              ,B1.CUST_CLSS" ).append("\n"); 
		query.append("              ,B1.CUST_TP_CD" ).append("\n"); 
		query.append("              ,B1.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("      		  ,B1.CUST_GRP_ID" ).append("\n"); 
		query.append("   			  ,B1.CUST_CD" ).append("\n"); 
		query.append("			  ,B1.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("              ,B1.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("     		  ,B1.SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${rhq_cd} != '')" ).append("\n"); 
		query.append("    		  ,B1.RHQ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    		  ,B1.CTRT_OFC_CD" ).append("\n"); 
		query.append("     		  ,B1.PER_CD" ).append("\n"); 
		query.append("		      -- BKG 별 CHG CODE 별로 SUM 한 후 마지막에 조건별로 다시 SUM함" ).append("\n"); 
		query.append("              ,B1.BKG_NO " ).append("\n"); 
		query.append("              ,SUM(B1.TRF_USD_CHG_AMT) TRF_USD_CHG_AMT" ).append("\n"); 
		query.append("              ,(SELECT SUM(MAS_CONV_CURR_USD_FNC(CURR_CD, NVL(CHG_AMT, 0),TO_CHAR(SYSDATE, 'YYYYMM')))" ).append("\n"); 
		query.append("                 FROM BKG_CHG_RT B2" ).append("\n"); 
		query.append("                WHERE B2.BKG_NO = B1.BKG_NO" ).append("\n"); 
		query.append("                  AND B2.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("                  AND (DECODE((SELECT DECODE(RAT_UT_CD, 'BX', 'BX', 'BL', 'BL', CNTR_SZ_CD)" ).append("\n"); 
		query.append("                                FROM PRI_RAT_UT" ).append("\n"); 
		query.append("                               WHERE RAT_UT_CD(+) = B2.RAT_UT_CD) " ).append("\n"); 
		query.append("                             ,'2', '20'" ).append("\n"); 
		query.append("                             ,'4', '40'" ).append("\n"); 
		query.append("                             ,'7', '45'" ).append("\n"); 
		query.append("                             ,'BX','BX'" ).append("\n"); 
		query.append("                             ,'BL','BL' --TRF RAT UT CODE를 PER 기준으로 환산하여 join 함" ).append("\n"); 
		query.append("                             ,'OT') = B1.PER_CD" ).append("\n"); 
		query.append("                        OR B1.PER_CD  IN ( 'BX', 'BL' )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                  AND B2.FRT_INCL_XCLD_DIV_CD <> 'I'" ).append("\n"); 
		query.append("                ) RAT_USD_CHG_AMT              " ).append("\n"); 
		query.append("         FROM ( " ).append("\n"); 
		query.append("               SELECT  /*+ ORDERED USE_NL(A4) INDEX(A4 XPKMDM_CUSTOMER) INDEX(A1 XPKBKG_TRF_SCG_RT) */" ).append("\n"); 
		query.append("                       A3.REP_CHG_CD " ).append("\n"); 
		query.append("                      ,A3.MDT_RAT_FLG MDTR_CD" ).append("\n"); 
		query.append("                      ,A1.CHG_CD" ).append("\n"); 
		query.append("                      ,CASE WHEN A4.NEW_KEY_ACCT_FLG =  'Y' THEN 'CC'" ).append("\n"); 
		query.append("                          --  WHEN A4.GLO_ACCT_FLG = 'Y' THEN 'GA'" ).append("\n"); 
		query.append("                            WHEN A4.RGN_ACCT_FLG =  'Y' THEN 'RC'" ).append("\n"); 
		query.append("                       ELSE 'LC'" ).append("\n"); 
		query.append("                       END CUST_CLSS" ).append("\n"); 
		query.append("                      ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00697' AND INTG_CD_VAL_CTNT(+) = A4.RVIS_CNTR_CUST_TP_CD) CUST_TP_CD" ).append("\n"); 
		query.append("                      ,A4.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("                      ,A4.CUST_GRP_ID" ).append("\n"); 
		query.append("                      ,A2.CTRT_CUST_CNT_CD|| LPAD(A2.CTRT_CUST_SEQ, 6, '0')  CUST_CD" ).append("\n"); 
		query.append("                      ,A2.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                      ,A2.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("                      ,A2.SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${rhq_cd} != '')" ).append("\n"); 
		query.append("                      ,@[rhq_cd] RHQ_CD -- RHQ 조건이 들어올 때만" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("                      ,A2.CTRT_OFC_CD" ).append("\n"); 
		query.append("                      ,A1.RAT_UT_CD" ).append("\n"); 
		query.append("                      --20, 40, 45, BX, BL, OT 6가지 CODE로 GROUP BY " ).append("\n"); 
		query.append("                      ,DECODE((SELECT DECODE(RAT_UT_CD, 'BX', 'BX', 'BL', 'BL', CNTR_SZ_CD)" ).append("\n"); 
		query.append("                              FROM PRI_RAT_UT" ).append("\n"); 
		query.append("                                WHERE RAT_UT_CD(+) = A1.RAT_UT_CD) " ).append("\n"); 
		query.append("                             ,'2', '20'" ).append("\n"); 
		query.append("                             ,'4', '40'" ).append("\n"); 
		query.append("                             ,'7', '45'" ).append("\n"); 
		query.append("                             ,'BX','BX'" ).append("\n"); 
		query.append("                             ,'BL','BL'" ).append("\n"); 
		query.append("                             ,'OT') PER_CD " ).append("\n"); 
		query.append("                      ,A1.BKG_NO" ).append("\n"); 
		query.append("                      ,MAS_CONV_CURR_USD_FNC(A1.CURR_CD, NVL(A1.CHG_AMT, 0),TO_CHAR(SYSDATE, 'YYYYMM')) TRF_USD_CHG_AMT            " ).append("\n"); 
		query.append("                FROM  " ).append("\n"); 
		query.append("                     BKG_BOOKING A2" ).append("\n"); 
		query.append("                    ,MDM_CUSTOMER A4" ).append("\n"); 
		query.append("                    ,BKG_TRF_SCG_RT A1 " ).append("\n"); 
		query.append("                    ,MDM_CHARGE A3              " ).append("\n"); 
		query.append("#if (${rhq_cd} != '' )" ).append("\n"); 
		query.append("-- RHQ 조건이 들어올 때만 조인됨" ).append("\n"); 
		query.append("                    ,(" ).append("\n"); 
		query.append("                      SELECT OFC_CD " ).append("\n"); 
		query.append("                        FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("                       WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                      START WITH A.OFC_CD  = @[rhq_cd]" ).append("\n"); 
		query.append("                      CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD  " ).append("\n"); 
		query.append("                      ) A6 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                WHERE A1.CHG_CD = A3.CHG_CD" ).append("\n"); 
		query.append("                  AND A3.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("                  AND A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("                  AND A2.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                  AND A2.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("                  AND A2.CTRT_CUST_CNT_CD = A4.CUST_CNT_CD" ).append("\n"); 
		query.append("                  AND A2.CTRT_CUST_SEQ = A4.CUST_SEQ                  " ).append("\n"); 
		query.append("#if(${gubun} == '1')" ).append("\n"); 
		query.append("                  -- WEEK 로 조건이 들어올 때" ).append("\n"); 
		query.append("                  AND EXISTS ( SELECT BKG_NO" ).append("\n"); 
		query.append("                                FROM MAS_BKG_EXPN_DTL_WK" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("	#if(${f_sls_mon} == '' )" ).append("\n"); 
		query.append("                                -- Year, Week만 들어올 때" ).append("\n"); 
		query.append("                                AND SUBSTR(SLS_YRMON,1,4)||COST_WK BETWEEN @[f_year]||@[f_fm_wk] AND @[f_year]||@[f_to_wk]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${f_sls_mon} != '' )" ).append("\n"); 
		query.append("                                 -- Year, Month ,Week 들어올 때" ).append("\n"); 
		query.append("                                AND  SUBSTR(SLS_YRMON,5,2) = @[f_sls_mon]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                                AND BKG_NO = A2.BKG_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gubun} == '2' )" ).append("\n"); 
		query.append("                  -- MONTH 로 조건이 들어올 때" ).append("\n"); 
		query.append("                  AND EXISTS (SELECT  /*+ INDEX (MAS_BKG_EXPN_DTL, XAK3MAS_BKG_EXPN_DTL) */  " ).append("\n"); 
		query.append("                                   BKG_NO" ).append("\n"); 
		query.append("                              FROM MAS_BKG_EXPN_DTL" ).append("\n"); 
		query.append("                              WHERE COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append("                              AND BKG_NO = A2.BKG_NO)          " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gubun} == '3' )" ).append("\n"); 
		query.append("                  -- Appl 로 조건이 들어올때" ).append("\n"); 
		query.append("                  AND EXISTS (SELECT BKG_NO" ).append("\n"); 
		query.append("                              FROM BKG_RATE" ).append("\n"); 
		query.append("                              WHERE RT_APLY_DT >= TO_DATE(@[start_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                              AND RT_APLY_DT <= TO_DATE(@[end_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("                              AND BKG_NO = A2.BKG_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq_cd} != '' )" ).append("\n"); 
		query.append("                  AND A2.CTRT_OFC_CD =A6.OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rep_chg_cd} != '')" ).append("\n"); 
		query.append("                  AND A3.REP_CHG_CD = @[rep_chg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chg_cd} != '' )" ).append("\n"); 
		query.append("                  AND A1.CHG_CD IN (${chg_cd})  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_clss} == 'CC')" ).append("\n"); 
		query.append("                  AND NVL(A4.NEW_KEY_ACCT_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_clss} == 'RC')" ).append("\n"); 
		query.append("                  AND NVL(A4.RGN_ACCT_FLG, 'N') =  'Y' " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cust_clss} == 'LC')" ).append("\n"); 
		query.append("                  AND NVL(A4.NEW_KEY_ACCT_FLG, 'N')  <>  'Y' " ).append("\n"); 
		query.append("                  AND NVL(A4.RGN_ACCT_FLG, 'N') <>  'Y'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cust_tp_cd} != 'A' && ${cust_tp_cd} != '' )" ).append("\n"); 
		query.append("                  AND A4.RVIS_CNTR_CUST_TP_CD = @[cust_tp_cd] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cust_grp_id} != '' )" ).append("\n"); 
		query.append("                  AND A4.CUST_GRP_ID IN (${cust_grp_id}) " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cust_cd} != '' )" ).append("\n"); 
		query.append("                  AND A2.CTRT_CUST_CNT_CD||LPAD(A2.CTRT_CUST_SEQ, 6, '0')  IN (${cust_cd}) " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${ctrt_ofc_cd} != '' )" ).append("\n"); 
		query.append("                  AND A2.CTRT_OFC_CD IN (${ctrt_ofc_cd}) " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("                  AND A2.SVC_SCP_CD IN (${svc_scp_cd}) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mdtr_cd} != 'A')" ).append("\n"); 
		query.append("                  AND A3.MDT_RAT_FLG = @[mdtr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  ) B1" ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("#if (${per_cd} != '' )" ).append("\n"); 
		query.append("        AND B1.PER_CD  IN (${per_cd}) " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("    GROUP BY B1.REP_CHG_CD" ).append("\n"); 
		query.append("            ,B1.MDTR_CD" ).append("\n"); 
		query.append("            ,B1.CHG_CD" ).append("\n"); 
		query.append("            ,B1.CUST_CLSS" ).append("\n"); 
		query.append("            ,B1.CUST_TP_CD" ).append("\n"); 
		query.append("            ,B1.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("        	,B1.CUST_GRP_ID" ).append("\n"); 
		query.append("        	,B1.CUST_CD" ).append("\n"); 
		query.append("			,B1.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("        	,B1.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("        	,B1.SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${rhq_cd} != '')" ).append("\n"); 
		query.append("        	,B1.RHQ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        	,B1.CTRT_OFC_CD" ).append("\n"); 
		query.append("        	,B1.PER_CD" ).append("\n"); 
		query.append("            ,B1.BKG_NO" ).append("\n"); 
		query.append(")C1" ).append("\n"); 
		query.append("GROUP BY C1.REP_CHG_CD" ).append("\n"); 
		query.append("      ,C1.MDTR_CD" ).append("\n"); 
		query.append("      ,C1.CHG_CD" ).append("\n"); 
		query.append("      ,C1.CUST_CLSS" ).append("\n"); 
		query.append("      ,C1.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("      ,C1.CUST_TP_CD" ).append("\n"); 
		query.append("#if (${cust_grp_id} != '' )" ).append("\n"); 
		query.append("      ,C1.CUST_GRP_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cd} != '' )" ).append("\n"); 
		query.append("      ,C1.CUST_CD" ).append("\n"); 
		query.append("      ,C1.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,C1.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("      ,C1.SVC_SCP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq_cd} != '')" ).append("\n"); 
		query.append("      ,C1.RHQ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_ofc_cd} != '' )" ).append("\n"); 
		query.append("      ,C1.CTRT_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${per_cd} != '' )" ).append("\n"); 
		query.append("      ,C1.PER_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}