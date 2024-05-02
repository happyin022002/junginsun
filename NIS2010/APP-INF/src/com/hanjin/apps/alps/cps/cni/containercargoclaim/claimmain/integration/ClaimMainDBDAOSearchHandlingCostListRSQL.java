/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ClaimMainDBDAOSearchHandlingCostListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.03.03 양정란
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yang jung ran
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOSearchHandlingCostListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HandlingCost 조회
	  * </pre>
	  */
	public ClaimMainDBDAOSearchHandlingCostListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOSearchHandlingCostListRSQL").append("\n"); 
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
		query.append("    COST.CGO_CLM_PAY_NO" ).append("\n"); 
		query.append("  , COST.CGO_CLM_NO" ).append("\n"); 
		query.append("  , COST.CLM_COST_TP_CD" ).append("\n"); 
		query.append("  , COST.CLM_PTY_NO" ).append("\n"); 
		query.append("  , COST.COST_DESC" ).append("\n"); 
		query.append("  , COST.INV_NO" ).append("\n"); 
		query.append("  , COST.INV_DT" ).append("\n"); 
		query.append("  , COST.INV_AMT" ).append("\n"); 
		query.append("  , COST.LOCL_CURR_CD" ).append("\n"); 
		query.append("  , COST.INV_XCH_RT" ).append("\n"); 
		query.append("  , COST.INV_USD_AMT" ).append("\n"); 
		query.append("  , TO_CHAR (COST.PAY_DT, 'YYYYMMDD') AS PAY_DT" ).append("\n"); 
		query.append("  , COST.INV_RMK" ).append("\n"); 
		query.append("  , COST.INV_RGST_NO" ).append("\n"); 
		query.append("  , PARTY.CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("  , TO_CHAR (INV.AP_PAY_DT, 'YYYYMMDD') AS AP_PAY_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    CNI_CGO_CLM_COST COST" ).append("\n"); 
		query.append("  , AP_PAY_INV INV" ).append("\n"); 
		query.append("  , CNI_PARTY PARTY" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    COST.CGO_CLM_NO         = @[cgo_clm_no]" ).append("\n"); 
		query.append("    AND COST.INV_RGST_NO  = INV.INV_RGST_NO(+)" ).append("\n"); 
		query.append("    AND COST.CLM_PTY_NO     = PARTY.CLM_PTY_NO(+)" ).append("\n"); 
		query.append("ORDER BY COST.CGO_CLM_PAY_NO" ).append("\n"); 

	}
}