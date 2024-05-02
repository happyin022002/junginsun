/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAOAddGuidelineHeaderCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanGuidelineManageDBDAOAddGuidelineHeaderCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GuidelineHeader Insert
	  * </pre>
	  */
	public CntrPlanGuidelineManageDBDAOAddGuidelineHeaderCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_gline_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_gline_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eff_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration").append("\n"); 
		query.append("FileName : CntrPlanGuidelineManageDBDAOAddGuidelineHeaderCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_CTRL_GLINE_HDR(" ).append("\n"); 
		query.append("   TRD_CD         " ).append("\n"); 
		query.append("  ,SUB_TRD_CD     " ).append("\n"); 
		query.append("  ,VSL_LANE_CD    " ).append("\n"); 
		query.append("  ,EQ_GLINE_SEQ   " ).append("\n"); 
		query.append("  ,VSL_CD         " ).append("\n"); 
		query.append("  ,SKD_VOY_NO     " ).append("\n"); 
		query.append("  ,SKD_DIR_CD     " ).append("\n"); 
		query.append("  ,POL_CD         " ).append("\n"); 
		query.append("  ,EFF_ST_DT      " ).append("\n"); 
		query.append("  ,EFF_END_DT     " ).append("\n"); 
		query.append("  ,CFM_FLG        " ).append("\n"); 
		query.append("  ,REPO_GLINE_RMK " ).append("\n"); 
		query.append("  ,CRE_USR_ID     " ).append("\n"); 
		query.append("  ,CRE_DT         " ).append("\n"); 
		query.append("  ,UPD_USR_ID     " ).append("\n"); 
		query.append("  ,UPD_DT " ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("   @[trd_cd]" ).append("\n"); 
		query.append("  ,@[sub_trd_cd]" ).append("\n"); 
		query.append("  ,@[vsl_lane_cd]    " ).append("\n"); 
		query.append("  ,@[eq_gline_seq]   " ).append("\n"); 
		query.append("  ,@[vsl_cd]  " ).append("\n"); 
		query.append("  ,@[skd_voy_no]" ).append("\n"); 
		query.append("  ,@[skd_dir_cd]    " ).append("\n"); 
		query.append("  ,@[pol_cd]    " ).append("\n"); 
		query.append("  ,@[eff_st_dt]" ).append("\n"); 
		query.append("  ,'99991231'" ).append("\n"); 
		query.append("  ,NVL(@[cfm_flg],'N')    " ).append("\n"); 
		query.append("  ,@[repo_gline_rmk]" ).append("\n"); 
		query.append("  ,@[cre_usr_id]" ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  ,@[upd_usr_id] " ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}