/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ActualDataDBDAOSearchActualCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.15
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2013.02.15 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualDataDBDAOSearchActualCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchActualCodeList
	  * </pre>
	  */
	public ActualDataDBDAOSearchActualCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.integration").append("\n"); 
		query.append("FileName : ActualDataDBDAOSearchActualCodeListRSQL").append("\n"); 
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
		query.append("SELECT 'ALL' AS ACT_CD" ).append("\n"); 
		query.append(", '' AS ACT_NM" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT ACT_CD" ).append("\n"); 
		query.append(", ACT_NM" ).append("\n"); 
		query.append("FROM MDM_ACTIVITY" ).append("\n"); 
		query.append("WHERE ACT_TP_CD = 'T'" ).append("\n"); 
		query.append("ORDER BY ACT_CD" ).append("\n"); 

	}
}