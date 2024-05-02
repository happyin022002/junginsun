/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonDBDAODualTypeCountryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.14 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungHoon, Lee
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class DMTCommonDBDAODualTypeCountryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dual 인 Country 정보 조회를 위한 쿼리
	  * </pre>
	  */
	public DMTCommonDBDAODualTypeCountryRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT	DISTINCT a.cnt_cd, b.cnt_nm" ).append("\n"); 
		query.append("FROM	dmt_calc_tp a, mdm_country b" ).append("\n"); 
		query.append("WHERE	a.dmdt_calc_tp_cd = 'D'" ).append("\n"); 
		query.append("AND a.cnt_cd = b.cnt_cd" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.dmt.dmtcommon.dmtcommonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAODualTypeCountryRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}