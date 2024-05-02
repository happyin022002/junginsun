/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QualitativeEvaluationCreationDBDAOSpeQECreVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.10
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.10 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QualitativeEvaluationCreationDBDAOSpeQECreVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qualitative Evaluation Sheet Creation VO 생성쿼리
	  * </pre>
	  */
	public QualitativeEvaluationCreationDBDAOSpeQECreVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration ").append("\n"); 
		query.append("FileName : QualitativeEvaluationCreationDBDAOSpeQECreVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append(" '' AS UPD_DT" ).append("\n"); 
		query.append(",'' AS N1ST_EV_GRD_CTNT" ).append("\n"); 
		query.append(",'' AS EV_FCTR_CTNT" ).append("\n"); 
		query.append(",'' AS TOT_WGT" ).append("\n"); 
		query.append(",'' AS CRE_DT" ).append("\n"); 
		query.append(",'' AS EV_AREA_CTNT" ).append("\n"); 
		query.append(",'' AS EV_WGT_RT" ).append("\n"); 
		query.append(",'' AS CRE_USR_ID" ).append("\n"); 
		query.append(",'' AS QUAL_EV_SEQ" ).append("\n"); 
		query.append(",'' AS EV_YR" ).append("\n"); 
		query.append(",'' AS N2ND_EV_GRD_CTNT" ).append("\n"); 
		query.append(",'' AS UPD_USR_ID" ).append("\n"); 
		query.append(",'' AS N3RD_EV_GRD_CTNT" ).append("\n"); 
		query.append(",'' AS EV_SVC_CATE_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}