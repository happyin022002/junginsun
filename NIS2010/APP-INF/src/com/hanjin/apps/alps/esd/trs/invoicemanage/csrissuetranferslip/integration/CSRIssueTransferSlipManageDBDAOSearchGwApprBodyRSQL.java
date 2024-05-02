/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSearchGwApprBodyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOSearchGwApprBodyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * G/W Approval I/F Body 조회
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOSearchGwApprBodyRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOSearchGwApprBodyRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM L_SEQ" ).append("\n"); 
		query.append("      ,L_COA" ).append("\n"); 
		query.append("      ,L_ACCOUNT_NAME" ).append("\n"); 
		query.append("      ,L_GL_DATE" ).append("\n"); 
		query.append("      ,L_CITY" ).append("\n"); 
		query.append("      ,L_VENDOR_INV_NO" ).append("\n"); 
		query.append("      ,L_DESCRIPTION" ).append("\n"); 
		query.append("      ,L_DEBIT_AMT" ).append("\n"); 
		query.append("      ,L_CREDIT_AMT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT L_COA" ).append("\n"); 
		query.append("              ,L_ACCOUNT_NAME" ).append("\n"); 
		query.append("              ,L_GL_DATE" ).append("\n"); 
		query.append("              ,L_CITY" ).append("\n"); 
		query.append("              ,L_VENDOR_INV_NO" ).append("\n"); 
		query.append("              ,L_DESCRIPTION" ).append("\n"); 
		query.append("              ,CASE WHEN (L_DEBIT_AMT BETWEEN -0.999 AND -0.001) OR (L_DEBIT_AMT BETWEEN 0.001 AND 0.999) THEN TO_CHAR(L_DEBIT_AMT,'FM9990D999')" ).append("\n"); 
		query.append("                    WHEN L_DEBIT_AMT = 0 THEN '0'" ).append("\n"); 
		query.append("                    ELSE RTRIM(TO_CHAR(L_DEBIT_AMT, 'FM999,999,999,999.999'), '.')" ).append("\n"); 
		query.append("               END L_DEBIT_AMT" ).append("\n"); 
		query.append("              ,CASE WHEN (L_CREDIT_AMT BETWEEN -0.999 AND -0.001) OR (L_CREDIT_AMT BETWEEN 0.001 AND 0.999) THEN TO_CHAR(L_CREDIT_AMT,'FM9990D999')" ).append("\n"); 
		query.append("                    WHEN L_CREDIT_AMT = 0 THEN '0'" ).append("\n"); 
		query.append("                    ELSE RTRIM(TO_CHAR(L_CREDIT_AMT, 'FM999,999,999,999.999'), '.')" ).append("\n"); 
		query.append("               END L_CREDIT_AMT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT D.DTRB_COA_CO_CD||'.'||D.DTRB_COA_RGN_CD||'.'||D.DTRB_COA_CTR_CD||'.'||D.DTRB_COA_ACCT_CD||'.'||D.DTRB_COA_INTER_CO_CD||'.'||D.DTRB_COA_VVD_CD AS L_COA" ).append("\n"); 
		query.append("                      ,(SELECT ACCT_ENG_NM FROM  MDM_ACCOUNT WHERE ACCT_CD = D.DTRB_COA_ACCT_CD) AS L_ACCOUNT_NAME" ).append("\n"); 
		query.append("                      ,TO_CHAR(TO_DATE(GL_DT,'YYYYMMDD'),'YYYY/MM/DD') L_GL_DATE" ).append("\n"); 
		query.append("                      ,D.ATTR_CTNT3 AS L_CITY" ).append("\n"); 
		query.append("                      ,D.ATTR_CTNT1 AS L_VENDOR_INV_NO" ).append("\n"); 
		query.append("                      ,D.INV_DESC AS L_DESCRIPTION" ).append("\n"); 
		query.append("                      ,SUM( ROUND(D.INV_AMT,2) ) AS L_DEBIT_AMT" ).append("\n"); 
		query.append("                      ,0 AS L_CREDIT_AMT" ).append("\n"); 
		query.append("                      ,D.LINE_NO AS NO" ).append("\n"); 
		query.append("                      ,'1' TP" ).append("\n"); 
		query.append("                  FROM AP_INV_HDR  H" ).append("\n"); 
		query.append("                      ,AP_INV_DTRB D" ).append("\n"); 
		query.append("                 WHERE H.CSR_NO = D.CSR_NO" ).append("\n"); 
		query.append("                   AND H.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("                GROUP BY D.DTRB_COA_CO_CD" ).append("\n"); 
		query.append("                        ,D.DTRB_COA_RGN_CD" ).append("\n"); 
		query.append("                        ,D.DTRB_COA_CTR_CD" ).append("\n"); 
		query.append("                        ,D.DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append("                        ,D.DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append("                        ,D.DTRB_COA_VVD_CD" ).append("\n"); 
		query.append("                        ,D.INV_DESC" ).append("\n"); 
		query.append("                        ,H.GL_DT" ).append("\n"); 
		query.append("                        ,D.ATTR_CTNT3" ).append("\n"); 
		query.append("                        ,D.ATTR_CTNT1" ).append("\n"); 
		query.append("                        ,D.LINE_NO" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT COA_CO_CD||'.'||COA_RGN_CD||'.'||COA_CTR_CD||'.'||COA_ACCT_CD||'.'||COA_INTER_CO_CD||'.'||COA_VVD_CD L_COA" ).append("\n"); 
		query.append("                       ,(SELECT ACCT_ENG_NM" ).append("\n"); 
		query.append("                           FROM MDM_ACCOUNT X" ).append("\n"); 
		query.append("                          WHERE ACCT_CD = H.COA_ACCT_CD ) L_ACCOUNT_NAME" ).append("\n"); 
		query.append("                       ,TO_CHAR(TO_DATE(GL_DT,'YYYYMMDD'),'YYYY/MM/DD') AS L_GL_DATE" ).append("\n"); 
		query.append("                       ,''                                              AS L_CITY" ).append("\n"); 
		query.append("                       ,''                                              AS L_VENDOR_INV_NO" ).append("\n"); 
		query.append("                       ,INV_DESC                                        AS L_DESCRIPTION" ).append("\n"); 
		query.append("                       ,0                                               AS L_DEBIT_AMT" ).append("\n"); 
		query.append("                       ,ROUND(H.CSR_AMT,2)                              AS L_CREDIT_AMT" ).append("\n"); 
		query.append("                       ,999 AS NO" ).append("\n"); 
		query.append("                       ,'2' TP" ).append("\n"); 
		query.append("                  FROM AP_INV_HDR H" ).append("\n"); 
		query.append("                 WHERE H.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        ORDER BY L_VENDOR_INV_NO, NO ASC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM < 7" ).append("\n"); 

	}
}