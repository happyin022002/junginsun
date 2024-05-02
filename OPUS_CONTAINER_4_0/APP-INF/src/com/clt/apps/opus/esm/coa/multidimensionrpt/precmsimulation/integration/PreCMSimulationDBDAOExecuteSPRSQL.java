/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PreCMSimulationDBDAOExecuteSPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreCMSimulationDBDAOExecuteSPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExecuteSP
	  * </pre>
	  */
	public PreCMSimulationDBDAOExecuteSPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_mty_rtn_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_agn_bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_start_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_agn_ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_g_rev",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_end_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_mty_pkup_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_agn_ff_cust",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_out_param_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ppd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_clt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_agmt_sgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.integration").append("\n"); 
		query.append("FileName : PreCMSimulationDBDAOExecuteSPRSQL").append("\n"); 
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
		query.append("#if (${f_call_id} == 'PRE' )" ).append("\n"); 
		query.append("	CALL COA_COST_ASSIGN_PRECM_PRC(	@[f_out_param_number],@[f_start_pctl_no],@[f_end_pctl_no],@[f_user_id],@[f_g_rev]," ).append("\n"); 
		query.append("									@[f_agmt_sgn_ofc_cd],@[f_ppd_ofc_cd],@[f_clt_ofc_cd],@[f_mty_pkup_yd],@[f_mty_rtn_yd]" ).append("\n"); 
		query.append("                                   ,@[f_agn_bkg_ofc_cd],@[f_agn_ctrt_ofc_cd],@[f_agn_ff_cust])" ).append("\n"); 
		query.append("#elseif (${f_call_id} == 'TRS' )" ).append("\n"); 
		query.append("	CALL TRS_AGMT_APLY_TO_COA_PRC('',@[f_pctl_no],@[f_pctl_no],'N',@[f_out_param_number])" ).append("\n"); 
		query.append("#elseif (${f_call_id} == 'TES' )" ).append("\n"); 
		query.append("	CALL TES_COA_RATE_PRC('',@[f_pctl_no],@[f_pctl_no],@[f_out_param_number])" ).append("\n"); 
		query.append("#elseif (${f_call_id} == 'AVG' )" ).append("\n"); 
		query.append("	CALL COA_COST_PARA_ASSIGN_PKG.MAIN_CMTX_AVG(@[f_pctl_no],@[f_pctl_no],@[f_cost_yrmon])" ).append("\n"); 
		query.append("#elseif (${f_call_id} == 'AGT' )" ).append("\n"); 
		query.append("	CALL ACM_APLY_OTR_COMM_TO_COA_PRC(@[f_pctl_no],@[f_user_id])" ).append("\n"); 
		query.append("#elseif (${f_call_id} == 'TTL' )" ).append("\n"); 
		query.append("	CALL COA_COST_PARA_ASSIGN_PKG.MAIN_COM_TTL_PARA('',@[f_pctl_no],@[f_pctl_no],@[f_cost_yrmon])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}