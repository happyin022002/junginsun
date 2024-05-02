/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMReportDBDAOSearchCSRDetailListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.09
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.10.09 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmreport.acmreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMReportDBDAOSearchCSRDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * CSR Detail 정보를 조회한다.
	  * </pre>
	  */
	public ACMReportDBDAOSearchCSRDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmreport.acmreport.integration").append("\n");
		query.append("FileName : ACMReportDBDAOSearchCSRDetailListRSQL").append("\n");
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
		query.append("SELECT MAX (AGN.BKG_NO) AS BKG_NO," ).append("\n");
		query.append("       (SELECT SUM (QTY.OP_CNTR_QTY)" ).append("\n");
		query.append("          FROM BKG_BL_DOC DOC," ).append("\n");
		query.append("               BKG_BOOKING BKG," ).append("\n");
		query.append("               BKG_BOOKING BK2," ).append("\n");
		query.append("               BKG_QUANTITY QTY" ).append("\n");
		query.append("         WHERE ( BKG.BKG_NO = DOC.BKG_NO" ).append("\n");
		query.append("                    OR ( BKG.BL_NO = DOC.MST_CVRD_BL_NO ) )" ).append("\n");
		query.append("           AND BK2.BKG_NO = DOC.BKG_NO" ).append("\n");
		query.append("           AND BK2.BKG_NO = QTY.BKG_NO" ).append("\n");
		query.append("           AND BK2.BL_NO_TP = '0'" ).append("\n");
		query.append("           AND BKG.BKG_NO = AGN.BKG_NO ) AS QTY," ).append("\n");
		query.append("       (SELECT TO_CHAR(NVL(PPD_OFRT_AMT, 0) + NVL(PPD_CHG_AMT, 0) + NVL(CLT_OFRT_AMT, 0) + NVL(CLT_CHG_AMT, 0), '999,999,990.00')" ).append("\n");
		query.append("          FROM ACM_AGN_BKG_INFO" ).append("\n");
		query.append("         WHERE BKG_NO = AGN.BKG_NO ) AS G_REV," ).append("\n");
		query.append("	   '' AS N_REV," ).append("\n");
		query.append("       SUM (" ).append("\n");
		query.append("               CASE" ).append("\n");
		query.append("                 WHEN AGN.COMM_STND_COST_CD = '512621' THEN AGN.IF_AMT" ).append("\n");
		query.append("               END ) AS OUT_BOUND," ).append("\n");
		query.append("       SUM (" ).append("\n");
		query.append("               CASE" ).append("\n");
		query.append("                 WHEN AGN.COMM_STND_COST_CD = '512611' THEN AGN.IF_AMT" ).append("\n");
		query.append("               END ) AS IN_BOUND," ).append("\n");
		query.append("       SUM (" ).append("\n");
		query.append("               CASE" ).append("\n");
		query.append("                 WHEN AGN.COMM_STND_COST_CD = '512631' THEN AGN.IF_AMT" ).append("\n");
		query.append("               END ) AS TRANS," ).append("\n");
		query.append("       SUM (" ).append("\n");
		query.append("               CASE" ).append("\n");
		query.append("                 WHEN AGN.COMM_STND_COST_CD = '512661' THEN AGN.IF_AMT" ).append("\n");
		query.append("               END ) AS CHF," ).append("\n");
		query.append("       SUM (" ).append("\n");
		query.append("               CASE" ).append("\n");
		query.append("                 WHEN AGN.COMM_STND_COST_CD = '512641' THEN AGN.IF_AMT" ).append("\n");
		query.append("               END ) AS BROG," ).append("\n");
		query.append("       SUM (" ).append("\n");
		query.append("               CASE" ).append("\n");
		query.append("                 WHEN AGN.COMM_STND_COST_CD = '512691' THEN AGN.IF_AMT" ).append("\n");
		query.append("               END ) AS DOC_OTH," ).append("\n");
		query.append("       SUM (" ).append("\n");
		query.append("               CASE" ).append("\n");
		query.append("                 WHEN AGN.COMM_STND_COST_CD = '512692' THEN AGN.IF_AMT" ).append("\n");
		query.append("               END ) AS DMDT," ).append("\n");
		query.append("       SUM (" ).append("\n");
		query.append("               CASE" ).append("\n");
		query.append("                 WHEN AGN.COMM_STND_COST_CD = '512693' THEN AGN.IF_AMT" ).append("\n");
		query.append("               END ) AS VSL_OPR," ).append("\n");
		query.append("       SUM (" ).append("\n");
		query.append("               CASE" ).append("\n");
		query.append("                 WHEN AGN.COMM_STND_COST_CD = '512694' THEN AGN.IF_AMT" ).append("\n");
		query.append("               END ) AS COST_MU" ).append("\n");
		query.append("  FROM ACM_AGN_COMM AGN," ).append("\n");
		query.append("       ACM_AGN_BKG_INFO INF" ).append("\n");
		query.append(" WHERE AGN.BKG_NO = INF.BKG_NO" ).append("\n");
		query.append("#if(${agn_cd} != '')" ).append("\n");
		query.append("   AND AGN.AGN_CD = @[agn_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("   AND AGN.CSR_NO = @[csr_no]" ).append("\n");
		query.append("   AND INF.REV_VVD_CD = @[rev_vvd_cd]" ).append("\n");
		query.append("   AND AGN.COMM_STND_COST_CD = @[comm_stnd_cost_cd]" ).append("\n");
		query.append(" GROUP BY AGN.BKG_NO," ).append("\n");
		query.append("       AGN.CSR_NO," ).append("\n");
		query.append("       AGN.COMM_STND_COST_CD," ).append("\n");
		query.append("       INF.REV_VVD_CD" ).append("\n");
		query.append("" ).append("\n");
		query.append("UNION ALL" ).append("\n");
		query.append("-- OTHER COMMISSION --" ).append("\n");
		query.append("SELECT MAX (AGN.OTR_COMM_NO) AS BKG_NO," ).append("\n");
		query.append("       (SELECT SUM (QTY.OP_CNTR_QTY)" ).append("\n");
		query.append("          FROM BKG_BL_DOC DOC," ).append("\n");
		query.append("               BKG_BOOKING BKG," ).append("\n");
		query.append("               BKG_BOOKING BK2," ).append("\n");
		query.append("               BKG_QUANTITY QTY" ).append("\n");
		query.append("         WHERE ( BKG.BKG_NO = DOC.BKG_NO" ).append("\n");
		query.append("                    OR ( BKG.BL_NO = DOC.MST_CVRD_BL_NO ) )" ).append("\n");
		query.append("           AND BK2.BKG_NO = DOC.BKG_NO" ).append("\n");
		query.append("           AND BK2.BKG_NO = QTY.BKG_NO" ).append("\n");
		query.append("           AND BK2.BL_NO_TP = '0'" ).append("\n");
		query.append("           AND BKG.BKG_NO = AGN.OTR_COMM_NO ) AS QTY," ).append("\n");
		query.append("       (SELECT TO_CHAR(NVL(PPD_OFRT_AMT, 0) + NVL(PPD_CHG_AMT, 0) + NVL(CLT_OFRT_AMT, 0) + NVL(CLT_CHG_AMT, 0), '999,999,990.00')" ).append("\n");
		query.append("          FROM ACM_AGN_BKG_INFO" ).append("\n");
		query.append("         WHERE BKG_NO = AGN.OTR_COMM_NO ) AS G_REV," ).append("\n");
		query.append("	   '' AS N_REV," ).append("\n");
		query.append("       SUM (" ).append("\n");
		query.append("               CASE" ).append("\n");
		query.append("                 WHEN AGN.COMM_STND_COST_CD = '512621' THEN AGN.IF_AMT" ).append("\n");
		query.append("               END ) AS OUT_BOUND," ).append("\n");
		query.append("       SUM (" ).append("\n");
		query.append("               CASE" ).append("\n");
		query.append("                 WHEN AGN.COMM_STND_COST_CD = '512611' THEN AGN.IF_AMT" ).append("\n");
		query.append("               END ) AS IN_BOUND," ).append("\n");
		query.append("       SUM (" ).append("\n");
		query.append("               CASE" ).append("\n");
		query.append("                 WHEN AGN.COMM_STND_COST_CD = '512631' THEN AGN.IF_AMT" ).append("\n");
		query.append("               END ) AS TRANS," ).append("\n");
		query.append("       SUM (" ).append("\n");
		query.append("               CASE" ).append("\n");
		query.append("                 WHEN AGN.COMM_STND_COST_CD = '512661' THEN AGN.IF_AMT" ).append("\n");
		query.append("               END ) AS CHF," ).append("\n");
		query.append("       SUM (" ).append("\n");
		query.append("               CASE" ).append("\n");
		query.append("                 WHEN AGN.COMM_STND_COST_CD = '512641' THEN AGN.IF_AMT" ).append("\n");
		query.append("               END ) AS BROG," ).append("\n");
		query.append("       SUM (" ).append("\n");
		query.append("               CASE" ).append("\n");
		query.append("                 WHEN AGN.COMM_STND_COST_CD = '512691' THEN AGN.IF_AMT" ).append("\n");
		query.append("               END ) AS DOC_OTH," ).append("\n");
		query.append("       SUM (" ).append("\n");
		query.append("               CASE" ).append("\n");
		query.append("                 WHEN AGN.COMM_STND_COST_CD = '512692' THEN AGN.IF_AMT" ).append("\n");
		query.append("               END ) AS DMDT," ).append("\n");
		query.append("       SUM (" ).append("\n");
		query.append("               CASE" ).append("\n");
		query.append("                 WHEN AGN.COMM_STND_COST_CD = '512693' THEN AGN.IF_AMT" ).append("\n");
		query.append("               END ) AS VSL_OPR," ).append("\n");
		query.append("       SUM (" ).append("\n");
		query.append("               CASE" ).append("\n");
		query.append("                 WHEN AGN.COMM_STND_COST_CD = '512694' THEN AGN.IF_AMT" ).append("\n");
		query.append("               END ) AS COST_MU" ).append("\n");
		query.append("  FROM ACM_AGN_OTR_COMM AGN" ).append("\n");
		query.append(" WHERE AGN.CSR_NO = @[csr_no]" ).append("\n");
		query.append("#if(${agn_cd} != '')" ).append("\n");
		query.append("   AND AGN.AGN_CD = @[agn_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("   AND AGN.AC_VSL_CD||AGN.AC_SKD_VOY_NO||AGN.AC_SKD_DIR_CD = @[rev_vvd_cd]" ).append("\n");
		query.append("   AND AGN.COMM_STND_COST_CD = @[comm_stnd_cost_cd]" ).append("\n");
		query.append(" GROUP BY AGN.OTR_COMM_NO," ).append("\n");
		query.append("       AGN.CSR_NO," ).append("\n");
		query.append("       AGN.COMM_STND_COST_CD," ).append("\n");
		query.append("       AGN.AC_VSL_CD||AGN.AC_SKD_VOY_NO||AGN.AC_SKD_DIR_CD" ).append("\n");

	}
}