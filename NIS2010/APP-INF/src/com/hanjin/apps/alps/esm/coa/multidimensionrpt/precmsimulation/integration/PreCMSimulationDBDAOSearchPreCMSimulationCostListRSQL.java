/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PreCMSimulationDBDAOSearchPreCMSimulationCostListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreCMSimulationDBDAOSearchPreCMSimulationCostListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA_MON_MISC_REV_PRE_TEU 테이블의 데이터 조회
	  * 2011.12.21 최윤성 [CHM-201115260-01] [COA] Pre CM/OP Simulation화면 U.I 변경요청 - LOC, NOD Chekc 로직 추가
	  * 2011.12.26 최윤성 [CSR전환중] [COA] Pre CM/OP Simulation화면 U.I변경건 Inquiry by BKG / Product Catalog Inquiry 동일 적용요청 - Full Transport Expense 조건 추가
	  * </pre>
	  */
	public PreCMSimulationDBDAOSearchPreCMSimulationCostListRSQL(){
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
		params.put("f_cob_profit_lv",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_g_rev",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cob_profit_vw",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.integration").append("\n"); 
		query.append("FileName : PreCMSimulationDBDAOSearchPreCMSimulationCostListRSQL").append("\n"); 
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
		query.append("SELECT 'Freight Rev'          NOD_CD" ).append("\n"); 
		query.append("       , 1                    COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("       , ''                   GRP" ).append("\n"); 
		query.append("       , ''                   SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("       , ''                   STND_COST_NM" ).append("\n"); 
		query.append("       , TO_NUMBER(@[f_g_rev]) AMT" ).append("\n"); 
		query.append("       , ''                   WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("       , ''                   WTR_DE_TERM_CD" ).append("\n"); 
		query.append("       , 0                    LVL" ).append("\n"); 
		query.append("       , 'N'                  AVG_LVL_CHK" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'DEM/DET'               NOD_CD" ).append("\n"); 
		query.append("       , 2                     COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("       , ''                    GRP" ).append("\n"); 
		query.append("       , ''                    SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("       , ''                    STND_COST_NM" ).append("\n"); 
		query.append("       , SUM(ESTM_USD_TTL_AMT) AMT" ).append("\n"); 
		query.append("       , ''                    WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("       , ''                    WTR_DE_TERM_CD" ).append("\n"); 
		query.append("       , 0                     LVL" ).append("\n"); 
		query.append("       , 'N'                   AVG_LVL_CHK" ).append("\n"); 
		query.append("FROM   COA_COM_COST_PARA" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("AND STND_COST_CD = '43201011'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'SMU'                    NOD_CD" ).append("\n"); 
		query.append("       , 3                      COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("       , ''                     GRP" ).append("\n"); 
		query.append("       , ''                     SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("       , ''                     STND_COST_NM" ).append("\n"); 
		query.append("       , SUM(RESPB_USD_TTL_AMT) AMT" ).append("\n"); 
		query.append("       , ''                     WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("       , ''                     WTR_DE_TERM_CD" ).append("\n"); 
		query.append("       , 0                      LVL" ).append("\n"); 
		query.append("       , 'N'                    AVG_LVL_CHK" ).append("\n"); 
		query.append("FROM   COA_COM_COST_PARA" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("AND STND_COST_CD IN ('92101011','92101012')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'Misc OP Rev'                                    NOD_CD" ).append("\n"); 
		query.append("       , 4                                              COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("       , ''                                             GRP" ).append("\n"); 
		query.append("       , ''                                             SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("       , ''                                             STND_COST_NM" ).append("\n"); 
		query.append("       , DECODE(IS_USE_TRD_UC,'Y',TRD_UC_AMT * CNTR_TEU" ).append("\n"); 
		query.append("                             , RLANE_UC_AMT * CNTR_TEU) AMT" ).append("\n"); 
		query.append("       , ''                                             WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("       , ''                                             WTR_DE_TERM_CD" ).append("\n"); 
		query.append("       , 0                                              LVL" ).append("\n"); 
		query.append("       , 'N'                                            AVG_LVL_CHK" ).append("\n"); 
		query.append("FROM   (SELECT A2.PCTL_NO" ).append("\n"); 
		query.append("               , A2.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("               , A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("               , A2.CNTR_QTY" ).append("\n"); 
		query.append("               , DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1),'2',A2.CNTR_QTY, '3',A2.CNTR_QTY , A2.CNTR_QTY * 2) CNTR_TEU" ).append("\n"); 
		query.append("               , A3.REV_YRMON" ).append("\n"); 
		query.append("               , DECODE(NVL(A1.COST_ROUT_NO,1),1,A1.N1ST_TRD_CD" ).append("\n"); 
		query.append("                                              , 2,A1.N2ND_TRD_CD" ).append("\n"); 
		query.append("                                              , 3,A1.N3RD_TRD_CD" ).append("\n"); 
		query.append("                                              , A1.N4TH_TRD_CD) TRD_CD --a3.trd_cd" ).append("\n"); 
		query.append("               , DECODE(NVL(A1.COST_ROUT_NO,1),1,A1.N1ST_RLANE_CD" ).append("\n"); 
		query.append("                                              , 2,A1.N2ND_RLANE_CD" ).append("\n"); 
		query.append("                                              , 3,A1.N3RD_RLANE_CD" ).append("\n"); 
		query.append("                                              , A1.N4TH_RLANE_CD) RLANE_CD --a3.rlane_cd" ).append("\n"); 
		query.append("               , SUBSTR(DECODE(NVL(COST_ROUT_NO,1),1,A1.N1ST_FINC_VVD_CD" ).append("\n"); 
		query.append("                                                  , 2,A1.N2ND_FINC_VVD_CD" ).append("\n"); 
		query.append("                                                  , 3,A1.N3RD_FINC_VVD_CD" ).append("\n"); 
		query.append("                                                  , A1.N4TH_FINC_VVD_CD)," ).append("\n"); 
		query.append("                        -1) DIR_CD --a3.dir_cd" ).append("\n"); 
		query.append("               , NVL(A3.TRD_UC_AMT,0)                                TRD_UC_AMT" ).append("\n"); 
		query.append("               , NVL(A3.RLANE_UC_AMT,0)                              RLANE_UC_AMT" ).append("\n"); 
		query.append("               , A3.IS_USE_TRD_UC" ).append("\n"); 
		query.append("        FROM   COA_COM_PARA A1" ).append("\n"); 
		query.append("               , COA_COM_COST_PARA A2" ).append("\n"); 
		query.append("               , (SELECT   REV_YRMON" ).append("\n"); 
		query.append("                         , TRD_CD" ).append("\n"); 
		query.append("                         , RLANE_CD" ).append("\n"); 
		query.append("                         , DIR_CD" ).append("\n"); 
		query.append("                         , MAX(TRD_UC_AMT)    TRD_UC_AMT" ).append("\n"); 
		query.append("                         , MAX(RLANE_UC_AMT)  RLANE_UC_AMT" ).append("\n"); 
		query.append("                         , MAX(IS_USE_TRD_UC) IS_USE_TRD_UC" ).append("\n"); 
		query.append("                FROM     (SELECT REV_YRMON" ).append("\n"); 
		query.append("                                 , TRD_CD" ).append("\n"); 
		query.append("                                 , DIR_CD" ).append("\n"); 
		query.append("                                 , DECODE(RLANE_CD,'XXXXX',NULL" ).append("\n"); 
		query.append("                                                  , RLANE_CD) RLANE_CD" ).append("\n"); 
		query.append("                                 , DECODE(RLANE_CD,'XXXXX',ETC_UT_REV_AMT" ).append("\n"); 
		query.append("                                                  , 0) TRD_UC_AMT" ).append("\n"); 
		query.append("                                 , DECODE(RLANE_CD,'XXXXX',0" ).append("\n"); 
		query.append("                                                  , ETC_UT_REV_AMT) RLANE_UC_AMT" ).append("\n"); 
		query.append("                                 , CASE " ).append("\n"); 
		query.append("                                     WHEN ETC_UT_REV_AMT > 100" ).append("\n"); 
		query.append("                                          AND TRD_TTL_QTY < 100" ).append("\n"); 
		query.append("                                     THEN 'Y'" ).append("\n"); 
		query.append("                                     ELSE 'N'" ).append("\n"); 
		query.append("                                   END AS IS_USE_TRD_UC" ).append("\n"); 
		query.append("                          FROM   COA_MON_MISC_REV_PRE_TEU" ).append("\n"); 
		query.append("                          WHERE  REV_YRMON = COA_BZC_COST_YRMON_FNC(''))" ).append("\n"); 
		query.append("                GROUP BY REV_YRMON" ).append("\n"); 
		query.append("                         , TRD_CD" ).append("\n"); 
		query.append("                         , RLANE_CD" ).append("\n"); 
		query.append("                         , DIR_CD) A3" ).append("\n"); 
		query.append("        WHERE  A1.PCTL_NO = A2.PCTL_NO" ).append("\n"); 
		query.append("        AND A2.PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("        AND A2.COA_COST_SRC_CD = '43201011'" ).append("\n"); 
		query.append("        AND A3.REV_YRMON (+)  = COA_BZC_COST_YRMON_FNC('')" ).append("\n"); 
		query.append("        AND A3.TRD_CD (+)  = DECODE(NVL(A1.COST_ROUT_NO,1),1,A1.N1ST_TRD_CD" ).append("\n"); 
		query.append("                                                          , 2,A1.N2ND_TRD_CD" ).append("\n"); 
		query.append("                                                          , 3,A1.N3RD_TRD_CD" ).append("\n"); 
		query.append("                                                          , A1.N4TH_TRD_CD)" ).append("\n"); 
		query.append("        AND A3.RLANE_CD (+)  = DECODE(NVL(A1.COST_ROUT_NO,1),1,A1.N1ST_RLANE_CD" ).append("\n"); 
		query.append("                                                            , 2,A1.N2ND_RLANE_CD" ).append("\n"); 
		query.append("                                                            , 3,A1.N3RD_RLANE_CD" ).append("\n"); 
		query.append("                                                            , A1.N4TH_RLANE_CD)" ).append("\n"); 
		query.append("        AND A3.DIR_CD (+)  = SUBSTR(DECODE(NVL(COST_ROUT_NO,1),1,A1.N1ST_FINC_VVD_CD" ).append("\n"); 
		query.append("                                                              , 2,A1.N2ND_FINC_VVD_CD" ).append("\n"); 
		query.append("                                                              , 3,A1.N3RD_FINC_VVD_CD" ).append("\n"); 
		query.append("                                                              , A1.N4TH_FINC_VVD_CD)," ).append("\n"); 
		query.append("                                    -1))" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'BKG CM'   NOD_CD" ).append("\n"); 
		query.append("       , 5        COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("       , ''       GRP" ).append("\n"); 
		query.append("       , ''       SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("       , ''       STND_COST_NM" ).append("\n"); 
		query.append("       , NULL     AMT" ).append("\n"); 
		query.append("       , ''       WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("       , ''       WTR_DE_TERM_CD" ).append("\n"); 
		query.append("       , 0        LVL" ).append("\n"); 
		query.append("       , 'N'      AVG_LVL_CHK" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'BKG OP'   NOD_CD" ).append("\n"); 
		query.append("       , 6        COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("       , ''       GRP" ).append("\n"); 
		query.append("       , ''       SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("       , ''       STND_COST_NM" ).append("\n"); 
		query.append("       , NULL     AMT" ).append("\n"); 
		query.append("       , ''       WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("       , ''       WTR_DE_TERM_CD" ).append("\n"); 
		query.append("       , 0        LVL" ).append("\n"); 
		query.append("       , 'N'      AVG_LVL_CHK" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'Total Cost'   NOD_CD" ).append("\n"); 
		query.append("       , 7            COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("       , ''           GRP" ).append("\n"); 
		query.append("       , ''           SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("       , ''           STND_COST_NM" ).append("\n"); 
		query.append("       , NULL         AMT" ).append("\n"); 
		query.append("       , ''           WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("       , ''           WTR_DE_TERM_CD" ).append("\n"); 
		query.append("       , 0            LVL" ).append("\n"); 
		query.append("       , 'N'          AVG_LVL_CHK" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT NOD_CD" ).append("\n"); 
		query.append("       , COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("       , GRP" ).append("\n"); 
		query.append("       , SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("       , SUBSTR(STND_COST_NM,3) STND_COST_NM" ).append("\n"); 
		query.append("       , AMT" ).append("\n"); 
		query.append("       , WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("       , WTR_DE_TERM_CD" ).append("\n"); 
		query.append("       , DECODE(LVL,1,1" ).append("\n"); 
		query.append("                   , 2) LVL" ).append("\n"); 
		query.append("       , AVG_LVL_CHK" ).append("\n"); 
		query.append("FROM   (SELECT   NOD                                                        NOD_CD" ).append("\n"); 
		query.append("                 , A2.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                 , A2.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                 , COA_GET_COM_NM_FNC('cost_act_grp_cd',A2.COST_ACT_GRP_CD) GRP" ).append("\n"); 
		query.append("                 , DECODE(A3.STND_COST_CD, '51701011', 'CM2 Cost', A3.SGRP_COST_CD_DESC) SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("                 , A3.ACCT_DP_SEQ||DECODE(A3.STND_COST_CD, '51701011', 'CM2 Cost', A3.STND_COST_NM) STND_COST_NM" ).append("\n"); 
		query.append("                 , DECODE(@[f_cob_profit_vw],'P',SUM(A2.ESTM_USD_TTL_AMT), SUM(A2.RESPB_USD_TTL_AMT)) AMT" ).append("\n"); 
		query.append("                 , A3.STND_COST_TP_CD||A3.COA_COST_SRC_PRT_CD             PR_CM" ).append("\n"); 
		query.append("                 , MAX(A2.WTR_RCV_TERM_CD)                                  WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("                 , MAX(A2.WTR_DE_TERM_CD)                                   WTR_DE_TERM_CD" ).append("\n"); 
		query.append("                 , GROUPING(A3.ACCT_DP_SEQ||DECODE(A3.STND_COST_CD, '51701011', 'CM2 Cost', A3.STND_COST_NM))     LVL" ).append("\n"); 
		query.append("                 , CASE	WHEN REGEXP_LIKE(A2.COST_CALC_RMK, 'AVG-SCC|AVG-ECC|AVG-LCC|AVG-RCC') AND A3.SGRP_COST_CD = 'CVTR' --Full Transport Expense" ).append("\n"); 
		query.append("							THEN 'Y'" ).append("\n"); 
		query.append("							ELSE 'N'" ).append("\n"); 
		query.append("					END  AVG_LVL_CHK" ).append("\n"); 
		query.append("        FROM     COA_COM_COST_PARA A2" ).append("\n"); 
		query.append("                 , COA_STND_ACCT_V A3" ).append("\n"); 
		query.append("                 , (SELECT DISTINCT COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                                  , COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                                  , N1ST_NOD_CD                                               ORG_NOD_CD" ).append("\n"); 
		query.append("                                  , COALESCE(N4TH_NOD_CD,N3RD_NOD_CD,N2ND_NOD_CD)             DEST_NOD_CD" ).append("\n"); 
		query.append("                                  , DECODE(N1ST_NOD_CD,N2ND_NOD_CD,N1ST_NOD_CD" ).append("\n"); 
		query.append("                                                      , DECODE(N1ST_NOD_CD,NULL,' '" ).append("\n"); 
		query.append("                                                                          , N1ST_NOD_CD)" ).append("\n"); 
		query.append("                                                        ||DECODE(N2ND_NOD_CD,NULL,' '" ).append("\n"); 
		query.append("                                                                            , ' -> '" ).append("\n"); 
		query.append("                                                                              ||N2ND_NOD_CD)" ).append("\n"); 
		query.append("                                                        ||DECODE(N3RD_NOD_CD,NULL,' '" ).append("\n"); 
		query.append("                                                                            , ' -> '" ).append("\n"); 
		query.append("                                                                              ||N3RD_NOD_CD)" ).append("\n"); 
		query.append("                                                        ||DECODE(N4TH_NOD_CD,NULL,' '" ).append("\n"); 
		query.append("                                                                            , ' -> '" ).append("\n"); 
		query.append("                                                                              ||N4TH_NOD_CD)) NOD" ).append("\n"); 
		query.append("                  FROM   COA_COM_COST_PARA" ).append("\n"); 
		query.append("                  WHERE  PCTL_NO = @[f_pctl_no]) A4" ).append("\n"); 
		query.append("        WHERE    A2.PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("        AND (A2.ESTM_USD_TTL_AMT <> 0" ).append("\n"); 
		query.append("              OR A2.RESPB_USD_TTL_AMT <> 0)" ).append("\n"); 
		query.append("        AND COA_COST_SRC_PRT_CD IN (DECODE(@[f_cob_profit_lv],'C','CO', 'CO'),DECODE(@[f_cob_profit_vw],'P','PA', 'RA'))" ).append("\n"); 
		query.append("        AND STND_COST_TP_CD IN ('C',DECODE(@[f_cob_profit_lv],'C','C','M','C','O'))" ).append("\n"); 
		query.append("        AND A2.STND_COST_CD = A3.STND_COST_CD" ).append("\n"); 
		query.append("        AND A2.COST_ACT_GRP_SEQ = A4.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("        AND A3.PA_VW = 'BKG'" ).append("\n"); 
		query.append("#if (${f_cob_profit_lv} != 'M') " ).append("\n"); 
		query.append("        AND A2.STND_COST_CD <> '51701011'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY A2.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                 , NOD" ).append("\n"); 
		query.append("                 , A2.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                 , DECODE(A3.STND_COST_CD, '51701011', 'CM2 Cost', A3.SGRP_COST_CD_DESC)" ).append("\n"); 
		query.append("                 , ROLLUP(A3.ACCT_DP_SEQ||DECODE(A3.STND_COST_CD, '51701011', 'CM2 Cost', A3.STND_COST_NM))" ).append("\n"); 
		query.append("                 , A3.STND_COST_TP_CD" ).append("\n"); 
		query.append("                   ||A3.COA_COST_SRC_PRT_CD" ).append("\n"); 
		query.append("                 , CASE	WHEN REGEXP_LIKE(A2.COST_CALC_RMK, 'AVG-SCC|AVG-ECC|AVG-LCC|AVG-RCC')  AND A3.SGRP_COST_CD = 'CVTR'" ).append("\n"); 
		query.append("							THEN 'Y'" ).append("\n"); 
		query.append("							ELSE 'N'" ).append("\n"); 
		query.append("					END  ) " ).append("\n"); 
		query.append("ORDER BY COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("         , SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("         , LVL" ).append("\n"); 
		query.append("         , STND_COST_NM" ).append("\n"); 

	}
}