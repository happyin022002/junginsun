/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AGNCommApprovalDBDAOSearchReturnCSRAuditConfirmListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.04
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2013.02.04 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE YOUNJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOSearchReturnCSRAuditConfirmListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Audit Confirm 처리한 내용을 조회한다.
	  * </pre>
	  */
	public AGNCommApprovalDBDAOSearchReturnCSRAuditConfirmListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aud_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration").append("\n"); 
		query.append("FileName : AGNCommApprovalDBDAOSearchReturnCSRAuditConfirmListRSQL").append("\n"); 
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
		query.append("      AUD_NO," ).append("\n"); 
		query.append("      AGN_CD," ).append("\n"); 
		query.append("      COUNT(DISTINCT AC_VSL_CD||AC_SKD_VOY_NO||AC_SKD_DIR_CD||AC_REV_DIR_CD) AS VVD_CNT," ).append("\n"); 
		query.append("      CURR_CD," ).append("\n"); 
		query.append("      ROUND(SUM(IF_AMT), 2) AS NET_AMT," ).append("\n"); 
		query.append("      CSR_NO" ).append("\n"); 
		query.append(" FROM ACM_AGN_COMM" ).append("\n"); 
		query.append("WHERE AGN_CD    = @[agn_cd]" ).append("\n"); 
		query.append("  AND AUD_NO    = @[aud_no]" ).append("\n"); 
		query.append("  AND AC_STS_CD = 'AS'" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("AUD_NO, " ).append("\n"); 
		query.append("AGN_CD, " ).append("\n"); 
		query.append("CURR_CD, " ).append("\n"); 
		query.append("CSR_NO" ).append("\n"); 

	}
}