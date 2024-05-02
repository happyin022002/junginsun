/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOAbbrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOAbbrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ABBR Code List
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOAbbrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOAbbrRSQL").append("\n"); 
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
		query.append("SELECT JO_STL_ITM_CD AS CODE" ).append("\n"); 
		query.append("     , JO_STL_ITM_NM AS NAME" ).append("\n"); 
		query.append("  FROM JOO_STL_ITM" ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append(" #if (${super_cd1} != '')" ).append("\n"); 
		query.append("   AND JO_AUTO_CRE_FLG = @[super_cd1] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${super_cd2} != '')" ).append("\n"); 
		query.append("   AND JO_MNL_CRE_FLG = @[super_cd2] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY ORD_SEQ" ).append("\n"); 

	}
}