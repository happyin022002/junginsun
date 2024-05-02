/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UncollectedCargoDBDAOSearchUncollectedGlMonXchRtListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UncollectedCargoDBDAOSearchUncollectedGlMonXchRtListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 년월 / 통화코드별 환율조회 
	  * </pre>
	  */
	public UncollectedCargoDBDAOSearchUncollectedGlMonXchRtListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_xch_rt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAOSearchUncollectedGlMonXchRtListRSQL").append("\n"); 
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
		query.append("SELECT GL.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("        , GL.CURR_CD" ).append("\n"); 
		query.append("        , MDM.CNT_CD" ).append("\n"); 
		query.append("        , GL.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("        , GL.LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT GL" ).append("\n"); 
		query.append("    , MDM_CURRENCY MDM" ).append("\n"); 
		query.append("WHERE GL.ACCT_XCH_RT_YRMON = @[acct_xch_rt_yrmon]" ).append("\n"); 
		query.append("AND GL.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("AND GL.CURR_CD = MDM.CURR_CD" ).append("\n"); 
		query.append("ORDER BY GL.CURR_CD" ).append("\n"); 

	}
}