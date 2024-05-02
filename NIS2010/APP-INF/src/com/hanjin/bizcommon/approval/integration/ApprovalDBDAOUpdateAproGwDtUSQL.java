/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ApprovalDBDAOUpdateAproGwDtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOUpdateAproGwDtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RESULT 값에 따라 DATE 컬럼 업데이트
	  * </pre>
	  */
	public ApprovalDBDAOUpdateAproGwDtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gw_agmt_doc_cfm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOUpdateAproGwDtUSQL").append("\n"); 
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
		query.append("UPDATE AP_INV_HDR  " ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("#if (${csr_apro_tp_cd} == 'GW')" ).append("\n"); 
		query.append("	#if (${result} == 'P') " ).append("\n"); 
		query.append("		RQST_APRO_STEP_FLG = ''" ).append("\n"); 
		query.append("    	,CSR_APRO_STEP_ASGN_DT = SYSDATE" ).append("\n"); 
		query.append("	#elseif (${result} == 'Y') " ).append("\n"); 
		query.append("		GW_AGMT_DOC_CFM_CD = @[gw_agmt_doc_cfm_cd]" ).append("\n"); 
		query.append("		,CSR_APRO_CMPL_DT = SYSDATE" ).append("\n"); 
		query.append("	#elseif (${result} == 'D')" ).append("\n"); 
		query.append("		CSR_CXL_DT = SYSDATE" ).append("\n"); 
		query.append("	#elseif (${result} == 'N')" ).append("\n"); 
		query.append("		CSR_RJCT_DT = SYSDATE" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		RQST_APRO_STEP_FLG = ''" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${csr_apro_tp_cd} == 'AL')" ).append("\n"); 
		query.append("	RQST_APRO_STEP_FLG = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE CSR_NO = @[csr_no] " ).append("\n"); 
		query.append("#if (${csr_apro_tp_cd} == 'GW')" ).append("\n"); 
		query.append("	#if (${result} == 'P') " ).append("\n"); 
		query.append("		AND	RQST_APRO_STEP_FLG = 'Y'" ).append("\n"); 
		query.append("		AND CSR_APRO_STEP_ASGN_RQST_DT IS NOT NULL" ).append("\n"); 
		query.append("	#elseif (${result} == 'Y') " ).append("\n"); 
		query.append("		AND RQST_APRO_STEP_FLG IS NULL" ).append("\n"); 
		query.append("	#elseif (${result} == 'D')" ).append("\n"); 
		query.append("		AND RQST_APRO_STEP_FLG IS NULL" ).append("\n"); 
		query.append("	#elseif (${result} == 'N')" ).append("\n"); 
		query.append("		AND RQST_APRO_STEP_FLG IS NULL" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND 1=1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${csr_apro_tp_cd} == 'AL')" ).append("\n"); 
		query.append("	AND 1=1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}