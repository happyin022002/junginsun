/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTClosingDBDAOEstmPerfRptListVORSQL.java
*@FileTitle : Estimated Performanace Report by Office & Account
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.18
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2010.11.18 이정수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTClosingDBDAOEstmPerfRptListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EstmPerfRptListVO 생성
	  * </pre>
	  */
	public AGTClosingDBDAOEstmPerfRptListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.integration").append("\n"); 
		query.append("FileName : AGTClosingDBDAOEstmPerfRptListVORSQL").append("\n"); 
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
		query.append("SELECT rev_yrmon_cd, rev_vvd_cd, ioc_cd, rev_lane_cd, vvd_tp_cd, estm_ttl, act_ttl, accl_ttl" ).append("\n"); 
		query.append("  from ( -- EXCEL('삭제확인(SELCDA)')에서 추출" ).append("\n"); 
		query.append("    SELECT '201001' rev_yrmon_cd, 'AEAD0066EA' rev_vvd_cd, 'IA' ioc_cd, 'IMUAE' rev_lane_cd, 'RV' vvd_tp_cd, '3,514.21' estm_ttl, '3,535.21' act_ttl, -21.00 accl_ttl from dual union all" ).append("\n"); 
		query.append("    SELECT '201001' rev_yrmon_cd, 'AEAD0066EA' rev_vvd_cd, 'OO' ioc_cd, 'IMUAE' rev_lane_cd, 'RV' vvd_tp_cd, '3,514.21' estm_ttl, '6,429.13' act_ttl, 2.76 accl_ttl from dual union all" ).append("\n"); 
		query.append("    SELECT '201002' rev_yrmon_cd, 'AEDE0069EA' rev_vvd_cd, 'OO' ioc_cd, 'IMUAE' rev_lane_cd, 'RV' vvd_tp_cd, '5,261.33' estm_ttl, '5,261.33' act_ttl, 0.00 accl_ttl from dual union all" ).append("\n"); 
		query.append("    SELECT '201002' rev_yrmon_cd, 'AEFO0063EA' rev_vvd_cd, 'IA' ioc_cd, 'IMUAE' rev_lane_cd, 'RV' vvd_tp_cd, '335.71' estm_ttl, '335.71' act_ttl, 0.00 accl_ttl from dual" ).append("\n"); 
		query.append("       ) ocp" ).append("\n"); 
		query.append(" ORDER BY 1" ).append("\n"); 

	}
}