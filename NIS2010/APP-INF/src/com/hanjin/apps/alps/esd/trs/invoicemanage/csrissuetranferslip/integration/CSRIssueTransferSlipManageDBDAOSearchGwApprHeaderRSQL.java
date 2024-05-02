/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSearchGwApprHeaderRSQL.java
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

public class CSRIssueTransferSlipManageDBDAOSearchGwApprHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * G/W Approval I/F Header 조회
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOSearchGwApprHeaderRSQL(){
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
		query.append("FileName : CSRIssueTransferSlipManageDBDAOSearchGwApprHeaderRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(DESCRIPTION,1,250) AS SUBJECT" ).append("\n"); 
		query.append("      ,VATREGISTNO" ).append("\n"); 
		query.append("      ,CSRDATE" ).append("\n"); 
		query.append("      ,CSR_NO" ).append("\n"); 
		query.append("      ,OFFICE" ).append("\n"); 
		query.append("      ,PRPD_BY" ).append("\n"); 
		query.append("      ,BUDGET" ).append("\n"); 
		query.append("      ,PERFORMANCE" ).append("\n"); 
		query.append("      ,RATIO" ).append("\n"); 
		query.append("      ,PAY_TO" ).append("\n"); 
		query.append("      ,DESCRIPTION" ).append("\n"); 
		query.append("      ,EVIDENCE" ).append("\n"); 
		query.append("      ,QTY" ).append("\n"); 
		query.append("      ,INVOICE_DATE" ).append("\n"); 
		query.append("      ,DUE_DATE" ).append("\n"); 
		query.append("      ,AR_OFFSET_NO" ).append("\n"); 
		query.append("      ,CSR_TYPE" ).append("\n"); 
		query.append("      ,PAY_GROUP" ).append("\n"); 
		query.append("      ,ASA_NO" ).append("\n"); 
		query.append("      ,CURRENCY" ).append("\n"); 
		query.append("      -- ,AMOUNT" ).append("\n"); 
		query.append("      -- ,PYMT_AMT" ).append("\n"); 
		query.append("      ,CASE WHEN (AMOUNT BETWEEN -0.999 AND -0.001) OR (AMOUNT BETWEEN 0.001 AND 0.999) THEN TO_CHAR(AMOUNT,'FM9990D999')" ).append("\n"); 
		query.append("            WHEN AMOUNT = 0 THEN '0'" ).append("\n"); 
		query.append("            ELSE RTRIM(TO_CHAR(AMOUNT, 'FM999,999,999,999.999'), '.')" ).append("\n"); 
		query.append("       END AMOUNT" ).append("\n"); 
		query.append("      ,CASE WHEN (PYMT_AMT BETWEEN -0.999 AND -0.001) OR (PYMT_AMT BETWEEN 0.001 AND 0.999) THEN TO_CHAR(PYMT_AMT,'FM9990D999')" ).append("\n"); 
		query.append("            WHEN PYMT_AMT = 0 THEN '0'" ).append("\n"); 
		query.append("            ELSE RTRIM(TO_CHAR(PYMT_AMT, 'FM999,999,999,999.999'), '.')" ).append("\n"); 
		query.append("       END PYMT_AMT " ).append("\n"); 
		query.append("      ,APR_LINE" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("(SELECT INV_DESC AS SUBJECT" ).append("\n"); 
		query.append("       ,'' AS VATREGISTNO" ).append("\n"); 
		query.append("       ,TO_CHAR(SYSDATE, 'YYYY/MM/DD') AS CSRDATE" ).append("\n"); 
		query.append("       ,CSR_NO AS CSR_NO" ).append("\n"); 
		query.append("       ,TJ_OFC_CD AS OFFICE" ).append("\n"); 
		query.append("       ,ATTR_CTNT10 AS PRPD_BY" ).append("\n"); 
		query.append("       ,'' BUDGET" ).append("\n"); 
		query.append("       ,'' PERFORMANCE" ).append("\n"); 
		query.append("       ,'' RATIO" ).append("\n"); 
		query.append("       ,INV_DESC AS PAY_TO" ).append("\n"); 
		query.append("       ,(SELECT DTRB.INV_DESC" ).append("\n"); 
		query.append("           FROM (SELECT D.INV_DESC" ).append("\n"); 
		query.append("                   FROM AP_INV_DTRB    D" ).append("\n"); 
		query.append("                  WHERE D.CSR_NO   = @[csr_no]" ).append("\n"); 
		query.append("                  ORDER BY D.INV_AMT DESC" ).append("\n"); 
		query.append("                 ) DTRB" ).append("\n"); 
		query.append("          WHERE ROWNUM < 2" ).append("\n"); 
		query.append("        ) DESCRIPTION" ).append("\n"); 
		query.append("       ,ATTR_CATE_NM AS EVIDENCE" ).append("\n"); 
		query.append("       ,(SELECT SUM(CNT) " ).append("\n"); 
		query.append("           FROM (SELECT COUNT(INV_NO) CNT" ).append("\n"); 
		query.append("                   FROM TRS_TRSP_INV_WRK" ).append("\n"); 
		query.append("                  WHERE CSR_NO    = @[csr_no]" ).append("\n"); 
		query.append("                  UNION ALL" ).append("\n"); 
		query.append("                 SELECT COUNT(INV_NO) CNT" ).append("\n"); 
		query.append("                   FROM TRS_TRSP_RAIL_INV_WRK" ).append("\n"); 
		query.append("                  WHERE CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        ) AS QTY" ).append("\n"); 
		query.append("       ,SUBSTR(INV_DT,1,4)||'/'||SUBSTR(INV_DT,5,2)||'/'||SUBSTR(INV_DT,7,2) AS INVOICE_DATE" ).append("\n"); 
		query.append("       ,SUBSTR(INV_TERM_DT,1,4)||'/'||SUBSTR(INV_TERM_DT,5,2)||'/'||SUBSTR(INV_TERM_DT,7,2) AS DUE_DATE" ).append("\n"); 
		query.append("       ,'' AR_OFFSET_NO" ).append("\n"); 
		query.append("       ,CSR_TP_CD AS CSR_TYPE" ).append("\n"); 
		query.append("       ,PAY_GRP_LU_CD AS PAY_GROUP" ).append("\n"); 
		query.append("       ,CASE WHEN CSR_AMT = 0 AND ATTR_CTNT2 IS NOT NULL THEN ATTR_CTNT2" ).append("\n"); 
		query.append("        END ASA_NO" ).append("\n"); 
		query.append("       ,CSR_CURR_CD AS CURRENCY" ).append("\n"); 
		query.append("       ,CSR_AMT AS AMOUNT" ).append("\n"); 
		query.append("       ,PAY_AMT AS PYMT_AMT" ).append("\n"); 
		query.append("       ,APRO_USR_JB_TIT_CD APR_LINE" ).append("\n"); 
		query.append("   FROM AP_INV_HDR A" ).append("\n"); 
		query.append("  WHERE A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}