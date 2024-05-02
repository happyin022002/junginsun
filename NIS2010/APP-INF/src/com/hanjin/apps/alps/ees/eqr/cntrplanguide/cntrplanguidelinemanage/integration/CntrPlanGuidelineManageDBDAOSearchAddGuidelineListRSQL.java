/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAOSearchAddGuidelineListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanGuidelineManageDBDAOSearchAddGuidelineListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GUIDELINS ADD/AMEND POPUP QUERY
	  * </pre>
	  */
	public CntrPlanGuidelineManageDBDAOSearchAddGuidelineListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eff_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration").append("\n"); 
		query.append("FileName : CntrPlanGuidelineManageDBDAOSearchAddGuidelineListRSQL").append("\n"); 
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
		query.append("SELECT   TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,VSL_LANE_CD" ).append("\n"); 
		query.append("        ,'' EQ_GLINE_SEQ" ).append("\n"); 
		query.append("        ,VVD" ).append("\n"); 
		query.append("        ,POL_CD" ).append("\n"); 
		query.append("        ,ETA_DT" ).append("\n"); 
		query.append("		,EFF_ST_DT 	" ).append("\n"); 
		query.append("        ,POD_CD 		" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("	#foreach( ${key} in ${arr_cntr_tpsz_cd}) " ).append("\n"); 
		query.append("		,'' QTY_$key" ).append("\n"); 
		query.append("	    ,'' UT_$key" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("        ,' ' REPO_GLINE_RMK	" ).append("\n"); 
		query.append("        ,'99991231' EFF_END_DT  		" ).append("\n"); 
		query.append("        ,SYSDATE UPD_DT  		" ).append("\n"); 
		query.append("        ,'' UPD_USR_NM  		" ).append("\n"); 
		query.append("        ,'' UPD_USR_ID  		" ).append("\n"); 
		query.append("        ,'N' CFM_FLG  		" ).append("\n"); 
		query.append("        ,SUBSTR(VVD,1,4)VSL_CD      		" ).append("\n"); 
		query.append("        ,SUBSTR(VVD,5,4)SKD_VOY_NO  		" ).append("\n"); 
		query.append("        ,SUBSTR(VVD,9,1)SKD_DIR_CD " ).append("\n"); 
		query.append("		,SORT_ID" ).append("\n"); 
		query.append("    FROM   (SELECT @[trade] TRD_CD" ).append("\n"); 
		query.append("                  ,SUBSTR(@[subtrade],4,2) SUB_TRD_CD" ).append("\n"); 
		query.append("                  --,SUBSTR([lane],6) VSL_LANE_CD" ).append("\n"); 
		query.append("                  ,@[lane]     VSL_LANE_CD" ).append("\n"); 
		query.append("                  ,@[s_vvd_cd] VVD" ).append("\n"); 
		query.append("                  ,@[s_pol_cd] POL_CD" ).append("\n"); 
		query.append("                  ,@[s_eta_dt] ETA_DT" ).append("\n"); 
		query.append("                  ,@[s_eff_st_dt] EFF_ST_DT" ).append("\n"); 
		query.append("				  ,'Priority' POD_CD" ).append("\n"); 
		query.append("                  ,0 CLPT_SEQ " ).append("\n"); 
		query.append("                  ,'1' SORT_ID" ).append("\n"); 
		query.append("              FROM DUAL" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT @[trade] TRD_CD" ).append("\n"); 
		query.append("                  ,SUBSTR(@[subtrade],4,2) SUB_TRD_CD" ).append("\n"); 
		query.append("                  --,SUBSTR([lane],6) VSL_LANE_CD" ).append("\n"); 
		query.append("                  ,@[lane] VSL_LANE_CD" ).append("\n"); 
		query.append("                  ,@[s_vvd_cd] VVD" ).append("\n"); 
		query.append("                  ,@[s_pol_cd] POL_CD" ).append("\n"); 
		query.append("                  ,@[s_eta_dt] ETA_DT" ).append("\n"); 
		query.append("                  ,@[s_eff_st_dt] EFF_ST_DT" ).append("\n"); 
		query.append("                  ,'%' POD" ).append("\n"); 
		query.append("                  ,0 CLPT_SEQ " ).append("\n"); 
		query.append("                  ,'2' SORT_ID" ).append("\n"); 
		query.append("              FROM DUAL" ).append("\n"); 
		query.append("             UNION ALL" ).append("\n"); 
		query.append("            SELECT @[trade] TRD_CD" ).append("\n"); 
		query.append("                  ,SUBSTR(@[subtrade],4,2) SUB_TRD_CD" ).append("\n"); 
		query.append("                  --,SUBSTR([lane],6) VSL_LANE_CD" ).append("\n"); 
		query.append("                  ,@[lane] VSL_LANE_CD" ).append("\n"); 
		query.append("                  ,@[s_vvd_cd] VVD" ).append("\n"); 
		query.append("                  ,@[s_pol_cd] POL_CD" ).append("\n"); 
		query.append("                  ,@[s_eta_dt] ETA_DT" ).append("\n"); 
		query.append("                  ,@[s_eff_st_dt] EFF_ST_DT" ).append("\n"); 
		query.append("				  ,A.VPS_PORT_CD POD" ).append("\n"); 
		query.append("                  ,A.CLPT_SEQ " ).append("\n"); 
		query.append("                  ,'3' SORT_ID" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD	A" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("		   #if (${s_vvd_cd} != '') " ).append("\n"); 
		query.append("			   AND VSL_CD = SUBSTR(@[s_vvd_cd],1,4)            -- ADD 선택값" ).append("\n"); 
		query.append("               AND SKD_VOY_NO = SUBSTR(@[s_vvd_cd],5,4)            -- ADD 선택값" ).append("\n"); 
		query.append("               AND SKD_DIR_CD = SUBSTR(@[s_vvd_cd],9)               -- ADD 선택값   " ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("	   		   AND A.VPS_PORT_CD IN ( SELECT LOC_CD " ).append("\n"); 
		query.append("              				            FROM MDM_LOCATION" ).append("\n"); 
		query.append("			                           WHERE CONTI_CD      = 'A'  -- 하드코딩, ASIA 제외" ).append("\n"); 
		query.append("            				             AND CALL_PORT_FLG = 'Y'   -- 하드코딩, PORT 만 검색" ).append("\n"); 
		query.append("                            			 AND DELT_FLG      = 'N'   -- 하드코딩, DELT 제거" ).append("\n"); 
		query.append("                         			) " ).append("\n"); 
		query.append("               ) " ).append("\n"); 
		query.append(" ORDER BY SORT_ID,CLPT_SEQ" ).append("\n"); 

	}
}