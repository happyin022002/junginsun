/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatementCommonDBDAOSearchOfficeComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOSearchOfficeComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Combo Search
	  * </pre>
	  */
	public StatementCommonDBDAOSearchOfficeComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchOfficeComboListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT AR_OFC_CD AS OFC_CD        " ).append("\n"); 
		query.append("      ,AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE AP_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("OR AR_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY AR_OFC_CD" ).append("\n"); 

	}
}