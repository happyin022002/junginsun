/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExceptionDataDBDAOSearchExptNotSubInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.29 이중환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExceptionDataDBDAOSearchExptNotSubInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select subinfo
	  * </pre>
	  */
	public ExceptionDataDBDAOSearchExptNotSubInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.integration ").append("\n"); 
		query.append("FileName : ExceptionDataDBDAOSearchExptNotSubInfoRSQL").append("\n"); 
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
		query.append("select '' r_ibflag," ).append("\n"); 
		query.append("'' r_subsc_grp_cd," ).append("\n"); 
		query.append("'' r_ntfd_ofc_cd," ).append("\n"); 
		query.append("'' r_global_id," ).append("\n"); 
		query.append("'' r_name," ).append("\n"); 
		query.append("'' r_email," ).append("\n"); 
		query.append("'' r_cnt_ofc," ).append("\n"); 
		query.append("'' r_usr_id," ).append("\n"); 
		query.append("'' r_upd_dt," ).append("\n"); 
		query.append("'' r_act," ).append("\n"); 
		query.append("'' cop_expt_subsc_cs_seq," ).append("\n"); 
		query.append("'' subsc_grp_ntfd_pty_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}