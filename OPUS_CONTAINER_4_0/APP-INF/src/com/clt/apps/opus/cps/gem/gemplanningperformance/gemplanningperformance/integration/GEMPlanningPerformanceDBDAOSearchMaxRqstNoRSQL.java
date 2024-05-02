/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchMaxRqstNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.09.24 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchMaxRqstNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 최대값 취득
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchMaxRqstNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_rqst_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchMaxRqstNoRSQL").append("\n"); 
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
		query.append("SELECT MAX (GEN_EXPN_RQST_NO) GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("FROM   GEM_REQUEST" ).append("\n"); 
		query.append("WHERE  GEN_EXPN_RQST_NO LIKE GEN_EXPN_RQST_TP_CD || RQST_OFC_CD || TO_CHAR (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[rqst_ofc_cd]), 'YYYYMMDD') || '%'" ).append("\n"); 
		query.append("AND GEN_EXPN_RQST_TP_CD = @[gen_expn_rqst_tp_cd]" ).append("\n"); 
		query.append("AND RQST_OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 

	}
}