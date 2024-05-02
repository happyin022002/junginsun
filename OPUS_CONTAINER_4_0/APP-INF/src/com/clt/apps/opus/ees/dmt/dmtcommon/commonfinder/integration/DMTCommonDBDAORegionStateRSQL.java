/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCommonDBDAORegionStateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.22
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.01.22 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAORegionStateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Region and State ( 'US' & 'CA')
	  * </pre>
	  */
	public DMTCommonDBDAORegionStateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAORegionStateRSQL").append("\n"); 
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
		query.append("SELECT	CNT_CD, RGN_CD, RGN_NM" ).append("\n"); 
		query.append("FROM	MDM_REGION" ).append("\n"); 
		query.append("WHERE	CNT_CD NOT IN ('CA','US')" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	CNT_CD, STE_CD, STE_NM" ).append("\n"); 
		query.append("FROM	MDM_STATE" ).append("\n"); 
		query.append("WHERE	CNT_CD IN ('CA','US')" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY CNT_CD, RGN_CD ASC" ).append("\n"); 

	}
}