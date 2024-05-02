/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOARInvoiceListByGoodDateVORSQL.java
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

public class ARInvoiceInquiryDBDAOARInvoiceListByGoodDateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Inquiry by VVD & Good Date
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOARInvoiceListByGoodDateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_clr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("issue_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scope",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOARInvoiceListByGoodDateVORSQL").append("\n"); 
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
		query.append("SELECT /*+ ORDERED */ DISTINCT 			" ).append("\n"); 
		query.append("#if (${date_option} == 'G') 			" ).append("\n"); 
		query.append("  A.BL_INV_CFM_DT GOOD_DATE,			" ).append("\n"); 
		query.append("#elseif (${date_option} == 'I') 			" ).append("\n"); 
		query.append("  A.BL_INV_IF_DT GOOD_DATE,			" ).append("\n"); 
		query.append("#elseif (${date_option} == 'E') 			" ).append("\n"); 
		query.append("  A.GL_EFF_DT GOOD_DATE,			" ).append("\n"); 
		query.append("#elseif (${date_option} == 'A') 			" ).append("\n"); 
		query.append("  A.SAIL_ARR_DT GOOD_DATE,			" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  A.AR_OFC_CD," ).append("\n"); 
		query.append("  DECODE(A.IO_BND_CD, 'I', 'I/B', 'O', 'O/B') IO_BND_CD," ).append("\n"); 
		query.append("  A.REV_TP_CD||A.REV_SRC_CD TYPE," ).append("\n"); 
		query.append("  A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("  A.SAIL_ARR_DT," ).append("\n"); 
		query.append("  A.POL_CD," ).append("\n"); 
		query.append("  A.POD_CD," ).append("\n"); 
		query.append("  A.ACT_CUST_CNT_CD||'-'||LPAD(A.ACT_CUST_SEQ, 6, '0') CUSTOMER," ).append("\n"); 
		query.append("  F.CUST_LGL_ENG_NM CUST_NM," ).append("\n"); 
		query.append("  A.BL_SRC_NO," ).append("\n"); 
		query.append("  A.AR_IF_NO," ).append("\n"); 
		query.append("  A.USD_XCH_RT INV_XCH_RT," ).append("\n"); 
		query.append("  A.INV_TTL_LOCL_AMT LCL_AMT," ).append("\n"); 
		query.append("  -- 2018.05.24 인도지역 Split Invoice Issue 기능 보완 " ).append("\n"); 
		query.append("  CASE WHEN (SELECT DECODE(A.AR_OFC_CD, 'BOMSC', '', MAX(INV_NO)) FROM INV_AR_SPLIT_ISS WHERE BL_SRC_NO = A.BL_SRC_NO) IS NULL THEN" ).append("\n"); 
		query.append("     DECODE(A.INV_CLR_FLG, 'Y', 'SYS CLEAR', NVL(A.INV_NO, DECODE(G.DMDT_AR_INV_ISS_FLG, 'N', A.INV_SRC_NO, DECODE(G.N3PTY_BIL_AR_INV_FLG, 'N', A.INV_SRC_NO, DECODE(G.TML_INV_ISS_FLG, 'N', A.INV_SRC_NO, NULL))))) " ).append("\n"); 
		query.append("  ELSE" ).append("\n"); 
		query.append("     (SELECT MAX(INV_NO) FROM INV_AR_SPLIT_ISS WHERE BL_SRC_NO = A.BL_SRC_NO )" ).append("\n"); 
		query.append("  END INV_NO," ).append("\n"); 
		query.append("  -- 2018.05.24 인도지역 Split Invoice Issue 기능 보완 " ).append("\n"); 
		query.append("  CASE WHEN (SELECT DECODE(A.AR_OFC_CD, 'BOMSC', '', MAX(INV_NO)) FROM INV_AR_SPLIT_ISS WHERE BL_SRC_NO = A.BL_SRC_NO) IS NULL THEN" ).append("\n"); 
		query.append("     DECODE(A.INV_CLR_FLG, 'Y', A.ISS_DT, NVL(A.ISS_DT, DECODE(G.DMDT_AR_INV_ISS_FLG, 'N', A.ISS_DT, DECODE(G.N3PTY_BIL_AR_INV_FLG, 'N', A.ISS_DT, DECODE(G.TML_INV_ISS_FLG, 'N', A.ISS_DT, NULL))))) " ).append("\n"); 
		query.append("  ELSE" ).append("\n"); 
		query.append("     (SELECT MAX(ISS_DT) FROM INV_AR_SPLIT_ISS WHERE BL_SRC_NO = A.BL_SRC_NO )" ).append("\n"); 
		query.append("  END ISS_DT," ).append("\n"); 
		query.append("  CASE WHEN (SELECT MAX(NVL(AUTO_INV_ISS_FLG,'N')) FROM INV_AR_ISS WHERE INV_NO = A.INV_NO AND ISS_DT = A.ISS_DT) ='Y' THEN 'A'  ELSE 'M'  END  AUTO_INV_ISS_FLG," ).append("\n"); 
		query.append("  A.UPD_USR_ID," ).append("\n"); 
		query.append("  MAX(D.DP_PRCS_KNT) OVER (PARTITION BY A.LOCL_CURR_CD) DP_PRCS_KNT_LCL," ).append("\n"); 
		query.append("  0 DP_PRCS_KNT," ).append("\n"); 
		query.append("  --2017.08.01 인도 GST 세법 변경 관련 보완" ).append("\n"); 
		query.append("  (SELECT MAX(INV_NO)" ).append("\n"); 
		query.append("   FROM INV_AR_ISS_DTL" ).append("\n"); 
		query.append("   WHERE AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("   AND LENGTH(INV_NO) = 15" ).append("\n"); 
		query.append("   AND SUBSTR(INV_NO, 1, 1) = 'P') PRO_INV_NO," ).append("\n"); 
		query.append("  (SELECT SUM(IDA_CGST_AMT) FROM INV_AR_CHG WHERE AR_IF_NO = A.AR_IF_NO) IDA_CGST_AMT," ).append("\n"); 
		query.append("  (SELECT SUM(IDA_SGST_AMT) FROM INV_AR_CHG WHERE AR_IF_NO = A.AR_IF_NO) IDA_SGST_AMT," ).append("\n"); 
		query.append("  (SELECT SUM(IDA_UGST_AMT) FROM INV_AR_CHG WHERE AR_IF_NO = A.AR_IF_NO) IDA_UGST_AMT," ).append("\n"); 
		query.append("  (SELECT SUM(IDA_IGST_AMT) FROM INV_AR_CHG WHERE AR_IF_NO = A.AR_IF_NO) IDA_IGST_AMT" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("  MDM_CURRENCY D," ).append("\n"); 
		query.append("  MDM_CUSTOMER F," ).append("\n"); 
		query.append("  INV_AR_STUP_OFC G," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT ROWID RID," ).append("\n"); 
		query.append("      AR_IF_NO" ).append("\n"); 
		query.append("    FROM INV_AR_MN" ).append("\n"); 
		query.append("#if (${office} != '')" ).append("\n"); 
		query.append("    WHERE AR_OFC_CD = @[office] -- OFFICE" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("    WHERE AR_OFC_CD IN ( SELECT OFC_CD -- OFC ALL 선택시 적용..  " ).append("\n"); 
		query.append("                         FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                         WHERE AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                    WHERE OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                                     FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                     WHERE OFC_CD = @[user_ofc_cd]))" ).append("\n"); 
		query.append("                           AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${from_date} != '' && ${to_date} != '') 									" ).append("\n"); 
		query.append("#if (${date_option} == 'G') 									" ).append("\n"); 
		query.append("      AND BL_INV_CFM_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')									" ).append("\n"); 
		query.append("#elseif (${date_option} == 'I')									" ).append("\n"); 
		query.append("      AND BL_INV_IF_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')									" ).append("\n"); 
		query.append("#elseif (${date_option} == 'E')									" ).append("\n"); 
		query.append("      AND GL_EFF_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')									" ).append("\n"); 
		query.append("#elseif (${date_option} == 'A')									" ).append("\n"); 
		query.append("      AND SAIL_ARR_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')									" ).append("\n"); 
		query.append("#end									" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("    ) X" ).append("\n"); 
		query.append("WHERE A.ROWID = X.RID" ).append("\n"); 
		query.append("  AND A.AR_IF_NO = X.AR_IF_NO" ).append("\n"); 
		query.append("  AND A.LOCL_CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("  AND A.ACT_CUST_CNT_CD = F.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_SEQ = F.CUST_SEQ (+)" ).append("\n"); 
		query.append("  AND A.AR_OFC_CD = G.AR_OFC_CD (+)" ).append("\n"); 
		query.append("#if (${from_date} != '' && ${to_date} != '') 									" ).append("\n"); 
		query.append("#if (${date_option} == 'G') 									" ).append("\n"); 
		query.append("  AND A.BL_INV_CFM_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')									" ).append("\n"); 
		query.append("#elseif (${date_option} == 'I')									" ).append("\n"); 
		query.append("  AND A.BL_INV_IF_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')									" ).append("\n"); 
		query.append("#elseif (${date_option} == 'E')									" ).append("\n"); 
		query.append("  AND A.GL_EFF_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')									" ).append("\n"); 
		query.append("#elseif (${date_option} == 'A')									" ).append("\n"); 
		query.append("  AND A.SAIL_ARR_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')									" ).append("\n"); 
		query.append("#end							" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${office} != '')" ).append("\n"); 
		query.append("  AND A.AR_OFC_CD = @[office] -- OFFICE" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("  AND A.AR_OFC_CD IN ( SELECT OFC_CD -- OFC ALL 선택시 적용..  " ).append("\n"); 
		query.append("                       FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                       WHERE AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                  WHERE OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                                   FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                   WHERE OFC_CD = @[user_ofc_cd]))" ).append("\n"); 
		query.append("                         AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${issue_flag} != 'A') " ).append("\n"); 
		query.append("  AND A.INV_ISS_FLG = @[issue_flag]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${date_option} != 'G')" ).append("\n"); 
		query.append("#if (${good_flag} == 'Y') " ).append("\n"); 
		query.append("  AND A.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${good_flag} == 'N') " ).append("\n"); 
		query.append("  AND A.BL_INV_CFM_DT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_cnt_cd} != '') " ).append("\n"); 
		query.append("  AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_seq} != '') " ).append("\n"); 
		query.append("  AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_tp_cd} != '')" ).append("\n"); 
		query.append("  AND A.REV_TP_CD = @[rev_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_src_cd} != '')" ).append("\n"); 
		query.append("  AND A.REV_SRC_CD IN (@[rev_src_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("  AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '') " ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scope} != '') " ).append("\n"); 
		query.append("  AND A.SVC_SCP_CD = @[scope]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} != 'A')" ).append("\n"); 
		query.append("  AND A.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("#if ((${bound} == 'I') && (${port} != ''))" ).append("\n"); 
		query.append("  AND A.POD_CD = @[port]" ).append("\n"); 
		query.append("#elseif ((${bound} == 'O') && (${port} != ''))" ).append("\n"); 
		query.append("  AND A.POL_CD = @[port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${port} != '')" ).append("\n"); 
		query.append("  AND ((A.IO_BND_CD = 'I' AND A.POD_CD = @[port]) OR (A.IO_BND_CD = 'O' AND A.POL_CD = @[port]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_clr_flg} == 'N')" ).append("\n"); 
		query.append("  AND A.INV_CLR_FLG = @[inv_clr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${upd_usr_id} != '') " ).append("\n"); 
		query.append("  AND A.UPD_USR_ID LIKE @[upd_usr_id]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY GOOD_DATE, AR_OFC_CD, DECODE(IO_BND_CD, 'O/B', 1, 'I/B', 2), TYPE, VVD, SAIL_ARR_DT, POL_CD, POD_CD, CUSTOMER, BL_SRC_NO, AR_IF_NO" ).append("\n"); 

	}
}