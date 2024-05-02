/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchEdiPortalTpIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.12.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchEdiPortalTpIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Portal EDI를 위한 수신 EDI ID를 조회함
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchEdiPortalTpIdRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchEdiPortalTpIdRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT GROUP_EDI_ID GROUP_ID" ).append("\n"); 
		query.append("	, EDI_RECEIVE_ID RCV_ID" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (SELECT BKG_NO" ).append("\n"); 
		query.append("        , MIN(RANK) RANK" ).append("\n"); 
		query.append("        , GROUP_EDI_ID" ).append("\n"); 
		query.append("        , EDI_RECEIVE_ID" ).append("\n"); 
		query.append("        , REF_CODE" ).append("\n"); 
		query.append("      FROM " ).append("\n"); 
		query.append("        (SELECT  BK.BKG_NO" ).append("\n"); 
		query.append("                , MIN(TP_RANK.RANK) RANK" ).append("\n"); 
		query.append("                , EDI_BY_CUST.GROUP_EDI_ID" ).append("\n"); 
		query.append("                , EDI_BY_CUST.EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                , EDI_BY_CUST.CNT_CD||EDI_BY_CUST.CUST_SEQ AS REF_CODE" ).append("\n"); 
		query.append("          FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("                , BKG_BOOKING BK" ).append("\n"); 
		query.append("                , (SELECT GRP.ESVC_GRP_CD           GROUP_EDI_ID" ).append("\n"); 
		query.append("                         , GRP.CUST_TRD_PRNR_ID     EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                         , GRP_CUST.CNT_CD   " ).append("\n"); 
		query.append("                         , GRP_CUST.CUST_SEQ" ).append("\n"); 
		query.append("                         , GRP_CUST.BKG_CUST_TP_DESC " ).append("\n"); 
		query.append("                   FROM BKG_EDI_GRP_CUST GRP_CUST, BKG_EDI_GRP GRP" ).append("\n"); 
		query.append("                  WHERE GRP.ESVC_GRP_CD         = GRP_CUST.ESVC_GRP_CD" ).append("\n"); 
		query.append("                    AND GRP.CO_CD               = GRP_CUST.CO_CD" ).append("\n"); 
		query.append("                    AND GRP.CO_CD               = 'H'" ).append("\n"); 
		query.append("                    AND GRP.ESVC_GRP_DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                    AND GRP_CUST.CNT_CD         > ' '" ).append("\n"); 
		query.append("                    AND GRP_CUST.CUST_SEQ       > 0" ).append("\n"); 
		query.append("                    AND GRP_CUST.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                    AND GRP_CUST.BKG_CFM_FLG    = 'Y'" ).append("\n"); 
		query.append("                    ) EDI_BY_CUST               " ).append("\n"); 
		query.append("                , (SELECT 'S' RCV_TP, '1SH' RANK FROM DUAL " ).append("\n"); 
		query.append("                   UNION SELECT 'C' RCV_TP, '2CN' RANK FROM DUAL " ).append("\n"); 
		query.append("                   UNION SELECT 'N' RCV_TP, '3NF' RANK FROM DUAL " ).append("\n"); 
		query.append("                   UNION SELECT 'F' RCV_TP, '4FF' RANK FROM DUAL " ).append("\n"); 
		query.append("                   UNION SELECT 'A' RCV_TP, '5AN' RANK FROM DUAL " ).append("\n"); 
		query.append("                   UNION SELECT 'E' RCV_TP, '6EX' RANK FROM DUAL) TP_RANK" ).append("\n"); 
		query.append("         WHERE EDI_BY_CUST.CNT_CD   = CUST.CUST_CNT_CD " ).append("\n"); 
		query.append("           AND EDI_BY_CUST.CUST_SEQ = CUST.CUST_SEQ" ).append("\n"); 
		query.append("           AND BK.BKG_NO            = CUST.BKG_NO" ).append("\n"); 
		query.append("           AND CUST.BKG_CUST_TP_CD  = TP_RANK.RCV_TP" ).append("\n"); 
		query.append("           AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND DECODE(BKG_CUST_TP_DESC,'ALL','ALL',CUST.BKG_CUST_TP_CD)" ).append("\n"); 
		query.append("                               IN (SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("                                     FROM TABLE(BKG_SPLIT_FNC(BKG_CUST_TP_DESC,',')))" ).append("\n"); 
		query.append("         GROUP BY BK.BKG_NO" ).append("\n"); 
		query.append("                , EDI_BY_CUST.GROUP_EDI_ID" ).append("\n"); 
		query.append("                , EDI_BY_CUST.EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                , EDI_BY_CUST.CNT_CD||EDI_BY_CUST.CUST_SEQ" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("          SELECT BK.BKG_NO" ).append("\n"); 
		query.append("                , '7SC' RANK" ).append("\n"); 
		query.append("                , EDI_BY_SC.GROUP_EDI_ID" ).append("\n"); 
		query.append("                , EDI_BY_SC.EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                , EDI_BY_SC.SC_NO AS REF_CODE" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("                , (SELECT  GRP.ESVC_GRP_CD           GROUP_EDI_ID" ).append("\n"); 
		query.append("                         , GRP.CUST_TRD_PRNR_ID     EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                         , GRP_CUST.SC_NO" ).append("\n"); 
		query.append("                         , GRP_CUST.BKG_CTRT_TP_CD" ).append("\n"); 
		query.append("                   FROM BKG_EDI_GRP GRP, BKG_EDI_GRP_CUST GRP_CUST" ).append("\n"); 
		query.append("                  WHERE GRP.ESVC_GRP_CD         = GRP_CUST.ESVC_GRP_CD" ).append("\n"); 
		query.append("                    AND GRP.CO_CD               = GRP_CUST.CO_CD      " ).append("\n"); 
		query.append("                    AND GRP.CO_CD               = 'H'" ).append("\n"); 
		query.append("                    AND GRP.ESVC_GRP_DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                    AND GRP_CUST.SC_NO          > ' '              " ).append("\n"); 
		query.append("                    AND GRP_CUST.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                    AND GRP_CUST.BKG_CFM_FLG    = 'Y'" ).append("\n"); 
		query.append("                    ) EDI_BY_SC" ).append("\n"); 
		query.append("         WHERE EDI_BY_SC.SC_NO  = DECODE(EDI_BY_SC.BKG_CTRT_TP_CD, '1', BK.SC_NO, '2', BK.RFA_NO)" ).append("\n"); 
		query.append("           AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("     GROUP BY BKG_NO" ).append("\n"); 
		query.append("        , GROUP_EDI_ID" ).append("\n"); 
		query.append("        , EDI_RECEIVE_ID" ).append("\n"); 
		query.append("        , REF_CODE) MST, BKG_BOOKING BK" ).append("\n"); 
		query.append("  WHERE BK.BKG_NO = MST.BKG_NO " ).append("\n"); 
		query.append("	AND ((MST.EDI_RECEIVE_ID IN ('INTTRA', 'INTTRANG2', 'GTNEXUS', 'CARGOSMART', 'PKEXM010')	" ).append("\n"); 
		query.append("          AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                            FROM BKG_HIS_MST HIS, BKG_HIS_DTL DTL" ).append("\n"); 
		query.append("                           WHERE HIS.BKG_NO  = BK.BKG_NO" ).append("\n"); 
		query.append("                             AND DTL.BKG_NO  = BK.BKG_NO" ).append("\n"); 
		query.append("                             AND HIS.HIS_SEQ = DTL.HIS_SEQ" ).append("\n"); 
		query.append("                             AND HIS.HIS_SEQ = (SELECT MAX(A.HIS_SEQ) " ).append("\n"); 
		query.append("                                                  FROM BKG_HIS_MST A, BKG_HIS_DTL B " ).append("\n"); 
		query.append("                                                 WHERE A.BKG_NO = HIS.BKG_NO " ).append("\n"); 
		query.append("                                                   AND A.BKG_NO   = B.BKG_NO " ).append("\n"); 
		query.append("                                                   AND A.HIS_SEQ  = B.HIS_SEQ)" ).append("\n"); 
		query.append("                             AND (DTL.HIS_CATE_NM IN ('BKG QTY','Booking Cancel.','Container No.')" ).append("\n"); 
		query.append("		      		     	      OR DTL.CRNT_CTNT LIKE 'Attach Container:%'" ).append("\n"); 
		query.append("                                  OR DTL.CRNT_CTNT LIKE 'Combined to target bkg no:%'" ).append("\n"); 
		query.append("                                  ) " ).append("\n"); 
		query.append("                             AND ROWNUM = 1)" ).append("\n"); 
		query.append("          AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                      FROM BKG_XTER_RQST_MST BXRM " ).append("\n"); 
		query.append("                      WHERE BXRM.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                      AND BXRM.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("                      AND BXRM.BKG_UPLD_STS_CD = 'F'" ).append("\n"); 
		query.append("                      AND BXRM.XTER_RQST_VIA_CD <> 'WEB')" ).append("\n"); 
		query.append("          )  " ).append("\n"); 
		query.append("           OR (MST.EDI_RECEIVE_ID LIKE ('IKEA%')	" ).append("\n"); 
		query.append("                AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                                  FROM BKG_HIS_MST HIS, BKG_HIS_DTL DTL" ).append("\n"); 
		query.append("                                 WHERE HIS.BKG_NO  = BK.BKG_NO" ).append("\n"); 
		query.append("                                   AND DTL.BKG_NO  = BK.BKG_NO" ).append("\n"); 
		query.append("                                   AND HIS.HIS_SEQ = DTL.HIS_SEQ" ).append("\n"); 
		query.append("                                   AND HIS.HIS_SEQ = (SELECT MAX(A.HIS_SEQ) " ).append("\n"); 
		query.append("                                                        FROM BKG_HIS_MST A, BKG_HIS_DTL B " ).append("\n"); 
		query.append("                                                       WHERE A.BKG_NO = HIS.BKG_NO " ).append("\n"); 
		query.append("                                                         AND A.BKG_NO   = B.BKG_NO " ).append("\n"); 
		query.append("                                                         AND A.HIS_SEQ  = B.HIS_SEQ)" ).append("\n"); 
		query.append("                                   AND DTL.HIS_CATE_NM = 'Booking Cancel.' " ).append("\n"); 
		query.append("                                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}