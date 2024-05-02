/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOAddVskSwapCstPortCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.26
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2010.05.26 임창빈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang-Bin Lim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOAddVskSwapCstPortCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOAddVskSwapCstPortCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_hndl_20ft_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_spd_estm_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_prod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_hndl_20ft_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_inp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("init_skd_inp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_port_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("init_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_port_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pe_usd_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("phs_io_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnvr_out_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_inp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_40ft_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_skp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tztm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_wrk_hrs",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("plism_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_bnk_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prt_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_call_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_hndl_40ft_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_buf_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_hndl_40ft_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plism_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nxt_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_rpt_inp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_skp_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_skd_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dlay_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnvr_in_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_cng_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plism_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crn_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_20ft_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_call_no_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_bnk_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_hdn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_cgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_skp_rsn_offr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_40ft_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_buf_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dlay_rsn_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_yd_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("max_spd_estm_brth_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("init_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_skd_cng_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_cgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_dlay_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("phs_io_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("noon_rpt_inp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_brth_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("init_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("td_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_call_no_upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_20ft_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOAddVskSwapCstPortCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_SWAP_CST_PORT (" ).append("\n"); 
		query.append("	PORT_SKP_TP_CD" ).append("\n"); 
		query.append(",	PORT_SKP_RSN_CD" ).append("\n"); 
		query.append(",	PORT_SKP_RSN_OFFR_RMK" ).append("\n"); 
		query.append(",	TTL_DLAY_HRS" ).append("\n"); 
		query.append(",	TS_PORT_CD" ).append("\n"); 
		query.append(",	USD_FLG" ).append("\n"); 
		query.append(",	MNVR_OUT_HRS" ).append("\n"); 
		query.append(",	SIM_DT" ).append("\n"); 
		query.append(",	SIM_NO" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	VPS_PORT_CD" ).append("\n"); 
		query.append(",	CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	CLPT_SEQ" ).append("\n"); 
		query.append(",	SLAN_CD" ).append("\n"); 
		query.append(",	PORT_SKD_STS_CD" ).append("\n"); 
		query.append(",	YD_CD" ).append("\n"); 
		query.append(",	CALL_YD_IND_SEQ" ).append("\n"); 
		query.append(",	PF_ETA_DT" ).append("\n"); 
		query.append(",	PF_ETB_DT" ).append("\n"); 
		query.append(",	PF_ETD_DT" ).append("\n"); 
		query.append(",	INIT_ETA_DT" ).append("\n"); 
		query.append(",	INIT_ETB_DT" ).append("\n"); 
		query.append(",	INIT_ETD_DT" ).append("\n"); 
		query.append(",	VPS_ETA_DT" ).append("\n"); 
		query.append(",	VPS_ETB_DT" ).append("\n"); 
		query.append(",	VPS_ETD_DT" ).append("\n"); 
		query.append(",	VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append(",	VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append(",	VPS_LOC_CD" ).append("\n"); 
		query.append(",	SHP_CALL_NO" ).append("\n"); 
		query.append(",	SHP_CALL_NO_UPD_USR_ID" ).append("\n"); 
		query.append(",	SHP_CALL_NO_UPD_DT" ).append("\n"); 
		query.append(",	TML_VSL_CD" ).append("\n"); 
		query.append(",	TML_VOY_NO" ).append("\n"); 
		query.append(",	FT_DT" ).append("\n"); 
		query.append(",	PLISM_YD_CD" ).append("\n"); 
		query.append(",	PLISM_VSL_CD" ).append("\n"); 
		query.append(",	PLISM_VOY_NO" ).append("\n"); 
		query.append(",	SKD_CNG_STS_CD" ).append("\n"); 
		query.append(",	TURN_PORT_FLG" ).append("\n"); 
		query.append(",	TURN_PORT_IND_CD" ).append("\n"); 
		query.append(",	TURN_SKD_VOY_NO" ).append("\n"); 
		query.append(",	TURN_SKD_DIR_CD" ).append("\n"); 
		query.append(",	TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	IB_CGO_QTY" ).append("\n"); 
		query.append(",	OB_CGO_QTY" ).append("\n"); 
		query.append(",	VPS_RMK" ).append("\n"); 
		query.append(",	PHS_IO_RSN_CD" ).append("\n"); 
		query.append(",	PHS_IO_RMK" ).append("\n"); 
		query.append(",	SKD_BRTH_NO" ).append("\n"); 
		query.append(",	INIT_SKD_INP_FLG" ).append("\n"); 
		query.append(",	OFC_INP_FLG" ).append("\n"); 
		query.append(",	NOON_RPT_INP_FLG" ).append("\n"); 
		query.append(",	DEP_RPT_INP_FLG" ).append("\n"); 
		query.append(",	ACT_INP_FLG" ).append("\n"); 
		query.append(",	PRT_CHK_FLG" ).append("\n"); 
		query.append(",	LNK_DIST" ).append("\n"); 
		query.append(",	LNK_SPD" ).append("\n"); 
		query.append(",	TZTM_HRS" ).append("\n"); 
		query.append(",	TD_HRS" ).append("\n"); 
		query.append(",	MNVR_IN_HRS" ).append("\n"); 
		query.append(",	TML_PROD_QTY" ).append("\n"); 
		query.append(",	CRN_KNT" ).append("\n"); 
		query.append(",	PORT_WRK_HRS" ).append("\n"); 
		query.append(",	SEA_BUF_HRS" ).append("\n"); 
		query.append(",	PORT_BUF_HRS" ).append("\n"); 
		query.append(",	ADD_BNK_CSM_QTY" ).append("\n"); 
		query.append(",	ADD_BNK_COST_AMT" ).append("\n"); 
		query.append(",	TS_20FT_TTL_QTY" ).append("\n"); 
		query.append(",	TS_40FT_TTL_QTY" ).append("\n"); 
		query.append(",	TS_20FT_TTL_AMT" ).append("\n"); 
		query.append(",	TS_40FT_TTL_AMT" ).append("\n"); 
		query.append(",	TML_HNDL_20FT_TTL_QTY" ).append("\n"); 
		query.append(",	TML_HNDL_40FT_TTL_QTY" ).append("\n"); 
		query.append(",	TML_HNDL_20FT_TTL_AMT" ).append("\n"); 
		query.append(",	TML_HNDL_40FT_TTL_AMT" ).append("\n"); 
		query.append(",	PE_USD_TTL_AMT" ).append("\n"); 
		query.append(",	NXT_SLAN_CD" ).append("\n"); 
		query.append(",	MAX_SPD_ESTM_BRTH_DT" ).append("\n"); 
		query.append(",	MAX_SPD_ESTM_DEP_DT" ).append("\n"); 
		query.append(",	USR_HDN_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	AUTO_SKD_CNG_FLG" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[port_skp_tp_cd]" ).append("\n"); 
		query.append(",	@[port_skp_rsn_cd]" ).append("\n"); 
		query.append(",	@[port_skp_rsn_offr_rmk]" ).append("\n"); 
		query.append(",	@[ttl_dlay_hrs]" ).append("\n"); 
		query.append(",	@[ts_port_cd]" ).append("\n"); 
		query.append(",	@[usd_flg]" ).append("\n"); 
		query.append(",	NVL(@[mnvr_out_hrs], 0)" ).append("\n"); 
		query.append(",	TO_DATE(@[sim_dt],'YYYYMMDD')" ).append("\n"); 
		query.append(",	LTRIM(TO_CHAR(TO_NUMBER(@[sim_no])))" ).append("\n"); 
		query.append(",	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[skd_voy_no]" ).append("\n"); 
		query.append(",	@[skd_dir_cd]" ).append("\n"); 
		query.append(",	@[vps_port_cd]" ).append("\n"); 
		query.append(",	@[clpt_ind_seq]" ).append("\n"); 
		query.append(",	@[clpt_seq]" ).append("\n"); 
		query.append(",	@[slan_cd]" ).append("\n"); 
		query.append(",	@[port_skd_sts_cd]" ).append("\n"); 
		query.append(",	@[yd_cd]" ).append("\n"); 
		query.append(",	@[call_yd_ind_seq]" ).append("\n"); 
		query.append(",	TO_DATE(@[pf_eta_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[pf_etb_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[pf_etd_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(NVL(@[init_eta_dt], @[vps_eta_dt]),'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(NVL(@[init_etb_dt], @[vps_etb_dt]),'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(NVL(@[init_etd_dt], @[vps_etd_dt]),'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[vps_eta_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[vps_etb_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[vps_etd_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[vsl_dlay_rsn_cd]" ).append("\n"); 
		query.append(",	@[vsl_dlay_rsn_desc]" ).append("\n"); 
		query.append(",	@[vps_loc_cd]" ).append("\n"); 
		query.append(",	@[shp_call_no]" ).append("\n"); 
		query.append(",	@[shp_call_no_upd_usr_id]" ).append("\n"); 
		query.append(",	TO_DATE(@[shp_call_no_upd_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[tml_vsl_cd]" ).append("\n"); 
		query.append(",	@[tml_voy_no]" ).append("\n"); 
		query.append(",	TO_DATE(@[ft_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[plism_yd_cd]" ).append("\n"); 
		query.append(",	@[plism_vsl_cd]" ).append("\n"); 
		query.append(",	@[plism_voy_no]" ).append("\n"); 
		query.append(",	LTRIM(@[skd_cng_sts_cd])" ).append("\n"); 
		query.append(",	@[turn_port_flg]" ).append("\n"); 
		query.append(",	@[turn_port_ind_cd]" ).append("\n"); 
		query.append(",	@[turn_skd_voy_no]" ).append("\n"); 
		query.append(",	@[turn_skd_dir_cd]" ).append("\n"); 
		query.append(",	@[turn_clpt_ind_seq]" ).append("\n"); 
		query.append(",	@[ib_cgo_qty]" ).append("\n"); 
		query.append(",	@[ob_cgo_qty]" ).append("\n"); 
		query.append(",	@[vps_rmk]" ).append("\n"); 
		query.append(",	@[phs_io_rsn_cd]" ).append("\n"); 
		query.append(",	@[phs_io_rmk]" ).append("\n"); 
		query.append(",	@[skd_brth_no]" ).append("\n"); 
		query.append(",	NVL(@[init_skd_inp_flg], 'N')" ).append("\n"); 
		query.append(",	NVL(@[ofc_inp_flg], 'N')" ).append("\n"); 
		query.append(",	NVL(@[noon_rpt_inp_flg], 'N')" ).append("\n"); 
		query.append(",	NVL(@[dep_rpt_inp_flg], 'N')" ).append("\n"); 
		query.append(",	NVL(@[act_inp_flg], 'N')" ).append("\n"); 
		query.append(",	NVL(@[prt_chk_flg], 'N')" ).append("\n"); 
		query.append(",	NVL(@[lnk_dist], 0)" ).append("\n"); 
		query.append(",	NVL(@[lnk_spd], 0)" ).append("\n"); 
		query.append(",	NVL(@[tztm_hrs], 0)" ).append("\n"); 
		query.append(",	NVL(@[td_hrs], 0)" ).append("\n"); 
		query.append(",	NVL(@[mnvr_in_hrs], 0)" ).append("\n"); 
		query.append(",	NVL(@[tml_prod_qty], 0)" ).append("\n"); 
		query.append(",	NVL(@[crn_knt], 0)" ).append("\n"); 
		query.append(",	NVL(@[port_wrk_hrs], 0)" ).append("\n"); 
		query.append(",	NVL(@[sea_buf_hrs], 0)" ).append("\n"); 
		query.append(",	NVL(@[port_buf_hrs], 0)" ).append("\n"); 
		query.append(",	NVL(@[add_bnk_csm_qty], 0)" ).append("\n"); 
		query.append(",	NVL(@[add_bnk_cost_amt], 0)" ).append("\n"); 
		query.append(",	NVL(@[ts_20ft_ttl_qty], 0)" ).append("\n"); 
		query.append(",	NVL(@[ts_40ft_ttl_qty], 0)" ).append("\n"); 
		query.append(",	NVL(@[ts_20ft_ttl_amt], 0)" ).append("\n"); 
		query.append(",	NVL(@[ts_40ft_ttl_amt], 0)" ).append("\n"); 
		query.append(",	NVL(@[tml_hndl_20ft_ttl_qty], 0)" ).append("\n"); 
		query.append(",	NVL(@[tml_hndl_40ft_ttl_qty], 0)" ).append("\n"); 
		query.append(",	NVL(@[tml_hndl_20ft_ttl_amt], 0)" ).append("\n"); 
		query.append(",	NVL(@[tml_hndl_40ft_ttl_amt], 0)" ).append("\n"); 
		query.append(",	@[pe_usd_ttl_amt]" ).append("\n"); 
		query.append(",	@[nxt_slan_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[max_spd_estm_brth_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[max_spd_estm_dep_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	NVL(@[usr_hdn_flg], 'N')" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	NVL(TO_DATE(@[cre_dt], 'YYYYMMDDHH24MI'), SYSDATE)" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",   NVL(TO_DATE(@[upd_dt], 'YYYYMMDDHH24MISS'), SYSDATE)" ).append("\n"); 
		query.append(",	DECODE(NVL(@[auto_skd_cng_flg], '0'), '1', 'Y', '0', 'N', @[auto_skd_cng_flg])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}