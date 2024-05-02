/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTOfficeAgreementInfoDBDAOSearchDeductionInfoChkDetailChkListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.18 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTOfficeAgreementInfoDBDAOSearchDeductionInfoChkDetailChkListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * (ESM_AGT_005) 
	  * </pre>
	  */
	public AGTOfficeAgreementInfoDBDAOSearchDeductionInfoChkDetailChkListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.integration").append("\n"); 
		query.append("FileName : AGTOfficeAgreementInfoDBDAOSearchDeductionInfoChkDetailChkListRSQL").append("\n"); 
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
		query.append("'0' AS CHK_YN," ).append("\n"); 
		query.append("CHG_CD," ).append("\n"); 
		query.append("CHG_NM," ).append("\n"); 
		query.append("REP_CHG_CD," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID       = 'CD00630'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = FRT_CHG_TP_CD" ).append("\n"); 
		query.append(")                                              AS FRT_CHG_TP_CD," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID       = 'CD00628'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = CHG_REV_TP_CD" ).append("\n"); 
		query.append(")                                              AS CHG_REV_TP_CD," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID       = 'CD00627'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = CHG_APLY_TP_CD" ).append("\n"); 
		query.append(")                                              AS CHG_APLY_TP_CD" ).append("\n"); 
		query.append("FROM MDM_CHARGE" ).append("\n"); 
		query.append("WHERE NVL (DELT_FLG, 'N')      = 'N'" ).append("\n"); 
		query.append("AND REP_CHG_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#if(${rep_chg_cd} != '')" ).append("\n"); 
		query.append("${rep_chg_cd}" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY REP_CHG_CD" ).append("\n"); 

	}
}