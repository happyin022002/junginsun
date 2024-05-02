/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NewCCTManageDBDAOMultiCCTManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NewCCTManageDBDAOMultiCCTManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiCCTManage
	  * </pre>
	  */
	public NewCCTManageDBDAOMultiCCTManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_hour",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_xcld_hol_sat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_clz_file_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_clz_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_bse_calc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_clz_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_yd_bse_calc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_dir_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sat_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_day",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_clz_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_file_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cargo_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sun_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_xcld_hol_fri_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_xcld_hol_sun_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("holi_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fri_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_clz_hr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_xcld_hol_hol_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.integration").append("\n"); 
		query.append("FileName : NewCCTManageDBDAOMultiCCTManageRSQL").append("\n"); 
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
		query.append("MERGE INTO PRD_TML_CCT_MGMT C USING  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    (SELECT @[yard_code] YD_CD " ).append("\n"); 
		query.append("         , @[lane_code] VSL_SLAN_CD " ).append("\n"); 
		query.append("         , NVL(@[lane_dir_code], 'A') VSL_SLAN_DIR_CD " ).append("\n"); 
		query.append("         , @[cargo_type] CGO_TP_CD " ).append("\n"); 
		query.append("         , @[cct_type] CCT_TP_CD " ).append("\n"); 
		query.append("         , DECODE(TO_NUMBER(@[cct_hour], '99'), 0, NULL, TO_NUMBER(@[cct_hour], '99')) CCT_HR " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         #if(${cct_type} == 'CMN') " ).append("\n"); 
		query.append("         , '' CCT_DY_CD " ).append("\n"); 
		query.append("         #else " ).append("\n"); 
		query.append("         , @[cct_day] CCT_DY_CD " ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         , @[cct_time] CCT_HRMNT " ).append("\n"); 
		query.append("      FROM DUAL " ).append("\n"); 
		query.append("    ) T " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ON( C.YD_CD = T.YD_CD " ).append("\n"); 
		query.append("	AND C.VSL_SLAN_CD = T.VSL_SLAN_CD " ).append("\n"); 
		query.append("	AND C.VSL_SLAN_DIR_CD = T.VSL_SLAN_DIR_CD " ).append("\n"); 
		query.append("	AND C.CGO_TP_CD =T.CGO_TP_CD ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("       UPDATE " ).append("\n"); 
		query.append("          SET C.CCT_TP_CD= @[cct_type] " ).append("\n"); 
		query.append("            , C.CCT_HR = T.CCT_HR " ).append("\n"); 
		query.append("            , C.CCT_FILE_FLG = @[cct_file_flg] " ).append("\n"); 
		query.append("            , C.YD_BSE_CALC_FLG = @[yd_bse_calc_flg] " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if(${cct_type} == 'CMN') " ).append("\n"); 
		query.append("            , C.CCT_DY_CD = '' " ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("            , C.CCT_DY_CD = T.CCT_DY_CD " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("            , C.CCT_HRMNT = T.CCT_HRMNT " ).append("\n"); 
		query.append("            , C.XCLD_HOL_FRI_FLG = @[fri_flag] " ).append("\n"); 
		query.append("            , C.XCLD_HOL_SAT_FLG = @[sat_flag] " ).append("\n"); 
		query.append("            , C.XCLD_HOL_SUN_FLG = @[sun_flag] " ).append("\n"); 
		query.append("            , C.XCLD_HOL_HOL_FLG = @[holi_flag] " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if(${ibflag} == 'I' || ${ibflag} == 'U') " ).append("\n"); 
		query.append("            , C.DELT_FLG = 'N' " ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("            , C.DELT_FLG = 'Y' " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("            , C.UPD_USR_ID = @[user_id] " ).append("\n"); 
		query.append("            , C.UPD_DT = SYSDATE 		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			, C.VGM_CLZ_TP_CD = @[vgm_clz_tp_cd] " ).append("\n"); 
		query.append("            , C.VGM_CLZ_HR = DECODE(TO_NUMBER(@[vgm_clz_hr], '99'), 0, NULL, TO_NUMBER(@[vgm_clz_hr], '99')) " ).append("\n"); 
		query.append("            , C.VGM_CLZ_FILE_FLG = @[vgm_clz_file_flg] " ).append("\n"); 
		query.append("            , C.VGM_YD_BSE_CALC_FLG = @[vgm_yd_bse_calc_flg] " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if(${vgm_clz_tp_cd} == 'CMN') " ).append("\n"); 
		query.append("            , C.VGM_CLZ_DY_CD = '' " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("            , C.VGM_CLZ_DY_CD = @[vgm_clz_dy_cd] " ).append("\n"); 
		query.append("            #end	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            , C.VGM_CLZ_HRMNT = @[vgm_clz_hrmnt] " ).append("\n"); 
		query.append("            , C.VGM_XCLD_HOL_FRI_FLG = @[vgm_xcld_hol_fri_flg] " ).append("\n"); 
		query.append("            , C.VGM_XCLD_HOL_SAT_FLG = @[vgm_xcld_hol_sat_flg] " ).append("\n"); 
		query.append("            , C.VGM_XCLD_HOL_SUN_FLG = @[vgm_xcld_hol_sun_flg] " ).append("\n"); 
		query.append("            , C.VGM_XCLD_HOL_HOL_FLG = @[vgm_xcld_hol_hol_flg] " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       INSERT " ).append("\n"); 
		query.append("              ( " ).append("\n"); 
		query.append("                  YD_CD " ).append("\n"); 
		query.append("                , VSL_SLAN_CD " ).append("\n"); 
		query.append("                , VSL_SLAN_DIR_CD " ).append("\n"); 
		query.append("                , CGO_TP_CD " ).append("\n"); 
		query.append("                , CCT_TP_CD " ).append("\n"); 
		query.append("                , CCT_HR " ).append("\n"); 
		query.append("                , CCT_FILE_FLG " ).append("\n"); 
		query.append("                , YD_BSE_CALC_FLG " ).append("\n"); 
		query.append("                , CCT_DY_CD " ).append("\n"); 
		query.append("                , CCT_HRMNT " ).append("\n"); 
		query.append("                , XCLD_HOL_FRI_FLG " ).append("\n"); 
		query.append("                , XCLD_HOL_SAT_FLG " ).append("\n"); 
		query.append("                , XCLD_HOL_SUN_FLG " ).append("\n"); 
		query.append("                , XCLD_HOL_HOL_FLG " ).append("\n"); 
		query.append("                , DELT_FLG " ).append("\n"); 
		query.append("                , CRE_USR_ID " ).append("\n"); 
		query.append("                , CRE_DT " ).append("\n"); 
		query.append("                , UPD_USR_ID " ).append("\n"); 
		query.append("                , UPD_DT " ).append("\n"); 
		query.append("                , VGM_CLZ_TP_CD " ).append("\n"); 
		query.append("                , VGM_CLZ_HR " ).append("\n"); 
		query.append("                , VGM_CLZ_FILE_FLG " ).append("\n"); 
		query.append("                , VGM_YD_BSE_CALC_FLG " ).append("\n"); 
		query.append("                , VGM_CLZ_DY_CD " ).append("\n"); 
		query.append("                , VGM_CLZ_HRMNT " ).append("\n"); 
		query.append("                , VGM_XCLD_HOL_FRI_FLG " ).append("\n"); 
		query.append("                , VGM_XCLD_HOL_SAT_FLG " ).append("\n"); 
		query.append("                , VGM_XCLD_HOL_SUN_FLG " ).append("\n"); 
		query.append("                , VGM_XCLD_HOL_HOL_FLG " ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("              VALUES " ).append("\n"); 
		query.append("              ( " ).append("\n"); 
		query.append("                  @[yard_code] " ).append("\n"); 
		query.append("                , @[lane_code] " ).append("\n"); 
		query.append("                , NVL(@[lane_dir_code], 'A') " ).append("\n"); 
		query.append("                , @[cargo_type] " ).append("\n"); 
		query.append("                , @[cct_type] " ).append("\n"); 
		query.append("                , DECODE(TO_NUMBER(@[cct_hour], '99'), 0, NULL, TO_NUMBER(@[cct_hour], '99')) " ).append("\n"); 
		query.append("                , @[cct_file_flg] " ).append("\n"); 
		query.append("                , @[yd_bse_calc_flg] " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                #if(${cct_type} == 'CMN') " ).append("\n"); 
		query.append("                , '' " ).append("\n"); 
		query.append("                #else " ).append("\n"); 
		query.append("                , @[cct_day] " ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                , @[cct_time] " ).append("\n"); 
		query.append("                , @[fri_flag] " ).append("\n"); 
		query.append("                , @[sat_flag] " ).append("\n"); 
		query.append("                , @[sun_flag] " ).append("\n"); 
		query.append("                , @[holi_flag] " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                #if(${ibflag} == 'I' || ${ibflag} == 'U') " ).append("\n"); 
		query.append("                , 'N' " ).append("\n"); 
		query.append("                #else " ).append("\n"); 
		query.append("                , 'Y' " ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                , @[user_id] " ).append("\n"); 
		query.append("                , SYSDATE " ).append("\n"); 
		query.append("                , @[user_id] " ).append("\n"); 
		query.append("                , SYSDATE " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , @[vgm_clz_tp_cd] " ).append("\n"); 
		query.append("                , DECODE(TO_NUMBER(@[vgm_clz_hr], '99'), 0, NULL, TO_NUMBER(@[vgm_clz_hr], '99')) " ).append("\n"); 
		query.append("                , @[vgm_clz_file_flg] " ).append("\n"); 
		query.append("                , @[vgm_yd_bse_calc_flg] " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                #if(${vgm_clz_tp_cd} == 'CMN') " ).append("\n"); 
		query.append("                , '' " ).append("\n"); 
		query.append("                #else " ).append("\n"); 
		query.append("                , @[vgm_clz_dy_cd] " ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , @[vgm_clz_hrmnt] " ).append("\n"); 
		query.append("                , @[vgm_xcld_hol_fri_flg] " ).append("\n"); 
		query.append("                , @[vgm_xcld_hol_sat_flg] " ).append("\n"); 
		query.append("                , @[vgm_xcld_hol_sun_flg] " ).append("\n"); 
		query.append("                , @[vgm_xcld_hol_hol_flg] " ).append("\n"); 
		query.append("              )" ).append("\n"); 

	}
}