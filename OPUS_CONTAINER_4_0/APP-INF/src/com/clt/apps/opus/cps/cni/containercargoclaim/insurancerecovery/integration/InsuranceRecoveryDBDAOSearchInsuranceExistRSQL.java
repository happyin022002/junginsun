/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InsuranceRecoveryDBDAOSearchInsuranceExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2009.10.30 정행룡
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONG HAENG RYONG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InsuranceRecoveryDBDAOSearchInsuranceExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insurance 입력/수정 결정
	  * </pre>
	  */
	public InsuranceRecoveryDBDAOSearchInsuranceExistRSQL(){
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
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.integration").append("\n"); 
		query.append("FileName : InsuranceRecoveryDBDAOSearchInsuranceExistRSQL").append("\n"); 
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
		query.append("'Y' AS CHK_EXIST" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("EXISTS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CGO_CLM_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_CGO_CLM_INSUR" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}