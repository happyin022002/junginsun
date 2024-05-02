/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkCostDBDAOCreateAverageUCRawCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.21
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.07.21 최덕우
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

public class NetworkCostDBDAOCreateAverageUCRawCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Raw Data
	  * </pre>
	  */
	public NetworkCostDBDAOCreateAverageUCRawCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_fm_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOCreateAverageUCRawCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_OP_AVG_VSL_TP_COST" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	    COST_YRMON" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , VSL_OSHP_CD" ).append("\n"); 
		query.append("      , STND_COST_CD" ).append("\n"); 
		query.append("      , FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("      , FREQ_NO " ).append("\n"); 
		query.append("      , NTWK_HIR_COST_AMT" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" SELECT COST_YRMON" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , VSL_OSHP_CD     " ).append("\n"); 
		query.append("      , DECODE(B.NO, 1, '43102011', 2, '53101000', 3, '53102000', 4, '53200000', 5, '54100000'" ).append("\n"); 
		query.append("                   , 6, '54250000', 7, '54300000', 8, '54200000', 9, '54150000', 10 , '54450000'" ).append("\n"); 
		query.append("		   , 11, '54180000', 12, '54550000', 13, '54350000', 14, '54400000') STND_COST_CD" ).append("\n"); 
		query.append("      , HJS_BSA_CAPA AS FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("      , FREQ_NO      " ).append("\n"); 
		query.append("      , DECODE(B.NO, 1, SPC_INCOME, 2, AMT_01, 3, AMT_02, 4, AMT_03, 5, AMT_04" ).append("\n"); 
		query.append("                   , 6, AMT_05, 7, AMT_06, 8, AMT_07, 9, AMT_08, 10 , AMT_09" ).append("\n"); 
		query.append("		   , 11, AMT_10, 12, AMT_11, 13, AMT_12, 14, AMT_13) NTWK_HIR_COST_AMT" ).append("\n"); 
		query.append("      , @[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE CRE_DT" ).append("\n"); 
		query.append("      , @[cre_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE UPD_DT" ).append("\n"); 
		query.append("   FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("              SELECT COST_YRMON" ).append("\n"); 
		query.append("                      , TRD_CD" ).append("\n"); 
		query.append("                      , RLANE_CD" ).append("\n"); 
		query.append("                      , DIR_CD" ).append("\n"); 
		query.append("                      , VSL_OSHP_CD" ).append("\n"); 
		query.append("                      , SUM(FNL_HJS_BSA_CAPA) AS HJS_BSA_CAPA" ).append("\n"); 
		query.append("                      , COUNT(*) FREQ_NO                                              " ).append("\n"); 
		query.append("                      , SUM(SPC_INCOME) SPC_INCOME" ).append("\n"); 
		query.append("                      , SUM(AMT_01 ) AS AMT_01" ).append("\n"); 
		query.append("                      , SUM(AMT_02)  AS AMT_02" ).append("\n"); 
		query.append("                      , SUM(AMT_03)  AS AMT_03" ).append("\n"); 
		query.append("                      , SUM(AMT_04)  AS AMT_04" ).append("\n"); 
		query.append("                      , SUM(AMT_05)  AS AMT_05" ).append("\n"); 
		query.append("                      , SUM(AMT_06)  AS AMT_06" ).append("\n"); 
		query.append("                      , SUM(AMT_07)  AS AMT_07" ).append("\n"); 
		query.append("                      , SUM(AMT_08)  AS AMT_08" ).append("\n"); 
		query.append("                      , SUM(AMT_09)  AS AMT_09" ).append("\n"); 
		query.append("                      , SUM(AMT_10)  AS AMT_10" ).append("\n"); 
		query.append("                      , SUM(AMT_11)  AS AMT_11" ).append("\n"); 
		query.append("                      , SUM(AMT_12)  AS AMT_12" ).append("\n"); 
		query.append("                      , SUM(AMT_13)  AS AMT_13" ).append("\n"); 
		query.append("                   FROM" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                         SELECT REPLACE(@[f_cost_yrmon],'-','') AS COST_YRMON" ).append("\n"); 
		query.append("                              , A.COST_WK" ).append("\n"); 
		query.append("                              , A.TRD_CD" ).append("\n"); 
		query.append("                              , A.RLANE_CD" ).append("\n"); 
		query.append("                              , A.VSL_CD" ).append("\n"); 
		query.append("                              , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                              , A.DIR_CD" ).append("\n"); 
		query.append("                              , NVL(V.VSL_OSHP_CD, 'OTH') VSL_OSHP_CD" ).append("\n"); 
		query.append("                              , B.FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("                              , NVL(B.INCM_BZC_CHTR_AMT, 0)+NVL(B.INCM_SUB_CHTR_AMT, 0)+NVL(B.INCM_CRS_CHTR_AMT, 0) AS SPC_INCOME" ).append("\n"); 
		query.append("                              , C.AMT_01" ).append("\n"); 
		query.append("                              , C.AMT_02" ).append("\n"); 
		query.append("                              , C.AMT_03" ).append("\n"); 
		query.append("                              , C.AMT_04" ).append("\n"); 
		query.append("                              , C.AMT_05" ).append("\n"); 
		query.append("                              , C.AMT_06" ).append("\n"); 
		query.append("                              , C.AMT_07" ).append("\n"); 
		query.append("                              , C.AMT_08" ).append("\n"); 
		query.append("                              , C.AMT_09" ).append("\n"); 
		query.append("                              , C.AMT_10" ).append("\n"); 
		query.append("                              , C.AMT_11" ).append("\n"); 
		query.append("                              , C.AMT_12" ).append("\n"); 
		query.append("                              , C.AMT_13" ).append("\n"); 
		query.append("                           FROM COA_MON_VVD A" ).append("\n"); 
		query.append("                              , BSA_VVD_MST B" ).append("\n"); 
		query.append("                              , (SELECT A1.TRD_CD                                                         AS TRD_CD" ).append("\n"); 
		query.append("                                      , A1.RLANE_CD                                                       AS RLANE_CD" ).append("\n"); 
		query.append("                                      , A1.IOC_CD                                                         AS IOC_CD" ).append("\n"); 
		query.append("                                      , A1.VSL_CD                                                         AS VSL_CD" ).append("\n"); 
		query.append("                                      , A1.SKD_VOY_NO                                                     AS SKD_VOY_NO" ).append("\n"); 
		query.append("                                      , A1.DIR_CD                                                         AS DIR_CD" ).append("\n"); 
		query.append("                                      , SUM(TS_UC_AMT)                                                    AS TS_UC_AMT" ).append("\n"); 
		query.append("                                      , SUM(DECODE(A1.STND_COST_CD, '53101000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_01" ).append("\n"); 
		query.append("                                      , SUM(DECODE(A1.STND_COST_CD, '53102000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_02" ).append("\n"); 
		query.append("                                      , SUM(DECODE(A1.STND_COST_CD, '53200000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_03" ).append("\n"); 
		query.append("                                      , SUM(DECODE(A1.STND_COST_CD, '54100000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_04" ).append("\n"); 
		query.append("                                      , SUM(DECODE(A1.STND_COST_CD, '54250000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_05" ).append("\n"); 
		query.append("                                      , SUM(DECODE(A1.STND_COST_CD, '54300000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_06" ).append("\n"); 
		query.append("                                      , SUM(DECODE(A1.STND_COST_CD, '54200000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_07" ).append("\n"); 
		query.append("                                      , SUM(DECODE(A1.STND_COST_CD, '54150000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_08" ).append("\n"); 
		query.append("                                      , SUM(DECODE(A1.STND_COST_CD, '54450000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_09" ).append("\n"); 
		query.append("                                      , SUM(DECODE(A1.STND_COST_CD, '54180000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_10" ).append("\n"); 
		query.append("                                      , SUM(DECODE(A1.STND_COST_CD, '54550000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_11" ).append("\n"); 
		query.append("                                      , SUM(DECODE(A1.STND_COST_CD, '54350000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_12" ).append("\n"); 
		query.append("                                      , SUM(DECODE(A1.STND_COST_CD, '54400000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_13" ).append("\n"); 
		query.append("                                   FROM COA_VVD_HIR A1" ).append("\n"); 
		query.append("                               GROUP BY A1.TRD_CD" ).append("\n"); 
		query.append("                                      , A1.RLANE_CD" ).append("\n"); 
		query.append("                                      , A1.IOC_CD" ).append("\n"); 
		query.append("                                      , A1.VSL_CD" ).append("\n"); 
		query.append("                                      , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      , A1.DIR_CD" ).append("\n"); 
		query.append("                                ) C" ).append("\n"); 
		query.append("                              , COA_LANE_RGST R" ).append("\n"); 
		query.append("                              , COA_VSL_RGST V" ).append("\n"); 
		query.append("                          WHERE A.TRD_CD     = B.TRD_CD" ).append("\n"); 
		query.append("                            AND A.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("                            AND A.IOC_CD     = B.IOC_CD" ).append("\n"); 
		query.append("                            AND A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("                            AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                            AND A.DIR_CD     = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                            AND A.TRD_CD     = C.TRD_CD" ).append("\n"); 
		query.append("                            AND A.RLANE_CD   = C.RLANE_CD" ).append("\n"); 
		query.append("                            AND A.IOC_CD     = C.IOC_CD" ).append("\n"); 
		query.append("                            AND A.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("                            AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("                            AND A.DIR_CD     = C.DIR_CD" ).append("\n"); 
		query.append("                            AND A.TRD_CD     = R.TRD_CD" ).append("\n"); 
		query.append("                            AND A.RLANE_CD   = R.RLANE_CD" ).append("\n"); 
		query.append("                            AND A.IOC_CD     = R.IOC_CD" ).append("\n"); 
		query.append("                            AND A.DIR_CD     = R.DIR_CD" ).append("\n"); 
		query.append("                            AND R.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                            AND A.VSL_CD   = V.VSL_CD(+)" ).append("\n"); 
		query.append("                            AND V.LST_FLG(+)  = 'Y'" ).append("\n"); 
		query.append("                            AND V.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("                            AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND SUBSTR(A.SLS_YRMON,1,4)||A.COST_WK BETWEEN REPLACE(@[f_fm_yrwk],'-','') AND REPLACE(@[f_to_yrwk],'-','')" ).append("\n"); 
		query.append("                            AND B.FNL_HJS_BSA_CAPA > 0" ).append("\n"); 
		query.append("                            AND A.SUB_TRD_CD <> 'IP'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("               GROUP BY COST_YRMON" ).append("\n"); 
		query.append("                      , TRD_CD" ).append("\n"); 
		query.append("                      , RLANE_CD" ).append("\n"); 
		query.append("                      , DIR_CD" ).append("\n"); 
		query.append("                      , VSL_OSHP_CD" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("      , (SELECT LEVEL NO" ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
		query.append("                CONNECT BY LEVEL <= 14" ).append("\n"); 
		query.append("        ) B" ).append("\n"); 

	}
}