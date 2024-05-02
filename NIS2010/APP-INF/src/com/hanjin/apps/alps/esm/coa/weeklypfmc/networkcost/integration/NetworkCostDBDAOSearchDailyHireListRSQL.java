/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkCostDBDAOSearchDailyHireListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.16
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.07.16 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchDailyHireListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDailyHireList SELECT
	  * </pre>
	  */
	public NetworkCostDBDAOSearchDailyHireListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchDailyHireListRSQL").append("\n"); 
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
		query.append("    FLAG                FLAG" ).append("\n"); 
		query.append("   ,COST_YRMON          COST_YRMON" ).append("\n"); 
		query.append("   ,COST_WK             COST_WK" ).append("\n"); 
		query.append("   ,VSL_CD              VSL_CD" ).append("\n"); 
		query.append("   ,CHRG_CTRT_NO        CHRG_CTRT_NO" ).append("\n"); 
		query.append("   ,CHRG_CTRT_SEQ       CHRG_CTRT_SEQ" ).append("\n"); 
		query.append("   ,NUM                 NUM" ).append("\n"); 
		query.append("   ,CTRT_EFF_FM_DT      CTRT_EFF_FM_DT" ).append("\n"); 
		query.append("   ,CTRT_EFF_TO_DT      CTRT_EFF_TO_DT" ).append("\n"); 
		query.append("   ,N1ST_HIR_RT         N1ST_HIR_RT" ).append("\n"); 
		query.append("   ,N1ST_CURR_CD        N1ST_CURR_CD" ).append("\n"); 
		query.append("   ,N2ND_HIR_RT         N2ND_HIR_RT" ).append("\n"); 
		query.append("   ,N2ND_CURR_CD        N2ND_CURR_CD" ).append("\n"); 
		query.append("   ,CHRG_DHIR_AMT       CHRG_DHIR_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("             DECODE(NVL(C1.VSL_CD,''),'','I', 'R' )                                                                     FLAG" ).append("\n"); 
		query.append("           , C3.COST_YRMON                                                                                              COST_YRMON" ).append("\n"); 
		query.append("           , C3.COST_WK                                                                                                 COST_WK" ).append("\n"); 
		query.append("           , C3.VSL_CD                                                                                                  VSL_CD" ).append("\n"); 
		query.append("           , C2.CHRG_CTRT_NO                                                                                            CHRG_CTRT_NO" ).append("\n"); 
		query.append("           , C2.CHRG_CTRT_SEQ                                                                                           CHRG_CTRT_SEQ" ).append("\n"); 
		query.append("           , ROW_NUMBER() OVER (PARTITION BY C3.COST_YRMON, C3.VSL_CD, C2.CHRG_CTRT_NO ORDER BY C2.CHRG_CTRT_SEQ DESC)  NUM" ).append("\n"); 
		query.append("           , C2.CTRT_EFF_FM_DT                                                                                          CTRT_EFF_FM_DT" ).append("\n"); 
		query.append("           , C2.CTRT_EFF_TO_DT                                                                                          CTRT_EFF_TO_DT" ).append("\n"); 
		query.append("           , C2.N1ST_HIR_RT                                                                                             N1ST_HIR_RT" ).append("\n"); 
		query.append("           , C2.N1ST_CURR_CD                                                                                            N1ST_CURR_CD" ).append("\n"); 
		query.append("           , C2.N2ND_HIR_RT                                                                                             N2ND_HIR_RT" ).append("\n"); 
		query.append("           , C2.N2ND_CURR_CD                                                                                            N2ND_CURR_CD" ).append("\n"); 
		query.append("           , NVL (C1.CHRG_DHIR_AMT, 0)                                                                                  CHRG_DHIR_AMT" ).append("\n"); 
		query.append("          FROM COA_CHRG_VSL_DLY_HIR C1" ).append("\n"); 
		query.append("             , COA_VSL_CHRG_IF C2" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                #if (${yrType} == 'yrwk')" ).append("\n"); 
		query.append("                     DISTINCT MIN(B1.SLS_YRMON) OVER() MIN_YRMON" ).append("\n"); 
		query.append("                   , B1.SLS_YRMON COST_YRMON" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                     DISTINCT MIN(B1.COST_YRMON) OVER() MIN_YRMON" ).append("\n"); 
		query.append("                   , B1.COST_YRMON COST_YRMON" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                   , B1.COST_WK" ).append("\n"); 
		query.append("                   , B1.VSL_CD" ).append("\n"); 
		query.append("                  FROM COA_MON_VVD B1" ).append("\n"); 
		query.append("                     ,(" ).append("\n"); 
		query.append("                       SELECT" ).append("\n"); 
		query.append("                           A1.VSL_SEQ        VSL_SEQ" ).append("\n"); 
		query.append("                          ,A1.VSL_CD         VSL_CD" ).append("\n"); 
		query.append("                          ,A1.VSL_TP_CD      VSL_TP_CD" ).append("\n"); 
		query.append("                          ,A1.VSL_OSHP_CD    VSL_OSHP_CD" ).append("\n"); 
		query.append("                          ,A1.VOP_CD         VOP_CD" ).append("\n"); 
		query.append("                          ,A1.PORT_CLSS_CAPA PORT_CLSS_CAPA" ).append("\n"); 
		query.append("                          ,A1.VSL_CLSS_CAPA  VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                          ,A1.VSL_APLY_FM_DT FM_DT" ).append("\n"); 
		query.append("                          ,A1.VSL_APLY_TO_DT TO_DT" ).append("\n"); 
		query.append("                         FROM COA_VSL_RGST A1" ).append("\n"); 
		query.append("                        WHERE 1 = 1" ).append("\n"); 
		query.append("                          AND NVL(A1.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                      ) B2" ).append("\n"); 
		query.append("                 #if (${yrType} == 'yrwk')" ).append("\n"); 
		query.append("                    WHERE B1.SLS_YRMON  LIKE @[sls_yrmon]||'%'" ).append("\n"); 
		query.append("                      AND B1.COST_WK = @[cost_wk]" ).append("\n"); 
		query.append("                 #else" ).append("\n"); 
		query.append("                    WHERE B1.COST_YRMON  LIKE @[sls_yrmon]||@[cost_wk]" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 AND B1.VSL_CD      = B2.VSL_CD" ).append("\n"); 
		query.append("                 AND B1.VSL_CD      LIKE @[vsl_cd] || '%'" ).append("\n"); 
		query.append("                 AND B1.DELT_FLG   <> 'Y'" ).append("\n"); 
		query.append("                 AND B2.VSL_TP_CD   = 'C'" ).append("\n"); 
		query.append("                 AND B2.VSL_OSHP_CD = 'CHT'" ).append("\n"); 
		query.append("                 AND TO_CHAR(B1.N1ST_LODG_PORT_ETD_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                     BETWEEN NVL(TO_CHAR(B2.FM_DT, 'YYYYMMDD'), '19000101')" ).append("\n"); 
		query.append("                     AND     NVL(TO_CHAR(B2.TO_DT, 'YYYYMMDD'), '99991231')" ).append("\n"); 
		query.append("				AND B1.SUB_TRD_CD <> 'IP'" ).append("\n"); 
		query.append("               ) C3" ).append("\n"); 
		query.append("         #if (${rtnRow} >= 2)" ).append("\n"); 
		query.append("       WHERE C3.COST_YRMON = C2.COST_YRMON(+)" ).append("\n"); 
		query.append("         #else" ).append("\n"); 
		query.append("       WHERE C3.MIN_YRMON = C2.COST_YRMON(+)" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         AND C3.VSL_CD     = C2.VSL_CD(+)" ).append("\n"); 
		query.append("         AND C3.COST_YRMON = C1.COST_YRMON(+)" ).append("\n"); 
		query.append("         AND C3.VSL_CD     = C1.VSL_CD(+)" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("  WHERE NUM = 1" ).append("\n"); 
		query.append("  ORDER BY COST_YRMON" ).append("\n"); 
		query.append("          ,COST_WK" ).append("\n"); 
		query.append("          ,VSL_CD" ).append("\n"); 
		query.append("          ,CHRG_CTRT_NO" ).append("\n"); 

	}
}