/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMReportDBDAOSearchCSRInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.09
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.10.09 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmreport.acmreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMReportDBDAOSearchCSRInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR Inquiry 목록을 조회한다.
	  * </pre>
	  */
	public ACMReportDBDAOSearchCSRInquiryListRSQL(){
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
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmreport.acmreport.integration").append("\n"); 
		query.append("FileName : ACMReportDBDAOSearchCSRInquiryListRSQL").append("\n"); 
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
		query.append("SELECT AGN.AGN_CD," ).append("\n"); 
		query.append("       AGN.CSR_NO," ).append("\n"); 
		query.append("       AGN.AUD_NO," ).append("\n"); 
		query.append("       MAX (INH.INV_DESC) AS INV_DESC," ).append("\n"); 
		query.append("       AGN.COMM_STND_COST_CD," ).append("\n"); 
		query.append("       SUM (AGN.IF_AMT) AS IF_AMT," ).append("\n"); 
		query.append("       SUM (AGN.PAY_IF_AMT) AS PAY_IF_AMT," ).append("\n"); 
		query.append("       INF.REV_VVD_CD," ).append("\n"); 
		query.append("       CASE AGN.XCH_RT_APLY_LVL" ).append("\n"); 
		query.append("         WHEN '4' THEN (SELECT ORG.FX_CURR_RT" ).append("\n"); 
		query.append("                          FROM MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("                         WHERE ORG.OFC_CD = AGN.AGN_CD )" ).append("\n"); 
		query.append("                  ELSE AGN.PAY_XCH_RT" ).append("\n"); 
		query.append("       END AS XCH_RT," ).append("\n"); 
		query.append("       AGN.CURR_CD," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("         WHEN MAX (IF_ERR_RSN) IS NOT NULL THEN MAX (IF_ERR_RSN)" ).append("\n"); 
		query.append("         WHEN MAX (RCV_ERR_RSN) IS NOT NULL THEN MAX (RCV_ERR_RSN)" ).append("\n"); 
		query.append("         WHEN MAX (AGN.AC_PROC_DESC) = 'Interface OK!' THEN 'Success'" ).append("\n"); 
		query.append("         ELSE MAX (AGN.AC_PROC_DESC)" ).append("\n"); 
		query.append("       END AS STATUS," ).append("\n"); 
		query.append("       TO_CHAR(MAX (INH.CRE_DT), 'YYYYMMDD')  AS CRE_DT," ).append("\n"); 
		query.append("       TO_CHAR(MAX (INH.IF_DT), 'YYYYMMDD')   AS IF_DT," ).append("\n"); 
		query.append("       TO_CHAR(MAX (AGN.APRO_DT), 'YYYYMMDD') AS APRO_DT," ).append("\n"); 
		query.append("       MAX (INH.GL_DT)       AS GL_DT," ).append("\n"); 
		query.append("       MAX (INH.PAY_DT)      AS PAY_DT," ).append("\n"); 
		query.append("       MAX (AGN.IF_USR_ID)   AS CRE_USR_ID," ).append("\n"); 
		query.append("       MAX (AGN.APRO_USR_ID) AS APRO_USR_ID" ).append("\n"); 
		query.append("  FROM ACM_AGN_COMM AGN," ).append("\n"); 
		query.append("       AP_INV_HDR INH," ).append("\n"); 
		query.append("       ACM_AGN_BKG_INFO INF" ).append("\n"); 
		query.append(" WHERE AGN.CSR_NO = INH.CSR_NO" ).append("\n"); 
		query.append("   AND AGN.CSR_NO IS NOT NULL" ).append("\n"); 
		query.append("   AND AGN.BKG_NO = INF.BKG_NO" ).append("\n"); 
		query.append("   AND AGN.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("   AND INH.SRC_CTNT = 'COMMISSION' " ).append("\n"); 
		query.append(" #if (${csr_no} != '')" ).append("\n"); 
		query.append("   AND AGN.CSR_NO IN (${csr_no}) " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${rev_vvd_cd} != '')" ).append("\n"); 
		query.append("   AND INF.REV_VVD_CD LIKE @[rev_vvd_cd]||'%'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${date_div} == 'C')" ).append("\n"); 
		query.append("   AND INH.CRE_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append(" #elseif (${date_div} == 'A')" ).append("\n"); 
		query.append("   AND INH.IF_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append(" #elseif (${date_div} == 'G')" ).append("\n"); 
		query.append("   AND INH.GL_DT BETWEEN replace(@[date_fm],'-','') AND replace(@[date_to],'-','')" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${sts_cd} == '1')" ).append("\n"); 
		query.append("   AND INH.IF_DT IS NULL" ).append("\n"); 
		query.append("   AND NVL (INH.IF_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append(" #elseif (${sts_cd} == '2')" ).append("\n"); 
		query.append("   AND INH.IF_DT IS NOT NULL" ).append("\n"); 
		query.append("   AND NVL (INH.IF_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append("   AND NVL (INH.RCV_ERR_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append(" #elseif (${sts_cd} == '3')" ).append("\n"); 
		query.append("   AND INH.IF_DT IS NOT NULL" ).append("\n"); 
		query.append("   AND NVL (INH.IF_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append("   AND NVL (INH.RCV_ERR_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append("   AND INH.PAY_DT IS NOT NULL" ).append("\n"); 
		query.append(" #elseif (${sts_cd} == '4') " ).append("\n"); 
		query.append("   AND (NVL (INH.IF_FLG, 'Y') = 'E'" ).append("\n"); 
		query.append("    OR NVL (INH.RCV_ERR_FLG, 'Y') = 'E')" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" GROUP BY AGN.AGN_CD," ).append("\n"); 
		query.append("       AGN.CSR_NO," ).append("\n"); 
		query.append("       AGN.AUD_NO," ).append("\n"); 
		query.append("       AGN.COMM_STND_COST_CD," ).append("\n"); 
		query.append("       INF.REV_VVD_CD," ).append("\n"); 
		query.append("       AGN.XCH_RT_APLY_LVL," ).append("\n"); 
		query.append("       AGN.PAY_XCH_RT," ).append("\n"); 
		query.append("       AGN.CURR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- OTHER COMMISSION --" ).append("\n"); 
		query.append("SELECT AGN.AGN_CD," ).append("\n"); 
		query.append("       AGN.CSR_NO," ).append("\n"); 
		query.append("       AGN.AUD_NO," ).append("\n"); 
		query.append("       MAX (INH.INV_DESC) AS INV_DESC," ).append("\n"); 
		query.append("       AGN.COMM_STND_COST_CD," ).append("\n"); 
		query.append("       SUM (AGN.IF_AMT) AS IF_AMT," ).append("\n"); 
		query.append("       SUM (AGN.PAY_IF_AMT) AS PAY_IF_AMT," ).append("\n"); 
		query.append("       AGN.AC_VSL_CD||AGN.AC_SKD_VOY_NO||AGN.AC_SKD_DIR_CD AS REV_VVD_CD," ).append("\n"); 
		query.append("       CASE AGN.XCH_RT_APLY_LVL" ).append("\n"); 
		query.append("         WHEN '4' THEN (SELECT ORG.FX_CURR_RT" ).append("\n"); 
		query.append("                          FROM MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("                         WHERE ORG.OFC_CD = AGN.AGN_CD )" ).append("\n"); 
		query.append("                  ELSE AGN.PAY_XCH_RT" ).append("\n"); 
		query.append("       END AS XCH_RT," ).append("\n"); 
		query.append("       AGN.CURR_CD," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("         WHEN MAX (IF_ERR_RSN) IS NOT NULL THEN MAX (IF_ERR_RSN)" ).append("\n"); 
		query.append("         WHEN MAX (RCV_ERR_RSN) IS NOT NULL THEN MAX (RCV_ERR_RSN)" ).append("\n"); 
		query.append("         WHEN MAX (AGN.AC_PROC_DESC) = 'Interface OK!' THEN 'Success'" ).append("\n"); 
		query.append("         ELSE MAX (AGN.AC_PROC_DESC)" ).append("\n"); 
		query.append("       END AS STATUS," ).append("\n"); 
		query.append("       TO_CHAR(MAX (INH.CRE_DT), 'YYYYMMDD')  AS CRE_DT," ).append("\n"); 
		query.append("       TO_CHAR(MAX (INH.IF_DT), 'YYYYMMDD')   AS IF_DT," ).append("\n"); 
		query.append("       TO_CHAR(MAX (AGN.APRO_DT), 'YYYYMMDD') AS APRO_DT," ).append("\n"); 
		query.append("       MAX (INH.GL_DT)       AS GL_DT," ).append("\n"); 
		query.append("       MAX (INH.PAY_DT)      AS PAY_DT," ).append("\n"); 
		query.append("       MAX (AGN.IF_USR_ID)   AS CRE_USR_ID," ).append("\n"); 
		query.append("       MAX (AGN.APRO_USR_ID) AS APRO_USR_ID" ).append("\n"); 
		query.append("  FROM ACM_AGN_OTR_COMM AGN," ).append("\n"); 
		query.append("       AP_INV_HDR INH" ).append("\n"); 
		query.append(" WHERE AGN.CSR_NO = INH.CSR_NO" ).append("\n"); 
		query.append("   AND AGN.CSR_NO IS NOT NULL" ).append("\n"); 
		query.append("   AND AGN.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("   AND INH.SRC_CTNT = 'COMMISSION' " ).append("\n"); 
		query.append(" #if (${csr_no} != '')" ).append("\n"); 
		query.append("   AND AGN.CSR_NO IN (${csr_no}) " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${rev_vvd_cd} != '')" ).append("\n"); 
		query.append("   AND AGN.AC_VSL_CD||AGN.AC_SKD_VOY_NO||AGN.AC_SKD_DIR_CD LIKE @[rev_vvd_cd]||'%'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${date_div} == 'C')" ).append("\n"); 
		query.append("   AND INH.CRE_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append(" #elseif (${date_div} == 'A')" ).append("\n"); 
		query.append("   AND INH.IF_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append(" #elseif (${date_div} == 'G')" ).append("\n"); 
		query.append("   AND INH.GL_DT BETWEEN replace(@[date_fm],'-','') AND replace(@[date_to],'-','')" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${sts_cd} == '1')" ).append("\n"); 
		query.append("   AND INH.IF_DT IS NULL" ).append("\n"); 
		query.append("   AND NVL (INH.IF_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append(" #elseif (${sts_cd} == '2')" ).append("\n"); 
		query.append("   AND INH.IF_DT IS NOT NULL" ).append("\n"); 
		query.append("   AND NVL (INH.IF_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append("   AND NVL (INH.RCV_ERR_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append(" #elseif (${sts_cd} == '3')" ).append("\n"); 
		query.append("   AND INH.IF_DT IS NOT NULL" ).append("\n"); 
		query.append("   AND NVL (INH.IF_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append("   AND NVL (INH.RCV_ERR_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append("   AND INH.PAY_DT IS NOT NULL" ).append("\n"); 
		query.append(" #elseif (${sts_cd} == '4') " ).append("\n"); 
		query.append("   AND (NVL (INH.IF_FLG, 'Y') = 'E'" ).append("\n"); 
		query.append("    OR NVL (INH.RCV_ERR_FLG, 'Y') = 'E')" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" GROUP BY AGN.AGN_CD," ).append("\n"); 
		query.append("       AGN.CSR_NO," ).append("\n"); 
		query.append("       AGN.AUD_NO," ).append("\n"); 
		query.append("       AGN.COMM_STND_COST_CD," ).append("\n"); 
		query.append("       AGN.AC_VSL_CD||AGN.AC_SKD_VOY_NO||AGN.AC_SKD_DIR_CD," ).append("\n"); 
		query.append("       AGN.XCH_RT_APLY_LVL," ).append("\n"); 
		query.append("       AGN.PAY_XCH_RT," ).append("\n"); 
		query.append("       AGN.CURR_CD" ).append("\n"); 
		query.append(" ORDER BY AGN_CD," ).append("\n"); 
		query.append("       CSR_NO," ).append("\n"); 
		query.append("       AUD_NO," ).append("\n"); 
		query.append("       COMM_STND_COST_CD," ).append("\n"); 
		query.append("       REV_VVD_CD" ).append("\n"); 

	}
}