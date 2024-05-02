/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchARInvoiceSumByGoodDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.03.17 최도순
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

public class ARInvoiceInquiryDBDAOSearchARInvoiceSumByGoodDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Inquiry by Date & VVD 화면 하단용 Summary.
	  * INV_AR_MN, INV_AR_CHG에서  조회조건에 해당하는 BL count, Grand USD Total, Grand LCL Total을 구함.
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchARInvoiceSumByGoodDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("issue_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchARInvoiceSumByGoodDateRSQL").append("\n"); 
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
		query.append("SELECT COUNT(DISTINCT(TB.BL_SRC_NO)) BL_COUNT," ).append("\n"); 
		query.append("  ROUND(SUM(TB.CHG_AMT), 2) GRAND_USD_TOTAL," ).append("\n"); 
		query.append("  ROUND(SUM(TB.LCL_AMT), 2) GRAND_LCL_TOTAL" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("#if (${from_date} != '' && ${to_date} != '') " ).append("\n"); 
		query.append("#if (${date_option} == 'G') " ).append("\n"); 
		query.append("    SELECT /*+ index(A XAK5INV_AR_MN)  */ A.BL_SRC_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    SELECT /*+ index(A XAK3INV_AR_MN)  */ A.BL_SRC_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    SELECT A.BL_SRC_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      SUM(DECODE(C.CURR_CD, 'USD', C.CHG_AMT, 0)) CHG_AMT," ).append("\n"); 
		query.append("      ROUND(A.INV_TTL_LOCL_AMT, D.DP_PRCS_KNT) LCL_AMT" ).append("\n"); 
		query.append("    FROM INV_AR_MN A," ).append("\n"); 
		query.append("      INV_AR_CHG C," ).append("\n"); 
		query.append("      MDM_CURRENCY D" ).append("\n"); 
		query.append("    WHERE A.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("      AND A.LOCL_CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("#if (${from_date} != '' && ${to_date} != '') " ).append("\n"); 
		query.append("#if (${date_option} == 'G') " ).append("\n"); 
		query.append("      AND A.BL_INV_CFM_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      AND A.BL_INV_IF_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${office} != '')" ).append("\n"); 
		query.append("      AND A.AR_OFC_CD = @[office] -- OFFICE" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("      AND A.AR_OFC_CD IN ( SELECT OFC_CD -- OFC ALL 선택시 적용..  " ).append("\n"); 
		query.append("                             FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                            WHERE AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                         FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                        WHERE OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                                           FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                          WHERE OFC_CD = @[user_ofc_cd]))" ).append("\n"); 
		query.append("                              AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${issue_flag} != 'A') " ).append("\n"); 
		query.append("      AND A.INV_ISS_FLG = @[issue_flag]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${date_option} != 'G')" ).append("\n"); 
		query.append("#if (${good_flag} == 'Y') " ).append("\n"); 
		query.append("      AND A.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${good_flag} == 'N') " ).append("\n"); 
		query.append("      AND A.BL_INV_CFM_DT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_cnt_cd} != '') " ).append("\n"); 
		query.append("      AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_seq} != '') " ).append("\n"); 
		query.append("      AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rev_tp_cd} != '')" ).append("\n"); 
		query.append("AND A.REV_TP_CD = @[rev_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_src_cd} != '')" ).append("\n"); 
		query.append("AND A.REV_SRC_CD IN (@[rev_src_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("      AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '') " ).append("\n"); 
		query.append("      AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("      AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scope} != '') " ).append("\n"); 
		query.append("      AND A.SVC_SCP_CD = @[scope]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bound} != 'A')" ).append("\n"); 
		query.append("      AND A.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("#if ((${bound} == 'I') && (${port} != ''))" ).append("\n"); 
		query.append("      AND A.POD_CD = @[port]" ).append("\n"); 
		query.append("#elseif ((${bound} == 'O') && (${port} != ''))" ).append("\n"); 
		query.append("      AND A.POL_CD = @[port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${port} != '')" ).append("\n"); 
		query.append("      AND ((A.IO_BND_CD = 'I' AND A.POD_CD = @[port]) OR (A.IO_BND_CD = 'O' AND A.POL_CD = @[port]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_clr_flg} == 'N')" ).append("\n"); 
		query.append("      AND A.INV_CLR_FLG = @[inv_clr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    GROUP BY A.BL_SRC_NO, A.AR_IF_NO, A.INV_TTL_LOCL_AMT, D.DP_PRCS_KNT) TB" ).append("\n"); 

	}
}