/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DryWetClaimDBDAOCustomHandlingCostVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.04 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DryWetClaimDBDAOCustomHandlingCostVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 Case 관련 발생된 제 처리비용을 생성 및 변경한다
	  * </pre>
	  */
	public DryWetClaimDBDAOCustomHandlingCostVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOCustomHandlingCostVORSQL").append("\n"); 
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
		query.append("'' DW_CLM_NO" ).append("\n"); 
		query.append(",	'' COST_SEQ" ).append("\n"); 
		query.append(",	'' CLM_COST_TP_CD" ).append("\n"); 
		query.append(",	'' CLM_PTY_NO" ).append("\n"); 
		query.append(",	'' CLM_PTY_NM" ).append("\n"); 
		query.append(",	'' COST_DESC" ).append("\n"); 
		query.append(",	'' INV_DT" ).append("\n"); 
		query.append(",	'' PAY_DT" ).append("\n"); 
		query.append(",	'' LOCL_CURR_CD" ).append("\n"); 
		query.append(",	'' INV_AMT" ).append("\n"); 
		query.append(",	'' INV_USD_AMT" ).append("\n"); 
		query.append(",	'' INV_XCH_RT" ).append("\n"); 
		query.append(",	'' INV_RMK" ).append("\n"); 
		query.append(",   '' SEQ_NO" ).append("\n"); 
		query.append(",	'' CRE_USR_ID" ).append("\n"); 
		query.append(",	'' UPD_USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}