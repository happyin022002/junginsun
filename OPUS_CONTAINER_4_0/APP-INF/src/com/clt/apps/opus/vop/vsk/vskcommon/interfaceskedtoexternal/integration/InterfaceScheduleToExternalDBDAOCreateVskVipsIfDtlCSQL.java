/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VIPS I/F 목적의 DETAIL DATA 생성
	  * </pre>
	  */
	public InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vips_if_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pf_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vips_act_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vips_ib_consortium_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clpt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vips_act_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vips_act_brth_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("init_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vips_vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vips_vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("init_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vips_vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vips_ob_consortium_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_skd_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration").append("\n"); 
		query.append("FileName : InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_VSL_SKD_VIPS_IF_DTL" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("   VSL_CD" ).append("\n"); 
		query.append("  ,SKD_VOY_NO" ).append("\n"); 
		query.append("  ,SKD_DIR_CD" ).append("\n"); 
		query.append("  ,VIPS_IF_SEQ" ).append("\n"); 
		query.append("  ,VPS_PORT_CD" ).append("\n"); 
		query.append("  ,CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,CLPT_SEQ" ).append("\n"); 
		query.append("  ,PORT_SKD_STS_CD" ).append("\n"); 
		query.append("  ,YD_CD" ).append("\n"); 
		query.append("  ,CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("  ,SKD_CNG_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,VIPS_IB_CONSORTIUM_VOY_NO " ).append("\n"); 
		query.append("  ,VIPS_OB_CONSORTIUM_VOY_NO " ).append("\n"); 
		query.append("  ,PF_ETA_DT" ).append("\n"); 
		query.append("  ,PF_ETB_DT" ).append("\n"); 
		query.append("  ,PF_ETD_DT" ).append("\n"); 
		query.append("  ,INIT_ETA_DT             " ).append("\n"); 
		query.append("  ,INIT_ETB_DT" ).append("\n"); 
		query.append("  ,INIT_ETD_DT             " ).append("\n"); 
		query.append("  ,VIPS_VPS_ETA_DT" ).append("\n"); 
		query.append("  ,VIPS_VPS_ETB_DT" ).append("\n"); 
		query.append("  ,VIPS_VPS_ETD_DT" ).append("\n"); 
		query.append("  ,VIPS_ACT_ARR_DT" ).append("\n"); 
		query.append("  ,VIPS_ACT_BRTH_DT" ).append("\n"); 
		query.append("  ,VIPS_ACT_DEP_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,VIPS_MODI_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,TURN_PORT_FLG" ).append("\n"); 
		query.append("  ,TURN_PORT_IND_CD" ).append("\n"); 
		query.append("  ,TURN_SKD_VOY_NO " ).append("\n"); 
		query.append("  ,TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("  ,TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("  ,VIPS_LOD_IND_CD" ).append("\n"); 
		query.append("  ,VIPS_DCHG_IND_CD" ).append("\n"); 
		query.append("  ,VIPS_PASS_IND_CD" ).append("\n"); 
		query.append("  ,SKD_UPD_USR_ID" ).append("\n"); 
		query.append("  ,SKD_UPD_USR_NM" ).append("\n"); 
		query.append("  ,SKD_UPD_DT" ).append("\n"); 
		query.append("  ,ADD_CALL_FLG" ).append("\n"); 
		query.append("  ,VT_ADD_CALL_FLG      " ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("   VALUES" ).append("\n"); 
		query.append("    ( " ).append("\n"); 
		query.append("    @[vsl_cd]" ).append("\n"); 
		query.append("    , @[skd_voy_no]" ).append("\n"); 
		query.append("    , @[skd_dir_cd] " ).append("\n"); 
		query.append("    , @[vips_if_seq]" ).append("\n"); 
		query.append("  , @[vps_port_cd]" ).append("\n"); 
		query.append("  , @[clpt_ind_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  , @[clpt_seq]" ).append("\n"); 
		query.append("  , @[port_skd_sts_cd]" ).append("\n"); 
		query.append("  , @[yd_cd]" ).append("\n"); 
		query.append("  , @[call_yd_ind_seq]" ).append("\n"); 
		query.append("  , @[skd_cng_sts_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  , @[vips_ib_consortium_voy_no]" ).append("\n"); 
		query.append("  , @[vips_ob_consortium_voy_no]" ).append("\n"); 
		query.append("   , TO_DATE(@[pf_eta_dt]      , 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("  , TO_DATE(@[pf_etb_dt]      , 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("  , TO_DATE(@[pf_etd_dt]      , 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("  , TO_DATE(@[init_eta_dt]    , 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("  , TO_DATE(@[init_etb_dt]    , 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("  , TO_DATE(@[init_etd_dt]    , 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("  , TO_DATE(@[vips_vps_eta_dt]  , 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("  , TO_DATE(@[vips_vps_etb_dt]  , 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("  , TO_DATE(@[vips_vps_etd_dt]  , 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("  , TO_DATE(@[vips_act_arr_dt]  , 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("  , TO_DATE(@[vips_act_brth_dt]  , 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("  , TO_DATE(@[vips_act_dep_dt]  , 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  , (SELECT MODI_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = @[vps_port_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, @[turn_port_flg]" ).append("\n"); 
		query.append("	, @[turn_port_ind_cd]" ).append("\n"); 
		query.append("	, @[turn_skd_voy_no]" ).append("\n"); 
		query.append("	, @[turn_skd_dir_cd]" ).append("\n"); 
		query.append("	, @[turn_clpt_ind_seq]" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	,(CASE WHEN @[turn_port_ind_cd]  IN('D','V','F') THEN '' ELSE 'Y' END ) -- vips_lod_ind_cd" ).append("\n"); 
		query.append("	 --Only can Discharging in case 'D','V','F'" ).append("\n"); 
		query.append("	,(CASE WHEN @[clpt_seq] = '1' THEN '' ELSE 'Y' END) -- vips_dchg_ind_cd" ).append("\n"); 
		query.append("	 --Only can Loading in case clpt_seq='1' in same vvd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, 'Y' -- vips_pass_ind_cd (all Y)" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	, (CASE WHEN @[skd_upd_usr_id] = 'IF_EDI_SVC' THEN 'IF_EDI' ELSE @[skd_upd_usr_id] END)" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	, NVL((SELECT USR_NM  FROM COM_USER WHERE USR_ID = @[skd_upd_usr_id]),'IF_EDI') --skd_upd_usr_nm" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	, TO_DATE(@[skd_upd_dt]			, 'YYYYMMDDHH24MI') --skd_upd_dt" ).append("\n"); 
		query.append("	, @[add_call_flg]" ).append("\n"); 
		query.append(" 	, @[vt_add_call_flg]" ).append("\n"); 
		query.append("	, 'VIPS_IF'" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , 'VIPS_IF'" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}