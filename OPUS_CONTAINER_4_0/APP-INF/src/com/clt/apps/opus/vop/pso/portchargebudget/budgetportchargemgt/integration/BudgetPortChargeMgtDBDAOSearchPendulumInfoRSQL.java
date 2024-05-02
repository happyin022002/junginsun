/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOSearchPendulumInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.27 
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

public class BudgetPortChargeMgtDBDAOSearchPendulumInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pendulum 정보 Search
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOSearchPendulumInfoRSQL(){
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
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOSearchPendulumInfoRSQL").append("\n"); 
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
		query.append("SELECT T02.YD_CD" ).append("\n"); 
		query.append("     , T02.TURN_PORT_FLG" ).append("\n"); 
		query.append("     , T02.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("     , T02.RLANE_DIR_CD" ).append("\n"); 
		query.append("     , CASE" ).append("\n"); 
		query.append("         WHEN T02.PEND_TURN_PORT_IND_CD = 'Y' THEN 'O'" ).append("\n"); 
		query.append("         WHEN T02.PEND_TURN_PORT_IND_CD = 'F' THEN 'I'" ).append("\n"); 
		query.append("         WHEN T02.PEND_TURN_PORT_IND_CD = 'N' THEN 'B' /* Both : In/Out */" ).append("\n"); 
		query.append("       END AS IB_BND" ).append("\n"); 
		query.append("     , T02.VSL_SLAN_CD AS SLAN_CD" ).append("\n"); 
		query.append("     , TO_CHAR(T02.VPS_ETD_DT,'YYYYMMDD') AS VPS_ETD_DT" ).append("\n"); 
		query.append("     , T02.RLANE_CD" ).append("\n"); 
		query.append("     , T02.REV_YRMON" ).append("\n"); 
		query.append("     , (/*VSK_PF_SKD_DTL.TURN_PORT_IND_CD 체크.*/" ).append("\n"); 
		query.append("        SELECT NVL(CASE WHEN T4.VSL_SLAN_DIR_SEQ = 1 AND T2.TURN_PORT_IND_CD = 'N' AND T2.PORT_ROTN_SEQ = 1 THEN 'Y'" ).append("\n"); 
		query.append("                        ELSE T2.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                   END,'N')" ).append("\n"); 
		query.append("          FROM VSK_PF_SKD T1" ).append("\n"); 
		query.append("             , VSK_PF_SKD_DTL T2" ).append("\n"); 
		query.append("             , MDM_VSL_SVC_LANE T3" ).append("\n"); 
		query.append("             , MDM_VSL_SVC_LANE_DIR T4" ).append("\n"); 
		query.append("         WHERE T1.VSL_SLAN_CD   = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("           AND T1.PF_SVC_TP_CD  = T2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("           AND T1.VSL_SLAN_CD   = T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("           AND T2.VSL_SLAN_CD   = T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("           AND T2.SKD_DIR_CD    = T4.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("           AND T1.VSL_SLAN_CD   = T02.VSL_SLAN_CD" ).append("\n"); 
		query.append("           AND T2.PORT_CD       = SUBSTR(T02.YD_CD, 1, 5)" ).append("\n"); 
		query.append("           AND T2.SKD_DIR_CD    = T02.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND T1.SLAN_STND_FLG = 'Y'" ).append("\n"); 
		query.append("           AND T3.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("           AND T2.TURN_PORT_IND_CD <> 'F'" ).append("\n"); 
		query.append("           AND ROWNUM           = 1" ).append("\n"); 
		query.append("       ) AS PF_TURN_PORT_IND_CD" ).append("\n"); 
		query.append("     , T02.VSL_CD " ).append("\n"); 
		query.append("     , T02.SKD_VOY_NO " ).append("\n"); 
		query.append("     , T02.SKD_DIR_CD" ).append("\n"); 
		query.append("     , T02.CLPT_IND_SEQ" ).append("\n"); 
		query.append("  FROM (SELECT T01.*" ).append("\n"); 
		query.append("             , CASE WHEN IB_RTO = 0   THEN CASE WHEN OB_RTO = 50 THEN 'Y' WHEN OB_RTO = 100 THEN 'N' END" ).append("\n"); 
		query.append("                    WHEN IB_RTO = 50  THEN CASE WHEN OB_RTO = 0  THEN 'F' WHEN OB_RTO = 50  THEN 'F' END" ).append("\n"); 
		query.append("                    WHEN IB_RTO = 100 THEN 'N'" ).append("\n"); 
		query.append("               END AS PEND_TURN_PORT_IND_CD" ).append("\n"); 
		query.append("          FROM (SELECT DISTINCT T5.CLPT_SEQ AS PORT_SEQ" ).append("\n"); 
		query.append("                     , T5.YD_CD" ).append("\n"); 
		query.append("                     , NVL(T2.IB_RTO,0) AS IB_RTO" ).append("\n"); 
		query.append("                     , NVL(T2.OB_RTO,0) AS OB_RTO" ).append("\n"); 
		query.append("                     , T2.REV_DIR_CD AS RLANE_DIR_CD" ).append("\n"); 
		query.append("                     , T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("                     , T5.VPS_ETD_DT" ).append("\n"); 
		query.append("                     , T5.TURN_PORT_FLG" ).append("\n"); 
		query.append("                     , T5.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                     , T5.VSL_CD " ).append("\n"); 
		query.append("                     , T5.SKD_VOY_NO " ).append("\n"); 
		query.append("                     , T5.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , T2.RLANE_CD" ).append("\n"); 
		query.append("                     , (SELECT MAX(REV_YRMON)" ).append("\n"); 
		query.append("                          FROM GL_ESTM_REV_VVD B" ).append("\n"); 
		query.append("                         WHERE B.EXE_YRMON      = REPLACE(@[exe_yrmon] , '-', '') /*EXE_YRMON*/" ).append("\n"); 
		query.append("                           AND B.VSL_CD         = T5.VSL_CD" ).append("\n"); 
		query.append("                           AND B.SKD_VOY_NO     = T5.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND B.SKD_DIR_CD     = T5.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND B.RLANE_CD       = T2.RLANE_CD" ).append("\n"); 
		query.append("                           AND B.REV_DIR_CD     = T2.REV_DIR_CD" ).append("\n"); 
		query.append("                        ) AS REV_YRMON" ).append("\n"); 
		query.append("                     , T5.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  FROM VSK_VSL_SKD          T1" ).append("\n"); 
		query.append("                     , PSO_PORT_EXPN_DIV    T2" ).append("\n"); 
		query.append("                     --, GL_ESTM_REV_VVD      T4" ).append("\n"); 
		query.append("                     , VSK_VSL_PORT_SKD     T5" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND T5.VSL_CD        = @[vsl_cd] " ).append("\n"); 
		query.append("                   AND T5.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("                   AND T5.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("                   AND T5.VPS_PORT_CD   = SUBSTR (@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("                   AND T5.YD_CD         = @[yd_cd]" ).append("\n"); 
		query.append("                   AND T5.CLPT_IND_SEQ  = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                   AND NVL(T5.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("                   AND NVL(T5.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                   AND T5.VSL_CD        = T1.VSL_CD" ).append("\n"); 
		query.append("                   AND T5.SKD_VOY_NO    = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND T5.SKD_DIR_CD    = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND T1.VSL_SLAN_CD   = T2.SLAN_CD" ).append("\n"); 
		query.append("                   AND T1.SKD_DIR_CD    = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND T5.VPS_PORT_CD   = T2.LOC_CD                   " ).append("\n"); 
		query.append("                 ORDER BY T5.CLPT_SEQ" ).append("\n"); 
		query.append("               ) T01" ).append("\n"); 
		query.append("         WHERE 1=1 ) T02" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   --AND T02.YD_CD = 'CNSHA12' -- Test Yd" ).append("\n"); 
		query.append(" --ORDER BY PORT_SEQ" ).append("\n"); 

	}
}