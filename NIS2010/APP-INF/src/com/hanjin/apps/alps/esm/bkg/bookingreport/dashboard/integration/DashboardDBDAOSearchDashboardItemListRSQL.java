/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DashboardDBDAOSearchDashboardItemListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DashboardDBDAOSearchDashboardItemListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Item List를 조회한다.
	  * </pre>
	  */
	public DashboardDBDAOSearchDashboardItemListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration").append("\n"); 
		query.append("FileName : DashboardDBDAOSearchDashboardItemListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  DBD_IRR_TP_CD" ).append("\n"); 
		query.append(", COL_NM" ).append("\n"); 
		query.append(", DP_NM" ).append("\n"); 
		query.append(", ITM_HLP_DESC" ).append("\n"); 
		query.append(", DP_SEQ" ).append("\n"); 
		query.append("FROM BKG_DBD_RPT_COL A" ).append("\n"); 
		query.append("WHERE RPT_ID='DBD1'" ).append("\n"); 
		query.append("ORDER BY A.DP_SEQ" ).append("\n"); 

	}
}