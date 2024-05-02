/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOaddUserAuthSetupCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOaddUserAuthSetupCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2011.10.12 윤태승 [CHM-201113684-01][ESM_BKG] US AMS 의 MI 중복전송 기능 요청 - IDhjsedlee
	  * * 2012.05.10 김보배 [CHM-201217461] [BKG] [ACE M1] US AMS 전송후 1J 이후 Diversion 요청 기능 추가
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOaddUserAuthSetupCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_mib",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_fpo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mi_multi",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_hub",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_ftz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("of_mit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mi_cstms",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_cstms",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("of_his",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_ptt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_div",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mi_hub",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOaddUserAuthSetupCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("  INTO BKG_CSTMS_COM_USR_AUTH " ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       CNT_CD" ).append("\n"); 
		query.append("      ,PROC_ID" ).append("\n"); 
		query.append("      ,ACT_ID" ).append("\n"); 
		query.append("      ,USR_ID" ).append("\n"); 
		query.append("      ,CSTMS_AUTH_FLG" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("SELECT TB.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT 'US' " ).append("\n"); 
		query.append("              ,CASE WHEN IDX.LVL = 1 THEN 'BLI'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 2 THEN 'BLI'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 3 THEN 'BLI'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 4 THEN 'BLI'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 5 THEN 'BLI'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 6 THEN 'BLI'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 7 THEN 'BLI'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 8 THEN 'BLI'" ).append("\n"); 
		query.append("					WHEN IDX.LVL = 9 THEN 'BLI'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 10 THEN 'MIB'" ).append("\n"); 
		query.append("					WHEN IDX.LVL = 11 THEN 'MIB'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 12 THEN 'MI'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 13 THEN 'BLI'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 14 THEN 'OFM'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 15 THEN 'OFM'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 16 THEN 'CHG'" ).append("\n"); 
		query.append("                    ELSE NULL END PROC_ID" ).append("\n"); 
		query.append("              ,CASE WHEN IDX.LVL = 1 THEN 'VVD'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 2 THEN 'POD'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 3 THEN 'DEL'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 4 THEN 'HUB'" ).append("\n"); 
		query.append("					WHEN IDX.LVL = 5 THEN 'CSTMS'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 6 THEN 'MIB'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 7 THEN 'PTT'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 8 THEN 'FTZ'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 9 THEN 'DIV'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 10 THEN 'HUB'" ).append("\n"); 
		query.append("					WHEN IDX.LVL = 11 THEN 'CSTMS'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 12 THEN 'MULTI'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 13 THEN 'FPO'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 14 THEN 'MIT'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 15 THEN 'HIS'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 16 THEN 'POD'" ).append("\n"); 
		query.append("                    ELSE NULL END ACT_ID" ).append("\n"); 
		query.append("              ,PARA.USR_ID" ).append("\n"); 
		query.append("              ,CASE WHEN IDX.LVL = 1 AND PARA.BL_VVD = 1 THEN 'Y'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 2 AND PARA.BL_POD = 1 THEN 'Y'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 3 AND PARA.BL_DEL = 1 THEN 'Y'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 4 AND PARA.BL_HUB = 1 THEN 'Y'" ).append("\n"); 
		query.append("					WHEN IDX.LVL = 5 AND PARA.BL_CSTMS = 1 THEN 'Y'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 6 AND PARA.BL_MIB = 1 THEN 'Y'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 7 AND PARA.BL_PTT = 1 THEN 'Y'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 8 AND PARA.BL_FTZ = 1 THEN 'Y'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 9 AND PARA.BL_DIV = 1 THEN 'Y'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 10 AND PARA.MI_HUB = 1 THEN 'Y'" ).append("\n"); 
		query.append("					WHEN IDX.LVL = 11 AND PARA.MI_CSTMS = 1 THEN 'Y'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 12 AND PARA.MI_MULTI = 1 THEN 'Y'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 13 AND PARA.BL_FPO = 1 THEN 'Y'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 14 AND PARA.OF_MIT = 1 THEN 'Y'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 15 AND PARA.OF_HIS = 1 THEN 'Y'" ).append("\n"); 
		query.append("                    WHEN IDX.LVL = 16 AND PARA.CHG_POD = 1 THEN 'Y'" ).append("\n"); 
		query.append("                    ELSE 'N' END CSTMS_AUTH_FLG" ).append("\n"); 
		query.append("              ,PARA.CRE_USR_ID" ).append("\n"); 
		query.append("              ,PARA.UPD_USR_ID" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("               SELECT @[usr_id] USR_ID" ).append("\n"); 
		query.append("                     ,@[bl_vvd] BL_VVD" ).append("\n"); 
		query.append("                     ,@[bl_pod] BL_POD" ).append("\n"); 
		query.append("                     ,@[bl_del] BL_DEL" ).append("\n"); 
		query.append("                     ,@[bl_hub] BL_HUB" ).append("\n"); 
		query.append("					 ,@[bl_cstms] BL_CSTMS" ).append("\n"); 
		query.append("                     ,@[bl_mib] BL_MIB" ).append("\n"); 
		query.append("                     ,@[bl_fpo] BL_FPO" ).append("\n"); 
		query.append("                     ,@[bl_ptt] BL_PTT" ).append("\n"); 
		query.append("                     ,@[bl_ftz] BL_FTZ" ).append("\n"); 
		query.append("                     ,@[bl_div] BL_DIV" ).append("\n"); 
		query.append("                     ,@[mi_hub] MI_HUB" ).append("\n"); 
		query.append("					 ,@[mi_cstms] MI_CSTMS" ).append("\n"); 
		query.append("                     ,@[mi_multi] MI_MULTI" ).append("\n"); 
		query.append("                     ,@[of_mit] OF_MIT" ).append("\n"); 
		query.append("                     ,@[of_his] OF_HIS" ).append("\n"); 
		query.append("                     ,@[chg_pod] CHG_POD" ).append("\n"); 
		query.append("                     ,@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("                     ,@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("                 FROM DUAL" ).append("\n"); 
		query.append("               ) PARA" ).append("\n"); 
		query.append("               ," ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("              SELECT 1 LVL FROM DUAL UNION ALL" ).append("\n"); 
		query.append("              SELECT 2 LVL FROM DUAL UNION ALL" ).append("\n"); 
		query.append("              SELECT 3 LVL FROM DUAL UNION ALL" ).append("\n"); 
		query.append("              SELECT 4 LVL FROM DUAL UNION ALL" ).append("\n"); 
		query.append("              SELECT 5 LVL FROM DUAL UNION ALL" ).append("\n"); 
		query.append("              SELECT 6 LVL FROM DUAL UNION ALL" ).append("\n"); 
		query.append("              SELECT 7 LVL FROM DUAL UNION ALL" ).append("\n"); 
		query.append("              SELECT 8 LVL FROM DUAL UNION ALL" ).append("\n"); 
		query.append("              SELECT 9 LVL FROM DUAL UNION ALL" ).append("\n"); 
		query.append("              SELECT 10 LVL FROM DUAL UNION ALL" ).append("\n"); 
		query.append("              SELECT 11 LVL FROM DUAL UNION ALL" ).append("\n"); 
		query.append("              SELECT 12 LVL FROM DUAL UNION ALL" ).append("\n"); 
		query.append("			  SELECT 13 LVL FROM DUAL UNION ALL" ).append("\n"); 
		query.append("			  SELECT 14 LVL FROM DUAL UNION ALL" ).append("\n"); 
		query.append("              SELECT 15 LVL FROM DUAL UNION ALL" ).append("\n"); 
		query.append("              SELECT 16 LVL FROM DUAL" ).append("\n"); 
		query.append("              ) IDX" ).append("\n"); 
		query.append("       ) TB" ).append("\n"); 
		query.append(" WHERE TB.CSTMS_AUTH_FLG = 'Y'" ).append("\n"); 

	}
}