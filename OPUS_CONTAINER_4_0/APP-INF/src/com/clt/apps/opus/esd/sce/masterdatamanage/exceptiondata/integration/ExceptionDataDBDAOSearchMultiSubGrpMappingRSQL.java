/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExceptionDataDBDAOSearchMultiSubGrpMappingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.26 이중환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExceptionDataDBDAOSearchMultiSubGrpMappingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select grp map
	  * </pre>
	  */
	public ExceptionDataDBDAOSearchMultiSubGrpMappingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration").append("\n"); 
		query.append("FileName : ExceptionDataDBDAOSearchMultiSubGrpMappingRSQL").append("\n"); 
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
		query.append("select '' r_to_act," ).append("\n"); 
		query.append("'' r_fm_act," ).append("\n"); 
		query.append("'' r_subseq_grp," ).append("\n"); 
		query.append("'' r_noti_prty," ).append("\n"); 
		query.append("'' usr_id," ).append("\n"); 
		query.append("'' r_act," ).append("\n"); 
		query.append("'' cop_expt_subsc_cs_seq," ).append("\n"); 
		query.append("'' r_expt_tp," ).append("\n"); 
		query.append("'' r_ibflag" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}