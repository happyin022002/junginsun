/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOCreateSimSummaryReportAddAccntCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.02.23 윤진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOCreateSimSummaryReportAddAccntCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Addition accent 입력
	  * </pre>
	  */
	public LaneSimulationDBDAOCreateSimSummaryReportAddAccntCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.mas.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOCreateSimSummaryReportAddAccntCSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_SIM_SMRY_RPT D1" ).append("\n"); 
		query.append("USING (SELECT SIM_DT" ).append("\n"); 
		query.append(",SIM_NO" ).append("\n"); 
		query.append(",SECT_NO" ).append("\n"); 
		query.append("#if(${default_rpt_no} != '')" ).append("\n"); 
		query.append(",'${default_rpt_no}' SIM_RPT_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",SGRP_COST_CD" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",(AMT * OPDY) SIM_PERF_AMT" ).append("\n"); 
		query.append(",@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE CRE_DT" ).append("\n"); 
		query.append(",@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM (SELECT   C1.SIM_DT" ).append("\n"); 
		query.append(",C1.SIM_NO" ).append("\n"); 
		query.append(",C1.SECT_NO" ).append("\n"); 
		query.append(",C1.VSL_CD" ).append("\n"); 
		query.append(",C1.SGRP_COST_CD" ).append("\n"); 
		query.append(",MAX(DECODE(C2.SGRP_COST_CD, 'OPDY', C2.SIM_PERF_AMT)) OPDY" ).append("\n"); 
		query.append(",MAX(C1.AMT) AMT" ).append("\n"); 
		query.append("FROM (SELECT A1.SIM_DT" ).append("\n"); 
		query.append(",A1.SIM_NO" ).append("\n"); 
		query.append(",A1.SECT_NO" ).append("\n"); 
		query.append(",A1.VSL_CD" ).append("\n"); 
		query.append(",'SBPF' SGRP_COST_CD" ).append("\n"); 
		query.append(", A1.VSL_CLSS_CAPA" ).append("\n"); 
		query.append(", A2.VSL_DLY_UC_AMT AMT" ).append("\n"); 
		query.append(", A1.BSA_CAPA" ).append("\n"); 
		query.append("FROM MAS_SIM_VSL_SET_INFO A1, MAS_TM_CHTR_OUT_HIR A2" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A1.BSA_CAPA BETWEEN A2.FM_VSL_CLSS_CAPA AND A2.TO_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("AND A1.SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("AND A1.SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("AND A1.SIM_DIV_CD = '1'   --BSA" ).append("\n"); 
		query.append(") C1" ).append("\n"); 
		query.append(",MAS_SIM_SMRY_RPT C2" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND C1.SIM_DT = C2.SIM_DT" ).append("\n"); 
		query.append("AND C1.SIM_NO = C2.SIM_NO" ).append("\n"); 
		query.append("AND C1.SECT_NO = C2.SECT_NO" ).append("\n"); 
		query.append("AND C1.VSL_CD = C2.VSL_CD" ).append("\n"); 
		query.append("AND C2.SGRP_COST_CD  = 'OPDY'" ).append("\n"); 
		query.append("GROUP BY C1.SIM_DT, C1.SIM_NO, C1.SECT_NO, C1.VSL_CD, C1.SGRP_COST_CD) ) D2" ).append("\n"); 
		query.append("ON (    D1.SIM_DT = D2.SIM_DT" ).append("\n"); 
		query.append("AND D1.SIM_NO = D2.SIM_NO" ).append("\n"); 
		query.append("AND D1.SECT_NO = D2.SECT_NO" ).append("\n"); 
		query.append("AND D1.SIM_RPT_NO = D2.SIM_RPT_NO" ).append("\n"); 
		query.append("AND D1.SGRP_COST_CD = D2.SGRP_COST_CD" ).append("\n"); 
		query.append("AND D1.VSL_CD = D2.VSL_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET D1.SIM_PERF_AMT = D2.SIM_PERF_AMT" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT(D1.SIM_DT, D1.SIM_NO, D1.SECT_NO, D1.SIM_RPT_NO, D1.SGRP_COST_CD, D1.VSL_CD, D1.SIM_PERF_AMT" ).append("\n"); 
		query.append(",D1.CRE_USR_ID, D1.CRE_DT, D1.UPD_USR_ID, D1.UPD_DT)" ).append("\n"); 
		query.append("VALUES(D2.SIM_DT, D2.SIM_NO, D2.SECT_NO, D2.SIM_RPT_NO, D2.SGRP_COST_CD, D2.VSL_CD, D2.SIM_PERF_AMT" ).append("\n"); 
		query.append(",D2.CRE_USR_ID, D2.CRE_DT, D2.UPD_USR_ID, D2.UPD_DT)" ).append("\n"); 

	}
}