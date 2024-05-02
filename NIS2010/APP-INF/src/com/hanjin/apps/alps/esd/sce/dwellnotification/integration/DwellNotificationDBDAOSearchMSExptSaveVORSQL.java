/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DwellNotificationDBDAOSearchMSExptSaveVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOSearchMSExptSaveVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Microsoft (TMC) Dwell Reason Contents 조회된 항목을 저장하기 위한 VO
	  * </pre>
	  */
	public DwellNotificationDBDAOSearchMSExptSaveVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOSearchMSExptSaveVORSQL").append("\n"); 
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
		query.append("'' AS bkg_no," ).append("\n"); 
		query.append("'' AS cntr_no," ).append("\n"); 
		query.append("'' AS vvd," ).append("\n"); 
		query.append("'' AS estm_oc," ).append("\n"); 
		query.append("'' AS estm_id," ).append("\n"); 
		query.append("'' AS estm_tt," ).append("\n"); 
		query.append("'' AS act_oc," ).append("\n"); 
		query.append("'' AS act_id," ).append("\n"); 
		query.append("'' AS act_tt," ).append("\n"); 
		query.append("'' AS diff," ).append("\n"); 
		query.append("'' AS ms_dwll_rsn_cd," ).append("\n"); 
		query.append("'' AS ms_dwll_rmk," ).append("\n"); 
		query.append("'' AS cre_usr_id," ).append("\n"); 
		query.append("'' AS cre_dt," ).append("\n"); 
		query.append("'' AS upd_usr_id," ).append("\n"); 
		query.append("'' AS upd_dt" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}