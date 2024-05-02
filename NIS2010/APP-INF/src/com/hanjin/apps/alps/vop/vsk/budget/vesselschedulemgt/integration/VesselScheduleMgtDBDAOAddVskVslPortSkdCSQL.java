/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOAddVskVslPortSkdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.22 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOAddVskVslPortSkdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD Port Schedule 정보를 생성합니다.
	  * 
	  * * History
	  * * 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOAddVskVslPortSkdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("turn_port_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_skp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tztm_hrs",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dlay_rsn_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("init_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_auto_upd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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
		params.put("new_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("shp_call_no_upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("turn_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOAddVskVslPortSkdCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_BUD_VSL_PORT_SKD (" ).append("\n"); 
		query.append("	VSL_CD" ).append("\n"); 
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
		query.append(",	PORT_SKP_TP_CD" ).append("\n"); 
		query.append(",	PORT_SKP_RSN_CD" ).append("\n"); 
		query.append(",	PORT_SKP_RSN_OFFR_RMK" ).append("\n"); 
		query.append(",	TTL_DLAY_HRS" ).append("\n"); 
		query.append(",	TS_PORT_CD" ).append("\n"); 
		query.append(",	USD_FLG" ).append("\n"); 
		query.append(",	NOON_RPT_INP_FLG" ).append("\n"); 
		query.append(",	DEP_RPT_INP_FLG" ).append("\n"); 
		query.append(",	ACT_INP_FLG" ).append("\n"); 
		query.append(",	PRT_CHK_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	SKD_AUTO_UPD_FLG" ).append("\n"); 
		query.append(",	VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append(",	VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append(",	VSL_DLAY_RSN_LOC_CD" ).append("\n"); 
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
		query.append(",	EDI_SND_KNT" ).append("\n"); 
		query.append(",	AUTO_SKD_CNG_FLG" ).append("\n"); 
		query.append(",	LNK_SPD" ).append("\n"); 
		query.append(",	SEA_BUF_HRS" ).append("\n"); 
		query.append(",	PORT_BUF_HRS" ).append("\n"); 
		query.append(",	TZTM_HRS" ).append("\n"); 
		query.append(",	PORT_WRK_HRS" ).append("\n"); 
		query.append(",	LNK_DIST" ).append("\n"); 
		query.append(",	MNVR_OUT_HRS" ).append("\n"); 
		query.append(",	MNVR_IN_HRS" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[skd_voy_no]" ).append("\n"); 
		query.append(",	@[skd_dir_cd]" ).append("\n"); 
		query.append(",	@[vps_port_cd]" ).append("\n"); 
		query.append(",	@[new_clpt_ind_seq]" ).append("\n"); 
		query.append(",	@[clpt_seq]" ).append("\n"); 
		query.append(",	@[slan_cd]" ).append("\n"); 
		query.append(",	@[port_skd_sts_cd]" ).append("\n"); 
		query.append(",	@[yd_cd]" ).append("\n"); 
		query.append(",	@[call_yd_ind_seq]" ).append("\n"); 
		query.append(",	TO_DATE(TRIM(@[pf_eta_dt]), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(TRIM(@[pf_etb_dt]), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(TRIM(@[pf_etd_dt]), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[init_eta_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[init_etb_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[init_etd_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[vps_eta_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[vps_etb_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[vps_etd_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[port_skp_tp_cd]" ).append("\n"); 
		query.append(",	@[port_skp_rsn_cd]" ).append("\n"); 
		query.append(",	@[port_skp_rsn_offr_rmk]" ).append("\n"); 
		query.append(",	NVL(@[ttl_dlay_hrs], 0)" ).append("\n"); 
		query.append(",	@[ts_port_cd]" ).append("\n"); 
		query.append(",	NVL(@[usd_flg], 'N')" ).append("\n"); 
		query.append(",	NVL(@[noon_rpt_inp_flg], 'N')" ).append("\n"); 
		query.append(",	NVL(@[dep_rpt_inp_flg], 'N')" ).append("\n"); 
		query.append(",	NVL(@[act_inp_flg], 'N')" ).append("\n"); 
		query.append(",	NVL(@[prt_chk_flg], 'N')" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append("--,	NVL(TO_DATE([cre_dt], 'YYYYMMDDHH24MI'), SYSDATE)" ).append("\n"); 
		query.append(",       TO_DATE(CASE WHEN LENGTH(@[cre_dt])>=12 THEN" ).append("\n"); 
		query.append("	                SUBSTR(@[cre_dt],1,12)" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("	                TO_CHAR(SYSDATE, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                END, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	NVL(@[skd_auto_upd_flg], 'N')" ).append("\n"); 
		query.append(",	@[vsl_dlay_rsn_cd]" ).append("\n"); 
		query.append(",	@[vsl_dlay_rsn_desc]" ).append("\n"); 
		query.append(",	@[vsl_dlay_rsn_loc_cd]" ).append("\n"); 
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
		query.append(",	NVL(@[turn_port_flg], 'N')" ).append("\n"); 
		query.append(",	@[turn_port_ind_cd]" ).append("\n"); 
		query.append(",	@[turn_skd_voy_no]" ).append("\n"); 
		query.append(",	@[turn_skd_dir_cd]" ).append("\n"); 
		query.append(",	@[turn_clpt_ind_seq]" ).append("\n"); 
		query.append(",	NVL(@[ib_cgo_qty], 0)" ).append("\n"); 
		query.append(",	NVL(@[ob_cgo_qty], 0)" ).append("\n"); 
		query.append(",	@[vps_rmk]" ).append("\n"); 
		query.append(",	@[phs_io_rsn_cd]" ).append("\n"); 
		query.append(",	@[phs_io_rmk]" ).append("\n"); 
		query.append(",	@[skd_brth_no]" ).append("\n"); 
		query.append(",	'Y'" ).append("\n"); 
		query.append(",	NVL(@[ofc_inp_flg], 'N')" ).append("\n"); 
		query.append(",	NVL(@[edi_snd_knt], 0)" ).append("\n"); 
		query.append(",	DECODE(NVL(@[auto_skd_cng_flg], '0'), '1', 'Y', '0', 'N', @[auto_skd_cng_flg])" ).append("\n"); 
		query.append(",	@[lnk_spd]" ).append("\n"); 
		query.append(",	@[sea_buf_hrs]" ).append("\n"); 
		query.append(",	@[port_buf_hrs]" ).append("\n"); 
		query.append(",	@[tztm_hrs]" ).append("\n"); 
		query.append(",	@[port_wrk_hrs]" ).append("\n"); 
		query.append(",	@[lnk_dist]" ).append("\n"); 
		query.append(",	@[mnvr_out_hrs]" ).append("\n"); 
		query.append(",	@[mnvr_in_hrs]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}