/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LaneSimulationDBDAOMultiSimSummaryReportInsCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOMultiSimSummaryReportInsCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * summary 레포트 입력
	  * </pre>
	  */
	public LaneSimulationDBDAOMultiSimSummaryReportInsCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_rpb_rev",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ldf_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sect_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_rpt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOMultiSimSummaryReportInsCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_SIM_SMRY_RPT" ).append("\n"); 
		query.append("(SIM_DT, SIM_NO, SECT_NO, SIM_RPT_NO, SGRP_COST_CD, VSL_CD, SIM_PERF_AMT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("		    (SELECT SIM_DT" ).append("\n"); 
		query.append("		           ,SIM_NO" ).append("\n"); 
		query.append("		           ,SECT_NO" ).append("\n"); 
		query.append("		           ,@[sim_rpt_no] SIM_RPT_NO" ).append("\n"); 
		query.append("		           ,SGRP_COST_CD" ).append("\n"); 
		query.append("		           ,VSL_CD" ).append("\n"); 
		query.append("		           ,DECODE(SGRP_COST_CD, 'LDFR', @[ldf_rto] / 100, 'GRPB', @[grs_rpb_rev], SIM_PERF_AMT) SIM_PERF_AMT" ).append("\n"); 
		query.append("		           ,@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("		           ,SYSDATE" ).append("\n"); 
		query.append("				   ,@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("                   ,SYSDATE" ).append("\n"); 
		query.append("		       FROM COA_SIM_SMRY_RPT" ).append("\n"); 
		query.append("		      WHERE SIM_DT = @[sim_dt]" ).append("\n"); 
		query.append("		        AND SIM_NO = @[sim_no]" ).append("\n"); 
		query.append("		        AND SECT_NO = @[sect_no]" ).append("\n"); 
		query.append("		        AND SIM_RPT_NO = 'AA001')" ).append("\n"); 

	}
}