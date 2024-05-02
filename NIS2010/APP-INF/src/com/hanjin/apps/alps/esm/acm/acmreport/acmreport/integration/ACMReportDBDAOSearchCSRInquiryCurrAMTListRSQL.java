/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMReportDBDAOSearchCSRInquiryCurrAMTListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.10
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.10.10 김봉균
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

public class ACMReportDBDAOSearchCSRInquiryCurrAMTListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CURR_CD에 따른 금액을 구한다.
	  * </pre>
	  */
	public ACMReportDBDAOSearchCSRInquiryCurrAMTListRSQL(){
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
		query.append("FileName : ACMReportDBDAOSearchCSRInquiryCurrAMTListRSQL").append("\n"); 
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
		query.append("SELECT SUM (PAY_IF_AMT) AS PAY_IF_AMT, CURR_CD, SUM (IF_AMT) AS IF_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (    " ).append("\n"); 
		query.append("    SELECT NVL( SUM (AGN.PAY_IF_AMT), '') AS PAY_IF_AMT," ).append("\n"); 
		query.append("           AGN.CURR_CD," ).append("\n"); 
		query.append("           SUM (AGN.IF_AMT) AS IF_AMT" ).append("\n"); 
		query.append("      FROM ACM_AGN_COMM AGN," ).append("\n"); 
		query.append("           AP_INV_HDR INH," ).append("\n"); 
		query.append("           ACM_AGN_BKG_INFO INF" ).append("\n"); 
		query.append("     WHERE AGN.CSR_NO = INH.CSR_NO" ).append("\n"); 
		query.append("       AND AGN.CSR_NO IS NOT NULL" ).append("\n"); 
		query.append("       AND AGN.BKG_NO = INF.BKG_NO" ).append("\n"); 
		query.append("       AND AGN.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("       AND INH.SRC_CTNT = 'COMMISSION' " ).append("\n"); 
		query.append("     #if (${csr_no} != '')" ).append("\n"); 
		query.append("       AND AGN.CSR_NO IN (${csr_no}) " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${rev_vvd_cd} != '')" ).append("\n"); 
		query.append("       AND INF.REV_VVD_CD LIKE @[rev_vvd_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${date_div} == 'C')" ).append("\n"); 
		query.append("       AND INH.CRE_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("     #elseif (${date_div} == 'A')" ).append("\n"); 
		query.append("       AND INH.IF_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("     #elseif (${date_div} == 'G')" ).append("\n"); 
		query.append("       AND INH.GL_DT BETWEEN REPLACE(@[date_fm], '-','') AND REPLACE(@[date_to], '-','') + 0.99999" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${sts_cd} == '1')" ).append("\n"); 
		query.append("       AND INH.IF_DT IS NULL" ).append("\n"); 
		query.append("       AND NVL (INH.IF_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append("     #elseif (${sts_cd} == '2')" ).append("\n"); 
		query.append("       AND INH.IF_DT IS NOT NULL" ).append("\n"); 
		query.append("       AND NVL (INH.IF_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append("       AND NVL (INH.RCV_ERR_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append("     #elseif (${sts_cd} == '3')" ).append("\n"); 
		query.append("       AND INH.IF_DT IS NOT NULL" ).append("\n"); 
		query.append("       AND NVL (INH.IF_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append("       AND NVL (INH.RCV_ERR_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append("       AND INH.PAY_DT IS NOT NULL" ).append("\n"); 
		query.append("     #elseif (${sts_cd} == '4') " ).append("\n"); 
		query.append("       AND (NVL (INH.IF_FLG, 'Y') = 'E'" ).append("\n"); 
		query.append("        OR NVL (INH.RCV_ERR_FLG, 'Y') = 'E')" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     GROUP BY AGN.CURR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    -- OTHER COMMISSION --" ).append("\n"); 
		query.append("    SELECT NVL( SUM (AGN.PAY_IF_AMT), '') AS PAY_IF_AMT," ).append("\n"); 
		query.append("           AGN.CURR_CD," ).append("\n"); 
		query.append("           SUM (AGN.IF_AMT) AS IF_AMT" ).append("\n"); 
		query.append("      FROM ACM_AGN_OTR_COMM AGN," ).append("\n"); 
		query.append("           AP_INV_HDR INH" ).append("\n"); 
		query.append("     WHERE AGN.CSR_NO = INH.CSR_NO" ).append("\n"); 
		query.append("       AND AGN.CSR_NO IS NOT NULL" ).append("\n"); 
		query.append("       AND AGN.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("       AND INH.SRC_CTNT = 'COMMISSION' " ).append("\n"); 
		query.append("     #if (${csr_no} != '')" ).append("\n"); 
		query.append("       AND AGN.CSR_NO IN (${csr_no}) " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${rev_vvd_cd} != '')" ).append("\n"); 
		query.append("       AND AGN.AC_VSL_CD||AGN.AC_SKD_VOY_NO||AGN.AC_SKD_DIR_CD LIKE @[rev_vvd_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${date_div} == 'C')" ).append("\n"); 
		query.append("       AND INH.CRE_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("     #elseif (${date_div} == 'A')" ).append("\n"); 
		query.append("       AND INH.IF_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("     #elseif (${date_div} == 'G')" ).append("\n"); 
		query.append("       AND INH.GL_DT BETWEEN REPLACE(@[date_fm], '-','') AND REPLACE(@[date_to], '-','') + 0.99999" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${sts_cd} == '1')" ).append("\n"); 
		query.append("       AND INH.IF_DT IS NULL" ).append("\n"); 
		query.append("       AND NVL (INH.IF_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append("     #elseif (${sts_cd} == '2')" ).append("\n"); 
		query.append("       AND INH.IF_DT IS NOT NULL" ).append("\n"); 
		query.append("       AND NVL (INH.IF_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append("       AND NVL (INH.RCV_ERR_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append("     #elseif (${sts_cd} == '3')" ).append("\n"); 
		query.append("       AND INH.IF_DT IS NOT NULL" ).append("\n"); 
		query.append("       AND NVL (INH.IF_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append("       AND NVL (INH.RCV_ERR_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append("       AND INH.PAY_DT IS NOT NULL" ).append("\n"); 
		query.append("     #elseif (${sts_cd} == '4') " ).append("\n"); 
		query.append("       AND (NVL (INH.IF_FLG, 'Y') = 'E'" ).append("\n"); 
		query.append("        OR NVL (INH.RCV_ERR_FLG, 'Y') = 'E')" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     GROUP BY AGN.CURR_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("GROUP BY CURR_CD" ).append("\n"); 
		query.append("ORDER BY CURR_CD" ).append("\n"); 

	}
}