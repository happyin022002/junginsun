/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchGCFSAFListByDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOSearchGCFSAFListByDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquiry for GCF SAF collected in other office
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchGCFSAFListByDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchGCFSAFListByDataRSQL").append("\n"); 
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
		query.append("SELECT TB.AR_HD_QTR_OFC_CD," ).append("\n"); 
		query.append("  TB.AR_OFC_CD," ).append("\n"); 
		query.append("  TB.BL_SRC_NO," ).append("\n"); 
		query.append("  TB.SAIL_ARR_DT," ).append("\n"); 
		query.append("  TB.BL_INV_CFM_DT," ).append("\n"); 
		query.append("  TB.VVD," ).append("\n"); 
		query.append("  TB.POL_CD," ).append("\n"); 
		query.append("  TB.SC_NO," ).append("\n"); 
		query.append("  TB.CURR_CD," ).append("\n"); 
		query.append("  ROUND(SUM(TB.USD_AMT),2) USD_AMT," ).append("\n"); 
		query.append("  TB.CUST_CODE," ).append("\n"); 
		query.append("  TB.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("  TB.BKG_NO," ).append("\n"); 
		query.append("  TB.BL_INV_IF_DT," ).append("\n"); 
		query.append("  TB.AR_IF_NO," ).append("\n"); 
		query.append("  TB.POD_CD," ).append("\n"); 
		query.append("  SUM(TB.CHG_AMT) CHG_AMT," ).append("\n"); 
		query.append("  ROUND(SUM(TB.INR_AMT),2) INR_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT C.AR_HD_QTR_OFC_CD," ).append("\n"); 
		query.append("      A.AR_OFC_CD, " ).append("\n"); 
		query.append("      A.BL_SRC_NO," ).append("\n"); 
		query.append("      A.SAIL_ARR_DT," ).append("\n"); 
		query.append("      A.BL_INV_CFM_DT," ).append("\n"); 
		query.append("      A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("      A.POL_CD," ).append("\n"); 
		query.append("	  A.SC_NO," ).append("\n"); 
		query.append("      X.CURR_CD," ).append("\n"); 
		query.append("     ( X.CHG_AMT *( SELECT S1.USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("                          FROM GL_MON_XCH_RT S1" ).append("\n"); 
		query.append("                          WHERE S1.ACCT_XCH_RT_YRMON = SUBSTR(A.GL_EFF_DT, 0, 6)" ).append("\n"); 
		query.append("                          AND S1.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                          AND S1.CURR_CD = X.CURR_CD )) USD_AMT," ).append("\n"); 
		query.append("      A.ACT_CUST_CNT_CD||'-'||LPAD(A.ACT_CUST_SEQ, 6, '0') CUST_CODE," ).append("\n"); 
		query.append("      D.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("      A.BKG_NO," ).append("\n"); 
		query.append("      A.BL_INV_IF_DT," ).append("\n"); 
		query.append("      A.AR_IF_NO," ).append("\n"); 
		query.append("      A.POD_CD," ).append("\n"); 
		query.append("      X.CHG_AMT," ).append("\n"); 
		query.append("     (X.CHG_AMT / (" ).append("\n"); 
		query.append("            SELECT (S1.USD_LOCL_XCH_RT/S2.USD_LOCL_XCH_RT) USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("            FROM GL_MON_XCH_RT S1," ).append("\n"); 
		query.append("                 GL_MON_XCH_RT S2" ).append("\n"); 
		query.append("            WHERE S1.ACCT_XCH_RT_YRMON = SUBSTR(A.GL_EFF_DT, 0, 6)" ).append("\n"); 
		query.append("              AND S1.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("              AND S1.CURR_CD = X.CURR_CD" ).append("\n"); 
		query.append("              AND S2.ACCT_XCH_RT_YRMON = SUBSTR(A.GL_EFF_DT, 0, 6)" ).append("\n"); 
		query.append("              AND S2.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("              AND S2.CURR_CD = 'INR' )) INR_AMT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT A.ROWID RID," ).append("\n"); 
		query.append("          B.CURR_CD," ).append("\n"); 
		query.append("          B.CHG_AMT," ).append("\n"); 
		query.append("          B.INV_XCH_RT," ).append("\n"); 
		query.append("          ROWNUM RNUM" ).append("\n"); 
		query.append("        FROM INV_AR_MN A," ).append("\n"); 
		query.append("          INV_AR_CHG B" ).append("\n"); 
		query.append("        WHERE A.AR_IF_NO = B.AR_IF_NO " ).append("\n"); 
		query.append("#if (${date_option} == 'G')									" ).append("\n"); 
		query.append("      AND A.BL_INV_CFM_DT BETWEEN REPLACE(@[from_date], '-', '') AND REPLACE(@[to_date], '-', '')									" ).append("\n"); 
		query.append("#elseif (${date_option} == 'I')									" ).append("\n"); 
		query.append("      AND A.BL_INV_IF_DT BETWEEN REPLACE(@[from_date], '-', '') AND REPLACE(@[to_date], '-', '')									" ).append("\n"); 
		query.append("#elseif (${date_option} == 'A')									" ).append("\n"); 
		query.append("      AND A.SAIL_ARR_DT BETWEEN REPLACE(@[from_date], '-', '') AND REPLACE(@[to_date], '-', '')									" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("#if (${ar_hd_qtr_ofc_cd} != 'All')" ).append("\n"); 
		query.append("          AND A.AR_OFC_CD IN (" ).append("\n"); 
		query.append("            SELECT AR_OFC_CD" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("            WHERE AR_HD_QTR_OFC_CD IN (${ar_hd_qtr_ofc_cd})" ).append("\n"); 
		query.append("              AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		  AND B.CHG_CD IN (${chg_cd})" ).append("\n"); 
		query.append("          AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("          AND A.BL_INV_CFM_DT IS NOT NULL ) X," ).append("\n"); 
		query.append("      INV_AR_MN A," ).append("\n"); 
		query.append("      MDM_ORGANIZATION C," ).append("\n"); 
		query.append("      MDM_CUSTOMER D" ).append("\n"); 
		query.append("    WHERE X.RID = A.ROWID" ).append("\n"); 
		query.append("      AND A.AR_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("      AND A.ACT_CUST_CNT_CD = D.CUST_CNT_CD" ).append("\n"); 
		query.append("      AND A.ACT_CUST_SEQ = D.CUST_SEQ " ).append("\n"); 
		query.append("      AND A.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("      AND C.AR_HD_QTR_OFC_CD IN (${ar_hd_qtr_ofc_cd}) ) TB" ).append("\n"); 
		query.append("GROUP BY TB.AR_HD_QTR_OFC_CD, TB.AR_OFC_CD, TB.BL_SRC_NO, TB.SAIL_ARR_DT,TB.BL_INV_CFM_DT, TB.VVD, TB.POL_CD,TB.SC_NO, TB.CURR_CD, TB.CUST_CODE, TB.CUST_LGL_ENG_NM, TB.BKG_NO, TB.BL_INV_IF_DT, TB.AR_IF_NO, TB.POD_CD" ).append("\n"); 

	}
}