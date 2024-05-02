/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOsearchCHSEstimateExpenseCalcDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOsearchCHSEstimateExpenseCalcDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20091007 1107 start
	  * -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * 2014-06-16 BY JUSTIN HAN CSR ID : CHM-201430737, TITLE : ALPS-CHSS-Invoice에서 chassis estimated Expense 로직 수정 요청
	  *                   CHANGED CP, NP ESTIMATED EXPENSE G/L DATE CONDITIONAL CLAUSE, TO BETWEEN
	  * 2015-03-24 BY Chang Young Kim CSR ID : CHM-201534562, Title : 미주샷시 임차료(사용료) 추정 비용 로직 검토 의뢰
	  *                   기준일중 From을 전년도 1월로 변경
	  * 2015-03-30 Query Tunning TIS 
	  * 2015-07-30 [CHM-201536860] 샤시 월별 추정 실적 입력 로직 변경.
	  *                  ZP Estimate 금액을 CGM_CHSS_POOL_EXPN_ESTM으로 변경함
	  * 2015-09-22 [CHM-201537907] 샤시 추정실적 입력 로직 변경.
	  *                  Estimate 금액 로직 삭제
	  * 2015-11-06 [CHM-201538798] 샤시 추정실적 "ACCRUAL COST" 계산 로직 변경
	  *                  Accrual Cost 계산로직에서 ABS 삭제
	  * -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOsearchCHSEstimateExpenseCalcDataRSQL(){
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
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOsearchCHSEstimateExpenseCalcDataRSQL").append("\n"); 
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
		query.append("SELECT   @[period_eddt] AS EXE_YRMON" ).append("\n"); 
		query.append("       , 'CHS' AS SYS_SRC_ID" ).append("\n"); 
		query.append("       , T1.COST_YRMON AS REV_YRMON" ).append("\n"); 
		query.append("       , T1.ACCT_CD AS ACCT_CD" ).append("\n"); 
		query.append("       , T1.AGMT_NO AS AGMT_NO" ).append("\n"); 
		query.append("       , T1.AGMT_LSTM_CD AS AGMT_LSTM_CD" ).append("\n"); 
		query.append("       , T1.CHSS_POOL_CD AS CHSS_POOL_CD" ).append("\n"); 
		query.append("       , T1.INV_NO AS INVO_NO" ).append("\n"); 
		query.append("       , 1 AS ESTM_SEQ_NO" ).append("\n"); 
		query.append("       , 'CNTC' AS VSL_CD" ).append("\n"); 
		query.append("       , SUBSTR(T1.COST_YRMON, 3, 4) AS SKD_VOY_NO" ).append("\n"); 
		query.append("       , 'M' AS SKD_DIR_CD" ).append("\n"); 
		query.append("       , 'M' AS REV_DIR_CD" ).append("\n"); 
		query.append("       , 'CNTC'||SUBSTR(T1.COST_YRMON, 3, 4)||'MM' AS REV_VVD" ).append("\n"); 
		query.append("       , NVL(T1.ESTIMATE_AMT, 0) AS ESTM_AMT" ).append("\n"); 
		query.append("       , NVL(T1.ACTUAL_AMT,0) AS ACT_AMT" ).append("\n"); 
		query.append("       , CASE WHEN NVL(T1.ESTIMATE_AMT, 0) - NVL(T1.ACTUAL_AMT, 0) < 0 THEN 0" ).append("\n"); 
		query.append("              ELSE NVL(T1.ESTIMATE_AMT, 0) - NVL(T1.ACTUAL_AMT, 0)" ).append("\n"); 
		query.append("         END AS ACCL_AMT" ).append("\n"); 
		query.append("       , T1.CRE_USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(T1.CRE_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("       , 1 AS SORT" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("           SELECT   A.AGMT_OFC_CTY_CD||A.AGMT_SEQ AS AGMT_NO" ).append("\n"); 
		query.append("                  , COST_YRMON" ).append("\n"); 
		query.append("                  , ACCT_CD" ).append("\n"); 
		query.append("                  , MAX(AGMT_LSTM_CD) AGMT_LSTM_CD" ).append("\n"); 
		query.append("	              , MAX(E.CHSS_POOL_CD) CHSS_POOL_CD" ).append("\n"); 
		query.append("                  , INV_NO" ).append("\n"); 
		query.append("                  , MAX(CHG_AMT) ESTIMATE_AMT" ).append("\n"); 
		query.append("                  , MAX(INV_AMT) ACTUAL_AMT" ).append("\n"); 
		query.append("                  , MAX(CHG_CRE_DT) CRE_DT" ).append("\n"); 
		query.append("                  , MAX(A.CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append("           FROM     (" ).append("\n"); 
		query.append("                      SELECT   A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                             , A.AGMT_SEQ" ).append("\n"); 
		query.append("                             , NULL AS AGMT_VER_NO" ).append("\n"); 
		query.append("                             , A.ESTM_YRMON AS COST_YRMON" ).append("\n"); 
		query.append("                             , '510851' AS  ACCT_CD -- CGM_LSE_CHG_DTL의 ZP 데이터의 유일 계정코드" ).append("\n"); 
		query.append("                             , NULL AS INV_NO" ).append("\n"); 
		query.append("                             , A.ESTM_AMT AS CHG_AMT -- CGM_CHSS_POOL_EXPN_ESTM는 CURR_CD가 USD로 고정" ).append("\n"); 
		query.append("                             , NULL AS INV_AMT" ).append("\n"); 
		query.append("                             , A.CRE_DT AS CHG_CRE_DT" ).append("\n"); 
		query.append("                             , A.CRE_USR_ID" ).append("\n"); 
		query.append("                      FROM     CGM_CHSS_POOL_EXPN_ESTM A" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      A.ESTM_YRMON BETWEEN @[exe_yrmon] ||'01' AND @[period_eddt]" ).append("\n"); 
		query.append("                      AND      CHSS_POOL_TP_CD = 'ZP'" ).append("\n"); 
		query.append("                      UNION ALL      " ).append("\n"); 
		query.append("                      SELECT   C.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                             , C.AGMT_SEQ" ).append("\n"); 
		query.append("                             , C.AGMT_VER_NO" ).append("\n"); 
		query.append("                             , '20'||C.REV_SKD_VOY_NO COST_YRMON" ).append("\n"); 
		query.append("                             , D1.ACCT_CD" ).append("\n"); 
		query.append("                             , C.INV_NO" ).append("\n"); 
		query.append("                             , NULL      		" ).append("\n"); 
		query.append("                             , SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC('20'||C.REV_SKD_VOY_NO, C.CURR_CD, 'USD', D1.INV_AMT, 3)) INV_AMT" ).append("\n"); 
		query.append("                             , MAX(C.CRE_DT)" ).append("\n"); 
		query.append("                             , MAX(C.CRE_USR_ID)" ).append("\n"); 
		query.append("                      FROM     CGM_PAY_INV C" ).append("\n"); 
		query.append("                             , AP_PAY_INV D" ).append("\n"); 
		query.append("                             , AP_PAY_INV_DTL D1" ).append("\n"); 
		query.append("                             , AP_INV_HDR E" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      C.INV_RGST_NO = D.INV_RGST_NO" ).append("\n"); 
		query.append("                      AND      D.INV_RGST_NO = D1.INV_RGST_NO        " ).append("\n"); 
		query.append("                      AND      C.CHSS_MGST_INV_KND_CD IN ('LS', 'ZP')" ).append("\n"); 
		query.append("                      AND      C.EQ_KND_CD = 'Z'        " ).append("\n"); 
		query.append("                      AND      D.INV_STS_CD IN ( 'D','P')" ).append("\n"); 
		query.append("                      AND      D.CSR_NO = E.CSR_NO" ).append("\n"); 
		query.append("#if(${rev_yrmon} != '')" ).append("\n"); 
		query.append("                      AND      SUBSTR(E.GL_DT,1,6) BETWEEN @[exe_yrmon] ||'01' AND @[rev_yrmon]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                      AND      SUBSTR(E.GL_DT,1,6) BETWEEN @[exe_yrmon] ||'01' AND @[period_eddt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                      AND      C.REV_SKD_VOY_NO BETWEEN SUBSTR(@[exe_yrmon], 3, 2) ||'01' AND SUBSTR(@[period_eddt], 3, 4)" ).append("\n"); 
		query.append("                      AND      D1.ACCT_CD IN ('510831', '510851')" ).append("\n"); 
		query.append("                      GROUP BY C.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                             , C.AGMT_SEQ" ).append("\n"); 
		query.append("                             , C.AGMT_VER_NO" ).append("\n"); 
		query.append("                             , C.REV_SKD_VOY_NO" ).append("\n"); 
		query.append("                             , D1.ACCT_CD" ).append("\n"); 
		query.append("                             , C.INV_NO " ).append("\n"); 
		query.append("                    ) A" ).append("\n"); 
		query.append("                  , CGM_AGREEMENT E" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      A.AGMT_OFC_CTY_CD = E.AGMT_OFC_cTY_CD(+)" ).append("\n"); 
		query.append("           AND      A.AGMT_SEQ = E.AGMT_SEQ(+)" ).append("\n"); 
		query.append("           AND      E.LST_VER_FLG(+) = 'Y'   " ).append("\n"); 
		query.append("           GROUP BY A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                  , A.AGMT_SEQ" ).append("\n"); 
		query.append("                  , A.AGMT_VER_NO" ).append("\n"); 
		query.append("                  , COST_YRMON" ).append("\n"); 
		query.append("                  , ACCT_CD" ).append("\n"); 
		query.append("                  , INV_NO" ).append("\n"); 
		query.append("         ) T1" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      TO_NUMBER(SUBSTR(T1.COST_YRMON, 3, 4)) <= TO_NUMBER(SUBSTR( @[period_eddt] , 3, 4))" ).append("\n"); 
		query.append("AND      ( NVL(T1.ESTIMATE_AMT ,0) <> 0 OR NVL(T1.ACTUAL_AMT,0) <>0  )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   @[period_eddt] AS EXE_YRMON" ).append("\n"); 
		query.append("       , 'CHS' AS SYS_SRC_ID" ).append("\n"); 
		query.append("       , A.REV_YRMON AS REV_YRMON" ).append("\n"); 
		query.append("       , A.ACCT_CD AS ACCT_CD" ).append("\n"); 
		query.append("       , A.AGMT_OFC_CTY_CD||A.AGMT_SEQ AS AGMT_NO" ).append("\n"); 
		query.append("       , A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("       , A.CHSS_POOL_CD" ).append("\n"); 
		query.append("       , '' AS INVO_NO" ).append("\n"); 
		query.append("       , 1 AS ESTM_SEQ_NO" ).append("\n"); 
		query.append("       , 'CNTC' AS VSL_CD" ).append("\n"); 
		query.append("       , SUBSTR(A.REV_YRMON, 3, 4) AS SKD_VOY_NO" ).append("\n"); 
		query.append("       , 'M' AS SKD_DIR_CD" ).append("\n"); 
		query.append("       , 'M' AS REV_DIR_CD" ).append("\n"); 
		query.append("       , 'CNTC'||SUBSTR(A.REV_YRMON, 3, 4)||'MM' AS REV_VVD" ).append("\n"); 
		query.append("       , NVL(A.ESTM_AMT, 0) AS ESTM_AMT" ).append("\n"); 
		query.append("       , NVL(A.INV_AMT,0) AS ACT_AMT" ).append("\n"); 
		query.append("       , CASE WHEN NVL(A.ESTM_AMT, 0) - NVL(A.INV_AMT, 0) < 0 THEN 0" ).append("\n"); 
		query.append("              ELSE NVL(A.ESTM_AMT, 0) - NVL(A.INV_AMT, 0)" ).append("\n"); 
		query.append("         END AS ACCL_AMT" ).append("\n"); 
		query.append("       , A.CRE_USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(A.CRE_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("       , 2 AS SORT" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("           SELECT   REV_YRMON" ).append("\n"); 
		query.append("                  , AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                  , AGMT_SEQ" ).append("\n"); 
		query.append("                  , MAX(CHSS_POOL_CD) CHSS_POOL_CD" ).append("\n"); 
		query.append("                  , MAX(INV_AMT) INV_AMT" ).append("\n"); 
		query.append("                  , MAX(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("                  , MAX(ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("                  , MAX(AGMT_LSTM_CD) AGMT_LSTM_CD" ).append("\n"); 
		query.append("                  , MAX(CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append("                  , MAX(CRE_DT) CRE_DT" ).append("\n"); 
		query.append("           FROM     ( " ).append("\n"); 
		query.append("                      SELECT   '20'||B.REV_SKD_VOY_NO AS REV_YRMON" ).append("\n"); 
		query.append("                             , B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                             , B.AGMT_SEQ " ).append("\n"); 
		query.append("                             , MAX(B.CHSS_POOL_CD) CHSS_POOL_CD        		" ).append("\n"); 
		query.append("		                     , SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC('20'||B.REV_SKD_VOY_NO, B.CURR_CD, 'USD', D.INV_AMT, 3)) INV_AMT" ).append("\n"); 
		query.append("                             , NULL ESTM_AMT" ).append("\n"); 
		query.append("                             , MAX(ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("                             , MAX(B.CHSS_MGST_INV_KND_CD )  AGMT_LSTM_CD" ).append("\n"); 
		query.append("                             , MAX(B.CRE_USR_ID)	AS CRE_USR_ID" ).append("\n"); 
		query.append("                             , MAX( GLOBALDATE_PKG.TIME_CONV_OFC_FNC( 'SELHO' , B.CRE_DT, B.COST_OFC_CD) ) AS CRE_DT" ).append("\n"); 
		query.append("                      FROM     CGM_PAY_INV B , AP_PAY_INV C , AP_PAY_INV_DTL D , AP_INV_HDR E  " ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      B.INV_RGST_NO = C.INV_RGST_NO" ).append("\n"); 
		query.append("                      AND      C.INV_RGST_NO = D.INV_RGST_NO" ).append("\n"); 
		query.append("                      AND      C.INV_STS_CD IN ('D','P')" ).append("\n"); 
		query.append("                      AND      B.CHSS_MGST_INV_KND_CD IN ('CP','NP')" ).append("\n"); 
		query.append("                      AND      C.CSR_NO = E.CSR_NO" ).append("\n"); 
		query.append("#if(${rev_yrmon} != '')" ).append("\n"); 
		query.append("                      AND      SUBSTR(E.GL_DT,1,6) BETWEEN @[exe_yrmon] ||'01' AND @[rev_yrmon]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                      AND      SUBSTR(E.GL_DT,1,6) BETWEEN @[exe_yrmon] ||'01' AND @[period_eddt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                      AND      B.REV_SKD_VOY_NO BETWEEN SUBSTR(@[exe_yrmon], 3, 2) ||'01' AND SUBSTR(@[period_eddt], 3, 4)" ).append("\n"); 
		query.append("                      GROUP BY B.REV_SKD_VOY_NO" ).append("\n"); 
		query.append("                             , B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                             , B.AGMT_SEQ" ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      SELECT   A.ESTM_YRMON" ).append("\n"); 
		query.append("                             , A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                             , A.AGMT_SEQ" ).append("\n"); 
		query.append("                             , A.CHSS_POOL_CD" ).append("\n"); 
		query.append("                             , NULL INV_AMT		" ).append("\n"); 
		query.append("		                     , MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(A.ESTM_YRMON, A.CURR_CD, 'USD', A.ESTM_AMT, 3) ESTM_AMT" ).append("\n"); 
		query.append("                             , DECODE(CHSS_POOL_TP_CD ,'CP','510852','NP','510851')  ACCT_CD" ).append("\n"); 
		query.append("                             , A.CHSS_POOL_TP_CD" ).append("\n"); 
		query.append("                             , A.CRE_USR_ID" ).append("\n"); 
		query.append("                             , A.CRE_DT" ).append("\n"); 
		query.append("                      FROM     CGM_CHSS_POOL_EXPN_ESTM A" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      A.ESTM_YRMON BETWEEN @[exe_yrmon] ||'01' AND @[period_eddt]" ).append("\n"); 
		query.append("                      AND      CHSS_POOL_TP_CD IN ('CP','NP')" ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      NVL(ESTM_AMT,0) <>0  OR NVL(INV_AMT,0) <>0" ).append("\n"); 
		query.append("           GROUP BY REV_YRMON" ).append("\n"); 
		query.append("                  , AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                  , AGMT_SEQ" ).append("\n"); 
		query.append("         ) A" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      TO_NUMBER(SUBSTR(  SUBSTR(A.REV_YRMON,1,6) , 3, 4)) <= TO_NUMBER(SUBSTR(  @[period_eddt] , 3, 4))" ).append("\n"); 
		query.append("ORDER BY REV_YRMON DESC" ).append("\n"); 
		query.append("       , SORT" ).append("\n"); 
		query.append("       , AGMT_LSTM_CD" ).append("\n"); 
		query.append("       , AGMT_NO" ).append("\n"); 

	}
}