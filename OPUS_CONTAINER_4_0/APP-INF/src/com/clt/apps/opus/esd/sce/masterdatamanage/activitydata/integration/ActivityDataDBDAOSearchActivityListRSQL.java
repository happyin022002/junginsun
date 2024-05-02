/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActivityDataDBDAOSearchActivityListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.10.06 오현경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Oh hyun-kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActivityDataDBDAOSearchActivityListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchActivityList
	  * </pre>
	  */
	public ActivityDataDBDAOSearchActivityListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.integration").append("\n"); 
		query.append("FileName : ActivityDataDBDAOSearchActivityListRSQL").append("\n"); 
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
		query.append("SELECT  commcode_pkg.get_comdtl_name_fnc('CD00140', act_tp_cd) act_tp_nm" ).append("\n"); 
		query.append(", act_cd" ).append("\n"); 
		query.append(", act_nm" ).append("\n"); 
		query.append(", cop_skd_lgc_no" ).append("\n"); 
		query.append(", act_sts_mapg_cd" ).append("\n"); 
		query.append(", act_stnd_edi_sts_cd" ).append("\n"); 
		query.append(", cust_vis_flg" ).append("\n"); 
		query.append("--, vndr_ev_tol_hrs" ).append("\n"); 
		query.append("--, vndr_ev_svc_cate_cd" ).append("\n"); 
		query.append(", bzc_vis_flg" ).append("\n"); 
		query.append(", act_flg" ).append("\n"); 
		query.append("FROM  mdm_activity" ).append("\n"); 
		query.append("ORDER  BY act_tp_cd DESC" ).append("\n"); 

	}
}