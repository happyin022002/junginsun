/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchPoolListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.09.08 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchPoolListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CgmCodeMgtDB.SearchPoolListData
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchPoolListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOSearchPoolListDataRSQL").append("\n"); 
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
		query.append("SELECT CHSS_POOL_CD AS CODE1," ).append("\n"); 
		query.append("CHSS_POOL_NM AS DESC1," ).append("\n"); 
		query.append("POOL_MGMT_CO_CD AS CODE2" ).append("\n"); 
		query.append("FROM CGM_CHSS_POOL" ).append("\n"); 
		query.append("ORDER BY CHSS_POOL_CD" ).append("\n"); 

	}
}