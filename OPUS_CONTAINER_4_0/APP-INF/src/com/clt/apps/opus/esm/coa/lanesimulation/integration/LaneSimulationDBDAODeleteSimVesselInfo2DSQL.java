/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAODeleteSimVesselInfo2DSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.11.25 윤진영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAODeleteSimVesselInfo2DSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel info 삭제
	  * </pre>
	  */
	public LaneSimulationDBDAODeleteSimVesselInfo2DSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sect_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration ").append("\n"); 
		query.append("FileName : LaneSimulationDBDAODeleteSimVesselInfo2DSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("FROM COA_SIM_VSL_SET_INFO" ).append("\n"); 
		query.append("WHERE SIM_DT  =  @[sim_dt]" ).append("\n"); 
		query.append("AND SIM_NO  =  @[sim_no]" ).append("\n"); 
		query.append("AND SECT_NO <> @[sect_no]" ).append("\n"); 
		query.append("AND SIM_DIV_CD  <> '2'" ).append("\n"); 
		query.append("AND VSL_CD NOT IN (" ).append("\n"); 
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append("FROM COA_SIM_VSL_SET_INFO" ).append("\n"); 
		query.append("WHERE SIM_DT  = @[sim_dt]" ).append("\n"); 
		query.append("AND SIM_NO  = @[sim_no]" ).append("\n"); 
		query.append("AND SECT_NO = @[sect_no]" ).append("\n"); 
		query.append("AND VSL_CD  = @[vsl_cd]" ).append("\n"); 
		query.append("AND SIM_DIV_CD  <> '2'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}