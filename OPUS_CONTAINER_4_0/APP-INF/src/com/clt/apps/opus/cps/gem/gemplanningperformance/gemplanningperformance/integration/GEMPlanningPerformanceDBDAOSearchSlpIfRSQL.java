/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchSlpIfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.08.06 최정미
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

public class GEMPlanningPerformanceDBDAOSearchSlpIfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GEM_SLP_IF 테이블의 정보를 조회한다.
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchSlpIfRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchSlpIfRSQL").append("\n"); 
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
		query.append("SELECT SLP_TJ_NO" ).append("\n"); 
		query.append(",SLP_SEQ_NO" ).append("\n"); 
		query.append(",GL_EFF_DT" ).append("\n"); 
		query.append(",ACCT_CD" ).append("\n"); 
		query.append(",SLP_CURR_CD" ).append("\n"); 
		query.append(",SLP_AMT" ).append("\n"); 
		query.append(",SLP_CTR_CD" ).append("\n"); 
		query.append(",SLP_DESC" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",SLP_VNDR_CD" ).append("\n"); 
		query.append("FROM   GEM_SLP_IF" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("#if(${slp_tj_no} != '')" ).append("\n"); 
		query.append("AND    SLP_TJ_NO = @[slp_tj_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${slp_seq_no} != '')" ).append("\n"); 
		query.append("AND    SLP_SEQ_NO = (SELECT SUBSTR (@[slp_seq_no] + 10000, 2, 5) FROM DUAL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${gl_eff_dt} != '')" ).append("\n"); 
		query.append("AND    GL_EFF_DT LIKE @[gl_eff_dt]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    SLP_IF_FLG = 'N'" ).append("\n"); 

	}
}