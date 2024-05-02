/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExceptionDataDBDAOSearchToleranceMultiInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.20 이중환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExceptionDataDBDAOSearchToleranceMultiInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select multi info
	  * </pre>
	  */
	public ExceptionDataDBDAOSearchToleranceMultiInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration ").append("\n"); 
		query.append("FileName : ExceptionDataDBDAOSearchToleranceMultiInfoRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' r_ibflag," ).append("\n"); 
		query.append("'' r_expt_tp," ).append("\n"); 
		query.append("'' r_expt_tp_dtl," ).append("\n"); 
		query.append("'' r_fm_act," ).append("\n"); 
		query.append("'' r_fm_act_nm," ).append("\n"); 
		query.append("'' r_to_act," ).append("\n"); 
		query.append("'' r_to_act_nm," ).append("\n"); 
		query.append("'' r_loc_cd," ).append("\n"); 
		query.append("'' r_nod_cd," ).append("\n"); 
		query.append("'' r_foml_tm_dys," ).append("\n"); 
		query.append("'' r_foml_tm_hrs," ).append("\n"); 
		query.append("'' r_foml_tm_min," ).append("\n"); 
		query.append("'' r_usr_id," ).append("\n"); 
		query.append("'' r_upd_dt," ).append("\n"); 
		query.append("'' r_act_flg" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}