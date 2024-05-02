/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSlotXchLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.08.19 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSlotXchLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSlotXchLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSlotXchLaneRSQL").append("\n"); 
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
		query.append("''ACCT_YRMON_FR" ).append("\n"); 
		query.append(",''ACCT_YRMON_TO" ).append("\n"); 
		query.append(",''TRD_CD" ).append("\n"); 
		query.append(",''RLANE_CD" ).append("\n"); 
		query.append(",''VVD" ).append("\n"); 
		query.append(",''R_STL_BSA_QTY" ).append("\n"); 
		query.append(",''R_STL_BSA_SLT_PRC" ).append("\n"); 
		query.append(",''R_STL_LOCL_AMT" ).append("\n"); 
		query.append(",''R_JO_CRR_CD" ).append("\n"); 
		query.append(",''E_STL_LOCL_AMT" ).append("\n"); 
		query.append(",''E_STL_BSA_SLT_PRC" ).append("\n"); 
		query.append(",''E_STL_BSA_QTY" ).append("\n"); 
		query.append(",''E_JO_CRR_CD" ).append("\n"); 
		query.append(",''ACCT_YRMON" ).append("\n"); 
		query.append(",''COST_WK" ).append("\n"); 
		query.append(",''ACCT_YR" ).append("\n"); 
		query.append(",''COST_FR" ).append("\n"); 
		query.append(",''COST_TO" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}