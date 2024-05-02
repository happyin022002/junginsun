/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LaneSimulationDBDAOCreateCoaSimRqst1CSQL.java
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

public class LaneSimulationDBDAOCreateCoaSimRqst1CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK의 요청으로 COA_SIM_INFO에 데이터를 입력한다.[복제]
	  * </pre>
	  */
	public LaneSimulationDBDAOCreateCoaSimRqst1CSQL(){
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOCreateCoaSimRqst1CSQL").append("\n"); 
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
		query.append("#if (${param} == 'COA_SIM_INFO') " ).append("\n"); 
		query.append("INSERT INFO COA_SIM_INFO" ).append("\n"); 
		query.append("(SIM_DT, SIM_NO, SLAN_CD, SIM_STS_CD, EXPC_OT_PERF_RTO, CO_CD, SVC_DUR_DYS, BRTH_ITVAL_DYS, SIM_DEPT_CD, EXTD_LANE_FLG, SIM_RMK, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT @[sim_dt]" ).append("\n"); 
		query.append("      ,@[sim_no]" ).append("\n"); 
		query.append("      ,SLAN_CD" ).append("\n"); 
		query.append("      ,SIM_DEPT_CD" ).append("\n"); 
		query.append("      ,SIM_RMK" ).append("\n"); 
		query.append("      ,EXTD_LANE_FLG" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("  FROM COA_SIM_INFO" ).append("\n"); 
		query.append("WHERE SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("  AND SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("#elseif (${param} == 'COA_SIM_SVC_LANE') " ).append("\n"); 
		query.append("INSERT INTO COA_SIM_SVC_LANE" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("               SIM_DT" ).append("\n"); 
		query.append("              ,SIM_NO" ).append("\n"); 
		query.append("              ,SECT_NO" ).append("\n"); 
		query.append("              ,FREQ_NO" ).append("\n"); 
		query.append("              ,TRD_CD" ).append("\n"); 
		query.append("              ,SUB_TRD_CD" ).append("\n"); 
		query.append("              ,RLANE_CD" ).append("\n"); 
		query.append("              ,IOC_CD" ).append("\n"); 
		query.append("              ,SKD_DIR_CD" ).append("\n"); 
		query.append("              ,LOD_TTL_QTY" ).append("\n"); 
		query.append("              ,BSA_CAPA" ).append("\n"); 
		query.append("              ,GRS_RPB_REV" ).append("\n"); 
		query.append("              ,GRS_TTL_REV" ).append("\n"); 
		query.append("              ,LDF_RTO" ).append("\n"); 
		query.append("              ,CRE_USR_ID" ).append("\n"); 
		query.append("              ,CRE_DT" ).append("\n"); 
		query.append("              ,UPD_USR_ID" ).append("\n"); 
		query.append("              ,UPD_DT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("SELECT @[sim_dt]" ).append("\n"); 
		query.append("      ,@[sim_no]" ).append("\n"); 
		query.append("      ,SECT_NO" ).append("\n"); 
		query.append("      ,FREQ_NO" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,IOC_CD" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,LOD_TTL_QTY" ).append("\n"); 
		query.append("      ,BSA_CAPA" ).append("\n"); 
		query.append("      ,0" ).append("\n"); 
		query.append("      ,0" ).append("\n"); 
		query.append("      ,LDF_RTO" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("  FROM COA_SIM_SVC_LANE" ).append("\n"); 
		query.append("WHERE SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("  AND SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("#elseif (${param} == 'COA_SIM_VSL_SET_INFO') " ).append("\n"); 
		query.append("INSERT INTO COA_SIM_VSL_SET_INFO " ).append("\n"); 
		query.append("(SIM_DT, SIM_NO, SECT_NO, VSL_CD, SIM_DIV_CD, VSL_CLSS_CAPA, VOP_CD, VSL_CAPA, BSA_CAPA, FNL_HJS_BSA_CAPA, LDF_RTO, OTR_CRR_BSA_CAPA1, OTR_CRR_BSA_CAPA2, OTR_CRR_BSA_CAPA3, OTR_CRR_BSA_CAPA4, OTR_CRR_BSA_CAPA5, HJS_BFR_BSA_CAPA, SUB_LSE_CAPA1, SUB_LSE_CAPA2, SUB_LSE_CAPA3, SUB_LSE_CAPA4, SUB_LSE_CAPA5, SUB_CHTR_CAPA1, SUB_CHTR_CAPA2, SUB_CHTR_CAPA3, SUB_CHTR_CAPA4, SUB_CHTR_CAPA5, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT @[sim_dt]" ).append("\n"); 
		query.append("      ,@[sim_no]" ).append("\n"); 
		query.append("      ,SECT_NO" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SIM_DIV_CD" ).append("\n"); 
		query.append("      ,VSL_CLSS_CAPA" ).append("\n"); 
		query.append("      ,VOP_CD" ).append("\n"); 
		query.append("      ,VSL_CAPA" ).append("\n"); 
		query.append("      ,BSA_CAPA" ).append("\n"); 
		query.append("      ,FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("      ,LDF_RTO" ).append("\n"); 
		query.append("      ,OTR_CRR_BSA_CAPA1" ).append("\n"); 
		query.append("      ,OTR_CRR_BSA_CAPA2" ).append("\n"); 
		query.append("      ,OTR_CRR_BSA_CAPA3" ).append("\n"); 
		query.append("      ,OTR_CRR_BSA_CAPA4" ).append("\n"); 
		query.append("      ,OTR_CRR_BSA_CAPA5" ).append("\n"); 
		query.append("      ,HJS_BFR_BSA_CAPA" ).append("\n"); 
		query.append("      ,SUB_LSE_CAPA1" ).append("\n"); 
		query.append("      ,SUB_LSE_CAPA2" ).append("\n"); 
		query.append("      ,SUB_LSE_CAPA3" ).append("\n"); 
		query.append("      ,SUB_LSE_CAPA4" ).append("\n"); 
		query.append("      ,SUB_LSE_CAPA5" ).append("\n"); 
		query.append("      ,SUB_CHTR_CAPA1" ).append("\n"); 
		query.append("      ,SUB_CHTR_CAPA2" ).append("\n"); 
		query.append("      ,SUB_CHTR_CAPA3" ).append("\n"); 
		query.append("      ,SUB_CHTR_CAPA4" ).append("\n"); 
		query.append("      ,SUB_CHTR_CAPA5" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("  FROM COA_SIM_VSL_SET_INFO" ).append("\n"); 
		query.append(" WHERE SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("   AND SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}