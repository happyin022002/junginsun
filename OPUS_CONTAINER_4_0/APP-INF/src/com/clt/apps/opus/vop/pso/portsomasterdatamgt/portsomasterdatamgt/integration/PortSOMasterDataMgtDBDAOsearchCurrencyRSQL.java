/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortSOMasterDataMgtDBDAOsearchCurrencyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.04.15 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortSOMasterDataMgtDBDAOsearchCurrencyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCurrency
	  * </pre>
	  */
	public PortSOMasterDataMgtDBDAOsearchCurrencyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration").append("\n"); 
		query.append("FileName : PortSOMasterDataMgtDBDAOsearchCurrencyRSQL").append("\n"); 
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
		query.append("SELECT CURR_CD" ).append("\n"); 
		query.append(",CURR_NM" ).append("\n"); 
		query.append(",CNT_CD" ).append("\n"); 
		query.append(",DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM   MDM_CURRENCY" ).append("\n"); 
		query.append("ORDER  BY 1" ).append("\n"); 

	}
}