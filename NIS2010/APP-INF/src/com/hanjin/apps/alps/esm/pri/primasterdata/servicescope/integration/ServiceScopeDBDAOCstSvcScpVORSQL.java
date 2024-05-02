/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceScopeDBDAOCstSvcScpVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.08 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceScopeDBDAOCstSvcScpVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Service Scope 조회조건 VO
	  * </pre>
	  */
	public ServiceScopeDBDAOCstSvcScpVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.integration ").append("\n"); 
		query.append("FileName : ServiceScopeDBDAOCstSvcScpVORSQL").append("\n"); 
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
		query.append("SELECT '' AS ORG_TP_CD" ).append("\n"); 
		query.append(", '' AS ORG_CD" ).append("\n"); 
		query.append(", '' AS DEST_TP_CD" ).append("\n"); 
		query.append(", '' AS DEST_CD" ).append("\n"); 
		query.append(", '' AS ORG_DEST_TP_CD" ).append("\n"); 
		query.append(", '' AS ORG_DEST_CD" ).append("\n"); 
		query.append(", '' AS SVC_SCP_CD" ).append("\n"); 
		query.append(", '' AS CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}