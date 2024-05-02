/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PreCMSimulationDBDAOSearchBzcCostYrmonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreCMSimulationDBDAOSearchBzcCostYrmonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBzcCostYrmon
	  * </pre>
	  */
	public PreCMSimulationDBDAOSearchBzcCostYrmonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.integration ").append("\n"); 
		query.append("FileName : PreCMSimulationDBDAOSearchBzcCostYrmonRSQL").append("\n"); 
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
		query.append("SELECT	COA_BZC_COST_YRMON_FNC('') COST_YRMON" ).append("\n"); 
		query.append("FROM 	DUAL" ).append("\n"); 

	}
}