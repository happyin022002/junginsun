/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOPrintComCsrHeaderInfoRSQL.java
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

public class CARIssueTransferSlipManageDBDAOPrintComCsrHeaderInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 그룹웨어 전송 Header Info
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOPrintComCsrHeaderInfoRSQL(){
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
		query.append("FileName : CARIssueTransferSlipManageDBDAOPrintComCsrHeaderInfoRSQL").append("\n"); 
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
		query.append("       ,'' BUDGET " ).append("\n"); 
		query.append("       ,'' PERFORMANCE" ).append("\n"); 
		query.append("       ,'' RATIO" ).append("\n"); 
		query.append("       ,(SELECT DECODE(VNDR_CNT_CD" ).append("\n"); 
		query.append("                    ,'KR',VNDR_LOCL_LANG_NM" ).append("\n"); 
		query.append("                    ,VNDR_LGL_ENG_NM)" ).append("\n"); 
		query.append("       FROM    MDM_VENDOR" ).append("\n"); 
		query.append("       WHERE   VNDR_SEQ = VNDR_NO" ).append("\n"); 
		query.append("       ) PAY_TO" ).append("\n"); 
		query.append("       ,( SELECT (SELECT M.ACCT_ENG_NM FROM MDM_ACCOUNT M WHERE ACCT_CD = DTRB_COA_ACCT_CD)" ).append("\n"); 
		query.append("			FROM (" ).append("\n"); 
		query.append("					SELECT SUM(INV_AMT) SUM_AMT, DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append("					FROM AP_INV_DTRB D WHERE CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("					GROUP BY D.DTRB_COA_CO_CD, D.DTRB_COA_RGN_CD, D.DTRB_COA_CTR_CD, D.DTRB_COA_ACCT_CD, D.DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append("							, D.DTRB_COA_VVD_CD, D.INV_DESC, D.ATTR_CTNT3, D.ATTR_CTNT1, D.LINE_NO" ).append("\n"); 
		query.append("					ORDER BY SUM_AMT DESC" ).append("\n"); 
		query.append("				) A WHERE ROWNUM = 1" ).append("\n"); 
		query.append("		) DESCRIPTION" ).append("\n"); 
		query.append("       ,ATTR_CATE_NM EVIDENCE" ).append("\n"); 
		query.append("       ,NVL((" ).append("\n"); 
		query.append("            SELECT COUNT(DISTINCT A.ATTR_CTNT1)" ).append("\n"); 
		query.append("            FROM AP_INV_HDR B, AP_INV_DTRB A " ).append("\n"); 
		query.append("            WHERE B.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("            AND B.CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append("            AND (B.CSR_NO, B.VNDR_NO, A.ATTR_CTNT1) IN (" ).append("\n"); 
		query.append("                SELECT T.CSR_NO, T.VNDR_SEQ, T.INV_NO FROM TES_TML_SO_HDR T " ).append("\n"); 
		query.append("                WHERE T.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("                AND NVL(T.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            ),0) QTY" ).append("\n"); 
		query.append("       ,SUBSTR(INV_DT,1,4)||'/'||SUBSTR(INV_DT,5,2)||'/'||SUBSTR(INV_DT,7,2) INVOICE_DATE" ).append("\n"); 
		query.append("       ,( SELECT DECODE(SUBSTR(VNDR_TERM_NM,1,1),'O','',TO_CHAR(A.ISS_DT+VNDR_TERM_NM,'YYYY/MM/DD'))" ).append("\n"); 
		query.append("			FROM	(SELECT MAX(ISS_DT) ISS_DT, VNDR_SEQ FROM TES_TML_SO_HDR WHERE CSR_NO = @[csr_no] AND NVL(DELT_FLG,'N') <> 'Y' GROUP BY VNDR_SEQ) A, MDM_VENDOR B" ).append("\n"); 
		query.append("			WHERE A.VNDR_SEQ = B.VNDR_SEQ ) DUE_DATE" ).append("\n"); 
		query.append("       ,'' AR_OFFSET_NO" ).append("\n"); 
		query.append("       ,CSR_TP_CD CSR_TYPE" ).append("\n"); 
		query.append("       ,PAY_GRP_LU_CD PAY_GROUP" ).append("\n"); 
		query.append("       ,CASE WHEN (" ).append("\n"); 
		query.append("                   CSR_AMT = 0" ).append("\n"); 
		query.append("                   AND ATTR_CTNT2 IS NOT NULL" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("             THEN SUBSTR(ATTR_CTNT2,1,3)||SUBSTR(ATTR_CTNT2,8,3)||SUBSTR(ATTR_CTNT2,4,4)" ).append("\n"); 
		query.append("        END AS ASA_NO" ).append("\n"); 
		query.append("       ,CSR_CURR_CD CURRENCY" ).append("\n"); 
		query.append("       ,CASE WHEN (CSR_AMT BETWEEN -0.999 AND -0.001) OR (CSR_AMT BETWEEN 0.001 AND 0.999) THEN TO_CHAR(CSR_AMT,'FM9990D999')" ).append("\n"); 
		query.append("             WHEN CSR_AMT = 0 THEN '0'" ).append("\n"); 
		query.append("             ELSE RTRIM(TO_CHAR(CSR_AMT, 'FM999,999,999,999.999'), '.')" ).append("\n"); 
		query.append("        END AMOUNT" ).append("\n"); 
		query.append("       ,DECODE(PAY_DT,'','',PAY_AMT) PYMT_AMT" ).append("\n"); 
		query.append("       ,APRO_USR_JB_TIT_CD APR_LINE" ).append("\n"); 
		query.append("FROM   AP_INV_HDR H" ).append("\n"); 
		query.append("     , MDM_VENDOR V" ).append("\n"); 
		query.append("WHERE  H.VNDR_NO = V.VNDR_SEQ" ).append("\n"); 
		query.append("  AND  CSR_NO    = @[csr_no]" ).append("\n"); 

	}
}