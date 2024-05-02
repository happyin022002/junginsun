/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterCmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterCmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterCm
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterCmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterCmRSQL").append("\n"); 
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
		query.append("SELECT UPPER(CNTR_NO) CNTR_NO" ).append("\n"); 
		query.append("        , MK_DESC_SEQ CNTR_MF_SEQ" ).append("\n"); 
		query.append("        , PCK_QTY " ).append("\n"); 
		query.append("        , UPPER(PCK_TP_CD) PCK_TP_cD" ).append("\n"); 
		query.append("        , CNTR_MF_WGT" ).append("\n"); 
		query.append("        , UPPER(WGT_UT_CD) WGT_UT_CD" ).append("\n"); 
		query.append("        , MEAS_QTY " ).append("\n"); 
		query.append("        , UPPER(MEAS_UT_CD) MEAS_UT_CD " ).append("\n"); 
		query.append("        , UPPER(REPLACE(NVL(HAMO_TRF_CTNT, ' '),'.','')) HAMO_TRF_CD" ).append("\n"); 
		query.append("        , UPPER(NVL(NCM_NO, DECODE(NCM_MULTI_NO, NULL, ' ', " ).append("\n"); 
		query.append("                      SUBSTR(NCM_MULTI_NO, 0, DECODE( INSTR(NCM_MULTI_NO,',') , 0,  LENGTH(NCM_MULTI_NO), " ).append("\n"); 
		query.append("                                                                                    INSTR(NCM_MULTI_NO,',')-1))))) NCM_NO" ).append("\n"); 
		query.append("        , '  ' PO_NO" ).append("\n"); 
		query.append("        , UPPER(NVL(REPLACE(MARKS, '@@', CHR(13)||CHR(10)), ' ')) CNTR_MF_MK_DESC " ).append("\n"); 
		query.append("        , UPPER(NVL(REPLACE(DESCRIPTION, '@@', CHR(13)||CHR(10)), ' ')) CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("        , UPPER(NVL(REPLACE(DTL_DESC, '@@', CHR(13)||CHR(10)), '  ')) CNTR_MF_DTL_DESC " ).append("\n"); 
		query.append("		, NVL(DCGO_SEQ,'') DCGO_SEQ" ).append("\n"); 
		query.append("		, UPPER(NVL(CMDT_HS_CD,'   ')) CMDT_HS_CD" ).append("\n"); 
		query.append("		, '   ' CNTR_MF_NO" ).append("\n"); 
		query.append("        , UPPER(SI_NO) SI_NO" ).append("\n"); 
		query.append("        , XTER_RQST_SEQ" ).append("\n"); 
		query.append("        , UPPER(NCM_MULTI_NO) NCM_MULTI_NO" ).append("\n"); 
		query.append("        , UPPER(WPM_TRT_CD) WPM_TRT_CD" ).append("\n"); 
		query.append("FROM ( /* FOR MASTER BKG */" ).append("\n"); 
		query.append("    SELECT CM.XTER_RQST_NO " ).append("\n"); 
		query.append("        , CM.XTER_RQST_SEQ " ).append("\n"); 
		query.append("        , CM.CNTR_NO " ).append("\n"); 
		query.append("        , CM.MK_DESC_SEQ " ).append("\n"); 
		query.append("        , CM.PCK_QTY" ).append("\n"); 
		query.append("        , CM.PCK_TP_CD " ).append("\n"); 
		query.append("        , CM.CNTR_MF_WGT " ).append("\n"); 
		query.append("        , CM.WGT_UT_CD " ).append("\n"); 
		query.append("        , CM.MEAS_QTY" ).append("\n"); 
		query.append("        , CM.MEAS_UT_CD" ).append("\n"); 
		query.append("        , CM.CNTR_MF_MK_DESC MARKS" ).append("\n"); 
		query.append("        , CM.CNTR_MF_DESC DESCRIPTION" ).append("\n"); 
		query.append("        , CM.CNTR_MF_DTL_DESC DTL_DESC" ).append("\n"); 
		query.append("        , CM.HAMO_TRF_CTNT" ).append("\n"); 
		query.append("        , CM.NCM_NO" ).append("\n"); 
		query.append("		, CM.CMDT_HS_CD" ).append("\n"); 
		query.append("		, CM.DCGO_SEQ" ).append("\n"); 
		query.append("        , '' AS SI_NO" ).append("\n"); 
		query.append("        , NVL(BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("                                  SELECT DTL.NCM_NO" ).append("\n"); 
		query.append("                                    FROM BKG_XTER_CNTR_MK_DESC_NCM DTL" ).append("\n"); 
		query.append("                                   WHERE DTL.XTER_SNDR_ID = CM.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                     AND DTL.XTER_RQST_NO = CM.XTER_RQST_NO" ).append("\n"); 
		query.append("                                     AND DTL.XTER_RQST_SEQ =  CM.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                                     AND DTL.MK_DESC_SEQ = CM.MK_DESC_SEQ" ).append("\n"); 
		query.append("                                     AND DTL.CNTR_NO  = CM.CNTR_NO" ).append("\n"); 
		query.append("                                     AND DTL.CNTR_SEQ = CM.CNTR_SEQ " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                        ),CM.NCM_NO" ).append("\n"); 
		query.append("        ) NCM_MULTI_NO" ).append("\n"); 
		query.append("        , WPM_TRT_CD" ).append("\n"); 
		query.append("    FROM BKG_XTER_CNTR_MK_DESC CM" ).append("\n"); 
		query.append("    WHERE CM.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("      AND CM.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("      AND CM.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("    UNION ALL /* FOR H/BL */" ).append("\n"); 
		query.append("    SELECT CM.XTER_RQST_NO " ).append("\n"); 
		query.append("        , CM.XTER_RQST_SEQ " ).append("\n"); 
		query.append("        , CM.CNTR_NO" ).append("\n"); 
		query.append("        , CM.MK_DESC_SEQ " ).append("\n"); 
		query.append("        , CM.PCK_QTY " ).append("\n"); 
		query.append("        , CM.PCK_TP_CD " ).append("\n"); 
		query.append("        , CM.CNTR_MF_WGT" ).append("\n"); 
		query.append("        , CM.WGT_UT_CD " ).append("\n"); 
		query.append("        , CM.MEAS_QTY " ).append("\n"); 
		query.append("        , CM.MEAS_UT_CD " ).append("\n"); 
		query.append("        , CM.CNTR_MF_MK_DESC MARKS " ).append("\n"); 
		query.append("        , CM.CNTR_MF_DESC DESCRIPTION " ).append("\n"); 
		query.append("        , CM.CNTR_MF_DTL_DESC DTL_DESC " ).append("\n"); 
		query.append("        , CM.HAMO_TRF_CTNT" ).append("\n"); 
		query.append("        , CM.NCM_NO" ).append("\n"); 
		query.append("		, CM.CMDT_HS_CD" ).append("\n"); 
		query.append("		, CM.DCGO_SEQ" ).append("\n"); 
		query.append("        , MST.XTER_RQST_NO SI_NO" ).append("\n"); 
		query.append("        , NVL(BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("                                  SELECT DTL.NCM_NO" ).append("\n"); 
		query.append("                                    FROM BKG_XTER_CNTR_MK_DESC_NCM DTL" ).append("\n"); 
		query.append("                                   WHERE DTL.XTER_SNDR_ID = CM.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                     AND DTL.XTER_RQST_NO = CM.XTER_RQST_NO" ).append("\n"); 
		query.append("                                     AND DTL.XTER_RQST_SEQ =  CM.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                                     AND DTL.MK_DESC_SEQ = CM.MK_DESC_SEQ" ).append("\n"); 
		query.append("                                     AND DTL.CNTR_NO  = CM.CNTR_NO" ).append("\n"); 
		query.append("                                     AND DTL.CNTR_SEQ = CM.CNTR_SEQ " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                        ),CM.NCM_NO" ).append("\n"); 
		query.append("        ) NCM_MULTI_NO" ).append("\n"); 
		query.append("        , WPM_TRT_CD" ).append("\n"); 
		query.append("    FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("        , BKG_XTER_CNTR_MK_DESC CM" ).append("\n"); 
		query.append("    WHERE CM.XTER_RQST_NO  = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("      AND CM.XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("      AND CM.XTER_SNDR_ID  = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("      AND MST.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("      AND MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("      AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("      AND MST.XTER_BL_TP_CD= 'H' " ).append("\n"); 
		query.append("	  AND 0 = ( SELECT COUNT(*)    " ).append("\n"); 
		query.append("    			  FROM BKG_XTER_CNTR_MK_DESC" ).append("\n"); 
		query.append("    			 WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("     			   AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("      			   AND XTER_RQST_SEQ= @[rqst_seq] )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY CNTR_NO, MK_DESC_SEQ, XTER_RQST_NO, XTER_RQST_SEQ, PCK_QTY, CNTR_MF_WGT, MEAS_QTY, MARKS, DESCRIPTION" ).append("\n"); 

	}
}