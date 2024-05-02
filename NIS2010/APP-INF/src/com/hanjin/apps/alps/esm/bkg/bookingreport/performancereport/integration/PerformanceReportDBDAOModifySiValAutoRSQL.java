/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOModifySiValAutoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.17
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.06.17 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOModifySiValAutoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PerformanceReportDBDAOModifySiValAutoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOModifySiValAutoRSQL").append("\n"); 
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
		query.append("/* For In VO */" ).append("\n"); 
		query.append("SELECT  '' BKG_NO" ).append("\n"); 
		query.append(",       '' XTER_SNDR_ID" ).append("\n"); 
		query.append(",       '' XTER_RQST_NO" ).append("\n"); 
		query.append(",       '' XTER_RQST_SEQ" ).append("\n"); 
		query.append(",       '' USR_ID" ).append("\n"); 
		query.append(",       '' O_RESULT" ).append("\n"); 
		query.append(",       '' O_ERR_MSG" ).append("\n"); 
		query.append(",       '' CALL_PGM_TYPE" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}