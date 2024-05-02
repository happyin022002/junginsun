/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ComCsrApprovalDBDAOSearchBatchCsrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.22 
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

public class ComCsrApprovalDBDAOSearchBatchCsrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * batch 대상 csr조회
	  * </pre>
	  */
	public ComCsrApprovalDBDAOSearchBatchCsrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.csrapproval.integration").append("\n"); 
		query.append("FileName : ComCsrApprovalDBDAOSearchBatchCsrRSQL").append("\n"); 
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
		query.append("WITH CSR_BASE AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("    L.*" ).append("\n"); 
		query.append("    FROM COM_AP_CSR_HIS L" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND L.COM_AP_CSR_APRO_HIS_SEQ > 0" ).append("\n"); 
		query.append("    AND NVL(L.GW_APRO_RSLT_CD,'X') = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("N.CSR_NO" ).append("\n"); 
		query.append(",N.TJ_OFC_CD OFC_CD" ).append("\n"); 
		query.append(",N.APRO_USR_ID USER_ID" ).append("\n"); 
		query.append(",N.APRO_USR_NM" ).append("\n"); 
		query.append(",N.APRO_USR_JB_TIT_NM" ).append("\n"); 
		query.append(",N.AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append(",N.GW_AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("H.*, " ).append("\n"); 
		query.append("DENSE_RANK() OVER (PARTITION BY X.CSR_NO ORDER BY X.COM_AP_CSR_APRO_HIS_SEQ DESC) RNK," ).append("\n"); 
		query.append("X.COM_AP_CSR_APRO_HIS_SEQ, X.APRO_USR_ID, X.APRO_USR_NM, X.APRO_USR_JB_TIT_NM" ).append("\n"); 
		query.append("FROM CSR_BASE X, AP_INV_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.CSR_NO = X.CSR_NO" ).append("\n"); 
		query.append("AND NVL(H.CSR_APRO_TP_CD,'AL') = 'GW'" ).append("\n"); 
		query.append("AND NVL(H.EXE_ACT_TP_CD,'N') = 'B'" ).append("\n"); 
		query.append("AND NVL(H.RQST_APRO_STEP_FLG,'X') <> 'Y'" ).append("\n"); 
		query.append("AND H.IF_FLG IS NULL" ).append("\n"); 
		query.append("AND H.RCV_ERR_FLG IS NULL" ).append("\n"); 
		query.append("AND H.AFT_ACT_FLG IS NULL" ).append("\n"); 
		query.append("AND H.CSR_APRO_CMPL_DT IS NOT NULL" ).append("\n"); 
		query.append("AND H.CSR_RJCT_DT IS NULL" ).append("\n"); 
		query.append("AND CASE WHEN H.IF_ERR_RSN IS NOT NULL THEN SUBSTR(UPPER(H.IF_ERR_RSN),1,7) ELSE 'X' END <> 'SENDING'" ).append("\n"); 
		query.append("AND H.CRE_DT >= NVL((SELECT V.CFM_DT FROM COM_AP_ACCT_VER V WHERE V.AP_ACCT_VER_NO = (SELECT MAX(M.AP_ACCT_VER_NO) FROM COM_AP_ACCT_VER M WHERE NVL(M.CFM_FLG,'N') = 'Y')),SYSDATE-100)" ).append("\n"); 
		query.append("AND ROWNUM <= NVL((SELECT V.EXE_ROW_KNT FROM COM_AP_ACCT_VER V WHERE V.AP_ACCT_VER_NO = (SELECT MAX(M.AP_ACCT_VER_NO) FROM COM_AP_ACCT_VER M WHERE NVL(M.CFM_FLG,'N') = 'Y')),100)" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("    SELECT 'X'" ).append("\n"); 
		query.append("    FROM COM_AP_CSR_HIS E" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND E.CSR_NO = H.CSR_NO" ).append("\n"); 
		query.append("    AND E.COM_AP_CSR_APRO_HIS_SEQ > 0" ).append("\n"); 
		query.append("    AND E.COM_AP_CSR_APRO_HIS_SEQ = (" ).append("\n"); 
		query.append("        SELECT MAX(X.COM_AP_CSR_APRO_HIS_SEQ)" ).append("\n"); 
		query.append("        FROM COM_AP_CSR_HIS X" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND X.CSR_NO = E.CSR_NO" ).append("\n"); 
		query.append("        AND X.COM_AP_CSR_APRO_HIS_SEQ > 0" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    AND E.AP_CSR_IF_STS_CD IN ('EX','SD','SE','IC','IE','BE') --// 10분 BATCH 주기를 넘어서 ERP에서 REPLY가 오는 경우가 있어서 BE(batch end)인 경우도 일단 제외한다." ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(") N" ).append("\n"); 
		query.append("WHERE N.RNK = 1" ).append("\n"); 
		query.append("ORDER BY N.CRE_DT DESC" ).append("\n"); 

	}
}