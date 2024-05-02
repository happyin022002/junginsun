/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PayableEstimateAuditDBDAOcalculationPayableEstimateAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * 2010.09.03 양봉준   [CHM-201005796-01] 추정비용 실적집계하는 로직 수정, 승인된 Charge에 대해서만 집계되도록 수정함 LSE_PAY_RNTL_CHG 테이블의 CNTR_AUD_STS_CD ='A' 조건 추가
	  * 2010.09.10 남궁진호[CHM-201005908-01]  LP Term 정보 조회시 Estimate 금액이 잘못 산출되는 현상 보완, ACCOUNT CODE를 지정하여 처리함
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
		params.put("period_eddt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_stdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.integration").append("\n"); 
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
		query.append("SELECT  0 AS SEQ" ).append("\n"); 
		query.append("      , @[period_dt] AS ACTUAL_MONTH" ).append("\n"); 
		query.append("      , 'LSE' AS SYS_NAME" ).append("\n"); 
		query.append("      , IF_RGST_NO" ).append("\n"); 
		query.append("      , REV_MONTH" ).append("\n"); 
		query.append("      , ACCT_CODE" ).append("\n"); 
		query.append("      , AGMT_NO" ).append("\n"); 
		query.append("      , AGMT_CTY_CD" ).append("\n"); 
		query.append("      , AGMT_SEQ" ).append("\n"); 
		query.append("      , 'CNTR' AS BIZ_UNIT" ).append("\n"); 
		query.append("      , TP_SZ" ).append("\n"); 
		query.append("      , EST_QTY" ).append("\n"); 
		query.append("      , ESTIMATED_COST" ).append("\n"); 
		query.append("      , ACTUAL_COST" ).append("\n"); 
		query.append("      , ACCURAL_AMT" ).append("\n"); 
		query.append("      , VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD AS REV_VVD" ).append("\n"); 
		query.append("      , 'KRSEL' AS LOC_CD" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , SKD_DIR_CD" ).append("\n"); 
		query.append("      , REV_DIR_CD" ).append("\n"); 
		query.append("      , TO_CHAR(SYSDATE,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("      , TO_CHAR(SYSDATE,'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("FROM   (SELECT  REV_MONTH" ).append("\n"); 
		query.append("              , ACCT_CODE" ).append("\n"); 
		query.append("              , TP_SZ" ).append("\n"); 
		query.append("              , VSL_CD" ).append("\n"); 
		query.append("              , SKD_VOY_NO" ).append("\n"); 
		query.append("              , SKD_DIR_CD" ).append("\n"); 
		query.append("              , REV_DIR_CD" ).append("\n"); 
		query.append("              , CRR_CD" ).append("\n"); 
		query.append("              , IF_RGST_NO" ).append("\n"); 
		query.append("              , MAX(AGMT_NO) AS AGMT_NO" ).append("\n"); 
		query.append("              , MAX(AGMT_CTY_CD) AS AGMT_CTY_CD" ).append("\n"); 
		query.append("              , MAX(AGMT_SEQ) AS AGMT_SEQ" ).append("\n"); 
		query.append("              , SUM(EST_QTY)        AS EST_QTY" ).append("\n"); 
		query.append("              , SUM(ESTIMATED_COST) AS ESTIMATED_COST" ).append("\n"); 
		query.append("              , SUM(INV_AMT) AS ACTUAL_COST" ).append("\n"); 
		query.append("              , CASE WHEN SUM(ESTIMATED_COST) - SUM(INV_AMT) < 0 THEN 0" ).append("\n"); 
		query.append("                     ELSE SUM(ESTIMATED_COST) - SUM(INV_AMT)" ).append("\n"); 
		query.append("                END AS ACCURAL_AMT" ).append("\n"); 
		query.append("        FROM   (SELECT  TO_CHAR(TO_DATE(SKD_VOY_NO, 'YYMM'), 'YYYYMM') REV_MONTH" ).append("\n"); 
		query.append("                      , '510811' ACCT_CODE" ).append("\n"); 
		query.append("                      , AGMT_CTY_CD || LTRIM(TO_CHAR(AGMT_SEQ, '000000')) AGMT_NO" ).append("\n"); 
		query.append("                      , AGMT_CTY_CD AGMT_CTY_CD" ).append("\n"); 
		query.append("                      , AGMT_SEQ AGMT_SEQ" ).append("\n"); 
		query.append("                      , CNTR_TPSZ_CD TP_SZ" ).append("\n"); 
		query.append("                      , OP_LSE_QTY EST_QTY" ).append("\n"); 
		query.append("                      , VSL_CD VSL_CD" ).append("\n"); 
		query.append("                      , SKD_VOY_NO SKD_VOY_NO" ).append("\n"); 
		query.append("                      , SKD_DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append("                      , REV_DIR_CD REV_DIR_CD" ).append("\n"); 
		query.append("                      , 'USD' CRR_CD" ).append("\n"); 
		query.append("                      , SUM(PAY_AMT) ESTIMATED_COST" ).append("\n"); 
		query.append("                      , 0 INV_AMT" ).append("\n"); 
		query.append("                      , IF_RGST_NO" ).append("\n"); 
		query.append("                FROM    LSE_OP_LSE" ).append("\n"); 
		query.append("                WHERE   OP_LSE_STS_CD <> 'D'" ).append("\n"); 
		query.append("                AND     ISS_YRMON BETWEEN @[period_stdt] AND @[period_eddt]" ).append("\n"); 
		query.append("                GROUP BY TO_CHAR(TO_DATE(SKD_VOY_NO, 'YYMM'), 'YYYYMM'), " ).append("\n"); 
		query.append("                         AGMT_CTY_CD || LTRIM(TO_CHAR(AGMT_SEQ, '000000')), AGMT_CTY_CD, AGMT_SEQ, " ).append("\n"); 
		query.append("                         CNTR_TPSZ_CD, OP_LSE_QTY, IF_RGST_NO, VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD, " ).append("\n"); 
		query.append("                         VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD" ).append("\n"); 
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
		query.append("                      , 'USD' CRR_CD" ).append("\n"); 
		query.append("                      , ESTIMATED_COST" ).append("\n"); 
		query.append("                      , 0 INV_AMT" ).append("\n"); 
		query.append("                      , NVL(A.IF_RGST_NO, A.AGMT_SEQ) IF_RGST_NO" ).append("\n"); 
		query.append("                FROM   (SELECT  A.CHG_COST_YRMON" ).append("\n"); 
		query.append("                              , A.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                              , A.LSTM_CD" ).append("\n"); 
		query.append("                              , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                              , A.AGMT_SEQ" ).append("\n"); 
		query.append("                              , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                              , C.ACCT_CD" ).append("\n"); 
		query.append("                              , C.COST_CD" ).append("\n"); 
		query.append("                              , COUNT(CNTR_NO) EST_QTY" ).append("\n"); 
		query.append("                              , SUM(A.TTL_COST_AMT + A.CR_AMT) ESTIMATED_COST" ).append("\n"); 
		query.append("                              , A.IF_RGST_NO" ).append("\n"); 
		query.append("                        FROM   (SELECT  A.IF_RGST_NO" ).append("\n"); 
		query.append("                                      , A.CHG_COST_YRMON" ).append("\n"); 
		query.append("                                      , A.LSTM_CD" ).append("\n"); 
		query.append("                                      , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                      , A.AGMT_SEQ" ).append("\n"); 
		query.append("                                      , B.CNTR_NO, B.LSE_PAY_CHG_TP_CD, B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                        B.CR_AMT, B.TTL_COST_AMT" ).append("\n"); 
		query.append("                                FROM    LSE_PAY_RNTL_CHG     A" ).append("\n"); 
		query.append("                                      , LSE_PAY_RNTL_CHG_DTL B" ).append("\n"); 
		query.append("                                WHERE   A.AGMT_CTY_CD   = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                AND     A.AGMT_SEQ      = B.AGMT_SEQ" ).append("\n"); 
		query.append("                                AND     A.CHG_SEQ       = B.CHG_SEQ" ).append("\n"); 
		query.append("                                AND     A.CHG_COST_YRMON BETWEEN @[period_stdt] AND @[period_eddt]" ).append("\n"); 
		query.append("                               ) A" ).append("\n"); 
		query.append("                              ,(SELECT  LSE_RCV_CHG_TP_CD, ACCT_CD, LSTM_CD, COST_CD" ).append("\n"); 
		query.append("                                FROM    LSE_RNTL_COST_ACCT_ORD WHERE LSTM_CD = 'XX'" ).append("\n"); 
		query.append("                                UNION ALL" ).append("\n"); 
		query.append("                                SELECT  LSE_RCV_CHG_TP_CD, ACCT_CD, 'BX', COST_CD" ).append("\n"); 
		query.append("                                FROM    LSE_RNTL_COST_ACCT_ORD WHERE LSTM_CD = 'XX'" ).append("\n"); 
		query.append("                                UNION ALL" ).append("\n"); 
		query.append("                                SELECT  LSE_RCV_CHG_TP_CD, ACCT_CD, LSTM_CD, COST_CD" ).append("\n"); 
		query.append("                                FROM   (SELECT  A.LSE_RCV_CHG_TP_CD," ).append("\n"); 
		query.append("                                                A.LSTM_CD AS ZZZ," ).append("\n"); 
		query.append("                                                A.ACCT_CD AS ACCT_CD," ).append("\n"); 
		query.append("                                                A.COST_CD," ).append("\n"); 
		query.append("                                                B.LSTM_CD AS LSTM_CD" ).append("\n"); 
		query.append("                                        FROM    LSE_RNTL_COST_ACCT_ORD A," ).append("\n"); 
		query.append("                                                MST_LSE_TERM B" ).append("\n"); 
		query.append("                                        WHERE   A.LSTM_CD IN('XX', B.LSTM_CD)" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                WHERE  (LSE_RCV_CHG_TP_CD, ZZZ, LSTM_CD) NOT IN (SELECT A.LSE_RCV_CHG_TP_CD, 'XX', B.LSTM_CD" ).append("\n"); 
		query.append("                                                                                 FROM   LSE_RNTL_COST_ACCT_ORD A," ).append("\n"); 
		query.append("                                                                                        MST_LSE_TERM B" ).append("\n"); 
		query.append("                                                                                 WHERE  A.LSTM_CD = B.LSTM_CD)" ).append("\n"); 
		query.append("                                ) C" ).append("\n"); 
		query.append("                        WHERE   A.LSTM_CD           = C.LSTM_CD          (+)" ).append("\n"); 
		query.append("                        AND     A.LSE_PAY_CHG_TP_CD = C.LSE_RCV_CHG_TP_CD(+)" ).append("\n"); 
		query.append("                        AND     A.IF_RGST_NO IS NULL" ).append("\n"); 
		query.append("                        GROUP BY A.LSE_PAY_CHG_TP_CD, C.ACCT_CD, C.COST_CD" ).append("\n"); 
		query.append("                               , A.CHG_COST_YRMON, A.AGMT_CTY_CD, A.AGMT_SEQ" ).append("\n"); 
		query.append("                               , A.LSTM_CD, A.CNTR_TPSZ_CD, A.IF_RGST_NO" ).append("\n"); 
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
		query.append("                              , 'USD' CRR_CD" ).append("\n"); 
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
		query.append("                                        MAX_RGST_SEQ" ).append("\n"); 
		query.append("                                FROM   (SELECT  A.CHG_COST_YRMON" ).append("\n"); 
		query.append("                                              , B.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                                              , A.LSTM_CD" ).append("\n"); 
		query.append("                                              , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                              , A.AGMT_SEQ" ).append("\n"); 
		query.append("                                              , B.CNTR_TPSZ_CD" ).append("\n"); 
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
		query.append("                                                WHERE   A.INV_RGST_NO    = B.INV_RGST_NO" ).append("\n"); 
		query.append("                                                AND     A.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("                                                AND     A.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                                                AND     A.INV_STS_CD  IN ('P','D')" ).append("\n"); 
		query.append("                                                AND     B.VSL_CD         = 'CNTC'" ).append("\n"); 
		query.append("                                                AND     B.SKD_DIR_CD     = 'M'" ).append("\n"); 
		query.append("                                                AND     B.REV_DIR_CD     = 'M'" ).append("\n"); 
		query.append("                                                AND     B.SKD_VOY_NO BETWEEN SUBSTR(@[period_stdt], 3,4) AND SUBSTR(@[period_eddt], 3,4)                                                " ).append("\n"); 
		query.append("                                                GROUP BY A.INV_RGST_NO) C " ).append("\n"); 
		query.append("                                        WHERE   A.AGMT_CTY_CD     = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                        AND     A.AGMT_SEQ        = B.AGMT_SEQ" ).append("\n"); 
		query.append("                                        AND     A.CHG_SEQ         = B.CHG_SEQ" ).append("\n"); 
		query.append("                                        AND     A.IF_RGST_NO      = C.INV_RGST_NO" ).append("\n"); 
		query.append("                                        AND     B.CNTR_AUD_STS_CD = 'A'" ).append("\n"); 
		query.append("                                        AND     A.IF_RGST_NO IS NOT NULL" ).append("\n"); 
		query.append("                                        AND     A.CHG_COST_YRMON BETWEEN @[period_stdt] AND @[period_eddt]" ).append("\n"); 
		query.append("                                        GROUP BY B.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                                               , A.CHG_COST_YRMON, A.AGMT_CTY_CD, A.AGMT_SEQ" ).append("\n"); 
		query.append("                                               , A.LSTM_CD, B.CNTR_TPSZ_CD, A.IF_RGST_NO" ).append("\n"); 
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
		query.append("                        WHERE   A.INV_RGST_NO    = B.INV_RGST_NO" ).append("\n"); 
		query.append("                        AND     A.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("                        AND     A.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                        AND     A.INV_STS_CD IN ('P','D')" ).append("\n"); 
		query.append("                        AND     B.VSL_CD         = 'CNTC'                        " ).append("\n"); 
		query.append("                        AND     B.SKD_DIR_CD     = 'M'" ).append("\n"); 
		query.append("                        AND     B.REV_DIR_CD     = 'M'" ).append("\n"); 
		query.append("                        AND     B.SKD_VOY_NO BETWEEN SUBSTR(@[period_stdt], 3,4) AND SUBSTR(@[period_eddt], 3,4)" ).append("\n"); 
		query.append("                        GROUP BY B.ACCT_CD, B.VSL_CD, B.SKD_DIR_CD, B.REV_DIR_CD, " ).append("\n"); 
		query.append("                                 B.CNTR_TPSZ_CD, A.INV_CURR_CD, B.INV_RGST_NO, B.INV_RGST_SEQ" ).append("\n"); 
		query.append("                        ) B" ).append("\n"); 
		query.append("                WHERE   A.IF_RGST_NO = B.IF_RGST_NO" ).append("\n"); 
		query.append("                AND     A.IF_RGST_SEQ = B.IF_RGST_SEQ" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT  C.REV_MONTH" ).append("\n"); 
		query.append("                      , B.ACCT_CD" ).append("\n"); 
		query.append("                      , NULL AGMT_NO" ).append("\n"); 
		query.append("                      , NULL AGMT_CTY_CD" ).append("\n"); 
		query.append("                      , NULL AGMT_SEQ" ).append("\n"); 
		query.append("                      , B.CNTR_TPSZ_CD TPSZ" ).append("\n"); 
		query.append("                      , 0 EST_QTY" ).append("\n"); 
		query.append("                      , B.VSL_CD" ).append("\n"); 
		query.append("                      , SUBSTR(C.REV_MONTH, 3, 4) AS SKD_VOYAGE_NO" ).append("\n"); 
		query.append("                      , B.SKD_DIR_CD" ).append("\n"); 
		query.append("                      , B.REV_DIR_CD" ).append("\n"); 
		query.append("                      , A.INV_CURR_CD CRR_CD" ).append("\n"); 
		query.append("                      , 0 ESTIMATED_COST" ).append("\n"); 
		query.append("                      , SUM(B.INV_AMT) INV_AMT" ).append("\n"); 
		query.append("                      , B.INV_RGST_NO IF_RGST_NO" ).append("\n"); 
		query.append("                FROM    AP_PAY_INV A" ).append("\n"); 
		query.append("                      , AP_PAY_INV_DTL B" ).append("\n"); 
		query.append("                      ,(SELECT  DISTINCT IF_RGST_NO, CHG_COST_YRMON AS REV_MONTH" ).append("\n"); 
		query.append("                        FROM    LSE_PAY_RNTL_CHG" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT	DISTINCT IF_RGST_NO, TO_CHAR(TO_DATE(SKD_VOY_NO, 'YYMM'), 'YYYYMM') AS REV_MONTH" ).append("\n"); 
		query.append("                        FROM    LSE_OP_LSE" ).append("\n"); 
		query.append("                        ) C" ).append("\n"); 
		query.append("                WHERE   B.INV_RGST_NO 	 = A.INV_RGST_NO" ).append("\n"); 
		query.append("                AND     B.INV_RGST_NO    = C.IF_RGST_NO" ).append("\n"); 
		query.append("                AND     A.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("                AND     A.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                AND     A.INV_STS_CD IN ('P','D')" ).append("\n"); 
		query.append("                AND     B.VSL_CD         = 'CNTC'                " ).append("\n"); 
		query.append("                AND     B.SKD_DIR_CD     = 'M'" ).append("\n"); 
		query.append("                AND     B.REV_DIR_CD     = 'M'" ).append("\n"); 
		query.append("                AND     B.SKD_VOY_NO BETWEEN SUBSTR(@[period_stdt], 3, 4) AND SUBSTR(@[period_eddt], 3, 4)                " ).append("\n"); 
		query.append("                GROUP BY C.REV_MONTH, B.ACCT_CD, B.VSL_CD, SUBSTR(C.REV_MONTH, 3, 4), " ).append("\n"); 
		query.append("                         B.SKD_DIR_CD, B.REV_DIR_CD, B.CNTR_TPSZ_CD, A.INV_CURR_CD, B.INV_RGST_NO" ).append("\n"); 
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
		query.append("                              , 'USD' CRR_CD" ).append("\n"); 
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
		query.append("                                        MAX_RGST_SEQ" ).append("\n"); 
		query.append("                                FROM   (SELECT  A.CHG_COST_YRMON" ).append("\n"); 
		query.append("                                              , B.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                                              , A.LSTM_CD" ).append("\n"); 
		query.append("                                              , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                              , A.AGMT_SEQ" ).append("\n"); 
		query.append("                                              , B.CNTR_TPSZ_CD" ).append("\n"); 
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
		query.append("                                                WHERE   A.INV_RGST_NO    = B.INV_RGST_NO" ).append("\n"); 
		query.append("                                                AND     A.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("                                                AND     A.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                                                AND     A.INV_STS_CD  IN ('C','A')" ).append("\n"); 
		query.append("                                                AND     B.VSL_CD         = 'CNTC'" ).append("\n"); 
		query.append("                                                AND     B.SKD_DIR_CD     = 'M'" ).append("\n"); 
		query.append("                                                AND     B.REV_DIR_CD     = 'M'" ).append("\n"); 
		query.append("                                                AND     B.SKD_VOY_NO BETWEEN SUBSTR(@[period_stdt], 3,4) AND SUBSTR(@[period_eddt], 3,4)                                                " ).append("\n"); 
		query.append("                                                GROUP BY A.INV_RGST_NO) C " ).append("\n"); 
		query.append("                                        WHERE   A.AGMT_CTY_CD     = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                        AND     A.AGMT_SEQ        = B.AGMT_SEQ" ).append("\n"); 
		query.append("                                        AND     A.CHG_SEQ         = B.CHG_SEQ" ).append("\n"); 
		query.append("                                        AND     A.IF_RGST_NO      = C.INV_RGST_NO" ).append("\n"); 
		query.append("                                        AND     B.CNTR_AUD_STS_CD = 'A'" ).append("\n"); 
		query.append("                                        AND     A.IF_RGST_NO IS NOT NULL" ).append("\n"); 
		query.append("                                        AND     A.CHG_COST_YRMON BETWEEN @[period_stdt] AND @[period_eddt]" ).append("\n"); 
		query.append("                                        GROUP BY B.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                                               , A.CHG_COST_YRMON, A.AGMT_CTY_CD, A.AGMT_SEQ" ).append("\n"); 
		query.append("                                               , A.LSTM_CD, B.CNTR_TPSZ_CD, A.IF_RGST_NO" ).append("\n"); 
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
		query.append("                        WHERE   A.INV_RGST_NO    = B.INV_RGST_NO" ).append("\n"); 
		query.append("                        AND     A.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("                        AND     A.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                        AND     A.INV_STS_CD IN ('C','A')" ).append("\n"); 
		query.append("                        AND     B.VSL_CD         = 'CNTC'                        " ).append("\n"); 
		query.append("                        AND     B.SKD_DIR_CD     = 'M'" ).append("\n"); 
		query.append("                        AND     B.REV_DIR_CD     = 'M'" ).append("\n"); 
		query.append("                        AND     B.SKD_VOY_NO BETWEEN SUBSTR(@[period_stdt], 3,4) AND SUBSTR(@[period_eddt], 3,4)" ).append("\n"); 
		query.append("                        GROUP BY B.ACCT_CD, B.VSL_CD, B.SKD_DIR_CD, B.REV_DIR_CD, " ).append("\n"); 
		query.append("                                 B.CNTR_TPSZ_CD, A.INV_CURR_CD, B.INV_RGST_NO, B.INV_RGST_SEQ" ).append("\n"); 
		query.append("                        ) B" ).append("\n"); 
		query.append("                WHERE   A.IF_RGST_NO = B.IF_RGST_NO" ).append("\n"); 
		query.append("                AND     A.IF_RGST_SEQ = B.IF_RGST_SEQ" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        GROUP BY REV_MONTH, ACCT_CODE, TP_SZ, VSL_CD, SKD_VOY_NO, " ).append("\n"); 
		query.append("                 SKD_DIR_CD, REV_DIR_CD, CRR_CD, IF_RGST_NO" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}