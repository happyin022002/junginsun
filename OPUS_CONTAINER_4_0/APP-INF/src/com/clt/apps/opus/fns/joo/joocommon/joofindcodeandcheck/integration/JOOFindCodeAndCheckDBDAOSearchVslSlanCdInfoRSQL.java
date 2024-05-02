/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOSearchVslSlanCdInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.10 
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

public class JOOFindCodeAndCheckDBDAOSearchVslSlanCdInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOSearchVslSlanCdInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration ").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOSearchVslSlanCdInfoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT B.VSL_SLAN_CD CODE" ).append("\n"); 
		query.append("     , B.VSL_SLAN_NM NAME" ).append("\n"); 
		query.append("  FROM VSK_VSL_SKD A" ).append("\n"); 
		query.append("     , MDM_VSL_SVC_LANE B" ).append("\n"); 
		query.append(" WHERE A.VSL_CD = SUBSTR(@[code],1,4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR(@[code],5,8)" ).append("\n"); 
		query.append("   AND A.VSL_SLAN_CD = B.VSL_SLAN_CD" ).append("\n"); 

	}
}