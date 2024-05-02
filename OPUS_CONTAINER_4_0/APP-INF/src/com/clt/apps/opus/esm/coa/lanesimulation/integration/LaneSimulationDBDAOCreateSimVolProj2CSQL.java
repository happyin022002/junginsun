/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOCreateSimVolProj2CSQL.java
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

public class LaneSimulationDBDAOCreateSimVolProj2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * route projection volumn insert 2
	  * </pre>
	  */
	public LaneSimulationDBDAOCreateSimVolProj2CSQL(){
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOCreateSimVolProj2CSQL").append("\n"); 
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
		query.append("INSERT INTO  COA_SIM_CTRB_MGN_COST(" ).append("\n"); 
		query.append("SIM_DT, SIM_NO, SECT_NO, POL_CD, POD_CD, SGRP_COST_CD, CGO_VAR_UC_AMT, CGO_VAR_AMT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT A1.SIM_DT" ).append("\n"); 
		query.append(",A1.SIM_NO" ).append("\n"); 
		query.append(",A1.SECT_NO" ).append("\n"); 
		query.append(",A1.POL_CD" ).append("\n"); 
		query.append(",A1.POD_CD" ).append("\n"); 
		query.append(",A2.SGRP_COST_CD" ).append("\n"); 
		query.append(",SUM(DECODE(A1.PORT_PAIR_QTY, 0 , 0, A2.SIM_PERF_AMT/A1.PORT_PAIR_QTY)) AS CGO_VAR_UC_AMT" ).append("\n"); 
		query.append(",SUM(DECODE(A1.PORT_PAIR_QTY, 0 , 0, A2.SIM_PERF_AMT/A1.PORT_PAIR_QTY)* A1.PORT_PAIR_LOD_QTY)  AS CGO_VAR_AMT" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append("FROM COA_SIM_VOL_PRJ A1" ).append("\n"); 
		query.append(",COA_SIM_SMRY A2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A1.POL_CD       = A2.POL_CD" ).append("\n"); 
		query.append("AND A1.POD_CD       = A2.POD_CD" ).append("\n"); 
		query.append("AND A2.SGRP_COST_CD NOT IN ('LOAD','FRRE')" ).append("\n"); 
		query.append("AND A2.COST_YRMON   >= TO_CHAR(ADD_MONTHS(SYSDATE,-${prd_cd}),'YYYYMM')" ).append("\n"); 
		query.append("AND A1.SIM_DT       = @[sim_dt]" ).append("\n"); 
		query.append("AND A1.SIM_NO       = @[sim_no]" ).append("\n"); 
		query.append("AND A1.TRD_CD       = A2.TRD_CD" ).append("\n"); 
		query.append("AND A1.SKD_DIR_CD   = A2.DIR_CD" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("AND A2.TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("AND A2.RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_cd} != '')" ).append("\n"); 
		query.append("AND A2.DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A1.SIM_DT" ).append("\n"); 
		query.append(",A1.SIM_NO" ).append("\n"); 
		query.append(",A1.SECT_NO" ).append("\n"); 
		query.append(",A1.POL_CD" ).append("\n"); 
		query.append(",A1.POD_CD" ).append("\n"); 
		query.append(",A2.SGRP_COST_CD" ).append("\n"); 

	}
}