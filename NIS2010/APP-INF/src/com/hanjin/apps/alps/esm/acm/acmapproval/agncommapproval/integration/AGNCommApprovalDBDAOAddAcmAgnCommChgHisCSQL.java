/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommApprovalDBDAOAddAcmAgnCommChgHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.19
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.10.19 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOAddAcmAgnCommChgHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACM_AGN_COMM_CHG_HIS 테이블 저장
	  * </pre>
	  */
	public AGNCommApprovalDBDAOAddAcmAgnCommChgHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration").append("\n"); 
		query.append("FileName : AGNCommApprovalDBDAOAddAcmAgnCommChgHisCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_AGN_COMM_CHG_HIS" ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       AGN_CD," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       AC_TP_CD," ).append("\n"); 
		query.append("       AC_SEQ," ).append("\n"); 
		query.append("       AC_CHG_SEQ," ).append("\n"); 
		query.append("       @[calc_no] AS CALC_NO," ).append("\n"); 
		query.append("       REP_CHG_CD," ).append("\n"); 
		query.append("       CHG_CD," ).append("\n"); 
		query.append("       BKG_AGMT_UT_CD," ).append("\n"); 
		query.append("       CHG_DDCT_AMT," ).append("\n"); 
		query.append("       CURR_CD," ).append("\n"); 
		query.append("       CHG_DDCT_PAY_AMT," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("  FROM ACM_AGN_COMM_CHG" ).append("\n"); 
		query.append(" WHERE BKG_NO in (SELECT DISTINCT BKG_NO" ).append("\n"); 
		query.append("                   FROM ACM_AGN_COMM" ).append("\n"); 
		query.append("                  WHERE CSR_NO = @[csr_no])" ).append("\n"); 
		query.append("  AND (BKG_NO,AGN_CD,IO_BND_CD,AC_TP_CD,AC_SEQ) IN (" ).append("\n"); 
		query.append("        SELECT BKG_NO,AGN_CD,IO_BND_CD,AC_TP_CD,AC_SEQ" ).append("\n"); 
		query.append("        FROM ACM_AGN_COMM" ).append("\n"); 
		query.append("        WHERE CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}