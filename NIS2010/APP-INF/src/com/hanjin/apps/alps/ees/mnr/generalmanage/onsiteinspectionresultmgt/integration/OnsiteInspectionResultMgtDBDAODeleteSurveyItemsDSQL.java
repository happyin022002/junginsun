/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OnsiteInspectionResultMgtDBDAODeleteSurveyItemsDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 이율규
*@LastVersion : 1.0
* 2015.08.04 이율규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yulkyu Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnsiteInspectionResultMgtDBDAODeleteSurveyItemsDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 설문 조사 항목들을 갱신하기 전에, 이전의 데이터를 모두 삭제(Delete Flag가 N인 것들만 삭제)
	  * </pre>
	  */
	public OnsiteInspectionResultMgtDBDAODeleteSurveyItemsDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.integration ").append("\n"); 
		query.append("FileName : OnsiteInspectionResultMgtDBDAODeleteSurveyItemsDSQL").append("\n"); 
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
		query.append("DELETE MNR_ONSITE_INSP_RSLT_ITM" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 

	}
}