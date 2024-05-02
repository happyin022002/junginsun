/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchTMLOPDysListRSQL.java
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

public class LaneSimulationDBDAOSearchTMLOPDysListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchtmlopdyslist
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchTMLOPDysListRSQL(){
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
		query.append("FileName : LaneSimulationDBDAOSearchTMLOPDysListRSQL").append("\n"); 
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
		query.append("SELECT TRD_CD," ).append("\n"); 
		query.append("RLANE_CD," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("VSL_DBL_CALL_SEQ," ).append("\n"); 
		query.append("PORT_SEQ, TML_CD," ).append("\n"); 
		query.append("PORT_DYS," ).append("\n"); 
		query.append("TTL_TZ_DYS," ).append("\n"); 
		query.append("DECODE(ROW_NUMBER() OVER(PARTITION BY  TRD_CD, RLANE_CD, SKD_DIR_CD ORDER BY SECT_NO, PORT_SEQ)," ).append("\n"); 
		query.append("COUNT(*) OVER(PARTITION BY  TRD_CD, RLANE_CD, SKD_DIR_CD)," ).append("\n"); 
		query.append("'0', SEA_DYS) SEA_DYS," ).append("\n"); 
		query.append("APLY_VOY_RTO," ).append("\n"); 
		query.append("SIM_DT," ).append("\n"); 
		query.append("SIM_NO," ).append("\n"); 
		query.append("SECT_NO" ).append("\n"); 
		query.append("FROM COA_SIM_TML_OP_DYS" ).append("\n"); 
		query.append("WHERE SIM_DT  = @[f_sim_dt]" ).append("\n"); 
		query.append("AND SIM_NO  = @[f_sim_no]" ).append("\n"); 
		query.append("ORDER BY SECT_NO, PORT_SEQ" ).append("\n"); 

	}
}