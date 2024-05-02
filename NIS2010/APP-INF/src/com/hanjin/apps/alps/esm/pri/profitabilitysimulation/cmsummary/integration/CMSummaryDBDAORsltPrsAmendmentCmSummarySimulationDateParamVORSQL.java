/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CMSummaryDBDAORsltPrsAmendmentCmSummarySimulationDateParamVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CMSummaryDBDAORsltPrsAmendmentCmSummarySimulationDateParamVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DATE Parameter를 조회한다.
	  * 
	  * * History
	  * 2015.06.26 CHM-201536492 Split05-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public CMSummaryDBDAORsltPrsAmendmentCmSummarySimulationDateParamVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rfrc_eff_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_ctrt_eff_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_smr_eff_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_ctrt_eff_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_smr_eff_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_smr_exp_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rfrc_eff_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rfrc_exp_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rfrc_exp_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_ctrt_exp_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_ctrt_exp_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_smr_exp_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration").append("\n"); 
		query.append("FileName : CMSummaryDBDAORsltPrsAmendmentCmSummarySimulationDateParamVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	MIN(CASE WHEN (COST_YR = @[frm_ctrt_eff_yr] AND COST_WK = @[frm_ctrt_eff_wk]) OR (COST_YR = @[frm_ctrt_exp_yr] AND COST_WK =  @[frm_ctrt_exp_wk]) THEN SLS_FM_DT END) AS  C_SLS_FM_DT" ).append("\n"); 
		query.append("	,MAX(CASE WHEN (COST_YR = @[frm_ctrt_eff_yr] AND COST_WK = @[frm_ctrt_eff_wk]) OR (COST_YR = @[frm_ctrt_exp_yr] AND COST_WK =  @[frm_ctrt_exp_wk]) THEN SLS_TO_DT END) AS C_SLS_TO_DT" ).append("\n"); 
		query.append("	,MIN(CASE WHEN (COST_YR = @[frm_smr_eff_yr] AND COST_WK = @[frm_smr_eff_wk]) OR (COST_YR = @[frm_smr_exp_yr] AND COST_WK =  @[frm_smr_exp_wk]) THEN SLS_FM_DT END) AS  S_SLS_FM_DT" ).append("\n"); 
		query.append("	,MAX(CASE WHEN (COST_YR = @[frm_smr_eff_yr] AND COST_WK = @[frm_smr_eff_wk]) OR (COST_YR = @[frm_smr_exp_yr] AND COST_WK =  @[frm_smr_exp_wk]) THEN SLS_TO_DT END) AS S_SLS_TO_DT" ).append("\n"); 
		query.append("	,MIN(CASE WHEN (COST_YR = @[frm_rfrc_eff_yr] AND COST_WK = @[frm_rfrc_eff_wk]) OR (COST_YR = @[frm_rfrc_exp_yr] AND COST_WK = @[frm_rfrc_exp_wk]) THEN SLS_FM_DT END) AS  R_SLS_FM_DT" ).append("\n"); 
		query.append("	,MAX(CASE WHEN (COST_YR = @[frm_rfrc_eff_yr] AND COST_WK = @[frm_rfrc_eff_wk]) OR (COST_YR = @[frm_rfrc_exp_yr] AND COST_WK = @[frm_rfrc_exp_wk]) THEN SLS_TO_DT END) AS  R_SLS_TO_DT" ).append("\n"); 
		query.append("	,MIN(CASE WHEN (COST_YR = @[frm_rfrc_eff_yr] AND COST_WK = @[frm_rfrc_eff_wk]) OR (COST_YR = @[frm_rfrc_exp_yr] AND COST_WK = @[frm_rfrc_exp_wk]) THEN COST_YR||COST_WK END) AS R_FM_YRWK" ).append("\n"); 
		query.append("	,MAX(CASE WHEN (COST_YR = @[frm_rfrc_eff_yr] AND COST_WK = @[frm_rfrc_eff_wk]) OR (COST_YR = @[frm_rfrc_exp_yr] AND COST_WK = @[frm_rfrc_exp_wk]) THEN COST_YR||COST_WK END) AS R_TO_YRWK" ).append("\n"); 
		query.append("FROM MAS_WK_PRD " ).append("\n"); 
		query.append("WHERE ((COST_YR = @[frm_ctrt_eff_yr] AND COST_WK = @[frm_ctrt_eff_wk]) OR (COST_YR = @[frm_ctrt_exp_yr] AND COST_WK = @[frm_ctrt_exp_wk])) -- VW_CONTRACT_DT  " ).append("\n"); 
		query.append("	OR ((COST_YR = @[frm_smr_eff_yr] AND COST_WK = @[frm_smr_eff_wk]) OR (COST_YR = @[frm_smr_exp_yr] AND COST_WK =  @[frm_smr_exp_wk])) --  VW_SUMMARY_DT " ).append("\n"); 
		query.append("	OR ((COST_YR = @[frm_rfrc_eff_yr] AND COST_WK = @[frm_rfrc_eff_wk]) OR (COST_YR = @[frm_rfrc_exp_yr] AND COST_WK = @[frm_rfrc_exp_wk])) -- VW_REFERENCE_DT, VW_REFERENCE_WEEK" ).append("\n"); 

	}
}