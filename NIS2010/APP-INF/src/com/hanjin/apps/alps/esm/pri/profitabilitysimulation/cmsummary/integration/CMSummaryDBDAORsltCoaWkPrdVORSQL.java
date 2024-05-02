/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CMSummaryDBDAORsltCoaWkPrdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CMSummaryDBDAORsltCoaWkPrdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2015.06.26 CHM-201536492 Split05-주간 MAS Open에 따른 타모듈 프로그램 적용 요청 
	  * </pre>
	  */
	public CMSummaryDBDAORsltCoaWkPrdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration").append("\n"); 
		query.append("FileName : CMSummaryDBDAORsltCoaWkPrdVORSQL").append("\n"); 
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
		query.append("SELECT COST_YR,COST_WK,SLS_FM_DT,SLS_TO_DT ," ).append("\n"); 
		query.append("       CASE WHEN TO_DATE(SYSDATE) <= TO_DATE(SLS_TO_DT,'YYYYMMDD')  AND TO_DATE(SYSDATE) >= TO_DATE(SLS_FM_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("			THEN 0" ).append("\n"); 
		query.append("			WHEN TO_DATE(SYSDATE) > TO_DATE(SLS_TO_DT,'YYYYMMDD')   " ).append("\n"); 
		query.append("            THEN -1" ).append("\n"); 
		query.append("            ELSE 1" ).append("\n"); 
		query.append("       END AS WK_TP" ).append("\n"); 
		query.append("FROM MAS_WK_PRD " ).append("\n"); 
		query.append("ORDER BY COST_YR,COST_WK" ).append("\n"); 

	}
}