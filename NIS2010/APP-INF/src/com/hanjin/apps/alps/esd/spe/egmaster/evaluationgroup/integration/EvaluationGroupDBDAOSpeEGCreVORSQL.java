/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EvaluationGroupDBDAOSpeEGCreVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.26
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.26 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupDBDAOSpeEGCreVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESD_SPE_1001 화면의 vo 생성 쿼리
	  * </pre>
	  */
	public EvaluationGroupDBDAOSpeEGCreVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.integration").append("\n"); 
		query.append("FileName : EvaluationGroupDBDAOSpeEGCreVORSQL").append("\n"); 
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
		query.append("SELECT '' AS S_EG_RHQ_CD" ).append("\n"); 
		query.append(", '' AS S_EG_OFC_CD" ).append("\n"); 
		query.append(", '' AS S_SP_CATE_CD" ).append("\n"); 
		query.append(", '' AS S_EV_SVC_CATE_CD" ).append("\n"); 
		query.append(", '' AS EG_ID" ).append("\n"); 
		query.append(", '' AS EG_RHQ_CD " ).append("\n"); 
		query.append(", '' AS EG_OFC_CD " ).append("\n"); 
		query.append(", '' AS EV_SVC_CATE_CD" ).append("\n"); 
		query.append(", '' AS EV_SVC_CATE_CODE" ).append("\n"); 
		query.append(", '' AS EG_NM " ).append("\n"); 
		query.append(", '' AS CTRT_OFC_CD " ).append("\n"); 
		query.append(", '' AS DELT_FLG " ).append("\n"); 
		query.append(", '' AS CRE_USR_ID " ).append("\n"); 
		query.append(", '' AS CRE_DT " ).append("\n"); 
		query.append(", '' AS UPD_USR_ID " ).append("\n"); 
		query.append(", '' AS UPD_DT " ).append("\n"); 
		query.append(", '' AS ISFLAG " ).append("\n"); 
		query.append(", '' AS G_EG_RHQ_CD" ).append("\n"); 
		query.append(", '' AS G_EG_OFC_CD " ).append("\n"); 
		query.append(", '' AS G_EV_SVC_CATE_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}