/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EstimationDBDAOSearchAutoIFStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.03.14 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EstimationDBDAOSearchAutoIFStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search auto I/F status.
	  * </pre>
	  */
	public EstimationDBDAOSearchAutoIFStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration").append("\n"); 
		query.append("FileName : EstimationDBDAOSearchAutoIFStatusRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(*), 1, 'AUTO', 0, 'NON-AUTO', '') AUTO_STATUS" ).append("\n"); 
		query.append("FROM   FCM_ESTM_WK_CSM_IF" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    SUBSTR(BSE_YRMON, 1, 4) = '9999'" ).append("\n"); 
		query.append("AND    BSE_WK = '99'" ).append("\n"); 

	}
}