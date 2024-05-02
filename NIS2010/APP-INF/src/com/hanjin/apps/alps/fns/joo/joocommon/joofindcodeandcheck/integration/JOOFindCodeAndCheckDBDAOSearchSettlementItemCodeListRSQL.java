/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOSearchSettlementItemCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.08.13 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
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
		query.append("Path : com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration ").append("\n"); 
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
		query.append("A.JO_STL_ITM_NM NAME" ).append("\n"); 
		query.append("FROM JOO_STL_ITM A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${code} != '')" ).append("\n"); 
		query.append("AND A.JO_STL_ITM_CD = @[code]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sortkey} != '')" ).append("\n"); 
		query.append("ORDER BY @[sortkey]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY CASE WHEN A.JO_STL_ITM_CD = 'S/H'  THEN 1" ).append("\n"); 
		query.append("WHEN A.JO_STL_ITM_CD = 'OUS'  THEN 2" ).append("\n"); 
		query.append("WHEN A.JO_STL_ITM_CD = 'R/F'  THEN 3" ).append("\n"); 
		query.append("WHEN A.JO_STL_ITM_CD = 'OTH'  THEN 4" ).append("\n"); 
		query.append("WHEN A.JO_STL_ITM_CD = 'W/R'  THEN 5" ).append("\n"); 
		query.append("WHEN A.JO_STL_ITM_CD = 'P/B'  THEN 6 END" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}