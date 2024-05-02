/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchSeasonalSMUCostListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.29
*@LastModifier : 김성훈
*@LastVersion : 1.0
* 2012.06.29 김성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM SUNG-HUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchSeasonalSMUCostListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.05.31 SHKIM
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchSeasonalSMUCostListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchSeasonalSMUCostListVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("     A.COST_YRMON 		-- YYYYMM1" ).append("\n"); 
		query.append("    ,A.TRD_CD 			-- Trade2" ).append("\n"); 
		query.append("    ,A.SUB_TRD_CD 		-- SubTrade3" ).append("\n"); 
		query.append("    ,A.RLANE_CD 			-- Lane" ).append("\n"); 
		query.append("    ,A.VSL_SLAN_DIR_CD 	-- Bound" ).append("\n"); 
		query.append("    --,DECODE(A3.COST_LANE_TP_CD, 'L', 'Local', 'T/S') AS COST_LANE_TP_NM    -- AS LaneType" ).append("\n"); 
		query.append("    --, VOP_VAR_FX_AMT AS BSE_UC_AMT --BaseUnitCost -- BSE_UC_AMT 반올림 미" ).append("\n"); 
		query.append("    ,A.SSNL_PRC_UT_AMT as PLCY_PRC_UT_AMT 	--PolicyPrice " ).append("\n"); 
		query.append("    , (B.PLCY_PRC_UT_AMT - A.SSNL_PRC_UT_AMT ) as SSNL_DIFF_AMT 	-- Diff" ).append("\n"); 
		query.append("FROM MAS_SSNL_SLT_MGMT_UT A" ).append("\n"); 
		query.append("	 , MAS_SLT_MGMT_UT B" ).append("\n"); 
		query.append("    --,(  SELECT DECODE(LEVEL, 1, 'L', 'T') COST_LANE_TP_CD  FROM DUAL  CONNECT BY ROWNUM < 3) A3" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND A.COST_YRMON      = B.COST_YRMON(+)" ).append("\n"); 
		query.append("  AND A.TRD_CD          = B.TRD_CD(+)" ).append("\n"); 
		query.append("  AND A.RLANE_CD        = B.RLANE_CD(+)" ).append("\n"); 
		query.append("  AND A.VSL_SLAN_DIR_CD = B.VSL_SLAN_DIR_CD(+)" ).append("\n"); 
		query.append("  AND A.COST_YRMON = @[f_cost_yrmon]  " ).append("\n"); 
		query.append("  AND A.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("  AND B.COST_LANE_TP_CD(+) = 'L' " ).append("\n"); 
		query.append("#if (${f_trd_cd} != '') " ).append("\n"); 
		query.append("  AND A.TRD_CD 			= @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '') " ).append("\n"); 
		query.append("  AND A.SUB_TRD_CD 		= @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '')" ).append("\n"); 
		query.append("  AND A.RLANE_CD 			= @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("  AND A.VSL_SLAN_DIR_CD 	= @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.TRD_CD" ).append("\n"); 
		query.append("       , A.SUB_TRD_CD" ).append("\n"); 
		query.append("       , A.RLANE_CD" ).append("\n"); 
		query.append("       , A.VSL_SLAN_DIR_CD" ).append("\n"); 

	}
}