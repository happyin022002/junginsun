/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ManualARCreationDBDAOSearchNonShippingARMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.03
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.04.03 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOSearchNonShippingARMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ManualARCreationDBDAOSearchNonShippingARMainRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOSearchNonShippingARMainRSQL").append("\n"); 
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
		query.append("SELECT TB.BL_SRC_NO," ).append("\n"); 
		query.append("  TB.AR_IF_NO," ).append("\n"); 
		query.append("  TB.AR_OFC_CD," ).append("\n"); 
		query.append("  TB.EFF_DT," ).append("\n"); 
		query.append("  TB.CUST_CNT_CD," ).append("\n"); 
		query.append("  TB.CUST_SEQ," ).append("\n"); 
		query.append("  TB.CUST_NM," ).append("\n"); 
		query.append("  TB.CUST_LOCL_LANG_NM," ).append("\n"); 
		query.append("  TB.CUST_RGST_NO," ).append("\n"); 
		query.append("  TB.CURR_CD," ).append("\n"); 
		query.append("  ROUND(TB.AMOUNT, TB.DP_PRCS_KNT) AMOUNT," ).append("\n"); 
		query.append("  TB.LCL_CURR," ).append("\n"); 
		query.append("  ROUND(TB.INV_TTL_LOCL_AMT-TB.TAX_AMOUNT, TB.DP_PRCS_KNT_LOCAL) LOCAL_AMOUNT," ).append("\n"); 
		query.append("  TB.LCL_CURR TAX_CURR_CD," ).append("\n"); 
		query.append("  TB.TAX_XCH_RT," ).append("\n"); 
		query.append("  TB.AR_TAX_IND_CD," ).append("\n"); 
		query.append("  TB.TAX_AMOUNT," ).append("\n"); 
		query.append("  TB.LCL_CURR TOTAL_CURR_CD," ).append("\n"); 
		query.append("  ROUND(TB.INV_TTL_LOCL_AMT, TB.DP_PRCS_KNT_LOCAL) TOTAL_LOCAL_AMT," ).append("\n"); 
		query.append("  TO_CHAR(TB.INV_XCH_RT, 'FM999,999,990.000000') INV_XCH_RT," ).append("\n"); 
		query.append("  TB.LCL_VVD," ).append("\n"); 
		query.append("  TB.POL_CD," ).append("\n"); 
		query.append("  TB.ACCT_CD," ).append("\n"); 
		query.append("  TB.INV_RMK," ).append("\n"); 
		query.append("  TB.SLP_NO," ).append("\n"); 
		query.append("  TB.DP_PRCS_KNT," ).append("\n"); 
		query.append("  TB.DP_PRCS_KNT_LOCAL," ).append("\n"); 
		query.append("  TB.INV_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT A.BL_SRC_NO," ).append("\n"); 
		query.append("      A.AR_IF_NO," ).append("\n"); 
		query.append("      A.AR_OFC_CD," ).append("\n"); 
		query.append("      TO_CHAR(TO_DATE(A.GL_EFF_DT, 'YYYYMMDD'), 'YYYY-MM-DD') EFF_DT," ).append("\n"); 
		query.append("      A.ACT_CUST_CNT_CD CUST_CNT_CD," ).append("\n"); 
		query.append("      LPAD(A.ACT_CUST_SEQ, 6, '0') CUST_SEQ," ).append("\n"); 
		query.append("      C.CUST_LGL_ENG_NM CUST_NM," ).append("\n"); 
		query.append("      C.CUST_LOCL_LANG_NM," ).append("\n"); 
		query.append("      C.CUST_RGST_NO," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT S1.CURR_CD" ).append("\n"); 
		query.append("        FROM INV_AR_CHG S1" ).append("\n"); 
		query.append("        WHERE A.AR_IF_NO = S1.AR_IF_NO" ).append("\n"); 
		query.append("          AND (S1.ACCT_CD != '212111' OR (S1.ACCT_CD = '212111' AND S1.MNL_FLG <>'N'))" ).append("\n"); 
		query.append("          AND ROWNUM = 1) CURR_CD," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT SUM(CHG_AMT)" ).append("\n"); 
		query.append("        FROM INV_AR_CHG" ).append("\n"); 
		query.append("        WHERE A.AR_IF_NO = AR_IF_NO" ).append("\n"); 
		query.append("          AND MNL_FLG = 'Y') AMOUNT," ).append("\n"); 
		query.append("      A.LOCL_CURR_CD LCL_CURR," ).append("\n"); 
		query.append("      A.TAX_XCH_RT," ).append("\n"); 
		query.append("      A.AR_TAX_IND_CD," ).append("\n"); 
		query.append("      NVL((" ).append("\n"); 
		query.append("            SELECT SUM(F.CHG_AMT)" ).append("\n"); 
		query.append("            FROM INV_AR_CHG F" ).append("\n"); 
		query.append("            WHERE A.AR_IF_NO = F.AR_IF_NO" ).append("\n"); 
		query.append("              AND F.MNL_FLG = 'N'), 0) TAX_AMOUNT," ).append("\n"); 
		query.append("      A.INV_TTL_LOCL_AMT," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT S1.INV_XCH_RT" ).append("\n"); 
		query.append("        FROM INV_AR_CHG S1" ).append("\n"); 
		query.append("        WHERE A.AR_IF_NO = S1.AR_IF_NO" ).append("\n"); 
		query.append("          AND (S1.ACCT_CD != '212111' OR (S1.ACCT_CD = '212111' AND S1.MNL_FLG <>'N'))" ).append("\n"); 
		query.append("          AND ROWNUM = 1 ) INV_XCH_RT," ).append("\n"); 
		query.append("      A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD LCL_VVD," ).append("\n"); 
		query.append("      A.POL_CD," ).append("\n"); 
		query.append("      A.ACCT_CD," ).append("\n"); 
		query.append("      A.INV_RMK," ).append("\n"); 
		query.append("      A.SLP_NO," ).append("\n"); 
		query.append("      D.DP_PRCS_KNT DP_PRCS_KNT_LOCAL," ).append("\n"); 
		query.append("      E.DP_PRCS_KNT DP_PRCS_KNT," ).append("\n"); 
		query.append("      A.INV_NO" ).append("\n"); 
		query.append("    FROM INV_AR_MN A," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT ST.AR_IF_NO," ).append("\n"); 
		query.append("          ST.CURR_CD," ).append("\n"); 
		query.append("          ST.INV_XCH_RT" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT B1.AR_IF_NO," ).append("\n"); 
		query.append("              B1.CURR_CD," ).append("\n"); 
		query.append("              B1.INV_XCH_RT" ).append("\n"); 
		query.append("            FROM INV_AR_MN A1," ).append("\n"); 
		query.append("              INV_AR_CHG B1" ).append("\n"); 
		query.append("            WHERE A1.AR_IF_NO = B1.AR_IF_NO" ).append("\n"); 
		query.append("              AND A1.LOCL_CURR_CD != B1.CURR_CD" ).append("\n"); 
		query.append("              AND A1.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT B2.AR_IF_NO," ).append("\n"); 
		query.append("              B2.CURR_CD," ).append("\n"); 
		query.append("              B2.INV_XCH_RT" ).append("\n"); 
		query.append("            FROM INV_AR_MN A2," ).append("\n"); 
		query.append("              INV_AR_CHG B2" ).append("\n"); 
		query.append("            WHERE A2.AR_IF_NO = B2.AR_IF_NO" ).append("\n"); 
		query.append("              AND A2.LOCL_CURR_CD = B2.CURR_CD" ).append("\n"); 
		query.append("              AND A2.AR_IF_NO = @[ar_if_no] ) ST" ).append("\n"); 
		query.append("        WHERE ROWNUM = 1 ) B," ).append("\n"); 
		query.append("      MDM_CUSTOMER C," ).append("\n"); 
		query.append("      MDM_CURRENCY D," ).append("\n"); 
		query.append("      MDM_CURRENCY E" ).append("\n"); 
		query.append("    WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("      AND A.ACT_CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("      AND A.ACT_CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("      AND A.LOCL_CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("      AND B.CURR_CD = E.CURR_CD" ).append("\n"); 
		query.append("      AND A.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("      AND A.ACCT_CD = '111091') TB" ).append("\n"); 

	}
}