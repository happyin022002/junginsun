/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchApproveFMSYnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.25
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.08.25 민정호
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

public class TCharterIOConsultationDBDAOSearchApproveFMSYnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FMS에서 금액이 10만불 이상 이하에서 결재라인에 CEO, 본부장이 존재하는지 조회한다.
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchApproveFMSYnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgn_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchApproveFMSYnRSQL").append("\n"); 
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
		query.append("    WHEN " ).append("\n"); 
		query.append("        (SELECT R.APRO_RQST_SEQ FROM COM_APRO_RQST_ROUT R WHERE R.APRO_RQST_NO = X.APRO_RQST_NO AND NVL(AP_COM_CHECK_CEO_YN_FNC(R.APRO_USR_ID),'X') = 'Y') > 0 " ).append("\n"); 
		query.append("        AND" ).append("\n"); 
		query.append("        (SELECT R.APRO_RQST_SEQ FROM COM_APRO_RQST_ROUT R WHERE R.APRO_RQST_NO = X.APRO_RQST_NO AND NVL(AP_COM_CHECK_CEO_YN_FNC(R.APRO_USR_ID),'X') = 'Y')" ).append("\n"); 
		query.append("        <>" ).append("\n"); 
		query.append("        X.MAX_APRO_SEQ" ).append("\n"); 
		query.append("    THEN 'I' --// PDT 맨뒤인지 확인" ).append("\n"); 
		query.append("    WHEN EXISTS (" ).append("\n"); 
		query.append("        SELECT 'Y'" ).append("\n"); 
		query.append("        FROM FMS_CONSULTATION C ,FMS_INV_DTL D" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND C.SLP_TP_CD||C.SLP_FUNC_CD||C.SLP_OFC_CD||C.SLP_ISS_DT||C.SLP_SER_NO = " ).append("\n"); 
		query.append("            D.SLP_TP_CD||D.SLP_FUNC_CD||D.SLP_OFC_CD||D.SLP_ISS_DT||D.SLP_SER_NO" ).append("\n"); 
		query.append("        AND D.AP_CXL_FLG = 'Y'		" ).append("\n"); 
		query.append("		AND C.SLP_TP_CD||C.SLP_FUNC_CD||C.SLP_OFC_CD||C.SLP_ISS_DT||C.SLP_SER_NO = X.CSR_NO" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'Y'" ).append("\n"); 
		query.append("        FROM FMS_CONSULTATION C ,FMS_BUNKER D" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND C.SLP_TP_CD||C.SLP_FUNC_CD||C.SLP_OFC_CD||C.SLP_ISS_DT||C.SLP_SER_NO = " ).append("\n"); 
		query.append("            D.SLP_TP_CD||D.SLP_FUNC_CD||D.SLP_OFC_CD||D.SLP_ISS_DT||D.SLP_SER_NO" ).append("\n"); 
		query.append("        AND D.AP_CXL_FLG = 'Y'" ).append("\n"); 
		query.append("		AND C.SLP_TP_CD||C.SLP_FUNC_CD||C.SLP_OFC_CD||C.SLP_ISS_DT||C.SLP_SER_NO = X.CSR_NO" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'Y'" ).append("\n"); 
		query.append("        FROM FMS_CONSULTATION C ,FMS_OWNR_ACCT_SLP D" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND C.SLP_TP_CD||C.SLP_FUNC_CD||C.SLP_OFC_CD||C.SLP_ISS_DT||C.SLP_SER_NO = " ).append("\n"); 
		query.append("            D.SLP_TP_CD||D.SLP_FUNC_CD||D.SLP_OFC_CD||D.SLP_ISS_DT||D.SLP_SER_NO" ).append("\n"); 
		query.append("        AND D.AP_CXL_FLG = 'Y'" ).append("\n"); 
		query.append("		AND C.SLP_TP_CD||C.SLP_FUNC_CD||C.SLP_OFC_CD||C.SLP_ISS_DT||C.SLP_SER_NO = X.CSR_NO" ).append("\n"); 
		query.append("        ) AND CSR_USD_AMT >= 100000" ).append("\n"); 
		query.append("    THEN 'F'" ).append("\n"); 
		query.append("    WHEN EXISTS (" ).append("\n"); 
		query.append("        SELECT 'Y'" ).append("\n"); 
		query.append("        FROM FMS_CSUL_SLP A" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO = X.CSR_NO" ).append("\n"); 
		query.append("        AND A.ACCT_CD IN ('954111', '954112', '954113', '956115') " ).append("\n"); 
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
		query.append("            THEN DECODE(NVL(AP_COM_CHECK_CEO_YN_FNC(X.APRO_USR_ID),'X'),'N','P',NVL(AP_COM_CHECK_CEO_YN_FNC(X.APRO_USR_ID),'X')) --P : CEO 올자리에 CEO가 없다는" ).append("\n"); 
		query.append("            ELSE " ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                WHEN DECODE(NVL(AP_COM_CHECK_CEO_YN_FNC(X.APRO_USR_ID),'X'),'N','P',NVL(AP_COM_CHECK_CEO_YN_FNC(X.APRO_USR_ID),'X')) = 'Y'" ).append("\n"); 
		query.append("                THEN 'Y'" ).append("\n"); 
		query.append("                ELSE DECODE(NVL(AP_COM_CHECK_MGR_YN_FNC(X.APRO_USR_ID,@[lgn_usr_id]),'X'),'N','M',NVL(AP_COM_CHECK_MGR_YN_FNC(X.APRO_USR_ID,@[lgn_usr_id]),'X')) --M : 본부장직급 올자리에 본부장직급이 없다는" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("        WHEN (ACCT_XCH_RT_YRMON IS NOT NULL AND CSR_USD_AMT IS NULL) OR (ACCT_XCH_RT_YRMON IS NULL AND CSR_USD_AMT IS NOT NULL)        " ).append("\n"); 
		query.append("        THEN 'E'" ).append("\n"); 
		query.append("        ELSE 'X'" ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append("    END CHK_VAL_YN" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO  CSR_NO" ).append("\n"); 
		query.append("        , A.CSR_DESC" ).append("\n"); 
		query.append("        , A.EFF_DT" ).append("\n"); 
		query.append("        , A.CSR_USR_ID" ).append("\n"); 
		query.append("        , A.RQST_AMT" ).append("\n"); 
		query.append("        , SUBSTR(A.EFF_DT, 1, 6) ACCT_XCH_RT_YRMON        " ).append("\n"); 
		query.append("        ,(NVL(A.RQST_AMT / DECODE(A.CSR_CURR_CD, 'USD', 1, " ).append("\n"); 
		query.append("          (SELECT NVL(EX1.USD_LOCL_XCH_RT, 1) " ).append("\n"); 
		query.append("             FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("           WHERE A.CSR_CURR_CD = EX1.CURR_CD " ).append("\n"); 
		query.append("             AND EX1.ACCT_XCH_RT_YRMON = SUBSTR(A.EFF_DT, 1, 6)" ).append("\n"); 
		query.append("             AND EX1.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("            )),0)) CSR_USD_AMT               " ).append("\n"); 
		query.append("        , COUNT(R.APRO_RQST_SEQ) OVER (PARTITION BY R.APRO_RQST_NO) KNT" ).append("\n"); 
		query.append("        , DENSE_RANK() OVER (PARTITION BY R.APRO_RQST_NO ORDER BY R.APRO_RQST_SEQ DESC) RNK" ).append("\n"); 
		query.append("        , MAX(R.APRO_RQST_SEQ) OVER (PARTITION BY R.APRO_RQST_NO) MAX_APRO_SEQ        " ).append("\n"); 
		query.append("        , R.APRO_RQST_NO" ).append("\n"); 
		query.append("        , R.APRO_RQST_SEQ" ).append("\n"); 
		query.append("        , R.APRO_USR_ID" ).append("\n"); 
		query.append("        , R.APRO_USR_NM" ).append("\n"); 
		query.append("    FROM FMS_CONSULTATION A, COM_APRO_RQST_HDR H, COM_APRO_CSR_DTL D, COM_APRO_RQST_ROUT R " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO = D.CSR_NO" ).append("\n"); 
		query.append("    AND H.APRO_RQST_NO = D.APRO_RQST_NO" ).append("\n"); 
		query.append("    AND H.APRO_RQST_NO = R.APRO_RQST_NO" ).append("\n"); 
		query.append("    AND A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE RNK = 1" ).append("\n"); 

	}
}