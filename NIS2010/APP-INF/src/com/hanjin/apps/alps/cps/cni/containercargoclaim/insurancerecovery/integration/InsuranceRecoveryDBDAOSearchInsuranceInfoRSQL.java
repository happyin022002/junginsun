/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InsuranceRecoveryDBDAOSearchInsuranceInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2009.10.30 정행룡
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONG HAENG RYONG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InsuranceRecoveryDBDAOSearchInsuranceInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insurance 조회
	  * </pre>
	  */
	public InsuranceRecoveryDBDAOSearchInsuranceInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.integration").append("\n"); 
		query.append("FileName : InsuranceRecoveryDBDAOSearchInsuranceInfoRSQL").append("\n"); 
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
		query.append("CGO_CLM_NO" ).append("\n"); 
		query.append(",  INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(",  INSUR_REF_NO" ).append("\n"); 
		query.append(",  AGN_CLM_PTY_NO" ).append("\n"); 
		query.append(",  AGN_CRSPN_TP_CD" ).append("\n"); 
		query.append(",  AGN_CRSPN_APNT_DT" ).append("\n"); 
		query.append(",  AGN_CRSPN_REF_NO" ).append("\n"); 
		query.append(",  CRSPN_CLM_PTY_NO" ).append("\n"); 
		query.append(",  INSUR_PLCY_YR" ).append("\n"); 
		query.append(",  DDCT_USD_AMT" ).append("\n"); 
		query.append(",  INSUR_FMAL_CLM_DT" ).append("\n"); 
		query.append(",  INSUR_DMND_USD_AMT" ).append("\n"); 
		query.append(",  INSUR_DMND_CURR_CD" ).append("\n"); 
		query.append(",  INSUR_DMND_AMT" ).append("\n"); 
		query.append(",  INSUR_XCH_RT" ).append("\n"); 
		query.append(",  INSUR_RCVR_DT" ).append("\n"); 
		query.append(",  INSUR_RCVR_USD_AMT" ).append("\n"); 
		query.append(",  INSUR_RCVR_LOCL_CURR_CD" ).append("\n"); 
		query.append(",  INSUR_RCVR_AMT" ).append("\n"); 
		query.append(",  INSUR_RCVR_XCH_RT" ).append("\n"); 
		query.append(",  INSUR_RMK" ).append("\n"); 
		query.append(",  CRE_USR_ID" ).append("\n"); 
		query.append(",  CRE_DT" ).append("\n"); 
		query.append(",  UPD_USR_ID" ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append("FROM CNI_CGO_CLM_INSUR" ).append("\n"); 
		query.append("WHERE CGO_CLM_NO  = @[cgo_clm_no]" ).append("\n"); 

	}
}