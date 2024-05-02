/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ComCsrApprovalDBDAOPrintComCsrHeaderInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.08 
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

public class ComCsrApprovalDBDAOPrintComCsrHeaderInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 그룹웨어 전송 Header Info
	  * </pre>
	  */
	public ComCsrApprovalDBDAOPrintComCsrHeaderInfoRSQL(){
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
		query.append("Path : com.hanjin.bizcommon.csr.csrapproval.integration").append("\n"); 
		query.append("FileName : ComCsrApprovalDBDAOPrintComCsrHeaderInfoRSQL").append("\n"); 
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
		query.append("SELECT INV_DESC SUBJECT" ).append("\n"); 
		query.append("       ,'' VATREGISTNO" ).append("\n"); 
		query.append("       ,TO_CHAR(SYSDATE,'YYYY/MM/DD') CSRDATE" ).append("\n"); 
		query.append("       ,CSR_NO" ).append("\n"); 
		query.append("       ,TJ_OFC_CD OFFICE" ).append("\n"); 
		query.append("       ,ATTR_CTNT10 PRPD_BY" ).append("\n"); 
		query.append("       ,'' BUDGET" ).append("\n"); 
		query.append("       ,'' PERFORMANCE" ).append("\n"); 
		query.append("       ,'' RATIO" ).append("\n"); 
		query.append("       ,(SELECT DECODE(VNDR_CNT_CD" ).append("\n"); 
		query.append("                    ,'KR',VNDR_LOCL_LANG_NM " ).append("\n"); 
		query.append("                    ,VNDR_LGL_ENG_NM)" ).append("\n"); 
		query.append("       FROM    MDM_VENDOR" ).append("\n"); 
		query.append("       WHERE   VNDR_SEQ = VNDR_NO" ).append("\n"); 
		query.append("       ) PAY_TO" ).append("\n"); 
		query.append("       ,INV_DESC DESCRIPTION" ).append("\n"); 
		query.append("       ,ATTR_CATE_NM EVIDENCE" ).append("\n"); 
		query.append("       ,NVL((" ).append("\n"); 
		query.append("            SELECT COUNT(DISTINCT A.ATTR_CTNT1)" ).append("\n"); 
		query.append("            FROM AP_INV_HDR B, AP_INV_DTRB A " ).append("\n"); 
		query.append("            WHERE B.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("            AND B.CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append("            AND (B.CSR_NO, B.VNDR_NO, A.ATTR_CTNT1) IN (" ).append("\n"); 
		query.append("                SELECT T.CSR_NO, T.VNDR_SEQ, T.INV_NO FROM AP_PAY_INV T " ).append("\n"); 
		query.append("                WHERE T.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("                AND NVL(T.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            ),0) QTY" ).append("\n"); 
		query.append("       ,SUBSTR(INV_DT,1,4)||'/'||SUBSTR(INV_DT,5,2)||'/'||SUBSTR(INV_DT,7,2) INVOICE_DATE" ).append("\n"); 
		query.append("       ,SUBSTR(H.INV_TERM_DT, 1, 4) ||'/' ||SUBSTR(H.INV_TERM_DT, 5, 2) ||'/' ||SUBSTR(H.INV_TERM_DT, 7, 2) DUE_DATE" ).append("\n"); 
		query.append("       ,'' AR_OFFSET_NO" ).append("\n"); 
		query.append("       ,CSR_TP_CD CSR_TYPE" ).append("\n"); 
		query.append("       ,PAY_GRP_LU_CD PAY_GROUP" ).append("\n"); 
		query.append("       ,CASE WHEN (" ).append("\n"); 
		query.append("                      CSR_AMT = 0" ).append("\n"); 
		query.append("                        AND ATTR_CTNT2 IS NOT NULL" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("             THEN SUBSTR(ATTR_CTNT2,1,3)||SUBSTR(ATTR_CTNT2,8,3)||SUBSTR(ATTR_CTNT2,4,4)" ).append("\n"); 
		query.append("        END AS ASA_NO" ).append("\n"); 
		query.append("       ,CSR_CURR_CD CURRENCY" ).append("\n"); 
		query.append("       ,CASE WHEN (CSR_AMT BETWEEN -0.999 AND -0.001) OR (CSR_AMT BETWEEN 0.001 AND 0.999) THEN TO_CHAR(CSR_AMT,'FM9990D999')" ).append("\n"); 
		query.append("             WHEN CSR_AMT = 0 THEN '0'" ).append("\n"); 
		query.append("             ELSE RTRIM(TO_CHAR(CSR_AMT, 'FM999,999,999,999.999'), '.')" ).append("\n"); 
		query.append("        END AMOUNT" ).append("\n"); 
		query.append("       ,DECODE(PAY_DT,'','',PAY_AMT) PYMT_AMT" ).append("\n"); 
		query.append("	   ,APRO_USR_JB_TIT_CD APR_LINE" ).append("\n"); 
		query.append("FROM   AP_INV_HDR H" ).append("\n"); 
		query.append("     , MDM_VENDOR V" ).append("\n"); 
		query.append("WHERE  H.VNDR_NO = V.VNDR_SEQ" ).append("\n"); 
		query.append("   AND CSR_NO    = @[csr_no]" ).append("\n"); 

	}
}