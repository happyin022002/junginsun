/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DashboardDBDAOSearchDashboardReportFormRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.14 
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

public class DashboardDBDAOSearchDashboardReportFormRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dashboard Report Form 데이터를 조회한다
	  * </pre>
	  */
	public DashboardDBDAOSearchDashboardReportFormRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration").append("\n"); 
		query.append("FileName : DashboardDBDAOSearchDashboardReportFormRSQL").append("\n"); 
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
		query.append("    RPT_FOM_NO" ).append("\n"); 
		query.append("    , RPT_FOM_NM" ).append("\n"); 
		query.append("    , RPT_FOM_DESC " ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID " ).append("\n"); 
		query.append("FROM BKG_DBD_RPT_FOM" ).append("\n"); 
		query.append("WHERE CRE_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("ORDER BY CRE_DT" ).append("\n"); 

	}
}