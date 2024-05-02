/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchItmUpdDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.10.12 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchItmUpdDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * item 테이블의 update date 취득
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchItmUpdDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration ").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchItmUpdDtRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("TO_CHAR (UPD_DT, 'YYYYMMDDHH24MISS') UPD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("GEM_ITEM" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("GEN_EXPN_RQST_NO         = @[gen_expn_rqst_no]" ).append("\n"); 
		query.append("AND GEN_EXPN_RQST_SEQ    = @[gen_expn_rqst_seq]" ).append("\n"); 
		query.append("AND GEN_EXPN_TRNS_DIV_CD = 'F'" ).append("\n"); 

	}
}