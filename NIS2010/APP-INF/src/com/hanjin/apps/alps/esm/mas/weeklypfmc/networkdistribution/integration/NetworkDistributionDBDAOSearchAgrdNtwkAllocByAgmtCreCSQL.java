/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtCreCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.14
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.08.14 송민석
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

public class NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtCreCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtCreCSQL(){
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
		query.append("FileName : NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtCreCSQL").append("\n"); 
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
		query.append("  INTO MAS_ALOC_AGMT_EXPN ( FM_TRD_CD, FM_RLANE_CD, FM_IOC_CD, FM_VSL_CD, FM_SKD_VOY_NO, FM_DIR_CD, TS_UC_AMT, SML_SLS_AMT, CHT_OUT_AMT" ).append("\n"); 
		query.append("                          , TO_TRD_CD, TO_RLANE_CD, TO_IOC_CD, TO_VSL_CD, TO_SKD_VOY_NO, TO_DIR_CD, LOCL_TS_STS_CD, BZC_ALOC_TP_CD, OVR_USD_ALOC_CHG_FLG" ).append("\n"); 
		query.append("                          , BSA, AGRD_TEU, TS_TEU, OVR_TEU, OVR_USD_ALOC_CHG_RTO, OVR_SLT_PRC, BZC_ALOC_FX_AMT" ).append("\n"); 
		query.append("                          , AGRD_EXPN_AMT, OVR_USD_AMT, FX_EXPN_AMT, CRE_DT, CRE_USR_ID, UPD_DT, UPD_USR_ID )" ).append("\n"); 
		query.append("WITH " ).append("\n"); 
		query.append("AGRD_RTO_STUP AS (" ).append("\n"); 
		query.append("SELECT A.COST_YRMON, A.COST_WK" ).append("\n"); 
		query.append("     , A.TRD_CD, A.RLANE_CD, A.IOC_CD, A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD" ).append("\n"); 
		query.append("     , B.COST_YRMON_SEQ, B.GRP_SEQ, B.LOCL_TS_STS_CD" ).append("\n"); 
		query.append("     , B.BZC_ALOC_TP_CD, NVL(B.BZC_ALOC_RTO, 0) AS BZC_ALOC_RTO" ).append("\n"); 
		query.append("     , NVL(B.BZC_ALOC_FX_AMT, 0) AS BZC_ALOC_FX_AMT" ).append("\n"); 
		query.append("     , B.OVR_USD_ALOC_CHG_FLG, NVL(B.OVR_USD_ALOC_CHG_RTO, 0) AS OVR_USD_ALOC_CHG_RTO" ).append("\n"); 
		query.append("  FROM MAS_MON_VVD A" ).append("\n"); 
		query.append("     , MAS_AGRD_NTWK_COST_RTO B" ).append("\n"); 
		query.append("     , MAS_LANE_RGST C" ).append("\n"); 
		query.append(" WHERE A.TRD_CD       = B.TRD_CD" ).append("\n"); 
		query.append("   AND A.RLANE_CD     = B.RLANE_CD" ).append("\n"); 
		query.append("   AND A.IOC_CD       = B.IOC_CD" ).append("\n"); 
		query.append("   AND A.DIR_CD       = B.DIR_CD" ).append("\n"); 
		query.append("   AND A.COST_YRMON   = B.COST_YRMON" ).append("\n"); 
		query.append("   AND A.TRD_CD       = C.TRD_CD" ).append("\n"); 
		query.append("   AND A.RLANE_CD     = C.RLANE_CD" ).append("\n"); 
		query.append("   AND A.IOC_CD       = C.IOC_CD" ).append("\n"); 
		query.append("   AND A.DIR_CD       = C.DIR_CD" ).append("\n"); 
		query.append("   AND A.DELT_FLG    <> 'Y'" ).append("\n"); 
		query.append("   AND B.DELT_FLG    <> 'Y'" ).append("\n"); 
		query.append("   AND C.DELT_FLG    <> 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_cost_wk} != '')" ).append("\n"); 
		query.append("   AND A.COST_YRMON LIKE substr(@[cost_yrmon],0,4) || '%' " ).append("\n"); 
		query.append("   AND A.COST_WK BETWEEN @[fm_cost_wk] AND @[to_cost_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_cost_wk} == '')" ).append("\n"); 
		query.append("    AND A.COST_YRMON = @[cost_yrmon]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", FM_VVD AS (" ).append("\n"); 
		query.append("SELECT A.COST_YRMON, A.COST_WK" ).append("\n"); 
		query.append("     , A.TRD_CD, A.RLANE_CD, A.IOC_CD, A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD" ).append("\n"); 
		query.append("     , A.COST_YRMON_SEQ, A.GRP_SEQ" ).append("\n"); 
		query.append("     , SUM(CASE WHEN B.STND_COST_CD NOT IN ('43102011', '54600000') " ).append("\n"); 
		query.append("                   THEN NVL(B.HJS_SLS_AMT, 0)" ).append("\n"); 
		query.append("                ELSE 0 " ).append("\n"); 
		query.append("            END) AS SML_SLS_AMT " ).append("\n"); 
		query.append("     , SUM(CASE WHEN B.STND_COST_CD IN ( '53101000', '53102000', '53200000', '54100000'" ).append("\n"); 
		query.append("                                       , '54250000', '54300000', '54200000', '54150000'" ).append("\n"); 
		query.append("                                       , '54450000', '54180000', '54550000', '54350000'" ).append("\n"); 
		query.append("                                       , '54400000', '72100000') " ).append("\n"); 
		query.append("                   THEN NVL(B.CO_AMT, 0)" ).append("\n"); 
		query.append("                ELSE 0 " ).append("\n"); 
		query.append("            END) AS CHT_OUT_AMT" ).append("\n"); 
		query.append("  FROM AGRD_RTO_STUP A, MAS_VVD_HIR B" ).append("\n"); 
		query.append(" WHERE A.TRD_CD       = B.TRD_CD" ).append("\n"); 
		query.append("   AND A.RLANE_CD     = B.RLANE_CD" ).append("\n"); 
		query.append("   AND A.IOC_CD       = B.IOC_CD" ).append("\n"); 
		query.append("   AND A.VSL_CD       = B.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO   = B.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.DIR_CD       = B.DIR_CD" ).append("\n"); 
		query.append("   AND A.LOCL_TS_STS_CD  = 'LO'" ).append("\n"); 
		query.append(" GROUP BY A.COST_YRMON, A.COST_WK" ).append("\n"); 
		query.append("        , A.TRD_CD, A.RLANE_CD, A.IOC_CD, A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD" ).append("\n"); 
		query.append("        , A.COST_YRMON_SEQ, A.GRP_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", ALOC_BY_AGRD AS (" ).append("\n"); 
		query.append("SELECT COST_YRMON, COST_YRMON_SEQ, GRP_SEQ" ).append("\n"); 
		query.append("     , FM_COST_WK, FM_TRD_CD, FM_RLANE_CD, FM_IOC_CD, FM_VSL_CD, FM_SKD_VOY_NO, FM_DIR_CD" ).append("\n"); 
		query.append("     , DECODE(BSA,0,0,SML_SLS_AMT / BSA) AS TS_UC_AMT, SML_SLS_AMT, CHT_OUT_AMT" ).append("\n"); 
		query.append("     , TO_COST_WK, TO_TRD_CD, TO_RLANE_CD, TO_IOC_CD, TO_VSL_CD, TO_SKD_VOY_NO, TO_DIR_CD, LOCL_TS_STS_CD" ).append("\n"); 
		query.append("     , BZC_ALOC_TP_CD, OVR_USD_ALOC_CHG_FLG" ).append("\n"); 
		query.append("     , BSA, BZC_ALOC_RTO, BSA * BZC_ALOC_RTO / 100 AS AGRD_TEU, TS_TEU" ).append("\n"); 
		query.append("     , DECODE(LOCL_TS_STS_CD" ).append("\n"); 
		query.append("             , 'TS', (CASE WHEN TS_TEU - BSA * BZC_ALOC_RTO / 100 > 0 " ).append("\n"); 
		query.append("                              THEN TS_TEU - BSA * BZC_ALOC_RTO / 100 " ).append("\n"); 
		query.append("                           ELSE 0" ).append("\n"); 
		query.append("                       END)" ).append("\n"); 
		query.append("             , 0" ).append("\n"); 
		query.append("       ) AS OVR_TEU" ).append("\n"); 
		query.append("     , DECODE(LOCL_TS_STS_CD" ).append("\n"); 
		query.append("             , 'TS', OVR_USD_ALOC_CHG_RTO" ).append("\n"); 
		query.append("             , 0" ).append("\n"); 
		query.append("       ) AS OVR_USD_ALOC_CHG_RTO" ).append("\n"); 
		query.append("     , DECODE(LOCL_TS_STS_CD" ).append("\n"); 
		query.append("             , 'TS', DECODE(BSA,0,0,SML_SLS_AMT / BSA) * OVR_USD_ALOC_CHG_RTO / 100" ).append("\n"); 
		query.append("             , 0" ).append("\n"); 
		query.append("       ) AS OVR_SLT_PRC" ).append("\n"); 
		query.append("     , BZC_ALOC_FX_AMT" ).append("\n"); 
		query.append("     , DECODE(LOCL_TS_STS_CD || BZC_ALOC_TP_CD" ).append("\n"); 
		query.append("             , 'TSR', SML_SLS_AMT * BZC_ALOC_RTO / 100" ).append("\n"); 
		query.append("             , 0" ).append("\n"); 
		query.append("       ) AS AGRD_EXPN_AMT" ).append("\n"); 
		query.append("     , DECODE(LOCL_TS_STS_CD || BZC_ALOC_TP_CD" ).append("\n"); 
		query.append("             , 'TSR', ( DECODE(BSA,0,0,SML_SLS_AMT / BSA) * OVR_USD_ALOC_CHG_RTO / 100) " ).append("\n"); 
		query.append("                        * (CASE WHEN TS_TEU - BSA * BZC_ALOC_RTO / 100 > 0 " ).append("\n"); 
		query.append("                                   THEN TS_TEU - BSA * BZC_ALOC_RTO / 100 " ).append("\n"); 
		query.append("                                ELSE 0" ).append("\n"); 
		query.append("                            END)" ).append("\n"); 
		query.append("             , 0" ).append("\n"); 
		query.append("       ) AS OVR_USD_AMT -- OVR_USD_AMT = OVR_SLT_PRC * OVR_TEU" ).append("\n"); 
		query.append("     , DECODE(LOCL_TS_STS_CD || BZC_ALOC_TP_CD" ).append("\n"); 
		query.append("             , 'TSF',  SML_SLS_AMT + CHT_OUT_AMT - BZC_ALOC_FX_AMT" ).append("\n"); 
		query.append("             , 0" ).append("\n"); 
		query.append("       ) AS FX_EXPN_AMT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.COST_YRMON, A.COST_WK AS FM_COST_WK" ).append("\n"); 
		query.append("             , A.TRD_CD AS FM_TRD_CD, A.RLANE_CD AS FM_RLANE_CD, A.IOC_CD AS FM_IOC_CD" ).append("\n"); 
		query.append("             , A.VSL_CD AS FM_VSL_CD, A.SKD_VOY_NO AS FM_SKD_VOY_NO, A.DIR_CD AS FM_DIR_CD" ).append("\n"); 
		query.append("             , A.SML_SLS_AMT, A.CHT_OUT_AMT" ).append("\n"); 
		query.append("             , B.COST_WK AS TO_COST_WK" ).append("\n"); 
		query.append("             , B.TRD_CD AS TO_TRD_CD, B.RLANE_CD AS TO_RLANE_CD, B.IOC_CD AS TO_IOC_CD" ).append("\n"); 
		query.append("             , B.VSL_CD AS TO_VSL_CD, B.SKD_VOY_NO AS TO_SKD_VOY_NO, B.DIR_CD AS TO_DIR_CD" ).append("\n"); 
		query.append("             , B.LOCL_TS_STS_CD, B.BZC_ALOC_TP_CD, NVL(C.FNL_HJS_BSA_CAPA, 0) AS BSA, B.BZC_ALOC_RTO" ).append("\n"); 
		query.append("             , (CASE WHEN B.LOCL_TS_STS_CD = 'TS' " ).append("\n"); 
		query.append("                            AND B.BZC_ALOC_TP_CD = 'R' " ).append("\n"); 
		query.append("                        THEN (" ).append("\n"); 
		query.append("                              SELECT NVL(SUM(NVL(TS_QTY, 0)), 0)" ).append("\n"); 
		query.append("                                FROM MAS_LANE_TS_QTY TS" ).append("\n"); 
		query.append("                               WHERE 1=1" ).append("\n"); 
		query.append("                                 AND TS.FM_TRD_CD     = A.TRD_CD" ).append("\n"); 
		query.append("                                 AND TS.FM_RLANE_CD   = A.RLANE_CD" ).append("\n"); 
		query.append("                                 AND TS.TO_TRD_CD     = B.TRD_CD    " ).append("\n"); 
		query.append("                                 AND TS.TO_RLANE_CD   = B.RLANE_CD  " ).append("\n"); 
		query.append("                                 AND TS.TO_IOC_CD     = B.IOC_CD    " ).append("\n"); 
		query.append("                                 AND TS.TO_VSL_CD     = B.VSL_CD    " ).append("\n"); 
		query.append("                                 AND TS.TO_SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                                 AND TS.TO_SKD_DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END) AS TS_TEU" ).append("\n"); 
		query.append("             , B.BZC_ALOC_FX_AMT" ).append("\n"); 
		query.append("             , B.OVR_USD_ALOC_CHG_FLG, B.OVR_USD_ALOC_CHG_RTO" ).append("\n"); 
		query.append("             , B.COST_YRMON_SEQ, B.GRP_SEQ" ).append("\n"); 
		query.append("          FROM FM_VVD A, AGRD_RTO_STUP B, BSA_VVD_MST C" ).append("\n"); 
		query.append("         WHERE A.COST_YRMON   = B.COST_YRMON" ).append("\n"); 
		query.append("           AND A.COST_WK      = B.COST_WK" ).append("\n"); 
		query.append("           AND A.GRP_SEQ      = B.GRP_SEQ" ).append("\n"); 
		query.append("           AND A.TRD_CD       = C.TRD_CD(+)" ).append("\n"); 
		query.append("           AND A.RLANE_CD     = C.RLANE_CD(+)" ).append("\n"); 
		query.append("           AND A.IOC_CD       = C.IOC_CD(+)" ).append("\n"); 
		query.append("           AND A.VSL_CD       = C.VSL_CD(+)" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO   = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND A.DIR_CD       = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.FM_TRD_CD, A.FM_RLANE_CD, A.FM_IOC_CD, A.FM_VSL_CD, A.FM_SKD_VOY_NO, A.FM_DIR_CD" ).append("\n"); 
		query.append("     , A.TS_UC_AMT, A.SML_SLS_AMT, A.CHT_OUT_AMT" ).append("\n"); 
		query.append("     , A.TO_TRD_CD, A.TO_RLANE_CD, A.TO_IOC_CD, A.TO_VSL_CD, A.TO_SKD_VOY_NO, A.TO_DIR_CD, A.LOCL_TS_STS_CD" ).append("\n"); 
		query.append("     , A.BZC_ALOC_TP_CD, A.OVR_USD_ALOC_CHG_FLG" ).append("\n"); 
		query.append("     , A.BSA, A.AGRD_TEU, A.TS_TEU, A.OVR_TEU, A.OVR_USD_ALOC_CHG_RTO, A.OVR_SLT_PRC" ).append("\n"); 
		query.append("     , A.BZC_ALOC_FX_AMT" ).append("\n"); 
		query.append("     , DECODE(A.LOCL_TS_STS_CD" ).append("\n"); 
		query.append("             , 'TS', A.AGRD_EXPN_AMT" ).append("\n"); 
		query.append("             , 'LO', SUM(DECODE(A.LOCL_TS_STS_CD, 'TS', -A.AGRD_EXPN_AMT, 0)) " ).append("\n"); 
		query.append("                         OVER (PARTITION BY A.FM_TRD_CD, A.FM_RLANE_CD, A.FM_IOC_CD, A.FM_VSL_CD, A.FM_SKD_VOY_NO, A.FM_DIR_CD)" ).append("\n"); 
		query.append("       ) AS AGRD_EXPN_AMT" ).append("\n"); 
		query.append("     , DECODE(A.LOCL_TS_STS_CD" ).append("\n"); 
		query.append("             , 'TS', A.OVR_USD_AMT" ).append("\n"); 
		query.append("             , 'LO', SUM(DECODE(A.LOCL_TS_STS_CD, 'TS', -A.OVR_USD_AMT, 0)) " ).append("\n"); 
		query.append("                         OVER (PARTITION BY A.FM_TRD_CD, A.FM_RLANE_CD, A.FM_IOC_CD, A.FM_VSL_CD, A.FM_SKD_VOY_NO, A.FM_DIR_CD)" ).append("\n"); 
		query.append("       ) AS OVR_USD_AMT" ).append("\n"); 
		query.append("     , DECODE(A.LOCL_TS_STS_CD" ).append("\n"); 
		query.append("             , 'TS', A.FX_EXPN_AMT" ).append("\n"); 
		query.append("             , 'LO', SUM(DECODE(A.LOCL_TS_STS_CD, 'TS', -A.FX_EXPN_AMT, 0)) " ).append("\n"); 
		query.append("                         OVER (PARTITION BY A.FM_TRD_CD, A.FM_RLANE_CD, A.FM_IOC_CD, A.FM_VSL_CD, A.FM_SKD_VOY_NO, A.FM_DIR_CD)" ).append("\n"); 
		query.append("       ) AS FX_EXPN_AMT" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT, @[cre_usr_id] AS CRE_USR_ID, SYSDATE AS UPD_DT, @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("  FROM ALOC_BY_AGRD A" ).append("\n"); 

	}
}