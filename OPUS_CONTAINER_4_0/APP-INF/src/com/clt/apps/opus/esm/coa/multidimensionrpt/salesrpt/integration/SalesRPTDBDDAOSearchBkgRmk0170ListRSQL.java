/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SalesRPTDBDDAOSearchBkgRmk0170ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
	  * 2014.07.30 송주현 COA_BKG_COST_SRC_DTL에 f_cntr_tpsz_cd 조건 추가, DEM/DMT 계정 삭제
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
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_epp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rout_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
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
		query.append("SELECT NOD_CD " ).append("\n"); 
		query.append("    ,GRP " ).append("\n"); 
		query.append("    ,STND_COST_CD " ).append("\n"); 
		query.append("    ,STND_COST_NM " ).append("\n"); 
		query.append("    ,COA_COST_SRC_CD " ).append("\n"); 
		query.append("    ,COA_COST_SRC_NM " ).append("\n"); 
		query.append("    ,CNTR_TPSZ_CD				--SJH.20141029.ADD" ).append("\n"); 
		query.append("    ,AMT " ).append("\n"); 
		query.append("    ,CTRT_RTN_FLG " ).append("\n"); 
		query.append("    ,COST_CALC_RMK " ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("    SELECT 'Misc OP Rev' NOD_CD " ).append("\n"); 
		query.append("        ,4 COST_ACT_GRP_SEQ " ).append("\n"); 
		query.append("        ,'' GRP " ).append("\n"); 
		query.append("        ,'' STND_COST_CD " ).append("\n"); 
		query.append("        ,'' STND_COST_NM " ).append("\n"); 
		query.append("        ,'' COA_COST_SRC_CD " ).append("\n"); 
		query.append("        ,'' COA_COST_SRC_NM " ).append("\n"); 
		query.append("        ,'' CNTR_TPSZ_CD		--SJH.20141029.ADD" ).append("\n"); 
		query.append("        , BKG_MISC_REV AMT" ).append("\n"); 
		query.append("        ,'Average' CTRT_RTN_FLG " ).append("\n"); 
		query.append("        ,CASE " ).append("\n"); 
		query.append("            WHEN IS_USE_TRD_UC = 'Y' THEN " ).append("\n"); 
		query.append("                 'MRI Trade ' || '('||TRD_CD||', '||DIR_CD||')' || ROUND(TRD_UC_AMT, 2) || '*' || CNTR_TEU || '(TEU)' " ).append("\n"); 
		query.append("            ELSE 'MRI Lane '  || '('||RLANE_CD||', '||DIR_CD||')' || ROUND(RLANE_UC_AMT, 2) || '*' || CNTR_TEU || '(TEU)' " ).append("\n"); 
		query.append("         END COST_CALC_RMK " ).append("\n"); 
		query.append("        ,'00' ACCT_DP_SEQ " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT A2.BKG_NO " ).append("\n"); 
		query.append("            ,A2.COST_ACT_GRP_SEQ " ).append("\n"); 
		query.append("            ,A2.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("            ,A2.CNTR_QTY  " ).append("\n"); 
		query.append("            ,DECODE(SUBSTR(A2.CNTR_TPSZ_CD, -1), '2', A2.CNTR_QTY, A2.CNTR_QTY * 2) CNTR_TEU " ).append("\n"); 
		query.append("            ,A3.REV_YRMON " ).append("\n"); 
		query.append("            ,A1.TRD_CD --A3.TRD_CD " ).append("\n"); 
		query.append("            ,A1.RLANE_CD --A3.RLANE_CD " ).append("\n"); 
		query.append("            ,A1.DIR_CD--A3.DIR_CD " ).append("\n"); 
		query.append("            ,NVL(A3.TRD_UC_AMT, 0) TRD_UC_AMT " ).append("\n"); 
		query.append("            ,NVL(A3.RLANE_UC_AMT, 0) RLANE_UC_AMT " ).append("\n"); 
		query.append("            ,A1.BKG_MISC_REV + A1.SCR_CHG_REV BKG_MISC_REV" ).append("\n"); 
		query.append("            ,A3.IS_USE_TRD_UC " ).append("\n"); 
		query.append("        FROM COA_BKG_EXPN_DTL A1 " ).append("\n"); 
		query.append("            ,COA_BKG_COST_SRC_DTL A2 " ).append("\n"); 
		query.append("            ,( " ).append("\n"); 
		query.append("            SELECT REV_YRMON " ).append("\n"); 
		query.append("                ,TRD_CD " ).append("\n"); 
		query.append("                ,RLANE_CD " ).append("\n"); 
		query.append("                ,DIR_CD " ).append("\n"); 
		query.append("                ,MAX(TRD_UC_AMT) TRD_UC_AMT " ).append("\n"); 
		query.append("                ,MAX(RLANE_UC_AMT) RLANE_UC_AMT " ).append("\n"); 
		query.append("                ,MAX(IS_USE_TRD_UC) IS_USE_TRD_UC " ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT REV_YRMON " ).append("\n"); 
		query.append("                    ,TRD_CD " ).append("\n"); 
		query.append("                    ,DIR_CD " ).append("\n"); 
		query.append("                    ,DECODE(RLANE_CD, 'XXXXX', NULL, RLANE_CD) RLANE_CD " ).append("\n"); 
		query.append("                    ,DECODE(RLANE_CD, 'XXXXX', ETC_UT_REV_AMT, 0) TRD_UC_AMT " ).append("\n"); 
		query.append("                    ,DECODE(RLANE_CD, 'XXXXX', 0, ETC_UT_REV_AMT) RLANE_UC_AMT " ).append("\n"); 
		query.append("                    ,CASE  " ).append("\n"); 
		query.append("                         WHEN ETC_UT_REV_AMT > 100 AND TRD_TTL_QTY < 100 THEN " ).append("\n"); 
		query.append("                              'Y'         																																													" ).append("\n"); 
		query.append("                         ELSE 'N'            																																													" ).append("\n"); 
		query.append("                     END AS IS_USE_TRD_UC 																																																			" ).append("\n"); 
		query.append("                FROM COA_MON_MISC_REV_PRE_TEU " ).append("\n"); 
		query.append("                WHERE REV_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("                ) " ).append("\n"); 
		query.append("            GROUP BY REV_YRMON, TRD_CD, RLANE_CD, DIR_CD" ).append("\n"); 
		query.append("            ) A3 " ).append("\n"); 
		query.append("        WHERE A1.BKG_NO          = A2.BKG_NO " ).append("\n"); 
		query.append("		  AND A1.CNTR_TPSZ_CD    = A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		  AND A1.COST_ROUT_NO    = A2.COST_ROUT_NO" ).append("\n"); 
		query.append("          AND A2.BKG_NO          = @[f_bkg_no] " ).append("\n"); 
		query.append("#if ( ${f_cntr_tpsz_cd} != '' )" ).append("\n"); 
		query.append("          AND A2.CNTR_TPSZ_CD    = NVL(@[f_cntr_tpsz_cd], A2.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND A2.COA_COST_SRC_CD = '43201011' " ).append("\n"); 
		query.append("          AND A3.REV_YRMON(+)    = @[f_cost_yrmon]  " ).append("\n"); 
		query.append("          AND A3.TRD_CD(+)       = A1.TRD_CD " ).append("\n"); 
		query.append("          AND A3.RLANE_CD(+)     = A1.RLANE_CD " ).append("\n"); 
		query.append("          AND A3.DIR_CD(+)       = A1.DIR_CD" ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    UNION ALL " ).append("\n"); 
		query.append("    SELECT A4.NOD_CD " ).append("\n"); 
		query.append("        ,A1.COST_ACT_GRP_SEQ  " ).append("\n"); 
		query.append("        ,COA_GET_COM_NM_FNC('COST_ACT_GRP_CD', A1.COST_ACT_GRP_CD) GRP " ).append("\n"); 
		query.append("        ,A1.STND_COST_CD  " ).append("\n"); 
		query.append("        ,A2.STND_COST_NM " ).append("\n"); 
		query.append("        ,A1.COA_COST_SRC_CD                       " ).append("\n"); 
		query.append("        ,COA_GET_COM_NM_FNC('COA_COST_SRC_CD', A1.COA_COST_SRC_CD) -- 2011.01.11 이윤정 [CHM-201108216-01] TMFDFL 계정에 대해서 TMFDMT으로 변환하여 보여주는 부분을 제거." ).append("\n"); 
		query.append("        ,A1.CNTR_TPSZ_CD 		--SJH.20141029.ADD" ).append("\n"); 
		query.append("        ,CASE" ).append("\n"); 
		query.append("            WHEN @[f_epp_tp_cd] ='B' THEN" ).append("\n"); 
		query.append("                DECODE(A1.STND_COST_CD,'51102001', A1.ESTM_USD_TTL_AMT2, A1.ESTM_USD_TTL_AMT)" ).append("\n"); 
		query.append("            ELSE A1.ESTM_USD_TTL_AMT" ).append("\n"); 
		query.append("            END AS AMT" ).append("\n"); 
		query.append("        ,DECODE(CTRT_RTN_FLG, 'Y', 'Contract','L', 'Actual', 'Average') CTRT_RTN_FLG " ).append("\n"); 
		query.append("        ,CASE  " ).append("\n"); 
		query.append("            WHEN REGEXP_LIKE(A1.COST_CALC_RMK, '^>T[RE]S AVG-') THEN " ).append("\n"); 
		query.append("                 SUBSTR(A1.COST_CALC_RMK, 2, 12) || ' -> ' || ROUND(ESTM_USD_UC_AMT, 2)" ).append("\n"); 
		query.append("            WHEN A1.STND_COST_CD IN ('51102001') THEN " ).append("\n"); 
		query.append("                 DECODE(@[f_epp_tp_cd] ,'B',SUBSTR(A1.COST_CALC_RMK2, 1),SUBSTR(A1.COST_CALC_RMK, 1))		--SJH.20141127.MOD" ).append("\n"); 
		query.append("            ELSE DECODE(A1.COA_COST_SRC_CD  " ).append("\n"); 
		query.append("                  ,'51601011', SUBSTR(A1.COST_CALC_RMK, 2)" ).append("\n"); 
		query.append("                  ,REPLACE(A1.COST_CALC_RMK, '>TP', 'TP')  )  " ).append("\n"); 
		query.append("          END AS COST_CALC_RMK" ).append("\n"); 
		query.append("        ,ACCT_DP_SEQ  " ).append("\n"); 
		query.append("    FROM COA_BKG_COST_SRC_DTL A1  " ).append("\n"); 
		query.append("        ,COA_STND_ACCT_V A2  " ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("        SELECT DISTINCT COST_ACT_GRP_SEQ  " ).append("\n"); 
		query.append("            ,COST_ACT_GRP_CD  " ).append("\n"); 
		query.append("            ,N1ST_NOD_CD ORG_NOD_CD  " ).append("\n"); 
		query.append("            ,COALESCE(N4TH_NOD_CD, N3RD_NOD_CD, N2ND_NOD_CD) DEST_NOD_CD  " ).append("\n"); 
		query.append("            ,DECODE(N1ST_NOD_CD  " ).append("\n"); 
		query.append("                                ,N2ND_NOD_CD, N1ST_NOD_CD  " ).append("\n"); 
		query.append("                                ,  DECODE(N1ST_NOD_CD, NULL, ' ', N1ST_NOD_CD)  " ).append("\n"); 
		query.append("                                || DECODE(N2ND_NOD_CD, NULL, ' ', ' -> ' || N2ND_NOD_CD)  " ).append("\n"); 
		query.append("                                || DECODE(N3RD_NOD_CD, NULL, ' ', ' -> ' || N3RD_NOD_CD)  " ).append("\n"); 
		query.append("                                || DECODE(N4TH_NOD_CD, NULL, ' ', ' -> ' || N4TH_NOD_CD)  " ).append("\n"); 
		query.append("             ) NOD_CD  " ).append("\n"); 
		query.append("            ,COST_CALC_RMK  " ).append("\n"); 
		query.append("            ,BKG_NO  " ).append("\n"); 
		query.append("            ,CNTR_TPSZ_CD  " ).append("\n"); 
		query.append("            ,COA_COST_SRC_CD  " ).append("\n"); 
		query.append("            ,COST_ROUT_NO  " ).append("\n"); 
		query.append("        FROM COA_BKG_COST_SRC_DTL   " ).append("\n"); 
		query.append("        WHERE BKG_NO       = @[f_bkg_no] " ).append("\n"); 
		query.append("#if ( ${f_cntr_tpsz_cd} != '' )" ).append("\n"); 
		query.append("            AND CNTR_TPSZ_CD = NVL(@[f_cntr_tpsz_cd], CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rout_no} != 'All') " ).append("\n"); 
		query.append("            AND COST_ROUT_NO = @[f_rout_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ) a4  " ).append("\n"); 
		query.append("    WHERE A1.BKG_NO           = @[f_bkg_no] " ).append("\n"); 
		query.append("        AND COA_COST_SRC_PRT_CD IN(DECODE(@[f_pro_lvl], 'C', 'CO', 'CO'), 'PA')   " ).append("\n"); 
		query.append("        AND STND_COST_TP_CD     IN('C', DECODE(@[f_pro_lvl], 'C', 'C', 'O'))  " ).append("\n"); 
		query.append("        AND A1.STND_COST_CD     = A2.STND_COST_CD  " ).append("\n"); 
		query.append("        AND A2.PA_VW            = 'BKG' " ).append("\n"); 
		query.append("        AND (   A1.ESTM_USD_TTL_AMT <> 0  " ).append("\n"); 
		query.append("            )  " ).append("\n"); 
		query.append("        AND A1.BKG_NO           = A4.BKG_NO   " ).append("\n"); 
		query.append("        AND A1.CNTR_TPSZ_CD     = A4.CNTR_TPSZ_CD  " ).append("\n"); 
		query.append("        AND A1.COST_ACT_GRP_SEQ = A4.COST_ACT_GRP_SEQ   " ).append("\n"); 
		query.append("        AND A1.COA_COST_SRC_CD  = A4.COA_COST_SRC_CD   " ).append("\n"); 
		query.append("        AND A1.COST_ROUT_NO     = A4.COST_ROUT_NO   " ).append("\n"); 
		query.append("        AND A1.COST_ACT_GRP_CD  = A4.COST_ACT_GRP_CD " ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("ORDER BY COST_ACT_GRP_SEQ, ACCT_DP_SEQ, 5, CNTR_TPSZ_CD, 9		--20150519.MOD" ).append("\n"); 

	}
}