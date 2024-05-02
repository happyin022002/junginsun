/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCommonDBDAOCoverageVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOCoverageVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Continent, Country, Region, State, Location 정보를 저장하고 사용하기 위한 VO 객체
	  * </pre>
	  */
	public DMTCommonDBDAOCoverageVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOCoverageVORSQL").append("\n"); 
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
		query.append("SELECT	'' conti_cd," ).append("\n"); 
		query.append("'' conti_nm," ).append("\n"); 
		query.append("'' svr_id," ).append("\n"); 
		query.append("'' cnt_cd," ).append("\n"); 
		query.append("'' cnt_nm," ).append("\n"); 
		query.append("'' rgn_cd," ).append("\n"); 
		query.append("'' rgn_nm," ).append("\n"); 
		query.append("'' ste_cd," ).append("\n"); 
		query.append("'' ste_nm," ).append("\n"); 
		query.append("'' loc_cd," ).append("\n"); 
		query.append("'' loc_nm," ).append("\n"); 
		query.append("'' yd_cd," ).append("\n"); 
		query.append("'' yd_nm," ).append("\n"); 
		query.append("'' tp," ).append("\n"); 
		query.append("'' yd_cd1," ).append("\n"); 
		query.append("'' yd_cd2," ).append("\n"); 
		query.append("'' rt_curr_cd," ).append("\n"); 
		query.append("'' use_rt_curr," ).append("\n"); 
		query.append("'' code," ).append("\n"); 
		query.append("'' name" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	dual" ).append("\n"); 

	}
}