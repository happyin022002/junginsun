/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationDBDAOSearchCalcFACCommDRInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOSearchCalcFACCommDRInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FACCommCalculationDBDAOSearchCalcFACCommDRInfoRSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAOSearchCalcFACCommDRInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration").append("\n"); 
		query.append("FileName : FACCommCalculationDBDAOSearchCalcFACCommDRInfoRSQL").append("\n"); 
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
		query.append("       NVL (ROUND (SUM ((AMT.AMT + NVL (PCA.PC_AMT, 0)) * (RAT.RATE / 100)), 2), 0) AS ACT_COMM_AMT" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("           SELECT" ).append("\n"); 
		query.append("                  BCR.CHG_CD," ).append("\n"); 
		query.append("                  SUBSTR (CTP.CNTR_TP, 1, 1)         AS CHG_TP," ).append("\n"); 
		query.append("                  NVL" ).append("\n"); 
		query.append("                ( SUM" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("             CASE" ).append("\n"); 
		query.append("             WHEN XCH.CURR_CD = 'USD'" ).append("\n"); 
		query.append("             THEN BCR.CHG_AMT" ).append("\n"); 
		query.append("             WHEN NVL (XCH.USD_LOCL_XCH_RT, 0) = 0" ).append("\n"); 
		query.append("             THEN 0" ).append("\n"); 
		query.append("             ELSE BCR.CHG_AMT / XCH.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("              END" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                , 0" ).append("\n"); 
		query.append("                )                                    AS AMT" ).append("\n"); 
		query.append("             FROM BKG_CHG_RT    BCR," ).append("\n"); 
		query.append("                  GL_MON_XCH_RT XCH," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                      SELECT" ).append("\n"); 
		query.append("                             MAX (BKG.BKG_NO) AS BKG_NO," ).append("\n"); 
		query.append("                             QTY.CNTR_TPSZ_CD AS CNTR_TP" ).append("\n"); 
		query.append("                        FROM BKG_QUANTITY   QTY," ).append("\n"); 
		query.append("                             BKG_BL_DOC     DOC," ).append("\n"); 
		query.append("                             BKG_BOOKING    BKG," ).append("\n"); 
		query.append("                             BKG_BOOKING    BK2," ).append("\n"); 
		query.append("                             MDM_CNTR_TP_SZ TPS" ).append("\n"); 
		query.append("                       WHERE QTY.BKG_NO                  = DOC.BKG_NO" ).append("\n"); 
		query.append("                         AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                         AND QTY.CNTR_TPSZ_CD            = TPS.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("                         AND" ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                             BKG.BKG_NO                  = DOC.BKG_NO" ).append("\n"); 
		query.append("                          OR" ).append("\n"); 
		query.append("                             BKG.BL_NO                   = DOC.MST_CVRD_BL_NO" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                         AND BK2.BKG_NO                  = DOC.BKG_NO" ).append("\n"); 
		query.append("                         AND BK2.BL_NO_TP              <>  '9'" ).append("\n"); 
		query.append("                         AND BK2.BKG_STS_CD            <>  'X'" ).append("\n"); 
		query.append("                         AND BKG.BKG_NO                  = @[bkg_no] --'DUS101173700' " ).append("\n"); 
		query.append("                    GROUP BY QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                ) CTP" ).append("\n"); 
		query.append("            WHERE BCR.BKG_NO                = CTP.BKG_NO" ).append("\n"); 
		query.append("              AND BCR.FRT_INCL_XCLD_DIV_CD  = 'N'" ).append("\n"); 
		query.append("              AND BCR.RAT_UT_CD            != 'PC'" ).append("\n"); 
		query.append("              AND BCR.RAT_UT_CD             = CTP.CNTR_TP" ).append("\n"); 
		query.append("#if (${fac_chg_ctnt_div} != '') " ).append("\n"); 
		query.append("              AND BCR.CHG_CD IN ( ${fac_chg_ctnt_div} ) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              AND XCH.CURR_CD           (+) = BCR.CURR_CD" ).append("\n"); 
		query.append("              AND XCH.ACCT_XCH_RT_YRMON (+) = SUBSTR(@[vps_etd_dt], 1, 6) ----vps_etd_dt" ).append("\n"); 
		query.append("              AND XCH.ACCT_XCH_RT_LVL   (+)   = '1'" ).append("\n"); 
		query.append("         GROUP BY BCR.CHG_CD," ).append("\n"); 
		query.append("                  SUBSTR (CTP.CNTR_TP, 1, 1)" ).append("\n"); 
		query.append("     ) AMT," ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("           SELECT" ).append("\n"); 
		query.append("                  CHG_TP," ).append("\n"); 
		query.append("                  OFT_AMT * PC_RATE_AS AS PC_AMT" ).append("\n"); 
		query.append("             FROM" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                      SELECT" ).append("\n"); 
		query.append("                             BCR.CHG_CD                 AS OFT," ).append("\n"); 
		query.append("                             SUBSTR (CTP.CNTR_TP, 1, 1) AS CHG_TP," ).append("\n"); 
		query.append("                             NVL" ).append("\n"); 
		query.append("                           ( SUM" ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                        CASE" ).append("\n"); 
		query.append("                        WHEN XCH.CURR_CD = 'USD'" ).append("\n"); 
		query.append("                        THEN BCR.CHG_AMT" ).append("\n"); 
		query.append("                        WHEN NVL (XCH.USD_LOCL_XCH_RT, 0) = 0" ).append("\n"); 
		query.append("                        THEN 0" ).append("\n"); 
		query.append("                        ELSE BCR.CHG_AMT / XCH.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                           , 0" ).append("\n"); 
		query.append("                           )                        AS OFT_AMT" ).append("\n"); 
		query.append("                        FROM BKG_CHG_RT    BCR," ).append("\n"); 
		query.append("                             GL_MON_XCH_RT XCH," ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                                SELECT" ).append("\n"); 
		query.append("                                       MAX (BKG.BKG_NO) AS BKG_NO," ).append("\n"); 
		query.append("                                       QTY.CNTR_TPSZ_CD AS CNTR_TP" ).append("\n"); 
		query.append("                                  FROM BKG_QUANTITY   QTY," ).append("\n"); 
		query.append("                                       BKG_BL_DOC     DOC," ).append("\n"); 
		query.append("                                       BKG_BOOKING    BKG," ).append("\n"); 
		query.append("                                       BKG_BOOKING    BK2," ).append("\n"); 
		query.append("                                       MDM_CNTR_TP_SZ TPS" ).append("\n"); 
		query.append("                                 WHERE QTY.BKG_NO                  = DOC.BKG_NO" ).append("\n"); 
		query.append("                                   AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                                   AND QTY.CNTR_TPSZ_CD            = TPS.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("                                   AND" ).append("\n"); 
		query.append("                                     (" ).append("\n"); 
		query.append("                                       BKG.BKG_NO                  = DOC.BKG_NO" ).append("\n"); 
		query.append("                                    OR" ).append("\n"); 
		query.append("                                       BKG.BL_NO                   = DOC.MST_CVRD_BL_NO" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                                   AND BK2.BKG_NO                  = DOC.BKG_NO" ).append("\n"); 
		query.append("                                   AND BK2.BL_NO_TP              <>  '9'" ).append("\n"); 
		query.append("                                   AND BK2.BKG_STS_CD            <>  'X'" ).append("\n"); 
		query.append("                                   AND BKG.BKG_NO                  = @[bkg_no] --'DUS101173700' " ).append("\n"); 
		query.append("                              GROUP BY QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                           ) CTP" ).append("\n"); 
		query.append("                       WHERE BCR.BKG_NO                = CTP.BKG_NO" ).append("\n"); 
		query.append("                         AND BCR.FRT_INCL_XCLD_DIV_CD  = 'N'" ).append("\n"); 
		query.append("                         AND BCR.RAT_UT_CD             = CTP.CNTR_TP" ).append("\n"); 
		query.append("                         AND BCR.CHG_CD                = 'OFT'" ).append("\n"); 
		query.append("                         AND XCH.CURR_CD           (+) = BCR.CURR_CD" ).append("\n"); 
		query.append("                         AND XCH.ACCT_XCH_RT_YRMON (+) = SUBSTR (@[vps_etd_dt], 1, 6) ----vps_etd_dt" ).append("\n"); 
		query.append("                         AND XCH.ACCT_XCH_RT_LVL   (+) = '1'" ).append("\n"); 
		query.append("                    GROUP BY BCR.CHG_CD," ).append("\n"); 
		query.append("                             SUBSTR (CTP.CNTR_TP, 1, 1)" ).append("\n"); 
		query.append("                ) OFT," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                      SELECT" ).append("\n"); 
		query.append("                             BCR.CHG_CD PC_CHG," ).append("\n"); 
		query.append("                             NVL (BCR.RAT_AS_QTY, 0) / 100 AS PC_RATE_AS" ).append("\n"); 
		query.append("                        FROM BKG_CHG_RT BCR," ).append("\n"); 
		query.append("                             GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("                       WHERE BCR.BKG_NO                = @[bkg_no] --'DUS101173700' " ).append("\n"); 
		query.append("                         AND BCR.FRT_INCL_XCLD_DIV_CD  = 'N'" ).append("\n"); 
		query.append("#if (${fac_chg_ctnt_div} != '') " ).append("\n"); 
		query.append("                         AND BCR.CHG_CD IN ( ${fac_chg_ctnt_div} ) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                           AND BCR.RAT_UT_CD            = 'PC'" ).append("\n"); 
		query.append("                           AND XCH.CURR_CD           (+) = BCR.CURR_CD" ).append("\n"); 
		query.append("                           AND XCH.ACCT_XCH_RT_YRMON (+) = SUBSTR(@[vps_etd_dt], 1, 6) ----vps_etd_dt" ).append("\n"); 
		query.append("                           AND XCH.ACCT_XCH_RT_LVL   (+)   = '1'" ).append("\n"); 
		query.append("                ) PCC" ).append("\n"); 
		query.append("     ) PCA," ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                   CTP.CNTR_TP AS CHG_TP," ).append("\n"); 
		query.append("                   FRT.CNTR_ARR," ).append("\n"); 
		query.append("                   FRT.CNTR_RT AS RATE" ).append("\n"); 
		query.append("              FROM" ).append("\n"); 
		query.append("                 (" ).append("\n"); 
		query.append("                       SELECT" ).append("\n"); 
		query.append("                     DISTINCT SUBSTR (QTY.CNTR_TPSZ_CD, 1, 1) AS CNTR_TP" ).append("\n"); 
		query.append("                         FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("                        WHERE QTY.BKG_NO" ).append("\n"); 
		query.append("                           IN" ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                                  SELECT" ).append("\n"); 
		query.append("                                         DOC.BKG_NO" ).append("\n"); 
		query.append("                                    FROM BKG_BL_DOC  DOC," ).append("\n"); 
		query.append("                                         BKG_BOOKING BKG," ).append("\n"); 
		query.append("                                         BKG_BOOKING BK2" ).append("\n"); 
		query.append("                                   WHERE" ).append("\n"); 
		query.append("                                       (" ).append("\n"); 
		query.append("                                         BKG.BKG_NO                  = DOC.BKG_NO" ).append("\n"); 
		query.append("                                      OR" ).append("\n"); 
		query.append("                                         BKG.BL_NO                   = DOC.MST_CVRD_BL_NO" ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                                     AND BK2.BKG_NO                  = DOC.BKG_NO" ).append("\n"); 
		query.append("                                     AND BK2.BL_NO_TP              <>  '9'" ).append("\n"); 
		query.append("                                     AND BK2.BKG_STS_CD            <>  'X'" ).append("\n"); 
		query.append("                                     AND BKG.BKG_NO                  = @[bkg_no] --'DUS101173700' " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                          AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                 ) CTP," ).append("\n"); 
		query.append("                 (" ).append("\n"); 
		query.append("                       SELECT" ).append("\n"); 
		query.append("                         CASE ROWNUM" ).append("\n"); 
		query.append("                         WHEN 1" ).append("\n"); 
		query.append("                         THEN NVL (FRT.FAC_SPCL_CNTR_TP_CTNT1,' ')" ).append("\n"); 
		query.append("                         ELSE NVL (FRT.FAC_SPCL_CNTR_TP_CTNT2,' ')" ).append("\n"); 
		query.append("                          END                                      AS CNTR_ARR," ).append("\n"); 
		query.append("                         CASE ROWNUM" ).append("\n"); 
		query.append("                         WHEN 1" ).append("\n"); 
		query.append("                         THEN NVL (FRT.FAC_SPCL_CNTR_RT1, 0)" ).append("\n"); 
		query.append("                         ELSE NVL (FRT.FAC_SPCL_CNTR_RT2, 0)" ).append("\n"); 
		query.append("                          END                                      AS CNTR_RT" ).append("\n"); 
		query.append("                         FROM ACM_FAC_AGMT FRT," ).append("\n"); 
		query.append("                              ALL_OBJECTS     AOS" ).append("\n"); 
		query.append("                        WHERE FRT.FAC_OFC_CD   = @[fac_ofc_cd]" ).append("\n"); 
		query.append("                          AND FRT.FF_CNT_CD    = @[ff_cnt_cd]" ).append("\n"); 
		query.append("                          AND FRt.FF_SEQ  = TO_NUMBER(@[ff_cust_seq])" ).append("\n"); 
		query.append("                          AND FRT.FAC_AGMT_SEQ  = @[fac_agmt_seq]" ).append("\n"); 
		query.append("                          AND ROWNUM                <  3" ).append("\n"); 
		query.append("                ) FRT" ).append("\n"); 
		query.append("            WHERE INSTR (NVL (FRT.CNTR_ARR,' '), CTP.CNTR_TP) > 0" ).append("\n"); 
		query.append("     ) RAT" ).append("\n"); 
		query.append(" WHERE AMT.CHG_TP = PCA.CHG_TP(+)" ).append("\n"); 
		query.append("   AND AMT.CHG_TP = RAT.CHG_TP(+)" ).append("\n"); 

	}
}