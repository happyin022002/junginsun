/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchConsultationSlipListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchConsultationSlipListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchConsultationSlipList
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchConsultationSlipListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchConsultationSlipListRSQL").append("\n"); 
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
		query.append("SELECT APRO_FLG" ).append("\n"); 
		query.append("     , CSR_NO" ).append("\n"); 
		query.append("     , CSR_DT" ).append("\n"); 
		query.append("     , PRODUCED_BY" ).append("\n"); 
		query.append("     , CSR_CURR_CD" ).append("\n"); 
		query.append("     , CSR_AMT" ).append("\n"); 
		query.append("     , CSR_DESC" ).append("\n"); 
		query.append("     , REQUEST_TEAM" ).append("\n"); 
		query.append("     , RQST_DT" ).append("\n"); 
		query.append("     , OWNR_CD" ).append("\n"); 
		query.append("     , OWNR_NM" ).append("\n"); 
		query.append("     , OWNR_TP_CD" ).append("\n"); 
		query.append("     , OWNR_FULL_NM" ).append("\n"); 
		query.append("     , EVID_TP" ).append("\n"); 
		query.append("     , DEDUCTION" ).append("\n"); 
		query.append("     , RQST_AMT" ).append("\n"); 
		query.append("     , DIFF_DESC" ).append("\n"); 
		query.append("     , CXL_FLG" ).append("\n"); 
		query.append("     , CXL_DESC" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , VSL_ENG_NM" ).append("\n"); 
		query.append("     , FLET_CTRT_NO" ).append("\n"); 
		query.append("     , FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("     , SLIP_TYPE" ).append("\n"); 
		query.append("     , RCV_ERR_FLG" ).append("\n"); 
		query.append("     , RCV_ERR_RSN" ).append("\n"); 
		query.append("     , DECODE(SLIP_TYPE,'RV',NULL,INV_STS_CD) AS INV_STS_CD /*REVERSE 일대는 status null 로 표시한다.*/" ).append("\n"); 
		query.append("  FROM (SELECT APRO_FLG" ).append("\n"); 
		query.append("             , CSR_NO" ).append("\n"); 
		query.append("             , CSR_DT" ).append("\n"); 
		query.append("             , PRODUCED_BY" ).append("\n"); 
		query.append("             , CSR_CURR_CD" ).append("\n"); 
		query.append("             , CSR_AMT" ).append("\n"); 
		query.append("             , CSR_DESC" ).append("\n"); 
		query.append("             , REQUEST_TEAM" ).append("\n"); 
		query.append("             , RQST_DT" ).append("\n"); 
		query.append("             , CASE WHEN SP.CUST_CNT_CD IS NOT NULL AND SP.CUST_SEQ IS NOT NULL THEN CUST_CNT_CD || ' ' || CUST_SEQ" ).append("\n"); 
		query.append("                    ELSE TO_CHAR(VNDR_SEQ)" ).append("\n"); 
		query.append("               END OWNR_CD" ).append("\n"); 
		query.append("             , CASE WHEN SP.CUST_CNT_CD IS NOT NULL AND SP.CUST_SEQ IS NOT NULL THEN (  SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("                                                                                          FROM MDM_CUSTOMER MV" ).append("\n"); 
		query.append("                                                                                             , FMS_OWNER FO" ).append("\n"); 
		query.append("                                                                                         WHERE MV.CUST_CNT_CD = SP.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                                                           AND MV.CUST_SEQ = SP.CUST_SEQ" ).append("\n"); 
		query.append("                                                                                           AND MV.FLET_MGMT_OWNR_CUST_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("                                                                                           AND ROWNUM =1)" ).append("\n"); 
		query.append("                    ELSE (  SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("                              FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("                                 , FMS_OWNER FO" ).append("\n"); 
		query.append("                             WHERE MV.VNDR_SEQ = SP.VNDR_SEQ" ).append("\n"); 
		query.append("                               AND MV.FLET_MGMT_OWNR_VNDR_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("                               AND ROWNUM =1)" ).append("\n"); 
		query.append("               END OWNR_NM" ).append("\n"); 
		query.append("             , CASE WHEN SP.CUST_CNT_CD IS NOT NULL AND SP.CUST_SEQ IS NOT NULL THEN 'C'" ).append("\n"); 
		query.append("                    ELSE 'V'" ).append("\n"); 
		query.append("               END OWNR_TP_CD" ).append("\n"); 
		query.append("             , CASE WHEN SP.CUST_CNT_CD IS NOT NULL AND SP.CUST_SEQ IS NOT NULL THEN (  SELECT MV.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                                                                          FROM MDM_CUSTOMER MV" ).append("\n"); 
		query.append("                                                                                         WHERE MV.CUST_CNT_CD = SP.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                                                           AND MV.CUST_SEQ = SP.CUST_SEQ" ).append("\n"); 
		query.append("                                                                                           AND ROWNUM =1)" ).append("\n"); 
		query.append("                    ELSE (  SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                              FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("                             WHERE MV.VNDR_SEQ = SP.VNDR_SEQ" ).append("\n"); 
		query.append("                               AND ROWNUM =1)" ).append("\n"); 
		query.append("               END OWNR_FULL_NM" ).append("\n"); 
		query.append("             , EVID_TP" ).append("\n"); 
		query.append("             , DEDUCTION" ).append("\n"); 
		query.append("             , RQST_AMT" ).append("\n"); 
		query.append("             , DIFF_DESC" ).append("\n"); 
		query.append("             , CXL_FLG" ).append("\n"); 
		query.append("             , CXL_DESC" ).append("\n"); 
		query.append("             , VSL_CD" ).append("\n"); 
		query.append("             , VSL_ENG_NM" ).append("\n"); 
		query.append("             , FLET_CTRT_NO" ).append("\n"); 
		query.append("             , SUBSTR(FLET_CTRT_NO, 5, 2) FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("             , (SELECT CASE WHEN SLP_TP_CD||SLP_FUNC_CD = '20T' AND ORG_SLP_TP_CD IS NOT NULL THEN 'RV'" ).append("\n"); 
		query.append("                            ELSE NULL" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                  FROM FMS_CSUL_SLP" ).append("\n"); 
		query.append("                 WHERE SLP_TP_CD || SLP_FUNC_CD || SLP_OFC_CD || SLP_ISS_DT || SLP_SER_NO = CSR_NO" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) SLIP_TYPE" ).append("\n"); 
		query.append("             , NVL((SELECT DECODE(AP.RCV_ERR_FLG,'E','Y','N')" ).append("\n"); 
		query.append("                      FROM AP_INV_HDR AP" ).append("\n"); 
		query.append("                     WHERE AP.CSR_NO = SP.CSR_NO ),'N') AS RCV_ERR_FLG" ).append("\n"); 
		query.append("             , (SELECT AP.RCV_ERR_RSN" ).append("\n"); 
		query.append("                  FROM AP_INV_HDR AP" ).append("\n"); 
		query.append("                 WHERE AP.CSR_NO = SP.CSR_NO ) AS RCV_ERR_RSN" ).append("\n"); 
		query.append("             , CASE WHEN SP.SLP_TP_CD = '07' OR SP.SLP_TP_CD = '06' THEN (SELECT CASE WHEN NVL(H.PAY_AMT,0) <> 0 AND H.PAY_DT IS NOT NULL THEN 'Paid'" ).append("\n"); 
		query.append("                                                                                      ELSE NULL" ).append("\n"); 
		query.append("                                                                                 END" ).append("\n"); 
		query.append("                                                                            FROM AP_INV_HDR H" ).append("\n"); 
		query.append("                                                                           WHERE 1=1" ).append("\n"); 
		query.append("                                                                             AND H.CSR_NO = SP.CSR_NO )" ).append("\n"); 
		query.append("                    WHEN SP.SLP_TP_CD = '20' OR SP.SLP_TP_CD = '18' THEN (  SELECT CASE WHEN SUM(SOD.BAL_AMT) <= 0 THEN 'Receipt'" ).append("\n"); 
		query.append("                                                                                      ELSE NULL" ).append("\n"); 
		query.append("                                                                                   END" ).append("\n"); 
		query.append("                                                                              FROM SAR_OTS_HDR SOT" ).append("\n"); 
		query.append("                                                                                 , SAR_OTS_DTL SOD" ).append("\n"); 
		query.append("                                                                             WHERE 1=1" ).append("\n"); 
		query.append("                                                                               AND SOT.RHQ_CD = SOD.RHQ_CD" ).append("\n"); 
		query.append("                                                                               AND SOT.OTS_OFC_CD = SOD.OTS_OFC_CD" ).append("\n"); 
		query.append("                                                                               AND SOT.BL_NO = SOD.BL_NO" ).append("\n"); 
		query.append("                                                                               AND SOT.INV_NO = SOD.INV_NO" ).append("\n"); 
		query.append("                                                                               AND SOT.AP_AR_OFFST_NO = SP.CSR_NO )" ).append("\n"); 
		query.append("                   ELSE NULL" ).append("\n"); 
		query.append("                END AS INV_STS_CD" ).append("\n"); 
		query.append("          FROM (SELECT DISTINCT FC.APRO_FLG" ).append("\n"); 
		query.append("                     , FC.SLP_TP_CD || FC.SLP_FUNC_CD || FC.SLP_OFC_CD || FC.SLP_ISS_DT || FC.SLP_SER_NO CSR_NO" ).append("\n"); 
		query.append("                     , FC.SLP_TP_CD" ).append("\n"); 
		query.append("                     , TO_CHAR(FC.CRE_DT,'YYYYMMDD') CSR_DT" ).append("\n"); 
		query.append("                     , (SELECT USR_NM" ).append("\n"); 
		query.append("                          FROM COM_USER" ).append("\n"); 
		query.append("                         WHERE USR_ID = FC.CSR_USR_ID" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) PRODUCED_BY" ).append("\n"); 
		query.append("                     , FC.CSR_CURR_CD" ).append("\n"); 
		query.append("                     , TO_CHAR(FC.CSR_AMT,'FM999,999,999,999,999,990.00') CSR_AMT" ).append("\n"); 
		query.append("                     , FC.CSR_DESC" ).append("\n"); 
		query.append("                     , FC.SLP_OFC_CD REQUEST_TEAM" ).append("\n"); 
		query.append("                     , FC.RQST_DT" ).append("\n"); 
		query.append("                     , FS.CUST_CNT_CD" ).append("\n"); 
		query.append("                     , FS.CUST_SEQ" ).append("\n"); 
		query.append("                     , FS.VNDR_SEQ" ).append("\n"); 
		query.append("                     , (SELECT SLD.LU_DESC" ).append("\n"); 
		query.append("                          FROM SCO_LU_HDR SLH" ).append("\n"); 
		query.append("                             , SCO_LU_DTL SLD" ).append("\n"); 
		query.append("                         WHERE SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("                           AND SLH.LU_TP_CD = 'AP TAX CODE'" ).append("\n"); 
		query.append("                           AND NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("                           AND SLD.LU_CD = FC.EVID_TP_CD) AS EVID_TP" ).append("\n"); 
		query.append("                     , CASE WHEN FC.DIFF_AMT != 0 THEN 'Y'                                         " ).append("\n"); 
		query.append("                            ELSE 'N'" ).append("\n"); 
		query.append("                       END DEDUCTION" ).append("\n"); 
		query.append("                     , TO_CHAR(FC.RQST_AMT,'FM999,999,999,999,999,990.00') RQST_AMT" ).append("\n"); 
		query.append("                     , CASE WHEN FC.DIFF_AMT < 0 THEN TO_CHAR(-1 * FC.DIFF_AMT ,'FM999,999,999,999,999,990.00')" ).append("\n"); 
		query.append("                            ELSE TO_CHAR(FC.DIFF_AMT,'FM999,999,999,999,999,990.00')" ).append("\n"); 
		query.append("                       END AS DIFF_DESC" ).append("\n"); 
		query.append("                     , FC.CXL_FLG" ).append("\n"); 
		query.append("                     , FC.CXL_DESC" ).append("\n"); 
		query.append("                     , FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("                     , NVL(FS.VSL_CD,(SELECT VSL_CD" ).append("\n"); 
		query.append("                                  FROM FMS_CONTRACT" ).append("\n"); 
		query.append("                                 WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1)) VSL_CD" ).append("\n"); 
		query.append("                     , (SELECT VSL_ENG_NM" ).append("\n"); 
		query.append("                          FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("                         WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                           AND VSL_CD = NVL(FS.VSL_CD,(SELECT VSL_CD" ).append("\n"); 
		query.append("                                          FROM FMS_CONTRACT" ).append("\n"); 
		query.append("                                         WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND ROWNUM = 1)) ) VSL_ENG_NM" ).append("\n"); 
		query.append("                  FROM FMS_CONSULTATION FC" ).append("\n"); 
		query.append("                     , FMS_CSUL_SLP FS" ).append("\n"); 
		query.append("                 WHERE FC.SLP_TP_CD = FS.SLP_TP_CD" ).append("\n"); 
		query.append("                   AND FC.SLP_FUNC_CD = FS.SLP_FUNC_CD" ).append("\n"); 
		query.append("                   AND FC.SLP_OFC_CD = FS.SLP_OFC_CD" ).append("\n"); 
		query.append("                   AND FC.SLP_ISS_DT = FS.SLP_ISS_DT" ).append("\n"); 
		query.append("                   AND FC.SLP_SER_NO = FS.SLP_SER_NO" ).append("\n"); 
		query.append("                   AND FC.CXL_FLG = 'N'" ).append("\n"); 
		query.append("                   AND FC.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("                   AND FC.SLP_TP_CD = DECODE(@[csr_type],'AP','07',FC.SLP_TP_CD)" ).append("\n"); 
		query.append("            ) SP " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" ORDER BY CSR_NO" ).append("\n"); 

	}
}