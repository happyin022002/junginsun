/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExceptionDataDBDAOSearchMultiExpOfcInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.11.10 이중환
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

public class ExceptionDataDBDAOSearchMultiExpOfcInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select multi info
	  * </pre>
	  */
	public ExceptionDataDBDAOSearchMultiExpOfcInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.integration ").append("\n"); 
		query.append("FileName : ExceptionDataDBDAOSearchMultiExpOfcInfoRSQL").append("\n"); 
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
		query.append("select '' f_ofc_cd," ).append("\n"); 
		query.append("'' f_mapg_ofc_cd," ).append("\n"); 
		query.append("'' f_act_flg," ).append("\n"); 
		query.append("'' f_ibflag," ).append("\n"); 
		query.append("'' f_usr_id," ).append("\n"); 
		query.append("'' f_mapg_ofc_nm," ).append("\n"); 
		query.append("'' f_loc_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}