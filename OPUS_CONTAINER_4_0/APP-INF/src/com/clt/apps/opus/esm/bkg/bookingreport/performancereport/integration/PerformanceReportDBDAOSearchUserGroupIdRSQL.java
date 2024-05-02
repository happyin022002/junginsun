/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchUserGroupIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.01 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchUserGroupIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchUserGroupIdRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchUserGroupIdRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchUserGroupIdRSQL").append("\n"); 
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
		query.append("USR_ID," ).append("\n"); 
		query.append("DPCS_WRK_GRP_CD," ).append("\n"); 
		query.append("DECODE(DPCS_WRK_GRP_CD, 'S', 'FO'," ).append("\n"); 
		query.append("'I', 'IP'," ).append("\n"); 
		query.append("'R', 'RT'," ).append("\n"); 
		query.append("'A', 'AD'," ).append("\n"); 
		query.append("'U', 'SU', DPCS_WRK_GRP_CD)  DPCS_WRK_GRP_CD_2 ," ).append("\n"); 
		query.append("DPCS_WRK_PRT_CD," ).append("\n"); 
		query.append("DPCS_WRK_SVR_CD" ).append("\n"); 
		query.append("FROM BKG_DPCS_USR_GRP" ).append("\n"); 
		query.append("WHERE USR_ID = @[usr_id]" ).append("\n"); 

	}
}