/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OccurrenceAnalysisDAOCondRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2010.02.04 박제성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Je Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OccurrenceAnalysisDAOCondRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Occurrence Analysis  Cond
	  * </pre>
	  */
	public OccurrenceAnalysisDAOCondRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo").append("\n"); 
		query.append("FileName : OccurrenceAnalysisDAOCondRSQL").append("\n"); 
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
		query.append(" '' REPORT_BY" ).append("\n"); 
		query.append(", '' PERIOD " ).append("\n"); 
		query.append(", '' FROM_PERIOD" ).append("\n"); 
		query.append(", '' TO_PERIOD" ).append("\n"); 
		query.append(", '' PAGE_NO" ).append("\n"); 
		query.append(", '' RDBTN" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}