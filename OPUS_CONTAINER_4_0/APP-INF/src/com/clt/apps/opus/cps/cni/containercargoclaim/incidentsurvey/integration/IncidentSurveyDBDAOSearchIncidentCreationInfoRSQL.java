/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IncidentSurveyDBDAOSearchIncidentCreationInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2009.11.12 양정란
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yang jung ran
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IncidentSurveyDBDAOSearchIncidentCreationInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IncidentCreation 조회
	  * </pre>
	  */
	public IncidentSurveyDBDAOSearchIncidentCreationInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.integration ").append("\n"); 
		query.append("FileName : IncidentSurveyDBDAOSearchIncidentCreationInfoRSQL").append("\n"); 
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
		query.append("INCI.CGO_CLM_INCI_NO" ).append("\n"); 
		query.append(", AREA.CLM_AREA_CD" ).append("\n"); 
		query.append(", INCI.CRE_OFC_CD" ).append("\n"); 
		query.append(", INCI.INCI_PLC_TP_CD" ).append("\n"); 
		query.append(", INCI.CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(INCI.CRE_DT,'YYYYMMDD') AS CRE_DT" ).append("\n"); 
		query.append(", TO_CHAR(INCI.UPD_DT,'YYYYMMDD') AS UPD_DT" ).append("\n"); 
		query.append(", INCI.INCI_OCCR_DT" ).append("\n"); 
		query.append(", INCI.INCI_REF_VVD_NO" ).append("\n"); 
		query.append(", INCI.INCI_LOC_CD" ).append("\n"); 
		query.append(", INCI.INCI_SUBJ_NM" ).append("\n"); 
		query.append(", INCI.INCI_DEV_DESC" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_CGO_CLM_INCI INCI" ).append("\n"); 
		query.append(", CNI_AREA_OFC AREA" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("INCI.CRE_OFC_CD      = AREA.OFC_CD(+)" ).append("\n"); 
		query.append("AND INCI.CGO_CLM_INCI_NO = @[cgo_clm_inci_no]" ).append("\n"); 

	}
}