/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchExpnBySubExpnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.23 최정미
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchExpnBySubExpnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일반관리비 실적 비용 집계를 위한 비용 코드 를 조회한다 ( expense , sub expense )
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchExpnBySubExpnRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rslt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT DECODE(B.GEN_EXPN_CD, '', A.GEN_EXPN_CD, B.GEN_EXPN_CD) EXPN_CD" ).append("\n"); 
		query.append(",DECODE(B.SPRT_GEN_EXPN_CD, '', A.GEN_EXPN_CD, B.SPRT_GEN_EXPN_CD) SUB_EXPN_CD" ).append("\n"); 
		query.append("FROM GEM_ACCT_MTX A, GEM_ACCT_EXPT B" ).append("\n"); 
		query.append("WHERE A.ACCT_CD     = @[acct_cd]" ).append("\n"); 
		query.append("AND A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("AND B.OFC_CD(+)   = @[rslt_ofc_cd]" ).append("\n"); 
		query.append("AND A.ACCT_CD     = B.ACCT_CD(+)" ).append("\n"); 
		query.append("AND A.GEN_EXPN_CD = B.SPRT_GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("AND B.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("AND B.SPRT_YRMON(+) <= SUBSTR(@[gl_eff_dt],1,6)" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchExpnBySubExpnRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}