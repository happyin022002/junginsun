/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOsearchPreviousWeeksRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2010.04.15 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorMgtDBDAOsearchPreviousWeeksRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CIM Batch Job Status
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOsearchPreviousWeeksRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOsearchPreviousWeeksRSQL").append("\n"); 
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
		query.append("        SND_YEAR||SND_WEEK AS WF," ).append("\n"); 
		query.append("        FST_YEAR||FST_WEEK AS WT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                    LAG(PLN_YR,1) OVER (ORDER BY PLN_YR,PLN_WK) AS FST_YEAR," ).append("\n"); 
		query.append("                    LAG(PLN_WK,1) OVER (ORDER BY PLN_YR,PLN_WK) AS FST_WEEK," ).append("\n"); 
		query.append("                    LAG(PLN_YR,3) OVER (ORDER BY PLN_YR,PLN_WK) AS SND_YEAR," ).append("\n"); 
		query.append("                    LAG(PLN_WK,3) OVER (ORDER BY PLN_YR,PLN_WK) AS SND_WEEK," ).append("\n"); 
		query.append("                    PLN_YR||PLN_WK AS CUR_WEEK," ).append("\n"); 
		query.append("                    WK_ST_DT AS SAT_DATE," ).append("\n"); 
		query.append("                    WK_END_DT AS END_DATE" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("                    EQR_WK_PRD" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("        TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN A.SAT_DATE AND A.END_DATE" ).append("\n"); 

	}
}