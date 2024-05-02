/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOAverageUCVesselUtADDCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.13
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.07.13 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jinhwan, Son
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOAverageUCVesselUtADDCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Average U/C_Vessel Pooling2 (OP Fixed & Variable cost, etc) Insert
	  * 2015.07.13 손진환 [CHM-201536797] ALPS MAS의 Pooling 화면 Row Add & Save 버튼 추가 CSR
	  * </pre>
	  */
	public NetworkCostDBDAOAverageUCVesselUtADDCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("teu_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tgt_lod_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOAverageUCVesselUtADDCSQL").append("\n"); 
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
		query.append("INSERT INTO MAS_POOL_UT_COST (" ).append("\n"); 
		query.append("          COST_YRMON" ).append("\n"); 
		query.append("		, STND_COST_CD" ).append("\n"); 
		query.append("        , TRD_CD" ).append("\n"); 
		query.append("		, SUB_TRD_CD" ).append("\n"); 
		query.append("        , RLANE_CD" ).append("\n"); 
		query.append("        , DIR_CD" ).append("\n"); 
		query.append("        , HUL_BND_CD" ).append("\n"); 
		query.append("		, EFF_FM_YRMON" ).append("\n"); 
		query.append("		, EFF_TO_YRMON" ).append("\n"); 
		query.append("		, TTL_AMT" ).append("\n"); 
		query.append("		, TGT_LOD_QTY" ).append("\n"); 
		query.append("		, TEU_UC_AMT" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" SELECT @[cost_yrmon] AS COST_YRMON" ).append("\n"); 
		query.append("	  , @[stnd_cost_cd] AS STND_COST_CD" ).append("\n"); 
		query.append("      , @[trd_cd]     AS TRD_CD" ).append("\n"); 
		query.append("	  , @[sub_trd_cd]     AS SUB_TRD_CD" ).append("\n"); 
		query.append("      , @[rlane_cd]   AS RLANE_CD" ).append("\n"); 
		query.append("      , @[dir_cd]     AS DIR_CD" ).append("\n"); 
		query.append("      , @[hul_bnd_cd] AS HUL_BND_CD" ).append("\n"); 
		query.append("	  , TRIM(REPLACE(SUBSTR(@[eff_yrmon], 0, 7), '-', '')) AS EFF_FM_YRMON" ).append("\n"); 
		query.append("	  , TRIM(REPLACE(SUBSTR(@[eff_yrmon], 9), '-', '')) AS EFF_TO_YRMON" ).append("\n"); 
		query.append("	  , @[ttl_amt] AS TTL_AMT" ).append("\n"); 
		query.append("	  , @[tgt_lod_qty] AS TGT_LOD_QTY" ).append("\n"); 
		query.append("	  , @[teu_uc_amt] AS TEU_UC_AMT" ).append("\n"); 
		query.append("      , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE       AS CRE_DT" ).append("\n"); 
		query.append("      , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE       AS UPD_DT" ).append("\n"); 
		query.append(" FROM DUAL" ).append("\n"); 

	}
}