/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : COPSearchDBDAOTempRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.08
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.12.08 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOTempRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBookingInfo
	  * </pre>
	  */
	public COPSearchDBDAOTempRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOTempRSQL").append("\n"); 
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
		query.append("SELECT        NULL RAIL_VNDR_NM" ).append("\n"); 
		query.append("        	, NULL BIL_EDI_SNT_DT" ).append("\n"); 
		query.append("        	, NULL BIL_EDI_SNT_DT_HMS" ).append("\n"); 
		query.append("        	, NULL MTC_EDI_RCV_RSLT_FLG" ).append("\n"); 
		query.append("        	, NULL MTC_EDI_RCV_RSLT_DT" ).append("\n"); 
		query.append("        	, NULL MTC_EDI_RCV_RSLT_DT_HMS" ).append("\n"); 
		query.append("        	, NULL CXL_RQST_RJCT_RSN" ).append("\n"); 
		query.append("        	, NULL WBL_NO" ).append("\n"); 
		query.append("  FROM dual" ).append("\n"); 

	}
}