/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchSlipInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchSlipInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Slip Inquiry
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchSlipInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchSlipInquiryListRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("     (CASE WHEN SP.SLP_TP_CD = '20' THEN" ).append("\n"); 
		query.append("               (SELECT CASE           " ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '20' AND C.APRO_FLG = 'Y' THEN 'Approved'        " ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '20' AND C.APRO_FLG = 'N' AND C.CXL_FLG = 'N'  THEN 'Submitted'" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                      ELSE ''" ).append("\n"); 
		query.append("                    END " ).append("\n"); 
		query.append("                FROM FMS_CONSULTATION C," ).append("\n"); 
		query.append("                     COM_APRO_CSR_DTL P," ).append("\n"); 
		query.append("                     COM_APRO_RQST_HDR Q" ).append("\n"); 
		query.append("                WHERE 1 = 1" ).append("\n"); 
		query.append("                  AND SP.CSR_NO = P.CSR_NO" ).append("\n"); 
		query.append("                  AND P.APRO_RQST_NO = Q.APRO_RQST_NO" ).append("\n"); 
		query.append("                  AND C.SLP_TP_CD = SP.SLP_TP_CD" ).append("\n"); 
		query.append("                  AND C.SLP_FUNC_CD = SP.SLP_FUNC_CD" ).append("\n"); 
		query.append("                  AND C.SLP_OFC_CD = SP.SLP_OFC_CD" ).append("\n"); 
		query.append("                  AND C.SLP_ISS_DT = SP.SLP_ISS_DT" ).append("\n"); 
		query.append("                  AND C.SLP_SER_NO =  SP.SLP_SER_NO" ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          WHEN SP.SLP_TP_CD = '07' AND SP.CSR_DESC LIKE 'O/A Currency%' THEN" ).append("\n"); 
		query.append("                (SELECT CASE" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'Y' AND H.IF_FLG = 'Y' THEN 'Approved'" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'Y' AND H.IF_FLG = 'E' AND NVL(C.AP_CXL_FLG, 'N') = 'N' THEN 'I/F Error'" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                      ELSE ''" ).append("\n"); 
		query.append("                    END " ).append("\n"); 
		query.append("                FROM AP_INV_HDR H," ).append("\n"); 
		query.append("                     FMS_CONSULTATION C" ).append("\n"); 
		query.append("                WHERE 1 = 1" ).append("\n"); 
		query.append("                  AND SP.CSR_NO = H.CSR_NO" ).append("\n"); 
		query.append("                  AND C.SLP_TP_CD = SP.SLP_TP_CD" ).append("\n"); 
		query.append("                  AND C.SLP_FUNC_CD = SP.SLP_FUNC_CD" ).append("\n"); 
		query.append("                  AND C.SLP_OFC_CD = SP.SLP_OFC_CD" ).append("\n"); 
		query.append("                  AND C.SLP_ISS_DT = SP.SLP_ISS_DT" ).append("\n"); 
		query.append("                  AND C.SLP_SER_NO =  SP.SLP_SER_NO" ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          WHEN SP.SLP_TP_CD = '07' AND SP.CSR_APRO_TP_CD = 'GW' THEN" ).append("\n"); 
		query.append("                (SELECT CASE" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD||C.SLP_FUNC_CD = '07P' AND C.RQST_AMT < 0 THEN 'Cancelled'" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD||C.SLP_FUNC_CD||C.SLP_OFC_CD = '07SSELADG' AND C.RQST_AMT < 0 THEN 'Cancelled'" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.SLP_OFC_CD = 'SELADG' AND C.RQST_AMT > 0 AND " ).append("\n"); 
		query.append("                                 'Y' = (SELECT 'Y'" ).append("\n"); 
		query.append("                                         FROM FMS_CSUL_SLP S," ).append("\n"); 
		query.append("                                              FMS_CONSULTATION F" ).append("\n"); 
		query.append("                                         WHERE 1= 1" ).append("\n"); 
		query.append("                                           AND S.SLP_TP_CD = '07'" ).append("\n"); 
		query.append("                                           AND S.CSR_AMT < 0" ).append("\n"); 
		query.append("                                           AND S.ORG_SLP_TP_CD = C.SLP_TP_CD   " ).append("\n"); 
		query.append("                                           AND S.ORG_SLP_FUNC_CD = C.SLP_FUNC_CD" ).append("\n"); 
		query.append("                                           AND S.ORG_SLP_OFC_CD = C.SLP_OFC_CD" ).append("\n"); 
		query.append("                                           AND S.ORG_ISS_DT =  C.SLP_ISS_DT" ).append("\n"); 
		query.append("                                           AND S.ORG_SLP_SER_NO = C.SLP_SER_NO" ).append("\n"); 
		query.append("                                           AND S.SLP_TP_CD = F.SLP_TP_CD " ).append("\n"); 
		query.append("                                           AND S.SLP_FUNC_CD = F.SLP_FUNC_CD" ).append("\n"); 
		query.append("                                           AND S.SLP_OFC_CD =  F.SLP_OFC_CD" ).append("\n"); 
		query.append("                                           AND S.SLP_ISS_DT =  F.SLP_ISS_DT " ).append("\n"); 
		query.append("                                           AND S.SLP_SER_NO = F.SLP_SER_NO " ).append("\n"); 
		query.append("                                           AND SUBSTR(F.CSR_DESC, 1, 15) <> 'Hire Settlement'" ).append("\n"); 
		query.append("                                           AND ROWNUM = 1   " ).append("\n"); 
		query.append("                                  )  THEN 'Cancelled'" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'N' AND C.CXL_FLG = 'N' AND H.IF_FLG IS NULL " ).append("\n"); 
		query.append("                                AND NVL(H.CSR_APRO_TP_CD, 'AL') = 'GW' AND H.RQST_APRO_STEP_FLG IS NULL THEN 'Submitted'" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'N' AND C.CXL_FLG = 'N' AND H.IF_FLG IS NULL" ).append("\n"); 
		query.append("                             AND C.VAT_SLP_TP_CD IS NOT NULL THEN 'Submitted'" ).append("\n"); 
		query.append("                                         " ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'Y' AND H.IF_FLG = 'Y' THEN 'Approved'" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'Y' AND H.IF_FLG = 'E' AND NVL(C.AP_CXL_FLG, 'N') = 'N' THEN 'I/F Error'" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'N' AND C.CXL_FLG = 'N' AND H.IF_FLG IS NULL " ).append("\n"); 
		query.append("                                AND NVL(H.CSR_APRO_TP_CD, 'AL') = 'GW' AND NVL(H.RQST_APRO_STEP_FLG, 'N') = 'Y' THEN 'Saved(G)'" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.OA_INV_DT IS NOT NULL AND C.APRO_FLG = 'N' AND C.CXL_FLG = 'N' " ).append("\n"); 
		query.append("                               AND H.CSR_NO IS NULL THEN 'Saved(F)' " ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'Y' AND H.CSR_NO IS NULL THEN 'Approved'" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                      ELSE ''" ).append("\n"); 
		query.append("                    END " ).append("\n"); 
		query.append("                FROM AP_INV_HDR H," ).append("\n"); 
		query.append("                     FMS_CONSULTATION C" ).append("\n"); 
		query.append("                WHERE 1 = 1" ).append("\n"); 
		query.append("                  AND SP.CSR_NO = H.CSR_NO" ).append("\n"); 
		query.append("                  AND C.SLP_TP_CD = SP.SLP_TP_CD" ).append("\n"); 
		query.append("                  AND C.SLP_FUNC_CD = SP.SLP_FUNC_CD" ).append("\n"); 
		query.append("                  AND C.SLP_OFC_CD = SP.SLP_OFC_CD" ).append("\n"); 
		query.append("                  AND C.SLP_ISS_DT = SP.SLP_ISS_DT" ).append("\n"); 
		query.append("                  AND C.SLP_SER_NO =  SP.SLP_SER_NO" ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("          WHEN SP.SLP_TP_CD = '07' AND SP.CSR_DESC LIKE '선급부가세%'  THEN" ).append("\n"); 
		query.append("                (SELECT CASE" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'N' AND C.CXL_FLG = 'N' AND H.IF_FLG IS NULL" ).append("\n"); 
		query.append("                             AND C.VAT_SLP_TP_CD IS NOT NULL THEN 'Submitted'" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'N' AND C.CXL_FLG = 'N' THEN 'Saved(G)'" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD||C.SLP_FUNC_CD = '07P' AND C.RQST_AMT < 0 THEN 'Cancelled'" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD||C.SLP_FUNC_CD||C.SLP_OFC_CD = '07SSELADG' AND C.RQST_AMT < 0 THEN 'Cancelled'" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.SLP_OFC_CD = 'SELADG' AND C.RQST_AMT > 0 AND " ).append("\n"); 
		query.append("                                 'Y' = (SELECT 'Y'" ).append("\n"); 
		query.append("                                         FROM FMS_CSUL_SLP S," ).append("\n"); 
		query.append("                                              FMS_CONSULTATION F" ).append("\n"); 
		query.append("                                         WHERE 1= 1" ).append("\n"); 
		query.append("                                           AND S.SLP_TP_CD = '07'" ).append("\n"); 
		query.append("                                           AND S.CSR_AMT < 0" ).append("\n"); 
		query.append("                                           AND S.ORG_SLP_TP_CD = C.SLP_TP_CD   " ).append("\n"); 
		query.append("                                           AND S.ORG_SLP_FUNC_CD = C.SLP_FUNC_CD" ).append("\n"); 
		query.append("                                           AND S.ORG_SLP_OFC_CD = C.SLP_OFC_CD" ).append("\n"); 
		query.append("                                           AND S.ORG_ISS_DT =  C.SLP_ISS_DT" ).append("\n"); 
		query.append("                                           AND S.ORG_SLP_SER_NO = C.SLP_SER_NO" ).append("\n"); 
		query.append("                                           AND S.SLP_TP_CD = F.SLP_TP_CD " ).append("\n"); 
		query.append("                                           AND S.SLP_FUNC_CD = F.SLP_FUNC_CD" ).append("\n"); 
		query.append("                                           AND S.SLP_OFC_CD =  F.SLP_OFC_CD" ).append("\n"); 
		query.append("                                           AND S.SLP_ISS_DT =  F.SLP_ISS_DT " ).append("\n"); 
		query.append("                                           AND S.SLP_SER_NO = F.SLP_SER_NO " ).append("\n"); 
		query.append("                                           AND SUBSTR(F.CSR_DESC, 1, 15) <> 'Hire Settlement'" ).append("\n"); 
		query.append("                                           AND ROWNUM = 1   " ).append("\n"); 
		query.append("                                  )  THEN 'Cancelled'" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'N' AND C.CXL_FLG = 'N' AND H.IF_FLG IS NULL " ).append("\n"); 
		query.append("                                AND NVL(H.CSR_APRO_TP_CD, 'AL') = 'GW' AND H.RQST_APRO_STEP_FLG IS NULL THEN 'Submitted'" ).append("\n"); 
		query.append("                                         " ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'Y' AND H.IF_FLG = 'Y' THEN 'Approved'" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'Y' AND H.IF_FLG = 'E' AND NVL(C.AP_CXL_FLG, 'N') = 'N' THEN 'I/F Error'" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'N' AND C.CXL_FLG = 'N' AND H.IF_FLG IS NULL " ).append("\n"); 
		query.append("                                AND NVL(H.CSR_APRO_TP_CD, 'AL') = 'GW' AND NVL(H.RQST_APRO_STEP_FLG, 'N') = 'Y' THEN 'Saved(G)'" ).append("\n"); 
		query.append("                              ELSE ''" ).append("\n"); 
		query.append("                    END " ).append("\n"); 
		query.append("                FROM AP_INV_HDR H," ).append("\n"); 
		query.append("                     FMS_CONSULTATION C" ).append("\n"); 
		query.append("                WHERE 1 = 1" ).append("\n"); 
		query.append("                  AND SP.CSR_NO = H.CSR_NO" ).append("\n"); 
		query.append("                  AND C.SLP_TP_CD = SP.SLP_TP_CD" ).append("\n"); 
		query.append("                  AND C.SLP_FUNC_CD = SP.SLP_FUNC_CD" ).append("\n"); 
		query.append("                  AND C.SLP_OFC_CD = SP.SLP_OFC_CD" ).append("\n"); 
		query.append("                  AND C.SLP_ISS_DT = SP.SLP_ISS_DT" ).append("\n"); 
		query.append("                  AND C.SLP_SER_NO =  SP.SLP_SER_NO" ).append("\n"); 
		query.append("              )  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          WHEN SP.SLP_TP_CD = '07' AND SP.CSR_CNT = 0 THEN" ).append("\n"); 
		query.append("                (SELECT CASE" ).append("\n"); 
		query.append("                      WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'N' AND C.CXL_FLG = 'N' THEN 'Saved(F)'" ).append("\n"); 
		query.append("                      WHEN C.SLP_TP_CD||C.SLP_FUNC_CD = '07P' AND C.APRO_FLG = 'Y' AND C.CXL_FLG = 'N' AND C.RQST_AMT < 0 THEN 'Cancelled'" ).append("\n"); 
		query.append("                      WHEN C.SLP_TP_CD||C.SLP_FUNC_CD||C.SLP_OFC_CD = '07SSELADG' AND C.RQST_AMT < 0 AND C.APRO_FLG = 'Y' AND C.CXL_FLG = 'N' THEN 'Cancelled'" ).append("\n"); 
		query.append("                      WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'Y' AND C.CXL_FLG = 'N' THEN 'Approved'" ).append("\n"); 
		query.append("                      WHEN C.SLP_TP_CD = '07' AND C.SLP_OFC_CD = 'SELADG' AND C.RQST_AMT > 0 AND " ).append("\n"); 
		query.append("                                 'Y' = (SELECT 'Y'" ).append("\n"); 
		query.append("                                         FROM FMS_CSUL_SLP S," ).append("\n"); 
		query.append("                                              FMS_CONSULTATION F" ).append("\n"); 
		query.append("                                         WHERE 1= 1" ).append("\n"); 
		query.append("                                           AND S.SLP_TP_CD = '07'" ).append("\n"); 
		query.append("                                           AND S.CSR_AMT < 0" ).append("\n"); 
		query.append("                                           AND S.ORG_SLP_TP_CD = C.SLP_TP_CD   " ).append("\n"); 
		query.append("                                           AND S.ORG_SLP_FUNC_CD = C.SLP_FUNC_CD" ).append("\n"); 
		query.append("                                           AND S.ORG_SLP_OFC_CD = C.SLP_OFC_CD" ).append("\n"); 
		query.append("                                           AND S.ORG_ISS_DT =  C.SLP_ISS_DT" ).append("\n"); 
		query.append("                                           AND S.ORG_SLP_SER_NO = C.SLP_SER_NO" ).append("\n"); 
		query.append("                                           AND S.SLP_TP_CD = F.SLP_TP_CD " ).append("\n"); 
		query.append("                                           AND S.SLP_FUNC_CD = F.SLP_FUNC_CD" ).append("\n"); 
		query.append("                                           AND S.SLP_OFC_CD =  F.SLP_OFC_CD" ).append("\n"); 
		query.append("                                           AND S.SLP_ISS_DT =  F.SLP_ISS_DT " ).append("\n"); 
		query.append("                                           AND S.SLP_SER_NO = F.SLP_SER_NO " ).append("\n"); 
		query.append("                                           AND SUBSTR(F.CSR_DESC, 1, 15) <> 'Hire Settlement'" ).append("\n"); 
		query.append("                                           AND ROWNUM = 1   " ).append("\n"); 
		query.append("                                  )  THEN 'Cancelled'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      ELSE ''" ).append("\n"); 
		query.append("                    END " ).append("\n"); 
		query.append("                FROM FMS_CONSULTATION C" ).append("\n"); 
		query.append("                WHERE 1 = 1" ).append("\n"); 
		query.append("                  AND C.SLP_TP_CD = SP.SLP_TP_CD" ).append("\n"); 
		query.append("                  AND C.SLP_FUNC_CD = SP.SLP_FUNC_CD" ).append("\n"); 
		query.append("                  AND C.SLP_OFC_CD = SP.SLP_OFC_CD" ).append("\n"); 
		query.append("                  AND C.SLP_ISS_DT = SP.SLP_ISS_DT" ).append("\n"); 
		query.append("                  AND C.SLP_SER_NO =  SP.SLP_SER_NO" ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         WHEN SP.SLP_TP_CD = '07' AND SP.APRO_FLG = 'Y' AND SP.CSR_APRO_TP_CD = 'AL' THEN" ).append("\n"); 
		query.append("                (SELECT CASE" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'Y' AND H.IF_FLG = 'Y' THEN 'Approved'" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'Y' AND H.IF_FLG = 'E' AND NVL(C.AP_CXL_FLG, 'N') = 'N' THEN 'I/F Error'" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                      ELSE ''" ).append("\n"); 
		query.append("                    END " ).append("\n"); 
		query.append("                FROM AP_INV_HDR H," ).append("\n"); 
		query.append("                     FMS_CONSULTATION C" ).append("\n"); 
		query.append("                WHERE 1 = 1" ).append("\n"); 
		query.append("                  AND SP.CSR_NO = H.CSR_NO" ).append("\n"); 
		query.append("                  AND C.SLP_TP_CD = SP.SLP_TP_CD" ).append("\n"); 
		query.append("                  AND C.SLP_FUNC_CD = SP.SLP_FUNC_CD" ).append("\n"); 
		query.append("                  AND C.SLP_OFC_CD = SP.SLP_OFC_CD" ).append("\n"); 
		query.append("                  AND C.SLP_ISS_DT = SP.SLP_ISS_DT" ).append("\n"); 
		query.append("                  AND C.SLP_SER_NO =  SP.SLP_SER_NO" ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ELSE   " ).append("\n"); 
		query.append("                (SELECT CASE" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'N' AND C.CXL_FLG = 'N' AND H.IF_FLG IS NULL " ).append("\n"); 
		query.append("                                AND NVL(H.CSR_APRO_TP_CD, 'AL') = 'AL' AND Q.APSTS_CD = 'P' THEN 'Submitted'" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'N' AND C.CXL_FLG = 'N' AND H.IF_FLG IS NULL" ).append("\n"); 
		query.append("                             AND C.VAT_SLP_TP_CD IS NOT NULL THEN 'Submitted'" ).append("\n"); 
		query.append("                                         " ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'Y' AND H.IF_FLG = 'Y' THEN 'Approved'" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'Y' AND H.IF_FLG = 'E' AND NVL(C.AP_CXL_FLG, 'N') = 'N' THEN 'I/F Error'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                       WHEN C.SLP_TP_CD = '07' AND C.APRO_FLG = 'Y' AND H.CSR_NO IS NULL THEN 'Approved'" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                      ELSE ''" ).append("\n"); 
		query.append("                    END " ).append("\n"); 
		query.append("                FROM AP_INV_HDR H," ).append("\n"); 
		query.append("                     FMS_CONSULTATION C," ).append("\n"); 
		query.append("                     COM_APRO_CSR_DTL P," ).append("\n"); 
		query.append("                     COM_APRO_RQST_HDR Q" ).append("\n"); 
		query.append("                WHERE 1 = 1" ).append("\n"); 
		query.append("                  AND SP.CSR_NO = H.CSR_NO" ).append("\n"); 
		query.append("                  AND SP.CSR_NO = P.CSR_NO" ).append("\n"); 
		query.append("                  AND P.APRO_RQST_NO = Q.APRO_RQST_NO" ).append("\n"); 
		query.append("                  AND C.SLP_TP_CD = SP.SLP_TP_CD" ).append("\n"); 
		query.append("                  AND C.SLP_FUNC_CD = SP.SLP_FUNC_CD" ).append("\n"); 
		query.append("                  AND C.SLP_OFC_CD = SP.SLP_OFC_CD" ).append("\n"); 
		query.append("                  AND C.SLP_ISS_DT = SP.SLP_ISS_DT" ).append("\n"); 
		query.append("                  AND C.SLP_SER_NO =  SP.SLP_SER_NO" ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("         END ) AS APRO_FLG, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   SP.CSR_NO," ).append("\n"); 
		query.append("	   CSR_DT," ).append("\n"); 
		query.append("	   PRODUCED_BY," ).append("\n"); 
		query.append("	   SP.CSR_CURR_CD," ).append("\n"); 
		query.append("	   SP.CSR_AMT," ).append("\n"); 
		query.append("	   CSR_DESC," ).append("\n"); 
		query.append("	   REQUEST_TEAM," ).append("\n"); 
		query.append("	   RQST_DT," ).append("\n"); 
		query.append("       CASE WHEN SP.CUST_CNT_CD IS NOT NULL AND SP.CUST_SEQ IS NOT NULL THEN" ).append("\n"); 
		query.append("                 SP.CUST_CNT_CD || ' ' || SP.CUST_SEQ" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 TO_CHAR(SP.VNDR_SEQ) " ).append("\n"); 
		query.append("        END OWNR_CD, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        CASE WHEN FT.OWNR_SEQ IS NULL THEN" ).append("\n"); 
		query.append("        (  " ).append("\n"); 
		query.append("          CASE WHEN SP.CUST_CNT_CD IS NOT NULL AND SP.CUST_SEQ IS NOT NULL THEN" ).append("\n"); 
		query.append("          (SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER MV, FMS_OWNER FO" ).append("\n"); 
		query.append("          WHERE MV.CUST_CNT_CD = SP.CUST_CNT_CD" ).append("\n"); 
		query.append("          AND MV.CUST_SEQ = SP.CUST_SEQ" ).append("\n"); 
		query.append("          AND MV.FLET_MGMT_OWNR_CUST_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("          AND ROWNUM =1)" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("          (SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("          FROM MDM_VENDOR MV, FMS_OWNER FO" ).append("\n"); 
		query.append("          WHERE MV.VNDR_SEQ = SP.VNDR_SEQ" ).append("\n"); 
		query.append("          AND MV.FLET_MGMT_OWNR_VNDR_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("          AND ROWNUM =1)" ).append("\n"); 
		query.append("          END " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("      ELSE  " ).append("\n"); 
		query.append("          (SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("           FROM FMS_OWNER FO" ).append("\n"); 
		query.append("           WHERE FT.OWNR_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("           AND ROWNUM =1" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("      END OWNR_NM," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  		(SELECT MV.SUBS_CO_CD " ).append("\n"); 
		query.append("  			FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("  			WHERE MV.VNDR_SEQ = SP.VNDR_SEQ" ).append("\n"); 
		query.append("  		) INTER_CO_CD," ).append("\n"); 
		query.append("  		(SELECT mc.subs_co_cd" ).append("\n"); 
		query.append("    		FROM mdm_customer mc" ).append("\n"); 
		query.append("    		WHERE mc.cust_cnt_cd = SP.CUST_CNT_CD" ).append("\n"); 
		query.append("     		and mc.cust_seq = SP.CUST_SEQ" ).append("\n"); 
		query.append("     		AND ROWNUM =1 " ).append("\n"); 
		query.append("     	) AR_INTER_CO_CD," ).append("\n"); 
		query.append("	   EVID_TP," ).append("\n"); 
		query.append("	   DEDUCTION," ).append("\n"); 
		query.append("	   RQST_AMT," ).append("\n"); 
		query.append("       DIFF_DESC," ).append("\n"); 
		query.append("       CXL_FLG," ).append("\n"); 
		query.append("       CXL_DESC," ).append("\n"); 
		query.append("       SP.VSL_CD," ).append("\n"); 
		query.append("       VSL_ENG_NM," ).append("\n"); 
		query.append("       SP.FLET_CTRT_NO," ).append("\n"); 
		query.append("       SUBSTR(SP.FLET_CTRT_NO, 5, 2) FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("	   (SELECT CASE WHEN SLP_TP_CD||SLP_FUNC_CD = '20T' AND ORG_SLP_TP_CD IS NOT NULL THEN " ).append("\n"); 
		query.append("                         'RV' " ).append("\n"); 
		query.append("					WHEN SLP_TP_CD||SLP_FUNC_CD = '20T' AND SUBSTR(SP.FLET_CTRT_NO, 5, 2) = 'TI' THEN" ).append("\n"); 
		query.append("                  		'AR'" ).append("\n"); 
		query.append("                END " ).append("\n"); 
		query.append("	      FROM FMS_CSUL_SLP " ).append("\n"); 
		query.append("	     WHERE SLP_TP_CD   = SUBSTR(SP.CSR_NO,1,2)" ).append("\n"); 
		query.append("           AND SLP_FUNC_CD = SUBSTR(SP.CSR_NO,3,1)" ).append("\n"); 
		query.append("           AND SLP_OFC_CD = SUBSTR(SP.CSR_NO,4,6)" ).append("\n"); 
		query.append("           AND SLP_ISS_DT = SUBSTR(SP.CSR_NO,10,6)" ).append("\n"); 
		query.append("           AND SLP_SER_NO = SUBSTR(SP.CSR_NO,16,5)" ).append("\n"); 
		query.append("           AND ROWNUM = 1) SLIP_TYPE" ).append("\n"); 
		query.append("	   ,CASE WHEN SUBSTR(SP.CSR_NO,0,3) = '20T' THEN ''" ).append("\n"); 
		query.append("             ELSE AP.RQST_APRO_STEP_FLG" ).append("\n"); 
		query.append("             END RQST_APRO_STEP_FLG" ).append("\n"); 
		query.append("       ,(SELECT H.PAY_DT" ).append("\n"); 
		query.append("         FROM AP_INV_HDR H" ).append("\n"); 
		query.append("         WHERE H.CSR_NO = SP.CSR_NO" ).append("\n"); 
		query.append("           AND SUBSTR(H.INV_DESC, 1, 15) <> 'Hire Settlement'" ).append("\n"); 
		query.append("         ) PAY_DT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT FC.APRO_FLG," ).append("\n"); 
		query.append("               FC.SLP_TP_CD," ).append("\n"); 
		query.append("               FC.SLP_FUNC_CD," ).append("\n"); 
		query.append("               FC.SLP_OFC_CD ," ).append("\n"); 
		query.append("               FC.SLP_ISS_DT ," ).append("\n"); 
		query.append("               FC.SLP_SER_NO ,     " ).append("\n"); 
		query.append("                  FC.SLP_TP_CD" ).append("\n"); 
		query.append("               || FC.SLP_FUNC_CD" ).append("\n"); 
		query.append("               || FC.SLP_OFC_CD" ).append("\n"); 
		query.append("               || FC.SLP_ISS_DT" ).append("\n"); 
		query.append("               || FC.SLP_SER_NO CSR_NO," ).append("\n"); 
		query.append("               FC.EFF_DT CSR_DT," ).append("\n"); 
		query.append("               (SELECT USR_NM" ).append("\n"); 
		query.append("                  FROM COM_USER" ).append("\n"); 
		query.append("                 WHERE USR_ID = FC.CSR_USR_ID" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) PRODUCED_BY," ).append("\n"); 
		query.append("               FC.CSR_CURR_CD," ).append("\n"); 
		query.append("               TO_CHAR(FC.CSR_AMT,'FM999,999,999,999,999,990.00') CSR_AMT," ).append("\n"); 
		query.append("               FC.CSR_DESC," ).append("\n"); 
		query.append("               FC.SLP_OFC_CD REQUEST_TEAM," ).append("\n"); 
		query.append("               FC.RQST_DT," ).append("\n"); 
		query.append("               (SELECT CUST_CNT_CD" ).append("\n"); 
		query.append("                  FROM FMS_CSUL_SLP FS" ).append("\n"); 
		query.append("                 WHERE FC.SLP_TP_CD = FS.SLP_TP_CD" ).append("\n"); 
		query.append("				   AND FC.SLP_FUNC_CD = FS.SLP_FUNC_CD" ).append("\n"); 
		query.append("				   AND FC.SLP_OFC_CD = FS.SLP_OFC_CD" ).append("\n"); 
		query.append("				   AND FC.SLP_ISS_DT = FS.SLP_ISS_DT" ).append("\n"); 
		query.append("				   AND FC.SLP_SER_NO = FS.SLP_SER_NO" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) CUST_CNT_CD," ).append("\n"); 
		query.append("               (SELECT CUST_SEQ" ).append("\n"); 
		query.append("                  FROM FMS_CSUL_SLP FS" ).append("\n"); 
		query.append("                 WHERE FC.SLP_TP_CD = FS.SLP_TP_CD" ).append("\n"); 
		query.append("				   AND FC.SLP_FUNC_CD = FS.SLP_FUNC_CD" ).append("\n"); 
		query.append("				   AND FC.SLP_OFC_CD = FS.SLP_OFC_CD" ).append("\n"); 
		query.append("				   AND FC.SLP_ISS_DT = FS.SLP_ISS_DT" ).append("\n"); 
		query.append("				   AND FC.SLP_SER_NO = FS.SLP_SER_NO" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) CUST_SEQ," ).append("\n"); 
		query.append("               (SELECT VNDR_SEQ" ).append("\n"); 
		query.append("                  FROM FMS_CSUL_SLP FS" ).append("\n"); 
		query.append("                 WHERE FC.SLP_TP_CD = FS.SLP_TP_CD" ).append("\n"); 
		query.append("				   AND FC.SLP_FUNC_CD = FS.SLP_FUNC_CD" ).append("\n"); 
		query.append("				   AND FC.SLP_OFC_CD = FS.SLP_OFC_CD" ).append("\n"); 
		query.append("				   AND FC.SLP_ISS_DT = FS.SLP_ISS_DT" ).append("\n"); 
		query.append("				   AND FC.SLP_SER_NO = FS.SLP_SER_NO" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) VNDR_SEQ," ).append("\n"); 
		query.append("               DECODE(FC.EVID_TP_CD,'1','TAX','4','CI','ETC') EVID_TP," ).append("\n"); 
		query.append("               CASE WHEN FC.DIFF_AMT > 0 THEN" ).append("\n"); 
		query.append("                         'Y'" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                         'N'" ).append("\n"); 
		query.append("                END DEDUCTION," ).append("\n"); 
		query.append("               TO_CHAR(FC.RQST_AMT,'FM999,999,999,999,999,990.00') RQST_AMT," ).append("\n"); 
		query.append("               TO_CHAR(FC.DIFF_AMT,'FM999,999,999,999,999,990.00') DIFF_DESC," ).append("\n"); 
		query.append("               FC.CXL_FLG," ).append("\n"); 
		query.append("               FC.CXL_DESC," ).append("\n"); 
		query.append("               FC.FLET_CTRT_NO," ).append("\n"); 
		query.append("			   (SELECT NVL(VSL_CD,(SELECT VSL_CD" ).append("\n"); 
		query.append("			   						 FROM FMS_CONTRACT" ).append("\n"); 
		query.append("			                        WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("			                          AND ROWNUM = 1))" ).append("\n"); 
		query.append("                 FROM FMS_CSUL_SLP FS" ).append("\n"); 
		query.append("                WHERE FC.SLP_TP_CD = FS.SLP_TP_CD" ).append("\n"); 
		query.append("				  AND FC.SLP_FUNC_CD = FS.SLP_FUNC_CD" ).append("\n"); 
		query.append("				  AND FC.SLP_OFC_CD = FS.SLP_OFC_CD" ).append("\n"); 
		query.append("				  AND FC.SLP_ISS_DT = FS.SLP_ISS_DT" ).append("\n"); 
		query.append("				  AND FC.SLP_SER_NO = FS.SLP_SER_NO" ).append("\n"); 
		query.append("                  AND ROWNUM = 1) VSL_CD," ).append("\n"); 
		query.append("			   (SELECT VSL_ENG_NM" ).append("\n"); 
		query.append("  				  FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append(" 				 WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("   				   AND VSL_CD = (SELECT NVL(VSL_CD,(SELECT VSL_CD" ).append("\n"); 
		query.append("			   						                  FROM FMS_CONTRACT" ).append("\n"); 
		query.append("			                                         WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("			                                           AND ROWNUM = 1))" ).append("\n"); 
		query.append("                  				   FROM FMS_CSUL_SLP FS" ).append("\n"); 
		query.append("					              WHERE FC.SLP_TP_CD = FS.SLP_TP_CD" ).append("\n"); 
		query.append("									AND FC.SLP_FUNC_CD = FS.SLP_FUNC_CD" ).append("\n"); 
		query.append("									AND FC.SLP_OFC_CD = FS.SLP_OFC_CD" ).append("\n"); 
		query.append("									AND FC.SLP_ISS_DT = FS.SLP_ISS_DT" ).append("\n"); 
		query.append("									AND FC.SLP_SER_NO = FS.SLP_SER_NO" ).append("\n"); 
		query.append("                   				    AND ROWNUM = 1)) VSL_ENG_NM" ).append("\n"); 
		query.append("               ,(SELECT NVL(H.CSR_APRO_TP_CD, 'AL')" ).append("\n"); 
		query.append("                  FROM AP_INV_HDR H " ).append("\n"); 
		query.append("                  WHERE H.CSR_NO = FC.SLP_TP_CD|| FC.SLP_FUNC_CD || FC.SLP_OFC_CD || FC.SLP_ISS_DT || FC.SLP_SER_NO " ).append("\n"); 
		query.append("                 ) CSR_APRO_TP_CD" ).append("\n"); 
		query.append("               ,(SELECT COUNT(*)" ).append("\n"); 
		query.append("                  FROM AP_INV_HDR H " ).append("\n"); 
		query.append("                  WHERE H.CSR_NO = FC.SLP_TP_CD|| FC.SLP_FUNC_CD || FC.SLP_OFC_CD || FC.SLP_ISS_DT || FC.SLP_SER_NO" ).append("\n"); 
		query.append("                 ) CSR_CNT" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("          FROM FMS_CONSULTATION FC" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND FC.CXL_FLG = 'N'" ).append("\n"); 
		query.append("         #if (${vat_slp_tp_cd} != '')" ).append("\n"); 
		query.append("		   AND FC.VAT_SLP_TP_CD IS NULL" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 #if (${from_eff_dt} != '')" ).append("\n"); 
		query.append("           AND FC.EFF_DT BETWEEN REPLACE(@[from_eff_dt],'-','') AND REPLACE(@[to_eff_dt],'-','')" ).append("\n"); 
		query.append("		 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 #if (${from_cre_dt} != '')" ).append("\n"); 
		query.append("           AND FC.CRE_DT  BETWEEN TO_DATE(@[from_cre_dt],'YYYY-MM-DD') AND TO_DATE(@[to_cre_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("           AND FC.FLET_CTRT_NO IN (SELECT FLET_CTRT_NO" ).append("\n"); 
		query.append("                                     FROM FMS_CONTRACT" ).append("\n"); 
		query.append("                                    WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                   UNION ALL" ).append("\n"); 
		query.append("                                   SELECT FLET_CTRT_NO" ).append("\n"); 
		query.append("                                     FROM FMS_ID_VSL" ).append("\n"); 
		query.append("                                    WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                      AND USE_FLG = 'Y')  " ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         #if (${csr_no} != '')" ).append("\n"); 
		query.append("           AND    FC.SLP_TP_CD" ).append("\n"); 
		query.append("               || FC.SLP_FUNC_CD" ).append("\n"); 
		query.append("               || FC.SLP_OFC_CD" ).append("\n"); 
		query.append("               || FC.SLP_ISS_DT" ).append("\n"); 
		query.append("               || FC.SLP_SER_NO LIKE @[csr_no] || '%'" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("		SELECT DISTINCT" ).append("\n"); 
		query.append("			   FC.APRO_FLG," ).append("\n"); 
		query.append("               FC.SLP_TP_CD," ).append("\n"); 
		query.append("               FC.SLP_FUNC_CD," ).append("\n"); 
		query.append("               FC.SLP_OFC_CD ," ).append("\n"); 
		query.append("               FC.SLP_ISS_DT ," ).append("\n"); 
		query.append("               FC.SLP_SER_NO ,   " ).append("\n"); 
		query.append("                  FC.SLP_TP_CD" ).append("\n"); 
		query.append("               || FC.SLP_FUNC_CD" ).append("\n"); 
		query.append("               || FC.SLP_OFC_CD" ).append("\n"); 
		query.append("               || FC.SLP_ISS_DT" ).append("\n"); 
		query.append("               || FC.SLP_SER_NO CSR_NO," ).append("\n"); 
		query.append("               FC.EFF_DT CSR_DT," ).append("\n"); 
		query.append("               (SELECT USR_NM" ).append("\n"); 
		query.append("                  FROM COM_USER" ).append("\n"); 
		query.append("                 WHERE USR_ID = FC.CSR_USR_ID" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) PRODUCED_BY," ).append("\n"); 
		query.append("               FC.CSR_CURR_CD," ).append("\n"); 
		query.append("               TO_CHAR(FC.CSR_AMT,'FM999,999,999,999,999,990.00') CSR_AMT," ).append("\n"); 
		query.append("               FC.CSR_DESC," ).append("\n"); 
		query.append("               FC.SLP_OFC_CD REQUEST_TEAM," ).append("\n"); 
		query.append("               FC.RQST_DT," ).append("\n"); 
		query.append("               FS.CUST_CNT_CD," ).append("\n"); 
		query.append("               FS.CUST_SEQ," ).append("\n"); 
		query.append("               FS.VNDR_SEQ," ).append("\n"); 
		query.append("               DECODE(FC.EVID_TP_CD,'1','TAX','4','CI','ETC') EVID_TP," ).append("\n"); 
		query.append("               CASE WHEN FC.DIFF_AMT > 0 THEN" ).append("\n"); 
		query.append("                         'Y'" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                         'N'" ).append("\n"); 
		query.append("                END DEDUCTION," ).append("\n"); 
		query.append("               TO_CHAR(FC.RQST_AMT,'FM999,999,999,999,999,990.00') RQST_AMT," ).append("\n"); 
		query.append("               TO_CHAR(FC.DIFF_AMT,'FM999,999,999,999,999,990.00') DIFF_DESC," ).append("\n"); 
		query.append("               FC.CXL_FLG," ).append("\n"); 
		query.append("               FC.CXL_DESC," ).append("\n"); 
		query.append("               FC.FLET_CTRT_NO," ).append("\n"); 
		query.append("			   NVL(FS.VSL_CD,(SELECT VSL_CD" ).append("\n"); 
		query.append("			   					FROM FMS_CONTRACT" ).append("\n"); 
		query.append("			                   WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("			                     AND ROWNUM = 1)) VSL_CD," ).append("\n"); 
		query.append("			   (SELECT VSL_ENG_NM" ).append("\n"); 
		query.append("  				  FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append(" 				 WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("   				   AND VSL_CD = NVL(FS.VSL_CD,(SELECT VSL_CD" ).append("\n"); 
		query.append("			   						             FROM FMS_CONTRACT" ).append("\n"); 
		query.append("			                                    WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("			                                      AND ROWNUM = 1))" ).append("\n"); 
		query.append("   				) VSL_ENG_NM" ).append("\n"); 
		query.append("              ,'' CSR_APRO_TP_CD" ).append("\n"); 
		query.append("              ,0 CSR_CNT " ).append("\n"); 
		query.append("          FROM FMS_CONSULTATION FC, FMS_CSUL_SLP FS" ).append("\n"); 
		query.append("		 WHERE 1 = 1" ).append("\n"); 
		query.append("           AND FC.CXL_FLG = 'N'" ).append("\n"); 
		query.append("           AND FC.SLP_TP_CD = FS.SLP_TP_CD" ).append("\n"); 
		query.append("		   AND FC.SLP_FUNC_CD = FS.SLP_FUNC_CD" ).append("\n"); 
		query.append("		   AND FC.SLP_OFC_CD = FS.SLP_OFC_CD" ).append("\n"); 
		query.append("		   AND FC.SLP_ISS_DT = FS.SLP_ISS_DT" ).append("\n"); 
		query.append("		   AND FC.SLP_SER_NO = FS.SLP_SER_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         #if (${vat_slp_tp_cd} != '')" ).append("\n"); 
		query.append("		   AND FC.VAT_SLP_TP_CD IS NULL" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 #if (${from_eff_dt} != '')" ).append("\n"); 
		query.append("           AND FC.EFF_DT BETWEEN REPLACE(@[from_eff_dt],'-','') AND REPLACE(@[to_eff_dt],'-','')" ).append("\n"); 
		query.append("		 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 #if (${from_cre_dt} != '')" ).append("\n"); 
		query.append("           AND FC.CRE_DT  BETWEEN TO_DATE(@[from_cre_dt],'YYYY-MM-DD') AND TO_DATE(@[to_cre_dt],'YYYY-MM-DD') + 0.99999 " ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   AND FS.ORG_SLP_TP_CD = '20'" ).append("\n"); 
		query.append("           AND FS.ORG_SLP_FUNC_CD = 'T'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("     	   AND FS.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         #if (${csr_no} != '')" ).append("\n"); 
		query.append("           AND    FC.SLP_TP_CD" ).append("\n"); 
		query.append("               || FC.SLP_FUNC_CD" ).append("\n"); 
		query.append("               || FC.SLP_OFC_CD" ).append("\n"); 
		query.append("               || FC.SLP_ISS_DT" ).append("\n"); 
		query.append("               || FC.SLP_SER_NO LIKE @[csr_no] || '%'" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("       ) SP" ).append("\n"); 
		query.append("	   ,FMS_CONTRACT  FT" ).append("\n"); 
		query.append("	   ,AP_INV_HDR AP" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SP.FLET_CTRT_NO = FT.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("AND SP.CSR_NO = AP.CSR_NO(+)" ).append("\n"); 
		query.append("ORDER BY CSR_NO" ).append("\n"); 

	}
}