/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOCreateSimSummaryReportOpdayCSQL.java
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

public class LaneSimulationDBDAOCreateSimSummaryReportOpdayCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 레포트에 opdays 입력
	  * </pre>
	  */
	public LaneSimulationDBDAOCreateSimSummaryReportOpdayCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOCreateSimSummaryReportOpdayCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_SIM_SMRY_RPT C1" ).append("\n"); 
		query.append("USING (SELECT   B1.SIM_DT" ).append("\n"); 
		query.append(",B1.SIM_NO" ).append("\n"); 
		query.append(",B1.SECT_NO" ).append("\n"); 
		query.append("#if($default_rpt_no != '')" ).append("\n"); 
		query.append(",'${default_rpt_no}' SIM_RPT_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",'OPDY' SGRP_COST_CD" ).append("\n"); 
		query.append(",B1.VSL_CD" ).append("\n"); 
		query.append(",SUM(B2.TTL_TZ_DYS) SIM_PERF_AMT" ).append("\n"); 
		query.append(",@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE CRE_DT" ).append("\n"); 
		query.append(",@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM (SELECT   SIM_DT" ).append("\n"); 
		query.append(",SIM_NO" ).append("\n"); 
		query.append(",SECT_NO" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",TML_CD" ).append("\n"); 
		query.append(",VSL_DBL_CALL_SEQ" ).append("\n"); 
		query.append("FROM COA_SIM_NTWK_COST" ).append("\n"); 
		query.append("WHERE SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("AND SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("GROUP BY SIM_DT, SIM_NO, SECT_NO, VSL_CD, TML_CD, VSL_DBL_CALL_SEQ) B1" ).append("\n"); 
		query.append(",COA_SIM_TML_OP_DYS B2" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND B1.SIM_DT = B2.SIM_DT" ).append("\n"); 
		query.append("AND B1.SIM_NO = B2.SIM_NO" ).append("\n"); 
		query.append("AND B1.SECT_NO = B2.SECT_NO" ).append("\n"); 
		query.append("AND B1.TML_CD = B2.TML_CD" ).append("\n"); 
		query.append("AND B1.VSL_DBL_CALL_SEQ = B2.VSL_DBL_CALL_SEQ" ).append("\n"); 
		query.append("GROUP BY B1.SIM_DT, B1.SIM_NO, B1.SECT_NO, B1.VSL_CD) C2" ).append("\n"); 
		query.append("ON (    C1.SIM_DT = C2.SIM_DT" ).append("\n"); 
		query.append("AND C1.SIM_NO = C2.SIM_NO" ).append("\n"); 
		query.append("AND C1.SECT_NO = C2.SECT_NO" ).append("\n"); 
		query.append("AND C1.SIM_RPT_NO = C2.SIM_RPT_NO" ).append("\n"); 
		query.append("AND C1.SGRP_COST_CD = C2.SGRP_COST_CD" ).append("\n"); 
		query.append("AND C1.VSL_CD = C2.VSL_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET C1.SIM_PERF_AMT = C2.SIM_PERF_AMT" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT(C1.SIM_DT, C1.SIM_NO, C1.SECT_NO, C1.SIM_RPT_NO, C1.SGRP_COST_CD, C1.VSL_CD, C1.SIM_PERF_AMT" ).append("\n"); 
		query.append(",C1.CRE_USR_ID, C1.CRE_DT,C1.UPD_USR_ID, C1.UPD_DT)" ).append("\n"); 
		query.append("VALUES(C2.SIM_DT, C2.SIM_NO, C2.SECT_NO, C2.SIM_RPT_NO, C2.SGRP_COST_CD, C2.VSL_CD, C2.SIM_PERF_AMT" ).append("\n"); 
		query.append(",C2.CRE_USR_ID, C2.CRE_DT,C2.UPD_USR_ID, C2.UPD_DT)" ).append("\n"); 

	}
}