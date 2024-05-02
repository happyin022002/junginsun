/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOAverageUCVesselDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.03.09 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ock, KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOAverageUCVesselDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AverageUCVesselDetail
	  * </pre>
	  */
	public NetworkCostDBDAOAverageUCVesselDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cobcost",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_yearweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOAverageUCVesselDetailRSQL").append("\n"); 
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
		query.append("SELECT COST_YRMON" ).append("\n"); 
		query.append("     , STND_COST_CD" ).append("\n"); 
		query.append("     , VSL_CLSS_CAPA" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , DHIR_AMT" ).append("\n"); 
		query.append("     , VSL_KNT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , SUM(DECODE(DHIR_AMT,0,0,VSL_KNT)) OVER(PARTITION BY COST_YRMON, STND_COST_CD, VSL_CLSS_CAPA) AS GRP_KNT" ).append("\n"); 
		query.append("     , EFF_YRMON" ).append("\n"); 
		query.append("     , EFF_WK" ).append("\n"); 
		query.append("  FROM MAS_POOL_VSL_DLY_HIR" ).append("\n"); 
		query.append(" WHERE VSL_CD      != 'XXXX'" ).append("\n"); 
		query.append("   AND COST_YRMON   = REPLACE(@[f_yearweek],'-','')" ).append("\n"); 
		query.append("   AND STND_COST_CD = @[f_cobcost] " ).append("\n"); 
		query.append("#if(${f_vsl_cd} != '')" ).append("\n"); 
		query.append("   AND VSL_CD       = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY VSL_CLSS_CAPA, VSL_CD" ).append("\n"); 

	}
}