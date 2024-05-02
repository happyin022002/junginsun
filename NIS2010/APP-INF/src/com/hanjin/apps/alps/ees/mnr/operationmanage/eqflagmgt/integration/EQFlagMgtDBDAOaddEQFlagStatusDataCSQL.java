/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EQFlagMgtDBDAOaddEQFlagStatusDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.18
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.05.18 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HamHyungSeok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOaddEQFlagStatusDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addEQFlagStatusData
	  * </pre>
	  */
	public EQFlagMgtDBDAOaddEQFlagStatusDataCSQL(){
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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_dmg_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOaddEQFlagStatusDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_EQ_STS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("          EQ_NO, " ).append("\n"); 
		query.append("          EQ_KND_CD, " ).append("\n"); 
		query.append("          EQ_TPSZ_CD, " ).append("\n"); 
		query.append("		  MNR_DMG_FLG," ).append("\n"); 
		query.append("		  MNR_TTL_LSS_FLG," ).append("\n"); 
		query.append("		  MNR_DISP_FLG," ).append("\n"); 
		query.append("		  MNR_SCRP_FLG," ).append("\n"); 
		query.append("		  MNR_DONA_FLG," ).append("\n"); 
		query.append("		  MNR_DMG_FLG_YD_CD," ).append("\n"); 
		query.append("		  MNR_TTL_LSS_FLG_YD_CD," ).append("\n"); 
		query.append("		  MNR_DISP_FLG_YD_CD," ).append("\n"); 
		query.append("		  MNR_SCRP_FLG_YD_CD," ).append("\n"); 
		query.append("		  MNR_DONA_FLG_YD_CD," ).append("\n"); 
		query.append("		  MNR_DMG_FLG_DT," ).append("\n"); 
		query.append("		  MNR_TTL_LSS_FLG_DT," ).append("\n"); 
		query.append("		  MNR_DISP_FLG_DT," ).append("\n"); 
		query.append("		  MNR_SCRP_FLG_DT," ).append("\n"); 
		query.append("		  MNR_DONA_FLG_DT," ).append("\n"); 
		query.append("          MNR_STS_RMK, " ).append("\n"); 
		query.append("          CRE_USR_ID, " ).append("\n"); 
		query.append("          CRE_DT, " ).append("\n"); 
		query.append("          UPD_USR_ID, " ).append("\n"); 
		query.append("          UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("         @[eq_no]," ).append("\n"); 
		query.append("         @[eq_knd_cd]," ).append("\n"); 
		query.append("         @[eq_tpsz_cd]," ).append("\n"); 
		query.append("		 DECODE(@[cost_dtl_cd], 'DMG', DECODE(@[mnr_dmg_flg],'0','N','Y'), 'N')," ).append("\n"); 
		query.append("		 DECODE(@[cost_dtl_cd], 'TLL', DECODE(@[mnr_dmg_flg],'0','N','Y'), 'N')," ).append("\n"); 
		query.append("		 DECODE(@[cost_dtl_cd], 'DSP', DECODE(@[mnr_dmg_flg],'0','N','Y'), 'N')," ).append("\n"); 
		query.append("		 DECODE(@[cost_dtl_cd], 'SCR', DECODE(@[mnr_dmg_flg],'0','N','Y'), 'N')," ).append("\n"); 
		query.append("		 DECODE(@[cost_dtl_cd], 'DON', DECODE(@[mnr_dmg_flg],'0','N','Y'), 'N')," ).append("\n"); 
		query.append("		 DECODE(@[cost_dtl_cd], 'DMG', @[mnr_dmg_flg_yd_cd])," ).append("\n"); 
		query.append("		 DECODE(@[cost_dtl_cd], 'TLL', @[mnr_dmg_flg_yd_cd])," ).append("\n"); 
		query.append("		 DECODE(@[cost_dtl_cd], 'DSP', @[mnr_dmg_flg_yd_cd])," ).append("\n"); 
		query.append("		 DECODE(@[cost_dtl_cd], 'SCR', @[mnr_dmg_flg_yd_cd])," ).append("\n"); 
		query.append("		 DECODE(@[cost_dtl_cd], 'DON', @[mnr_dmg_flg_yd_cd])," ).append("\n"); 
		query.append("		 DECODE(@[cost_dtl_cd], 'DMG', TO_DATE(@[mnr_dmg_flg_dt],'YYYY-MM-DD'))," ).append("\n"); 
		query.append("		 DECODE(@[cost_dtl_cd], 'TLL', TO_DATE(@[mnr_dmg_flg_dt],'YYYY-MM-DD'))," ).append("\n"); 
		query.append("		 DECODE(@[cost_dtl_cd], 'DSP', TO_DATE(@[mnr_dmg_flg_dt],'YYYY-MM-DD'))," ).append("\n"); 
		query.append("		 DECODE(@[cost_dtl_cd], 'SCR', TO_DATE(@[mnr_dmg_flg_dt],'YYYY-MM-DD'))," ).append("\n"); 
		query.append("		 DECODE(@[cost_dtl_cd], 'DON', TO_DATE(@[mnr_dmg_flg_dt],'YYYY-MM-DD'))," ).append("\n"); 
		query.append("         @[mnr_sts_rmk]," ).append("\n"); 
		query.append("         @[cre_usr_id]," ).append("\n"); 
		query.append("         SYSDATE," ).append("\n"); 
		query.append("         @[cre_usr_id]," ).append("\n"); 
		query.append("         SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}