/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IncidentSurveyDBDAOSearchIncidentInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2009.11.19 양정란
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

public class IncidentSurveyDBDAOSearchIncidentInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IncidentSurvey 조회
	  * </pre>
	  */
	public IncidentSurveyDBDAOSearchIncidentInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_plc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_str",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_to_str",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_area",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_from_str",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.integration").append("\n"); 
		query.append("FileName : IncidentSurveyDBDAOSearchIncidentInquiryListRSQL").append("\n"); 
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
		query.append("CGO_CLM_INCI_NO" ).append("\n"); 
		query.append(", CLM_AREA_CD" ).append("\n"); 
		query.append(", CRE_OFC_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", INCI_PLC_TP_CD" ).append("\n"); 
		query.append(", INCI_LOC_CD" ).append("\n"); 
		query.append(", INCI_OCCR_DT" ).append("\n"); 
		query.append(", INCI_REF_VVD_NO" ).append("\n"); 
		query.append(", INCI_SUBJ_NM" ).append("\n"); 
		query.append(", INCI_DEV_DESC" ).append("\n"); 
		query.append(", ROW_NUM" ).append("\n"); 
		query.append(", TOTAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("INCI.CGO_CLM_INCI_NO" ).append("\n"); 
		query.append(", AREA.CLM_AREA_CD" ).append("\n"); 
		query.append(", INCI.CRE_OFC_CD" ).append("\n"); 
		query.append(", INCI.CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR (INCI.CRE_DT, 'YYYYMMDD') AS CRE_DT" ).append("\n"); 
		query.append(", INCI.INCI_PLC_TP_CD" ).append("\n"); 
		query.append(", INCI.INCI_LOC_CD" ).append("\n"); 
		query.append(", INCI.INCI_OCCR_DT" ).append("\n"); 
		query.append(", INCI.INCI_REF_VVD_NO" ).append("\n"); 
		query.append(", INCI.INCI_SUBJ_NM" ).append("\n"); 
		query.append(", INCI.INCI_DEV_DESC" ).append("\n"); 
		query.append(", ROW_NUMBER () OVER (ORDER BY INCI.CGO_CLM_INCI_NO DESC) ROW_NUM" ).append("\n"); 
		query.append(", COUNT ( *) OVER () TOTAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_CGO_CLM_INCI INCI" ).append("\n"); 
		query.append(", CNI_AREA_OFC AREA" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("INCI.CRE_OFC_CD  = AREA.OFC_CD(+)" ).append("\n"); 
		query.append("#if(${sch_cond} == 'INCI_NO')" ).append("\n"); 
		query.append("AND INCI.CGO_CLM_INCI_NO LIKE @[sch_str]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sch_cond} == 'VVD')" ).append("\n"); 
		query.append("AND INCI.INCI_REF_VVD_NO LIKE @[sch_str]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sch_area} != '')" ).append("\n"); 
		query.append("AND AREA.CLM_AREA_CD = @[sch_area]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sch_ofc_cd} != '')" ).append("\n"); 
		query.append("AND INCI.CRE_OFC_CD = @[sch_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sch_cre_usr_id} != '')" ).append("\n"); 
		query.append("AND INCI.CRE_USR_ID = @[sch_cre_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sch_plc_tp_cd} != '')" ).append("\n"); 
		query.append("AND INCI.INCI_PLC_TP_CD = @[sch_plc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sch_loc_cd} != '')" ).append("\n"); 
		query.append("AND INCI.INCI_LOC_CD = @[sch_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sch_duration} == 'DOI')" ).append("\n"); 
		query.append("AND INCI.INCI_OCCR_DT BETWEEN @[sch_from_str] AND @[sch_to_str]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sch_duration} == 'DORG')" ).append("\n"); 
		query.append("AND TO_CHAR(INCI.CRE_DT,'YYYYMMDD') BETWEEN @[sch_from_str] AND @[sch_to_str]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${start_page} != '')" ).append("\n"); 
		query.append("WHERE ROW_NUM BETWEEN ${start_page} AND ${end_page}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}