/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ClaimMainDBDAOSearchHandlingCostInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.03.11 양정란
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yang jung ran
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOSearchHandlingCostInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchHandlingCostInfo
	  * </pre>
	  */
	public ClaimMainDBDAOSearchHandlingCostInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOSearchHandlingCostInfoRSQL").append("\n"); 
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
		query.append("    CLM.CGO_CLM_NO" ).append("\n"); 
		query.append("  , CLM.CLM_AREA_CD" ).append("\n"); 
		query.append("  , MISC.CLM_MISC_NM --STATUS" ).append("\n"); 
		query.append("  , CLM.CGO_CLM_STS_CD                                            " ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE (CLM.CS_CLZ_DT,'YYYYMMDD'), 'YYYY-MM-DD') AS CS_CLZ_DT --DOC" ).append("\n"); 
		query.append("  , CLM.CGO_CLM_STL_TP_CD                                        --TOS" ).append("\n"); 
		query.append("  , (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            PTY_NM" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            CNI_PARTY" ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("            CLM_PTY_NO = CLM.CLMT_CLM_PTY_NO" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    PTY_NM                                                                   --Claimant" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE (CLM.PRLM_CLM_NTC_DT,'YYYYMMDD'), 'YYYY-MM-DD') AS PRLM_CLM_NTC_DT --NOPC_DATE" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE (CLM.SMNS_SVE_DT,'YYYYMMDD'), 'YYYY-MM-DD')     AS SMNS_SVE_DT     --Summons Served Date" ).append("\n"); 
		query.append("  , CLM.CLMT_LOCL_AMT" ).append("\n"); 
		query.append("  , CLM.CLMT_LOCL_CURR_CD" ).append("\n"); 
		query.append("  , CLM.CLMT_LOCL_XCH_RT" ).append("\n"); 
		query.append("  , CLM.CLMT_USD_AMT" ).append("\n"); 
		query.append("  , CLM.CGO_CLM_STL_LOCL_AMT -- Settled Amount(INV_USD_AMT)" ).append("\n"); 
		query.append("  , CLM.CGO_CLM_STL_LOCL_CURR_CD" ).append("\n"); 
		query.append("  , CLM.CGO_CLM_STL_XCH_RT" ).append("\n"); 
		query.append("  , CLM.CGO_CLM_STL_USD_AMT" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE (FMAL_CLM_RCV_DT,'YYYYMMDD'), 'YYYY-MM-DD') AS FMAL_CLM_RCV_DT --DOF" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE (CGO_CLM_STL_DT,'YYYYMMDD'), 'YYYY-MM-DD')  AS CGO_CLM_STL_DT  -- DOS" ).append("\n"); 
		query.append("  , CLM_STL_AUTH_NO -- Approval No (INV_NO)" ).append("\n"); 
		query.append("  , CLM.HDLR_USR_ID" ).append("\n"); 
		query.append("  , CLM.HDLR_OFC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    CNI_CLM_V CLM" ).append("\n"); 
		query.append("  , (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            CLM_MISC_NM" ).append("\n"); 
		query.append("          , CLM_MISC_CD" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            CNI_MISC_CD" ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("            CLSS_CLM_MISC_CD = '08'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    MISC" ).append("\n"); 
		query.append("  , CNI_CGO_CLM_COST COST" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    CLM.CGO_CLM_NO         = @[cgo_clm_no]" ).append("\n"); 
		query.append("    AND CLM.CGO_CLM_NO     = COST.CGO_CLM_NO(+)" ).append("\n"); 
		query.append("    AND CLM.CGO_CLM_STS_CD = MISC.CLM_MISC_CD" ).append("\n"); 

	}
}