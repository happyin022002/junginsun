/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOgetIoRatioRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.26 
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

public class BudgetPortChargeMgtDBDAOgetIoRatioRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getIoRatio
	  * [2015.03.11]REV_YRMON > EXE_YRMON 변경 
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOgetIoRatioRSQL(){
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
		query.append("FileName : BudgetPortChargeMgtDBDAOgetIoRatioRSQL").append("\n"); 
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
		query.append(", V_CHK_PENDULUM AS (" ).append("\n"); 
		query.append("    /* Y : AR Rev Lane 2Row Data(Pendulum Data) & PSO_PORT_EXPN_DIV 에 등록 되지 않았을때. N : Normal Data or AR Rev Lane 1Row Data*/" ).append("\n"); 
		query.append("    SELECT CASE WHEN CHK_PEND_CNT > 1 AND CHK_DIV_CNT = 0 THEN 'Y'" ).append("\n"); 
		query.append("                ELSE 'N'" ).append("\n"); 
		query.append("           END AS NOT_USED_PEND_YN" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT COUNT(B.RLANE_CD) AS CHK_PEND_CNT" ).append("\n"); 
		query.append("                 , SUM((SELECT COUNT(1)" ).append("\n"); 
		query.append("                          FROM PSO_PORT_EXPN_DIV E" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND E.SLAN_CD    = A.SLAN_CD" ).append("\n"); 
		query.append("                           AND E.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND E.LOC_CD     = A.VPS_PORT_CD" ).append("\n"); 
		query.append("                           AND E.RLANE_CD   = B.RLANE_CD )) AS CHK_DIV_CNT" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                 , GL_ESTM_REV_VVD B" ).append("\n"); 
		query.append("                 , V_PARAM V" ).append("\n"); 
		query.append("             WHERE A.VSL_CD         = B.VSL_CD" ).append("\n"); 
		query.append("               AND A.SKD_VOY_NO     = B.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND A.SKD_DIR_CD     = B.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND A.VSL_CD         = V.VSL_CD" ).append("\n"); 
		query.append("               AND A.SKD_VOY_NO     = V.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND A.SKD_DIR_CD     = V.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND A.YD_CD          = V.YD_CD" ).append("\n"); 
		query.append("               AND B.EXE_YRMON      = V.EXE_YRMON" ).append("\n"); 
		query.append("               AND A.CLPT_IND_SEQ   = V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("               AND NVL(A.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("               AND NVL(A.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("--SELECT * FROM V_CHK_PENDULUM;" ).append("\n"); 
		query.append("SELECT A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.TURN" ).append("\n"); 
		query.append("     , A.SLAN_CD" ).append("\n"); 
		query.append("     , A.VPS_PORT_CD" ).append("\n"); 
		query.append("     , A.RLANE_DIR_CD" ).append("\n"); 
		query.append("     , A.OB_RTO ORI_OB_RTO" ).append("\n"); 
		query.append("     , A.IB_RTO ORI_IB_RTO" ).append("\n"); 
		query.append("     , CASE WHEN CHK.NOT_USED_PEND_YN = 'Y' AND A.OB_RTO_CNT = A.TOT_CNT THEN DECODE(A.TURN, 'N', DECODE(RNUM , 1, 50, 0), 'Y', 50,  0) ELSE A.OB_RTO END AS OB_RTO" ).append("\n"); 
		query.append("     , CASE WHEN CHK.NOT_USED_PEND_YN = 'Y' AND A.OB_RTO_CNT = A.TOT_CNT THEN DECODE(A.TURN, 'N', DECODE(RNUM , 2, 50, 0), 'Y',  0, 50) ELSE A.IB_RTO END AS IB_RTO" ).append("\n"); 
		query.append("     , A.RLANE_CD" ).append("\n"); 
		query.append("     , A.REV_YRMON" ).append("\n"); 
		query.append("     , A.RLANE_RANK" ).append("\n"); 
		query.append("     , CHK.NOT_USED_PEND_YN" ).append("\n"); 
		query.append("     , CASE WHEN CHK.NOT_USED_PEND_YN = 'Y' AND A.OB_RTO_CNT = A.TOT_CNT AND A.TURN NOT IN ('N', 'Y') THEN 1 ELSE 3 END AS CNK_ROW_CNT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.*" ).append("\n"); 
		query.append("             , COUNT(A.OB_RTO) OVER (PARTITION BY OB_RTO) AS OB_RTO_CNT /*OB Ratio 100 Count*/" ).append("\n"); 
		query.append("             , COUNT(A.VSL_CD) OVER () AS TOT_CNT /*전체 Row Count*/" ).append("\n"); 
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
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                --Monthly Estimated 의 경우" ).append("\n"); 
		query.append("                                SELECT DISTINCT V.VSL_CD" ).append("\n"); 
		query.append("                                     , V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                     , V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                     , V.TURN TURN" ).append("\n"); 
		query.append("                                     , V.SLAN_CD" ).append("\n"); 
		query.append("                                     , V.VPS_PORT_CD" ).append("\n"); 
		query.append("                                     , V.REV_DIR_CD RLANE_DIR_CD" ).append("\n"); 
		query.append("                                     , DECODE (V.TURN, 'Y', 50,NVL(OB_RTO,100) ) OB_RTO" ).append("\n"); 
		query.append("                                     , DECODE (V.TURN, 'Y', 0,NVL(IB_RTO,0) ) IB_RTO" ).append("\n"); 
		query.append("                                     , V.RLANE_CD" ).append("\n"); 
		query.append("                                     , V.REV_YRMON AS REV_YRMON" ).append("\n"); 
		query.append("                                     , DENSE_RANK() OVER (ORDER BY V.REV_DIR_CD, V.RLANE_CD) RLANE_RANK" ).append("\n"); 
		query.append("                                  FROM PSO_PORT_EXPN_DIV D" ).append("\n"); 
		query.append("                                     , (SELECT DISTINCT A.VSL_CD" ).append("\n"); 
		query.append("                                             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                             , B.REV_DIR_CD" ).append("\n"); 
		query.append("                                             , A.TURN_PORT_FLG TURN" ).append("\n"); 
		query.append("                                             , A.SLAN_CD" ).append("\n"); 
		query.append("                                             , A.VPS_PORT_CD" ).append("\n"); 
		query.append("                                             , B.RLANE_CD" ).append("\n"); 
		query.append("                                             , B.REV_YRMON" ).append("\n"); 
		query.append("                                          FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                                             , GL_ESTM_REV_VVD B" ).append("\n"); 
		query.append("                                             , V_PARAM P" ).append("\n"); 
		query.append("                                         WHERE A.VSL_CD         = B.VSL_CD" ).append("\n"); 
		query.append("                                           AND A.SKD_VOY_NO     = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                                           AND A.SKD_DIR_CD     = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                                           AND A.VSL_CD         = P.VSL_CD" ).append("\n"); 
		query.append("                                           AND A.SKD_VOY_NO     = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                                           AND A.SKD_DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                                           AND A.YD_CD          = P.YD_CD" ).append("\n"); 
		query.append("                                           AND A.CLPT_IND_SEQ   = P.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                           AND B.EXE_YRMON      = P.EXE_YRMON" ).append("\n"); 
		query.append("                                           AND A.TURN_PORT_IND_CD IN ('N', 'Y')" ).append("\n"); 
		query.append("                                           AND NVL(A.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                                           AND NVL(A.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/  " ).append("\n"); 
		query.append("                                            -- Pendulum 의 경우면서 TURN = Y 인 경우 Outbound 쪽만 계산함" ).append("\n"); 
		query.append("                                           AND B.RLANE_CD = DECODE(A.TURN_PORT_FLG,'Y',PSO_GET_REV_LANE_FNC(A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD,A.VPS_PORT_CD ),B.RLANE_CD)" ).append("\n"); 
		query.append("                                       ) V" ).append("\n"); 
		query.append("                                 WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${pend_flg} != '' && ${pend_flg} == 'Y') " ).append("\n"); 
		query.append("			/*pendulum Case.*/" ).append("\n"); 
		query.append("                                   AND V.SLAN_CD        = D.SLAN_CD" ).append("\n"); 
		query.append("                                   AND V.SKD_DIR_CD     = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND V.VPS_PORT_CD    = D.LOC_CD" ).append("\n"); 
		query.append("                                   AND V.RLANE_CD       = D.RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                   /*pendulum not case.*/" ).append("\n"); 
		query.append("                                   AND V.SLAN_CD        = D.SLAN_CD(+)" ).append("\n"); 
		query.append("                                   AND V.SKD_DIR_CD     = D.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                                   AND V.VPS_PORT_CD    = D.LOC_CD(+)" ).append("\n"); 
		query.append("                                   AND V.RLANE_CD       = D.RLANE_CD(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                SELECT DISTINCT V.VSL_CD" ).append("\n"); 
		query.append("                                     , V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                     , V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                     , V.TURN_PORT_IND_CD TURN" ).append("\n"); 
		query.append("                                     , V.SLAN_CD" ).append("\n"); 
		query.append("                                     , V.VPS_PORT_CD" ).append("\n"); 
		query.append("                                     , REV_DIR_CD AS RLANE_DIR_CD" ).append("\n"); 
		query.append("                                     , 0 OB_RTO" ).append("\n"); 
		query.append("                                     , 50 IB_RTO" ).append("\n"); 
		query.append("                                     , L.RLANE_CD" ).append("\n"); 
		query.append("                                     , REV_YRMON AS REV_YRMON" ).append("\n"); 
		query.append("                                     , DENSE_RANK() OVER (ORDER BY L.REV_DIR_CD, L.RLANE_CD) RLANE_RANK" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                                     , GL_ESTM_REV_VVD L" ).append("\n"); 
		query.append("                                     , V_PARAM P" ).append("\n"); 
		query.append("                                 WHERE V.VSL_CD         = L.VSL_CD" ).append("\n"); 
		query.append("                                   AND V.SKD_VOY_NO     = L.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND V.SKD_DIR_CD     = L.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND V.SLAN_CD        = SUBSTR (L.RLANE_CD, 1, 3)" ).append("\n"); 
		query.append("                                   AND V.VSL_CD         = P.VSL_CD" ).append("\n"); 
		query.append("                                   AND V.SKD_VOY_NO     = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND V.SKD_DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND V.YD_CD          = P.YD_CD" ).append("\n"); 
		query.append("                                   AND V.CLPT_IND_SEQ   = P.CLPT_IND_SEQ " ).append("\n"); 
		query.append("                                   AND NVL(V.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                                   AND NVL(V.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("                                   AND V.TURN_PORT_IND_CD IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("                                   AND L.EXE_YRMON      = P.EXE_YRMON" ).append("\n"); 
		query.append("                                   AND (L.RLANE_CD      = NVL( (SELECT RLANE_CD" ).append("\n"); 
		query.append("                                                                  FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                                                                     , AR_FINC_DIR_CONV B" ).append("\n"); 
		query.append("                                                                     , MDM_LOCATION L" ).append("\n"); 
		query.append("                                                                     , V_PARAM P" ).append("\n"); 
		query.append("                                                                 WHERE V.VSL_CD         = P.VSL_CD" ).append("\n"); 
		query.append("                                                                   AND V.SKD_VOY_NO     = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                   AND V.SKD_DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                   AND V.YD_CD          = P.YD_CD" ).append("\n"); 
		query.append("                                                                   AND V.CLPT_IND_SEQ   = P.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                                   AND V.VPS_PORT_CD    = L.LOC_CD" ).append("\n"); 
		query.append("                                                                   AND V.SLAN_CD        = B.SLAN_CD" ).append("\n"); 
		query.append("                                                                   AND V.SKD_DIR_CD     = B.SLAN_DIR_CD" ).append("\n"); 
		query.append("                                                                   AND L.SCONTI_CD      = B.SCONTI_CD" ).append("\n"); 
		query.append("                                                                   AND ROWNUM <= 1), L.RLANE_CD ))" ).append("\n"); 
		query.append("                            ) A" ).append("\n"); 
		query.append("                       ) A" ).append("\n"); 
		query.append("                 ORDER BY A.RLANE_RANK" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND ROWNUM < 3 /*2건 이하의 Row를 리턴하게 한다.*/" ).append("\n"); 
		query.append("         ORDER BY OB_RTO DESC, A.RLANE_RANK" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("     , V_CHK_PENDULUM CHK /*1건의 Row*/ " ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${pend_flg} != '' && ${pend_flg} == 'Y') " ).append("\n"); 
		query.append("    /* PSO Pendulum Data & OB_RTO 100 Data is 2Row 일때 1개의 Row만 적용.*/" ).append("\n"); 
		query.append("   AND ROWNUM < (CASE WHEN A.OB_RTO_CNT = A.TOT_CNT AND A.TURN NOT IN ('N', 'Y') THEN 2 ELSE 3 END)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    /* GL Pendulum Data & OB_RTO 100 Data is 2Row 일때 1개의 Row만 적용.*/" ).append("\n"); 
		query.append("   AND ROWNUM < (CASE WHEN CHK.NOT_USED_PEND_YN = 'Y' AND A.OB_RTO_CNT = A.TOT_CNT AND A.TURN NOT IN ('N', 'Y') THEN 2 ELSE 3 END)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A.OB_RTO DESC" ).append("\n"); 

	}
}