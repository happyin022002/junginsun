/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CollectionAuditDBDAOsearchCollecationAuditListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CollectionAuditDBDAOsearchCollecationAuditListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_DOD_0008 : DOD Collection Audit List 개발
	  * </pre>
	  */
	public CollectionAuditDBDAOsearchCollecationAuditListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_exemption_yn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eq_rtn_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eq_rtn_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.integration").append("\n"); 
		query.append("FileName : CollectionAuditDBDAOsearchCollecationAuditListRSQL").append("\n"); 
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
		query.append("SELECT E.CFM_OFC_CD" ).append("\n"); 
		query.append("     , A.CNTR_NO" ).append("\n"); 
		query.append("     , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , B.DEL_CD" ).append("\n"); 
		query.append("     , E.CNTR_RTN_YD_CD TRO_CNTR_RTN_YD_CD" ).append("\n"); 
		query.append("     , A.ACT_TRN_YARD" ).append("\n"); 
		query.append("     , E.CNTR_RTN_DT TRO_CNTR_RTN_DT" ).append("\n"); 
		query.append("     , A.ACT_TRN_YARD" ).append("\n"); 
		query.append("--     , TO_CHAR(E.CNTR_RTN_DT, 'YYYY-MM-DD') CNTR_RTN_DT" ).append("\n"); 
		query.append("     , A.PRE_EVENTDATE CNTR_RTN_DT" ).append("\n"); 
		query.append("     , A.BKG_NO" ).append("\n"); 
		query.append("     , B.POR_CD" ).append("\n"); 
		query.append("     , B.POL_CD" ).append("\n"); 
		query.append("     , B.POD_CD" ).append("\n"); 
		query.append("     , B.DEL_CD" ).append("\n"); 
		query.append("     , B.SC_NO" ).append("\n"); 
		query.append("     , B.RFA_NO" ).append("\n"); 
		query.append("     , (SELECT U.CUST_CNT_CD" ).append("\n"); 
		query.append("          FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("         WHERE U.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND U.BKG_CUST_TP_CD = 'S' ) CUST_CNT_CD" ).append("\n"); 
		query.append("     , (SELECT U.CUST_SEQ" ).append("\n"); 
		query.append("          FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("         WHERE U.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND U.BKG_CUST_TP_CD = 'S' ) CUST_SEQ" ).append("\n"); 
		query.append("     , (SELECT U.CUST_CNT_CD || LPAD(U.CUST_SEQ, 6, '0')" ).append("\n"); 
		query.append("          FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("         WHERE U.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND U.BKG_CUST_TP_CD = 'S' ) CUSTOMER" ).append("\n"); 
		query.append("     , (SELECT SUBSTR(C.CUST_LGL_ENG_NM, 1, 50)" ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER C" ).append("\n"); 
		query.append("             , BKG_CUSTOMER U" ).append("\n"); 
		query.append("         WHERE C.CUST_CNT_CD = U.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND C.CUST_SEQ = U.CUST_SEQ" ).append("\n"); 
		query.append("           AND U.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND U.BKG_CUST_TP_CD = 'S' ) CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("     , TO_CHAR(B.POL_ETD_DT, 'YYYY-MM-DD') POL_ETD_DT" ).append("\n"); 
		query.append("     , TO_CHAR(E.CFM_DT, 'YYYY-MM-DD') TRO_DT" ).append("\n"); 
		query.append("     , (SELECT TO_CHAR(G.UPD_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("         WHERE G.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("           AND G.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("           AND G.AR_IF_NO IS NOT NULL" ).append("\n"); 
		query.append("           AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                 WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                   AND C.CNTR_NO = G.CNTR_NO) ) AR_IF_DT" ).append("\n"); 
		query.append("     , (SELECT G.CURR_CD" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("         WHERE G.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("           AND G.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("           AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                 WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                   AND C.CNTR_NO = G.CNTR_NO) ) CURR_CD" ).append("\n"); 
		query.append("     , (SELECT G.GEN_TRF_AMT" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("         WHERE G.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("           AND G.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if(${s_ar_if_yn} == 'Y')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NOT NULL" ).append("\n"); 
		query.append("           #end   " ).append("\n"); 
		query.append("           #if(${s_ar_if_yn} == 'N')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NULL" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                 WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                   AND C.CNTR_NO = G.CNTR_NO) ) GEN_TRF_AMT" ).append("\n"); 
		query.append("     , (SELECT G.SPCL_TRF_AMT" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("         WHERE G.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("           AND G.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if(${s_ar_if_yn} == 'Y')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NOT NULL" ).append("\n"); 
		query.append("           #end   " ).append("\n"); 
		query.append("           #if(${s_ar_if_yn} == 'N')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NULL" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                 WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                   AND C.CNTR_NO = G.CNTR_NO) ) SPCL_TRF_AMT" ).append("\n"); 
		query.append("     , (SELECT DECODE(G.DRP_OFF_CHG_TRF_SPCL_SEQ, NULL, G.GEN_TRF_AMT, G.SPCL_TRF_AMT)" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("         WHERE G.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("           AND G.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if(${s_ar_if_yn} == 'Y')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NOT NULL" ).append("\n"); 
		query.append("           #end   " ).append("\n"); 
		query.append("           #if(${s_ar_if_yn} == 'N')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NULL" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                 WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                   AND C.CNTR_NO = G.CNTR_NO) ) INCURRED_AMT" ).append("\n"); 
		query.append("     , (SELECT (-G.DC_AMT + G.SVC_FEE_AMT)*-1" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("         WHERE G.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("           AND G.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if(${s_ar_if_yn} == 'Y')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NOT NULL" ).append("\n"); 
		query.append("           #end   " ).append("\n"); 
		query.append("           #if(${s_ar_if_yn} == 'N')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NULL" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                 WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                   AND C.CNTR_NO = G.CNTR_NO) ) ADJUST_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , (SELECT CASE WHEN G.TTL_AMT > 0 THEN G.TTL_AMT" ).append("\n"); 
		query.append("                WHEN G.TTL_AMT < 0 THEN 0" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("                END END" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("         WHERE G.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("           AND G.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if(${s_ar_if_yn} == 'Y')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NOT NULL" ).append("\n"); 
		query.append("           #end   " ).append("\n"); 
		query.append("           #if(${s_ar_if_yn} == 'N')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NULL" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                 WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                   AND C.CNTR_NO = G.CNTR_NO) ) INVOICE_AMT" ).append("\n"); 
		query.append("     , (SELECT ROUND(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(G.UPD_DT, 'YYYYMM'), G.CURR_CD, 'USD', " ).append("\n"); 
		query.append("                      CASE WHEN G.TTL_AMT > 0 THEN  G.TTL_AMT" ).append("\n"); 
		query.append("                          WHEN G.TTL_AMT < 0 THEN 0" ).append("\n"); 
		query.append("                          ELSE 0" ).append("\n"); 
		query.append("                          END), 2)" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("         WHERE G.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("           AND G.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if(${s_ar_if_yn} == 'Y')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NOT NULL" ).append("\n"); 
		query.append("           #end   " ).append("\n"); 
		query.append("           #if(${s_ar_if_yn} == 'N')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NULL" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                 WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                   AND C.CNTR_NO = G.CNTR_NO) ) INVOICE_USD_AMT" ).append("\n"); 
		query.append("      , (SELECT  " ).append("\n"); 
		query.append("               NVL((CASE WHEN G.DRP_OFF_CHG_TRF_SPCL_SEQ IS NULL" ).append("\n"); 
		query.append("                    THEN (SELECT F.DRP_OFF_CHG_TRF_EXPT_FLG" ).append("\n"); 
		query.append("                            FROM DOD_DRP_OFF_CHG D, DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("                           WHERE D.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                             AND D.CNTR_NO = G.CNTR_NO" ).append("\n"); 
		query.append("                             AND D.DRP_OFF_CHG_TRF_SEQ = F.DRP_OFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append("                             AND D.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                                    FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                                   WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                                     AND C.CNTR_NO = G.CNTR_NO))" ).append("\n"); 
		query.append("                     ELSE (SELECT F.DRP_OFF_CHG_TRF_EXPT_FLG" ).append("\n"); 
		query.append("                            FROM DOD_DRP_OFF_CHG D, DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("                           WHERE D.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                             AND D.CNTR_NO = G.CNTR_NO" ).append("\n"); 
		query.append("                             AND D.DRP_OFF_CHG_TRF_SPCL_SEQ = F.DRP_OFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append("                             AND D.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                                    FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                                   WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                                     AND C.CNTR_NO = G.CNTR_NO))" ).append("\n"); 
		query.append("                    END), 'N')" ).append("\n"); 
		query.append("             FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("             WHERE G.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("               AND G.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("               AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                                          FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                                         WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                                           AND C.CNTR_NO = G.CNTR_NO) ) EXEMPTION" ).append("\n"); 
		query.append("     , (SELECT DECODE(G.AUTH_APRO_RQST_NO, NULL, 'N', 'Y')" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("         WHERE G.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("           AND G.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("           AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                 WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                   AND C.CNTR_NO = G.CNTR_NO) ) ADJUST_APPROVAL" ).append("\n"); 
		query.append("     , (SELECT G.DC_RMK" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("         WHERE G.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("           AND G.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("           AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                 WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                   AND C.CNTR_NO = G.CNTR_NO) ) REMARK" ).append("\n"); 
		query.append("  FROM (SELECT /*+ INDEX( M XIE6CTM_MOVEMENT ) */" ).append("\n"); 
		query.append("          M.CNMV_CO_CD AS COMPANY" ).append("\n"); 
		query.append("             , M.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append("             , M.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             , M.ORG_YD_CD AS ACT_TRN_YARD" ).append("\n"); 
		query.append("             , TO_CHAR(M.CNMV_EVNT_DT,'YYYY-MM-DD') AS PRE_EVENTDATE" ).append("\n"); 
		query.append("             , M.TRNK_VSL_CD||M.TRNK_SKD_VOY_NO||M.TRNK_SKD_DIR_CD AS TVVD" ).append("\n"); 
		query.append("             , (SELECT /*+ INDEX_DESC ( MM XFN1CTM_MOVEMENT ) */" ).append("\n"); 
		query.append("                  MM.BKG_NO" ).append("\n"); 
		query.append("                  FROM CTM_MOVEMENT MM" ).append("\n"); 
		query.append("                 WHERE MM.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("                   AND MM.CNMV_YR || TO_CHAR(MM.CNMV_SEQ, '0000') ||MM.CNMV_SPLIT_NO < M.CNMV_YR||TO_CHAR(M.CNMV_SEQ,'0000')||M.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                   AND MM.MVMT_STS_CD = 'ID'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1 ) BKG_NO" ).append("\n"); 
		query.append("          FROM CTM_MOVEMENT M" ).append("\n"); 
		query.append("             , MST_CONTAINER C" ).append("\n"); 
		query.append("-- Period (MT Return Date) 조건                      " ).append("\n"); 
		query.append("         WHERE M.CNMV_EVNT_DT BETWEEN TO_DATE( @[s_eq_rtn_from_dt], 'YYYY-MM-DD') + .0 AND TO_DATE( @[s_eq_rtn_to_dt], 'YYYY-MM-DD') + .99999" ).append("\n"); 
		query.append("           AND M.MVMT_STS_CD = 'MT'" ).append("\n"); 
		query.append("           AND M.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("           AND NVL(C.LSTM_CD, '  ') <> 'SH' /* SOC  */" ).append("\n"); 
		query.append("           AND NVL(M.MVMT_CRE_TP_CD, '  ') NOT IN ( 'C'" ).append("\n"); 
		query.append("                     ,'L' )" ).append("\n"); 
		query.append("           #if(${s_loc_cd} != '')" ).append("\n"); 
		query.append("              #if(${s_loc_tp_cd} == '5')" ).append("\n"); 
		query.append("              AND M.ORG_YARD_CD = @[s_loc_cd] -- RETURN LOACATION" ).append("\n"); 
		query.append("              #else" ).append("\n"); 
		query.append("              AND EXISTS (" ).append("\n"); 
		query.append("                  SELECT 'X'" ).append("\n"); 
		query.append("                    FROM MDM_LOCATION L, MDM_EQ_ORZ_CHT O, MDM_YARD Y" ).append("\n"); 
		query.append("                   WHERE L.SCC_CD = O.SCC_CD" ).append("\n"); 
		query.append("                     AND L.LOC_CD = Y.LOC_CD" ).append("\n"); 
		query.append("                     AND Y.YD_CD = M.ORG_YD_CD" ).append("\n"); 
		query.append("                     #if(${s_loc_tp_cd} == '1')" ).append("\n"); 
		query.append("                     AND O.RCC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append("                     #elseif(${s_loc_tp_cd} == '2')" ).append("\n"); 
		query.append("                     AND O.LCC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append("                     #elseif(${s_loc_tp_cd} == '3')" ).append("\n"); 
		query.append("                     AND O.ECC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append("                     #elseif(${s_loc_tp_cd} == '4')" ).append("\n"); 
		query.append("                     AND O.SCC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append("                     #end   " ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("              AND 'ID' = (SELECT /*+ INDEX_DESC ( MM XFN1CTM_MOVEMENT ) */" ).append("\n"); 
		query.append("                  MM.MVMT_STS_CD /*  PRE_MVMT_STS_CD   */" ).append("\n"); 
		query.append("                  FROM CTM_MOVEMENT MM" ).append("\n"); 
		query.append("                 WHERE MM.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("                   AND MM.CNMV_YR || TO_CHAR(MM.CNMV_SEQ, '0000') ||MM.CNMV_SPLIT_NO < M.CNMV_YR||TO_CHAR(M.CNMV_SEQ,'0000')||M.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                   AND ROWNUM = 1 )" ).append("\n"); 
		query.append("             #if(${s_cntr_no} != '')" ).append("\n"); 
		query.append("             AND M.CNTR_NO = @[s_cntr_no] --CNTR NO" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("             #if(${s_bkg_no} != '')" ).append("\n"); 
		query.append("             AND M.BKG_NO = @[s_bkg_no] -- BKG NO" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("     , BKG_CUSTOMER S1" ).append("\n"); 
		query.append("     , BKG_CUSTOMER C1" ).append("\n"); 
		query.append("     , BKG_CUSTOMER N1" ).append("\n"); 
		query.append("     , BKG_BOOKING B" ).append("\n"); 
		query.append("     , BKG_EUR_TRO E" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.BKG_NO = S1.BKG_NO(+)" ).append("\n"); 
		query.append("   AND S1.BKG_CUST_TP_CD(+) ='S'" ).append("\n"); 
		query.append("   AND A.BKG_NO = C1.BKG_NO(+)" ).append("\n"); 
		query.append("   AND C1.BKG_CUST_TP_CD(+) ='C'" ).append("\n"); 
		query.append("   AND A.BKG_NO = N1.BKG_NO(+)" ).append("\n"); 
		query.append("   AND N1.BKG_CUST_TP_CD(+) ='N'" ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("   AND A.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("   AND A.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("   AND E.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("   AND E.HLG_TP_CD = 'M'" ).append("\n"); 
		query.append("   AND SUBSTR(E.CNTR_RTN_YD_CD, 1, 5) <> B.DEL_CD" ).append("\n"); 
		query.append("   AND E.CXL_FLG = 'N'" ).append("\n"); 
		query.append("   AND E.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("   AND E.CFM_OFC_CD = @[s_ofc_cd] -- OFFFICE 조건" ).append("\n"); 
		query.append("   AND E.TRO_SEQ = (SELECT MAX(TT.TRO_SEQ)" ).append("\n"); 
		query.append("                             FROM BKG_EUR_TRO TT" ).append("\n"); 
		query.append("                            WHERE TT.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                              AND TT.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("                              AND TT.IO_BND_CD = 'I') " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("   #if(${s_rfa_no} != '')" ).append("\n"); 
		query.append("   AND B.RFA_NO = @[s_rfa_no]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${s_sc_no} != '')" ).append("\n"); 
		query.append("   AND B.SC_NO = @[s_sc_no]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${s_loc_cd} != '')" ).append("\n"); 
		query.append("       #if(${s_loc_tp_cd} == '5')" ).append("\n"); 
		query.append("       AND A.ACT_TRN_YARD = @[s_loc_cd] -- RETURN LOACATION" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("       AND EXISTS (" ).append("\n"); 
		query.append("           SELECT 'X'" ).append("\n"); 
		query.append("             FROM MDM_LOCATION L, MDM_EQ_ORZ_CHT O, MDM_YARD Y" ).append("\n"); 
		query.append("            WHERE L.SCC_CD = O.SCC_CD" ).append("\n"); 
		query.append("              AND L.LOC_CD = Y.LOC_CD" ).append("\n"); 
		query.append("              AND Y.YD_CD = E.CNTR_RTN_YD_CD" ).append("\n"); 
		query.append("              #if(${s_loc_tp_cd} == '1')" ).append("\n"); 
		query.append("              AND O.RCC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append("              #elseif(${s_loc_tp_cd} == '2')" ).append("\n"); 
		query.append("              AND O.LCC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append("              #elseif(${s_loc_tp_cd} == '3')" ).append("\n"); 
		query.append("              AND O.ECC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append("              #elseif(${s_loc_tp_cd} == '4')" ).append("\n"); 
		query.append("              AND O.SCC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append("              #end   " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${s_cust_cd} != '')" ).append("\n"); 
		query.append("   AND @[s_cust_cd] = (SELECT U.CUST_CNT_CD||LPAD(U.CUST_SEQ, 6, '0')" ).append("\n"); 
		query.append("                     FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("                    WHERE U.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                      AND U.BKG_CUST_TP_CD = 'S' )" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${s_unmatch_yn} == 'Y')" ).append("\n"); 
		query.append("   AND (SELECT G.GEN_TRF_AMT" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("         WHERE G.BKG_NO =  A.BKG_NO" ).append("\n"); 
		query.append("           AND G.CNTR_NO = A.CNTR_NO  " ).append("\n"); 
		query.append("           AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                                      FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                                     WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                                       AND C.CNTR_NO = G.CNTR_NO) " ).append("\n"); 
		query.append("           AND G.AR_IF_NO IS NOT NULL                             " ).append("\n"); 
		query.append("         ) <> " ).append("\n"); 
		query.append("         (SELECT G.TTL_AMT" ).append("\n"); 
		query.append("            FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("           WHERE G.BKG_NO =  A.BKG_NO" ).append("\n"); 
		query.append("             AND G.CNTR_NO = A.CNTR_NO  " ).append("\n"); 
		query.append("             AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                                        FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                                       WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                                         AND C.CNTR_NO = G.CNTR_NO) " ).append("\n"); 
		query.append("             AND G.AR_IF_NO IS NOT NULL  " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${s_unmatch_yn} == 'N')" ).append("\n"); 
		query.append("   AND (SELECT G.GEN_TRF_AMT" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("         WHERE G.BKG_NO =  A.BKG_NO" ).append("\n"); 
		query.append("           AND G.CNTR_NO = A.CNTR_NO  " ).append("\n"); 
		query.append("           AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                                      FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                                     WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                                       AND C.CNTR_NO = G.CNTR_NO) " ).append("\n"); 
		query.append("           AND G.AR_IF_NO IS NOT NULL                             " ).append("\n"); 
		query.append("         ) = " ).append("\n"); 
		query.append("         (SELECT G.TTL_AMT" ).append("\n"); 
		query.append("            FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("           WHERE G.BKG_NO =  A.BKG_NO" ).append("\n"); 
		query.append("             AND G.CNTR_NO = A.CNTR_NO  " ).append("\n"); 
		query.append("             AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                                        FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                                       WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                                         AND C.CNTR_NO = G.CNTR_NO) " ).append("\n"); 
		query.append("             AND G.AR_IF_NO IS NOT NULL                              " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if(${s_exemption_yn} != 'A')" ).append("\n"); 
		query.append("   AND @[s_exemption_yn] =  (SELECT DECODE(G.AR_IF_NO, NULL, 'Y', 'N')" ).append("\n"); 
		query.append("                               FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("                             WHERE G.BKG_NO =  A.BKG_NO" ).append("\n"); 
		query.append("                               AND G.CNTR_NO = A.CNTR_NO  " ).append("\n"); 
		query.append("#if(${s_exemption_yn} == 'Y')" ).append("\n"); 
		query.append("                               AND NVL(G.DC_RMK, 'N') = 'Tariff Exemption'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_exemption_yn} == 'N')" ).append("\n"); 
		query.append("                               AND NVL(G.DC_RMK, 'N') <> 'Tariff Exemption'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                               AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                                                          FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                                                         WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                                                            AND C.CNTR_NO = G.CNTR_NO)  " ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${s_ar_if_yn} == 'Y')" ).append("\n"); 
		query.append("   AND EXISTS  (SELECT 'OK'" ).append("\n"); 
		query.append("                FROM DOD_DRP_OFF_CHG GG" ).append("\n"); 
		query.append("               WHERE GG.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                 AND GG.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("                 AND GG.AR_IF_NO IS NOT NULL" ).append("\n"); 
		query.append("                 AND GG.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                                             FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                                            WHERE C.BKG_NO = GG.BKG_NO" ).append("\n"); 
		query.append("                                              AND C.CNTR_NO = GG.CNTR_NO)) " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if(${s_ar_if_yn} == 'N')" ).append("\n"); 
		query.append("   AND EXISTS  (SELECT 'OK'" ).append("\n"); 
		query.append("                FROM DOD_DRP_OFF_CHG GG" ).append("\n"); 
		query.append("               WHERE GG.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                 AND GG.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("                 AND GG.AR_IF_NO IS NULL" ).append("\n"); 
		query.append("                 AND GG.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                                             FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                                            WHERE C.BKG_NO = GG.BKG_NO" ).append("\n"); 
		query.append("                                              AND C.CNTR_NO = GG.CNTR_NO)) " ).append("\n"); 
		query.append("   #end" ).append("\n"); 

	}
}