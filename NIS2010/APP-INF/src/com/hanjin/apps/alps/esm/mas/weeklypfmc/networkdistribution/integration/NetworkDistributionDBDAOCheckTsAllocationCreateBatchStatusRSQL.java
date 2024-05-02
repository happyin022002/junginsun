/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : NetworkDistributionDBDAOCheckTsAllocationCreateBatchStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.31
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2013.01.31 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOCheckTsAllocationCreateBatchStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TS Allocation BATCH 가 실행중인지 체크한다.
	  * </pre>
	  */
	public NetworkDistributionDBDAOCheckTsAllocationCreateBatchStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOCheckTsAllocationCreateBatchStatusRSQL").append("\n"); 
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
		query.append("SELECT COST_WK,COST_CRE_STS_CD" ).append("\n"); 
		query.append("  FROM MAS_UT_COST_CRE_STS" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND COST_CRE_STS_CD = 'P'" ).append("\n"); 
		query.append("   AND CM_UC_CD = 'TSAL'" ).append("\n"); 

	}
}