/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NewCctVgmHisManageDBDAOAddPrdTmlVgmCctHisByPrdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.24 
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

public class NewCctVgmHisManageDBDAOAddPrdTmlVgmCctHisByPrdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NewCctVgmHisManageDBDAOAddPrdTmlVgmCctHisByPrd
	  * </pre>
	  */
	public NewCctVgmHisManageDBDAOAddPrdTmlVgmCctHisByPrdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_clz_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_clz_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clz_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xcld_hol_fri_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_clz_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xcld_hol_sun_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xcld_hol_sat_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cct_hr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_clz_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cct_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_clz_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xcld_hol_hol_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.integration").append("\n"); 
		query.append("FileName : NewCctVgmHisManageDBDAOAddPrdTmlVgmCctHisByPrdCSQL").append("\n"); 
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
		query.append("#if (${pctl_use_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO PRD_TML_VGM_CCT_HIS (" ).append("\n"); 
		query.append("   HIS_SEQ" ).append("\n"); 
		query.append("  ,PCTL_USE_FLG" ).append("\n"); 
		query.append("  ,YD_CD" ).append("\n"); 
		query.append("  ,VSL_SLAN_CD" ).append("\n"); 
		query.append("  ,VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("  ,CGO_TP_CD" ).append("\n"); 
		query.append("  ,VGM_FLG" ).append("\n"); 
		query.append("  ,DELT_FLG" ).append("\n"); 
		query.append("  ,CCT_TP_CD" ).append("\n"); 
		query.append("  ,CCT_HR" ).append("\n"); 
		query.append("  ,CCT_DY_CD" ).append("\n"); 
		query.append("  ,CCT_HRMNT" ).append("\n"); 
		query.append("  ,CCT_FILE_FLG" ).append("\n"); 
		query.append("  ,YD_BSE_CALC_FLG" ).append("\n"); 
		query.append("  ,XCLD_HOL_FRI_FLG" ).append("\n"); 
		query.append("  ,XCLD_HOL_SAT_FLG" ).append("\n"); 
		query.append("  ,XCLD_HOL_SUN_FLG" ).append("\n"); 
		query.append("  ,XCLD_HOL_HOL_FLG" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT nvl((select max(HIS_SEQ) from PRD_TML_VGM_CCT_HIS), 0) + 1 HIS_SEQ" ).append("\n"); 
		query.append("        ,@[pctl_use_flg] pctl_use_flg" ).append("\n"); 
		query.append("        ,yd_cd" ).append("\n"); 
		query.append("        ,vsl_slan_cd" ).append("\n"); 
		query.append("        ,vsl_slan_dir_cd" ).append("\n"); 
		query.append("        ,cgo_tp_cd" ).append("\n"); 
		query.append("        ,@[vgm_flg] vgm_flg" ).append("\n"); 
		query.append("        ,@[delt_flg] delt_flg" ).append("\n"); 
		query.append("        ,@[cct_tp_cd] cct_tp_cd" ).append("\n"); 
		query.append("        ,@[cct_hr] cct_hr" ).append("\n"); 
		query.append("        ,@[cct_dy_cd] cct_dy_cd" ).append("\n"); 
		query.append("        ,@[cct_hrmnt] cct_hrmnt" ).append("\n"); 
		query.append("        ,@[cct_file_flg] cct_file_flg" ).append("\n"); 
		query.append("        ,@[yd_bse_calc_flg] yd_bse_calc_flg" ).append("\n"); 
		query.append("        ,@[xcld_hol_fri_flg] xcld_hol_fri_flg" ).append("\n"); 
		query.append("        ,@[xcld_hol_sat_flg] xcld_hol_sat_flg" ).append("\n"); 
		query.append("        ,@[xcld_hol_sun_flg] xcld_hol_sun_flg" ).append("\n"); 
		query.append("        ,@[xcld_hol_hol_flg] xcld_hol_hol_flg" ).append("\n"); 
		query.append("        ,@[cre_usr_id] cre_usr_id" ).append("\n"); 
		query.append("        ,SYSDATE cre_dt" ).append("\n"); 
		query.append("        ,@[upd_usr_id] upd_usr_id" ).append("\n"); 
		query.append("        ,SYSDATE upd_dt" ).append("\n"); 
		query.append("    FROM PRD_TML_CCT_MGMT O" ).append("\n"); 
		query.append("   WHERE O.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("     AND VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("     AND VSL_SLAN_DIR_CD = NVL(@[vsl_slan_dir_cd], 'A')" ).append("\n"); 
		query.append("     AND CGO_TP_CD = @[cgo_tp_cd]" ).append("\n"); 
		query.append("#if (${vgm_flg} == 'Y')" ).append("\n"); 
		query.append("	 AND (	O.VGM_CLZ_TP_CD <> @[cct_tp_cd] " ).append("\n"); 
		query.append("			OR to_number(NVL(O.VGM_CLZ_HR, '0')) <> TO_NUMBER(NVL(@[cct_hr], '0')) " ).append("\n"); 
		query.append("			OR NVL(O.VGM_CLZ_DY_CD, 'X')    <> NVL(@[cct_dy_cd], 'X') " ).append("\n"); 
		query.append("			OR NVL(O.VGM_CLZ_HRMNT, 'X')    <> NVL(@[cct_hrmnt], 'X') " ).append("\n"); 
		query.append("		    OR NVL(O.VGM_CLZ_FILE_FLG, '0')     <> NVL(@[cct_file_flg], '0') " ).append("\n"); 
		query.append("			OR NVL(O.VGM_YD_BSE_CALC_FLG, '0')  <> NVL(@[yd_bse_calc_flg], '0') " ).append("\n"); 
		query.append("			OR NVL(O.VGM_XCLD_HOL_FRI_FLG, '0') <> NVL(@[xcld_hol_fri_flg], '0') " ).append("\n"); 
		query.append("			OR NVL(O.VGM_XCLD_HOL_SAT_FLG, '0') <> NVL(@[xcld_hol_sat_flg], '0') " ).append("\n"); 
		query.append("			OR NVL(O.VGM_XCLD_HOL_SUN_FLG, '0') <> NVL(@[xcld_hol_sun_flg], '0') " ).append("\n"); 
		query.append("			OR NVL(O.VGM_XCLD_HOL_HOL_FLG, '0') <> NVL(@[xcld_hol_hol_flg], '0') " ).append("\n"); 
		query.append("			OR DELT_FLG <> @[delt_flg]" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     AND (	CCT_TP_CD <> @[cct_tp_cd] " ).append("\n"); 
		query.append("			OR to_number(NVL(CCT_HR, '0')) <>  TO_NUMBER(NVL(@[cct_hr], '0')) " ).append("\n"); 
		query.append("			OR NVL(CCT_DY_CD, 'X') <> NVL(@[cct_dy_cd], 'X') " ).append("\n"); 
		query.append("			OR NVL(CCT_HRMNT, 'X') <> NVL(@[cct_hrmnt], 'X') " ).append("\n"); 
		query.append("		    OR NVL(O.CCT_FILE_FLG, '0')     <> NVL(@[cct_file_flg], '0') " ).append("\n"); 
		query.append("			OR NVL(O.YD_BSE_CALC_FLG, '0')  <> NVL(@[yd_bse_calc_flg], '0') " ).append("\n"); 
		query.append("			OR NVL(O.XCLD_HOL_FRI_FLG, '0') <> NVL(@[xcld_hol_fri_flg], '0') " ).append("\n"); 
		query.append("			OR NVL(O.XCLD_HOL_SAT_FLG, '0') <> NVL(@[xcld_hol_sat_flg], '0') " ).append("\n"); 
		query.append("			OR NVL(O.XCLD_HOL_SUN_FLG, '0') <> NVL(@[xcld_hol_sun_flg], '0') " ).append("\n"); 
		query.append("			OR NVL(O.XCLD_HOL_HOL_FLG, '0') <> NVL(@[xcld_hol_hol_flg], '0') " ).append("\n"); 
		query.append("			OR DELT_FLG <> @[delt_flg]" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO PRD_TML_VGM_CCT_HIS" ).append("\n"); 
		query.append("(HIS_SEQ, PCTL_USE_FLG, YD_CD, VVD_CD, VSL_SLAN_CD, VPS_PORT_CD, CLPT_IND_SEQ, VGM_FLG, DELT_FLG, CGO_CLZ_DT, DCGO_CLZ_DT, RC_CLZ_DT, AWK_CGO_CLZ_DT, BB_CGO_CLZ_DT, VGM_CLZ_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("  SELECT nvl((select max(HIS_SEQ) from PRD_TML_VGM_CCT_HIS), 0) + 1 HIS_SEQ" ).append("\n"); 
		query.append("        ,@[pctl_use_flg] PCTL_USE_FLG" ).append("\n"); 
		query.append("        ,@[yd_cd] YD_CD" ).append("\n"); 
		query.append("        ,@[vvd_cd] VVD_CD" ).append("\n"); 
		query.append("		,@[vsl_slan_cd] VSL_SLAN_CD" ).append("\n"); 
		query.append("		,@[vps_port_cd] VPS_PORT_CD " ).append("\n"); 
		query.append("		,@[clpt_ind_seq] CLPT_IND_SEQ" ).append("\n"); 
		query.append("        ,@[vgm_flg] VGM_FLG" ).append("\n"); 
		query.append("        ,@[delt_flg] DELT_FLG" ).append("\n"); 
		query.append("        ,TO_DATE(@[cgo_clz_dt], 'YYYYMMDDHH24MI')  CGO_CLZ_DT" ).append("\n"); 
		query.append("        ,TO_DATE(@[dcgo_clz_dt], 'YYYYMMDDHH24MI')  DCGO_CLZ_DT" ).append("\n"); 
		query.append("        ,TO_DATE(@[rc_clz_dt], 'YYYYMMDDHH24MI')  RC_CLZ_DT" ).append("\n"); 
		query.append("        ,TO_DATE(@[awk_cgo_clz_dt], 'YYYYMMDDHH24MI')  AWK_CGO_CLZ_DT" ).append("\n"); 
		query.append("        ,TO_DATE(@[bb_cgo_clz_dt], 'YYYYMMDDHH24MI')  BB_CGO_CLZ_DT" ).append("\n"); 
		query.append("        ,TO_DATE(@[vgm_clz_dt], 'YYYYMMDDHH24MI')  VGM_CLZ_DT" ).append("\n"); 
		query.append("        ,@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE CRE_DT" ).append("\n"); 
		query.append("        ,@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE UPD_DT" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD O" ).append("\n"); 
		query.append("    WHERE VSL_CD        = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND     SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND     SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND     VPS_PORT_CD     = @[vps_port_cd]" ).append("\n"); 
		query.append("AND     CLPT_IND_SEQ    = @[clpt_ind_seq]" ).append("\n"); 
		query.append("#if (${vgm_flg} == 'Y')" ).append("\n"); 
		query.append("AND ( NVL(VGM_CLZ_DT, TO_DATE('299912312359', 'YYYYMMDDHH24MI')) <> TO_DATE(NVL(@[vgm_clz_dt], '299912312359'), 'YYYYMMDDHH24MI'))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ( NVL(CGO_CLZ_DT, TO_DATE('299912312359', 'YYYYMMDDHH24MI'))    <> TO_DATE(NVL(@[cgo_clz_dt], '299912312359'), 'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("  OR NVL(DCGO_CLZ_DT, TO_DATE('299912312359', 'YYYYMMDDHH24MI'))    <>  TO_DATE(NVL(@[dcgo_clz_dt], '299912312359'), 'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("  OR NVL(RC_CLZ_DT, TO_DATE('299912312359', 'YYYYMMDDHH24MI'))    <>  TO_DATE(NVL(@[rc_clz_dt], '299912312359'), 'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("  OR NVL(AWK_CGO_CLZ_DT, TO_DATE('299912312359', 'YYYYMMDDHH24MI'))   <>  TO_DATE(NVL(@[awk_cgo_clz_dt], '299912312359'), 'YYYYMMDDHH24MI')  " ).append("\n"); 
		query.append("  OR NVL(BB_CGO_CLZ_DT, TO_DATE('299912312359', 'YYYYMMDDHH24MI'))  <>  TO_DATE(NVL(@[bb_cgo_clz_dt], '299912312359'), 'YYYYMMDDHH24MI')   " ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}