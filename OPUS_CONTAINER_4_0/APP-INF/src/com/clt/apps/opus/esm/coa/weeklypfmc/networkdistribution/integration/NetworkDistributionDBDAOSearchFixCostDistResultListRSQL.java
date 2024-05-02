/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkDistributionDBDAOSearchFixCostDistResultListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
	  * 
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
		params.put("cost_wk_e",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.integration").append("\n"); 
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
		query.append("     A.COST_YRMON                                                                                   AS COST_YRMON" ).append("\n"); 
		query.append("    ,A.COST_WK                                                                                      AS COST_WK" ).append("\n"); 
		query.append("    ,B.TRD_CD                                                                                       AS TRD_CD" ).append("\n"); 
		query.append("    ,B.RLANE_CD                                                                                     AS RLANE_CD" ).append("\n"); 
		query.append("    ,B.IOC_CD                                                                                       AS IOC_CD" ).append("\n"); 
		query.append("    ,B.VSL_CD||B.SKD_VOY_NO||B.DIR_CD                                                               AS VVD_CD" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("	,NVL(SUM(B.CO_AMT),0)                                                                           AS CO_AMT" ).append("\n"); 
		query.append("    ,NVL(SUM(DECODE(B.STND_COST_CD, '54600002',0, B.CO_SLS_AMT)),0)                                 AS CO_SLS_AMT			--SJH.20141124.MOD" ).append("\n"); 
		query.append("    ,0                                                                                 				AS N1ST_ASGN_AMT		--SJH.20141124.MOD" ).append("\n"); 
		query.append("    ,0                                                                                              AS N2ST_ASGN_AMT" ).append("\n"); 
		query.append("    -- SJH.20141031.ADD, SJH.20141104.MOD : 54600001->54600002, SJH.20141117.MOD : NVL" ).append("\n"); 
		query.append("    ,NVL(SUM(DECODE(B.STND_COST_CD,'54600002', ( NVL(B.CO_SLS_AMT,0) ),0)),0)                       AS SLT_INTER_AMT		--SJH.20141124.MOD" ).append("\n"); 
		query.append("    --,NVL(SUM(B.IPT_ASGN_AMT),0)                                                                   AS IPT_ASGN_AMT" ).append("\n"); 
		query.append("    ,NVL(SUM(B.CO_SLS_AMT),0) + NVL(SUM(B.N1ST_ASGN_AMT),0)                          				AS CO_SALES_FINAL		--SJH.20141124.MOD" ).append("\n"); 
		query.append("    ,NVL(SUM(B.CO_AMT),0) + NVL(SUM(B.CO_SLS_AMT),0) + NVL(SUM(B.N1ST_ASGN_AMT),0) 					AS TOTAL_NETWORK_COST	--SJH.20141124.MOD" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("FROM COA_MON_VVD A" ).append("\n"); 
		query.append("       ,COA_VVD_HIR B" ).append("\n"); 
		query.append("  WHERE A.TRD_CD     = B.TRD_CD" ).append("\n"); 
		query.append("    AND A.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("    AND A.IOC_CD     = B.IOC_CD" ).append("\n"); 
		query.append("    AND A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("    AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND A.DIR_CD     = B.DIR_CD" ).append("\n"); 
		query.append("    AND B.STND_COST_CD NOT IN('43102011','54600000','43102021') " ).append("\n"); 
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

	}
}