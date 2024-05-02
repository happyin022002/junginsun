/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DryWetClaimDBDAOSearchHandlingCostListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.02
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.02 윤세영
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

public class DryWetClaimDBDAOSearchHandlingCostListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 Case 관련 발생된 제 처리비용을 조회한다
	  * </pre>
	  */
	public DryWetClaimDBDAOSearchHandlingCostListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOSearchHandlingCostListVORSQL").append("\n"); 
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
		query.append("DW_CLM_NO" ).append("\n"); 
		query.append(",	COST_SEQ" ).append("\n"); 
		query.append(",	CLM_COST_TP_CD" ).append("\n"); 
		query.append(",	CLM_PTY_NO" ).append("\n"); 
		query.append(",   (SELECT PTY_NM FROM CNI_PARTY WHERE CLM_PTY_NO = A.CLM_PTY_NO) CLM_PTY_NM" ).append("\n"); 
		query.append(",	COST_DESC" ).append("\n"); 
		query.append(",	INV_DT" ).append("\n"); 
		query.append(",	PAY_DT" ).append("\n"); 
		query.append(",	LOCL_CURR_CD" ).append("\n"); 
		query.append(",	INV_AMT" ).append("\n"); 
		query.append(",	INV_USD_AMT" ).append("\n"); 
		query.append(",	INV_XCH_RT" ).append("\n"); 
		query.append(",	INV_RMK" ).append("\n"); 
		query.append("FROM CNI_DW_CLM_COST A" ).append("\n"); 
		query.append("WHERE	DW_CLM_NO = @[dw_clm_no]" ).append("\n"); 

	}
}