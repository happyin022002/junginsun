/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InsuranceDBDAOCustomPremiumVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2010.01.13 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.insurance.insurance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InsuranceDBDAOCustomPremiumVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Premium 저장 VO
	  * </pre>
	  */
	public InsuranceDBDAOCustomPremiumVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.insurance.insurance.integration").append("\n"); 
		query.append("FileName : InsuranceDBDAOCustomPremiumVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	'' INSUR_TP_CD    " ).append("\n"); 
		query.append(",	'' INSUR_PLCY_YR  " ).append("\n"); 
		query.append(",	'' INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(",	'' INSUR_CLM_PTY_PRM_NO" ).append("\n"); 
		query.append(",	'' INSUR_PRM_TP_CD" ).append("\n"); 
		query.append(",	'' TTL_LOCL_AMT   " ).append("\n"); 
		query.append(",	'' TTL_CURR_CD    " ).append("\n"); 
		query.append(",	'' TTL_XCH_RT     " ).append("\n"); 
		query.append(",	'' TTL_USD_AMT    " ).append("\n"); 
		query.append(",	'' TTL_DUE_DT     " ).append("\n"); 
		query.append(",	'' TTL_PAY_DT     " ).append("\n"); 
		query.append(",	'' ADJ_LOCL_AMT   " ).append("\n"); 
		query.append(",	'' ADJ_CURR_CD    " ).append("\n"); 
		query.append(",	'' ADJ_XCH_RT     " ).append("\n"); 
		query.append(",	'' ADJ_USD_AMT    " ).append("\n"); 
		query.append(",	'' ADJ_DUE_DT     " ).append("\n"); 
		query.append(",	'' ADJ_PAY_DT     " ).append("\n"); 
		query.append(",	'' RFND_LOCL_AMT  " ).append("\n"); 
		query.append(",	'' RFND_CURR_CD   " ).append("\n"); 
		query.append(",	'' RFND_XCH_RT    " ).append("\n"); 
		query.append(",	'' RFND_USD_AMT   " ).append("\n"); 
		query.append(",	'' RFND_DUE_DT    " ).append("\n"); 
		query.append(",	'' RFND_PAY_DT    " ).append("\n"); 
		query.append(",	'' OTS_LOCL_AMT   " ).append("\n"); 
		query.append(",	'' OTS_CURR_CD    " ).append("\n"); 
		query.append(",	'' OTS_XCH_RT     " ).append("\n"); 
		query.append(",	'' OTS_USD_AMT    " ).append("\n"); 
		query.append(",	'' OTS_DUE_DT     " ).append("\n"); 
		query.append(",	'' OTS_PAY_DT     " ).append("\n"); 
		query.append(",	'' DIFF_RMK       " ).append("\n"); 
		query.append(",   '' CRE_USR_ID     " ).append("\n"); 
		query.append(",   '' UPD_USR_ID     " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}