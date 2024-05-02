/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StatementCommonDBDAOSearchApplicationComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.02 
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

public class StatementCommonDBDAOSearchApplicationComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Application Combo List
	  * </pre>
	  */
	public StatementCommonDBDAOSearchApplicationComboRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchApplicationComboRSQL").append("\n"); 
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
		query.append("SELECT  '   ' AS APPL_CD" ).append("\n"); 
		query.append("      , '   ' AS APPL_NM " ).append("\n"); 
		query.append("  FROM  DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  'SAR' AS APPL_CD" ).append("\n"); 
		query.append("      , 'SAR' AS APPL_NM" ).append("\n"); 
		query.append("  FROM  DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  'SAP' AS APPL_CD" ).append("\n"); 
		query.append("       , 'SAP' AS APPL_NM" ).append("\n"); 
		query.append("  FROM  DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  'SCO' AS APPL_CD" ).append("\n"); 
		query.append("      , 'SCO' AS APPL_NM " ).append("\n"); 
		query.append("  FROM  DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}