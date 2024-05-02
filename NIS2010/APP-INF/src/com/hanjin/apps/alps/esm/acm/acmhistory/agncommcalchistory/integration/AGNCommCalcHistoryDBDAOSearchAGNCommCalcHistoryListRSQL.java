/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommCalcHistoryDBDAOSearchAGNCommCalcHistoryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.19
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.10.19 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmhistory.agncommcalchistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommCalcHistoryDBDAOSearchAGNCommCalcHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AGNCommCalcHistoryDBDAOSearchAGNCommCalcHistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmhistory.agncommcalchistory.integration").append("\n"); 
		query.append("FileName : AGNCommCalcHistoryDBDAOSearchAGNCommCalcHistoryListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(SUBSTR(B.CALC_NO,1,6),'YYMMDD'),'YYYY-MM-DD') AS EVT_DT," ).append("\n"); 
		query.append("       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', TO_DATE(SUBSTR(B.CALC_NO,1,6),'YYMMDD'), 'GMT'), 'YYYY-MM-DD')  AS EVT_GMT_DT," ).append("\n"); 
		query.append("       DECODE(A.AC_STS_CD, 'CS', 'Calculation', 'RS', 'Request', 'AS', 'Audited', 'PS', 'Approved', 'IS', 'Interface', 'Rejected') AS EVT_TP," ).append("\n"); 
		query.append("       A.AGN_CD," ).append("\n"); 
		query.append("       A.AGN_AGMT_NO," ).append("\n"); 
		query.append("       MAX(DECODE(A.AC_VSL_CD, 'CNTC', '', A.AC_VSL_CD||A.AC_SKD_VOY_NO||A.AC_SKD_DIR_CD||A.AC_REV_DIR_CD)) AS COMM_VVD," ).append("\n"); 
		query.append("       A.IO_BND_CD," ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(A.SAIL_ARR_DT, 'YYYYMMDD'), 'YYYY-MM-DD') AS SAIL_ARR_DT," ).append("\n"); 
		query.append("       DECODE(A.AC_TP_CD, 'G', 'General', 'K', 'BRKG', 'H', 'CHF', 'S', 'T/S', 'C', 'Cross', A.AC_TP_CD) AS AC_TP_CD," ).append("\n"); 
		query.append("       DECODE( A.CALC_NO , B.CALC_NO , B.RNK , '' ) AS CALC_SEQ," ).append("\n"); 
		query.append("       A.AC_STS_CD," ).append("\n"); 
		query.append("       SUM(DECODE(SIGN(INSTR('GKHSC', A.AC_TP_CD)), 1, A.IF_AMT, 0)) AS IF_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(SIGN(INSTR('GKHSC', A.AC_TP_CD)), 1, A.CRNT_AMT, 0)) AS CRNT_AMT," ).append("\n"); 
		query.append("       COUNT(A.BKG_NO) AS BKG_CNT," ).append("\n"); 
		query.append("       SUM(A.CRNT_REV_AMT) AS CRNT_REV_AMT," ).append("\n"); 
		query.append("       SUM(A.DDCT_CHG_AMT) AS DDCT_CHG_AMT," ).append("\n"); 
		query.append("       SUM(A.DDCT_TRSP_AMT) AS DDCT_TRSP_AMT," ).append("\n"); 
		query.append("       SUM(A.DDCT_SPCL_CMPN_AMT) AS DDCT_SPCL_CMPN_AMT," ).append("\n"); 
		query.append("       A.BKG_NO," ).append("\n"); 
		query.append("       A.AC_SEQ," ).append("\n"); 
		query.append("       A.CALC_NO" ).append("\n"); 
		query.append("  FROM ACM_AGN_COMM_HIS A" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT CALC_NO, RANK() OVER ( PARTITION BY BKG_NO ORDER BY CALC_NO) RNK " ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT DISTINCT CALC_NO, BKG_NO " ).append("\n"); 
		query.append("            FROM ACM_AGN_COMM_HIS " ).append("\n"); 
		query.append("            WHERE 1 = 1" ).append("\n"); 
		query.append("#if(${bkg_no} != '')" ).append("\n"); 
		query.append("            AND BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${io_bnd_cd} != '')" ).append("\n"); 
		query.append("            AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("      )B" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if(${bkg_no} != '')" ).append("\n"); 
		query.append("   AND A.BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${io_bnd_cd} != '')" ).append("\n"); 
		query.append("   AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND AC_STS_CD NOT IN ('CZ')" ).append("\n"); 
		query.append("   AND A.CALC_NO = B.CALC_NO" ).append("\n"); 
		query.append(" GROUP BY" ).append("\n"); 
		query.append("          A.CRE_DT," ).append("\n"); 
		query.append("          A.AGN_CD," ).append("\n"); 
		query.append("          A.AGN_AGMT_NO," ).append("\n"); 
		query.append("          A.IO_BND_CD," ).append("\n"); 
		query.append("          A.SAIL_ARR_DT," ).append("\n"); 
		query.append("          A.AC_TP_CD," ).append("\n"); 
		query.append("          A.CALC_NO," ).append("\n"); 
		query.append("          A.AC_STS_CD," ).append("\n"); 
		query.append("          A.BKG_NO," ).append("\n"); 
		query.append("          A.AC_SEQ," ).append("\n"); 
		query.append("          B.CALC_NO," ).append("\n"); 
		query.append("          B.RNK" ).append("\n"); 
		query.append(" ORDER BY B.CALC_NO,EVT_DT,EVT_GMT_DT,EVT_TP,AGN_CD,AGN_AGMT_NO,COMM_VVD,IO_BND_CD,SAIL_ARR_DT,CALC_SEQ,AC_TP_CD" ).append("\n"); 

	}
}