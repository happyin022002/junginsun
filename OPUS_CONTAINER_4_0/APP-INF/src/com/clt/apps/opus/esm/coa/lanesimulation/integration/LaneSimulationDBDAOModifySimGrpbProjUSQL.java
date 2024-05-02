/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOModifySimGrpbProjUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.02.23 윤진영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOModifySimGrpbProjUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane Simulation RPB Project 수정
	  * </pre>
	  */
	public LaneSimulationDBDAOModifySimGrpbProjUSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOModifySimGrpbProjUSQL").append("\n"); 
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
		query.append("MERGE INTO COA_SIM_VOL_PRJ B1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT A1.SIM_DT, A1.SIM_NO, A1.SECT_NO" ).append("\n"); 
		query.append(",A2.POL_CD, A2.POD_CD" ).append("\n"); 
		query.append(",A1.GRS_TTL_REV" ).append("\n"); 
		query.append(",A2.PORT_PAIR_RTO" ).append("\n"); 
		query.append(",DECODE(NVL(A2.PORT_PAIR_LOD_QTY,0),0,0, (A1.GRS_TTL_REV * (A2.PORT_PAIR_LOD_QTY*A2.GRS_RPB_REV) /SUM(A2.PORT_PAIR_LOD_QTY*A2.GRS_RPB_REV)OVER(PARTITION BY A1.SIM_DT, A1.SIM_NO, A1.SECT_NO))/ A2.PORT_PAIR_LOD_QTY) AS GRS_RPB_REV" ).append("\n"); 
		query.append("FROM COA_SIM_SVC_LANE A1" ).append("\n"); 
		query.append(",COA_SIM_VOL_PRJ A2" ).append("\n"); 
		query.append("WHERE A1.SIM_DT = A2.SIM_DT" ).append("\n"); 
		query.append("AND A1.SIM_NO = A2.SIM_NO" ).append("\n"); 
		query.append("AND A1.SECT_NO= A2.SECT_NO" ).append("\n"); 
		query.append("AND A1.SIM_DT = @[sim_dt]" ).append("\n"); 
		query.append("AND A1.SIM_NO = @[sim_no]" ).append("\n"); 
		query.append(") B2" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("B1.SIM_DT  = B2.SIM_DT" ).append("\n"); 
		query.append("AND B1.SIM_NO  = B2.SIM_NO" ).append("\n"); 
		query.append("AND B1.SECT_NO = B2.SECT_NO" ).append("\n"); 
		query.append("AND B1.POL_CD  = B2.POL_CD" ).append("\n"); 
		query.append("AND B1.POD_CD  = B2.POD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET B1.GRS_RPB_REV = B2.GRS_RPB_REV" ).append("\n"); 
		query.append(",B1.UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append(",B1.UPD_DT      = SYSDATE" ).append("\n"); 

	}
}