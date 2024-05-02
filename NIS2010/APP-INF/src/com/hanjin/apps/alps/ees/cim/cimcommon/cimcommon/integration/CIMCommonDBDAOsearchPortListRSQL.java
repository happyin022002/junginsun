/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CIMCommonDBDAOsearchPortListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2010.02.01 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOsearchPortListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * port조회
	  * </pre>
	  */
	public CIMCommonDBDAOsearchPortListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CIMCommonDBDAOsearchPortListRSQL").append("\n"); 
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
		query.append("SELECT 	LOC_CD" ).append("\n"); 
		query.append("FROM 	MDM_LOCATION" ).append("\n"); 
		query.append("WHERE 	PORT_INLND_CD = 'Y'" ).append("\n"); 

	}
}