/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NetworkCostDBDAOSearchFixCostByVVDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchFixCostByVVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFixCostByVVDList SELECT
	  * </pre>
	  */
	public NetworkCostDBDAOSearchFixCostByVVDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchFixCostByVVDListRSQL").append("\n"); 
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
		query.append("    A1.TRD_CD || A1.RLANE_CD || A1.IOC_CD || A1.VSL_CD || A1.SKD_VOY_NO || A1.DIR_CD           AS SUBSUM_CODE" ).append("\n"); 
		query.append("   ,A1.TRD_CD                                                                                  AS TRD_CD" ).append("\n"); 
		query.append("   ,A1.RLANE_CD                                                                                AS RLANE_CD" ).append("\n"); 
		query.append("   ,A1.IOC_CD                                                                                  AS IOC_CD" ).append("\n"); 
		query.append("   ,A1.VSL_CD                                                                                  AS VSL_CD" ).append("\n"); 
		query.append("   ,A1.SKD_VOY_NO                                                                              AS SKD_VOY_NO" ).append("\n"); 
		query.append("   ,A1.DIR_CD                                                                                  AS DIR_CD" ).append("\n"); 
		query.append("   ,NVL ((SELECT Y.CONTI_NM" ).append("\n"); 
		query.append("            FROM MDM_LOCATION X" ).append("\n"); 
		query.append("               , MDM_CONTINENT Y" ).append("\n"); 
		query.append("           WHERE X.CONTI_CD = Y.CONTI_CD" ).append("\n"); 
		query.append("             AND X.LOC_CD   = A2.LOC_CD), '')                                                  AS CONTI_NM" ).append("\n"); 
		query.append("   ,A2.LOC_CD                                                                                  AS LOC_CD              /* Port */" ).append("\n"); 
		query.append("   ,A2.VSL_DBL_CALL_SEQ                                                                        AS VSL_DBL_CALL_SEQ    /* Call IND */" ).append("\n"); 
		query.append("   ,A2.CLPT_SEQ                                                                                AS CLPT_SEQ            /* Call SEQ */" ).append("\n"); 
		query.append("   ,A2.APLY_VOY_RTO                                                                            AS APLY_VOY_RTO        /* Apply(%) */" ).append("\n"); 
		query.append("   ,A3.PNDLM_RTO                                                                               AS PNDLM_RTO           /* Pendulum(%) : 20160129.ADD */" ).append("\n"); 
		query.append("   ,SUM (CASE WHEN (A2.STND_COST_CD = '53101000') THEN A2.VSL_COST_AMT ELSE 0 END)             AS AMT_01              /* Port Expense */" ).append("\n"); 
		query.append("   ,SUM (CASE WHEN (A2.STND_COST_CD = '53102000') THEN A2.VSL_COST_AMT ELSE 0 END)             AS AMT_02              /* Canal Transit Fee */" ).append("\n"); 
		query.append("   ,A2.PORT_DYS                                                                                AS PORT_DYS            /* Port Days */" ).append("\n"); 
		query.append("   ,A2.SEA_DYS                                                                                 AS SEA_DYS             /* Sea Days */" ).append("\n"); 
		query.append("   ,A2.TTL_TZ_DYS                                                                              AS TTL_TZ_DYS          /* Total Days */" ).append("\n"); 
		query.append("   ,SUM (CASE WHEN (A2.STND_COST_CD = '53200000') THEN A2.FOIL_CSM * A2.TTL_TZ_DYS ELSE 0 END) AS AMT_13              /* FO Cons. */" ).append("\n"); 
		query.append("   ,SUM (CASE WHEN (A2.STND_COST_CD = '53200000') THEN A2.VSL_COST_AMT ELSE 0 END)             AS AMT_03              /* Bunker */" ).append("\n"); 
		query.append("   ,SUM (CASE WHEN (A2.STND_COST_CD = '54100000') THEN A2.VSL_COST_AMT ELSE 0 END)             AS AMT_04              /* Crew Expense */" ).append("\n"); 
		query.append("   ,SUM (CASE WHEN (A2.STND_COST_CD = '54250000') THEN A2.VSL_COST_AMT ELSE 0 END)             AS AMT_05              /* Insurance */" ).append("\n"); 
		query.append("   ,SUM (CASE WHEN (A2.STND_COST_CD = '54300000') THEN A2.VSL_COST_AMT ELSE 0 END)             AS AMT_06              /* Lubricant Expense */" ).append("\n"); 
		query.append("   ,SUM (CASE WHEN (A2.STND_COST_CD = '54200000') THEN A2.VSL_COST_AMT ELSE 0 END)             AS AMT_07              /* Store Supply Expense */" ).append("\n"); 
		query.append("   ,SUM (CASE WHEN (A2.STND_COST_CD = '54150000') THEN A2.VSL_COST_AMT ELSE 0 END)             AS AMT_08              /* Vessel M&R */" ).append("\n"); 
		query.append("   ,SUM (CASE WHEN (A2.STND_COST_CD = '54450000') THEN A2.VSL_COST_AMT ELSE 0 END)             AS AMT_09              /* Deprecations */" ).append("\n"); 
		query.append("   ,SUM (CASE WHEN (A2.STND_COST_CD = '54180000') THEN A2.VSL_COST_AMT ELSE 0 END)             AS AMT_10              /* Telecom Expense */" ).append("\n"); 
		query.append("   ,SUM (CASE WHEN (A2.STND_COST_CD = '54550000') THEN A2.VSL_COST_AMT ELSE 0 END)             AS AMT_11              /* Other Operation Fixed Exp */" ).append("\n"); 
		query.append("   ,SUM (CASE WHEN (A2.STND_COST_CD = '54350000') THEN A2.VSL_COST_AMT ELSE 0 END)             AS AMT_12              /* Time Charterage */" ).append("\n"); 
		query.append("   ,SUM (CASE WHEN (A2.STND_COST_CD = '75000000') THEN A2.VSL_COST_AMT ELSE 0 END)             AS AMT_14              /* General Expense */" ).append("\n"); 
		query.append("  FROM COA_MON_VVD A1 " ).append("\n"); 
		query.append("     , COA_MON_VVD_PORT_COST A2" ).append("\n"); 
		query.append("     , COA_MON_VVD_PORT_OP_DYS A3					--20160129.ADD" ).append("\n"); 
		query.append(" WHERE A1.TRD_CD      = A2.TRD_CD   /* A2 */" ).append("\n"); 
		query.append("   AND A1.RLANE_CD    = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.IOC_CD      = A2.IOC_CD" ).append("\n"); 
		query.append("   AND A1.VSL_CD      = A2.VSL_CD" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO  = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A1.DIR_CD      = A2.DIR_CD" ).append("\n"); 
		query.append("   --20160129.ADD" ).append("\n"); 
		query.append("   AND A2.TRD_CD      = A3.TRD_CD" ).append("\n"); 
		query.append("   AND A2.RLANE_CD    = A3.RLANE_CD" ).append("\n"); 
		query.append("   AND A2.IOC_CD      = A3.IOC_CD" ).append("\n"); 
		query.append("   AND A2.VSL_CD      = A3.VSL_CD" ).append("\n"); 
		query.append("   AND A2.SKD_VOY_NO  = A3.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A2.DIR_CD      = A3.DIR_CD" ).append("\n"); 
		query.append("   AND A2.LOC_CD      = A3.LOC_CD " ).append("\n"); 
		query.append("   AND A2.VSL_DBL_CALL_SEQ = A3.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND NVL (A1.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${trd_cd} != '')" ).append("\n"); 
		query.append("      AND A1.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("      AND A1.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${ioc_cd} != '')" ).append("\n"); 
		query.append("      AND A1.IOC_CD = @[ioc_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("      AND A1.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("      AND A1.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${dir_cd} != '')" ).append("\n"); 
		query.append("      AND A1.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${priod} == 'M')" ).append("\n"); 
		query.append("      #if (${cost_yrmon} != '')" ).append("\n"); 
		query.append("          AND A1.COST_YRMON BETWEEN @[cost_yrmon_s] AND @[cost_yrmon_e]" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("          AND A1.COST_YRMON like @[cost_yrmon] || '%'" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("   #elseif (${priod} == 'W')" ).append("\n"); 
		query.append("      AND A1.SLS_YRMON LIKE @[sls_yrmon]" ).append("\n"); 
		query.append("      #if (${cost_wk} != '')" ).append("\n"); 
		query.append("          AND A1.COST_WK BETWEEN @[cost_wk_s] AND @[cost_wk_e]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("GROUP BY A1.TRD_CD" ).append("\n"); 
		query.append("        ,A1.RLANE_CD" ).append("\n"); 
		query.append("        ,A1.IOC_CD" ).append("\n"); 
		query.append("        ,A1.VSL_CD" ).append("\n"); 
		query.append("        ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,A1.DIR_CD" ).append("\n"); 
		query.append("        ,A2.LOC_CD" ).append("\n"); 
		query.append("        ,A2.VSL_DBL_CALL_SEQ" ).append("\n"); 
		query.append("        ,A2.CLPT_SEQ" ).append("\n"); 
		query.append("        ,A2.APLY_VOY_RTO" ).append("\n"); 
		query.append("        ,A3.PNDLM_RTO					--20160129.ADD" ).append("\n"); 
		query.append("        ,A2.SEA_DYS" ).append("\n"); 
		query.append("        ,A2.PORT_DYS" ).append("\n"); 
		query.append("        ,A2.TTL_TZ_DYS" ).append("\n"); 
		query.append("ORDER BY A1.TRD_CD" ).append("\n"); 
		query.append("       , A1.RLANE_CD" ).append("\n"); 
		query.append("       , A1.IOC_CD" ).append("\n"); 
		query.append("       , A1.VSL_CD" ).append("\n"); 
		query.append("       , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("       , A1.DIR_CD" ).append("\n"); 
		query.append("       , A2.CLPT_SEQ" ).append("\n"); 

	}
}