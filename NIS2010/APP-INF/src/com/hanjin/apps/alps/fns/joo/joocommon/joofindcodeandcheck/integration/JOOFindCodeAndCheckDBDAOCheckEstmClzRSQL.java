/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOCheckEstmClzRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.03.08 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOCheckEstmClzRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 시행월의 마감여부 check한다.
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOCheckEstmClzRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOCheckEstmClzRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       NVL(A.ESTM_CLZ_FLG,'N') AS CODE" ).append("\n"); 
		query.append("      ,TO_CHAR(A.ESTM_CLZ_DT,'YYYYMMDD') AS NAME" ).append("\n"); 
		query.append("FROM   JOO_ESTM_CLZ A" ).append("\n"); 
		query.append("WHERE  A.ESTM_CLZ_YR  = SUBSTR(REPLACE(@[super_cd1],'-',''),1,4)" ).append("\n"); 
		query.append("AND    A.ESTM_CLZ_MON = SUBSTR(REPLACE(@[super_cd1],'-',''),5,2)" ).append("\n"); 

	}
}