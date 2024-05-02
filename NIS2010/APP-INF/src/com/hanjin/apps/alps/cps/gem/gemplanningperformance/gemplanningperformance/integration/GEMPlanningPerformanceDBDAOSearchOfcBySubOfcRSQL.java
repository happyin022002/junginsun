/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchOfcBySubOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.24 최정미
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

public class GEMPlanningPerformanceDBDAOSearchOfcBySubOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일반관리비 실적 비용 집계를 위한 조직 코드 를 조회한다. ( office , sub office )
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchOfcBySubOfcRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rslt_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT DECODE(B.EXPN_SMRY_OFC_CD,'',A.OFC_CD,B.EXPN_SMRY_OFC_CD) OFC_CD" ).append("\n"); 
		query.append(",A.LOCL_CURR_CD" ).append("\n"); 
		query.append(",A.OFC_CD SUB_OFC_CD" ).append("\n"); 
		query.append(",DECODE(A.OFC_CO_DIV_CD,'S','O',A.OFC_CO_DIV_CD) OFC_CO_DIV_CD" ).append("\n"); 
		query.append("FROM   GEM_OFFICE A , GEM_OFFICE B" ).append("\n"); 
		query.append("WHERE  A.CTR_CD = @[rslt_ctr_cd]" ).append("\n"); 
		query.append("AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    A.OFC_CD   = B.OFC_CD(+)" ).append("\n"); 
		query.append("AND    B.EXPN_SMRY_YRMON(+) <= SUBSTR(@[gl_eff_dt],1,6)" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchOfcBySubOfcRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}