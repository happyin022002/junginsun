/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AGNCommApprovalDBDAOSearchReturnCSRDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOSearchReturnCSRDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACMCommVendorInfo
	  * </pre>
	  */
	public AGNCommApprovalDBDAOSearchReturnCSRDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no_master",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration").append("\n"); 
		query.append("FileName : AGNCommApprovalDBDAOSearchReturnCSRDetailListRSQL").append("\n"); 
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
		query.append("SELECT AUD_NO," ).append("\n"); 
		query.append("       AGN_CD," ).append("\n"); 
		query.append("       COUNT(DISTINCT AC_VSL_CD||AC_SKD_VOY_NO||AC_SKD_DIR_CD||AC_REV_DIR_CD) AS VVD_CNT," ).append("\n"); 
		query.append("       CURR_CD," ).append("\n"); 
		query.append("       ROUND(SUM(IF_AMT), 2) AS NET_AMT," ).append("\n"); 
		query.append("       ROUND(SUM(IF_AMT * NVL(INV_TAX_RT, 0) / 100), DECODE(CURR_CD, 'JPY', 0, 2)) AS VAT," ).append("\n"); 
		query.append("       ROUND(SUM(IF_AMT + (IF_AMT * NVL(INV_TAX_RT, 0) / 100)), DECODE(CURR_CD, 'JPY', 0, 2)) AS TOT_AMT," ).append("\n"); 
		query.append("       CSR_NO," ).append("\n"); 
		query.append("       TO_CHAR(APRO_DT, 'YYYY-MM-DD') AS APRO_DT" ).append("\n"); 
		query.append("  FROM ACM_AGN_COMM" ).append("\n"); 
		query.append(" WHERE AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("#if (${csr_no_master} != '')" ).append("\n"); 
		query.append("   AND CSR_NO = @[csr_no_master]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND AC_STS_CD IN ('PS', 'IF')" ).append("\n"); 
		query.append("   AND CRE_USR_ID <> 'COST'" ).append("\n"); 
		query.append("   AND APRO_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append(" GROUP BY AUD_NO," ).append("\n"); 
		query.append("          AGN_CD," ).append("\n"); 
		query.append("          CURR_CD," ).append("\n"); 
		query.append("          CSR_NO," ).append("\n"); 
		query.append("          TO_CHAR(APRO_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append(" ORDER BY AUD_NO," ).append("\n"); 
		query.append("          AGN_CD," ).append("\n"); 
		query.append("          CURR_CD," ).append("\n"); 
		query.append("          APRO_DT" ).append("\n"); 

	}
}