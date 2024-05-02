/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BudgetPortChargeMgtBCDBDAOsearchEstTgtVvdByMonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtBCDBDAOsearchEstTgtVvdByMonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Estimate Expense Creation을 하기 위해 이미 생성한 추정 대상 VVD를 Revenue Month 나 노선 별로 조회한다.
	  * 
	  * =======================================
	  * history
	  * 2012.06.21 진마리아 CHM-201218370-01 추정 관련 로직 변경 (팬드럼 노선)
	  * </pre>
	  */
	public BudgetPortChargeMgtBCDBDAOsearchEstTgtVvdByMonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtedate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtsdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtBCDBDAOsearchEstTgtVvdByMonRSQL").append("\n"); 
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
		query.append("/*" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     '' TXTSDATE" ).append("\n"); 
		query.append("    ,'' TXTEDATE" ).append("\n"); 
		query.append("    ,'' REV_YRMON" ).append("\n"); 
		query.append("    ,'' LANE" ).append("\n"); 
		query.append("    ,'' CHK" ).append("\n"); 
		query.append("    ,'' VVD" ).append("\n"); 
		query.append("    ,'' HVVD" ).append("\n"); 
		query.append("    ,'' VSL_CD" ).append("\n"); 
		query.append("    ,'' SKD_VOY_NO" ).append("\n"); 
		query.append("    ,'' SKD_DIR_CD" ).append("\n"); 
		query.append("    ,'' CLPT_IND_SEQ" ).append("\n"); 
		query.append("    ,'' TURN_PORT_FLG" ).append("\n"); 
		query.append("    ,'' TURN_PORT_IND_CD" ).append("\n"); 
		query.append("    ,'' CLPT_SEQ" ).append("\n"); 
		query.append("    ,'' TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("    ,'' TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("    ,'' TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    ,'' VIR_TURN_PORT_FLG" ).append("\n"); 
		query.append("    ,'' VIR_TURN_PORT_IND_CD" ).append("\n"); 
		query.append("    ,'' TMNL_CODE" ).append("\n"); 
		query.append("    ,'' TXTCOLOR" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("SELECT  X.*   FROM    " ).append("\n"); 
		query.append(" (   SELECT  Z.*, CASE WHEN Z.txtColor2 IN ('Pink') THEN " ).append("\n"); 
		query.append("                          ( SELECT  MAX(  CASE WHEN X.CPLS_FLG = 'Y' AND ( Y.XPR_DESC LIKE '%null%' OR  Y.XPR_DESC LIKE '%no-rate%'  )  THEN  'Pink'" ).append("\n"); 
		query.append("                                               WHEN Y.XPR_DESC IS NULL THEN  'Blue'" ).append("\n"); 
		query.append("                                               ELSE NULL" ).append("\n"); 
		query.append("                                          END )" ).append("\n"); 
		query.append("                              FROM PSO_YD_CHG X, PSO_TGT_YD_EXPN Y" ).append("\n"); 
		query.append("                             WHERE X.YD_CD  = Y.YD_CD " ).append("\n"); 
		query.append("                               AND Y.VSL_CD = Z.VSL_CD" ).append("\n"); 
		query.append("                               AND Y.SKD_VOY_NO  = Z.SKD_VOY_NO" ).append("\n"); 
		query.append("                               AND Y.SKD_DIR_CD  = Z.SKD_DIR_CD" ).append("\n"); 
		query.append("                               AND Y.PSO_BZTP_CD ='2'" ).append("\n"); 
		query.append("                               AND X.YD_CD       = Z.TMNL_CODE" ).append("\n"); 
		query.append("                               AND X.LST_FLG     = 'Y'" ).append("\n"); 
		query.append("                               AND Y.REV_YRMON BETWEEN TO_CHAR (X.EFF_DT, 'YYYYMM') AND TO_CHAR (X.EXP_DT, 'YYYYMM')" ).append("\n"); 
		query.append("                               AND Z.REV_YRMON BETWEEN TO_CHAR (X.EFF_DT, 'YYYYMM') AND TO_CHAR (X.EXP_DT, 'YYYYMM')" ).append("\n"); 
		query.append("                               AND Y.REV_YRMON BETWEEN TO_CHAR (X.EFF_DT, 'YYYYMM') AND TO_CHAR (X.EXP_DT, 'YYYYMM')" ).append("\n"); 
		query.append("                               AND X.VNDR_SEQ = Y.VNDR_SEQ" ).append("\n"); 
		query.append("                               AND X.LGS_COST_CD = Y.LGS_COST_CD  )" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("                         ELSE  Z.txtColor2" ).append("\n"); 
		query.append("                         END AS txtColor" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  FROM  " ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("        SELECT    ''                                              AS txtsDate" ).append("\n"); 
		query.append("                , ''                                              AS txteDate" ).append("\n"); 
		query.append("                , T1.REV_YRMON" ).append("\n"); 
		query.append("                , SUBSTR(T1.LANE,1,3)                             AS LANE" ).append("\n"); 
		query.append("                , ''                                              AS CHK" ).append("\n"); 
		query.append("                , T1.VSL_CD || T1.SKD_VOY_NO || T1.SKD_DIR_CD     AS VVD" ).append("\n"); 
		query.append("                , T1.VSL_CD || T1.SKD_VOY_NO || T1.SKD_DIR_CD     AS HVVD" ).append("\n"); 
		query.append("                , MAX(T1.VSL_CD)                                  AS VSL_CD" ).append("\n"); 
		query.append("                , MAX(T1.SKD_VOY_NO)                              AS SKD_VOY_NO" ).append("\n"); 
		query.append("                , MAX(T1.SKD_DIR_CD)                              AS SKD_DIR_CD" ).append("\n"); 
		query.append("                , MAX(T1.CLPT_IND_SEQ)                            AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("                , MAX(T1.TURN_PORT_FLG)                           AS TURN_PORT_FLG" ).append("\n"); 
		query.append("                , MAX(T1.TURN_PORT_IND_CD)                        AS TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                , MAX(T1.CLPT_SEQ)                                AS CLPT_SEQ" ).append("\n"); 
		query.append("                , MAX(T1.TURN_SKD_VOY_NO)                         AS TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                , MAX(T1.TURN_SKD_DIR_CD)                         AS TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                , MAX(T1.TURN_CLPT_IND_SEQ)                       AS TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                , MAX(T1.VIR_TURN_PORT_FLG)                       AS VIR_TURN_PORT_FLG" ).append("\n"); 
		query.append("                , MAX(T1.VIR_TURN_PORT_IND_CD)                    AS VIR_TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                , T1.YD_CD                                        AS TMNL_CODE" ).append("\n"); 
		query.append("                , DECODE (T1.YD_CD," ).append("\n"); 
		query.append("                         NULL, 'Red'," ).append("\n"); 
		query.append("                         DECODE (LENGTH (T1.YD_CD)," ).append("\n"); 
		query.append("                                 5, 'Red'," ).append("\n"); 
		query.append("                                 DECODE(    (   SELECT  1" ).append("\n"); 
		query.append("                                                FROM    PSO_YD_CHG X" ).append("\n"); 
		query.append("                                                WHERE   X.YD_CD     = T1.YD_CD" ).append("\n"); 
		query.append("                                                AND     T1.REV_YRMON BETWEEN TO_CHAR (X.EFF_DT, 'YYYYMM') AND TO_CHAR (X.EXP_DT, 'YYYYMM')" ).append("\n"); 
		query.append("                                                AND     LST_FLG     = 'Y'" ).append("\n"); 
		query.append("                                                AND     ROWNUM      <= 1 " ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                          , NULL, 'Red', " ).append("\n"); 
		query.append("                                 MAX(CASE WHEN T2.XPR_DESC LIKE '%null%' OR T2.XPR_DESC LIKE '%no-rate%' THEN 'Pink'" ).append("\n"); 
		query.append("                                          WHEN T2.XPR_DESC IS NULL THEN 'Blue' END)" ).append("\n"); 
		query.append("                )))                                                AS txtColor2" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  DISTINCT '2'                       AS PSO_BZTP_CD" ).append("\n"); 
		query.append("                        , AV.VSL_CD" ).append("\n"); 
		query.append("                        , AV.SKD_VOY_NO" ).append("\n"); 
		query.append("                        , VP.SKD_DIR_CD" ).append("\n"); 
		query.append("                        , NVL (VP.YD_CD, VP.VPS_PORT_CD)   AS YD_CD" ).append("\n"); 
		query.append("                        , RV.REV_YRMON" ).append("\n"); 
		query.append("                        , VP.SLAN_CD                       AS LANE" ).append("\n"); 
		query.append("                        , VP.CLPT_SEQ" ).append("\n"); 
		query.append("                        , VP.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                        , VP.TURN_PORT_FLG" ).append("\n"); 
		query.append("                        , VP.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                        , VP.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                        , VP.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                        , VP.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                        , (" ).append("\n"); 
		query.append("                        SELECT  TURN_PORT_FLG" ).append("\n"); 
		query.append("                        FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                        WHERE   VSL_CD          =VP.VSL_CD" ).append("\n"); 
		query.append("                        AND     SKD_VOY_NO      =VP.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND     SKD_DIR_CD      =VP.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND     VPS_PORT_CD     =VP.VPS_PORT_CD" ).append("\n"); 
		query.append("                        AND     CLPT_IND_SEQ    =VP.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                        )                                 AS VIR_TURN_PORT_FLG" ).append("\n"); 
		query.append("                        , (" ).append("\n"); 
		query.append("                        SELECT  TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                        FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                        WHERE   VSL_CD          =VP.VSL_CD" ).append("\n"); 
		query.append("                        AND     SKD_VOY_NO      =VP.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND     SKD_DIR_CD      =VP.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND     VPS_PORT_CD     =VP.VPS_PORT_CD" ).append("\n"); 
		query.append("                        AND     CLPT_IND_SEQ    =VP.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                        )                                 AS VIR_TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                FROM    AR_MST_REV_VVD     AV," ).append("\n"); 
		query.append("                        MDM_VSL_CNTR       VS," ).append("\n"); 
		query.append("                        VSK_VSL_SKD        VV," ).append("\n"); 
		query.append("                        VSK_VSL_PORT_SKD   VP," ).append("\n"); 
		query.append("                        GL_ESTM_REV_VVD    RV" ).append("\n"); 
		query.append("                WHERE   1=1" ).append("\n"); 
		query.append("                AND     RV.EXE_YRMON > ' '" ).append("\n"); 
		query.append("                AND     RV.REV_YRMON > ' '" ).append("\n"); 
		query.append("                AND     RV.REV_YRMON BETWEEN REPLACE(@[txtsdate], '-','') AND REPLACE(@[txtedate], '-','')" ).append("\n"); 
		query.append("                AND     RV.RLANE_CD  IN (  CASE WHEN VV.VSL_SLAN_CD = (SELECT S.SLAN_CD FROM PSO_PORT_EXPN_DIV S WHERE S.SLAN_CD = VV.VSL_SLAN_CD AND ROWNUM = 1) THEN" ).append("\n"); 
		query.append("                                            (" ).append("\n"); 
		query.append("                                            SELECT  S.RLANE_CD" ).append("\n"); 
		query.append("                                            FROM    PSO_PORT_EXPN_DIV S" ).append("\n"); 
		query.append("                                            WHERE   1=1" ).append("\n"); 
		query.append("                                            AND     S.SLAN_CD       = VV.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                            AND     S.SKD_DIR_CD    = VV.SKD_DIR_CD" ).append("\n"); 
		query.append("                                            AND     S.RLANE_CD      = RV.RLANE_CD" ).append("\n"); 
		query.append("                                            AND     S.LOC_CD        = VP.VPS_PORT_CD" ).append("\n"); 
		query.append("                                            AND     ROWNUM          = 1" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                        ELSE" ).append("\n"); 
		query.append("                                            (" ).append("\n"); 
		query.append("                                            SELECT  PSO_GET_REV_LANE_FNC(VP.VSL_CD , VP.SKD_VOY_NO , VP.SKD_DIR_CD , substr(VP.YD_CD , 1, 5 ))" ).append("\n"); 
		query.append("                                            FROM    DUAL" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                AND     RTRIM (VS.CNTR_VSL_CLSS_CAPA) IS NOT NULL" ).append("\n"); 
		query.append("                AND     NVL(VV.ACT_CRR_CD,VS.CRR_CD) = 'SML'" ).append("\n"); 
		query.append("                AND     AV.VSL_CD       = VS.VSL_CD" ).append("\n"); 
		query.append("                AND     AV.VSL_CD       = VV.VSL_CD" ).append("\n"); 
		query.append("                AND     AV.SKD_VOY_NO   = VV.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     AV.SKD_DIR_CD   = VV.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND     AV.VSL_CD       = VP.VSL_CD" ).append("\n"); 
		query.append("                AND     AV.SKD_VOY_NO   = VP.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     AV.SKD_DIR_CD   = VP.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND     AV.VSL_CD       = RV.VSL_CD" ).append("\n"); 
		query.append("                AND     AV.SKD_VOY_NO   = RV.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     AV.SKD_DIR_CD   = RV.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND     AV.RLANE_DIR_CD = RV.REV_DIR_CD" ).append("\n"); 
		query.append("                AND     'S'            <> NVL(VP.SKD_CNG_STS_CD, 'X')" ).append("\n"); 
		query.append("                     -- ADDED 2010.05.07" ).append("\n"); 
		query.append("#if(${vvd}!='')" ).append("\n"); 
		query.append("                AND     RV.VSL_CD       = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                AND     RV.SKD_VOY_NO   = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                AND     RV.SKD_DIR_CD   = substr(@[vvd], 9)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                AND     AV.REV_YRMON    = RV.REV_YRMON" ).append("\n"); 
		query.append("                AND     VP.SLAN_CD      = NVL2(@[lane], @[lane], VP.SLAN_CD)" ).append("\n"); 
		query.append("                ) T1," ).append("\n"); 
		query.append("                PSO_TGT_YD_EXPN T2" ).append("\n"); 
		query.append("        WHERE   T1.PSO_BZTP_CD  = T2.PSO_BZTP_CD(+)" ).append("\n"); 
		query.append("        AND     T1.VSL_CD       = T2.VSL_CD     (+)" ).append("\n"); 
		query.append("        AND     T1.SKD_VOY_NO   = T2.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("        AND     T1.SKD_DIR_CD   = T2.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("        AND     T1.YD_CD        = T2.YD_CD      (+)" ).append("\n"); 
		query.append("        GROUP BY  T1.REV_YRMON, T1.LANE, T1.VSL_CD || T1.SKD_VOY_NO || T1.SKD_DIR_CD, T1.YD_CD " ).append("\n"); 
		query.append("    )  Z" ).append("\n"); 
		query.append("        ) X" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("#if(${mismatched}!='')" ).append("\n"); 
		query.append("AND     X.TXTCOLOR IN ('Blue', 'Red', 'Pink')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY   X.REV_YRMON, X.LANE, X.VVD,  X.CLPT_SEQ" ).append("\n"); 

	}
}