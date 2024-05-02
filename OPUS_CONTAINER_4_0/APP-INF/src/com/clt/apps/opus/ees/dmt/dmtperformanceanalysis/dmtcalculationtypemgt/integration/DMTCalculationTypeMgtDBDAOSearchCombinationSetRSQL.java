/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DMTCalculationTypeMgtDBDAOSearchCombinationSetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationTypeMgtDBDAOSearchCombinationSetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Combination Set을 조회한다.
	  * </pre>
	  */
	public DMTCalculationTypeMgtDBDAOSearchCombinationSetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.integration").append("\n"); 
		query.append("FileName : DMTCalculationTypeMgtDBDAOSearchCombinationSetRSQL").append("\n"); 
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
		query.append("SELECT DMDT_CNTR_TP_CD," ).append("\n"); 
		query.append("       DMDT_CGO_TP_CD," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(CRE_DT, 'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("  FROM DMT_CMB_SET" ).append("\n"); 

	}
}