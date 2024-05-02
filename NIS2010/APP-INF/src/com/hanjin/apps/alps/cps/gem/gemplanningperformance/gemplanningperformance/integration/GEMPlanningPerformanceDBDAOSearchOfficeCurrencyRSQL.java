/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchOfficeCurrencyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.08.14 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchOfficeCurrencyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 로그인 조직(Office)의 Hierarchy 구조 조회 및 환율정보 취득
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchOfficeCurrencyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_xch_rt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration ").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchOfficeCurrencyRSQL").append("\n"); 
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
		query.append("SELECT A.L_1 LEVEL1" ).append("\n"); 
		query.append(",A.L_2 LEVEL2" ).append("\n"); 
		query.append(",A.L_3 LEVEL3" ).append("\n"); 
		query.append(",A.L_4 LEVEL4" ).append("\n"); 
		query.append(",A.RGN_OFC_FLG" ).append("\n"); 
		query.append(",B.LOCL_CURR_CD" ).append("\n"); 
		query.append(",B.RQST_UT_VAL" ).append("\n"); 
		query.append(",B.RQST_AUTH_FLG || B.RHQ_AUTH_FLG || B.TIC_AUTH_FLG || B.CMIT_AUTH_FLG AUTH_FLG" ).append("\n"); 
		query.append(",C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append(",C.LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append(",C.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("FROM   GEM_OFC_LEVEL_V A" ).append("\n"); 
		query.append(",GEM_OFFICE B" ).append("\n"); 
		query.append(",GEM_XCH_RT C" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    A.L_4 = B.OFC_CD" ).append("\n"); 
		query.append("AND    B.LOCL_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("AND    A.L_4 = @[ofc_cd]" ).append("\n"); 
		query.append("AND    C.ACCT_XCH_RT_YRMON = @[acct_xch_rt_yrmon] || '00'" ).append("\n"); 
		query.append("AND    C.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 

	}
}