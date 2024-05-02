/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOOfficeCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.06.17 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOOfficeCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Code retrieve
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOOfficeCodeRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("WKPLC_NM AS CODE," ).append("\n"); 
		query.append("WKPLC_DESC AS NAME" ).append("\n"); 
		query.append("FROM  AP_WORKPLACE" ).append("\n"); 
		query.append("ORDER  BY 1" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.common.joofindcodeandcheck.integration ").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOOfficeCodeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}