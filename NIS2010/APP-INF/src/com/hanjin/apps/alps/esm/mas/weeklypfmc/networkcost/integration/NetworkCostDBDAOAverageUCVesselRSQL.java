/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOAverageUCVesselRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.06
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.03.06 김종옥
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

public class NetworkCostDBDAOAverageUCVesselRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AverageUCVessel
	  * </pre>
	  */
	public NetworkCostDBDAOAverageUCVesselRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selclass",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOAverageUCVesselRSQL").append("\n"); 
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
		query.append("SELECT A.COST_YRMON" ).append("\n"); 
		query.append("     , A.STND_COST_CD" ).append("\n"); 
		query.append("     , A.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("     , A.VSL_CD" ).append("\n"); 
		query.append("     , A.DHIR_AMT" ).append("\n"); 
		query.append("     , A.VSL_KNT" ).append("\n"); 
		query.append("     , B.PRE_DHIR_AMT" ).append("\n"); 
		query.append("     , '' AS UPD_USR_ID" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT COST_YRMON" ).append("\n"); 
		query.append("             , STND_COST_CD" ).append("\n"); 
		query.append("             , VSL_CLSS_CAPA" ).append("\n"); 
		query.append("             , VSL_CD" ).append("\n"); 
		query.append("             , DHIR_AMT" ).append("\n"); 
		query.append("             , VSL_KNT" ).append("\n"); 
		query.append("          FROM MAS_POOL_VSL_DLY_HIR" ).append("\n"); 
		query.append("         WHERE VSL_CD = 'XXXX'" ).append("\n"); 
		query.append("           AND COST_YRMON   = REPLACE(@[f_yearweek], '-', '')" ).append("\n"); 
		query.append("           AND STND_COST_CD = @[f_cobcost]" ).append("\n"); 
		query.append("#if(${f_selclass} != '')" ).append("\n"); 
		query.append("           AND VSL_CLSS_CAPA = @[f_selclass]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) A," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT REPLACE(@[f_yearweek], '-', '') AS COST_YRMON" ).append("\n"); 
		query.append("             , STND_COST_CD" ).append("\n"); 
		query.append("             , VSL_CLSS_CAPA" ).append("\n"); 
		query.append("             , VSL_CD" ).append("\n"); 
		query.append("             , DHIR_AMT AS PRE_DHIR_AMT" ).append("\n"); 
		query.append("             , VSL_KNT" ).append("\n"); 
		query.append("          FROM MAS_POOL_VSL_DLY_HIR" ).append("\n"); 
		query.append("         WHERE VSL_CD = 'XXXX'" ).append("\n"); 
		query.append("           AND COST_YRMON   = TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[f_yearweek], '-', '')||'01','YYYYMMDD'), -1), 'YYYYMM')" ).append("\n"); 
		query.append("           AND STND_COST_CD = @[f_cobcost]" ).append("\n"); 
		query.append("#if(${f_selclass} != '')" ).append("\n"); 
		query.append("           AND VSL_CLSS_CAPA = @[f_selclass]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append(" WHERE A.COST_YRMON   = B.COST_YRMON(+)" ).append("\n"); 
		query.append("   AND A.STND_COST_CD = B.STND_COST_CD(+)" ).append("\n"); 
		query.append("   AND A.VSL_CLSS_CAPA = B.VSL_CLSS_CAPA(+)" ).append("\n"); 
		query.append("ORDER BY VSL_CLSS_CAPA ASC " ).append("\n"); 

	}
}