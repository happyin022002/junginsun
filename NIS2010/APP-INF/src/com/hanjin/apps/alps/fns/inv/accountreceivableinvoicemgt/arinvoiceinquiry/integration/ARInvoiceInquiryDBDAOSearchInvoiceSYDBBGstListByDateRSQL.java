/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchInvoiceSYDBBGstListByDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.26 
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

public class ARInvoiceInquiryDBDAOSearchInvoiceSYDBBGstListByDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchInvoiceSYDBBGstListByDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("iss_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchInvoiceSYDBBGstListByDateRSQL").append("\n"); 
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
		query.append("SELECT A.GL_EFF_DT," ).append("\n"); 
		query.append("  TO_CHAR(TO_DATE(F.ISS_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') ISS_DT," ).append("\n"); 
		query.append("  F.INV_NO," ).append("\n"); 
		query.append("  A.BL_SRC_NO," ).append("\n"); 
		query.append("  A.ACT_CUST_CNT_CD||'-'||LPAD(A.ACT_CUST_SEQ, 6, '0') CUSTOMER," ).append("\n"); 
		query.append("  D.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("  DECODE(A.IO_BND_CD, 'I', 'I/B', 'O/B') IO_BND_CD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'AUD', DECODE(B.CHG_CD, 'CMR', B.CHG_AMT, 0), 0)) CMR_AUD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'USD', DECODE(B.CHG_CD, 'CMR', B.CHG_AMT, 0), 0)) CMR_USD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'AUD', DECODE(B.CHG_CD, 'DHF', B.CHG_AMT, 'DDF', B.CHG_AMT, 0), 0)) DHF_AUD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'USD', DECODE(B.CHG_CD, 'DHF', B.CHG_AMT, 'DDF', B.CHG_AMT, 0), 0)) DHF_USD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'AUD', DECODE(B.CHG_CD, 'DTH', B.CHG_AMT, 0), 0)) DTH_AUD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'USD', DECODE(B.CHG_CD, 'DTH', B.CHG_AMT, 0), 0)) DTH_USD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'AUD', DECODE(B.CHG_CD, 'EHC', B.CHG_AMT, 'OCH', B.CHG_AMT, 'DCH', B.CHG_AMT, 0), 0)) EHC_AUD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'USD', DECODE(B.CHG_CD, 'EHC', B.CHG_AMT, 'OCH', B.CHG_AMT, 'DCH', B.CHG_AMT, 0), 0)) EHC_USD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'AUD', DECODE(B.CHG_CD, 'DTS', B.CHG_AMT, 0), 0)) DTS_AUD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'USD', DECODE(B.CHG_CD, 'DTS', B.CHG_AMT, 0), 0)) DTS_USD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'AUD', DECODE(B.CHG_CD, 'DPS', B.CHG_AMT, 0), 0)) DPS_AUD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'USD', DECODE(B.CHG_CD, 'DPS', B.CHG_AMT, 0), 0)) DPS_USD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'AUD', DECODE(B.CHG_CD, 'DTC', B.CHG_AMT, 0), 0)) DTC_AUD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'USD', DECODE(B.CHG_CD, 'DTC', B.CHG_AMT, 0), 0)) DTC_USD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'AUD', DECODE(B.CHG_CD, 'AST', B.CHG_AMT, 0), 0)) AST_AUD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'USD', DECODE(B.CHG_CD, 'AST', B.CHG_AMT, 0), 0)) AST_USD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'AUD', DECODE(B.CHG_CD, 'TVA', B.CHG_AMT, 0), 0)) TVA_AUD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'USD', DECODE(B.CHG_CD, 'TVA', B.CHG_AMT, 0), 0)) TVA_USD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'AUD', DECODE(B.CHG_CD, 'CMR', 0, 'DHF', 0, 'DDF', 0, 'DTH', 0, 'EHC', 0, 'DTS', 0, 'DPS', 0, 'AST', 0, 'TVA', 0, 'DTC', 0, B.CHG_AMT), 0)) NON_TAXABLE_AUD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'USD', DECODE(B.CHG_CD, 'CMR', 0, 'DHF', 0, 'DDF', 0, 'DTH', 0, 'EHC', 0, 'DTS', 0, 'DPS', 0, 'AST', 0, 'TVA', 0, B.CHG_AMT), 0)) NON_TAXABLE_USD," ).append("\n"); 
		query.append("  A.USD_XCH_RT," ).append("\n"); 
		query.append("  ROUND(SUM(DECODE(B.CURR_CD, 'USD', 0, B.CHG_AMT * B.INV_XCH_RT)), 2) LCL_AMT," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'USD', B.CHG_AMT, 0)) USD_AMT," ).append("\n"); 
		query.append("  ROUND(SUM(DECODE(B.CURR_CD, 'USD', B.CHG_AMT * A.USD_XCH_RT, 0)), 2) EQV_LCL," ).append("\n"); 
		query.append("  ROUND(SUM(B.CHG_AMT * B.INV_XCH_RT), 2) GRAND_TOTAL" ).append("\n"); 
		query.append("FROM INV_AR_ISS F," ).append("\n"); 
		query.append("  INV_AR_ISS_DTL C," ).append("\n"); 
		query.append("  INV_AR_CHG B," ).append("\n"); 
		query.append("  INV_AR_MN A," ).append("\n"); 
		query.append("  MDM_CUSTOMER D," ).append("\n"); 
		query.append("  MDM_CURRENCY G" ).append("\n"); 
		query.append("WHERE F.ISS_DT BETWEEN REPLACE(@[iss_fm_dt], '-', '') AND REPLACE(@[iss_to_dt], '-', '')" ).append("\n"); 
		query.append("  AND F.ISS_OFC_CD IN (" ).append("\n"); 
		query.append("    SELECT OFC_CD" ).append("\n"); 
		query.append("    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("    WHERE AR_OFC_CD = @[office])" ).append("\n"); 
		query.append("  AND F.INV_NO = C.INV_NO" ).append("\n"); 
		query.append("  AND F.INV_SEQ = 1" ).append("\n"); 
		query.append("  AND C.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("  AND C.CHG_SEQ = B.CHG_SEQ" ).append("\n"); 
		query.append("  AND B.AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("  AND A.AR_OFC_CD = @[office]" ).append("\n"); 
		query.append("  AND A.ACT_CUST_CNT_CD = D.CUST_CNT_CD" ).append("\n"); 
		query.append("  AND A.ACT_CUST_SEQ = D.CUST_SEQ" ).append("\n"); 
		query.append("  AND A.LOCL_CURR_CD = G.CURR_CD" ).append("\n"); 
		query.append("  AND A.INV_DELT_DIV_CD <>'Y'" ).append("\n"); 
		query.append("#if (${act_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("  AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_seq} != '')" ).append("\n"); 
		query.append("  AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("  AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bound} != '')  " ).append("\n"); 
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
		query.append("GROUP BY A.GL_EFF_DT, TO_CHAR(TO_DATE(F.ISS_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD'), F.INV_NO, A.BL_SRC_NO, A.ACT_CUST_CNT_CD||'-'||LPAD(A.ACT_CUST_SEQ, 6, '0'), D.CUST_LGL_ENG_NM, DECODE(A.IO_BND_CD, 'I', 'I/B', 'O/B'), A.USD_XCH_RT" ).append("\n"); 
		query.append("ORDER BY A.GL_EFF_DT, TO_CHAR(TO_DATE(F.ISS_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD'), F.INV_NO, A.BL_SRC_NO" ).append("\n"); 

	}
}