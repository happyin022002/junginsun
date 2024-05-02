/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerCargoClaimReportDBDAOCargoLitigationReportInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.11.20 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerCargoClaimReportDBDAOCargoLitigationReportInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cargo Litigation Report
	  * </pre>
	  */
	public ContainerCargoClaimReportDBDAOCargoLitigationReportInfoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.integration ").append("\n"); 
		query.append("FileName : ContainerCargoClaimReportDBDAOCargoLitigationReportInfoRSQL").append("\n"); 
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
		query.append("A.HDLR_OFC_CD" ).append("\n"); 
		query.append(", A.CGO_CLM_STS_CD" ).append("\n"); 
		query.append(", '' CGO_CLM_STS_DT" ).append("\n"); 
		query.append(", CNI_GET_GMT_FNC (@[user_id]) CUR_DT" ).append("\n"); 
		query.append(", A.CGO_CLM_NO" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("VSL_ENG_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("VSL_CD = SUBSTR (TRNK_REF_VVD_NO, 1, 4)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VSL_ENG_NM" ).append("\n"); 
		query.append(", A.TRNK_REF_VVD_NO" ).append("\n"); 
		query.append(", B.CGO_CLM_REF_BL_NO" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MAX (CGO_CLM_REF_CNTR_NO)" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_CGO_CLM_CNTR_DTL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CGO_CLM_NO            = A.CGO_CLM_NO" ).append("\n"); 
		query.append("AND CGO_CLM_REF_BL_NO = B.CGO_CLM_REF_BL_NO" ).append("\n"); 
		query.append("AND MN_CNTR_FLG       = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("CGO_CLM_REF_CNTR_NO" ).append("\n"); 
		query.append(", A.SHPR_NM" ).append("\n"); 
		query.append(", A.CNEE_NM" ).append("\n"); 
		query.append(", A.NTFY_NM" ).append("\n"); 
		query.append(", A.CGO_QLTY_DESC" ).append("\n"); 
		query.append(", CNI_GET_CLM_MISC_NM_FNC ('33', A.CRR_TERM_CD, '2') CRR_TERM_MISC_NM" ).append("\n"); 
		query.append(", A.POR_CD" ).append("\n"); 
		query.append(", A.RCT_DT" ).append("\n"); 
		query.append(", A.POL_CD" ).append("\n"); 
		query.append(", A.LODG_DT" ).append("\n"); 
		query.append(", A.POD_CD" ).append("\n"); 
		query.append(", A.DCHG_DT" ).append("\n"); 
		query.append(", A.DEL_CD" ).append("\n"); 
		query.append(", A.DE_DT" ).append("\n"); 
		query.append(", A.N1ST_PRE_REF_VVD_NO" ).append("\n"); 
		query.append(", A.N1ST_PRE_TS_LOC_CD" ).append("\n"); 
		query.append(", A.N1ST_PRE_TS_DT" ).append("\n"); 
		query.append(", A.N1ST_PST_REF_VVD_NO" ).append("\n"); 
		query.append(", A.N1ST_PST_TS_LOC_CD" ).append("\n"); 
		query.append(", A.N1ST_PST_TS_DT" ).append("\n"); 
		query.append(", A.CLM_OFRT_AMT" ).append("\n"); 
		query.append(", CNI_GET_CLM_MISC_NM_FNC ('33', A.CLM_OFRT_TERM_CD, '2') OFRT_TERM_MISC_NM" ).append("\n"); 
		query.append(", CNI_GET_PTY_NM_FNC (INSUR_AGN_CLM_PTY_NO, '2') INSUR_PTY_NM" ).append("\n"); 
		query.append(", A.PLT_NM" ).append("\n"); 
		query.append(", CNI_GET_PTY_NM_FNC (CLM_AGN_CLM_PTY_NO, '2') AGN_PTY_NM" ).append("\n"); 
		query.append(", A.DEFT_NM" ).append("\n"); 
		query.append(", CNI_GET_PTY_NM_FNC (DEFT_ATTY_CLM_PTY_NO, '2') DEFT_ATTY_PTY_NM" ).append("\n"); 
		query.append(", A.SMNS_SVE_DT" ).append("\n"); 
		query.append(", A.CRT_NM" ).append("\n"); 
		query.append(", A.CRT_CS_NO" ).append("\n"); 
		query.append(", A.CLMT_LOCL_CURR_CD" ).append("\n"); 
		query.append(", A.CLMT_LOCL_AMT" ).append("\n"); 
		query.append(", A.CLMT_USD_AMT" ).append("\n"); 
		query.append(", A.CLM_CUZ_DESC" ).append("\n"); 
		query.append(", A.LTGT_CS_DESC" ).append("\n"); 
		query.append(", CNI_GET_PTY_NM_FNC (LABL_CLM_PTY_NO, '2') LABL_PTY_PTY_NM" ).append("\n"); 
		query.append(", A.LABL_PTY_DMND_CURR_CD" ).append("\n"); 
		query.append(", A.LABL_PTY_DMND_AMT" ).append("\n"); 
		query.append(", A.LABL_PTY_DMND_USD_AMT" ).append("\n"); 
		query.append(", A.LABL_PTY_FMAL_CLM_DT" ).append("\n"); 
		query.append(", A.LABL_PTY_RCVR_LOCL_CURR_CD" ).append("\n"); 
		query.append(", A.LABL_PTY_RCVR_LOCL_AMT" ).append("\n"); 
		query.append(", A.LABL_PTY_RCVR_USD_AMT" ).append("\n"); 
		query.append(", A.LABL_PTY_RCVR_DT" ).append("\n"); 
		query.append(", A.LABL_PTY_CLM_RMK" ).append("\n"); 
		query.append(", A.CGO_CLM_STL_RMK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_CLM_V A" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CGO_CLM_REF_BL_NO" ).append("\n"); 
		query.append(", CGO_CLM_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_CGO_CLM_BL_DTL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CGO_CLM_NO    = @[cgo_clm_no]" ).append("\n"); 
		query.append("AND MN_BL_FLG = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.CGO_CLM_NO = B.CGO_CLM_NO (+)" ).append("\n"); 
		query.append("AND A.CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 

	}
}