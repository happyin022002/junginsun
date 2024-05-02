/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOInsertWorkOrderPreviewTempCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOInsertWorkOrderPreviewTempCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWorkOrderPreviewIssuedGroup의 SQL
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOInsertWorkOrderPreviewTempCSQL(){
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
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nomi_trkr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nomi_trkr_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_dflt_vndr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3pty_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_fuel_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nego_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_wgt_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toll_fee_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_instr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_sp_cng_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_toll_fee_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_sp_cng_rsn_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rjct_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fctry_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_wy_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_scg_vat_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtn_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fuel_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wtr_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wtr_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_bl_no_iss_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_pst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_frst_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_vat_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc_add_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nego_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_mor_cnddt_aply_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOInsertWorkOrderPreviewTempCSQL").append("\n"); 
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
		query.append("INSERT INTO trs_trsp_wrk_ord_prv_tmp" ).append("\n"); 
		query.append("(		" ).append("\n"); 
		query.append("	trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("	, trsp_so_seq" ).append("\n"); 
		query.append("	, wo_prv_grp_seq " ).append("\n"); 
		query.append("	, wo_iss_sts_cd" ).append("\n"); 
		query.append("	, wo_iss_no" ).append("\n"); 
		query.append("	, vndr_seq" ).append("\n"); 
		query.append("	, wo_cxl_flg" ).append("\n"); 
		query.append("	, dtn_use_flg" ).append("\n"); 
		query.append("	, wo_bl_no_iss_flg" ).append("\n"); 
		query.append("	, curr_cd" ).append("\n"); 
		query.append("	, bzc_amt" ).append("\n"); 
		query.append("	, nego_amt" ).append("\n"); 
		query.append("	, etc_add_amt" ).append("\n"); 
		query.append("	, fuel_scg_amt" ).append("\n"); 
		query.append("	, scg_vat_amt" ).append("\n"); 
		query.append("    , toll_fee_amt" ).append("\n"); 
		query.append("	, ovr_wgt_scg_amt" ).append("\n"); 
		query.append("	, n3pty_bil_flg" ).append("\n"); 
		query.append("	, usd_ttl_amt" ).append("\n"); 
		query.append("	, cust_cnt_cd" ).append("\n"); 
		query.append("	, cust_seq" ).append("\n"); 
		query.append("	, cust_nomi_trkr_flg" ).append("\n"); 
		query.append("	, trsp_agmt_rt_tp_cd" ).append("\n"); 
		query.append("	, trsp_agmt_wy_tp_cd" ).append("\n"); 
		query.append("	, trsp_frst_flg" ).append("\n"); 
		query.append("	, trsp_rjct_rsn_cd" ).append("\n"); 
		query.append("	, trsp_dflt_vndr_flg" ).append("\n"); 
		query.append("	, n1st_nod_pln_dt" ).append("\n"); 
		query.append("	, lst_nod_pln_dt" ).append("\n"); 
		query.append("	, dor_nod_pln_dt" ).append("\n"); 
		query.append("	, inter_rmk" ).append("\n"); 
		query.append("	, spcl_instr_rmk" ).append("\n"); 
		query.append("	, fctry_nm" ).append("\n"); 
		query.append("	, dor_pst_cd" ).append("\n"); 
		query.append("	, cntc_pson_phn_no" ).append("\n"); 
		query.append("	, cntc_pson_fax_no" ).append("\n"); 
		query.append("	, cntc_pson_nm" ).append("\n"); 
		query.append("	, n3pty_cust_cnt_cd" ).append("\n"); 
		query.append("	, n3pty_cust_seq" ).append("\n"); 
		query.append("	, n3pty_desc" ).append("\n"); 
		query.append("	, n3pty_vndr_seq" ).append("\n"); 
		query.append("	, n3pty_ofc_cd" ).append("\n"); 
		query.append("	, n3pty_bil_bzc_amt" ).append("\n"); 
		query.append("	, n3pty_bil_tp_cd" ).append("\n"); 
		query.append("	, n3pty_curr_cd" ).append("\n"); 
		query.append(" 	, cre_usr_id" ).append("\n"); 
		query.append("	, cre_dt" ).append("\n"); 
		query.append("	, upd_usr_id" ).append("\n"); 
		query.append("	, upd_dt" ).append("\n"); 
		query.append("    , wtr_rcv_term_cd" ).append("\n"); 
		query.append("    , wtr_de_term_cd" ).append("\n"); 
		query.append("    , trsp_agmt_ofc_cty_cd" ).append("\n"); 
		query.append("    , trsp_agmt_seq" ).append("\n"); 
		query.append("    , trsp_agmt_cfm_flg" ).append("\n"); 
		query.append("    , trsp_agmt_rt_seq" ).append("\n"); 
		query.append("    , trsp_agmt_upd_dt" ).append("\n"); 
		query.append("    , agmt_mor_cnddt_aply_flg" ).append("\n"); 
		query.append("    , nego_rmk" ).append("\n"); 
		query.append("    , scg_dtl_tmp_seq" ).append("\n"); 
		query.append("    , gline_vndr_seq" ).append("\n"); 
		query.append("    , gline_curr_cd" ).append("\n"); 
		query.append("    , gline_bzc_amt" ).append("\n"); 
		query.append("    , gline_fuel_scg_amt" ).append("\n"); 
		query.append("    , gline_toll_fee_amt" ).append("\n"); 
		query.append("    , gline_scg_vat_amt" ).append("\n"); 
		query.append("    , gline_ttl_amt" ).append("\n"); 
		query.append("	, cust_nomi_trkr_ind_cd" ).append("\n"); 
		query.append("	, trsp_sp_cng_rsn_cd" ).append("\n"); 
		query.append("    , trsp_sp_cng_rsn_rmk" ).append("\n"); 
		query.append("	, vgm_flg" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("VALUES " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	@[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("	, @[trsp_so_seq]" ).append("\n"); 
		query.append("	, @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("	, @[wo_iss_sts_cd]     " ).append("\n"); 
		query.append("	, @[wo_iss_no]      " ).append("\n"); 
		query.append("	, @[vndr_seq]          " ).append("\n"); 
		query.append("	, @[wo_cxl_flg]" ).append("\n"); 
		query.append("	, @[dtn_use_flg]" ).append("\n"); 
		query.append("	, @[wo_bl_no_iss_flg]" ).append("\n"); 
		query.append("	, @[curr_cd]   " ).append("\n"); 
		query.append("	, @[bzc_amt]            " ).append("\n"); 
		query.append("	, @[nego_amt]            " ).append("\n"); 
		query.append("	, @[etc_add_amt]" ).append("\n"); 
		query.append("	, @[fuel_scg_amt]" ).append("\n"); 
		query.append("	, @[scg_vat_amt]        " ).append("\n"); 
		query.append("    , @[toll_fee_amt]             " ).append("\n"); 
		query.append("	, @[ovr_wgt_scg_amt]" ).append("\n"); 
		query.append("	, @[n3pty_bil_flg]    " ).append("\n"); 
		query.append("	, @[usd_ttl_amt]      " ).append("\n"); 
		query.append("	, @[cust_cnt_cd]        " ).append("\n"); 
		query.append("	, @[cust_seq]        " ).append("\n"); 
		query.append("	, @[cust_nomi_trkr_flg]" ).append("\n"); 
		query.append("	, @[trsp_agmt_rt_tp_cd] " ).append("\n"); 
		query.append("	, @[trsp_agmt_wy_tp_cd] " ).append("\n"); 
		query.append("	, @[trsp_frst_flg] " ).append("\n"); 
		query.append("	, @[trsp_rjct_rsn_cd]" ).append("\n"); 
		query.append("	, @[trsp_dflt_vndr_flg]" ).append("\n"); 
		query.append("	, TO_DATE(@[n1st_nod_pln_dt],  'YYYYMMDDHH24MISS') " ).append("\n"); 
		query.append("	, TO_DATE(@[lst_nod_pln_dt],  'YYYYMMDDHH24MISS')	" ).append("\n"); 
		query.append("	, TO_DATE(@[dor_nod_pln_dt],  'YYYYMMDDHH24MISS')    " ).append("\n"); 
		query.append("	, @[inter_rmk]     " ).append("\n"); 
		query.append("	, @[spcl_instr_rmk]" ).append("\n"); 
		query.append("	, @[fctry_nm]     " ).append("\n"); 
		query.append("	, @[dor_pst_cd]" ).append("\n"); 
		query.append("	, @[cntc_pson_phn_no]" ).append("\n"); 
		query.append("	, @[cntc_pson_fax_no]   " ).append("\n"); 
		query.append("	, @[cntc_pson_nm]   " ).append("\n"); 
		query.append("	, @[n3pty_cust_cnt_cd]" ).append("\n"); 
		query.append("	, @[n3pty_cust_seq]  " ).append("\n"); 
		query.append("	, @[n3pty_desc]     " ).append("\n"); 
		query.append("	, @[n3pty_vndr_seq]" ).append("\n"); 
		query.append("	, @[n3pty_ofc_cd]     " ).append("\n"); 
		query.append("	, @[n3pty_bil_bzc_amt]" ).append("\n"); 
		query.append("	, @[n3pty_bil_tp_cd]  " ).append("\n"); 
		query.append("	, @[n3pty_curr_cd]  " ).append("\n"); 
		query.append("	, @[cre_usr_id]" ).append("\n"); 
		query.append("	, sysdate" ).append("\n"); 
		query.append("	, @[upd_usr_id]" ).append("\n"); 
		query.append("	, sysdate" ).append("\n"); 
		query.append("    , @[wtr_rcv_term_cd]" ).append("\n"); 
		query.append("    , @[wtr_de_term_cd]" ).append("\n"); 
		query.append("    , @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("    , @[trsp_agmt_seq]" ).append("\n"); 
		query.append("    , @[trsp_agmt_cfm_flg]" ).append("\n"); 
		query.append("    , @[trsp_agmt_rt_seq]" ).append("\n"); 
		query.append("    , TO_DATE(@[trsp_agmt_upd_dt],  'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("    , @[agmt_mor_cnddt_aply_flg]" ).append("\n"); 
		query.append("    , @[nego_rmk]" ).append("\n"); 
		query.append("    , @[scg_grp_seq]" ).append("\n"); 
		query.append("    , @[gline_vndr_seq]" ).append("\n"); 
		query.append("    , @[gline_curr_cd]" ).append("\n"); 
		query.append("    , @[gline_bzc_amt]" ).append("\n"); 
		query.append("    , @[gline_fuel_scg_amt]" ).append("\n"); 
		query.append("    , @[gline_toll_fee_amt]" ).append("\n"); 
		query.append("    , @[gline_scg_vat_amt]" ).append("\n"); 
		query.append("    , NVL(@[gline_bzc_amt], 0)+NVL(@[gline_fuel_scg_amt], 0)+NVL(@[gline_toll_fee_amt], 0)+NVL(@[gline_scg_vat_amt], 0)" ).append("\n"); 
		query.append("	, @[cust_nomi_trkr_ind_cd]" ).append("\n"); 
		query.append("	, @[trsp_sp_cng_rsn_cd]" ).append("\n"); 
		query.append("    , @[trsp_sp_cng_rsn_rmk]" ).append("\n"); 
		query.append("	, (CASE" ).append("\n"); 
		query.append("         WHEN( (SELECT VGM_WGT" ).append("\n"); 
		query.append("                  FROM BKG_CONTAINER BKCN," ).append("\n"); 
		query.append("                       TRS_TRSP_SVC_ORD TRSO" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND BKCN.BKG_NO = TRSO.BKG_NO" ).append("\n"); 
		query.append("                   AND BKCN.CNTR_NO = TRSO.EQ_NO" ).append("\n"); 
		query.append("                   AND TRSO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                   AND TRSO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("                   AND BKCN.CNTR_DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND TRSO.DELT_FLG = 'N') > 0) THEN 'Y'" ).append("\n"); 
		query.append("         ELSE 'N'" ).append("\n"); 
		query.append("       END)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}