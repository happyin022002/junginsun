/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOSearchCSRSummary1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOSearchCSRSummary1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCSRSummary1
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOSearchCSRSummary1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOSearchCSRSummary1RSQL").append("\n"); 
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
		query.append("SELECT a.cost_ofc_cd cost_ofc_cd" ).append("\n"); 
		query.append("		,a.vndr_seq vndr_no" ).append("\n"); 
		query.append("		,b.vndr_lgl_eng_nm vndr_seq_name" ).append("\n"); 
		query.append("		,count(a.vndr_seq) cnt_inv" ).append("\n"); 
		query.append("		,a.curr_cd curr_cd" ).append("\n"); 
		query.append("		,sum(NVL(a.ttl_inv_amt,0)+NVL(a.vat_amt,0)) total_amt" ).append("\n"); 
		query.append("		,TO_CHAR(max(a.iss_dt),'YYYY-MM-DD') iss_dt" ).append("\n"); 
		query.append("		,TO_CHAR(max(a.rcv_dt),'YYYY-MM-DD') rcv_dt" ).append("\n"); 
		query.append("		,b.gen_pay_term_cd" ).append("\n"); 
		query.append("		,DECODE(b.gen_pay_term_cd, 'O60', 'KR H/O Payment_60', b.gen_pay_term_cd) gen_pay_term_desc" ).append("\n"); 
		query.append("		,DECODE(b.gen_pay_term_cd, 'IN',  TO_CHAR(max(a.iss_dt) + 5, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("							,'OUT', TO_CHAR(max(a.iss_dt) + 60, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("							,'O60', ''" ).append("\n"); 
		query.append("							,'O45', ''" ).append("\n"); 
		query.append("							,TO_CHAR(max(a.iss_dt) + TO_NUMBER(b.gen_pay_term_cd), 'YYYY-MM-DD')) payment_due_dt" ).append("\n"); 
		query.append("		,b.pay_term_tp_cd" ).append("\n"); 
		query.append("FROM tes_tml_so_hdr a, mdm_vendor b" ).append("\n"); 
		query.append("WHERE a.inv_ofc_cd = @[inv_ofc_cd]" ).append("\n"); 
		query.append("	AND a.tml_inv_sts_cd = 'C'" ).append("\n"); 
		query.append("	AND a.tml_inv_rjct_sts_cd in ('NL','RL')" ).append("\n"); 
		query.append("#if (${inv_cfm_dt} != '') " ).append("\n"); 
		query.append("	AND to_char(a.inv_cfm_dt,'YYYY-MM-DD') = @[inv_cfm_dt]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("	AND a.vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND a.vndr_seq = b.vndr_seq" ).append("\n"); 
		query.append("	AND NVL(a.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("	a.cost_ofc_cd" ).append("\n"); 
		query.append("	,a.vndr_seq" ).append("\n"); 
		query.append("	,b.vndr_lgl_eng_nm" ).append("\n"); 
		query.append("	,a.curr_cd" ).append("\n"); 
		query.append("	,b.gen_pay_term_cd" ).append("\n"); 
		query.append("	,b.pay_term_tp_cd" ).append("\n"); 

	}
}