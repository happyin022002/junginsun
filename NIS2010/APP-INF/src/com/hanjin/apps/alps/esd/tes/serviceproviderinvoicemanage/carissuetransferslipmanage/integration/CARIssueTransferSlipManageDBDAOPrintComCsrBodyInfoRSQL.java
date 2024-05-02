/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOPrintComCsrBodyInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : 이 용 호
*@LastVersion : 1.0
* 2014.12.18 이 용 호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOPrintComCsrBodyInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 그룹웨어 전송 Body Info
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOPrintComCsrBodyInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOPrintComCsrBodyInfoRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM L_SEQ, R.* " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT Chart_of_Account L_COA," ).append("\n"); 
		query.append("    	   Account_Name L_ACCOUNT_NAME," ).append("\n"); 
		query.append("    	   GL_Date L_GL_DATE," ).append("\n"); 
		query.append("    	   City L_CITY," ).append("\n"); 
		query.append("    	   Invoice_NO L_VENDOR_INV_NO," ).append("\n"); 
		query.append("    	   Description L_DESCRIPTION," ).append("\n"); 
		query.append("    	   Debit L_DEBIT_AMT," ).append("\n"); 
		query.append("    	   Credit L_CREDIT_AMT" ).append("\n"); 
		query.append("    FROM ( SELECT Chart_of_Account, Account_Name, GL_Date, City, Invoice_NO, Description, Debit, Credit" ).append("\n"); 
		query.append("    	   FROM ( SELECT D.DTRB_COA_CO_CD||'.'||D.DTRB_COA_RGN_CD||'.'||D.DTRB_COA_CTR_CD||'.'||D.DTRB_COA_ACCT_CD||'.'||" ).append("\n"); 
		query.append("    					 D.DTRB_COA_INTER_CO_CD||'.'||D.DTRB_COA_VVD_CD Chart_of_Account," ).append("\n"); 
		query.append("    					 (SELECT ACCT_ENG_NM FROM MDM_ACCOUNT WHERE  ACCT_CD = D.DTRB_COA_ACCT_CD) Account_Name," ).append("\n"); 
		query.append("    					 substr(H.GL_DT,1,4)||'/'||substr(H.GL_DT,5,2)||'/'||substr(H.GL_DT,7,2) GL_Date," ).append("\n"); 
		query.append("    					 D.ATTR_CTNT3 City," ).append("\n"); 
		query.append("    					 D.ATTR_CTNT1 Invoice_NO," ).append("\n"); 
		query.append("    					 D.INV_DESC Description," ).append("\n"); 
		query.append("    					 TO_CHAR(ROUND(SUM(D.INV_AMT),2)) Debit," ).append("\n"); 
		query.append("    					 '' Credit," ).append("\n"); 
		query.append("    					 D.LINE_NO NO" ).append("\n"); 
		query.append("    			  FROM   AP_INV_HDR H, AP_INV_DTRB D" ).append("\n"); 
		query.append("    			  WHERE  H.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("    			  AND    H.CSR_NO = D.CSR_NO" ).append("\n"); 
		query.append("    			  GROUP BY D.DTRB_COA_CO_CD, D.DTRB_COA_RGN_CD, D.DTRB_COA_CTR_CD, D.DTRB_COA_ACCT_CD, D.DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("    					   D.DTRB_COA_VVD_CD, D.INV_DESC, H.GL_DT, D.ATTR_CTNT3, D.ATTR_CTNT1, D.LINE_NO )" ).append("\n"); 
		query.append("    	   ORDER BY NO ASC )" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COA_CO_CD||'.'||COA_RGN_CD||'.'||COA_CTR_CD||'.'||COA_ACCT_CD||'.'||" ).append("\n"); 
		query.append("    	   COA_INTER_CO_CD||'.'||COA_VVD_CD Chart_of_Account," ).append("\n"); 
		query.append("    	   ( SELECT ACCT_ENG_NM" ).append("\n"); 
		query.append("    		 FROM   MDM_ACCOUNT" ).append("\n"); 
		query.append("    		 WHERE  ACCT_CD = COA_ACCT_CD )  Account_Name," ).append("\n"); 
		query.append("    	   substr(GL_DT,1,4)||'/'||substr(GL_DT,5,2)||'/'||substr(GL_DT,7,2) GL_Date," ).append("\n"); 
		query.append("    	   '' City," ).append("\n"); 
		query.append("    	   '' Invoice_NO," ).append("\n"); 
		query.append("    	   INV_DESC Description," ).append("\n"); 
		query.append("    	   '' Debit," ).append("\n"); 
		query.append("    	   TO_CHAR(ROUND(H.CSR_AMT,2)) Credit" ).append("\n"); 
		query.append("    FROM   AP_INV_HDR H" ).append("\n"); 
		query.append("    WHERE  H.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("    ) R" ).append("\n"); 
		query.append("WHERE ROWNUM <= 6" ).append("\n"); 

	}
}