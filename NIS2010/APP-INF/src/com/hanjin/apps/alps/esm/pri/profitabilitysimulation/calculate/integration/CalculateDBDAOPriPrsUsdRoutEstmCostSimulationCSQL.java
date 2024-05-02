/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CalculateDBDAOPriPrsUsdRoutEstmCostSimulationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CalculateDBDAOPriPrsUsdRoutEstmCostSimulationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal Scope Copy PRI_SP_SCP_RT_ACT_CUST Insert
	  * 
	  * * History
	  * 2015.06.26 CHM-201536492 Split05-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public CalculateDBDAOPriPrsUsdRoutEstmCostSimulationCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cs_src_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cs_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.integration").append("\n"); 
		query.append("FileName : CalculateDBDAOPriPrsUsdRoutEstmCostSimulationCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_PRS_USD_ROUT_ESTM_COST (" ).append("\n"); 
		query.append("        ROUT_CS_NO" ).append("\n"); 
		query.append("        , COA_COST_SRC_CD" ).append("\n"); 
		query.append("        , COM_ROUT_SEQ" ).append("\n"); 
		query.append("        , ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("        , LOC_CD" ).append("\n"); 
		query.append("        , COND_OFC_CD" ).append("\n"); 
		query.append("        , DIV_MEAS_CD" ).append("\n"); 
		query.append("        , OFC_CLSS_CD" ).append("\n"); 
		query.append("        , SLS_ACT_CD" ).append("\n"); 
		query.append("        , RA_ACCT_CD" ).append("\n"); 
		query.append("        , STND_COST_CD" ).append("\n"); 
		query.append("        , COST_ASS_BSE_CD" ).append("\n"); 
		query.append("        , SVC_TRNS_PRC_AMT" ).append("\n"); 
		query.append("        , BKG_KNT" ).append("\n"); 
		query.append("        , CNTR_BX_KNT" ).append("\n"); 
		query.append("        , CNTR_TEU_QTY" ).append("\n"); 
		query.append("        , VSL_DYS" ).append("\n"); 
		query.append("        , COM_FLG" ).append("\n"); 
		query.append("        , COST_CALC_RMK" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("			   @[rout_cs_no] AS ROUT_CS_NO" ).append("\n"); 
		query.append("			, MAS_COST_SRC_CD" ).append("\n"); 
		query.append("			, COM_ROUT_SEQ" ).append("\n"); 
		query.append("			, @[rout_cs_src_dt] AS ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("			, LOC_CD" ).append("\n"); 
		query.append("			, COND_OFC_CD" ).append("\n"); 
		query.append("			, DIV_MEAS_CD" ).append("\n"); 
		query.append("			, OFC_CLSS_CD" ).append("\n"); 
		query.append("			, SLS_ACT_CD" ).append("\n"); 
		query.append("			, RA_ACCT_CD" ).append("\n"); 
		query.append("			, STND_COST_CD" ).append("\n"); 
		query.append("			, COST_ASS_BSE_CD" ).append("\n"); 
		query.append("			, SVC_TRNS_PRC_AMT" ).append("\n"); 
		query.append("			, BKG_KNT" ).append("\n"); 
		query.append("			, CNTR_BX_KNT" ).append("\n"); 
		query.append("			, CNTR_TEU_QTY" ).append("\n"); 
		query.append("			, VSL_DYS" ).append("\n"); 
		query.append("			, COM_FLG" ).append("\n"); 
		query.append("			, COST_CALC_RMK" ).append("\n"); 
		query.append("			, @[upd_usr_id]" ).append("\n"); 
		query.append("			, SYSDATE" ).append("\n"); 
		query.append("			, @[upd_usr_id]" ).append("\n"); 
		query.append("			, SYSDATE			" ).append("\n"); 
		query.append("		FROM MAS_COM_SVC_TRNS_PRC_PARA" ).append("\n"); 
		query.append("		WHERE PCTL_NO = @[pctl_no]" ).append("\n"); 

	}
}