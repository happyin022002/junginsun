/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FACCommCalculationDBDAOSearchFACAGMTRateInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOSearchFACAGMTRateInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FACCommCalculationDBDAOSearchFACAGMTRateInfoRSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAOSearchFACAGMTRateInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.integration").append("\n"); 
		query.append("FileName : FACCommCalculationDBDAOSearchFACAGMTRateInfoRSQL").append("\n"); 
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
		query.append("  CASE AGM.FAC_OFC_CD" ).append("\n"); 
		query.append("  WHEN ARR.AR_OFC_CD" ).append("\n"); 
		query.append("  THEN 'AR'" ).append("\n"); 
		query.append("  ELSE 'PP'" ).append("\n"); 
		query.append("   END                                            AS OFC_ODR," ).append("\n"); 
		query.append("  CASE" ).append("\n"); 
		query.append("  WHEN ARR.CURR_CD = AGM.CURR_CD" ).append("\n"); 
		query.append("  THEN 'Y'" ).append("\n"); 
		query.append("  ELSE 'N'" ).append("\n"); 
		query.append("   END" ).append("\n"); 
		query.append("    ||" ).append("\n"); 
		query.append("  CASE --> SHIPPER" ).append("\n"); 
		query.append("  WHEN NVL (AGM.SHPR_CNT_CD, '*') = '*'" ).append("\n"); 
		query.append("  THEN 'N'" ).append("\n"); 
		query.append("  WHEN AGM.SHPR_CNT_CD   = ARR.SHPR_CNT_CD" ).append("\n"); 
		query.append("   AND AGM.SHPR_SEQ = ARR.SHPR_CUST_SEQ" ).append("\n"); 
		query.append("  THEN 'Y'" ).append("\n"); 
		query.append("  ELSE 'N'" ).append("\n"); 
		query.append("   END" ).append("\n"); 
		query.append("    ||" ).append("\n"); 
		query.append("  CASE --> SERVICE SCOPE" ).append("\n"); 
		query.append("  WHEN NVL (AGM.SVC_SCP_CD, '*') = '*'" ).append("\n"); 
		query.append("  THEN 'N'" ).append("\n"); 
		query.append("  WHEN AGM.SVC_SCP_CD   = ARR.SVC_SCP_CD" ).append("\n"); 
		query.append("  THEN 'Y'" ).append("\n"); 
		query.append("  ELSE 'N'" ).append("\n"); 
		query.append("   END" ).append("\n"); 
		query.append("    ||" ).append("\n"); 
		query.append("  CASE --> RECEIVE TERM" ).append("\n"); 
		query.append("  WHEN NVL (AGM.BKG_RCV_TERM_CD, '*') = '*'" ).append("\n"); 
		query.append("  THEN 'N'" ).append("\n"); 
		query.append("  WHEN AGM.BKG_RCV_TERM_CD   = ARR.RCV_TERM_CD" ).append("\n"); 
		query.append("  THEN 'Y'" ).append("\n"); 
		query.append("  ELSE 'N'" ).append("\n"); 
		query.append("   END" ).append("\n"); 
		query.append("    ||" ).append("\n"); 
		query.append("  CASE --> SERVICE CONTRACT" ).append("\n"); 
		query.append("  WHEN NVL (AGM.SC_NO, '*') = '*'" ).append("\n"); 
		query.append("  THEN 'N'" ).append("\n"); 
		query.append("  WHEN AGM.SC_NO   = ARR.SC_NO" ).append("\n"); 
		query.append("  THEN 'Y'" ).append("\n"); 
		query.append("  ELSE 'N'" ).append("\n"); 
		query.append("   END" ).append("\n"); 
		query.append("    ||" ).append("\n"); 
		query.append("  CASE --> RFA" ).append("\n"); 
		query.append("  WHEN NVL (AGM.RFA_NO, '*') = '*'" ).append("\n"); 
		query.append("  THEN 'N'" ).append("\n"); 
		query.append("  WHEN AGM.RFA_NO   = ARR.RFA_NO" ).append("\n"); 
		query.append("  THEN 'Y'" ).append("\n"); 
		query.append("  ELSE 'N'" ).append("\n"); 
		query.append("   END" ).append("\n"); 
		query.append("    ||" ).append("\n"); 
		query.append("  CASE" ).append("\n"); 
		query.append("  WHEN AGM.CMDT_TP_CD = '2'" ).append("\n"); 
		query.append("   AND AGM.CMDT_CD    = ARR.REP_CMDT_CD" ).append("\n"); 
		query.append("  THEN 'Y'" ).append("\n"); 
		query.append("  WHEN AGM.CMDT_TP_CD = '3'" ).append("\n"); 
		query.append("   AND AGM.CMDT_CD    = ARR.CMDT_CD" ).append("\n"); 
		query.append("  THEN 'Y'" ).append("\n"); 
		query.append("  ELSE 'N'" ).append("\n"); 
		query.append("   END" ).append("\n"); 
		query.append("    || NVL (AGM.FAC_DBL_FLG, 'N')" ).append("\n"); 
		query.append("    || NVL (AGM.FAC_SGL_FLG, 'N')" ).append("\n"); 
		query.append("    || NVL (AGM.POR_GRP_TP_CD, '*')" ).append("\n"); 
		query.append("    || NVL (AGM.POL_GRP_TP_CD, '*')" ).append("\n"); 
		query.append("    || NVL (AGM.POD_GRP_TP_CD, '*')" ).append("\n"); 
		query.append("    || NVL (AGM.DEL_GRP_TP_CD, '*')" ).append("\n"); 
		query.append("    || NVL (AGM.CMDT_TP_CD, '*')                  AS ODR," ).append("\n"); 
		query.append("	   ARR.BKG_NO," ).append("\n"); 
		query.append("       AGM.FF_CNT_CD, " ).append("\n"); 
		query.append("       TO_CHAR (AGM.FF_SEQ,'FM000000') AS FF_CUST_SEQ, " ).append("\n"); 
		query.append("       AGM.SHPR_CNT_CD, " ).append("\n"); 
		query.append("       TO_CHAR (AGM.SHPR_SEQ, 'FM000000')    AS SHPR_CUST_SEQ,  " ).append("\n"); 
		query.append("       AGM.FAC_DIV_CD, " ).append("\n"); 
		query.append("       --AGM.FAC_TP_CD, " ).append("\n"); 
		query.append("       NVL (AGM.FAC_BKG_RT, 0)                    AS FAC_BKG_RT,  " ).append("\n"); 
		query.append("	   NVL (AGM.FAC_BKG_AMT, 0)                    AS FAC_BKG_AMT," ).append("\n"); 
		query.append("       NVL (RTRIM (AGM.FAC_CHG_CTNT), 'X')        AS FAC_CHG_CTNT,  " ).append("\n"); 
		query.append("       NVL (AGM.FAC_BX_AMT, 0)                     AS FAC_BX_AMT, " ).append("\n"); 
		query.append("       NVL (AGM.FAC_TEU_AMT, 0)                    AS FAC_DRY_TEU_AMT, " ).append("\n"); 
		query.append("       NVL (AGM.FAC_FEU_AMT, 0)                    AS FAC_DRY_FEU_AMT, " ).append("\n"); 
		query.append("       NVL (AGM.FAC_RF_TEU_AMT, 0)                 AS FAC_RF_TEU_AMT, " ).append("\n"); 
		query.append("       NVL (AGM.FAC_RF_FEU_AMT, 0)                 AS FAC_RF_FEU_AMT,  " ).append("\n"); 
		query.append("       NVL (AGM.FAC_SGL_FLG, 'N')                 AS FAC_SGL_FLG, " ).append("\n"); 
		query.append("       --NVL (AGM.GRS_NET_DIV_CD, '*')              AS GRS_NET_DIV_CD, " ).append("\n"); 
		query.append("       NVL (AGM.FAC_SPCL_TEU_AMT, 0)               AS FAC_SPCL_TEU_AMT, " ).append("\n"); 
		query.append("       NVL (AGM.FAC_SPCL_FEU_AMT, 0)               AS FAC_SPCL_FEU_AMT,  " ).append("\n"); 
		query.append("       AGM.FAC_OFC_CD, " ).append("\n"); 
		query.append("       AGM.FAC_AGMT_SEQ," ).append("\n"); 
		query.append("       AGM.FAC_SPCL_CNTR_TP_CTNT1, " ).append("\n"); 
		query.append("       AGM.FAC_SPCL_CNTR_RT1, " ).append("\n"); 
		query.append("       AGM.FAC_SPCL_CNTR_TP_CTNT2, " ).append("\n"); 
		query.append("       AGM.FAC_SPCL_CNTR_RT2, " ).append("\n"); 
		query.append("       NVL (AGM.CURR_CD,'USD')                    AS CURR_CD, " ).append("\n"); 
		query.append("       AGM.POR_ROUT_CD " ).append("\n"); 
		query.append("    || AGM.POL_ROUT_CD " ).append("\n"); 
		query.append("    || AGM.POD_ROUT_CD " ).append("\n"); 
		query.append("    || AGM.DEL_ROUT_CD AS ROUT_CD" ).append("\n"); 
		query.append("  FROM ACM_FAC_AGMT AGM," ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("---------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("           SELECT" ).append("\n"); 
		query.append("                  BKG.BKG_NO," ).append("\n"); 
		query.append("                  BKG.SVC_SCP_CD," ).append("\n"); 
		query.append("                  BKG.RCV_TERM_CD," ).append("\n"); 
		query.append("                  BKG.DE_TERM_CD," ).append("\n"); 
		query.append("                  BKG.SC_NO," ).append("\n"); 
		query.append("                  BKG.RFA_NO," ).append("\n"); 
		query.append("                  BKG.CMDT_CD," ).append("\n"); 
		query.append("                  BKG.REP_CMDT_CD," ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("-- <APPLICATION DATE>" ).append("\n"); 
		query.append("-- 1. TRUNK의 출항일자를 구한다." ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                      SELECT /*+INDEX(VSK_VSL_PORT_SKD XPKVSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("                             TO_CHAR (SKD.VPS_ETD_DT,'YYYYMMDD') AS TRUNK_ETD_DT" ).append("\n"); 
		query.append("                        FROM VSK_VSL_PORT_SKD SKD," ).append("\n"); 
		query.append("                             BKG_VVD          VVD" ).append("\n"); 
		query.append("                       WHERE VVD.VSL_PRE_PST_CD             = 'T'" ).append("\n"); 
		query.append("                         AND SKD.VSL_CD                 = NVL (VVD.VSL_CD, '*')" ).append("\n"); 
		query.append("                         AND SKD.SKD_VOY_NO             = NVL (VVD.SKD_VOY_NO, '*')" ).append("\n"); 
		query.append("                         AND SKD.SKD_DIR_CD             = NVL (VVD.SKD_DIR_CD, '*')" ).append("\n"); 
		query.append("                         AND NVL (SKD.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("                         AND SKD.VPS_PORT_CD            = NVL (VVD.POL_CD, '*')" ).append("\n"); 
		query.append("                         AND SKD.VT_ADD_CALL_FLG IS NULL" ).append("\n"); 
		query.append("                         AND VVD.BKG_NO                     = BKG.BKG_NO" ).append("\n"); 
		query.append("                         AND ROWNUM                     = 1" ).append("\n"); 
		query.append("                ) AS TRUNK_ETD_DT," ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("-- POR, POL, POD, DEL의 정보를 서로 다른 경우의 수 1296개(6^4,6의 네제곱)의 배열로 생성한다." ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("             CASE ODR.POR_GRP_TP_CD" ).append("\n"); 
		query.append("             WHEN '1' THEN POR.CONTI_CD" ).append("\n"); 
		query.append("             WHEN '2' THEN POR.SCONTI_CD" ).append("\n"); 
		query.append("             WHEN '3' THEN POR.CNT_CD" ).append("\n"); 
		query.append("             WHEN '4' THEN POR.RGN_CD" ).append("\n"); 
		query.append("             WHEN '6' THEN POR.LOC_CD" ).append("\n"); 
		query.append("             ELSE '*'" ).append("\n"); 
		query.append("              END                                AS POR_ROUT_CD," ).append("\n"); 
		query.append("             CASE ODR.POL_GRP_TP_CD" ).append("\n"); 
		query.append("             WHEN '1' THEN POL.CONTI_CD" ).append("\n"); 
		query.append("             WHEN '2' THEN POL.SCONTI_CD" ).append("\n"); 
		query.append("             WHEN '3' THEN POL.CNT_CD" ).append("\n"); 
		query.append("             WHEN '4' THEN POL.RGN_CD" ).append("\n"); 
		query.append("             WHEN '6' THEN POL.LOC_CD" ).append("\n"); 
		query.append("             ELSE '*'" ).append("\n"); 
		query.append("              END                                AS POL_ROUT_CD," ).append("\n"); 
		query.append("             CASE ODR.POD_GRP_TP_CD" ).append("\n"); 
		query.append("             WHEN '1' THEN POD.CONTI_CD" ).append("\n"); 
		query.append("             WHEN '2' THEN POD.SCONTI_CD" ).append("\n"); 
		query.append("             WHEN '3' THEN POD.CNT_CD" ).append("\n"); 
		query.append("             WHEN '4' THEN POD.RGN_CD" ).append("\n"); 
		query.append("             WHEN '6' THEN POD.LOC_CD" ).append("\n"); 
		query.append("             ELSE '*'" ).append("\n"); 
		query.append("              END                                AS POD_ROUT_CD," ).append("\n"); 
		query.append("             CASE ODR.DEL_GRP_TP_CD" ).append("\n"); 
		query.append("             WHEN '1' THEN DEL.CONTI_CD" ).append("\n"); 
		query.append("             WHEN '2' THEN DEL.SCONTI_CD" ).append("\n"); 
		query.append("             WHEN '3' THEN DEL.CNT_CD" ).append("\n"); 
		query.append("             WHEN '4' THEN DEL.RGN_CD" ).append("\n"); 
		query.append("             WHEN '6' THEN DEL.LOC_CD" ).append("\n"); 
		query.append("             ELSE '*'" ).append("\n"); 
		query.append("              END                                AS DEL_ROUT_CD," ).append("\n"); 
		query.append("                  ODR.POR_GRP_TP_CD," ).append("\n"); 
		query.append("                  ODR.POL_GRP_TP_CD," ).append("\n"); 
		query.append("                  ODR.POD_GRP_TP_CD," ).append("\n"); 
		query.append("                  ODR.DEL_GRP_TP_CD," ).append("\n"); 
		query.append("             CASE" ).append("\n"); 
		query.append("             WHEN BKG.POR_CD   = BKG.POL_CD" ).append("\n"); 
		query.append("              AND BKG.POD_CD   = BKG.DEL_CD" ).append("\n"); 
		query.append("             THEN 'NN'" ).append("\n"); 
		query.append("             WHEN BKG.POR_CD  <> BKG.POL_CD" ).append("\n"); 
		query.append("              AND BKG.POD_CD  <> BKG.DEL_CD" ).append("\n"); 
		query.append("              AND NOT EXISTS" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                      SELECT" ).append("\n"); 
		query.append("                             'X'" ).append("\n"); 
		query.append("                        FROM BKG_CHG_RT CHG" ).append("\n"); 
		query.append("                       WHERE CHG.CHG_CD" ).append("\n"); 
		query.append("                          IN" ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                             'OIH', 'OAR', 'DIH', 'DAR'" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                         AND CHG.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                         AND CHG.BKG_NO               = BKG.BKG_NO" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("             THEN 'YY'" ).append("\n"); 
		query.append("             WHEN BKG.POD_CD <>  BKG.DEL_CD" ).append("\n"); 
		query.append("              AND NOT EXISTS" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                      SELECT" ).append("\n"); 
		query.append("                             'X'" ).append("\n"); 
		query.append("                        FROM BKG_CHG_RT CHG" ).append("\n"); 
		query.append("                       WHERE CHG.CHG_CD" ).append("\n"); 
		query.append("                          IN" ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                             'DIH', 'DAR'" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                         AND CHG.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                         AND CHG.BKG_NO               = BKG.BKG_NO" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("             THEN 'YN'" ).append("\n"); 
		query.append("             WHEN BKG.POR_CD <>  BKG.POL_CD" ).append("\n"); 
		query.append("              AND NOT EXISTS" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                      SELECT" ).append("\n"); 
		query.append("                             'X'" ).append("\n"); 
		query.append("                        FROM BKG_CHG_RT CHG" ).append("\n"); 
		query.append("                       WHERE CHG.CHG_CD" ).append("\n"); 
		query.append("                          IN" ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                             'OIH', 'OAR'" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                         AND CHG.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                         AND CHG.BKG_NO               = BKG.BKG_NO" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("             THEN 'YN'" ).append("\n"); 
		query.append("             ELSE 'NN'" ).append("\n"); 
		query.append("              END                                AS FAC_SGL_DBL_FLG," ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("-- NET/GROSS 구한다." ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("             CASE" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                      SELECT COUNT(DISTINCT CHG_CD) AS CNT" ).append("\n"); 
		query.append("                        FROM BKG_CHG_RT" ).append("\n"); 
		query.append("                       WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                         AND FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                         AND CHG_CD IN ('OFT')" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("             WHEN" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                      SELECT COUNT(DISTINCT CHG_CD) AS CNT" ).append("\n"); 
		query.append("                        FROM BKG_CHG_RT" ).append("\n"); 
		query.append("                       WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                         AND FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("             THEN 'Y'" ).append("\n"); 
		query.append("             ELSE 'N'" ).append("\n"); 
		query.append("              END                                               AS ALL_IN_RT_CD," ).append("\n"); 
		query.append("                  NVL (SHR.CUST_CNT_CD, '*')                    AS SHPR_CNT_CD," ).append("\n"); 
		query.append("                  NVL (TO_CHAR (SHR.CUST_SEQ, 'FM000000'), '*') AS SHPR_CUST_SEQ," ).append("\n"); 
		query.append("                  NVL (FDR.CUST_CNT_CD, '*')                    AS FF_CNT_CD," ).append("\n"); 
		query.append("                  NVL (TO_CHAR (FDR.CUST_SEQ, 'FM000000'), '*') AS FF_CUST_SEQ," ).append("\n"); 
		query.append("             CASE" ).append("\n"); 
		query.append("             WHEN EXISTS" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                      SELECT" ).append("\n"); 
		query.append("                             'X'" ).append("\n"); 
		query.append("                        FROM BKG_CHG_RT   CHG" ).append("\n"); 
		query.append("                       WHERE CHG.BKG_NO   = BKG.BKG_NO" ).append("\n"); 
		query.append("                         AND CHG.CHG_CD   = 'OFT'" ).append("\n"); 
		query.append("                         AND CHG.CURR_CD  = 'EUR'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("             THEN 'EUR'" ).append("\n"); 
		query.append("             ELSE 'USD'" ).append("\n"); 
		query.append("              END                                     AS CURR_CD," ).append("\n"); 
		query.append("                  @[bkg_ar_ofc_cd]                    AS AR_OFC_CD, --AR_OFC_CD---------------------- " ).append("\n"); 
		query.append("                  @[ofc_cd]                           AS PPD_OFC_CD --PPD_OFC_CD---------------------- " ).append("\n"); 
		query.append("             FROM BKG_BOOKING    BKG," ).append("\n"); 
		query.append("                  BKG_RATE       RAT," ).append("\n"); 
		query.append("                  BKG_CUSTOMER   FDR," ).append("\n"); 
		query.append("                  BKG_CUSTOMER   SHR," ).append("\n"); 
		query.append("                  MDM_LOCATION   POR," ).append("\n"); 
		query.append("                  MDM_LOCATION   POL," ).append("\n"); 
		query.append("                  MDM_LOCATION   POD," ).append("\n"); 
		query.append("                  MDM_LOCATION   DEL," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("-- POR, POL, POD, DEL의 정보를 서로 다른 경우의 수 1296개(6^4,6의 네제곱)의 배열로 생성한다." ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("                      SELECT" ).append("\n"); 
		query.append("                        CASE MOD (CEIL (ROWNUM/216)+1295, 6)" ).append("\n"); 
		query.append("                        WHEN 1 THEN '1'" ).append("\n"); 
		query.append("                        WHEN 2 THEN '2'" ).append("\n"); 
		query.append("                        WHEN 3 THEN '3'" ).append("\n"); 
		query.append("                        WHEN 4 THEN '4'" ).append("\n"); 
		query.append("                        WHEN 5 THEN '6'" ).append("\n"); 
		query.append("                        ELSE '*'" ).append("\n"); 
		query.append("                         END                                AS POR_GRP_TP_CD," ).append("\n"); 
		query.append("                        CASE MOD (CEIL (ROWNUM/36)+1295, 6)" ).append("\n"); 
		query.append("                        WHEN 1 THEN '1'" ).append("\n"); 
		query.append("                        WHEN 2 THEN '2'" ).append("\n"); 
		query.append("                        WHEN 3 THEN '3'" ).append("\n"); 
		query.append("                        WHEN 4 THEN '4'" ).append("\n"); 
		query.append("                        WHEN 5 THEN '6'" ).append("\n"); 
		query.append("                        ELSE '*'" ).append("\n"); 
		query.append("                         END                                AS POL_GRP_TP_CD," ).append("\n"); 
		query.append("                        CASE MOD (CEIL (ROWNUM/6 )+1295, 6)" ).append("\n"); 
		query.append("                        WHEN 1 THEN '1'" ).append("\n"); 
		query.append("                        WHEN 2 THEN '2'" ).append("\n"); 
		query.append("                        WHEN 3 THEN '3'" ).append("\n"); 
		query.append("                        WHEN 4 THEN '4'" ).append("\n"); 
		query.append("                        WHEN 5 THEN '6'" ).append("\n"); 
		query.append("                        ELSE '*'" ).append("\n"); 
		query.append("                         END                                AS POD_GRP_TP_CD," ).append("\n"); 
		query.append("                        CASE MOD (ROWNUM+1295, 6)" ).append("\n"); 
		query.append("                        WHEN 1 THEN '1'" ).append("\n"); 
		query.append("                        WHEN 2 THEN '2'" ).append("\n"); 
		query.append("                        WHEN 3 THEN '3'" ).append("\n"); 
		query.append("                        WHEN 4 THEN '4'" ).append("\n"); 
		query.append("                        WHEN 5 THEN '6'" ).append("\n"); 
		query.append("                        ELSE '*'" ).append("\n"); 
		query.append("                         END                                AS DEL_GRP_TP_CD" ).append("\n"); 
		query.append("                   FROM ALL_OBJECTS ODR" ).append("\n"); 
		query.append("                  WHERE ROWNUM <= 1296" ).append("\n"); 
		query.append("                ) ODR" ).append("\n"); 
		query.append("            WHERE BKG.BKG_NO             = @[bkg_no] --'DUS101173700'  " ).append("\n"); 
		query.append("              AND BKG.BKG_NO             = RAT.BKG_NO" ).append("\n"); 
		query.append("              AND POR.LOC_CD             = BKG.POR_CD" ).append("\n"); 
		query.append("              AND POL.LOC_CD             = BKG.POL_CD" ).append("\n"); 
		query.append("              AND POD.LOC_CD             = BKG.POD_CD" ).append("\n"); 
		query.append("              AND DEL.LOC_CD             = BKG.DEL_CD" ).append("\n"); 
		query.append("              AND BKG.BKG_NO             = FDR.BKG_NO (+)" ).append("\n"); 
		query.append("              AND BKG.BKG_NO             = SHR.BKG_NO (+)" ).append("\n"); 
		query.append("              AND FDR.BKG_CUST_TP_CD (+) = 'F'" ).append("\n"); 
		query.append("              AND SHR.BKG_CUST_TP_CD (+) = 'S'" ).append("\n"); 
		query.append("              AND POR.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("              AND POL.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("              AND POD.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("              AND DEL.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("---------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("     ) ARR" ).append("\n"); 
		query.append("---------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append(" WHERE AGM.FAC_STS_CD                = 'PS'" ).append("\n"); 
		query.append("   AND" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("       AGM.FAC_OFC_CD                    = ARR.AR_OFC_CD" ).append("\n"); 
		query.append("    OR AGM.FAC_OFC_CD                    = ARR.PPD_OFC_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("   AND AGM.FF_CNT_CD               = ARR.FF_CNT_CD " ).append("\n"); 
		query.append("   AND AGM.FF_SEQ" ).append("\n"); 
		query.append("    IN" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("       TO_NUMBER (999999)," ).append("\n"); 
		query.append("       TO_NUMBER (DECODE(ARR.FF_CUST_SEQ,'*','000000',ARR.FF_CUST_SEQ))" ).append("\n"); 
		query.append("     ) " ).append("\n"); 
		query.append("   AND NVL (AGM.POR_ROUT_CD, '*')        = ARR.POR_ROUT_CD" ).append("\n"); 
		query.append("   AND NVL (AGM.POR_GRP_TP_CD, '*')      = ARR.POR_GRP_TP_CD" ).append("\n"); 
		query.append("   AND NVL (AGM.POL_ROUT_CD, '*')        = ARR.POL_ROUT_CD" ).append("\n"); 
		query.append("   AND NVL (AGM.POL_GRP_TP_CD, '*')      = ARR.POL_GRP_TP_CD" ).append("\n"); 
		query.append("   AND NVL (AGM.POD_ROUT_CD, '*')        = ARR.POD_ROUT_CD" ).append("\n"); 
		query.append("   AND NVL (AGM.POD_GRP_TP_CD, '*')      = ARR.POD_GRP_TP_CD" ).append("\n"); 
		query.append("   AND NVL (AGM.DEL_ROUT_CD, '*')        = ARR.DEL_ROUT_CD" ).append("\n"); 
		query.append("   AND NVL (AGM.DEL_GRP_TP_CD, '*')      = ARR.DEL_GRP_TP_CD" ).append("\n"); 
		query.append("--> DATE FROM" ).append("\n"); 
		query.append("   AND ARR.TRUNK_ETD_DT" ).append("\n"); 
		query.append("   BETWEEN AGM.FM_EFF_DT" ).append("\n"); 
		query.append("   AND AGM.TO_EFF_DT" ).append("\n"); 
		query.append("--> DATE TO" ).append("\n"); 
		query.append("   AND ARR.TRUNK_ETD_DT" ).append("\n"); 
		query.append("   BETWEEN AGM.FM_EFF_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND AGM.TO_EFF_DT--> SHIPPER" ).append("\n"); 
		query.append("   AND NVL (AGM.SHPR_CNT_CD, '*')" ).append("\n"); 
		query.append("    IN" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("       '*', ARR.SHPR_CNT_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("   AND NVL (AGM.SHPR_SEQ, 0)" ).append("\n"); 
		query.append("    IN" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("       0, ARR.SHPR_CUST_SEQ" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("--> SERVICE SCOPE" ).append("\n"); 
		query.append("   AND NVL (AGM.SVC_SCP_CD, '*')" ).append("\n"); 
		query.append("    IN" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("       '*', ARR.SVC_SCP_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("--> RECEIVE TERM" ).append("\n"); 
		query.append("   AND NVL (AGM.BKG_RCV_TERM_CD, '*')" ).append("\n"); 
		query.append("    IN" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("       '*', ARR.RCV_TERM_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("--> DELIVERY TERM" ).append("\n"); 
		query.append("   AND NVL (AGM.BKG_DE_TERM_CD, '*')" ).append("\n"); 
		query.append("    IN" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("       '*', ARR.DE_TERM_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("--> SINGLE FACTOR " ).append("\n"); 
		query.append("   AND NVL (AGM.FAC_SGL_FLG, 'N') " ).append("\n"); 
		query.append("    IN " ).append("\n"); 
		query.append("     ( " ).append("\n"); 
		query.append("       'N', " ).append("\n"); 
		query.append("             CASE " ).append("\n"); 
		query.append("             WHEN FAC_SGL_DBL_FLG = 'YY' " ).append("\n"); 
		query.append("               OR FAC_SGL_DBL_FLG = 'YN' " ).append("\n"); 
		query.append("               OR FAC_SGL_DBL_FLG = 'NY' " ).append("\n"); 
		query.append("             THEN 'Y' " ).append("\n"); 
		query.append("              END " ).append("\n"); 
		query.append("     ) " ).append("\n"); 
		query.append("--> DOUBLE FACTOR " ).append("\n"); 
		query.append("   AND NVL (AGM.FAC_DBL_FLG, 'N') " ).append("\n"); 
		query.append("    IN " ).append("\n"); 
		query.append("     ( " ).append("\n"); 
		query.append("       'N', " ).append("\n"); 
		query.append("             CASE " ).append("\n"); 
		query.append("             WHEN FAC_SGL_DBL_FLG = 'YY' " ).append("\n"); 
		query.append("             THEN 'Y' " ).append("\n"); 
		query.append("              END " ).append("\n"); 
		query.append("     ) " ).append("\n"); 
		query.append("--> SERVICE CONTRACT" ).append("\n"); 
		query.append("   AND NVL (AGM.SC_NO, '*')" ).append("\n"); 
		query.append("    IN" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("       '*', ARR.SC_NO" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("--> RFA" ).append("\n"); 
		query.append("   AND NVL (AGM.RFA_NO, '*')" ).append("\n"); 
		query.append("    IN" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("       '*', ARR.RFA_NO" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("--> COMMODITY" ).append("\n"); 
		query.append("   AND NVL (AGM.CMDT_CD, '*')" ).append("\n"); 
		query.append("    IN" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("             CASE AGM.CMDT_TP_CD" ).append("\n"); 
		query.append("             WHEN '2'" ).append("\n"); 
		query.append("             THEN ARR.REP_CMDT_CD" ).append("\n"); 
		query.append("             WHEN '3'" ).append("\n"); 
		query.append("             THEN ARR.CMDT_CD" ).append("\n"); 
		query.append("             ELSE '*'" ).append("\n"); 
		query.append("              END" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("-->GROSS / NET DIVISION  'ALL IN RATE'" ).append("\n"); 
		query.append("   AND NVL (AGM.ALL_IN_RT_CD, 'N') = NVL (ARR.ALL_IN_RT_CD, 'N')" ).append("\n"); 
		query.append("ORDER BY 1 DESC, 5 ASC, 2 DESC" ).append("\n"); 

	}
}