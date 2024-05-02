/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PreCMSimulationDBDAOSearchPreCMSimulationCostListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.integration;

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
	  * MAS_MON_MISC_REV_PRE_TEU 테이블의 데이터 조회
	  * 2011.12.21 최윤성 [CHM-201115260-01] [MAS] Pre CM/OP Simulation화면 U.I 변경요청 - LOC, NOD Chekc 로직 추가
	  * 2011.12.26 최윤성 [CSR전환중] [MAS] Pre CM/OP Simulation화면 U.I변경건 Inquiry by BKG / Product Catalog Inquiry 동일 적용요청 - Full Transport Expense 조건 추가
	  * 2014.12.30 김시몬 OP 추가
	  * 2015.01.08 OP(Lane) 추가
	  * 2015.01.19 OP QTA BASE로 수정
	  * 2015.02.13 김시몬 OP 제어 OFC 추가
	  * 2015.03.05 김시몬 OP Activity 첫자 소문자에서 대문자로 변경
	  * 2015.03.26 컬럼 속성명 변경으로 수정()
	  * 2015.09.01 김성욱 43201011을 65000000 로 변경 - SOC check 된 경우 DemDet 을 계산에 제외 시키면서 BKG CM 세부 항목이 안나오는 문제 때문에 변경함.
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
		params.put("f_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_cob_profit_lv",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_void_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cob_profit_vw",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.integration").append("\n"); 
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
		query.append("SELECT NOD_CD" ).append("\n"); 
		query.append("       ,COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("       ,GRP" ).append("\n"); 
		query.append("       ,SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("       ,STND_COST_NM" ).append("\n"); 
		query.append("       ,AMT" ).append("\n"); 
		query.append("       ,WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("       ,WTR_DE_TERM_CD" ).append("\n"); 
		query.append("       ,LVL" ).append("\n"); 
		query.append("       ,AVG_LVL_CHK" ).append("\n"); 
		query.append("       ,NVL((SELECT 'Y'" ).append("\n"); 
		query.append("              FROM MAS_OP_EXPT_OFC" ).append("\n"); 
		query.append("             WHERE OFC_CD = @[f_ofc_cd]" ).append("\n"); 
		query.append("           ),'N') AS OP_CHK " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("        SELECT 'Freight Rev'          NOD_CD" ).append("\n"); 
		query.append("               , 1                    COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("               , ''                   GRP" ).append("\n"); 
		query.append("               , ''                   SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("               , ''                   STND_COST_NM" ).append("\n"); 
		query.append("               , TO_NUMBER(@[f_g_rev]) AMT" ).append("\n"); 
		query.append("               , ''                   WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("               , ''                   WTR_DE_TERM_CD" ).append("\n"); 
		query.append("               , 0                    LVL" ).append("\n"); 
		query.append("               , 'N'                  AVG_LVL_CHK" ).append("\n"); 
		query.append("        FROM   DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT 'DEM/DET'               NOD_CD" ).append("\n"); 
		query.append("               , 2                     COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("               , ''                    GRP" ).append("\n"); 
		query.append("               , ''                    SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("               , ''                    STND_COST_NM" ).append("\n"); 
		query.append("               , SUM(ESTM_USD_TTL_AMT) AMT" ).append("\n"); 
		query.append("               , ''                    WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("               , ''                    WTR_DE_TERM_CD" ).append("\n"); 
		query.append("               , 0                     LVL" ).append("\n"); 
		query.append("               , 'N'                   AVG_LVL_CHK" ).append("\n"); 
		query.append("        FROM   MAS_COM_COST_PARA" ).append("\n"); 
		query.append("        WHERE  PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("        AND STND_COST_CD = '43201011'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'SMU'                    NOD_CD" ).append("\n"); 
		query.append("               , 3                      COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("               , ''                     GRP" ).append("\n"); 
		query.append("               , ''                     SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("               , ''                     STND_COST_NM" ).append("\n"); 
		query.append("               , SUM(RESPB_USD_TTL_AMT) AMT" ).append("\n"); 
		query.append("               , ''                     WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("               , ''                     WTR_DE_TERM_CD" ).append("\n"); 
		query.append("               , 0                      LVL" ).append("\n"); 
		query.append("               , 'N'                    AVG_LVL_CHK" ).append("\n"); 
		query.append("        FROM   MAS_COM_COST_PARA" ).append("\n"); 
		query.append("        WHERE  PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("        AND STND_COST_CD IN ('92101011','92101012')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'Misc Rev'                                       NOD_CD" ).append("\n"); 
		query.append("               , 4                                              COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("               , ''                                             GRP" ).append("\n"); 
		query.append("               , ''                                             SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("               , ''                                             STND_COST_NM" ).append("\n"); 
		query.append("               , DECODE(IS_USE_TRD_UC,'Y',TRD_UC_AMT * CNTR_TEU" ).append("\n"); 
		query.append("                                     , RLANE_UC_AMT * CNTR_TEU) AMT" ).append("\n"); 
		query.append("               , ''                                             WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("               , ''                                             WTR_DE_TERM_CD" ).append("\n"); 
		query.append("               , 0                                              LVL" ).append("\n"); 
		query.append("               , 'N'                                            AVG_LVL_CHK" ).append("\n"); 
		query.append("        FROM   (SELECT A2.PCTL_NO" ).append("\n"); 
		query.append("                       , A2.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                       , A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                       , A2.CNTR_QTY" ).append("\n"); 
		query.append("                       , DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1),'2',A2.CNTR_QTY, '3',A2.CNTR_QTY , A2.CNTR_QTY * 2) CNTR_TEU" ).append("\n"); 
		query.append("                       , A3.REV_YRMON" ).append("\n"); 
		query.append("                       , DECODE(NVL(A1.COST_ROUT_NO,1),1,A1.N1ST_TRD_CD" ).append("\n"); 
		query.append("                                                      , 2,A1.N2ND_TRD_CD" ).append("\n"); 
		query.append("                                                      , 3,A1.N3RD_TRD_CD" ).append("\n"); 
		query.append("                                                      , A1.N4TH_TRD_CD) TRD_CD --a3.trd_cd" ).append("\n"); 
		query.append("                       , DECODE(NVL(A1.COST_ROUT_NO,1),1,A1.N1ST_RLANE_CD" ).append("\n"); 
		query.append("                                                      , 2,A1.N2ND_RLANE_CD" ).append("\n"); 
		query.append("                                                      , 3,A1.N3RD_RLANE_CD" ).append("\n"); 
		query.append("                                                      , A1.N4TH_RLANE_CD) RLANE_CD --a3.rlane_cd" ).append("\n"); 
		query.append("                       , SUBSTR(DECODE(NVL(COST_ROUT_NO,1),1,A1.N1ST_FINC_VVD_CD" ).append("\n"); 
		query.append("                                                          , 2,A1.N2ND_FINC_VVD_CD" ).append("\n"); 
		query.append("                                                          , 3,A1.N3RD_FINC_VVD_CD" ).append("\n"); 
		query.append("                                                          , A1.N4TH_FINC_VVD_CD)," ).append("\n"); 
		query.append("                                -1) DIR_CD --a3.dir_cd" ).append("\n"); 
		query.append("                       , NVL(A3.TRD_UC_AMT,0)                                TRD_UC_AMT" ).append("\n"); 
		query.append("                       , NVL(A3.RLANE_UC_AMT,0)                              RLANE_UC_AMT" ).append("\n"); 
		query.append("                       , A3.IS_USE_TRD_UC" ).append("\n"); 
		query.append("                FROM   MAS_COM_PARA A1" ).append("\n"); 
		query.append("                       , MAS_COM_COST_PARA A2" ).append("\n"); 
		query.append("                       , (SELECT   REV_YRMON" ).append("\n"); 
		query.append("                                 , TRD_CD" ).append("\n"); 
		query.append("                                 , RLANE_CD" ).append("\n"); 
		query.append("                                 , DIR_CD" ).append("\n"); 
		query.append("                                 , MAX(TRD_UC_AMT)    TRD_UC_AMT" ).append("\n"); 
		query.append("                                 , MAX(RLANE_UC_AMT)  RLANE_UC_AMT" ).append("\n"); 
		query.append("                                 , MAX(IS_USE_TRD_UC) IS_USE_TRD_UC" ).append("\n"); 
		query.append("                        FROM     (SELECT REV_YRMON" ).append("\n"); 
		query.append("                                         , TRD_CD" ).append("\n"); 
		query.append("                                         , DIR_CD" ).append("\n"); 
		query.append("                                         , DECODE(RLANE_CD,'XXXXX',NULL" ).append("\n"); 
		query.append("                                                          , RLANE_CD) RLANE_CD" ).append("\n"); 
		query.append("                                         , DECODE(RLANE_CD,'XXXXX',ETC_UT_REV_AMT" ).append("\n"); 
		query.append("                                                          , 0) TRD_UC_AMT" ).append("\n"); 
		query.append("                                         , DECODE(RLANE_CD,'XXXXX',0" ).append("\n"); 
		query.append("                                                          , ETC_UT_REV_AMT) RLANE_UC_AMT" ).append("\n"); 
		query.append("                                         , CASE " ).append("\n"); 
		query.append("                                             WHEN ETC_UT_REV_AMT > 100" ).append("\n"); 
		query.append("                                                  AND TRD_TTL_QTY < 100" ).append("\n"); 
		query.append("                                             THEN 'Y'" ).append("\n"); 
		query.append("                                             ELSE 'N'" ).append("\n"); 
		query.append("                                           END AS IS_USE_TRD_UC" ).append("\n"); 
		query.append("                                  FROM   MAS_MON_MISC_REV_PRE_TEU" ).append("\n"); 
		query.append("                                  WHERE  REV_YRMON = MAS_BZC_COST_YRMON_FNC(''))" ).append("\n"); 
		query.append("                        GROUP BY REV_YRMON" ).append("\n"); 
		query.append("                                 , TRD_CD" ).append("\n"); 
		query.append("                                 , RLANE_CD" ).append("\n"); 
		query.append("                                 , DIR_CD) A3" ).append("\n"); 
		query.append("                WHERE  A1.PCTL_NO = A2.PCTL_NO" ).append("\n"); 
		query.append("                AND A2.PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("--                AND A2.MAS_COST_SRC_CD = '43201011' -- 아래로 수정 2015.09.01" ).append("\n"); 
		query.append("                AND A2.MAS_COST_SRC_CD = '65000000'" ).append("\n"); 
		query.append("                AND A3.REV_YRMON (+)  = MAS_BZC_COST_YRMON_FNC('')" ).append("\n"); 
		query.append("                AND A3.TRD_CD (+)  = DECODE(NVL(A1.COST_ROUT_NO,1),1,A1.N1ST_TRD_CD" ).append("\n"); 
		query.append("                                                                  , 2,A1.N2ND_TRD_CD" ).append("\n"); 
		query.append("                                                                  , 3,A1.N3RD_TRD_CD" ).append("\n"); 
		query.append("                                                                  , A1.N4TH_TRD_CD)" ).append("\n"); 
		query.append("                AND A3.RLANE_CD (+)  = DECODE(NVL(A1.COST_ROUT_NO,1),1,A1.N1ST_RLANE_CD" ).append("\n"); 
		query.append("                                                                    , 2,A1.N2ND_RLANE_CD" ).append("\n"); 
		query.append("                                                                    , 3,A1.N3RD_RLANE_CD" ).append("\n"); 
		query.append("                                                                    , A1.N4TH_RLANE_CD)" ).append("\n"); 
		query.append("                AND A3.DIR_CD (+)  = SUBSTR(DECODE(NVL(COST_ROUT_NO,1),1,A1.N1ST_FINC_VVD_CD" ).append("\n"); 
		query.append("                                                                      , 2,A1.N2ND_FINC_VVD_CD" ).append("\n"); 
		query.append("                                                                      , 3,A1.N3RD_FINC_VVD_CD" ).append("\n"); 
		query.append("                                                                      , A1.N4TH_FINC_VVD_CD)," ).append("\n"); 
		query.append("                                            -1))" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'CM'   NOD_CD" ).append("\n"); 
		query.append("               , 1000     COST_ACT_GRP_SEQ --5를 1000 으로 변경" ).append("\n"); 
		query.append("               , ''       GRP" ).append("\n"); 
		query.append("               , ''       SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("               , ''       STND_COST_NM" ).append("\n"); 
		query.append("               , NULL     AMT" ).append("\n"); 
		query.append("               , ''       WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("               , ''       WTR_DE_TERM_CD" ).append("\n"); 
		query.append("               , 0        LVL" ).append("\n"); 
		query.append("               , 'N'      AVG_LVL_CHK" ).append("\n"); 
		query.append("        FROM   DUAL" ).append("\n"); 
		query.append("        --UNION ALL" ).append("\n"); 
		query.append("        --SELECT 'CM(BKG)'   NOD_CD" ).append("\n"); 
		query.append("        --       , 1001     COST_ACT_GRP_SEQ --5를 1000 으로 변경" ).append("\n"); 
		query.append("        --       , ''       GRP" ).append("\n"); 
		query.append("        --       , ''       SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("        --       , ''       STND_COST_NM" ).append("\n"); 
		query.append("        --       , NULL     AMT" ).append("\n"); 
		query.append("        --       , ''       WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("        --       , ''       WTR_DE_TERM_CD" ).append("\n"); 
		query.append("        --       , 0        LVL" ).append("\n"); 
		query.append("        --       , 'N'      AVG_LVL_CHK" ).append("\n"); 
		query.append("        --FROM   DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'BKG OP'   NOD_CD" ).append("\n"); 
		query.append("               , 1010     COST_ACT_GRP_SEQ --6을 1010 으로 변경" ).append("\n"); 
		query.append("               , 'Excluding Vessel Interest'       GRP" ).append("\n"); 
		query.append("               , '' AS  SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("               , ''       STND_COST_NM" ).append("\n"); 
		query.append("               , NULL     AMT" ).append("\n"); 
		query.append("               , ''       WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("               , ''       WTR_DE_TERM_CD" ).append("\n"); 
		query.append("               , 0        LVL" ).append("\n"); 
		query.append("               , 'N'      AVG_LVL_CHK" ).append("\n"); 
		query.append("        FROM   DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'BKG OP(Lane)'   NOD_CD" ).append("\n"); 
		query.append("               , 1020     COST_ACT_GRP_SEQ --6을 1010 으로 변경" ).append("\n"); 
		query.append("               , 'Including Vessel Interest'       GRP" ).append("\n"); 
		query.append("               , ''  AS  SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("               , ''       STND_COST_NM" ).append("\n"); 
		query.append("               , NULL     AMT" ).append("\n"); 
		query.append("               , ''       WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("               , ''       WTR_DE_TERM_CD" ).append("\n"); 
		query.append("               , 0        LVL" ).append("\n"); 
		query.append("               , 'N'      AVG_LVL_CHK" ).append("\n"); 
		query.append("        FROM   DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'Total Cost'   NOD_CD" ).append("\n"); 
		query.append("               , 1005            COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("               , ''           GRP" ).append("\n"); 
		query.append("               , ''           SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("               , ''           STND_COST_NM" ).append("\n"); 
		query.append("               , NULL         AMT" ).append("\n"); 
		query.append("               , ''           WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("               , ''           WTR_DE_TERM_CD" ).append("\n"); 
		query.append("               , 0            LVL" ).append("\n"); 
		query.append("               , 'N'          AVG_LVL_CHK" ).append("\n"); 
		query.append("        FROM   DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT NOD_CD" ).append("\n"); 
		query.append("               , COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("               , GRP" ).append("\n"); 
		query.append("               , SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("               , SUBSTR(STND_COST_NM,3) STND_COST_NM" ).append("\n"); 
		query.append("               , AMT" ).append("\n"); 
		query.append("               , WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("               , WTR_DE_TERM_CD" ).append("\n"); 
		query.append("               , DECODE(LVL,1,1" ).append("\n"); 
		query.append("                           , 2) LVL" ).append("\n"); 
		query.append("               , AVG_LVL_CHK" ).append("\n"); 
		query.append("        FROM   (SELECT   NOD                                                        NOD_CD" ).append("\n"); 
		query.append("                         , A2.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                         , A2.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                         , MAS_GET_COM_NM_FNC('cost_act_grp_cd',A2.COST_ACT_GRP_CD) GRP" ).append("\n"); 
		query.append("                         , DECODE(A3.STND_COST_CD, '51701011', 'CM2 Cost', A3.SGRP_COST_CD_DESC) SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("                         , A3.ACCT_DP_SEQ||DECODE(A3.STND_COST_CD, '51701011', 'CM2 Cost', A3.STND_COST_NM) STND_COST_NM" ).append("\n"); 
		query.append("                         , DECODE(@[f_cob_profit_vw],'P',SUM(A2.ESTM_USD_TTL_AMT), SUM(A2.RESPB_USD_TTL_AMT)) AMT" ).append("\n"); 
		query.append("                         , A3.STND_COST_TP_CD||A3.MAS_COST_SRC_PRT_CD             PR_CM" ).append("\n"); 
		query.append("                         , MAX(A2.WTR_RCV_TERM_CD)                                  WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("                         , MAX(A2.WTR_DE_TERM_CD)                                   WTR_DE_TERM_CD" ).append("\n"); 
		query.append("                         , GROUPING(A3.ACCT_DP_SEQ||DECODE(A3.STND_COST_CD, '51701011', 'CM2 Cost', A3.STND_COST_NM))     LVL" ).append("\n"); 
		query.append("                         , CASE	WHEN REGEXP_LIKE(A2.COST_CALC_RMK, 'AVG-SCC|AVG-ECC|AVG-LCC|AVG-RCC') AND A3.SGRP_COST_CD = 'CVTR' --Full Transport Expense" ).append("\n"); 
		query.append("        							THEN 'Y'" ).append("\n"); 
		query.append("        							ELSE 'N'" ).append("\n"); 
		query.append("        					END  AVG_LVL_CHK" ).append("\n"); 
		query.append("                FROM     MAS_COM_COST_PARA A2" ).append("\n"); 
		query.append("                         , MAS_STND_ACCT_V A3" ).append("\n"); 
		query.append("                         , (SELECT DISTINCT COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                                          , COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                                          , N1ST_NOD_CD                                               ORG_NOD_CD" ).append("\n"); 
		query.append("                                          , COALESCE(N4TH_NOD_CD,N3RD_NOD_CD,N2ND_NOD_CD)             DEST_NOD_CD" ).append("\n"); 
		query.append("                                          , DECODE(N1ST_NOD_CD,N2ND_NOD_CD,N1ST_NOD_CD" ).append("\n"); 
		query.append("                                                              , DECODE(N1ST_NOD_CD,NULL,' '" ).append("\n"); 
		query.append("                                                                                  , N1ST_NOD_CD)" ).append("\n"); 
		query.append("                                                                ||DECODE(N2ND_NOD_CD,NULL,' '" ).append("\n"); 
		query.append("                                                                                    , ' -> '" ).append("\n"); 
		query.append("                                                                                      ||N2ND_NOD_CD)" ).append("\n"); 
		query.append("                                                                ||DECODE(N3RD_NOD_CD,NULL,' '" ).append("\n"); 
		query.append("                                                                                    , ' -> '" ).append("\n"); 
		query.append("                                                                                      ||N3RD_NOD_CD)" ).append("\n"); 
		query.append("                                                                ||DECODE(N4TH_NOD_CD,NULL,' '" ).append("\n"); 
		query.append("                                                                                    , ' -> '" ).append("\n"); 
		query.append("                                                                                      ||N4TH_NOD_CD)) NOD" ).append("\n"); 
		query.append("                          FROM   MAS_COM_COST_PARA" ).append("\n"); 
		query.append("                          WHERE  PCTL_NO = @[f_pctl_no]) A4" ).append("\n"); 
		query.append("                WHERE    A2.PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("                AND (A2.ESTM_USD_TTL_AMT <> 0" ).append("\n"); 
		query.append("                      OR A2.RESPB_USD_TTL_AMT <> 0)" ).append("\n"); 
		query.append("                AND MAS_COST_SRC_PRT_CD IN (DECODE(@[f_cob_profit_lv],'C','CO', 'CO'),DECODE(@[f_cob_profit_vw],'P','PA', 'RA'))" ).append("\n"); 
		query.append("                AND STND_COST_TP_CD IN ('C',DECODE(@[f_cob_profit_lv],'C','C','M','C','O'))" ).append("\n"); 
		query.append("                AND A2.STND_COST_CD = A3.STND_COST_CD" ).append("\n"); 
		query.append("                AND A2.COST_ACT_GRP_SEQ = A4.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                AND A3.PA_VW = 'BKG'" ).append("\n"); 
		query.append("        #if (${f_cob_profit_lv} != 'M') " ).append("\n"); 
		query.append("                AND A2.STND_COST_CD <> '51701011'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                GROUP BY A2.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                         , NOD" ).append("\n"); 
		query.append("                         , A2.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                         , DECODE(A3.STND_COST_CD, '51701011', 'CM2 Cost', A3.SGRP_COST_CD_DESC)" ).append("\n"); 
		query.append("                         , ROLLUP(A3.ACCT_DP_SEQ||DECODE(A3.STND_COST_CD, '51701011', 'CM2 Cost', A3.STND_COST_NM))" ).append("\n"); 
		query.append("                         , A3.STND_COST_TP_CD" ).append("\n"); 
		query.append("                           ||A3.MAS_COST_SRC_PRT_CD" ).append("\n"); 
		query.append("                         , CASE	WHEN REGEXP_LIKE(A2.COST_CALC_RMK, 'AVG-SCC|AVG-ECC|AVG-LCC|AVG-RCC')  AND A3.SGRP_COST_CD = 'CVTR'" ).append("\n"); 
		query.append("        							THEN 'Y'" ).append("\n"); 
		query.append("        							ELSE 'N'" ).append("\n"); 
		query.append("        					END  ) " ).append("\n"); 
		query.append("        --ORDER BY COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("        --         , SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("        --         , LVL" ).append("\n"); 
		query.append("        --         , STND_COST_NM" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT NOD_CD" ).append("\n"); 
		query.append("               , COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("               , GRP" ).append("\n"); 
		query.append("               , SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("               , SUBSTR(STND_COST_NM,5) STND_COST_NM" ).append("\n"); 
		query.append("               , AMT" ).append("\n"); 
		query.append("               , WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("               , WTR_DE_TERM_CD" ).append("\n"); 
		query.append("               , DECODE(LVL,1,1, 2) LVL" ).append("\n"); 
		query.append("               , AVG_LVL_CHK " ).append("\n"); 
		query.append("          FROM ( " ).append("\n"); 
		query.append("                SELECT   '' as NOD_CD" ).append("\n"); 
		query.append("                       , D2.ACCT_DP_SEQ        AS COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                       , D2.MGRP_COST_CD_DESC  AS GRP" ).append("\n"); 
		query.append("                       , D2.MGRP_COST_CD_DESC  AS SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("                       , D2.ACCT_DP_SEQ||D2.STND_COST_NM  AS STND_COST_NM" ).append("\n"); 
		query.append("                       , SUM(D1.TEU_UC_AMT * (D3.CNTR_TEU + @[f_void_qty])) AS AMT" ).append("\n"); 
		query.append("                       , ''       WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("                       , ''       WTR_DE_TERM_CD" ).append("\n"); 
		query.append("                       , GROUPING(D2.ACCT_DP_SEQ||D2.STND_COST_NM) AS LVL" ).append("\n"); 
		query.append("                       , 'Y'      AVG_LVL_CHK" ).append("\n"); 
		query.append("                  FROM MAS_STND_UT_COST D1," ).append("\n"); 
		query.append("                       (" ).append("\n"); 
		query.append("                        SELECT A.MGRP_COST_CD,A.MGRP_COST_CD_DESC," ).append("\n"); 
		query.append("                               B.SGRP_COST_CD,B.SGRP_COST_CD_DESC," ).append("\n"); 
		query.append("                               C.STND_COST_CD,C.STND_COST_NM,C.PERF_VW_CD," ).append("\n"); 
		query.append("                               DECODE(A.MGRP_COST_CD,'OV',1001,'VF',1002,'OF',1003,'GE',1004) AS ACCT_DP_SEQ" ).append("\n"); 
		query.append("                          FROM MAS_MN_GRP_COST  A," ).append("\n"); 
		query.append("                               MAS_SUB_GRP_COST B," ).append("\n"); 
		query.append("                               MAS_STND_ACCT    C" ).append("\n"); 
		query.append("                         WHERE A.MGRP_COST_CD = B.MGRP_COST_CD" ).append("\n"); 
		query.append("                           AND A.MGRP_COST_CD = C.MGRP_COST_CD" ).append("\n"); 
		query.append("                           AND B.SGRP_COST_CD = C.SGRP_COST_CD" ).append("\n"); 
		query.append("                           AND A.MGRP_COST_CD IN ('OF','OV','GE','VF') " ).append("\n"); 
		query.append("                       ) D2," ).append("\n"); 
		query.append("                       (SELECT SUBSTR(COST_YRQ,1,4) AS COST_YR," ).append("\n"); 
		query.append("                               SUBSTR(COST_YRQ,5,2) AS BSE_QTR_CD," ).append("\n"); 
		query.append("                               TRD_CD," ).append("\n"); 
		query.append("                               SUB_TRD_CD," ).append("\n"); 
		query.append("                               RLANE_CD," ).append("\n"); 
		query.append("                               DIR_CD," ).append("\n"); 
		query.append("                               STND_COST_CD," ).append("\n"); 
		query.append("                               CNTR_TEU," ).append("\n"); 
		query.append("                               GEN_FLG" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT COST_YRQ," ).append("\n"); 
		query.append("                                       TRD_CD," ).append("\n"); 
		query.append("                                       SUB_TRD_CD," ).append("\n"); 
		query.append("                                       RLANE_CD," ).append("\n"); 
		query.append("                                       DIR_CD," ).append("\n"); 
		query.append("                                       STND_COST_CD," ).append("\n"); 
		query.append("                                       CNTR_TEU," ).append("\n"); 
		query.append("                                       GEN_FLG," ).append("\n"); 
		query.append("                                       R_CNT," ).append("\n"); 
		query.append("                                       MIN(R_CNT) OVER() AS MIN_R_CNT" ).append("\n"); 
		query.append("                                  FROM (                       " ).append("\n"); 
		query.append("                                        SELECT MAX(D3.COST_YR||D3.BSE_QTR_CD) AS COST_YRQ,D3.TRD_CD,D3.SUB_TRD_CD,D3.RLANE_CD,D3.DIR_CD,D3.STND_COST_CD, D2.CNTR_TEU,D2.GEN_FLG, 1 AS R_CNT" ).append("\n"); 
		query.append("                                          FROM MAS_STND_UT_COST D3," ).append("\n"); 
		query.append("                                               (" ).append("\n"); 
		query.append("                                                SELECT DISTINCT TRD_CD," ).append("\n"); 
		query.append("                                                       RLANE_CD," ).append("\n"); 
		query.append("                                                       DIR_CD," ).append("\n"); 
		query.append("                                                       CNTR_TEU," ).append("\n"); 
		query.append("                                                       DECODE(FLG,COST_ROUT_NO,'Y','N') AS GEN_FLG" ).append("\n"); 
		query.append("                                                  FROM (" ).append("\n"); 
		query.append("                                                        SELECT 1 AS FLG," ).append("\n"); 
		query.append("                                                               A1.PCTL_NO," ).append("\n"); 
		query.append("                                                               A1.N1ST_TRD_CD    AS TRD_CD," ).append("\n"); 
		query.append("                                                               A1.N1ST_RLANE_CD  AS RLANE_CD," ).append("\n"); 
		query.append("                                                               SUBSTR(A1.N1ST_FINC_VVD_CD,-1) AS DIR_CD," ).append("\n"); 
		query.append("                                                               NVL(A1.COST_ROUT_NO,1) AS COST_ROUT_NO," ).append("\n"); 
		query.append("                                                               DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1),'2',A2.CNTR_QTY, '3',A2.CNTR_QTY , A2.CNTR_QTY * 2) AS CNTR_TEU" ).append("\n"); 
		query.append("                                                          FROM MAS_COM_PARA A1," ).append("\n"); 
		query.append("                                                               MAS_COM_COST_PARA A2" ).append("\n"); 
		query.append("                                                         WHERE A1.PCTL_NO = A2.PCTL_NO" ).append("\n"); 
		query.append("                                                           AND A2.PCTL_NO = @[f_pctl_no] --'T1412240554189010006'" ).append("\n"); 
		query.append("--                                                         AND A2.MAS_COST_SRC_CD = '43201011' --아래로 수정 2015.09.01" ).append("\n"); 
		query.append("                                                           AND A2.MAS_COST_SRC_CD = DECODE( SOC_FLG  , 'Y', '65000000', '43201011')" ).append("\n"); 
		query.append("                                                    " ).append("\n"); 
		query.append("                                                        UNION ALL" ).append("\n"); 
		query.append("                                                    " ).append("\n"); 
		query.append("                                                        SELECT 2 AS FLG," ).append("\n"); 
		query.append("                                                               A1.PCTL_NO," ).append("\n"); 
		query.append("                                                               A1.N2ND_TRD_CD    AS TRD_CD," ).append("\n"); 
		query.append("                                                               A1.N2ND_RLANE_CD  AS RLANE_CD," ).append("\n"); 
		query.append("                                                               SUBSTR(A1.N2ND_FINC_VVD_CD,-1) AS DIR_CD," ).append("\n"); 
		query.append("                                                               NVL(A1.COST_ROUT_NO,1) AS COST_ROUT_NO," ).append("\n"); 
		query.append("                                                               DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1),'2',A2.CNTR_QTY, '3',A2.CNTR_QTY , A2.CNTR_QTY * 2) AS CNTR_TEU" ).append("\n"); 
		query.append("                                                          FROM MAS_COM_PARA A1," ).append("\n"); 
		query.append("                                                               MAS_COM_COST_PARA A2" ).append("\n"); 
		query.append("                                                         WHERE A1.PCTL_NO = A2.PCTL_NO" ).append("\n"); 
		query.append("                                                           AND A2.PCTL_NO = @[f_pctl_no] --'T1412240554189010006'" ).append("\n"); 
		query.append("--                                                         AND A2.MAS_COST_SRC_CD = '43201011' --아래로 수정 2015.09.01" ).append("\n"); 
		query.append("                                                           AND A2.MAS_COST_SRC_CD = DECODE( SOC_FLG  , 'Y', '65000000', '43201011')" ).append("\n"); 
		query.append("                                                           AND A1.N2ND_TRD_CD IS NOT NULL      " ).append("\n"); 
		query.append("                                                    " ).append("\n"); 
		query.append("                                                        UNION ALL" ).append("\n"); 
		query.append("                                                       " ).append("\n"); 
		query.append("                                                        SELECT 3 AS FLG," ).append("\n"); 
		query.append("                                                               A1.PCTL_NO," ).append("\n"); 
		query.append("                                                               A1.N3RD_TRD_CD    AS TRD_CD," ).append("\n"); 
		query.append("                                                               A1.N3RD_RLANE_CD  AS RLANE_CD," ).append("\n"); 
		query.append("                                                               SUBSTR(A1.N3RD_FINC_VVD_CD,-1) AS DIR_CD," ).append("\n"); 
		query.append("                                                               NVL(A1.COST_ROUT_NO,1) AS COST_ROUT_NO," ).append("\n"); 
		query.append("                                                               DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1),'2',A2.CNTR_QTY, '3',A2.CNTR_QTY , A2.CNTR_QTY * 2) AS CNTR_TEU" ).append("\n"); 
		query.append("                                                          FROM MAS_COM_PARA A1," ).append("\n"); 
		query.append("                                                               MAS_COM_COST_PARA A2" ).append("\n"); 
		query.append("                                                         WHERE A1.PCTL_NO = A2.PCTL_NO" ).append("\n"); 
		query.append("                                                           AND A2.PCTL_NO = @[f_pctl_no] --'T1412240554189010006'" ).append("\n"); 
		query.append("--                                                         AND A2.MAS_COST_SRC_CD = '43201011'--아래로 수정 2015.09.01" ).append("\n"); 
		query.append("                                                           AND A2.MAS_COST_SRC_CD = DECODE( SOC_FLG  , 'Y', '65000000', '43201011')" ).append("\n"); 
		query.append("                                                           AND A1.N3RD_TRD_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                    " ).append("\n"); 
		query.append("                                                        UNION ALL" ).append("\n"); 
		query.append("                                                       " ).append("\n"); 
		query.append("                                                        SELECT 4 AS FLG," ).append("\n"); 
		query.append("                                                               A1.PCTL_NO," ).append("\n"); 
		query.append("                                                               A1.N4TH_TRD_CD    AS TRD_CD," ).append("\n"); 
		query.append("                                                               A1.N4TH_RLANE_CD  AS RLANE_CD," ).append("\n"); 
		query.append("                                                               SUBSTR(A1.N4TH_FINC_VVD_CD,-1) AS DIR_CD," ).append("\n"); 
		query.append("                                                               NVL(A1.COST_ROUT_NO,1) AS COST_ROUT_NO," ).append("\n"); 
		query.append("                                                               DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1),'2',A2.CNTR_QTY, '3',A2.CNTR_QTY , A2.CNTR_QTY * 2) AS CNTR_TEU" ).append("\n"); 
		query.append("                                                          FROM MAS_COM_PARA A1," ).append("\n"); 
		query.append("                                                               MAS_COM_COST_PARA A2" ).append("\n"); 
		query.append("                                                         WHERE A1.PCTL_NO = A2.PCTL_NO" ).append("\n"); 
		query.append("                                                           AND A2.PCTL_NO = @[f_pctl_no] --'T1412240554189010006'" ).append("\n"); 
		query.append("--                                                         AND A2.MAS_COST_SRC_CD = '43201011'--아래로 수정 2015.09.01" ).append("\n"); 
		query.append("                                                           AND A2.MAS_COST_SRC_CD = DECODE( SOC_FLG  , 'Y', '65000000', '43201011')" ).append("\n"); 
		query.append("                                                           AND A1.N4TH_TRD_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                      )" ).append("\n"); 
		query.append("                                                WHERE DECODE(TRD_CD,'AES',FLG,'TPS',FLG,'TAS',FLG,'EMS',FLG,COST_ROUT_NO) = COST_ROUT_NO" ).append("\n"); 
		query.append("                                               ) D2 " ).append("\n"); 
		query.append("                                         WHERE D2.TRD_CD   = D3.TRD_CD" ).append("\n"); 
		query.append("                                           AND D2.RLANE_CD = D3.RLANE_CD" ).append("\n"); 
		query.append("                                           AND D2.DIR_CD   = D3.DIR_CD" ).append("\n"); 
		query.append("                                           AND D3.TEU_UC_AMT <> 0" ).append("\n"); 
		query.append("                                         GROUP BY D3.TRD_CD,D3.SUB_TRD_CD,D3.RLANE_CD,D3.DIR_CD,D3.STND_COST_CD, D2.CNTR_TEU, D2.GEN_FLG" ).append("\n"); 
		query.append("                                       " ).append("\n"); 
		query.append("                                        UNION ALL" ).append("\n"); 
		query.append("                                        SELECT MAX(D3.COST_YR||D3.BSE_QTR_CD) AS COST_YRQ,D3.TRD_CD,D3.SUB_TRD_CD,D3.RLANE_CD,D3.DIR_CD,D3.STND_COST_CD, D2.CNTR_TEU,D2.GEN_FLG, 2 AS R_CNT" ).append("\n"); 
		query.append("                                          FROM MAS_STND_UT_COST D3," ).append("\n"); 
		query.append("                                               (" ).append("\n"); 
		query.append("                                                SELECT DISTINCT TRD_CD," ).append("\n"); 
		query.append("                                                       RLANE_CD," ).append("\n"); 
		query.append("                                                       DIR_CD," ).append("\n"); 
		query.append("                                                       CNTR_TEU," ).append("\n"); 
		query.append("                                                       DECODE(FLG,COST_ROUT_NO,'Y','N') AS GEN_FLG" ).append("\n"); 
		query.append("                                                  FROM (" ).append("\n"); 
		query.append("                                                        SELECT 1 AS FLG," ).append("\n"); 
		query.append("                                                               A1.PCTL_NO," ).append("\n"); 
		query.append("                                                               A1.N1ST_TRD_CD    AS TRD_CD," ).append("\n"); 
		query.append("                                                               A1.N1ST_RLANE_CD  AS RLANE_CD," ).append("\n"); 
		query.append("                                                               SUBSTR(A1.N1ST_FINC_VVD_CD,-1) AS DIR_CD," ).append("\n"); 
		query.append("                                                               NVL(A1.COST_ROUT_NO,1) AS COST_ROUT_NO," ).append("\n"); 
		query.append("                                                               DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1),'2',A2.CNTR_QTY, '3',A2.CNTR_QTY , A2.CNTR_QTY * 2) AS CNTR_TEU" ).append("\n"); 
		query.append("                                                          FROM MAS_COM_PARA A1," ).append("\n"); 
		query.append("                                                               MAS_COM_COST_PARA A2" ).append("\n"); 
		query.append("                                                         WHERE A1.PCTL_NO = A2.PCTL_NO" ).append("\n"); 
		query.append("                                                           AND A2.PCTL_NO = @[f_pctl_no] --'T1412240554189010006'" ).append("\n"); 
		query.append("--                                                         AND A2.MAS_COST_SRC_CD = '43201011'--아래로 수정 2015.09.01" ).append("\n"); 
		query.append("                                                           AND A2.MAS_COST_SRC_CD = DECODE( SOC_FLG  , 'Y', '65000000', '43201011')" ).append("\n"); 
		query.append("                                                    " ).append("\n"); 
		query.append("                                                        UNION ALL" ).append("\n"); 
		query.append("                                                    " ).append("\n"); 
		query.append("                                                        SELECT 2 AS FLG," ).append("\n"); 
		query.append("                                                               A1.PCTL_NO," ).append("\n"); 
		query.append("                                                               A1.N2ND_TRD_CD    AS TRD_CD," ).append("\n"); 
		query.append("                                                               A1.N2ND_RLANE_CD  AS RLANE_CD," ).append("\n"); 
		query.append("                                                               SUBSTR(A1.N2ND_FINC_VVD_CD,-1) AS DIR_CD," ).append("\n"); 
		query.append("                                                               NVL(A1.COST_ROUT_NO,1) AS COST_ROUT_NO," ).append("\n"); 
		query.append("                                                               DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1),'2',A2.CNTR_QTY, '3',A2.CNTR_QTY , A2.CNTR_QTY * 2) AS CNTR_TEU" ).append("\n"); 
		query.append("                                                          FROM MAS_COM_PARA A1," ).append("\n"); 
		query.append("                                                               MAS_COM_COST_PARA A2" ).append("\n"); 
		query.append("                                                         WHERE A1.PCTL_NO = A2.PCTL_NO" ).append("\n"); 
		query.append("                                                           AND A2.PCTL_NO = @[f_pctl_no] --'T1412240554189010006'" ).append("\n"); 
		query.append("--                                                         AND A2.MAS_COST_SRC_CD = '43201011'--아래로 수정 2015.09.01" ).append("\n"); 
		query.append("                                                           AND A2.MAS_COST_SRC_CD = DECODE( SOC_FLG  , 'Y', '65000000', '43201011')" ).append("\n"); 
		query.append("                                                           AND A1.N2ND_TRD_CD IS NOT NULL      " ).append("\n"); 
		query.append("                                                    " ).append("\n"); 
		query.append("                                                        UNION ALL" ).append("\n"); 
		query.append("                                                       " ).append("\n"); 
		query.append("                                                        SELECT 3 AS FLG," ).append("\n"); 
		query.append("                                                               A1.PCTL_NO," ).append("\n"); 
		query.append("                                                               A1.N3RD_TRD_CD    AS TRD_CD," ).append("\n"); 
		query.append("                                                               A1.N3RD_RLANE_CD  AS RLANE_CD," ).append("\n"); 
		query.append("                                                               SUBSTR(A1.N3RD_FINC_VVD_CD,-1) AS DIR_CD," ).append("\n"); 
		query.append("                                                               NVL(A1.COST_ROUT_NO,1) AS COST_ROUT_NO," ).append("\n"); 
		query.append("                                                               DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1),'2',A2.CNTR_QTY, '3',A2.CNTR_QTY , A2.CNTR_QTY * 2) AS CNTR_TEU" ).append("\n"); 
		query.append("                                                          FROM MAS_COM_PARA A1," ).append("\n"); 
		query.append("                                                               MAS_COM_COST_PARA A2" ).append("\n"); 
		query.append("                                                         WHERE A1.PCTL_NO = A2.PCTL_NO" ).append("\n"); 
		query.append("                                                           AND A2.PCTL_NO = @[f_pctl_no] --'T1412240554189010006'" ).append("\n"); 
		query.append("--                                                         AND A2.MAS_COST_SRC_CD = '43201011'--아래로 수정 2015.09.01" ).append("\n"); 
		query.append("                                                           AND A2.MAS_COST_SRC_CD = DECODE( SOC_FLG  , 'Y', '65000000', '43201011')" ).append("\n"); 
		query.append("                                                           AND A1.N3RD_TRD_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                    " ).append("\n"); 
		query.append("                                                        UNION ALL" ).append("\n"); 
		query.append("                                                       " ).append("\n"); 
		query.append("                                                        SELECT 4 AS FLG," ).append("\n"); 
		query.append("                                                               A1.PCTL_NO," ).append("\n"); 
		query.append("                                                               A1.N4TH_TRD_CD    AS TRD_CD," ).append("\n"); 
		query.append("                                                               A1.N4TH_RLANE_CD  AS RLANE_CD," ).append("\n"); 
		query.append("                                                               SUBSTR(A1.N4TH_FINC_VVD_CD,-1) AS DIR_CD," ).append("\n"); 
		query.append("                                                               NVL(A1.COST_ROUT_NO,1) AS COST_ROUT_NO," ).append("\n"); 
		query.append("                                                               DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1),'2',A2.CNTR_QTY, '3',A2.CNTR_QTY , A2.CNTR_QTY * 2) AS CNTR_TEU" ).append("\n"); 
		query.append("                                                          FROM MAS_COM_PARA A1," ).append("\n"); 
		query.append("                                                               MAS_COM_COST_PARA A2" ).append("\n"); 
		query.append("                                                         WHERE A1.PCTL_NO = A2.PCTL_NO" ).append("\n"); 
		query.append("                                                           AND A2.PCTL_NO = @[f_pctl_no] --'T1412240554189010006'" ).append("\n"); 
		query.append("--                                                         AND A2.MAS_COST_SRC_CD = '43201011'--아래로 수정 2015.09.01" ).append("\n"); 
		query.append("                                                           AND A2.MAS_COST_SRC_CD = DECODE( SOC_FLG  , 'Y', '65000000', '43201011')" ).append("\n"); 
		query.append("                                                           AND A1.N4TH_TRD_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                      )" ).append("\n"); 
		query.append("                                                WHERE DECODE(TRD_CD,'AES',FLG,'TPS',FLG,'TAS',FLG,'EMS',FLG,COST_ROUT_NO) = COST_ROUT_NO" ).append("\n"); 
		query.append("                                               ) D2 " ).append("\n"); 
		query.append("                                         WHERE D2.TRD_CD       = D3.TRD_CD" ).append("\n"); 
		query.append("                                           AND D2.RLANE_CD     = D3.RLANE_CD" ).append("\n"); 
		query.append("                                           AND D3.STND_COST_CD = '65000000'" ).append("\n"); 
		query.append("                                           AND D3.RLANE_CD    != 'XXXXX'" ).append("\n"); 
		query.append("                                           AND D3.DIR_CD       = 'M'" ).append("\n"); 
		query.append("                                           AND D3.TEU_UC_AMT  <> 0" ).append("\n"); 
		query.append("                                           AND D2.GEN_FLG      = 'Y'" ).append("\n"); 
		query.append("                                         GROUP BY D3.TRD_CD,D3.SUB_TRD_CD,D3.RLANE_CD,D3.DIR_CD,D3.STND_COST_CD, D2.CNTR_TEU, D2.GEN_FLG" ).append("\n"); 
		query.append("                                         " ).append("\n"); 
		query.append("                                        UNION ALL" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        SELECT MAX(D3.COST_YR||D3.BSE_QTR_CD) AS COST_YRQ,D3.TRD_CD,D3.SUB_TRD_CD,D3.RLANE_CD,D3.DIR_CD,D3.STND_COST_CD, D2.CNTR_TEU,D2.GEN_FLG, 3 AS R_CNT" ).append("\n"); 
		query.append("                                          FROM MAS_STND_UT_COST D3," ).append("\n"); 
		query.append("                                               (" ).append("\n"); 
		query.append("                                                SELECT DISTINCT A.TRD_CD," ).append("\n"); 
		query.append("                                                       A.RLANE_CD," ).append("\n"); 
		query.append("                                                       A.DIR_CD," ).append("\n"); 
		query.append("                                                       B.SUB_TRD_CD," ).append("\n"); 
		query.append("                                                       A.CNTR_TEU," ).append("\n"); 
		query.append("                                                       DECODE(A.FLG,A.COST_ROUT_NO,'Y','N') AS GEN_FLG" ).append("\n"); 
		query.append("                                                  FROM (" ).append("\n"); 
		query.append("                                                        SELECT 1 AS FLG," ).append("\n"); 
		query.append("                                                               A1.PCTL_NO," ).append("\n"); 
		query.append("                                                               A1.N1ST_TRD_CD    AS TRD_CD," ).append("\n"); 
		query.append("                                                               A1.N1ST_RLANE_CD  AS RLANE_CD," ).append("\n"); 
		query.append("                                                               SUBSTR(A1.N1ST_FINC_VVD_CD,-1) AS DIR_CD," ).append("\n"); 
		query.append("                                                               NVL(A1.COST_ROUT_NO,1) AS COST_ROUT_NO," ).append("\n"); 
		query.append("                                                               DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1),'2',A2.CNTR_QTY, '3',A2.CNTR_QTY , A2.CNTR_QTY * 2) AS CNTR_TEU" ).append("\n"); 
		query.append("                                                          FROM MAS_COM_PARA A1," ).append("\n"); 
		query.append("                                                               MAS_COM_COST_PARA A2" ).append("\n"); 
		query.append("                                                         WHERE A1.PCTL_NO = A2.PCTL_NO" ).append("\n"); 
		query.append("                                                           AND A2.PCTL_NO = @[f_pctl_no] --'T1412240554189010006'" ).append("\n"); 
		query.append("--                                                         AND A2.MAS_COST_SRC_CD = '43201011'--아래로 수정 2015.09.01" ).append("\n"); 
		query.append("                                                           AND A2.MAS_COST_SRC_CD = DECODE( SOC_FLG  , 'Y', '65000000', '43201011')" ).append("\n"); 
		query.append("                                                    " ).append("\n"); 
		query.append("                                                        UNION ALL" ).append("\n"); 
		query.append("                                                    " ).append("\n"); 
		query.append("                                                        SELECT 2 AS FLG," ).append("\n"); 
		query.append("                                                               A1.PCTL_NO," ).append("\n"); 
		query.append("                                                               A1.N2ND_TRD_CD    AS TRD_CD," ).append("\n"); 
		query.append("                                                               A1.N2ND_RLANE_CD  AS RLANE_CD," ).append("\n"); 
		query.append("                                                               SUBSTR(A1.N2ND_FINC_VVD_CD,-1) AS DIR_CD," ).append("\n"); 
		query.append("                                                               NVL(A1.COST_ROUT_NO,1) AS COST_ROUT_NO," ).append("\n"); 
		query.append("                                                               DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1),'2',A2.CNTR_QTY, '3',A2.CNTR_QTY , A2.CNTR_QTY * 2) AS CNTR_TEU" ).append("\n"); 
		query.append("                                                          FROM MAS_COM_PARA A1," ).append("\n"); 
		query.append("                                                               MAS_COM_COST_PARA A2" ).append("\n"); 
		query.append("                                                         WHERE A1.PCTL_NO = A2.PCTL_NO" ).append("\n"); 
		query.append("                                                           AND A2.PCTL_NO = @[f_pctl_no] --'T1412240554189010006'" ).append("\n"); 
		query.append("--                                                         AND A2.MAS_COST_SRC_CD = '43201011'--아래로 수정 2015.09.01" ).append("\n"); 
		query.append("                                                           AND A2.MAS_COST_SRC_CD = DECODE( SOC_FLG  , 'Y', '65000000', '43201011')" ).append("\n"); 
		query.append("                                                           AND A1.N2ND_TRD_CD IS NOT NULL      " ).append("\n"); 
		query.append("                                                    " ).append("\n"); 
		query.append("                                                        UNION ALL" ).append("\n"); 
		query.append("                                                       " ).append("\n"); 
		query.append("                                                        SELECT 3 AS FLG," ).append("\n"); 
		query.append("                                                               A1.PCTL_NO," ).append("\n"); 
		query.append("                                                               A1.N3RD_TRD_CD    AS TRD_CD," ).append("\n"); 
		query.append("                                                               A1.N3RD_RLANE_CD  AS RLANE_CD," ).append("\n"); 
		query.append("                                                               SUBSTR(A1.N3RD_FINC_VVD_CD,-1) AS DIR_CD," ).append("\n"); 
		query.append("                                                               NVL(A1.COST_ROUT_NO,1) AS COST_ROUT_NO," ).append("\n"); 
		query.append("                                                               DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1),'2',A2.CNTR_QTY, '3',A2.CNTR_QTY , A2.CNTR_QTY * 2) AS CNTR_TEU" ).append("\n"); 
		query.append("                                                          FROM MAS_COM_PARA A1," ).append("\n"); 
		query.append("                                                               MAS_COM_COST_PARA A2" ).append("\n"); 
		query.append("                                                         WHERE A1.PCTL_NO = A2.PCTL_NO" ).append("\n"); 
		query.append("                                                           AND A2.PCTL_NO = @[f_pctl_no] --'T1412240554189010006'" ).append("\n"); 
		query.append("--                                                         AND A2.MAS_COST_SRC_CD = '43201011'--아래로 수정 2015.09.01" ).append("\n"); 
		query.append("                                                           AND A2.MAS_COST_SRC_CD = DECODE( SOC_FLG  , 'Y', '65000000', '43201011')" ).append("\n"); 
		query.append("                                                           AND A1.N3RD_TRD_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                    " ).append("\n"); 
		query.append("                                                        UNION ALL" ).append("\n"); 
		query.append("                                                       " ).append("\n"); 
		query.append("                                                        SELECT 4 AS FLG," ).append("\n"); 
		query.append("                                                               A1.PCTL_NO," ).append("\n"); 
		query.append("                                                               A1.N4TH_TRD_CD    AS TRD_CD," ).append("\n"); 
		query.append("                                                               A1.N4TH_RLANE_CD  AS RLANE_CD," ).append("\n"); 
		query.append("                                                               SUBSTR(A1.N4TH_FINC_VVD_CD,-1) AS DIR_CD," ).append("\n"); 
		query.append("                                                               NVL(A1.COST_ROUT_NO,1) AS COST_ROUT_NO," ).append("\n"); 
		query.append("                                                               DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1),'2',A2.CNTR_QTY, '3',A2.CNTR_QTY , A2.CNTR_QTY * 2) AS CNTR_TEU" ).append("\n"); 
		query.append("                                                          FROM MAS_COM_PARA A1," ).append("\n"); 
		query.append("                                                               MAS_COM_COST_PARA A2" ).append("\n"); 
		query.append("                                                         WHERE A1.PCTL_NO = A2.PCTL_NO" ).append("\n"); 
		query.append("                                                           AND A2.PCTL_NO = @[f_pctl_no] --'T1412240554189010006'" ).append("\n"); 
		query.append("--                                                         AND A2.MAS_COST_SRC_CD = '43201011'--아래로 수정 2015.09.01" ).append("\n"); 
		query.append("                                                           AND A2.MAS_COST_SRC_CD = DECODE( SOC_FLG  , 'Y', '65000000', '43201011')" ).append("\n"); 
		query.append("                                                           AND A1.N4TH_TRD_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                      ) A," ).append("\n"); 
		query.append("                                                      (" ).append("\n"); 
		query.append("                                                       SELECT DISTINCT RLANE_CD,TRD_CD,SUB_TRD_CD,VSL_SLAN_DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("                                                         FROM mdm_dtl_rev_lane" ).append("\n"); 
		query.append("                                                      ) B" ).append("\n"); 
		query.append("                                                WHERE DECODE(A.TRD_CD,'AES',A.FLG,'TPS',A.FLG,'TAS',A.FLG,'EMS',A.FLG,A.COST_ROUT_NO) = A.COST_ROUT_NO" ).append("\n"); 
		query.append("                                                  AND A.TRD_CD   = B.TRD_CD" ).append("\n"); 
		query.append("                                                  AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                                                  AND A.DIR_CD   = B.DIR_CD" ).append("\n"); 
		query.append("                                               ) D2 " ).append("\n"); 
		query.append("                                         WHERE D2.TRD_CD       = D3.TRD_CD" ).append("\n"); 
		query.append("                                           AND D2.SUB_TRD_CD   = D3.SUB_TRD_CD" ).append("\n"); 
		query.append("                                           AND D3.STND_COST_CD = '65000000'" ).append("\n"); 
		query.append("                                           AND D3.RLANE_CD     = 'XXXXX'" ).append("\n"); 
		query.append("                                           AND D3.DIR_CD       = 'M'" ).append("\n"); 
		query.append("                                           AND D3.TEU_UC_AMT  <> 0" ).append("\n"); 
		query.append("                                           AND D2.GEN_FLG      = 'Y'" ).append("\n"); 
		query.append("                                         GROUP BY D3.TRD_CD,D3.SUB_TRD_CD,D3.RLANE_CD,D3.DIR_CD,D3.STND_COST_CD, D2.CNTR_TEU, D2.GEN_FLG" ).append("\n"); 
		query.append("                                       )                                           " ).append("\n"); 
		query.append("                                 GROUP BY COST_YRQ," ).append("\n"); 
		query.append("                                       TRD_CD," ).append("\n"); 
		query.append("                                       SUB_TRD_CD," ).append("\n"); 
		query.append("                                       RLANE_CD," ).append("\n"); 
		query.append("                                       DIR_CD," ).append("\n"); 
		query.append("                                       STND_COST_CD," ).append("\n"); 
		query.append("                                       CNTR_TEU," ).append("\n"); 
		query.append("                                       GEN_FLG," ).append("\n"); 
		query.append("                                       R_CNT" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                         WHERE R_CNT = MIN_R_CNT" ).append("\n"); 
		query.append("                           AND GEN_FLG = DECODE(STND_COST_CD,'65000000','Y',GEN_FLG)" ).append("\n"); 
		query.append("                       ) D3" ).append("\n"); 
		query.append("                 WHERE D1.COST_YR      = D3.COST_YR" ).append("\n"); 
		query.append("                   AND D1.BSE_QTR_CD  = D3.BSE_QTR_CD" ).append("\n"); 
		query.append("                   AND D1.TRD_CD       = D3.TRD_CD" ).append("\n"); 
		query.append("                   AND D1.RLANE_CD     = D3.RLANE_CD" ).append("\n"); 
		query.append("                   AND D1.DIR_CD       = D3.DIR_CD" ).append("\n"); 
		query.append("                   AND D1.STND_COST_CD = D3.STND_COST_CD   " ).append("\n"); 
		query.append("                   AND D1.SUB_TRD_CD   = D3.SUB_TRD_CD                               " ).append("\n"); 
		query.append("                   AND D1.STND_COST_CD = D2.STND_COST_CD" ).append("\n"); 
		query.append("                 GROUP BY D2.ACCT_DP_SEQ    " ).append("\n"); 
		query.append("                       , D2.MGRP_COST_CD_DESC" ).append("\n"); 
		query.append("                       , ROLLUP(D2.ACCT_DP_SEQ||D2.STND_COST_NM)   " ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" ORDER BY COST_ACT_GRP_SEQ  " ).append("\n"); 
		query.append("         , SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("         , LVL" ).append("\n"); 
		query.append("         , STND_COST_NM" ).append("\n"); 

	}
}