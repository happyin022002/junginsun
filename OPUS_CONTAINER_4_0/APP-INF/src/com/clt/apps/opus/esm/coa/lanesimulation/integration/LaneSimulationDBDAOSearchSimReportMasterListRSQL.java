/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimReportMasterListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.10.28 윤진영
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

public class LaneSimulationDBDAOSearchSimReportMasterListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * report master list 조회
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimReportMasterListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimReportMasterListRSQL").append("\n"); 
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
		query.append("SELECT A1.SIM_DT AS SIM_DT" ).append("\n"); 
		query.append(",A1.SIM_NO AS SIM_NO" ).append("\n"); 
		query.append(",A1.SIM_DEPT_CD || A1.SIM_DT || A1.SIM_NO || A1.CRE_USR_ID AS SIMULATION_NO" ).append("\n"); 
		query.append(",A2.SECT_NO AS SECT_NO" ).append("\n"); 
		query.append(",A3.SIM_RPT_NO AS SIM_RPT_NO" ).append("\n"); 
		query.append(",A2.RLANE_CD AS RLANE_CD" ).append("\n"); 
		query.append(",A2.SKD_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append(",NVL(A3.LDF_RTO, 0) * 100 AS LDF_RTO" ).append("\n"); 
		query.append(",A3.GRS_RPB_REV AS GRS_RPB_REV" ).append("\n"); 
		query.append(",A3.BNK_COST_AMT AS BNK_COST_AMT" ).append("\n"); 
		query.append(",A3.SIM_RMK AS SIM_RMK" ).append("\n"); 
		query.append("FROM COA_SIM_INFO A1, COA_SIM_SVC_LANE A2, COA_SIM_RPT_MST A3" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${f_sim_dt} != '')" ).append("\n"); 
		query.append("AND A1.SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_sim_no} != '')" ).append("\n"); 
		query.append("AND A1.SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A1.SIM_DT = A2.SIM_DT" ).append("\n"); 
		query.append("AND A1.SIM_NO = A2.SIM_NO" ).append("\n"); 
		query.append("AND A2.SIM_DT = A3.SIM_DT" ).append("\n"); 
		query.append("AND A2.SIM_NO = A3.SIM_NO" ).append("\n"); 
		query.append("AND A2.SECT_NO = A3.SECT_NO" ).append("\n"); 
		query.append("ORDER BY A1.SIM_DT, A1.SIM_NO, A3.SIM_RPT_NO, A2.SECT_NO" ).append("\n"); 

	}
}