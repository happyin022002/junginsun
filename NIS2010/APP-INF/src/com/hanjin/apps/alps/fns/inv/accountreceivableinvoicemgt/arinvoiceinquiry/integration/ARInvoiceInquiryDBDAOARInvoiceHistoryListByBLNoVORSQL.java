/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOARInvoiceHistoryListByBLNoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.24 
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

public class ARInvoiceInquiryDBDAOARInvoiceHistoryListByBLNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOARInvoiceHistoryListByBLNoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOARInvoiceHistoryListByBLNoVORSQL").append("\n"); 
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
		query.append("SELECT AR_IF_NO_INV_SPLIT_CD," ).append("\n"); 
		query.append("  AR_IF_NO," ).append("\n"); 
		query.append("  VVD," ).append("\n"); 
		query.append("  CUST_CD," ).append("\n"); 
		query.append("  INV_SPLIT_CD," ).append("\n"); 
		query.append("  REV_TP_CD," ).append("\n"); 
		query.append("  REV_SRC_CD," ).append("\n"); 
		query.append("  REV_TYPE," ).append("\n"); 
		query.append("  CURR_ORDER," ).append("\n"); 
		query.append("  BL_INV_IF_DT," ).append("\n"); 
		query.append("  BL_INV_CFM_DT," ).append("\n"); 
		query.append("  INV_NO," ).append("\n"); 
		query.append("  AUTO_INV_ISS_FLG," ).append("\n"); 
		query.append("  CURR_CD," ).append("\n"); 
		query.append("  SUM(CHG_AMT) CHG_AMT," ).append("\n"); 
		query.append("  DP_PRCS_KNT," ).append("\n"); 
		query.append("  INV_XCH_RT," ).append("\n"); 
		query.append("  ROUND(SUM(CHG_AMT)*INV_XCH_RT, DP_PRCS_KNT_LOCAL) LOCAL_TOTAL," ).append("\n"); 
		query.append("  DP_PRCS_KNT_LOCAL," ).append("\n"); 
		query.append("  INV_CLR_FLG," ).append("\n"); 
		query.append("  CRE_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT TRIM(A.AR_IF_NO ||' '||DECODE(A.INV_SPLIT_CD, 'M', NULL, A.INV_SPLIT_CD )) AR_IF_NO_INV_SPLIT_CD," ).append("\n"); 
		query.append("      A.AR_IF_NO," ).append("\n"); 
		query.append("      A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("      A.ACT_CUST_CNT_CD ||'-'|| LPAD(A.ACT_CUST_SEQ, 6, '0') CUST_CD," ).append("\n"); 
		query.append("      A.INV_SPLIT_CD," ).append("\n"); 
		query.append("      A.REV_TP_CD," ).append("\n"); 
		query.append("      A.REV_SRC_CD," ).append("\n"); 
		query.append("      A.REV_TP_CD||A.REV_SRC_CD REV_TYPE," ).append("\n"); 
		query.append("      DECODE(B.CURR_CD, 'USD', 1, A.LOCL_CURR_CD, 2, 3) CURR_ORDER," ).append("\n"); 
		query.append("      A.BL_INV_IF_DT," ).append("\n"); 
		query.append("      A.BL_INV_CFM_DT," ).append("\n"); 
		query.append("      CASE WHEN G.S_INV_NO IS NULL THEN" ).append("\n"); 
		query.append("         DECODE(A.INV_CLR_FLG, 'Y', 'SYS CLEAR', NVL(A.INV_NO, CASE WHEN (F.DMDT_AR_INV_ISS_FLG = 'Y' OR F.N3PTY_BIL_AR_INV_FLG = 'Y' OR F.TML_INV_ISS_FLG = 'Y' OR F.DOD_AR_INV_ISS_FLG = 'Y') THEN A.INV_NO ELSE A.INV_SRC_NO END))" ).append("\n"); 
		query.append("      ELSE" ).append("\n"); 
		query.append("         CASE WHEN A.INV_NO > G.S_INV_NO THEN" ).append("\n"); 
		query.append("            DECODE(A.INV_CLR_FLG, 'Y', 'SYS CLEAR', NVL(A.INV_NO, CASE WHEN (F.DMDT_AR_INV_ISS_FLG = 'Y' OR F.N3PTY_BIL_AR_INV_FLG = 'Y' OR F.TML_INV_ISS_FLG = 'Y' OR F.DOD_AR_INV_ISS_FLG = 'Y') THEN A.INV_NO ELSE A.INV_SRC_NO END))" ).append("\n"); 
		query.append("         ELSE" ).append("\n"); 
		query.append("            DECODE(A.INV_CLR_FLG, 'Y', 'SYS CLEAR', NVL(G.S_INV_NO, CASE WHEN (F.DMDT_AR_INV_ISS_FLG = 'Y' OR F.N3PTY_BIL_AR_INV_FLG = 'Y' OR F.TML_INV_ISS_FLG = 'Y' OR F.DOD_AR_INV_ISS_FLG = 'Y') THEN G.S_INV_NO ELSE A.INV_SRC_NO END))" ).append("\n"); 
		query.append("         END" ).append("\n"); 
		query.append("      END AS INV_NO," ).append("\n"); 
		query.append("      CASE WHEN (SELECT MAX(NVL(AUTO_INV_ISS_FLG,'N')) FROM INV_AR_ISS WHERE INV_NO = A.INV_NO AND ISS_DT = A.ISS_DT) ='Y' THEN 'A'  ELSE 'M'  END  AUTO_INV_ISS_FLG, " ).append("\n"); 
		query.append("      B.CURR_CD," ).append("\n"); 
		query.append("      B.CHG_AMT," ).append("\n"); 
		query.append("      D.DP_PRCS_KNT," ).append("\n"); 
		query.append("      B.INV_XCH_RT," ).append("\n"); 
		query.append("      E.DP_PRCS_KNT DP_PRCS_KNT_LOCAL," ).append("\n"); 
		query.append("      B.INV_CLR_FLG," ).append("\n"); 
		query.append("      A.LOCL_CURR_CD," ).append("\n"); 
		query.append("      A.CRE_DT" ).append("\n"); 
		query.append("    FROM INV_AR_MN A," ).append("\n"); 
		query.append("      INV_AR_CHG B," ).append("\n"); 
		query.append("      MDM_CURRENCY D," ).append("\n"); 
		query.append("      MDM_CURRENCY E," ).append("\n"); 
		query.append("      INV_AR_STUP_OFC F," ).append("\n"); 
		query.append("      (SELECT DECODE(@[office], 'BOMSC', '', MAX(INV_NO)) S_INV_NO		-- 2018.05.24 인도지역 Split Invoice Issue 기능 보완 " ).append("\n"); 
		query.append("       FROM   INV_AR_SPLIT_ISS" ).append("\n"); 
		query.append("       WHERE  AR_OFC_CD = @[office]" ).append("\n"); 
		query.append("       #if (${bl_src_no} != '') " ).append("\n"); 
		query.append("          AND    BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${bkg_no} != '') " ).append("\n"); 
		query.append("          AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("       #end " ).append("\n"); 
		query.append("       ) G" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("      AND D.CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("      AND E.CURR_CD = A.LOCL_CURR_CD" ).append("\n"); 
		query.append("      AND A.AR_OFC_CD = F.AR_OFC_CD (+)" ).append("\n"); 
		query.append("#if (${bl_src_no} != '') " ).append("\n"); 
		query.append("      AND A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("      AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND A.AR_OFC_CD = @[office]" ).append("\n"); 
		query.append("      AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${rev_type} == 'B') " ).append("\n"); 
		query.append("      AND A.REV_TP_CD = 'B'" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'C') " ).append("\n"); 
		query.append("      AND A.REV_TP_CD = 'C'" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'D') " ).append("\n"); 
		query.append("      AND A.REV_TP_CD = 'M' AND A.REV_SRC_CD IN ('DM','DT')" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'M') " ).append("\n"); 
		query.append("      AND A.REV_TP_CD = 'M' AND A.REV_SRC_CD NOT IN ('DM','DT')" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'BC') " ).append("\n"); 
		query.append("      AND A.REV_TP_CD IN ('B','C')" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'BD') " ).append("\n"); 
		query.append("      AND (A.REV_TP_CD = 'B' OR (A.REV_TP_CD = 'M' AND A.REV_SRC_CD IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'BM') " ).append("\n"); 
		query.append("      AND (A.REV_TP_CD = 'B' OR (A.REV_TP_CD = 'M' AND A.REV_SRC_CD NOT IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'CD') " ).append("\n"); 
		query.append("      AND (A.REV_TP_CD = 'C' OR (A.REV_TP_CD = 'M' AND A.REV_SRC_CD IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'CM') " ).append("\n"); 
		query.append("      AND (A.REV_TP_CD = 'C' OR (A.REV_TP_CD = 'M' AND A.REV_SRC_CD NOT IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'DM') " ).append("\n"); 
		query.append("      AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'BCD') " ).append("\n"); 
		query.append("      AND (A.REV_TP_CD IN ('B','C') OR (A.REV_TP_CD = 'M' AND A.REV_SRC_CD IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'BCM') " ).append("\n"); 
		query.append("      AND (A.REV_TP_CD IN ('B','C') OR (A.REV_TP_CD = 'M' AND A.REV_SRC_CD NOT IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'BDM') " ).append("\n"); 
		query.append("      AND A.REV_TP_CD IN ('B','M')" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'CDM') " ).append("\n"); 
		query.append("      AND A.REV_TP_CD IN ('C','M')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("GROUP BY AR_IF_NO_INV_SPLIT_CD, AR_IF_NO, INV_SPLIT_CD, VVD, CUST_CD, REV_TP_CD, REV_SRC_CD, REV_TYPE, CURR_ORDER, CRE_DT, BL_INV_IF_DT, BL_INV_CFM_DT, INV_NO,AUTO_INV_ISS_FLG, CURR_CD, DP_PRCS_KNT, INV_XCH_RT, DP_PRCS_KNT_LOCAL, INV_CLR_FLG, LOCL_CURR_CD" ).append("\n"); 
		query.append("ORDER BY DECODE(REV_TP_CD,'M',1,0), AR_IF_NO_INV_SPLIT_CD, DECODE(CURR_CD, 'USD', 1, LOCL_CURR_CD, 2, 3), CURR_CD, CRE_DT" ).append("\n"); 

	}
}