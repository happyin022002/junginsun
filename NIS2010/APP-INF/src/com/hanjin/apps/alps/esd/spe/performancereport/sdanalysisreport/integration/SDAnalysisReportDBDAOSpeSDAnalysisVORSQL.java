/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SDAnalysisReportDBDAOSpeSDAnalysisVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.23
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.23 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SDAnalysisReportDBDAOSpeSDAnalysisVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SD Analysis Report VO 생성쿼리
	  * </pre>
	  */
	public SDAnalysisReportDBDAOSpeSDAnalysisVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.integration").append("\n"); 
		query.append("FileName : SDAnalysisReportDBDAOSpeSDAnalysisVORSQL").append("\n"); 
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
		query.append("SELECT '' AS EG_RHQ_CD" ).append("\n"); 
		query.append("   , '' AS EG_OFC_CD" ).append("\n"); 
		query.append("   , '' AS EV_SVC_CATE_CD" ).append("\n"); 
		query.append("   , '' AS EG_ID" ).append("\n"); 
		query.append("   , '' AS EG_NM" ).append("\n"); 
		query.append("   , '' AS SP_SEQ" ).append("\n"); 
		query.append("   , '' AS SP_NAME" ).append("\n"); 
		query.append("   , '' AS SD_GROUP" ).append("\n"); 
		query.append("   , '' AS PA_POINT" ).append("\n"); 
		query.append("   , '' AS PA_GROUP" ).append("\n"); 
		query.append("   , '' AS BE_POINT" ).append("\n"); 
		query.append("   , '' AS BE_GROUP" ).append("\n"); 
		query.append("   , '' AS S_EG_RHQ_CD" ).append("\n"); 
		query.append("   , '' AS S_EG_OFC_CD" ).append("\n"); 
		query.append("   , '' AS S_EV_SVC_CATE_CD" ).append("\n"); 
		query.append("   , '' AS S_SP_SEQ" ).append("\n"); 
		query.append("   , '' AS MON" ).append("\n"); 
		query.append("   , '' AS FROM_DT" ).append("\n"); 
		query.append("   , '' AS TO_DT" ).append("\n"); 
		query.append("   , '' AS EV_YR" ).append("\n"); 
		query.append("   , '' AS EV_FROM_YR" ).append("\n"); 
		query.append("   , '' AS EV_TO_YR" ).append("\n"); 
		query.append("   , '' AS EV_FROM_MON" ).append("\n"); 
		query.append("   , '' AS EV_TO_MON" ).append("\n"); 
		query.append("   , '' AS S_SD_GP" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}