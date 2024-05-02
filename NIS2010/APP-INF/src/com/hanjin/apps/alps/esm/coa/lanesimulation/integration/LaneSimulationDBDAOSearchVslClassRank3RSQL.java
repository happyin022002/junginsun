/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchVslClassRank3RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.11.12 윤진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchVslClassRank3RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel class 상위 3개 가져오기
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchVslClassRank3RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchVslClassRank3RSQL").append("\n"); 
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
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("SELECT VSL_CLSS_CAPA" ).append("\n"); 
		query.append(",COUNT(DISTINCT VSL_CD) AS VSL_CNT" ).append("\n"); 
		query.append("FROM COA_SIM_VSL_SET_INFO" ).append("\n"); 
		query.append("WHERE SIM_DT=@[f_sim_dt]" ).append("\n"); 
		query.append("AND SIM_NO=@[f_sim_no]" ).append("\n"); 
		query.append("AND VSL_CLSS_CAPA IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY VSL_CLSS_CAPA" ).append("\n"); 
		query.append("ORDER BY 1 DESC" ).append("\n"); 
		query.append(") WHERE ROWNUM <= 3" ).append("\n"); 

	}
}