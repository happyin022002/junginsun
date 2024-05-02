/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAOMultiSimCtrbMgnCostCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOMultiSimCtrbMgnCostCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CtbMgnCost 머지
	  * </pre>
	  */
	public LaneSimulationDBDAOMultiSimCtrbMgnCostCSQL(){
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
		params.put("sect_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : LaneSimulationDBDAOMultiSimCtrbMgnCostCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_SIM_CTRB_MGN_COST A1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT A.SIM_DT" ).append("\n"); 
		query.append(",A.SIM_NO" ).append("\n"); 
		query.append(",A.SECT_NO" ).append("\n"); 
		query.append(",A.SGRP_COST_CD" ).append("\n"); 
		query.append(",A.POL_CD" ).append("\n"); 
		query.append(",A.POD_CD" ).append("\n"); 
		query.append(",SUM(A.CGO_VAR_UC_AMT*B.PORT_PAIR_LOD_QTY) QTY" ).append("\n"); 
		query.append("FROM COA_SIM_CTRB_MGN_COST A" ).append("\n"); 
		query.append(",COA_SIM_VOL_PRJ B" ).append("\n"); 
		query.append("WHERE A.SIM_DT  = @[sim_dt]" ).append("\n"); 
		query.append("AND A.SIM_NO  = @[sim_no]" ).append("\n"); 
		query.append("AND A.SECT_NO = @[sect_no]" ).append("\n"); 
		query.append("AND A.SIM_DT  = B.SIM_DT" ).append("\n"); 
		query.append("AND A.SIM_NO  = B.SIM_NO" ).append("\n"); 
		query.append("AND A.SECT_NO = B.SECT_NO" ).append("\n"); 
		query.append("AND A.POL_CD  = B.POL_CD" ).append("\n"); 
		query.append("AND A.POD_CD  = B.POD_CD" ).append("\n"); 
		query.append("GROUP BY A.SIM_DT" ).append("\n"); 
		query.append(",A.SIM_NO" ).append("\n"); 
		query.append(",A.SECT_NO" ).append("\n"); 
		query.append(",A.SGRP_COST_CD" ).append("\n"); 
		query.append(",A.POL_CD" ).append("\n"); 
		query.append(",A.POD_CD" ).append("\n"); 
		query.append(") A2" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("A1.SIM_DT  = A2.SIM_DT" ).append("\n"); 
		query.append("AND A1.SIM_NO  = A2.SIM_NO" ).append("\n"); 
		query.append("AND A1.SECT_NO = A2.SECT_NO" ).append("\n"); 
		query.append("AND A1.SGRP_COST_CD = A2.SGRP_COST_CD" ).append("\n"); 
		query.append("AND A1.POL_CD  = A2.POL_CD" ).append("\n"); 
		query.append("AND A1.POD_CD  = A2.POD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET  A1.CGO_VAR_AMT = A2.QTY" ).append("\n"); 
		query.append(",A1.UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append(",A1.UPD_DT      = SYSDATE" ).append("\n"); 

	}
}