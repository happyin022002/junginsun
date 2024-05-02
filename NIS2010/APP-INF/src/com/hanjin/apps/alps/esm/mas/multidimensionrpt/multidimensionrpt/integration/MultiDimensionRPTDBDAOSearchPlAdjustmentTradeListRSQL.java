/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchPlAdjustmentTradeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOSearchPlAdjustmentTradeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiDimensionRPTDBDAOSearchPlAdjustmentTradeListRSQL
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchPlAdjustmentTradeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sls_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOSearchPlAdjustmentTradeListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(GROUPING(RPT_ITM_DESC), 1, '1', '2') AS LV" ).append("\n"); 
		query.append("      ,MIN(SEQ) AS SEQ" ).append("\n"); 
		query.append("      ,DECODE(RPT_ITM_DESC, NULL, SGRP_COST_CD_DESC, RPT_ITM_DESC) AS ITM_DESC" ).append("\n"); 
		query.append("      ,STND_COST_CD" ).append("\n"); 
		query.append("      ,SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("      ,RPT_ITM_DESC" ).append("\n"); 
		query.append("      ,RPT_ITM_COLR_FLG" ).append("\n"); 
		query.append("    #foreach($key in ${allcols}) " ).append("\n"); 
		query.append("      ,SUM(HH_AMT$velocityCount) AS HH_AMT$velocityCount" ).append("\n"); 
		query.append("      ,SUM(BH_AMT$velocityCount) AS BH_AMT$velocityCount" ).append("\n"); 
		query.append("      ,SUM(DIR_M_AMT$velocityCount) AS DIR_M_AMT$velocityCount" ).append("\n"); 
		query.append("      ,SUM(TRD_AMT$velocityCount)   AS TRD_AMT$velocityCount" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("      ,SUM (COM_AMT)   AS COM_AMT" ).append("\n"); 
		query.append("      ,SUM (TTL_AMT)   AS TTL_AMT" ).append("\n"); 
		query.append("      ,COUNT(1) AS CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT C2.RPT_DP_SEQ AS SEQ" ).append("\n"); 
		query.append("              ,C2.SGRP_COST_CD" ).append("\n"); 
		query.append("              ,C2.STND_COST_CD" ).append("\n"); 
		query.append("              ,C2.SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("              ,C2.RPT_ITM_DESC" ).append("\n"); 
		query.append("              ,C2.RPT_ITM_COLR_FLG" ).append("\n"); 
		query.append("      #foreach($key in ${allcols})" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN C2.TRD_CD = '$key' AND C2.HUL_BND_CD = 'HH' AND C2.STND_COST_CD != 'RPB00000' AND C2.STND_COST_CD != 'LOADFACT' " ).append("\n"); 
		query.append("                        THEN NVL(C1.AMT, 0)" ).append("\n"); 
		query.append("                        WHEN C2.TRD_CD = '$key' AND C2.HUL_BND_CD = 'HH' AND (C2.STND_COST_CD = 'RPB00000' OR C2.STND_COST_CD = 'LOADFACT') " ).append("\n"); 
		query.append("                        THEN 1" ).append("\n"); 
		query.append("                        ELSE 0 END) *" ).append("\n"); 
		query.append("                  (CASE WHEN C2.STND_COST_CD = 'RPB00000' THEN DECODE(MAX(C1.LOAD), 0, 0, MAX(C1.REV_AMT)/MAX(C1.LOAD))" ).append("\n"); 
		query.append("                        WHEN C2.STND_COST_CD = 'LOADFACT' THEN DECODE(MAX(C1.BSA_CAPA), 0, 0, MAX(C1.LOAD)/MAX(C1.BSA_CAPA) * 100)" ).append("\n"); 
		query.append("                        ELSE 1 END) AS HH_AMT$velocityCount" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("              ,SUM(CASE WHEN C2.TRD_CD = '$key' AND C2.HUL_BND_CD = 'BH' AND C2.STND_COST_CD != 'RPB00000' AND C2.STND_COST_CD != 'LOADFACT' " ).append("\n"); 
		query.append("                        THEN NVL(C1.AMT, 0)" ).append("\n"); 
		query.append("                        WHEN C2.TRD_CD = '$key' AND C2.HUL_BND_CD = 'BH' AND (C2.STND_COST_CD = 'RPB00000' OR C2.STND_COST_CD = 'LOADFACT') " ).append("\n"); 
		query.append("                        THEN 1" ).append("\n"); 
		query.append("                        ELSE 0 END) *" ).append("\n"); 
		query.append("                  (CASE WHEN C2.STND_COST_CD = 'RPB00000' THEN DECODE(MAX(C1.LOAD), 0, 0, MAX(C1.REV_AMT)/MAX(C1.LOAD))" ).append("\n"); 
		query.append("                        WHEN C2.STND_COST_CD = 'LOADFACT' THEN DECODE(MAX(C1.BSA_CAPA), 0, 0, MAX(C1.LOAD)/MAX(C1.BSA_CAPA) * 100)" ).append("\n"); 
		query.append("                        ELSE 1 END) AS BH_AMT$velocityCount" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("              ,SUM(CASE WHEN C2.TRD_CD = '$key' AND C2.HUL_BND_CD = 'M' AND C2.STND_COST_CD != 'RPB00000' AND C2.STND_COST_CD != 'LOADFACT' " ).append("\n"); 
		query.append("                        THEN NVL(C1.AMT, 0)" ).append("\n"); 
		query.append("                        WHEN C2.TRD_CD = '$key' AND C2.HUL_BND_CD = 'M' AND (C2.STND_COST_CD = 'RPB00000' OR C2.STND_COST_CD = 'LOADFACT') " ).append("\n"); 
		query.append("                        THEN 1" ).append("\n"); 
		query.append("                        ELSE 0 END) *" ).append("\n"); 
		query.append("                  (CASE WHEN C2.STND_COST_CD = 'RPB00000' THEN DECODE(MAX(C1.LOAD), 0, 0, MAX(C1.REV_AMT)/MAX(C1.LOAD))" ).append("\n"); 
		query.append("                        WHEN C2.STND_COST_CD = 'LOADFACT' THEN DECODE(MAX(C1.BSA_CAPA), 0, 0, MAX(C1.LOAD)/MAX(C1.BSA_CAPA) * 100)" ).append("\n"); 
		query.append("                        ELSE 1 END) AS DIR_M_AMT$velocityCount" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("              ,SUM(CASE WHEN C2.TRD_CD = '$key' AND C2.STND_COST_CD != 'RPB00000' AND C2.STND_COST_CD != 'LOADFACT' " ).append("\n"); 
		query.append("                        THEN NVL(C1.AMT, 0)" ).append("\n"); 
		query.append("                        WHEN C2.TRD_CD = '$key' AND (C2.STND_COST_CD = 'RPB00000' OR C2.STND_COST_CD = 'LOADFACT') " ).append("\n"); 
		query.append("                        THEN 1" ).append("\n"); 
		query.append("                        ELSE 0 END) *" ).append("\n"); 
		query.append("                  (CASE WHEN C2.STND_COST_CD = 'RPB00000' THEN DECODE(MAX(C1.LOAD), 0, 0, MAX(C1.REV_AMT)/MAX(C1.LOAD))" ).append("\n"); 
		query.append("                        WHEN C2.STND_COST_CD = 'LOADFACT' THEN DECODE(MAX(C1.BSA_CAPA), 0, 0, MAX(C1.LOAD)/MAX(C1.BSA_CAPA) * 100)" ).append("\n"); 
		query.append("                        ELSE 1 END) AS TRD_AMT$velocityCount" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN C2.TRD_CD = 'COM' AND C2.STND_COST_CD != 'RPB00000' AND C2.STND_COST_CD != 'LOADFACT' " ).append("\n"); 
		query.append("                        THEN NVL(C1.AMT, 0)" ).append("\n"); 
		query.append("                        WHEN C2.TRD_CD = 'COM' AND (C2.STND_COST_CD = 'RPB00000' OR C2.STND_COST_CD = 'LOADFACT') " ).append("\n"); 
		query.append("                        THEN 1" ).append("\n"); 
		query.append("                        ELSE 0 END) *" ).append("\n"); 
		query.append("                  (CASE WHEN C2.STND_COST_CD = 'RPB00000' THEN DECODE(MAX(C1.LOAD), 0, 0, MAX(C1.REV_AMT)/MAX(C1.LOAD))" ).append("\n"); 
		query.append("                        WHEN C2.STND_COST_CD = 'LOADFACT' THEN DECODE(MAX(C1.BSA_CAPA), 0, 0, MAX(C1.LOAD)/MAX(C1.BSA_CAPA) * 100)" ).append("\n"); 
		query.append("                        ELSE 1 END) AS COM_AMT" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("              ,SUM(CASE WHEN C2.STND_COST_CD != 'RPB00000' AND C2.STND_COST_CD != 'LOADFACT' " ).append("\n"); 
		query.append("                        THEN NVL(C1.AMT, 0)" ).append("\n"); 
		query.append("                        WHEN C2.STND_COST_CD = 'RPB00000' OR C2.STND_COST_CD = 'LOADFACT' " ).append("\n"); 
		query.append("                        THEN 1" ).append("\n"); 
		query.append("                        ELSE 0 END) *" ).append("\n"); 
		query.append("                  (CASE WHEN C2.STND_COST_CD = 'RPB00000' THEN DECODE(MAX(C1.LOAD), 0, 0, MAX(C1.REV_AMT)/MAX(C1.LOAD))" ).append("\n"); 
		query.append("                        WHEN C2.STND_COST_CD = 'LOADFACT' THEN DECODE(MAX(C1.BSA_CAPA), 0, 0, MAX(C1.LOAD)/MAX(C1.BSA_CAPA) * 100)" ).append("\n"); 
		query.append("                        ELSE 1 END) AS TTL_AMT" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT A.TRD_CD" ).append("\n"); 
		query.append("                      ,A.HUL_BND_CD" ).append("\n"); 
		query.append("                      ,B.STND_COST_CD" ).append("\n"); 
		query.append("                      ,SUM(NVL(DECODE(A.PL_DESC, 'Week', A.ESTM_PL_AMT, 'Month', A.ACCT_AMT), 0)) OVER(PARTITION BY A.TRD_CD, A.HUL_BND_CD, B.STND_COST_CD) AS AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(B.STND_COST_CD,'LOAD0000',NVL(DECODE(A.PL_DESC, 'Week', A.ESTM_PL_AMT, 'Month', A.ACCT_AMT), 0),0)) OVER(PARTITION BY A.TRD_CD, A.HUL_BND_CD) AS LOAD" ).append("\n"); 
		query.append("                      ,SUM(DECODE(B.STND_COST_CD,'BSA00000',NVL(DECODE(A.PL_DESC, 'Week', A.ESTM_PL_AMT, 'Month', A.ACCT_AMT), 0),0)) OVER(PARTITION BY A.TRD_CD, A.HUL_BND_CD) AS BSA_CAPA" ).append("\n"); 
		query.append("                      ,SUM(DECODE(B.STND_COST_CD,'REVENUE0',NVL(DECODE(A.PL_DESC, 'Week', A.ESTM_PL_AMT, 'Month', A.ACCT_AMT), 0),0)) OVER(PARTITION BY A.TRD_CD, A.HUL_BND_CD) AS REV_AMT" ).append("\n"); 
		query.append("                FROM MAS_PFIT_ADJ A, MAS_PFIT_LSS_RPT_ITM B" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND A.STND_COST_CD = B.STND_COST_CD" ).append("\n"); 
		query.append("                  AND B.RPT_VW_CD = 'P'" ).append("\n"); 
		query.append("               #if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("                  AND A.REV_YRMON    BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append("               #elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("                  AND A.SLS_YRMON     LIKE @[f_year]||@[f_sls_mon]||'%'" ).append("\n"); 
		query.append("                  AND A.COST_WK       BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if(${f_trd_cd} !='')" ).append("\n"); 
		query.append("                  AND A.TRD_CD    = @[f_trd_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if(${f_rlane_cd} !='')" ).append("\n"); 
		query.append("                  AND A.RLANE_CD  = @[f_rlane_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if(${f_dir_cd} !='')" ).append("\n"); 
		query.append("                  AND A.SKD_DIR_CD = @[f_dir_cd] " ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if(${f_vsl_cd} !='')" ).append("\n"); 
		query.append("                  AND A.VSL_CD    = @[f_vsl_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if(${f_skd_voy_no} !='')" ).append("\n"); 
		query.append("                  AND A.SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if(${f_skd_dir_cd} !='')" ).append("\n"); 
		query.append("                  AND A.SKD_DIR_CD = @[f_skd_dir_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if(${f_sub_trd_cd} !='')" ).append("\n"); 
		query.append("                  AND A.SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if(${f_trd_dir_cd} !='')" ).append("\n"); 
		query.append("                  AND A.HUL_BND_CD = @[f_trd_dir_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("                  AND (B.STND_COST_TP_CD IN ('S','C','O') OR B.STND_COST_CD IN ('OPCTOTAL','OPB00000','BOPTOTAL','BOPB0000'))" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                SELECT DISTINCT 'COM' AS TRD_CD" ).append("\n"); 
		query.append("                      ,'M' HUL_BND_CD" ).append("\n"); 
		query.append("                      ,A1.STND_COST_CD" ).append("\n"); 
		query.append("                      ,SUM(NVL(A1.TTL_AMT, 0)) OVER(PARTITION BY A1.STND_COST_CD) AS AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(A1.STND_COST_CD,'LOAD0000',NVL(A1.TTL_AMT, 0),0)) OVER() AS LOAD" ).append("\n"); 
		query.append("                      ,SUM(DECODE(A1.STND_COST_CD,'BSA00000',NVL(A1.TTL_AMT, 0),0)) OVER() AS BSA_CAPA" ).append("\n"); 
		query.append("                      ,SUM(DECODE(A1.STND_COST_CD,'REVENUE0',NVL(A1.TTL_AMT, 0),0)) OVER() AS REV_AMT" ).append("\n"); 
		query.append("                 FROM MAS_MNL_DTL_COST A1" ).append("\n"); 
		query.append("                WHERE 1 = 1" ).append("\n"); 
		query.append("               #if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("                  AND A1.COST_YRMON    BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append("               #elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("                  AND A1.COST_YRMON    LIKE @[f_year]||'%'" ).append("\n"); 
		query.append("                  AND A1.COST_WK       BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if(${f_trd_cd} !='')" ).append("\n"); 
		query.append("                  AND 'COM'    = @[f_trd_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if(${f_rlane_cd} !='')" ).append("\n"); 
		query.append("                  AND A1.RLANE_CD  = @[f_rlane_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if(${f_dir_cd} !='')" ).append("\n"); 
		query.append("                  AND 'M'    = @[f_dir_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if(${f_vsl_cd} !='')" ).append("\n"); 
		query.append("                  AND 'CNTC'    = @[f_vsl_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if(${f_skd_voy_no} !='')" ).append("\n"); 
		query.append("                  AND SUBSTR(A1.COST_YRMON,3,2)||A1.COST_WK    = @[f_skd_voy_no]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if(${f_skd_dir_cd} !='')" ).append("\n"); 
		query.append("                  AND 'M' = @[f_skd_dir_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if(${f_sub_trd_cd} !='')" ).append("\n"); 
		query.append("                  AND 'OT' = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("            ) C1," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("              SELECT A1.TRD_CD " ).append("\n"); 
		query.append("					,A2.SGRP_COST_CD " ).append("\n"); 
		query.append("					,A2.STND_COST_CD " ).append("\n"); 
		query.append("					,A2.RPT_VW_CD " ).append("\n"); 
		query.append("					,A1.HUL_BND_CD" ).append("\n"); 
		query.append("					,A2.SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("					,A2.RPT_ITM_DESC" ).append("\n"); 
		query.append("					,A2.RPT_DP_SEQ" ).append("\n"); 
		query.append("					,A2.RPT_ITM_COLR_FLG" ).append("\n"); 
		query.append("				FROM (" ).append("\n"); 
		query.append("					 SELECT DISTINCT TRD_CD, HUL_BND_CD FROM MAS_LANE_RGST WHERE DELT_FLG = 'N' UNION ALL" ).append("\n"); 
		query.append("                     SELECT DISTINCT TRD_CD, 'M' HUL_BND_CD FROM MAS_LANE_RGST WHERE DELT_FLG = 'N' UNION ALL" ).append("\n"); 
		query.append("                     SELECT DISTINCT 'COM' TRD_CD, 'M' HUL_BND_CD FROM DUAL" ).append("\n"); 
		query.append("					 ) A1" ).append("\n"); 
		query.append("					,MAS_PFIT_LSS_RPT_ITM A2" ).append("\n"); 
		query.append("				WHERE A2.RPT_VW_CD = 'P'" ).append("\n"); 
		query.append("                  AND (A2.STND_COST_TP_CD IN ('S','C','O') OR A2.STND_COST_CD IN ('OPCTOTAL','OPB00000','BOPTOTAL','BOPB0000'))" ).append("\n"); 
		query.append("            ) C2" ).append("\n"); 
		query.append("        WHERE C1.STND_COST_CD(+) = C2.STND_COST_CD" ).append("\n"); 
		query.append("          AND C1.TRD_CD(+)       = C2.TRD_CD" ).append("\n"); 
		query.append("          AND C1.HUL_BND_CD(+)   = C2.HUL_BND_CD" ).append("\n"); 
		query.append("        GROUP BY C2.RPT_DP_SEQ" ).append("\n"); 
		query.append("              ,C2.STND_COST_CD" ).append("\n"); 
		query.append("              ,C2.SGRP_COST_CD" ).append("\n"); 
		query.append("              ,C2.RPT_ITM_DESC" ).append("\n"); 
		query.append("              ,C2.SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("              ,C2.RPT_ITM_COLR_FLG" ).append("\n"); 
		query.append("        ORDER BY SEQ" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("GROUP BY GROUPING SETS ((SGRP_COST_CD_DESC), (STND_COST_CD, SGRP_COST_CD_DESC, RPT_ITM_DESC, RPT_ITM_COLR_FLG))" ).append("\n"); 
		query.append("ORDER BY SEQ, LV" ).append("\n"); 

	}
}