/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanSensitivityAnalysisDBDAOEesEqr0065MultiVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.21 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanSensitivityAnalysisDBDAOEesEqr0065MultiVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 멀티VO
	  * </pre>
	  */
	public CntrRepoPlanSensitivityAnalysisDBDAOEesEqr0065MultiVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanSensitivityAnalysisDBDAOEesEqr0065MultiVORSQL").append("\n"); 
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
		query.append("select '' week" ).append("\n"); 
		query.append(",'' sensity" ).append("\n"); 
		query.append(",'' obj" ).append("\n"); 
		query.append(",'' fm_loc" ).append("\n"); 
		query.append(",'' to_loc" ).append("\n"); 
		query.append(",'' ts_type" ).append("\n"); 
		query.append(",'' vol" ).append("\n"); 
		query.append(",'' curr_cost" ).append("\n"); 
		query.append(",'' curr_limit" ).append("\n"); 
		query.append(",'' cost_ranage" ).append("\n"); 
		query.append(",'' cost_ranage1" ).append("\n"); 
		query.append(",'' lane" ).append("\n"); 
		query.append(",'' vvd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}