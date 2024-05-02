/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CanalTransitFeeInvoiceBCDBDAOsearchCanalTzFeeSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanalTransitFeeInvoiceBCDBDAOsearchCanalTzFeeSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전도금과 actual 의 diff
	  * </pre>
	  */
	public CanalTransitFeeInvoiceBCDBDAOsearchCanalTzFeeSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.integration").append("\n"); 
		query.append("FileName : CanalTransitFeeInvoiceBCDBDAOsearchCanalTzFeeSummaryRSQL").append("\n"); 
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
		query.append("WITH ADV_PAY AS (" ).append("\n"); 
		query.append(" SELECT CNL_TZ_BZTP_CD , " ).append("\n"); 
		query.append("        MIN(LGS_COST_CD1) AS LGS_COST_CD1," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD2) AS LGS_COST_CD2," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD3) AS LGS_COST_CD3," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD4) AS LGS_COST_CD4," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD5) AS LGS_COST_CD5," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD6) AS LGS_COST_CD6," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD7) AS LGS_COST_CD7," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD8) AS LGS_COST_CD8," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD9) AS LGS_COST_CD9," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD10) AS LGS_COST_CD10," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD11) AS LGS_COST_CD11," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD12) AS LGS_COST_CD12," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD13) AS LGS_COST_CD13" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append(" SELECT A.CNL_TZ_BZTP_CD, " ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNAC',RQST_AMT) AS LGS_COST_CD1," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNBK',RQST_AMT) AS LGS_COST_CD2," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNHD',RQST_AMT) AS LGS_COST_CD3," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNLD',RQST_AMT) AS LGS_COST_CD4," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNLH',RQST_AMT) AS LGS_COST_CD5," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNLR',RQST_AMT) AS LGS_COST_CD6," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNOT',RQST_AMT) AS LGS_COST_CD7," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNPT',RQST_AMT) AS LGS_COST_CD8," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNQR',RQST_AMT) AS LGS_COST_CD9," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNSS',RQST_AMT) AS LGS_COST_CD10," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNTF',RQST_AMT) AS LGS_COST_CD11," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNTW',RQST_AMT) AS LGS_COST_CD12," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNTX',RQST_AMT) AS LGS_COST_CD13 " ).append("\n"); 
		query.append("  FROM ( " ).append("\n"); 
		query.append("  SELECT X.CNL_TZ_BZTP_CD, SUBSTR(Y.LGS_COST_CD,1,4) LGS_COST_GRP, SUM(Y.RQST_AMT) AS RQST_AMT" ).append("\n"); 
		query.append("    FROM PSO_CNL_TZ_FEE X, PSO_CNL_TZ_FEE_DTL Y" ).append("\n"); 
		query.append("   WHERE X.PSO_BZTP_CD        = Y.PSO_BZTP_CD" ).append("\n"); 
		query.append("     AND X.VSL_CD             = Y.VSL_CD" ).append("\n"); 
		query.append("     AND X.SKD_VOY_NO         = Y.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND X.SKD_DIR_CD         = Y.SKD_DIR_CD" ).append("\n"); 
		query.append("     AND X.PSO_BZTP_CD        = '5'" ).append("\n"); 
		query.append("     AND X.YD_CD              = Y.YD_CD" ).append("\n"); 
		query.append("     AND X.CALL_SEQ           = Y.CALL_SEQ" ).append("\n"); 
		query.append("     AND X.CNL_TZ_PROC_STS_CD = 'A'" ).append("\n"); 
		query.append("     AND X.VSL_CD             = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("     AND X.SKD_VOY_NO         = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("     AND X.SKD_DIR_CD         = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("     AND X.YD_CD              = @[yd_cd]" ).append("\n"); 
		query.append("     AND X.CNL_TZ_BZTP_CD     ='E'" ).append("\n"); 
		query.append("     AND EXISTS  ( SELECT '*'" ).append("\n"); 
		query.append("                    FROM PSO_CNL_TZ_FEE_DTL A, PSO_CNL_TZ_FEE B" ).append("\n"); 
		query.append("                   WHERE A.VSL_CD             = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                     AND A.SKD_VOY_NO         = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                     AND A.SKD_DIR_CD         = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                     AND A.YD_CD              = @[yd_cd]" ).append("\n"); 
		query.append("                     AND A.VSL_CD             = B.VSL_CD" ).append("\n"); 
		query.append("                     AND A.SKD_VOY_NO         = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                     AND B.CNL_TZ_BZTP_CD     = 'I'" ).append("\n"); 
		query.append("                     AND A.SKD_DIR_CD         = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                     AND A.YD_CD              = B.YD_CD" ).append("\n"); 
		query.append("                     AND A.PSO_BZTP_CD        = B.PSO_BZTP_CD" ).append("\n"); 
		query.append("                     AND A.CALL_SEQ          = B.CALL_SEQ" ).append("\n"); 
		query.append("                     AND B.PSO_BZTP_CD       = '5'" ).append("\n"); 
		query.append("                     AND B.NTC_YRMON         = @[rev_yrmon]" ).append("\n"); 
		query.append("                     AND A.LGS_COST_CD        LIKE  Y.LGS_COST_CD||'%' )" ).append("\n"); 
		query.append("     GROUP BY X.CNL_TZ_BZTP_CD, SUBSTR(Y.LGS_COST_CD,1,4) ) A ) " ).append("\n"); 
		query.append("     GROUP BY CNL_TZ_BZTP_CD )," ).append("\n"); 
		query.append("  INV_PAY AS ( SELECT CNL_TZ_BZTP_CD , " ).append("\n"); 
		query.append("        MIN(LGS_COST_CD1) AS LGS_COST_CD1," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD2) AS LGS_COST_CD2," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD3) AS LGS_COST_CD3," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD4) AS LGS_COST_CD4," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD5) AS LGS_COST_CD5," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD6) AS LGS_COST_CD6," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD7) AS LGS_COST_CD7," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD8) AS LGS_COST_CD8," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD9) AS LGS_COST_CD9," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD10) AS LGS_COST_CD10," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD11) AS LGS_COST_CD11," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD12) AS LGS_COST_CD12," ).append("\n"); 
		query.append("        MIN(LGS_COST_CD13) AS LGS_COST_CD13" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append(" SELECT A.CNL_TZ_BZTP_CD, " ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNAC',RQST_AMT) AS LGS_COST_CD1," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNBK',RQST_AMT) AS LGS_COST_CD2," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNHD',RQST_AMT) AS LGS_COST_CD3," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNLD',RQST_AMT) AS LGS_COST_CD4," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNLH',RQST_AMT) AS LGS_COST_CD5," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNLR',RQST_AMT) AS LGS_COST_CD6," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNOT',RQST_AMT) AS LGS_COST_CD7," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNPT',RQST_AMT) AS LGS_COST_CD8," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNQR',RQST_AMT) AS LGS_COST_CD9," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNSS',RQST_AMT) AS LGS_COST_CD10," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNTF',RQST_AMT) AS LGS_COST_CD11," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNTW',RQST_AMT) AS LGS_COST_CD12," ).append("\n"); 
		query.append("        DECODE(LGS_COST_GRP,'CNTX',RQST_AMT) AS LGS_COST_CD13 " ).append("\n"); 
		query.append("  FROM ( " ).append("\n"); 
		query.append("  SELECT X.CNL_TZ_BZTP_CD, SUBSTR(Y.LGS_COST_CD,1,4) LGS_COST_GRP, SUM(Y.RQST_AMT) AS RQST_AMT" ).append("\n"); 
		query.append("    FROM PSO_CNL_TZ_FEE X, PSO_CNL_TZ_FEE_DTL Y" ).append("\n"); 
		query.append("   WHERE X.PSO_BZTP_CD        = Y.PSO_BZTP_CD" ).append("\n"); 
		query.append("     AND X.VSL_CD             = Y.VSL_CD" ).append("\n"); 
		query.append("     AND X.SKD_VOY_NO         = Y.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND X.SKD_DIR_CD         = Y.SKD_DIR_CD" ).append("\n"); 
		query.append("     AND X.PSO_BZTP_CD        = '5'" ).append("\n"); 
		query.append("     AND X.YD_CD              = Y.YD_CD" ).append("\n"); 
		query.append("     AND X.CNL_TZ_PROC_STS_CD IN ( 'A','Q')" ).append("\n"); 
		query.append("     AND X.CALL_SEQ           = Y.CALL_SEQ" ).append("\n"); 
		query.append("     AND X.VSL_CD             = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("     AND X.SKD_VOY_NO         = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("     AND X.SKD_DIR_CD         = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("     AND X.YD_CD              = @[yd_cd]" ).append("\n"); 
		query.append("     AND X.CNL_TZ_BZTP_CD     = 'I'" ).append("\n"); 
		query.append("     AND SUBSTR(Y.LGS_COST_CD,1,4) IN ( SELECT SUBSTR(B.LGS_COST_CD,1,4)" ).append("\n"); 
		query.append("                                          FROM PSO_CNL_TZ_FEE A, PSO_CNL_TZ_FEE_DTL B" ).append("\n"); 
		query.append("                                         WHERE A.NTC_YRMON          = @[rev_yrmon]" ).append("\n"); 
		query.append("                                           AND A.PSO_BZTP_CD        = B.PSO_BZTP_CD" ).append("\n"); 
		query.append("                                           AND A.VSL_CD             = B.VSL_CD" ).append("\n"); 
		query.append("                                           AND A.SKD_VOY_NO         = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                                           AND A.SKD_DIR_CD         = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                                           AND A.PSO_BZTP_CD        = '5'" ).append("\n"); 
		query.append("                                           AND A.YD_CD              = B.YD_CD" ).append("\n"); 
		query.append("                                           AND A.CNL_TZ_PROC_STS_CD IN ( 'A','Q')" ).append("\n"); 
		query.append("                                           AND A.CALL_SEQ           = B.CALL_SEQ" ).append("\n"); 
		query.append("                                           AND A.VSL_CD             = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                           AND A.SKD_VOY_NO         = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                           AND A.SKD_DIR_CD         = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                                           AND A.YD_CD              = @[yd_cd]" ).append("\n"); 
		query.append("                                           AND A.CNL_TZ_BZTP_CD     = 'I'  )" ).append("\n"); 
		query.append("     GROUP BY X.CNL_TZ_BZTP_CD, SUBSTR(Y.LGS_COST_CD,1,4) ) A ) " ).append("\n"); 
		query.append("     GROUP BY CNL_TZ_BZTP_CD )" ).append("\n"); 
		query.append("    SELECT  'Advance Payment' AS TITLE, " ).append("\n"); 
		query.append("            LGS_COST_CD1, LGS_COST_CD2, LGS_COST_CD3,  LGS_COST_CD4,  LGS_COST_CD5,  LGS_COST_CD6," ).append("\n"); 
		query.append("            LGS_COST_CD7, LGS_COST_CD8, LGS_COST_CD9,  LGS_COST_CD10, LGS_COST_CD11, LGS_COST_CD12, LGS_COST_CD13 " ).append("\n"); 
		query.append("      FROM ADV_PAY" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT  'Invoice Amount' AS TITLE, " ).append("\n"); 
		query.append("            LGS_COST_CD1, LGS_COST_CD2, LGS_COST_CD3,  LGS_COST_CD4,  LGS_COST_CD5,  LGS_COST_CD6," ).append("\n"); 
		query.append("            LGS_COST_CD7, LGS_COST_CD8, LGS_COST_CD9,  LGS_COST_CD10, LGS_COST_CD11, LGS_COST_CD12, LGS_COST_CD13 " ).append("\n"); 
		query.append("     FROM INV_PAY" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'Diff'  AS TITLE, " ).append("\n"); 
		query.append("           CASE WHEN A.LGS_COST_CD1 IS NULL AND B.LGS_COST_CD1 IS NULL THEN NULL" ).append("\n"); 
		query.append("                ELSE  NVL(A.LGS_COST_CD1,0) -  NVL(B.LGS_COST_CD1  ,0) " ).append("\n"); 
		query.append("           END AS LGS_COST_CD1," ).append("\n"); 
		query.append("           CASE WHEN A.LGS_COST_CD2 IS NULL AND B.LGS_COST_CD2 IS NULL THEN NULL" ).append("\n"); 
		query.append("                ELSE  NVL(A.LGS_COST_CD2,0) -  NVL(B.LGS_COST_CD2  ,0) " ).append("\n"); 
		query.append("           END AS LGS_COST_CD2," ).append("\n"); 
		query.append("           CASE WHEN A.LGS_COST_CD3 IS NULL AND B.LGS_COST_CD3 IS NULL THEN NULL" ).append("\n"); 
		query.append("                ELSE  NVL(A.LGS_COST_CD3,0) -  NVL(B.LGS_COST_CD3  ,0) " ).append("\n"); 
		query.append("           END AS LGS_COST_CD3," ).append("\n"); 
		query.append("           CASE WHEN A.LGS_COST_CD4 IS NULL AND B.LGS_COST_CD4 IS NULL THEN NULL" ).append("\n"); 
		query.append("                ELSE  NVL(A.LGS_COST_CD4,0) -  NVL(B.LGS_COST_CD4  ,0) " ).append("\n"); 
		query.append("           END AS LGS_COST_CD4," ).append("\n"); 
		query.append("           CASE WHEN A.LGS_COST_CD5 IS NULL AND B.LGS_COST_CD5 IS NULL THEN NULL" ).append("\n"); 
		query.append("                ELSE  NVL(A.LGS_COST_CD5,0) -  NVL(B.LGS_COST_CD5  ,0) " ).append("\n"); 
		query.append("           END AS LGS_COST_CD5," ).append("\n"); 
		query.append("           CASE WHEN A.LGS_COST_CD6 IS NULL AND B.LGS_COST_CD6 IS NULL THEN NULL" ).append("\n"); 
		query.append("                ELSE  NVL(A.LGS_COST_CD6,0) -  NVL(B.LGS_COST_CD6  ,0) " ).append("\n"); 
		query.append("           END AS LGS_COST_CD1," ).append("\n"); 
		query.append("           CASE WHEN A.LGS_COST_CD7 IS NULL AND B.LGS_COST_CD7 IS NULL THEN NULL" ).append("\n"); 
		query.append("                ELSE  NVL(A.LGS_COST_CD7,0) -  NVL(B.LGS_COST_CD7  ,0) " ).append("\n"); 
		query.append("           END AS LGS_COST_CD7," ).append("\n"); 
		query.append("           CASE WHEN A.LGS_COST_CD8 IS NULL AND B.LGS_COST_CD8 IS NULL THEN NULL" ).append("\n"); 
		query.append("                ELSE  NVL(A.LGS_COST_CD8,0) -  NVL(B.LGS_COST_CD8  ,0) " ).append("\n"); 
		query.append("           END AS LGS_COST_CD8," ).append("\n"); 
		query.append("           CASE WHEN A.LGS_COST_CD9 IS NULL AND B.LGS_COST_CD9 IS NULL THEN NULL" ).append("\n"); 
		query.append("                ELSE  NVL(A.LGS_COST_CD9,0) -  NVL(B.LGS_COST_CD9  ,0) " ).append("\n"); 
		query.append("           END AS LGS_COST_CD9," ).append("\n"); 
		query.append("           CASE WHEN A.LGS_COST_CD10 IS NULL AND B.LGS_COST_CD10 IS NULL THEN NULL" ).append("\n"); 
		query.append("                ELSE  NVL(A.LGS_COST_CD10,0) -  NVL(B.LGS_COST_CD10  ,0) " ).append("\n"); 
		query.append("           END AS LGS_COST_CD10," ).append("\n"); 
		query.append("           CASE WHEN A.LGS_COST_CD11 IS NULL AND B.LGS_COST_CD11 IS NULL THEN NULL" ).append("\n"); 
		query.append("                ELSE  NVL(A.LGS_COST_CD11,0) -  NVL(B.LGS_COST_CD11  ,0) " ).append("\n"); 
		query.append("           END AS LGS_COST_CD11," ).append("\n"); 
		query.append("           CASE WHEN A.LGS_COST_CD12 IS NULL AND B.LGS_COST_CD12 IS NULL THEN NULL" ).append("\n"); 
		query.append("                ELSE  NVL(A.LGS_COST_CD12,0) -  NVL(B.LGS_COST_CD12  ,0) " ).append("\n"); 
		query.append("           END AS LGS_COST_CD12," ).append("\n"); 
		query.append("           CASE WHEN A.LGS_COST_CD13 IS NULL AND B.LGS_COST_CD13 IS NULL THEN NULL" ).append("\n"); 
		query.append("                ELSE  NVL(A.LGS_COST_CD13,0) -  NVL(B.LGS_COST_CD13  ,0) " ).append("\n"); 
		query.append("           END AS LGS_COST_CD13" ).append("\n"); 
		query.append("     FROM ADV_PAY A, INV_PAY B" ).append("\n"); 

	}
}