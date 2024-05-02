/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DOFChgTrfmanageDBDAOsearchCurrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2012.04.02 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgTrfmanageDBDAOsearchCurrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Curr CD 리스트 목록 조회
	  * </pre>
	  */
	public DOFChgTrfmanageDBDAOsearchCurrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgTrfmanageDBDAOsearchCurrListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("X.SCC_CD," ).append("\n"); 
		query.append("'EUR|USD'||DECODE((SELECT M.CURR_CD FROM MDM_COUNTRY M WHERE M.CNT_CD LIKE SUBSTR(X.SCC_CD,1,2)||'%' AND M.CURR_CD NOT IN ('EUR','USD')),NULL,'','','','|')||(" ).append("\n"); 
		query.append("SELECT M.CURR_CD FROM MDM_COUNTRY M WHERE M.CNT_CD LIKE SUBSTR(X.SCC_CD,1,2)||'%' AND M.CURR_CD NOT IN ('EUR','USD')) CURR_LIST_CTNT" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("NVL((SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN B.YD_CD IS NOT NULL" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END SCC_YD_CHK" ).append("\n"); 
		query.append("FROM MDM_LOCATION A, MDM_YARD B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND A.SCC_CD = X.SCC_CD" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("),'N') SCC_YD_CHK," ).append("\n"); 
		query.append("(   SELECT L.PORT_INLND_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND L.LOC_CD = X.SCC_CD ) PORT_INLND_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("#foreach(${key} IN ${arrSccCd})" ).append("\n"); 
		query.append("#if($velocityCount == $arrSccCd.size())" ).append("\n"); 
		query.append("SELECT '${key}' SCC_CD FROM DUAL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT '${key}' SCC_CD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") X" ).append("\n"); 

	}
}