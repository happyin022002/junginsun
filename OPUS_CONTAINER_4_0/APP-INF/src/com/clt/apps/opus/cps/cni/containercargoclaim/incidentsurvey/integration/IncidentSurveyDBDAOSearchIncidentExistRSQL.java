/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IncidentSurveyDBDAOSearchIncidentExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2009.10.27 양정란
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yang jung ran
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IncidentSurveyDBDAOSearchIncidentExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Incident 입력/수정 결정
	  * </pre>
	  */
	public IncidentSurveyDBDAOSearchIncidentExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_inci_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.integration").append("\n"); 
		query.append("FileName : IncidentSurveyDBDAOSearchIncidentExistRSQL").append("\n"); 
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
		query.append("'Y' EXIST" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("EXISTS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CGO_CLM_INCI_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_CGO_CLM_INCI" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CGO_CLM_INCI_NO = @[cgo_clm_inci_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}