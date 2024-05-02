/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchARInvoiceMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.03.22 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOSearchARInvoiceMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchARInvoiceMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchARInvoiceMainRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.AR_IF_NO," ).append("\n"); 
		query.append("  DECODE(A.INV_SPLIT_CD, 'M', NULL, A.INV_SPLIT_CD ) INV_SPLIT_CD," ).append("\n"); 
		query.append("  A.BL_SRC_NO," ).append("\n"); 
		query.append("  A.BKG_NO," ).append("\n"); 
		query.append("  A.AR_OFC_CD," ).append("\n"); 
		query.append("  A.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("  LPAD(A.ACT_CUST_SEQ, 6, '0') ACT_CUST_SEQ," ).append("\n"); 
		query.append("  C.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("  C.CUST_RGST_NO," ).append("\n"); 
		query.append("  A.INV_CUST_CNT_CD," ).append("\n"); 
		query.append("  LPAD(A.INV_CUST_SEQ, 6, '0') INV_CUST_SEQ," ).append("\n"); 
		query.append("  D.CR_CURR_CD," ).append("\n"); 
		query.append("  D.CR_AMT," ).append("\n"); 
		query.append("  D.IB_CR_TERM_DYS," ).append("\n"); 
		query.append("  D.OB_CR_TERM_DYS," ).append("\n"); 
		query.append("  D.CR_CLT_OFC_CD," ).append("\n"); 
		query.append("  A.VSL_CD||A.SKD_VOY_NO||SKD_DIR_CD VVD," ).append("\n"); 
		query.append("  A.SVC_SCP_CD," ).append("\n"); 
		query.append("  DECODE(A.IO_BND_CD, 'I', 'I/B', 'O/B') IO_BND_CD," ).append("\n"); 
		query.append("  TO_CHAR(TO_DATE(A.SAIL_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') SAIL_DT," ).append("\n"); 
		query.append("  TO_CHAR(TO_DATE(A.SAIL_ARR_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') SAIL_ARR_DT," ).append("\n"); 
		query.append("  A.TRNK_VSL_CD||A.TRNK_SKD_VOY_NO||A.TRNK_SKD_DIR_CD TRUNK_VVD," ).append("\n"); 
		query.append("  A.SLAN_CD," ).append("\n"); 
		query.append("  A.POR_CD," ).append("\n"); 
		query.append("  A.POL_CD," ).append("\n"); 
		query.append("  A.POD_CD," ).append("\n"); 
		query.append("  A.DEL_CD," ).append("\n"); 
		query.append("  A.BKG_CORR_NO," ).append("\n"); 
		query.append("  TO_CHAR(A.BKG_CORR_DT, 'YYYY-MM-DD') BKG_CORR_DT," ).append("\n"); 
		query.append("  A.CO_STF_CTNT," ).append("\n"); 
		query.append("  A.INV_REF_NO," ).append("\n"); 
		query.append("  A.BKG_REF_NO," ).append("\n"); 
		query.append("  A.SI_REF_NO," ).append("\n"); 
		query.append("  A.INV_RMK," ).append("\n"); 
		query.append("  A.REV_TP_CD," ).append("\n"); 
		query.append("  A.REV_SRC_CD," ).append("\n"); 
		query.append("  A.MST_BL_NO," ).append("\n"); 
		query.append("  A.RFA_NO," ).append("\n"); 
		query.append("  A.SC_NO," ).append("\n"); 
		query.append("  A.SREP_CD," ).append("\n"); 
		query.append("  TRIM(TO_CHAR(ROUND(A.CGO_WGT, 3), '999,999,999,999,999,990.999')) CGO_WGT," ).append("\n"); 
		query.append("  TRIM(TO_CHAR(ROUND(A.CGO_MEAS_QTY, 3), '999,999,999,999,999,990.999')) CGO_MEAS_QTY," ).append("\n"); 
		query.append("  A.WHF_DECL_NO," ).append("\n"); 
		query.append("  TO_CHAR(TO_DATE(A.WHF_DECL_CFM_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') WHF_DECL_CFM_DT," ).append("\n"); 
		query.append("  A.BKG_TEU_QTY," ).append("\n"); 
		query.append("  A.BKG_FEU_QTY," ).append("\n"); 
		query.append("  TO_CHAR(TO_DATE(A.BL_INV_IF_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') BL_INV_IF_DT," ).append("\n"); 
		query.append("  TO_CHAR(TO_DATE(A.BL_INV_CFM_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') BL_INV_CFM_DT," ).append("\n"); 
		query.append("  TO_CHAR(TO_DATE(A.GL_EFF_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') GL_EFF_DT," ).append("\n"); 
		query.append("  DECODE(A.INV_CLR_FLG, " ).append("\n"); 
		query.append("         'Y', " ).append("\n"); 
		query.append("         'SYS CLEAR', " ).append("\n"); 
		query.append("         NVL(DECODE(A.AR_OFC_CD, " ).append("\n"); 
		query.append("                    'SGNBB', " ).append("\n"); 
		query.append("                    (SELECT DISTINCT INV_NO FROM INV_AR_ISS_DTL WHERE AR_IF_NO = A.AR_IF_NO AND INV_NO LIKE 'F%' AND ROWNUM = 1),  -- AR_OFC_CD가 SGNBB인 경우는 FRT인 INV정보만 조회한다. (2009-12-16)" ).append("\n"); 
		query.append("                    (SELECT MAX(INV_NO) FROM INV_AR_ISS_DTL WHERE AR_IF_NO = A.AR_IF_NO AND ROWNUM = 1)), " ).append("\n"); 
		query.append("         A.INV_SRC_NO)) INV_NO," ).append("\n"); 
		query.append("  DECODE(A.AR_OFC_CD, " ).append("\n"); 
		query.append("         'SGNBB', " ).append("\n"); 
		query.append("         (SELECT DISTINCT TO_CHAR(TO_DATE(S2.ISS_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') FROM INV_AR_ISS_DTL S1, INV_AR_ISS S2 WHERE S1.AR_IF_NO = A.AR_IF_NO AND S1.INV_NO LIKE 'F%' AND S1.INV_NO = S2.INV_NO AND S2.INV_SEQ = 1), " ).append("\n"); 
		query.append("         (SELECT TO_CHAR(TO_DATE(MAX(S2.ISS_DT), 'YYYY-MM-DD'), 'YYYY-MM-DD') FROM INV_AR_ISS_DTL S1, INV_AR_ISS S2 WHERE S1.AR_IF_NO = A.AR_IF_NO AND S1.INV_NO = S2.INV_NO AND S2.INV_SEQ = 1)) ISS_DT," ).append("\n"); 
		query.append("  TO_CHAR(TO_DATE(A.DUE_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') DUE_DT," ).append("\n"); 
		query.append("  A.FRT_FWRD_CNT_CD," ).append("\n"); 
		query.append("  A.FRT_FWRD_CUST_SEQ," ).append("\n"); 
		query.append("  TO_CHAR(A.USD_XCH_RT, 'FM9,999,999,990.999990') USD_XCH_RT" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("  MDM_CUSTOMER C," ).append("\n"); 
		query.append("  MDM_CR_CUST D" ).append("\n"); 
		query.append("WHERE A.ACT_CUST_CNT_CD = C.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_SEQ = C.CUST_SEQ (+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_CNT_CD = D.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_SEQ = D.CUST_SEQ (+)" ).append("\n"); 
		query.append("  AND A.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("  AND A.AR_OFC_CD IN (" ).append("\n"); 
		query.append("    SELECT OFC_CD" ).append("\n"); 
		query.append("    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("    WHERE AR_HD_QTR_OFC_CD = (" ).append("\n"); 
		query.append("        SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("        WHERE OFC_CD = (" ).append("\n"); 
		query.append("            SELECT AR_OFC_CD" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("            WHERE OFC_CD = @[ofc_cd]))" ).append("\n"); 
		query.append("      AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("  AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 

	}
}