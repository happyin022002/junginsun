/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOsearchMGSEstimateExpenseCalcDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.08
*@LastModifier : 이용태
*@LastVersion : 1.0
* 2010.06.08 이용태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE YONG-TAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOsearchMGSEstimateExpenseCalcDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20091012 2206 start
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOsearchMGSEstimateExpenseCalcDataRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOsearchMGSEstimateExpenseCalcDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    @[period_eddt]                  AS EXE_YRMON" ).append("\n"); 
		query.append("    ,'MGS'                          AS SYS_SRC_ID" ).append("\n"); 
		query.append("    ,T1.COST_YRMON                  AS REV_YRMON" ).append("\n"); 
		query.append("    ,T1.ACCT_CD                     AS ACCT_CD" ).append("\n"); 
		query.append("	,T1.AGMT_NO                     AS AGMT_NO" ).append("\n"); 
		query.append("	,T1.AGMT_LSTM_CD                AS AGMT_LSTM_CD" ).append("\n"); 
		query.append(",''                AS CHSS_POOL_CD" ).append("\n"); 
		query.append("	,T1.INV_NO                      AS INVO_NO" ).append("\n"); 
		query.append("    ,1                              AS ESTM_SEQ_NO            " ).append("\n"); 
		query.append("    , 'CNTC'                        AS VSL_CD" ).append("\n"); 
		query.append("    , SUBSTR(T1.COST_YRMON, 3, 4)  	AS SKD_VOY_NO" ).append("\n"); 
		query.append("    ,'M'                            AS SKD_DIR_CD" ).append("\n"); 
		query.append("    ,'M'                            AS REV_DIR_CD" ).append("\n"); 
		query.append(",'CNTC'||SUBSTR(T1.COST_YRMON, 3, 4)||'MM'    AS REV_VVD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("WHEN (T1.COST_YRMON = @[period_eddt] ) THEN " ).append("\n"); 
		query.append("    CASE WHEN T1.ESTIMATE_AMT - ABS( T1.ACTUAL_AMT ) <0 THEN NVL(T1.ACTUAL_AMT, 0)" ).append("\n"); 
		query.append("    ELSE NVL(T1.ESTIMATE_AMT, 0)" ).append("\n"); 
		query.append("    END" ).append("\n"); 
		query.append("ELSE NVL(T1.ACTUAL_AMT, 0)" ).append("\n"); 
		query.append("END AS ESTM_AMT " ).append("\n"); 
		query.append(",NVL(T1.ACTUAL_AMT,0)  AS ACT_AMT   -- 해당월에도 Actual 금액 있으면 표시" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("        WHEN (T1.COST_YRMON = @[period_eddt] ) THEN " ).append("\n"); 
		query.append("            CASE WHEN T1.ESTIMATE_AMT - ABS( T1.ACTUAL_AMT) <0 THEN NVL(T1.ACTUAL_AMT, 0)" ).append("\n"); 
		query.append("            ELSE NVL(T1.ESTIMATE_AMT, 0)" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("        ELSE NVL(T1.ACTUAL_AMT, 0)" ).append("\n"); 
		query.append("    END - NVL(T1.ACTUAL_AMT,0)" ).append("\n"); 
		query.append("AS ACCL_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", T1.CRE_USR_ID					AS CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(T1.CRE_DT,'YYYY-MM-DD')	AS CRE_DT" ).append("\n"); 
		query.append(",1 SORT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("    A.AGMT_OFC_CTY_CD||A.AGMT_SEQ AGMT_NO" ).append("\n"); 
		query.append("    ,COST_YRMON" ).append("\n"); 
		query.append("    ,ACCT_CD" ).append("\n"); 
		query.append("    ,MAX(AGMT_LSTM_CD) AGMT_LSTM_CD" ).append("\n"); 
		query.append("    ,INV_NO" ).append("\n"); 
		query.append("    ,MAX(CHG_AMT) ESTIMATE_AMT" ).append("\n"); 
		query.append("    ,MAX(INV_AMT) ACTUAL_AMT" ).append("\n"); 
		query.append("    ,MAX(CHG_CRE_DT) CRE_dT" ).append("\n"); 
		query.append("    ,MAX(A.CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("          SELECT  " ).append("\n"); 
		query.append("          B.AGMT_OFC_CTY_CD, " ).append("\n"); 
		query.append("          B.AGMT_SEQ, " ).append("\n"); 
		query.append("          B.AGMT_VER_NO, " ).append("\n"); 
		query.append("          B.COST_YRMON, " ).append("\n"); 
		query.append("--          DECODE(B.ACCT_CD, '510871', '510831', B.ACCT_CD) ACCT_CD ," ).append("\n"); 
		query.append("		  ACCT_CD," ).append("\n"); 
		query.append("          B.INV_NO,   " ).append("\n"); 
		query.append("          SUM(B.LSE_CHG_AMT) CHG_AMT," ).append("\n"); 
		query.append("          NULL INV_AMT," ).append("\n"); 
		query.append("          MAX(A.CRE_DT) CHG_CRE_DT," ).append("\n"); 
		query.append("          MAX(A.CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          FROM  CGM_LSE_CHG_HDR A, CGM_LSE_CHG_DTL B " ).append("\n"); 
		query.append("          WHERE " ).append("\n"); 
		query.append("          A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("          AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("          AND A.AGMT_VER_NO = B.AGMT_VER_NO" ).append("\n"); 
		query.append("          AND A.COST_YRMON = B.COST_YRMON" ).append("\n"); 
		query.append("          AND B.COST_YRMON <= @[period_eddt]" ).append("\n"); 
		query.append("          AND A.EQ_KND_CD = 'G'" ).append("\n"); 
		query.append("		  AND B.ACCT_CD = 510831" ).append("\n"); 
		query.append("         GROUP BY " ).append("\n"); 
		query.append("          B.AGMT_OFC_CTY_CD, " ).append("\n"); 
		query.append("          B.AGMT_SEQ, " ).append("\n"); 
		query.append("          B.AGMT_VER_NO, " ).append("\n"); 
		query.append("          B.COST_YRMON, " ).append("\n"); 
		query.append("--          DECODE(B.ACCT_CD, '510871', '510831', B.ACCT_CD) ," ).append("\n"); 
		query.append("		  ACCT_CD," ).append("\n"); 
		query.append("          B.INV_NO" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("    UNION ALL      " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("        C.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("        C.AGMT_SEQ," ).append("\n"); 
		query.append("        C.AGMT_VER_NO," ).append("\n"); 
		query.append("        C.COST_YRMON, " ).append("\n"); 
		query.append("--        DECODE(D1.ACCT_CD, '510871', '510831', D1.ACCT_CD) ACCT_CD, " ).append("\n"); 
		query.append("		D1.ACCT_CD," ).append("\n"); 
		query.append("        C.INV_NO, " ).append("\n"); 
		query.append("        NULL ," ).append("\n"); 
		query.append("        SUM(D1.INV_AMT) INV_AMT," ).append("\n"); 
		query.append("        MAX(C.CRE_DT)," ).append("\n"); 
		query.append("        MAX(C.CRE_USR_ID)" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        FROM CGM_PAY_INV C, AP_PAY_INV D, AP_PAY_INV_DTL D1, AP_INV_HDR E" ).append("\n"); 
		query.append("        WHERE   " ).append("\n"); 
		query.append("        C.INV_RGST_NO = D.INV_RGST_NO" ).append("\n"); 
		query.append("        AND D.INV_RGST_NO = D1.INV_RGST_NO        " ).append("\n"); 
		query.append("        AND C.CHSS_MGST_INV_KND_CD IN ('LS')" ).append("\n"); 
		query.append("        AND C.EQ_KND_CD = 'G'        " ).append("\n"); 
		query.append("        AND D.INV_STS_CD IN ( 'D','P')" ).append("\n"); 
		query.append("        AND D.CSR_NO = E.CSR_NO" ).append("\n"); 
		query.append("        AND  SUBSTR( E.GL_DT,1,6) <= @[period_eddt]" ).append("\n"); 
		query.append("		AND D1.ACCT_CD = 510831" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        GROUP BY C.AGMT_OFC_CTY_CD,C.AGMT_SEQ,C.AGMT_VER_NO,C.COST_YRMON, " ).append("\n"); 
		query.append("--		DECODE(D1.ACCT_CD, '510871', '510831', D1.ACCT_CD) , " ).append("\n"); 
		query.append("		D1.ACCT_CD, C.INV_NO " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    )  A, CGM_AGREEMENT E" ).append("\n"); 
		query.append("    WHERE A.AGMT_OFC_CTY_CD = E.AGMT_OFC_cTY_CD(+)" ).append("\n"); 
		query.append("     AND A.AGMT_SEQ = E.AGMT_SEQ(+)" ).append("\n"); 
		query.append("     AND E.LST_VER_FLG(+) = 'Y'   " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    GROUP BY " ).append("\n"); 
		query.append("    A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("    ,A.AGMT_SEQ" ).append("\n"); 
		query.append("    ,A.AGMT_VER_NO" ).append("\n"); 
		query.append("    ,COST_YRMON" ).append("\n"); 
		query.append("    ,ACCT_CD" ).append("\n"); 
		query.append("    ,INV_NO" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") T1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE TO_NUMBER(SUBSTR(T1.COST_YRMON, 5, 2)) <= TO_NUMBER(SUBSTR( @[period_eddt] , 5, 2))" ).append("\n"); 
		query.append("AND ( NVL(T1.ESTIMATE_AMT ,0) <> 0 OR NVL(T1.ACTUAL_AMT,0) <>0  )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY REV_YRMON DESC , SORT , AGMT_LSTM_CD, AGMT_NO" ).append("\n"); 

	}
}