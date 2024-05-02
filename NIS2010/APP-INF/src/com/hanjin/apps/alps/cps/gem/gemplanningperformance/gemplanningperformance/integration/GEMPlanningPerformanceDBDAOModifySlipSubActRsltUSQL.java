/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOModifySlipSubActRsltUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOModifySlipSubActRsltUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 현지 법인 월별 실적 수정
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOModifySlipSubActRsltUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("perf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rslt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOModifySlipSubActRsltUSQL").append("\n"); 
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
		query.append("UPDATE GEM_SUBS_PERF A" ).append("\n"); 
		query.append("   SET A.PERF_AMT    = A.PERF_AMT + @[perf_amt]/(SELECT B.RQST_UT_VAL FROM GEM_OFFICE B WHERE B.OFC_CD = A.OFC_CD AND B.DELT_FLG = 'N' AND ROWNUM = 1)," ).append("\n"); 
		query.append("       A.UPD_USR_ID  = @[upd_usr_id]," ).append("\n"); 
		query.append("       A.UPD_DT      = SYSDATE" ).append("\n"); 
		query.append(" WHERE A.RSLT_YRMON  = @[rslt_yrmon]" ).append("\n"); 
		query.append("   AND A.OFC_CD      = @[ofc_cd]" ).append("\n"); 
		query.append("   AND A.GEN_EXPN_CD = @[gen_expn_cd]" ).append("\n"); 

	}
}