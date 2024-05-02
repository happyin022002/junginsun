/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : USARailPerformanceDBDAOSearchRailPerformanceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.usarailperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USARailPerformanceDBDAOSearchRailPerformanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRailPerformanceVO 생성 쿼리
	  * </pre>
	  */
	public USARailPerformanceDBDAOSearchRailPerformanceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.usarailperformance.integration").append("\n"); 
		query.append("FileName : USARailPerformanceDBDAOSearchRailPerformanceRSQL").append("\n"); 
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
		query.append("'' ctrl_ofc" ).append("\n"); 
		query.append(", '' frm_yard" ).append("\n"); 
		query.append(", '' current_ofc_cd" ).append("\n"); 
		query.append(", '' status" ).append("\n"); 
		query.append(", '' to_date" ).append("\n"); 
		query.append(", '' date_type" ).append("\n"); 
		query.append(", '' to_yard" ).append("\n"); 
		query.append(", '' login_usr_id" ).append("\n"); 
		query.append(", '' fm_date" ).append("\n"); 
		query.append(", '' to_node" ).append("\n"); 
		query.append(", '' pagerows" ).append("\n"); 
		query.append(", '' comp_cd" ).append("\n"); 
		query.append(", '' login_ofc_cd" ).append("\n"); 
		query.append(", '' ibflag" ).append("\n"); 
		query.append(", '' io_bound" ).append("\n"); 
		query.append(", '' frm_node" ).append("\n"); 
		query.append(", '' login_date" ).append("\n"); 
		query.append(", '' rail_road_name" ).append("\n"); 
		query.append(", '' rail_road_code" ).append("\n"); 
		query.append(", '' f_chkprd" ).append("\n"); 
		query.append(", '' f_year" ).append("\n"); 
		query.append(", '' f_fm_mon" ).append("\n"); 
		query.append(", '' f_to_mon" ).append("\n"); 
		query.append(", '' f_fm_wk" ).append("\n"); 
		query.append(", '' f_to_wk" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}