/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PreCMSimulationDBDAOSearchBkgRmk4007ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreCMSimulationDBDAOSearchBkgRmk4007ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PreCMSimulationDBDAOSearchBkgRmk4007ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.integration").append("\n"); 
		query.append("FileName : PreCMSimulationDBDAOSearchBkgRmk4007ListRSQL").append("\n"); 
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
		query.append("SELECT NOD_CD " ).append("\n"); 
		query.append("      ,GRP " ).append("\n"); 
		query.append("      ,STND_COST_CD " ).append("\n"); 
		query.append("      ,STND_COST_NM " ).append("\n"); 
		query.append("      ,COA_COST_SRC_CD" ).append("\n"); 
		query.append("      ,COA_COST_SRC_NM " ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD  " ).append("\n"); 
		query.append("      ,AMT_A" ).append("\n"); 
		query.append("      ,AMT_B" ).append("\n"); 
		query.append("      ,CTRT_RTN_FLG " ).append("\n"); 
		query.append("      ,COST_CALC_RMK" ).append("\n"); 
		query.append("	  ,MIS_AVG_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT A4.NOD_CD  NOD_CD" ).append("\n"); 
		query.append("        ,A1.COST_ACT_GRP_SEQ  " ).append("\n"); 
		query.append("        ,COA_GET_COM_NM_FNC('COST_ACT_GRP_CD', A1.COST_ACT_GRP_CD) GRP " ).append("\n"); 
		query.append("        ,A1.STND_COST_CD  " ).append("\n"); 
		query.append("        ,A2.STND_COST_NM " ).append("\n"); 
		query.append("        ,A1.COA_COST_SRC_CD" ).append("\n"); 
		query.append("        ,COA_GET_COM_NM_FNC('COA_COST_SRC_CD', A1.COA_COST_SRC_CD) COA_COST_SRC_NM -- 2011.01.11 이윤정 [CHM-201108216-01] TMFDFL 계정에 대해서 TMFDMT으로 변환하여 보여주는 부분을 제거." ).append("\n"); 
		query.append("        ,A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,NVL(A1.ESTM_USD_TTL_AMT,0)																AMT_A" ).append("\n"); 
		query.append("        ,NVL(DECODE(A1.STND_COST_CD,'51102001', A1.ESTM_USD_TTL_AMT2, A1.ESTM_USD_TTL_AMT),0)	AMT_B" ).append("\n"); 
		query.append("        ,DECODE(CTRT_RTN_FLG, 'Y', 'Contract','L', 'Actual', 'Average') CTRT_RTN_FLG " ).append("\n"); 
		query.append("        ,CASE  " ).append("\n"); 
		query.append("            WHEN REGEXP_LIKE(A1.COST_CALC_RMK, '^>T[RE]S AVG-') THEN " ).append("\n"); 
		query.append("                 SUBSTR(A1.COST_CALC_RMK, 2, 12) || ' -> ' || ROUND(ESTM_USD_UC_AMT, 2)" ).append("\n"); 
		query.append("            WHEN A1.STND_COST_CD IN ('51102001') THEN " ).append("\n"); 
		query.append("                 DECODE('A' ,'B',SUBSTR(A1.COST_CALC_RMK2, 1),SUBSTR(A1.COST_CALC_RMK, 1))" ).append("\n"); 
		query.append("            ELSE DECODE(A1.COA_COST_SRC_CD  " ).append("\n"); 
		query.append("                  ,'51601011', SUBSTR(A1.COST_CALC_RMK, 2)" ).append("\n"); 
		query.append("                  ,REPLACE(A1.COST_CALC_RMK, '>TP', 'TP')  )  " ).append("\n"); 
		query.append("          END AS COST_CALC_RMK" ).append("\n"); 
		query.append("        ,ACCT_DP_SEQ  " ).append("\n"); 
		query.append("		,DECODE(A1.COST_ASS_BSE_CD||A1.CTRT_RTN_FLG,'CN',1,0) MIS_AVG_FLG" ).append("\n"); 
		query.append("    FROM COA_COM_COST_PARA A1  " ).append("\n"); 
		query.append("        ,COA_STND_ACCT_V A2  " ).append("\n"); 
		query.append("        ,(SELECT  DISTINCT COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                          ,COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                          ,N1ST_NOD_CD ORG_NOD_CD" ).append("\n"); 
		query.append("                          ,COALESCE(N4TH_NOD_CD, N3RD_NOD_CD, N2ND_NOD_CD) DEST_NOD_CD" ).append("\n"); 
		query.append("                          ,DECODE(N1ST_NOD_CD ,N2ND_NOD_CD, N1ST_NOD_CD" ).append("\n"); 
		query.append("                                              , DECODE(N1ST_NOD_CD, NULL, ' ', N1ST_NOD_CD)" ).append("\n"); 
		query.append("                                             || DECODE(N2ND_NOD_CD, NULL, ' ', ' -> ' || N2ND_NOD_CD)" ).append("\n"); 
		query.append("                                             || DECODE(N3RD_NOD_CD, NULL, ' ', ' -> ' || N3RD_NOD_CD)" ).append("\n"); 
		query.append("                                             || DECODE(N4TH_NOD_CD, NULL, ' ', ' -> ' || N4TH_NOD_CD) ) NOD_CD" ).append("\n"); 
		query.append("            FROM  COA_COM_COST_PARA" ).append("\n"); 
		query.append("           WHERE  PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("		   AND STND_COST_CD <> '51102001'" ).append("\n"); 
		query.append("        ) A4  " ).append("\n"); 
		query.append("   WHERE  A1.PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("     AND  COA_COST_SRC_PRT_CD IN ('CO', 'PA')   " ).append("\n"); 
		query.append("     AND  STND_COST_TP_CD = 'C' " ).append("\n"); 
		query.append("     AND  A1.STND_COST_CD = A2.STND_COST_CD" ).append("\n"); 
		query.append("     AND  A2.PA_VW = 'BKG'" ).append("\n"); 
		query.append("--   AND  A1.STND_COST_CD <> '51701011'" ).append("\n"); 
		query.append("     AND  A1.COST_ACT_GRP_SEQ = A4.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("     AND  A1.ESTM_USD_TTL_AMT <> 0 " ).append("\n"); 
		query.append("#if (${f_cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("     AND  A1.CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("ORDER BY COST_ACT_GRP_SEQ, ACCT_DP_SEQ, CNTR_TPSZ_CD, 5, 9" ).append("\n"); 

	}
}