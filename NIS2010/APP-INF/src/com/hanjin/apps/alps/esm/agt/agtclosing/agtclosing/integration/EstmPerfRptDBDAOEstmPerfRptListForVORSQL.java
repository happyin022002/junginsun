/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EstmPerfRptDBDAOEstmPerfRptListForVORSQL.java
*@FileTitle : Estimated Performanace Report by Office & Account
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.18
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2010.11.18 이정수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EstmPerfRptDBDAOEstmPerfRptListForVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EstmPerfRptListVO 생성
	  * </pre>
	  */
	public EstmPerfRptDBDAOEstmPerfRptListForVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.integration").append("\n"); 
		query.append("FileName : EstmPerfRptDBDAOEstmPerfRptListForVORSQL").append("\n"); 
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
		query.append("/* EstmPerfRptListVO 생성 쿼리*/			" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" ''  search_dt_fr" ).append("\n"); 
		query.append(", '' search_dt_to" ).append("\n"); 
		query.append(", '' s_r_vvd" ).append("\n"); 
		query.append(", '' s_ia_flg" ).append("\n"); 
		query.append(", '' s_ie_flg" ).append("\n"); 
		query.append(", '' s_im_flg" ).append("\n"); 
		query.append(", '' s_oo_flg" ).append("\n"); 
		query.append(", '' s_xx_flg" ).append("\n"); 
		query.append(", '' rev_yrmon_cd" ).append("\n"); 
		query.append(", '' rev_vvd_cd" ).append("\n"); 
		query.append(", '' ioc_cd" ).append("\n"); 
		query.append(", '' rev_lane_cd" ).append("\n"); 
		query.append(", '' vvd_tp_cd" ).append("\n"); 
		query.append(", '' estm_ttl" ).append("\n"); 
		query.append(", '' act_ttl" ).append("\n"); 
		query.append(", '' accl_ttl" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}