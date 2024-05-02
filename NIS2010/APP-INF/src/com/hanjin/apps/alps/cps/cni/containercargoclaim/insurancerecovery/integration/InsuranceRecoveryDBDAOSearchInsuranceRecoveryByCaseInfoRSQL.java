/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InsuranceRecoveryDBDAOSearchInsuranceRecoveryByCaseInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InsuranceRecoveryDBDAOSearchInsuranceRecoveryByCaseInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InsuranceRecoveryByCase 정보조회
	  * </pre>
	  */
	public InsuranceRecoveryDBDAOSearchInsuranceRecoveryByCaseInfoRSQL(){
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
		query.append("FileName : InsuranceRecoveryDBDAOSearchInsuranceRecoveryByCaseInfoRSQL").append("\n"); 
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
		query.append("  , CLM_AREA_CD" ).append("\n"); 
		query.append("  , HDLR_OFC_CD" ).append("\n"); 
		query.append("  , HDLR_USR_ID" ).append("\n"); 
		query.append("  , TO_CHAR(UPD_DT , 'YYYYMMDD') UPD_DT" ).append("\n"); 
		query.append("  , TRNK_REF_VVD_NO" ).append("\n"); 
		query.append("  , CNI_GET_CLM_MISC_NM_FNC('08' , CGO_CLM_STS_CD , '2') CGO_CLM_STS_NM" ).append("\n"); 
		query.append("  , CGO_CLM_STS_CD" ).append("\n"); 
		query.append("  , CS_CLZ_DT" ).append("\n"); 
		query.append("  , (TO_DATE (NVL (CS_CLZ_DT, TO_CHAR (SYSDATE, 'YYYYMMDD')), 'YYYYMMDD')      - TO_DATE (PRLM_CLM_NTC_DT, 'YYYYMMDD')) + 1 AS HPD" ).append("\n"); 
		query.append("  , (TO_DATE (NVL (CGO_CLM_STL_DT, TO_CHAR (SYSDATE, 'YYYYMMDD')), 'YYYYMMDD') - TO_DATE (FMAL_CLM_RCV_DT, 'YYYYMMDD')) + 1 AS NHP" ).append("\n"); 
		query.append("  , CGO_CLM_STL_DT" ).append("\n"); 
		query.append("  , PRLM_CLM_NTC_DT" ).append("\n"); 
		query.append("  , FMAL_CLM_RCV_DT" ).append("\n"); 
		query.append("  , CGO_CLM_STL_TP_CD" ).append("\n"); 
		query.append("  , CGO_CLM_TP_CD" ).append("\n"); 
		query.append("  , MJR_CLM_DMG_LSS_CD" ).append("\n"); 
		query.append("  , N3RD_LABL_PTY_CD" ).append("\n"); 
		query.append("  , INCI_PLC_TP_CD" ).append("\n"); 
		query.append("  , INCI_OCCR_DT" ).append("\n"); 
		query.append("  , CLM_CGO_TP_CD" ).append("\n"); 
		query.append("  , CLMT_LOCL_AMT" ).append("\n"); 
		query.append("  , CLMT_LOCL_CURR_CD" ).append("\n"); 
		query.append("  , CLMT_LOCL_XCH_RT" ).append("\n"); 
		query.append("  , CLMT_USD_AMT" ).append("\n"); 
		query.append("  , CNI_GET_PTY_NM_FNC (INSUR_CLM_PTY_NO, '1') INSUR_CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("  , CNI_GET_PTY_NM_FNC (INSUR_CLM_PTY_NO, '2') INSUR_PTY_NM" ).append("\n"); 
		query.append("  , INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append("  , CGO_CLM_STL_LOCL_AMT" ).append("\n"); 
		query.append("  , CGO_CLM_STL_LOCL_CURR_CD" ).append("\n"); 
		query.append("  , CGO_CLM_STL_XCH_RT" ).append("\n"); 
		query.append("  , CGO_CLM_STL_USD_AMT" ).append("\n"); 
		query.append("  , LABL_PTY_RCVR_LOCL_AMT" ).append("\n"); 
		query.append("  , LABL_PTY_RCVR_LOCL_CURR_CD" ).append("\n"); 
		query.append("  , LABL_PTY_RCVR_DT" ).append("\n"); 
		query.append("  , LABL_PTY_RCVR_LOCL_XCH_RT" ).append("\n"); 
		query.append("  , LABL_PTY_RCVR_USD_AMT" ).append("\n"); 
		query.append("  , INSUR_DMND_AMT" ).append("\n"); 
		query.append("  , INSUR_DMND_CURR_CD" ).append("\n"); 
		query.append("  , INSUR_FMAL_CLM_DT" ).append("\n"); 
		query.append("  , INSUR_XCH_RT" ).append("\n"); 
		query.append("  , INSUR_DMND_USD_AMT" ).append("\n"); 
		query.append("  , INSUR_RCVR_DT" ).append("\n"); 
		query.append("  , INSUR_RCVR_USD_AMT" ).append("\n"); 
		query.append("  , INSUR_RMK" ).append("\n"); 
		query.append("  , RCVR_USD_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    CNI_CLM_V" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 

	}
}