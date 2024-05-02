/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOgetIoRatioForPendulumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.28 
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

public class BudgetPortChargeMgtDBDAOgetIoRatioForPendulumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pendulum io ration 조회
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOgetIoRatioForPendulumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : BudgetPortChargeMgtDBDAOgetIoRatioForPendulumRSQL").append("\n"); 
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
		query.append("-- IoRatio VO" ).append("\n"); 
		query.append("WITH V_PARAM AS ( --NAET0071E" ).append("\n"); 
		query.append("    SELECT @[vsl_cd]       AS VSL_CD" ).append("\n"); 
		query.append("         , @[skd_voy_no]    AS SKD_VOY_NO" ).append("\n"); 
		query.append("         , @[skd_dir_cd]    AS SKD_DIR_CD" ).append("\n"); 
		query.append("         , @[yd_cd]         AS YD_CD" ).append("\n"); 
		query.append("         , REPLACE (@[exe_yrmon], '-', '')         AS EXE_YRMON" ).append("\n"); 
		query.append("         , NVL(@[clpt_ind_seq],(SELECT MIN(P.CLPT_IND_SEQ)" ).append("\n"); 
		query.append("                      FROM VSK_VSL_PORT_SKD P" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND P.VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("                       AND P.SKD_VOY_NO     = @[skd_voy_no]" ).append("\n"); 
		query.append("                       AND P.SKD_DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("                       AND P.YD_CD          = @[yd_cd]" ).append("\n"); 
		query.append("                       AND NVL(P.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/   " ).append("\n"); 
		query.append("                       AND NVL(P.SKD_CNG_STS_CD, ' ') != 'S' )) AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.TURN" ).append("\n"); 
		query.append("     , A.SLAN_CD" ).append("\n"); 
		query.append("     , A.VPS_PORT_CD" ).append("\n"); 
		query.append("     , A.RLANE_DIR_CD" ).append("\n"); 
		query.append("     , A.OB_RTO ORI_OB_RTO" ).append("\n"); 
		query.append("     , A.IB_RTO ORI_IB_RTO" ).append("\n"); 
		query.append("     , CASE WHEN A.OB_RTO_CNT = A.TOT_CNT AND A.TOT_CNT = 1 THEN DECODE(A.TURN, 'N', 100, 'Y', 50,  0) ELSE A.OB_RTO END AS OB_RTO" ).append("\n"); 
		query.append("     , CASE WHEN A.IB_RTO_CNT = A.TOT_CNT AND A.TOT_CNT = 1 THEN DECODE(A.TURN, 'N', 100, 'Y', 50,  0) ELSE A.IB_RTO END AS IB_RTO" ).append("\n"); 
		query.append("     , A.RLANE_CD" ).append("\n"); 
		query.append("     , A.REV_YRMON" ).append("\n"); 
		query.append("     , A.RLANE_RANK" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.*" ).append("\n"); 
		query.append("             , ROWNUM AS RNUM" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT A.*" ).append("\n"); 
		query.append("                  FROM ( " ).append("\n"); 
		query.append("                        SELECT VSL_CD" ).append("\n"); 
		query.append("                             , SKD_VOY_NO" ).append("\n"); 
		query.append("                             , SKD_DIR_CD" ).append("\n"); 
		query.append("                             , TURN" ).append("\n"); 
		query.append("                             , SLAN_CD" ).append("\n"); 
		query.append("                             , VPS_PORT_CD" ).append("\n"); 
		query.append("                             , RLANE_DIR_CD" ).append("\n"); 
		query.append("                             , OB_RTO" ).append("\n"); 
		query.append("                             , IB_RTO" ).append("\n"); 
		query.append("                             , RLANE_CD" ).append("\n"); 
		query.append("                             , REV_YRMON" ).append("\n"); 
		query.append("                             , RLANE_RANK" ).append("\n"); 
		query.append("                             , SUM(CASE WHEN OB_RTO > 0 THEN 1 ELSE 0 END) AS OB_RTO_CNT" ).append("\n"); 
		query.append("                             , SUM(CASE WHEN IB_RTO > 0 THEN 1 ELSE 0 END) AS IB_RTO_CNT" ).append("\n"); 
		query.append("                             , COUNT(A.VSL_CD) OVER () AS TOT_CNT" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT D.*" ).append("\n"); 
		query.append("                                  FROM (" ).append("\n"); 
		query.append("                                         --Monthly Estimated 의 경우" ).append("\n"); 
		query.append("                                        SELECT DISTINCT V.VSL_CD" ).append("\n"); 
		query.append("                                             , V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                             , V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                             , V.TURN TURN" ).append("\n"); 
		query.append("                                             , V.SLAN_CD" ).append("\n"); 
		query.append("                                             , V.VPS_PORT_CD" ).append("\n"); 
		query.append("                                             , D.REV_DIR_CD RLANE_DIR_CD" ).append("\n"); 
		query.append("                                             , DECODE (V.TURN, 'Y', 50,NVL(OB_RTO,100) ) OB_RTO" ).append("\n"); 
		query.append("                                             , DECODE (V.TURN, 'Y',  0,NVL(IB_RTO,  0) ) IB_RTO" ).append("\n"); 
		query.append("                                             , D.RLANE_CD" ).append("\n"); 
		query.append("                                             , (SELECT MAX(REV_YRMON)" ).append("\n"); 
		query.append("                                                  FROM GL_ESTM_REV_VVD B" ).append("\n"); 
		query.append("                                                 WHERE B.EXE_YRMON      = V.EXE_YRMON" ).append("\n"); 
		query.append("                                                   AND B.VSL_CD         = V.VSL_CD" ).append("\n"); 
		query.append("                                                   AND B.SKD_VOY_NO     = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                   AND B.SKD_DIR_CD     = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                   AND B.RLANE_CD       = D.RLANE_CD" ).append("\n"); 
		query.append("                                                   AND B.REV_DIR_CD     = D.REV_DIR_CD" ).append("\n"); 
		query.append("                                                ) AS REV_YRMON" ).append("\n"); 
		query.append("                                             , DENSE_RANK() OVER (ORDER BY D.REV_DIR_CD, D.RLANE_CD) RLANE_RANK" ).append("\n"); 
		query.append("                                          FROM PSO_PORT_EXPN_DIV D" ).append("\n"); 
		query.append("                                             , (SELECT DISTINCT A.VSL_CD" ).append("\n"); 
		query.append("                                                     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                     , DECODE(A.TURN_PORT_IND_CD,'N',DECODE(A.TURN_PORT_FLG,'Y','Y','N'),'Y') TURN" ).append("\n"); 
		query.append("                                                     , A.SLAN_CD" ).append("\n"); 
		query.append("                                                     , A.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                     , P.EXE_YRMON" ).append("\n"); 
		query.append("                                                  FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                                                     --, GL_ESTM_REV_VVD B" ).append("\n"); 
		query.append("                                                     , V_PARAM P" ).append("\n"); 
		query.append("                                                 WHERE 1=1" ).append("\n"); 
		query.append("                                                   AND A.VSL_CD         = P.VSL_CD" ).append("\n"); 
		query.append("                                                   AND A.SKD_VOY_NO     = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                   AND A.SKD_DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                   AND A.YD_CD          = P.YD_CD" ).append("\n"); 
		query.append("                                                   AND A.CLPT_IND_SEQ   = P.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                   AND A.TURN_PORT_IND_CD IN ('N', 'Y')" ).append("\n"); 
		query.append("                                                   AND NVL(A.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                                                   AND NVL(A.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/  " ).append("\n"); 
		query.append("                                               ) V" ).append("\n"); 
		query.append("                                         WHERE 1 = 1" ).append("\n"); 
		query.append("                                            /*pendulum Case.*/" ).append("\n"); 
		query.append("                                           AND V.SLAN_CD        = D.SLAN_CD" ).append("\n"); 
		query.append("                                           AND V.SKD_DIR_CD     = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                                           AND V.VPS_PORT_CD    = D.LOC_CD" ).append("\n"); 
		query.append("                                          ) D" ).append("\n"); 
		query.append("                                    WHERE 1=1" ).append("\n"); 
		query.append("                                      --AND RLANE_RANK = 1" ).append("\n"); 
		query.append("                                      " ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                 " ).append("\n"); 
		query.append("                                SELECT D.*" ).append("\n"); 
		query.append("                                  FROM (" ).append("\n"); 
		query.append("                                         --Monthly Estimated 의 경우" ).append("\n"); 
		query.append("                                        SELECT DISTINCT V.VSL_CD" ).append("\n"); 
		query.append("                                             , V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                             , V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                             , V.TURN TURN" ).append("\n"); 
		query.append("                                             , V.SLAN_CD" ).append("\n"); 
		query.append("                                             , V.VPS_PORT_CD" ).append("\n"); 
		query.append("                                             , D.REV_DIR_CD RLANE_DIR_CD" ).append("\n"); 
		query.append("                                             , DECODE (V.TURN, 'Y',  0,NVL(OB_RTO,  0) ) OB_RTO" ).append("\n"); 
		query.append("                                             , DECODE (V.TURN, 'Y', 50,NVL(IB_RTO,100) ) IB_RTO" ).append("\n"); 
		query.append("                                             , D.RLANE_CD" ).append("\n"); 
		query.append("                                             , (SELECT MAX(REV_YRMON)" ).append("\n"); 
		query.append("                                                  FROM GL_ESTM_REV_VVD B" ).append("\n"); 
		query.append("                                                 WHERE B.EXE_YRMON      = V.EXE_YRMON" ).append("\n"); 
		query.append("                                                   AND B.VSL_CD         = V.VSL_CD" ).append("\n"); 
		query.append("                                                   AND B.SKD_VOY_NO     = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                   AND B.SKD_DIR_CD     = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                   AND B.RLANE_CD       = D.RLANE_CD" ).append("\n"); 
		query.append("                                                   AND B.REV_DIR_CD     = D.REV_DIR_CD" ).append("\n"); 
		query.append("                                                ) AS REV_YRMON" ).append("\n"); 
		query.append("                                             , DENSE_RANK() OVER (ORDER BY D.REV_DIR_CD, D.RLANE_CD) RLANE_RANK" ).append("\n"); 
		query.append("                                          FROM PSO_PORT_EXPN_DIV D" ).append("\n"); 
		query.append("                                             , (SELECT DISTINCT V.VSL_CD" ).append("\n"); 
		query.append("                                                     , V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                     , V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                     , DECODE(V.TURN_PORT_IND_CD,'N',DECODE(V.TURN_PORT_FLG,'Y','Y','N'),'Y') AS TURN" ).append("\n"); 
		query.append("                                                     , V.SLAN_CD" ).append("\n"); 
		query.append("                                                     , V.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                     , P.EXE_YRMON" ).append("\n"); 
		query.append("                                                  FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                                                     --, GL_ESTM_REV_VVD B" ).append("\n"); 
		query.append("                                                     , V_PARAM P" ).append("\n"); 
		query.append("                                                 WHERE 1=1" ).append("\n"); 
		query.append("                                                   AND V.VSL_CD         = P.VSL_CD" ).append("\n"); 
		query.append("                                                   AND V.SKD_VOY_NO     = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                   AND V.SKD_DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                   AND V.YD_CD          = P.YD_CD" ).append("\n"); 
		query.append("                                                   AND V.CLPT_IND_SEQ   = P.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                   AND V.TURN_PORT_IND_CD IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("                                                   AND NVL(V.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                                                   AND NVL(V.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/  " ).append("\n"); 
		query.append("                                               ) V" ).append("\n"); 
		query.append("                                         WHERE 1 = 1" ).append("\n"); 
		query.append("                                            /*pendulum Case.*/" ).append("\n"); 
		query.append("                                           AND V.SLAN_CD        = D.SLAN_CD" ).append("\n"); 
		query.append("                                           AND V.SKD_DIR_CD     = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                                           AND V.VPS_PORT_CD    = D.LOC_CD" ).append("\n"); 
		query.append("                                          ) D" ).append("\n"); 
		query.append("                                    WHERE 1=1" ).append("\n"); 
		query.append("                                      --AND RLANE_RANK = 1                                    " ).append("\n"); 
		query.append("                                ) A" ).append("\n"); 
		query.append("                          GROUP BY VSL_CD" ).append("\n"); 
		query.append("                             , SKD_VOY_NO" ).append("\n"); 
		query.append("                             , SKD_DIR_CD" ).append("\n"); 
		query.append("                             , TURN" ).append("\n"); 
		query.append("                             , SLAN_CD" ).append("\n"); 
		query.append("                             , VPS_PORT_CD" ).append("\n"); 
		query.append("                             , RLANE_DIR_CD" ).append("\n"); 
		query.append("                             , OB_RTO" ).append("\n"); 
		query.append("                             , IB_RTO" ).append("\n"); 
		query.append("                             , RLANE_CD" ).append("\n"); 
		query.append("                             , REV_YRMON" ).append("\n"); 
		query.append("                             , RLANE_RANK" ).append("\n"); 
		query.append("                       ) A" ).append("\n"); 
		query.append("                 ORDER BY A.RLANE_RANK" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND ROWNUM < 3 /*2건 이하의 Row를 리턴하게 한다.*/" ).append("\n"); 
		query.append("         ORDER BY OB_RTO DESC, A.RLANE_RANK" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" ORDER BY A.OB_RTO DESC" ).append("\n"); 

	}
}