/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SalesRPTDBDDAOSearchBkgRmk0170ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDDAOSearchBkgRmk0170ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquiry by BKG Remark
	  * 2011.01.11 이윤정 [CHM-201108216-01] NIBC, NOBC 요율 반영 로직 수정.TMFDFL 계정에 대해서 TMFDMT으로 변환하여 보여주는 부분을 제거.
	  * 2011.01.28 이윤정 [CHM-201108646-01] [MAS]Inquiry by BKG Remark 화면 정보변경.
	  * 2011.12.30 최윤성 [CHM-201115391-01] [MAS] Pre CM/OP Simulation화면 U.I변경건 Inquiry by BKG / Product Catalog Inquiry 동일 적용요청 - LOC, NOD Chekc 로직 추가
	  * 2012.07.30 최윤성 [CHM-201219111-01] AWK 에 대한 Remark 처리 조건 추가
	  * 2014.01.21 김수정 [CHM-201428560] [MAS] RBCCO에 대한 Misc OP Rev. 추정에 대한 로직 수정 보완
	  * 2014.07.18 PEJ [CHM-201431133] [MAS] HJL에서 ETS모듈 통해 발행한 W/O에 대한 Vendor 참조 로직 보완 및 S/P Code 추가
	  *                                                  CTRT_RTN_FLG = 'Y' 즉 CONTRACT 일경우 VENDOR 를 보여준다.
	  * 2015.03.24 [CHM-201534153] 김시몬 CM/OP계정 추가 및 변경에 따라 보완
	  * </pre>
	  */
	public SalesRPTDBDDAOSearchBkgRmk0170ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rout_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pro_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pro_vw",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDDAOSearchBkgRmk0170ListRSQL").append("\n"); 
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
		query.append("    ,GRP" ).append("\n"); 
		query.append("    ,STND_COST_CD" ).append("\n"); 
		query.append("    ,DECODE(STND_COST_CD,'51701011','CM2 COST',STND_COST_NM) STND_COST_NM" ).append("\n"); 
		query.append("    ,MAS_COST_SRC_CD" ).append("\n"); 
		query.append("    ,DECODE(STND_COST_CD,'51701011','CM2 COST('||MAS_COST_SRC_NM||')',MAS_COST_SRC_NM) MAS_COST_SRC_NM" ).append("\n"); 
		query.append("    ,AMT" ).append("\n"); 
		query.append("    ,CTRT_RTN_FLG" ).append("\n"); 
		query.append("    ,COST_CALC_RMK" ).append("\n"); 
		query.append("    ,AVG_LVL_CHK" ).append("\n"); 
		query.append("    ,VENDOR_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT 'DEM/DET' NOD_CD" ).append("\n"); 
		query.append("        ,2 COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("        ,'' GRP" ).append("\n"); 
		query.append("        ,'' STND_COST_CD" ).append("\n"); 
		query.append("        ,'' STND_COST_NM" ).append("\n"); 
		query.append("        ,'' MAS_COST_SRC_CD" ).append("\n"); 
		query.append("        ,'' MAS_COST_SRC_NM" ).append("\n"); 
		query.append("        ,ESTM_USD_TTL_AMT AMT" ).append("\n"); 
		query.append("        ,DECODE(CTRT_RTN_FLG, 'Y', 'Contract','L', 'Actual', 'Average') CTRT_RTN_FLG" ).append("\n"); 
		query.append("        ,REPLACE(COST_CALC_RMK, '>', '') COST_CALC_RMK" ).append("\n"); 
		query.append("        ,'00' ACCT_DP_SEQ" ).append("\n"); 
		query.append("        ,'N' AVG_LVL_CHK" ).append("\n"); 
		query.append("        ,'' VENDOR_SEQ" ).append("\n"); 
		query.append("    FROM MAS_BKG_COST_SRC_DTL" ).append("\n"); 
		query.append("    WHERE BKG_NO                  = @[f_bkg_no]" ).append("\n"); 
		query.append("        AND STND_COST_CD            = '43201011'" ).append("\n"); 
		query.append("        AND NVL(ESTM_USD_TTL_AMT,0) <> 0" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'Misc OP Rev' NOD_CD" ).append("\n"); 
		query.append("        ,4 COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("        ,'' GRP" ).append("\n"); 
		query.append("        ,'' STND_COST_CD" ).append("\n"); 
		query.append("        ,'' STND_COST_NM" ).append("\n"); 
		query.append("        ,'' MAS_COST_SRC_CD" ).append("\n"); 
		query.append("        ,'' MAS_COST_SRC_NM" ).append("\n"); 
		query.append("        ,BKG_MISC_REV AMT" ).append("\n"); 
		query.append("        ,'Average' CTRT_RTN_FLG" ).append("\n"); 
		query.append("        ,CASE" ).append("\n"); 
		query.append("            WHEN RLANE_CD <> 'RBCCO' AND IS_USE_TRD_UC = 'Y' THEN" ).append("\n"); 
		query.append("                 'MRI Trade ' || '('||TRD_CD||', '||DIR_CD||')' || ROUND(TRD_UC_AMT, 2) || '*' || CNTR_TEU || '(TEU) + BKG MISC REV ' || '('||ROUND((BKG_MISC_REV-(TRD_UC_AMT*CNTR_TEU)), 3)||')'" ).append("\n"); 
		query.append("            WHEN RLANE_CD <> 'RBCCO' AND IS_USE_TRD_UC = 'N' THEN         " ).append("\n"); 
		query.append("                 'MRI Lane '  || '('||RLANE_CD||', '||DIR_CD||')' || ROUND(RLANE_UC_AMT, 2) || '*' || CNTR_TEU || '(TEU) + BKG MISC REV ' || '('||ROUND((BKG_MISC_REV-(RLANE_UC_AMT*CNTR_TEU)), 3)||')'" ).append("\n"); 
		query.append("            WHEN RT_FLG = 'N' THEN" ).append("\n"); 
		query.append("                 'F.Rev 50%'" ).append("\n"); 
		query.append("            WHEN IS_USE_TRD_UC = 'Y' THEN  " ).append("\n"); 
		query.append("                 'MRI Lane (' || ROUND(TRD_UC_AMT, 2) || ') * ' || CNTR_TEU || '(TEU) + BKG MISC REV ' || '('||ROUND((BKG_MISC_REV-(RLANE_UC_AMT*CNTR_TEU)), 3)||')'" ).append("\n"); 
		query.append("            ELSE 'MRI Lane (' || ROUND(RLANE_UC_AMT, 2) || ') * ' || CNTR_TEU || '(TEU) + BKG MISC REV ' || '('||ROUND((BKG_MISC_REV-(RLANE_UC_AMT*CNTR_TEU)), 3)||')'" ).append("\n"); 
		query.append("        END COST_CALC_RMK" ).append("\n"); 
		query.append("        ,'00' ACCT_DP_SEQ" ).append("\n"); 
		query.append("        ,'N' AVG_LVL_CHK" ).append("\n"); 
		query.append("        ,'' VENDOR_SEQ" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT A2.BKG_NO" ).append("\n"); 
		query.append("            ,A2.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("            ,A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ,A2.CNTR_QTY" ).append("\n"); 
		query.append("            ,DECODE(SUBSTR(A2.CNTR_TPSZ_CD, -1), '2', A2.CNTR_QTY, '3', A2.CNTR_QTY, A2.CNTR_QTY * 2) CNTR_TEU" ).append("\n"); 
		query.append("            ,A3.REV_YRMON" ).append("\n"); 
		query.append("            ,A1.TRD_CD --A3.TRD_CD" ).append("\n"); 
		query.append("            ,A1.RLANE_CD --A3.RLANE_CD" ).append("\n"); 
		query.append("            ,A1.DIR_CD--A3.DIR_CD" ).append("\n"); 
		query.append("            ,NVL(A3.TRD_UC_AMT, 0) TRD_UC_AMT" ).append("\n"); 
		query.append("            ,NVL(A3.RLANE_UC_AMT, 0) RLANE_UC_AMT" ).append("\n"); 
		query.append("            ,A3.IS_USE_TRD_UC" ).append("\n"); 
		query.append("            ,A1.BKG_MISC_REV + A1.SCR_CHG_REV BKG_MISC_REV" ).append("\n"); 
		query.append("            ,DECODE(A4.BKG_NO, NULL, 'N', 'Y') RT_FLG" ).append("\n"); 
		query.append("        FROM MAS_BKG_EXPN_DTL A1" ).append("\n"); 
		query.append("            ,MAS_BKG_COST_SRC_DTL A2" ).append("\n"); 
		query.append("            ,(" ).append("\n"); 
		query.append("            SELECT REV_YRMON" ).append("\n"); 
		query.append("                ,TRD_CD" ).append("\n"); 
		query.append("                ,RLANE_CD" ).append("\n"); 
		query.append("                ,DIR_CD" ).append("\n"); 
		query.append("                ,MAX(TRD_UC_AMT) TRD_UC_AMT" ).append("\n"); 
		query.append("                ,MAX(RLANE_UC_AMT) RLANE_UC_AMT" ).append("\n"); 
		query.append("                ,MAX(IS_USE_TRD_UC) IS_USE_TRD_UC" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT REV_YRMON" ).append("\n"); 
		query.append("                    ,TRD_CD" ).append("\n"); 
		query.append("                    ,DIR_CD" ).append("\n"); 
		query.append("                    ,DECODE(RLANE_CD, 'XXXXX', NULL, RLANE_CD) RLANE_CD" ).append("\n"); 
		query.append("                    ,DECODE(RLANE_CD, 'XXXXX', ETC_UT_REV_AMT, 0) TRD_UC_AMT" ).append("\n"); 
		query.append("                    ,DECODE(RLANE_CD, 'XXXXX', 0, ETC_UT_REV_AMT) RLANE_UC_AMT" ).append("\n"); 
		query.append("                    ,CASE" ).append("\n"); 
		query.append("                         WHEN ETC_UT_REV_AMT > 100 AND TRD_TTL_QTY < 100 THEN" ).append("\n"); 
		query.append("                              'Y'" ).append("\n"); 
		query.append("                         ELSE 'N'" ).append("\n"); 
		query.append("                     END AS IS_USE_TRD_UC" ).append("\n"); 
		query.append("                FROM MAS_MON_MISC_REV_PRE_TEU" ).append("\n"); 
		query.append("                WHERE REV_YRMON = MAS_BZC_COST_YRMON_FNC(@[f_bkg_no])" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            GROUP BY REV_YRMON, TRD_CD, RLANE_CD, DIR_CD" ).append("\n"); 
		query.append("            ) A3" ).append("\n"); 
		query.append("            ,(SELECT DISTINCT BKG_NO" ).append("\n"); 
		query.append("                FROM BKG_CHG_RT" ).append("\n"); 
		query.append("               WHERE BKG_NO = @[f_bkg_no]) A4" ).append("\n"); 
		query.append("        WHERE A1.BKG_NO          = A2.BKG_NO" ).append("\n"); 
		query.append("          AND A1.CNTR_TPSZ_CD    = A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          AND A1.COST_ROUT_NO    = A2.COST_ROUT_NO" ).append("\n"); 
		query.append("          AND A2.BKG_NO          = @[f_bkg_no]" ).append("\n"); 
		query.append("          AND A2.MAS_COST_SRC_CD = '43201011'" ).append("\n"); 
		query.append("          AND A3.REV_YRMON(+)    = MAS_BZC_COST_YRMON_FNC(@[f_bkg_no])" ).append("\n"); 
		query.append("          AND A3.TRD_CD(+)       = A1.TRD_CD" ).append("\n"); 
		query.append("          AND A3.RLANE_CD(+)     = A1.RLANE_CD" ).append("\n"); 
		query.append("          AND A3.DIR_CD(+)       = A1.DIR_CD" ).append("\n"); 
		query.append("          AND A4.BKG_NO(+)       = A1.BKG_NO" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT A4.NOD_CD" ).append("\n"); 
		query.append("        ,A1.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("        ,MAS_GET_COM_NM_FNC('COST_ACT_GRP_CD', A1.COST_ACT_GRP_CD) GRP" ).append("\n"); 
		query.append("        ,A1.STND_COST_CD" ).append("\n"); 
		query.append("        ,A2.STND_COST_NM" ).append("\n"); 
		query.append("        ,A1.MAS_COST_SRC_CD                                        -- 2011.01.11 이윤정 [CHM-201108216-01] TMFDFL 계정에 대해서 TMFDMT으로 변환하여 보여주는 부분을 제거." ).append("\n"); 
		query.append("        ,MAS_GET_COM_NM_FNC('MAS_COST_SRC_CD', A1.MAS_COST_SRC_CD) -- 2011.01.11 이윤정 [CHM-201108216-01] TMFDFL 계정에 대해서 TMFDMT으로 변환하여 보여주는 부분을 제거." ).append("\n"); 
		query.append("        ,DECODE(@[f_pro_vw], 'P', A1.ESTM_USD_TTL_AMT, A1.RESPB_USD_TTL_AMT) AMT" ).append("\n"); 
		query.append("        -- ,DECODE(CTRT_RTN_FLG, 'Y', 'Contract','L', 'Actual', 'Average') CTRT_RTN_FLG" ).append("\n"); 
		query.append("        , CASE WHEN A1.STND_COST_CD = '51401011' THEN DECODE(A1.COST_ASS_BSE_CD, 'C', 'Contract', 'Average')" ).append("\n"); 
		query.append("               ELSE DECODE(CTRT_RTN_FLG, 'Y', 'Contract','L', 'Actual', 'Average')" ).append("\n"); 
		query.append("               END AS CTRT_RTN_FLG" ).append("\n"); 
		query.append("        ,CASE" ).append("\n"); 
		query.append("            WHEN REGEXP_LIKE(A1.COST_CALC_RMK, '^>T[RE]S AVG-') THEN" ).append("\n"); 
		query.append("                 SUBSTR(A1.COST_CALC_RMK, 2, 12) || ' -> ' || ROUND(ESTM_USD_UC_AMT, 2)" ).append("\n"); 
		query.append("            WHEN REGEXP_LIKE(A1.COST_CALC_RMK, '^>AWK OOG-Qty') THEN    -- 2012.07.30 최윤성 [CHM-201219111-01] AWK 에 대한 Remark 처리 조건 추가" ).append("\n"); 
		query.append("                 SUBSTR(A1.COST_CALC_RMK, 2, INSTR(A1.COST_CALC_RMK, '>T') + 10 ) || ' -> ' || ROUND(ESTM_USD_UC_AMT, 2)            " ).append("\n"); 
		query.append("            ELSE DECODE(A1.MAS_COST_SRC_CD" ).append("\n"); 
		query.append("                  ,'51601011', SUBSTR(A1.COST_CALC_RMK, 2)" ).append("\n"); 
		query.append("                  ,'92404011', A4.COST_CALC_RMK   --ABC/STP" ).append("\n"); 
		query.append("                  ,'65000000', A4.COST_CALC_RMK   --ABC/STP" ).append("\n"); 
		query.append("                  ,'65901011', A4.COST_CALC_RMK   --ABC/STP" ).append("\n"); 
		query.append("                  ,'65901021', A4.COST_CALC_RMK   --ABC/STP" ).append("\n"); 
		query.append("                  ,'92202011', REPLACE(REPLACE(A1.COST_CALC_RMK, ', RepoPOR', ', RepoPOR'), ', CNTREQ', ', CNTREQ')" ).append("\n"); 
		query.append("                  ,'92202012', REPLACE(A1.COST_CALC_RMK, ', Direction=', ', Direction=')" ).append("\n"); 
		query.append("                  ,REPLACE(A1.COST_CALC_RMK, '>TP', 'TP')" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("         END AS COST_CALC_RMK" ).append("\n"); 
		query.append("        ,ACCT_DP_SEQ" ).append("\n"); 
		query.append("        ,CASE WHEN REGEXP_LIKE(A1.COST_CALC_RMK, 'AVG-SCC|AVG-ECC|AVG-LCC|AVG-RCC') AND A2.SGRP_COST_CD = 'CVTR'" ).append("\n"); 
		query.append("                 THEN 'Y'" ).append("\n"); 
		query.append("                 ELSE 'N'" ).append("\n"); 
		query.append("          END AS AVG_LVL_CHK" ).append("\n"); 
		query.append("        ,A4.VENDOR_SEQ" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("          SELECT BKG_NO, CNTR_TPSZ_CD, COST_ROUT_NO, COST_ACT_GRP_SEQ, COST_ACT_GRP_CD, COST_ASS_BSE_CD, CTRT_RTN_FLG" ).append("\n"); 
		query.append("               , (CASE WHEN MAS_COST_SRC_CD IN ('52101013', '52201013', '52101012', '52201012')" ).append("\n"); 
		query.append("                          THEN '52101014'" ).append("\n"); 
		query.append("                       WHEN MAS_COST_SRC_CD IN ('52301013', '52301012')" ).append("\n"); 
		query.append("                          THEN '52301014'" ).append("\n"); 
		query.append("                       WHEN MAS_COST_SRC_CD IN ('52401013', '52401012')" ).append("\n"); 
		query.append("                          THEN '52401014'" ).append("\n"); 
		query.append("                       WHEN MAS_COST_SRC_CD IN ('52601013', '52601012')" ).append("\n"); 
		query.append("                          THEN '52601014'" ).append("\n"); 
		query.append("                       ELSE MAS_COST_SRC_CD" ).append("\n"); 
		query.append("                   END) AS MAS_COST_SRC_CD " ).append("\n"); 
		query.append("               , (CASE WHEN STND_COST_CD IN ('52101013', '52201013', '52101012', '52201012')" ).append("\n"); 
		query.append("                          THEN '52101014'" ).append("\n"); 
		query.append("                       WHEN STND_COST_CD IN ('52301013', '52301012')" ).append("\n"); 
		query.append("                          THEN '52301014'" ).append("\n"); 
		query.append("                       WHEN STND_COST_CD IN ('52401013', '52401012')" ).append("\n"); 
		query.append("                          THEN '52401014'" ).append("\n"); 
		query.append("                       WHEN STND_COST_CD IN ('52601013', '52601012')" ).append("\n"); 
		query.append("                          THEN '52601014'" ).append("\n"); 
		query.append("                       ELSE STND_COST_CD" ).append("\n"); 
		query.append("                   END) AS STND_COST_CD" ).append("\n"); 
		query.append("               , SUM(ESTM_USD_TTL_AMT) AS ESTM_USD_TTL_AMT, SUM(RESPB_USD_TTL_AMT) AS RESPB_USD_TTL_AMT, SUM(ESTM_USD_UC_AMT) AS ESTM_USD_UC_AMT" ).append("\n"); 
		query.append("               , MAX(CASE WHEN STND_COST_CD IN ( '52101013', '52201013', '52101012', '52201012'" ).append("\n"); 
		query.append("                                               , '52301013', '52301012'" ).append("\n"); 
		query.append("                                               , '52401013', '52401012'" ).append("\n"); 
		query.append("                                               , '52601013', '52601012'" ).append("\n"); 
		query.append("                                               , '52101014', '52301014', '52401014', '52601014')" ).append("\n"); 
		query.append("                                 AND ESTM_USD_TTL_AMT = 0 " ).append("\n"); 
		query.append("                                 AND RESPB_USD_TTL_AMT = 0" ).append("\n"); 
		query.append("                             THEN ''" ).append("\n"); 
		query.append("                          ELSE COST_CALC_RMK" ).append("\n"); 
		query.append("                      END) AS COST_CALC_RMK" ).append("\n"); 
		query.append("            FROM MAS_BKG_COST_SRC_DTL" ).append("\n"); 
		query.append("           WHERE BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("           GROUP BY BKG_NO, CNTR_TPSZ_CD, COST_ROUT_NO, COST_ACT_GRP_SEQ, COST_ACT_GRP_CD, COST_ASS_BSE_CD, CTRT_RTN_FLG" ).append("\n"); 
		query.append("                  , (CASE WHEN MAS_COST_SRC_CD IN ('52101013', '52201013', '52101012', '52201012')" ).append("\n"); 
		query.append("                             THEN '52101014'" ).append("\n"); 
		query.append("                          WHEN MAS_COST_SRC_CD IN ('52301013', '52301012')" ).append("\n"); 
		query.append("                             THEN '52301014'" ).append("\n"); 
		query.append("                          WHEN MAS_COST_SRC_CD IN ('52401013', '52401012')" ).append("\n"); 
		query.append("                             THEN '52401014'" ).append("\n"); 
		query.append("                          WHEN MAS_COST_SRC_CD IN ('52601013', '52601012')" ).append("\n"); 
		query.append("                             THEN '52601014'" ).append("\n"); 
		query.append("                          ELSE MAS_COST_SRC_CD" ).append("\n"); 
		query.append("                      END)" ).append("\n"); 
		query.append("                  , (CASE WHEN STND_COST_CD IN ('52101013', '52201013', '52101012', '52201012')" ).append("\n"); 
		query.append("                             THEN '52101014'" ).append("\n"); 
		query.append("                          WHEN STND_COST_CD IN ('52301013', '52301012')" ).append("\n"); 
		query.append("                             THEN '52301014'" ).append("\n"); 
		query.append("                          WHEN STND_COST_CD IN ('52401013', '52401012')" ).append("\n"); 
		query.append("                             THEN '52401014'" ).append("\n"); 
		query.append("                          WHEN STND_COST_CD IN ('52601013', '52601012')" ).append("\n"); 
		query.append("                             THEN '52601014'" ).append("\n"); 
		query.append("                          ELSE STND_COST_CD" ).append("\n"); 
		query.append("                      END)" ).append("\n"); 
		query.append("         ) A1" ).append("\n"); 
		query.append("        ,MAS_STND_ACCT_V A2" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("        SELECT DISTINCT COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("            ,COST_ACT_GRP_CD" ).append("\n"); 
		query.append("            ,N1ST_NOD_CD ORG_NOD_CD" ).append("\n"); 
		query.append("            ,COALESCE(N4TH_NOD_CD, N3RD_NOD_CD, N2ND_NOD_CD) DEST_NOD_CD" ).append("\n"); 
		query.append("            ,DECODE(N1ST_NOD_CD" ).append("\n"); 
		query.append("                                ,N2ND_NOD_CD, N1ST_NOD_CD" ).append("\n"); 
		query.append("                                ,  DECODE(N1ST_NOD_CD, NULL, ' ', N1ST_NOD_CD)" ).append("\n"); 
		query.append("                                || DECODE(N2ND_NOD_CD, NULL, ' ', ' -> ' || N2ND_NOD_CD)" ).append("\n"); 
		query.append("                                || DECODE(N3RD_NOD_CD, NULL, ' ', ' -> ' || N3RD_NOD_CD)" ).append("\n"); 
		query.append("                                || DECODE(N4TH_NOD_CD, NULL, ' ', ' -> ' || N4TH_NOD_CD)" ).append("\n"); 
		query.append("             ) NOD_CD" ).append("\n"); 
		query.append("            ,COST_CALC_RMK" ).append("\n"); 
		query.append("            ,BKG_NO" ).append("\n"); 
		query.append("            ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ,MAS_COST_SRC_CD" ).append("\n"); 
		query.append("            ,COST_ROUT_NO" ).append("\n"); 
		query.append("            ,CASE WHEN CTRT_RTN_FLG = 'Y' THEN -- CONTRACT 일경우 VENDOR 를 보여준다." ).append("\n"); 
		query.append("                          DECODE(TO_CHAR(N1ST_VNDR_SEQ), TO_CHAR(N2ND_VNDR_SEQ), TO_CHAR(N1ST_VNDR_SEQ), TO_CHAR(N1ST_VNDR_SEQ) || ',' || TO_CHAR(N2ND_VNDR_SEQ))" ).append("\n"); 
		query.append("                       || DECODE(TO_CHAR(N2ND_VNDR_SEQ), TO_CHAR(N3RD_VNDR_SEQ), ' ', DECODE(TO_CHAR(N3RD_VNDR_SEQ), NULL, '', ',' || TO_CHAR(N3RD_VNDR_SEQ)))" ).append("\n"); 
		query.append("                       || DECODE(TO_CHAR(N3RD_VNDR_SEQ), TO_CHAR(N4TH_VNDR_SEQ), ' ', DECODE(TO_CHAR(N4TH_VNDR_SEQ), NULL, '', ',' || TO_CHAR(N4TH_VNDR_SEQ)))" ).append("\n"); 
		query.append("                       || DECODE(TO_CHAR(N4TH_VNDR_SEQ), TO_CHAR(N5TH_VNDR_SEQ), ' ', DECODE(TO_CHAR(N5TH_VNDR_SEQ), NULL, '', ',' || TO_CHAR(N5TH_VNDR_SEQ)))" ).append("\n"); 
		query.append("                  ELSE NULL" ).append("\n"); 
		query.append("             END VENDOR_SEQ        " ).append("\n"); 
		query.append("        FROM MAS_BKG_COST_SRC_DTL" ).append("\n"); 
		query.append("        WHERE BKG_NO       = @[f_bkg_no]" ).append("\n"); 
		query.append("#if (${f_rout_no} != 'All')" ).append("\n"); 
		query.append("            AND COST_ROUT_NO = @[f_rout_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ) a4" ).append("\n"); 
		query.append("    WHERE A2.MAS_COST_SRC_PRT_CD IN(DECODE(@[f_pro_lvl], 'C', 'CO', 'CO'), DECODE(@[f_pro_vw], 'P', 'PA', 'RA'))" ).append("\n"); 
		query.append("		AND	A2.STND_COST_TP_CD IN('C', DECODE(@[f_pro_lvl], 'C', 'C', 'M', 'C','O')) " ).append("\n"); 
		query.append("        AND A1.STND_COST_CD     = A2.STND_COST_CD" ).append("\n"); 
		query.append("        AND A2.PA_VW            = 'BKG'" ).append("\n"); 
		query.append("#if (${f_pro_lvl} != 'M') " ).append("\n"); 
		query.append("		AND A1.STND_COST_CD <> '51701011'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND (   A1.ESTM_USD_TTL_AMT <> 0" ).append("\n"); 
		query.append("            OR  A1.RESPB_USD_TTL_AMT <> 0" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        AND A1.BKG_NO           = A4.BKG_NO" ).append("\n"); 
		query.append("        AND A1.CNTR_TPSZ_CD     = A4.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        AND A1.COST_ACT_GRP_SEQ = A4.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("        AND A1.MAS_COST_SRC_CD  = A4.MAS_COST_SRC_CD" ).append("\n"); 
		query.append("        AND A1.COST_ROUT_NO     = A4.COST_ROUT_NO" ).append("\n"); 
		query.append("        AND A1.COST_ACT_GRP_CD  = A4.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("        AND A1.MAS_COST_SRC_CD  NOT IN ('92404011', '65000000', '65901011', '65901021')" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT '' NOD" ).append("\n"); 
		query.append("        ,990 COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("        ,'Common AG' GRP" ).append("\n"); 
		query.append("        ,B1.STND_COST_CD" ).append("\n"); 
		query.append("        ,DECODE(B1.STND_COST_CD" ).append("\n"); 
		query.append("                            ,'91401011', 'STP Income'" ).append("\n"); 
		query.append("                            ,'92404011', 'STP Cost'" ).append("\n"); 
		query.append("                            ,'65000000', 'Business Activity Cost'" ).append("\n"); 
		query.append("                            ,'65901011', 'Own-Vol Activity Cost'" ).append("\n"); 
		query.append("                            ,'65901021', 'Oth-Vol Activity Cost'" ).append("\n"); 
		query.append("                            ,'Business Activity Cost'" ).append("\n"); 
		query.append("         ) STND_COST_NM" ).append("\n"); 
		query.append("        ,B1.RA_ACCT_CD MAS_COST_SRC_CD" ).append("\n"); 
		query.append("        ,B2.SLS_ACT_DESC MAS_COST_SRC_NM" ).append("\n"); 
		query.append("        ,B1.SVC_TRNS_PRC_AMT AMT" ).append("\n"); 
		query.append("        ,'' CTRT_RTN_FLG" ).append("\n"); 
		query.append("        ,'' COST_CALC_RMK" ).append("\n"); 
		query.append("        ,'' ACCT_DP_SEQ" ).append("\n"); 
		query.append("        ,'N' AVG_LVL_CHK" ).append("\n"); 
		query.append("        ,'' VENDER_SEQ" ).append("\n"); 
		query.append("    FROM MAS_BKG_SVC_TRNS_PRC B1" ).append("\n"); 
		query.append("        ,MAS_OFC_ROUT_MAPG B2" ).append("\n"); 
		query.append("    WHERE B1.SLS_ACT_CD       = B2.SLS_ACT_CD" ).append("\n"); 
		query.append("        AND B1.OFC_CLSS_CD      = B2.OFC_CLSS_CD" ).append("\n"); 
		query.append("        AND B2.COST_YRMON       = MAS_BZC_COST_YRMON_FNC(B1.BKG_NO)" ).append("\n"); 
		query.append("        AND B1.BKG_NO           = @[f_bkg_no]" ).append("\n"); 
		query.append("        AND B1.SVC_TRNS_PRC_AMT <> 0" ).append("\n"); 
		query.append("#if (${f_pro_lvl} == 'O')" ).append("\n"); 
		query.append("        AND B1.MAS_COST_SRC_CD  NOT IN ('91401011')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        AND B1.MAS_COST_SRC_CD  NOT IN ('92404011', '65000000', '65901011', '65901021', '91401011')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT ' ' AS NOD_CD " ).append("\n"); 
		query.append("           , COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("           , GRP" ).append("\n"); 
		query.append("           , STND_COST_CD" ).append("\n"); 
		query.append("           , SUBSTR(STND_COST_NM,5) STND_COST_NM" ).append("\n"); 
		query.append("           , STND_COST_CD" ).append("\n"); 
		query.append("           , SUBSTR(STND_COST_NM,5) STND_COST_NM" ).append("\n"); 
		query.append("           --, SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("           , NVL(AMT,0) AS AMT" ).append("\n"); 
		query.append("           , 'Average' AS CTRT_RTN_FLG" ).append("\n"); 
		query.append("           , '' AS COST_CALC_RMK" ).append("\n"); 
		query.append("           , ACCT_DP_SEQ" ).append("\n"); 
		query.append("           , 'Y' AS AVG_LVL_CHK " ).append("\n"); 
		query.append("           , '' AS VENDER_SEQ" ).append("\n"); 
		query.append("      FROM ( " ).append("\n"); 
		query.append("            SELECT   D2.ACCT_DP_SEQ        AS COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                   , D2.MGRP_COST_CD_DESC  AS GRP" ).append("\n"); 
		query.append("                   , D2.MGRP_COST_CD_DESC  AS SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("                   , D2.ACCT_DP_SEQ||D2.STND_COST_NM  AS STND_COST_NM" ).append("\n"); 
		query.append("                   , D2.STND_COST_CD" ).append("\n"); 
		query.append("                   , d2.ACCT_DP_SEQ2       AS ACCT_DP_SEQ" ).append("\n"); 
		query.append("                   , D2.ESTM_USD_TTL_AMT   AS AMT" ).append("\n"); 
		query.append("             FROM (                                " ).append("\n"); 
		query.append("                     SELECT B.MGRP_COST_CD," ).append("\n"); 
		query.append("                            B.MGRP_COST_CD_DESC," ).append("\n"); 
		query.append("                            --B.SGRP_COST_CD," ).append("\n"); 
		query.append("                            B.STND_COST_CD," ).append("\n"); 
		query.append("                            B.STND_COST_NM," ).append("\n"); 
		query.append("                            DECODE(B.MGRP_COST_CD,'OV',1001,'VF',1002,'OF',1003,'GE',1004) AS ACCT_DP_SEQ," ).append("\n"); 
		query.append("                            B.ACCT_DP_SEQ AS ACCT_DP_SEQ2," ).append("\n"); 
		query.append("                            A.ESTM_USD_TTL_AMT" ).append("\n"); 
		query.append("                       FROM (" ).append("\n"); 
		query.append("                             SELECT A.STND_COST_CD," ).append("\n"); 
		query.append("                                    SUM(A.ESTM_USD_TTL_AMT) AS ESTM_USD_TTL_AMT" ).append("\n"); 
		query.append("                               FROM MAS_BKG_OP_COST_SRC_DTL A" ).append("\n"); 
		query.append("                              WHERE A.BKG_NO  = @[f_bkg_no]" ).append("\n"); 
		query.append("                            #if (${f_rout_no} != 'All')" ).append("\n"); 
		query.append("                                AND COST_ROUT_NO = @[f_rout_no]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                              GROUP BY A.STND_COST_CD" ).append("\n"); 
		query.append("                            ) A," ).append("\n"); 
		query.append("                            MAS_STND_ACCT_V         B" ).append("\n"); 
		query.append("                     WHERE 1 = 1" ).append("\n"); 
		query.append("                       AND A.STND_COST_CD(+)     = B.STND_COST_CD" ).append("\n"); 
		query.append("                       AND B.MAS_COST_SRC_PRT_CD = 'PA'" ).append("\n"); 
		query.append("                       AND B.MGRP_COST_CD IN ('OF','OV','VF','GE')" ).append("\n"); 
		query.append("                       AND SUBSTR(B.STND_COST_CD,-1) != 9" ).append("\n"); 
		query.append("                   ) D2" ).append("\n"); 
		query.append("            )   " ).append("\n"); 
		query.append("      WHERE @[f_pro_lvl] = 'O' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("ORDER BY COST_ACT_GRP_SEQ, ACCT_DP_SEQ, 5, 9" ).append("\n"); 

	}
}