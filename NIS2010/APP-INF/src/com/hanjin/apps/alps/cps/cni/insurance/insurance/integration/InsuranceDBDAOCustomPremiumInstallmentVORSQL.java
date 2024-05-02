/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InsuranceDBDAOCustomPremiumInstallmentVORSQL.java
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

public class InsuranceDBDAOCustomPremiumInstallmentVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Premium Installment 저장 VO
	  * </pre>
	  */
	public InsuranceDBDAOCustomPremiumInstallmentVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.insurance.insurance.integration").append("\n"); 
		query.append("FileName : InsuranceDBDAOCustomPremiumInstallmentVORSQL").append("\n"); 
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
		query.append(",	'' INSUR_PRM_TP_CD" ).append("\n"); 
		query.append(",	'' INST_SEQ       " ).append("\n"); 
		query.append(",	'' INST_LOCL_AMT  " ).append("\n"); 
		query.append(",	'' INST_CURR_CD   " ).append("\n"); 
		query.append(",	'' INST_XCH_RT    " ).append("\n"); 
		query.append(",	'' INST_USD_AMT   " ).append("\n"); 
		query.append(",	'' INST_DUE_DT    " ).append("\n"); 
		query.append(",	'' INST_PAY_DT    " ).append("\n"); 
		query.append(",   '' CRE_USR_ID     " ).append("\n"); 
		query.append(",   '' UPD_USR_ID     " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}