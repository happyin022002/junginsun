/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DailyForecastManageDBDAODummyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAODummyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * aaa
	  * </pre>
	  */
	public DailyForecastManageDBDAODummyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAODummyRSQL").append("\n"); 
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
		query.append("select '' trd_cd, " ).append("\n"); 
		query.append("       '' sub_trd_cd," ).append("\n"); 
		query.append("       '' rlane_cd, " ).append("\n"); 
		query.append("       '' sls_rep_ofc_team_cd," ).append("\n"); 
		query.append("       '' qta_aply_cd," ).append("\n"); 
		query.append("       '' bse_yr," ).append("\n"); 
		query.append("       '' bse_qtr_cd," ).append("\n"); 
		query.append("       '' vvd," ).append("\n"); 
		query.append("       '' vsl_cd, " ).append("\n"); 
		query.append("       '' skd_voy_no, " ).append("\n"); 
		query.append("       '' skd_dir_cd, " ).append("\n"); 
		query.append("       '' sls_rgn_ofc_cd, " ).append("\n"); 
		query.append("       '' sls_ofc_cd, " ).append("\n"); 
		query.append("       '' team_qta_rto, " ).append("\n"); 
		query.append("       '' cre_usr_id, " ).append("\n"); 
		query.append("       '' cre_dt, " ).append("\n"); 
		query.append("       '' upd_usr_id, " ).append("\n"); 
		query.append("       '' upd_dt" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}