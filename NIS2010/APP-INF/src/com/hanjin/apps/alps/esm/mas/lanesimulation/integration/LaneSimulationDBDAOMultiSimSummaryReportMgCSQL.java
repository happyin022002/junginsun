/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOMultiSimSummaryReportMgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.16 
* 1.0 Creation
* 2010.10.08 박은주 CHM-201006307 Session 정보 변경 및 프로그램 오류수정
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOMultiSimSummaryReportMgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * summary 레포트 머지 1
	  * </pre>
	  */
	public LaneSimulationDBDAOMultiSimSummaryReportMgCSQL(){
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
		params.put("sect_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.mas.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOMultiSimSummaryReportMgCSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_SIM_SMRY_RPT C1" ).append("\n"); 
		query.append("		    USING (SELECT   A1.SIM_DT" ).append("\n"); 
		query.append("		                   ,A1.SIM_NO" ).append("\n"); 
		query.append("		                   ,A1.SECT_NO" ).append("\n"); 
		query.append("		                   ,@[sim_rpt_no] SIM_RPT_NO" ).append("\n"); 
		query.append("		                   ,A1.VSL_CD" ).append("\n"); 
		query.append("		                   ,'OVBK' SGRP_COST_CD" ).append("\n"); 
		query.append("		                   ,SUM(((A3.FOIL_SAIL_CSM * A2.SEA_DYS) +(A3.FOIL_PORT_CSM * A2.PORT_DYS)) * @[grs_rpb_rev]" ).append("\n"); 
		query.append("		                        +(A3.DOIL_CSM * A2.TTL_TZ_DYS * A3.DOIL_UC_AMT)" ).append("\n"); 
		query.append("		                       ) SIM_PERF_AMT" ).append("\n"); 
		query.append("		                   ,@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("		                   ,SYSDATE CRE_DT" ).append("\n"); 
		query.append("		               FROM MAS_SIM_VSL_SET_INFO A1" ).append("\n"); 
		query.append("		                  ,(" ).append("\n"); 
		query.append("		                   SELECT DISTINCT SIM_DT, SIM_NO, SECT_NO, TML_CD, PORT_DYS, SEA_DYS, TTL_TZ_DYS, APLY_VOY_RTO" ).append("\n"); 
		query.append("		                     FROM MAS_SIM_TML_OP_DYS" ).append("\n"); 
		query.append("		                    WHERE SIM_DT = @[sim_dt]" ).append("\n"); 
		query.append("		                      AND SIM_NO = @[sim_no] " ).append("\n"); 
		query.append("		                      AND SECT_NO = @[sect_no] " ).append("\n"); 
		query.append("		                   )A2" ).append("\n"); 
		query.append("		                  , MAS_SIM_BNK_COST A3" ).append("\n"); 
		query.append("		              WHERE A1.SIM_DT = A2.SIM_DT" ).append("\n"); 
		query.append("		                AND A1.SIM_NO = A2.SIM_NO" ).append("\n"); 
		query.append("		                AND A1.SECT_NO = A2.SECT_NO" ).append("\n"); 
		query.append("		                AND A1.SIM_DT = A3.SIM_DT" ).append("\n"); 
		query.append("		                AND A1.SIM_NO = A3.SIM_NO" ).append("\n"); 
		query.append("		                AND A1.SECT_NO = A3.SECT_NO" ).append("\n"); 
		query.append("		                AND A1.VSL_CLSS_CAPA = A3.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("		                AND A1.SIM_DIV_CD = '1'" ).append("\n"); 
		query.append("		                AND A1.SIM_DT = @[sim_dt]" ).append("\n"); 
		query.append("		                AND A1.SIM_NO = @[sim_no]" ).append("\n"); 
		query.append("		                AND A1.SECT_NO = @[sect_no]" ).append("\n"); 
		query.append("		           GROUP BY A1.SIM_DT, A1.SIM_NO, A1.SECT_NO, A1.VSL_CD) C2" ).append("\n"); 
		query.append("		    ON (    C1.SIM_DT = C2.SIM_DT" ).append("\n"); 
		query.append("		        AND C1.SIM_NO = C2.SIM_NO" ).append("\n"); 
		query.append("		        AND C1.SECT_NO = C2.SECT_NO" ).append("\n"); 
		query.append("		        AND C1.SIM_RPT_NO = C2.SIM_RPT_NO" ).append("\n"); 
		query.append("		        AND C1.SGRP_COST_CD = C2.SGRP_COST_CD" ).append("\n"); 
		query.append("		        AND C1.VSL_CD = C2.VSL_CD)" ).append("\n"); 
		query.append("		    WHEN MATCHED THEN" ).append("\n"); 
		query.append("		       UPDATE" ).append("\n"); 
		query.append("		          SET C1.SIM_PERF_AMT = C2.SIM_PERF_AMT" ).append("\n"); 
		query.append("		    WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("		       INSERT(C1.SIM_DT, C1.SIM_NO, C1.SECT_NO, C1.SIM_RPT_NO, C1.SGRP_COST_CD, C1.VSL_CD, C1.SIM_PERF_AMT" ).append("\n"); 
		query.append("		             ,C1.CRE_USR_ID, C1.CRE_DT)" ).append("\n"); 
		query.append("		       VALUES(C2.SIM_DT, C2.SIM_NO, C2.SECT_NO, C2.SIM_RPT_NO, C2.SGRP_COST_CD, C2.VSL_CD, C2.SIM_PERF_AMT" ).append("\n"); 
		query.append("		             ,C2.CRE_USR_ID, C2.CRE_DT)" ).append("\n"); 

	}
}