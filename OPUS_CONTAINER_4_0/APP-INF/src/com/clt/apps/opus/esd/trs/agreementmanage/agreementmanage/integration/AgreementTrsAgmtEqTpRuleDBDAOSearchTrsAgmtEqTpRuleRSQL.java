/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgreementTrsAgmtEqTpRuleDBDAOSearchTrsAgmtEqTpRuleRSQL.java
*@FileTitle : TRS_AGMT_EQ_TP_RULE
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 이준근
*@LastVersion : 1.0
* 2012.04.25 이준근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeJunKun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementTrsAgmtEqTpRuleDBDAOSearchTrsAgmtEqTpRuleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTrsAgmtEqTpRule
	  * </pre>
	  */
	public AgreementTrsAgmtEqTpRuleDBDAOSearchTrsAgmtEqTpRuleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_trsp_agmt_rule_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementTrsAgmtEqTpRuleDBDAOSearchTrsAgmtEqTpRuleRSQL").append("\n"); 
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
		query.append("       TRSP_AGMT_RULE_SEQ    " ).append("\n"); 
		query.append("      ,TRSP_AGMT_RULE_TP_CD" ).append("\n"); 
		query.append("      ,TRSP_AGMT_STEP_KNT" ).append("\n"); 
		query.append("      ,TRSP_AGMT_COST_MOD_CD" ).append("\n"); 
		query.append("      ,TRSP_AGMT_CGO_TP_CD" ).append("\n"); 
		query.append("      ,TRSP_AGMT_EQ_KND_CD" ).append("\n"); 
		query.append("      ,TRSP_AGMT_EQ_TP_CD" ).append("\n"); 
		query.append("      ,TRSP_AGMT_EQ_SZ_CD" ).append("\n"); 
		query.append("      ,TRSP_AGMT_TP_CD" ).append("\n"); 
		query.append("      ,TRSP_MOD_CD" ).append("\n"); 
		query.append("      ,SCG_COND_CD" ).append("\n"); 
		query.append("      ,FM_LOC_COND_CD" ).append("\n"); 
		query.append("      ,VIA_LOC_COND_CD" ).append("\n"); 
		query.append("      ,TO_LOC_COND_CD" ).append("\n"); 
		query.append("      ,DOR_LOC_COND_CD" ).append("\n"); 
		query.append("      ,RCV_COND_CD" ).append("\n"); 
		query.append("      ,DE_COND_CD" ).append("\n"); 
		query.append("      ,RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("      ,RT_COND_CD" ).append("\n"); 
		query.append("      ,CURR_COND_CD" ).append("\n"); 
		query.append("      ,RND_TRP_RT_COND_CD" ).append("\n"); 
		query.append("      ,CHSS_NO_COND_CD" ).append("\n"); 
		query.append("      ,TO_DIST_COND_CD" ).append("\n"); 
		query.append("      ,FX_PER_DIST_COND_CD" ).append("\n"); 
		query.append("      ,DIST_UT_COND_CD" ).append("\n"); 
		query.append("      ,OVWT_UT_COND_CD" ).append("\n"); 
		query.append("      ,OVWT_STND_COND_CD" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("FROM TRS_AGMT_EQ_TP_RULE" ).append("\n"); 
		query.append("WHERE 1 =1" ).append("\n"); 
		query.append("#if (${frm_trsp_agmt_rule_tp_cd} != '') " ).append("\n"); 
		query.append("	AND TRSP_AGMT_RULE_TP_CD = @[frm_trsp_agmt_rule_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY TRSP_AGMT_RULE_SEQ" ).append("\n"); 

	}
}