/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOSearchJooComCodeListByLadenRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOSearchJooComCodeListByLadenRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JOO_COM_PPT Laden TpSz
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOSearchJooComCodeListByLadenRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration ").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOSearchJooComCodeListByLadenRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT ATTR_CTNT2" ).append("\n"); 
		query.append("     , MIN(LINE_SEQ) OVER (PARTITION BY ATTR_CTNT2) AS LINE_SEQ" ).append("\n"); 
		query.append("  FROM JOO_COM_PPT" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND PPT_CD = 'TPSZ MAP'" ).append("\n"); 
		query.append("   AND ATTR_CTNT2 IS NOT NULL" ).append("\n"); 
		query.append(" ORDER BY LINE_SEQ" ).append("\n"); 

	}
}