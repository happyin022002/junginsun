/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchSlpAmtConversionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.30 최정미
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

public class GEMPlanningPerformanceDBDAOSearchSlpAmtConversionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 품의서의 전표금액을 조직의 Local Currency 기준으로 전환 한다.
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchSlpAmtConversionRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT TO_NUMBER(NVL(DECODE( @[slp_curr_cd], @[ofc_curr_cd], #if(${slp_amt} != '')${slp_amt} #else 0 #end, (#if(${slp_amt} != '')${slp_amt} #else 0 #end/A.USD_LOCL_XCH_RT)*B.USD_LOCL_XCH_RT),0)) code" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT A , GL_MON_XCH_RT B" ).append("\n"); 
		query.append("WHERE A.ACCT_XCH_RT_YRMON     = SUBSTR(@[gl_eff_dt],1,6)" ).append("\n"); 
		query.append("AND A.CURR_CD = @[slp_curr_cd]" ).append("\n"); 
		query.append("AND A.ACCT_XCH_RT_LVL    = '1'" ).append("\n"); 
		query.append("AND A.ACCT_XCH_RT_YRMON  = B.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("AND B.CURR_CD = @[ofc_curr_cd]" ).append("\n"); 
		query.append("AND B.ACCT_XCH_RT_LVL    = '1'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchSlpAmtConversionRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}