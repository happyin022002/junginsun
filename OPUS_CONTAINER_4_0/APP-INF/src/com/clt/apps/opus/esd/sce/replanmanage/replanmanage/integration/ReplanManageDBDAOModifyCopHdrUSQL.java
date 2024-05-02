/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReplanManageDBDAOModifyCopHdrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOModifyCopHdrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_COP_HDR 를 update 한다.
	  * </pre>
	  */
	public ReplanManageDBDAOModifyCopHdrUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("umch_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_ob_dor_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_fsh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_sub_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prov_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_upd_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_rail_chk_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_apnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOModifyCopHdrUSQL").append("\n"); 
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
		query.append("UPDATE SCE_COP_HDR A SET " ).append("\n"); 
		query.append("	#if (${bkg_no} != '') " ).append("\n"); 
		query.append("BKG_NO = @[bkg_no], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${cntr_no} != '') " ).append("\n"); 
		query.append("CNTR_NO = @[cntr_no], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("CNTR_TPSZ_CD = @[cntr_tpsz_cd], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${cnmv_yr} != '') " ).append("\n"); 
		query.append("CNMV_YR = @[cnmv_yr], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${cop_sts_cd} != '') " ).append("\n"); 
		query.append("COP_STS_CD = @[cop_sts_cd], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${cop_sub_sts_cd} != '') " ).append("\n"); 
		query.append("COP_SUB_STS_CD = @[cop_sub_sts_cd]," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${pctl_no} != '') " ).append("\n"); 
		query.append("PCTL_NO = @[pctl_no], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${mst_cop_no} != '') " ).append("\n"); 
		query.append("MST_COP_NO = @[mst_cop_no], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if ( ${cop_fsh_dt} != '') " ).append("\n"); 
		query.append("COP_FSH_DT = TO_DATE(@[cop_fsh_dt], 'YYYYMMDDHH24MISS'), " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${trnk_vsl_cd} != '') " ).append("\n"); 
		query.append("TRNK_VSL_CD = @[trnk_vsl_cd], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${trnk_skd_voy_no} != '') " ).append("\n"); 
		query.append("TRNK_SKD_VOY_NO = @[trnk_skd_voy_no], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${trnk_skd_dir_cd} != '') " ).append("\n"); 
		query.append("TRNK_SKD_DIR_CD = @[trnk_skd_dir_cd], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${por_nod_cd} != '') " ).append("\n"); 
		query.append("POR_NOD_CD = @[por_nod_cd], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${pol_nod_cd} != '') " ).append("\n"); 
		query.append("POL_NOD_CD = @[pol_nod_cd], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${pod_nod_cd} != '') " ).append("\n"); 
		query.append("POD_NOD_CD = @[pod_nod_cd], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${del_nod_cd} != '') " ).append("\n"); 
		query.append("DEL_NOD_CD = @[del_nod_cd], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${cop_rail_chk_cd} != '') " ).append("\n"); 
		query.append("COP_RAIL_CHK_CD = @[cop_rail_chk_cd], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${ib_tro_flg} != '') " ).append("\n"); 
		query.append("IB_TRO_FLG = @[ib_tro_flg], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${ob_tro_flg} != '') " ).append("\n"); 
		query.append("OB_TRO_FLG = @[ob_tro_flg], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${prov_cntr_no} != '') " ).append("\n"); 
		query.append("PROV_CNTR_NO = @[prov_cntr_no], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${prov_cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("PROV_CNTR_TPSZ_CD = @[prov_cntr_tpsz_cd], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${umch_sts_cd} != '') " ).append("\n"); 
		query.append("UMCH_STS_CD = @[umch_sts_cd], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if ( ${cfm_ob_dor_arr_dt} != '') " ).append("\n"); 
		query.append("CFM_OB_DOR_ARR_DT = TO_DATE(@[cfm_ob_dor_arr_dt], 'YYYYMMDDHH24MISS'), " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if ( ${cfm_apnt_dt} != '') " ).append("\n"); 
		query.append("CFM_APNT_DT = TO_DATE(@[cfm_apnt_dt], 'YYYYMMDDHH24MISS'), " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${cop_upd_rmk} != '') " ).append("\n"); 
		query.append("COP_UPD_RMK = (CASE WHEN LENGTH(CASE WHEN A.COP_UPD_RMK IS NULL THEN '' ELSE A.COP_UPD_RMK END) + LENGTH(CHR(10) || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MI') || '> ' || @[cop_upd_rmk]) >= 4000 THEN" ).append("\n"); 
		query.append("					  SUBSTR(A.COP_UPD_RMK" ).append("\n"); 
		query.append("							,(CASE WHEN REGEXP_INSTR(A.COP_UPD_RMK, CHR(10), 1, 1) + 1 > LENGTH(CHR(10) || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MI') || '> ' || @[cop_upd_rmk]) THEN REGEXP_INSTR(A.COP_UPD_RMK, CHR(10), 1, 1) + 1" ).append("\n"); 
		query.append("								   WHEN REGEXP_INSTR(A.COP_UPD_RMK, CHR(10), 1, 2) + 1 > LENGTH(CHR(10) || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MI') || '> ' || @[cop_upd_rmk]) THEN REGEXP_INSTR(A.COP_UPD_RMK, CHR(10), 1, 2) + 1" ).append("\n"); 
		query.append("								   ELSE REGEXP_INSTR(A.COP_UPD_RMK, CHR(10), 1, 3) + 1" ).append("\n"); 
		query.append("							 END)" ).append("\n"); 
		query.append("							) || CHR(10) || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MI') || '> ' || @[cop_upd_rmk]" ).append("\n"); 
		query.append("					ELSE NVL2(A.COP_UPD_RMK,  A.COP_UPD_RMK || CHR(10) || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MI') || '> ' || @[cop_upd_rmk], TO_CHAR(SYSDATE, 'YYYYMMDDHH24MI') || '> ' || @[cop_upd_rmk])" ).append("\n"); 
		query.append("			  END)," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${upd_usr_id} != '') " ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id], " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("COP_NO = @[cop_no]" ).append("\n"); 

	}
}