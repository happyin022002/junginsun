/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOSearchOwnDailyHireListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.12 
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

public class NetworkCostDBDAOSearchOwnDailyHireListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOwnDailyHireList SELECT
	  * 
	  * - 20150312.MOD : GROUP BY 절에서 , OWN_VSL_RMK 빼기..
	  * </pre>
	  */
	public NetworkCostDBDAOSearchOwnDailyHireListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchOwnDailyHireListRSQL").append("\n"); 
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
		query.append("    COST_YRMON                      COST_YRMON " ).append("\n"); 
		query.append("#if (${yrType} == 'yrwk')" ).append("\n"); 
		query.append("   ,COST_WK                         COST_WK     " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   ,''                          COST_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   ,VSL_CD                          VSL_CD       " ).append("\n"); 
		query.append("   ,VSL_CLSS_CAPA                   VSL_CLSS_CAPA" ).append("\n"); 
		query.append("   #foreach(${keys} IN ${keyList})" ).append("\n"); 
		query.append("      ,SUM(t$keys) t$keys" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   ,''" ).append("\n"); 
		query.append("   ,MAX(OWN_VSL_RMK)                OWN_VSL_RMK					--20150312.MOD (MAX)" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            DISTINCT D2.COST_YRMON                              COST_YRMON" ).append("\n"); 
		query.append("		#if (${yrType} == 'yrwk')" ).append("\n"); 
		query.append("           ,D2.COST_WK                                          COST_WK" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("           ,D2.VSL_CD                                           VSL_CD" ).append("\n"); 
		query.append("           ,D2.VSL_CLSS_CAPA                                    VSL_CLSS_CAPA" ).append("\n"); 
		query.append("           #foreach(${keys} IN ${keyList2})" ).append("\n"); 
		query.append("              ,DECODE(NVL(D1.VSL_CLSS_CAPA,''), '', D3.avg$keys, NVL(DECODE(D1.STND_COST_CD,'$keys',D1.DHIR_AMT),0)) t$keys" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           ,''" ).append("\n"); 
		query.append("           --,DECODE(D1.VSL_CLSS_CAPA, '', 'AVG', D1.OWN_VSL_RMK) OWN_VSL_RMK" ).append("\n"); 
		query.append("		   --SJH.20141226.MOD" ).append("\n"); 
		query.append("           ,DECODE(D1.VSL_CLSS_CAPA, '', 'AVG', DECODE(D1.OWN_VSL_RMK,'VSL AVG General Expense','',D1.OWN_VSL_RMK)) OWN_VSL_RMK" ).append("\n"); 
		query.append("          FROM COA_OWN_VSL_DLY_HIR D1" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                #if (${yrType} == 'yrwk')" ).append("\n"); 
		query.append("                    DISTINCT B1.SLS_YRMON   COST_YRMON" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("                    DISTINCT B1.COST_YRMON   COST_YRMON" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                   ,B1.COST_WK              COST_WK      " ).append("\n"); 
		query.append("                   ,B1.VSL_CD               VSL_CD       " ).append("\n"); 
		query.append("                   ,B2.VSL_CLSS_CAPA        VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                  FROM COA_MON_VVD B1" ).append("\n"); 
		query.append("                      ,(SELECT" ).append("\n"); 
		query.append("                            A1.VSL_SEQ        VSL_SEQ" ).append("\n"); 
		query.append("                           ,A1.VSL_CD         VSL_CD" ).append("\n"); 
		query.append("                           ,A1.VSL_TP_CD      VSL_TP_CD" ).append("\n"); 
		query.append("                           ,A1.VSL_OSHP_CD    VSL_OSHP_CD" ).append("\n"); 
		query.append("                           ,A1.VOP_CD         VOP_CD                           " ).append("\n"); 
		query.append("                           ,A1.VSL_CLSS_CAPA  VSL_CLSS_CAPA" ).append("\n"); 
		query.append("						   ,NVL(A1.VSL_APLY_FM_DT, A1.VSL_RETN_FM_DT)     FM_DT 				" ).append("\n"); 
		query.append("                  		   ,NVL(A1.VSL_APLY_TO_DT , A1.VSL_RETN_TO_DT)     TO_DT " ).append("\n"); 
		query.append("                          FROM COA_VSL_RGST A1" ).append("\n"); 
		query.append("                         WHERE 1 = 1" ).append("\n"); 
		query.append("                           AND NVL(A1.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                       ) B2" ).append("\n"); 
		query.append("                 WHERE B1.VSL_CD = B2.VSL_CD" ).append("\n"); 
		query.append("                   #if (${yrType} == 'yrwk')" ).append("\n"); 
		query.append("                      AND B1.SLS_YRMON LIKE @[sls_yrmon]||'%'" ).append("\n"); 
		query.append("                      AND B1.COST_WK = @[cost_wk]" ).append("\n"); 
		query.append("                   #else" ).append("\n"); 
		query.append("                      AND B1.COST_YRMON LIKE @[sls_yrmon]||@[cost_wk]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   AND B1.DELT_FLG            <> 'Y'" ).append("\n"); 
		query.append("                   AND B2.VSL_TP_CD           = 'C'" ).append("\n"); 
		query.append("                   AND B2.VSL_OSHP_CD         = 'OWN'" ).append("\n"); 
		query.append("                   AND TO_CHAR(B1.N1ST_LODG_PORT_ETD_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                               BETWEEN NVL(TO_CHAR(B2.FM_DT, 'YYYYMMDD'), '19000101')" ).append("\n"); 
		query.append("                               AND     NVL(TO_CHAR(B2.TO_DT, 'YYYYMMDD'), '99991231')" ).append("\n"); 
		query.append("                   AND B2.VSL_CD = NVL(@[vsl_cd], B2.VSL_CD)" ).append("\n"); 
		query.append("               ) D2" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                    C2.COST_YRMON" ).append("\n"); 
		query.append("                   ,C2.COST_WK" ).append("\n"); 
		query.append("                   ,C2.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                   #foreach(${keys} IN ${keyList3})" ).append("\n"); 
		query.append("                      ,NVL(SUM(DECODE(C1.STND_COST_CD,'$keys',C1.DHIR_AMT)),0) avg$keys" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   ,''" ).append("\n"); 
		query.append("                   , C1.OWN_VSL_RMK" ).append("\n"); 
		query.append("                  FROM COA_OWN_VSL_DLY_HIR C1" ).append("\n"); 
		query.append("                      ,(SELECT" ).append("\n"); 
		query.append("                        #if (${yrType} == 'yrwk')" ).append("\n"); 
		query.append("                            DISTINCT MIN(B1.SLS_YRMON) OVER()   MIN_YRMON" ).append("\n"); 
		query.append("                           ,B1.SLS_YRMON                        COST_YRMON" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                            DISTINCT MIN(B1.COST_YRMON) OVER()   MIN_YRMON" ).append("\n"); 
		query.append("                           ,B1.COST_YRMON                        COST_YRMON" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("                           ,B1.COST_WK                          COST_WK" ).append("\n"); 
		query.append("                           ,B2.VSL_CLSS_CAPA                    VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                          FROM COA_MON_VVD B1" ).append("\n"); 
		query.append("                              ,(SELECT" ).append("\n"); 
		query.append("                                    A1.VSL_SEQ        VSL_SEQ" ).append("\n"); 
		query.append("                                   ,A1.VSL_CD         VSL_CD" ).append("\n"); 
		query.append("                                   ,A1.VSL_TP_CD      VSL_TP_CD" ).append("\n"); 
		query.append("                                   ,A1.VSL_OSHP_CD    VSL_OSHP_CD" ).append("\n"); 
		query.append("                                   ,A1.VOP_CD         VOP_CD                                   " ).append("\n"); 
		query.append("                                   ,A1.VSL_CLSS_CAPA  VSL_CLSS_CAPA" ).append("\n"); 
		query.append("						   		   ,NVL(A1.VSL_APLY_FM_DT, A1.VSL_RETN_FM_DT)     FM_DT 				" ).append("\n"); 
		query.append("                  		           ,NVL(A1.VSL_APLY_TO_DT , A1.VSL_RETN_TO_DT)     TO_DT " ).append("\n"); 
		query.append("                                  FROM COA_VSL_RGST A1" ).append("\n"); 
		query.append("                                 WHERE 1 = 1" ).append("\n"); 
		query.append("                                   AND NVL(A1.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                               ) B2" ).append("\n"); 
		query.append("                         WHERE B1.VSL_CD = B2.VSL_CD" ).append("\n"); 
		query.append("                           #if (${yrType} == 'yrwk')" ).append("\n"); 
		query.append("                              AND B1.SLS_YRMON LIKE @[sls_yrmon]||'%'" ).append("\n"); 
		query.append("                              AND B1.COST_WK = @[cost_wk]" ).append("\n"); 
		query.append("                           #else" ).append("\n"); 
		query.append("                              AND B1.COST_YRMON LIKE @[sls_yrmon]||@[cost_wk]" ).append("\n"); 
		query.append("                           #end" ).append("\n"); 
		query.append("                           AND B1.DELT_FLG            <> 'Y'" ).append("\n"); 
		query.append("                           AND B2.VSL_TP_CD           = 'C'" ).append("\n"); 
		query.append("                           AND B2.VSL_OSHP_CD         = 'OWN'" ).append("\n"); 
		query.append("                           AND TO_CHAR(B1.N1ST_LODG_PORT_ETD_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                       BETWEEN NVL(TO_CHAR(B2.FM_DT, 'YYYYMMDD'), '19000101')" ).append("\n"); 
		query.append("                                       AND     NVL(TO_CHAR(B2.TO_DT, 'YYYYMMDD'), '99991231')" ).append("\n"); 
		query.append("                           AND B2.VSL_CD = NVL(@[vsl_cd], B2.vsl_cd)" ).append("\n"); 
		query.append("                      ) C2" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND C2.MIN_YRMON        = C1.COST_YRMON(+)" ).append("\n"); 
		query.append("                   AND C1.VSL_CD(+)        ='XXXX'" ).append("\n"); 
		query.append("                   AND C2.VSL_CLSS_CAPA    = C1.VSL_CLSS_CAPA(+)" ).append("\n"); 
		query.append("                GROUP BY C2.COST_YRMON" ).append("\n"); 
		query.append("                       , C2.COST_WK" ).append("\n"); 
		query.append("                       , C2.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                       , C1.OWN_VSL_RMK" ).append("\n"); 
		query.append("               ) D3" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND D2.COST_YRMON    = D1.COST_YRMON(+)" ).append("\n"); 
		query.append("           AND D2.VSL_CD        = D1.VSL_CD(+)" ).append("\n"); 
		query.append("           AND D2.VSL_CLSS_CAPA = D1.VSL_CLSS_CAPA(+)" ).append("\n"); 
		query.append("           AND D2.COST_YRMON    = D3.COST_YRMON(+)" ).append("\n"); 
		query.append("           AND D2.VSL_CLSS_CAPA = D3.VSL_CLSS_CAPA(+)" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" GROUP BY COST_YRMON" ).append("\n"); 
		query.append("#if (${yrType} == 'yrwk')" ).append("\n"); 
		query.append("        , COST_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , VSL_CD" ).append("\n"); 
		query.append("        , VSL_CLSS_CAPA" ).append("\n"); 
		query.append("        , VSL_CLSS_CAPA        " ).append("\n"); 
		query.append(" ORDER BY COST_YRMON" ).append("\n"); 
		query.append("#if (${yrType} == 'yrwk')" ).append("\n"); 
		query.append("        , COST_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , VSL_CD" ).append("\n"); 
		query.append("        , VSL_CLSS_CAPA" ).append("\n"); 

	}
}