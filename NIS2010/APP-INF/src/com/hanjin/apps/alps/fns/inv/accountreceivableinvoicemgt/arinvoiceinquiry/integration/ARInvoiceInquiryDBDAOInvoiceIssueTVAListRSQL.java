/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOInvoiceIssueTVAListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2010.02.23 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JungJin, Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOInvoiceIssueTVAListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOInvoiceIssueTVAListRSQL(){
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
		query.append("FileName : ARInvoiceInquiryDBDAOInvoiceIssueTVAListRSQL").append("\n"); 
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
		query.append("SELECT A.AR_IF_NO," ).append("\n"); 
		query.append("  TO_CHAR(TO_DATE(F.ISS_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') ISS_DT," ).append("\n"); 
		query.append("  A.ACT_CUST_CNT_CD||'-'||LPAD(A.ACT_CUST_SEQ, 6, '0') CUSTOMER," ).append("\n"); 
		query.append("  C.INV_NO INV_NO," ).append("\n"); 
		query.append("  A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("  DECODE(A.IO_BND_CD, 'I', 'I/B', 'O/B') IO_BND_CD," ).append("\n"); 
		query.append("  DECODE(A.IO_BND_CD, 'I', A.POD_CD, 'O', A.POL_CD) PORT," ).append("\n"); 
		query.append("  TO_CHAR(TO_DATE(A.SAIL_ARR_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') SAIL_ARR_DT," ).append("\n"); 
		query.append("  A.BL_SRC_NO," ).append("\n"); 
		query.append("  DECODE(A.REV_TP_CD, 'B', 'B/L', 'C', 'C/A', 'M', 'MRI', NVL(A.REV_TP_CD, '')) REV_TP_CD," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'USD', B.CHG_AMT, 0)) FRT_USD," ).append("\n"); 
		query.append("  A.USD_XCH_RT," ).append("\n"); 
		query.append("  SUM(DECODE(B.CURR_CD, 'USD', B.CHG_AMT, 0) * B.INV_XCH_RT) EQV_LCL," ).append("\n"); 
		query.append("  SUM(DECODE(B.CHG_CD, 'TVA', B.CHG_AMT, 'IVA', B.CHG_AMT, 0) * B.INV_XCH_RT) TVA_LCL," ).append("\n"); 
		query.append("  SUM(DECODE(B.CHG_CD, 'TVA', 0, 'IVA', 0, DECODE(B.CURR_CD, 'USD', 0, B.CHG_AMT)) * B.INV_XCH_RT) CHG_LCL," ).append("\n"); 
		query.append("  SUM(B.CHG_AMT * B.INV_XCH_RT) TTL_LCL," ).append("\n"); 
		query.append("  D.CUST_RGST_NO VAT_NO," ).append("\n"); 
		query.append("  SUM(DECODE( B.TVA_FLG, 'Y', DECODE(B.CHG_CD, 'TVA', 0, 'IVA', 0, B.CHG_AMT), 0) * B.INV_XCH_RT) TAXABLE_AMT," ).append("\n"); 
		query.append("  SUM(DECODE(NVL(B.TVA_FLG, 'N'), 'Y', 0, DECODE(B.CHG_CD, 'TVA', 0, 'IVA', 0, B.CHG_AMT)) * B.INV_XCH_RT) NON_TAXABLE_AMT," ).append("\n"); 
		query.append("  TO_CHAR(TO_DATE(A.GL_EFF_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') GL_EFF_DT, " ).append("\n"); 
		query.append("  G.DP_PRCS_KNT" ).append("\n"); 
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
		query.append("  AND EXISTS (" ).append("\n"); 
		query.append("    SELECT 'X'" ).append("\n"); 
		query.append("    FROM INV_AR_CHG E" ).append("\n"); 
		query.append("    WHERE B.AR_IF_NO = E.AR_IF_NO" ).append("\n"); 
		query.append("      AND (E.CHG_CD = 'TVA' OR E.CHG_CD = 'IVA')) " ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("GROUP BY A.AR_IF_NO, F.ISS_DT, A.ACT_CUST_CNT_CD||'-'||LPAD(A.ACT_CUST_SEQ, 6, '0'), C.INV_NO, A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD, DECODE(A.IO_BND_CD, 'I', 'I/B', 'O/B'), DECODE(A.IO_BND_CD, 'I', A.POD_CD, 'O', A.POL_CD), A.SAIL_ARR_DT, A.BL_SRC_NO, DECODE(A.REV_TP_CD, 'B', 'B/L', 'C', 'C/A', 'M', 'MRI', NVL(A.REV_TP_CD, '')), A.USD_XCH_RT, D.CUST_RGST_NO, A.GL_EFF_DT, G.DP_PRCS_KNT" ).append("\n"); 

	}
}