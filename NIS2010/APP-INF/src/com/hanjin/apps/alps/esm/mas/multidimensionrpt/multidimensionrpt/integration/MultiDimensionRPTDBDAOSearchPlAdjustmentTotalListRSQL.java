/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchPlAdjustmentTotalListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.17 
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

public class MultiDimensionRPTDBDAOSearchPlAdjustmentTotalListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiDimensionRPTDBDAOSearchPlAdjustmentTotalListRSQL
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchPlAdjustmentTotalListRSQL(){
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
		query.append("FileName : MultiDimensionRPTDBDAOSearchPlAdjustmentTotalListRSQL").append("\n"); 
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
		query.append("      ,SUM(HH_WKLY_AMT) AS HH_WKLY_AMT" ).append("\n"); 
		query.append("      ,SUM(BH_WKLY_AMT) AS BH_WKLY_AMT" ).append("\n"); 
		query.append("      ,SUM(MB_WKLY_AMT) AS MB_WKLY_AMT" ).append("\n"); 
		query.append("      ,SUM(TTL_WKLY_AMT) AS TTL_WKLY_AMT" ).append("\n"); 
		query.append("      ,SUM(HH_ADJ_AMT) AS HH_ADJ_AMT" ).append("\n"); 
		query.append("      ,SUM(BH_ADJ_AMT) AS BH_ADJ_AMT" ).append("\n"); 
		query.append("      ,SUM(MB_ADJ_AMT) AS MB_ADJ_AMT" ).append("\n"); 
		query.append("      ,SUM(TTL_ADJ_AMT) AS TTL_ADJ_AMT" ).append("\n"); 
		query.append("      ,SUM(HH_MON_AMT) AS HH_MON_AMT" ).append("\n"); 
		query.append("      ,SUM(BH_MON_AMT) AS BH_MON_AMT" ).append("\n"); 
		query.append("      ,SUM(MB_MON_AMT) AS MB_MON_AMT" ).append("\n"); 
		query.append("      ,SUM(TTL_MON_AMT) AS TTL_MON_AMT" ).append("\n"); 
		query.append("      ,COUNT(1) AS CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT SEQ" ).append("\n"); 
		query.append("              ,STND_COST_CD" ).append("\n"); 
		query.append("              ,SGRP_COST_CD" ).append("\n"); 
		query.append("              ,RPT_ITM_DESC" ).append("\n"); 
		query.append("              ,SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("              ,RPT_ITM_COLR_FLG" ).append("\n"); 
		query.append("              ,DECODE(STND_COST_CD,'RPB00000',DECODE(MAX(HH_LOAD),0,0,MAX(HH_WKLY_REV_AMT)/MAX(HH_LOAD)),'LOADFACT',DECODE(MAX(HH_BSA_CAPA),0,0,MAX(HH_LOAD)/MAX(HH_BSA_CAPA) * 100),SUM(NVL(HH_WKLY_AMT, 0))) AS HH_WKLY_AMT" ).append("\n"); 
		query.append("              ,DECODE(STND_COST_CD,'RPB00000',DECODE(MAX(BH_LOAD),0,0,MAX(BH_WKLY_REV_AMT)/MAX(BH_LOAD)),'LOADFACT',DECODE(MAX(BH_BSA_CAPA),0,0,MAX(BH_LOAD)/MAX(BH_BSA_CAPA) * 100),SUM(NVL(BH_WKLY_AMT, 0))) AS BH_WKLY_AMT" ).append("\n"); 
		query.append("              ,DECODE(STND_COST_CD,'RPB00000',DECODE(MAX(MB_LOAD),0,0,MAX(MB_WKLY_REV_AMT)/MAX(MB_LOAD)),'LOADFACT',DECODE(MAX(MB_BSA_CAPA),0,0,MAX(MB_LOAD)/MAX(MB_BSA_CAPA) * 100),SUM(NVL(MB_WKLY_AMT, 0))) AS MB_WKLY_AMT" ).append("\n"); 
		query.append("              ,DECODE(STND_COST_CD,'RPB00000',DECODE(MAX(HH_LOAD)+MAX(BH_LOAD)+MAX(MB_LOAD),0,0,(MAX(HH_WKLY_REV_AMT)+MAX(BH_WKLY_REV_AMT)+MAX(MB_WKLY_REV_AMT)) / (MAX(HH_LOAD)+MAX(BH_LOAD)+MAX(MB_LOAD)))," ).append("\n"); 
		query.append("                                   'LOADFACT',DECODE(MAX(HH_BSA_CAPA)+MAX(BH_BSA_CAPA)+MAX(MB_BSA_CAPA),0,0,(MAX(HH_LOAD)+MAX(BH_LOAD)+MAX(MB_LOAD))/(MAX(HH_BSA_CAPA)+MAX(BH_BSA_CAPA)+MAX(MB_BSA_CAPA)) * 100)," ).append("\n"); 
		query.append("                                   SUM(NVL(HH_WKLY_AMT, 0)) + SUM(NVL(BH_WKLY_AMT, 0)) + SUM(NVL(MB_WKLY_AMT, 0))) AS TTL_WKLY_AMT" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              ,DECODE(STND_COST_CD,'RPB00000',DECODE(MAX(HH_LOAD),0,0,MAX(HH_MON_REV_AMT)/MAX(HH_LOAD)),'LOADFACT',DECODE(MAX(HH_BSA_CAPA),0,0,MAX(HH_LOAD)/MAX(HH_BSA_CAPA) * 100),SUM(NVL(HH_MON_AMT, 0))) -" ).append("\n"); 
		query.append("               DECODE(STND_COST_CD,'RPB00000',DECODE(MAX(HH_LOAD),0,0,MAX(HH_WKLY_REV_AMT)/MAX(HH_LOAD)),'LOADFACT',DECODE(MAX(HH_BSA_CAPA),0,0,MAX(HH_LOAD)/MAX(HH_BSA_CAPA) * 100),SUM(NVL(HH_WKLY_AMT, 0))) AS HH_ADJ_AMT" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("              ,DECODE(STND_COST_CD,'RPB00000',DECODE(MAX(BH_LOAD),0,0,MAX(BH_MON_REV_AMT)/MAX(BH_LOAD)),'LOADFACT',DECODE(MAX(BH_BSA_CAPA),0,0,MAX(BH_LOAD)/MAX(BH_BSA_CAPA) * 100),SUM(NVL(BH_MON_AMT, 0))) -" ).append("\n"); 
		query.append("               DECODE(STND_COST_CD,'RPB00000',DECODE(MAX(BH_LOAD),0,0,MAX(BH_WKLY_REV_AMT)/MAX(BH_LOAD)),'LOADFACT',DECODE(MAX(BH_BSA_CAPA),0,0,MAX(BH_LOAD)/MAX(BH_BSA_CAPA) * 100),SUM(NVL(BH_WKLY_AMT, 0))) AS BH_ADJ_AMT" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("              ,DECODE(STND_COST_CD,'RPB00000',DECODE(MAX(MB_LOAD),0,0,MAX(MB_MON_REV_AMT)/MAX(MB_LOAD)),'LOADFACT',DECODE(MAX(MB_BSA_CAPA),0,0,MAX(MB_LOAD)/MAX(MB_BSA_CAPA) * 100),SUM(NVL(MB_MON_AMT, 0))) -" ).append("\n"); 
		query.append("               DECODE(STND_COST_CD,'RPB00000',DECODE(MAX(MB_LOAD),0,0,MAX(MB_WKLY_REV_AMT)/MAX(MB_LOAD)),'LOADFACT',DECODE(MAX(MB_BSA_CAPA),0,0,MAX(MB_LOAD)/MAX(MB_BSA_CAPA) * 100),SUM(NVL(MB_WKLY_AMT, 0))) AS MB_ADJ_AMT" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("              ,DECODE(STND_COST_CD,'RPB00000',DECODE(MAX(HH_LOAD)+MAX(BH_LOAD)+MAX(MB_LOAD),0,0,(MAX(HH_MON_REV_AMT)+MAX(BH_MON_REV_AMT)+MAX(MB_MON_REV_AMT)) / (MAX(HH_LOAD)+MAX(BH_LOAD)+MAX(MB_LOAD)))," ).append("\n"); 
		query.append("                                   'LOADFACT',DECODE(MAX(HH_BSA_CAPA)+MAX(BH_BSA_CAPA)+MAX(MB_BSA_CAPA),0,0,(MAX(HH_LOAD)+MAX(BH_LOAD)+MAX(MB_LOAD))/(MAX(HH_BSA_CAPA)+MAX(BH_BSA_CAPA)+MAX(MB_BSA_CAPA)) * 100)," ).append("\n"); 
		query.append("                                   SUM(NVL(HH_MON_AMT, 0)) + SUM(NVL(BH_MON_AMT, 0)) + SUM(NVL(MB_MON_AMT, 0))) -" ).append("\n"); 
		query.append("               DECODE(STND_COST_CD,'RPB00000',DECODE(MAX(HH_LOAD)+MAX(BH_LOAD)+MAX(MB_LOAD),0,0,(MAX(HH_WKLY_REV_AMT)+MAX(BH_WKLY_REV_AMT)+MAX(MB_WKLY_REV_AMT)) / (MAX(HH_LOAD)+MAX(BH_LOAD)+MAX(MB_LOAD)))," ).append("\n"); 
		query.append("                                   'LOADFACT',DECODE(MAX(HH_BSA_CAPA)+MAX(BH_BSA_CAPA)+MAX(MB_BSA_CAPA),0,0,(MAX(HH_LOAD)+MAX(BH_LOAD)+MAX(MB_LOAD))/(MAX(HH_BSA_CAPA)+MAX(BH_BSA_CAPA)+MAX(MB_BSA_CAPA)) * 100)," ).append("\n"); 
		query.append("                                   SUM(NVL(HH_WKLY_AMT, 0)) + SUM(NVL(BH_WKLY_AMT, 0)) + SUM(NVL(MB_WKLY_AMT, 0))) AS TTL_ADJ_AMT                                   " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              ,DECODE(STND_COST_CD,'RPB00000',DECODE(MAX(HH_LOAD),0,0,MAX(HH_MON_REV_AMT)/MAX(HH_LOAD)),'LOADFACT',DECODE(MAX(HH_BSA_CAPA),0,0,MAX(HH_LOAD)/MAX(HH_BSA_CAPA) * 100),SUM(NVL(HH_MON_AMT, 0))) AS HH_MON_AMT" ).append("\n"); 
		query.append("              ,DECODE(STND_COST_CD,'RPB00000',DECODE(MAX(BH_LOAD),0,0,MAX(BH_MON_REV_AMT)/MAX(BH_LOAD)),'LOADFACT',DECODE(MAX(BH_BSA_CAPA),0,0,MAX(BH_LOAD)/MAX(BH_BSA_CAPA) * 100),SUM(NVL(BH_MON_AMT, 0))) AS BH_MON_AMT" ).append("\n"); 
		query.append("              ,DECODE(STND_COST_CD,'RPB00000',DECODE(MAX(MB_LOAD),0,0,MAX(MB_MON_REV_AMT)/MAX(MB_LOAD)),'LOADFACT',DECODE(MAX(MB_BSA_CAPA),0,0,MAX(MB_LOAD)/MAX(MB_BSA_CAPA) * 100),SUM(NVL(MB_MON_AMT, 0))) AS MB_MON_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,DECODE(STND_COST_CD,'RPB00000',DECODE(MAX(HH_LOAD)+MAX(BH_LOAD)+MAX(MB_LOAD),0,0,(MAX(HH_MON_REV_AMT)+MAX(BH_MON_REV_AMT)+MAX(MB_MON_REV_AMT)) / (MAX(HH_LOAD)+MAX(BH_LOAD)+MAX(MB_LOAD)))," ).append("\n"); 
		query.append("                                   'LOADFACT',DECODE(MAX(HH_BSA_CAPA)+MAX(BH_BSA_CAPA)+MAX(MB_BSA_CAPA),0,0,(MAX(HH_LOAD)+MAX(BH_LOAD)+MAX(MB_LOAD))/(MAX(HH_BSA_CAPA)+MAX(BH_BSA_CAPA)+MAX(MB_BSA_CAPA)) * 100)," ).append("\n"); 
		query.append("                                   SUM(NVL(HH_MON_AMT, 0)) + SUM(NVL(BH_MON_AMT, 0)) + SUM(NVL(MB_MON_AMT, 0))) AS TTL_MON_AMT" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT B.RPT_DP_SEQ AS SEQ" ).append("\n"); 
		query.append("                      ,A.HUL_BND_CD" ).append("\n"); 
		query.append("                      ,B.STND_COST_CD" ).append("\n"); 
		query.append("                      ,B.SGRP_COST_CD" ).append("\n"); 
		query.append("                      ,B.RPT_ITM_DESC" ).append("\n"); 
		query.append("                      ,B.SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("                      ,B.RPT_ITM_COLR_FLG" ).append("\n"); 
		query.append("                      ,DECODE(A.HUL_BND_CD, 'HH', A.ESTM_PL_AMT, 0) AS HH_WKLY_AMT" ).append("\n"); 
		query.append("                      ,DECODE(A.HUL_BND_CD, 'BH', A.ESTM_PL_AMT, 0) AS BH_WKLY_AMT" ).append("\n"); 
		query.append("                      ,DECODE(A.HUL_BND_CD, 'M', A.ESTM_PL_AMT, 0) AS MB_WKLY_AMT" ).append("\n"); 
		query.append("                      ,CASE WHEN A.HUL_BND_CD = 'HH' AND A.PL_DESC = 'Week' THEN A.ESTM_PL_AMT" ).append("\n"); 
		query.append("                       WHEN A.HUL_BND_CD = 'HH' AND A.PL_DESC = 'Month' THEN A.ACCT_AMT END AS HH_MON_AMT" ).append("\n"); 
		query.append("                      ,CASE WHEN A.HUL_BND_CD = 'BH' AND A.PL_DESC = 'Week' THEN A.ESTM_PL_AMT" ).append("\n"); 
		query.append("                       WHEN A.HUL_BND_CD = 'BH' AND A.PL_DESC = 'Month' THEN A.ACCT_AMT END AS BH_MON_AMT" ).append("\n"); 
		query.append("                      ,CASE WHEN A.HUL_BND_CD = 'M' AND A.PL_DESC = 'Week' THEN A.ESTM_PL_AMT" ).append("\n"); 
		query.append("                       WHEN A.HUL_BND_CD = 'M' AND A.PL_DESC = 'Month' THEN A.ACCT_AMT END AS MB_MON_AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(B.STND_COST_CD,'LOAD0000',DECODE(A.HUL_BND_CD, 'HH', A.ESTM_PL_AMT, 0),0)) OVER(PARTITION BY A.HUL_BND_CD) AS HH_LOAD" ).append("\n"); 
		query.append("                      ,SUM(DECODE(B.STND_COST_CD,'LOAD0000',DECODE(A.HUL_BND_CD, 'BH', A.ESTM_PL_AMT, 0),0)) OVER(PARTITION BY A.HUL_BND_CD) AS BH_LOAD" ).append("\n"); 
		query.append("                      ,SUM(DECODE(B.STND_COST_CD,'LOAD0000',DECODE(A.HUL_BND_CD, 'M',  A.ESTM_PL_AMT, 0),0)) OVER(PARTITION BY A.HUL_BND_CD) AS MB_LOAD" ).append("\n"); 
		query.append("                      ,SUM(DECODE(B.STND_COST_CD,'BSA00000',DECODE(A.HUL_BND_CD, 'HH', A.ESTM_PL_AMT, 0),0)) OVER(PARTITION BY A.HUL_BND_CD) AS HH_BSA_CAPA" ).append("\n"); 
		query.append("                      ,SUM(DECODE(B.STND_COST_CD,'BSA00000',DECODE(A.HUL_BND_CD, 'BH', A.ESTM_PL_AMT, 0),0)) OVER(PARTITION BY A.HUL_BND_CD) AS BH_BSA_CAPA" ).append("\n"); 
		query.append("                      ,SUM(DECODE(B.STND_COST_CD,'BSA00000',DECODE(A.HUL_BND_CD, 'M',  A.ESTM_PL_AMT, 0),0)) OVER(PARTITION BY A.HUL_BND_CD) AS MB_BSA_CAPA" ).append("\n"); 
		query.append("                      ,SUM(DECODE(B.STND_COST_CD,'REVENUE0',DECODE(A.HUL_BND_CD, 'HH', A.ESTM_PL_AMT, 0),0)) OVER(PARTITION BY A.HUL_BND_CD) AS HH_WKLY_REV_AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(B.STND_COST_CD,'REVENUE0',DECODE(A.HUL_BND_CD, 'BH', A.ESTM_PL_AMT, 0),0)) OVER(PARTITION BY A.HUL_BND_CD) AS BH_WKLY_REV_AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(B.STND_COST_CD,'REVENUE0',DECODE(A.HUL_BND_CD, 'M',  A.ESTM_PL_AMT, 0),0)) OVER(PARTITION BY A.HUL_BND_CD) AS MB_WKLY_REV_AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(B.STND_COST_CD,'REVENUE0',DECODE(A.HUL_BND_CD, 'HH',DECODE(A.PL_DESC, 'Week', A.ESTM_PL_AMT,A.ACCT_AMT), 0), 0)) OVER(PARTITION BY A.HUL_BND_CD) AS HH_MON_REV_AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(B.STND_COST_CD,'REVENUE0',DECODE(A.HUL_BND_CD, 'BH',DECODE(A.PL_DESC, 'Week', A.ESTM_PL_AMT,A.ACCT_AMT), 0), 0)) OVER(PARTITION BY A.HUL_BND_CD) AS BH_MON_REV_AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(B.STND_COST_CD,'REVENUE0',DECODE(A.HUL_BND_CD, 'M', DECODE(A.PL_DESC, 'Week', A.ESTM_PL_AMT,A.ACCT_AMT), 0), 0)) OVER(PARTITION BY A.HUL_BND_CD) AS MB_MON_REV_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                FROM MAS_PFIT_ADJ A, MAS_PFIT_LSS_RPT_ITM B" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND A.STND_COST_CD = B.STND_COST_CD" ).append("\n"); 
		query.append("                AND B.RPT_VW_CD = 'P'" ).append("\n"); 
		query.append("            #if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("				AND A.REV_YRMON    BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append("			#elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("				AND A.SLS_YRMON     LIKE @[f_year]||@[f_sls_mon]||'%'" ).append("\n"); 
		query.append("				AND A.COST_WK       BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("            #if(${f_trd_cd} !='')" ).append("\n"); 
		query.append("				AND A.TRD_CD    = @[f_trd_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_rlane_cd} !='')" ).append("\n"); 
		query.append("				AND A.RLANE_CD  = @[f_rlane_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_dir_cd} !='')" ).append("\n"); 
		query.append("				AND A.SKD_DIR_CD = @[f_dir_cd] " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_vsl_cd} !='')" ).append("\n"); 
		query.append("				AND A.VSL_CD    = @[f_vsl_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_skd_voy_no} !='')" ).append("\n"); 
		query.append("				AND A.SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_skd_dir_cd} !='')" ).append("\n"); 
		query.append("				AND A.SKD_DIR_CD = @[f_skd_dir_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("			#if(${f_sub_trd_cd} !='')" ).append("\n"); 
		query.append("				AND A.SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("			#if(${f_trd_dir_cd} !='')" ).append("\n"); 
		query.append("				AND A.HUL_BND_CD = @[f_trd_dir_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("                AND (B.STND_COST_TP_CD IN ('S','C','O') OR B.STND_COST_CD IN ('OPCTOTAL','OPB00000','BOPTOTAL','BOPB0000'))" ).append("\n"); 
		query.append("                ORDER BY SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        GROUP BY SEQ" ).append("\n"); 
		query.append("              ,STND_COST_CD" ).append("\n"); 
		query.append("              ,SGRP_COST_CD" ).append("\n"); 
		query.append("              ,RPT_ITM_DESC" ).append("\n"); 
		query.append("              ,SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("              ,RPT_ITM_COLR_FLG" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("GROUP BY GROUPING SETS ((SGRP_COST_CD_DESC), (STND_COST_CD, SGRP_COST_CD_DESC, RPT_ITM_DESC, RPT_ITM_COLR_FLG)) " ).append("\n"); 
		query.append("ORDER BY SEQ, LV" ).append("\n"); 

	}
}