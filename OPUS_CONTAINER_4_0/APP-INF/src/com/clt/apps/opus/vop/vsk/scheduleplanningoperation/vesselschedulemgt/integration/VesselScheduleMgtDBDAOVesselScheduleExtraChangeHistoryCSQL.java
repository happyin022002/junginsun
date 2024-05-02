/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOVesselScheduleExtraChangeHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.04 
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

public class VesselScheduleMgtDBDAOVesselScheduleExtraChangeHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Creation for Vessel Schedule History without Bookings
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOVesselScheduleExtraChangeHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_call_yd_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_call_yd_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_atch_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vskd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_cng_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_skd_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_cng_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vskd_cng_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_skd_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOVesselScheduleExtraChangeHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO	VSK_VSL_SKD_HIS" ).append("\n"); 
		query.append("			(	VSKD_CNG_NO" ).append("\n"); 
		query.append("			,	BKG_ATCH_FLG" ).append("\n"); 
		query.append("			,	VSKD_TP_CD" ).append("\n"); 
		query.append("			,	VSKD_CNG_TP_CD" ).append("\n"); 
		query.append("			,	BFR_SKD_STS_CD" ).append("\n"); 
		query.append("			,	BFR_VSL_SLAN_CD" ).append("\n"); 
		query.append("			,	BFR_VSL_CD" ).append("\n"); 
		query.append("			,	BFR_SKD_VOY_NO" ).append("\n"); 
		query.append("			,	BFR_SKD_DIR_CD" ).append("\n"); 
		query.append("			,	BFR_VPS_PORT_CD" ).append("\n"); 
		query.append("			,	BFR_CLPT_IND_SEQ" ).append("\n"); 
		query.append("			,	BFR_YD_CD" ).append("\n"); 
		query.append("			,	BFR_CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("			,	BFR_VPS_ETA_DT" ).append("\n"); 
		query.append("			,	BFR_VPS_ETB_DT" ).append("\n"); 
		query.append("			,	BFR_VPS_ETD_DT" ).append("\n"); 
		query.append("			,	AFT_SKD_STS_CD" ).append("\n"); 
		query.append("			,	AFT_VSL_SLAN_CD" ).append("\n"); 
		query.append("			,	AFT_VSL_CD" ).append("\n"); 
		query.append("			,	AFT_SKD_VOY_NO" ).append("\n"); 
		query.append("			,	AFT_SKD_DIR_CD" ).append("\n"); 
		query.append("			,	AFT_VPS_PORT_CD" ).append("\n"); 
		query.append("			,	AFT_CLPT_IND_SEQ" ).append("\n"); 
		query.append("			,	AFT_YD_CD" ).append("\n"); 
		query.append("			,	AFT_CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("			,	AFT_VPS_ETA_DT" ).append("\n"); 
		query.append("			,	AFT_VPS_ETB_DT" ).append("\n"); 
		query.append("			,	AFT_VPS_ETD_DT" ).append("\n"); 
		query.append("			,	DIFF_RMK" ).append("\n"); 
		query.append("			,	SKD_CNG_ID" ).append("\n"); 
		query.append("			,	SKD_CNG_DESC" ).append("\n"); 
		query.append("			,	CRE_USR_ID" ).append("\n"); 
		query.append("			,	CRE_DT" ).append("\n"); 
		query.append("			,	UPD_USR_ID" ).append("\n"); 
		query.append("			,	UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			,	BFR_PF_SVC_TP_CD" ).append("\n"); 
		query.append("			,	AFT_PF_SVC_TP_CD" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("VALUES		(	LTRIM(TO_CHAR(VSK_VSL_SKD_HIS_SEQ.NEXTVAL, '00000000000000'))	-- <old:VSK_VSL_SKD_DEL_SEQ> --" ).append("\n"); 
		query.append("			,	NVL(@[bkg_atch_flg]		, '*'	)								-- 'Y':WITH BOOKINGS, 'N':WITHOUT BOOKINGS --" ).append("\n"); 
		query.append("			,	NVL(@[vskd_tp_cd]		, '*'	)" ).append("\n"); 
		query.append("			,	@[vskd_cng_tp_cd]" ).append("\n"); 
		query.append("			,	@[bfr_skd_sts_cd]" ).append("\n"); 
		query.append("			,	@[bfr_vsl_slan_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			,	NVL(@[bfr_vsl_cd]		,'****'	)" ).append("\n"); 
		query.append("			,	NVL(@[bfr_skd_voy_no]	,'****'	)" ).append("\n"); 
		query.append("			,	NVL(@[bfr_skd_dir_cd]	,'*'	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			,	@[bfr_vps_port_cd]" ).append("\n"); 
		query.append("			,	@[bfr_clpt_ind_seq]" ).append("\n"); 
		query.append("			,	@[bfr_yd_cd]" ).append("\n"); 
		query.append("			,	@[bfr_call_yd_ind_seq]" ).append("\n"); 
		query.append("			,	TO_DATE(@[bfr_vps_eta_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("			,	TO_DATE(@[bfr_vps_etb_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("			,	TO_DATE(@[bfr_vps_etd_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("			,	@[aft_skd_sts_cd]" ).append("\n"); 
		query.append("			,	@[aft_vsl_slan_cd]" ).append("\n"); 
		query.append("			,	@[aft_vsl_cd]" ).append("\n"); 
		query.append("			,	@[aft_skd_voy_no]" ).append("\n"); 
		query.append("			,	@[aft_skd_dir_cd]" ).append("\n"); 
		query.append("			,	@[aft_vps_port_cd]" ).append("\n"); 
		query.append("			,	@[aft_clpt_ind_seq]" ).append("\n"); 
		query.append("			,	@[aft_yd_cd]" ).append("\n"); 
		query.append("			,	@[aft_call_yd_ind_seq]" ).append("\n"); 
		query.append("			,	TO_DATE(@[aft_vps_eta_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("			,	TO_DATE(@[aft_vps_etb_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("			,	TO_DATE(@[aft_vps_etd_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("			,	@[diff_rmk]" ).append("\n"); 
		query.append("			,	@[skd_cng_id]" ).append("\n"); 
		query.append("			,	@[skd_cng_desc]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			,	NVL(@[upd_usr_id],'SYSTEM')" ).append("\n"); 
		query.append("			,	SYSDATE" ).append("\n"); 
		query.append("			,	NVL(@[upd_usr_id],'SYSTEM')" ).append("\n"); 
		query.append("			,	SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			,	@[bfr_pf_svc_tp_cd]" ).append("\n"); 
		query.append("			,	NULL" ).append("\n"); 
		query.append("			)" ).append("\n"); 

	}
}