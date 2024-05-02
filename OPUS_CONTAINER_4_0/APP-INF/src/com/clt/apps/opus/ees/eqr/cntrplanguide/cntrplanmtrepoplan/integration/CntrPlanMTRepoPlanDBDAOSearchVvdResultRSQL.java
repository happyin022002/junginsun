/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanMTRepoPlanDBDAOSearchVvdResultRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanmtrepoplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanMTRepoPlanDBDAOSearchVvdResultRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD Result 대상 조회SDSD
	  * </pre>
	  */
	public CntrPlanMTRepoPlanDBDAOSearchVvdResultRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fcbf_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eff_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eff_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fcbf_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd_second",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanmtrepoplan.integration").append("\n"); 
		query.append("FileName : CntrPlanMTRepoPlanDBDAOSearchVvdResultRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT" ).append("\n"); 
		query.append("X.SLAN_CD" ).append("\n"); 
		query.append("||'/'||" ).append("\n"); 
		query.append("X.VSL_CD||X.SKD_VOY_NO||X.SKD_DIR_CD" ).append("\n"); 
		query.append("||'/'||" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.DIFF > 0" ).append("\n"); 
		query.append("THEN X.NEXT_VPS_PORT_CD" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("||'/'||" ).append("\n"); 
		query.append("'FCBF('||NVL(P.FNL_CBF_FLG,'N')||')'" ).append("\n"); 
		query.append("||'/'||" ).append("\n"); 
		query.append("'PLAN('||CASE WHEN P.POL_CD IS NOT NULL THEN 'Y' ELSE 'N' END||')'" ).append("\n"); 
		query.append("vvd_rslt" ).append("\n"); 
		query.append(", X.VSL_CD||X.SKD_VOY_NO||X.SKD_DIR_CD s_vvd_cd" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT X.* FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append(", A.VPS_PORT_CD" ).append("\n"); 
		query.append(", LEAD(A.VPS_PORT_CD) OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD ORDER BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CLPT_SEQ) NEXT_VPS_PORT_CD" ).append("\n"); 
		query.append(", A.SLAN_CD" ).append("\n"); 
		query.append(", A.VPS_ETA_DT - SYSDATE DIFF" ).append("\n"); 
		query.append(", DENSE_RANK() OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD ORDER BY ABS(A.VPS_ETA_DT - SYSDATE)) RK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT" ).append("\n"); 
		query.append("A.SLAN_CD" ).append("\n"); 
		query.append(",A.VSL_CD" ).append("\n"); 
		query.append(",A.SKD_VOY_NO" ).append("\n"); 
		query.append(",A.SKD_DIR_CD" ).append("\n"); 
		query.append(",A.VPS_PORT_CD VPS_PORT_CD --POL_CD" ).append("\n"); 
		query.append(",A.VPS_ETA_DT" ).append("\n"); 
		query.append(",A.VPS_ETD_DT" ).append("\n"); 
		query.append(",A.CLPT_SEQ CLPT_SEQ --AS POL_CLPT_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("-- TURNING PORT 만 추출(POL)" ).append("\n"); 
		query.append("SELECT SLAN_CD" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",VPS_PORT_CD" ).append("\n"); 
		query.append(",CLPT_IND_SEQ" ).append("\n"); 
		query.append(",CLPT_SEQ" ).append("\n"); 
		query.append(",YD_CD" ).append("\n"); 
		query.append(",VPS_ETA_DT" ).append("\n"); 
		query.append(",VPS_ETD_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD, MDM_LOCATION L, MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND YD_CD NOT IN ('PAPACT1','EGSUZT1')" ).append("\n"); 
		query.append("#if (${s_vvd_cd} != '')" ).append("\n"); 
		query.append("AND VSL_CD     = SUBSTR(@[s_vvd_cd], 0, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[s_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[s_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_eff_st_dt} != '')" ).append("\n"); 
		query.append("AND VPS_ETA_DT BETWEEN TO_DATE(REPLACE(@[s_eff_st_dt],'-',''),'YYYYMMDD')+0.0 AND TO_DATE(REPLACE(@[s_eff_end_dt],'-',''),'YYYYMMDD')+0.9999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lane} != '')" ).append("\n"); 
		query.append("AND SLAN_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${arr_lane})" ).append("\n"); 
		query.append("#if($velocityCount < $arr_lane.size())" ).append("\n"); 
		query.append("SUBSTR('$key',6)," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SUBSTR('$key',6)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--		AND   (" ).append("\n"); 
		query.append("--    		    TURN_PORT_FLG  = 'Y'" ).append("\n"); 
		query.append("--        		OR SKD_VOY_NO = '0001'" ).append("\n"); 
		query.append("--	        	OR (SLAN_CD='IMU'" ).append("\n"); 
		query.append("--    	        	AND" ).append("\n"); 
		query.append("--	        	    (SELECT B.RCC_CD" ).append("\n"); 
		query.append("--    	        	FROM MDM_LOCATION L, MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("--	    	        WHERE L.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("--    	    	    AND NVL(L.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("--        	    	AND NVL(B.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("--	            	AND L.LOC_CD = VPS_PORT_CD" ).append("\n"); 
		query.append("--		            AND ROWNUM = 1) = 'DEHAM')" ).append("\n"); 
		query.append("--    		   )" ).append("\n"); 
		query.append("AND   NVL(SKD_CNG_STS_CD,'X') <> 'S' -- SKIP 은 제외" ).append("\n"); 
		query.append("AND   CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("AND   VPS_PORT_CD = L.LOC_CD" ).append("\n"); 
		query.append("AND   L.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("AND   NVL(L.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND   NVL(B.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${rcc_cd} != '')" ).append("\n"); 
		query.append("AND B.RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_tp_cd_second} == 'L')" ).append("\n"); 
		query.append("#if (${loc_cd_second} != '')" ).append("\n"); 
		query.append("AND B.LCC_CD = @[loc_cd_second]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${loc_tp_cd_second} == 'E')" ).append("\n"); 
		query.append("#if (${loc_cd_second} != '')" ).append("\n"); 
		query.append("AND B.ECC_CD = @[loc_cd_second]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${loc_tp_cd_second} == 'S')" ).append("\n"); 
		query.append("#if (${loc_cd_second} != '')" ).append("\n"); 
		query.append("AND B.SCC_CD = @[loc_cd_second]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${s_vvd_cd} != '')" ).append("\n"); 
		query.append("AND A.VSL_CD     = SUBSTR(@[s_vvd_cd], 0, 4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[s_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = SUBSTR(@[s_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_eff_st_dt} != '')" ).append("\n"); 
		query.append("AND A.VPS_ETA_DT BETWEEN TO_DATE(REPLACE(@[s_eff_st_dt],'-',''),'YYYYMMDD')+0.0 AND TO_DATE(REPLACE(@[s_eff_end_dt],'-',''),'YYYYMMDD')+0.9999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lane} != '')" ).append("\n"); 
		query.append("AND A.SLAN_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${arr_lane})" ).append("\n"); 
		query.append("#if($velocityCount < $arr_lane.size())" ).append("\n"); 
		query.append("SUBSTR('$key',6)," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SUBSTR('$key',6)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE X.RK = 1" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT P.* FROM EQR_CTRL_MTY_LODG_PLN P" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${s_fcbf_st_dt} != '')" ).append("\n"); 
		query.append("AND P.FNL_CBF_DT BETWEEN TO_DATE(REPLACE(@[s_fcbf_st_dt],'-',''),'YYYYMMDD')+0.0 AND TO_DATE(REPLACE(@[s_fcbf_end_dt],'-',''),'YYYYMMDD')+0.9999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") P" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT DISTINCT SUBSTR(D.RLANE_CD,0,3) SLAN_CD, D.VSL_SLAN_DIR_CD, D.IOC_CD, D.TRD_CD, D.SUB_TRD_CD" ).append("\n"); 
		query.append("FROM MDM_DTL_REV_LANE D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NVL(D.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${trade} != '')" ).append("\n"); 
		query.append("AND D.TRD_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${arr_trd_cd})" ).append("\n"); 
		query.append("#if($velocityCount < $arr_trd_cd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${subtrade} != '')" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("#foreach($key IN ${arr_sub_trd_cd})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("(D.TRD_CD = SUBSTR('$key',1,3) AND D.SUB_TRD_CD = SUBSTR('$key',4,2))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("OR (D.TRD_CD = SUBSTR('$key',1,3) AND D.SUB_TRD_CD = SUBSTR('$key',4,2))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND D.FM_CONTI_CD IN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT A.CONTI_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION A, MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("WHERE A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("AND A.CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${rcc_cd} != '')" ).append("\n"); 
		query.append("AND B.RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_tp_cd_second} == 'L')" ).append("\n"); 
		query.append("#if (${loc_cd_second} != '')" ).append("\n"); 
		query.append("AND B.LCC_CD = @[loc_cd_second]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${loc_tp_cd_second} == 'E')" ).append("\n"); 
		query.append("#if (${loc_cd_second} != '')" ).append("\n"); 
		query.append("AND B.ECC_CD = @[loc_cd_second]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${loc_tp_cd_second} == 'S')" ).append("\n"); 
		query.append("#if (${loc_cd_second} != '')" ).append("\n"); 
		query.append("AND B.SCC_CD = @[loc_cd_second]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND X.SLAN_CD    = B.SLAN_CD" ).append("\n"); 
		query.append("AND X.SKD_DIR_CD = B.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("AND X.VSL_CD     = P.VSL_CD(+)" ).append("\n"); 
		query.append("AND X.SKD_VOY_NO = P.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND X.SKD_DIR_CD = P.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND X.VPS_PORT_CD = SUBSTR(P.POL_YD_CD(+),1,5)" ).append("\n"); 
		query.append("#if (${s_fcbf_st_dt} != '')" ).append("\n"); 
		query.append("AND P.VSL_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("X.SLAN_CD" ).append("\n"); 
		query.append("||'/'||" ).append("\n"); 
		query.append("X.VSL_CD||X.SKD_VOY_NO||X.SKD_DIR_CD" ).append("\n"); 
		query.append("||'/'||" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.DIFF > 0" ).append("\n"); 
		query.append("THEN X.NEXT_VPS_PORT_CD" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("||'/'||" ).append("\n"); 
		query.append("'FCBF('||NVL(P.FNL_CBF_FLG,'N')||')'" ).append("\n"); 
		query.append("||'/'||" ).append("\n"); 
		query.append("'PLAN('||CASE WHEN P.POL_CD IS NOT NULL THEN 'Y' ELSE 'N' END||')'" ).append("\n"); 

	}
}