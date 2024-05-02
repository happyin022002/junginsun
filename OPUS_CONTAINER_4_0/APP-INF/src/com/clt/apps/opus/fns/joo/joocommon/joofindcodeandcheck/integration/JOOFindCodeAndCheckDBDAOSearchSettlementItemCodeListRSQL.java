/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOSearchSettlementItemCodeListRSQL.java
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

public class JOOFindCodeAndCheckDBDAOSearchSettlementItemCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOSearchSettlementItemCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sortkey",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOSearchSettlementItemCodeListRSQL").append("\n"); 
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
		query.append("SELECT A.JO_STL_ITM_CD CODE," ).append("\n"); 
		query.append("       A.JO_STL_ITM_NM NAME " ).append("\n"); 
		query.append("  FROM JOO_STL_ITM A " ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${code} != '') " ).append("\n"); 
		query.append("   AND A.JO_STL_ITM_CD = @[code]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sortkey} != '') " ).append("\n"); 
		query.append("   ORDER BY @[sortkey]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY ORD_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}