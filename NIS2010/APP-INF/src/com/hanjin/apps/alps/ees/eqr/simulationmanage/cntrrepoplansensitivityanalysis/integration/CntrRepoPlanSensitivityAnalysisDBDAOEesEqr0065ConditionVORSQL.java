/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanSensitivityAnalysisDBDAOEesEqr0065ConditionVORSQL.java
*@FileTitle : 민감도 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.18 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanSensitivityAnalysisDBDAOEesEqr0065ConditionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조건절 VO
	  * </pre>
	  */
	public CntrRepoPlanSensitivityAnalysisDBDAOEesEqr0065ConditionVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.integration ").append("\n"); 
		query.append("FileName : CntrRepoPlanSensitivityAnalysisDBDAOEesEqr0065ConditionVORSQL").append("\n"); 
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
		query.append("'' yyyyww," ).append("\n"); 
		query.append("'' seq," ).append("\n"); 
		query.append("'' repoRmk," ).append("\n"); 
		query.append("'' fmToAt," ).append("\n"); 
		query.append("'' fmType," ).append("\n"); 
		query.append("'' fmEccCd," ).append("\n"); 
		query.append("'' toType," ).append("\n"); 
		query.append("'' toEccCd," ).append("\n"); 
		query.append("'' atType," ).append("\n"); 
		query.append("'' atEccCd," ).append("\n"); 
		query.append("'' fmStartYear," ).append("\n"); 
		query.append("'' fmStartWeek," ).append("\n"); 
		query.append("'' fmEndYear," ).append("\n"); 
		query.append("'' fmEndWeek," ).append("\n"); 
		query.append("'' toStartYear," ).append("\n"); 
		query.append("'' toStartWeek," ).append("\n"); 
		query.append("'' toEndYear," ).append("\n"); 
		query.append("'' toEndWeek," ).append("\n"); 
		query.append("'' atStartYear," ).append("\n"); 
		query.append("'' atStartWeek," ).append("\n"); 
		query.append("'' atEndYear," ).append("\n"); 
		query.append("'' atEndWeek," ).append("\n"); 
		query.append("'' cntrTpszCd," ).append("\n"); 
		query.append("'' sens," ).append("\n"); 
		query.append("'' costObj," ).append("\n"); 
		query.append("'' limitObj," ).append("\n"); 
		query.append("'' sensText," ).append("\n"); 
		query.append("'' objectText," ).append("\n"); 
		query.append("'' scnrID," ).append("\n"); 
		query.append("'' User_ID," ).append("\n"); 
		query.append("'' run_id" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}