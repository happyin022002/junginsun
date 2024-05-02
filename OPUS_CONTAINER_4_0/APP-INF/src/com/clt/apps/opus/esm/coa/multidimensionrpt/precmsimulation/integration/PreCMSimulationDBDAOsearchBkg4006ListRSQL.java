/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PreCMSimulationDBDAOsearchBkg4006ListRSQL.java
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

public class PreCMSimulationDBDAOsearchBkg4006ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * _BKG_COST_DTL, _SPCL_REPO_CNTR_RGST 테이블의 데이터 조회
	  * </pre>
	  */
	public PreCMSimulationDBDAOsearchBkg4006ListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.integration").append("\n"); 
		query.append("FileName : PreCMSimulationDBDAOsearchBkg4006ListRSQL").append("\n"); 
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
		query.append("SELECT NOD_CD, COST_ACT_GRP_SEQ, GRP, SGRP_COST_CD_DESC, STND_COST_NM" ).append("\n"); 
		query.append("            ,DECODE(LVL,3,SUM(DECODE(LVL||GBN,2||1,AMT20_A,0)) OVER() - SUM(DECODE(LVL||GBN,2||2,AMT20_A,0)) OVER(), AMT20_A) AS AMT20_A" ).append("\n"); 
		query.append("            ,DECODE(LVL,3,SUM(DECODE(LVL||GBN,2||1,AMT40_A,0)) OVER() - SUM(DECODE(LVL||GBN,2||2,AMT40_A,0)) OVER(), AMT40_A) AS AMT40_A" ).append("\n"); 
		query.append("            ,DECODE(LVL,3,SUM(DECODE(LVL||GBN,2||1,AMT45_A,0)) OVER() - SUM(DECODE(LVL||GBN,2||2,AMT45_A,0)) OVER(), AMT45_A) AS AMT45_A" ).append("\n"); 
		query.append("			,DECODE(LVL,3,SUM(DECODE(LVL||GBN,2||1,AMT45_2_A,0)) OVER() - SUM(DECODE(LVL||GBN,2||2,AMT45_2_A,0)) OVER(), AMT45_2_A) AS AMT45_2_A" ).append("\n"); 
		query.append("            ,DECODE(LVL,3,SUM(DECODE(LVL||GBN,2||1,AMT20_B,0)) OVER() - SUM(DECODE(LVL||GBN,2||2,AMT20_B,0)) OVER(), AMT20_B) AS AMT20_B" ).append("\n"); 
		query.append("            ,DECODE(LVL,3,SUM(DECODE(LVL||GBN,2||1,AMT40_B,0)) OVER() - SUM(DECODE(LVL||GBN,2||2,AMT40_B,0)) OVER(), AMT40_B) AS AMT40_B" ).append("\n"); 
		query.append("            ,DECODE(LVL,3,SUM(DECODE(LVL||GBN,2||1,AMT45_B,0)) OVER() - SUM(DECODE(LVL||GBN,2||2,AMT45_B,0)) OVER(), AMT45_B) AS AMT45_B" ).append("\n"); 
		query.append("			,DECODE(LVL,3,SUM(DECODE(LVL||GBN,2||1,AMT45_2_B,0)) OVER() - SUM(DECODE(LVL||GBN,2||2,AMT45_2_B,0)) OVER(), AMT45_2_B) AS AMT45_2_B" ).append("\n"); 
		query.append("			,SIGN(DECODE(LVL,3,SUM(MIS_AVG_CNT_20) OVER(),MIS_AVG_CNT_20)) MIS_AVG_FLG_20" ).append("\n"); 
		query.append("			,SIGN(DECODE(LVL,3,SUM(MIS_AVG_CNT_40) OVER(),MIS_AVG_CNT_40)) MIS_AVG_FLG_40" ).append("\n"); 
		query.append("			,SIGN(DECODE(LVL,3,SUM(MIS_AVG_CNT_45) OVER(),MIS_AVG_CNT_45)) MIS_AVG_FLG_45" ).append("\n"); 
		query.append("			,SIGN(DECODE(LVL,3,SUM(MIS_AVG_CNT_45_2) OVER(),MIS_AVG_CNT_45_2)) MIS_AVG_FLG_45_2" ).append("\n"); 
		query.append("            ,WTR_RCV_TERM_CD, WTR_DE_TERM_CD, DECODE(LVL,3,1,1,3,0,4,LVL) LVL" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("	  SELECT '' 				AS NOD_CD" ).append("\n"); 
		query.append("            ,0  				AS COST_ACT_GRP_SEQ " ).append("\n"); 
		query.append("            ,'' 				AS GRP" ).append("\n"); 
		query.append("            ,SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("            ,SGRP_COST_CD_DESC  AS STND_COST_NM  " ).append("\n"); 
		query.append("            ,AMT20_A" ).append("\n"); 
		query.append("            ,AMT40_A" ).append("\n"); 
		query.append("            ,AMT45_A" ).append("\n"); 
		query.append("            ,AMT45_2_A" ).append("\n"); 
		query.append("            ,AMT20_B" ).append("\n"); 
		query.append("            ,AMT40_B" ).append("\n"); 
		query.append("            ,AMT45_B" ).append("\n"); 
		query.append("            ,AMT45_2_B" ).append("\n"); 
		query.append("            ,0 MIS_AVG_CNT_20" ).append("\n"); 
		query.append("            ,0 MIS_AVG_CNT_40" ).append("\n"); 
		query.append("            ,0 MIS_AVG_CNT_45" ).append("\n"); 
		query.append("            ,0 MIS_AVG_CNT_45_2" ).append("\n"); 
		query.append("            ,'' 				AS WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("            ,'' 				AS WTR_DE_TERM_CD" ).append("\n"); 
		query.append("            ,LVL" ).append("\n"); 
		query.append("            ,1 					AS GBN" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("                SELECT SGRP_COST_CD_DESC," ).append("\n"); 
		query.append("                       DECODE(LVL,2,SUM(AMT20_A) OVER(),AMT20_A) AMT20_A" ).append("\n"); 
		query.append("                      ,DECODE(LVL,2,SUM(AMT40_A) OVER(),AMT40_A) AMT40_A  " ).append("\n"); 
		query.append("                      ,DECODE(LVL,2,SUM(AMT45_A) OVER(),AMT45_A) AMT45_A  " ).append("\n"); 
		query.append("                      ,DECODE(LVL,2,SUM(AMT45_2_A) OVER(),AMT45_2_A) AMT45_2_A  " ).append("\n"); 
		query.append("                      ,DECODE(LVL,2,SUM(AMT20_B) OVER(),AMT20_B) AMT20_B " ).append("\n"); 
		query.append("                      ,DECODE(LVL,2,SUM(AMT40_B) OVER(),AMT40_B) AMT40_B " ).append("\n"); 
		query.append("                      ,DECODE(LVL,2,SUM(AMT45_B) OVER(),AMT45_B) AMT45_B " ).append("\n"); 
		query.append("                      ,DECODE(LVL,2,SUM(AMT45_2_B) OVER(),AMT45_2_B) AMT45_2_B " ).append("\n"); 
		query.append("                      ,LVL" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                             'CM' SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("                             ,0 AMT20_A,0 AMT40_A,0 AMT45_A,0 AMT45_2_A,0 AMT20_B,0 AMT40_B,0 AMT45_B,0 AMT45_2_B,3 LVL, 0 LVL2, 0 SEQ    FROM DUAL" ).append("\n"); 
		query.append("                UNION ALL                     " ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                             'Total Revenue' SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("                             ,0 AMT20_A,0 AMT40_A,0 AMT45_A,0 AMT45_2_A,0 AMT20_B,0 AMT40_B,0 AMT45_B,0 AMT45_2_B,2 LVL, 0 LVL2, 0 SEQ    FROM DUAL" ).append("\n"); 
		query.append("                UNION ALL " ).append("\n"); 
		query.append("								#if (${rowcnt} > 0) " ).append("\n"); 
		query.append("									#set($i = 1)	        	" ).append("\n"); 
		query.append("									#foreach(${key} in ${parentArr})" ).append("\n"); 
		query.append("										SELECT '${key.chgCd}' SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("										      ,${key.d20} AMT20_A,${key.d40} AMT40_A,${key.d45} AMT45_A,${key.d70} AMT45_2_A" ).append("\n"); 
		query.append("										      ,${key.d20} AMT20_B,${key.d40} AMT40_B,${key.d45} AMT45_B,${key.d70} AMT45_2_B" ).append("\n"); 
		query.append("                                              ,${key.lvl} LVL, ${key.lvl2} LVL2, ${key.pc} SEQ 	FROM DUAL " ).append("\n"); 
		query.append("										#if(${rowcnt} > $i) " ).append("\n"); 
		query.append("											UNION ALL" ).append("\n"); 
		query.append("											#set ($i = $i+1)	        		" ).append("\n"); 
		query.append("										#end" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if(${rowcnt} == 0 )" ).append("\n"); 
		query.append("										SELECT ' ' SGRP_COST_CD_DESC, 0 AMT20_A, 0 AMT40_A, 0 AMT45_A, 0 AMT45_2_A, 0 AMT20_B, 0 AMT40_B, 0 AMT45_B, 0 AMT45_2_B, 0 LVL, 0 LVL2, 0 SEQ FROM DUAL " ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("                             ) A" ).append("\n"); 
		query.append("                 ORDER BY LVL DESC, LVL2 DESC, SEQ ASC" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- COST" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("          DECODE(LVL,2,'',NOD_CD)    					AS NOD_CD" ).append("\n"); 
		query.append("         ,DECODE(LVL,2,0,COST_ACT_GRP_SEQ) 				AS COST_ACT_GRP_SEQ " ).append("\n"); 
		query.append("         ,DECODE(LVL,2,'',GRP)          				AS GRP " ).append("\n"); 
		query.append("         ,DECODE(LVL,2,'Total Cost',SGRP_COST_CD_DESC)  AS SGRP_COST_CD_DESC " ).append("\n"); 
		query.append("         ,DECODE(LVL,2,'Total Cost',0,STND_COST_NM,'')  AS STND_COST_NM " ).append("\n"); 
		query.append("         ,AMT20_A" ).append("\n"); 
		query.append("         ,AMT40_A" ).append("\n"); 
		query.append("         ,AMT45_A  " ).append("\n"); 
		query.append("         ,AMT45_2_A        " ).append("\n"); 
		query.append("         ,AMT20_B" ).append("\n"); 
		query.append("         ,AMT40_B" ).append("\n"); 
		query.append("         ,AMT45_B" ).append("\n"); 
		query.append("         ,AMT45_2_B" ).append("\n"); 
		query.append("         ,MIS_AVG_CNT_20" ).append("\n"); 
		query.append("         ,MIS_AVG_CNT_40" ).append("\n"); 
		query.append("         ,MIS_AVG_CNT_45" ).append("\n"); 
		query.append("         ,MIS_AVG_CNT_45_2" ).append("\n"); 
		query.append("         ,WTR_RCV_TERM_CD " ).append("\n"); 
		query.append("         ,WTR_DE_TERM_CD " ).append("\n"); 
		query.append("         ,LVL " ).append("\n"); 
		query.append("         ,2 											AS GBN" ).append("\n"); 
		query.append("FROM     (SELECT /*+ ORDERED */ " ).append("\n"); 
		query.append("                 MAX(A4.NOD_CD) 						AS NOD_CD" ).append("\n"); 
		query.append("                ,MAX(A1.COST_ACT_GRP_CD)    			AS COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                ,A1.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                ,A3.SGRP_COST_CD" ).append("\n"); 
		query.append("                ,MAX(A3.SGRP_COST_CD_DESC) 				AS SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("                ,A3.STND_COST_CD" ).append("\n"); 
		query.append("                ,MAX(A3.STND_COST_NM) 					AS STND_COST_NM" ).append("\n"); 
		query.append("                ,COA_GET_COM_NM_FNC('cost_act_grp_cd',MAX(A1.COST_ACT_GRP_CD)) 		AS GRP " ).append("\n"); 
		query.append("                ,SUM(DECODE ( SUBSTR(A1.CNTR_TPSZ_CD,-1), 2, A1.ESTM_USD_TTL_AMT, 0)) AMT20_A" ).append("\n"); 
		query.append("                ,SUM(DECODE ( SUBSTR(A1.CNTR_TPSZ_CD,-1), 4, A1.ESTM_USD_TTL_AMT, 0)) AMT40_A" ).append("\n"); 
		query.append("                ,SUM(DECODE ( SUBSTR(A1.CNTR_TPSZ_CD,-1), 5, A1.ESTM_USD_TTL_AMT, 0)) AMT45_A  " ).append("\n"); 
		query.append("				,SUM(DECODE ( SUBSTR(A1.CNTR_TPSZ_CD,-1), 7, A1.ESTM_USD_TTL_AMT, 0)) AMT45_2_A              " ).append("\n"); 
		query.append("                ,SUM(DECODE ( SUBSTR(A1.CNTR_TPSZ_CD,-1), 2, DECODE(A1.STND_COST_CD, '51102001', A1.ESTM_USD_TTL_AMT2, A1.ESTM_USD_TTL_AMT), 0)) AMT20_B" ).append("\n"); 
		query.append("                ,SUM(DECODE ( SUBSTR(A1.CNTR_TPSZ_CD,-1), 4, DECODE(A1.STND_COST_CD, '51102001', A1.ESTM_USD_TTL_AMT2, A1.ESTM_USD_TTL_AMT), 0)) AMT40_B" ).append("\n"); 
		query.append("                ,SUM(DECODE ( SUBSTR(A1.CNTR_TPSZ_CD,-1), 5, DECODE(A1.STND_COST_CD, '51102001', A1.ESTM_USD_TTL_AMT2, A1.ESTM_USD_TTL_AMT), 0)) AMT45_B" ).append("\n"); 
		query.append("				,SUM(DECODE ( SUBSTR(A1.CNTR_TPSZ_CD,-1), 7, DECODE(A1.STND_COST_CD, '51102001', A1.ESTM_USD_TTL_AMT2, A1.ESTM_USD_TTL_AMT), 0)) AMT45_2_B" ).append("\n"); 
		query.append("                ,MAX(A1.WTR_RCV_TERM_CD) 				AS WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("                ,MAX(A1.WTR_DE_TERM_CD) 				AS WTR_DE_TERM_CD" ).append("\n"); 
		query.append("                ,SUM(DECODE ( SUBSTR(A1.CNTR_TPSZ_CD,-1), 2, DECODE(A1.COST_ASS_BSE_CD||A1.CTRT_RTN_FLG, 'CN', 1, 0), 0)) MIS_AVG_CNT_20" ).append("\n"); 
		query.append("                ,SUM(DECODE ( SUBSTR(A1.CNTR_TPSZ_CD,-1), 4, DECODE(A1.COST_ASS_BSE_CD||A1.CTRT_RTN_FLG, 'CN', 1, 0), 0)) MIS_AVG_CNT_40" ).append("\n"); 
		query.append("                ,SUM(DECODE ( SUBSTR(A1.CNTR_TPSZ_CD,-1), 5, DECODE(A1.COST_ASS_BSE_CD||A1.CTRT_RTN_FLG, 'CN', 1, 0), 0)) MIS_AVG_CNT_45" ).append("\n"); 
		query.append("				,SUM(DECODE ( SUBSTR(A1.CNTR_TPSZ_CD,-1), 7, DECODE(A1.COST_ASS_BSE_CD||A1.CTRT_RTN_FLG, 'CN', 1, 0), 0)) MIS_AVG_CNT_45_2" ).append("\n"); 
		query.append("                ,GROUPING(A1.COST_ACT_GRP_SEQ)+GROUPING(A3.STND_COST_CD) 			AS LVL " ).append("\n"); 
		query.append("          FROM  COA_COM_COST_PARA A1 " ).append("\n"); 
		query.append("               ,COA_STND_ACCT_V A3 " ).append("\n"); 
		query.append("               ,(SELECT DISTINCT COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                               , COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                               , N1ST_NOD_CD                                               ORG_NOD_CD" ).append("\n"); 
		query.append("                               , COALESCE(N4TH_NOD_CD,N3RD_NOD_CD,N2ND_NOD_CD)             DEST_NOD_CD" ).append("\n"); 
		query.append("                               , DECODE(N1ST_NOD_CD,N2ND_NOD_CD,N1ST_NOD_CD" ).append("\n"); 
		query.append("                                             , DECODE(N1ST_NOD_CD,NULL,' ', N1ST_NOD_CD)" ).append("\n"); 
		query.append("                                             ||DECODE(N2ND_NOD_CD,NULL,' ', ' -> '||N2ND_NOD_CD)" ).append("\n"); 
		query.append("                                             ||DECODE(N3RD_NOD_CD,NULL,' ', ' -> '||N3RD_NOD_CD)" ).append("\n"); 
		query.append("                                             ||DECODE(N4TH_NOD_CD,NULL,' ', ' -> '||N4TH_NOD_CD)) NOD_CD" ).append("\n"); 
		query.append("                   FROM  COA_COM_COST_PARA" ).append("\n"); 
		query.append("                  WHERE  PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("					AND  STND_COST_CD <> '51102001') A4   " ).append("\n"); 
		query.append("          WHERE    A1.PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("                   AND A1.ESTM_USD_TTL_AMT <> 0  " ).append("\n"); 
		query.append("                   AND A3.COA_COST_SRC_PRT_CD IN ('CO','PA')    		-- COA_COST_SRC_PRT_CD:R,P" ).append("\n"); 
		query.append("                   AND A3.STND_COST_TP_CD IN ('C')" ).append("\n"); 
		query.append("                   AND A1.STND_COST_CD = A3.STND_COST_CD " ).append("\n"); 
		query.append("                   AND A3.PA_VW = 'BKG'" ).append("\n"); 
		query.append("                   AND A1.COST_ACT_GRP_SEQ = A4.COST_ACT_GRP_SEQ " ).append("\n"); 
		query.append("--                   AND A1.STND_COST_CD NOT IN ('51102001') MTY 추가해야 함				" ).append("\n"); 
		query.append("          GROUP BY ROLLUP(A1.COST_ACT_GRP_SEQ, A3.SGRP_COST_CD,A3.STND_COST_CD)          " ).append("\n"); 
		query.append("            HAVING GROUPING(A1.COST_ACT_GRP_SEQ)=1 OR A3.SGRP_COST_CD IS NOT NULL" ).append("\n"); 
		query.append("          ORDER BY GROUPING(A1.COST_ACT_GRP_SEQ) DESC, A1.COST_ACT_GRP_SEQ, A3.SGRP_COST_CD, GROUPING(A3.STND_COST_CD) DESC , A3.STND_COST_CD" ).append("\n"); 
		query.append("                   ) " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}