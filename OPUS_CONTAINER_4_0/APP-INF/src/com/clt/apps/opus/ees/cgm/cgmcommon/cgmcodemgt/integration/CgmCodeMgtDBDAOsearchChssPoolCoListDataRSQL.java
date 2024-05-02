/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CgmCodeMgtDBDAOsearchChssPoolCoListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOsearchChssPoolCoListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CgmCodeMgtDBDAOsearchChssPoolCoListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration ").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOsearchChssPoolCoListDataRSQL").append("\n"); 
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
		query.append("SELECT A.CHSS_POOL_CD," ).append("\n"); 
		query.append("       A.CHSS_POOL_NM," ).append("\n"); 
		query.append("       A.POOL_MGMT_CO_CD," ).append("\n"); 
		query.append("       A.POOL_MGMT_CO_NM," ).append("\n"); 
		query.append("       A.CRE_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("       A.UPD_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("  FROM CGM_CHSS_POOL A" ).append("\n"); 

	}
}