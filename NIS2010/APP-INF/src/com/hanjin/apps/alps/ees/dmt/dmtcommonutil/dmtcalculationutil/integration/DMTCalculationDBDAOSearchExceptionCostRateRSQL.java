/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchExceptionCostRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchExceptionCostRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Exception Cost Rate 정보
	  * EXPT_COST_AMT는 CNTR  Size별로 dmdt_trf_cd 및 term 에 따라 금액합계함.
	  * 
	  * DET Amount = (CNTR_COST + OTR_COST + CY or DOR) * EX.EXPT_DYS + STOCK : DTIC, CTIC 인 경우, term 이 'O'(FO) 인 경우
	  * DEM Amount = (TML_COST + CNTR_COST + OTR_COST + CY or DOR) * EX.EXPT_DYS + STOCK : DEM Amount대상 이외 경우	
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchExceptionCostRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_bzc_ft_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_ft_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchExceptionCostRateRSQL").append("\n"); 
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
		query.append("SELECT  1 AS INCUR_QTY" ).append("\n"); 
		query.append("        , DECODE(SUBSTR(@[cntr_tpsz_cd], 2, 1), '2', 1, 2)          AS INCUR_CNTR_TEU_KNT" ).append("\n"); 
		query.append("        , 1 AS EXPT_QTY" ).append("\n"); 
		query.append("        , DECODE(SUBSTR(@[cntr_tpsz_cd], 2, 1), '2', 1, 2)          AS EXPT_CNTR_TEU_KNT" ).append("\n"); 
		query.append("        , EX.INCUR_AMT                                              AS INCUR_AMT" ).append("\n"); 
		query.append("        , CO.YD_CD" ).append("\n"); 
		query.append("        , CO.YD_EXPT_COST_SEQ" ).append("\n"); 
		query.append("        , EX.EXPT_DYS                                               AS EXPT_DYS " ).append("\n"); 
		query.append("        , ((CO.USD_COST_RT_AMT * EX.EXPT_DYS) + CO.USD_STK_AMT)     AS EXPT_COST_AMT" ).append("\n"); 
		query.append("        , " ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN (EX.CAL_FG = '2') AND EXP_RATE_FLG = 'Y' THEN" ).append("\n"); 
		query.append("            NVL(EX.EXPT_TRF_RT_ADJ_AMT, 0)                                 " ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("        END                                                         AS EXPT_TRF_RT_ADJ_AMT " ).append("\n"); 
		query.append("        , " ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN EXP_RATE_FLG = 'Y' THEN" ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("            WHEN (EX.CAL_FG <> '2') AND EXP_GUBUN IN ('YS', 'YB') THEN" ).append("\n"); 
		query.append("                -- Dual Type Exception & Rate 적용이 S/C 또는 Before 일 경우 현재 로직인 불안정하여 경우수에 따라서 로직을 구현함." ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                WHEN  ( EX.EXPT_FT_AMT = 0 AND EX.EXPT_TRF_RT_ADJ_AMT = 0 ) THEN" ).append("\n"); 
		query.append("                      0" ).append("\n"); 
		query.append("                WHEN  (EX.EXPT_FT_AMT = 0 AND EX.EXPT_TRF_RT_ADJ_AMT > 0 AND EX.INCUR_AMT >= EX.EXPT_TRF_RT_ADJ_AMT ) THEN" ).append("\n"); 
		query.append("                      EX.EXPT_TRF_RT_ADJ_AMT" ).append("\n"); 
		query.append("                WHEN  (EX.EXPT_FT_AMT = 0 AND EX.EXPT_TRF_RT_ADJ_AMT > 0 AND EX.INCUR_AMT <  EX.EXPT_TRF_RT_ADJ_AMT ) THEN" ).append("\n"); 
		query.append("                      EX.INCUR_AMT" ).append("\n"); 
		query.append("                WHEN  (EX.EXPT_FT_AMT > 0 AND EX.EXPT_TRF_RT_ADJ_AMT = 0 AND EX.INCUR_AMT >= EX.EXPT_FT_AMT         ) THEN" ).append("\n"); 
		query.append("                      EX.EXPT_FT_AMT" ).append("\n"); 
		query.append("                WHEN  (EX.EXPT_FT_AMT > 0 AND EX.EXPT_TRF_RT_ADJ_AMT = 0 AND EX.INCUR_AMT <  EX.EXPT_FT_AMT         ) THEN" ).append("\n"); 
		query.append("                      EX.INCUR_AMT" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                      0" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("            WHEN (EX.CAL_FG <> '2') AND ( EX.EXPT_TRF_RT_ADJ_AMT > 0  AND EXPT_FT_AMT = 0 )THEN" ).append("\n"); 
		query.append("                EX.EXPT_TRF_RT_ADJ_AMT     " ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                EX.EXPT_FT_AMT                                  -- 일반적인 경우" ).append("\n"); 
		query.append("            END                                      " ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("            EX.EXPT_FT_AMT + EX.EXPT_TRF_RT_ADJ_AMT" ).append("\n"); 
		query.append("        END                                                         AS EXPT_FT_AMT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  C.YD_CD," ).append("\n"); 
		query.append("                C.YD_EXPT_COST_SEQ," ).append("\n"); 
		query.append("                C.CURR_CD," ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} == 'DTIC' || ${dmdt_trf_cd} == 'CTIC' ) " ).append("\n"); 
		query.append("                ROUND(DECODE( SUBSTR(@[cntr_tpsz_cd], 2, 1), " ).append("\n"); 
		query.append("                      '2', ( NVL(C.CNTR_COST_20FT_RT_AMT, 0)" ).append("\n"); 
		query.append("                           + DECODE(@[term_cd], 'D', NVL(C.CHG_COST_DOR_RT_AMT, 0), NVL(C.CHG_COST_CY_RT_AMT, 0))" ).append("\n"); 
		query.append("                           + NVL(C.OTR_COST_20FT_RT_AMT, 0))," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                		   ( NVL(C.CNTR_COST_40FT_RT_AMT, 0)" ).append("\n"); 
		query.append("                		   + DECODE(@[term_cd], 'D', NVL(C.CHG_COST_DOR_RT_AMT, 0), NVL(C.CHG_COST_CY_RT_AMT, 0))" ).append("\n"); 
		query.append("                           + NVL(C.OTR_COST_40FT_RT_AMT, 0))" ).append("\n"); 
		query.append("                		   ) * (1/G.USD_LOCL_XCH_RT), 2)                                         AS USD_COST_RT_AMT," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                ROUND(DECODE( SUBSTR(@[cntr_tpsz_cd], 2, 1), " ).append("\n"); 
		query.append("                      '2', ( DECODE(@[term_cd], 'O', 0, NVL(C.TML_COST_20FT_RT_AMT, 0)) + " ).append("\n"); 
		query.append("                             NVL(C.CNTR_COST_20FT_RT_AMT, 0) + NVL(C.OTR_COST_20FT_RT_AMT, 0))," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                		   ( DECODE(@[term_cd], 'O', 0, NVL(C.TML_COST_40FT_RT_AMT, 0)) + " ).append("\n"); 
		query.append("                		     NVL(C.CNTR_COST_40FT_RT_AMT, 0) + NVL(C.OTR_COST_40FT_RT_AMT, 0)" ).append("\n"); 
		query.append("                		    )   ) * (1/G.USD_LOCL_XCH_RT), 2)                                    AS USD_COST_RT_AMT, " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                ROUND(NVL(C.CNTR_COST_STK_AMT,0)* (1/G.USD_LOCL_XCH_RT), 2)                      AS USD_STK_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        FROM    DMT_YD_EXPT_COST C, GL_MON_XCH_RT G" ).append("\n"); 
		query.append("        WHERE   C.YD_CD             =  @[yd_cd]" ).append("\n"); 
		query.append("        AND     C.CFM_FLG           = 'Y'" ).append("\n"); 
		query.append("        AND     TO_DATE(SUBSTR(@[eta_dt], 1, 8),'YYYYMMDD') BETWEEN     C.EFF_DT" ).append("\n"); 
		query.append("                                                            AND         NVL(C.EXP_DT, TO_DATE(SUBSTR(@[eta_dt], 1, 8), 'YYYYMMDD')) + 0.99999" ).append("\n"); 
		query.append("        AND     G.ACCT_XCH_RT_YRMON = SUBSTR(@[fm_mvmt_dt], 1, 6)" ).append("\n"); 
		query.append("        AND     G.ACCT_XCH_RT_LVL   = 1" ).append("\n"); 
		query.append("        AND     G.CURR_CD           = C.CURR_CD" ).append("\n"); 
		query.append("        ) CO," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  (" ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                WHEN TO_DATE(SUBSTR(@[to_mvmt_dt], 1, 8),'YYYYMMDD') <= TO_DATE(SUBSTR(@[expt_ft_end_dt], 1, 8), 'YYYYMMDD') THEN" ).append("\n"); 
		query.append("                        '1'" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                        '2'" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("                )                                                                               AS CAL_FG," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                WHEN TO_DATE(SUBSTR(@[to_mvmt_dt], 1, 8), 'YYYYMMDD') <  TO_DATE(SUBSTR(@[expt_ft_end_dt], 1, 8), 'YYYYMMDD')  THEN " ).append("\n"); 
		query.append("                    (TO_DATE(SUBSTR(@[to_mvmt_dt], 1, 8), 'YYYYMMDD') - TO_DATE(SUBSTR(@[dmdt_bzc_ft_end_dt], 1, 8), 'YYYYMMDD')) " ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                    (TO_DATE(SUBSTR(@[expt_ft_end_dt],1,8), 'YYYYMMDD') - TO_DATE(SUBSTR(@[dmdt_bzc_ft_end_dt], 1, 8), 'YYYYMMDD'))" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("                )                                                                               AS EXPT_DYS," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                WHEN T2.DMDT_TRF_APLY_TP_CD= 'G' THEN" ).append("\n"); 
		query.append("                    'N'" ).append("\n"); 
		query.append("                WHEN T2.DMDT_TRF_APLY_TP_CD= 'B' THEN                     " ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    SELECT  MAX('Y')" ).append("\n"); 
		query.append("                    FROM    DMT_CHG_CALC            S1," ).append("\n"); 
		query.append("                            DMT_RFA_EXPT_TRF_DTL    S2" ).append("\n"); 
		query.append("                    WHERE   1=1" ).append("\n"); 
		query.append("                    AND     S1.RFA_EXPT_DAR_NO          = S2.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("                    AND     S1.RFA_EXPT_MAPG_SEQ        = S2.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("                    AND     S1.RFA_EXPT_VER_SEQ         = S2.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                    AND     S1.RFA_RQST_DTL_SEQ         = S2.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("                    AND     S1.CNTR_NO                  = @[cntr_no]   " ).append("\n"); 
		query.append("                    AND     S1.CNTR_CYC_NO              = @[cntr_cyc_no]" ).append("\n"); 
		query.append("                    AND     S1.DMDT_TRF_CD              = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("                    AND     S1.DMDT_CHG_LOC_DIV_CD      = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("                    AND     S1.CHG_SEQ                  = @[chg_seq]" ).append("\n"); 
		query.append("                    AND     S2.RT_USE_FLG               = 'Y'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    SELECT  MAX('Y')" ).append("\n"); 
		query.append("                    FROM	DMT_CHG_CALC            S1," ).append("\n"); 
		query.append("                            DMT_SC_EXPT_GRP         S2," ).append("\n"); 
		query.append("                    		PRI_SP_HDR              S3" ).append("\n"); 
		query.append("                    WHERE	1=1" ).append("\n"); 
		query.append("                    AND     S2.PROP_NO			        = S3.PROP_NO" ).append("\n"); 
		query.append("                    AND     S1.SC_NO                    = S3.SC_NO" ).append("\n"); 
		query.append("                    AND     S1.SC_EXPT_VER_SEQ          = S2.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                    AND	    S1.SC_EXPT_GRP_SEQ          = S2.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("                    AND     S1.CNTR_NO                  = @[cntr_no]   " ).append("\n"); 
		query.append("                    AND     S1.CNTR_CYC_NO              = @[cntr_cyc_no]" ).append("\n"); 
		query.append("                    AND     S1.DMDT_TRF_CD              = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("                    AND     S1.DMDT_CHG_LOC_DIV_CD      = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("                    AND     S1.CHG_SEQ                  = @[chg_seq]" ).append("\n"); 
		query.append("                    AND     S2.RT_ADJ_FLG               = 'Y'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("                )                                                                               AS EXP_RATE_FLG," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  ROUND((NVL(MAX(A.SC_RFA_EXPT_AMT), 0) - @[bzc_rt]) * (1/GL.USD_LOCL_XCH_RT), 2)  " ).append("\n"); 
		query.append("                FROM    DMT_CHG_CALC A " ).append("\n"); 
		query.append("                WHERE   A.CNTR_NO                   = @[cntr_no]   " ).append("\n"); 
		query.append("                AND     A.CNTR_CYC_NO               = @[cntr_cyc_no]" ).append("\n"); 
		query.append("                AND     A.DMDT_TRF_CD               = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("                AND     A.DMDT_CHG_LOC_DIV_CD       = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("                AND     A.CHG_SEQ                   = @[chg_seq]" ).append("\n"); 
		query.append("                )                                                                               AS EXPT_TRF_RT_ADJ_AMT," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  ROUND(NVL(MAX(A.ORG_CHG_AMT), 0) * (1/GL.USD_LOCL_XCH_RT), 2)" ).append("\n"); 
		query.append("                FROM    DMT_CHG_CALC A " ).append("\n"); 
		query.append("                WHERE   A.CNTR_NO               = @[cntr_no]  " ).append("\n"); 
		query.append("                AND     A.CNTR_CYC_NO           = @[cntr_cyc_no]" ).append("\n"); 
		query.append("                AND     A.DMDT_TRF_CD           = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("                AND     A.DMDT_CHG_LOC_DIV_CD   = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("                AND     A.CHG_SEQ               = @[chg_seq]" ).append("\n"); 
		query.append("                )                                                                               AS INCUR_AMT, " ).append("\n"); 
		query.append("                ROUND(@[bzc_rt] * (1/GL.USD_LOCL_XCH_RT), 2)                                    AS EXPT_FT_AMT," ).append("\n"); 
		query.append("                EXP_GUBUN" ).append("\n"); 
		query.append("        FROM    GL_MON_XCH_RT GL," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  NVL(DMDT_TRF_APLY_TP_CD, 'G')                    AS DMDT_TRF_APLY_TP_CD," ).append("\n"); 
		query.append("                        DUL_TP_EXPT_FLG || NVL(DMDT_TRF_APLY_TP_CD, 'G') AS EXP_GUBUN" ).append("\n"); 
		query.append("                FROM    DMT_CHG_CALC" ).append("\n"); 
		query.append("                WHERE	1=1" ).append("\n"); 
		query.append("                AND     CNTR_NO                  = @[cntr_no]   " ).append("\n"); 
		query.append("                AND     CNTR_CYC_NO              = @[cntr_cyc_no]" ).append("\n"); 
		query.append("                AND     DMDT_TRF_CD              = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("                AND     DMDT_CHG_LOC_DIV_CD      = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("                AND     CHG_SEQ                  = @[chg_seq]" ).append("\n"); 
		query.append("                AND     ROWNUM                   = 1" ).append("\n"); 
		query.append("                )   T2" ).append("\n"); 
		query.append("        WHERE   GL.ACCT_XCH_RT_YRMON    = SUBSTR(@[fm_mvmt_dt], 1, 6)" ).append("\n"); 
		query.append("        AND     GL.ACCT_XCH_RT_LVL      = '1'" ).append("\n"); 
		query.append("        AND     GL.CURR_CD              = (" ).append("\n"); 
		query.append("                                          SELECT  BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("                                          FROM    DMT_CHG_CALC" ).append("\n"); 
		query.append("                                          WHERE   1=1" ).append("\n"); 
		query.append("                                          AND     CNTR_NO                  = @[cntr_no]   " ).append("\n"); 
		query.append("                                          AND     CNTR_CYC_NO              = @[cntr_cyc_no]" ).append("\n"); 
		query.append("                                          AND     DMDT_TRF_CD              = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("                                          AND     DMDT_CHG_LOC_DIV_CD      = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("                                          AND     CHG_SEQ                  = @[chg_seq]" ).append("\n"); 
		query.append("                                          AND     ROWNUM                   = 1" ).append("\n"); 
		query.append("                                          )" ).append("\n"); 
		query.append("        ) EX" ).append("\n"); 

	}
}