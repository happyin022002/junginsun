/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchTmlSeaSpeedRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.10.19 윤진영
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

public class LaneSimulationDBDAOSearchTmlSeaSpeedRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 터미널 입력시 평균 vessel speed를 구한다
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchTmlSeaSpeedRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchTmlSeaSpeedRSQL").append("\n"); 
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
		query.append("SELECT NVL(ROUND(AVG(VSL_SVC_SPD),1),0) AS LNK_SPD," ).append("\n"); 
		query.append("NVL(ROUND(MIN(VSL_SVC_SPD),1),0) AS MIN_SPD," ).append("\n"); 
		query.append("NVL(ROUND(MAX(VSL_SVC_SPD),1),0) AS MAX_SPD" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR A," ).append("\n"); 
		query.append("COA_SIM_VSL_SET_INFO B" ).append("\n"); 
		query.append("WHERE A.VSL_CD=B.VSL_CD" ).append("\n"); 
		query.append("AND B.SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("AND B.SIM_NO = @[f_sim_no]" ).append("\n"); 

	}
}