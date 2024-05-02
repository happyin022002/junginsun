/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OnsiteInspectionResultMgtDBDAOSearchSurveyItemsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 이율규
*@LastVersion : 1.0
* 2015.08.11 이율규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yulkyu Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnsiteInspectionResultMgtDBDAOSearchSurveyItemsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * M&R Onsite Inspection Result 설문조사서에 사용될 설문 항목들을 조회
	  * </pre>
	  */
	public OnsiteInspectionResultMgtDBDAOSearchSurveyItemsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.integration").append("\n"); 
		query.append("FileName : OnsiteInspectionResultMgtDBDAOSearchSurveyItemsRSQL").append("\n"); 
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
		query.append("SELECT EV_ITM_ORD_NO," ).append("\n"); 
		query.append("       EV_ITM_NM," ).append("\n"); 
		query.append("	   EV_ITM_SEQ" ).append("\n"); 
		query.append("  FROM MNR_ONSITE_INSP_RSLT_ITM" ).append("\n"); 
		query.append(" WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY LPAD(EV_ITM_ORD_NO, 4, '0')" ).append("\n"); 

	}
}