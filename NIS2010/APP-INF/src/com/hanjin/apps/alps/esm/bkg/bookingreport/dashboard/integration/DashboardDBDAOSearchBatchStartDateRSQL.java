/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DashboardDBDAOSearchBatchStartDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.07
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.07 
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

public class DashboardDBDAOSearchBatchStartDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 현재 유효한 batch data의 시작 시간을 조회한다.
	  * </pre>
	  */
	public DashboardDBDAOSearchBatchStartDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration").append("\n"); 
		query.append("FileName : DashboardDBDAOSearchBatchStartDateRSQL").append("\n"); 
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
		query.append("'Batch Executed Date : '||TO_CHAR(BAT_ST_DT, 'YYYY-MM-DD HH24:MI:SS') BAT_ST_DT" ).append("\n"); 
		query.append(", DBD_CRE_DT" ).append("\n"); 
		query.append(", DBD_CRE_SEQ" ).append("\n"); 
		query.append("FROM BKG_DBD_BAT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BAT_STS_CD = 'S'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}