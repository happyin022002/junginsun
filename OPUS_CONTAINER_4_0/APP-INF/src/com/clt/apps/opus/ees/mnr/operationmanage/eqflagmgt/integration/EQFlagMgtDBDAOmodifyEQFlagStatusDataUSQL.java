/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EQFlagMgtDBDAOmodifyEQFlagStatusDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOmodifyEQFlagStatusDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyEQFlagStatusData
	  * </pre>
	  */
	public EQFlagMgtDBDAOmodifyEQFlagStatusDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_sts_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_dmg_flg_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_dmg_flg_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_dmg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOmodifyEQFlagStatusDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_EQ_STS A" ).append("\n"); 
		query.append("	SET  A.MNR_DMG_FLG     = DECODE(@[cost_dtl_cd], 'DMG', DECODE(@[mnr_dmg_flg],'0','N','Y'), A.MNR_DMG_FLG)," ).append("\n"); 
		query.append("	     A.MNR_TTL_LSS_FLG = DECODE(@[cost_dtl_cd], 'TLL', DECODE(@[mnr_dmg_flg],'0','N','Y'), A.MNR_TTL_LSS_FLG)," ).append("\n"); 
		query.append("	     A.MNR_DISP_FLG    = DECODE(@[cost_dtl_cd], 'DSP', DECODE(@[mnr_dmg_flg],'0','N','Y'), A.MNR_DISP_FLG)," ).append("\n"); 
		query.append("	     A.MNR_SCRP_FLG    = DECODE(@[cost_dtl_cd], 'SCR', DECODE(@[mnr_dmg_flg],'0','N','Y'), A.MNR_SCRP_FLG)," ).append("\n"); 
		query.append("	     A.MNR_DONA_FLG    = DECODE(@[cost_dtl_cd], 'DON', DECODE(@[mnr_dmg_flg],'0','N','Y'), A.MNR_DONA_FLG)," ).append("\n"); 
		query.append("		 A.UPD_USR_ID = @[cre_usr_id]," ).append("\n"); 
		query.append("		 A.UPD_DT = SYSDATE," ).append("\n"); 
		query.append("	  	 A.MNR_DMG_FLG_YD_CD     = DECODE(@[cost_dtl_cd], 'DMG', @[mnr_dmg_flg_yd_cd], A.MNR_DMG_FLG_YD_CD)," ).append("\n"); 
		query.append("	     A.MNR_TTL_LSS_FLG_YD_CD = DECODE(@[cost_dtl_cd], 'TLL', @[mnr_dmg_flg_yd_cd], A.MNR_TTL_LSS_FLG_YD_CD)," ).append("\n"); 
		query.append("	     A.MNR_DISP_FLG_YD_CD    = DECODE(@[cost_dtl_cd], 'DSP', @[mnr_dmg_flg_yd_cd], A.MNR_DISP_FLG_YD_CD)," ).append("\n"); 
		query.append("	     A.MNR_SCRP_FLG_YD_CD    = DECODE(@[cost_dtl_cd], 'SCR', @[mnr_dmg_flg_yd_cd], A.MNR_SCRP_FLG_YD_CD)," ).append("\n"); 
		query.append("	     A.MNR_DONA_FLG_YD_CD    = DECODE(@[cost_dtl_cd], 'DON', @[mnr_dmg_flg_yd_cd], A.MNR_DONA_FLG_YD_CD)," ).append("\n"); 
		query.append("	  	 A.MNR_DMG_FLG_DT     = DECODE(@[cost_dtl_cd], 'DMG', TO_DATE(@[mnr_dmg_flg_dt],'YYYY-MM-DD HH24:MI'), A.MNR_DMG_FLG_DT)," ).append("\n"); 
		query.append("	     A.MNR_TTL_LSS_FLG_DT = DECODE(@[cost_dtl_cd], 'TLL', TO_DATE(@[mnr_dmg_flg_dt],'YYYY-MM-DD'), A.MNR_TTL_LSS_FLG_DT)," ).append("\n"); 
		query.append("	     A.MNR_DISP_FLG_DT    = DECODE(@[cost_dtl_cd], 'DSP', TO_DATE(@[mnr_dmg_flg_dt],'YYYY-MM-DD'), A.MNR_DISP_FLG_DT)," ).append("\n"); 
		query.append("	     A.MNR_SCRP_FLG_DT    = DECODE(@[cost_dtl_cd], 'SCR', TO_DATE(@[mnr_dmg_flg_dt],'YYYY-MM-DD'), A.MNR_SCRP_FLG_DT)," ).append("\n"); 
		query.append("	     A.MNR_DONA_FLG_DT    = DECODE(@[cost_dtl_cd], 'DON', TO_DATE(@[mnr_dmg_flg_dt],'YYYY-MM-DD'), A.MNR_DONA_FLG_DT)," ).append("\n"); 
		query.append("		 A.MNR_STS_RMK = @[mnr_sts_rmk]" ).append("\n"); 
		query.append("WHERE A.EQ_NO = @[eq_no]" ).append("\n"); 

	}
}