/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOModifyVskVslPortDataOnlyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOModifyVskVslPortDataOnlyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK_VSL_PORT_SKD 에서 키값을 제외한 항목을 수정합니다.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOModifyVskVslPortDataOnlyUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_renm_new_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skp_call_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("init_skd_inp_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("turn_port_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("add_call_xter_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_skp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_cssm_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tztm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("plism_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("first_vir_port_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vt_add_call_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pf_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("priv_call_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_call_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_buf_hrs",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ob_cssm_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_skp_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_renm_new_vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("plism_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_snd_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_call_no_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dlay_rsn_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_buf_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("call_yd_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("auto_skd_cng_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_cgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("vps_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("vsl_renm_old_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_renm_old_vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_call_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsld_wks",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOModifyVskVslPortDataOnlyUSQL").append("\n"); 
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
		query.append("UPDATE		VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("SET			PORT_SKP_TP_CD         = @[port_skp_tp_cd]" ).append("\n"); 
		query.append("		,	PORT_SKP_RSN_CD        = @[port_skp_rsn_cd]" ).append("\n"); 
		query.append("		,	PORT_SKP_RSN_OFFR_RMK  = @[port_skp_rsn_offr_rmk]" ).append("\n"); 
		query.append("		,	TTL_DLAY_HRS           = @[ttl_dlay_hrs]" ).append("\n"); 
		query.append("		,	TS_PORT_CD             = @[ts_port_cd]" ).append("\n"); 
		query.append("		,	USD_FLG                = NVL(@[usd_flg], USD_FLG)" ).append("\n"); 
		query.append("		,	NOON_RPT_INP_FLG       = NVL(@[noon_rpt_inp_flg], NOON_RPT_INP_FLG)" ).append("\n"); 
		query.append("		,	DEP_RPT_INP_FLG        = NVL(@[dep_rpt_inp_flg], DEP_RPT_INP_FLG)" ).append("\n"); 
		query.append("		,	ACT_INP_FLG            = NVL(@[act_inp_flg], ACT_INP_FLG)" ).append("\n"); 
		query.append("		,	PRT_CHK_FLG            = NVL(@[prt_chk_flg], PRT_CHK_FLG)" ).append("\n"); 
		query.append("		,	UPD_USR_ID             = @[upd_usr_id]" ).append("\n"); 
		query.append("		,	UPD_DT                 = SYSDATE" ).append("\n"); 
		query.append("		,	CLPT_SEQ               = NVL(@[clpt_seq], CLPT_SEQ)" ).append("\n"); 
		query.append("		,	SLAN_CD                = NVL(@[slan_cd], SLAN_CD)" ).append("\n"); 
		query.append("		,	PORT_SKD_STS_CD        = NVL(@[port_skd_sts_cd], PORT_SKD_STS_CD)" ).append("\n"); 
		query.append("		,	YD_CD                  = NVL(@[yd_cd], YD_CD)" ).append("\n"); 
		query.append("		,	CALL_YD_IND_SEQ        = NVL(@[call_yd_ind_seq], CALL_YD_IND_SEQ)" ).append("\n"); 
		query.append("		,	VPS_ETA_DT             = NVL(TO_DATE(@[vps_eta_dt], 'YYYYMMDDHH24MI'), VPS_ETA_DT)" ).append("\n"); 
		query.append("		,	VPS_ETB_DT             = NVL(TO_DATE(@[vps_etb_dt], 'YYYYMMDDHH24MI'), VPS_ETB_DT)" ).append("\n"); 
		query.append("		,	VPS_ETD_DT             = NVL(TO_DATE(@[vps_etd_dt], 'YYYYMMDDHH24MI'), VPS_ETD_DT)" ).append("\n"); 
		query.append("		,	VSL_DLAY_RSN_CD        = @[vsl_dlay_rsn_cd]" ).append("\n"); 
		query.append("		,	VSL_DLAY_RSN_DESC      = @[vsl_dlay_rsn_desc]" ).append("\n"); 
		query.append("		,	VSL_DLAY_RSN_LOC_CD    = @[vsl_dlay_rsn_loc_cd]" ).append("\n"); 
		query.append("		,	SHP_CALL_NO            = NVL(@[shp_call_no], SHP_CALL_NO)" ).append("\n"); 
		query.append("		,	SHP_CALL_NO_UPD_USR_ID = NVL(@[shp_call_no_upd_usr_id], SHP_CALL_NO_UPD_USR_ID)" ).append("\n"); 
		query.append("		,	SHP_CALL_NO_UPD_DT     = NVL(TO_DATE(@[shp_call_no_upd_dt], 'YYYYMMDDHH24MI'), SHP_CALL_NO_UPD_DT)" ).append("\n"); 
		query.append("		,	TML_VSL_CD             = LTRIM(NVL(@[tml_vsl_cd], TML_VSL_CD))" ).append("\n"); 
		query.append("		,	TML_VOY_NO             = LTRIM(NVL(@[tml_voy_no], TML_VOY_NO))" ).append("\n"); 
		query.append("		,	FT_DT                  = NVL(TO_DATE(@[ft_dt],'YYYYMMDDHH24MI'), FT_DT)" ).append("\n"); 
		query.append("		,	PLISM_YD_CD            = LTRIM(NVL(@[plism_yd_cd], PLISM_YD_CD))" ).append("\n"); 
		query.append("		,	PLISM_VSL_CD           = LTRIM(NVL(@[plism_vsl_cd], PLISM_VSL_CD))" ).append("\n"); 
		query.append("		,	PLISM_VOY_NO           = LTRIM(NVL(@[plism_voy_no], PLISM_VOY_NO))" ).append("\n"); 
		query.append("		,	SKD_CNG_STS_CD         = LTRIM(NVL(@[skd_cng_sts_cd], SKD_CNG_STS_CD))" ).append("\n"); 
		query.append("		,	TURN_PORT_FLG          = NVL(@[turn_port_flg], TURN_PORT_FLG)" ).append("\n"); 
		query.append("		,	TURN_PORT_IND_CD       = NVL(@[turn_port_ind_cd], TURN_PORT_IND_CD)" ).append("\n"); 
		query.append("		,	TURN_SKD_VOY_NO        = @[turn_skd_voy_no]" ).append("\n"); 
		query.append("		,	TURN_SKD_DIR_CD        = @[turn_skd_dir_cd]" ).append("\n"); 
		query.append("		,	TURN_CLPT_IND_SEQ      = @[turn_clpt_ind_seq]	/* turn_clpt_ind_seq 값이 0일 경우 Null 값으로 입력되므로 nvl을 사용 못함. */" ).append("\n"); 
		query.append("		,	IB_CGO_QTY             = NVL(@[ib_cgo_qty], IB_CGO_QTY)" ).append("\n"); 
		query.append("		,	OB_CGO_QTY             = NVL(@[ob_cgo_qty], OB_CGO_QTY)" ).append("\n"); 
		query.append("		,	VPS_RMK                = @[vps_rmk]" ).append("\n"); 
		query.append("		,	PHS_IO_RSN_CD          = LTRIM(NVL(@[phs_io_rsn_cd], PHS_IO_RSN_CD))" ).append("\n"); 
		query.append("		,	PHS_IO_RMK             = LTRIM(NVL(@[phs_io_rmk], PHS_IO_RMK))" ).append("\n"); 
		query.append("		,	SKD_BRTH_NO            = NVL(@[skd_brth_no], SKD_BRTH_NO)" ).append("\n"); 
		query.append("		,	INIT_SKD_INP_FLG       = NVL(@[init_skd_inp_flg], INIT_SKD_INP_FLG)" ).append("\n"); 
		query.append("		,	OFC_INP_FLG            = NVL(@[ofc_inp_flg], OFC_INP_FLG)" ).append("\n"); 
		query.append("		,	EDI_SND_KNT            = NVL(@[edi_snd_knt], EDI_SND_KNT)" ).append("\n"); 
		query.append("		,	AUTO_SKD_CNG_FLG       = NVL(DECODE(@[auto_skd_cng_flg], '1', 'Y', '0', 'N', @[auto_skd_cng_flg]), AUTO_SKD_CNG_FLG)" ).append("\n"); 
		query.append("		,	LNK_SPD                = NVL(@[lnk_spd], LNK_SPD)" ).append("\n"); 
		query.append("		,	SEA_BUF_HRS            = NVL(@[sea_buf_hrs], SEA_BUF_HRS)" ).append("\n"); 
		query.append("		,	PORT_BUF_HRS           = NVL(@[port_buf_hrs], PORT_BUF_HRS)" ).append("\n"); 
		query.append("		,	TZTM_HRS               = NVL(@[tztm_hrs], TZTM_HRS)" ).append("\n"); 
		query.append("		,	PORT_WRK_HRS           = NVL(@[port_wrk_hrs], PORT_WRK_HRS)" ).append("\n"); 
		query.append("		,	LNK_DIST               = NVL(@[lnk_dist], LNK_DIST)" ).append("\n"); 
		query.append("		,	MNVR_OUT_HRS           = NVL(@[mnvr_out_hrs], MNVR_OUT_HRS)" ).append("\n"); 
		query.append("		,	MNVR_IN_HRS            = NVL(@[mnvr_in_hrs], MNVR_IN_HRS)" ).append("\n"); 
		query.append("--		,	PF_ETA_DT              = CASE WHEN [pf_eta_dt] = 'XXX' THEN NULL ELSE NVL(TO_DATE([pf_eta_dt], 'YYYYMMDDHH24MI'), PF_ETA_DT) END" ).append("\n"); 
		query.append("--		,	PF_ETB_DT              = CASE WHEN [pf_etb_dt] = 'XXX' THEN NULL ELSE NVL(TO_DATE([pf_etb_dt], 'YYYYMMDDHH24MI'), PF_ETB_DT) END" ).append("\n"); 
		query.append("--		,	PF_ETD_DT              = CASE WHEN [pf_etd_dt] = 'XXX' THEN NULL ELSE NVL(TO_DATE([pf_etd_dt], 'YYYYMMDDHH24MI'), PF_ETD_DT) END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	PF_ETA_DT              = NVL2(@[pf_eta_dt], TO_DATE(@[pf_eta_dt], 'YYYYMMDDHH24MI'), NULL)" ).append("\n"); 
		query.append("		,	PF_ETB_DT              = NVL2(@[pf_etb_dt], TO_DATE(@[pf_etb_dt], 'YYYYMMDDHH24MI'), NULL)" ).append("\n"); 
		query.append("		,	PF_ETD_DT              = NVL2(@[pf_etd_dt], TO_DATE(@[pf_etd_dt], 'YYYYMMDDHH24MI'), NULL)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		----,	IB_CSSM_VOY_NO         = DECODE([ib_cssm_voy_no] , 'XXX', NULL, NVL([ib_cssm_voy_no], IB_CSSM_VOY_NO))" ).append("\n"); 
		query.append("		----,	OB_CSSM_VOY_NO         = DECODE([ob_cssm_voy_no] , 'XXX', NULL, NVL([ob_cssm_voy_no], OB_CSSM_VOY_NO))" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			--::ADD:2015-05-15:by TOP::--" ).append("\n"); 
		query.append("		,	IB_CSSM_VOY_NO		   = " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	        CASE 	--WHEN [cssm_voy_init_cre_flg] = 'N'															THEN IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("					WHEN @[ib_cssm_voy_no]   IS NOT NULL    																		THEN @[ib_cssm_voy_no]" ).append("\n"); 
		query.append("					WHEN (SELECT SL.VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE SL WHERE SL.VSL_SLAN_CD = @[slan_cd]) = 'O' 				THEN" ).append("\n"); 
		query.append("					--------------------------------------------- <FEEDER SERVICE LANE> ----------------------------------------------" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("					CASE" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] = 'N' 			AND @[turn_port_flg] = 'N' 			AND @[turn_skd_voy_no] IS NULL 		AND @[clpt_seq] = '1' THEN ''		-- FIRST ONE AMONG ALL PORTS --" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] = 'N' 			AND @[turn_port_flg] = 'N' 			AND @[turn_skd_voy_no] IS NULL 							  THEN @[skd_voy_no]||@[skd_dir_cd]" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] = 'N' 			AND @[turn_port_flg] = 'Y' 			AND @[turn_skd_voy_no] IS NOT NULL	THEN @[turn_skd_voy_no]||@[turn_skd_dir_cd]" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] = 'Y' 			AND @[turn_skd_voy_no] IS NOT NULL 	AND @[clpt_seq] = '1'				THEN @[turn_skd_voy_no]||@[turn_skd_dir_cd]" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] = 'Y' 			AND @[turn_skd_voy_no] IS NOT NULL 										THEN @[skd_voy_no]||@[skd_dir_cd] 	-- FIRST PORT AMONG SECOND DIR. PORTS --" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] = 'F'			AND @[turn_skd_voy_no] IS NOT NULL 										THEN @[skd_voy_no]||@[skd_dir_cd]	-- FIRST VIR. PORT --" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] IN ('D','V')	AND @[turn_skd_voy_no] IS NOT NULL 	AND @[first_vir_port_flg] = 'Y'		THEN @[skd_voy_no]||@[skd_dir_cd]	-- FIRST VIR. PORT --" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] IN ('D','V')	AND @[turn_skd_voy_no] IS NOT NULL 										THEN @[turn_skd_voy_no]||@[turn_skd_dir_cd]" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("					------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("					ELSE" ).append("\n"); 
		query.append("					--------------------------------------------- <TRUNK SERVICE LANE> -----------------------------------------------" ).append("\n"); 
		query.append("					CASE" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] = 'N' 			AND @[turn_port_flg] = 'N' 			AND @[turn_skd_voy_no] IS NULL 		AND @[clpt_seq] = '1' THEN ''		-- FIRST ONE AMONG ALL PORTS --" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] = 'N' 			AND @[turn_port_flg] = 'N' 			AND @[turn_skd_voy_no] IS NULL 							  THEN SUBSTR(@[skd_voy_no],2,4)||@[skd_dir_cd]" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] = 'N' 			AND @[turn_port_flg] = 'Y' 			AND @[turn_skd_voy_no] IS NOT NULL	THEN SUBSTR(@[turn_skd_voy_no],2,4)||@[turn_skd_dir_cd]" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] = 'Y' 			AND @[turn_skd_voy_no] IS NOT NULL 	AND @[clpt_seq] = '1'				THEN SUBSTR(@[turn_skd_voy_no],2,4)||@[turn_skd_dir_cd]" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] = 'Y' 			AND @[turn_skd_voy_no] IS NOT NULL 										THEN SUBSTR(@[skd_voy_no],2,4)||@[skd_dir_cd] 	-- FIRST PORT AMONG SECOND DIR. PORTS --" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] = 'F'			AND @[turn_skd_voy_no] IS NOT NULL 										THEN SUBSTR(@[skd_voy_no],2,4)||@[skd_dir_cd]	-- FIRST VIR. PORT --" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] IN ('D','V')	AND @[turn_skd_voy_no] IS NOT NULL 	AND @[first_vir_port_flg] = 'Y'		THEN SUBSTR(@[skd_voy_no],2,4)||@[skd_dir_cd]	-- FIRST VIR. PORT --" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] IN ('D','V')	AND @[turn_skd_voy_no] IS NOT NULL 										THEN SUBSTR(@[turn_skd_voy_no],2,4)||@[turn_skd_dir_cd]" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("					------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("			END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	OB_CSSM_VOY_NO		   = " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			CASE 	WHEN @[turn_port_ind_cd] IN ('D','V','F')														THEN ''" ).append("\n"); 
		query.append("					WHEN @[ob_cssm_voy_no]   IS NOT NULL    														THEN @[ob_cssm_voy_no]" ).append("\n"); 
		query.append("					WHEN (SELECT SL.VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE SL WHERE SL.VSL_SLAN_CD = @[slan_cd]) = 'O' THEN" ).append("\n"); 
		query.append("					--------------------------------------------- <FEEDER SERVICE LANE> ----------------------------------------------" ).append("\n"); 
		query.append("					CASE 	" ).append("\n"); 
		query.append("					WHEN @[vt_add_call_flg]	 = 'Y'				THEN ''" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] IN ('Y','N')		THEN @[skd_voy_no]||@[skd_dir_cd]" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] IN ('D','V','F')	THEN ''" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("					------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("					ELSE" ).append("\n"); 
		query.append("					--------------------------------------------- <TRUNK SERVICE LANE> -----------------------------------------------" ).append("\n"); 
		query.append("					CASE 	" ).append("\n"); 
		query.append("					WHEN @[vt_add_call_flg]	 = 'Y'				THEN ''" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] IN ('Y','N')		THEN SUBSTR(@[skd_voy_no],2,4)||@[skd_dir_cd]" ).append("\n"); 
		query.append("					WHEN @[turn_port_ind_cd] IN ('D','V','F')	THEN ''" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("					------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("			END" ).append("\n"); 
		query.append("			-----------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			--::ADD:2015-07-13:by TOP::--" ).append("\n"); 
		query.append("		,	VT_ADD_CALL_FLG		   = CASE 	WHEN @[vt_add_call_flg] IS NULL THEN @[vt_add_call_flg]" ).append("\n"); 
		query.append("											WHEN @[vt_add_call_flg]	= 'Y'	THEN 'Y'" ).append("\n"); 
		query.append("									 END" ).append("\n"); 
		query.append("        ,   VSL_RENM_OLD_VSL_CD    = @[vsl_renm_old_vsl_cd]" ).append("\n"); 
		query.append("        ,   VSL_RENM_OLD_VSL_ENG_NM= @[vsl_renm_old_vsl_eng_nm]" ).append("\n"); 
		query.append("        ,   VSL_RENM_NEW_VSL_CD    = @[vsl_renm_new_vsl_cd]" ).append("\n"); 
		query.append("        ,   VSL_RENM_NEW_VSL_ENG_NM= @[vsl_renm_new_vsl_eng_nm]" ).append("\n"); 
		query.append("        ,   VSLD_WKS               = @[vsld_wks]" ).append("\n"); 
		query.append("        ,   SKP_CALL_FLG           = @[skp_call_flg]" ).append("\n"); 
		query.append("        ,   ADD_CALL_FLG           = @[add_call_flg]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    ,   ADD_CALL_XTER_FLG	   = DECODE(@[add_call_xter_flg],'1','Y','N')" ).append("\n"); 
		query.append("		,	PRIV_CALL_FLG		   = @[priv_call_flg]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE		VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND			SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("AND			SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND			VPS_PORT_CD  = @[vps_port_cd]" ).append("\n"); 
		query.append("AND			CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 

	}
}