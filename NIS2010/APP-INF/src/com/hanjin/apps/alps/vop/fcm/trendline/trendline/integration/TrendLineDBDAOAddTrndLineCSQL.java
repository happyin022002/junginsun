/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TrendLineDBDAOAddTrndLineCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.04.04 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.trendline.trendline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrendLineDBDAOAddTrndLineCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trnd Line 정보를 생성합니다.
	  * 
	  * History
	  * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
	  * </pre>
	  */
	public TrendLineDBDAOAddTrndLineCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coef_of_dtmn_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnd_line_cons_val",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trnd_line_cht_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnd_line_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_coef_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_gnr_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_coef_val",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("foml_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trnd_line_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_slp_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnd_line_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("op_max_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_slp_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_blr_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trnd_line_tp_sub_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnd_line_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_slp_opt_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trnd_line_use_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.trendline.trendline.integration").append("\n"); 
		query.append("FileName : TrendLineDBDAOAddTrndLineCSQL").append("\n"); 
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
		query.append("INSERT INTO FCM_TRND_LINE (" ).append("\n"); 
		query.append("  TRND_LINE_SEQ," ).append("\n"); 
		query.append("  TRND_LINE_TP_CD," ).append("\n"); 
		query.append("  TRND_LINE_CHT_TP_CD," ).append("\n"); 
		query.append("  TRND_LINE_FM_DT," ).append("\n"); 
		query.append("  TRND_LINE_TO_DT," ).append("\n"); 
		query.append("  VSL_CLSS_CD," ).append("\n"); 
		query.append("  VSL_CLSS_SUB_CD," ).append("\n"); 
		query.append("  VSL_SLAN_CD," ).append("\n"); 
		query.append("  VSL_CD," ).append("\n"); 
		query.append("  SKD_DIR_CD," ).append("\n"); 
		query.append("  AVG_SLP_RT," ).append("\n"); 
		query.append("  AVG_SLP_OPT_RT," ).append("\n"); 
		query.append("  APLY_SLP_RT," ).append("\n"); 
		query.append("  N1ST_COEF_VAL," ).append("\n"); 
		query.append("  N1ST_VAR_DGR_VAL," ).append("\n"); 
		query.append("  N2ND_COEF_VAL," ).append("\n"); 
		query.append("  N2ND_VAR_DGR_VAL," ).append("\n"); 
		query.append("  TRND_LINE_CONS_VAL," ).append("\n"); 
		query.append("  COEF_OF_DTMN_VAL," ).append("\n"); 
		query.append("  FOML_DESC," ).append("\n"); 
		query.append("  AVG_GNR_CSM_WGT," ).append("\n"); 
		query.append("  AVG_BLR_CSM_WGT," ).append("\n"); 
		query.append("  OP_MAX_SPD," ).append("\n"); 
		query.append("  OP_MIN_SPD," ).append("\n"); 
		query.append("  TRND_LINE_RMK," ).append("\n"); 
		query.append("  CRE_USR_ID," ).append("\n"); 
		query.append("  CRE_DT," ).append("\n"); 
		query.append("  UPD_USR_ID," ).append("\n"); 
		query.append("  UPD_DT," ).append("\n"); 
		query.append("  TRND_LINE_TP_SUB_CD," ).append("\n"); 
		query.append("  TRND_LINE_USE_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("  (SELECT NVL(MAX(TRND_LINE_SEQ),0)+1 FROM FCM_TRND_LINE)," ).append("\n"); 
		query.append("  @[trnd_line_tp_cd]," ).append("\n"); 
		query.append("  @[trnd_line_cht_tp_cd]," ).append("\n"); 
		query.append("  REPLACE(@[trnd_line_fm_dt],'-','')," ).append("\n"); 
		query.append("  REPLACE(@[trnd_line_to_dt],'-','')," ).append("\n"); 
		query.append("  @[vsl_clss_cd]," ).append("\n"); 
		query.append("  @[vsl_clss_sub_cd]," ).append("\n"); 
		query.append("  @[vsl_slan_cd]," ).append("\n"); 
		query.append("  @[vsl_cd]," ).append("\n"); 
		query.append("  @[skd_dir_cd]," ).append("\n"); 
		query.append("  @[avg_slp_rt]," ).append("\n"); 
		query.append("  @[avg_slp_opt_rt]," ).append("\n"); 
		query.append("  @[aply_slp_rt]," ).append("\n"); 
		query.append("  @[n1st_coef_val]," ).append("\n"); 
		query.append("  '2'," ).append("\n"); 
		query.append("  @[n2nd_coef_val]," ).append("\n"); 
		query.append("  '1'," ).append("\n"); 
		query.append("  @[trnd_line_cons_val]," ).append("\n"); 
		query.append("  @[coef_of_dtmn_val]," ).append("\n"); 
		query.append("  @[foml_desc]," ).append("\n"); 
		query.append("  @[avg_gnr_csm_wgt]," ).append("\n"); 
		query.append("  @[avg_blr_csm_wgt]," ).append("\n"); 
		query.append("  @[op_max_spd]," ).append("\n"); 
		query.append("  @[op_min_spd]," ).append("\n"); 
		query.append("  @[trnd_line_rmk]," ).append("\n"); 
		query.append("  @[cre_usr_id]," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  @[upd_usr_id]," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  @[trnd_line_tp_sub_cd]," ).append("\n"); 
		query.append("  @[trnd_line_use_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}