/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ArApprovalDBDAOPrintArCsrBodyInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.16
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.01.16 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArApprovalDBDAOPrintArCsrBodyInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * groupware 전송 xmlData Body info
	  * </pre>
	  */
	public ArApprovalDBDAOPrintArCsrBodyInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.integration").append("\n"); 
		query.append("FileName : ArApprovalDBDAOPrintArCsrBodyInfoRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM L_SEQ, R.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    CHR_OF_ACCT L_COA" ).append("\n"); 
		query.append("    ,ACCT_ENG_NM L_ACCOUNT_NAME" ).append("\n"); 
		query.append("    ,DECODE(LENGTH(EFF_DT),8,SUBSTR(EFF_DT,0,4) || '/' || SUBSTR(EFF_DT,5,2) || '/' || SUBSTR(EFF_DT,7,2),EFF_DT) AS L_GL_DATE" ).append("\n"); 
		query.append("    ,SLP_LOC_CD L_CITY" ).append("\n"); 
		query.append("    ,TO_INV_NO L_VENDOR_INV_NO" ).append("\n"); 
		query.append("    ,CSR_DESC L_DESCRIPTION" ).append("\n"); 
		query.append("    ,DECODE(DR_AMT,'0',NULL,TO_CHAR(DR_AMT,'FM999,999,999,990.00')) AS L_DEBIT_AMT" ).append("\n"); 
		query.append("    ,DECODE(CR_AMT,'0',NULL,TO_CHAR(CR_AMT,'FM999,999,999,990.00')) AS L_CREDIT_AMT" ).append("\n"); 
		query.append("  FROM (SELECT 1 NUM," ).append("\n"); 
		query.append("               A.EFF_DT," ).append("\n"); 
		query.append("               B.SLP_LOC_CD," ).append("\n"); 
		query.append("               B.CSR_DESC," ).append("\n"); 
		query.append("               B.TO_INV_NO," ).append("\n"); 
		query.append("               '01' || '.' || C.FINC_RGN_CD || '.' || B.CTR_CD || '.' || B.ACCT_CD || '.' || '00' || '.' ||" ).append("\n"); 
		query.append("               NVL(VSL_CD || SKD_VOY_NO || SKD_DIR_CD || REV_DIR_CD,'0000000000') CHR_OF_ACCT," ).append("\n"); 
		query.append("               D.ACCT_ENG_NM," ).append("\n"); 
		query.append("               B.CSR_AMT DR_AMT," ).append("\n"); 
		query.append("               0 CR_AMT" ).append("\n"); 
		query.append("          FROM FMS_CONSULTATION A," ).append("\n"); 
		query.append("               FMS_CSUL_SLP B," ).append("\n"); 
		query.append("               MDM_ORGANIZATION C," ).append("\n"); 
		query.append("               MDM_ACCOUNT D" ).append("\n"); 
		query.append("         WHERE A.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("           AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("           AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("           AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("           AND A.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("           AND SUBSTR(@[csr_no],1,2) = A.SLP_TP_CD" ).append("\n"); 
		query.append("           AND SUBSTR(@[csr_no],3,1) = A.SLP_FUNC_CD" ).append("\n"); 
		query.append("           AND SUBSTR(@[csr_no],4,6) = A.SLP_OFC_CD" ).append("\n"); 
		query.append("           AND SUBSTR(@[csr_no],10,6) = A.SLP_ISS_DT" ).append("\n"); 
		query.append("           AND SUBSTR(@[csr_no],16,5) = A.SLP_SER_NO" ).append("\n"); 
		query.append("           AND A.SLP_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("           AND B.ACCT_CD = D.ACCT_CD" ).append("\n"); 
		query.append("           AND B.FLET_SRC_TP_CD = 'R1'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 2 NUM," ).append("\n"); 
		query.append("               A.EFF_DT," ).append("\n"); 
		query.append("               B.SLP_LOC_CD," ).append("\n"); 
		query.append("               B.CSR_DESC," ).append("\n"); 
		query.append("               B.TO_INV_NO," ).append("\n"); 
		query.append("               '01' || '.' || C.FINC_RGN_CD || '.' || B.CTR_CD || '.' || B.ACCT_CD || '.' || '00' || '.' ||" ).append("\n"); 
		query.append("               NVL(VSL_CD || SKD_VOY_NO || SKD_DIR_CD || REV_DIR_CD,'0000000000')  CHR_OF_ACCT," ).append("\n"); 
		query.append("               D.ACCT_ENG_NM," ).append("\n"); 
		query.append("               0 DR_AMT," ).append("\n"); 
		query.append("               B.CSR_AMT CR_AMT" ).append("\n"); 
		query.append("          FROM FMS_CONSULTATION A," ).append("\n"); 
		query.append("               FMS_CSUL_SLP B," ).append("\n"); 
		query.append("               MDM_ORGANIZATION C," ).append("\n"); 
		query.append("               MDM_ACCOUNT D" ).append("\n"); 
		query.append("         WHERE A.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("           AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("           AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("           AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("           AND A.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("           AND SUBSTR(@[csr_no],1,2) = A.SLP_TP_CD" ).append("\n"); 
		query.append("           AND SUBSTR(@[csr_no],3,1) = A.SLP_FUNC_CD" ).append("\n"); 
		query.append("           AND SUBSTR(@[csr_no],4,6) = A.SLP_OFC_CD" ).append("\n"); 
		query.append("           AND SUBSTR(@[csr_no],10,6) = A.SLP_ISS_DT" ).append("\n"); 
		query.append("           AND SUBSTR(@[csr_no],16,5) = A.SLP_SER_NO" ).append("\n"); 
		query.append("           AND A.SLP_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("           AND B.ACCT_CD = D.ACCT_CD" ).append("\n"); 
		query.append("           AND B.FLET_SRC_TP_CD = 'R6'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 1 NUM," ).append("\n"); 
		query.append("               A.EFF_DT," ).append("\n"); 
		query.append("               B.SLP_LOC_CD," ).append("\n"); 
		query.append("               B.CSR_DESC," ).append("\n"); 
		query.append("               B.TO_INV_NO," ).append("\n"); 
		query.append("               '01' || '.' || C.FINC_RGN_CD || '.' || B.CTR_CD || '.' || B.ACCT_CD || '.' || '00' || '.' ||" ).append("\n"); 
		query.append("               NVL(VSL_CD || SKD_VOY_NO || SKD_DIR_CD || REV_DIR_CD,'0000000000') CHR_OF_ACCT," ).append("\n"); 
		query.append("               D.ACCT_ENG_NM," ).append("\n"); 
		query.append("               B.CSR_AMT DR_AMT," ).append("\n"); 
		query.append("               0 CR_AMT" ).append("\n"); 
		query.append("          FROM FMS_CONSULTATION A," ).append("\n"); 
		query.append("               FMS_CSUL_SLP B," ).append("\n"); 
		query.append("               MDM_ORGANIZATION C," ).append("\n"); 
		query.append("               MDM_ACCOUNT D" ).append("\n"); 
		query.append("         WHERE A.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("           AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("           AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("           AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("           AND A.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("           AND SUBSTR(@[csr_no],1,2) = A.SLP_TP_CD" ).append("\n"); 
		query.append("           AND SUBSTR(@[csr_no],3,1) = A.SLP_FUNC_CD" ).append("\n"); 
		query.append("           AND SUBSTR(@[csr_no],4,6) = A.SLP_OFC_CD" ).append("\n"); 
		query.append("           AND SUBSTR(@[csr_no],10,6) = A.SLP_ISS_DT" ).append("\n"); 
		query.append("           AND SUBSTR(@[csr_no],16,5) = A.SLP_SER_NO" ).append("\n"); 
		query.append("           AND A.SLP_TP_CD <> '20'" ).append("\n"); 
		query.append("           AND A.SLP_FUNC_CD <> 'T'" ).append("\n"); 
		query.append("           AND A.SLP_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("           AND B.ACCT_CD = D.ACCT_CD" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT NUM," ).append("\n"); 
		query.append("        EFF_DT," ).append("\n"); 
		query.append("        SLP_LOC_CD," ).append("\n"); 
		query.append("        CSR_DESC," ).append("\n"); 
		query.append("        TO_INV_NO," ).append("\n"); 
		query.append("        CHR_OF_ACCT," ).append("\n"); 
		query.append("        ACCT_ENG_NM," ).append("\n"); 
		query.append("        DR_AMT," ).append("\n"); 
		query.append("        SUM(CR_AMT) CR_AMT" ).append("\n"); 
		query.append("          FROM (SELECT 2 NUM," ).append("\n"); 
		query.append("         A.EFF_DT," ).append("\n"); 
		query.append("         (SELECT LOC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = SUBSTR(@[csr_no],4,6)) SLP_LOC_CD," ).append("\n"); 
		query.append("         A.CSR_DESC," ).append("\n"); 
		query.append("         B.TO_INV_NO," ).append("\n"); 
		query.append("         '01' || '.' || C.FINC_RGN_CD || '.' || (SELECT AP_CTR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = SUBSTR(@[csr_no],4,6)) || '.' || '210111' || '.' || '00' || '.' || '0000000000' CHR_OF_ACCT," ).append("\n"); 
		query.append("         (SELECT ACCT_ENG_NM FROM MDM_ACCOUNT WHERE ACCT_CD = '210111') ACCT_ENG_NM," ).append("\n"); 
		query.append("         0 DR_AMT," ).append("\n"); 
		query.append("         NVL(B.CSR_AMT,0) CR_AMT" ).append("\n"); 
		query.append("    FROM FMS_CONSULTATION A," ).append("\n"); 
		query.append("         FMS_CSUL_SLP B," ).append("\n"); 
		query.append("         MDM_ORGANIZATION C" ).append("\n"); 
		query.append("   WHERE A.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("     AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("     AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("     AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("     AND A.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("     AND SUBSTR(@[csr_no],1,2) = A.SLP_TP_CD" ).append("\n"); 
		query.append("     AND SUBSTR(@[csr_no],3,1) = A.SLP_FUNC_CD" ).append("\n"); 
		query.append("     AND SUBSTR(@[csr_no],4,6) = A.SLP_OFC_CD" ).append("\n"); 
		query.append("     AND SUBSTR(@[csr_no],10,6) = A.SLP_ISS_DT" ).append("\n"); 
		query.append("     AND SUBSTR(@[csr_no],16,5) = A.SLP_SER_NO" ).append("\n"); 
		query.append("     AND A.SLP_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("     AND A.SLP_TP_CD <> '20'" ).append("\n"); 
		query.append("     AND A.SLP_FUNC_CD <> 'T')" ).append("\n"); 
		query.append("              GROUP BY NUM, EFF_DT, SLP_LOC_CD, CSR_DESC, TO_INV_NO, CHR_OF_ACCT, ACCT_ENG_NM, DR_AMT)" ).append("\n"); 
		query.append(" ORDER BY NUM, TO_INV_NO" ).append("\n"); 
		query.append(") R" ).append("\n"); 
		query.append("WHERE ROWNUM <= 6" ).append("\n"); 

	}
}