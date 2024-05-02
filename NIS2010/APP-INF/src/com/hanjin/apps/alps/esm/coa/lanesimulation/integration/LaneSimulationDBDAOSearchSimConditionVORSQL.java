/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimConditionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.11.18 윤진영
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

public class LaneSimulationDBDAOSearchSimConditionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LaneSimulation에서 사용하는 공통VO
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimConditionVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimConditionVORSQL").append("\n"); 
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
		query.append("SELECT '' AS F_SLAN_CD" ).append("\n"); 
		query.append(",'' AS F_SIM_DT" ).append("\n"); 
		query.append(",'' AS F_SIM_NO" ).append("\n"); 
		query.append(",'' AS F_SECT_NO" ).append("\n"); 
		query.append(",'' AS F_DEPT_CD" ).append("\n"); 
		query.append(",'' AS F_DEPT_CD2" ).append("\n"); 
		query.append(",'' AS F_CM_HEADER" ).append("\n"); 
		query.append(",'' AS F_OP_HEADER" ).append("\n"); 
		query.append(",'' AS F_HEADER" ).append("\n"); 
		query.append(",'' AS F_TML_CD" ).append("\n"); 
		query.append(",'' AS F_EXT_FLG" ).append("\n"); 
		query.append(",'' AS F_SGRP_COST_CD" ).append("\n"); 
		query.append(",'' AS USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}