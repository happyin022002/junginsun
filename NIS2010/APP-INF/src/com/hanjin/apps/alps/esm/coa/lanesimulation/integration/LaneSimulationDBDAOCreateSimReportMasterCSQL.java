/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : LaneSimulationDBDAOCreateSimReportMasterCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.03.08 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOCreateSimReportMasterCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 레포트 마스터 입력
	  * =========================================================
	  * History
	  * 2011.03.08 김상수 Ticket ID:CHM-201109234-01 lane simulation 기능 보완
	  *                            - 조회조건의 join문을 outer join으로 변경
	  * </pre>
	  */
	public LaneSimulationDBDAOCreateSimReportMasterCSQL(){
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
		query.append("FileName : LaneSimulationDBDAOCreateSimReportMasterCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_SIM_RPT_MST" ).append("\n"); 
		query.append("		    SELECT SIM_DT" ).append("\n"); 
		query.append("		          ,SIM_NO" ).append("\n"); 
		query.append("		          ,SECT_NO" ).append("\n"); 
		query.append("		          ,SIM_RPT_NO" ).append("\n"); 
		query.append("		          ,LDF_RTO" ).append("\n"); 
		query.append("		          ,GRS_RPB_REV" ).append("\n"); 
		query.append("		          ,BNK_COST_AMT" ).append("\n"); 
		query.append("		          , 'LF=' || NVL(ROUND(LDF_RTO, 2), 0) * 100 SIM_RMK" ).append("\n"); 
		query.append("		          ,@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("		          ,SYSDATE CRE_DT" ).append("\n"); 
		query.append("		          ,@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("		          ,SYSDATE CRE_DT" ).append("\n"); 
		query.append("		      FROM (SELECT   A1.SIM_DT" ).append("\n"); 
		query.append("		                    ,A1.SIM_NO" ).append("\n"); 
		query.append("		                    ,A1.SECT_NO" ).append("\n"); 
		query.append("		                    ,A1.SIM_RPT_NO" ).append("\n"); 
		query.append("		                    ,AVG(DECODE(SGRP_COST_CD, 'LDFR', SIM_PERF_AMT)) LDF_RTO" ).append("\n"); 
		query.append("		                    ,AVG(DECODE(SGRP_COST_CD, 'GRPB', SIM_PERF_AMT)) GRS_RPB_REV" ).append("\n"); 
		query.append("		                    ,AVG(A2.FOIL_UC_AMT) BNK_COST_AMT" ).append("\n"); 
		query.append("		                FROM COA_SIM_SMRY_RPT A1   -- MASTER 테이블에서 LDFR, GRPB, OVBK 추출" ).append("\n"); 
		query.append("		                     ,COA_SIM_BNK_COST A2" ).append("\n"); 
		query.append("		               WHERE 1 = 1" ).append("\n"); 
		query.append("		                 AND A1.SIM_DT  = A2.SIM_DT(+)" ).append("\n"); 
		query.append("		                 AND A1.SIM_NO  = A2.SIM_NO(+)" ).append("\n"); 
		query.append("		                 AND A1.SECT_NO = A2.SECT_NO(+)" ).append("\n"); 
		query.append("		                 AND A1.SIM_DT  = @[f_sim_dt]" ).append("\n"); 
		query.append("		                 AND A1.SIM_NO  = @[f_sim_no]" ).append("\n"); 
		query.append("                  #if(${default_rpt_no} != '')" ).append("\n"); 
		query.append("		                 AND A1.SIM_RPT_NO = '${default_rpt_no}' --처음인 경우 AA001을 사용" ).append("\n"); 
		query.append("		          #end   " ).append("\n"); 
		query.append("		                 AND A1.SGRP_COST_CD IN('LDFR', 'GRPB', 'OVBK', 'OPDY')" ).append("\n"); 
		query.append("		            GROUP BY A1.SIM_DT, A1.SIM_NO, A1.SECT_NO, A1.SIM_RPT_NO)" ).append("\n"); 

	}
}