/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : HolidayMgtDBDAOSb45RulingExceptionsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.29
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.02.29 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HolidayMgtDBDAOSb45RulingExceptionsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MergeDmtOvrDyExclu
	  * </pre>
	  */
	public HolidayMgtDBDAOSb45RulingExceptionsUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xcld_hol_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exclu_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xcld_sat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xcld_sun_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dem_det_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.integration").append("\n"); 
		query.append("FileName : HolidayMgtDBDAOSb45RulingExceptionsUSQL").append("\n"); 
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
		query.append("MERGE INTO DMT_OVR_DY_EXCLU" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append(" ON (" ).append("\n"); 
		query.append("      CNT_CD        = @[cnt_cd] AND" ).append("\n"); 
		query.append("      LOC_CD        = NVL(@[loc_cd], ' ') AND" ).append("\n"); 
		query.append("      YD_CD         = NVL(@[yd_cd], ' ') AND" ).append("\n"); 
		query.append("      IO_BND_CD     = @[io_bnd_cd] AND" ).append("\n"); 
		query.append("      DEM_DET_TP_CD = @[dem_det_tp_cd] AND" ).append("\n"); 
		query.append("      EXCLU_SEQ     = @[exclu_seq]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("  UPDATE" ).append("\n"); 
		query.append("     SET XCLD_SAT_FLG     = @[xcld_sat_flg]," ).append("\n"); 
		query.append("         XCLD_SUN_FLG     = @[xcld_sun_flg]," ).append("\n"); 
		query.append("         XCLD_HOL_FLG     = @[xcld_hol_flg]," ).append("\n"); 
		query.append("         EFF_DT           = TO_DATE(@[eff_dt], 'YYYYMMDD')," ).append("\n"); 
		query.append("         EXP_DT           = TO_DATE(@[exp_dt], 'YYYYMMDD')," ).append("\n"); 
		query.append("         UPD_USR_ID       = @[upd_usr_id]," ).append("\n"); 
		query.append("         UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("  INSERT" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("	       CNT_CD" ).append("\n"); 
		query.append("	      ,LOC_CD" ).append("\n"); 
		query.append("	      ,YD_CD" ).append("\n"); 
		query.append("	      ,IO_BND_CD" ).append("\n"); 
		query.append("          ,DEM_DET_TP_CD" ).append("\n"); 
		query.append("	      ,EXCLU_SEQ" ).append("\n"); 
		query.append("	      ,XCLD_SAT_FLG" ).append("\n"); 
		query.append("	      ,XCLD_SUN_FLG" ).append("\n"); 
		query.append("	      ,XCLD_HOL_FLG" ).append("\n"); 
		query.append("	      ,EFF_DT" ).append("\n"); 
		query.append("	      ,EXP_DT" ).append("\n"); 
		query.append("	      ,CRE_USR_ID" ).append("\n"); 
		query.append("	      ,CRE_DT" ).append("\n"); 
		query.append("	      ,UPD_USR_ID" ).append("\n"); 
		query.append("	      ,UPD_DT" ).append("\n"); 
		query.append("    	  ,EDW_UPD_DT " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("  VALUES" ).append("\n"); 
		query.append("         (	   " ).append("\n"); 
		query.append("		   @[cnt_cd]" ).append("\n"); 
		query.append("	      ,NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("	      ,NVL(@[yd_cd], ' ')" ).append("\n"); 
		query.append("	      ,@[io_bnd_cd]" ).append("\n"); 
		query.append("          ,@[dem_det_tp_cd]" ).append("\n"); 
		query.append("	      ,(" ).append("\n"); 
		query.append("          		SELECT /*+ INDEX_DESC(DMT_OVR_DY_EXCLU XPKDMT_OVR_DY_EXCLU) */ " ).append("\n"); 
		query.append("				       NVL(MAX(EXCLU_SEQ)+1, 1) EXCLU_SEQ" ).append("\n"); 
		query.append("				  FROM DMT_OVR_DY_EXCLU" ).append("\n"); 
		query.append("				 WHERE 1=1" ).append("\n"); 
		query.append("				   AND CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("				   AND LOC_CD = NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("				   AND YD_CD = NVL(@[yd_cd], ' ')" ).append("\n"); 
		query.append("				   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                   AND DEM_DET_TP_CD = @[dem_det_tp_cd]" ).append("\n"); 
		query.append("				   AND ROWNUM = 1" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("	      ,@[xcld_sat_flg]" ).append("\n"); 
		query.append("	      ,@[xcld_sun_flg]" ).append("\n"); 
		query.append("	      ,@[xcld_hol_flg]" ).append("\n"); 
		query.append("	      ,TO_DATE(@[eff_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("	      ,TO_DATE(@[exp_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("	      ,@[cre_usr_id]" ).append("\n"); 
		query.append("	      ,SYSDATE" ).append("\n"); 
		query.append("	      ,@[upd_usr_id]" ).append("\n"); 
		query.append("	      ,SYSDATE" ).append("\n"); 
		query.append("	      ,NULL" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}