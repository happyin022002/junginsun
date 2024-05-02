/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkDistributionDBDAOSearchTradeDirbyLaneListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOSearchTradeDirbyLaneListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rlane, Direction 별 Haul bound 정보를 조회한다.
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchTradeDirbyLaneListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cobtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_coblane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cobioc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOSearchTradeDirbyLaneListRSQL").append("\n"); 
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
		query.append(" SELECT RLANE_CD" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , IOC_CD" ).append("\n"); 
		query.append("      , VSL_LANE_TP_CD" ).append("\n"); 
		query.append("      , OP_LANE_TP_CD" ).append("\n"); 
		query.append("      , SUB_TRD_CD" ).append("\n"); 
		query.append("      , SLAN_CD" ).append("\n"); 
		query.append("      , HUL_BND_CD" ).append("\n"); 
		query.append("      , IAS_RGN_CD" ).append("\n"); 
		query.append("   FROM COA_LANE_RGST" ).append("\n"); 
		query.append("  WHERE TRD_CD   = @[f_cobtrade]" ).append("\n"); 
		query.append("    AND RLANE_CD = @[f_coblane]" ).append("\n"); 
		query.append("    AND IOC_CD   = @[f_cobioc]" ).append("\n"); 
		query.append("    AND DELT_FLG = 'N'" ).append("\n"); 

	}
}