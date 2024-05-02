/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchTransactionDataComparisonReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOSearchTransactionDataComparisonReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchTransactionDataComparisonReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_hd_qtr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchTransactionDataComparisonReportRSQL").append("\n"); 
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
		query.append("SELECT ERP_IF_GL_DT" ).append("\n"); 
		query.append(", AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append(", AR_OFC_CD" ).append("\n"); 
		query.append(", REV_TP_CD" ).append("\n"); 
		query.append(", REV_SRC_CD" ).append("\n"); 
		query.append(", INV_COA_ACCT_CD" ).append("\n"); 
		query.append(", ACCT_KRN_NM" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", INV_AMT " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT T.ERP_IF_GL_DT" ).append("\n"); 
		query.append(", D.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append(", T.AR_OFC_CD" ).append("\n"); 
		query.append(", T.REV_TP_CD" ).append("\n"); 
		query.append(", T.REV_SRC_CD" ).append("\n"); 
		query.append(", T.INV_COA_ACCT_CD" ).append("\n"); 
		query.append(", T.ACCT_KRN_NM" ).append("\n"); 
		query.append(", T.CURR_CD" ).append("\n"); 
		query.append(", T.INV_AMT" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION D, (" ).append("\n"); 
		query.append("SELECT TO_CHAR(TO_DATE(C.ERP_IF_GL_DT,'YYYYMMDD'),'YYYY/MM') ERP_IF_GL_DT" ).append("\n"); 
		query.append(", A.AR_OFC_CD AR_OFC_CD" ).append("\n"); 
		query.append(", DECODE(A.REV_TP_CD, 'B', 'B/L', 'C', 'C/A', 'M', 'MRI') REV_TP_CD" ).append("\n"); 
		query.append(", A.REV_TP_CD||A.REV_SRC_CD REV_SRC_CD" ).append("\n"); 
		query.append(", C.INV_COA_ACCT_CD INV_COA_ACCT_CD" ).append("\n"); 
		query.append(", (SELECT MAX(ACCT_LOCL_NM) FROM MDM_ACCOUNT WHERE ACCT_CD = C.INV_COA_ACCT_CD) ACCT_KRN_NM" ).append("\n"); 
		query.append(", C.CURR_CD CURR_CD" ).append("\n"); 
		query.append(", SUM(C.INV_AMT) INV_AMT" ).append("\n"); 
		query.append("FROM INV_AR_MN A, INV_AR_AMT C" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("AND C.INV_ERP_IF_STS_CD = 'Y'" ).append("\n"); 
		query.append("#if (${date_option} == 'I') " ).append("\n"); 
		query.append("    AND A.BL_INV_IF_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')" ).append("\n"); 
		query.append("#elseif (${date_option} == 'C') " ).append("\n"); 
		query.append("    AND A.BL_INV_CFM_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')" ).append("\n"); 
		query.append("#elseif (${date_option} == 'G') " ).append("\n"); 
		query.append("    AND C.ERP_IF_GL_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} != 'ALL' && ${ar_ofc_cd} != '')" ).append("\n"); 
		query.append("    AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_tp_cd} != 'A' && ${rev_tp_cd} != '')" ).append("\n"); 
		query.append("    AND A.REV_TP_CD = @[rev_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_src_cd} != 'A' && ${rev_src_cd} != '')" ).append("\n"); 
		query.append("    AND A.REV_SRC_CD IN (@[rev_src_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY TO_CHAR(TO_DATE(ERP_IF_GL_DT,'YYYYMMDD'),'YYYY/MM')" ).append("\n"); 
		query.append(", A.AR_OFC_CD" ).append("\n"); 
		query.append(", DECODE(A.REV_TP_CD, 'B', 'B/L', 'C', 'C/A', 'M', 'MRI')" ).append("\n"); 
		query.append(", A.REV_TP_CD||A.REV_SRC_CD" ).append("\n"); 
		query.append(", C.INV_COA_ACCT_CD" ).append("\n"); 
		query.append(", C.CURR_CD" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("WHERE D.OFC_CD = T.AR_OFC_CD" ).append("\n"); 
		query.append("#if (${ar_hd_qtr_ofc_cd} != 'ALL' && ${ar_hd_qtr_ofc_cd} != '')" ).append("\n"); 
		query.append("    AND D.AR_HD_QTR_OFC_CD = @[ar_hd_qtr_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY ERP_IF_GL_DT" ).append("\n"); 
		query.append(", AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append(", AR_OFC_CD" ).append("\n"); 
		query.append(", REV_TP_CD" ).append("\n"); 
		query.append(", REV_SRC_CD" ).append("\n"); 
		query.append(", INV_COA_ACCT_CD" ).append("\n"); 
		query.append(", ACCT_KRN_NM" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", INV_AMT    " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT ERP_IF_GL_DT" ).append("\n"); 
		query.append(", AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append(", AR_OFC_CD" ).append("\n"); 
		query.append(", REV_TP_CD" ).append("\n"); 
		query.append(", REV_SRC_CD" ).append("\n"); 
		query.append(", REV_COA_ACCT_CD" ).append("\n"); 
		query.append(", ACCT_KRN_NM" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", CHG_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT T.ERP_IF_GL_DT" ).append("\n"); 
		query.append(", D.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append(", T.AR_OFC_CD" ).append("\n"); 
		query.append(", T.REV_TP_CD" ).append("\n"); 
		query.append(", T.REV_SRC_CD" ).append("\n"); 
		query.append(", T.REV_COA_ACCT_CD" ).append("\n"); 
		query.append(", T.ACCT_KRN_NM" ).append("\n"); 
		query.append(", T.CURR_CD" ).append("\n"); 
		query.append(", T.CHG_AMT" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION D, (" ).append("\n"); 
		query.append("SELECT TO_CHAR(TO_DATE(C.ERP_IF_GL_DT,'YYYYMMDD'),'YYYY/MM') ERP_IF_GL_DT" ).append("\n"); 
		query.append(", A.AR_OFC_CD AR_OFC_CD" ).append("\n"); 
		query.append(", DECODE(A.REV_TP_CD, 'B', 'B/L', 'C', 'C/A', 'M', 'MRI') REV_TP_CD" ).append("\n"); 
		query.append(", A.REV_TP_CD||A.REV_SRC_CD REV_SRC_CD" ).append("\n"); 
		query.append(", B.REV_COA_ACCT_CD REV_COA_ACCT_CD" ).append("\n"); 
		query.append(", (SELECT MAX(ACCT_LOCL_NM) FROM MDM_ACCOUNT WHERE ACCT_CD = B.REV_COA_ACCT_CD) ACCT_KRN_NM" ).append("\n"); 
		query.append(", C.CURR_CD CURR_CD" ).append("\n"); 
		query.append(", SUM(B.CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append("FROM INV_AR_MN A, INV_AR_CHG B, INV_AR_AMT C" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("AND B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("AND B.AR_IF_SER_NO = C.AR_IF_SER_NO" ).append("\n"); 
		query.append("AND C.INV_ERP_IF_STS_CD = 'Y'" ).append("\n"); 
		query.append("#if (${date_option} == 'I') " ).append("\n"); 
		query.append("    AND A.BL_INV_IF_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')" ).append("\n"); 
		query.append("#elseif (${date_option} == 'C') " ).append("\n"); 
		query.append("    AND A.BL_INV_CFM_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')" ).append("\n"); 
		query.append("#elseif (${date_option} == 'G') " ).append("\n"); 
		query.append("    AND C.ERP_IF_GL_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} != 'ALL' && ${ar_ofc_cd} != '')" ).append("\n"); 
		query.append("    AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_tp_cd} != 'A' && ${rev_tp_cd} != '')" ).append("\n"); 
		query.append("    AND A.REV_TP_CD = @[rev_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_src_cd} != 'A' && ${rev_src_cd} != '')" ).append("\n"); 
		query.append("    AND A.REV_SRC_CD IN (@[rev_src_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY TO_CHAR(TO_DATE(ERP_IF_GL_DT,'YYYYMMDD'),'YYYY/MM')" ).append("\n"); 
		query.append(", A.AR_OFC_CD" ).append("\n"); 
		query.append(", DECODE(A.REV_TP_CD, 'B', 'B/L', 'C', 'C/A', 'M', 'MRI')" ).append("\n"); 
		query.append(", A.REV_TP_CD||A.REV_SRC_CD" ).append("\n"); 
		query.append(", B.REV_COA_ACCT_CD" ).append("\n"); 
		query.append(", C.CURR_CD" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("WHERE D.OFC_CD = T.AR_OFC_CD" ).append("\n"); 
		query.append("#if (${ar_hd_qtr_ofc_cd} != 'ALL' && ${ar_hd_qtr_ofc_cd} != '')" ).append("\n"); 
		query.append("    AND D.AR_HD_QTR_OFC_CD = @[ar_hd_qtr_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY ERP_IF_GL_DT" ).append("\n"); 
		query.append(", AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append(", AR_OFC_CD" ).append("\n"); 
		query.append(", REV_TP_CD" ).append("\n"); 
		query.append(", REV_SRC_CD" ).append("\n"); 
		query.append(", REV_COA_ACCT_CD" ).append("\n"); 
		query.append(", ACCT_KRN_NM" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", CHG_AMT )" ).append("\n"); 

	}
}