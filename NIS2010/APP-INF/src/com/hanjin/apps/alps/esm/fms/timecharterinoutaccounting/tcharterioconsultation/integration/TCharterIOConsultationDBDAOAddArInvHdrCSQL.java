/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOAddArInvHdrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.16
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.01.16 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOAddArInvHdrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR GW결재
	  * AR_INV_HDR 저장
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOAddArInvHdrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOAddArInvHdrCSQL").append("\n"); 
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
		query.append("INSERT INTO AR_INV_HDR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CSR_NO," ).append("\n"); 
		query.append("ACCT_XCH_RT_YRMON," ).append("\n"); 
		query.append("CSR_USD_AMT," ).append("\n"); 
		query.append("RQST_APRO_STEP_FLG," ).append("\n"); 
		query.append("COM_AP_CSR_APRO_HIS_SEQ," ).append("\n"); 
		query.append("CSR_APRO_TP_CD," ).append("\n"); 
		query.append("CSR_APRO_STEP_ASGN_RQST_DT," ).append("\n"); 
		query.append("CSR_APRO_STEP_ASGN_DT," ).append("\n"); 
		query.append("CSR_APRO_CMPL_DT," ).append("\n"); 
		query.append("CSR_CXL_DT," ).append("\n"); 
		query.append("GW_CSR_RQST_ID," ).append("\n"); 
		query.append("GW_APRO_URL_CTNT," ).append("\n"); 
		query.append("CSR_RJCT_DT," ).append("\n"); 
		query.append("APRO_USR_JB_TIT_CD," ).append("\n"); 
		query.append("GW_AGMT_DOC_CFM_CD," ).append("\n"); 
		query.append("AGMT_DOC_CFM_CD," ).append("\n"); 
		query.append("AGMT_FILE_CFM_CD," ).append("\n"); 
		query.append("AGMT_EVID_CFM_FNL_CD," ).append("\n"); 
		query.append("AP_FILE_DIV_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("@[csr_no] AS CSR_NO," ).append("\n"); 
		query.append("'' AS ACCT_XCH_RT_YRMON," ).append("\n"); 
		query.append("'' AS CSR_USD_AMT," ).append("\n"); 
		query.append("'Y' AS RQST_APRO_STEP_FLG," ).append("\n"); 
		query.append("'' AS COM_AP_CSR_APRO_HIS_SEQ," ).append("\n"); 
		query.append("'GW' AS CSR_APRO_TP_CD," ).append("\n"); 
		query.append("SYSDATE AS CSR_APRO_STEP_ASGN_RQST_DT," ).append("\n"); 
		query.append("'' AS CSR_APRO_STEP_ASGN_DT," ).append("\n"); 
		query.append("'' AS CSR_APRO_CMPL_DT," ).append("\n"); 
		query.append("'' AS CSR_CXL_DT," ).append("\n"); 
		query.append("'' AS GW_CSR_RQST_ID," ).append("\n"); 
		query.append("'' AS GW_APRO_URL_CTNT," ).append("\n"); 
		query.append("'' AS CSR_RJCT_DT," ).append("\n"); 
		query.append("'' AS APRO_USR_JB_TIT_CD," ).append("\n"); 
		query.append("'' AS GW_AGMT_DOC_CFM_CD," ).append("\n"); 
		query.append("'' AS AGMT_DOC_CFM_CD," ).append("\n"); 
		query.append("'' AS AGMT_FILE_CFM_CD," ).append("\n"); 
		query.append("'' AS AGMT_EVID_CFM_FNL_CD," ).append("\n"); 
		query.append("'' AS AP_FILE_DIV_CD," ).append("\n"); 
		query.append("@[cre_usr_id] 	AS CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE 		AS CRE_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}