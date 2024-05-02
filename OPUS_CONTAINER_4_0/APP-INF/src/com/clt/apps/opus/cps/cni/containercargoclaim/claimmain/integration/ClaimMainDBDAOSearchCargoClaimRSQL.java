/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ClaimMainDBDAOSearchCargoClaimRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.30
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.04.30 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOSearchCargoClaimRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 클레임 번호로 카고 클레임 조회
	  * </pre>
	  */
	public ClaimMainDBDAOSearchCargoClaimRSQL(){
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
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration ").append("\n"); 
		query.append("FileName : ClaimMainDBDAOSearchCargoClaimRSQL").append("\n"); 
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
		query.append("    CGO_CLM_NO" ).append("\n"); 
		query.append("  , HDLR_USR_ID" ).append("\n"); 
		query.append("  , HDLR_OFC_CD" ).append("\n"); 
		query.append("  , CS_CLZ_DT" ).append("\n"); 
		query.append("  , CS_CLZ_OFC_CD" ).append("\n"); 
		query.append("  , CS_CLZ_USR_ID" ).append("\n"); 
		query.append("  , TM_BAR_DT" ).append("\n"); 
		query.append("  , PRLM_CLM_NTC_DT" ).append("\n"); 
		query.append("  , CGO_CLM_ACKNAK_DT" ).append("\n"); 
		query.append("  , FACT_FND_DT" ).append("\n"); 
		query.append("  , FACT_FND_DESC" ).append("\n"); 
		query.append("  , TRNS_FLG" ).append("\n"); 
		query.append("  , CS_CLZ_ROPN_FLG" ).append("\n"); 
		query.append("  , CS_CLZ_ROPN_DT" ).append("\n"); 
		query.append("  , CS_CLZ_ROPN_OFC_CD" ).append("\n"); 
		query.append("  , CS_CLZ_ROPN_USR_ID" ).append("\n"); 
		query.append("  , CGO_CLM_DIV_CD" ).append("\n"); 
		query.append("  , CP_DESC" ).append("\n"); 
		query.append("  , CLMT_CLM_PTY_NO" ).append("\n"); 
		query.append("  , CLMT_DESC" ).append("\n"); 
		query.append("  , CLMT_CLM_TP_CD" ).append("\n"); 
		query.append("  , CLMT_REF_NO" ).append("\n"); 
		query.append("  , FMAL_CLM_RCV_OFC_CD" ).append("\n"); 
		query.append("  , FMAL_CLM_RCV_DT" ).append("\n"); 
		query.append("  , FMAL_CLM_RCV_USR_ID" ).append("\n"); 
		query.append("  , CGO_CLM_TP_CD" ).append("\n"); 
		query.append("  , MJR_CLM_DMG_LSS_CD" ).append("\n"); 
		query.append("  , MINR_CLM_DMG_LSS_CD" ).append("\n"); 
		query.append("  , CGO_CLM_INCI_NO" ).append("\n"); 
		query.append("  , INCI_PLC_TP_CD" ).append("\n"); 
		query.append("  , INCI_OCCR_DT" ).append("\n"); 
		query.append("  , CLMT_LOCL_AMT" ).append("\n"); 
		query.append("  , CLMT_LOCL_CURR_CD" ).append("\n"); 
		query.append("  , CLMT_LOCL_XCH_RT" ).append("\n"); 
		query.append("  , CLMT_USD_AMT" ).append("\n"); 
		query.append("  , CLM_CUZ_DESC" ).append("\n"); 
		query.append("  , CLM_RVW_DESC" ).append("\n"); 
		query.append("  , AGN_CLM_PTY_NO" ).append("\n"); 
		query.append("  , CLMT_AGN_TP_CD" ).append("\n"); 
		query.append("  , CLMT_AGN_APNT_DT" ).append("\n"); 
		query.append("  , CLMT_AGN_REF_NO" ).append("\n"); 
		query.append("  , CGO_CLM_RCV_OFC_CD" ).append("\n"); 
		query.append("  , CGO_CLM_SUIT_FLG" ).append("\n"); 
		query.append("  , CLM_STL_APPL_DT" ).append("\n"); 
		query.append("  , CLM_STL_APPL_USR_ID" ).append("\n"); 
		query.append("  , CLM_STL_APPL_OFC_CD" ).append("\n"); 
		query.append("  , CLM_STL_AUTH_DT" ).append("\n"); 
		query.append("  , CLM_STL_AUTH_USR_ID" ).append("\n"); 
		query.append("  , CLM_STL_AUTH_OFC_CD" ).append("\n"); 
		query.append("  , CLM_STL_AUTH_CD" ).append("\n"); 
		query.append("  , CLM_STL_AUTH_RMK" ).append("\n"); 
		query.append("  , CLM_STL_AUTH_NO" ).append("\n"); 
		query.append("  , PAY_RMK" ).append("\n"); 
		query.append("  , CLMT_AGN_DESC" ).append("\n"); 
		query.append("  , CGO_CLM_STS_CD" ).append("\n"); 
		query.append("  , BFR_CGO_CLM_STS_CD" ).append("\n"); 
		query.append("  , CGO_CLM_CLZ_CD" ).append("\n"); 
		query.append("  , PRE_CGO_CLM_CLZ_CD" ).append("\n"); 
		query.append("  , CGO_CLM_CXL_FLG" ).append("\n"); 
		query.append("  , PAST_CGO_CLM_NO" ).append("\n"); 
		query.append("  , CRM_VOC_NO" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    CNI_CGO_CLM " ).append("\n"); 
		query.append("WHERE CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 

	}
}