/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchExpenseItemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.07.24 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchExpenseItemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Gae_item 조회
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchExpenseItemRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_itm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_trns_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_gen_expn_apro_step_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_gen_expn_apsts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchExpenseItemRSQL").append("\n"); 
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
		query.append("SELECT GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",GEN_EXPN_CD" ).append("\n"); 
		query.append(",GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append(",GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append(",GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append(",CRNT_GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append(",CRNT_GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append(",GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append(",GEN_EXPN_CALC_BSS_DESC" ).append("\n"); 
		query.append(",RQST_OPIN_RMK" ).append("\n"); 
		query.append(",JAN_AMT" ).append("\n"); 
		query.append(",FEB_AMT" ).append("\n"); 
		query.append(",MAR_AMT" ).append("\n"); 
		query.append(",APR_AMT" ).append("\n"); 
		query.append(",MAY_AMT" ).append("\n"); 
		query.append(",JUN_AMT" ).append("\n"); 
		query.append(",JUL_AMT" ).append("\n"); 
		query.append(",AUG_AMT" ).append("\n"); 
		query.append(",SEP_AMT" ).append("\n"); 
		query.append(",OCT_AMT" ).append("\n"); 
		query.append(",NOV_AMT" ).append("\n"); 
		query.append(",DEC_AMT" ).append("\n"); 
		query.append(",(JAN_AMT+FEB_AMT+MAR_AMT+APR_AMT+MAY_AMT+JUN_AMT+JUL_AMT+AUG_AMT+SEP_AMT+OCT_AMT+NOV_AMT+DEC_AMT) SUM_AMT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("FROM   GEM_ITEM" ).append("\n"); 
		query.append("WHERE GEN_EXPN_RQST_NO = @[gen_expn_rqst_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND OFC_CD =  @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${gen_expn_cd} != '')" ).append("\n"); 
		query.append("AND GEN_EXPN_CD =  @[gen_expn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${gen_expn_itm_no} != '')" ).append("\n"); 
		query.append("AND GEN_EXPN_ITM_NO =  @[gen_expn_itm_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${gen_expn_trns_div_cd} != '')" ).append("\n"); 
		query.append("AND GEN_EXPN_TRNS_DIV_CD =  @[gen_expn_trns_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${gen_expn_rqst_seq} != '')" ).append("\n"); 
		query.append("AND GEN_EXPN_RQST_SEQ =  @[gen_expn_rqst_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crnt_gen_expn_apro_step_cd} != '')" ).append("\n"); 
		query.append("AND CRNT_GEN_EXPN_APRO_STEP_CD =  @[crnt_gen_expn_apro_step_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crnt_gen_expn_apsts_cd} != '')" ).append("\n"); 
		query.append("AND CRNT_GEN_EXPN_APSTS_CD =  @[crnt_gen_expn_apsts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY GEN_EXPN_RQST_SEQ ,  GEN_EXPN_RQST_SEQ , GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 

	}
}