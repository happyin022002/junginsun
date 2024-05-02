/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InsuranceDBDAOCustomInsuranceVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.13 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.insurance.insurance.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InsuranceDBDAOCustomInsuranceVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insurance 저장 VO
	  * </pre>
	  */
	public InsuranceDBDAOCustomInsuranceVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.insurance.insurance.integration ").append("\n"); 
		query.append("FileName : InsuranceDBDAOCustomInsuranceVORSQL").append("\n"); 
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
		query.append("'' INSUR_TP_CD" ).append("\n"); 
		query.append(",	'' INSUR_PLCY_YR" ).append("\n"); 
		query.append(",	'' INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(",	'' INSUR_CTNT" ).append("\n"); 
		query.append(",	'' RINS_CLM_PTY_NO" ).append("\n"); 
		query.append(",	'' RINS_CTNT" ).append("\n"); 
		query.append(",	'' INS_CLM_PTY_NO" ).append("\n"); 
		query.append(",	'' INS_CTNT" ).append("\n"); 
		query.append(",	'' CINS_CLM_PTY_NO" ).append("\n"); 
		query.append(",	'' CINS_CTNT" ).append("\n"); 
		query.append(",	'' BRO_CLM_PTY_NO" ).append("\n"); 
		query.append(",	'' INT_DESC" ).append("\n"); 
		query.append(",	'' INSUR_CTRT_EFF_DT" ).append("\n"); 
		query.append(",	'' INSUR_CTRT_EXP_DT" ).append("\n"); 
		query.append(",	'' SUBJ_MAT_INS_DESC" ).append("\n"); 
		query.append(",	'' INS_CURR_CD" ).append("\n"); 
		query.append(",	'' INS_LOCL_AMT" ).append("\n"); 
		query.append(",	'' INS_XCH_RT" ).append("\n"); 
		query.append(",	'' INS_USD_AMT" ).append("\n"); 
		query.append(",	'' LMT_INS_CURR_CD" ).append("\n"); 
		query.append(",	'' LMT_INS_LOCL_AMT" ).append("\n"); 
		query.append(",	'' LMT_INS_XCH_RT" ).append("\n"); 
		query.append(",	'' LMT_INS_USD_AMT" ).append("\n"); 
		query.append(",	'' INSUR_RMK" ).append("\n"); 
		query.append(",	'' CRE_USR_ID" ).append("\n"); 
		query.append(",	'' UPD_USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}