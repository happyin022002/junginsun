/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOAddVskActPortSkdCheckingExistCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOAddVskActPortSkdCheckingExistCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK_ACT_PORT_SKD 테이블에 생성될 PK에 대한 데이터 존재유무 확인이후 미존재시 INSERT
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOAddVskActPortSkdCheckingExistCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_brth_ank_off_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_fwddr_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_atd_inp_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_tug_bot_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_gm_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_ata_inp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_low_sulp_foil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dep_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_gbg_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_low_sulp_foil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_frsh_wtr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_aftdr_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_low_sulp_doil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_foil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_gm_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_arr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_atb_inp_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_tug_bot_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plt_lst_unld_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_foil_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_aftdr_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_arr_dlay_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_unbrth_ank_drp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_brth_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_slg_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_brth_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dep_dlay_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_atd_inp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_fwddr_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_doil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_doil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_low_sulp_foil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_frsh_wtr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_low_sulp_doil_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_ata_inp_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_unbrth_ank_off_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_blst_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_brth_ank_drp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_atb_inp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_foil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_low_sulp_doil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_doil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_brth_dlay_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_blst_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spl_frsh_wtr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOAddVskActPortSkdCheckingExistCSQL").append("\n"); 
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
		query.append("INSERT  INTO  VSK_ACT_PORT_SKD  (" ).append("\n"); 
		query.append("                                     VSL_CD" ).append("\n"); 
		query.append("                                  ,  SKD_VOY_NO" ).append("\n"); 
		query.append("                                  ,  SKD_DIR_CD" ).append("\n"); 
		query.append("                                  ,  VPS_PORT_CD" ).append("\n"); 
		query.append("                                  ,  CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                  ,  PORT_SKD_STS_CD" ).append("\n"); 
		query.append("                                  ,  LST_ETA_DT" ).append("\n"); 
		query.append("                                  ,  ACT_ARR_DT" ).append("\n"); 
		query.append("                                  ,  VSL_ARR_DLAY_RSN_CD" ).append("\n"); 
		query.append("                                  ,  ACT_ATA_INP_DT" ).append("\n"); 
		query.append("                                  ,  ACT_ATA_INP_USR_ID" ).append("\n"); 
		query.append("                                  ,  LST_ETB_DT" ).append("\n"); 
		query.append("                                  ,  ACT_BRTH_DT" ).append("\n"); 
		query.append("                                  ,  VSL_BRTH_DLAY_RSN_CD" ).append("\n"); 
		query.append("                                  ,  ACT_ATB_INP_DT" ).append("\n"); 
		query.append("                                  ,  ACT_ATB_INP_USR_ID" ).append("\n"); 
		query.append("                                  ,  LST_ETD_DT" ).append("\n"); 
		query.append("                                  ,  ACT_DEP_DT" ).append("\n"); 
		query.append("                                  ,  VSL_DEP_DLAY_RSN_CD" ).append("\n"); 
		query.append("                                  ,  ACT_ATD_INP_DT" ).append("\n"); 
		query.append("                                  ,  ACT_ATD_INP_USR_ID" ).append("\n"); 
		query.append("                                  ,  ARR_FOIL_WGT" ).append("\n"); 
		query.append("                                  ,  ARR_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("                                  ,  ARR_DOIL_WGT" ).append("\n"); 
		query.append("                                  ,  ARR_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("                                  ,  ARR_FRSH_WTR_WGT" ).append("\n"); 
		query.append("                                  ,  ARR_BLST_WGT" ).append("\n"); 
		query.append("                                  ,  ARR_FWDDR_HGT" ).append("\n"); 
		query.append("                                  ,  ARR_AFTDR_HGT" ).append("\n"); 
		query.append("                                  ,  ARR_GM_HGT" ).append("\n"); 
		query.append("                                  ,  ARR_TUG_BOT_KNT" ).append("\n"); 
		query.append("                                  ,  SPL_FOIL_WGT" ).append("\n"); 
		query.append("                                  ,  SPL_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("                                  ,  SPL_DOIL_WGT" ).append("\n"); 
		query.append("                                  ,  SPL_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("                                  ,  SPL_FRSH_WTR_WGT" ).append("\n"); 
		query.append("                                  ,  DEP_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("                                  ,  DEP_FOIL_WGT" ).append("\n"); 
		query.append("                                  ,  DEP_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("                                  ,  DEP_DOIL_WGT" ).append("\n"); 
		query.append("                                  ,  DEP_FRSH_WTR_WGT" ).append("\n"); 
		query.append("                                  ,  DEP_BLST_WGT" ).append("\n"); 
		query.append("                                  ,  DEP_FWDDR_HGT" ).append("\n"); 
		query.append("                                  ,  DEP_AFTDR_HGT" ).append("\n"); 
		query.append("                                  ,  DEP_GM_HGT" ).append("\n"); 
		query.append("                                  ,  DEP_TUG_BOT_KNT" ).append("\n"); 
		query.append("                                  ,  TTL_SLG_WGT" ).append("\n"); 
		query.append("                                  ,  TTL_GBG_QTY" ).append("\n"); 
		query.append("                                  ,  PLT_LST_UNLD_DT" ).append("\n"); 
		query.append("                                  ,  BFR_BRTH_ANK_DRP_DT" ).append("\n"); 
		query.append("                                  ,  BFR_BRTH_ANK_OFF_DT" ).append("\n"); 
		query.append("                                  ,  AFT_UNBRTH_ANK_DRP_DT" ).append("\n"); 
		query.append("                                  ,  AFT_UNBRTH_ANK_OFF_DT" ).append("\n"); 
		query.append("                                  ,  DIFF_RMK" ).append("\n"); 
		query.append("                                  ,  ACT_ARR_RMK" ).append("\n"); 
		query.append("                                  ,  ACT_BRTH_RMK" ).append("\n"); 
		query.append("                                  ,  ACT_DEP_RMK" ).append("\n"); 
		query.append("                                  ,  CRE_USR_ID" ).append("\n"); 
		query.append("                                  ,	 CRE_DT" ).append("\n"); 
		query.append("                                  ,	 UPD_USR_ID" ).append("\n"); 
		query.append("                                  ,	 UPD_DT" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("SELECT                           " ).append("\n"); 
		query.append("                                    @[vsl_cd]                            							AS  VSL_CD             " ).append("\n"); 
		query.append("                                  , @[skd_voy_no]                                                   AS  SKD_VOY_NO         " ).append("\n"); 
		query.append("                                  , @[skd_dir_cd]                                                   AS  SKD_DIR_CD         " ).append("\n"); 
		query.append("                                  , @[vps_port_cd]                                                  AS  VPS_PORT_CD        " ).append("\n"); 
		query.append("                                  , @[clpt_ind_seq]                                                 AS  CLPT_IND_SEQ       " ).append("\n"); 
		query.append("                                  , @[port_skd_sts_cd]                                              AS  PORT_SKD_STS_CD    " ).append("\n"); 
		query.append("                                  , TO_DATE(@[lst_eta_dt],'YYYYMMDDHH24MI')                         AS  LST_ETA_DT         " ).append("\n"); 
		query.append("                                  , TO_DATE(@[act_arr_dt],'YYYYMMDDHH24MI')                         AS  ACT_ARR_DT         " ).append("\n"); 
		query.append("                                  , @[vsl_arr_dlay_rsn_cd]                                          AS  VSL_ARR_DLAY_RSN_CD" ).append("\n"); 
		query.append("                                  , CASE	WHEN @[act_arr_dt] IS NULL THEN NULL                 " ).append("\n"); 
		query.append("                                      		WHEN @[act_ata_inp_dt] IS NULL THEN SYSDATE    " ).append("\n"); 
		query.append("                                           	ELSE TO_DATE(@[act_ata_inp_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                                    END                                								AS  ACT_ATA_INP_DT    " ).append("\n"); 
		query.append("                                  , CASE 	WHEN @[act_arr_dt] IS NULL THEN NULL" ).append("\n"); 
		query.append("                                       		WHEN @[act_ata_inp_usr_id] IS NULL THEN @[upd_usr_id]" ).append("\n"); 
		query.append("                                       		ELSE @[act_ata_inp_usr_id]" ).append("\n"); 
		query.append("                                    END                                								AS  ACT_ATA_INP_USR_ID" ).append("\n"); 
		query.append("                                  , TO_DATE(@[lst_etb_dt],'YYYYMMDDHH24MI')              			AS  LST_ETB_DT            " ).append("\n"); 
		query.append("                                  , TO_DATE(@[act_brth_dt],'YYYYMMDDHH24MI')                        AS  ACT_BRTH_DT" ).append("\n"); 
		query.append("                                  , @[vsl_brth_dlay_rsn_cd]                                         AS  VSL_BRTH_DLAY_RSN_CD" ).append("\n"); 
		query.append("                                  , CASE 	WHEN @[act_brth_dt] IS NULL THEN NULL" ).append("\n"); 
		query.append("                                       		WHEN @[act_atb_inp_dt] IS NULL THEN SYSDATE" ).append("\n"); 
		query.append("                                       		ELSE TO_DATE(@[act_atb_inp_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                                    END                                								AS  ACT_ATB_INP_DT" ).append("\n"); 
		query.append("                                  , CASE 	WHEN @[act_brth_dt] IS NULL THEN NULL" ).append("\n"); 
		query.append("                                       		WHEN @[act_atb_inp_usr_id] IS NULL THEN @[upd_usr_id]" ).append("\n"); 
		query.append("                                       		ELSE @[act_atb_inp_usr_id]" ).append("\n"); 
		query.append("                                    END                                								AS  ACT_ATB_INP_USR_ID" ).append("\n"); 
		query.append("                                  , TO_DATE(@[lst_etd_dt],'YYYYMMDDHH24MI')              			AS  LST_ETD_DT" ).append("\n"); 
		query.append("                                  , TO_DATE(@[act_dep_dt],'YYYYMMDDHH24MI')                         AS  ACT_DEP_DT" ).append("\n"); 
		query.append("                                  , @[vsl_dep_dlay_rsn_cd]                      					AS  VSL_DEP_DLAY_RSN_CD" ).append("\n"); 
		query.append("                                  , CASE 	WHEN @[act_dep_dt] IS NULL THEN NULL" ).append("\n"); 
		query.append("                                       		WHEN @[act_atd_inp_dt] IS NULL THEN SYSDATE" ).append("\n"); 
		query.append("                                       		ELSE TO_DATE(@[act_atd_inp_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                                    END                                                            AS  ACT_ATD_INP_DT" ).append("\n"); 
		query.append("                                  , CASE	WHEN @[act_dep_dt] IS NULL THEN NULL" ).append("\n"); 
		query.append("                                       		WHEN @[act_atd_inp_usr_id] IS NULL THEN @[upd_usr_id]" ).append("\n"); 
		query.append("                                       		ELSE @[act_atd_inp_usr_id]" ).append("\n"); 
		query.append("                                    END                                								AS  ACT_ATD_INP_USR_ID" ).append("\n"); 
		query.append("                                  , TO_NUMBER(NVL(@[arr_foil_wgt]              , 0))        		AS  ARR_FOIL_WGT         " ).append("\n"); 
		query.append("                                  , TO_NUMBER(NVL(@[arr_low_sulp_foil_wgt]     , 0))                AS  ARR_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("                                  , TO_NUMBER(NVL(@[arr_doil_wgt]              , 0))                AS  ARR_DOIL_WGT         " ).append("\n"); 
		query.append("                                  , TO_NUMBER(NVL(@[arr_low_sulp_doil_wgt]     , 0))                AS  ARR_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[arr_frsh_wtr_wgt]          , 0))                AS	ARR_FRSH_WTR_WGT     " ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[arr_blst_wgt]              , 0))                AS	ARR_BLST_WGT         " ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[arr_fwddr_hgt]             , 0))                AS	ARR_FWDDR_HGT        " ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[arr_aftdr_hgt]             , 0))                AS	ARR_AFTDR_HGT        " ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[arr_gm_hgt]                , 0))                AS	ARR_GM_HGT           " ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[arr_tug_bot_knt]           , 0))                AS	ARR_TUG_BOT_KNT      " ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[spl_foil_wgt]              , 0))                AS	SPL_FOIL_WGT         " ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[spl_low_sulp_foil_wgt]     , 0))                AS	SPL_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[spl_doil_wgt]              , 0))                AS	SPL_DOIL_WGT         " ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[spl_low_sulp_doil_wgt]     , 0))                AS	SPL_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[spl_frsh_wtr_wgt]          , 0))                AS	SPL_FRSH_WTR_WGT     " ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[dep_low_sulp_foil_wgt]     , 0))                AS	DEP_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[dep_foil_wgt]              , 0))                AS	DEP_FOIL_WGT         " ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[dep_low_sulp_doil_wgt]     , 0))                AS	DEP_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[dep_doil_wgt]              , 0))                AS	DEP_DOIL_WGT         " ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[dep_frsh_wtr_wgt]          , 0))                AS	DEP_FRSH_WTR_WGT     " ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[dep_blst_wgt]              , 0))                AS	DEP_BLST_WGT         " ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[dep_fwddr_hgt]             , 0))                AS	DEP_FWDDR_HGT        " ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[dep_aftdr_hgt]             , 0))                AS	DEP_AFTDR_HGT        " ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[dep_gm_hgt]                , 0))                AS	DEP_GM_HGT           " ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[dep_tug_bot_knt]           , 0))                AS	DEP_TUG_BOT_KNT      " ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[ttl_slg_wgt]               , 0))                AS	TTL_SLG_WGT          " ).append("\n"); 
		query.append("                                  ,	TO_NUMBER(NVL(@[ttl_gbg_qty]               , 0))                AS	TTL_GBG_QTY          " ).append("\n"); 
		query.append("                                  ,	TO_DATE(@[plt_lst_unld_dt]       ,'YYYYMMDDHH24MI')             AS	PLT_LST_UNLD_DT      " ).append("\n"); 
		query.append("                                  ,	TO_DATE(@[bfr_brth_ank_drp_dt]   ,'YYYYMMDDHH24MI')             AS	BFR_BRTH_ANK_DRP_DT  " ).append("\n"); 
		query.append("                                  ,	TO_DATE(@[bfr_brth_ank_off_dt]   ,'YYYYMMDDHH24MI')             AS	BFR_BRTH_ANK_OFF_DT  " ).append("\n"); 
		query.append("                                  ,	TO_DATE(@[aft_unbrth_ank_drp_dt] ,'YYYYMMDDHH24MI')             AS	AFT_UNBRTH_ANK_DRP_DT" ).append("\n"); 
		query.append("                                  ,	TO_DATE(@[aft_unbrth_ank_off_dt] ,'YYYYMMDDHH24MI')             AS	AFT_UNBRTH_ANK_OFF_DT" ).append("\n"); 
		query.append("                                  ,	@[diff_rmk]                                                     AS	DIFF_RMK             " ).append("\n"); 
		query.append("                                  ,	@[act_arr_rmk]                                                  AS	ACT_ARR_RMK          " ).append("\n"); 
		query.append("                                  ,	@[act_brth_rmk]                                                 AS	ACT_BRTH_RMK         " ).append("\n"); 
		query.append("                                  ,	@[act_dep_rmk]                                                  AS	ACT_DEP_RMK          " ).append("\n"); 
		query.append("                                  ,	@[cre_usr_id]                                                   AS	CRE_USR_ID           " ).append("\n"); 
		query.append("                                  ,	SYSDATE                                                         AS	CRE_DT               " ).append("\n"); 
		query.append("                                  ,	@[upd_usr_id]                                                   AS	UPD_USR_ID           " ).append("\n"); 
		query.append("                                  ,	SYSDATE                                                         AS	UPD_DT               " ).append("\n"); 
		query.append("FROM                             	DUAL" ).append("\n"); 
		query.append("WHERE                            	NOT EXISTS (SELECT   ''" ).append("\n"); 
		query.append("                                             	FROM     VSK_ACT_PORT_SKD   AK" ).append("\n"); 
		query.append("                                             	WHERE    AK.VSL_CD          = @[vsl_cd]" ).append("\n"); 
		query.append("                                             	AND      AK.SKD_VOY_NO      = @[skd_voy_no] " ).append("\n"); 
		query.append("                                             	AND      AK.SKD_DIR_CD      = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                             	AND      AK.VPS_PORT_CD     = @[vps_port_cd]" ).append("\n"); 
		query.append("                                             	AND      AK.CLPT_IND_SEQ    = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                                            	)                                 " ).append("\n"); 

	}
}