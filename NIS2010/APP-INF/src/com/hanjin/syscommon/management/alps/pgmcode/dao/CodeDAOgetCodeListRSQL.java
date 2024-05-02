/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CodeDAOgetCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.pgmcode.dao ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeDAOgetCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getCodeList
	  * </pre>
	  */
	public CodeDAOgetCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.pgmcode.dao ").append("\n"); 
		query.append("FileName : CodeDAOgetCodeListRSQL").append("\n"); 
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
		query.append("SELECT (100000 +(rownum * 10) ) as sortKey , pgm_appl_cd as code, pgm_appl_nm as name FROM com_pgm_appl" ).append("\n"); 

	}
}