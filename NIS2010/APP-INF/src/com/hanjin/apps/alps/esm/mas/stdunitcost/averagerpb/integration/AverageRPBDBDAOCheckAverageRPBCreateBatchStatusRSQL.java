/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AverageRPBDBDAOCheckAverageRPBCreateBatchStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AverageRPBDBDAOCheckAverageRPBCreateBatchStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckAverageRPBCreateBatchStatus
	  * </pre>
	  */
	public AverageRPBDBDAOCheckAverageRPBCreateBatchStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.integration ").append("\n"); 
		query.append("FileName : AverageRPBDBDAOCheckAverageRPBCreateBatchStatusRSQL").append("\n"); 
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
		query.append("   AND CM_UC_CD = 'RPBC'" ).append("\n"); 

	}
}