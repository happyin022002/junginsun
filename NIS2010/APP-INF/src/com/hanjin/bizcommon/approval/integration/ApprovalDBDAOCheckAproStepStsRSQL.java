/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ApprovalDBDAOCheckAproStepStsRSQL.java
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

public class ApprovalDBDAOCheckAproStepStsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * apro step 유효성 확인
	  * </pre>
	  */
	public ApprovalDBDAOCheckAproStepStsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOCheckAproStepStsRSQL").append("\n"); 
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
		query.append("    CASE" ).append("\n"); 
		query.append("	--WHEN X.ACCT_XCH_RT_YRMON IS NULL AND X.CSR_USD_AMT IS NULL" ).append("\n"); 
		query.append("	--THEN 'X' " ).append("\n"); 
		query.append("    WHEN " ).append("\n"); 
		query.append("        (SELECT R.APRO_RQST_SEQ FROM COM_APRO_RQST_ROUT R WHERE R.APRO_RQST_NO = X.APRO_RQST_NO AND NVL(AP_COM_CHECK_CEO_YN_FNC(R.APRO_USR_ID),'X') = 'Y') > 0 " ).append("\n"); 
		query.append("        AND" ).append("\n"); 
		query.append("        (SELECT R.APRO_RQST_SEQ FROM COM_APRO_RQST_ROUT R WHERE R.APRO_RQST_NO = X.APRO_RQST_NO AND NVL(AP_COM_CHECK_CEO_YN_FNC(R.APRO_USR_ID),'X') = 'Y')" ).append("\n"); 
		query.append("        <>" ).append("\n"); 
		query.append("        X.MAX_APRO_SEQ" ).append("\n"); 
		query.append("    THEN 'I' " ).append("\n"); 
		query.append("    WHEN EXISTS (" ).append("\n"); 
		query.append("        SELECT 'Y'" ).append("\n"); 
		query.append("        FROM AP_INV_HDR HH, AP_INV_DTRB DD, AP_INV_HDR H, AP_INV_DTRB D, COM_APRO_CSR_DTL B, COM_APRO_RQST_HDR A, COM_APRO_RQST_ROUT R" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND HH.SRC_CTNT NOT IN ('BROKERAGE','COMMISSION') " ).append("\n"); 
		query.append("        AND HH.CSR_NO = DD.CSR_NO" ).append("\n"); 
		query.append("        AND HH.CSR_NO = X.CSR_NO" ).append("\n"); 
		query.append("        AND H.CSR_NO = D.CSR_NO" ).append("\n"); 
		query.append("        AND H.VNDR_NO = HH.VNDR_NO" ).append("\n"); 
		query.append("        AND D.ATTR_CTNT1 = DD.ATTR_CTNT1" ).append("\n"); 
		query.append("        AND NVL(H.IF_FLG,'N') = 'E'" ).append("\n"); 
		query.append("        AND H.CSR_NO = B.CSR_NO" ).append("\n"); 
		query.append("        AND B.APRO_RQST_NO = A.APRO_RQST_NO" ).append("\n"); 
		query.append("        AND A.APRO_RQST_NO = R.APRO_RQST_NO" ).append("\n"); 
		query.append("        AND NVL(A.APSTS_CD,'N') = 'C'" ).append("\n"); 
		query.append("        AND NVL(R.APSTS_CD,'N') = 'C'" ).append("\n"); 
		query.append("        AND NVL(AP_COM_CHECK_CEO_YN_FNC(R.APRO_USR_ID),'X') = 'Y'" ).append("\n"); 
		query.append("        AND R.APRO_RQST_SEQ = (SELECT MAX(X.APRO_RQST_SEQ) FROM COM_APRO_RQST_ROUT X WHERE X.APRO_RQST_NO = R.APRO_RQST_NO)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    THEN 'F' " ).append("\n"); 
		query.append("    WHEN EXISTS (" ).append("\n"); 
		query.append("        SELECT 'Y'" ).append("\n"); 
		query.append("        FROM AP_INV_HDR H, AP_INV_DTRB D" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND H.CSR_NO = X.CSR_NO        " ).append("\n"); 
		query.append("        AND H.CSR_NO = D.CSR_NO" ).append("\n"); 
		query.append("        AND ( " ).append("\n"); 
		query.append("				D.DTRB_COA_ACCT_CD IN (" ).append("\n"); 
		query.append("										'511900','511911' " ).append("\n"); 
		query.append("										,'954113','954111','954112','954115' " ).append("\n"); 
		query.append("										,'111081','111421','111431' " ).append("\n"); 
		query.append("								      ) " ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				D.DTRB_COA_ACCT_CD LIKE '5117%' " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    THEN 'C'" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN ACCT_XCH_RT_YRMON IS NOT NULL AND CSR_USD_AMT IS NOT NULL" ).append("\n"); 
		query.append("        THEN " ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("            WHEN X.KNT < 2" ).append("\n"); 
		query.append("            THEN 'K'" ).append("\n"); 
		query.append("            WHEN CSR_USD_AMT >= 100000" ).append("\n"); 
		query.append("            THEN DECODE(NVL(AP_COM_CHECK_CEO_YN_FNC(X.APRO_USR_ID),'X'),'N','P',NVL(AP_COM_CHECK_CEO_YN_FNC(X.APRO_USR_ID),'X')) " ).append("\n"); 
		query.append("            ELSE " ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                WHEN DECODE(NVL(AP_COM_CHECK_CEO_YN_FNC(X.APRO_USR_ID),'X'),'N','P',NVL(AP_COM_CHECK_CEO_YN_FNC(X.APRO_USR_ID),'X')) = 'Y'" ).append("\n"); 
		query.append("                THEN 'Y'" ).append("\n"); 
		query.append("                ELSE DECODE(NVL(AP_COM_CHECK_MGR_YN_FNC(X.APRO_USR_ID,@[usr_id]),'X'),'N','M',NVL(AP_COM_CHECK_MGR_YN_FNC(X.APRO_USR_ID,@[usr_id]),'X'))" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("        WHEN (ACCT_XCH_RT_YRMON IS NOT NULL AND CSR_USD_AMT IS NULL) OR (ACCT_XCH_RT_YRMON IS NULL AND CSR_USD_AMT IS NOT NULL)        " ).append("\n"); 
		query.append("        THEN 'E'" ).append("\n"); 
		query.append("        ELSE 'X' " ).append("\n"); 
		query.append("        END" ).append("\n"); 
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
		query.append("        , MAX(R.APRO_RQST_SEQ) OVER (PARTITION BY R.APRO_RQST_NO) MAX_APRO_SEQ" ).append("\n"); 
		query.append("        , R.APRO_RQST_NO" ).append("\n"); 
		query.append("        , R.APRO_RQST_SEQ" ).append("\n"); 
		query.append("        , R.APRO_USR_ID" ).append("\n"); 
		query.append("        , R.APRO_USR_NM" ).append("\n"); 
		query.append("    FROM AP_INV_HDR A, COM_APRO_RQST_HDR H, COM_APRO_CSR_DTL D, COM_APRO_RQST_ROUT R" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND A.CSR_NO = D.CSR_NO" ).append("\n"); 
		query.append("    AND H.APRO_RQST_NO = D.APRO_RQST_NO" ).append("\n"); 
		query.append("    AND H.APRO_RQST_NO = R.APRO_RQST_NO" ).append("\n"); 
		query.append("    AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE RNK = 1" ).append("\n"); 

	}
}