/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtInterCreCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.26
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.26 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtInterCreCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtInterCreCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_cost_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtInterCreCSQL").append("\n"); 
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
		query.append("  INTO MAS_ALOC_INTER_TS_EXPN ( FM_TRD_CD, FM_RLANE_CD, FM_IOC_CD, FM_VSL_CD, FM_SKD_VOY_NO, FM_DIR_CD, FM_TS_UC_AMT, FM_SML_SLS_AMT" ).append("\n"); 
		query.append("                              , TO_TRD_CD, TO_RLANE_CD, TO_IOC_CD, TO_VSL_CD, TO_SKD_VOY_NO, TO_DIR_CD, LOCL_TS_STS_CD, TS_QTY" ).append("\n"); 
		query.append("                              , TS_QTY_RTO, TS_EXPN_AMT, CRE_DT, CRE_USR_ID, UPD_DT, UPD_USR_ID )" ).append("\n"); 
		query.append("SELECT A.FM_TRD_CD, A.FM_RLANE_CD, A.FM_IOC_CD, A.FM_VSL_CD, A.FM_SKD_VOY_NO, A.FM_DIR_CD" ).append("\n"); 
		query.append("     , A.FM_TS_UC_AMT, A.FM_SML_SLS_AMT" ).append("\n"); 
		query.append("     , A.TO_TRD_CD, A.TO_RLANE_CD, A.TO_IOC_CD, A.TO_VSL_CD, A.TO_SKD_VOY_NO, A.TO_DIR_CD" ).append("\n"); 
		query.append("     , A.LOCL_TS_STS_CD, A.TS_QTY, A.TS_QTY_RTO" ).append("\n"); 
		query.append("     , DECODE(A.LOCL_TS_STS_CD" ).append("\n"); 
		query.append("             , 'TS', A.TS_EXPN_AMT" ).append("\n"); 
		query.append("             , 'LO', SUM(DECODE(A.LOCL_TS_STS_CD, 'TS', -A.TS_EXPN_AMT, 0)) " ).append("\n"); 
		query.append("                         OVER (PARTITION BY A.FM_TRD_CD, A.FM_IOC_CD, A.FM_VSL_CD, A.FM_SKD_VOY_NO, A.FM_DIR_CD)" ).append("\n"); 
		query.append("       ) AS TS_EXPN_AMT" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT, @[cre_usr_id] AS CRE_USR_ID, SYSDATE AS UPD_DT, @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.FM_TRD_CD, A.FM_RLANE_CD, A.FM_IOC_CD, A.FM_VSL_CD, A.FM_SKD_VOY_NO, A.FM_DIR_CD" ).append("\n"); 
		query.append("             , A.FM_TS_UC_AMT, A.FM_SML_SLS_AMT" ).append("\n"); 
		query.append("             , A.TO_TRD_CD, A.TO_RLANE_CD, A.TO_IOC_CD, A.TO_VSL_CD, A.TO_SKD_VOY_NO, A.TO_DIR_CD" ).append("\n"); 
		query.append("             , A.LOCL_TS_STS_CD, A.TS_QTY" ).append("\n"); 
		query.append("             , NVL(" ).append("\n"); 
		query.append("                   RATIO_TO_REPORT(A.TS_QTY) " ).append("\n"); 
		query.append("                       OVER (PARTITION BY A.FM_TRD_CD, A.FM_IOC_CD, A.FM_VSL_CD, A.FM_SKD_VOY_NO, A.FM_DIR_CD) " ).append("\n"); 
		query.append("                     * 100" ).append("\n"); 
		query.append("                  , 0" ).append("\n"); 
		query.append("               ) AS TS_QTY_RTO" ).append("\n"); 
		query.append("             , (CASE WHEN A.LOCL_TS_STS_CD = 'LO'" ).append("\n"); 
		query.append("                        THEN 0" ).append("\n"); 
		query.append("                     ELSE (" ).append("\n"); 
		query.append("                            A.FM_SML_SLS_AMT " ).append("\n"); 
		query.append("                                * NVL(" ).append("\n"); 
		query.append("                                      RATIO_TO_REPORT(A.TS_QTY) " ).append("\n"); 
		query.append("                                          OVER (PARTITION BY A.FM_TRD_CD, A.FM_IOC_CD, A.FM_VSL_CD, A.FM_SKD_VOY_NO, A.FM_DIR_CD) " ).append("\n"); 
		query.append("                                     , 0" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                 END) AS TS_EXPN_AMT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT A.FM_COST_YRMON, A.FM_COST_WK" ).append("\n"); 
		query.append("                     , A.FM_TRD_CD, A.FM_RLANE_CD, A.FM_IOC_CD, A.FM_VSL_CD, A.FM_SKD_VOY_NO, A.FM_DIR_CD" ).append("\n"); 
		query.append("                     , (CASE WHEN B.TRD_CD IS NOT NULL AND NVL(B.BSA, 0) > 0" ).append("\n"); 
		query.append("                                THEN (A.FM_SML_SLS_AMT + NVL(B.AGRD_EXPN_AMT, 0)) / B.BSA" ).append("\n"); 
		query.append("                             ELSE A.FM_TS_UC_AMT" ).append("\n"); 
		query.append("                         END) AS FM_TS_UC_AMT" ).append("\n"); 
		query.append("                     , (CASE WHEN B.TRD_CD IS NOT NULL" ).append("\n"); 
		query.append("                                THEN A.FM_SML_SLS_AMT + NVL(B.AGRD_EXPN_AMT, 0)" ).append("\n"); 
		query.append("                             ELSE A.FM_SML_SLS_AMT" ).append("\n"); 
		query.append("                         END) AS FM_SML_SLS_AMT" ).append("\n"); 
		query.append("                     , A.TO_COST_YRMON, A.TO_COST_WK, A.TO_TRD_CD, A.TO_RLANE_CD, A.TO_IOC_CD, A.TO_VSL_CD, A.TO_SKD_VOY_NO, A.TO_DIR_CD" ).append("\n"); 
		query.append("                     , A.LOCL_TS_STS_CD" ).append("\n"); 
		query.append("                     , A.TS_QTY" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT A.COST_YRMON AS FM_COST_YRMON, A.COST_WK AS FM_COST_WK" ).append("\n"); 
		query.append("                             , A.TRD_CD AS FM_TRD_CD, A.RLANE_CD AS FM_RLANE_CD, A.IOC_CD AS FM_IOC_CD" ).append("\n"); 
		query.append("                             , A.VSL_CD AS FM_VSL_CD, A.SKD_VOY_NO AS FM_SKD_VOY_NO, A.DIR_CD AS FM_DIR_CD" ).append("\n"); 
		query.append("                             , SUM(B.TS_UC_AMT) AS FM_TS_UC_AMT" ).append("\n"); 
		query.append("                             , (" ).append("\n"); 
		query.append("                                SELECT SUM(T.HJS_SLS_AMT)" ).append("\n"); 
		query.append("                                  FROM MAS_VVD_HIR T" ).append("\n"); 
		query.append("                                 WHERE A.TRD_CD   = T.TRD_CD" ).append("\n"); 
		query.append("                                   AND A.RLANE_CD   = T.RLANE_CD" ).append("\n"); 
		query.append("                                   AND A.IOC_CD     = T.IOC_CD" ).append("\n"); 
		query.append("                                   AND A.VSL_CD     = T.VSL_CD" ).append("\n"); 
		query.append("                                   AND A.SKD_VOY_NO = T.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND A.DIR_CD     = T.DIR_CD" ).append("\n"); 
		query.append("                                   AND T.STND_COST_CD NOT IN ('43102011', '54600000')" ).append("\n"); 
		query.append("                                ) AS FM_SML_SLS_AMT" ).append("\n"); 
		query.append("                             , D.COST_YRMON AS TO_COST_YRMON, D.COST_WK AS TO_COST_WK" ).append("\n"); 
		query.append("                             , B.TO_TRD_CD, B.TO_RLANE_CD, B.TO_IOC_CD" ).append("\n"); 
		query.append("                             , B.TO_VSL_CD, B.TO_SKD_VOY_NO, B.TO_SKD_DIR_CD AS TO_DIR_CD" ).append("\n"); 
		query.append("                             , B.LOCL_TS_STS_CD" ).append("\n"); 
		query.append("                             , MAX(C.TS_QTY) AS TS_QTY	" ).append("\n"); 
		query.append("                          FROM MAS_MON_VVD     A" ).append("\n"); 
		query.append("                             , MAS_FX_AMT_DTRB B" ).append("\n"); 
		query.append("                             , MAS_LANE_TS_QTY C" ).append("\n"); 
		query.append("                             , MAS_MON_VVD     D" ).append("\n"); 
		query.append("                         WHERE A.TRD_CD        = B.FM_TRD_CD" ).append("\n"); 
		query.append("                           AND A.RLANE_CD      = B.FM_RLANE_CD" ).append("\n"); 
		query.append("                           AND A.IOC_CD        = B.FM_IOC_CD" ).append("\n"); 
		query.append("                           AND A.VSL_CD        = B.FM_VSL_CD" ).append("\n"); 
		query.append("                           AND A.SKD_VOY_NO    = B.FM_SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND A.DIR_CD        = B.FM_SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND B.FM_TRD_CD     = C.FM_TRD_CD" ).append("\n"); 
		query.append("                           AND B.FM_RLANE_CD   = C.FM_RLANE_CD" ).append("\n"); 
		query.append("                           AND B.FM_IOC_CD     = C.FM_IOC_CD" ).append("\n"); 
		query.append("                           AND B.FM_VSL_CD     = C.FM_VSL_CD" ).append("\n"); 
		query.append("                           AND B.FM_SKD_VOY_NO = C.FM_SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND B.FM_SKD_DIR_CD = C.FM_SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND B.TO_TRD_CD     = C.TO_TRD_CD" ).append("\n"); 
		query.append("                           AND B.TO_RLANE_CD   = C.TO_RLANE_CD" ).append("\n"); 
		query.append("                           AND B.TO_IOC_CD     = C.TO_IOC_CD" ).append("\n"); 
		query.append("                           AND B.TO_VSL_CD     = C.TO_VSL_CD" ).append("\n"); 
		query.append("                           AND B.TO_SKD_VOY_NO = C.TO_SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND B.TO_SKD_DIR_CD = C.TO_SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND B.TO_TRD_CD     = D.TRD_CD(+)" ).append("\n"); 
		query.append("                           AND B.TO_RLANE_CD   = D.RLANE_CD(+)" ).append("\n"); 
		query.append("                           AND B.TO_IOC_CD     = D.IOC_CD(+)" ).append("\n"); 
		query.append("                           AND B.TO_VSL_CD     = D.VSL_CD(+)" ).append("\n"); 
		query.append("                           AND B.TO_SKD_VOY_NO = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                           AND B.TO_SKD_DIR_CD = D.DIR_CD(+)" ).append("\n"); 
		query.append("                           AND A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("                           AND D.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${fm_cost_wk} != '')" ).append("\n"); 
		query.append("   AND A.COST_YRMON LIKE substr(@[cost_yrmon],0,4) || '%' " ).append("\n"); 
		query.append("   AND A.COST_WK BETWEEN @[fm_cost_wk] AND @[to_cost_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_cost_wk} == '')" ).append("\n"); 
		query.append("    AND A.COST_YRMON = @[cost_yrmon]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                           AND NVL(DTRB_STEP_CD,'BZC') = 'BZC' 	" ).append("\n"); 
		query.append("                           AND B.FM_IOC_CD = 'I'" ).append("\n"); 
		query.append("                           AND B.TO_IOC_CD = 'I'" ).append("\n"); 
		query.append("                         GROUP BY A.COST_YRMON, A.COST_WK, A.TRD_CD, A.RLANE_CD, A.IOC_CD, A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD" ).append("\n"); 
		query.append("                                , D.COST_YRMON, D.COST_WK, B.TO_TRD_CD, B.TO_RLANE_CD, B.TO_IOC_CD" ).append("\n"); 
		query.append("                                , B.TO_VSL_CD, B.TO_SKD_VOY_NO, B.TO_SKD_DIR_CD" ).append("\n"); 
		query.append("                                , B.LOCL_TS_STS_CD" ).append("\n"); 
		query.append("                       ) A" ).append("\n"); 
		query.append("                     , (" ).append("\n"); 
		query.append("                        SELECT X.TO_TRD_CD AS TRD_CD, X.TO_RLANE_CD AS RLANE_CD, X.TO_IOC_CD AS IOC_CD" ).append("\n"); 
		query.append("                             , X.TO_VSL_CD AS VSL_CD, X.TO_SKD_VOY_NO AS SKD_VOY_NO, X.TO_DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("                             , MAX(X.BSA) AS BSA" ).append("\n"); 
		query.append("                             , SUM(NVL(X.AGRD_EXPN_AMT, 0) + NVL(X.OVR_USD_AMT, 0) + NVL(X.FX_EXPN_AMT, 0)) AS AGRD_EXPN_AMT" ).append("\n"); 
		query.append("                          FROM MAS_ALOC_AGMT_EXPN X, MAS_MON_VVD Y" ).append("\n"); 
		query.append("                         WHERE X.FM_TRD_CD     = Y.TRD_CD" ).append("\n"); 
		query.append("                           AND X.FM_RLANE_CD   = Y.RLANE_CD" ).append("\n"); 
		query.append("                           AND X.FM_IOC_CD     = Y.IOC_CD" ).append("\n"); 
		query.append("                           AND X.FM_VSL_CD     = Y.VSL_CD" ).append("\n"); 
		query.append("                           AND X.FM_SKD_VOY_NO = Y.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND X.FM_DIR_CD     = Y.DIR_CD" ).append("\n"); 
		query.append("                           AND Y.DELT_FLG     <> 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_cost_wk} != '')" ).append("\n"); 
		query.append("   AND Y.COST_YRMON LIKE substr(@[cost_yrmon],0,4) || '%' " ).append("\n"); 
		query.append("   AND Y.COST_WK BETWEEN @[fm_cost_wk] AND @[to_cost_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_cost_wk} == '')" ).append("\n"); 
		query.append("    AND Y.COST_YRMON = @[cost_yrmon]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         GROUP BY X.TO_TRD_CD, X.TO_RLANE_CD, X.TO_IOC_CD, X.TO_VSL_CD, X.TO_SKD_VOY_NO, X.TO_DIR_CD" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                 WHERE A.FM_TRD_CD     = B.TRD_CD(+)" ).append("\n"); 
		query.append("                   AND A.FM_RLANE_CD   = B.RLANE_CD(+)" ).append("\n"); 
		query.append("                   AND A.FM_IOC_CD     = B.IOC_CD(+)" ).append("\n"); 
		query.append("                   AND A.FM_VSL_CD     = B.VSL_CD(+)" ).append("\n"); 
		query.append("                   AND A.FM_SKD_VOY_NO = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                   AND A.FM_DIR_CD     = B.DIR_CD(+)" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 

	}
}