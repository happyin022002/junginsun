/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QualitativeEvaluationCreationDBDAOSearchQECreRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.07
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.04.07 백형인
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

public class QualitativeEvaluationCreationDBDAOSearchQECreRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qualitative Evaluation 테이블에서 데이터를 조회한다.
	  * </pre>
	  */
	public QualitativeEvaluationCreationDBDAOSearchQECreRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_svc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration").append("\n"); 
		query.append("FileName : QualitativeEvaluationCreationDBDAOSearchQECreRSQL").append("\n"); 
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
		query.append("SELECT 	 EV_YR" ).append("\n"); 
		query.append("		,EV_SVC_CATE_CD" ).append("\n"); 
		query.append("		,QUAL_EV_SEQ" ).append("\n"); 
		query.append("		,EV_AREA_CTNT" ).append("\n"); 
		query.append("		,EV_FCTR_CTNT" ).append("\n"); 
		query.append("		,EV_WGT_RT" ).append("\n"); 
		query.append("		,N1ST_EV_GRD_CTNT" ).append("\n"); 
		query.append("		,N2ND_EV_GRD_CTNT" ).append("\n"); 
		query.append("		,N3RD_EV_GRD_CTNT" ).append("\n"); 
		query.append("		,CRE_USR_ID" ).append("\n"); 
		query.append("		,CRE_DT" ).append("\n"); 
		query.append("		,UPD_USR_ID" ).append("\n"); 
		query.append("		,UPD_DT" ).append("\n"); 
		query.append("FROM SPE_QUAL_EV" ).append("\n"); 
		query.append("WHERE EV_YR = @[ev_yr]" ).append("\n"); 
		query.append("AND EV_SVC_CATE_CD = @[ev_svc_cate_cd]" ).append("\n"); 

	}
}