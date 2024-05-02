/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EvaluationGroupKpiTargetManageDBDAOSearchEGKpiTargetConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupKpiTargetManageDBDAOSearchEGKpiTargetConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEGKpiTargetManageRSQL
	  * </pre>
	  */
	public EvaluationGroupKpiTargetManageDBDAOSearchEGKpiTargetConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.integration").append("\n"); 
		query.append("FileName : EvaluationGroupKpiTargetManageDBDAOSearchEGKpiTargetConditionRSQL").append("\n"); 
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
		query.append("'' EG_ID," ).append("\n"); 
		query.append("'' EG_ID_SEQ," ).append("\n"); 
		query.append("'' EG_RHQ_CD," ).append("\n"); 
		query.append("'' EV_YR," ).append("\n"); 
		query.append("'' EG_CTY_CD," ).append("\n"); 
		query.append("'' SVC_CATE_CD," ).append("\n"); 
		query.append("'' MAPPED," ).append("\n"); 
		query.append("'' TMP1," ).append("\n"); 
		query.append("'' TMP2" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}