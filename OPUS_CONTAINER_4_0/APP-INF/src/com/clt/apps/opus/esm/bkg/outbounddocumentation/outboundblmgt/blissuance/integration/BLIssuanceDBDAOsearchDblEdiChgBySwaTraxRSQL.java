/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiChgBySwaTraxRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.04
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.10.04 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiChgBySwaTraxRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiChgBySwaTraxRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiChgBySwaTraxRSQL").append("\n"); 
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
		query.append("SELECT '{CHARGE'                                                                                    || CHR(10)" ).append("\n"); 
		query.append("         || 'FCTYPE:'        || B.CHG_CD                                                            || CHR(10)" ).append("\n"); 
		query.append("         || 'RATE:'          || B.CHG_UT_AMT                                                        || CHR(10)" ).append("\n"); 
		query.append("         || 'RATED_AS:'      || B.RAT_AS_QTY                                                        || CHR(10)" ).append("\n"); 
		query.append("         || 'REVENUETON:'    || CHR(10)" ).append("\n"); 
		query.append("         || 'DIF_AMT:'       || ROUND(B.CHG_AMT * DECODE(B.CURR_CD, 'USD', 1, C.INV_XCH_RT) , 2)    || CHR(10)" ).append("\n"); 
		query.append("         || 'PPD:'               || CHR(10)" ).append("\n"); 
		query.append("         || 'CCT:'               || CHR(10)" ).append("\n"); 
		query.append("         || 'CURRENCYCODE:'  || B.CURR_CD                                                           || CHR(10)" ).append("\n"); 
		query.append("         || 'TARIFF:'        || B.TRF_ITM_NO                                                        || CHR(10)" ).append("\n"); 
		query.append("         || 'PERTYPE:'       || B.RAT_UT_CD                                                         || CHR(10)" ).append("\n"); 
		query.append("         || 'EXRATE:'        || TO_CHAR(DECODE(B.CURR_CD, 'USD', 1, C.INV_XCH_RT),'FM9990.000000')  || CHR(10)" ).append("\n"); 
		query.append("         || 'FRT_IND:'       || B.FRT_TERM_CD                                                       || CHR(10)" ).append("\n"); 
		query.append("         || '}CHARGE'                                                                               || CHR(10)       " ).append("\n"); 
		query.append("  FROM INV_AR_MN A" ).append("\n"); 
		query.append("      ,BKG_CHG_RT B" ).append("\n"); 
		query.append("      ,INV_CUST_AND_DLY_XCH_RT C" ).append("\n"); 
		query.append("      ,BKG_RATE D" ).append("\n"); 
		query.append("      ,MDM_LOCATION E" ).append("\n"); 
		query.append("      ,BKG_VVD F" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD G" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("         SELECT COUNT(G.VPS_PORT_CD) CNT" ).append("\n"); 
		query.append("           FROM INV_AR_MN A, BKG_CHG_RT B, INV_CUST_AND_DLY_XCH_RT C, BKG_RATE D, MDM_LOCATION E, BKG_VVD F, VSK_VSL_PORT_SKD G" ).append("\n"); 
		query.append("          WHERE B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("            AND NVL(B.FRT_INCL_XCLD_DIV_CD, 'N') NOT IN ('I', 'E')" ).append("\n"); 
		query.append("            AND B.BKG_NO = D.BKG_NO  " ).append("\n"); 
		query.append("            AND DECODE(B.N3PTY_RCV_OFC_CD, NULL, DECODE(B.FRT_TERM_CD, 'P', D.PPD_RCV_OFC_CD, D.CLT_OFC_CD) , B.N3PTY_RCV_OFC_CD) = 'SINBB'       " ).append("\n"); 
		query.append("            AND DECODE(B.N3PTY_CUST_CNT_CD, NULL, DECODE(B.FRT_TERM_CD, 'P', D.PPD_PAYR_CNT_CD, D.CLT_PAYR_CNT_CD) , B.N3PTY_CUST_CNT_CD) = 'SG'" ).append("\n"); 
		query.append("            AND DECODE(B.N3PTY_CUST_CNT_CD, NULL, DECODE(B.FRT_TERM_CD, 'P', D.PPD_PAYR_CUST_SEQ, D.CLT_PAYR_CUST_SEQ) , B.N3PTY_CUST_SEQ) IN (260, 11029)                                     " ).append("\n"); 
		query.append("            AND A.AR_IF_NO =  ( SELECT MAX(AR_IF_NO) " ).append("\n"); 
		query.append("                                  FROM INV_AR_MN " ).append("\n"); 
		query.append("                                 WHERE BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("                                   AND BL_INV_CFM_DT IS NOT NULL " ).append("\n"); 
		query.append("                                   AND AR_OFC_CD = 'SINBB'" ).append("\n"); 
		query.append("                                   AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                                   AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y')" ).append("\n"); 
		query.append("            AND C.CUST_CNT_CD = DECODE(B.N3PTY_CUST_CNT_CD, NULL, DECODE(B.FRT_TERM_CD, 'P', D.PPD_PAYR_CNT_CD, D.CLT_PAYR_CNT_CD), B.N3PTY_CUST_CNT_CD)" ).append("\n"); 
		query.append("            AND C.CUST_SEQ = DECODE(B.N3PTY_CUST_CNT_CD, NULL, DECODE(B.FRT_TERM_CD, 'P', D.PPD_PAYR_CUST_SEQ, D.CLT_PAYR_CUST_SEQ), B.N3PTY_CUST_SEQ)" ).append("\n"); 
		query.append("            AND A.IO_BND_CD = C.IO_BND_CD" ).append("\n"); 
		query.append("            AND DECODE(B.CURR_CD, 'SGD', 'USD', B.CURR_CD) = C.CHG_CURR_CD" ).append("\n"); 
		query.append("            AND C.LOCL_CURR_CD = 'SGD'" ).append("\n"); 
		query.append("            AND C.AR_OFC_CD = 'SINBB'" ).append("\n"); 
		query.append("            AND B.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("            AND A.POD_CD = E.LOC_CD" ).append("\n"); 
		query.append("            AND F.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("            AND F.VSL_CD = G.VSL_CD" ).append("\n"); 
		query.append("            AND F.SKD_VOY_NO = G.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND F.SKD_DIR_CD = G.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND 'Y' = CASE WHEN A.IO_BND_CD ='O' AND F.POL_CLPT_IND_SEQ = G.CLPT_IND_SEQ THEN 'Y'" ).append("\n"); 
		query.append("						   WHEN A.IO_BND_CD ='I' AND F.POD_CLPT_IND_SEQ = G.CLPT_IND_SEQ THEN 'Y'" ).append("\n"); 
		query.append("					  ELSE 'N'" ).append("\n"); 
		query.append("					  END " ).append("\n"); 
		query.append("            AND G.VPS_PORT_CD = DECODE(A.IO_BND_CD , 'O', A.POL_CD, A.POD_CD)" ).append("\n"); 
		query.append("            AND DECODE(A.IO_BND_CD , 'O' , (DECODE(E.CONTI_CD , 'M' , TO_CHAR(D.RT_APLY_DT, 'YYYYMMDD') , TO_CHAR(G.VPS_ETD_DT, 'YYYYMMDD') ) )" ).append("\n"); 
		query.append("                                   , 'I' , TO_CHAR(G.VPS_ETA_DT, 'YYYYMMDD') ) BETWEEN C.FM_DT AND C.TO_DT" ).append("\n"); 
		query.append("      ) P" ).append("\n"); 
		query.append("WHERE B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("  AND NVL(B.FRT_INCL_XCLD_DIV_CD, 'N') NOT IN ('I', 'E')" ).append("\n"); 
		query.append("  AND B.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("  AND DECODE(B.N3PTY_RCV_OFC_CD, NULL, DECODE(B.FRT_TERM_CD, 'P', D.PPD_RCV_OFC_CD, D.CLT_OFC_CD) , B.N3PTY_RCV_OFC_CD) = 'SINBB'       " ).append("\n"); 
		query.append("  AND DECODE(B.N3PTY_CUST_CNT_CD, NULL, DECODE(B.FRT_TERM_CD, 'P', D.PPD_PAYR_CNT_CD, D.CLT_PAYR_CNT_CD) , B.N3PTY_CUST_CNT_CD) = 'SG'" ).append("\n"); 
		query.append("  AND DECODE(B.N3PTY_CUST_CNT_CD, NULL, DECODE(B.FRT_TERM_CD, 'P', D.PPD_PAYR_CUST_SEQ, D.CLT_PAYR_CUST_SEQ) , B.N3PTY_CUST_SEQ) IN (260, 11029)                                     " ).append("\n"); 
		query.append("  AND A.AR_IF_NO =  ( SELECT MAX(AR_IF_NO) " ).append("\n"); 
		query.append("                        FROM INV_AR_MN " ).append("\n"); 
		query.append("                       WHERE BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("                         AND BL_INV_CFM_DT IS NOT NULL " ).append("\n"); 
		query.append("                         AND AR_OFC_CD = 'SINBB'" ).append("\n"); 
		query.append("                         AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                         AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y')                          " ).append("\n"); 
		query.append("  AND C.CUST_CNT_CD = DECODE(B.N3PTY_CUST_CNT_CD, NULL, DECODE(B.FRT_TERM_CD, 'P', D.PPD_PAYR_CNT_CD, D.CLT_PAYR_CNT_CD), B.N3PTY_CUST_CNT_CD)" ).append("\n"); 
		query.append("  AND C.CUST_SEQ = DECODE(B.N3PTY_CUST_CNT_CD, NULL, DECODE(B.FRT_TERM_CD, 'P', D.PPD_PAYR_CUST_SEQ, D.CLT_PAYR_CUST_SEQ), B.N3PTY_CUST_SEQ)" ).append("\n"); 
		query.append("  AND A.IO_BND_CD = C.IO_BND_CD" ).append("\n"); 
		query.append("  AND DECODE(B.CURR_CD, 'SGD', 'USD', B.CURR_CD) = C.CHG_CURR_CD" ).append("\n"); 
		query.append("  AND C.LOCL_CURR_CD = 'SGD'" ).append("\n"); 
		query.append("  AND C.AR_OFC_CD = 'SINBB'" ).append("\n"); 
		query.append("  AND B.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("  AND A.POD_CD = E.LOC_CD" ).append("\n"); 
		query.append("  AND F.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("  AND F.VSL_CD = G.VSL_CD" ).append("\n"); 
		query.append("  AND F.SKD_VOY_NO = G.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND F.SKD_DIR_CD = G.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND 'Y' = CASE WHEN A.IO_BND_CD ='O' AND F.POL_CLPT_IND_SEQ = G.CLPT_IND_SEQ THEN 'Y'" ).append("\n"); 
		query.append("				 WHEN A.IO_BND_CD ='I' AND F.POD_CLPT_IND_SEQ = G.CLPT_IND_SEQ THEN 'Y'" ).append("\n"); 
		query.append("			ELSE 'N'" ).append("\n"); 
		query.append("			END" ).append("\n"); 
		query.append("  AND G.VPS_PORT_CD = DECODE(A.IO_BND_CD , 'O', A.POL_CD, A.POD_CD)" ).append("\n"); 
		query.append("  AND G.VPS_PORT_CD = DECODE(B.FRT_TERM_CD, 'P', A.POL_CD, A.POD_CD)" ).append("\n"); 
		query.append("  AND DECODE(A.IO_BND_CD , 'O' , (DECODE(E.CONTI_CD , 'M' , TO_CHAR(D.RT_APLY_DT, 'YYYYMMDD') , TO_CHAR(G.VPS_ETD_DT, 'YYYYMMDD') ) )" ).append("\n"); 
		query.append("                         , 'I' , TO_CHAR(G.VPS_ETA_DT, 'YYYYMMDD') ) BETWEEN C.FM_DT AND C.TO_DT" ).append("\n"); 
		query.append("  AND (    (G.CLPT_IND_SEQ = DECODE(P.CNT, 1, G.CLPT_IND_SEQ, 0))" ).append("\n"); 
		query.append("        OR (1 =  CASE WHEN P.CNT = 1 AND NVL(G.SKD_CNG_STS_CD, ' ') = 'C' THEN 1" ).append("\n"); 
		query.append("                      WHEN NVL(G.SKD_CNG_STS_CD, ' ') IN ('I', ' ', 'A') THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END) )" ).append("\n"); 
		query.append(" ORDER BY B.DP_SEQ" ).append("\n"); 

	}
}