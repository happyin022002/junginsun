/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SetupDBDAOFcmVslCntrRgstVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.04.04 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.setup.setup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SetupDBDAOFcmVslCntrRgstVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Registration 정보를 변경한다.
	  * 
	  * History
	  * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
	  * </pre>
	  */
	public SetupDBDAOFcmVslCntrRgstVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mn_eng_rpm_pwr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_aux_blw_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnvr_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_adtv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_sub_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mn_eng_mkr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_tnk_cbm_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tbcgr_coff_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_aux_blw_mkr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_aux_blw_tp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_tnk_mt_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mn_eng_bhp_pwr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_max_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tbcgr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnr_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_stl_svc_tnk_mt_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_min_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hl_pnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tbcgr_mkr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnd_line_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tbcgr_tp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_gnr_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mn_eng_tp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tbcgr_rpm_pwr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.setup.setup.integration").append("\n"); 
		query.append("FileName : SetupDBDAOFcmVslCntrRgstVOUSQL").append("\n"); 
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
		query.append("MERGE INTO FCM_VSL_CNTR_RGST" ).append("\n"); 
		query.append("USING DUAL ON(VSL_CD = @[vsl_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("	UPDATE SET" ).append("\n"); 
		query.append("     VSL_CLSS_SUB_CD           = @[vsl_clss_sub_cd]" ).append("\n"); 
		query.append("	,MN_ENG_MKR_NM             = @[mn_eng_mkr_nm]" ).append("\n"); 
		query.append("	,MN_ENG_TP_DESC            = @[mn_eng_tp_desc]" ).append("\n"); 
		query.append("	,MN_ENG_RPM_PWR            = @[mn_eng_rpm_pwr]" ).append("\n"); 
		query.append("	,MN_ENG_BHP_PWR            = @[mn_eng_bhp_pwr]" ).append("\n"); 
		query.append("	,TBCGR_NO                  = @[tbcgr_no]" ).append("\n"); 
		query.append("	,TBCGR_MKR_NM              = @[tbcgr_mkr_nm]" ).append("\n"); 
		query.append("	,TBCGR_TP_DESC             = @[tbcgr_tp_desc]" ).append("\n"); 
		query.append("	,TBCGR_RPM_PWR             = @[tbcgr_rpm_pwr]" ).append("\n"); 
		query.append("	,TBCGR_COFF_FLG            = @[tbcgr_coff_flg]" ).append("\n"); 
		query.append("	,SPR_AUX_BLW_MKR_NM        = @[spr_aux_blw_mkr_nm]" ).append("\n"); 
		query.append("	,SPR_AUX_BLW_TP_DESC       = @[spr_aux_blw_tp_desc]" ).append("\n"); 
		query.append("	,SPR_AUX_BLW_NO            = @[spr_aux_blw_no]" ).append("\n"); 
		query.append("	,FOIL_ADTV_CD              = @[foil_adtv_cd]" ).append("\n"); 
		query.append("    ,HL_PNT_CD                 = @[hl_pnt_cd]" ).append("\n"); 
		query.append("	,GNR_CSM_WGT               = @[gnr_csm_wgt]" ).append("\n"); 
		query.append("	,FOIL_TNK_CBM_CAPA         = @[foil_tnk_cbm_capa]" ).append("\n"); 
		query.append("	,FOIL_TNK_MT_CAPA          = @[foil_tnk_mt_capa]" ).append("\n"); 
		query.append("	,FOIL_STL_SVC_TNK_MT_CAPA  = @[foil_stl_svc_tnk_mt_capa]" ).append("\n"); 
		query.append("	,OP_MAX_SPD               = @[op_max_spd]" ).append("\n"); 
		query.append("	,OP_MIN_SPD               = @[op_min_spd]" ).append("\n"); 
		query.append("	,OP_GNR_SPD               = @[op_gnr_spd]" ).append("\n"); 
		query.append("    ,TRND_LINE_USE_FLG         = @[trnd_line_use_flg]" ).append("\n"); 
		query.append("    ,MNVR_CSM_WGT              = @[mnvr_csm_wgt]" ).append("\n"); 
		query.append("	,UPD_USR_ID                = @[upd_usr_id]" ).append("\n"); 
		query.append("	,UPD_DT                    = SYSDATE" ).append("\n"); 
		query.append("	WHERE VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT(" ).append("\n"); 
		query.append("		VSL_CD" ).append("\n"); 
		query.append("        ,VSL_CLSS_SUB_CD" ).append("\n"); 
		query.append("		,MN_ENG_MKR_NM" ).append("\n"); 
		query.append("		,MN_ENG_TP_DESC" ).append("\n"); 
		query.append("		,MN_ENG_RPM_PWR" ).append("\n"); 
		query.append("		,MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("		,TBCGR_NO" ).append("\n"); 
		query.append("		,TBCGR_MKR_NM" ).append("\n"); 
		query.append("		,TBCGR_TP_DESC" ).append("\n"); 
		query.append("		,TBCGR_RPM_PWR" ).append("\n"); 
		query.append("		,TBCGR_COFF_FLG" ).append("\n"); 
		query.append("		,SPR_AUX_BLW_MKR_NM" ).append("\n"); 
		query.append("		,SPR_AUX_BLW_TP_DESC" ).append("\n"); 
		query.append("		,SPR_AUX_BLW_NO" ).append("\n"); 
		query.append("		,FOIL_ADTV_CD" ).append("\n"); 
		query.append("        ,HL_PNT_CD" ).append("\n"); 
		query.append("		,GNR_CSM_WGT" ).append("\n"); 
		query.append("		,FOIL_TNK_CBM_CAPA" ).append("\n"); 
		query.append("		,FOIL_TNK_MT_CAPA" ).append("\n"); 
		query.append("		,FOIL_STL_SVC_TNK_MT_CAPA" ).append("\n"); 
		query.append("		,OP_MAX_SPD" ).append("\n"); 
		query.append("		,OP_MIN_SPD" ).append("\n"); 
		query.append("		,OP_GNR_SPD" ).append("\n"); 
		query.append("        ,TRND_LINE_USE_FLG" ).append("\n"); 
		query.append("        ,MNVR_CSM_WGT" ).append("\n"); 
		query.append("		,CRE_USR_ID" ).append("\n"); 
		query.append("		,CRE_DT" ).append("\n"); 
		query.append("		,UPD_USR_ID" ).append("\n"); 
		query.append("		,UPD_DT" ).append("\n"); 
		query.append("	)VALUES(" ).append("\n"); 
		query.append("		@[vsl_cd]" ).append("\n"); 
		query.append("        ,@[vsl_clss_sub_cd]" ).append("\n"); 
		query.append("		,@[mn_eng_mkr_nm]" ).append("\n"); 
		query.append("		,@[mn_eng_tp_desc]" ).append("\n"); 
		query.append("		,@[mn_eng_rpm_pwr]" ).append("\n"); 
		query.append("		,@[mn_eng_bhp_pwr]" ).append("\n"); 
		query.append("		,@[tbcgr_no]" ).append("\n"); 
		query.append("		,@[tbcgr_mkr_nm]" ).append("\n"); 
		query.append("		,@[tbcgr_tp_desc]" ).append("\n"); 
		query.append("		,@[tbcgr_rpm_pwr]" ).append("\n"); 
		query.append("		,@[tbcgr_coff_flg]" ).append("\n"); 
		query.append("		,@[spr_aux_blw_mkr_nm]" ).append("\n"); 
		query.append("		,@[spr_aux_blw_tp_desc]" ).append("\n"); 
		query.append("		,@[spr_aux_blw_no]" ).append("\n"); 
		query.append("		,@[foil_adtv_cd]" ).append("\n"); 
		query.append("        ,@[hl_pnt_cd]" ).append("\n"); 
		query.append("		,@[gnr_csm_wgt]" ).append("\n"); 
		query.append("		,@[foil_tnk_cbm_capa]" ).append("\n"); 
		query.append("		,@[foil_tnk_mt_capa]" ).append("\n"); 
		query.append("		,@[foil_stl_svc_tnk_mt_capa]" ).append("\n"); 
		query.append("		,@[op_max_spd]" ).append("\n"); 
		query.append("		,@[op_min_spd]" ).append("\n"); 
		query.append("		,@[op_gnr_spd]" ).append("\n"); 
		query.append("        ,@[trnd_line_use_flg]" ).append("\n"); 
		query.append("        ,@[mnvr_csm_wgt]" ).append("\n"); 
		query.append("		,@[cre_usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append("		,@[upd_usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}