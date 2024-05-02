/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ClaimMainDBDAOSearchPaymentInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOSearchPaymentInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * payment 조회
	  * </pre>
	  */
	public ClaimMainDBDAOSearchPaymentInfoRSQL(){
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
		query.append("FileName : ClaimMainDBDAOSearchPaymentInfoRSQL").append("\n"); 
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
		query.append("    CLM.CGO_CLM_NO AS CGO_CLM_NO" ).append("\n"); 
		query.append("  , CLM.CLM_AREA_CD    /* AREA */" ).append("\n"); 
		query.append("  , MISC.CLM_MISC_NM    /* STATUS */" ).append("\n"); 
		query.append("  , CLM.CGO_CLM_STL_TP_CD    /* TOS */" ).append("\n"); 
		query.append("  , CLM.CS_CLZ_DT    /* DATE OF FORMAL CLAIM */" ).append("\n"); 
		query.append("  , MAX (" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            PTY_NM" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            CNI_PARTY" ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("            CLM_PTY_NO = CLM.CLMT_CLM_PTY_NO" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    )                                                                  AS PTY_NM" ).append("\n"); 
		query.append("  , MAX (CLMT_LOCL_AMT)                                                AS CLMT_LOCL_AMT" ).append("\n"); 
		query.append("  , MAX (CLMT_LOCL_CURR_CD)                                            AS CLMT_LOCL_CURR_CD" ).append("\n"); 
		query.append("  , MAX (CLMT_LOCL_XCH_RT)                                             AS CLMT_LOCL_XCH_RT" ).append("\n"); 
		query.append("  , MAX (CLMT_USD_AMT)                                                 AS CLMT_USD_AMT" ).append("\n"); 
		query.append("  , MAX (CGO_CLM_STL_LOCL_AMT)                                         AS CGO_CLM_STL_LOCL_AMT" ).append("\n"); 
		query.append("  , MAX (CGO_CLM_STL_LOCL_CURR_CD)                                     AS CGO_CLM_STL_LOCL_CURR_CD" ).append("\n"); 
		query.append("  , MAX (CGO_CLM_STL_XCH_RT)                                           AS CGO_CLM_STL_XCH_RT" ).append("\n"); 
		query.append("  , MAX (CGO_CLM_STL_USD_AMT)                                          AS CGO_CLM_STL_USD_AMT" ).append("\n"); 
		query.append("  , MAX ( (NVL (INSUR_RCVR_AMT, 0) + NVL (LABL_PTY_RCVR_LOCL_AMT, 0))) AS RECOVERED_AMOUNT" ).append("\n"); 
		query.append("  , MAX (LABL_PTY_RCVR_LOCL_AMT)                                       AS LABL_PTY_RCVR_LOCL_AMT" ).append("\n"); 
		query.append("  , MAX (LABL_PTY_RCVR_LOCL_CURR_CD)                                   AS LABL_PTY_RCVR_LOCL_CURR_CD" ).append("\n"); 
		query.append("  , MAX (LABL_PTY_RCVR_LOCL_XCH_RT)                                    AS LABL_PTY_RCVR_LOCL_XCH_RT" ).append("\n"); 
		query.append("  , MAX (LABL_PTY_RCVR_USD_AMT)                                        AS LABL_PTY_RCVR_USD_AMT" ).append("\n"); 
		query.append("  , MAX (INSUR_RCVR_AMT)                                               AS INSUR_RCVR_AMT" ).append("\n"); 
		query.append("  , MAX (INSUR_RCVR_LOCL_CURR_CD)                                      AS INSUR_RCVR_LOCL_CURR_CD" ).append("\n"); 
		query.append("  , MAX (INSUR_RCVR_XCH_RT)                                            AS INSUR_RCVR_XCH_RT" ).append("\n"); 
		query.append("  , MAX (INSUR_RCVR_USD_AMT)                                           AS INSUR_RCVR_USD_AMT" ).append("\n"); 
		query.append("  , MAX (FMAL_CLM_RCV_DT)                                              AS FMAL_CLM_RCV_DT    /* DOF */" ).append("\n"); 
		query.append("  , MAX (CGO_CLM_STL_DT) AS CGO_CLM_STL_DT    /* DOS */" ).append("\n"); 
		query.append("  , MAX (LABL_PTY_RCVR_DT) AS LABL_PTY_RCVR_DT    /* LP_DOR */" ).append("\n"); 
		query.append("  , MAX (INSUR_RCVR_DT) AS INSUR_RCVR_DT    /* INS_DOR */" ).append("\n"); 
		query.append("  , MAX ( (NVL (CGO_CLM_STL_USD_AMT, 0) - (NVL (INSUR_RCVR_USD_AMT, 0) + NVL (LABL_PTY_RCVR_USD_AMT, 0))))                                                                AS NET_PAID_AMOUNT" ).append("\n"); 
		query.append("  , MAX (ROUND (DECODE (CLMT_USD_AMT, 0, 0, (NVL (CGO_CLM_STL_USD_AMT, 0)   / CLMT_USD_AMT) * 100), 2))                                                                   AS DEFENSE_RATIO_ON_SETTLEMENT -- 반올림." ).append("\n"); 
		query.append("  , MAX (ROUND (DECODE (CLMT_USD_AMT, 0, 0, ( (NVL (CGO_CLM_STL_USD_AMT, 0) - (NVL (INSUR_RCVR_USD_AMT, 0) + NVL (LABL_PTY_RCVR_USD_AMT, 0))) / CLMT_USD_AMT) * 100), 2)) AS ON_NET_PAYMENT" ).append("\n"); 
		query.append("  , SUM (INV_USD_AMT) AS INV_USD_AMT/* HANDLING_COST_IN_TOTAL */" ).append("\n"); 
		query.append("  , MAX (PAY_RMK) AS PAY_RMK" ).append("\n"); 
		query.append("  , MAX (CGO_CLM_STS_CD) AS CGO_CLM_STS_CD" ).append("\n"); 
		query.append("  , MAX (CGO_CLM_CLZ_CD) AS CGO_CLM_CLZ_CD" ).append("\n"); 
		query.append("  , MAX (CLM.UPD_USR_ID) AS UPD_USR_ID" ).append("\n"); 
		query.append("  , MAX (CLM.HDLR_USR_ID) AS HDLR_USR_ID" ).append("\n"); 
		query.append("  , MAX (CLM.HDLR_OFC_CD) AS HDLR_OFC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    CNI_CLM_V CLM" ).append("\n"); 
		query.append("  , CNI_CGO_CLM_COST COST" ).append("\n"); 
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
		query.append("WHERE" ).append("\n"); 
		query.append("    CLM.CGO_CLM_NO         = @[cgo_clm_no]" ).append("\n"); 
		query.append("    AND CLM.CGO_CLM_NO     = COST.CGO_CLM_NO(+)" ).append("\n"); 
		query.append("    AND CLM.CGO_CLM_STS_CD = MISC.CLM_MISC_CD" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("    CLM.CGO_CLM_NO" ).append("\n"); 
		query.append("  , CLM.CLM_AREA_CD" ).append("\n"); 
		query.append("  , MISC.CLM_MISC_NM" ).append("\n"); 
		query.append("  , CLM.CGO_CLM_STL_TP_CD" ).append("\n"); 
		query.append("  , CLM.CS_CLZ_DT" ).append("\n"); 

	}
}