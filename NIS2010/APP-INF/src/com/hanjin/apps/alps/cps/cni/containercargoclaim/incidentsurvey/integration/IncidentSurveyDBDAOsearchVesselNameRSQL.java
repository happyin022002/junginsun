/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IncidentSurveyDBDAOsearchVesselNameRSQL.java
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

public class IncidentSurveyDBDAOsearchVesselNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD validation
	  * </pre>
	  */
	public IncidentSurveyDBDAOsearchVesselNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.integration").append("\n"); 
		query.append("FileName : IncidentSurveyDBDAOsearchVesselNameRSQL").append("\n"); 
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
		query.append("    A.VSL_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    MDM_COUNTRY MC" ).append("\n"); 
		query.append("  , AR_MST_REV_VVD B" ).append("\n"); 
		query.append("  , MDM_VSL_BLK A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    MC.CNT_CD(+)                             = A.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("    AND B.VSL_CD(+)                          = A.VSL_CD" ).append("\n"); 
		query.append("    AND A.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD = @[vsl_cd]" ).append("\n"); 
		query.append("    AND A.DELT_FLG                           = 'N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    A.VSL_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    MDM_COUNTRY MC" ).append("\n"); 
		query.append("  , VSK_VSL_SKD B" ).append("\n"); 
		query.append("  , MDM_VSL_CNTR A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    MC.CNT_CD                                = A.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("    AND B.VSL_CD(+)                          = A.VSL_CD" ).append("\n"); 
		query.append("    AND A.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD = @[vsl_cd]" ).append("\n"); 
		query.append("    AND A.DELT_FLG                           = 'N'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 

	}
}