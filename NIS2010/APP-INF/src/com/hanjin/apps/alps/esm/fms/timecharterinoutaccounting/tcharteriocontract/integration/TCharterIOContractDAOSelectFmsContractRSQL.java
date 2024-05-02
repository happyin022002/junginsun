/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.03.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see 
 * @since J2EE 1.4
 */

public class TCharterIOContractDAOSelectFmsContractRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOContractDAOSelectFmsContractRSQL
	  * </pre>
	  */
	public TCharterIOContractDAOSelectFmsContractRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("select" ).append("\n"); 
		query.append("flet_ctrt_no," ).append("\n"); 
		query.append("vsl_cd," ).append("\n"); 
		query.append("(select vsl_eng_nm from mdm_vsl_cntr where vsl_cd = fc.vsl_cd and rownum =1) vsl_eng_nm," ).append("\n"); 
		query.append("flet_ctrt_tp_cd," ).append("\n"); 
		query.append("vndr_seq," ).append("\n"); 
		query.append("cust_cnt_cd," ).append("\n"); 
		query.append("cust_seq," ).append("\n"); 
		query.append("CASE WHEN fc.flet_ctrt_tp_cd = 'TO' THEN" ).append("\n"); 
		query.append("(select mv.cust_lgl_eng_nm" ).append("\n"); 
		query.append("from mdm_customer mv, fms_owner fo" ).append("\n"); 
		query.append("where cust_cnt_cd = fc.cust_cnt_cd" ).append("\n"); 
		query.append("and cust_seq = fc.cust_seq" ).append("\n"); 
		query.append("and mv.fms_ownr_seq = fo.ownr_seq" ).append("\n"); 
		query.append("and rownum =1)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(select mv.vndr_lgl_eng_nm" ).append("\n"); 
		query.append("from mdm_vendor mv, fms_owner fo" ).append("\n"); 
		query.append("where vndr_seq = fc.vndr_seq" ).append("\n"); 
		query.append("and mv.fms_ownr_seq = fo.ownr_seq" ).append("\n"); 
		query.append("and rownum =1)" ).append("\n"); 
		query.append("END vndr_lgl_eng_nm," ).append("\n"); 
		query.append("CASE WHEN fc.flet_ctrt_tp_cd = 'TO' THEN" ).append("\n"); 
		query.append("(select fo.ownr_nm" ).append("\n"); 
		query.append("from mdm_customer mv, fms_owner fo" ).append("\n"); 
		query.append("where cust_cnt_cd = fc.cust_cnt_cd" ).append("\n"); 
		query.append("and cust_seq = fc.cust_seq" ).append("\n"); 
		query.append("and mv.fms_ownr_seq = fo.ownr_seq" ).append("\n"); 
		query.append("and rownum =1)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(select fo.ownr_nm" ).append("\n"); 
		query.append("from mdm_vendor mv, fms_owner fo" ).append("\n"); 
		query.append("where vndr_seq = fc.vndr_seq" ).append("\n"); 
		query.append("and mv.fms_ownr_seq = fo.ownr_seq" ).append("\n"); 
		query.append("and rownum =1)" ).append("\n"); 
		query.append("END ownr_nm," ).append("\n"); 
		query.append("vsl_cnt_cd," ).append("\n"); 
		query.append("(select cnt_nm from mdm_country where cnt_cd = fc.vsl_cnt_cd) cnt_nm," ).append("\n"); 
		query.append("ctrt_fact_cd," ).append("\n"); 
		query.append("DECODE(cp_dt,NULL,cp_dt,SUBSTR(cp_dt,1,4) || '/' || SUBSTR(cp_dt,5,2) || '/' || SUBSTR(cp_dt,7,2)) cp_dt," ).append("\n"); 
		query.append("TO_CHAR(eff_dt,'YYYY/MM/DD') eff_dt," ).append("\n"); 
		query.append("TO_CHAR(eff_dt,'HH24:MI') from_time," ).append("\n"); 
		query.append("TO_CHAR(exp_dt,'YYYY/MM/DD') exp_dt," ).append("\n"); 
		query.append("TO_CHAR(exp_dt,'HH24:MI') to_time," ).append("\n"); 
		query.append("decl_flg," ).append("\n"); 
		query.append("acmm_rt_amt," ).append("\n"); 
		query.append("flet_brog_rt_amt," ).append("\n"); 
		query.append("flet_olay_comm_rt_amt," ).append("\n"); 
		query.append("TO_CHAR(TRIM(oa_rsv_amt),'999,999,999,999') oa_rsv_amt," ).append("\n"); 
		query.append("oa_rsv_curr_cd," ).append("\n"); 
		query.append("TO_CHAR(act_foil_bod_qty,'fm999,999,990.000') act_foil_bod_qty," ).append("\n"); 
		query.append("TO_CHAR(act_doil_bod_qty,'999,999,990.000') act_doil_bod_qty," ).append("\n"); 
		query.append("TO_CHAR(act_foil_bor_qty,'999,999,990.000') act_foil_bor_qty," ).append("\n"); 
		query.append("TO_CHAR(act_doil_bor_qty,'999,999,990.000') act_doil_bor_qty," ).append("\n"); 
		query.append("TO_CHAR(foil_bod_out_prc,'999,999,999,990.00') foil_bod_out_prc," ).append("\n"); 
		query.append("TO_CHAR(doil_bod_out_prc,'999,999,999,990.00') doil_bod_out_prc," ).append("\n"); 
		query.append("TO_CHAR(foil_bor_out_prc,'999,999,999,990.00') foil_bor_out_prc," ).append("\n"); 
		query.append("TO_CHAR(doil_bor_out_prc,'999,999,999,990.00') doil_bor_out_prc," ).append("\n"); 
		query.append("DECODE(vsl_bld_dt,NULL,vsl_bld_dt,SUBSTR(vsl_bld_dt,1,4) || '/' || SUBSTR(vsl_bld_dt,5,2) || '/' || SUBSTR(vsl_bld_dt,7,2)) vsl_bld_dt," ).append("\n"); 
		query.append("vsl_dznd_capa," ).append("\n"); 
		query.append("bse_14ton_vsl_capa," ).append("\n"); 
		query.append("TO_CHAR(ddwt_cgo_capa_qty,'999999.00') ddwt_cgo_capa_qty," ).append("\n"); 
		query.append("grs_wgt," ).append("\n"); 
		query.append("nrt_wgt," ).append("\n"); 
		query.append("chtr_prd_opt_ctnt," ).append("\n"); 
		query.append("rde_rng_ctnt," ).append("\n"); 
		query.append("rde_ntc_ctnt," ).append("\n"); 
		query.append("rf_cntr_plg_qty," ).append("\n"); 
		query.append("gr_flg," ).append("\n"); 
		query.append("TO_CHAR(shp_spd_qty,'999999.00') shp_spd_qty" ).append("\n"); 
		query.append("from fms_contract fc" ).append("\n"); 
		query.append("where flet_ctrt_no = @[flet_ctrt_no]" ).append("\n"); 

	}
}