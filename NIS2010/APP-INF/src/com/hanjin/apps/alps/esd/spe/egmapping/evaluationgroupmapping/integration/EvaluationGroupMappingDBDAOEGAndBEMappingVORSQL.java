/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EvaluationGroupMappingDBDAOEGAndBEMappingVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.23
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.23 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupMappingDBDAOEGAndBEMappingVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EvaluationGroupMapping VO 생성쿼리
	  * </pre>
	  */
	public EvaluationGroupMappingDBDAOEGAndBEMappingVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.integration").append("\n"); 
		query.append("FileName : EvaluationGroupMappingDBDAOEGAndBEMappingVORSQL").append("\n"); 
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
		query.append("  '' AS EG_ID" ).append("\n"); 
		query.append(", '' AS EG_NM" ).append("\n"); 
		query.append(", '' AS SP_SEQ" ).append("\n"); 
		query.append(", '' AS SP_NAME" ).append("\n"); 
		query.append(", '' AS EV_YR" ).append("\n"); 
		query.append(", '' AS BZC_EV_GRD_CD" ).append("\n"); 
		query.append(", '' AS BZC_EV_GRD_NM" ).append("\n"); 
		query.append(", '' AS EVR_USR_ID" ).append("\n"); 
		query.append(", '' AS EVR_USR_NM" ).append("\n"); 
		query.append(", '' AS EV_DT" ).append("\n"); 
		query.append(", '' AS S_EG_RHQ_CD" ).append("\n"); 
		query.append(", '' AS S_EG_OFC_CD" ).append("\n"); 
		query.append(", '' AS S_EV_SVC_CATE_CD" ).append("\n"); 
		query.append(", '' AS S_CHK_ALL" ).append("\n"); 
		query.append(", '' AS S_CHK_MAP" ).append("\n"); 
		query.append(", '' AS S_CHK_UNMAP" ).append("\n"); 
		query.append(", '' AS S_EV_YR" ).append("\n"); 
		query.append(", '' AS SPE_YRMON" ).append("\n"); 
		query.append(", '' AS CRE_USR_ID" ).append("\n"); 
		query.append(", '' AS CRE_DT" ).append("\n"); 
		query.append(", '' AS UPD_USR_ID" ).append("\n"); 
		query.append(", '' AS UPD_DT" ).append("\n"); 
		query.append(", '' AS SP_BZC_EG_SEQ" ).append("\n"); 
		query.append(", '' AS G_EG_ID" ).append("\n"); 
		query.append(", '' AS G_SP_SEQ" ).append("\n"); 
		query.append(", '' AS G_EV_YR" ).append("\n"); 
		query.append(", '' AS ISFLAG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}