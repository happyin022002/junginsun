/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PayableEstimateAuditDBDAOcalculationPayableEstimateAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.30
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.08.30 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableEstimateAuditDBDAOcalculationPayableEstimateAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 임차료에 대한 추정 실적 계산 합니다.
	  * </pre>
	  */
	public PayableEstimateAuditDBDAOcalculationPayableEstimateAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skr_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_pay_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.integration").append("\n"); 
		query.append("FileName : PayableEstimateAuditDBDAOcalculationPayableEstimateAuditRSQL").append("\n"); 
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
		query.append("WITH PARAM AS" ).append("\n"); 
		query.append("     ( " ).append("\n"); 
		query.append("         SELECT  MIN(GV.REV_YRMON)  AS PERIOD_STDT" ).append("\n"); 
		query.append("              ,  MAX(GV.REV_YRMON)  AS PERIOD_EDDT" ).append("\n"); 
		query.append("           FROM  GL_ESTM_REV_VVD GV" ).append("\n"); 
		query.append("          WHERE  GV.EXE_YRMON = REPLACE(@[period_dt], '-')" ).append("\n"); 
		query.append("            AND  GV.REV_YRMON < TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("            AND  GV.VSL_CD    = 'CNTC'" ).append("\n"); 
		query.append("           GROUP BY GV.EXE_YRMON " ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("     , RCV_VAL AS (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("               @[period_dt]         AS period_dt" ).append("\n"); 
		query.append("              ,@[lse_ctrt_no]       AS lse_ctrt_no" ).append("\n"); 
		query.append("              ,@[vndr_seq]          AS vndr_seq" ).append("\n"); 
		query.append("              ,@[lse_pay_chg_tp_cd] AS lse_pay_chg_tp_cd" ).append("\n"); 
		query.append("              ,@[skr_acct_cd]       AS skr_acct_cd" ).append("\n"); 
		query.append("              ,@[rev_month]         AS rev_month" ).append("\n"); 
		query.append("              ,@[agmt_seq]          AS agmt_seq" ).append("\n"); 
		query.append("              , NVL(@[lse_ctrt_no]        , 'Y')" ).append("\n"); 
		query.append("                ||TRIM(NVL(@[vndr_seq]         , 'Y'))" ).append("\n"); 
		query.append("                ||TRIM(NVL(@[lse_pay_chg_tp_cd], 'Y'))" ).append("\n"); 
		query.append("                ||TRIM(NVL(@[skr_acct_cd]      , 'Y'))" ).append("\n"); 
		query.append("                ||TRIM(NVL(@[rev_month]        , 'Y'))" ).append("\n"); 
		query.append("                ||TRIM(NVL(@[agmt_seq], 'Y')) AS CHK_FLG" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("    , TERM_LIST AS (SELECT  LSE_RCV_CHG_TP_CD, ACCT_CD, LSTM_CD, COST_CD" ).append("\n"); 
		query.append("                     FROM    LSE_RNTL_COST_ACCT_ORD WHERE LSTM_CD = 'XX'" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT  LSE_RCV_CHG_TP_CD, ACCT_CD, 'BX', COST_CD" ).append("\n"); 
		query.append("                    FROM    LSE_RNTL_COST_ACCT_ORD WHERE LSTM_CD = 'XX'" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT  LSE_RCV_CHG_TP_CD, ACCT_CD, LSTM_CD, COST_CD" ).append("\n"); 
		query.append("                    FROM   (SELECT  A.LSE_RCV_CHG_TP_CD," ).append("\n"); 
		query.append("                                    A.LSTM_CD AS ZZZ," ).append("\n"); 
		query.append("                                    A.ACCT_CD AS ACCT_CD," ).append("\n"); 
		query.append("                                    A.COST_CD," ).append("\n"); 
		query.append("                                    B.LSTM_CD AS LSTM_CD" ).append("\n"); 
		query.append("                              FROM  LSE_RNTL_COST_ACCT_ORD A," ).append("\n"); 
		query.append("                                    MST_LSE_TERM B" ).append("\n"); 
		query.append("                             WHERE   A.LSTM_CD IN('XX', B.LSTM_CD)" ).append("\n"); 
		query.append("                          ) " ).append("\n"); 
		query.append("                    WHERE  (LSE_RCV_CHG_TP_CD, ZZZ, LSTM_CD) NOT IN (SELECT A.LSE_RCV_CHG_TP_CD, 'XX', B.LSTM_CD" ).append("\n"); 
		query.append("                                                                       FROM   LSE_RNTL_COST_ACCT_ORD A," ).append("\n"); 
		query.append("                                                                              MST_LSE_TERM B" ).append("\n"); 
		query.append("                                                                      WHERE  A.LSTM_CD = B.LSTM_CD)" ).append("\n"); 
		query.append("                )  " ).append("\n"); 
		query.append("SELECT  0 AS SEQ" ).append("\n"); 
		query.append("      , REPLACE(@[period_dt], '-') AS ACTUAL_MONTH" ).append("\n"); 
		query.append("      , 'LSE' AS SYS_NAME" ).append("\n"); 
		query.append("      , SUB.IF_RGST_NO" ).append("\n"); 
		query.append("      , SUB.REV_MONTH" ).append("\n"); 
		query.append("      , SUB.ACCT_CODE" ).append("\n"); 
		query.append("      , SUB.AGMT_NO" ).append("\n"); 
		query.append("      , SUB.AGMT_CTY_CD" ).append("\n"); 
		query.append("      , SUB.AGMT_SEQ" ).append("\n"); 
		query.append("      , 'CNTR' AS BIZ_UNIT" ).append("\n"); 
		query.append("	  , SUB.CRR_CD AS LOCL_CURR_CD" ).append("\n"); 
		query.append("      , SUB.TP_SZ" ).append("\n"); 
		query.append("      , SUB.EST_QTY" ).append("\n"); 
		query.append("      , CASE WHEN SUB.LSE_PAY_CHG_TP_CD IN ('DCR', 'CRD') OR SIGN(SUB.ACTUAL_COST) = -1 THEN" ).append("\n"); 
		query.append("				DECODE(SUB.ACTUAL_COST, 0, SUB.ESTIMATED_COST, SUB.ACTUAL_COST)" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("   		        DECODE(SIGN(SUB.ACCURAL_AMT), -1, SUB.ACTUAL_COST - SUB.ESTIMATED_COST " ).append("\n"); 
		query.append("             			                       , SUB.ESTIMATED_COST) " ).append("\n"); 
		query.append("        END ESTIMATED_COST" ).append("\n"); 
		query.append("      , SUB.ACTUAL_COST" ).append("\n"); 
		query.append("      , CASE WHEN SUB.LSE_PAY_CHG_TP_CD IN ('DCR', 'CRD') OR SIGN(SUB.ACTUAL_COST) = -1 THEN" ).append("\n"); 
		query.append("                DECODE(SIGN(DECODE(SUB.ACTUAL_COST, 0, SUB.ESTIMATED_COST, 0)), -1, 0, DECODE(SUB.ACTUAL_COST, 0, SUB.ESTIMATED_COST, 0))" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("   		        DECODE(SIGN(DECODE(SIGN(SUB.ACCURAL_AMT), -1, 0, SUB.ACCURAL_AMT)), -1, 0, DECODE(SIGN(SUB.ACCURAL_AMT), -1, 0, SUB.ACCURAL_AMT))" ).append("\n"); 
		query.append("        END ACCURAL_AMT" ).append("\n"); 
		query.append("      , SUB.VSL_CD||SUB.SKD_VOY_NO||SUB.SKD_DIR_CD||SUB.REV_DIR_CD AS REV_VVD" ).append("\n"); 
		query.append("      , NVL((SELECT MO.LOC_CD" ).append("\n"); 
		query.append("             FROM LSE_AGREEMENT LA" ).append("\n"); 
		query.append("                , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("             WHERE LA.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("             AND   SUB.AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("             AND   SUB.AGMT_SEQ    = LA.AGMT_SEQ" ).append("\n"); 
		query.append("             AND   ROWNUM  = 1), 'SGSIN') AS LOC_CD" ).append("\n"); 
		query.append("      , SUB.VSL_CD" ).append("\n"); 
		query.append("      , SUB.SKD_VOY_NO" ).append("\n"); 
		query.append("      , SUB.SKD_DIR_CD" ).append("\n"); 
		query.append("      , SUB.REV_DIR_CD" ).append("\n"); 
		query.append("      , TO_CHAR(SYSDATE,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("      , TO_CHAR(SYSDATE,'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("      , SUB.REV_MONTH||'01' ACT_DT" ).append("\n"); 
		query.append("      , NVL((SELECT LA.OFC_CD" ).append("\n"); 
		query.append("               FROM LSE_AGREEMENT LA" ).append("\n"); 
		query.append("              WHERE SUB.AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("                AND SUB.AGMT_SEQ    = LA.AGMT_SEQ" ).append("\n"); 
		query.append("                AND ROWNUM  = 1), 'SINHO') AS ACT_PLC_CD" ).append("\n"); 
		query.append("      , SUB.LSTM_CD LSTM_CD" ).append("\n"); 
		query.append("      , (SELECT LA.LSE_CTRT_NO" ).append("\n"); 
		query.append("           FROM  LSE_AGREEMENT LA" ).append("\n"); 
		query.append("          WHERE SUB.AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("            AND SUB.AGMT_SEQ    = LA.AGMT_SEQ" ).append("\n"); 
		query.append("            AND ROWNUM  = 1) AS LSE_CTRT_NO" ).append("\n"); 
		query.append("      , (SELECT LA.VNDR_SEQ" ).append("\n"); 
		query.append("           FROM  LSE_AGREEMENT LA" ).append("\n"); 
		query.append("          WHERE SUB.AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("            AND SUB.AGMT_SEQ    = LA.AGMT_SEQ" ).append("\n"); 
		query.append("            AND ROWNUM  = 1) AS VNDR_SEQ" ).append("\n"); 
		query.append("      , (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("           FROM  LSE_AGREEMENT LA" ).append("\n"); 
		query.append("               , MDM_VENDOR MV" ).append("\n"); 
		query.append("          WHERE SUB.AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("            AND SUB.AGMT_SEQ    = LA.AGMT_SEQ" ).append("\n"); 
		query.append("            AND LA.VNDR_SEQ    = MV.VNDR_SEQ" ).append("\n"); 
		query.append("            AND    ROWNUM  = 1) AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      , SUB.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("      , (SELECT MA.MODI_ACCT_CD" ).append("\n"); 
		query.append("           FROM  MDM_ACCOUNT MA" ).append("\n"); 
		query.append("          WHERE SUB.ACCT_CODE = MA.ACCT_CD" ).append("\n"); 
		query.append("            AND ROWNUM  = 1) AS SKR_ACCT_CD" ).append("\n"); 
		query.append("      , DECODE(P.CHK_FLG, 'YYYYYY', NVL((SELECT NVL(IF.IF_FLG, 'N')" ).append("\n"); 
		query.append("                                           FROM GL_ESTM_IF_ERP IF" ).append("\n"); 
		query.append("                                          WHERE IF.EXE_YRMON = REPLACE(@[period_dt], '-')" ).append("\n"); 
		query.append("                                            AND ROWNUM      = 1), 'N')" ).append("\n"); 
		query.append("                        , 'Y' )AS IF_CHK_FLG" ).append("\n"); 
		query.append("FROM   (SELECT  REV_MONTH" ).append("\n"); 
		query.append("              , ACCT_CODE" ).append("\n"); 
		query.append("              , TP_SZ" ).append("\n"); 
		query.append("              , VSL_CD" ).append("\n"); 
		query.append("              , SKD_VOY_NO" ).append("\n"); 
		query.append("              , SKD_DIR_CD" ).append("\n"); 
		query.append("              , REV_DIR_CD" ).append("\n"); 
		query.append("              , CRR_CD" ).append("\n"); 
		query.append("              , IF_RGST_NO" ).append("\n"); 
		query.append("              , LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("              , AGMT_NO     AS AGMT_NO" ).append("\n"); 
		query.append("              , AGMT_CTY_CD AS AGMT_CTY_CD" ).append("\n"); 
		query.append("              , AGMT_SEQ    AS AGMT_SEQ" ).append("\n"); 
		query.append("              , MAX((SELECT LA.LSTM_CD" ).append("\n"); 
		query.append("                       FROM LSE_AGREEMENT LA" ).append("\n"); 
		query.append("                      WHERE SUB.AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("                        AND SUB.AGMT_SEQ    = LA.AGMT_SEQ" ).append("\n"); 
		query.append("                        AND ROWNUM  = 1)) AS LSTM_CD" ).append("\n"); 
		query.append("              , SUM(EST_QTY)        AS EST_QTY" ).append("\n"); 
		query.append("              , SUM(ESTIMATED_COST) AS ESTIMATED_COST" ).append("\n"); 
		query.append("              , SUM(INV_AMT) AS ACTUAL_COST" ).append("\n"); 
		query.append("              , SUM(ESTIMATED_COST) - SUM(INV_AMT) AS ACCURAL_AMT" ).append("\n"); 
		query.append("        FROM   (SELECT  TO_CHAR(TO_DATE(SKD_VOY_NO, 'YYMM'), 'YYYYMM') REV_MONTH" ).append("\n"); 
		query.append("                      , NVL( (SELECT LRC.ACCT_CD" ).append("\n"); 
		query.append("                              FROM LSE_RNTL_COST_ACCT_ORD LRC" ).append("\n"); 
		query.append("                                 , LSE_AGREEMENT LA" ).append("\n"); 
		query.append("                              WHERE LRC.LSE_RCV_CHG_TP_CD = 'OPL'" ).append("\n"); 
		query.append("                              AND    LRC.LSTM_CD          =  LA.LSTM_CD" ).append("\n"); 
		query.append("                              AND    LA.AGMT_CTY_CD       = LOL.AGMT_CTY_CD" ).append("\n"); 
		query.append("                              AND    LA.AGMT_SEQ          = LOL.AGMT_SEQ" ).append("\n"); 
		query.append("                              AND    ROWNUM               = 1)" ).append("\n"); 
		query.append("                           , (SELECT LRC.ACCT_CD" ).append("\n"); 
		query.append("                              FROM  LSE_RNTL_COST_ACCT_ORD LRC" ).append("\n"); 
		query.append("                              WHERE LRC.LSE_RCV_CHG_TP_CD = 'OPL'" ).append("\n"); 
		query.append("                              AND    LRC.LSTM_CD          = 'XX'" ).append("\n"); 
		query.append("                              AND    ROWNUM               = 1)) AS ACCT_CODE" ).append("\n"); 
		query.append("                      , AGMT_CTY_CD || LTRIM(TO_CHAR(AGMT_SEQ, '000000')) AGMT_NO" ).append("\n"); 
		query.append("                      , AGMT_CTY_CD AGMT_CTY_CD" ).append("\n"); 
		query.append("                      , AGMT_SEQ AGMT_SEQ" ).append("\n"); 
		query.append("                      , CNTR_TPSZ_CD TP_SZ" ).append("\n"); 
		query.append("                      , OP_LSE_QTY EST_QTY" ).append("\n"); 
		query.append("                      , VSL_CD VSL_CD" ).append("\n"); 
		query.append("                      , SKD_VOY_NO SKD_VOY_NO" ).append("\n"); 
		query.append("                      , SKD_DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append("                      , REV_DIR_CD REV_DIR_CD" ).append("\n"); 
		query.append("                      , LOL.CURR_CD CRR_CD" ).append("\n"); 
		query.append("                      , SUM(PAY_AMT) ESTIMATED_COST" ).append("\n"); 
		query.append("                      , 0 INV_AMT" ).append("\n"); 
		query.append("                      , IF_RGST_NO" ).append("\n"); 
		query.append("		              , 'OPL' AS LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                FROM    LSE_OP_LSE LOL" ).append("\n"); 
		query.append("                      , PARAM P" ).append("\n"); 
		query.append("                WHERE   OP_LSE_STS_CD <> 'D'" ).append("\n"); 
		query.append("                AND     ISS_YRMON BETWEEN P.PERIOD_STDT AND P.PERIOD_EDDT" ).append("\n"); 
		query.append("                AND     EXISTS ( SELECT 'Y'" ).append("\n"); 
		query.append("                                   FROM LSE_RNTL_COST_ACCT_ORD  LAC" ).append("\n"); 
		query.append("                                      , SCO_AP_COST_ACT_INFO SAC" ).append("\n"); 
		query.append("                                  WHERE LAC.ACCT_CD           = SAC.CONV_ACCT_CD" ).append("\n"); 
		query.append("                                    AND LAC.COST_CD           = SAC.ACT_COST_CD" ).append("\n"); 
		query.append("                                    AND SAC.SRC_MDL_CD        = 'LSE'" ).append("\n"); 
		query.append("                                    AND SAC.ACCL_FLG          = 'Y'" ).append("\n"); 
		query.append("                                    AND LAC.LSE_RCV_CHG_TP_CD = 'OPL'" ).append("\n"); 
		query.append("                                    AND ROWNUM                = 1)" ).append("\n"); 
		query.append("                GROUP BY TO_CHAR(TO_DATE(SKD_VOY_NO, 'YYMM'), 'YYYYMM'), " ).append("\n"); 
		query.append("                         AGMT_CTY_CD || LTRIM(TO_CHAR(AGMT_SEQ, '000000')), AGMT_CTY_CD, AGMT_SEQ, " ).append("\n"); 
		query.append("                         CNTR_TPSZ_CD, OP_LSE_QTY, IF_RGST_NO, VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD, " ).append("\n"); 
		query.append("                         VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, LOL.CURR_CD" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT  A.CHG_COST_YRMON AS REV_MONTH" ).append("\n"); 
		query.append("                      , NVL(A.ACCT_CD, B.ACCT_CD) AS ACCT_CODE" ).append("\n"); 
		query.append("                      , A.AGMT_CTY_CD || LTRIM(TO_CHAR(A.AGMT_SEQ, '000000')) AS AGMT_NO" ).append("\n"); 
		query.append("                      , A.AGMT_CTY_CD  AS AGMT_CTY_CD" ).append("\n"); 
		query.append("                      , A.AGMT_SEQ     AS AGMT_SEQ" ).append("\n"); 
		query.append("                      , A.CNTR_TPSZ_CD AS TP_SZ" ).append("\n"); 
		query.append("                      , EST_QTY" ).append("\n"); 
		query.append("                      , 'CNTC' VSL_CD" ).append("\n"); 
		query.append("                      , SUBSTR(A.CHG_COST_YRMON, 3,4) AS SKD_VOY_NO" ).append("\n"); 
		query.append("                      , 'M' SKD_DIR_CD" ).append("\n"); 
		query.append("                      , 'M' REV_DIR_CD" ).append("\n"); 
		query.append("                      , A.CURR_CD CRR_CD" ).append("\n"); 
		query.append("                      , ESTIMATED_COST" ).append("\n"); 
		query.append("                      , 0 INV_AMT" ).append("\n"); 
		query.append("                      , NVL(A.IF_RGST_NO, A.AGMT_SEQ) IF_RGST_NO" ).append("\n"); 
		query.append("		              , A.LSE_PAY_CHG_TP_CD AS LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                FROM   (SELECT  A.CHG_COST_YRMON" ).append("\n"); 
		query.append("                              , A.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                              , A.LSTM_CD" ).append("\n"); 
		query.append("                              , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                              , A.AGMT_SEQ" ).append("\n"); 
		query.append("                              , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                              , C.ACCT_CD" ).append("\n"); 
		query.append("                              , C.COST_CD" ).append("\n"); 
		query.append("                              , A.CURR_CD" ).append("\n"); 
		query.append("                              , COUNT(CNTR_NO) EST_QTY" ).append("\n"); 
		query.append("                              , SUM(A.TTL_COST_AMT + A.CR_AMT) ESTIMATED_COST" ).append("\n"); 
		query.append("                              , A.IF_RGST_NO" ).append("\n"); 
		query.append("                        FROM   (SELECT  A.IF_RGST_NO" ).append("\n"); 
		query.append("                                      , A.CHG_COST_YRMON" ).append("\n"); 
		query.append("                                      , A.LSTM_CD" ).append("\n"); 
		query.append("                                      , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                      , A.AGMT_SEQ" ).append("\n"); 
		query.append("                                      , B.CNTR_NO, B.LSE_PAY_CHG_TP_CD, B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                        B.CR_AMT, B.TTL_COST_AMT, A.CURR_CD" ).append("\n"); 
		query.append("                                FROM    LSE_PAY_RNTL_CHG     A" ).append("\n"); 
		query.append("                                      , LSE_PAY_RNTL_CHG_DTL B" ).append("\n"); 
		query.append("                                      , PARAM P" ).append("\n"); 
		query.append("                                WHERE   A.AGMT_CTY_CD   = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                AND     A.AGMT_SEQ      = B.AGMT_SEQ" ).append("\n"); 
		query.append("                                AND     A.CHG_SEQ       = B.CHG_SEQ" ).append("\n"); 
		query.append("                                AND     A.CHG_COST_YRMON BETWEEN P.PERIOD_STDT AND P.PERIOD_EDDT" ).append("\n"); 
		query.append("                               ) A" ).append("\n"); 
		query.append("                              , TERM_LIST C" ).append("\n"); 
		query.append("                        WHERE   A.LSTM_CD           = C.LSTM_CD          (+)" ).append("\n"); 
		query.append("                        AND     A.LSE_PAY_CHG_TP_CD = C.LSE_RCV_CHG_TP_CD(+)" ).append("\n"); 
		query.append("                        AND     NOT EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                                                       FROM AP_PAY_INV INV" ).append("\n"); 
		query.append("                                                      WHERE A.IF_RGST_NO = INV.INV_RGST_NO" ).append("\n"); 
		query.append("                                                        AND INV.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("                                                        AND INV.INV_STS_CD IN ('P','D')" ).append("\n"); 
		query.append("                                           )" ).append("\n"); 
		query.append("                        AND     EXISTS ( SELECT 'Y'" ).append("\n"); 
		query.append("                                           FROM LSE_RNTL_COST_ACCT_ORD  LAC" ).append("\n"); 
		query.append("                                               , SCO_AP_COST_ACT_INFO SAC" ).append("\n"); 
		query.append("                                          WHERE LAC.ACCT_CD           = SAC.CONV_ACCT_CD" ).append("\n"); 
		query.append("                                            AND LAC.COST_CD           = SAC.ACT_COST_CD" ).append("\n"); 
		query.append("                                            AND SAC.SRC_MDL_CD        = 'LSE'" ).append("\n"); 
		query.append("                                            AND SAC.ACCL_FLG          = 'Y'" ).append("\n"); 
		query.append("                                            AND C.ACCT_CD             = LAC.ACCT_CD" ).append("\n"); 
		query.append("                                            AND C.COST_CD             = LAC.COST_CD" ).append("\n"); 
		query.append("                                            AND ROWNUM                = 1)" ).append("\n"); 
		query.append("                        GROUP BY A.LSE_PAY_CHG_TP_CD, C.ACCT_CD, C.COST_CD" ).append("\n"); 
		query.append("                               , A.CHG_COST_YRMON, A.AGMT_CTY_CD, A.AGMT_SEQ" ).append("\n"); 
		query.append("                               , A.LSTM_CD, A.CNTR_TPSZ_CD, A.IF_RGST_NO, A.CURR_CD" ).append("\n"); 
		query.append("                        ) A," ).append("\n"); 
		query.append("                        LSE_RNTL_COST_ACCT_ORD B" ).append("\n"); 
		query.append("                WHERE  NVL2(A.ACCT_CD, A.LSE_PAY_CHG_TP_CD, 'XXX')= B.LSE_RCV_CHG_TP_CD(+)" ).append("\n"); 
		query.append("                AND    CASE WHEN A.ACCT_CD IS NULL AND A.LSTM_CD IN('ST','LT') THEN A.LSTM_CD" ).append("\n"); 
		query.append("                            ELSE 'XX' END = B.LSTM_CD(+)" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT  A.REV_MONTH" ).append("\n"); 
		query.append("                      , B.ACCT_CD AS ACCT_CODE" ).append("\n"); 
		query.append("                      , A.AGMT_NO" ).append("\n"); 
		query.append("                      , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                      , A.AGMT_SEQ" ).append("\n"); 
		query.append("                      , A.TP_SZ" ).append("\n"); 
		query.append("                      , A.EST_QTY" ).append("\n"); 
		query.append("                      , A.VSL_CD" ).append("\n"); 
		query.append("                      , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                      , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                      , A.REV_DIR_CD" ).append("\n"); 
		query.append("                      , A.CRR_CD" ).append("\n"); 
		query.append("                      , A.ESTIMATED_COST" ).append("\n"); 
		query.append("                      , A.INV_AMT" ).append("\n"); 
		query.append("                      , A.IF_RGST_NO" ).append("\n"); 
		query.append("		              , A.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                FROM   (SELECT  ROW_NUMBER() OVER(PARTITION BY A.IF_RGST_NO ORDER BY A.CHG_COST_YRMON, " ).append("\n"); 
		query.append("                                A.LSE_PAY_CHG_TP_CD, A.LSTM_CD, A.CNTR_TPSZ_CD) AS IF_RGST_SEQ" ).append("\n"); 
		query.append("                              , A.CHG_COST_YRMON AS REV_MONTH" ).append("\n"); 
		query.append("                              , A.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                              , A.LSTM_CD" ).append("\n"); 
		query.append("                              , A.AGMT_CTY_CD || LTRIM(TO_CHAR(A.AGMT_SEQ, '000000')) AS AGMT_NO" ).append("\n"); 
		query.append("                              , A.AGMT_CTY_CD  AS AGMT_CTY_CD" ).append("\n"); 
		query.append("                              , A.AGMT_SEQ     AS AGMT_SEQ" ).append("\n"); 
		query.append("                              , A.CNTR_TPSZ_CD AS TP_SZ" ).append("\n"); 
		query.append("                              , EST_QTY" ).append("\n"); 
		query.append("                              , 'CNTC' VSL_CD" ).append("\n"); 
		query.append("                              , SUBSTR(A.CHG_COST_YRMON, 3,4) AS SKD_VOY_NO" ).append("\n"); 
		query.append("                              , 'M' SKD_DIR_CD" ).append("\n"); 
		query.append("                              , 'M' REV_DIR_CD" ).append("\n"); 
		query.append("                              , A.CURR_CD CRR_CD" ).append("\n"); 
		query.append("                              , ESTIMATED_COST" ).append("\n"); 
		query.append("                              , 0 INV_AMT" ).append("\n"); 
		query.append("                              , NVL(A.IF_RGST_NO, A.AGMT_SEQ) IF_RGST_NO " ).append("\n"); 
		query.append("                        FROM   (SELECT  CHG_COST_YRMON," ).append("\n"); 
		query.append("                                        LSE_PAY_CHG_TP_CD," ).append("\n"); 
		query.append("                                        LSTM_CD," ).append("\n"); 
		query.append("                                        AGMT_CTY_CD," ).append("\n"); 
		query.append("                                        AGMT_SEQ," ).append("\n"); 
		query.append("                                        CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                        EST_QTY," ).append("\n"); 
		query.append("                                        DSCR_COST_AMT," ).append("\n"); 
		query.append("                                        CR_AMT," ).append("\n"); 
		query.append("                                        ESTIMATED_COST," ).append("\n"); 
		query.append("                                        IF_RGST_NO," ).append("\n"); 
		query.append("                                        CNT_RGST_SEQ," ).append("\n"); 
		query.append("                                        MAX_RGST_SEQ," ).append("\n"); 
		query.append("                                        CURR_CD" ).append("\n"); 
		query.append("                                FROM   (SELECT  A.CHG_COST_YRMON" ).append("\n"); 
		query.append("                                              , B.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                                              , A.LSTM_CD" ).append("\n"); 
		query.append("                                              , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                              , A.AGMT_SEQ" ).append("\n"); 
		query.append("                                              , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                              , A.CURR_CD" ).append("\n"); 
		query.append("                                              , COUNT(CNTR_NO) EST_QTY" ).append("\n"); 
		query.append("                                              , SUM(B.DSCR_COST_AMT) DSCR_COST_AMT" ).append("\n"); 
		query.append("                                              , SUM(B.CR_AMT) CR_AMT" ).append("\n"); 
		query.append("                                              , SUM(B.DSCR_COST_AMT + B.CR_AMT ) ESTIMATED_COST" ).append("\n"); 
		query.append("                                              , A.IF_RGST_NO" ).append("\n"); 
		query.append("                                              , COUNT(A.IF_RGST_NO) OVER(PARTITION BY A.IF_RGST_NO) CNT_RGST_SEQ" ).append("\n"); 
		query.append("                                              , MAX(C.MAX_RGST_SEQ) MAX_RGST_SEQ" ).append("\n"); 
		query.append("                                        FROM    LSE_PAY_RNTL_CHG A" ).append("\n"); 
		query.append("                                              , LSE_PAY_RNTL_CHG_DTL B" ).append("\n"); 
		query.append("                                              ,(SELECT  A.INV_RGST_NO, MAX(B.INV_RGST_SEQ) MAX_RGST_SEQ" ).append("\n"); 
		query.append("                                                FROM    AP_PAY_INV A" ).append("\n"); 
		query.append("                                                      , AP_PAY_INV_DTL B" ).append("\n"); 
		query.append("                                                      , PARAM P" ).append("\n"); 
		query.append("                                                WHERE   A.INV_RGST_NO    = B.INV_RGST_NO" ).append("\n"); 
		query.append("                                                AND     A.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("                                                AND     A.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                                                AND     A.INV_STS_CD IN ('P','D')" ).append("\n"); 
		query.append("                                                AND     B.VSL_CD         = 'CNTC'" ).append("\n"); 
		query.append("                                                AND     B.SKD_DIR_CD     = 'M'" ).append("\n"); 
		query.append("                                                AND     B.REV_DIR_CD     = 'M'" ).append("\n"); 
		query.append("                                                AND     SUBSTR(B.ACT_VVD_CD, 5, 4) BETWEEN SUBSTR(P.PERIOD_STDT, 3,4) AND SUBSTR(P.PERIOD_EDDT, 3,4)  " ).append("\n"); 
		query.append("                                                AND     EXISTS ( SELECT 'Y'" ).append("\n"); 
		query.append("                                                                   FROM LSE_RNTL_COST_ACCT_ORD  LAC" ).append("\n"); 
		query.append("                                                                      , SCO_AP_COST_ACT_INFO SAC" ).append("\n"); 
		query.append("                                                                  WHERE LAC.ACCT_CD           = SAC.CONV_ACCT_CD" ).append("\n"); 
		query.append("                                                                    AND LAC.COST_CD           = SAC.ACT_COST_CD" ).append("\n"); 
		query.append("                                                                    AND SAC.SRC_MDL_CD        = 'LSE'" ).append("\n"); 
		query.append("                                                                    AND SAC.ACCL_FLG          = 'Y'" ).append("\n"); 
		query.append("                                                                    AND B.ACCT_CD             = LAC.ACCT_CD" ).append("\n"); 
		query.append("                                                                    AND B.LGS_COST_CD         = LAC.COST_CD" ).append("\n"); 
		query.append("                                                                    AND ROWNUM                = 1)                                              " ).append("\n"); 
		query.append("                                                GROUP BY A.INV_RGST_NO) C " ).append("\n"); 
		query.append("                                             , PARAM P" ).append("\n"); 
		query.append("                                        WHERE   A.AGMT_CTY_CD     = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                        AND     A.AGMT_SEQ        = B.AGMT_SEQ" ).append("\n"); 
		query.append("                                        AND     A.CHG_SEQ         = B.CHG_SEQ" ).append("\n"); 
		query.append("                                        AND     A.IF_RGST_NO      = C.INV_RGST_NO" ).append("\n"); 
		query.append("                                        AND     B.CNTR_AUD_STS_CD = 'A'" ).append("\n"); 
		query.append("                                        AND     A.IF_RGST_NO IS NOT NULL" ).append("\n"); 
		query.append("                                        AND     A.CHG_COST_YRMON BETWEEN P.PERIOD_STDT AND P.PERIOD_EDDT" ).append("\n"); 
		query.append("                                        GROUP BY B.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                                               , A.CHG_COST_YRMON, A.AGMT_CTY_CD, A.AGMT_SEQ" ).append("\n"); 
		query.append("                                               , A.LSTM_CD, B.CNTR_TPSZ_CD, A.IF_RGST_NO, A.CURR_CD" ).append("\n"); 
		query.append("                                        ) A" ).append("\n"); 
		query.append("                                WHERE   1 = 1" ).append("\n"); 
		query.append("                                AND     A.CNT_RGST_SEQ <= A.MAX_RGST_SEQ" ).append("\n"); 
		query.append("                                OR     (CASE WHEN A.CNT_RGST_SEQ > A.MAX_RGST_SEQ THEN A.DSCR_COST_AMT END > 0" ).append("\n"); 
		query.append("                                OR      CASE WHEN A.CNT_RGST_SEQ > A.MAX_RGST_SEQ THEN A.CR_AMT        END < 0)" ).append("\n"); 
		query.append("                                )  A" ).append("\n"); 
		query.append("                        ) A," ).append("\n"); 
		query.append("                       (SELECT  B.INV_RGST_SEQ AS IF_RGST_SEQ" ).append("\n"); 
		query.append("                              , B.ACCT_CD" ).append("\n"); 
		query.append("                              , B.CNTR_TPSZ_CD TPSZ" ).append("\n"); 
		query.append("                              , B.INV_RGST_NO AS IF_RGST_NO" ).append("\n"); 
		query.append("                              , B.VSL_CD" ).append("\n"); 
		query.append("                              , B.SKD_DIR_CD" ).append("\n"); 
		query.append("                              , B.REV_DIR_CD" ).append("\n"); 
		query.append("                              , A.INV_CURR_CD CRR_CD" ).append("\n"); 
		query.append("                              , SUM(B.INV_AMT) INV_AMT" ).append("\n"); 
		query.append("                        FROM    AP_PAY_INV     A" ).append("\n"); 
		query.append("                              , AP_PAY_INV_DTL B" ).append("\n"); 
		query.append("                              , PARAM P" ).append("\n"); 
		query.append("                        WHERE   A.INV_RGST_NO    = B.INV_RGST_NO" ).append("\n"); 
		query.append("                        AND     A.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("                        AND     A.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                        AND     A.INV_STS_CD     IN ('P','D')" ).append("\n"); 
		query.append("                        AND     B.VSL_CD         = 'CNTC'                        " ).append("\n"); 
		query.append("                        AND     B.SKD_DIR_CD     = 'M'" ).append("\n"); 
		query.append("                        AND     B.REV_DIR_CD     = 'M'" ).append("\n"); 
		query.append("                        AND     SUBSTR(B.ACT_VVD_CD, 5, 4) BETWEEN SUBSTR(P.PERIOD_STDT, 3,4) AND SUBSTR(P.PERIOD_EDDT, 3,4)" ).append("\n"); 
		query.append("                        AND     EXISTS ( SELECT 'Y'" ).append("\n"); 
		query.append("                                   FROM SCO_AP_COST_ACT_INFO SAC" ).append("\n"); 
		query.append("                                  WHERE B.ACCT_CD             = SAC.CONV_ACCT_CD" ).append("\n"); 
		query.append("                                    AND B.LGS_COST_CD         = SAC.ACT_COST_CD" ).append("\n"); 
		query.append("                                    AND SAC.SRC_MDL_CD        = 'LSE'" ).append("\n"); 
		query.append("                                    AND SAC.ACCL_FLG          = 'Y'" ).append("\n"); 
		query.append("                                    AND ROWNUM                = 1)" ).append("\n"); 
		query.append("                        GROUP BY B.ACCT_CD, B.VSL_CD, B.SKD_DIR_CD, B.REV_DIR_CD, " ).append("\n"); 
		query.append("                                 B.CNTR_TPSZ_CD, A.INV_CURR_CD, B.INV_RGST_NO, B.INV_RGST_SEQ" ).append("\n"); 
		query.append("                        ) B" ).append("\n"); 
		query.append("                WHERE   A.IF_RGST_NO = B.IF_RGST_NO" ).append("\n"); 
		query.append("                AND     A.IF_RGST_SEQ = B.IF_RGST_SEQ" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT  C.REV_MONTH" ).append("\n"); 
		query.append("                      , B.ACCT_CD" ).append("\n"); 
		query.append("                      , C.AGMT_CTY_CD||TRIM(TO_CHAR(C.AGMT_SEQ, '000000')) AGMT_NO" ).append("\n"); 
		query.append("                      , C.AGMT_CTY_CD AGMT_CTY_CD" ).append("\n"); 
		query.append("                      , C.AGMT_SEQ AGMT_SEQ" ).append("\n"); 
		query.append("                      , B.CNTR_TPSZ_CD TPSZ" ).append("\n"); 
		query.append("                      , 0 EST_QTY" ).append("\n"); 
		query.append("                      , B.VSL_CD" ).append("\n"); 
		query.append("                      , SUBSTR(C.REV_MONTH, 3, 4) AS SKD_VOYAGE_NO" ).append("\n"); 
		query.append("                      , B.SKD_DIR_CD" ).append("\n"); 
		query.append("                      , B.REV_DIR_CD" ).append("\n"); 
		query.append("                      , A.INV_CURR_CD CRR_CD" ).append("\n"); 
		query.append("                      , 0 ESTIMATED_COST" ).append("\n"); 
		query.append("                      , MAX(C.INV_AMT) INV_AMT" ).append("\n"); 
		query.append("                      , B.INV_RGST_NO IF_RGST_NO" ).append("\n"); 
		query.append("		              , C.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                FROM    AP_PAY_INV A" ).append("\n"); 
		query.append("                      , AP_PAY_INV_DTL B" ).append("\n"); 
		query.append("                     ,(SELECT   HDR.IF_RGST_NO, HDR.CHG_COST_YRMON AS REV_MONTH, DTL.LSE_PAY_CHG_TP_CD, HDR.AGMT_CTY_CD, HDR.AGMT_SEQ, DTL.CNTR_TPSZ_CD, SUM(DTL.DSCR_COST_AMT+DTL.CR_AMT) AS INV_AMT" ).append("\n"); 
		query.append("                        FROM    LSE_PAY_RNTL_CHG HDR" ).append("\n"); 
		query.append("                              , LSE_PAY_RNTL_CHG_DTL DTL" ).append("\n"); 
		query.append("                        WHERE  HDR.AGMT_CTY_CD                = DTL.AGMT_CTY_CD" ).append("\n"); 
		query.append("                          AND  HDR.AGMT_SEQ                  = DTL.AGMT_SEQ" ).append("\n"); 
		query.append("                          AND  HDR.CHG_SEQ                   = DTL.CHG_SEQ" ).append("\n"); 
		query.append("                          AND  HDR.LSE_PAY_RNTL_STS_CD       = 'I'" ).append("\n"); 
		query.append("                          AND  NVL(DTL.CNTR_AUD_STS_CD, 'A') = 'A'  " ).append("\n"); 
		query.append("                        GROUP BY HDR.IF_RGST_NO, CHG_COST_YRMON, DTL.LSE_PAY_CHG_TP_CD, HDR.AGMT_CTY_CD, HDR.AGMT_SEQ, DTL.CNTR_TPSZ_CD    " ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT  OP.IF_RGST_NO, TO_CHAR(TO_DATE(OP.SKD_VOY_NO, 'YYMM'), 'YYYYMM') AS REV_MONTH, 'OPL' AS LSE_PAY_CHG_TP_CD, OP.AGMT_CTY_CD, OP.AGMT_SEQ, OP.CNTR_TPSZ_CD, SUM(OP.PAY_AMT) AS INV_AMT" ).append("\n"); 
		query.append("                        FROM    LSE_OP_LSE OP" ).append("\n"); 
		query.append("                        WHERE OP.OP_LSE_STS_CD = 'I'" ).append("\n"); 
		query.append("                        GROUP BY OP.IF_RGST_NO, TO_CHAR(TO_DATE(OP.SKD_VOY_NO, 'YYMM'), 'YYYYMM'), OP.AGMT_CTY_CD, OP.AGMT_SEQ, OP.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                        ) C" ).append("\n"); 
		query.append("                      , PARAM P" ).append("\n"); 
		query.append("                WHERE   B.INV_RGST_NO    = A.INV_RGST_NO" ).append("\n"); 
		query.append("                AND     B.INV_RGST_NO    = C.IF_RGST_NO" ).append("\n"); 
		query.append("                AND     B.CNTR_TPSZ_CD   = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                AND     A.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("                AND     A.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                AND     A.INV_STS_CD     IN ('P','D')" ).append("\n"); 
		query.append("                AND     B.VSL_CD         = 'CNTC'                " ).append("\n"); 
		query.append("                AND     B.SKD_DIR_CD     = 'M'" ).append("\n"); 
		query.append("                AND     B.REV_DIR_CD     = 'M'" ).append("\n"); 
		query.append("                AND     SUBSTR(B.ACT_VVD_CD, 5, 4) BETWEEN SUBSTR(P.PERIOD_STDT, 3, 4) AND SUBSTR(P.PERIOD_EDDT, 3, 4) " ).append("\n"); 
		query.append("                AND     EXISTS ( SELECT 'Y'" ).append("\n"); 
		query.append("                                   FROM SCO_AP_COST_ACT_INFO SAC" ).append("\n"); 
		query.append("                                  WHERE B.ACCT_CD             = SAC.CONV_ACCT_CD" ).append("\n"); 
		query.append("                                    AND B.LGS_COST_CD         = SAC.ACT_COST_CD" ).append("\n"); 
		query.append("                                    AND SAC.SRC_MDL_CD        = 'LSE'" ).append("\n"); 
		query.append("                                    AND SAC.ACCL_FLG          = 'Y'" ).append("\n"); 
		query.append("                                    AND ROWNUM                = 1)           " ).append("\n"); 
		query.append("                GROUP BY C.REV_MONTH, B.ACCT_CD, C.AGMT_CTY_CD||TRIM(TO_CHAR(C.AGMT_SEQ, '000000')), C.AGMT_CTY_CD," ).append("\n"); 
		query.append("                         C.AGMT_SEQ, B.VSL_CD, SUBSTR(C.REV_MONTH, 3, 4), " ).append("\n"); 
		query.append("                         B.SKD_DIR_CD, B.REV_DIR_CD, B.CNTR_TPSZ_CD, A.INV_CURR_CD, B.INV_RGST_NO, C.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                ) SUB" ).append("\n"); 
		query.append("                 GROUP BY REV_MONTH, ACCT_CODE, TP_SZ, VSL_CD, SKD_VOY_NO, " ).append("\n"); 
		query.append("                 SKD_DIR_CD, REV_DIR_CD, CRR_CD, IF_RGST_NO, LSE_PAY_CHG_TP_CD, AGMT_NO, AGMT_CTY_CD, AGMT_SEQ" ).append("\n"); 
		query.append("                ) SUB, RCV_VAL P" ).append("\n"); 
		query.append("WHERE DECODE(SUB.LSE_PAY_CHG_TP_CD, 'OPL', 1, EST_QTY) > 0 " ).append("\n"); 
		query.append("AND EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                 FROM LSE_AGREEMENT LA" ).append("\n"); 
		query.append("                WHERE SUB.AGMT_CTY_CD  = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("                  AND SUB.AGMT_SEQ     = LA.AGMT_SEQ" ).append("\n"); 
		query.append("                  AND LA.LSTM_CD       IN ( 'ST', 'LT', 'LP', 'OL')" ).append("\n"); 
		query.append("                  AND LA.LSE_PAY_TP_CD = 'NP'" ).append("\n"); 
		query.append("                  #if (${lse_ctrt_no} != '')" ).append("\n"); 
		query.append("                  AND LA.LSE_CTRT_NO = @[lse_ctrt_no]" ).append("\n"); 
		query.append("                  #end  " ).append("\n"); 
		query.append("                  #if (${vndr_seq} != '')" ).append("\n"); 
		query.append("                  AND LA.VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("                  #end  " ).append("\n"); 
		query.append("                  #if (${agmt_seq} != '')" ).append("\n"); 
		query.append("                  AND LA.AGMT_CTY_CD = 'HHO'" ).append("\n"); 
		query.append("                  AND LA.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("                  #end " ).append("\n"); 
		query.append("                  AND ROWNUM           = 1)" ).append("\n"); 
		query.append("AND REPLACE(SUB.REV_MONTH, '-', '') > DECODE(SUB.LSTM_CD, 'LT', '201603', 'ST', '201603', '000000')" ).append("\n"); 
		query.append("#if (${lse_pay_chg_tp_cd} != '')" ).append("\n"); 
		query.append("AND SUB.LSE_PAY_CHG_TP_CD = @[lse_pay_chg_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skr_acct_cd} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("              FROM  MDM_ACCOUNT MA" ).append("\n"); 
		query.append("             WHERE SUB.ACCT_CODE  = MA.ACCT_CD" ).append("\n"); 
		query.append("               AND MA.MODI_ACCT_CD IN (" ).append("\n"); 
		query.append("  		 			#foreach($key IN ${arr_skr_acct_cd})" ).append("\n"); 
		query.append("			  		  	#if($velocityCount < $arr_skr_acct_cd.size())" ).append("\n"); 
		query.append("  							'$key', " ).append("\n"); 
		query.append("  						#else " ).append("\n"); 
		query.append("  							'$key' " ).append("\n"); 
		query.append("  						#end " ).append("\n"); 
		query.append("  					#end " ).append("\n"); 
		query.append("					 )" ).append("\n"); 
		query.append("               AND ROWNUM  = 1)" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${rev_month} != '')" ).append("\n"); 
		query.append("AND REPLACE(SUB.REV_MONTH, '-', '') = REPLACE(@[rev_month], '-', '')" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("ORDER BY ACTUAL_MONTH, REV_MONTH DESC, AGMT_NO, TP_SZ" ).append("\n"); 

	}
}