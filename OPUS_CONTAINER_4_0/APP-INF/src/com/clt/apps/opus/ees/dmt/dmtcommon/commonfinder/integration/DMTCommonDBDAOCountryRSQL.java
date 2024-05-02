/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonDBDAOCountryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.25 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungHoon, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOCountryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Country 정보를 조회하기 위한 쿼리
	  * </pre>
	  */
	public DMTCommonDBDAOCountryRSQL(){
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
		query.append("SELECT 	CNT_CD, CNT_NM" ).append("\n"); 
		query.append("FROM	MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE	DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY CNT_CD ASC" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.dmtcommonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOCountryRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}