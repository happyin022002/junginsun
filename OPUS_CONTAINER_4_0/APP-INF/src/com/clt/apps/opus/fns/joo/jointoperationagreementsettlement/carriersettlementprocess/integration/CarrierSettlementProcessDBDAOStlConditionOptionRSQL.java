/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOStlConditionOptionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.15 장강철
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

public class CarrierSettlementProcessDBDAOStlConditionOptionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOStlConditionOptionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOStlConditionOptionRSQL").append("\n"); 
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
		query.append("SELECT  ''ACCT_YRMON," ).append("\n"); 
		query.append("''JO_CRR_CD," ).append("\n"); 
		query.append("''TRD_CD," ).append("\n"); 
		query.append("''REV_DIR_CD," ).append("\n"); 
		query.append("''RLANE_CD" ).append("\n"); 
		query.append("FROM  DUAL" ).append("\n"); 

	}
}