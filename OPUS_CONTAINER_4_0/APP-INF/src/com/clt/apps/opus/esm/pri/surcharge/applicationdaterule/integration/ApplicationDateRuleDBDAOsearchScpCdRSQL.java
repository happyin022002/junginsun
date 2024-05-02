/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ApplicationDateRuleDBDAOsearchScpCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.26
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.04.26 조정민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApplicationDateRuleDBDAOsearchScpCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Scope 정보를 콤보박스로 조회한다.
	  * </pre>
	  */
	public ApplicationDateRuleDBDAOsearchScpCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.integration").append("\n"); 
		query.append("FileName : ApplicationDateRuleDBDAOsearchScpCdRSQL").append("\n"); 
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
		query.append("SELECT distinct SVC_SCP_CD FROM MDM_SVC_SCP" ).append("\n"); 

	}
}