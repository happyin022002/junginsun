/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BudgetPortChargeMgtBCDBDAOsearchExpenseDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtBCDBDAOsearchExpenseDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchExpenseDetail 
	  * [2015.03.13]VNDR_SEQ (+) > VNDR_SEQ 로 변경, PENDULUM_YN 여부로 IN/OUT 추가
	  * [2016.04.18]ACCL_FLG=Y Add
	  * </pre>
	  */
	public BudgetPortChargeMgtBCDBDAOsearchExpenseDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_bztp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtBCDBDAOsearchExpenseDetailRSQL").append("\n"); 
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
		query.append("WITH V_PARAM AS (" ).append("\n"); 
		query.append("        SELECT @[vsl_cd]                        AS VSL_CD" ).append("\n"); 
		query.append("             , @[skd_voy_no]                    AS SKD_VOY_NO" ).append("\n"); 
		query.append("             , @[skd_dir_cd]                    AS SKD_DIR_CD" ).append("\n"); 
		query.append("             , @[yd_cd]                         AS YD_CD" ).append("\n"); 
		query.append("             , @[clpt_ind_seq]                  AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , REPLACE (@[exe_yrmon], '-', '')  AS EXE_YRMON" ).append("\n"); 
		query.append("             , NVL(@[pso_bztp_cd], '2')         AS PSO_BZTP_CD" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("     , V_PORT_SKD AS (" ).append("\n"); 
		query.append("#if(${hide_vrtl_port_flg} != '' && ${hide_vrtl_port_flg} =='Y')" ).append("\n"); 
		query.append("         /*hide virtual port checked case.*/" ).append("\n"); 
		query.append("        SELECT A.VSL_CD" ).append("\n"); 
		query.append("             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("             , A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , A.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("             , A.TURN_PORT_FLG" ).append("\n"); 
		query.append("             , DECODE(A.TURN_PORT_IND_CD,'N',DECODE(A.TURN_PORT_FLG,'Y','Y','N'),'Y') CHK_TURN_PORT_FLG" ).append("\n"); 
		query.append("             , A.SLAN_CD" ).append("\n"); 
		query.append("             , A.VPS_PORT_CD" ).append("\n"); 
		query.append("             , A.YD_CD" ).append("\n"); 
		query.append("             , TO_CHAR(A.VPS_ETD_DT,'YYYYMMDD') AS VPS_ETD_DT" ).append("\n"); 
		query.append("             , A.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("             , MAX(P.EXE_YRMON) AS EXE_YRMON" ).append("\n"); 
		query.append("             , MAX(P.PSO_BZTP_CD) AS PSO_BZTP_CD" ).append("\n"); 
		query.append("             , COUNT(G.RLANE_CD) AS CHK_GL_CNT" ).append("\n"); 
		query.append("             , SUM((SELECT COUNT(1)" ).append("\n"); 
		query.append("                          FROM PSO_PORT_EXPN_DIV E" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND E.SLAN_CD = A.SLAN_CD" ).append("\n"); 
		query.append("                           AND E.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND E.LOC_CD = A.VPS_PORT_CD" ).append("\n"); 
		query.append("                           AND E.RLANE_CD = G.RLANE_CD )) AS CHK_DIV_CNT" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("             , V_PARAM P" ).append("\n"); 
		query.append("             , GL_ESTM_REV_VVD G" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.VSL_CD                     = P.VSL_CD" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO                 = P.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD                 = P.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND A.YD_CD                      = P.YD_CD" ).append("\n"); 
		query.append("           AND A.CLPT_IND_SEQ               = P.CLPT_IND_SEQ" ).append("\n"); 
		query.append("           AND A.TURN_PORT_IND_CD           IN ('N', 'Y')" ).append("\n"); 
		query.append("           AND NVL(A.SKD_CNG_STS_CD, 'X')   <> 'S'" ).append("\n"); 
		query.append("           AND NVL(A.VT_ADD_CALL_FLG, 'N')  = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("           AND G.EXE_YRMON                  = P.EXE_YRMON" ).append("\n"); 
		query.append("           AND A.VSL_CD                     = G.VSL_CD" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO                 = G.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD                 = G.SKD_DIR_CD" ).append("\n"); 
		query.append("         GROUP BY A.VSL_CD" ).append("\n"); 
		query.append("             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("             , A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , A.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("             , A.TURN_PORT_FLG" ).append("\n"); 
		query.append("             , DECODE(A.TURN_PORT_IND_CD,'N',DECODE(A.TURN_PORT_FLG,'Y','Y','N'),'Y')" ).append("\n"); 
		query.append("             , A.SLAN_CD" ).append("\n"); 
		query.append("             , A.VPS_PORT_CD" ).append("\n"); 
		query.append("             , A.YD_CD" ).append("\n"); 
		query.append("             , TO_CHAR(A.VPS_ETD_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("             , A.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT A.VSL_CD" ).append("\n"); 
		query.append("             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("             , A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , A.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("             , A.TURN_PORT_FLG" ).append("\n"); 
		query.append("             , DECODE(A.TURN_PORT_IND_CD,'N',DECODE(A.TURN_PORT_FLG,'Y','Y','N'),'Y') CHK_TURN_PORT_FLG" ).append("\n"); 
		query.append("             , A.SLAN_CD" ).append("\n"); 
		query.append("             , A.VPS_PORT_CD" ).append("\n"); 
		query.append("             , A.YD_CD" ).append("\n"); 
		query.append("             , TO_CHAR(A.VPS_ETD_DT,'YYYYMMDD') AS VPS_ETD_DT" ).append("\n"); 
		query.append("             , A.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("             , MAX(P.EXE_YRMON) AS EXE_YRMON" ).append("\n"); 
		query.append("             , MAX(P.PSO_BZTP_CD) AS PSO_BZTP_CD" ).append("\n"); 
		query.append("             , COUNT(G.RLANE_CD) AS CHK_GL_CNT" ).append("\n"); 
		query.append("             , SUM((SELECT COUNT(1)" ).append("\n"); 
		query.append("                          FROM PSO_PORT_EXPN_DIV E" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND E.SLAN_CD = A.SLAN_CD" ).append("\n"); 
		query.append("                           AND E.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND E.LOC_CD = A.VPS_PORT_CD" ).append("\n"); 
		query.append("                           AND E.RLANE_CD = G.RLANE_CD )) AS CHK_DIV_CNT" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("             , V_PARAM P" ).append("\n"); 
		query.append("             , GL_ESTM_REV_VVD G" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.VSL_CD                     = P.VSL_CD" ).append("\n"); 
		query.append("           AND A.TURN_SKD_VOY_NO            = P.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND A.TURN_SKD_DIR_CD            = P.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND A.YD_CD                      = P.YD_CD" ).append("\n"); 
		query.append("           AND A.TURN_CLPT_IND_SEQ          = P.CLPT_IND_SEQ" ).append("\n"); 
		query.append("           AND A.TURN_PORT_IND_CD           IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("           AND NVL(A.SKD_CNG_STS_CD, 'X')   <> 'S'" ).append("\n"); 
		query.append("           AND NVL(A.VT_ADD_CALL_FLG, 'N')  = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("           AND G.EXE_YRMON                  = P.EXE_YRMON" ).append("\n"); 
		query.append("           AND A.VSL_CD                     = G.VSL_CD" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO                 = G.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD                 = G.SKD_DIR_CD" ).append("\n"); 
		query.append("         GROUP BY A.VSL_CD" ).append("\n"); 
		query.append("             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("             , A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , A.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("             , A.TURN_PORT_FLG" ).append("\n"); 
		query.append("             , DECODE(A.TURN_PORT_IND_CD,'N',DECODE(A.TURN_PORT_FLG,'Y','Y','N'),'Y')" ).append("\n"); 
		query.append("             , A.SLAN_CD" ).append("\n"); 
		query.append("             , A.VPS_PORT_CD" ).append("\n"); 
		query.append("             , A.YD_CD" ).append("\n"); 
		query.append("             , TO_CHAR(A.VPS_ETD_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("             , A.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        /*hide virtual port unchecked case.*/" ).append("\n"); 
		query.append("        SELECT A.VSL_CD" ).append("\n"); 
		query.append("             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("             , A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , A.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("             , A.TURN_PORT_FLG" ).append("\n"); 
		query.append("             , DECODE(A.TURN_PORT_IND_CD,'N',DECODE(A.TURN_PORT_FLG,'Y','Y','N'),'Y') CHK_TURN_PORT_FLG" ).append("\n"); 
		query.append("             , A.SLAN_CD" ).append("\n"); 
		query.append("             , A.VPS_PORT_CD" ).append("\n"); 
		query.append("             , A.YD_CD" ).append("\n"); 
		query.append("             , TO_CHAR(A.VPS_ETD_DT,'YYYYMMDD') AS VPS_ETD_DT" ).append("\n"); 
		query.append("             , A.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("             , MAX(P.EXE_YRMON) AS EXE_YRMON" ).append("\n"); 
		query.append("             , MAX(P.PSO_BZTP_CD) AS PSO_BZTP_CD" ).append("\n"); 
		query.append("             , COUNT(G.RLANE_CD) AS CHK_GL_CNT" ).append("\n"); 
		query.append("             , SUM((SELECT COUNT(1)" ).append("\n"); 
		query.append("                          FROM PSO_PORT_EXPN_DIV E" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND E.SLAN_CD = A.SLAN_CD" ).append("\n"); 
		query.append("                           AND E.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND E.LOC_CD = A.VPS_PORT_CD" ).append("\n"); 
		query.append("                           AND E.RLANE_CD = G.RLANE_CD )) AS CHK_DIV_CNT" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("             , V_PARAM P" ).append("\n"); 
		query.append("             , GL_ESTM_REV_VVD G" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.VSL_CD                     = P.VSL_CD" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO                 = P.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD                 = P.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND A.YD_CD                      = P.YD_CD" ).append("\n"); 
		query.append("           AND A.CLPT_IND_SEQ               = P.CLPT_IND_SEQ" ).append("\n"); 
		query.append("           AND NVL(A.SKD_CNG_STS_CD, 'X')   <> 'S'" ).append("\n"); 
		query.append("           AND NVL(A.VT_ADD_CALL_FLG, 'N')  = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("           AND G.EXE_YRMON                  = P.EXE_YRMON" ).append("\n"); 
		query.append("           AND A.VSL_CD                     = G.VSL_CD" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO                 = G.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD                 = G.SKD_DIR_CD" ).append("\n"); 
		query.append("         GROUP BY A.VSL_CD" ).append("\n"); 
		query.append("             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("             , A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , A.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("             , A.TURN_PORT_FLG" ).append("\n"); 
		query.append("             , DECODE(A.TURN_PORT_IND_CD,'N',DECODE(A.TURN_PORT_FLG,'Y','Y','N'),'Y')" ).append("\n"); 
		query.append("             , A.SLAN_CD" ).append("\n"); 
		query.append("             , A.VPS_PORT_CD" ).append("\n"); 
		query.append("             , A.YD_CD" ).append("\n"); 
		query.append("             , TO_CHAR(A.VPS_ETD_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("             , A.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("--SELECT * FROM V_PORT_SKD;" ).append("\n"); 
		query.append("     , V_PENDULUM AS (" ).append("\n"); 
		query.append("        SELECT V.VSL_CD" ).append("\n"); 
		query.append("             , V.SKD_VOY_NO" ).append("\n"); 
		query.append("             , V.SKD_DIR_CD" ).append("\n"); 
		query.append("             , V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , V.VPS_PORT_CD" ).append("\n"); 
		query.append("             , V.YD_CD" ).append("\n"); 
		query.append("             , V.CHK_TURN_PORT_FLG" ).append("\n"); 
		query.append("             , V.SLAN_CD" ).append("\n"); 
		query.append("             , D.REV_DIR_CD RLANE_DIR_CD" ).append("\n"); 
		query.append("             , COUNT(1) OVER (PARTITION BY D.LOC_CD) AS CNT" ).append("\n"); 
		query.append("          FROM PSO_PORT_EXPN_DIV D" ).append("\n"); 
		query.append("             , V_PORT_SKD V" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND V.SLAN_CD        = D.SLAN_CD" ).append("\n"); 
		query.append("           AND V.SKD_DIR_CD     = D.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND V.VPS_PORT_CD    = D.LOC_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("--SELECT * FROM V_PENDULUM;" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*1개의 Vendor : CPLS_FLG 가 N 상관없이 대상, 2개 Vendor 일때는 CPLS_FLG Y 인 대상*/" ).append("\n"); 
		query.append("     , V_PSO_YD_CHG AS (" ).append("\n"); 
		query.append("        SELECT VSL_CD" ).append("\n"); 
		query.append("             , SKD_VOY_NO" ).append("\n"); 
		query.append("             , SKD_DIR_CD" ).append("\n"); 
		query.append("             , CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , YD_CHG_NO" ).append("\n"); 
		query.append("             , YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("             , CURR_CD" ).append("\n"); 
		query.append("             , YD_CD" ).append("\n"); 
		query.append("             , LGS_COST_CD" ).append("\n"); 
		query.append("             , VNDR_SEQ" ).append("\n"); 
		query.append("             , EFF_DT" ).append("\n"); 
		query.append("             , EXP_DT" ).append("\n"); 
		query.append("          FROM (SELECT V.VSL_CD" ).append("\n"); 
		query.append("                     , V.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , V.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     , C.YD_CD" ).append("\n"); 
		query.append("                     , C.LGS_COST_CD" ).append("\n"); 
		query.append("                     , C.VNDR_SEQ" ).append("\n"); 
		query.append("                     , C.CPLS_FLG" ).append("\n"); 
		query.append("                     , C.EFF_DT" ).append("\n"); 
		query.append("                     , C.EXP_DT" ).append("\n"); 
		query.append("                     , MAX (C.YD_CHG_NO) YD_CHG_NO" ).append("\n"); 
		query.append("                     , MAX (C.YD_CHG_VER_SEQ) YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                     , SUBSTR (MAX (C.YD_CHG_VER_SEQ || CURR_CD), -3) AS CURR_CD" ).append("\n"); 
		query.append("                     , COUNT( * ) OVER (PARTITION BY V.VSL_CD , V.SKD_VOY_NO , V.SKD_DIR_CD , V.CLPT_IND_SEQ, C.YD_CD, C.LGS_COST_CD" ).append("\n"); 
		query.append("                                            ORDER BY V.VSL_CD , V.SKD_VOY_NO , V.SKD_DIR_CD , V.CLPT_IND_SEQ, C.YD_CD, C.LGS_COST_CD) AS CNT" ).append("\n"); 
		query.append("                  FROM PSO_YD_CHG C" ).append("\n"); 
		query.append("                     , V_PORT_SKD V" ).append("\n"); 
		query.append("                     , MDM_VENDOR M" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND C.YD_CD      = V.YD_CD" ).append("\n"); 
		query.append("                   AND TO_DATE(V.VPS_ETD_DT,'YYYYMMDD') BETWEEN C.EFF_DT AND C.EXP_DT" ).append("\n"); 
		query.append("                   AND C.VNDR_SEQ   = M.VNDR_SEQ" ).append("\n"); 
		query.append("                 GROUP BY V.VSL_CD" ).append("\n"); 
		query.append("                     , V.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , V.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     , C.YD_CD" ).append("\n"); 
		query.append("                     , C.LGS_COST_CD" ).append("\n"); 
		query.append("                     , C.VNDR_SEQ" ).append("\n"); 
		query.append("                     , C.CPLS_FLG" ).append("\n"); 
		query.append("                     , C.EFF_DT" ).append("\n"); 
		query.append("                     , C.EXP_DT" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("         WHERE (CASE WHEN CNT >= 2 THEN 'Y' ELSE CPLS_FLG END) = CPLS_FLG" ).append("\n"); 
		query.append("            /*2016.04.18 Add : Accrual 대상 만 진행함.*/" ).append("\n"); 
		query.append("           AND EXISTS ( SELECT 'Y'" ).append("\n"); 
		query.append("                          FROM SCO_AP_COST_ACT_INFO SACAI" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND SACAI.SRC_MDL_CD = 'PSO'" ).append("\n"); 
		query.append("                           AND NVL(SACAI.ENBL_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                           AND NVL(SACAI.ACCL_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("                           AND SACAI.ACT_COST_CD = LGS_COST_CD)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("--SELECT *  FROM V_PSO_YD_CHG;" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.*" ).append("\n"); 
		query.append("  FROM (SELECT T.REV_YRMON AS EXPN_YRMON" ).append("\n"); 
		query.append("             , T.VSL_SLAN_CD" ).append("\n"); 
		query.append("             , T.VSL_CD ||T.SKD_VOY_NO ||T.SKD_DIR_CD||T.REV_DIR_CD VVD" ).append("\n"); 
		query.append("             , T.REV_DIR_CD" ).append("\n"); 
		query.append("             , T.YD_CD" ).append("\n"); 
		query.append("             , T.ACCT_CD" ).append("\n"); 
		query.append("             , (SELECT MC.ACCT_ENG_NM" ).append("\n"); 
		query.append("                  FROM MDM_ACCOUNT MC" ).append("\n"); 
		query.append("                 WHERE MC.ACCT_CD = T.ACCT_CD" ).append("\n"); 
		query.append("                   AND ROWNUM = 1 ) ACCT_ENG_NM" ).append("\n"); 
		query.append("             , T.LGS_COST_CD" ).append("\n"); 
		query.append("             , (SELECT TLC.LGS_COST_FULL_NM" ).append("\n"); 
		query.append("                  FROM TES_LGS_COST TLC" ).append("\n"); 
		query.append("                 WHERE TLC.LGS_COST_CD = T.LGS_COST_CD" ).append("\n"); 
		query.append("                   AND ROWNUM=1) LGS_COST_FULL_NM" ).append("\n"); 
		query.append("             , T.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("             , T.TURN_PORT_FLG" ).append("\n"); 
		query.append("             , T.PENDULUM_YN" ).append("\n"); 
		query.append("             , IO_BND_CD CHK_IO_BND_CD" ).append("\n"); 
		query.append("             , T.CHK_GL_CNT" ).append("\n"); 
		query.append("             , T.CHK_DIV_CNT" ).append("\n"); 
		query.append("             , T.CHK_TURN_PORT_FLG" ).append("\n"); 
		query.append("             , T.CHK_TURN_PORT_IND_CD" ).append("\n"); 
		query.append("             , CASE WHEN T.CHK_GL_CNT > 1 AND T.CHK_DIV_CNT = 0 THEN DECODE(IO_BND_CD, 'I', 'IN', 'O', 'OUT','IN/OUT') /*is Pendulum In GL*/" ).append("\n"); 
		query.append("                    ELSE DECODE(IO_BND_CD, 'I', 'IN', 'O', DECODE(T.TURN_PORT_IND_CD,'N',DECODE(T.TURN_PORT_FLG,'Y','OUT', DECODE(PENDULUM_YN,'Y','OUT','IN/OUT')),'OUT'), 'IN/OUT') /*Not Pendulum*/" ).append("\n"); 
		query.append("               END IO_BND_CD" ).append("\n"); 
		query.append("             , DECODE(IO_BND_CD, 'I', 'IN', 'O', DECODE(T.TURN_PORT_IND_CD,'N',DECODE(T.TURN_PORT_FLG,'Y','OUT', DECODE(PENDULUM_YN,'Y','OUT','IN/OUT')),'OUT'), 'IN/OUT') IO_BND_CD2 /*2009.11.18 MODIFIED*/" ).append("\n"); 
		query.append("             , INV_USD_AMT" ).append("\n"); 
		query.append("             , T.VSL_CD" ).append("\n"); 
		query.append("             , T.SKD_VOY_NO" ).append("\n"); 
		query.append("             , T.SKD_DIR_CD" ).append("\n"); 
		query.append("             , '' SDT" ).append("\n"); 
		query.append("             , '' EDT" ).append("\n"); 
		query.append("             , '' MATCH_FLAG" ).append("\n"); 
		query.append("             , '' REV_YRMON" ).append("\n"); 
		query.append("             , LOCL_CURR_CD" ).append("\n"); 
		query.append("             , INV_LOCL_AMT" ).append("\n"); 
		query.append("             , '' PSO_BZTP_CD" ).append("\n"); 
		query.append("             , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                 WHERE INTG_CD_ID = 'CD01393'" ).append("\n"); 
		query.append("                   AND INTG_CD_VAL_CTNT = T.SKD_CNG_STS_CD) SKD_CNG_STS_CD" ).append("\n"); 
		query.append("             , E.XPR_DESC" ).append("\n"); 
		query.append("             , E.FOML_DESC" ).append("\n"); 
		query.append("             , T.VNDR_SEQ" ).append("\n"); 
		query.append("             , V.VNDR_LGL_ENG_NM VNDR_NM" ).append("\n"); 
		query.append("          FROM (SELECT DISTINCT T1.PSO_BZTP_CD" ).append("\n"); 
		query.append("                     , T1.EXPN_YRMON" ).append("\n"); 
		query.append("                     , T1.VSL_CD" ).append("\n"); 
		query.append("                     , T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("                     , C.YD_CD" ).append("\n"); 
		query.append("                     , A.ACCT_CD" ).append("\n"); 
		query.append("                     , C.LGS_COST_CD --,T1.VSL_CNTR_CLSS_CAPA CLSS : 추가 예정임" ).append("\n"); 
		query.append("                     , C.VNDR_SEQ" ).append("\n"); 
		query.append("                     , G.REV_YRMON" ).append("\n"); 
		query.append("                     , G.REV_DIR_CD" ).append("\n"); 
		query.append("                     , G.RLANE_CD" ).append("\n"); 
		query.append("                     , NVL((SELECT CASE WHEN P.CNT > 0 THEN 'Y'" ).append("\n"); 
		query.append("                                        ELSE 'N'" ).append("\n"); 
		query.append("                                   END" ).append("\n"); 
		query.append("                                  FROM V_PENDULUM P" ).append("\n"); 
		query.append("                            WHERE 1=1" ).append("\n"); 
		query.append("                              AND P.VSL_CD         = V.VSL_CD" ).append("\n"); 
		query.append("                              AND P.SKD_VOY_NO     = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                              AND P.SKD_DIR_CD     = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                              AND P.CLPT_IND_SEQ   = V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                              AND P.VPS_PORT_CD    = SUBSTR(C.YD_CD,1 , 5)" ).append("\n"); 
		query.append("                              AND ROWNUM = 1 ), 'N') AS PENDULUM_YN" ).append("\n"); 
		query.append("                     , V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     , V.CHK_GL_CNT" ).append("\n"); 
		query.append("                     , V.CHK_DIV_CNT" ).append("\n"); 
		query.append("                     , V.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                     , V.TURN_PORT_FLG" ).append("\n"); 
		query.append("                     , V.CHK_TURN_PORT_FLG" ).append("\n"); 
		query.append("                     , V.TURN_PORT_IND_CD AS CHK_TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                     , V.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("                  FROM PSO_TGT_VVD T1" ).append("\n"); 
		query.append("                     , V_PSO_YD_CHG C" ).append("\n"); 
		query.append("                     , TES_LGS_COST A" ).append("\n"); 
		query.append("                     , GL_ESTM_REV_VVD G" ).append("\n"); 
		query.append("                     , V_PORT_SKD V" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND T1.PSO_BZTP_CD   = V.PSO_BZTP_CD" ).append("\n"); 
		query.append("                   AND T1.VSL_CD        = V.VSL_CD" ).append("\n"); 
		query.append("                   AND T1.SKD_VOY_NO    = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND T1.SKD_DIR_CD    = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND V.VSL_CD         = C.VSL_CD" ).append("\n"); 
		query.append("                   AND V.SKD_VOY_NO     = C.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND V.SKD_DIR_CD     = C.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND V.CLPT_IND_SEQ   = C.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                   AND V.YD_CD          = C.YD_CD" ).append("\n"); 
		query.append("                   AND C.LGS_COST_CD    = A.LGS_COST_CD" ).append("\n"); 
		query.append("                   AND G.EXE_YRMON      = V.EXE_YRMON" ).append("\n"); 
		query.append("                   AND G.VSL_CD         = T1.VSL_CD" ).append("\n"); 
		query.append("                   AND G.SKD_VOY_NO     = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND G.SKD_DIR_CD     = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                    /*2015.07.03 Pendulum Yd_cd 일때는 Pendulum Rlane_dir_cd 일치, 그렇지 않을 경우는 GL의 Rev_dir_cd 를 조건으로 한다.*/" ).append("\n"); 
		query.append("                   AND G.REV_DIR_CD IN (SELECT G.REV_DIR_CD" ).append("\n"); 
		query.append("                                          FROM DUAL" ).append("\n"); 
		query.append("                                         WHERE 1 = (SELECT CASE WHEN COUNT(*) > 0 THEN -1" ).append("\n"); 
		query.append("                                                                ELSE 1" ).append("\n"); 
		query.append("                                                           END" ).append("\n"); 
		query.append("                                                      FROM V_PENDULUM P" ).append("\n"); 
		query.append("                                                     WHERE 1=1" ).append("\n"); 
		query.append("                                                       AND P.VSL_CD         = V.VSL_CD" ).append("\n"); 
		query.append("                                                       AND P.SKD_VOY_NO     = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                       AND P.SKD_DIR_CD     = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                       AND P.CLPT_IND_SEQ   = V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                       AND P.VPS_PORT_CD    = SUBSTR(V.YD_CD,1 , 5))" ).append("\n"); 
		query.append("                                        UNION ALL" ).append("\n"); 
		query.append("                                        SELECT P.RLANE_DIR_CD" ).append("\n"); 
		query.append("                                          FROM V_PENDULUM P" ).append("\n"); 
		query.append("                                         WHERE 1=1" ).append("\n"); 
		query.append("                                           AND P.VSL_CD         = V.VSL_CD" ).append("\n"); 
		query.append("                                           AND P.SKD_VOY_NO     = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                           AND P.SKD_DIR_CD     = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                           AND P.CLPT_IND_SEQ   = V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                           AND P.VPS_PORT_CD    = SUBSTR(V.YD_CD,1 , 5)" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("               ) T" ).append("\n"); 
		query.append("             , PSO_TGT_YD_EXPN E" ).append("\n"); 
		query.append("             , MDM_VENDOR V" ).append("\n"); 
		query.append("         WHERE T.VSL_CD         = E.VSL_CD(+)" ).append("\n"); 
		query.append("           AND T.SKD_VOY_NO     = E.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND T.SKD_DIR_CD     = E.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND T.RLANE_CD       = E.RLANE_CD(+)" ).append("\n"); 
		query.append("           AND T.PSO_BZTP_CD    = E.PSO_BZTP_CD(+)" ).append("\n"); 
		query.append("           AND T.YD_CD          = E.YD_CD(+)" ).append("\n"); 
		query.append("           AND T.CLPT_IND_SEQ   = E.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("           AND T.LGS_COST_CD    = E.LGS_COST_CD(+)" ).append("\n"); 
		query.append("           AND T.REV_YRMON      = E.REV_YRMON(+)" ).append("\n"); 
		query.append("           AND T.VNDR_SEQ       = E.VNDR_SEQ(+) -- 과거 데이타에는 VENDOR 가 0 으로 되어 있어서 해당 데이타 조회를 위해 OUTER 조인함" ).append("\n"); 
		query.append("           AND T.VNDR_SEQ       = V.VNDR_SEQ" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.CHK_IO_BND_CD IS NOT NULL" ).append("\n"); 
		query.append("   /*GL에만 등록된 Pendrum 일때와 기존 로직 분기.*/" ).append("\n"); 
		query.append("   --AND A.IO_BND_CD = (CASE WHEN CHK.CHK_GL_CNT > 1 AND CHK.CHK_DIV_CNT = 0 THEN DECODE(CHK.CHK_TURN_PORT_FLG,'Y',DECODE(CHK.CHK_TURN_PORT_IND_CD,'N','OUT','Y','OUT', 'IN'),'IN/OUT')  ELSE A.IO_BND_CD  END )" ).append("\n"); 
		query.append("#if(${match_flag} == 'unmatch')" ).append("\n"); 
		query.append("   AND NVL(A.INV_USD_AMT,0)  = 0           -- Mismatch" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${match_flag} == 'match')" ).append("\n"); 
		query.append("   AND NVL(A.INV_USD_AMT,0)  > 0           -- Match" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${hide_vrtl_port_flg} != '' && ${hide_vrtl_port_flg} =='Y')" ).append("\n"); 
		query.append(" /*hide virtual port checked case*/" ).append("\n"); 
		query.append(" ORDER BY A.VSL_SLAN_CD, A.ACCT_CD, A.LGS_COST_CD, A.VNDR_SEQ, A.IO_BND_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.YD_CD, A.EXPN_YRMON, A.REV_DIR_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" /*hide virtual port unchecked case.*/" ).append("\n"); 
		query.append(" ORDER BY A.VSL_SLAN_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.YD_CD, A.ACCT_CD, A.LGS_COST_CD, A.VNDR_SEQ, A.EXPN_YRMON, A.REV_DIR_CD, A.IO_BND_CD DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}