/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusReportDBDAOBkgRptDownExcel1704RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOBkgRptDownExcel1704RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgRptDownExcel1704
	  * </pre>
	  */
	public StatusReportDBDAOBkgRptDownExcel1704RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOBkgRptDownExcel1704RSQL").append("\n"); 
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
		query.append("SELECT ''" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}