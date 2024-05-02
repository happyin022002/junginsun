/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOAdjustConditionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.10.12 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOAdjustConditionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Adjustment의 조회조건
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOAdjustConditionVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOAdjustConditionVORSQL").append("\n"); 
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
		query.append("'' AS FM_ACCT_YRMON" ).append("\n"); 
		query.append(",'' AS TO_ACCT_YRMON" ).append("\n"); 
		query.append(",'' AS ACCT_YRMON" ).append("\n"); 
		query.append(",'' AS JO_CRR_CD" ).append("\n"); 
		query.append(",'' AS RE_DIVR_CD" ).append("\n"); 
		query.append(",'' AS TRD_CD" ).append("\n"); 
		query.append(",'' AS RLANE_CD" ).append("\n"); 
		query.append(",'' AS DIFF_ONLY_YN" ).append("\n"); 
		query.append(",'' AS JO_STL_ITM_CD" ).append("\n"); 
		query.append(",'' AS JO_MNU_NM" ).append("\n"); 
		query.append(",'' AS LOCL_CURR_CD" ).append("\n"); 
		query.append(",'' AS STL_ADJ_IRR_FLG" ).append("\n"); 
		query.append("FROM  DUAL" ).append("\n"); 

	}
}