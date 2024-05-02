/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOModifySimGrpb2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.02.23 윤진영
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

public class LaneSimulationDBDAOModifySimGrpb2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sim Grpb2 머지
	  * </pre>
	  */
	public LaneSimulationDBDAOModifySimGrpb2CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOModifySimGrpb2CSQL").append("\n"); 
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
		query.append("MERGE INTO COA_SIM_SVC_LANE A1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT SIM_DT, SIM_NO, SECT_NO, SUM(GRS_RPB_REV) GRS_RPB_REV, SUM(PORT_PAIR_LOD_QTY*GRS_RPB_REV) GRS_REV" ).append("\n"); 
		query.append("FROM COA_SIM_VOL_PRJ" ).append("\n"); 
		query.append("WHERE SIM_DT = @[sim_dt]" ).append("\n"); 
		query.append("AND SIM_NO = @[sim_no]" ).append("\n"); 
		query.append("GROUP BY SIM_DT, SIM_NO, SECT_NO" ).append("\n"); 
		query.append(") A2" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("A1.SIM_DT  = A2.SIM_DT" ).append("\n"); 
		query.append("AND A1.SIM_NO  = A2.SIM_NO" ).append("\n"); 
		query.append("AND A1.SECT_NO = A2.SECT_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET A1.GRS_RPB_REV = A2.GRS_REV/A1.LOD_TTL_QTY" ).append("\n"); 
		query.append(",A1.GRS_TTL_REV = A2.GRS_REV" ).append("\n"); 
		query.append(",A1.UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append(",A1.UPD_DT      = SYSDATE" ).append("\n"); 

	}
}