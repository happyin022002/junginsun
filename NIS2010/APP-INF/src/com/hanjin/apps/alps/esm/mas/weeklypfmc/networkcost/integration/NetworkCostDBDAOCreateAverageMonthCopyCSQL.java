/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : NetworkCostDBDAOCreateAverageMonthCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.23
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.12.23 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOCreateAverageMonthCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Average UC 월단가를 복사해서 생성한다.
	  * </pre>
	  */
	public NetworkCostDBDAOCreateAverageMonthCopyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tar_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_use_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_src_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOCreateAverageMonthCopyCSQL").append("\n"); 
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
		query.append(" INSERT" ).append("\n"); 
		query.append("   INTO MAS_OP_AVG_UT_COST" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                COST_YRMON" ).append("\n"); 
		query.append("              , TRD_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , STND_COST_CD" ).append("\n"); 
		query.append("              , OP_LANE_TP_CD" ).append("\n"); 
		query.append("              , OP_COST_AMT" ).append("\n"); 
		query.append("              , BSA_CAPA" ).append("\n"); 
		query.append("              , OP_UC_AMT" ).append("\n"); 
		query.append("              , VVD_RMK" ).append("\n"); 
		query.append("              , CRE_USR_ID" ).append("\n"); 
		query.append("              , CRE_DT" ).append("\n"); 
		query.append("              , UPD_USR_ID" ).append("\n"); 
		query.append("              , UPD_DT" ).append("\n"); 
		query.append("              , COST_USE_TP_CD" ).append("\n"); 
		query.append("              , DIR_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" SELECT @[f_tar_mon]" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , STND_COST_CD" ).append("\n"); 
		query.append("      , OP_LANE_TP_CD" ).append("\n"); 
		query.append("      , OP_COST_AMT" ).append("\n"); 
		query.append("      , BSA_CAPA" ).append("\n"); 
		query.append("      , OP_UC_AMT" ).append("\n"); 
		query.append("      , VVD_RMK" ).append("\n"); 
		query.append("      , @[user_id]" ).append("\n"); 
		query.append("      , SYSDATE" ).append("\n"); 
		query.append("      , @[user_id]" ).append("\n"); 
		query.append("      , SYSDATE" ).append("\n"); 
		query.append("      , COST_USE_TP_CD" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("   FROM MAS_OP_AVG_UT_COST" ).append("\n"); 
		query.append("  WHERE COST_YRMON     = @[f_src_mon]" ).append("\n"); 
		query.append("    AND COST_USE_TP_CD = @[cost_use_tp_cd]" ).append("\n"); 

	}
}