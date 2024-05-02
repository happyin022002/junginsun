/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TrsCommonDBDAOAutoFileNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.trscommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsCommonDBDAOAutoFileNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TrsCommonDBDAOAutoFileNoRSQL
	  * </pre>
	  */
	public TrsCommonDBDAOAutoFileNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.common.trscommon.integration").append("\n"); 
		query.append("FileName : TrsCommonDBDAOAutoFileNoRSQL").append("\n"); 
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
		query.append("SELECT    'TRS'" ).append("\n"); 
		query.append("       || TO_CHAR (" ).append("\n"); 
		query.append("             LPAD (" ).append("\n"); 
		query.append("                MAX (TO_NUMBER (SUBSTR (NVL (ATCH_FILE_LNK_ID, 0), 4))) + 1," ).append("\n"); 
		query.append("                7," ).append("\n"); 
		query.append("                '0'))" ).append("\n"); 
		query.append("          AS ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("  FROM TRS_ATCH_FILE" ).append("\n"); 
		query.append(" WHERE ATCH_FILE_LNK_ID LIKE 'TRS' || '%'" ).append("\n"); 

	}
}