/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOFmsOwnrAcctSlpAutoFilterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.06.23 최우석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDBDAOFmsOwnrAcctSlpAutoFilterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auto Matching Balance Filter
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOFmsOwnrAcctSlpAutoFilterRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("select distinct" ).append("\n"); 
		query.append("#if (${sheet_no} == \"1\")" ).append("\n"); 
		query.append("decode(A.stl_flg,'Y','1','N','0') stl_flg," ).append("\n"); 
		query.append("'' stl_flg1," ).append("\n"); 
		query.append("A.flet_ppay_rlt_cd," ).append("\n"); 
		query.append("A.acct_cd," ).append("\n"); 
		query.append("A.ctr_cd," ).append("\n"); 
		query.append("A.eff_dt," ).append("\n"); 
		query.append("A.n1st_curr_cd," ).append("\n"); 
		query.append("A.n1st_amt," ).append("\n"); 
		query.append("A.n1st_amt n1st_amt1," ).append("\n"); 
		query.append("A.n2nd_curr_cd," ).append("\n"); 
		query.append("A.n2nd_amt," ).append("\n"); 
		query.append("A.locl_xch_rt_amt act_xch_rt_amt," ).append("\n"); 
		query.append("A.csr_slp_flg apro_flg," ).append("\n"); 
		query.append("A.ap_desc," ).append("\n"); 
		query.append("A.ap_desc ap_desc1," ).append("\n"); 
		query.append("A.ap_desc ap_desc2," ).append("\n"); 
		query.append("A.ap_desc ap_desc3," ).append("\n"); 
		query.append("A.ap_desc ap_desc4," ).append("\n"); 
		query.append("A.ap_desc ap_desc5," ).append("\n"); 
		query.append("(A.vsl_cd || A.skd_voy_no || A.skd_dir_cd || A.rev_dir_cd) vvd_cd," ).append("\n"); 
		query.append("(A.vsl_cd || A.skd_voy_no || A.skd_dir_cd || A.rev_dir_cd) vvd_cd1," ).append("\n"); 
		query.append("(A.slp_tp_cd || A.slp_func_cd || A.slp_ofc_cd || A.slp_iss_dt || A.slp_ser_no || A.slp_seq_no) org_slp_no," ).append("\n"); 
		query.append("(A.slp_tp_cd || A.slp_func_cd || A.slp_ofc_cd || A.slp_iss_dt || A.slp_ser_no || A.slp_seq_no) org_slp_no1," ).append("\n"); 
		query.append("A.man_hr_flg," ).append("\n"); 
		query.append("A.slp_tp_cd," ).append("\n"); 
		query.append("A.slp_func_cd," ).append("\n"); 
		query.append("A.slp_ofc_cd slp_team_cd," ).append("\n"); 
		query.append("A.slp_iss_dt," ).append("\n"); 
		query.append("A.slp_ser_no," ).append("\n"); 
		query.append("A.slp_seq_no," ).append("\n"); 
		query.append("A.vsl_cd," ).append("\n"); 
		query.append("A.skd_voy_no," ).append("\n"); 
		query.append("A.skd_dir_cd," ).append("\n"); 
		query.append("A.rev_dir_cd" ).append("\n"); 
		query.append("#elseif (${sheet_no} == \"2\")" ).append("\n"); 
		query.append("decode(B.stl_flg,'Y','1','N','0') stl_flg," ).append("\n"); 
		query.append("'' stl_flg1," ).append("\n"); 
		query.append("B.flet_ppay_rlt_cd," ).append("\n"); 
		query.append("B.acct_cd," ).append("\n"); 
		query.append("B.ctr_cd," ).append("\n"); 
		query.append("B.eff_dt," ).append("\n"); 
		query.append("B.n1st_curr_cd," ).append("\n"); 
		query.append("B.n1st_amt," ).append("\n"); 
		query.append("B.n1st_amt n1st_amt1," ).append("\n"); 
		query.append("B.n2nd_curr_cd," ).append("\n"); 
		query.append("B.n2nd_amt," ).append("\n"); 
		query.append("B.locl_xch_rt_amt act_xch_rt_amt," ).append("\n"); 
		query.append("B.csr_slp_flg apro_flg," ).append("\n"); 
		query.append("B.ap_desc," ).append("\n"); 
		query.append("B.ap_desc ap_desc1," ).append("\n"); 
		query.append("B.ap_desc ap_desc2," ).append("\n"); 
		query.append("B.ap_desc ap_desc3," ).append("\n"); 
		query.append("B.ap_desc ap_desc4," ).append("\n"); 
		query.append("B.ap_desc ap_desc5," ).append("\n"); 
		query.append("(B.vsl_cd || B.skd_voy_no || B.skd_dir_cd || B.rev_dir_cd) vvd_cd," ).append("\n"); 
		query.append("(B.vsl_cd || B.skd_voy_no || B.skd_dir_cd || B.rev_dir_cd) vvd_cd1," ).append("\n"); 
		query.append("(B.slp_tp_cd || B.slp_func_cd || B.slp_ofc_cd || B.slp_iss_dt || B.slp_ser_no || B.slp_seq_no) org_slp_no," ).append("\n"); 
		query.append("(B.slp_tp_cd || B.slp_func_cd || B.slp_ofc_cd || B.slp_iss_dt || B.slp_ser_no || B.slp_seq_no) org_slp_no1," ).append("\n"); 
		query.append("B.man_hr_flg," ).append("\n"); 
		query.append("B.slp_tp_cd," ).append("\n"); 
		query.append("B.slp_func_cd," ).append("\n"); 
		query.append("B.slp_ofc_cd slp_team_cd," ).append("\n"); 
		query.append("B.slp_iss_dt," ).append("\n"); 
		query.append("B.slp_ser_no," ).append("\n"); 
		query.append("B.slp_seq_no," ).append("\n"); 
		query.append("B.vsl_cd," ).append("\n"); 
		query.append("B.skd_voy_no," ).append("\n"); 
		query.append("B.skd_dir_cd," ).append("\n"); 
		query.append("B.rev_dir_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("from fms_ownr_acct_slp A, fms_ownr_acct_slp B" ).append("\n"); 
		query.append("where A.n1st_amt = (B.n1st_amt*-1)" ).append("\n"); 
		query.append("and A.n1st_amt >= 0" ).append("\n"); 
		query.append("and A.eff_dt >= @[eff_dt1]" ).append("\n"); 
		query.append("and A.eff_dt <= @[eff_dt2]" ).append("\n"); 
		query.append("and B.n1st_amt < 0" ).append("\n"); 
		query.append("and B.eff_dt >= @[eff_dt1]" ).append("\n"); 
		query.append("and B.eff_dt <= @[eff_dt2]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd} != \"\")" ).append("\n"); 
		query.append("and A.vsl_cd = @[vsl_cd]" ).append("\n"); 
		query.append("and B.vsl_cd = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_cd} != \"\")" ).append("\n"); 
		query.append("and A.slp_ofc_cd like substr(@[loc_cd],3,3) || '%'" ).append("\n"); 
		query.append("and B.slp_ofc_cd like substr(@[loc_cd],3,3) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sheet_no} == \"1\")" ).append("\n"); 
		query.append("order by A.slp_tp_cd, A.slp_func_cd, A.slp_ofc_cd, A.slp_iss_dt, A.slp_ser_no, A.slp_seq_no" ).append("\n"); 
		query.append("#elseif (${sheet_no} == \"2\")" ).append("\n"); 
		query.append("order by B.slp_tp_cd, B.slp_func_cd, B.slp_ofc_cd, B.slp_iss_dt, B.slp_ser_no, B.slp_seq_no" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOFmsOwnrAcctSlpAutoFilterRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}