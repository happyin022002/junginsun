/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchRateAmountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchRateAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate 정보를 조회한다.
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchRateAmountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchRateAmountRSQL").append("\n"); 
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
		query.append("SELECT NVL(A.CHG_CD, '') FCTYPE" ).append("\n"); 
		query.append("     , NVL(A.CHG_UT_AMT, 0) RATE" ).append("\n"); 
		query.append("     , NVL(A.RAT_AS_QTY, 0) REVENUETON" ).append("\n"); 
		query.append("     , DECODE(A.FRT_TERM_CD, 'P', NVL(A.CHG_AMT, 0), 0.0) PPD" ).append("\n"); 
		query.append("     , DECODE(A.FRT_TERM_CD, 'C', NVL(A.CHG_AMT, 0), 0.0) CCT" ).append("\n"); 
		query.append("     , NVL(A.CURR_CD, '') CURRENCYCODE" ).append("\n"); 
		query.append("     , NVL(A.TRF_ITM_NO, '') TARIFF" ).append("\n"); 
		query.append("     , NVL(A.RAT_UT_CD, '') PERTYPE" ).append("\n"); 
		query.append("     , NVL(A.N3PTY_RCV_OFC_CD, '') RATEOFC" ).append("\n"); 
		query.append("     , NVL(A.N3PTY_CUST_CNT_CD||A.N3PTY_CUST_SEQ, '') THR_PAYER" ).append("\n"); 
		query.append("     , TO_CHAR(DECODE(VVD.EXCHRATE, NULL, MON.EXCHRATE, VVD.EXCHRATE), 'FM99990.000000') AS EXCHRATE" ).append("\n"); 
		query.append("  FROM (SELECT NVL(CR.CHG_CD, '') FCTYPE" ).append("\n"); 
		query.append("             , CR.RT_SEQ" ).append("\n"); 
		query.append("             , CR.N3PTY_CUST_CNT_CD||CR.N3PTY_CUST_SEQ AS THR_PAYER" ).append("\n"); 
		query.append("             , TO_CHAR(C.INV_XCH_RT, 'FM99990.000000') AS EXCHRATE " ).append("\n"); 
		query.append("          FROM (SELECT V.BKG_NO" ).append("\n"); 
		query.append("                     , V.POL_CD AS PORT_CD" ).append("\n"); 
		query.append("                     , V.VSL_CD" ).append("\n"); 
		query.append("                     , V.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , V.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , ROW_NUMBER() OVER(ORDER BY V.VSL_PRE_PST_CD||VSL_SEQ ASC) AS RNUM" ).append("\n"); 
		query.append("                     , B.SVC_SCP_CD" ).append("\n"); 
		query.append("                  FROM BKG_VVD V" ).append("\n"); 
		query.append("                     , BKG_BOOKING B" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                   AND B.BKG_NO = @[bkg_no]) B" ).append("\n"); 
		query.append("             , INV_VVD_XCH_RT C" ).append("\n"); 
		query.append("             , BKG_CHG_RT CR" ).append("\n"); 
		query.append("             , BKG_RATE BR" ).append("\n"); 
		query.append("             , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("         WHERE RNUM = 1" ).append("\n"); 
		query.append("           AND B.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("           AND B.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND B.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND B.PORT_CD    = C.PORT_CD" ).append("\n"); 
		query.append("           AND C.AR_OFC_CD  = NVL(CR.N3PTY_RCV_OFC_CD, BR.PPD_RCV_OFC_CD)" ).append("\n"); 
		query.append("           AND C.IO_BND_CD  = 'O'" ).append("\n"); 
		query.append("           AND C.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND C.CHG_CURR_CD = CR.CURR_CD" ).append("\n"); 
		query.append("           AND C.LOCL_CURR_CD = MO.AR_CURR_CD" ).append("\n"); 
		query.append("           AND MO.OFC_CD = NVL(CR.N3PTY_RCV_OFC_CD, BR.PPD_RCV_OFC_CD)" ).append("\n"); 
		query.append("           AND CR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND BR.BKG_NO = CR.BKG_NO" ).append("\n"); 
		query.append("           AND CR.FRT_TERM_CD IN ('P')" ).append("\n"); 
		query.append("           AND CR.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("       ) VVD" ).append("\n"); 
		query.append("     , (SELECT NVL(CR.CHG_CD, '') FCTYPE" ).append("\n"); 
		query.append("             , CR.RT_SEQ" ).append("\n"); 
		query.append("             , CR.N3PTY_CUST_CNT_CD||CR.N3PTY_CUST_SEQ AS THR_PAYER" ).append("\n"); 
		query.append("             , TO_CHAR( DECODE(AA.USD_LOCL_XCH_RT, 0, 0, ROUND(AA.USD_LOCL_XCH_RT/AB.USD_LOCL_XCH_RT, 6)), 'FM99990.000000') AS EXCHRATE" ).append("\n"); 
		query.append("          FROM GL_MON_XCH_RT AA" ).append("\n"); 
		query.append("             , GL_MON_XCH_RT AB" ).append("\n"); 
		query.append("             , (SELECT TO_CHAR(C.VPS_ETD_DT, 'YYYYMM') AS VPS_ETD_DT" ).append("\n"); 
		query.append("                  FROM (SELECT V.BKG_NO" ).append("\n"); 
		query.append("                             , V.POL_CD AS PORT_CD" ).append("\n"); 
		query.append("                             , V.VSL_CD" ).append("\n"); 
		query.append("                             , V.SKD_VOY_NO" ).append("\n"); 
		query.append("                             , V.SKD_DIR_CD" ).append("\n"); 
		query.append("                             , ROW_NUMBER() OVER(ORDER BY V.VSL_PRE_PST_CD||VSL_SEQ ASC) AS RNUM" ).append("\n"); 
		query.append("                          FROM BKG_VVD V" ).append("\n"); 
		query.append("                             , BKG_BOOKING B" ).append("\n"); 
		query.append("                         WHERE B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                           AND B.BKG_NO = @[bkg_no]) B" ).append("\n"); 
		query.append("                     , VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("                 WHERE RNUM = 1" ).append("\n"); 
		query.append("                   AND B.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("                   AND B.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND B.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND B.PORT_CD    = C.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND C.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("                   AND B.BKG_NO = @[bkg_no]) BB" ).append("\n"); 
		query.append("             , BKG_CHG_RT CR" ).append("\n"); 
		query.append("             , BKG_RATE BR" ).append("\n"); 
		query.append("             , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("         WHERE AA.ACCT_XCH_RT_YRMON = BB.VPS_ETD_DT" ).append("\n"); 
		query.append("           AND AA.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("           AND AA.CURR_CD = MO.AR_CURR_CD " ).append("\n"); 
		query.append("           AND AB.ACCT_XCH_RT_YRMON = BB.VPS_ETD_DT" ).append("\n"); 
		query.append("           AND AB.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("           AND AB.CURR_CD = CR.CURR_CD" ).append("\n"); 
		query.append("           AND MO.OFC_CD = NVL(CR.N3PTY_RCV_OFC_CD, BR.PPD_RCV_OFC_CD)" ).append("\n"); 
		query.append("           AND BR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND BR.BKG_NO = CR.BKG_NO" ).append("\n"); 
		query.append("           AND CR.FRT_TERM_CD IN ('P')" ).append("\n"); 
		query.append("           AND CR.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("           ) MON" ).append("\n"); 
		query.append("     , BKG_CHG_RT A" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.CHG_CD = VVD.FCTYPE(+)" ).append("\n"); 
		query.append("   AND A.CHG_CD = MON.FCTYPE(+)" ).append("\n"); 
		query.append("   AND A.RT_SEQ = VVD.RT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.RT_SEQ = MON.RT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("   AND A.FRT_TERM_CD IN ('P')" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("SELECT NVL(A.CHG_CD, '') FCTYPE" ).append("\n"); 
		query.append("     , NVL(A.CHG_UT_AMT, 0) RATE" ).append("\n"); 
		query.append("     , NVL(A.RAT_AS_QTY, 0) REVENUETON" ).append("\n"); 
		query.append("     , DECODE(A.FRT_TERM_CD, 'P', NVL(A.CHG_AMT, 0), 0.0) PPD" ).append("\n"); 
		query.append("     , DECODE(A.FRT_TERM_CD, 'C', NVL(A.CHG_AMT, 0), 0.0) CCT" ).append("\n"); 
		query.append("     , NVL(A.CURR_CD, '') CURRENCYCODE" ).append("\n"); 
		query.append("     , NVL(A.TRF_ITM_NO, '') TARIFF" ).append("\n"); 
		query.append("     , NVL(A.RAT_UT_CD, '') PERTYPE" ).append("\n"); 
		query.append("     , NVL(A.N3PTY_RCV_OFC_CD, '') RATEOFC" ).append("\n"); 
		query.append("     , NVL(A.N3PTY_CUST_CNT_CD||A.N3PTY_CUST_SEQ, '') THR_PAYER" ).append("\n"); 
		query.append("     , TO_CHAR(DECODE(VVD.EXCHRATE, NULL, MON.EXCHRATE, VVD.EXCHRATE), 'FM99990.000000') AS EXCHRATE" ).append("\n"); 
		query.append("  FROM (SELECT NVL(CR.CHG_CD, '') FCTYPE" ).append("\n"); 
		query.append("             , CR.RT_SEQ" ).append("\n"); 
		query.append("             , CR.N3PTY_CUST_CNT_CD||CR.N3PTY_CUST_SEQ AS THR_PAYER" ).append("\n"); 
		query.append("             , TO_CHAR( C.INV_XCH_RT, 'FM99990.000000') AS EXCHRATE" ).append("\n"); 
		query.append("          FROM (SELECT V.BKG_NO" ).append("\n"); 
		query.append("                     , V.POD_CD AS PORT_CD" ).append("\n"); 
		query.append("                     , V.VSL_CD" ).append("\n"); 
		query.append("                     , V.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , V.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , ROW_NUMBER() OVER(ORDER BY V.VSL_PRE_PST_CD||VSL_SEQ DESC) AS RNUM" ).append("\n"); 
		query.append("                     , B.SVC_SCP_CD" ).append("\n"); 
		query.append("                  FROM BKG_VVD V" ).append("\n"); 
		query.append("                     , BKG_BOOKING B" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                   AND B.BKG_NO = @[bkg_no]) B" ).append("\n"); 
		query.append("             , INV_VVD_XCH_RT C" ).append("\n"); 
		query.append("             , BKG_CHG_RT CR" ).append("\n"); 
		query.append("             , BKG_RATE BR" ).append("\n"); 
		query.append("             , MDM_ORGANIZATION MO " ).append("\n"); 
		query.append("         WHERE RNUM = 1" ).append("\n"); 
		query.append("           AND B.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("           AND B.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND B.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND B.PORT_CD    = C.PORT_CD" ).append("\n"); 
		query.append("           AND C.AR_OFC_CD  = NVL(CR.N3PTY_RCV_OFC_CD, BR.CLT_OFC_CD)" ).append("\n"); 
		query.append("           AND C.IO_BND_CD  = 'I'" ).append("\n"); 
		query.append("           AND C.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND C.CHG_CURR_CD = CR.CURR_CD" ).append("\n"); 
		query.append("           AND C.LOCL_CURR_CD = MO.AR_CURR_CD" ).append("\n"); 
		query.append("           AND MO.OFC_CD = NVL(CR.N3PTY_RCV_OFC_CD, BR.CLT_OFC_CD)" ).append("\n"); 
		query.append("           AND CR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND BR.BKG_NO = CR.BKG_NO" ).append("\n"); 
		query.append("           AND CR.FRT_TERM_CD IN ('C')" ).append("\n"); 
		query.append("           AND CR.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("        ) VVD" ).append("\n"); 
		query.append("     , (SELECT NVL(CR.CHG_CD, '') FCTYPE" ).append("\n"); 
		query.append("             , CR.RT_SEQ" ).append("\n"); 
		query.append("             , CR.N3PTY_CUST_CNT_CD||CR.N3PTY_CUST_SEQ AS THR_PAYER" ).append("\n"); 
		query.append("             , TO_CHAR(DECODE(AA.USD_LOCL_XCH_RT, 0, 0, ROUND(AA.USD_LOCL_XCH_RT/AB.USD_LOCL_XCH_RT, 6)), 'FM99990.000000') AS EXCHRATE" ).append("\n"); 
		query.append("          FROM GL_MON_XCH_RT AA" ).append("\n"); 
		query.append("             , GL_MON_XCH_RT AB" ).append("\n"); 
		query.append("             , (SELECT TO_CHAR(C.VPS_ETA_DT, 'YYYYMM') AS VPS_ETA_DT" ).append("\n"); 
		query.append("                  FROM (SELECT V.BKG_NO" ).append("\n"); 
		query.append("                             , V.POD_CD AS PORT_CD" ).append("\n"); 
		query.append("                             , V.VSL_CD" ).append("\n"); 
		query.append("                             , V.SKD_VOY_NO" ).append("\n"); 
		query.append("                             , V.SKD_DIR_CD" ).append("\n"); 
		query.append("                             , ROW_NUMBER() OVER(ORDER BY V.VSL_PRE_PST_CD||VSL_SEQ DESC) AS RNUM" ).append("\n"); 
		query.append("                          FROM BKG_VVD V" ).append("\n"); 
		query.append("                             , BKG_BOOKING B" ).append("\n"); 
		query.append("                         WHERE B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                           AND B.BKG_NO = @[bkg_no]) B" ).append("\n"); 
		query.append("                     , VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("                 WHERE RNUM = 1" ).append("\n"); 
		query.append("                   AND B.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("                   AND B.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND B.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND B.PORT_CD    = C.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND C.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("                   AND B.BKG_NO = @[bkg_no]) BB" ).append("\n"); 
		query.append("             , BKG_CHG_RT CR" ).append("\n"); 
		query.append("             , BKG_RATE BR" ).append("\n"); 
		query.append("             , MDM_ORGANIZATION MO " ).append("\n"); 
		query.append("         WHERE AA.ACCT_XCH_RT_YRMON = BB.VPS_ETA_DT" ).append("\n"); 
		query.append("           AND AA.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("           AND AA.CURR_CD = MO.AR_CURR_CD" ).append("\n"); 
		query.append("           AND MO.OFC_CD = NVL(CR.N3PTY_RCV_OFC_CD, BR.CLT_OFC_CD)" ).append("\n"); 
		query.append("           AND AB.ACCT_XCH_RT_YRMON = BB.VPS_ETA_DT" ).append("\n"); 
		query.append("           AND AB.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("           AND AB.CURR_CD = CR.CURR_CD" ).append("\n"); 
		query.append("           AND BR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND BR.BKG_NO = CR.BKG_NO" ).append("\n"); 
		query.append("           AND CR.FRT_TERM_CD IN ('C')" ).append("\n"); 
		query.append("           ) MON" ).append("\n"); 
		query.append("     , BKG_CHG_RT A" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.CHG_CD = VVD.FCTYPE(+)" ).append("\n"); 
		query.append("   AND A.CHG_CD = MON.FCTYPE(+)" ).append("\n"); 
		query.append("   AND A.RT_SEQ = VVD.RT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.RT_SEQ = MON.RT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("   AND A.FRT_TERM_CD IN ('C')" ).append("\n"); 

	}
}