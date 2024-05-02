/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterSICntrMfDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.23
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.03.23 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterSICntrMfDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterSICntrMfDescRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterSICntrMfDescRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(NVL(CM.CNTR_MF_SEQ,0), 0,'I','U') IBFLAG" ).append("\n"); 
		query.append("      , XCM.BKG_NO" ).append("\n"); 
		query.append("      , XCM.CNTR_NO" ).append("\n"); 
		query.append("      , XCM.PCK_QTY" ).append("\n"); 
		query.append("      , XCM.PCK_TP_CD" ).append("\n"); 
		query.append("      , XCM.CNTR_MF_WGT" ).append("\n"); 
		query.append("      , XCM.WGT_UT_CD" ).append("\n"); 
		query.append("      , XCM.MEAS_QTY" ).append("\n"); 
		query.append("      , XCM.MEAS_UT_CD" ).append("\n"); 
		query.append("      , XCM.MK_DESC_SEQ CNTR_MF_SEQ" ).append("\n"); 
		query.append("      , REPLACE(NVL(XCM.HAMO_TRF_CTNT, ''),'.','') HAMO_TRF_CD" ).append("\n"); 
		query.append("      , NVL(XCM.NCM_NO, DECODE(XCM.NCM_MULTI_NO, NULL, '', " ).append("\n"); 
		query.append("                      SUBSTR(XCM.NCM_MULTI_NO, 0, DECODE( INSTR(XCM.NCM_MULTI_NO,',') , 0,  LENGTH(XCM.NCM_MULTI_NO), " ).append("\n"); 
		query.append("                                                                                    INSTR(XCM.NCM_MULTI_NO,',')-1)))) NCM_NO " ).append("\n"); 
		query.append("      , NVL(REF.CUST_REF_NO_CTNT, '') PO_NO" ).append("\n"); 
		query.append("      , NVL(REPLACE(XCM.CNTR_MF_DTL_DESC, '@@', CHR(13)||CHR(10)), '  ') CNTR_MF_DTL_DESC" ).append("\n"); 
		query.append("      , NVL(REPLACE(XCM.CNTR_MF_DESC, '@@', CHR(13)||CHR(10)), ' ') CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("      , NVL(REPLACE(XCM.CNTR_MF_MK_DESC, '@@', CHR(13)||CHR(10)), ' ') CNTR_MF_MK_DESC" ).append("\n"); 
		query.append("	  , XCM.CNTR_MF_NO" ).append("\n"); 
		query.append("	  , XCM.DCGO_SEQ" ).append("\n"); 
		query.append("	  , NVL(XCM.CMDT_HS_CD, '') CMDT_HS_CD" ).append("\n"); 
		query.append("      , ( SELECT CNTR_TPSZ_CD FROM BKG_CONTAINER C WHERE C.BKG_NO = XCM.BKG_NO AND C.CNTR_NO = XCM.CNTR_NO AND ROWNUM <= 1 ) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , XCM.NCM_MULTI_NO" ).append("\n"); 
		query.append("      , XCM.WPM_TRT_CD" ).append("\n"); 
		query.append("      , ( SELECT STWG_CD FROM BKG_BOOKING WHERE BKG_NO = XCM.BKG_NO ) as STWG_CD" ).append("\n"); 
		query.append("FROM  (SELECT MST.BKG_NO " ).append("\n"); 
		query.append("        , CM.XTER_RQST_NO " ).append("\n"); 
		query.append("        , CM.XTER_RQST_SEQ " ).append("\n"); 
		query.append("        , CM.CNTR_NO " ).append("\n"); 
		query.append("        , CM.MK_DESC_SEQ " ).append("\n"); 
		query.append("        , CM.PCK_QTY" ).append("\n"); 
		query.append("        , CM.PCK_TP_CD " ).append("\n"); 
		query.append("        , CM.CNTR_MF_WGT " ).append("\n"); 
		query.append("        , CM.WGT_UT_CD " ).append("\n"); 
		query.append("        , CM.MEAS_QTY" ).append("\n"); 
		query.append("        , CM.MEAS_UT_CD" ).append("\n"); 
		query.append("        , CM.CNTR_MF_MK_DESC " ).append("\n"); 
		query.append("        , CM.CNTR_MF_DESC " ).append("\n"); 
		query.append("        , CM.CNTR_MF_DTL_DESC " ).append("\n"); 
		query.append("        , CM.HAMO_TRF_CTNT" ).append("\n"); 
		query.append("        , CM.NCM_NO" ).append("\n"); 
		query.append("		, CM.CMDT_HS_CD" ).append("\n"); 
		query.append("		, CM.DCGO_SEQ" ).append("\n"); 
		query.append("        , '' AS SI_NO" ).append("\n"); 
		query.append("        , CM.CNTR_MF_NO" ).append("\n"); 
		query.append("        ,NVL(BKG_JOIN_FNC(CURSOR( SELECT  DTL.NCM_NO" ).append("\n"); 
		query.append("                                 FROM    BKG_CNTR_MF_DESC_DTL DTL" ).append("\n"); 
		query.append("                                 WHERE   DTL.BKG_NO = MST.BKG_NO" ).append("\n"); 
		query.append("                                 AND     DTL.CNTR_NO = CM.CNTR_NO" ).append("\n"); 
		query.append("                                 AND     DTL.CNTR_MF_SEQ = CM.CNTR_SEQ								" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                        ),CM.NCM_NO    ) NCM_MULTI_NO" ).append("\n"); 
		query.append("        , CM.WPM_TRT_CD" ).append("\n"); 
		query.append("    FROM BKG_XTER_RQST_MST MST, BKG_XTER_CNTR_MK_DESC CM" ).append("\n"); 
		query.append("    WHERE MST.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("      AND MST.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("      AND MST.XTER_RQST_SEQ= @[xter_rqst_seq]" ).append("\n"); 
		query.append("      AND MST.XTER_SNDR_ID = CM.XTER_SNDR_ID" ).append("\n"); 
		query.append("      AND MST.XTER_RQST_NO = CM.XTER_RQST_NO" ).append("\n"); 
		query.append("      AND MST.XTER_RQST_SEQ = CM.XTER_RQST_SEQ) XCM," ).append("\n"); 
		query.append("      BKG_CNTR_MF_DESC CM, " ).append("\n"); 
		query.append("      BKG_REFERENCE REF" ).append("\n"); 
		query.append("WHERE XCM.BKG_NO = CM.BKG_NO(+)" ).append("\n"); 
		query.append("  AND XCM.CNTR_NO = CM.CNTR_NO(+)" ).append("\n"); 
		query.append("  AND CM.BKG_NO        = REF.BKG_NO        (+)" ).append("\n"); 
		query.append("  AND CM.CNTR_MF_SEQ   = REF.CNTR_MF_SEQ   (+)" ).append("\n"); 
		query.append("  AND 'CMPO'           = REF.BKG_REF_TP_CD (+)" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        CM.CNTR_NO" ).append("\n"); 
		query.append("      , CM.CNTR_MF_SEQ" ).append("\n"); 
		query.append("      , CM.PCK_QTY" ).append("\n"); 
		query.append("      , CM.CNTR_MF_WGT" ).append("\n"); 
		query.append("      , CM.MEAS_QTY" ).append("\n"); 
		query.append("      , CM.CNTR_MF_MK_DESC" ).append("\n"); 
		query.append("      , CM.CNTR_MF_GDS_DESC" ).append("\n"); 

	}
}