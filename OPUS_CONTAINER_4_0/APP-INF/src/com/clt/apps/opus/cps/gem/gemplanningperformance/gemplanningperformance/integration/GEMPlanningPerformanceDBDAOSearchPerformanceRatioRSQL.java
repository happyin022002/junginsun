/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchPerformanceRatioRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.07.07 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchPerformanceRatioRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP(A/P) 로부터 기 I/F 된 전표번호를 받아, 조직별 비용예산 및 실적집계 , 예산대비실적 집행률 을 전송한다
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchPerformanceRatioRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_tj_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT SLP_TJ_NO||'|'||SLP_SEQ_NO||'|'||GEN_EXPN_CD||'|'||GEN_EXPN_FNL_LOCL_AMT||'|'||SLP_PERF_AMT||'|'||DECODE(GEN_EXPN_FNL_LOCL_AMT, 0, 0, (SLP_PERF_AMT/GEN_EXPN_FNL_LOCL_AMT) * 100) SLP_TJ_NO" ).append("\n"); 
		query.append("FROM   GEM_SLP_PERF" ).append("\n"); 
		query.append("WHERE  SLP_TJ_NO = @[slp_tj_no]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchPerformanceRatioRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}