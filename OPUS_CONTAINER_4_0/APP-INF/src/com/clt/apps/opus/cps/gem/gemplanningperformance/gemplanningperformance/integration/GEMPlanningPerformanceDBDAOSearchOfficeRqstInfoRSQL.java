/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchOfficeRqstInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.05.20 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class GEMPlanningPerformanceDBDAOSearchOfficeRqstInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 로그인 조직(Office)이 GEM 시스템 사용시 권한 조회
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchOfficeRqstInfoRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_xch_rt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT A.RQST_AUTH_FLG || A.RHQ_AUTH_FLG || A.TIC_AUTH_FLG || A.CMIT_AUTH_FLG AUTH_FLG" ).append("\n"); 
		query.append(",A.RQST_UT_VAL" ).append("\n"); 
		query.append(",A.LOCL_CURR_CD" ).append("\n"); 
		query.append(",B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("FROM   GEM_OFFICE A, GEM_XCH_RT B" ).append("\n"); 
		query.append("WHERE  A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    A.LOCL_CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("AND    B.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("AND    B.ACCT_XCH_RT_YRMON = @[acct_xch_rt_yrmon] || '00'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchOfficeRqstInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}