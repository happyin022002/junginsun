/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : NetworkDistributionDBDAOSearchSpcChtrRevMssListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.02.22 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHOISUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOSearchSpcChtrRevMssListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSpcChtrRevMssList SELECT
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchSpcChtrRevMssListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cost_yrmon_e",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sls_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOSearchSpcChtrRevMssListRSQL").append("\n"); 
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
		query.append("    SUBSTR(A1.SLS_YRMON,1,4)                                                                    AS SLS_YRMON" ).append("\n"); 
		query.append("   ,A1.COST_WK                                                                                  AS COST_WK" ).append("\n"); 
		query.append("   ,A1.TRD_CD                                                                                   AS TRD_CD" ).append("\n"); 
		query.append("   ,A1.RLANE_CD                                                                                 AS RLANE_CD" ).append("\n"); 
		query.append("   ,A1.VSL_CD                                                                                   AS VSL_CD" ).append("\n"); 
		query.append("   ,A1.SKD_VOY_NO                                                                               AS SKD_VOY_NO" ).append("\n"); 
		query.append("   ,A1.DIR_CD                                                                                   AS DIR_CD" ).append("\n"); 
		query.append("   ,A2.N2ND_FNL_CO_BSA_CAPA                                                                     AS N2ND_FNL_CO_BSA_CAPA" ).append("\n"); 
		query.append("   ,A2.CO_BSA_CAPA                                                                              AS CO_BSA_CAPA" ).append("\n"); 
		query.append("   ,ROUND(A2.CO_BSA_RTO*100)                                                                    AS CO_BSA_RTO" ).append("\n"); 
		query.append("   ,ROUND(A2.CHTR_BSA_RTO*100)                                                                  AS CHTR_BSA_RTO" ).append("\n"); 
		query.append("   ,NVL(A2.EXPN_BZC_CHTR_AMT, 0) + NVL(A2.EXPN_SUB_CHTR_AMT, 0) + NVL(A2.EXPN_CRS_CHTR_AMT, 0)  AS EXPN" ).append("\n"); 
		query.append("   ,NVL(A2.INCM_BZC_CHTR_AMT, 0) + NVL(A2.INCM_SUB_CHTR_AMT, 0) + NVL(A2.INCM_CRS_CHTR_AMT, 0)  AS INCM" ).append("\n"); 
		query.append("  FROM COA_MON_VVD A1" ).append("\n"); 
		query.append("     , BSA_VVD_MST A2" ).append("\n"); 
		query.append(" WHERE A1.TRD_CD     = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.IOC_CD     = A2.IOC_CD" ).append("\n"); 
		query.append("   AND A1.VSL_CD     = A2.VSL_CD" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A1.DIR_CD     = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND NVL(A1.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("   AND NVL(A2.INCM_BZC_CHTR_AMT, 0) + NVL(A2.INCM_SUB_CHTR_AMT, 0) + NVL(A2.INCM_CRS_CHTR_AMT, 0) = 0" ).append("\n"); 
		query.append("   AND A2.CO_BSA_CAPA > 0 -- lease BSA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${priod} == 'M')" ).append("\n"); 
		query.append("       #if (${fmMonth} != '')" ).append("\n"); 
		query.append("           AND A1.COST_YRMON BETWEEN @[cost_yrmon_s] AND @[cost_yrmon_e]" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("           AND A1.COST_YRMON LIKE @[cost_yrmon] || '%'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("   #elseif (${priod} == 'W')" ).append("\n"); 
		query.append("       AND A1.SLS_YRMON LIKE @[sls_yrmon]" ).append("\n"); 
		query.append("       #if (${fmWeek} != '')" ).append("\n"); 
		query.append("           AND A1.COST_WK BETWEEN @[cost_wk_s] AND @[cost_wk_e]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("   #end" ).append("\n"); 

	}
}