/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOAverageUCVesselUtMergeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2015.08.13 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOAverageUCVesselUtMergeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_MAS_0335에서 UPDATE 시 호출
	  * </pre>
	  */
	public NetworkCostDBDAOAverageUCVesselUtMergeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOAverageUCVesselUtMergeUSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_POOL_UT_COST M1 USING" ).append("\n"); 
		query.append("(SELECT COST_YRMON" ).append("\n"); 
		query.append("      , STND_COST_CD" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , SUB_TRD_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , HUL_BND_CD" ).append("\n"); 
		query.append("      , MIN(EFF_FM_YRMON) AS EFF_FM_YRMON" ).append("\n"); 
		query.append("      , MAX(EFF_TO_YRMON) AS EFF_TO_YRMON" ).append("\n"); 
		query.append("      , NVL(SUM(TTL_AMT), 0) AS TTL_AMT" ).append("\n"); 
		query.append("      , NVL(SUM(VVD_BSA_CAPA), 0) AS TGT_LOD_QTY" ).append("\n"); 
		query.append("      , DECODE(NVL(SUM(VVD_BSA_CAPA), 0), 0, 0, NVL(SUM(TTL_AMT), 0)/NVL(SUM(VVD_BSA_CAPA), 0)) AS TEU_UC_AMT" ).append("\n"); 
		query.append("      , @[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE UPD_DT" ).append("\n"); 
		query.append("   FROM MAS_POOL_UT_COST_DTL" ).append("\n"); 
		query.append("  WHERE COST_YRMON   = REPLACE(@[cost_yrmon], '-', '')" ).append("\n"); 
		query.append("    AND STND_COST_CD = @[stnd_cost_cd]" ).append("\n"); 
		query.append("    AND TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("    AND SUB_TRD_CD   = @[sub_trd_cd]" ).append("\n"); 
		query.append("    AND RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("    AND DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append("GROUP BY COST_YRMON" ).append("\n"); 
		query.append("      , STND_COST_CD" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , SUB_TRD_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , HUL_BND_CD" ).append("\n"); 
		query.append(") S1 " ).append("\n"); 
		query.append("ON (   M1.COST_YRMON    = S1.COST_YRMON " ).append("\n"); 
		query.append("   AND M1.STND_COST_CD  = S1.STND_COST_CD " ).append("\n"); 
		query.append("   AND M1.TRD_CD        = S1.TRD_CD " ).append("\n"); 
		query.append("   AND M1.SUB_TRD_CD    = S1.SUB_TRD_CD " ).append("\n"); 
		query.append("   AND M1.RLANE_CD      = S1.RLANE_CD " ).append("\n"); 
		query.append("   AND M1.DIR_CD        = S1.DIR_CD )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("         UPDATE" ).append("\n"); 
		query.append("            SET M1.HUL_BND_CD   = S1.HUL_BND_CD" ).append("\n"); 
		query.append("              , M1.EFF_FM_YRMON = S1.EFF_FM_YRMON" ).append("\n"); 
		query.append("              , M1.EFF_TO_YRMON = S1.EFF_TO_YRMON" ).append("\n"); 
		query.append("              , M1.TTL_AMT      = S1.TTL_AMT" ).append("\n"); 
		query.append("              , M1.TGT_LOD_QTY  = S1.TGT_LOD_QTY" ).append("\n"); 
		query.append("              , M1.TEU_UC_AMT   = S1.TEU_UC_AMT" ).append("\n"); 
		query.append("              , M1.UPD_USR_ID   = S1.UPD_USR_ID" ).append("\n"); 
		query.append("              , M1.UPD_DT       = S1.UPD_DT" ).append("\n"); 

	}
}