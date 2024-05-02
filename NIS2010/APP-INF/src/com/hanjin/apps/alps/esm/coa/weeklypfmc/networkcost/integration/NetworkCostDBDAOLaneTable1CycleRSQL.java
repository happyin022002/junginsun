/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkCostDBDAOLaneTable1CycleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.17
*@LastModifier : Okyoung Im
*@LastVersion : 1.0
* 2014.06.17 Okyoung Im
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Okyoung Im
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOLaneTable1CycleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane Detail Retrieve
	  * 2014.06.17 임옥영 Ticket ID:CHM-201430756 
	  * AVG U/C의 Lane Detail R.Lane 알파벳 순 정렬
	  * </pre>
	  */
	public NetworkCostDBDAOLaneTable1CycleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOLaneTable1CycleRSQL").append("\n"); 
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
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , VSL_OSHP_CD" ).append("\n"); 
		query.append("      , SUB_TRD_CD" ).append("\n"); 
		query.append("      , FREQ_NO" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append("      , '' F_COST_YRMON" ).append("\n"); 
		query.append("      , RLANE_CD MERGE_CD" ).append("\n"); 
		query.append("   FROM COA_LANE_VSL_TP_FREQ" ).append("\n"); 
		query.append("  WHERE COST_YRMON = REPLACE(@[f_cost_yrmon], '-')" ).append("\n"); 
		query.append("ORDER BY RLANE_CD" ).append("\n"); 
		query.append("#if (${f_sort} == 'DESC')" ).append("\n"); 
		query.append("DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , INSTR('OWN CHT OTH', VSL_OSHP_CD)" ).append("\n"); 

	}
}