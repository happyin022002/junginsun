/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QualitativeEvaluationCreationDBDAOSpeQECreRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.24
*@LastModifier : 노영현
*@LastVersion : 1.0
* 2015.02.24 노영현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author N.Y.H
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QualitativeEvaluationCreationDBDAOSpeQECreRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qualitative Evaluation VO를 생성한다.
	  * </pre>
	  */
	public QualitativeEvaluationCreationDBDAOSpeQECreRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration").append("\n"); 
		query.append("FileName : QualitativeEvaluationCreationDBDAOSpeQECreRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append(" '' as ev_yr" ).append("\n"); 
		query.append(",'' as eg_svc_cate_cd" ).append("\n"); 
		query.append(",'' as qual_ev_seq" ).append("\n"); 
		query.append(",'' as ev_area_ctnt" ).append("\n"); 
		query.append(",'' as ev_fctr_ctnt" ).append("\n"); 
		query.append(",'' as ev_wgt_rt" ).append("\n"); 
		query.append(",'' as n1st_ev_grd_ctnt" ).append("\n"); 
		query.append(",'' as n2nd_ev_grd_ctnt" ).append("\n"); 
		query.append(",'' as n3rd_ev_grd_ctnt" ).append("\n"); 
		query.append(",'' as cre_usr_id" ).append("\n"); 
		query.append(",'' as cre_dt" ).append("\n"); 
		query.append(",'' as upd_usr_id" ).append("\n"); 
		query.append(",'' as upd_dt" ).append("\n"); 
		query.append(",'' as tot_wgt" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}