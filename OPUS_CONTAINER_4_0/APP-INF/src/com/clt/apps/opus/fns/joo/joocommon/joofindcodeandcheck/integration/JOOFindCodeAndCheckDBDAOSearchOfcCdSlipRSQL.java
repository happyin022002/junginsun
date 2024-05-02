/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOSearchOfcCdSlipRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.14 장강철
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

public class JOOFindCodeAndCheckDBDAOSearchOfcCdSlipRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOSearchOfcCdSlipRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOSearchOfcCdSlipRSQL").append("\n"); 
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
		query.append("SELECT     A.SLP_OFC_CD code, B.OFC_ENG_NM NAME" ).append("\n"); 
		query.append("FROM      JOO_SLIP A, MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE     A.SLP_OFC_CD  = B.OFC_CD" ).append("\n"); 
		query.append("GROUP BY A.SLP_OFC_CD,B.OFC_ENG_NM" ).append("\n"); 
		query.append("ORDER BY  A.SLP_OFC_CD" ).append("\n"); 

	}
}