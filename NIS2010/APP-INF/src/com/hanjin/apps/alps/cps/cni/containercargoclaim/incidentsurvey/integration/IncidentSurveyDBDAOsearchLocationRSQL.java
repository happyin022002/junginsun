/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IncidentSurveyDBDAOsearchLocationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.03.18 양정란
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

public class IncidentSurveyDBDAOsearchLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * location validation
	  * </pre>
	  */
	public IncidentSurveyDBDAOsearchLocationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.integration").append("\n"); 
		query.append("FileName : IncidentSurveyDBDAOsearchLocationRSQL").append("\n"); 
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
		query.append("    A.LOC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    MDM_LOCATION A" ).append("\n"); 
		query.append("  , MDM_COUNTRY B" ).append("\n"); 
		query.append("  , MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    1            = 1" ).append("\n"); 
		query.append("    AND A.CNT_CD = B.CNT_CD(+)" ).append("\n"); 
		query.append("    AND A.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("    AND A.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("    AND NVL (A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("    AND NVL (B.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}