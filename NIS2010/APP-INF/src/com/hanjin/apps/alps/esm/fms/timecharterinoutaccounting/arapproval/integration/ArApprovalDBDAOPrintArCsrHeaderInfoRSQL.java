/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ArApprovalDBDAOPrintArCsrHeaderInfoRSQL.java
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

public class ArApprovalDBDAOPrintArCsrHeaderInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * groupware 전송 xmlData Header info
	  * </pre>
	  */
	public ArApprovalDBDAOPrintArCsrHeaderInfoRSQL(){
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
		query.append("FileName : ArApprovalDBDAOPrintArCsrHeaderInfoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("        A.CSR_DESC AS SUBJECT" ).append("\n"); 
		query.append("       ,'' VATREGISTNO" ).append("\n"); 
		query.append("       ,TO_CHAR(SYSDATE,'YYYY/MM/DD') CSRDATE" ).append("\n"); 
		query.append("       ,(A.SLP_TP_CD || A.SLP_FUNC_CD || A.SLP_OFC_CD || A.SLP_ISS_DT || A.SLP_SER_NO) CSR_NO" ).append("\n"); 
		query.append("       ,A.SLP_OFC_CD OFFICE" ).append("\n"); 
		query.append("       ,D.USR_NM" ).append("\n"); 
		query.append("       ,'' BUDGET" ).append("\n"); 
		query.append("       ,'' PERFORMANCE" ).append("\n"); 
		query.append("       ,'' RATIO" ).append("\n"); 
		query.append("       ,C.CUST_LGL_ENG_NM PAY_TO" ).append("\n"); 
		query.append("       ,A.CSR_DESC DESCRIPTION" ).append("\n"); 
		query.append("       ,'' EVIDENCE" ).append("\n"); 
		query.append("       ,'' QTY" ).append("\n"); 
		query.append("       ,'' INVOICE_DATE" ).append("\n"); 
		query.append("       ,'' DUE_DATE" ).append("\n"); 
		query.append("       ,'' AR_OFFSET_NO" ).append("\n"); 
		query.append("       ,'SALES INVOICES' CSR_TYPE" ).append("\n"); 
		query.append("       ,'' PAY_GROUP" ).append("\n"); 
		query.append("       ,'' ASA_NO" ).append("\n"); 
		query.append("       ,A.CSR_CURR_CD CURRENCY" ).append("\n"); 
		query.append("       ,DECODE(A.RQST_AMT,'0','0.00',TO_CHAR(A.RQST_AMT,'FM999,999,999,990.00')) AS AMOUNT" ).append("\n"); 
		query.append("       ,'' AS PYMT_AMT" ).append("\n"); 
		query.append("       ,'N' APR_LINE" ).append("\n"); 
		query.append("	   ,D.USR_NM AS PRPD_BY" ).append("\n"); 
		query.append("  FROM FMS_CONSULTATION A," ).append("\n"); 
		query.append("       FMS_CSUL_SLP B," ).append("\n"); 
		query.append("       MDM_CUSTOMER C," ).append("\n"); 
		query.append("       MDM_VENDOR E," ).append("\n"); 
		query.append("       COM_USER D" ).append("\n"); 
		query.append(" WHERE A.SLP_TP_CD = B.SLP_TP_CD " ).append("\n"); 
		query.append("   AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("   AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("   AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("   AND A.SLP_SER_NO = B.SLP_SER_NO " ).append("\n"); 
		query.append("   AND SUBSTR(@[csr_no],1,2) = A.SLP_TP_CD" ).append("\n"); 
		query.append("   AND SUBSTR(@[csr_no],3,1) = A.SLP_FUNC_CD" ).append("\n"); 
		query.append("   AND SUBSTR(@[csr_no],4,6) = A.SLP_OFC_CD" ).append("\n"); 
		query.append("   AND SUBSTR(@[csr_no],10,6) = A.SLP_ISS_DT" ).append("\n"); 
		query.append("   AND SUBSTR(@[csr_no],16,5) = A.SLP_SER_NO" ).append("\n"); 
		query.append("   AND B.CUST_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND B.CUST_SEQ = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND B.VNDR_SEQ = E.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.CSR_USR_ID = D.USR_ID" ).append("\n"); 

	}
}