/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchPaymentSlipMasterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchPaymentSlipMasterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPaymentSlipMaster
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchPaymentSlipMasterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration ").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchPaymentSlipMasterRSQL").append("\n"); 
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
		query.append("SELECT A.SLP_TP_CD" ).append("\n"); 
		query.append("     , A.SLP_FUNC_CD" ).append("\n"); 
		query.append("     , A.SLP_OFC_CD" ).append("\n"); 
		query.append("     , A.SLP_ISS_DT" ).append("\n"); 
		query.append("     , A.SLP_SER_NO" ).append("\n"); 
		query.append("     , A.CSR_NO" ).append("\n"); 
		query.append("     , A.FLET_CTRT_NO" ).append("\n"); 
		query.append("     , A.CSR_CURR_CD" ).append("\n"); 
		query.append("     , A.CSR_AMT AS DR_AMT" ).append("\n"); 
		query.append("     , A.CSR_USR_ID" ).append("\n"); 
		query.append("     , A.CSR_DESC AS SLP_DESC" ).append("\n"); 
		query.append("     , A.RQST_AMT AS BALANCE_AMT" ).append("\n"); 
		query.append("     , A.EFF_DT" ).append("\n"); 
		query.append("     , A.EVID_TP_CD" ).append("\n"); 
		query.append("     , A.DIFF_AMT" ).append("\n"); 
		query.append("     , A.RQST_DT" ).append("\n"); 
		query.append("     , A.VAT_SLP_TP_CD" ).append("\n"); 
		query.append("     , A.VAT_SLP_FUNC_CD" ).append("\n"); 
		query.append("     , A.VAT_SLP_OFC_CD" ).append("\n"); 
		query.append("     , A.VAT_SLP_ISS_DT" ).append("\n"); 
		query.append("     , A.VAT_SLP_SER_NO" ).append("\n"); 
		query.append("     , A.PPAY_HIR_NO" ).append("\n"); 
		query.append("     , A.DOC_EVID_TP_CD" ).append("\n"); 
		query.append("     , A.VNDR_SEQ" ).append("\n"); 
		query.append("     , A.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("     , A.CUST_CNT_CD" ).append("\n"); 
		query.append("     , A.CUST_SEQ" ).append("\n"); 
		query.append("     , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD01513'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = A.FLET_CTRT_TP_CD) AS FLET_CTRT_TP_NM" ).append("\n"); 
		query.append("     , (SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_VENDOR" ).append("\n"); 
		query.append("         WHERE VNDR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N' ) AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , (SELECT M.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("              FROM MDM_CUSTOMER M" ).append("\n"); 
		query.append("             WHERE M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               AND M.CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND M.CUST_SEQ = A.CUST_SEQ) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.SLP_TP_CD" ).append("\n"); 
		query.append("             , A.SLP_FUNC_CD" ).append("\n"); 
		query.append("             , A.SLP_OFC_CD" ).append("\n"); 
		query.append("             , A.SLP_ISS_DT" ).append("\n"); 
		query.append("             , A.SLP_SER_NO" ).append("\n"); 
		query.append("             , A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO AS CSR_NO" ).append("\n"); 
		query.append("             , A.FLET_CTRT_NO" ).append("\n"); 
		query.append("             , A.CSR_CURR_CD" ).append("\n"); 
		query.append("             , A.CSR_AMT" ).append("\n"); 
		query.append("             , A.CSR_USR_ID" ).append("\n"); 
		query.append("             , A.CSR_DESC" ).append("\n"); 
		query.append("             , A.RQST_AMT" ).append("\n"); 
		query.append("             , A.EFF_DT" ).append("\n"); 
		query.append("             , A.EVID_TP_CD" ).append("\n"); 
		query.append("             , A.DIFF_AMT" ).append("\n"); 
		query.append("             , A.RQST_DT" ).append("\n"); 
		query.append("             , A.VAT_SLP_TP_CD" ).append("\n"); 
		query.append("             , A.VAT_SLP_FUNC_CD" ).append("\n"); 
		query.append("             , A.VAT_SLP_OFC_CD" ).append("\n"); 
		query.append("             , A.VAT_SLP_ISS_DT" ).append("\n"); 
		query.append("             , A.VAT_SLP_SER_NO" ).append("\n"); 
		query.append("             , A.PPAY_HIR_NO" ).append("\n"); 
		query.append("             , A.DOC_EVID_TP_CD" ).append("\n"); 
		query.append("             , CASE WHEN (B.FLET_CTRT_TP_CD = 'TO' AND A.SLP_FUNC_CD = 'P') THEN " ).append("\n"); 
		query.append("                        (SELECT M.VNDR_SEQ" ).append("\n"); 
		query.append("                           FROM MDM_CUSTOMER M" ).append("\n"); 
		query.append("                          WHERE M.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("                            AND M.CUST_SEQ = B.CUST_SEQ)" ).append("\n"); 
		query.append("                   ELSE B.VNDR_SEQ" ).append("\n"); 
		query.append("               END VNDR_SEQ" ).append("\n"); 
		query.append("             , B.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("             , B.CUST_CNT_CD" ).append("\n"); 
		query.append("             , B.CUST_SEQ" ).append("\n"); 
		query.append("          FROM FMS_CONSULTATION A" ).append("\n"); 
		query.append("             , FMS_CONTRACT B" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("           AND A.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("   ) A" ).append("\n"); 

	}
}