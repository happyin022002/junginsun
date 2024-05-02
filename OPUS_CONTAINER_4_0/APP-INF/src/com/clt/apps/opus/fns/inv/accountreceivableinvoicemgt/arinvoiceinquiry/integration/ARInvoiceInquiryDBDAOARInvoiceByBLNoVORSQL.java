/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOARInvoiceByBLNoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.15 
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

public class ARInvoiceInquiryDBDAOARInvoiceByBLNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOARInvoiceByBLNoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOARInvoiceByBLNoVORSQL").append("\n"); 
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
		query.append("SELECT A.BL_SRC_NO," ).append("\n"); 
		query.append("  A.BKG_NO," ).append("\n"); 
		query.append("  A.BL_TP_CD," ).append("\n"); 
		query.append("  A.AR_OFC_CD," ).append("\n"); 
		query.append("  A.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("  LPAD(A.ACT_CUST_SEQ, 6, '0') ACT_CUST_SEQ," ).append("\n"); 
		query.append("  B.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("  B.CUST_RGST_NO," ).append("\n"); 
		query.append("  A.REV_TP_CD," ).append("\n"); 
		query.append("  A.REV_SRC_CD," ).append("\n"); 
		query.append("  C.CR_CURR_CD," ).append("\n"); 
		query.append("  C.CR_AMT," ).append("\n"); 
		query.append("  C.IB_CR_TERM_DYS," ).append("\n"); 
		query.append("  C.OB_CR_TERM_DYS," ).append("\n"); 
		query.append("  C.CR_CLT_OFC_CD," ).append("\n"); 
		query.append("  A.VSL_CD||SKD_VOY_NO||A.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("  A.SVC_SCP_CD," ).append("\n"); 
		query.append("  CASE WHEN A.IO_BND_CD = 'I' THEN 'I/B' ELSE 'O/B' END IO_BND_CD," ).append("\n"); 
		query.append("  TO_CHAR(TO_DATE(A.SAIL_ARR_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') SAIL_ARR_DT," ).append("\n"); 
		query.append("  A.TRNK_VSL_CD||A.TRNK_SKD_VOY_NO||A.TRNK_SKD_DIR_CD TRUNK_VVD," ).append("\n"); 
		query.append("  A.SLAN_CD," ).append("\n"); 
		query.append("  A.POR_CD," ).append("\n"); 
		query.append("  A.POL_CD," ).append("\n"); 
		query.append("  A.POD_CD," ).append("\n"); 
		query.append("  A.DEL_CD," ).append("\n"); 
		query.append("  NVL(A.MST_BL_NO, ' ') MST_BL_NO," ).append("\n"); 
		query.append("  A.RFA_NO," ).append("\n"); 
		query.append("  A.SC_NO," ).append("\n"); 
		query.append("  A.SREP_CD," ).append("\n"); 
		query.append("  TRIM(TO_CHAR(ROUND(A.CGO_WGT, 3), '999,999,999,999,999,990.999')) CGO_WGT," ).append("\n"); 
		query.append("  TRIM(TO_CHAR(ROUND(A.CGO_MEAS_QTY, 3), '999,999,999,999,999,990.999')) CGO_MEAS_QTY," ).append("\n"); 
		query.append("  A.WHF_DECL_NO," ).append("\n"); 
		query.append("  A.BKG_TEU_QTY," ).append("\n"); 
		query.append("  A.BKG_FEU_QTY," ).append("\n"); 
		query.append("  A.USD_XCH_RT," ).append("\n"); 
		query.append("  DECODE(A.XCH_RT_USD_TP_CD,'I','Indi.','') XCH_RT_USD_TP_CD," ).append("\n"); 
		query.append("  A.CTRT_OFC_CD," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT SUM(CASE WHEN BL_INV_CFM_DT IS NOT NULL THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("    FROM INV_AR_MN" ).append("\n"); 
		query.append("    WHERE AR_IF_NO IN (" ).append("\n"); 
		query.append("        SELECT AR_IF_NO" ).append("\n"); 
		query.append("        FROM INV_AR_MN" ).append("\n"); 
		query.append("        WHERE BL_SRC_NO = (" ).append("\n"); 
		query.append("            SELECT DISTINCT BL_SRC_NO" ).append("\n"); 
		query.append("            FROM INV_AR_MN" ).append("\n"); 
		query.append("            WHERE AR_IF_NO = @[max_if_no]" ).append("\n"); 
		query.append("              AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y'  )" ).append("\n"); 
		query.append("          AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y')" ).append("\n"); 
		query.append("      AND AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("      AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y' ) GOOD," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT SUM(CASE WHEN BL_INV_CFM_DT IS NULL THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("    FROM INV_AR_MN" ).append("\n"); 
		query.append("    WHERE AR_IF_NO IN (" ).append("\n"); 
		query.append("        SELECT AR_IF_NO" ).append("\n"); 
		query.append("        FROM INV_AR_MN" ).append("\n"); 
		query.append("        WHERE BL_SRC_NO = (" ).append("\n"); 
		query.append("            SELECT DISTINCT BL_SRC_NO" ).append("\n"); 
		query.append("            FROM INV_AR_MN" ).append("\n"); 
		query.append("            WHERE AR_IF_NO = @[max_if_no]" ).append("\n"); 
		query.append("              AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y' )" ).append("\n"); 
		query.append("          AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y')" ).append("\n"); 
		query.append("      AND AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("      AND NVL(INV_DELT_DIV_CD,'N') <> 'Y' ) NOGOOD," ).append("\n"); 
		query.append("  NVL(A.OTS_PAY_CD, 'N') AS OTS_PAY_CD," ).append("\n"); 
		query.append("  A.ORG_INV_NO -- Including Migration Data" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("  MDM_CUSTOMER B," ).append("\n"); 
		query.append("  MDM_CR_CUST C" ).append("\n"); 
		query.append("WHERE A.ACT_CUST_CNT_CD = B.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_SEQ = B.CUST_SEQ (+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_CNT_CD = C.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_SEQ = C.CUST_SEQ (+)" ).append("\n"); 
		query.append("  AND A.AR_IF_NO = @[max_if_no]" ).append("\n"); 
		query.append("  AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 

	}
}