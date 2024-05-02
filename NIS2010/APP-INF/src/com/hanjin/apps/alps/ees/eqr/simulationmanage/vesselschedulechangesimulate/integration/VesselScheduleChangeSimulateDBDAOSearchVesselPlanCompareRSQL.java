/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleChangeSimulateDBDAOSearchVesselPlanCompareRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.11.09 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleChangeSimulateDBDAOSearchVesselPlanCompareRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Schedule과 Trunk Vessel EQR Plan 과의 비교값 조회
	  * </pre>
	  */
	public VesselScheduleChangeSimulateDBDAOSearchVesselPlanCompareRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etbEYrWk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etbSYrWk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repoPlnId1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repoPlnId2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.integration").append("\n"); 
		query.append("FileName : VesselScheduleChangeSimulateDBDAOSearchVesselPlanCompareRSQL").append("\n"); 
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
		query.append("X.PLN_YRWK" ).append("\n"); 
		query.append(", X.FM_ECC_CD" ).append("\n"); 
		query.append(", X.TO_ECC_CD" ).append("\n"); 
		query.append(", X.VSL_LANE_CD" ).append("\n"); 
		query.append(", X.VVD" ).append("\n"); 
		query.append(", X.MTY_VOL1" ).append("\n"); 
		query.append(", X.MTY_COST1" ).append("\n"); 
		query.append(", X.MTY_VOL2" ).append("\n"); 
		query.append(", X.MTY_COST2" ).append("\n"); 
		query.append(",(X.MTY_VOL1 - X.MTY_VOL2) MTY_VOL3" ).append("\n"); 
		query.append(",(X.MTY_COST1 - X.MTY_COST2) MTY_COST3" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("Y.PLN_YRWK" ).append("\n"); 
		query.append(", Y.FM_ECC_CD" ).append("\n"); 
		query.append(", Y.TO_ECC_CD" ).append("\n"); 
		query.append(", Y.VSL_LANE_CD" ).append("\n"); 
		query.append(", Y.VVD" ).append("\n"); 
		query.append(", MAX(DECODE(FLAG, '1', Y.CNTR_QTY, 0)) MTY_VOL1" ).append("\n"); 
		query.append(", MAX(DECODE(FLAG, '1', Y.LODG_DCHG_COST_AMT, 0)) MTY_COST1" ).append("\n"); 
		query.append(", MAX(DECODE(FLAG, '2', Y.CNTR_QTY, 0)) MTY_VOL2" ).append("\n"); 
		query.append(", MAX(DECODE(FLAG, '2', Y.LODG_DCHG_COST_AMT, 0)) MTY_COST2" ).append("\n"); 
		query.append("-- , Y.REPO_PLN_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.PLN_YRWK" ).append("\n"); 
		query.append(", A.FM_ECC_CD" ).append("\n"); 
		query.append(", A.TO_ECC_CD" ).append("\n"); 
		query.append(", A.VSL_LANE_CD" ).append("\n"); 
		query.append(", (A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD) VVD" ).append("\n"); 
		query.append("--  , A.REPO_PLN_ID" ).append("\n"); 
		query.append(", SUM(C.CNTR_QTY) CNTR_QTY" ).append("\n"); 
		query.append(", SUM(C.LODG_DCHG_COST_AMT)LODG_DCHG_COST_AMT, '1' FLAG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_VSL_LODG_DCHG_PLN A" ).append("\n"); 
		query.append(", VSK_VSL_SKD B" ).append("\n"); 
		query.append(", EQR_VSL_LODG_DCHG_PLN_QTY C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.VSL_CD      = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO  = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD  = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.VSL_LANE_CD = B.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = @[repoPlnId1]" ).append("\n"); 
		query.append("AND A.PLN_YRWK BETWEEN @[etbSYrWk] AND @[etbEYrWk]" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = C.REPO_PLN_ID" ).append("\n"); 
		query.append("AND A.PLN_YRWK    = C.PLN_YRWK" ).append("\n"); 
		query.append("AND A.PLN_SEQ     = C.PLN_SEQ" ).append("\n"); 
		query.append("#if(${coCd} == 'H')" ).append("\n"); 
		query.append("AND B.SKD_USD_IND_CD IN('B','H')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${coCd} == 'S')" ).append("\n"); 
		query.append("AND B.SKD_USD_IND_CD IN('B','S')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vslSlanCd} != '' )" ).append("\n"); 
		query.append("AND A.VSL_LANE_CD IN(" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrVslSlanCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrVslSlanCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vvd} != '' )" ).append("\n"); 
		query.append("AND A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD IN(" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrVvd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrVvd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("--  A.REPO_PLN_ID" ).append("\n"); 
		query.append("A.PLN_YRWK" ).append("\n"); 
		query.append(", A.FM_ECC_CD" ).append("\n"); 
		query.append(", A.TO_ECC_CD" ).append("\n"); 
		query.append(", A.VSL_LANE_CD" ).append("\n"); 
		query.append(", A.VSL_CD" ).append("\n"); 
		query.append(", A.SKD_VOY_NO" ).append("\n"); 
		query.append(", A.SKD_DIR_CD" ).append("\n"); 
		query.append("-- , A.REPO_PLN_ID" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.PLN_YRWK" ).append("\n"); 
		query.append(", A.FM_ECC_CD" ).append("\n"); 
		query.append(", A.TO_ECC_CD" ).append("\n"); 
		query.append(", A.VSL_LANE_CD" ).append("\n"); 
		query.append(", (A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD) VVD" ).append("\n"); 
		query.append("-- , A.REPO_PLN_ID" ).append("\n"); 
		query.append(", SUM(C.CNTR_QTY) CNTR_QTY" ).append("\n"); 
		query.append(", SUM(C.LODG_DCHG_COST_AMT) LODG_DCHG_COST_AMT" ).append("\n"); 
		query.append(", '2' FLAG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_VSL_LODG_DCHG_PLN A" ).append("\n"); 
		query.append(", VSK_VSL_SKD B" ).append("\n"); 
		query.append(", EQR_VSL_LODG_DCHG_PLN_QTY C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.VSL_CD      = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO  = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD  = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.VSL_LANE_CD = B.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = @[repoPlnId2]" ).append("\n"); 
		query.append("AND A.PLN_YRWK BETWEEN @[etbSYrWk] AND @[etbEYrWk]" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = C.REPO_PLN_ID" ).append("\n"); 
		query.append("AND A.PLN_YRWK    = C.PLN_YRWK" ).append("\n"); 
		query.append("AND A.PLN_SEQ     = C.PLN_SEQ" ).append("\n"); 
		query.append("#if(${coCd} == 'H')" ).append("\n"); 
		query.append("AND B.SKD_USD_IND_CD IN('B','H')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${coCd} == 'S')" ).append("\n"); 
		query.append("AND B.SKD_USD_IND_CD IN('B','S')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vslSlanCd} != '' )" ).append("\n"); 
		query.append("AND a.vsl_lane_cd IN(" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrVslSlanCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrVslSlanCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vvd} != '' )" ).append("\n"); 
		query.append("AND A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD IN(" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrVvd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrVvd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("--   A.REPO_PLN_ID" ).append("\n"); 
		query.append("A.PLN_YRWK" ).append("\n"); 
		query.append(", A.FM_ECC_CD" ).append("\n"); 
		query.append(", A.TO_ECC_CD" ).append("\n"); 
		query.append(", A.VSL_LANE_CD" ).append("\n"); 
		query.append(", A.VSL_CD" ).append("\n"); 
		query.append(", A.SKD_VOY_NO" ).append("\n"); 
		query.append(", A.SKD_DIR_CD" ).append("\n"); 
		query.append("--  , A.REPO_PLN_ID" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("Y.PLN_YRWK" ).append("\n"); 
		query.append(", Y.FM_ECC_CD" ).append("\n"); 
		query.append(", Y.TO_ECC_CD" ).append("\n"); 
		query.append(", Y.VSL_LANE_CD" ).append("\n"); 
		query.append(", Y.VVD" ).append("\n"); 
		query.append("-- , Y.REPO_PLN_ID" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("Y.PLN_YRWK" ).append("\n"); 
		query.append(", Y.FM_ECC_CD" ).append("\n"); 
		query.append(", Y.TO_ECC_CD" ).append("\n"); 
		query.append(", Y.VSL_LANE_CD" ).append("\n"); 
		query.append(", Y.VVD" ).append("\n"); 
		query.append(") X" ).append("\n"); 

	}
}