/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOSearchSltChtrCreRStatusListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchSltChtrCreRStatusListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSltChtrCreRStatusList SELECT
	  * </pre>
	  */
	public NetworkCostDBDAOSearchSltChtrCreRStatusListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchSltChtrCreRStatusListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("     SLT_TP_CD              AS SLT_TP_CD" ).append("\n"); 
		query.append("    ,(CASE WHEN SLT_TP_CD = 'J' AND STND_COST_CD = '54400000' THEN 'Joint/Independent (SC Slottage)'" ).append("\n"); 
		query.append("           WHEN SLT_TP_CD = 'J' AND STND_COST_CD = '54400010' THEN 'Joint/Independent (SC Ope)'" ).append("\n"); 
		query.append("           WHEN SLT_TP_CD = 'S' THEN 'Slot Charter (SC Slottage)'" ).append("\n"); 
		query.append("      END)                  AS SLT_TP_NM" ).append("\n"); 
		query.append("    ,VOP_CD                 AS VOP_CD" ).append("\n"); 
		query.append("    ,INCM_BZC_CHTR_CD       AS INCM_BZC_CHTR_CD" ).append("\n"); 
		query.append("    ,INCM_SUB_LSE_CD        AS INCM_SUB_LSE_CD " ).append("\n"); 
		query.append("    ,INCM_CRS_CHTR_CD       AS INCM_CRS_CHTR_CD" ).append("\n"); 
		query.append("    ,EXPN_BZC_CHTR_CD       AS EXPN_BZC_CHTR_CD" ).append("\n"); 
		query.append("    ,EXPN_SUB_CHTR_CD       AS EXPN_SUB_CHTR_CD" ).append("\n"); 
		query.append("    ,EXPN_CRS_CHTR_CD       AS EXPN_CRS_CHTR_CD" ).append("\n"); 
		query.append("    ,OP_CRE_STS_CD          AS OP_CRE_STS_CD   " ).append("\n"); 
		query.append("    ,CRE_SLCT_FLG           AS CRE_SLCT_FLG  " ).append("\n"); 
		query.append("    ,STND_COST_CD           AS STND_COST_CD  " ).append("\n"); 
		query.append("   FROM COA_SLT_CHTR_INFO A	" ).append("\n"); 

	}
}