/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOJooCodeParamVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.04.29 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOJooCodeParamVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JooCodeParamVO생성용 query
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOJooCodeParamVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOJooCodeParamVORSQL").append("\n"); 
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
		query.append("'' AS CODE," ).append("\n"); 
		query.append("'' AS NAME," ).append("\n"); 
		query.append("'' AS SUPER_CD1," ).append("\n"); 
		query.append("'' AS SUPER_CD2," ).append("\n"); 
		query.append("'' AS SORT_KEY," ).append("\n"); 
		query.append("'' AS OFC_CD," ).append("\n"); 
		query.append("'' AS JO_CRR_AUTH_CD," ).append("\n"); 
		query.append("'' AS ACCT_YRMON," ).append("\n"); 
		query.append("'' AS JO_CRR_CD," ).append("\n"); 
		query.append("'' AS OFC_CD," ).append("\n"); 
		query.append("'' AS AUTH_DELCHECK_YN" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}