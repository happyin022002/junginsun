/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ExpenseSummaryByOfficeDBDAOSearchExpenseSummaryByOfficeChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.expensesummary.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExpenseSummaryByOfficeDBDAOSearchExpenseSummaryByOfficeChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 미주 office 판단 쿼리
	  * </pre>
	  */
	public ExpenseSummaryByOfficeDBDAOSearchExpenseSummaryByOfficeChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.expensesummary.integration").append("\n"); 
		query.append("FileName : ExpenseSummaryByOfficeDBDAOSearchExpenseSummaryByOfficeChkRSQL").append("\n"); 
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
		query.append("SELECT	COUNT(*) CHK" ).append("\n"); 
		query.append("FROM	MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE	OFC_CD IN (" ).append("\n"); 
		query.append("					#foreach( ${key} in ${inputOfcArr})" ).append("\n"); 
		query.append("						#if($velocityCount == 1)" ).append("\n"); 
		query.append("		    				UPPER('${key}')" ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("		    				, UPPER('${key}')" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				  ) " ).append("\n"); 
		query.append("AND		AR_HD_QTR_OFC_CD = 'NYCRA'" ).append("\n"); 

	}
}