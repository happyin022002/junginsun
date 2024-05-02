/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkDistributionDBDAOSearchFixCostDistResultListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOSearchFixCostDistResultListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History ----------------------------
	  * 2010.11.23 이행지 [CHM-201006375-01][COA] Trunk IPC와 Ocean간 내부거래 신규 추가로 인한 기존 조회대상에서 삭제되도록 수정 
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchFixCostDistResultListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon_s",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_wk_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_wk_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOSearchFixCostDistResultListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("     A.COST_YRMON                                                                                                AS COST_YRMON" ).append("\n"); 
		query.append("    ,A.COST_WK                                                                                                   AS COST_WK" ).append("\n"); 
		query.append("    ,B.TRD_CD                                                                                                    AS TRD_CD" ).append("\n"); 
		query.append("    ,B.RLANE_CD                                                                                                  AS RLANE_CD" ).append("\n"); 
		query.append("    ,B.IOC_CD                                                                                                    AS IOC_CD" ).append("\n"); 
		query.append("    ,B.VSL_CD||B.SKD_VOY_NO||B.DIR_CD                                                                            AS VVD_CD" ).append("\n"); 
		query.append("	, (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03217' AND INTG_CD_VAL_CTNT = D.HUL_BND_CD) HUL_BND_CD" ).append("\n"); 
		query.append(" #if (${f_op_view} == 'OP1')" ).append("\n"); 
		query.append("	,NVL(SUM(B.CO_AMT),0)                                                                                        AS CO_AMT" ).append("\n"); 
		query.append("    ,NVL(SUM(B.HJS_SLS_AMT),0)                                                                                   AS HJS_SLS_AMT" ).append("\n"); 
		query.append("    ,NVL(SUM(B.N1ST_ASGN_AMT),0)                                                                                 AS N1ST_ASGN_AMT" ).append("\n"); 
		query.append("    ,0                                                                                                           AS N2ST_ASGN_AMT" ).append("\n"); 
		query.append("    ,NVL(SUM(B.IPT_ASGN_AMT),0)                                                                                  AS IPT_ASGN_AMT" ).append("\n"); 
		query.append("    ,NVL(SUM(B.HJS_SLS_AMT),0) + NVL(SUM(B.N1ST_ASGN_AMT),0) + NVL(SUM(B.IPT_ASGN_AMT),0)                        AS HJS_SALES_FINAL" ).append("\n"); 
		query.append("    ,NVL(SUM(B.CO_AMT),0) + NVL(SUM(B.HJS_SLS_AMT),0) + NVL(SUM(B.N1ST_ASGN_AMT),0) + NVL(SUM(B.IPT_ASGN_AMT),0) AS TOTAL_NETWORK_COST  " ).append("\n"); 
		query.append(" #elseif (${f_op_view} == 'OP4')" ).append("\n"); 
		query.append("	 ,NVL(SUM(B.N4TH_CO_AMT),0) 																				 AS CO_AMT " ).append("\n"); 
		query.append("	 ,NVL(SUM(B.N4TH_HJS_SLS_AMT),0) 																			 AS HJS_SLS_AMT " ).append("\n"); 
		query.append("	 ,NVL(SUM(B.N4TH_ASGN_AMT),0) 																				 AS N1ST_ASGN_AMT " ).append("\n"); 
		query.append("	 ,0 																										 AS N2ST_ASGN_AMT " ).append("\n"); 
		query.append("	 ,NVL(SUM(B.IPT_ASGN_AMT),0) 																				 AS IPT_ASGN_AMT " ).append("\n"); 
		query.append("	 ,NVL(SUM(B.N4TH_HJS_SLS_AMT),0) + NVL(SUM(B.N4TH_ASGN_AMT),0) + NVL(SUM(B.IPT_ASGN_AMT),0) 				 AS HJS_SALES_FINAL " ).append("\n"); 
		query.append("	 ,NVL(SUM(B.N4TH_CO_AMT),0) + NVL(SUM(B.N4TH_HJS_SLS_AMT),0) + NVL(SUM(B.N4TH_ASGN_AMT),0) + NVL(SUM(B.IPT_ASGN_AMT),0) AS TOTAL_NETWORK_COST " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" #elseif (${f_op_view} == 'OP5')" ).append("\n"); 
		query.append(" 	,NVL(SUM(B.CO_AMT),0) 																				 AS CO_AMT " ).append("\n"); 
		query.append("	,NVL(SUM(B.HJS_SLS_AMT),0) 																			 AS HJS_SLS_AMT " ).append("\n"); 
		query.append("	,NVL(SUM(B.N5TH_ASGN_AMT),0) 																				 AS N1ST_ASGN_AMT " ).append("\n"); 
		query.append("	,0 																										 AS N2ST_ASGN_AMT " ).append("\n"); 
		query.append("	,NVL(SUM(B.IPT_ASGN_AMT),0) 																				 AS IPT_ASGN_AMT " ).append("\n"); 
		query.append("	,NVL(SUM(B.HJS_SLS_AMT),0) + NVL(SUM(B.N5TH_ASGN_AMT),0) + NVL(SUM(B.IPT_ASGN_AMT),0) 				 AS HJS_SALES_FINAL " ).append("\n"); 
		query.append("	,NVL(SUM(B.CO_AMT),0) + NVL(SUM(B.HJS_SLS_AMT),0) + NVL(SUM(B.N5TH_ASGN_AMT),0) + NVL(SUM(B.IPT_ASGN_AMT),0) AS TOTAL_NETWORK_COST " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" #elseif (${f_op_view} == 'OP6')" ).append("\n"); 
		query.append("	,NVL(SUM(B.N4TH_CO_AMT),0) 																				 AS CO_AMT " ).append("\n"); 
		query.append("	,NVL(SUM(B.N4TH_HJS_SLS_AMT),0) 																			 AS HJS_SLS_AMT " ).append("\n"); 
		query.append("	,NVL(SUM(B.N6TH_ASGN_AMT),0) 																				 AS N1ST_ASGN_AMT " ).append("\n"); 
		query.append("	,0 																										 AS N2ST_ASGN_AMT " ).append("\n"); 
		query.append("	,NVL(SUM(B.IPT_ASGN_AMT),0) 																				 AS IPT_ASGN_AMT " ).append("\n"); 
		query.append("	,NVL(SUM(B.N4TH_HJS_SLS_AMT),0) + NVL(SUM(B.N6TH_ASGN_AMT),0) + NVL(SUM(B.IPT_ASGN_AMT),0) 				 AS HJS_SALES_FINAL " ).append("\n"); 
		query.append("	,NVL(SUM(B.N4TH_CO_AMT),0) + NVL(SUM(B.N4TH_HJS_SLS_AMT),0) + NVL(SUM(B.N6TH_ASGN_AMT),0) + NVL(SUM(B.IPT_ASGN_AMT),0) AS TOTAL_NETWORK_COST " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("FROM COA_MON_VVD A" ).append("\n"); 
		query.append("       ,COA_VVD_HIR B" ).append("\n"); 
		query.append("		,(SELECT TRD_CD, RLANE_CD, IOC_CD, DIR_CD, HUL_BND_CD FROM COA_LANE_RGST) D" ).append("\n"); 
		query.append("  WHERE A.TRD_CD     = B.TRD_CD" ).append("\n"); 
		query.append("    AND A.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("    AND A.IOC_CD     = B.IOC_CD" ).append("\n"); 
		query.append("    AND A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("    AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND A.DIR_CD     = B.DIR_CD" ).append("\n"); 
		query.append("	AND A.TRD_CD          = D.TRD_CD" ).append("\n"); 
		query.append("    AND A.RLANE_CD        = D.RLANE_CD" ).append("\n"); 
		query.append("    AND A.IOC_CD          = D.IOC_CD" ).append("\n"); 
		query.append("    AND A.DIR_CD          = D.DIR_CD   " ).append("\n"); 
		query.append("    AND B.STND_COST_CD NOT IN('43102011','54600000') " ).append("\n"); 
		query.append("    AND NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${trd_cd} != '')" ).append("\n"); 
		query.append("       AND A.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("       AND A.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${ioc_cd} != '')" ).append("\n"); 
		query.append("       AND A.IOC_CD = @[ioc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("       AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${dir_cd} != '')" ).append("\n"); 
		query.append("       AND A.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${stnd_cost_cd} != '')" ).append("\n"); 
		query.append("       AND B.STND_COST_CD = @[stnd_cost_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${priod} == 'M')" ).append("\n"); 
		query.append("        #if (${fmMonth} != '')" ).append("\n"); 
		query.append("            AND A.COST_YRMON BETWEEN @[cost_yrmon_s] AND @[cost_yrmon_e]" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            AND A.COST_YRMON like @[cost_yrmon] || '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #elseif (${priod} == 'W')" ).append("\n"); 
		query.append("        AND A.SLS_YRMON LIKE @[sls_yrmon]" ).append("\n"); 
		query.append("        #if (${fmWeek} != '')" ).append("\n"); 
		query.append("            AND A.COST_WK BETWEEN @[cost_wk_s] AND @[cost_wk_e]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(" GROUP BY" ).append("\n"); 
		query.append("        A.COST_YRMON" ).append("\n"); 
		query.append("       ,A.COST_WK" ).append("\n"); 
		query.append("       ,B.TRD_CD" ).append("\n"); 
		query.append("       ,B.RLANE_CD" ).append("\n"); 
		query.append("       ,B.IOC_CD" ).append("\n"); 
		query.append("       ,B.VSL_CD||B.SKD_VOY_NO||B.DIR_CD" ).append("\n"); 
		query.append("	   ,D.HUL_BND_CD" ).append("\n"); 

	}
}