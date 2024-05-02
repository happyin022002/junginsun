/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ComCsrApprovalDBDAOSearchCsrHisInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ComCsrApprovalDBDAOSearchCsrHisInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COM_AP_CSR_HIS의 정보를 조회한다.
	  * </pre>
	  */
	public ComCsrApprovalDBDAOSearchCsrHisInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.csrapproval.integration").append("\n"); 
		query.append("FileName : ComCsrApprovalDBDAOSearchCsrHisInfoRSQL").append("\n"); 
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
		query.append("SELECT CSR_NO" ).append("\n"); 
		query.append("    ,CSR_APRO_TP_CD" ).append("\n"); 
		query.append("    ,AUTO_MNL_FLG" ).append("\n"); 
		query.append("    ,INV_STS_CD" ).append("\n"); 
		query.append("    ,IO_BND_CD" ).append("\n"); 
		query.append("    ,IF_DT" ).append("\n"); 
		query.append("    ,GW_CSR_RQST_ID" ).append("\n"); 
		query.append("    ,GW_APRO_URL_CTNT" ).append("\n"); 
		query.append("    ,GW_APRO_RSLT_CD" ).append("\n"); 
		query.append("    ,CORR_HIS_RMK" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append("    ,APRO_USR_ID" ).append("\n"); 
		query.append("    ,APRO_USR_NM" ).append("\n"); 
		query.append("    ,APRO_USR_JB_TIT_NM" ).append("\n"); 
		query.append("    ,APRO_RMK" ).append("\n"); 
		query.append("FROM COM_AP_CSR_HIS" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("AND GW_APRO_RSLT_CD = 'Y'" ).append("\n"); 

	}
}