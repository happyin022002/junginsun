/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DOFChgTrfmanageDBDAOsearchCountryComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgTrfmanageDBDAOsearchCountryComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선택된 Customer 정보로 Effect date List Search
	  * </pre>
	  */
	public DOFChgTrfmanageDBDAOsearchCountryComboRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgTrfmanageDBDAOsearchCountryComboRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(MAX(SYS_CONNECT_BY_PATH(CNT_NM,'|')),2) CNT_NM," ).append("\n"); 
		query.append("        SUBSTR(MAX(SYS_CONNECT_BY_PATH(CNT_CD,'|')),2) CNT_CD" ).append("\n"); 
		query.append("FROM( SELECT 'GROUP' GP," ).append("\n"); 
		query.append("        ROW_NUMBER() OVER(ORDER BY  M.CNT_NM) RM," ).append("\n"); 
		query.append("        M.CNT_NM, " ).append("\n"); 
		query.append("        M.CNT_CD" ).append("\n"); 
		query.append("FROM MDM_COUNTRY M" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND M.SCONTI_CD LIKE 'E%'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" START WITH RM=1" ).append("\n"); 
		query.append(" CONNECT BY PRIOR RM = RM -1 AND PRIOR GP = GP" ).append("\n"); 
		query.append(" GROUP BY GP" ).append("\n"); 

	}
}