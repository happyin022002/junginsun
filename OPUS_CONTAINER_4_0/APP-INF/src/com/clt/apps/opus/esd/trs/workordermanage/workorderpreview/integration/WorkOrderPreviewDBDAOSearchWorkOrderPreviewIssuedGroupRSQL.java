/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssuedGroupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.23
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.06.23 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssuedGroupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWorkOrderPreviewIssuedGroup
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssuedGroupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("n3pty_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pkup_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_dflt_vndr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wo_cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_kgs_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_lbs_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wgt_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dor_pst_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3pty_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3pty_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3pty_bil_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("etc_add_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_rjct_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fctry_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3pty_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_frst_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntc_pson_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssuedGroupRSQL").append("\n"); 
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
		query.append("SELECT trsp_so_ofc_cty_cd							" ).append("\n"); 
		query.append("	  ,trsp_so_seq									" ).append("\n"); 
		query.append("	  ,@[wo_prv_grp_seq] wo_prv_grp_seq" ).append("\n"); 
		query.append("	  ,@[wo_iss_sts_cd] wo_iss_sts_cd" ).append("\n"); 
		query.append("	  ,1 wo_iss_no" ).append("\n"); 
		query.append("	  ,NVL(@[vndr_seq], vndr_seq) vndr_seq" ).append("\n"); 
		query.append("	  ,NVL(@[wo_cxl_flg], 'N') wo_cxl_flg" ).append("\n"); 
		query.append("	  ,NVL(@[dtn_use_flg],dtn_use_flg)	dtn_use_flg" ).append("\n"); 
		query.append("	  ,NVL(@[wo_bl_no_iss_flg],wo_bl_no_iss_flg) wo_bl_no_iss_flg" ).append("\n"); 
		query.append("	  ,NVL(@[curr_cd],curr_cd) curr_cd" ).append("\n"); 
		query.append("	  ,NVL(@[bzc_amt],bzc_amt) bzc_amt" ).append("\n"); 
		query.append("	  ,NVL(@[nego_amt],nego_amt) nego_amt" ).append("\n"); 
		query.append("	  ,NVL(@[etc_add_amt],etc_add_amt) etc_add_amt" ).append("\n"); 
		query.append("	  ,NVL(@[fuel_scg_amt],fuel_scg_amt) fuel_scg_amt" ).append("\n"); 
		query.append("	  ,NVL(@[ovr_wgt_scg_amt],ovr_wgt_scg_amt) ovr_wgt_scg_amt		" ).append("\n"); 
		query.append("	  ,NVL(@[n3pty_bil_flg],n3pty_bil_flg) n3pty_bil_flg			" ).append("\n"); 
		query.append("	  ,@[usd_ttl_amt] usd_ttl_amt" ).append("\n"); 
		query.append("	  ,NVL(@[cust_cnt_cd],cust_cnt_cd) cust_cnt_cd" ).append("\n"); 
		query.append("	  ,NVL(@[cust_seq],cust_seq) cust_seq		" ).append("\n"); 
		query.append("	  ,NVL(@[cust_nomi_trkr_flg],cust_nomi_trkr_flg) cust_nomi_trkr_flg" ).append("\n"); 
		query.append("	  ,NVL(@[trsp_agmt_rt_tp_cd],trsp_agmt_rt_tp_cd) trsp_agmt_rt_tp_cd" ).append("\n"); 
		query.append("	  ,NVL(@[trsp_agmt_wy_tp_cd],trsp_agmt_wy_tp_cd) trsp_agmt_wy_tp_cd" ).append("\n"); 
		query.append("	  ,NVL(@[trsp_frst_flg],trsp_frst_flg) trsp_frst_flg			" ).append("\n"); 
		query.append("	  ,NVL(@[trsp_rjct_rsn_cd],trsp_rjct_rsn_cd) trsp_rjct_rsn_cd	" ).append("\n"); 
		query.append("	  ,NVL(@[trsp_dflt_vndr_flg],trsp_dflt_vndr_flg) trsp_dflt_vndr_flg" ).append("\n"); 
		query.append("	  ,NVL(@[n1st_nod_pln_dt],TO_CHAR(n1st_nod_pln_dt, 'YYYYMMDDHH24MISS')) n1st_nod_pln_dt" ).append("\n"); 
		query.append("	  ,NVL(@[lst_nod_pln_dt],TO_CHAR(lst_nod_pln_dt, 'YYYYMMDDHH24MISS')) lst_nod_pln_dt" ).append("\n"); 
		query.append("	  ,NVL(@[dor_nod_pln_dt],TO_CHAR(dor_nod_pln_dt, 'YYYYMMDDHH24MISS')) dor_nod_pln_dt" ).append("\n"); 
		query.append("	  ,NVL(@[inter_rmk],inter_rmk) inter_rmk					" ).append("\n"); 
		query.append("	  ,NVL(@[spcl_instr_rmk],spcl_instr_rmk) spcl_instr_rmk" ).append("\n"); 
		query.append("	  ,NVL(@[fctry_nm],fctry_nm) fctry_nm		" ).append("\n"); 
		query.append("	  ,NVL(@[dor_pst_cd],dor_pst_cd) dor_pst_cd" ).append("\n"); 
		query.append("	  ,NVL(@[cntc_pson_phn_no],cntc_pson_phn_no) cntc_pson_phn_no" ).append("\n"); 
		query.append("	  ,NVL(@[cntc_pson_fax_no],cntc_pson_fax_no) cntc_pson_fax_no" ).append("\n"); 
		query.append("	  ,NVL(@[cntc_pson_nm],cntc_pson_nm) cntc_pson_nm" ).append("\n"); 
		query.append("	  ,@[n3pty_cust_cnt_cd] n3pty_cust_cnt_cd" ).append("\n"); 
		query.append("	  ,@[n3pty_cust_seq] n3pty_cust_seq" ).append("\n"); 
		query.append("	  ,@[n3pty_desc] n3pty_desc" ).append("\n"); 
		query.append("	  ,@[n3pty_vndr_seq] n3pty_vndr_seq" ).append("\n"); 
		query.append("	  ,@[n3pty_ofc_cd] n3pty_ofc_cd" ).append("\n"); 
		query.append("	  ,@[n3pty_bil_bzc_amt] n3pty_bil_bzc_amt" ).append("\n"); 
		query.append("	  ,@[n3pty_bil_tp_cd] n3pty_bil_tp_cd" ).append("\n"); 
		query.append("	  ,@[n3pty_curr_cd] n3pty_curr_cd" ).append("\n"); 
		query.append("	  ,@[trsp_agmt_ofc_cty_cd] trsp_agmt_ofc_cty_cd" ).append("\n"); 
		query.append("	  ,@[trsp_agmt_seq] trsp_agmt_seq" ).append("\n"); 
		query.append("	  ,NVL(@[wgt_meas_ut_cd], wgt_meas_ut_cd) wgt_meas_ut_cd" ).append("\n"); 
		query.append("	  ,NVL(@[cntr_kgs_wgt], cntr_kgs_wgt) cntr_kgs_wgt" ).append("\n"); 
		query.append("      ,NVL(@[cntr_lbs_wgt], cntr_lbs_wgt) cntr_lbs_wgt" ).append("\n"); 
		query.append("	  ,CASE WHEN  TRSP_COST_DTL_MOD_CD = 'CY'  OR (TRSP_COST_DTL_MOD_CD = 'DR'  AND TRS_GET_FOC_INFO_FNC(BL_NO, TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ, NULL) = DECODE(SUBSTR(DOR_NOD_CD, 1, 2), 'US', 'YYY', 'YY') ) THEN @[cntr_pkup_no] END cntr_pkup_no" ).append("\n"); 
		query.append("      ,@[scg_ind_cd] scg_ind_cd" ).append("\n"); 
		query.append("  FROM trs_trsp_svc_ord" ).append("\n"); 
		query.append(" WHERE trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 

	}
}