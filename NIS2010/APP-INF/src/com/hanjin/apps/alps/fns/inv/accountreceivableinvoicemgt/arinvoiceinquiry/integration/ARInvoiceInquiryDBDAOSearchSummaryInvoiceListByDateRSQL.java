/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchSummaryInvoiceListByDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.10 
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

public class ARInvoiceInquiryDBDAOSearchSummaryInvoiceListByDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회조건에 따라 Good Date or Issue date에 해당하는 AR Invoice  Summary정보를  조회한다.
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchSummaryInvoiceListByDateRSQL(){
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
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchSummaryInvoiceListByDateRSQL").append("\n"); 
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
		query.append("SELECT TB.AR_OFC_CD," ).append("\n"); 
		query.append("TB.DATE_VALUE," ).append("\n"); 
		query.append("DECODE(TB.IO_BND_CD, 'I', 'I/B', 'O', 'O/B') IO_BND_CD," ).append("\n"); 
		query.append("COUNT(DISTINCT TB.AR_IF_NO) COUNT," ).append("\n"); 
		query.append("SUM(TB.USD_AMT) USD_AMT," ).append("\n"); 
		query.append("SUM(TB.USD_EQV_AMT) USD_EQV_AMT," ).append("\n"); 
		query.append("SUM(TB.LCL_AMT) LCL_AMT," ).append("\n"); 
		query.append("SUM(TB.ETC_CUR_EQV_AMT) ETC_CUR_EQV_AMT," ).append("\n"); 
		query.append("SUM(TB.TTL_LCL_AMT) TTL_LCL_AMT," ).append("\n"); 
		query.append("TB.DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("#if (${date_option} != 'S')" ).append("\n"); 
		query.append("SELECT /*+ ORDERED */ A.AR_OFC_CD," ).append("\n"); 
		query.append("#if (${date_option} == 'G')" ).append("\n"); 
		query.append("A.BL_INV_CFM_DT DATE_VALUE," ).append("\n"); 
		query.append("#elseif (${date_option} == 'E')" ).append("\n"); 
		query.append("A.GL_EFF_DT DATE_VALUE," ).append("\n"); 
		query.append("#elseif (${date_option} == 'I')" ).append("\n"); 
		query.append("A.BL_INV_IF_DT DATE_VALUE," ).append("\n"); 
		query.append("#elseif (${date_option} == 'A')" ).append("\n"); 
		query.append("A.SAIL_ARR_DT DATE_VALUE," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("A.AR_IF_NO," ).append("\n"); 
		query.append("A.IO_BND_CD," ).append("\n"); 
		query.append("DECODE(A.IO_BND_CD, 'O', 1, 'I', 2) IO_BND_CD_ORDER," ).append("\n"); 
		query.append("A.LOCL_CURR_CD," ).append("\n"); 
		query.append("B.CURR_CD," ).append("\n"); 
		query.append("CASE WHEN B.CURR_CD = 'USD' AND D.AR_CURR_CD != 'USD' THEN B.CHG_AMT ELSE 0 END USD_AMT," ).append("\n"); 
		query.append("CASE WHEN B.CURR_CD = 'USD' AND D.AR_CURR_CD != 'USD' THEN ROUND(B.CHG_AMT * B.INV_XCH_RT, E.DP_PRCS_KNT) ELSE 0 END USD_EQV_AMT," ).append("\n"); 
		query.append("CASE WHEN B.CURR_CD = A.LOCL_CURR_CD THEN B.CHG_AMT ELSE 0 END LCL_AMT," ).append("\n"); 
		query.append("CASE WHEN B.CURR_CD != A.LOCL_CURR_CD AND B.CURR_CD != 'USD' THEN ROUND(B.CHG_AMT * B.INV_XCH_RT, E.DP_PRCS_KNT) ELSE 0 END ETC_CUR_EQV_AMT," ).append("\n"); 
		query.append("ROUND(B.CHG_AMT * B.INV_XCH_RT, E.DP_PRCS_KNT) TTL_LCL_AMT," ).append("\n"); 
		query.append("E.DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("INV_AR_CHG B," ).append("\n"); 
		query.append("MDM_ORGANIZATION D," ).append("\n"); 
		query.append("MDM_CURRENCY E" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = D.OFC_CD" ).append("\n"); 
		query.append("#if (${office} != '')" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = @[office] -- OFFICE" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.AR_OFC_CD IN ( SELECT OFC_CD -- OFC ALL 선택시 적용.." ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[user_ofc_cd]))" ).append("\n"); 
		query.append("AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.LOCL_CURR_CD = E.CURR_CD" ).append("\n"); 
		query.append("#if (${date_option} == 'G')" ).append("\n"); 
		query.append("AND A.BL_INV_CFM_DT BETWEEN REPLACE(@[from_date], '-', '') AND REPLACE(@[to_date], '-', '')" ).append("\n"); 
		query.append("#elseif (${date_option} == 'E')" ).append("\n"); 
		query.append("AND A.GL_EFF_DT BETWEEN REPLACE(@[from_date], '-', '') AND REPLACE(@[to_date], '-', '')" ).append("\n"); 
		query.append("#elseif (${date_option} == 'I')" ).append("\n"); 
		query.append("AND A.BL_INV_IF_DT BETWEEN REPLACE(@[from_date], '-', '') AND REPLACE(@[to_date], '-', '')" ).append("\n"); 
		query.append("#elseif (${date_option} == 'A')" ).append("\n"); 
		query.append("AND A.SAIL_ARR_DT BETWEEN REPLACE(@[from_date], '-', '') AND REPLACE(@[to_date], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${issue_flag} != '')" ).append("\n"); 
		query.append("AND A.INV_ISS_FLG = @[issue_flag]" ).append("\n"); 
		query.append("AND B.INV_ISS_FLG = @[issue_flag]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${issue_flag} == 'N')" ).append("\n"); 
		query.append("AND  A.INV_CLR_FLG     = 'N'" ).append("\n"); 
		query.append("AND  B.INV_CLR_FLG     = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chg_cd} != 'All')" ).append("\n"); 
		query.append("AND B.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_seq} != '')" ).append("\n"); 
		query.append("AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_tp_cd} != '')" ).append("\n"); 
		query.append("AND A.REV_TP_CD = @[rev_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scope} != '')" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[scope]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_src_cd} != '')" ).append("\n"); 
		query.append("${rev_src_cd}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("AND A.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("#if ((${bound} == 'I') && (${port} != ''))" ).append("\n"); 
		query.append("AND A.POD_CD = @[port]" ).append("\n"); 
		query.append("#elseif ((${bound} == 'O') && (${port} != ''))" ).append("\n"); 
		query.append("AND A.POL_CD = @[port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${port} != '')" ).append("\n"); 
		query.append("AND ((A.IO_BND_CD = 'I' AND A.POD_CD = @[port]) OR (A.IO_BND_CD = 'O' AND A.POL_CD = @[port]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT A.AR_OFC_CD," ).append("\n"); 
		query.append("ISS.DATE_VALUE," ).append("\n"); 
		query.append("A.AR_IF_NO," ).append("\n"); 
		query.append("A.IO_BND_CD," ).append("\n"); 
		query.append("DECODE(A.IO_BND_CD, 'O', 1, 'I', 2) IO_BND_CD_ORDER," ).append("\n"); 
		query.append("A.LOCL_CURR_CD," ).append("\n"); 
		query.append("B.CURR_CD," ).append("\n"); 
		query.append("CASE WHEN B.CURR_CD = 'USD' THEN B.CHG_AMT ELSE 0 END USD_AMT," ).append("\n"); 
		query.append("CASE WHEN B.CURR_CD = 'USD' AND C.AR_CURR_CD != 'USD' THEN ROUND(B.CHG_AMT * B.INV_XCH_RT, D.DP_PRCS_KNT) ELSE 0 END USD_EQV_AMT," ).append("\n"); 
		query.append("CASE WHEN B.CURR_CD = A.LOCL_CURR_CD AND C.AR_CURR_CD != 'USD' THEN B.CHG_AMT ELSE 0 END LCL_AMT," ).append("\n"); 
		query.append("CASE WHEN B.CURR_CD != A.LOCL_CURR_CD AND B.CURR_CD != 'USD' THEN ROUND(B.CHG_AMT * B.INV_XCH_RT, D.DP_PRCS_KNT) ELSE 0 END ETC_CUR_EQV_AMT," ).append("\n"); 
		query.append("ROUND(B.CHG_AMT * B.INV_XCH_RT, D.DP_PRCS_KNT) TTL_LCL_AMT," ).append("\n"); 
		query.append("D.DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT /*+ index(A XAK1INV_AR_ISS)  */ DISTINCT I.ISS_DT DATE_VALUE," ).append("\n"); 
		query.append("D.AR_IF_NO," ).append("\n"); 
		query.append("D.CHG_SEQ" ).append("\n"); 
		query.append("FROM INV_AR_ISS I," ).append("\n"); 
		query.append("INV_AR_ISS_DTL D" ).append("\n"); 
		query.append("WHERE D.INV_NO = I.INV_NO" ).append("\n"); 
		query.append("AND I.ISS_DT BETWEEN REPLACE(@[from_date], '-', '') AND REPLACE(@[to_date], '-', '')" ).append("\n"); 
		query.append("AND I.ISS_OFC_CD IN (" ).append("\n"); 
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("#if (${office} != '')" ).append("\n"); 
		query.append("WHERE AR_OFC_CD = @[office])) ISS," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE AR_OFC_CD IN ( SELECT OFC_CD -- OFC ALL 선택시 적용.." ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[user_ofc_cd]))" ).append("\n"); 
		query.append("AND OFC_CD = AR_OFC_CD ))) ISS," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("INV_AR_MN A," ).append("\n"); 
		query.append("INV_AR_CHG B," ).append("\n"); 
		query.append("MDM_ORGANIZATION C," ).append("\n"); 
		query.append("MDM_CURRENCY D" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("AND B.AR_IF_NO = ISS.AR_IF_NO" ).append("\n"); 
		query.append("AND B.CHG_SEQ = ISS.CHG_SEQ" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND A.LOCL_CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${issue_flag} != '')" ).append("\n"); 
		query.append("AND A.INV_ISS_FLG = @[issue_flag]" ).append("\n"); 
		query.append("AND B.INV_ISS_FLG = @[issue_flag]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${issue_flag} == 'N')" ).append("\n"); 
		query.append("AND  A.INV_CLR_FLG     = 'N'" ).append("\n"); 
		query.append("AND  B.INV_CLR_FLG     = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chg_cd} != 'All')" ).append("\n"); 
		query.append("AND B.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_seq} != '')" ).append("\n"); 
		query.append("AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_tp_cd} != '')" ).append("\n"); 
		query.append("AND A.REV_TP_CD = @[rev_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scope} != '')" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[scope]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_src_cd} != '')" ).append("\n"); 
		query.append("${rev_src_cd}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("AND A.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("#if ((${bound} == 'I') && (${port} != ''))" ).append("\n"); 
		query.append("AND A.POD_CD = @[port]" ).append("\n"); 
		query.append("#elseif ((${bound} == 'O') && (${port} != ''))" ).append("\n"); 
		query.append("AND A.POL_CD = @[port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${port} != '')" ).append("\n"); 
		query.append("AND ((A.IO_BND_CD = 'I' AND A.POD_CD = @[port]) OR (A.IO_BND_CD = 'O' AND A.POL_CD = @[port]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") TB" ).append("\n"); 
		query.append("GROUP BY TB.AR_OFC_CD, TB.DATE_VALUE, TB.IO_BND_CD, TB.DP_PRCS_KNT" ).append("\n"); 
		query.append("ORDER BY TB.AR_OFC_CD, TB.DATE_VALUE, TB.IO_BND_CD_ORDER" ).append("\n"); 

	}
}