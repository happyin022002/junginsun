/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IncidentSurveyDBDAOSearchMaxClaimInciNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.01.27 양정란
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yang jung ran
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IncidentSurveyDBDAOSearchMaxClaimInciNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Claim Inci No 생성시 최대값 가져오기
	  * </pre>
	  */
	public IncidentSurveyDBDAOSearchMaxClaimInciNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.integration").append("\n"); 
		query.append("FileName : IncidentSurveyDBDAOSearchMaxClaimInciNoRSQL").append("\n"); 
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
		query.append("    'INCID' || TO_CHAR (SYSDATE, 'YYYY') || LTRIM (TO_CHAR (TO_NUMBER ( (NVL (SUBSTR (MAX (CGO_CLM_INCI_NO), 10, 4), 0))) + 1, '0009')) AS CGO_CLM_INCI_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    CNI_CGO_CLM_INCI" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    CGO_CLM_INCI_NO LIKE 'INCID' || TO_CHAR (SYSDATE, 'YYYY') || '%'" ).append("\n"); 

	}
}