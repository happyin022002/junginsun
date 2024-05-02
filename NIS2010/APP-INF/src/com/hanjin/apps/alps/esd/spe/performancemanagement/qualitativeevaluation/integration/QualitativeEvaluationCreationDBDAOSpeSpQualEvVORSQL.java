/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QualitativeEvaluationCreationDBDAOSpeSpQualEvVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.02
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.04.02 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QualitativeEvaluationCreationDBDAOSpeSpQualEvVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qualitative Evaluation VO 생성쿼리
	  * </pre>
	  */
	public QualitativeEvaluationCreationDBDAOSpeSpQualEvVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration").append("\n"); 
		query.append("FileName : QualitativeEvaluationCreationDBDAOSpeSpQualEvVORSQL").append("\n"); 
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
		query.append("SELECT '' AS N1ST_EV_GRD_CTNT" ).append("\n"); 
		query.append(", '' AS N2ND_EV_GRD_CTNT" ).append("\n"); 
		query.append(", '' AS N3RD_EV_GRD_CTNT" ).append("\n"); 
		query.append(", '' AS GRADE_B" ).append("\n"); 
		query.append(", '' AS EV_WGT_RSLT_RT" ).append("\n"); 
		query.append(", '' AS CRE_DT" ).append("\n"); 
		query.append(", '' AS GRADE_A" ).append("\n"); 
		query.append(", '' AS SP_SEQ" ).append("\n"); 
		query.append(", '' AS SP_NAME" ).append("\n"); 
		query.append(", '' AS GRADE_C" ).append("\n"); 
		query.append(", '' AS EV_SVC_CATE_CD" ).append("\n"); 
		query.append(", '' AS EV_YR" ).append("\n"); 
		query.append(", '' AS UPD_USR_ID" ).append("\n"); 
		query.append(", '' AS EV_GRD_CHK_CD" ).append("\n"); 
		query.append(", '' AS UPD_DT" ).append("\n"); 
		query.append(", '' AS EV_MON" ).append("\n"); 
		query.append(", '' AS EV_FCTR_CTNT" ).append("\n"); 
		query.append(", '' AS EV_AREA_CTNT" ).append("\n"); 
		query.append(", '' AS EV_WGT_RT" ).append("\n"); 
		query.append(", '' AS CRE_USR_ID" ).append("\n"); 
		query.append(", '' AS SP_QUAL_EV_SEQ" ).append("\n"); 
		query.append(", '' AS QUAL_EV_SEQ" ).append("\n"); 
		query.append(", '' AS SP_KPI_ID" ).append("\n"); 
		query.append(", '' AS EG_ID" ).append("\n"); 
		query.append(", '' AS ISFLAG" ).append("\n"); 
		query.append(", '' AS EG_SVC_CATE_CD" ).append("\n"); 
		query.append(", '' AS ISFLAG" ).append("\n"); 
		query.append(", '' AS GRADE_A" ).append("\n"); 
		query.append(", '' AS GRADE_B" ).append("\n"); 
		query.append(", '' AS GRADE_C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", '' AS S_EG_RHQ_CD" ).append("\n"); 
		query.append(", '' AS S_EG_OFC_CD" ).append("\n"); 
		query.append(", '' AS S_EG_SVC_CATE_CD" ).append("\n"); 
		query.append(", '' AS S_SP_KPI_ID" ).append("\n"); 
		query.append(", '' AS S_EV_YR" ).append("\n"); 
		query.append(", '' AS S_EV_MON" ).append("\n"); 
		query.append(", '' AS S_SP_SEQ" ).append("\n"); 
		query.append(", '' AS S_EV_SVC_CATE_CD" ).append("\n"); 
		query.append(", '' AS S_EG_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", '' AS AVGSCORE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}