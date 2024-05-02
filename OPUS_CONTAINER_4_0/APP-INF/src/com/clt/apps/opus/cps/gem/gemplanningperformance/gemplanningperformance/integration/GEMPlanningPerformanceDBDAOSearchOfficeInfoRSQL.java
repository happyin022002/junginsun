/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchOfficeInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.06.26 진윤오
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

public class GEMPlanningPerformanceDBDAOSearchOfficeInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 오피스 정보 취득
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchOfficeInfoRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmit_auth_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_auth_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tic_auth_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_auth_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append(",OFC_ENG_NM" ).append("\n"); 
		query.append(",OFC_KRN_NM" ).append("\n"); 
		query.append(",CTR_CD" ).append("\n"); 
		query.append(",AP_CTRL_OFC_CD" ).append("\n"); 
		query.append(",LOCL_CURR_CD" ).append("\n"); 
		query.append(",RQST_UT_VAL" ).append("\n"); 
		query.append(",GEN_EXPN_OFC_LVL" ).append("\n"); 
		query.append(",PRNT_OFC_CD" ).append("\n"); 
		query.append(",OFC_CO_DIV_CD" ).append("\n"); 
		query.append(",RGN_OFC_FLG" ).append("\n"); 
		query.append(",SLS_OFC_FLG" ).append("\n"); 
		query.append(",RQST_AUTH_FLG" ).append("\n"); 
		query.append(",RHQ_AUTH_FLG" ).append("\n"); 
		query.append(",TIC_AUTH_FLG" ).append("\n"); 
		query.append(",CMIT_AUTH_FLG" ).append("\n"); 
		query.append(",EXPN_SMRY_OFC_CD" ).append("\n"); 
		query.append(",EXPN_SMRY_YRMON" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("FROM   GEM_OFFICE" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND  OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rqst_auth_flg} != '')" ).append("\n"); 
		query.append("AND	RQST_AUTH_FLG = @[rqst_auth_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq_auth_flg} != '')" ).append("\n"); 
		query.append("AND	RHQ_AUTH_FLG = @[rhq_auth_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tic_auth_flg} != '')" ).append("\n"); 
		query.append("AND	TIC_AUTH_FLG = @[tic_auth_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmit_auth_flg} != '')" ).append("\n"); 
		query.append("AND	CMIT_AUTH_FLG = @[cmit_auth_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '')" ).append("\n"); 
		query.append("AND	DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemplanningperformance.gemplanningperformance.integration ").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchOfficeInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}