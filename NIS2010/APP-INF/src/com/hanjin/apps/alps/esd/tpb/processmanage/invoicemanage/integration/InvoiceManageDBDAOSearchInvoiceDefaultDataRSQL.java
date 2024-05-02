/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchInvoiceDefaultDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchInvoiceDefaultDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceDefaultData
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchInvoiceDefaultDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("s_n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchInvoiceDefaultDataRSQL").append("\n"); 
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
		query.append("SELECT A.n3pty_no, B.n3pty_inv_no, R.n3pty_inv_rvis_seq, R.n3pty_inv_rvis_cd" ).append("\n"); 
		query.append("      ,B.n3pty_expn_tp_cd, B.n3pty_bil_tp_cd, TPB_GET_N3PTY_BIL_TP_NM_FNC(B.n3pty_bil_tp_cd) AS n3pty_bil_tp_nm" ).append("\n"); 
		query.append("      ,A.n3pty_src_no, eq_no, A.vndr_cust_div_cd" ).append("\n"); 
		query.append("      ,DECODE(B.vndr_cust_div_cd,'V',TO_CHAR(B.vndr_seq),'C',B.CUST_CNT_CD||TO_CHAR(B.cust_seq),'S',B.n3pty_ofc_cd,'') n3pty_cd" ).append("\n"); 
		query.append("      ,DECODE(B.vndr_cust_div_cd,'V',vndr_lgl_eng_nm,'C',cust_lgl_eng_nm,'S',B.n3pty_ofc_cd,'') n3pty_nm" ).append("\n"); 
		query.append("      ,B.vsl_cd||B.skd_voy_no||B.finc_dir_cd AS rev_vvd, B.curr_cd" ).append("\n"); 
		query.append("      ,B.ots_amt" ).append("\n"); 
		query.append("      ,B.inv_amt" ).append("\n"); 
		query.append("      ,TO_CHAR(TPB_GET_LCL_DATE_FNC(B.cfm_dt,@[user_ofc_cd]),'YYYY-MM-DD HH24:MI') AS cfm_dt" ).append("\n"); 
		query.append("      ,TPB_GET_RCVR_ACT_YN_FNC(B.n3pty_no) rcvr_act_yn" ).append("\n"); 
		query.append("      ,'N' AS invoice_able" ).append("\n"); 
		query.append("      ,DECODE(V.ofc_cd,@[user_ofc_cd],'Y','N') AS revise_able" ).append("\n"); 
		query.append("      ,CASE WHEN R.clt_agn_flg='Y' THEN 'N'" ).append("\n"); 
		query.append("            WHEN R.n3pty_inv_sts_cd='N' THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("       END AS erpif_able" ).append("\n"); 
		query.append("      ,( SELECT COUNT(DISTINCT n3pty_bil_tp_cd) FROM TPB_OTS_DTL K WHERE K.n3pty_no=A.n3pty_no ) AS length_n3pty_bil_tp_cd" ).append("\n"); 
		query.append("      ,TO_CHAR(R.ida_tax_seq) as ida_tax_seq" ).append("\n"); 
		query.append("  FROM TPB_OTS_DTL a, TPB_OTS_GRP b, TPB_OTS_GRP_STS c, TPB_INVOICE v, TPB_INV_RVIS r" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND A.n3pty_no = B.n3pty_no" ).append("\n"); 
		query.append("   AND B.n3pty_no = C.n3pty_no" ).append("\n"); 
		query.append("   AND B.n3pty_inv_no = V.n3pty_inv_no" ).append("\n"); 
		query.append("   AND B.n3pty_inv_no = R.n3pty_inv_no" ).append("\n"); 
		query.append("   AND V.lst_n3pty_inv_rvis_seq = R.n3pty_inv_rvis_seq" ).append("\n"); 
		query.append("   AND A.n3pty_no_dp_seq = 1" ).append("\n"); 
		query.append("   AND A.n3pty_delt_tp_cd IN ('N','S')" ).append("\n"); 
		query.append("   AND A.n3pty_bil_tp_cd IN ( SELECT n3pty_bil_tp_cd FROM TPB_N3RD_PTY_BIL_TP WHERE n3pty_bil_tp_cd != 'JO' )" ).append("\n"); 
		query.append("   AND B.n3pty_delt_tp_cd IN ('N')" ).append("\n"); 
		query.append("   AND C.ots_sts_lst_flg = 'Y'" ).append("\n"); 
		query.append("   AND C.ots_sts_cd IN ('I','Y','A','L','N','E')" ).append("\n"); 
		query.append("   AND V.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("   AND R.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("#if (${s_n3pty_no} != '') " ).append("\n"); 
		query.append("   AND A.n3pty_no = @[s_n3pty_no]" ).append("\n"); 
		query.append("#elseif (${s_n3pty_inv_no} != '') " ).append("\n"); 
		query.append("   AND B.n3pty_inv_no = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND 0 = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}