/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AGNCommApprovalDBDAOAddAcmAgnCommDtlHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.05 
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

public class AGNCommApprovalDBDAOAddAcmAgnCommDtlHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACM_AGN_COMM_DTL_HIS 테이블 저장
	  * </pre>
	  */
	public AGNCommApprovalDBDAOAddAcmAgnCommDtlHisCSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration").append("\n"); 
		query.append("FileName : AGNCommApprovalDBDAOAddAcmAgnCommDtlHisCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_AGN_COMM_DTL_HIS" ).append("\n"); 
		query.append("(BKG_NO, AGN_CD, IO_BND_CD, AC_TP_CD, AC_SEQ, CNTR_TPSZ_CD, CALC_NO, BKG_VOL_QTY, IF_DTRB_AMT, CURR_CD, PAY_IF_DTRB_AMT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       AGN_CD," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       AC_TP_CD," ).append("\n"); 
		query.append("       AC_SEQ," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       @[calc_no] AS CALC_NO," ).append("\n"); 
		query.append("       BKG_VOL_QTY," ).append("\n"); 
		query.append("       IF_DTRB_AMT," ).append("\n"); 
		query.append("       CURR_CD," ).append("\n"); 
		query.append("       PAY_IF_DTRB_AMT," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("  FROM ACM_AGN_COMM_DTL" ).append("\n"); 
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