/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CollectionSummaryDBDAOsearchCollectionSummaryByCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CollectionSummaryDBDAOsearchCollectionSummaryByCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 20160511 HongSeongPil 최초생성
	  * </pre>
	  */
	public CollectionSummaryDBDAOsearchCollectionSummaryByCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_type_N",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_type_C",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_type_S",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.integration").append("\n"); 
		query.append("FileName : CollectionSummaryDBDAOsearchCollectionSummaryByCustomerRSQL").append("\n"); 
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
		query.append("SELECT A.*" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("SELECT A.SC_NO," ).append("\n"); 
		query.append("       A.RFA_NO," ).append("\n"); 
		query.append("       B.CUST_CODE AS CUST_CD," ).append("\n"); 
		query.append("       B.CUST_NAME AS CUST_NM," ).append("\n"); 
		query.append("       B.CONTRACT_OFC AS REQ_OFC_CD," ).append("\n"); 
		query.append("       A.CFM_OFC_CD DOD_OFC_CD," ).append("\n"); 
		query.append("       A.LOC_CD," ).append("\n"); 
		query.append("       A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       A.CURR_CD," ).append("\n"); 
		query.append("       SUM(A.GEN_TRF_CNTR) GEN_TRF_CNTR," ).append("\n"); 
		query.append("       SUM(NVL(A.GEN_TRF_AMT,0)) GEN_TRF_AMT," ).append("\n"); 
		query.append("       SUM(A.SPC_TRF_CNTR) SPCL_TRF_CNTR," ).append("\n"); 
		query.append("       SUM(NVL(A.SPC_TRF_AMT,0)) SPCL_TRF_AMT," ).append("\n"); 
		query.append("       SUM(A.ADJ_CNTR) ADJUST_CNTR," ).append("\n"); 
		query.append("       SUM(NVL(A.ADJ_AMT,0)) ADJUST_AMT," ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("       #if(${ar_if} == 'N')" ).append("\n"); 
		query.append("         0 INVOICE_CNTR," ).append("\n"); 
		query.append("         0 INVOICE_AMT," ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if(${ar_if} != 'N')" ).append("\n"); 
		query.append("         SUM(A.INV_CNTR) INVOICE_CNTR," ).append("\n"); 
		query.append("         SUM(NVL(INV_AMT,0)) INVOICE_AMT," ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       SUM(DECODE(A.PEN_SPC_AMT, NULL, DECODE(A.PEN_GEN_AMT, NULL, 0, 1), 1)) PENDING_CNTR," ).append("\n"); 
		query.append("       SUM(DECODE(A.PEN_SPC_AMT, NULL, A.PEN_GEN_AMT, A.PEN_SPC_AMT))  PENDING_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT B.SC_NO," ).append("\n"); 
		query.append("           B.RFA_NO," ).append("\n"); 
		query.append("           E.CFM_OFC_CD" ).append("\n"); 
		query.append("           , SUBSTR(E.CNTR_RTN_YD_CD, 1, 5) LOC_CD" ).append("\n"); 
		query.append("           , E.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           , DECODE(@[curr_cd],'',E.CURR_CD,DECODE(@[curr_cd],'LOC',E.CURR_CD,@[curr_cd])) CURR_CD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("           #if(${ar_if} == 'A')" ).append("\n"); 
		query.append("             , (SELECT DECODE(NVL(G.DRP_OFF_CHG_TRF_SEQ, 0), 0, 0, 1)" ).append("\n"); 
		query.append("                 FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("                WHERE G.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                 AND G.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("                 AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                        FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                       WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                         AND C.CNTR_NO = G.CNTR_NO) ) GEN_TRF_CNTR" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${ar_if} == 'Y')" ).append("\n"); 
		query.append("             , (SELECT DECODE(NVL(G.DRP_OFF_CHG_TRF_SEQ, 0), 0, 0, 1)" ).append("\n"); 
		query.append("                 FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("                WHERE G.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                 AND G.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NOT NULL" ).append("\n"); 
		query.append("                 AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                        FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                       WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                         AND C.CNTR_NO = G.CNTR_NO) ) GEN_TRF_CNTR" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${ar_if} == 'N')" ).append("\n"); 
		query.append("             , (SELECT DECODE(NVL(G.DRP_OFF_CHG_TRF_SEQ, 0), 0, 0, 1)" ).append("\n"); 
		query.append("                 FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("                WHERE G.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                 AND G.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NULL" ).append("\n"); 
		query.append("                 AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                        FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                       WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                         AND C.CNTR_NO = G.CNTR_NO) ) GEN_TRF_CNTR" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("           , ROUND(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(E.CFM_DT,'YYYYMM'), E.CURR_CD, DECODE(@[curr_cd],'LOC',E.CURR_CD,@[curr_cd])," ).append("\n"); 
		query.append("             (SELECT CASE WHEN DECODE(G.DRP_OFF_CHG_TRF_SPCL_SEQ, NULL, G.GEN_TRF_AMT, 0) > 0 THEN G.GEN_TRF_AMT" ).append("\n"); 
		query.append("                          WHEN DECODE(G.DRP_OFF_CHG_TRF_SPCL_SEQ, NULL, G.GEN_TRF_AMT, 0) < 0 THEN 0" ).append("\n"); 
		query.append("                          ELSE 0" ).append("\n"); 
		query.append("                          END END" ).append("\n"); 
		query.append("                FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("               WHERE G.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                 AND G.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if(${ar_if} == 'Y')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NOT NULL" ).append("\n"); 
		query.append("           #end   " ).append("\n"); 
		query.append("           #if(${ar_if} == 'N')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NULL" ).append("\n"); 
		query.append("           #end     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                        FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                       WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                         AND C.CNTR_NO = G.CNTR_NO) )), 2) GEN_TRF_AMT" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("         , (SELECT DECODE(NVL(G.DRP_OFF_CHG_TRF_SPCL_SEQ, 0), 0, 0, 1)" ).append("\n"); 
		query.append("                FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("               WHERE G.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                 AND G.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if(${ar_if} == 'Y')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NOT NULL" ).append("\n"); 
		query.append("           #end   " ).append("\n"); 
		query.append("           #if(${ar_if} == 'N')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NULL" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                        FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                       WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                         AND C.CNTR_NO = G.CNTR_NO) ) SPC_TRF_CNTR" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("           , ROUND(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(E.CFM_DT,'YYYYMM'), E.CURR_CD, DECODE(@[curr_cd],'LOC',E.CURR_CD,@[curr_cd])," ).append("\n"); 
		query.append("             (SELECT CASE WHEN DECODE(G.DRP_OFF_CHG_TRF_SPCL_SEQ, NULL, 0, G.SPCL_TRF_AMT) > 0 THEN G.SPCL_TRF_AMT" ).append("\n"); 
		query.append("                          WHEN DECODE(G.DRP_OFF_CHG_TRF_SPCL_SEQ, NULL, 0, G.SPCL_TRF_AMT) < 0 THEN 0" ).append("\n"); 
		query.append("                          ELSE 0" ).append("\n"); 
		query.append("                          END END" ).append("\n"); 
		query.append("                FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("               WHERE G.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                 AND G.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if(${ar_if} == 'Y')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NOT NULL" ).append("\n"); 
		query.append("            #end   " ).append("\n"); 
		query.append("            #if(${ar_if} == 'N')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NULL" ).append("\n"); 
		query.append("            #end     " ).append("\n"); 
		query.append("                 AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                        FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                       WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                         AND C.CNTR_NO = G.CNTR_NO) )), 2) SPC_TRF_AMT" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("           , (SELECT DECODE(NVL((-G.DC_AMT + G.SVC_FEE_AMT)*-1, 0), 0, 0, 1)" ).append("\n"); 
		query.append("                FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("               WHERE G.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                 AND G.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if(${ar_if} == 'Y')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NOT NULL" ).append("\n"); 
		query.append("           #end   " ).append("\n"); 
		query.append("           #if(${ar_if} == 'N')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NULL" ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                        FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                       WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                         AND C.CNTR_NO = G.CNTR_NO) ) ADJ_CNTR" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("           , ROUND(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(E.CFM_DT,'YYYYMM'), E.CURR_CD, DECODE(@[curr_cd],'LOC',E.CURR_CD,@[curr_cd])," ).append("\n"); 
		query.append("             (SELECT ROUND( (-G.DC_AMT + G.SVC_FEE_AMT)*-1, 2)" ).append("\n"); 
		query.append("                FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("               WHERE G.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                 AND G.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if(${ar_if} == 'Y')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NOT NULL" ).append("\n"); 
		query.append("           #end   " ).append("\n"); 
		query.append("           #if(${ar_if} == 'N')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NULL" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                        FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                       WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                         AND C.CNTR_NO = G.CNTR_NO) )), 2) ADJ_AMT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , (SELECT 1" ).append("\n"); 
		query.append("                FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("               WHERE G.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                 AND G.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if(${ar_if} != 'N')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NOT NULL" ).append("\n"); 
		query.append("           #end   " ).append("\n"); 
		query.append("           #if(${ar_if} == 'N')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NULL" ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                        FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                       WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                         AND C.CNTR_NO = G.CNTR_NO) ) INV_CNTR" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("           , ROUND(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(E.CFM_DT,'YYYYMM'), E.CURR_CD, DECODE(@[curr_cd],'LOC',E.CURR_CD,@[curr_cd])," ).append("\n"); 
		query.append("             (SELECT CASE WHEN G.TTL_AMT > 0 AND G.AR_IF_NO IS NOT NULL THEN G.TTL_AMT" ).append("\n"); 
		query.append("                          WHEN G.TTL_AMT < 0 THEN 0" ).append("\n"); 
		query.append("                          ELSE 0" ).append("\n"); 
		query.append("                          END END" ).append("\n"); 
		query.append("                FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("               WHERE G.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                 AND G.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if(${ar_if} != 'N')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NOT NULL" ).append("\n"); 
		query.append("           #end   " ).append("\n"); 
		query.append("           #if(${ar_if} == 'N')" ).append("\n"); 
		query.append("                 AND G.AR_IF_NO IS NULL" ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                        FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                       WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                         AND C.CNTR_NO = G.CNTR_NO) )), 2) INV_AMT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("             , ROUND(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(E.CFM_DT,'YYYYMM'), E.CURR_CD, DECODE(@[curr_cd],'LOC',E.CURR_CD,@[curr_cd])," ).append("\n"); 
		query.append("               (SELECT D.DRP_OFF_CHG_TRF_AMT" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                   AND D.CNTR_RTN_LOC_CD = SUBSTR(E.CNTR_RTN_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                   AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(E.CNTR_RTN_YD_CD, 6, 2))" ).append("\n"); 
		query.append("                   AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                   AND D.CNTR_TPSZ_CD = E.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_DIV_CD = 'S'" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("                   AND DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', D.SPCL_CUST_CNT_CD) = DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', B.AGMT_ACT_CNT_CD)" ).append("\n"); 
		query.append("                   AND DECODE(D.SPCL_CUST_SEQ, NULL, 1, D.SPCL_CUST_SEQ) = DECODE(D.SPCL_CUST_SEQ, NULL, 1, B.AGMT_ACT_CUST_SEQ)" ).append("\n"); 
		query.append("                   AND DECODE(D.SC_NO, NULL, D.RFA_NO, D.SC_NO) = DECODE(D.SC_NO, NULL, B.RFA_NO, B.SC_NO)" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                   AND NVL(D.DEL_CD||D.CNTR_RTN_YD_SFX_CD, 1) = " ).append("\n"); 
		query.append("                     (SELECT NVL(MAX(D.DEL_CD)||MAX(D.CNTR_RTN_YD_SFX_CD), 1)" ).append("\n"); 
		query.append("                        FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                         WHERE 1 = 1" ).append("\n"); 
		query.append("                           AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                           AND D.CNTR_RTN_LOC_CD = SUBSTR(E.CNTR_RTN_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                           AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(E.CNTR_RTN_YD_CD, 6, 2))" ).append("\n"); 
		query.append("                           AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                           AND D.CNTR_TPSZ_CD = E.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                           AND D.DRP_OFF_CHG_TRF_DIV_CD = 'S'" ).append("\n"); 
		query.append("                           AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                           AND D.DRP_OFF_CHG_TRF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("                           AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("                           AND DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', D.SPCL_CUST_CNT_CD) = DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', B.AGMT_ACT_CNT_CD)" ).append("\n"); 
		query.append("                           AND DECODE(D.SPCL_CUST_SEQ, NULL, 1, D.SPCL_CUST_SEQ) = DECODE(D.SPCL_CUST_SEQ, NULL, 1, B.AGMT_ACT_CUST_SEQ)" ).append("\n"); 
		query.append("                           AND DECODE(D.SC_NO, NULL, D.RFA_NO, D.SC_NO) = DECODE(D.SC_NO, NULL, B.RFA_NO, B.SC_NO)" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                          AND NVL(D.SPCL_CUST_CNT_CD||D.SPCL_CUST_SEQ, 1) = " ).append("\n"); 
		query.append("                              (SELECT NVL(MAX(D.SPCL_CUST_CNT_CD||D.SPCL_CUST_SEQ), 1)" ).append("\n"); 
		query.append("                                FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                               WHERE 1 = 1" ).append("\n"); 
		query.append("                                 AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                                 AND D.CNTR_RTN_LOC_CD = SUBSTR(E.CNTR_RTN_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                                 AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(E.CNTR_RTN_YD_CD, 6, 2))" ).append("\n"); 
		query.append("                                 AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                                 AND D.CNTR_TPSZ_CD = E.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                 AND D.DRP_OFF_CHG_TRF_DIV_CD = 'S'" ).append("\n"); 
		query.append("                                 AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                                 AND D.DRP_OFF_CHG_TRF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("                                 AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("                                 AND DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', D.SPCL_CUST_CNT_CD) = DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', B.AGMT_ACT_CNT_CD)" ).append("\n"); 
		query.append("                                 AND DECODE(D.SPCL_CUST_SEQ, NULL, 1, D.SPCL_CUST_SEQ) = DECODE(D.SPCL_CUST_SEQ, NULL, 1, B.AGMT_ACT_CUST_SEQ)" ).append("\n"); 
		query.append("                                 AND DECODE(D.SC_NO, NULL, D.RFA_NO, D.SC_NO) = DECODE(D.SC_NO, NULL, B.RFA_NO, B.SC_NO)         " ).append("\n"); 
		query.append("                                 )   " ).append("\n"); 
		query.append("                           AND NOT EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("                                          FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("                                         WHERE G.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                                           AND G.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("                                           )      " ).append("\n"); 
		query.append("            )), 2) PEN_SPC_AMT" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            ,ROUND(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(E.CFM_DT,'YYYYMM'), E.CURR_CD, DECODE(@[curr_cd],'LOC',E.CURR_CD,@[curr_cd])," ).append("\n"); 
		query.append("            ( SELECT D.DRP_OFF_CHG_TRF_AMT" ).append("\n"); 
		query.append("                FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("               WHERE 1 = 1" ).append("\n"); 
		query.append("                 AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                 AND D.CNTR_RTN_LOC_CD = SUBSTR(E.CNTR_RTN_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                 AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(E.CNTR_RTN_YD_CD, 6, 2))" ).append("\n"); 
		query.append("                 AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                 AND D.CNTR_TPSZ_CD = E.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                 AND D.DRP_OFF_CHG_TRF_DIV_CD = 'G'" ).append("\n"); 
		query.append("                 AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                 AND D.DRP_OFF_CHG_TRF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("                 AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                  AND NVL(D.DEL_CD||D.CNTR_RTN_YD_SFX_CD, 1) = " ).append("\n"); 
		query.append("                       (SELECT NVL(MAX(D.DEL_CD)||MAX(D.CNTR_RTN_YD_SFX_CD), 1)" ).append("\n"); 
		query.append("                         FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                            WHERE 1 = 1" ).append("\n"); 
		query.append("                         AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                              AND D.CNTR_RTN_LOC_CD = SUBSTR(E.CNTR_RTN_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                              AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(E.CNTR_RTN_YD_CD, 6, 2))" ).append("\n"); 
		query.append("                              AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                              AND D.CNTR_TPSZ_CD = E.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                              AND D.DRP_OFF_CHG_TRF_DIV_CD = 'G'" ).append("\n"); 
		query.append("                              AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                              AND D.DRP_OFF_CHG_TRF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("                              AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                 AND NOT EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("                                    FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("                                   WHERE G.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                                     AND G.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("                                 )     " ).append("\n"); 
		query.append("              )), 2) PEN_GEN_AMT" ).append("\n"); 
		query.append("    FROM BKG_EUR_TRO E" ).append("\n"); 
		query.append("       , BKG_BOOKING B" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("     AND E.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("     AND E.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("     AND E.HLG_TP_CD = 'M'" ).append("\n"); 
		query.append("     AND SUBSTR(E.CNTR_RTN_YD_CD, 1, 5) <> B.DEL_CD" ).append("\n"); 
		query.append("     AND E.CXL_FLG = 'N'" ).append("\n"); 
		query.append("     AND E.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("     AND E.TRO_SEQ = (SELECT MAX(TT.TRO_SEQ)" ).append("\n"); 
		query.append("                               FROM BKG_EUR_TRO TT" ).append("\n"); 
		query.append("                              WHERE TT.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                                AND TT.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("                                AND TT.IO_BND_CD = 'I') " ).append("\n"); 
		query.append("#if (${period} == 'W') " ).append("\n"); 
		query.append("     AND E.CFM_DT BETWEEN (SELECT TO_DATE(K.WK_ST_DT,'YYYYMMDD') + .0" ).append("\n"); 
		query.append("						   FROM   EQR_WK_PRD K" ).append("\n"); 
		query.append("						   WHERE  K.PLN_YR||K.PLN_WK = @[from]" ).append("\n"); 
		query.append("						  )	AND" ).append("\n"); 
		query.append("						  (SELECT TO_DATE(K.WK_END_DT,'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("						   FROM   EQR_WK_PRD K" ).append("\n"); 
		query.append("						   WHERE  K.PLN_YR||K.PLN_WK = @[to]" ).append("\n"); 
		query.append("						  ) " ).append("\n"); 
		query.append("#elseif (${period} == 'D' || ${period} == 'M') " ).append("\n"); 
		query.append("     AND E.CFM_DT BETWEEN TO_DATE( @[from], 'YYYYMMDD') + .0 AND TO_DATE( @[to], 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${tpsz} != '')" ).append("\n"); 
		query.append("     AND E.CNTR_TPSZ_CD IN (SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                            FROM   CIM_TP_SZ_DP_SEQ S" ).append("\n"); 
		query.append("                            WHERE  S.CNTR_TPSZ_DIV_CD = DECODE(@[tpsz],'A', S.CNTR_TPSZ_DIV_CD, @[tpsz] ))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" -- AR I/F 조건" ).append("\n"); 
		query.append("   #if(${ar_if} == 'Y')" ).append("\n"); 
		query.append("    AND EXISTS  (SELECT 'OK'" ).append("\n"); 
		query.append("                FROM DOD_DRP_OFF_CHG GG" ).append("\n"); 
		query.append("               WHERE GG.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                 AND GG.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("                 AND GG.AR_IF_NO IS NOT NULL" ).append("\n"); 
		query.append("                 AND GG.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                                             FROM DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                                            WHERE C.BKG_NO = GG.BKG_NO" ).append("\n"); 
		query.append("                                              AND C.CNTR_NO = GG.CNTR_NO)) " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${office} != '')" ).append("\n"); 
		query.append("	#if (${ofc_flg} == 'O')" ).append("\n"); 
		query.append("    AND   E.CFM_OFC_CD IN (" ).append("\n"); 
		query.append("        #foreach( $an_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $ofc_cd_list.size()) '$an_ofc', #else '$an_ofc' #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("	#elseif (${ofc_flg} == 'R' && ${ofc_cd} != 'All')" ).append("\n"); 
		query.append("    AND @[office] =  (SELECT  DISTINCT OFC_CD     -- 인자값" ).append("\n"); 
		query.append("                        FROM  MDM_ORGANIZATION" ).append("\n"); 
		query.append("                       WHERE  1 = 1" ).append("\n"); 
		query.append("                         AND  OFC_KND_CD = '2'" ).append("\n"); 
		query.append("                         AND  PRNT_OFC_CD = 'SELDC'" ).append("\n"); 
		query.append("                      START WITH OFC_CD = E.CFM_OFC_CD" ).append("\n"); 
		query.append("                      CONNECT BY PRIOR PRNT_OFC_CD = OFC_CD)" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${rtn_loc_cd} != '')" ).append("\n"); 
		query.append("     AND E.CNTR_RTN_YD_CD LIKE @[rtn_loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("#if(${sch_flg} == 'SC')" ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("	SELECT	SPH.SC_NO,  " ).append("\n"); 
		query.append("			SCP.CUST_CNT_CD || LPAD(SCP.CUST_SEQ, 6, '0') AS CUST_CODE,  " ).append("\n"); 
		query.append("			SC.PROP_OFC_CD AS CONTRACT_OFC,  " ).append("\n"); 
		query.append("			SCP.CTRT_PTY_NM AS CUST_NAME " ).append("\n"); 
		query.append("       FROM	PRI_SP_HDR SPH,  " ).append("\n"); 
		query.append("         	PRI_SP_MN SC,  " ).append("\n"); 
		query.append("            PRI_SP_CTRT_PTY SCP " ).append("\n"); 
		query.append("      WHERE	SPH.PROP_NO = SC.PROP_NO " ).append("\n"); 
		query.append("        AND	SCP.PROP_NO = SPH.PROP_NO " ).append("\n"); 
		query.append("        AND	SC.AMDT_SEQ = SCP.AMDT_SEQ " ).append("\n"); 
		query.append("        AND	SCP.PRC_CTRT_PTY_TP_CD = 'C' " ).append("\n"); 
		query.append("        AND	SC.AMDT_SEQ = (	SELECT MAX (AMDT_SEQ) " ).append("\n"); 
		query.append("                              FROM PRI_SP_MN " ).append("\n"); 
		query.append("                             WHERE PROP_NO = SPH.PROP_NO " ).append("\n"); 
		query.append("                               AND ROWNUM <= 1) " ).append("\n"); 
		query.append("	#if (${sch_flg} == 'SC' && ${sc_rfa_no} != '')  " ).append("\n"); 
		query.append("		AND SPH.SC_NO	IN ( " ).append("\n"); 
		query.append("									#foreach( $sc_cd in ${sc_rfa_cd_list} ) " ).append("\n"); 
		query.append("										#if($velocityCount < $sc_rfa_cd_list.size()) '$sc_cd', #else '$sc_cd' #end " ).append("\n"); 
		query.append("									#end " ).append("\n"); 
		query.append("							) " ).append("\n"); 
		query.append("	#elseif (${sch_flg} == 'RFA' && ${sc_rfa_no} != '')" ).append("\n"); 
		query.append("		AND 1=2" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${ctrt_ofc} != '')" ).append("\n"); 
		query.append("		AND SC.PROP_OFC_CD	= @[ctrt_ofc]	 " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_flg} == 'CUST' && ${cust_cd} != '') " ).append("\n"); 
		query.append("        AND SCP.CUST_CNT_CD = SUBSTR(@[cust_cd], 1, 2) " ).append("\n"); 
		query.append("        AND SCP.CUST_SEQ	= SUBSTR(@[cust_cd], 3) " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_flg} == 'BKG' && ${cust_cd} != '')" ).append("\n"); 
		query.append("		AND SPH.SC_NO IN ( SELECT DISTINCT RR.SC_NO FROM BKG_CUSTOMER BC, DMT_CHG_BKG_CNTR RR" ).append("\n"); 
		query.append("              				WHERE 1=1" ).append("\n"); 
		query.append("                			  and BC.bkg_no = RR.bkg_no" ).append("\n"); 
		query.append("                			  and BC.CUST_CNT_CD = SUBSTR(@[cust_cd], 1, 2) AND BC.CUST_SEQ	= SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("		#if (${cust_type_A} != '')" ).append("\n"); 
		query.append("							  and BC.BKG_CUST_TP_CD IN ( 'S','C','N' )" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("							  and BC.BKG_CUST_TP_CD IN ( NVL(@[cust_type_S],' '), NVL(@[cust_type_C],' '), NVL(@[cust_type_N],' ') )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("						 ) " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE  A.SC_NO = B.SC_NO" ).append("\n"); 
		query.append("#elseif(${sch_flg} == 'RFA')" ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("     SELECT	RFH.RFA_NO,  " ).append("\n"); 
		query.append("            CTRT_CUST_CNT_CD || LPAD(CTRT_CUST_SEQ, 6, '0') AS CUST_CODE,  " ).append("\n"); 
		query.append("            PROP_OFC_CD AS CONTRACT_OFC," ).append("\n"); 
		query.append("            (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = RFA.CTRT_CUST_CNT_CD AND CUST_SEQ = RFA.CTRT_CUST_SEQ) AS CUST_NAME " ).append("\n"); 
		query.append("       FROM	PRI_RP_HDR RFH,  " ).append("\n"); 
		query.append("            PRI_RP_MN RFA " ).append("\n"); 
		query.append("      WHERE RFA.PROP_NO = RFH.PROP_NO " ).append("\n"); 
		query.append("        AND RFA.AMDT_SEQ = (SELECT MAX (AMDT_SEQ) " ).append("\n"); 
		query.append("                              FROM PRI_RP_MN " ).append("\n"); 
		query.append("                             WHERE PROP_NO = RFH.PROP_NO " ).append("\n"); 
		query.append("                               AND ROWNUM <= 1) " ).append("\n"); 
		query.append("	#if (${sch_flg} == 'RFA' && ${sc_rfa_no} != '')  " ).append("\n"); 
		query.append("		AND RFH.RFA_NO	IN ( " ).append("\n"); 
		query.append("									#foreach( $rfa_cd in ${sc_rfa_cd_list} ) " ).append("\n"); 
		query.append("										#if($velocityCount < $sc_rfa_cd_list.size()) '$rfa_cd', #else '$rfa_cd' #end " ).append("\n"); 
		query.append("									#end " ).append("\n"); 
		query.append("							) " ).append("\n"); 
		query.append("	#elseif (${sch_flg} == 'SC' && ${sc_rfa_no} != '')" ).append("\n"); 
		query.append("				AND 1=2" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${ctrt_ofc} != '')" ).append("\n"); 
		query.append("				AND RFA.PROP_OFC_CD   = @[ctrt_ofc] " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_flg} == 'CUST' && ${cust_cd} != '')" ).append("\n"); 
		query.append("		AND RFA.CTRT_CUST_CNT_CD = SUBSTR(@[cust_cd], 1, 2) " ).append("\n"); 
		query.append("		AND RFA.CTRT_CUST_SEQ	= SUBSTR(@[cust_cd], 3)    " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_flg} == 'BKG' && ${cust_cd} != '')" ).append("\n"); 
		query.append("		AND RFH.RFA_NO IN ( SELECT DISTINCT RR.RFA_NO FROM BKG_CUSTOMER BC, DMT_CHG_BKG_CNTR RR" ).append("\n"); 
		query.append("              				 WHERE 1=1" ).append("\n"); 
		query.append("                			   and BC.bkg_no = RR.bkg_no" ).append("\n"); 
		query.append("                			   and BC.CUST_CNT_CD = SUBSTR(@[cust_cd], 1, 2) AND BC.CUST_SEQ	= SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("		#if (${cust_type_A} != '')" ).append("\n"); 
		query.append("							   and BC.BKG_CUST_TP_CD IN ( 'S','C','N' )" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("							   and BC.BKG_CUST_TP_CD IN ( NVL(@[cust_type_S],' '), NVL(@[cust_type_C],' '), NVL(@[cust_type_N],' ') )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("			               ) " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE  A.RFA_NO = B.RFA_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.SC_NO," ).append("\n"); 
		query.append("         A.RFA_NO," ).append("\n"); 
		query.append("         B.CUST_CODE," ).append("\n"); 
		query.append("         B.CUST_NAME," ).append("\n"); 
		query.append("         B.CONTRACT_OFC," ).append("\n"); 
		query.append("         A.CFM_OFC_CD," ).append("\n"); 
		query.append("         A.LOC_CD," ).append("\n"); 
		query.append("         A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("         A.CURR_CD" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("#if(${ar_if} == 'N')" ).append("\n"); 
		query.append("WHERE PENDING_CNTR  > 0 " ).append("\n"); 
		query.append(" OR GEN_TRF_CNTR > 0" ).append("\n"); 
		query.append(" OR SPCL_TRF_CNTR > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ar_if} == 'A')" ).append("\n"); 
		query.append("WHERE PENDING_CNTR  > 0 " ).append("\n"); 
		query.append(" OR GEN_TRF_CNTR > 0" ).append("\n"); 
		query.append(" OR SPCL_TRF_CNTR > 0" ).append("\n"); 
		query.append(" OR INVOICE_CNTR > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}