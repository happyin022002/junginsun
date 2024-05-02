/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ApprovalDBDAOChkUrgPayFlgAproRoutRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.03 
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

public class ApprovalDBDAOChkUrgPayFlgAproRoutRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 후결 가능 여부 검사 : PDT님이 apro step의 마지막인지 검사 + 최소2개 이상의 apro step 존재여부 검사
	  * </pre>
	  */
	public ApprovalDBDAOChkUrgPayFlgAproRoutRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOChkUrgPayFlgAproRoutRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("--    X.URG_PAY_FLG, X.CSR_USD_AMT, X.APRO_USR_ID, X.APRO_RQST_SEQ, X.CRNT_APRO_SEQ," ).append("\n"); 
		query.append("    CASE" ).append("\n"); 
		query.append("    WHEN NVL(X.URG_PAY_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("    THEN" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN " ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("            WHEN ACCT_XCH_RT_YRMON IS NOT NULL AND CSR_USD_AMT IS NOT NULL" ).append("\n"); 
		query.append("            THEN " ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                WHEN X.KNT < 2" ).append("\n"); 
		query.append("                THEN 'K'" ).append("\n"); 
		query.append("                ELSE DECODE(NVL(AP_COM_CHECK_CEO_YN_FNC(X.APRO_USR_ID),'X'),'N','P',NVL(AP_COM_CHECK_CEO_YN_FNC(X.APRO_USR_ID),'X'))" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("            WHEN (ACCT_XCH_RT_YRMON IS NOT NULL AND CSR_USD_AMT IS NULL) OR (ACCT_XCH_RT_YRMON IS NULL AND CSR_USD_AMT IS NOT NULL)" ).append("\n"); 
		query.append("            THEN 'E' /* 둘중 하나만 값이 있으면 잘못 된것 */" ).append("\n"); 
		query.append("            ELSE 'X' /* 둘다 없으면 이번 대상아니라고 판단해야함 */" ).append("\n"); 
		query.append("            END = 'Y'" ).append("\n"); 
		query.append("        THEN" ).append("\n"); 
		query.append("            CASE " ).append("\n"); 
		query.append("            WHEN X.APRO_RQST_SEQ-1 = @[apro_rqst_seq] /* X.CRNT_APRO_SEQ  최종 결재자 SEQ - 1 = 현재 단계 결재 SEQ와 같은 경우에는 후결 가능 */" ).append("\n"); 
		query.append("            THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N2' " ).append("\n"); 
		query.append("            END " ).append("\n"); 
		query.append("        ELSE 'X2'" ).append("\n"); 
		query.append("        END       " ).append("\n"); 
		query.append("    ELSE 'N3'" ).append("\n"); 
		query.append("    END RETVAL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        A.CSR_NO" ).append("\n"); 
		query.append("        , A.SRC_CTNT" ).append("\n"); 
		query.append("        , A.GL_DT" ).append("\n"); 
		query.append("        , A.CSR_CURR_CD" ).append("\n"); 
		query.append("        , A.CSR_AMT" ).append("\n"); 
		query.append("        , A.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("        , A.CSR_USD_AMT" ).append("\n"); 
		query.append("        , COUNT(R.APRO_RQST_SEQ) OVER (PARTITION BY R.APRO_RQST_NO) KNT" ).append("\n"); 
		query.append("        , DENSE_RANK() OVER (PARTITION BY R.APRO_RQST_NO ORDER BY R.APRO_RQST_SEQ DESC) RNK" ).append("\n"); 
		query.append("        , R.APRO_RQST_NO" ).append("\n"); 
		query.append("        , R.APRO_RQST_SEQ" ).append("\n"); 
		query.append("        , R.APRO_USR_ID" ).append("\n"); 
		query.append("        , R.APRO_USR_NM" ).append("\n"); 
		query.append("        , A.URG_PAY_FLG" ).append("\n"); 
		query.append("        , H.CRNT_APRO_SEQ" ).append("\n"); 
		query.append("    FROM AP_INV_HDR A, COM_APRO_RQST_HDR H, COM_APRO_CSR_DTL D, COM_APRO_RQST_ROUT R " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND A.CSR_NO = D.CSR_NO" ).append("\n"); 
		query.append("    AND H.APRO_RQST_NO = D.APRO_RQST_NO" ).append("\n"); 
		query.append("    AND H.APRO_RQST_NO = R.APRO_RQST_NO" ).append("\n"); 
		query.append("    AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE RNK = 1" ).append("\n"); 

	}
}