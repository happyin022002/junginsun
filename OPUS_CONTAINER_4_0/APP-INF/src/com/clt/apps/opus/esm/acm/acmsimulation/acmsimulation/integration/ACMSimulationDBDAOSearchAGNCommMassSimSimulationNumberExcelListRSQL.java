/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ACMSimulationDBDAOSearchAGNCommMassSimSimulationNumberExcelListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOSearchAGNCommMassSimSimulationNumberExcelListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAGNCommMassSimSimulationNumberExcelList
	  * </pre>
	  */
	public ACMSimulationDBDAOSearchAGNCommMassSimSimulationNumberExcelListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOSearchAGNCommMassSimSimulationNumberExcelListRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO," ).append("\n"); 
		query.append("       C.BL_NO," ).append("\n"); 
		query.append("       A.IO_BND_CD," ).append("\n"); 
		query.append("       MAX(A.AC_TP_CD) AS AC_TP_CD, --Type" ).append("\n"); 
		query.append("       MAX(A.COMM_STND_COST_CD) AS COMM_STND_COST_CD, -- Account" ).append("\n"); 
		query.append("       R.VSL_CD||R.SKD_VOY_NO||R.DIR_CD AS REV_VVD_CD," ).append("\n"); 
		query.append("       (SELECT M.COST_YRMON AS REV_MON" ).append("\n"); 
		query.append("        FROM COA_MON_VVD M , COA_RGST_BKG R" ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("        AND R.BKG_NO     = A.BKG_NO" ).append("\n"); 
		query.append("        AND M.TRD_CD     = R.TRD_CD" ).append("\n"); 
		query.append("        AND M.RLANE_CD   = R.RLANE_CD          " ).append("\n"); 
		query.append("        AND M.IOC_CD     = R.IOC_CD            " ).append("\n"); 
		query.append("        AND M.VSL_CD     = R.VSL_CD            " ).append("\n"); 
		query.append("        AND M.SKD_VOY_NO = R.SKD_VOY_NO        " ).append("\n"); 
		query.append("        AND M.DIR_CD     = R.DIR_CD) AS REV_MON, -- R.Mon" ).append("\n"); 
		query.append("       MAX(DECODE(A.AC_VSL_CD, 'CNTC', '', A.AC_VSL_CD||A.AC_SKD_VOY_NO||A.AC_SKD_DIR_CD||A.AC_REV_DIR_CD)) AS COMM_VVD," ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(A.SAIL_ARR_DT, 'YYYYMMDD'), 'YYYY-MM-DD') AS SAIL_ARR_DT," ).append("\n"); 
		query.append("        (ACM_JOIN_FNC(CURSOR(SELECT CNTR_TPSZ_CD || 'x' || OP_CNTR_QTY" ).append("\n"); 
		query.append("                        	   FROM (" ).append("\n"); 
		query.append("                                    SELECT BKG_NO" ).append("\n"); 
		query.append("                                         , CASE WHEN OP_CNTR_QTY = EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                THEN SUBSTR(CNTR_TPSZ_CD, 1,1)||EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                WHEN OP_CNTR_QTY > EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                THEN DECODE(SUBSTR(CNTR_TPSZ_CD,1,1), 'R', DECODE(SUBSTR(EQ_SUBST_CNTR_TPSZ_CD,1,1),'D', SUBSTR(CNTR_TPSZ_CD,1,1)||EQ_SUBST_CNTR_TPSZ_CD, EQ_SUBST_CNTR_TPSZ_CD), EQ_SUBST_CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                                           END AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                         , CASE WHEN OP_CNTR_QTY = EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                THEN EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                WHEN OP_CNTR_QTY > EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                THEN DECODE(EQ_SUBST_CNTR_TPSZ_CD, NULL, OP_CNTR_QTY, EQ_SUBST_CGO_QTY)" ).append("\n"); 
		query.append("                                           END AS OP_CNTR_QTY  " ).append("\n"); 
		query.append("                                      FROM BKG_QUANTITY BQ" ).append("\n"); 
		query.append("                                     WHERE 1=1" ).append("\n"); 
		query.append("                                       AND BQ.EQ_SUBST_CGO_QTY > 0" ).append("\n"); 
		query.append("                                     UNION " ).append("\n"); 
		query.append("                                    SELECT BKG_NO" ).append("\n"); 
		query.append("                                         , CASE WHEN OP_CNTR_QTY > EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                THEN CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                WHEN OP_CNTR_QTY = EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                THEN SUBSTR(CNTR_TPSZ_CD, 1,1)||EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                           END AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                          ,CASE WHEN OP_CNTR_QTY > EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                THEN OP_CNTR_QTY-EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                WHEN OP_CNTR_QTY = EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                THEN EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                           END AS OP_CNTR_QTY" ).append("\n"); 
		query.append("                                      FROM BKG_QUANTITY BQ" ).append("\n"); 
		query.append("                                     WHERE 1=1" ).append("\n"); 
		query.append("                                       AND BQ.EQ_SUBST_CGO_QTY > 0" ).append("\n"); 
		query.append("                                       UNION" ).append("\n"); 
		query.append("                                    SELECT BKG_NO, CNTR_TPSZ_CD, OP_CNTR_QTY" ).append("\n"); 
		query.append("                                      FROM BKG_QUANTITY BQ" ).append("\n"); 
		query.append("                                     WHERE 1=1" ).append("\n"); 
		query.append("                                       AND BQ.EQ_SUBST_CGO_QTY = 0" ).append("\n"); 
		query.append("                                    ) Q " ).append("\n"); 
		query.append("                                WHERE Q.BKG_NO = A.BKG_NO  " ).append("\n"); 
		query.append("                                    " ).append("\n"); 
		query.append("        ))) CNTR_QTY, -- RD TYPE 구분" ).append("\n"); 
		query.append("       SUM(A.CRNT_REV_AMT) AS CRNT_REV_AMT," ).append("\n"); 
		query.append("       SUM(A.DDCT_CHG_AMT) AS DDCT_CHG_AMT," ).append("\n"); 
		query.append("       SUM(A.DDCT_TRSP_AMT) AS DDCT_TRSP_AMT," ).append("\n"); 
		query.append("       SUM(A.CRNT_REV_AMT - A.DDCT_CHG_AMT - A.DDCT_TRSP_AMT) AS POST_REV_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(SIGN(INSTR('GKHSCNR', A.AC_TP_CD)), 1, A.PPD_AMT, 0)) AS PPD_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(SIGN(INSTR('GKHSCNR', A.AC_TP_CD)), 1, A.IF_AMT, 0)) AS USD_AMT," ).append("\n"); 
		query.append("       A.AR_OFC_CD AS RESPB_OFC_CD," ).append("\n"); 
		query.append("       A.AR_OFC_CD," ).append("\n"); 
		query.append("       MAX(A.AP_OFC_CD) AS AP_OFC_CD," ).append("\n"); 
		query.append("       (SELECT RHQ_CD" ).append("\n"); 
		query.append("       FROM ACM_OFC_INFO" ).append("\n"); 
		query.append("       WHERE AGN_CD = A.AGN_CD AND ROWNUM = 1) AS HQ_OFC_CD," ).append("\n"); 
		query.append("       MAX(A.OFC_CHR_CD) AS OFC_CHR_CD," ).append("\n"); 
		query.append("       MAX(A.SIM_NO) AS SIM_NO" ).append("\n"); 
		query.append("  FROM ACM_SIM_COMM A," ).append("\n"); 
		query.append("       COA_RGST_BKG R," ).append("\n"); 
		query.append("       BKG_BOOKING C" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND A.SIM_NO = @[sim_no]" ).append("\n"); 
		query.append("   AND A.CRE_USR_ID <> 'COST'" ).append("\n"); 
		query.append("   AND C.BKG_NO = A.BKG_NO(+)" ).append("\n"); 
		query.append("   AND C.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append(" GROUP BY C.BL_NO," ).append("\n"); 
		query.append("          A.BKG_NO," ).append("\n"); 
		query.append("          A.IO_BND_CD," ).append("\n"); 
		query.append("          R.VSL_CD||R.SKD_VOY_NO||R.DIR_CD," ).append("\n"); 
		query.append("          A.AC_RLANE_CD," ).append("\n"); 
		query.append("          A.SAIL_ARR_DT," ).append("\n"); 
		query.append("          A.LOC_CD," ).append("\n"); 
		query.append("          A.AC_SEQ," ).append("\n"); 
		query.append("          C.BKG_STS_CD," ).append("\n"); 
		query.append("          A.REV_DIV_CD," ).append("\n"); 
		query.append("          A.CURR_CD," ).append("\n"); 
		query.append("          A.AC_STS_CD," ).append("\n"); 
		query.append("          A.CRE_DT," ).append("\n"); 
		query.append("          A.BDR_FLG," ).append("\n"); 
		query.append("          A.AC_PROC_DESC," ).append("\n"); 
		query.append("          A.AR_OFC_CD," ).append("\n"); 
		query.append("          A.AGN_CD" ).append("\n"); 
		query.append(" ORDER BY BKG_NO, BL_NO, IO_BND_CD" ).append("\n"); 

	}
}